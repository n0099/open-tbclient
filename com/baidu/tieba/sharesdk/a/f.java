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
    private int gAQ;
    private ShareEntity gAR;
    private final com.baidu.adp.lib.f.b<f.a> gAY;
    private com.baidu.tieba.sharesdk.b.b gBc;
    private IWXAPI gBg;
    private b gBh;
    private final a gBi;

    public f(Context context, int i) {
        super(context);
        this.gAY = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.ats == null || !f.this.b(f.this.gAR, aVar)) {
                    f.this.gBi.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gBi.onCancelled(str);
            }
        };
        this.gBi = new a();
        this.context = context.getApplicationContext();
        this.gAQ = i;
        this.gBg = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bsT() {
        if (this.context != null) {
            this.gBh = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gBh, intentFilter);
        }
    }

    private void bsU() {
        if (this.context != null && this.gBh != null) {
            this.context.unregisterReceiver(this.gBh);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void r(BdUniqueId bdUniqueId) {
        super.r(bdUniqueId);
        bsT();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bsU();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gBg == null) {
            sV(2);
            if (bVar != null) {
                bVar.bC(0, 2);
                return;
            }
            return;
        }
        this.gAR = shareEntity;
        this.gBc = bVar;
        this.gAQ = shareEntity.bsP();
        if (!this.gBg.isWXAppInstalled()) {
            if (this.gBc != null) {
                this.gBc.bC(this.gAQ, 2);
            }
            tj(getString(d.k.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gBg.isWXAppSupportAPI()) {
            if (this.gBc != null) {
                this.gBc.bC(this.gAQ, 2);
            }
            tj(getString(d.k.share_failed, new Object[0]));
        } else {
            String uh = shareEntity.uh();
            if (!TextUtils.isEmpty(uh) && (uh.startsWith("http://") || uh.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.gAR.bsQ()) {
                    com.baidu.adp.lib.f.c.ig().a(uh, 34, this.gAY, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.ig().a(uh, 10, this.gBi, 0, 0, getPageId(), new Object[0]);
                }
            } else if (h(shareEntity.getImageUri())) {
                to(shareEntity.getImageUri().getPath());
            } else {
                bsV();
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
                f.this.bsV();
                return;
            }
            Bitmap mZ = aVar.mZ();
            if (!TextUtils.isEmpty(f.this.gAR.getLinkUrl())) {
                f.this.c(f.this.gAR, mZ);
            } else if (!TextUtils.isEmpty(f.this.gAR.getVideoUrl())) {
                f.this.d(f.this.gAR, mZ);
            } else if (TextUtils.isEmpty(f.this.gAR.getContent())) {
                f.this.b(f.this.gAR, mZ);
            } else {
                f.this.bsV();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gBc != null) {
                f.this.gBc.bC(f.this.gAQ, 3);
            }
            f.this.sV(3);
        }
    }

    private void to(String str) {
        Bitmap tl = tl(str);
        if (tl == null) {
            tl = bsR();
        }
        if (tl != null) {
            b(this.gAR, tl);
        } else {
            c(this.gAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsV() {
        Bitmap bsR = bsR();
        if (bsR != null) {
            b(this.gAR, bsR);
        } else {
            c(this.gAR);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gBg != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tp("textShare");
            req.message = wXMediaMessage;
            req.scene = bsW();
            this.gBg.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gBg != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.jl().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tp("imageShare");
            req.message = wXMediaMessage;
            req.scene = bsW();
            this.gBg.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gBg == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.ats == null || aVar.ats.mZ() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.ats.mZ());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tp("imageShare");
        req.message = wXMediaMessage;
        req.scene = bsW();
        this.gBg.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return this.gAQ == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gBg == null || aVar == null || aVar.ats == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.ats.mZ());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tp("imageShare");
        req.message = wXMediaMessage;
        req.scene = bsW();
        this.gBg.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gBg != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tp("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bsW();
            this.gBg.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gBg != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tp("videoShare");
            req.message = wXMediaMessage;
            req.scene = bsW();
            this.gBg.sendReq(req);
        }
    }

    private int bsW() {
        if (this.gAQ == 3) {
            return 0;
        }
        if (this.gAQ == 2) {
            return 1;
        }
        return -1;
    }

    private String tp(String str) {
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
                    if (f.this.gBc != null) {
                        f.this.gBc.bC(f.this.gAQ, 1);
                    }
                    f.this.sV(1);
                } else if (intExtra == -2) {
                    if (f.this.gBc != null) {
                        f.this.gBc.bC(f.this.gAQ, 3);
                    }
                    f.this.sV(3);
                } else {
                    f.this.ai(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gBc != null) {
                        f.this.gBc.bC(f.this.gAQ, 2);
                    }
                    f.this.sV(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (this.gAR != null && !StringUtils.isNull(this.gAR.uh())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.gAR.uh());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = bsR();
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
