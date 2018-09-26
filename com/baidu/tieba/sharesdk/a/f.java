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
    private int gJE;
    private ShareEntity gJF;
    private final com.baidu.adp.lib.f.b<f.a> gJM;
    private com.baidu.tieba.sharesdk.b.b gJQ;
    private IWXAPI gJU;
    private b gJV;
    private final a gJW;

    public f(Context context, int i) {
        super(context);
        this.gJM = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.avv == null || !f.this.b(f.this.gJF, aVar)) {
                    f.this.gJW.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gJW.onCancelled(str);
            }
        };
        this.gJW = new a();
        this.context = context.getApplicationContext();
        this.gJE = i;
        this.gJU = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void buc() {
        if (this.context != null) {
            this.gJV = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gJV, intentFilter);
        }
    }

    private void bud() {
        if (this.context != null && this.gJV != null) {
            this.context.unregisterReceiver(this.gJV);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        buc();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bud();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gJU == null) {
            tt(2);
            if (bVar != null) {
                bVar.bF(0, 2);
                return;
            }
            return;
        }
        this.gJF = shareEntity;
        this.gJQ = bVar;
        this.gJE = shareEntity.btY();
        if (!this.gJU.isWXAppInstalled()) {
            if (this.gJQ != null) {
                this.gJQ.bF(this.gJE, 2);
            }
            tS(getString(e.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gJU.isWXAppSupportAPI()) {
            if (this.gJQ != null) {
                this.gJQ.bF(this.gJE, 2);
            }
            tS(getString(e.j.share_failed, new Object[0]));
        } else {
            String uW = shareEntity.uW();
            if (!TextUtils.isEmpty(uW) && (uW.startsWith("http://") || uW.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.gJF.btZ()) {
                    com.baidu.adp.lib.f.c.jn().a(uW, 34, this.gJM, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jn().a(uW, 10, this.gJW, 0, 0, getPageId(), new Object[0]);
                }
            } else if (h(shareEntity.getImageUri())) {
                tX(shareEntity.getImageUri().getPath());
            } else {
                bue();
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
                f.this.bue();
                return;
            }
            Bitmap oh = aVar.oh();
            if (!TextUtils.isEmpty(f.this.gJF.getLinkUrl())) {
                f.this.c(f.this.gJF, oh);
            } else if (!TextUtils.isEmpty(f.this.gJF.getVideoUrl())) {
                f.this.d(f.this.gJF, oh);
            } else if (TextUtils.isEmpty(f.this.gJF.getContent())) {
                f.this.b(f.this.gJF, oh);
            } else {
                f.this.bue();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gJQ != null) {
                f.this.gJQ.bF(f.this.gJE, 3);
            }
            f.this.tt(3);
        }
    }

    private void tX(String str) {
        Bitmap tU = tU(str);
        if (tU == null) {
            tU = bua();
        }
        if (tU != null) {
            b(this.gJF, tU);
        } else {
            c(this.gJF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bue() {
        Bitmap bua = bua();
        if (bua != null) {
            b(this.gJF, bua);
        } else {
            c(this.gJF);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gJU != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tY("textShare");
            req.message = wXMediaMessage;
            req.scene = buf();
            this.gJU.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gJU != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.ks().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tY("imageShare");
            req.message = wXMediaMessage;
            req.scene = buf();
            this.gJU.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gJU == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.avv == null || aVar.avv.oh() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.avv.oh());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tY("imageShare");
        req.message = wXMediaMessage;
        req.scene = buf();
        this.gJU.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return this.gJE == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gJU == null || aVar == null || aVar.avv == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.avv.oh());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tY("imageShare");
        req.message = wXMediaMessage;
        req.scene = buf();
        this.gJU.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gJU != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tY("webpageShare");
            req.message = wXMediaMessage;
            req.scene = buf();
            this.gJU.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gJU != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tY("videoShare");
            req.message = wXMediaMessage;
            req.scene = buf();
            this.gJU.sendReq(req);
        }
    }

    private int buf() {
        if (this.gJE == 3) {
            return 0;
        }
        if (this.gJE == 2) {
            return 1;
        }
        return -1;
    }

    private String tY(String str) {
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
                    if (f.this.gJQ != null) {
                        f.this.gJQ.bF(f.this.gJE, 1);
                    }
                    f.this.tt(1);
                } else if (intExtra == -2) {
                    if (f.this.gJQ != null) {
                        f.this.gJQ.bF(f.this.gJE, 3);
                    }
                    f.this.tt(3);
                } else {
                    f.this.al(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gJQ != null) {
                        f.this.gJQ.bF(f.this.gJE, 2);
                    }
                    f.this.tt(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        if (this.gJF != null && !StringUtils.isNull(this.gJF.uW())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.gJF.uW());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap d = d(bitmap, 120);
            if (d == null) {
                d = bua();
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
