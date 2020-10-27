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
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes24.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private int mEK;
    private ShareEntity mEL;
    private final com.baidu.adp.lib.e.b<f.a> mEU;
    private com.baidu.tieba.sharesdk.b.b mFa;
    private IWXAPI mFf;
    private b mFg;
    private final a mFh;

    public f(Context context, int i) {
        super(context);
        this.mEU = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.eJF == null || !f.this.b(f.this.mEL, aVar)) {
                    f.this.mFh.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.mFh.onCancelled(str);
            }
        };
        this.mFh = new a();
        this.context = context.getApplicationContext();
        this.mEK = i;
        this.mFf = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void dDy() {
        if (this.context != null) {
            this.mFg = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.mFg, intentFilter);
        }
    }

    private void dDz() {
        if (this.context != null && this.mFg != null) {
            this.context.unregisterReceiver(this.mFg);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void y(BdUniqueId bdUniqueId) {
        super.y(bdUniqueId);
        dDy();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        dDz();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mFf == null) {
            dm(2, this.mEK);
            if (bVar != null) {
                bVar.dl(0, 2);
                return;
            }
            return;
        }
        this.mEL = shareEntity;
        this.mFa = bVar;
        this.mEK = shareEntity.dDp();
        if (!this.mFf.isWXAppInstalled()) {
            if (this.mFa != null) {
                this.mFa.dl(this.mEK, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.ajq).bmI();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.mEL, a2.getRawBitmap());
        } else if (CN(shareEntity.dDo())) {
            RT(shareEntity.dDo());
        } else {
            String bhW = shareEntity.bhW();
            if (!TextUtils.isEmpty(bhW) && (bhW.startsWith("http://") || bhW.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.mEL.dDq() != 0) {
                    com.baidu.adp.lib.e.c.mS().a(bhW, 34, this.mEU, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.mS().a(bhW, 10, this.mFh, 0, 0, getPageId(), new Object[0]);
                }
            } else if (u(shareEntity.getImageUri())) {
                RT(shareEntity.getImageUri().getPath());
            } else {
                dDA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public final class a extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.dDA();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.mEL.getLinkUrl())) {
                if (f.this.mEK == 2) {
                    f.this.c(f.this.mEL, rawBitmap);
                    return;
                }
                String tid = f.this.mEL.getTid();
                int dDt = f.this.mEL.dDt();
                if ((dDt == 2 || dDt == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.mEL.canShareBySmartApp) {
                    f.this.e(f.this.mEL, rawBitmap);
                } else {
                    f.this.c(f.this.mEL, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.mEL.getVideoUrl())) {
                f.this.f(f.this.mEL, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.mEL.getContent())) {
                f.this.b(f.this.mEL, rawBitmap);
            } else {
                f.this.dDA();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.mFa != null) {
                f.this.mFa.dl(f.this.mEK, 3);
            }
            f.this.dm(3, f.this.mEK);
        }
    }

    private void RT(String str) {
        Bitmap RQ = RQ(str);
        if (RQ == null) {
            RQ = dDv();
        }
        if (RQ != null) {
            b(this.mEL, RQ);
        } else {
            d(this.mEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDA() {
        Bitmap dDv = dDv();
        if (dDv != null) {
            b(this.mEL, dDv);
        } else {
            d(this.mEL);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.mFf != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RU("textShare");
            req.message = wXMediaMessage;
            req.scene = dDB();
            this.mFf.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mFf != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.oi().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RU("imageShare");
            req.message = wXMediaMessage;
            req.scene = dDB();
            this.mFf.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.mFf == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.eJF == null || aVar.eJF.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = L(aVar.eJF.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = RU("imageShare");
        req.message = wXMediaMessage;
        req.scene = dDB();
        this.mFf.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.mEK == 2 || this.mEL.dDq() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.mFf == null || aVar == null || aVar.eJF == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = L(aVar.eJF.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = RU("imageShare");
        req.message = wXMediaMessage;
        req.scene = dDB();
        this.mFf.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.dDn()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.mEL, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.mEL, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.mEL, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mFf != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RU("webpageShare");
            req.message = wXMediaMessage;
            req.scene = dDB();
            this.mFf.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mFf != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.dDt() == 2 || shareEntity.dDt() == 4) {
                String dDs = shareEntity.dDs();
                if (at.isEmpty(dDs)) {
                    dDs = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(dDs);
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.bhW())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RU("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.mFf.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mFf != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RU("videoShare");
            req.message = wXMediaMessage;
            req.scene = dDB();
            this.mFf.sendReq(req);
        }
    }

    private int dDB() {
        if (this.mEK == 3) {
            return 0;
        }
        if (this.mEK == 2) {
            return 1;
        }
        return -1;
    }

    private String RU(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.mFa != null) {
                        f.this.mFa.dl(f.this.mEK, 1);
                    }
                    f.this.dm(1, f.this.mEK);
                } else if (intExtra == -2) {
                    if (f.this.mFa != null) {
                        f.this.mFa.dl(f.this.mEK, 3);
                    }
                    f.this.dm(3, f.this.mEK);
                } else {
                    f.this.bM(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.mFa != null) {
                        f.this.mFa.dl(f.this.mEK, 2);
                    }
                    f.this.dm(2, f.this.mEK);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(int i, String str) {
        if (this.mEL != null && !StringUtils.isNull(this.mEL.bhW())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.mEL.bhW());
        }
    }

    public byte[] L(Bitmap bitmap) {
        try {
            Bitmap h = h(bitmap, 120);
            if (h == null) {
                h = dDv();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            h.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] dDC() {
        try {
            Bitmap IF = IF(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IF.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return dDC();
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
                    return dDC();
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
