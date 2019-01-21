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
    private int hdB;
    private ShareEntity hdC;
    private final com.baidu.adp.lib.f.b<f.a> hdJ;
    private com.baidu.tieba.sharesdk.b.b hdN;
    private IWXAPI hdR;
    private b hdS;
    private final a hdT;

    public f(Context context, int i) {
        super(context);
        this.hdJ = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.aEZ == null || !f.this.b(f.this.hdC, aVar)) {
                    f.this.hdT.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.hdT.onCancelled(str);
            }
        };
        this.hdT = new a();
        this.context = context.getApplicationContext();
        this.hdB = i;
        this.hdR = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bAf() {
        if (this.context != null) {
            this.hdS = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.hdS, intentFilter);
        }
    }

    private void bAg() {
        if (this.context != null && this.hdS != null) {
            this.context.unregisterReceiver(this.hdS);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        bAf();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bAg();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.hdR == null) {
            uU(2);
            if (bVar != null) {
                bVar.bJ(0, 2);
                return;
            }
            return;
        }
        this.hdC = shareEntity;
        this.hdN = bVar;
        this.hdB = shareEntity.bAa();
        if (!this.hdR.isWXAppInstalled()) {
            if (this.hdN != null) {
                this.hdN.bJ(this.hdB, 2);
            }
            vs(getString(e.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.hdR.isWXAppSupportAPI()) {
            if (this.hdN != null) {
                this.hdN.bJ(this.hdB, 2);
            }
            vs(getString(e.j.share_failed, new Object[0]));
        } else if (hr(shareEntity.sb())) {
            vx(shareEntity.sb());
        } else {
            String yF = shareEntity.yF();
            if (!TextUtils.isEmpty(yF) && (yF.startsWith("http://") || yF.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.hdC.bAb() != 0) {
                    com.baidu.adp.lib.f.c.jA().a(yF, 34, this.hdJ, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jA().a(yF, 10, this.hdT, 0, 0, getPageId(), new Object[0]);
                }
            } else if (i(shareEntity.getImageUri())) {
                vx(shareEntity.getImageUri().getPath());
            } else {
                bAh();
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
                f.this.bAh();
                return;
            }
            Bitmap ot = aVar.ot();
            if (!TextUtils.isEmpty(f.this.hdC.getLinkUrl())) {
                f.this.c(f.this.hdC, ot);
            } else if (!TextUtils.isEmpty(f.this.hdC.getVideoUrl())) {
                f.this.d(f.this.hdC, ot);
            } else if (TextUtils.isEmpty(f.this.hdC.getContent())) {
                f.this.b(f.this.hdC, ot);
            } else {
                f.this.bAh();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.hdN != null) {
                f.this.hdN.bJ(f.this.hdB, 3);
            }
            f.this.uU(3);
        }
    }

    private void vx(String str) {
        Bitmap vu = vu(str);
        if (vu == null) {
            vu = bAd();
        }
        if (vu != null) {
            b(this.hdC, vu);
        } else {
            c(this.hdC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAh() {
        Bitmap bAd = bAd();
        if (bAd != null) {
            b(this.hdC, bAd);
        } else {
            c(this.hdC);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.hdR != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vy("textShare");
            req.message = wXMediaMessage;
            req.scene = bAi();
            this.hdR.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.hdR != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.kE().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vy("imageShare");
            req.message = wXMediaMessage;
            req.scene = bAi();
            this.hdR.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.hdR == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.aEZ == null || aVar.aEZ.ot() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.aEZ.ot());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = vy("imageShare");
        req.message = wXMediaMessage;
        req.scene = bAi();
        this.hdR.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.hdB == 2 || this.hdC.bAb() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.hdR == null || aVar == null || aVar.aEZ == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.aEZ.ot());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = vy("imageShare");
        req.message = wXMediaMessage;
        req.scene = bAi();
        this.hdR.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.hdR != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vy("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bAi();
            this.hdR.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.hdR != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = vy("videoShare");
            req.message = wXMediaMessage;
            req.scene = bAi();
            this.hdR.sendReq(req);
        }
    }

    private int bAi() {
        if (this.hdB == 3) {
            return 0;
        }
        if (this.hdB == 2) {
            return 1;
        }
        return -1;
    }

    private String vy(String str) {
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
                    if (f.this.hdN != null) {
                        f.this.hdN.bJ(f.this.hdB, 1);
                    }
                    f.this.uU(1);
                } else if (intExtra == -2) {
                    if (f.this.hdN != null) {
                        f.this.hdN.bJ(f.this.hdB, 3);
                    }
                    f.this.uU(3);
                } else {
                    f.this.ak(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.hdN != null) {
                        f.this.hdN.bJ(f.this.hdB, 2);
                    }
                    f.this.uU(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, String str) {
        if (this.hdC != null && !StringUtils.isNull(this.hdC.yF())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.hdC.yF());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap d = d(bitmap, 120);
            if (d == null) {
                d = bAd();
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
