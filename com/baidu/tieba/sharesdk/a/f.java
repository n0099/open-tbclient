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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.d.e;
import com.baidu.tbadk.core.util.o;
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
    private final com.baidu.adp.lib.e.c<e.a> nkH;
    private com.baidu.tieba.sharesdk.b.b nkN;
    private IWXAPI nkR;
    private b nkS;
    private final a nkT;
    private int nkw;
    private ShareEntity nkx;

    public f(Context context, int i) {
        super(context);
        this.nkH = new com.baidu.adp.lib.e.c<e.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.fcS == null || !f.this.b(f.this.nkx, aVar)) {
                    f.this.nkT.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.nkT.onCancelled(str);
            }
        };
        this.nkT = new a();
        this.context = context.getApplicationContext();
        this.nkw = i;
        this.nkR = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void dJs() {
        if (this.context != null) {
            this.nkS = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.nkS, intentFilter);
        }
    }

    private void dJt() {
        if (this.context != null && this.nkS != null) {
            this.context.unregisterReceiver(this.nkS);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void z(BdUniqueId bdUniqueId) {
        super.z(bdUniqueId);
        dJs();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        dJt();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.nkR == null) {
            dn(2, this.nkw);
            if (bVar != null) {
                bVar.dm(0, 2);
                return;
            }
            return;
        }
        this.nkx = shareEntity;
        this.nkN = bVar;
        this.nkw = shareEntity.dJj();
        if (!this.nkR.isWXAppInstalled()) {
            if (this.nkN != null) {
                this.nkN.dm(this.nkw, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.ajU).bqD();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            if (this.nkx.dJk() == 2) {
                g(this.nkx, a2.getRawBitmap());
            } else {
                b(this.nkx, a2.getRawBitmap());
            }
        } else if (Cl(shareEntity.dJi())) {
            SJ(shareEntity.dJi());
        } else {
            String imgUrl = shareEntity.getImgUrl();
            if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.nkx.dJk() != 0) {
                    com.baidu.adp.lib.e.d.mw().a(imgUrl, 34, this.nkH, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.d.mw().a(imgUrl, 10, this.nkT, 0, 0, getPageId(), new Object[0]);
                }
            } else if (z(shareEntity.getImageUri())) {
                SJ(shareEntity.getImageUri().getPath());
            } else {
                dJu();
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
                f.this.dJu();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.nkx.getLinkUrl())) {
                if (f.this.nkw == 2) {
                    f.this.c(f.this.nkx, rawBitmap);
                    return;
                }
                String tid = f.this.nkx.getTid();
                int dJn = f.this.nkx.dJn();
                if ((dJn == 2 || dJn == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.nkx.canShareBySmartApp) {
                    f.this.e(f.this.nkx, rawBitmap);
                } else {
                    f.this.c(f.this.nkx, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.nkx.getVideoUrl())) {
                f.this.f(f.this.nkx, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.nkx.getContent())) {
                f.this.b(f.this.nkx, rawBitmap);
            } else {
                f.this.dJu();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.nkN != null) {
                f.this.nkN.dm(f.this.nkw, 3);
            }
            f.this.dn(3, f.this.nkw);
        }
    }

    private void SJ(String str) {
        Bitmap SG = SG(str);
        if (SG == null) {
            SG = dJp();
        }
        if (SG != null) {
            b(this.nkx, SG);
        } else {
            d(this.nkx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJu() {
        Bitmap dJp = dJp();
        if (dJp != null) {
            b(this.nkx, dJp);
        } else {
            d(this.nkx);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.nkR != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SK("textShare");
            req.message = wXMediaMessage;
            req.scene = dJv();
            this.nkR.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nkR != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            if (!a(wXImageObject, bitmap)) {
                wXImageObject.imageData = com.baidu.adp.lib.util.d.nH().Bitmap2Bytes(bitmap, 85);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXImageObject;
                wXMediaMessage.thumbData = L(bitmap);
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = SK("imageShare");
                req.message = wXMediaMessage;
                req.scene = dJv();
                this.nkR.sendReq(req);
            }
        }
    }

    private boolean a(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.nkR == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.fcS == null || aVar.fcS.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        if (a(wXImageObject, aVar.fcS.getRawBitmap())) {
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = L(aVar.fcS.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = SK("imageShare");
        req.message = wXMediaMessage;
        req.scene = dJv();
        this.nkR.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, e.a aVar) {
        return (this.nkw == 2 || this.nkx.dJk() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.nkR == null || aVar == null || aVar.fcS == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = L(aVar.fcS.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = SK("imageShare");
        req.message = wXMediaMessage;
        req.scene = dJv();
        this.nkR.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.dJh()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.nkx, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.nkx, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.nkx, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nkR != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SK("webpageShare");
            req.message = wXMediaMessage;
            req.scene = dJv();
            this.nkR.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nkR != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.dJn() == 2 || shareEntity.dJn() == 4) {
                String dJm = shareEntity.dJm();
                if (au.isEmpty(dJm)) {
                    dJm = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(dJm);
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
            req.transaction = SK("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.nkR.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nkR != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SK("videoShare");
            req.message = wXMediaMessage;
            req.scene = dJv();
            this.nkR.sendReq(req);
        }
    }

    private int dJv() {
        if (this.nkw == 3) {
            return 0;
        }
        if (this.nkw == 2) {
            return 1;
        }
        return -1;
    }

    private String SK(String str) {
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
                    if (f.this.nkN != null) {
                        f.this.nkN.dm(f.this.nkw, 1);
                    }
                    f.this.dn(1, f.this.nkw);
                } else if (intExtra == -2) {
                    if (f.this.nkN != null) {
                        f.this.nkN.dm(f.this.nkw, 3);
                    }
                    f.this.dn(3, f.this.nkw);
                } else {
                    f.this.bW(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.nkN != null) {
                        f.this.nkN.dm(f.this.nkw, 2);
                    }
                    f.this.dn(2, f.this.nkw);
                }
                f.this.dJy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(int i, String str) {
        if (this.nkx != null && !StringUtils.isNull(this.nkx.getImgUrl())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.nkx.getImgUrl());
        }
    }

    public byte[] L(Bitmap bitmap) {
        try {
            Bitmap h = h(bitmap, 120);
            if (h == null) {
                h = dJp();
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
                h = IR(R.drawable.miniprogram_share_defaults);
            } else {
                h = h(bitmap, i);
            }
            if (h == null) {
                h = IR(R.drawable.miniprogram_share_defaults);
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

    public byte[] dJw() {
        try {
            Bitmap IR = IR(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IR.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return dJw();
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
                    return dJw();
                }
                return byteArray;
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean gT(Context context) {
        return this.nkR.getWXAppSupportAPI() >= 654314752;
    }

    public boolean dJx() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(WXImageObject wXImageObject, Bitmap bitmap) {
        if (this.context == null || wXImageObject == null || bitmap == null || !gT(this.context) || !dJx()) {
            return false;
        }
        try {
            a(wXImageObject, o.saveFileAsPNG(nkB, nkD, bitmap, 100), bitmap);
            return true;
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    private void a(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        wXImageObject.setImagePath(k(this.context, new File(str)));
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = L(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = SK("imageShare");
        req.message = wXMediaMessage;
        req.scene = dJv();
        this.nkR.sendReq(req);
    }

    public String k(Context context, File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        context.grantUriPermission("com.tencent.mm", uriForFile, 1);
        return uriForFile.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJy() {
        o.deleteFile(new File(nkB + nkD));
    }

    private void g(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.nkR != null && bitmap != null) {
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiData = c(bitmap, 512, false);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = L(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = SK("imageShare");
            req.message = wXMediaMessage;
            req.scene = dJv();
            this.nkR.sendReq(req);
        }
    }
}
