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
    private int kYK;
    private ShareEntity kYL;
    private final com.baidu.adp.lib.e.b<f.a> kYU;
    private com.baidu.tieba.sharesdk.b.b kZa;
    private IWXAPI kZe;
    private b kZf;
    private final a kZg;

    public f(Context context, int i) {
        super(context);
        this.kYU = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.dPE == null || !f.this.b(f.this.kYL, aVar)) {
                    f.this.kZg.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.kZg.onCancelled(str);
            }
        };
        this.kZg = new a();
        this.context = context.getApplicationContext();
        this.kYK = i;
        this.kZe = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void cZw() {
        if (this.context != null) {
            this.kZf = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.kZf, intentFilter);
        }
    }

    private void cZx() {
        if (this.context != null && this.kZf != null) {
            this.context.unregisterReceiver(this.kZf);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void y(BdUniqueId bdUniqueId) {
        super.y(bdUniqueId);
        cZw();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        cZx();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.kZe == null) {
            cQ(2, this.kYK);
            if (bVar != null) {
                bVar.cP(0, 2);
                return;
            }
            return;
        }
        this.kYL = shareEntity;
        this.kZa = bVar;
        this.kYK = shareEntity.cZo();
        if (!this.kZe.isWXAppInstalled()) {
            if (this.kZa != null) {
                this.kZa.cP(this.kYK, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.agt).aSY();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.kYL, a2.getRawBitmap());
        } else if (xw(shareEntity.cZn())) {
            LX(shareEntity.cZn());
        } else {
            String aOP = shareEntity.aOP();
            if (!TextUtils.isEmpty(aOP) && (aOP.startsWith("http://") || aOP.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.kYL.cZp() != 0) {
                    com.baidu.adp.lib.e.c.kX().a(aOP, 34, this.kYU, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.kX().a(aOP, 10, this.kZg, 0, 0, getPageId(), new Object[0]);
                }
            } else if (t(shareEntity.getImageUri())) {
                LX(shareEntity.getImageUri().getPath());
            } else {
                cZy();
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
                f.this.cZy();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.kYL.getLinkUrl())) {
                if (f.this.kYK == 2) {
                    f.this.c(f.this.kYL, rawBitmap);
                    return;
                }
                String tid = f.this.kYL.getTid();
                int cZr = f.this.kYL.cZr();
                if ((cZr == 2 || cZr == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.kYL.canShareBySmartApp) {
                    f.this.e(f.this.kYL, rawBitmap);
                } else {
                    f.this.c(f.this.kYL, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.kYL.getVideoUrl())) {
                f.this.f(f.this.kYL, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.kYL.getContent())) {
                f.this.b(f.this.kYL, rawBitmap);
            } else {
                f.this.cZy();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.kZa != null) {
                f.this.kZa.cP(f.this.kYK, 3);
            }
            f.this.cQ(3, f.this.kYK);
        }
    }

    private void LX(String str) {
        Bitmap LU = LU(str);
        if (LU == null) {
            LU = cZt();
        }
        if (LU != null) {
            b(this.kYL, LU);
        } else {
            d(this.kYL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZy() {
        Bitmap cZt = cZt();
        if (cZt != null) {
            b(this.kYL, cZt);
        } else {
            d(this.kYL);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.kZe != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = LY("textShare");
            req.message = wXMediaMessage;
            req.scene = cZz();
            this.kZe.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kZe != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.mm().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = J(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = LY("imageShare");
            req.message = wXMediaMessage;
            req.scene = cZz();
            this.kZe.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.kZe == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.dPE == null || aVar.dPE.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = J(aVar.dPE.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = LY("imageShare");
        req.message = wXMediaMessage;
        req.scene = cZz();
        this.kZe.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.kYK == 2 || this.kYL.cZp() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.kZe == null || aVar == null || aVar.dPE == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = J(aVar.dPE.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = LY("imageShare");
        req.message = wXMediaMessage;
        req.scene = cZz();
        this.kZe.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.cZm()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.kYL, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.kYL, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.kYL, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kZe != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = J(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = LY("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cZz();
            this.kZe.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kZe != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.cZr() == 2 || shareEntity.cZr() == 4) {
                String cZq = shareEntity.cZq();
                if (aq.isEmpty(cZq)) {
                    cZq = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(cZq);
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.aOP())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = LY("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.kZe.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.kZe != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = J(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = LY("videoShare");
            req.message = wXMediaMessage;
            req.scene = cZz();
            this.kZe.sendReq(req);
        }
    }

    private int cZz() {
        if (this.kYK == 3) {
            return 0;
        }
        if (this.kYK == 2) {
            return 1;
        }
        return -1;
    }

    private String LY(String str) {
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
                    if (f.this.kZa != null) {
                        f.this.kZa.cP(f.this.kYK, 1);
                    }
                    f.this.cQ(1, f.this.kYK);
                } else if (intExtra == -2) {
                    if (f.this.kZa != null) {
                        f.this.kZa.cP(f.this.kYK, 3);
                    }
                    f.this.cQ(3, f.this.kYK);
                } else {
                    f.this.bu(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.kZa != null) {
                        f.this.kZa.cP(f.this.kYK, 2);
                    }
                    f.this.cQ(2, f.this.kYK);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(int i, String str) {
        if (this.kYL != null && !StringUtils.isNull(this.kYL.aOP())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.kYL.aOP());
        }
    }

    public byte[] J(Bitmap bitmap) {
        try {
            Bitmap g = g(bitmap, 120);
            if (g == null) {
                g = cZt();
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

    public byte[] cZA() {
        try {
            Bitmap Dg = Dg(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Dg.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return cZA();
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
                    return cZA();
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
