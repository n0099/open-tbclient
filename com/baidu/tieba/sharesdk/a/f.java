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
    private final com.baidu.adp.lib.f.b<f.a> hcD;
    private com.baidu.tieba.sharesdk.b.b hcH;
    private IWXAPI hcL;
    private b hcM;
    private final a hcN;
    private int hcv;
    private ShareEntity hcw;

    public f(Context context, int i) {
        super(context);
        this.hcD = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.aEw == null || !f.this.b(f.this.hcw, aVar)) {
                    f.this.hcN.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.hcN.onCancelled(str);
            }
        };
        this.hcN = new a();
        this.context = context.getApplicationContext();
        this.hcv = i;
        this.hcL = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bzw() {
        if (this.context != null) {
            this.hcM = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.hcM, intentFilter);
        }
    }

    private void bzx() {
        if (this.context != null && this.hcM != null) {
            this.context.unregisterReceiver(this.hcM);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        bzw();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bzx();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.hcL == null) {
            uR(2);
            if (bVar != null) {
                bVar.bJ(0, 2);
                return;
            }
            return;
        }
        this.hcw = shareEntity;
        this.hcH = bVar;
        this.hcv = shareEntity.bzr();
        if (!this.hcL.isWXAppInstalled()) {
            if (this.hcH != null) {
                this.hcH.bJ(this.hcv, 2);
            }
            vc(getString(e.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.hcL.isWXAppSupportAPI()) {
            if (this.hcH != null) {
                this.hcH.bJ(this.hcv, 2);
            }
            vc(getString(e.j.share_failed, new Object[0]));
        } else {
            String ys = shareEntity.ys();
            if (!TextUtils.isEmpty(ys) && (ys.startsWith("http://") || ys.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.hcw.bzs() != 0) {
                    com.baidu.adp.lib.f.c.jA().a(ys, 34, this.hcD, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jA().a(ys, 10, this.hcN, 0, 0, getPageId(), new Object[0]);
                }
            } else if (i(shareEntity.getImageUri())) {
                vh(shareEntity.getImageUri().getPath());
            } else {
                bzy();
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
                f.this.bzy();
                return;
            }
            Bitmap op = aVar.op();
            if (!TextUtils.isEmpty(f.this.hcw.getLinkUrl())) {
                f.this.c(f.this.hcw, op);
            } else if (!TextUtils.isEmpty(f.this.hcw.getVideoUrl())) {
                f.this.d(f.this.hcw, op);
            } else if (TextUtils.isEmpty(f.this.hcw.getContent())) {
                f.this.b(f.this.hcw, op);
            } else {
                f.this.bzy();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.hcH != null) {
                f.this.hcH.bJ(f.this.hcv, 3);
            }
            f.this.uR(3);
        }
    }

    private void vh(String str) {
        Bitmap ve = ve(str);
        if (ve == null) {
            ve = bzu();
        }
        if (ve != null) {
            b(this.hcw, ve);
        } else {
            c(this.hcw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzy() {
        Bitmap bzu = bzu();
        if (bzu != null) {
            b(this.hcw, bzu);
        } else {
            c(this.hcw);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.hcL != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vi("textShare");
            req.message = wXMediaMessage;
            req.scene = bzz();
            this.hcL.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.hcL != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.kE().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vi("imageShare");
            req.message = wXMediaMessage;
            req.scene = bzz();
            this.hcL.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.hcL == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.aEw == null || aVar.aEw.op() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.aEw.op());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = vi("imageShare");
        req.message = wXMediaMessage;
        req.scene = bzz();
        this.hcL.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.hcv == 2 || this.hcw.bzs() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.hcL == null || aVar == null || aVar.aEw == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.aEw.op());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = vi("imageShare");
        req.message = wXMediaMessage;
        req.scene = bzz();
        this.hcL.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.hcL != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vi("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bzz();
            this.hcL.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.hcL != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vi("videoShare");
            req.message = wXMediaMessage;
            req.scene = bzz();
            this.hcL.sendReq(req);
        }
    }

    private int bzz() {
        if (this.hcv == 3) {
            return 0;
        }
        if (this.hcv == 2) {
            return 1;
        }
        return -1;
    }

    private String vi(String str) {
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
                    if (f.this.hcH != null) {
                        f.this.hcH.bJ(f.this.hcv, 1);
                    }
                    f.this.uR(1);
                } else if (intExtra == -2) {
                    if (f.this.hcH != null) {
                        f.this.hcH.bJ(f.this.hcv, 3);
                    }
                    f.this.uR(3);
                } else {
                    f.this.ai(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.hcH != null) {
                        f.this.hcH.bJ(f.this.hcv, 2);
                    }
                    f.this.uR(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.hcw != null && !StringUtils.isNull(this.hcw.ys())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.hcw.ys());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap d = d(bitmap, 120);
            if (d == null) {
                d = bzu();
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
