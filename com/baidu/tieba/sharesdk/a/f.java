package com.baidu.tieba.sharesdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.util.d.e;
import com.baidu.tieba.d;
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
    private ShareEntity glA;
    private final com.baidu.adp.lib.f.b<e.a> glH;
    private com.baidu.tieba.sharesdk.b.b glL;
    private IWXAPI glP;
    private b glQ;
    private final a glR;
    private int glz;

    public f(Context context, int i) {
        super(context);
        this.glH = new com.baidu.adp.lib.f.b<e.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.akH == null || !f.this.b(f.this.glA, aVar)) {
                    f.this.glR.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.glR.onCancelled(str);
            }
        };
        this.glR = new a();
        this.context = context.getApplicationContext();
        this.glz = i;
        this.glP = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bnt() {
        if (this.context != null) {
            this.glQ = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.glQ, intentFilter);
        }
    }

    private void bnu() {
        if (this.context != null && this.glQ != null) {
            this.context.unregisterReceiver(this.glQ);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        bnt();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bnu();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.glP == null) {
            sz(2);
            if (bVar != null) {
                bVar.bB(0, 2);
                return;
            }
            return;
        }
        this.glA = shareEntity;
        this.glL = bVar;
        this.glz = shareEntity.bnp();
        if (!this.glP.isWXAppInstalled()) {
            if (this.glL != null) {
                this.glL.bB(this.glz, 2);
            }
            st(getString(d.k.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.glP.isWXAppSupportAPI()) {
            if (this.glL != null) {
                this.glL.bB(this.glz, 2);
            }
            st(getString(d.k.share_failed, new Object[0]));
        } else {
            String qF = shareEntity.qF();
            if (!TextUtils.isEmpty(qF) && (qF.startsWith("http://") || qF.startsWith("https://"))) {
                if (this.glA.bnq()) {
                    com.baidu.adp.lib.f.c.fp().a(qF, 34, this.glH, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.fp().a(qF, 10, this.glR, 0, 0, getPageId(), new Object[0]);
                }
            } else if (i(shareEntity.bno())) {
                sy(shareEntity.bno().getPath());
            } else {
                bnv();
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
                f.this.bnv();
                return;
            }
            Bitmap kl = aVar.kl();
            if (!TextUtils.isEmpty(f.this.glA.getLinkUrl())) {
                f.this.c(f.this.glA, kl);
            } else if (!TextUtils.isEmpty(f.this.glA.getVideoUrl())) {
                f.this.d(f.this.glA, kl);
            } else if (TextUtils.isEmpty(f.this.glA.getContent())) {
                f.this.b(f.this.glA, kl);
            } else {
                f.this.bnv();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.glL != null) {
                f.this.glL.bB(f.this.glz, 3);
            }
            f.this.sz(3);
        }
    }

    private void sy(String str) {
        Bitmap sv = sv(str);
        if (sv == null) {
            sv = bnr();
        }
        if (sv != null) {
            b(this.glA, sv);
        } else {
            c(this.glA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnv() {
        Bitmap bnr = bnr();
        if (bnr != null) {
            b(this.glA, bnr);
        } else {
            c(this.glA);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.glP != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sz("textShare");
            req.message = wXMediaMessage;
            req.scene = bnw();
            this.glP.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.glP != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.gw().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = y(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sz("imageShare");
            req.message = wXMediaMessage;
            req.scene = bnw();
            this.glP.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.glP == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.akH == null || aVar.akH.kl() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = y(aVar.akH.kl());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = sz("imageShare");
        req.message = wXMediaMessage;
        req.scene = bnw();
        this.glP.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, e.a aVar) {
        return this.glz == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.glP == null || aVar == null || aVar.akH == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = y(aVar.akH.kl());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = sz("imageShare");
        req.message = wXMediaMessage;
        req.scene = bnw();
        this.glP.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.glP != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = y(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sz("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bnw();
            this.glP.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.glP != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = y(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sz("videoShare");
            req.message = wXMediaMessage;
            req.scene = bnw();
            this.glP.sendReq(req);
        }
    }

    private int bnw() {
        if (this.glz == 3) {
            return 0;
        }
        if (this.glz == 2) {
            return 1;
        }
        return -1;
    }

    private String sz(String str) {
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
                    if (f.this.glL != null) {
                        f.this.glL.bB(f.this.glz, 1);
                    }
                    f.this.sz(1);
                } else if (intExtra == -2) {
                    if (f.this.glL != null) {
                        f.this.glL.bB(f.this.glz, 3);
                    }
                    f.this.sz(3);
                } else {
                    f.this.ak(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.glL != null) {
                        f.this.glL.bB(f.this.glz, 2);
                    }
                    f.this.sz(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, String str) {
        if (this.glA != null && !StringUtils.isNull(this.glA.qF())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.glA.qF());
        }
    }

    public byte[] y(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = bnr();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            e.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
