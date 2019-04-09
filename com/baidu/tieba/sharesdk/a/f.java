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
    private int iuX;
    private ShareEntity iuY;
    private final com.baidu.adp.lib.f.b<f.a> ivf;
    private com.baidu.tieba.sharesdk.b.b ivj;
    private IWXAPI ivn;
    private b ivo;
    private final a ivp;

    public f(Context context, int i) {
        super(context);
        this.ivf = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.bMW == null || !f.this.b(f.this.iuY, aVar)) {
                    f.this.ivp.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.ivp.onCancelled(str);
            }
        };
        this.ivp = new a();
        this.context = context.getApplicationContext();
        this.iuX = i;
        this.ivn = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void caT() {
        if (this.context != null) {
            this.ivo = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.ivo, intentFilter);
        }
    }

    private void caU() {
        if (this.context != null && this.ivo != null) {
            this.context.unregisterReceiver(this.ivo);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void r(BdUniqueId bdUniqueId) {
        super.r(bdUniqueId);
        caT();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        caU();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.ivn == null) {
            yF(2);
            if (bVar != null) {
                bVar.cf(0, 2);
                return;
            }
            return;
        }
        this.iuY = shareEntity;
        this.ivj = bVar;
        this.iuX = shareEntity.caO();
        if (!this.ivn.isWXAppInstalled()) {
            if (this.ivj != null) {
                this.ivj.cf(this.iuX, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(d.j.share_weixin_not_installed_yet), 0, ShareHandlerActivity.bUN).abe();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.oy() != null) {
            b(this.iuY, a2.oy());
        } else if (od(shareEntity.caN())) {
            Cc(shareEntity.caN());
        } else {
            String Xk = shareEntity.Xk();
            if (!TextUtils.isEmpty(Xk) && (Xk.startsWith("http://") || Xk.startsWith("https://"))) {
                if (this.iuY.caP() != 0) {
                    com.baidu.adp.lib.f.c.jB().a(Xk, 34, this.ivf, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.jB().a(Xk, 10, this.ivp, 0, 0, getPageId(), new Object[0]);
                }
            } else if (q(shareEntity.getImageUri())) {
                Cc(shareEntity.getImageUri().getPath());
            } else {
                caV();
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
                f.this.caV();
                return;
            }
            Bitmap oy = aVar.oy();
            if (!TextUtils.isEmpty(f.this.iuY.getLinkUrl())) {
                if (f.this.iuX == 2) {
                    f.this.c(f.this.iuY, oy);
                    return;
                }
                String tid = f.this.iuY.getTid();
                if (StringUtils.isNull(tid) || tid.equals("0")) {
                    f.this.c(f.this.iuY, oy);
                } else {
                    f.this.d(f.this.iuY, oy);
                }
            } else if (!TextUtils.isEmpty(f.this.iuY.getVideoUrl())) {
                f.this.e(f.this.iuY, oy);
            } else if (TextUtils.isEmpty(f.this.iuY.getContent())) {
                f.this.b(f.this.iuY, oy);
            } else {
                f.this.caV();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.ivj != null) {
                f.this.ivj.cf(f.this.iuX, 3);
            }
            f.this.yF(3);
        }
    }

    private void Cc(String str) {
        Bitmap BZ = BZ(str);
        if (BZ == null) {
            BZ = caR();
        }
        if (BZ != null) {
            b(this.iuY, BZ);
        } else {
            d(this.iuY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caV() {
        Bitmap caR = caR();
        if (caR != null) {
            b(this.iuY, caR);
        } else {
            d(this.iuY);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.ivn != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Cd("textShare");
            req.message = wXMediaMessage;
            req.scene = caW();
            this.ivn.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivn != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.kG().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Cd("imageShare");
            req.message = wXMediaMessage;
            req.scene = caW();
            this.ivn.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.ivn == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.bMW == null || aVar.bMW.oy() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = F(aVar.bMW.oy());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Cd("imageShare");
        req.message = wXMediaMessage;
        req.scene = caW();
        this.ivn.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.iuX == 2 || this.iuY.caP() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.ivn == null || aVar == null || aVar.bMW == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = F(aVar.bMW.oy());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Cd("imageShare");
        req.message = wXMediaMessage;
        req.scene = caW();
        this.ivn.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivn != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Cd("webpageShare");
            req.message = wXMediaMessage;
            req.scene = caW();
            this.ivn.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivn != null) {
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.Xk())) {
                wXMediaMessage.thumbData = a(bitmap, SubsamplingScaleImageView.ORIENTATION_180, 144, true);
            } else {
                wXMediaMessage.thumbData = a(bitmap, SubsamplingScaleImageView.ORIENTATION_180, 144, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Cd("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.ivn.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.ivn != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Cd("videoShare");
            req.message = wXMediaMessage;
            req.scene = caW();
            this.ivn.sendReq(req);
        }
    }

    private int caW() {
        if (this.iuX == 3) {
            return 0;
        }
        if (this.iuX == 2) {
            return 1;
        }
        return -1;
    }

    private String Cd(String str) {
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
                    if (f.this.ivj != null) {
                        f.this.ivj.cf(f.this.iuX, 1);
                    }
                    f.this.yF(1);
                } else if (intExtra == -2) {
                    if (f.this.ivj != null) {
                        f.this.ivj.cf(f.this.iuX, 3);
                    }
                    f.this.yF(3);
                } else {
                    f.this.aC(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.ivj != null) {
                        f.this.ivj.cf(f.this.iuX, 2);
                    }
                    f.this.yF(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (this.iuY != null && !StringUtils.isNull(this.iuY.Xk())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.iuY.Xk());
        }
    }

    public byte[] F(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = caR();
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
                f = yG(d.f.miniprogram_share_defaults);
            } else {
                f = f(bitmap, i, i2);
            }
            if (f == null) {
                f = yG(d.f.miniprogram_share_defaults);
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
