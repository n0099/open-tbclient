package com.baidu.tieba.sharesdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.d.f;
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
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private int jUE;
    private ShareEntity jUF;
    private final com.baidu.adp.lib.e.b<f.a> jUL;
    private com.baidu.tieba.sharesdk.b.b jUP;
    private IWXAPI jUT;
    private b jUU;
    private final a jUV;

    public f(Context context, int i) {
        super(context);
        this.jUL = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.cXA == null || !f.this.b(f.this.jUF, aVar)) {
                    f.this.jUV.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.jUV.onCancelled(str);
            }
        };
        this.jUV = new a();
        this.context = context.getApplicationContext();
        this.jUE = i;
        this.jUT = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void cFU() {
        if (this.context != null) {
            this.jUU = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.jUU, intentFilter);
        }
    }

    private void cFV() {
        if (this.context != null && this.jUU != null) {
            this.context.unregisterReceiver(this.jUU);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void v(BdUniqueId bdUniqueId) {
        super.v(bdUniqueId);
        cFU();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        cFV();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jUT == null) {
            BF(2);
            if (bVar != null) {
                bVar.cC(0, 2);
                return;
            }
            return;
        }
        this.jUF = shareEntity;
        this.jUP = bVar;
        this.jUE = shareEntity.cFN();
        if (!this.jUT.isWXAppInstalled()) {
            if (this.jUP != null) {
                this.jUP.cC(this.jUE, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.MH).aCu();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.jUF, a2.getRawBitmap());
        } else if (uh(shareEntity.cFM())) {
            Iq(shareEntity.cFM());
        } else {
            String ayq = shareEntity.ayq();
            if (!TextUtils.isEmpty(ayq) && (ayq.startsWith("http://") || ayq.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.jUF.cFO() != 0) {
                    com.baidu.adp.lib.e.c.gr().a(ayq, 34, this.jUL, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.e.c.gr().a(ayq, 10, this.jUV, 0, 0, getPageId(), new Object[0]);
                }
            } else if (v(shareEntity.getImageUri())) {
                Iq(shareEntity.getImageUri().getPath());
            } else {
                cFW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class a extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.cFW();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.jUF.getLinkUrl())) {
                if (f.this.jUE == 2) {
                    f.this.c(f.this.jUF, rawBitmap);
                    return;
                }
                String tid = f.this.jUF.getTid();
                int cFQ = f.this.jUF.cFQ();
                if ((cFQ == 2 || cFQ == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && f.this.jUF.canShareBySmartApp) {
                    f.this.d(f.this.jUF, rawBitmap);
                } else {
                    f.this.c(f.this.jUF, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.jUF.getVideoUrl())) {
                f.this.e(f.this.jUF, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.jUF.getContent())) {
                f.this.b(f.this.jUF, rawBitmap);
            } else {
                f.this.cFW();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.jUP != null) {
                f.this.jUP.cC(f.this.jUE, 3);
            }
            f.this.BF(3);
        }
    }

    private void Iq(String str) {
        Bitmap In = In(str);
        if (In == null) {
            In = cFS();
        }
        if (In != null) {
            b(this.jUF, In);
        } else {
            d(this.jUF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFW() {
        Bitmap cFS = cFS();
        if (cFS != null) {
            b(this.jUF, cFS);
        } else {
            d(this.jUF);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.jUT != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ir("textShare");
            req.message = wXMediaMessage;
            req.scene = cFX();
            this.jUT.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jUT != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.hs().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ir("imageShare");
            req.message = wXMediaMessage;
            req.scene = cFX();
            this.jUT.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.jUT == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.cXA == null || aVar.cXA.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = F(aVar.cXA.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Ir("imageShare");
        req.message = wXMediaMessage;
        req.scene = cFX();
        this.jUT.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.jUE == 2 || this.jUF.cFO() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.jUT == null || aVar == null || aVar.cXA == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = F(aVar.cXA.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Ir("imageShare");
        req.message = wXMediaMessage;
        req.scene = cFX();
        this.jUT.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jUT != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ir("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cFX();
            this.jUT.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jUT != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.cFQ() == 2 || shareEntity.cFQ() == 4) {
                String cFP = shareEntity.cFP();
                if (aq.isEmpty(cFP)) {
                    cFP = "";
                }
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + URLEncoder.encode(cFP);
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.ayq())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ir("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.jUT.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.jUT != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = F(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Ir("videoShare");
            req.message = wXMediaMessage;
            req.scene = cFX();
            this.jUT.sendReq(req);
        }
    }

    private int cFX() {
        if (this.jUE == 3) {
            return 0;
        }
        if (this.jUE == 2) {
            return 1;
        }
        return -1;
    }

    private String Ir(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.jUP != null) {
                        f.this.jUP.cC(f.this.jUE, 1);
                    }
                    f.this.BF(1);
                } else if (intExtra == -2) {
                    if (f.this.jUP != null) {
                        f.this.jUP.cC(f.this.jUE, 3);
                    }
                    f.this.BF(3);
                } else {
                    f.this.bb(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.jUP != null) {
                        f.this.jUP.cC(f.this.jUE, 2);
                    }
                    f.this.BF(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i, String str) {
        if (this.jUF != null && !StringUtils.isNull(this.jUF.ayq())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + ETAG.ITEM_SEPARATOR + this.jUF.ayq());
        }
    }

    public byte[] F(Bitmap bitmap) {
        try {
            Bitmap f = f(bitmap, 120);
            if (f == null) {
                f = cFS();
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

    public byte[] cFY() {
        try {
            Bitmap BH = BH(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BH.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return cFY();
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
                    return cFY();
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
