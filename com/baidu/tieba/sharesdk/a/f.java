package com.baidu.tieba.sharesdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.d.e;
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
/* loaded from: classes8.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private int neU;
    private ShareEntity neV;
    private final com.baidu.adp.lib.e.c<e.a> nff;
    private com.baidu.tieba.sharesdk.b.b nfl;
    private IWXAPI nfp;
    private b nfq;
    private final a nfr;

    public f(Context context, int i) {
        super(context);
        this.nff = new com.baidu.adp.lib.e.c<e.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.ffl == null || !f.this.b(f.this.neV, aVar)) {
                    f.this.nfr.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.nfr.onCancelled(str);
            }
        };
        this.nfr = new a();
        this.context = context.getApplicationContext();
        this.neU = i;
        this.nfp = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void dKQ() {
        if (this.context != null) {
            this.nfq = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.nfq, intentFilter);
        }
    }

    private void dKR() {
        if (this.context != null && this.nfq != null) {
            this.context.unregisterReceiver(this.nfq);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void y(BdUniqueId bdUniqueId) {
        super.y(bdUniqueId);
        dKQ();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        dKR();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.nfp == null) {
            dp(2, this.neU);
            if (bVar != null) {
                bVar.mo41do(0, 2);
                return;
            }
            return;
        }
        this.neV = shareEntity;
        this.nfl = bVar;
        this.neU = shareEntity.dKH();
        if (!this.nfp.isWXAppInstalled()) {
            if (this.nfl != null) {
                this.nfl.mo41do(this.neU, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.akW).bud();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            if (this.neV.dKI() == 2) {
                g(this.neV, a2.getRawBitmap());
            } else {
                b(this.neV, a2.getRawBitmap());
            }
        } else if (Dg(shareEntity.dKG())) {
            SI(shareEntity.dKG());
        } else {
            String imgUrl = shareEntity.getImgUrl();
            if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.neV.dKI() != 0) {
                    com.baidu.adp.lib.e.d.mx().a(imgUrl, 34, this.nff, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.d.mx().a(imgUrl, 10, this.nfr, 0, 0, getPageId(), new Object[0]);
                }
            } else if (w(shareEntity.getImageUri())) {
                SI(shareEntity.getImageUri().getPath());
            } else {
                dKS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public final class a extends com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.dKS();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.neV.getLinkUrl())) {
                if (f.this.neU == 2) {
                    f.this.c(f.this.neV, rawBitmap);
                    return;
                }
                String tid = f.this.neV.getTid();
                int dKL = f.this.neV.dKL();
                if ((dKL == 2 || dKL == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.neV.canShareBySmartApp) {
                    f.this.e(f.this.neV, rawBitmap);
                } else {
                    f.this.c(f.this.neV, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.neV.getVideoUrl())) {
                f.this.f(f.this.neV, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.neV.getContent())) {
                f.this.b(f.this.neV, rawBitmap);
            } else {
                f.this.dKS();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.nfl != null) {
                f.this.nfl.mo41do(f.this.neU, 3);
            }
            f.this.dp(3, f.this.neU);
        }
    }

    private void SI(String str) {
        Bitmap SF = SF(str);
        if (SF == null) {
            SF = dKN();
        }
        if (SF != null) {
            b(this.neV, SF);
        } else {
            d(this.neV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKS() {
        Bitmap dKN = dKN();
        if (dKN != null) {
            b(this.neV, dKN);
        } else {
            d(this.neV);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.nfp != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SJ("textShare");
            req.message = wXMediaMessage;
            req.scene = dKT();
            this.nfp.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nfp != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            if (!a(wXImageObject, bitmap)) {
                wXImageObject.imageData = com.baidu.adp.lib.util.d.nI().Bitmap2Bytes(bitmap, 85);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXImageObject;
                wXMediaMessage.thumbData = M(bitmap);
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = SJ("imageShare");
                req.message = wXMediaMessage;
                req.scene = dKT();
                this.nfp.sendReq(req);
            }
        }
    }

    private boolean a(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.nfp == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.ffl == null || aVar.ffl.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        if (a(wXImageObject, aVar.ffl.getRawBitmap())) {
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(aVar.ffl.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = SJ("imageShare");
        req.message = wXMediaMessage;
        req.scene = dKT();
        this.nfp.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, e.a aVar) {
        return (this.neU == 2 || this.neV.dKI() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.nfp == null || aVar == null || aVar.ffl == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = M(aVar.ffl.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = SJ("imageShare");
        req.message = wXMediaMessage;
        req.scene = dKT();
        this.nfp.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.dKF()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.neV, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.neV, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.neV, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nfp != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SJ("webpageShare");
            req.message = wXMediaMessage;
            req.scene = dKT();
            this.nfp.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nfp != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.dKL() == 2 || shareEntity.dKL() == 4) {
                String dKK = shareEntity.dKK();
                if (at.isEmpty(dKK)) {
                    dKK = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(dKK);
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
            if ("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg".equals(shareEntity.getImgUrl())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SJ("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.nfp.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nfp != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SJ("videoShare");
            req.message = wXMediaMessage;
            req.scene = dKT();
            this.nfp.sendReq(req);
        }
    }

    private int dKT() {
        if (this.neU == 3) {
            return 0;
        }
        if (this.neU == 2) {
            return 1;
        }
        return -1;
    }

    private String SJ(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.nfl != null) {
                        f.this.nfl.mo41do(f.this.neU, 1);
                    }
                    f.this.dp(1, f.this.neU);
                } else if (intExtra == -2) {
                    if (f.this.nfl != null) {
                        f.this.nfl.mo41do(f.this.neU, 3);
                    }
                    f.this.dp(3, f.this.neU);
                } else {
                    f.this.bO(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.nfl != null) {
                        f.this.nfl.mo41do(f.this.neU, 2);
                    }
                    f.this.dp(2, f.this.neU);
                }
                f.this.dKW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, String str) {
        if (this.neV != null && !StringUtils.isNull(this.neV.getImgUrl())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.neV.getImgUrl());
        }
    }

    public byte[] M(Bitmap bitmap) {
        try {
            Bitmap h = h(bitmap, 120);
            if (h == null) {
                h = dKN();
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

    public byte[] c(Bitmap bitmap, int i, boolean z) {
        Bitmap h;
        try {
            if (z) {
                h = Ke(R.drawable.miniprogram_share_defaults);
            } else {
                h = h(bitmap, i);
            }
            if (h == null) {
                h = Ke(R.drawable.miniprogram_share_defaults);
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

    public byte[] dKU() {
        try {
            Bitmap Ke = Ke(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Ke.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return dKU();
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
                    height = valueOf3.intValue();
                    bitmap = g(bitmap, width, height);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    byteArray = byteArrayOutputStream2.toByteArray();
                    length = byteArray.length / 1024;
                }
                byteArrayOutputStream.close();
                if (bitmap == null) {
                    return dKU();
                }
                return byteArray;
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean gS(Context context) {
        return this.nfp.getWXAppSupportAPI() >= 654314752;
    }

    public boolean dKV() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(WXImageObject wXImageObject, Bitmap bitmap) {
        if (this.context == null || wXImageObject == null || bitmap == null || !gS(this.context) || !dKV()) {
            return false;
        }
        try {
            a(wXImageObject, n.saveFileAsPNG(neZ, nfb, bitmap, 100), bitmap);
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
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = SJ("imageShare");
        req.message = wXMediaMessage;
        req.scene = dKT();
        this.nfp.sendReq(req);
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
    public void dKW() {
        n.deleteFile(new File(neZ + nfb));
    }

    private void g(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nfp != null && bitmap != null) {
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiData = c(bitmap, 512, false);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SJ("imageShare");
            req.message = wXMediaMessage;
            req.scene = dKT();
            this.nfp.sendReq(req);
        }
    }
}
