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
/* loaded from: classes18.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private int lSP;
    private ShareEntity lSQ;
    private final com.baidu.adp.lib.e.b<f.a> lSZ;
    private com.baidu.tieba.sharesdk.b.b lTf;
    private IWXAPI lTj;
    private b lTk;
    private final a lTl;

    public f(Context context, int i) {
        super(context);
        this.lSZ = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.emA == null || !f.this.b(f.this.lSQ, aVar)) {
                    f.this.lTl.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.lTl.onCancelled(str);
            }
        };
        this.lTl = new a();
        this.context = context.getApplicationContext();
        this.lSP = i;
        this.lTj = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void dsI() {
        if (this.context != null) {
            this.lTk = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.lTk, intentFilter);
        }
    }

    private void dsJ() {
        if (this.context != null && this.lTk != null) {
            this.context.unregisterReceiver(this.lTk);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void z(BdUniqueId bdUniqueId) {
        super.z(bdUniqueId);
        dsI();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        dsJ();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lTj == null) {
            dg(2, this.lSP);
            if (bVar != null) {
                bVar.df(0, 2);
                return;
            }
            return;
        }
        this.lSQ = shareEntity;
        this.lTf = bVar;
        this.lSP = shareEntity.dsz();
        if (!this.lTj.isWXAppInstalled()) {
            if (this.lTf != null) {
                this.lTf.df(this.lSP, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.aiB).bhm();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.lSQ, a2.getRawBitmap());
        } else if (Bl(shareEntity.dsy())) {
            Qg(shareEntity.dsy());
        } else {
            String bcA = shareEntity.bcA();
            if (!TextUtils.isEmpty(bcA) && (bcA.startsWith("http://") || bcA.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.lSQ.dsA() != 0) {
                    com.baidu.adp.lib.e.c.mM().a(bcA, 34, this.lSZ, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.mM().a(bcA, 10, this.lTl, 0, 0, getPageId(), new Object[0]);
                }
            } else if (t(shareEntity.getImageUri())) {
                Qg(shareEntity.getImageUri().getPath());
            } else {
                dsK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public final class a extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.dsK();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.lSQ.getLinkUrl())) {
                if (f.this.lSP == 2) {
                    f.this.c(f.this.lSQ, rawBitmap);
                    return;
                }
                String tid = f.this.lSQ.getTid();
                int dsD = f.this.lSQ.dsD();
                if ((dsD == 2 || dsD == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.lSQ.canShareBySmartApp) {
                    f.this.e(f.this.lSQ, rawBitmap);
                } else {
                    f.this.c(f.this.lSQ, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.lSQ.getVideoUrl())) {
                f.this.f(f.this.lSQ, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.lSQ.getContent())) {
                f.this.b(f.this.lSQ, rawBitmap);
            } else {
                f.this.dsK();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.lTf != null) {
                f.this.lTf.df(f.this.lSP, 3);
            }
            f.this.dg(3, f.this.lSP);
        }
    }

    private void Qg(String str) {
        Bitmap Qd = Qd(str);
        if (Qd == null) {
            Qd = dsF();
        }
        if (Qd != null) {
            b(this.lSQ, Qd);
        } else {
            d(this.lSQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsK() {
        Bitmap dsF = dsF();
        if (dsF != null) {
            b(this.lSQ, dsF);
        } else {
            d(this.lSQ);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.lTj != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Qh("textShare");
            req.message = wXMediaMessage;
            req.scene = dsL();
            this.lTj.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lTj != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.ob().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Qh("imageShare");
            req.message = wXMediaMessage;
            req.scene = dsL();
            this.lTj.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.lTj == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.emA == null || aVar.emA.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(aVar.emA.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Qh("imageShare");
        req.message = wXMediaMessage;
        req.scene = dsL();
        this.lTj.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.lSP == 2 || this.lSQ.dsA() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.lTj == null || aVar == null || aVar.emA == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = M(aVar.emA.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Qh("imageShare");
        req.message = wXMediaMessage;
        req.scene = dsL();
        this.lTj.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.dsx()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.lSQ, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.lSQ, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.lSQ, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lTj != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Qh("webpageShare");
            req.message = wXMediaMessage;
            req.scene = dsL();
            this.lTj.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lTj != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.dsD() == 2 || shareEntity.dsD() == 4) {
                String dsC = shareEntity.dsC();
                if (at.isEmpty(dsC)) {
                    dsC = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(dsC);
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.bcA())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Qh("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.lTj.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lTj != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Qh("videoShare");
            req.message = wXMediaMessage;
            req.scene = dsL();
            this.lTj.sendReq(req);
        }
    }

    private int dsL() {
        if (this.lSP == 3) {
            return 0;
        }
        if (this.lSP == 2) {
            return 1;
        }
        return -1;
    }

    private String Qh(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.lTf != null) {
                        f.this.lTf.df(f.this.lSP, 1);
                    }
                    f.this.dg(1, f.this.lSP);
                } else if (intExtra == -2) {
                    if (f.this.lTf != null) {
                        f.this.lTf.df(f.this.lSP, 3);
                    }
                    f.this.dg(3, f.this.lSP);
                } else {
                    f.this.by(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.lTf != null) {
                        f.this.lTf.df(f.this.lSP, 2);
                    }
                    f.this.dg(2, f.this.lSP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, String str) {
        if (this.lSQ != null && !StringUtils.isNull(this.lSQ.bcA())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.lSQ.bcA());
        }
    }

    public byte[] M(Bitmap bitmap) {
        try {
            Bitmap h = h(bitmap, 120);
            if (h == null) {
                h = dsF();
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

    public byte[] dsM() {
        try {
            Bitmap Hd = Hd(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Hd.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return dsM();
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
                    return dsM();
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
