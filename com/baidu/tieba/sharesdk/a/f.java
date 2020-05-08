package com.baidu.tieba.sharesdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.c.f;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.webkit.internal.ETAG;
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
import java.net.URLEncoder;
/* loaded from: classes11.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private int kGI;
    private ShareEntity kGJ;
    private final com.baidu.adp.lib.e.b<f.a> kGS;
    private com.baidu.tieba.sharesdk.b.b kGY;
    private IWXAPI kHc;
    private b kHd;
    private final a kHe;

    public f(Context context, int i) {
        super(context);
        this.kGS = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.dBx == null || !f.this.b(f.this.kGJ, aVar)) {
                    f.this.kHe.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.kHe.onCancelled(str);
            }
        };
        this.kHe = new a();
        this.context = context.getApplicationContext();
        this.kGI = i;
        this.kHc = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void cSs() {
        if (this.context != null) {
            this.kHd = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.kHd, intentFilter);
        }
    }

    private void cSt() {
        if (this.context != null && this.kHd != null) {
            this.context.unregisterReceiver(this.kHd);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void v(BdUniqueId bdUniqueId) {
        super.v(bdUniqueId);
        cSs();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        cSt();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.kHc == null) {
            cL(2, this.kGI);
            if (bVar != null) {
                bVar.cK(0, 2);
                return;
            }
            return;
        }
        this.kGJ = shareEntity;
        this.kGY = bVar;
        this.kGI = shareEntity.cSk();
        if (!this.kHc.isWXAppInstalled()) {
            if (this.kGY != null) {
                this.kGY.cK(this.kGI, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.afW).aMX();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.kGJ, a2.getRawBitmap());
        } else if (vQ(shareEntity.cSj())) {
            Kl(shareEntity.cSj());
        } else {
            String aIU = shareEntity.aIU();
            if (!TextUtils.isEmpty(aIU) && (aIU.startsWith("http://") || aIU.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.kGJ.cSl() != 0) {
                    com.baidu.adp.lib.e.c.kV().a(aIU, 34, this.kGS, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.kV().a(aIU, 10, this.kHe, 0, 0, getPageId(), new Object[0]);
                }
            } else if (y(shareEntity.getImageUri())) {
                Kl(shareEntity.getImageUri().getPath());
            } else {
                cSu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public final class a extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.cSu();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.kGJ.getLinkUrl())) {
                if (f.this.kGI == 2) {
                    f.this.c(f.this.kGJ, rawBitmap);
                    return;
                }
                String tid = f.this.kGJ.getTid();
                int cSn = f.this.kGJ.cSn();
                if ((cSn == 2 || cSn == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.kGJ.canShareBySmartApp) {
                    f.this.e(f.this.kGJ, rawBitmap);
                } else {
                    f.this.c(f.this.kGJ, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.kGJ.getVideoUrl())) {
                f.this.f(f.this.kGJ, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.kGJ.getContent())) {
                f.this.b(f.this.kGJ, rawBitmap);
            } else {
                f.this.cSu();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.kGY != null) {
                f.this.kGY.cK(f.this.kGI, 3);
            }
            f.this.cL(3, f.this.kGI);
        }
    }

    private void Kl(String str) {
        Bitmap Ki = Ki(str);
        if (Ki == null) {
            Ki = cSp();
        }
        if (Ki != null) {
            b(this.kGJ, Ki);
        } else {
            d(this.kGJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSu() {
        Bitmap cSp = cSp();
        if (cSp != null) {
            b(this.kGJ, cSp);
        } else {
            d(this.kGJ);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.kHc != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Km("textShare");
            req.message = wXMediaMessage;
            req.scene = cSv();
            this.kHc.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kHc != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.mk().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = H(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Km("imageShare");
            req.message = wXMediaMessage;
            req.scene = cSv();
            this.kHc.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.kHc == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.dBx == null || aVar.dBx.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = H(aVar.dBx.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Km("imageShare");
        req.message = wXMediaMessage;
        req.scene = cSv();
        this.kHc.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.kGI == 2 || this.kGJ.cSl() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.kHc == null || aVar == null || aVar.dBx == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = H(aVar.dBx.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Km("imageShare");
        req.message = wXMediaMessage;
        req.scene = cSv();
        this.kHc.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.cSi()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.kGJ, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.kGJ, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.kGJ, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kHc != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = H(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Km("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cSv();
            this.kHc.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kHc != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.cSn() == 2 || shareEntity.cSn() == 4) {
                String cSm = shareEntity.cSm();
                if (aq.isEmpty(cSm)) {
                    cSm = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(cSm);
            } else {
                wXMiniProgramObject.path = "/pages/pb/pb?tid=" + shareEntity.getTid();
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
            String title = shareEntity.getTitle();
            if (StringUtils.isNull(title)) {
                title = shareEntity.getContent();
            }
            wXMediaMessage.title = title;
            wXMediaMessage.description = shareEntity.getContent();
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.aIU())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Km("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.kHc.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kHc != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = H(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Km("videoShare");
            req.message = wXMediaMessage;
            req.scene = cSv();
            this.kHc.sendReq(req);
        }
    }

    private int cSv() {
        if (this.kGI == 3) {
            return 0;
        }
        if (this.kGI == 2) {
            return 1;
        }
        return -1;
    }

    private String Km(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.kGY != null) {
                        f.this.kGY.cK(f.this.kGI, 1);
                    }
                    f.this.cL(1, f.this.kGI);
                } else if (intExtra == -2) {
                    if (f.this.kGY != null) {
                        f.this.kGY.cK(f.this.kGI, 3);
                    }
                    f.this.cL(3, f.this.kGI);
                } else {
                    f.this.bp(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.kGY != null) {
                        f.this.kGY.cK(f.this.kGI, 2);
                    }
                    f.this.cL(2, f.this.kGI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        if (this.kGJ != null && !StringUtils.isNull(this.kGJ.aIU())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.kGJ.aIU());
        }
    }

    public byte[] H(Bitmap bitmap) {
        try {
            Bitmap f = f(bitmap, 120);
            if (f == null) {
                f = cSp();
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

    public byte[] cSw() {
        try {
            Bitmap Cw = Cw(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Cw.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] b(Bitmap bitmap, boolean z) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (z || bitmap == null) {
                return cSw();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            double length = byteArray.length / 1024;
            if (length > 125.0d) {
                while (length > 125.0d) {
                    Double valueOf = Double.valueOf(length / 125.0d);
                    Double valueOf2 = Double.valueOf(width / Math.sqrt(valueOf.doubleValue()));
                    Double valueOf3 = Double.valueOf(height / Math.sqrt(valueOf.doubleValue()));
                    width = valueOf2.intValue();
                    int intValue = valueOf3.intValue();
                    bitmap = f(bitmap, width, intValue);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                    byteArray = byteArray2;
                    height = intValue;
                    length = byteArray2.length / 1024;
                }
                byteArrayOutputStream.close();
                if (bitmap == null) {
                    return cSw();
                }
                return byteArray;
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
