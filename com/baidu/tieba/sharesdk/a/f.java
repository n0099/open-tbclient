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
    private com.baidu.tieba.sharesdk.b.b gZD;
    private IWXAPI gZH;
    private b gZI;
    private final a gZJ;
    private int gZr;
    private ShareEntity gZs;
    private final com.baidu.adp.lib.f.b<f.a> gZz;

    public f(Context context, int i) {
        super(context);
        this.gZz = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.aEv == null || !f.this.b(f.this.gZs, aVar)) {
                    f.this.gZJ.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gZJ.onCancelled(str);
            }
        };
        this.gZJ = new a();
        this.context = context.getApplicationContext();
        this.gZr = i;
        this.gZH = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void byH() {
        if (this.context != null) {
            this.gZI = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gZI, intentFilter);
        }
    }

    private void byI() {
        if (this.context != null && this.gZI != null) {
            this.context.unregisterReceiver(this.gZI);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        byH();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        byI();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gZH == null) {
            uE(2);
            if (bVar != null) {
                bVar.bI(0, 2);
                return;
            }
            return;
        }
        this.gZs = shareEntity;
        this.gZD = bVar;
        this.gZr = shareEntity.byC();
        if (!this.gZH.isWXAppInstalled()) {
            if (this.gZD != null) {
                this.gZD.bI(this.gZr, 2);
            }
            uZ(getString(e.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gZH.isWXAppSupportAPI()) {
            if (this.gZD != null) {
                this.gZD.bI(this.gZr, 2);
            }
            uZ(getString(e.j.share_failed, new Object[0]));
        } else {
            String ys = shareEntity.ys();
            if (!TextUtils.isEmpty(ys) && (ys.startsWith("http://") || ys.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.gZs.byD() != 0) {
                    com.baidu.adp.lib.f.c.jA().a(ys, 34, this.gZz, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jA().a(ys, 10, this.gZJ, 0, 0, getPageId(), new Object[0]);
                }
            } else if (i(shareEntity.getImageUri())) {
                ve(shareEntity.getImageUri().getPath());
            } else {
                byJ();
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
                f.this.byJ();
                return;
            }
            Bitmap op = aVar.op();
            if (!TextUtils.isEmpty(f.this.gZs.getLinkUrl())) {
                f.this.c(f.this.gZs, op);
            } else if (!TextUtils.isEmpty(f.this.gZs.getVideoUrl())) {
                f.this.d(f.this.gZs, op);
            } else if (TextUtils.isEmpty(f.this.gZs.getContent())) {
                f.this.b(f.this.gZs, op);
            } else {
                f.this.byJ();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gZD != null) {
                f.this.gZD.bI(f.this.gZr, 3);
            }
            f.this.uE(3);
        }
    }

    private void ve(String str) {
        Bitmap vb = vb(str);
        if (vb == null) {
            vb = byF();
        }
        if (vb != null) {
            b(this.gZs, vb);
        } else {
            c(this.gZs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byJ() {
        Bitmap byF = byF();
        if (byF != null) {
            b(this.gZs, byF);
        } else {
            c(this.gZs);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gZH != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vf("textShare");
            req.message = wXMediaMessage;
            req.scene = byK();
            this.gZH.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gZH != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.kE().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vf("imageShare");
            req.message = wXMediaMessage;
            req.scene = byK();
            this.gZH.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gZH == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.aEv == null || aVar.aEv.op() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.aEv.op());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = vf("imageShare");
        req.message = wXMediaMessage;
        req.scene = byK();
        this.gZH.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.gZr == 2 || this.gZs.byD() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gZH == null || aVar == null || aVar.aEv == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.aEv.op());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = vf("imageShare");
        req.message = wXMediaMessage;
        req.scene = byK();
        this.gZH.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gZH != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vf("webpageShare");
            req.message = wXMediaMessage;
            req.scene = byK();
            this.gZH.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gZH != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vf("videoShare");
            req.message = wXMediaMessage;
            req.scene = byK();
            this.gZH.sendReq(req);
        }
    }

    private int byK() {
        if (this.gZr == 3) {
            return 0;
        }
        if (this.gZr == 2) {
            return 1;
        }
        return -1;
    }

    private String vf(String str) {
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
                    if (f.this.gZD != null) {
                        f.this.gZD.bI(f.this.gZr, 1);
                    }
                    f.this.uE(1);
                } else if (intExtra == -2) {
                    if (f.this.gZD != null) {
                        f.this.gZD.bI(f.this.gZr, 3);
                    }
                    f.this.uE(3);
                } else {
                    f.this.ah(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gZD != null) {
                        f.this.gZD.bI(f.this.gZr, 2);
                    }
                    f.this.uE(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, String str) {
        if (this.gZs != null && !StringUtils.isNull(this.gZs.ys())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.gZs.ys());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap d = d(bitmap, 120);
            if (d == null) {
                d = byF();
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
