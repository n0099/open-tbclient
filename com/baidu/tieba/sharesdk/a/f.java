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
import com.baidu.tbadk.core.util.as;
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
    private IWXAPI lBC;
    private b lBD;
    private final a lBE;
    private int lBi;
    private ShareEntity lBj;
    private final com.baidu.adp.lib.e.b<f.a> lBs;
    private com.baidu.tieba.sharesdk.b.b lBy;

    public f(Context context, int i) {
        super(context);
        this.lBs = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.ecR == null || !f.this.b(f.this.lBj, aVar)) {
                    f.this.lBE.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.lBE.onCancelled(str);
            }
        };
        this.lBE = new a();
        this.context = context.getApplicationContext();
        this.lBi = i;
        this.lBC = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void dhm() {
        if (this.context != null) {
            this.lBD = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.lBD, intentFilter);
        }
    }

    private void dhn() {
        if (this.context != null && this.lBD != null) {
            this.context.unregisterReceiver(this.lBD);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void z(BdUniqueId bdUniqueId) {
        super.z(bdUniqueId);
        dhm();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        dhn();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lBC == null) {
            cY(2, this.lBi);
            if (bVar != null) {
                bVar.cX(0, 2);
                return;
            }
            return;
        }
        this.lBj = shareEntity;
        this.lBy = bVar;
        this.lBi = shareEntity.dhd();
        if (!this.lBC.isWXAppInstalled()) {
            if (this.lBy != null) {
                this.lBy.cX(this.lBi, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.aho).aYR();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.lBj, a2.getRawBitmap());
        } else if (yV(shareEntity.dhc())) {
            Ni(shareEntity.dhc());
        } else {
            String aUh = shareEntity.aUh();
            if (!TextUtils.isEmpty(aUh) && (aUh.startsWith("http://") || aUh.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.lBj.dhe() != 0) {
                    com.baidu.adp.lib.e.c.ln().a(aUh, 34, this.lBs, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.ln().a(aUh, 10, this.lBE, 0, 0, getPageId(), new Object[0]);
                }
            } else if (t(shareEntity.getImageUri())) {
                Ni(shareEntity.getImageUri().getPath());
            } else {
                dho();
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
                f.this.dho();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.lBj.getLinkUrl())) {
                if (f.this.lBi == 2) {
                    f.this.c(f.this.lBj, rawBitmap);
                    return;
                }
                String tid = f.this.lBj.getTid();
                int dhh = f.this.lBj.dhh();
                if ((dhh == 2 || dhh == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.lBj.canShareBySmartApp) {
                    f.this.e(f.this.lBj, rawBitmap);
                } else {
                    f.this.c(f.this.lBj, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.lBj.getVideoUrl())) {
                f.this.f(f.this.lBj, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.lBj.getContent())) {
                f.this.b(f.this.lBj, rawBitmap);
            } else {
                f.this.dho();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.lBy != null) {
                f.this.lBy.cX(f.this.lBi, 3);
            }
            f.this.cY(3, f.this.lBi);
        }
    }

    private void Ni(String str) {
        Bitmap Nf = Nf(str);
        if (Nf == null) {
            Nf = dhj();
        }
        if (Nf != null) {
            b(this.lBj, Nf);
        } else {
            d(this.lBj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dho() {
        Bitmap dhj = dhj();
        if (dhj != null) {
            b(this.lBj, dhj);
        } else {
            d(this.lBj);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.lBC != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Nj("textShare");
            req.message = wXMediaMessage;
            req.scene = dhp();
            this.lBC.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lBC != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.mC().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Nj("imageShare");
            req.message = wXMediaMessage;
            req.scene = dhp();
            this.lBC.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.lBC == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.ecR == null || aVar.ecR.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(aVar.ecR.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Nj("imageShare");
        req.message = wXMediaMessage;
        req.scene = dhp();
        this.lBC.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.lBi == 2 || this.lBj.dhe() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.lBC == null || aVar == null || aVar.ecR == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = M(aVar.ecR.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Nj("imageShare");
        req.message = wXMediaMessage;
        req.scene = dhp();
        this.lBC.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.dhb()) {
            BdAsyncTask<Bitmap, Void, Bitmap> bdAsyncTask = new BdAsyncTask<Bitmap, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.f.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Bitmap... bitmapArr) {
                    if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                        return f.this.a(bitmapArr[0], f.this.lBj, false);
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap2) {
                    super.onPostExecute((AnonymousClass2) bitmap2);
                    f.this.d(f.this.lBj, bitmap2);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(bitmap);
            return;
        }
        d(this.lBj, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lBC != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Nj("webpageShare");
            req.message = wXMediaMessage;
            req.scene = dhp();
            this.lBC.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lBC != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.dhh() == 2 || shareEntity.dhh() == 4) {
                String dhg = shareEntity.dhg();
                if (as.isEmpty(dhg)) {
                    dhg = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(dhg);
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.aUh())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Nj("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.lBC.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.lBC != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Nj("videoShare");
            req.message = wXMediaMessage;
            req.scene = dhp();
            this.lBC.sendReq(req);
        }
    }

    private int dhp() {
        if (this.lBi == 3) {
            return 0;
        }
        if (this.lBi == 2) {
            return 1;
        }
        return -1;
    }

    private String Nj(String str) {
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
                    if (f.this.lBy != null) {
                        f.this.lBy.cX(f.this.lBi, 1);
                    }
                    f.this.cY(1, f.this.lBi);
                } else if (intExtra == -2) {
                    if (f.this.lBy != null) {
                        f.this.lBy.cX(f.this.lBi, 3);
                    }
                    f.this.cY(3, f.this.lBi);
                } else {
                    f.this.bA(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.lBy != null) {
                        f.this.lBy.cX(f.this.lBi, 2);
                    }
                    f.this.cY(2, f.this.lBi);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(int i, String str) {
        if (this.lBj != null && !StringUtils.isNull(this.lBj.aUh())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.lBj.aUh());
        }
    }

    public byte[] M(Bitmap bitmap) {
        try {
            Bitmap g = g(bitmap, 120);
            if (g == null) {
                g = dhj();
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

    public byte[] dhq() {
        try {
            Bitmap EG = EG(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            EG.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return dhq();
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
                    return dhq();
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
