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
    private int gBY;
    private ShareEntity gBZ;
    private final com.baidu.adp.lib.f.b<f.a> gCg;
    private com.baidu.tieba.sharesdk.b.b gCk;
    private IWXAPI gCo;
    private b gCp;
    private final a gCq;

    public f(Context context, int i) {
        super(context);
        this.gCg = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.asW == null || !f.this.b(f.this.gBZ, aVar)) {
                    f.this.gCq.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gCq.onCancelled(str);
            }
        };
        this.gCq = new a();
        this.context = context.getApplicationContext();
        this.gBY = i;
        this.gCo = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void brw() {
        if (this.context != null) {
            this.gCp = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gCp, intentFilter);
        }
    }

    private void brx() {
        if (this.context != null && this.gCp != null) {
            this.context.unregisterReceiver(this.gCp);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void r(BdUniqueId bdUniqueId) {
        super.r(bdUniqueId);
        brw();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        brx();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gCo == null) {
            sT(2);
            if (bVar != null) {
                bVar.bD(0, 2);
                return;
            }
            return;
        }
        this.gBZ = shareEntity;
        this.gCk = bVar;
        this.gBY = shareEntity.brs();
        if (!this.gCo.isWXAppInstalled()) {
            if (this.gCk != null) {
                this.gCk.bD(this.gBY, 2);
            }
            th(getString(d.j.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gCo.isWXAppSupportAPI()) {
            if (this.gCk != null) {
                this.gCk.bD(this.gBY, 2);
            }
            th(getString(d.j.share_failed, new Object[0]));
        } else {
            String tU = shareEntity.tU();
            if (!TextUtils.isEmpty(tU) && (tU.startsWith("http://") || tU.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.gBZ.brt()) {
                    com.baidu.adp.lib.f.c.ih().a(tU, 34, this.gCg, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.ih().a(tU, 10, this.gCq, 0, 0, getPageId(), new Object[0]);
                }
            } else if (h(shareEntity.getImageUri())) {
                tm(shareEntity.getImageUri().getPath());
            } else {
                bry();
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
                f.this.bry();
                return;
            }
            Bitmap nb = aVar.nb();
            if (!TextUtils.isEmpty(f.this.gBZ.getLinkUrl())) {
                f.this.c(f.this.gBZ, nb);
            } else if (!TextUtils.isEmpty(f.this.gBZ.getVideoUrl())) {
                f.this.d(f.this.gBZ, nb);
            } else if (TextUtils.isEmpty(f.this.gBZ.getContent())) {
                f.this.b(f.this.gBZ, nb);
            } else {
                f.this.bry();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gCk != null) {
                f.this.gCk.bD(f.this.gBY, 3);
            }
            f.this.sT(3);
        }
    }

    private void tm(String str) {
        Bitmap tj = tj(str);
        if (tj == null) {
            tj = bru();
        }
        if (tj != null) {
            b(this.gBZ, tj);
        } else {
            c(this.gBZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bry() {
        Bitmap bru = bru();
        if (bru != null) {
            b(this.gBZ, bru);
        } else {
            c(this.gBZ);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gCo != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tn("textShare");
            req.message = wXMediaMessage;
            req.scene = brz();
            this.gCo.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gCo != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.jm().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = w(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tn("imageShare");
            req.message = wXMediaMessage;
            req.scene = brz();
            this.gCo.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gCo == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.asW == null || aVar.asW.nb() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = w(aVar.asW.nb());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tn("imageShare");
        req.message = wXMediaMessage;
        req.scene = brz();
        this.gCo.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return this.gBY == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.gCo == null || aVar == null || aVar.asW == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = w(aVar.asW.nb());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tn("imageShare");
        req.message = wXMediaMessage;
        req.scene = brz();
        this.gCo.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gCo != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = w(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tn("webpageShare");
            req.message = wXMediaMessage;
            req.scene = brz();
            this.gCo.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gCo != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = w(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tn("videoShare");
            req.message = wXMediaMessage;
            req.scene = brz();
            this.gCo.sendReq(req);
        }
    }

    private int brz() {
        if (this.gBY == 3) {
            return 0;
        }
        if (this.gBY == 2) {
            return 1;
        }
        return -1;
    }

    private String tn(String str) {
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
                    if (f.this.gCk != null) {
                        f.this.gCk.bD(f.this.gBY, 1);
                    }
                    f.this.sT(1);
                } else if (intExtra == -2) {
                    if (f.this.gCk != null) {
                        f.this.gCk.bD(f.this.gBY, 3);
                    }
                    f.this.sT(3);
                } else {
                    f.this.ak(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gCk != null) {
                        f.this.gCk.bD(f.this.gBY, 2);
                    }
                    f.this.sT(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, String str) {
        if (this.gBZ != null && !StringUtils.isNull(this.gBZ.tU())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.gBZ.tU());
        }
    }

    public byte[] w(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = bru();
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
