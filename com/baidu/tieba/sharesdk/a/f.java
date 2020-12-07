package com.baidu.tieba.sharesdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.c.f;
import com.baidu.tbadk.core.util.n;
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
import java.io.File;
import java.net.URLEncoder;
/* loaded from: classes24.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private final com.baidu.adp.lib.e.b<f.a> mZI;
    private com.baidu.tieba.sharesdk.b.b mZO;
    private IWXAPI mZS;
    private b mZT;
    private final a mZU;
    private int mZx;
    private ShareEntity mZy;

    public f(Context context, int i) {
        super(context);
        this.mZI = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.eVN == null || !f.this.b(f.this.mZy, aVar)) {
                    f.this.mZU.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.mZU.onCancelled(str);
            }
        };
        this.mZU = new a();
        this.context = context.getApplicationContext();
        this.mZx = i;
        this.mZS = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void dLa() {
        if (this.context != null) {
            this.mZT = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.mZT, intentFilter);
        }
    }

    private void dLb() {
        if (this.context != null && this.mZT != null) {
            this.context.unregisterReceiver(this.mZT);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void y(BdUniqueId bdUniqueId) {
        super.y(bdUniqueId);
        dLa();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        dLb();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mZS == null) {
            dt(2, this.mZx);
            if (bVar != null) {
                bVar.ds(0, 2);
                return;
            }
            return;
        }
        this.mZy = shareEntity;
        this.mZO = bVar;
        this.mZx = shareEntity.dKR();
        if (!this.mZS.isWXAppInstalled()) {
            if (this.mZO != null) {
                this.mZO.ds(this.mZx, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.aku).brB();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.mZy, a2.getRawBitmap());
        } else if (Di(shareEntity.dKQ())) {
            SZ(shareEntity.dKQ());
        } else {
            String bmL = shareEntity.bmL();
            if (!TextUtils.isEmpty(bmL) && (bmL.startsWith("http://") || bmL.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.mZy.dKS() != 0) {
                    com.baidu.adp.lib.e.c.mS().a(bmL, 34, this.mZI, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.mS().a(bmL, 10, this.mZU, 0, 0, getPageId(), new Object[0]);
                }
            } else if (u(shareEntity.getImageUri())) {
                SZ(shareEntity.getImageUri().getPath());
            } else {
                dLc();
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
                f.this.dLc();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.mZy.getLinkUrl())) {
                if (f.this.mZx == 2) {
                    f.this.c(f.this.mZy, rawBitmap);
                    return;
                }
                String tid = f.this.mZy.getTid();
                int dKV = f.this.mZy.dKV();
                if ((dKV == 2 || dKV == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.mZy.canShareBySmartApp) {
                    f.this.e(f.this.mZy, rawBitmap);
                } else {
                    f.this.c(f.this.mZy, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.mZy.getVideoUrl())) {
                f.this.f(f.this.mZy, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.mZy.getContent())) {
                f.this.b(f.this.mZy, rawBitmap);
            } else {
                f.this.dLc();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.mZO != null) {
                f.this.mZO.ds(f.this.mZx, 3);
            }
            f.this.dt(3, f.this.mZx);
        }
    }

    private void SZ(String str) {
        Bitmap SW = SW(str);
        if (SW == null) {
            SW = dKX();
        }
        if (SW != null) {
            b(this.mZy, SW);
        } else {
            d(this.mZy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLc() {
        Bitmap dKX = dKX();
        if (dKX != null) {
            b(this.mZy, dKX);
        } else {
            d(this.mZy);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.mZS != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ta("textShare");
            req.message = wXMediaMessage;
            req.scene = dLd();
            this.mZS.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mZS != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            if (!a(wXImageObject, bitmap)) {
                wXImageObject.imageData = com.baidu.adp.lib.util.d.oh().Bitmap2Bytes(bitmap, 85);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXImageObject;
                wXMediaMessage.thumbData = L(bitmap);
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = Ta("imageShare");
                req.message = wXMediaMessage;
                req.scene = dLd();
                this.mZS.sendReq(req);
            }
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.mZS == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.eVN == null || aVar.eVN.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        if (a(wXImageObject, aVar.eVN.getRawBitmap())) {
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = L(aVar.eVN.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Ta("imageShare");
        req.message = wXMediaMessage;
        req.scene = dLd();
        this.mZS.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.mZx == 2 || this.mZy.dKS() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.mZS == null || aVar == null || aVar.eVN == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = L(aVar.eVN.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Ta("imageShare");
        req.message = wXMediaMessage;
        req.scene = dLd();
        this.mZS.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.dKP()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.mZy, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.mZy, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.mZy, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mZS != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ta("webpageShare");
            req.message = wXMediaMessage;
            req.scene = dLd();
            this.mZS.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mZS != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.dKV() == 2 || shareEntity.dKV() == 4) {
                String dKU = shareEntity.dKU();
                if (au.isEmpty(dKU)) {
                    dKU = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(dKU);
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
            if ("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg".equals(shareEntity.bmL())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ta("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.mZS.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.mZS != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ta("videoShare");
            req.message = wXMediaMessage;
            req.scene = dLd();
            this.mZS.sendReq(req);
        }
    }

    private int dLd() {
        if (this.mZx == 3) {
            return 0;
        }
        if (this.mZx == 2) {
            return 1;
        }
        return -1;
    }

    private String Ta(String str) {
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
                    if (f.this.mZO != null) {
                        f.this.mZO.ds(f.this.mZx, 1);
                    }
                    f.this.dt(1, f.this.mZx);
                } else if (intExtra == -2) {
                    if (f.this.mZO != null) {
                        f.this.mZO.ds(f.this.mZx, 3);
                    }
                    f.this.dt(3, f.this.mZx);
                } else {
                    f.this.bO(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.mZO != null) {
                        f.this.mZO.ds(f.this.mZx, 2);
                    }
                    f.this.dt(2, f.this.mZx);
                }
                f.this.dLg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, String str) {
        if (this.mZy != null && !StringUtils.isNull(this.mZy.bmL())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.mZy.bmL());
        }
    }

    public byte[] L(Bitmap bitmap) {
        try {
            Bitmap h = h(bitmap, 120);
            if (h == null) {
                h = dKX();
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

    public byte[] dLe() {
        try {
            Bitmap Kk = Kk(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Kk.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return dLe();
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
                    return dLe();
                }
                return byteArray;
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean gA(Context context) {
        return this.mZS.getWXAppSupportAPI() >= 654314752;
    }

    public boolean dLf() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(WXImageObject wXImageObject, Bitmap bitmap) {
        if (this.context == null || wXImageObject == null || bitmap == null || !gA(this.context) || !dLf()) {
            return false;
        }
        try {
            a(wXImageObject, n.saveFileAsPNG(mZC, mZE, bitmap, 100), bitmap);
            return true;
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    private void a(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        wXImageObject.setImagePath(l(this.context, new File(str)));
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = L(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Ta("imageShare");
        req.message = wXMediaMessage;
        req.scene = dLd();
        this.mZS.sendReq(req);
    }

    public String l(Context context, File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        context.grantUriPermission("com.tencent.mm", uriForFile, 1);
        return uriForFile.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLg() {
        n.deleteFile(new File(mZC + mZE));
    }
}
