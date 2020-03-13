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
    private int jVS;
    private ShareEntity jVT;
    private final com.baidu.adp.lib.e.b<f.a> jWc;
    private com.baidu.tieba.sharesdk.b.b jWi;
    private IWXAPI jWm;
    private b jWn;
    private final a jWo;

    public f(Context context, int i) {
        super(context);
        this.jWc = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.dbR == null || !f.this.b(f.this.jVT, aVar)) {
                    f.this.jWo.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.jWo.onCancelled(str);
            }
        };
        this.jWo = new a();
        this.context = context.getApplicationContext();
        this.jVS = i;
        this.jWm = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void cHD() {
        if (this.context != null) {
            this.jWn = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.jWn, intentFilter);
        }
    }

    private void cHE() {
        if (this.context != null && this.jWn != null) {
            this.context.unregisterReceiver(this.jWn);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void v(BdUniqueId bdUniqueId) {
        super.v(bdUniqueId);
        cHD();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        cHE();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jWm == null) {
            cE(2, this.jVS);
            if (bVar != null) {
                bVar.cD(0, 2);
                return;
            }
            return;
        }
        this.jVT = shareEntity;
        this.jWi = bVar;
        this.jVS = shareEntity.cHv();
        if (!this.jWm.isWXAppInstalled()) {
            if (this.jWi != null) {
                this.jWi.cD(this.jVS, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.Ni).aEH();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.jVT, a2.getRawBitmap());
        } else if (uz(shareEntity.cHu())) {
            IF(shareEntity.cHu());
        } else {
            String aAG = shareEntity.aAG();
            if (!TextUtils.isEmpty(aAG) && (aAG.startsWith("http://") || aAG.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.jVT.cHw() != 0) {
                    com.baidu.adp.lib.e.c.gr().a(aAG, 34, this.jWc, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.gr().a(aAG, 10, this.jWo, 0, 0, getPageId(), new Object[0]);
                }
            } else if (w(shareEntity.getImageUri())) {
                IF(shareEntity.getImageUri().getPath());
            } else {
                cHF();
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
                f.this.cHF();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.jVT.getLinkUrl())) {
                if (f.this.jVS == 2) {
                    f.this.c(f.this.jVT, rawBitmap);
                    return;
                }
                String tid = f.this.jVT.getTid();
                int cHy = f.this.jVT.cHy();
                if ((cHy == 2 || cHy == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.jVT.canShareBySmartApp) {
                    f.this.e(f.this.jVT, rawBitmap);
                } else {
                    f.this.c(f.this.jVT, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.jVT.getVideoUrl())) {
                f.this.f(f.this.jVT, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.jVT.getContent())) {
                f.this.b(f.this.jVT, rawBitmap);
            } else {
                f.this.cHF();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.jWi != null) {
                f.this.jWi.cD(f.this.jVS, 3);
            }
            f.this.cE(3, f.this.jVS);
        }
    }

    private void IF(String str) {
        Bitmap IC = IC(str);
        if (IC == null) {
            IC = cHA();
        }
        if (IC != null) {
            b(this.jVT, IC);
        } else {
            d(this.jVT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHF() {
        Bitmap cHA = cHA();
        if (cHA != null) {
            b(this.jVT, cHA);
        } else {
            d(this.jVT);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.jWm != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("textShare");
            req.message = wXMediaMessage;
            req.scene = cHG();
            this.jWm.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jWm != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.hG().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("imageShare");
            req.message = wXMediaMessage;
            req.scene = cHG();
            this.jWm.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.jWm == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.dbR == null || aVar.dbR.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = F(aVar.dbR.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = IG("imageShare");
        req.message = wXMediaMessage;
        req.scene = cHG();
        this.jWm.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.jVS == 2 || this.jVT.cHw() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.jWm == null || aVar == null || aVar.dbR == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = F(aVar.dbR.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = IG("imageShare");
        req.message = wXMediaMessage;
        req.scene = cHG();
        this.jWm.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.cHt()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: b */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.jVT, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.jVT, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.jVT, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jWm != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cHG();
            this.jWm.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jWm != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.cHy() == 2 || shareEntity.cHy() == 4) {
                String cHx = shareEntity.cHx();
                if (aq.isEmpty(cHx)) {
                    cHx = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(cHx);
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.aAG())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.jWm.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jWm != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("videoShare");
            req.message = wXMediaMessage;
            req.scene = cHG();
            this.jWm.sendReq(req);
        }
    }

    private int cHG() {
        if (this.jVS == 3) {
            return 0;
        }
        if (this.jVS == 2) {
            return 1;
        }
        return -1;
    }

    private String IG(String str) {
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
                    if (f.this.jWi != null) {
                        f.this.jWi.cD(f.this.jVS, 1);
                    }
                    f.this.cE(1, f.this.jVS);
                } else if (intExtra == -2) {
                    if (f.this.jWi != null) {
                        f.this.jWi.cD(f.this.jVS, 3);
                    }
                    f.this.cE(3, f.this.jVS);
                } else {
                    f.this.ba(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.jWi != null) {
                        f.this.jWi.cD(f.this.jVS, 2);
                    }
                    f.this.cE(2, f.this.jVS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(int i, String str) {
        if (this.jVT != null && !StringUtils.isNull(this.jVT.aAG())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.jVT.aAG());
        }
    }

    public byte[] F(Bitmap bitmap) {
        try {
            Bitmap f = f(bitmap, 120);
            if (f == null) {
                f = cHA();
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

    public byte[] cHH() {
        try {
            Bitmap BO = BO(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BO.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return cHH();
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
                    return cHH();
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
