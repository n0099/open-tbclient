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
    private int gSB;
    private ShareEntity gSC;
    private final com.baidu.adp.lib.f.b<f.a> gSJ;
    private com.baidu.tieba.sharesdk.b.b gSN;
    private IWXAPI gSR;
    private b gSS;
    private final a gST;

    public f(Context context, int i) {
        super(context);
        this.gSJ = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.aAV == null || !f.this.b(f.this.gSC, aVar)) {
                    f.this.gST.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gST.onCancelled(str);
            }
        };
        this.gST = new a();
        this.context = context.getApplicationContext();
        this.gSB = i;
        this.gSR = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bwN() {
        if (this.context != null) {
            this.gSS = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gSS, intentFilter);
        }
    }

    private void bwO() {
        if (this.context != null && this.gSS != null) {
            this.context.unregisterReceiver(this.gSS);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        bwN();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bwO();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gSR == null) {
            uj(2);
            if (bVar != null) {
                bVar.bK(0, 2);
                return;
            }
            return;
        }
        this.gSC = shareEntity;
        this.gSN = bVar;
        this.gSB = shareEntity.bwJ();
        if (!this.gSR.isWXAppInstalled()) {
            if (this.gSN != null) {
                this.gSN.bK(this.gSB, 2);
            }
            uy(getString(e.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gSR.isWXAppSupportAPI()) {
            if (this.gSN != null) {
                this.gSN.bK(this.gSB, 2);
            }
            uy(getString(e.j.share_failed, new Object[0]));
        } else {
            String xn = shareEntity.xn();
            if (!TextUtils.isEmpty(xn) && (xn.startsWith("http://") || xn.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.gSC.bwK()) {
                    com.baidu.adp.lib.f.c.jA().a(xn, 34, this.gSJ, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jA().a(xn, 10, this.gST, 0, 0, getPageId(), new Object[0]);
                }
            } else if (h(shareEntity.getImageUri())) {
                uD(shareEntity.getImageUri().getPath());
            } else {
                bwP();
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
                f.this.bwP();
                return;
            }
            Bitmap oq = aVar.oq();
            if (!TextUtils.isEmpty(f.this.gSC.getLinkUrl())) {
                f.this.c(f.this.gSC, oq);
            } else if (!TextUtils.isEmpty(f.this.gSC.getVideoUrl())) {
                f.this.d(f.this.gSC, oq);
            } else if (TextUtils.isEmpty(f.this.gSC.getContent())) {
                f.this.b(f.this.gSC, oq);
            } else {
                f.this.bwP();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gSN != null) {
                f.this.gSN.bK(f.this.gSB, 3);
            }
            f.this.uj(3);
        }
    }

    private void uD(String str) {
        Bitmap uA = uA(str);
        if (uA == null) {
            uA = bwL();
        }
        if (uA != null) {
            b(this.gSC, uA);
        } else {
            c(this.gSC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwP() {
        Bitmap bwL = bwL();
        if (bwL != null) {
            b(this.gSC, bwL);
        } else {
            c(this.gSC);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gSR != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uE("textShare");
            req.message = wXMediaMessage;
            req.scene = bwQ();
            this.gSR.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gSR != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.kE().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uE("imageShare");
            req.message = wXMediaMessage;
            req.scene = bwQ();
            this.gSR.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gSR == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.aAV == null || aVar.aAV.oq() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.aAV.oq());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = uE("imageShare");
        req.message = wXMediaMessage;
        req.scene = bwQ();
        this.gSR.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return this.gSB == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gSR == null || aVar == null || aVar.aAV == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.aAV.oq());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = uE("imageShare");
        req.message = wXMediaMessage;
        req.scene = bwQ();
        this.gSR.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gSR != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uE("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bwQ();
            this.gSR.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gSR != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = uE("videoShare");
            req.message = wXMediaMessage;
            req.scene = bwQ();
            this.gSR.sendReq(req);
        }
    }

    private int bwQ() {
        if (this.gSB == 3) {
            return 0;
        }
        if (this.gSB == 2) {
            return 1;
        }
        return -1;
    }

    private String uE(String str) {
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
                    if (f.this.gSN != null) {
                        f.this.gSN.bK(f.this.gSB, 1);
                    }
                    f.this.uj(1);
                } else if (intExtra == -2) {
                    if (f.this.gSN != null) {
                        f.this.gSN.bK(f.this.gSB, 3);
                    }
                    f.this.uj(3);
                } else {
                    f.this.ah(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gSN != null) {
                        f.this.gSN.bK(f.this.gSB, 2);
                    }
                    f.this.uj(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, String str) {
        if (this.gSC != null && !StringUtils.isNull(this.gSC.xn())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.gSC.xn());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap d = d(bitmap, 120);
            if (d == null) {
                d = bwL();
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
