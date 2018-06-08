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
    private int gwX;
    private ShareEntity gwY;
    private final com.baidu.adp.lib.f.b<e.a> gxf;
    private com.baidu.tieba.sharesdk.b.b gxj;
    private IWXAPI gxn;
    private b gxo;
    private final a gxp;

    public f(Context context, int i) {
        super(context);
        this.gxf = new com.baidu.adp.lib.f.b<e.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.asP == null || !f.this.b(f.this.gwY, aVar)) {
                    f.this.gxp.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.gxp.onCancelled(str);
            }
        };
        this.gxp = new a();
        this.context = context.getApplicationContext();
        this.gwX = i;
        this.gxn = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void bst() {
        if (this.context != null) {
            this.gxo = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.gxo, intentFilter);
        }
    }

    private void bsu() {
        if (this.context != null && this.gxo != null) {
            this.context.unregisterReceiver(this.gxo);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void r(BdUniqueId bdUniqueId) {
        super.r(bdUniqueId);
        bst();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        bsu();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gxn == null) {
            sL(2);
            if (bVar != null) {
                bVar.bD(0, 2);
                return;
            }
            return;
        }
        this.gwY = shareEntity;
        this.gxj = bVar;
        this.gwX = shareEntity.bsp();
        if (!this.gxn.isWXAppInstalled()) {
            if (this.gxj != null) {
                this.gxj.bD(this.gwX, 2);
            }
            tk(getString(d.k.share_weixin_not_installed_yet, new Object[0]));
        } else if (!this.gxn.isWXAppSupportAPI()) {
            if (this.gxj != null) {
                this.gxj.bD(this.gwX, 2);
            }
            tk(getString(d.k.share_failed, new Object[0]));
        } else {
            String ub = shareEntity.ub();
            if (!TextUtils.isEmpty(ub) && (ub.startsWith("http://") || ub.startsWith("https://"))) {
                if (this.gwY.bsq()) {
                    com.baidu.adp.lib.f.c.ig().a(ub, 34, this.gxf, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.ig().a(ub, 10, this.gxp, 0, 0, getPageId(), new Object[0]);
                }
            } else if (i(shareEntity.bso())) {
                tp(shareEntity.bso().getPath());
            } else {
                bsv();
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
                f.this.bsv();
                return;
            }
            Bitmap mZ = aVar.mZ();
            if (!TextUtils.isEmpty(f.this.gwY.getLinkUrl())) {
                f.this.c(f.this.gwY, mZ);
            } else if (!TextUtils.isEmpty(f.this.gwY.getVideoUrl())) {
                f.this.d(f.this.gwY, mZ);
            } else if (TextUtils.isEmpty(f.this.gwY.getContent())) {
                f.this.b(f.this.gwY, mZ);
            } else {
                f.this.bsv();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.gxj != null) {
                f.this.gxj.bD(f.this.gwX, 3);
            }
            f.this.sL(3);
        }
    }

    private void tp(String str) {
        Bitmap tm = tm(str);
        if (tm == null) {
            tm = bsr();
        }
        if (tm != null) {
            b(this.gwY, tm);
        } else {
            c(this.gwY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsv() {
        Bitmap bsr = bsr();
        if (bsr != null) {
            b(this.gwY, bsr);
        } else {
            c(this.gwY);
        }
    }

    private void c(ShareEntity shareEntity) {
        if (shareEntity != null && this.gxn != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tq("textShare");
            req.message = wXMediaMessage;
            req.scene = bsw();
            this.gxn.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gxn != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.jl().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tq("imageShare");
            req.message = wXMediaMessage;
            req.scene = bsw();
            this.gxn.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.gxn == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.asP == null || aVar.asP.mZ() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = x(aVar.asP.mZ());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tq("imageShare");
        req.message = wXMediaMessage;
        req.scene = bsw();
        this.gxn.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, e.a aVar) {
        return this.gwX == 2 ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.gxn == null || aVar == null || aVar.asP == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = x(aVar.asP.mZ());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = tq("imageShare");
        req.message = wXMediaMessage;
        req.scene = bsw();
        this.gxn.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gxn != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tq("webpageShare");
            req.message = wXMediaMessage;
            req.scene = bsw();
            this.gxn.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.gxn != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = x(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = tq("videoShare");
            req.message = wXMediaMessage;
            req.scene = bsw();
            this.gxn.sendReq(req);
        }
    }

    private int bsw() {
        if (this.gwX == 3) {
            return 0;
        }
        if (this.gwX == 2) {
            return 1;
        }
        return -1;
    }

    private String tq(String str) {
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
                    if (f.this.gxj != null) {
                        f.this.gxj.bD(f.this.gwX, 1);
                    }
                    f.this.sL(1);
                } else if (intExtra == -2) {
                    if (f.this.gxj != null) {
                        f.this.gxj.bD(f.this.gwX, 3);
                    }
                    f.this.sL(3);
                } else {
                    f.this.al(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.gxj != null) {
                        f.this.gxj.bD(f.this.gwX, 2);
                    }
                    f.this.sL(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        if (this.gwY != null && !StringUtils.isNull(this.gwY.ub())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.gwY.ub());
        }
    }

    public byte[] x(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = bsr();
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
