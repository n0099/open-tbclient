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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.d.f;
import com.baidu.tieba.d;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private IWXAPI ivC;
    private b ivD;
    private final a ivE;
    private int ivm;
    private ShareEntity ivn;
    private final com.baidu.adp.lib.f.b<f.a> ivu;
    private com.baidu.tieba.sharesdk.b.b ivy;

    public f(Context context, int i) {
        super(context);
        this.ivu = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.bMT == null || !f.this.b(f.this.ivn, aVar)) {
                    f.this.ivE.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.ivE.onCancelled(str);
            }
        };
        this.ivE = new a();
        this.context = context.getApplicationContext();
        this.ivm = i;
        this.ivC = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void caX() {
        if (this.context != null) {
            this.ivD = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.ivD, intentFilter);
        }
    }

    private void caY() {
        if (this.context != null && this.ivD != null) {
            this.context.unregisterReceiver(this.ivD);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void r(BdUniqueId bdUniqueId) {
        super.r(bdUniqueId);
        caX();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        caY();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.ivC == null) {
            yJ(2);
            if (bVar != null) {
                bVar.cf(0, 2);
                return;
            }
            return;
        }
        this.ivn = shareEntity;
        this.ivy = bVar;
        this.ivm = shareEntity.caS();
        if (!this.ivC.isWXAppInstalled()) {
            if (this.ivy != null) {
                this.ivy.cf(this.ivm, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(d.j.share_weixin_not_installed_yet), 0, ShareHandlerActivity.bUK).abh();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.oy() != null) {
            b(this.ivn, a2.oy());
        } else if (oc(shareEntity.caR())) {
            Cd(shareEntity.caR());
        } else {
            String Xn = shareEntity.Xn();
            if (!TextUtils.isEmpty(Xn) && (Xn.startsWith("http://") || Xn.startsWith("https://"))) {
                if (this.ivn.caT() != 0) {
                    com.baidu.adp.lib.f.c.jB().a(Xn, 34, this.ivu, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jB().a(Xn, 10, this.ivE, 0, 0, getPageId(), new Object[0]);
                }
            } else if (q(shareEntity.getImageUri())) {
                Cd(shareEntity.getImageUri().getPath());
            } else {
                caZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.caZ();
                return;
            }
            Bitmap oy = aVar.oy();
            if (!TextUtils.isEmpty(f.this.ivn.getLinkUrl())) {
                if (f.this.ivm == 2) {
                    f.this.c(f.this.ivn, oy);
                    return;
                }
                String tid = f.this.ivn.getTid();
                if (StringUtils.isNull(tid) || tid.equals("0")) {
                    f.this.c(f.this.ivn, oy);
                } else {
                    f.this.d(f.this.ivn, oy);
                }
            } else if (!TextUtils.isEmpty(f.this.ivn.getVideoUrl())) {
                f.this.e(f.this.ivn, oy);
            } else if (TextUtils.isEmpty(f.this.ivn.getContent())) {
                f.this.b(f.this.ivn, oy);
            } else {
                f.this.caZ();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.ivy != null) {
                f.this.ivy.cf(f.this.ivm, 3);
            }
            f.this.yJ(3);
        }
    }

    private void Cd(String str) {
        Bitmap Ca = Ca(str);
        if (Ca == null) {
            Ca = caV();
        }
        if (Ca != null) {
            b(this.ivn, Ca);
        } else {
            d(this.ivn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caZ() {
        Bitmap caV = caV();
        if (caV != null) {
            b(this.ivn, caV);
        } else {
            d(this.ivn);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.ivC != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ce("textShare");
            req.message = wXMediaMessage;
            req.scene = cba();
            this.ivC.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivC != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.kG().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ce("imageShare");
            req.message = wXMediaMessage;
            req.scene = cba();
            this.ivC.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.ivC == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.bMT == null || aVar.bMT.oy() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = F(aVar.bMT.oy());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Ce("imageShare");
        req.message = wXMediaMessage;
        req.scene = cba();
        this.ivC.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.ivm == 2 || this.ivn.caT() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.ivC == null || aVar == null || aVar.bMT == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = F(aVar.bMT.oy());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Ce("imageShare");
        req.message = wXMediaMessage;
        req.scene = cba();
        this.ivC.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivC != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ce("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cba();
            this.ivC.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivC != null) {
            String tid = shareEntity.getTid();
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            wXMiniProgramObject.path = "/pages/pb/pb?tid=" + tid;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
            String title = shareEntity.getTitle();
            if (StringUtils.isNull(title)) {
                title = shareEntity.getContent();
            }
            wXMediaMessage.title = title;
            wXMediaMessage.description = shareEntity.getContent();
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.Xn())) {
                wXMediaMessage.thumbData = a(bitmap, SubsamplingScaleImageView.ORIENTATION_180, 144, true);
            } else {
                wXMediaMessage.thumbData = a(bitmap, SubsamplingScaleImageView.ORIENTATION_180, 144, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ce("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.ivC.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivC != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ce("videoShare");
            req.message = wXMediaMessage;
            req.scene = cba();
            this.ivC.sendReq(req);
        }
    }

    private int cba() {
        if (this.ivm == 3) {
            return 0;
        }
        if (this.ivm == 2) {
            return 1;
        }
        return -1;
    }

    private String Ce(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.ivy != null) {
                        f.this.ivy.cf(f.this.ivm, 1);
                    }
                    f.this.yJ(1);
                } else if (intExtra == -2) {
                    if (f.this.ivy != null) {
                        f.this.ivy.cf(f.this.ivm, 3);
                    }
                    f.this.yJ(3);
                } else {
                    f.this.aA(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.ivy != null) {
                        f.this.ivy.cf(f.this.ivm, 2);
                    }
                    f.this.yJ(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i, String str) {
        if (this.ivn != null && !StringUtils.isNull(this.ivn.Xn())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.ivn.Xn());
        }
    }

    public byte[] F(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = caV();
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

    public byte[] a(Bitmap bitmap, int i, int i2, boolean z) {
        Bitmap f;
        try {
            if (z) {
                f = yK(d.f.miniprogram_share_defaults);
            } else {
                f = f(bitmap, i, i2);
            }
            if (f == null) {
                f = yK(d.f.miniprogram_share_defaults);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            f.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
