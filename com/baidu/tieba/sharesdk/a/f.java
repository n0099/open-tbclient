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
    private final com.baidu.adp.lib.e.b<f.a> jXE;
    private com.baidu.tieba.sharesdk.b.b jXK;
    private IWXAPI jXO;
    private b jXP;
    private final a jXQ;
    private int jXu;
    private ShareEntity jXv;

    public f(Context context, int i) {
        super(context);
        this.jXE = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.dce == null || !f.this.b(f.this.jXv, aVar)) {
                    f.this.jXQ.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.jXQ.onCancelled(str);
            }
        };
        this.jXQ = new a();
        this.context = context.getApplicationContext();
        this.jXu = i;
        this.jXO = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void cHX() {
        if (this.context != null) {
            this.jXP = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.jXP, intentFilter);
        }
    }

    private void cHY() {
        if (this.context != null && this.jXP != null) {
            this.context.unregisterReceiver(this.jXP);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void v(BdUniqueId bdUniqueId) {
        super.v(bdUniqueId);
        cHX();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        cHY();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jXO == null) {
            cF(2, this.jXu);
            if (bVar != null) {
                bVar.cE(0, 2);
                return;
            }
            return;
        }
        this.jXv = shareEntity;
        this.jXK = bVar;
        this.jXu = shareEntity.cHP();
        if (!this.jXO.isWXAppInstalled()) {
            if (this.jXK != null) {
                this.jXK.cE(this.jXu, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.Nj).aEL();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.jXv, a2.getRawBitmap());
        } else if (uz(shareEntity.cHO())) {
            IF(shareEntity.cHO());
        } else {
            String aAJ = shareEntity.aAJ();
            if (!TextUtils.isEmpty(aAJ) && (aAJ.startsWith("http://") || aAJ.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.jXv.cHQ() != 0) {
                    com.baidu.adp.lib.e.c.gr().a(aAJ, 34, this.jXE, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.gr().a(aAJ, 10, this.jXQ, 0, 0, getPageId(), new Object[0]);
                }
            } else if (w(shareEntity.getImageUri())) {
                IF(shareEntity.getImageUri().getPath());
            } else {
                cHZ();
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
                f.this.cHZ();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.jXv.getLinkUrl())) {
                if (f.this.jXu == 2) {
                    f.this.c(f.this.jXv, rawBitmap);
                    return;
                }
                String tid = f.this.jXv.getTid();
                int cHS = f.this.jXv.cHS();
                if ((cHS == 2 || cHS == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.jXv.canShareBySmartApp) {
                    f.this.e(f.this.jXv, rawBitmap);
                } else {
                    f.this.c(f.this.jXv, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.jXv.getVideoUrl())) {
                f.this.f(f.this.jXv, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.jXv.getContent())) {
                f.this.b(f.this.jXv, rawBitmap);
            } else {
                f.this.cHZ();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.jXK != null) {
                f.this.jXK.cE(f.this.jXu, 3);
            }
            f.this.cF(3, f.this.jXu);
        }
    }

    private void IF(String str) {
        Bitmap IC = IC(str);
        if (IC == null) {
            IC = cHU();
        }
        if (IC != null) {
            b(this.jXv, IC);
        } else {
            d(this.jXv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHZ() {
        Bitmap cHU = cHU();
        if (cHU != null) {
            b(this.jXv, cHU);
        } else {
            d(this.jXv);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.jXO != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("textShare");
            req.message = wXMediaMessage;
            req.scene = cIa();
            this.jXO.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jXO != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.hG().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("imageShare");
            req.message = wXMediaMessage;
            req.scene = cIa();
            this.jXO.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.jXO == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.dce == null || aVar.dce.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = F(aVar.dce.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = IG("imageShare");
        req.message = wXMediaMessage;
        req.scene = cIa();
        this.jXO.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.jXu == 2 || this.jXv.cHQ() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.jXO == null || aVar == null || aVar.dce == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = F(aVar.dce.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = IG("imageShare");
        req.message = wXMediaMessage;
        req.scene = cIa();
        this.jXO.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.cHN()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: b */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.jXv, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.jXv, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.jXv, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jXO != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cIa();
            this.jXO.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jXO != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.cHS() == 2 || shareEntity.cHS() == 4) {
                String cHR = shareEntity.cHR();
                if (aq.isEmpty(cHR)) {
                    cHR = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(cHR);
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.aAJ())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.jXO.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jXO != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = IG("videoShare");
            req.message = wXMediaMessage;
            req.scene = cIa();
            this.jXO.sendReq(req);
        }
    }

    private int cIa() {
        if (this.jXu == 3) {
            return 0;
        }
        if (this.jXu == 2) {
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
                    if (f.this.jXK != null) {
                        f.this.jXK.cE(f.this.jXu, 1);
                    }
                    f.this.cF(1, f.this.jXu);
                } else if (intExtra == -2) {
                    if (f.this.jXK != null) {
                        f.this.jXK.cE(f.this.jXu, 3);
                    }
                    f.this.cF(3, f.this.jXu);
                } else {
                    f.this.ba(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.jXK != null) {
                        f.this.jXK.cE(f.this.jXu, 2);
                    }
                    f.this.cF(2, f.this.jXu);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(int i, String str) {
        if (this.jXv != null && !StringUtils.isNull(this.jXv.aAJ())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.jXv.aAJ());
        }
    }

    public byte[] F(Bitmap bitmap) {
        try {
            Bitmap f = f(bitmap, 120);
            if (f == null) {
                f = cHU();
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

    public byte[] cIb() {
        try {
            Bitmap BW = BW(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BW.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return cIb();
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
                    return cIb();
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
