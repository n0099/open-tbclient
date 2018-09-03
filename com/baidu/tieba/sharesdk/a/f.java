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
import com.baidu.tieba.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
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
    private int gCb;
    private ShareEntity gCc;
    private final com.baidu.adp.lib.f.b<f.a> gCj;
    private com.baidu.tieba.sharesdk.b.b gCn;
    private IWXAPI gCr;
    private b gCs;
    private final a gCt;

    public f(Context context, int i) {
        super(context);
        this.gCj = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.asX == null || !f.this.b(f.this.gCc, aVar)) {
                    f.this.gCt.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gCt.onCancelled(str);
            }
        };
        this.gCt = new a();
        this.context = context.getApplicationContext();
        this.gCb = i;
        this.gCr = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void brx() {
        if (this.context != null) {
            this.gCs = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gCs, intentFilter);
        }
    }

    private void bry() {
        if (this.context != null && this.gCs != null) {
            this.context.unregisterReceiver(this.gCs);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void r(BdUniqueId bdUniqueId) {
        super.r(bdUniqueId);
        brx();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bry();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gCr == null) {
            sT(2);
            if (bVar != null) {
                bVar.bD(0, 2);
                return;
            }
            return;
        }
        this.gCc = shareEntity;
        this.gCn = bVar;
        this.gCb = shareEntity.brt();
        if (!this.gCr.isWXAppInstalled()) {
            if (this.gCn != null) {
                this.gCn.bD(this.gCb, 2);
            }
            tl(getString(f.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gCr.isWXAppSupportAPI()) {
            if (this.gCn != null) {
                this.gCn.bD(this.gCb, 2);
            }
            tl(getString(f.j.share_failed, new Object[0]));
        } else {
            String tT = shareEntity.tT();
            if (!TextUtils.isEmpty(tT) && (tT.startsWith("http://") || tT.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.gCc.bru()) {
                    com.baidu.adp.lib.f.c.ih().a(tT, 34, this.gCj, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.ih().a(tT, 10, this.gCt, 0, 0, getPageId(), new Object[0]);
                }
            } else if (h(shareEntity.getImageUri())) {
                tq(shareEntity.getImageUri().getPath());
            } else {
                brz();
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
                f.this.brz();
                return;
            }
            Bitmap nb = aVar.nb();
            if (!TextUtils.isEmpty(f.this.gCc.getLinkUrl())) {
                f.this.c(f.this.gCc, nb);
            } else if (!TextUtils.isEmpty(f.this.gCc.getVideoUrl())) {
                f.this.d(f.this.gCc, nb);
            } else if (TextUtils.isEmpty(f.this.gCc.getContent())) {
                f.this.b(f.this.gCc, nb);
            } else {
                f.this.brz();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gCn != null) {
                f.this.gCn.bD(f.this.gCb, 3);
            }
            f.this.sT(3);
        }
    }

    private void tq(String str) {
        Bitmap tn = tn(str);
        if (tn == null) {
            tn = brv();
        }
        if (tn != null) {
            b(this.gCc, tn);
        } else {
            c(this.gCc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brz() {
        Bitmap brv = brv();
        if (brv != null) {
            b(this.gCc, brv);
        } else {
            c(this.gCc);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gCr != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tr("textShare");
            req.message = wXMediaMessage;
            req.scene = brA();
            this.gCr.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gCr != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.jm().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = w(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tr("imageShare");
            req.message = wXMediaMessage;
            req.scene = brA();
            this.gCr.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gCr == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.asX == null || aVar.asX.nb() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = w(aVar.asX.nb());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tr("imageShare");
        req.message = wXMediaMessage;
        req.scene = brA();
        this.gCr.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return this.gCb == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gCr == null || aVar == null || aVar.asX == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = w(aVar.asX.nb());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tr("imageShare");
        req.message = wXMediaMessage;
        req.scene = brA();
        this.gCr.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gCr != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = w(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tr("webpageShare");
            req.message = wXMediaMessage;
            req.scene = brA();
            this.gCr.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gCr != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = w(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tr("videoShare");
            req.message = wXMediaMessage;
            req.scene = brA();
            this.gCr.sendReq(req);
        }
    }

    private int brA() {
        if (this.gCb == 3) {
            return 0;
        }
        if (this.gCb == 2) {
            return 1;
        }
        return -1;
    }

    private String tr(String str) {
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
                    if (f.this.gCn != null) {
                        f.this.gCn.bD(f.this.gCb, 1);
                    }
                    f.this.sT(1);
                } else if (intExtra == -2) {
                    if (f.this.gCn != null) {
                        f.this.gCn.bD(f.this.gCb, 3);
                    }
                    f.this.sT(3);
                } else {
                    f.this.ak(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gCn != null) {
                        f.this.gCn.bD(f.this.gCb, 2);
                    }
                    f.this.sT(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, String str) {
        if (this.gCc != null && !StringUtils.isNull(this.gCc.tT())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.gCc.tT());
        }
    }

    public byte[] w(Bitmap bitmap) {
        try {
            Bitmap d = d(bitmap, 120);
            if (d == null) {
                d = brv();
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
