package com.baidu.tieba.sharesdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.util.d.f;
import com.baidu.tieba.e;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.webkit.internal.ETAG;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private int gRd;
    private ShareEntity gRe;
    private final com.baidu.adp.lib.f.b<f.a> gRl;
    private com.baidu.tieba.sharesdk.b.b gRp;
    private IWXAPI gRt;
    private b gRu;
    private final a gRv;

    public f(Context context, int i) {
        super(context);
        this.gRl = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.aAg == null || !f.this.b(f.this.gRe, aVar)) {
                    f.this.gRv.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gRv.onCancelled(str);
            }
        };
        this.gRv = new a();
        this.context = context.getApplicationContext();
        this.gRd = i;
        this.gRt = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bxr() {
        if (this.context != null) {
            this.gRu = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gRu, intentFilter);
        }
    }

    private void bxs() {
        if (this.context != null && this.gRu != null) {
            this.context.unregisterReceiver(this.gRu);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        bxr();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bxs();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gRt == null) {
            tQ(2);
            if (bVar != null) {
                bVar.bI(0, 2);
                return;
            }
            return;
        }
        this.gRe = shareEntity;
        this.gRp = bVar;
        this.gRd = shareEntity.bxn();
        if (!this.gRt.isWXAppInstalled()) {
            if (this.gRp != null) {
                this.gRp.bI(this.gRd, 2);
            }
            uu(getString(e.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gRt.isWXAppSupportAPI()) {
            if (this.gRp != null) {
                this.gRp.bI(this.gRd, 2);
            }
            uu(getString(e.j.share_failed, new Object[0]));
        } else {
            String xf = shareEntity.xf();
            if (!TextUtils.isEmpty(xf) && (xf.startsWith("http://") || xf.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.gRe.bxo()) {
                    com.baidu.adp.lib.f.c.jC().a(xf, 34, this.gRl, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jC().a(xf, 10, this.gRv, 0, 0, getPageId(), new Object[0]);
                }
            } else if (h(shareEntity.getImageUri())) {
                uz(shareEntity.getImageUri().getPath());
            } else {
                bxt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.bxt();
                return;
            }
            Bitmap os = aVar.os();
            if (!TextUtils.isEmpty(f.this.gRe.getLinkUrl())) {
                f.this.c(f.this.gRe, os);
            } else if (!TextUtils.isEmpty(f.this.gRe.getVideoUrl())) {
                f.this.d(f.this.gRe, os);
            } else if (TextUtils.isEmpty(f.this.gRe.getContent())) {
                f.this.b(f.this.gRe, os);
            } else {
                f.this.bxt();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gRp != null) {
                f.this.gRp.bI(f.this.gRd, 3);
            }
            f.this.tQ(3);
        }
    }

    private void uz(String str) {
        Bitmap uw = uw(str);
        if (uw == null) {
            uw = bxp();
        }
        if (uw != null) {
            b(this.gRe, uw);
        } else {
            c(this.gRe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        Bitmap bxp = bxp();
        if (bxp != null) {
            b(this.gRe, bxp);
        } else {
            c(this.gRe);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gRt != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uA("textShare");
            req.message = wXMediaMessage;
            req.scene = bxu();
            this.gRt.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gRt != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.kG().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uA("imageShare");
            req.message = wXMediaMessage;
            req.scene = bxu();
            this.gRt.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gRt == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.aAg == null || aVar.aAg.os() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.aAg.os());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = uA("imageShare");
        req.message = wXMediaMessage;
        req.scene = bxu();
        this.gRt.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return this.gRd == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gRt == null || aVar == null || aVar.aAg == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.aAg.os());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = uA("imageShare");
        req.message = wXMediaMessage;
        req.scene = bxu();
        this.gRt.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gRt != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uA("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bxu();
            this.gRt.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gRt != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uA("videoShare");
            req.message = wXMediaMessage;
            req.scene = bxu();
            this.gRt.sendReq(req);
        }
    }

    private int bxu() {
        if (this.gRd == 3) {
            return 0;
        }
        if (this.gRd == 2) {
            return 1;
        }
        return -1;
    }

    private String uA(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.gRp != null) {
                        f.this.gRp.bI(f.this.gRd, 1);
                    }
                    f.this.tQ(1);
                } else if (intExtra == -2) {
                    if (f.this.gRp != null) {
                        f.this.gRp.bI(f.this.gRd, 3);
                    }
                    f.this.tQ(3);
                } else {
                    f.this.al(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gRp != null) {
                        f.this.gRp.bI(f.this.gRd, 2);
                    }
                    f.this.tQ(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        if (this.gRe != null && !StringUtils.isNull(this.gRe.xf())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.gRe.xf());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap d = d(bitmap, 120);
            if (d == null) {
                d = bxp();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            d.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
