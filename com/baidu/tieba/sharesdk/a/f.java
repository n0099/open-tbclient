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
    private final com.baidu.adp.lib.f.b<e.a> gkE;
    private com.baidu.tieba.sharesdk.b.b gkI;
    private IWXAPI gkM;
    private b gkN;
    private final a gkO;
    private int gkw;
    private ShareEntity gkx;

    public f(Context context, int i) {
        super(context);
        this.gkE = new com.baidu.adp.lib.f.b<e.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.akH == null || !f.this.b(f.this.gkx, aVar)) {
                    f.this.gkO.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gkO.onCancelled(str);
            }
        };
        this.gkO = new a();
        this.context = context.getApplicationContext();
        this.gkw = i;
        this.gkM = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bnv() {
        if (this.context != null) {
            this.gkN = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gkN, intentFilter);
        }
    }

    private void bnw() {
        if (this.context != null && this.gkN != null) {
            this.context.unregisterReceiver(this.gkN);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        bnv();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bnw();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gkM == null) {
            sB(2);
            if (bVar != null) {
                bVar.bC(0, 2);
                return;
            }
            return;
        }
        this.gkx = shareEntity;
        this.gkI = bVar;
        this.gkw = shareEntity.bnr();
        if (!this.gkM.isWXAppInstalled()) {
            if (this.gkI != null) {
                this.gkI.bC(this.gkw, 2);
            }
            sp(getString(d.k.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gkM.isWXAppSupportAPI()) {
            if (this.gkI != null) {
                this.gkI.bC(this.gkw, 2);
            }
            sp(getString(d.k.share_failed, new Object[0]));
        } else {
            String qG = shareEntity.qG();
            if (!TextUtils.isEmpty(qG) && (qG.startsWith("http://") || qG.startsWith("https://"))) {
                if (this.gkx.bns()) {
                    com.baidu.adp.lib.f.c.fp().a(qG, 34, this.gkE, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.fp().a(qG, 10, this.gkO, 0, 0, getPageId(), new Object[0]);
                }
            } else if (i(shareEntity.bnq())) {
                sv(shareEntity.bnq().getPath());
            } else {
                bnx();
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
                f.this.bnx();
                return;
            }
            Bitmap km = aVar.km();
            if (!TextUtils.isEmpty(f.this.gkx.getLinkUrl())) {
                f.this.c(f.this.gkx, km);
            } else if (!TextUtils.isEmpty(f.this.gkx.getVideoUrl())) {
                f.this.d(f.this.gkx, km);
            } else if (TextUtils.isEmpty(f.this.gkx.getContent())) {
                f.this.b(f.this.gkx, km);
            } else {
                f.this.bnx();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gkI != null) {
                f.this.gkI.bC(f.this.gkw, 3);
            }
            f.this.sB(3);
        }
    }

    private void sv(String str) {
        Bitmap ss = ss(str);
        if (ss == null) {
            ss = bnt();
        }
        if (ss != null) {
            b(this.gkx, ss);
        } else {
            c(this.gkx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnx() {
        Bitmap bnt = bnt();
        if (bnt != null) {
            b(this.gkx, bnt);
        } else {
            c(this.gkx);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gkM != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sw("textShare");
            req.message = wXMediaMessage;
            req.scene = bny();
            this.gkM.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gkM != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.gw().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = y(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sw("imageShare");
            req.message = wXMediaMessage;
            req.scene = bny();
            this.gkM.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.gkM == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.akH == null || aVar.akH.km() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = y(aVar.akH.km());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = sw("imageShare");
        req.message = wXMediaMessage;
        req.scene = bny();
        this.gkM.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, e.a aVar) {
        return this.gkw == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.gkM == null || aVar == null || aVar.akH == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = y(aVar.akH.km());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = sw("imageShare");
        req.message = wXMediaMessage;
        req.scene = bny();
        this.gkM.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gkM != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = y(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sw("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bny();
            this.gkM.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gkM != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = y(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = sw("videoShare");
            req.message = wXMediaMessage;
            req.scene = bny();
            this.gkM.sendReq(req);
        }
    }

    private int bny() {
        if (this.gkw == 3) {
            return 0;
        }
        if (this.gkw == 2) {
            return 1;
        }
        return -1;
    }

    private String sw(String str) {
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
                    if (f.this.gkI != null) {
                        f.this.gkI.bC(f.this.gkw, 1);
                    }
                    f.this.sB(1);
                } else if (intExtra == -2) {
                    if (f.this.gkI != null) {
                        f.this.gkI.bC(f.this.gkw, 3);
                    }
                    f.this.sB(3);
                } else {
                    f.this.ak(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gkI != null) {
                        f.this.gkI.bC(f.this.gkw, 2);
                    }
                    f.this.sB(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, String str) {
        if (this.gkx != null && !StringUtils.isNull(this.gkx.qG())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.gkx.qG());
        }
    }

    public byte[] y(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = bnt();
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
