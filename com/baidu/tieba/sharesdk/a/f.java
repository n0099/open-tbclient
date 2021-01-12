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
/* loaded from: classes7.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private com.baidu.tieba.sharesdk.b.b naF;
    private IWXAPI naJ;
    private b naK;
    private final a naL;
    private int nan;
    private ShareEntity nao;
    private final com.baidu.adp.lib.e.c<e.a> naz;

    public f(Context context, int i) {
        super(context);
        this.naz = new com.baidu.adp.lib.e.c<e.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.faC == null || !f.this.b(f.this.nao, aVar)) {
                    f.this.naL.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.naL.onCancelled(str);
            }
        };
        this.naL = new a();
        this.context = context.getApplicationContext();
        this.nan = i;
        this.naJ = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void dGZ() {
        if (this.context != null) {
            this.naK = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.naK, intentFilter);
        }
    }

    private void dHa() {
        if (this.context != null && this.naK != null) {
            this.context.unregisterReceiver(this.naK);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void y(BdUniqueId bdUniqueId) {
        super.y(bdUniqueId);
        dGZ();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        dHa();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.naJ == null) {
            dp(2, this.nan);
            if (bVar != null) {
                bVar.mo47do(0, 2);
                return;
            }
            return;
        }
        this.nao = shareEntity;
        this.naF = bVar;
        this.nan = shareEntity.dGQ();
        if (!this.naJ.isWXAppInstalled()) {
            if (this.naF != null) {
                this.naF.mo47do(this.nan, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.akf).bqk();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            if (this.nao.dGR() == 2) {
                g(this.nao, a2.getRawBitmap());
            } else {
                b(this.nao, a2.getRawBitmap());
            }
        } else if (BU(shareEntity.dGP())) {
            Rz(shareEntity.dGP());
        } else {
            String imgUrl = shareEntity.getImgUrl();
            if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.nao.dGR() != 0) {
                    com.baidu.adp.lib.e.d.mx().a(imgUrl, 34, this.naz, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.d.mx().a(imgUrl, 10, this.naL, 0, 0, getPageId(), new Object[0]);
                }
            } else if (z(shareEntity.getImageUri())) {
                Rz(shareEntity.getImageUri().getPath());
            } else {
                dHb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class a extends com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.dHb();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.nao.getLinkUrl())) {
                if (f.this.nan == 2) {
                    f.this.c(f.this.nao, rawBitmap);
                    return;
                }
                String tid = f.this.nao.getTid();
                int dGU = f.this.nao.dGU();
                if ((dGU == 2 || dGU == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.nao.canShareBySmartApp) {
                    f.this.e(f.this.nao, rawBitmap);
                } else {
                    f.this.c(f.this.nao, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.nao.getVideoUrl())) {
                f.this.f(f.this.nao, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.nao.getContent())) {
                f.this.b(f.this.nao, rawBitmap);
            } else {
                f.this.dHb();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.naF != null) {
                f.this.naF.mo47do(f.this.nan, 3);
            }
            f.this.dp(3, f.this.nan);
        }
    }

    private void Rz(String str) {
        Bitmap Rw = Rw(str);
        if (Rw == null) {
            Rw = dGW();
        }
        if (Rw != null) {
            b(this.nao, Rw);
        } else {
            d(this.nao);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHb() {
        Bitmap dGW = dGW();
        if (dGW != null) {
            b(this.nao, dGW);
        } else {
            d(this.nao);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.naJ != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RA("textShare");
            req.message = wXMediaMessage;
            req.scene = dHc();
            this.naJ.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.naJ != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            if (!a(wXImageObject, bitmap)) {
                wXImageObject.imageData = com.baidu.adp.lib.util.d.nI().Bitmap2Bytes(bitmap, 85);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXImageObject;
                wXMediaMessage.thumbData = M(bitmap);
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = RA("imageShare");
                req.message = wXMediaMessage;
                req.scene = dHc();
                this.naJ.sendReq(req);
            }
        }
    }

    private boolean a(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.naJ == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.faC == null || aVar.faC.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        if (a(wXImageObject, aVar.faC.getRawBitmap())) {
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(aVar.faC.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = RA("imageShare");
        req.message = wXMediaMessage;
        req.scene = dHc();
        this.naJ.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, e.a aVar) {
        return (this.nan == 2 || this.nao.dGR() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, e.a aVar) {
        if (shareEntity == null || this.naJ == null || aVar == null || aVar.faC == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = M(aVar.faC.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = RA("imageShare");
        req.message = wXMediaMessage;
        req.scene = dHc();
        this.naJ.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.dGO()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.nao, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.nao, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.nao, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.naJ != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RA("webpageShare");
            req.message = wXMediaMessage;
            req.scene = dHc();
            this.naJ.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.naJ != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.dGU() == 2 || shareEntity.dGU() == 4) {
                String dGT = shareEntity.dGT();
                if (at.isEmpty(dGT)) {
                    dGT = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(dGT);
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
            req.transaction = RA("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.naJ.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.naJ != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RA("videoShare");
            req.message = wXMediaMessage;
            req.scene = dHc();
            this.naJ.sendReq(req);
        }
    }

    private int dHc() {
        if (this.nan == 3) {
            return 0;
        }
        if (this.nan == 2) {
            return 1;
        }
        return -1;
    }

    private String RA(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.naF != null) {
                        f.this.naF.mo47do(f.this.nan, 1);
                    }
                    f.this.dp(1, f.this.nan);
                } else if (intExtra == -2) {
                    if (f.this.naF != null) {
                        f.this.naF.mo47do(f.this.nan, 3);
                    }
                    f.this.dp(3, f.this.nan);
                } else {
                    f.this.bP(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.naF != null) {
                        f.this.naF.mo47do(f.this.nan, 2);
                    }
                    f.this.dp(2, f.this.nan);
                }
                f.this.dHf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, String str) {
        if (this.nao != null && !StringUtils.isNull(this.nao.getImgUrl())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.nao.getImgUrl());
        }
    }

    public byte[] M(Bitmap bitmap) {
        try {
            Bitmap h = h(bitmap, 120);
            if (h == null) {
                h = dGW();
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
                h = Ix(R.drawable.miniprogram_share_defaults);
            } else {
                h = h(bitmap, i);
            }
            if (h == null) {
                h = Ix(R.drawable.miniprogram_share_defaults);
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

    public byte[] dHd() {
        try {
            Bitmap Ix = Ix(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Ix.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return dHd();
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
                    return dHd();
                }
                return byteArray;
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean gQ(Context context) {
        return this.naJ.getWXAppSupportAPI() >= 654314752;
    }

    public boolean dHe() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(WXImageObject wXImageObject, Bitmap bitmap) {
        if (this.context == null || wXImageObject == null || bitmap == null || !gQ(this.context) || !dHe()) {
            return false;
        }
        try {
            a(wXImageObject, n.saveFileAsPNG(nas, nav, bitmap, 100), bitmap);
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
        req.transaction = RA("imageShare");
        req.message = wXMediaMessage;
        req.scene = dHc();
        this.naJ.sendReq(req);
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
    public void dHf() {
        n.deleteFile(new File(nas + nav));
    }

    private void g(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.naJ != null && bitmap != null) {
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiData = c(bitmap, 512, false);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = RA("imageShare");
            req.message = wXMediaMessage;
            req.scene = dHc();
            this.naJ.sendReq(req);
        }
    }
}
