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
    private int gPa;
    private ShareEntity gPb;
    private final com.baidu.adp.lib.f.b<e.a> gPi;
    private com.baidu.tieba.sharesdk.b.b gPm;
    private IWXAPI gPq;
    private b gPr;
    private final a gPs;

    public f(Context context, int i) {
        super(context);
        this.gPi = new com.baidu.adp.lib.f.b<e.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.aZc == null || !f.this.b(f.this.gPb, aVar)) {
                    f.this.gPs.onLoaded((com.baidu.adp.widget.a.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gPs.onCancelled(str);
            }
        };
        this.gPs = new a();
        this.context = context.getApplicationContext();
        this.gPa = i;
        this.gPq = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bsl() {
        if (this.context != null) {
            this.gPr = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gPr, intentFilter);
        }
    }

    private void bsm() {
        if (this.context != null && this.gPr != null) {
            this.context.unregisterReceiver(this.gPr);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        bsl();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bsm();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gPq == null) {
            uY(2);
            if (bVar != null) {
                bVar.cA(0, 2);
                return;
            }
            return;
        }
        this.gPb = shareEntity;
        this.gPm = bVar;
        this.gPa = shareEntity.bsh();
        if (!this.gPq.isWXAppInstalled()) {
            if (this.gPm != null) {
                this.gPm.cA(this.gPa, 2);
            }
            si(getString(d.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gPq.isWXAppSupportAPI()) {
            if (this.gPm != null) {
                this.gPm.cA(this.gPa, 2);
            }
            si(getString(d.j.share_failed, new Object[0]));
        } else {
            String ya = shareEntity.ya();
            if (!TextUtils.isEmpty(ya) && (ya.startsWith("http://") || ya.startsWith("https://"))) {
                if (this.gPb.bsi()) {
                    com.baidu.adp.lib.f.c.nm().a(ya, 34, this.gPi, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.nm().a(ya, 10, this.gPs, 0, 0, getPageId(), new Object[0]);
                }
            } else if (ri(ya)) {
                sn(ya);
            } else {
                bsn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.bsn();
                return;
            }
            Bitmap sh = aVar.sh();
            if (!TextUtils.isEmpty(f.this.gPb.getLinkUrl())) {
                f.this.c(f.this.gPb, sh);
            } else if (!TextUtils.isEmpty(f.this.gPb.getVideoUrl())) {
                f.this.d(f.this.gPb, sh);
            } else if (TextUtils.isEmpty(f.this.gPb.getContent())) {
                f.this.b(f.this.gPb, sh);
            } else {
                f.this.bsn();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gPm != null) {
                f.this.gPm.cA(f.this.gPa, 3);
            }
            f.this.uY(3);
        }
    }

    private void sn(String str) {
        Bitmap sk = sk(str);
        if (sk == null) {
            sk = bsj();
        }
        if (sk != null) {
            b(this.gPb, sk);
        } else {
            c(this.gPb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsn() {
        Bitmap bsj = bsj();
        if (bsj != null) {
            b(this.gPb, bsj);
        } else {
            c(this.gPb);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gPq != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = so("textShare");
            req.message = wXMediaMessage;
            req.scene = bso();
            this.gPq.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gPq != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.or().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = u(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = so("imageShare");
            req.message = wXMediaMessage;
            req.scene = bso();
            this.gPq.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.gPq == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.aZc == null || aVar.aZc.sh() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = u(aVar.aZc.sh());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = so("imageShare");
        req.message = wXMediaMessage;
        req.scene = bso();
        this.gPq.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, e.a aVar) {
        return this.gPa == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.gPq == null || aVar == null || aVar.aZc == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = u(aVar.aZc.sh());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = so("imageShare");
        req.message = wXMediaMessage;
        req.scene = bso();
        this.gPq.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gPq != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = u(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = so("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bso();
            this.gPq.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gPq != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = u(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = so("videoShare");
            req.message = wXMediaMessage;
            req.scene = bso();
            this.gPq.sendReq(req);
        }
    }

    private int bso() {
        if (this.gPa == 3) {
            return 0;
        }
        if (this.gPa == 2) {
            return 1;
        }
        return -1;
    }

    private String so(String str) {
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
                    if (f.this.gPm != null) {
                        f.this.gPm.cA(f.this.gPa, 1);
                    }
                    f.this.uY(1);
                } else if (intExtra == -2) {
                    if (f.this.gPm != null) {
                        f.this.gPm.cA(f.this.gPa, 3);
                    }
                    f.this.uY(3);
                } else {
                    f.this.ae(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gPm != null) {
                        f.this.gPm.cA(f.this.gPa, 2);
                    }
                    f.this.uY(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, String str) {
        if (this.gPb != null && !StringUtils.isNull(this.gPb.ya())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.gPb.ya());
        }
    }

    public byte[] u(Bitmap bitmap) {
        try {
            Bitmap g = g(bitmap, 120);
            if (g == null) {
                g = bsj();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            g.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
