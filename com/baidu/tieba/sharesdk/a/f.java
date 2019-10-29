package com.baidu.tieba.sharesdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.e.f;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
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
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.sharesdk.a.a {
    private final com.baidu.adp.lib.f.b<f.a> iXF;
    private com.baidu.tieba.sharesdk.b.b iXJ;
    private IWXAPI iXN;
    private b iXO;
    private final a iXP;
    private int iXx;
    private ShareEntity iXy;

    public f(Context context, int i) {
        super(context);
        this.iXF = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.clJ == null || !f.this.b(f.this.iXy, aVar)) {
                    f.this.iXP.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.iXP.onCancelled(str);
            }
        };
        this.iXP = new a();
        this.context = context.getApplicationContext();
        this.iXx = i;
        this.iXN = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void ckK() {
        if (this.context != null) {
            this.iXO = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.iXO, intentFilter);
        }
    }

    private void ckL() {
        if (this.context != null && this.iXO != null) {
            this.context.unregisterReceiver(this.iXO);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void u(BdUniqueId bdUniqueId) {
        super.u(bdUniqueId);
        ckK();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        ckL();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iXN == null) {
            zf(2);
            if (bVar != null) {
                bVar.cl(0, 2);
                return;
            }
            return;
        }
        this.iXy = shareEntity;
        this.iXJ = bVar;
        this.iXx = shareEntity.ckF();
        if (!this.iXN.isWXAppInstalled()) {
            if (this.iXJ != null) {
                this.iXJ.cl(this.iXx, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.csX).akT();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            b(this.iXy, a2.getRawBitmap());
        } else if (oY(shareEntity.ckE())) {
            Dt(shareEntity.ckE());
        } else {
            String ahf = shareEntity.ahf();
            if (!TextUtils.isEmpty(ahf) && (ahf.startsWith("http://") || ahf.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.iXy.ckG() != 0) {
                    com.baidu.adp.lib.f.c.fT().a(ahf, 34, this.iXF, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.fT().a(ahf, 10, this.iXP, 0, 0, getPageId(), new Object[0]);
                }
            } else if (t(shareEntity.getImageUri())) {
                Dt(shareEntity.getImageUri().getPath());
            } else {
                ckM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                f.this.ckM();
                return;
            }
            Bitmap rawBitmap = aVar.getRawBitmap();
            if (!TextUtils.isEmpty(f.this.iXy.getLinkUrl())) {
                if (f.this.iXx == 2) {
                    f.this.c(f.this.iXy, rawBitmap);
                    return;
                }
                String tid = f.this.iXy.getTid();
                if (!f.this.iXy.czc || StringUtils.isNull(tid) || tid.equals("0")) {
                    f.this.c(f.this.iXy, rawBitmap);
                } else {
                    f.this.d(f.this.iXy, rawBitmap);
                }
            } else if (!TextUtils.isEmpty(f.this.iXy.getVideoUrl())) {
                f.this.e(f.this.iXy, rawBitmap);
            } else if (TextUtils.isEmpty(f.this.iXy.getContent())) {
                f.this.b(f.this.iXy, rawBitmap);
            } else {
                f.this.ckM();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.iXJ != null) {
                f.this.iXJ.cl(f.this.iXx, 3);
            }
            f.this.zf(3);
        }
    }

    private void Dt(String str) {
        Bitmap Dq = Dq(str);
        if (Dq == null) {
            Dq = ckI();
        }
        if (Dq != null) {
            b(this.iXy, Dq);
        } else {
            d(this.iXy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckM() {
        Bitmap ckI = ckI();
        if (ckI != null) {
            b(this.iXy, ckI);
        } else {
            d(this.iXy);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.iXN != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Du("textShare");
            req.message = wXMediaMessage;
            req.scene = ckN();
            this.iXN.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXN != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.gW().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = E(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Du("imageShare");
            req.message = wXMediaMessage;
            req.scene = ckN();
            this.iXN.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.iXN == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.clJ == null || aVar.clJ.getRawBitmap() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = E(aVar.clJ.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Du("imageShare");
        req.message = wXMediaMessage;
        req.scene = ckN();
        this.iXN.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.iXx == 2 || this.iXy.ckG() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.iXN == null || aVar == null || aVar.clJ == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = E(aVar.clJ.getRawBitmap());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Du("imageShare");
        req.message = wXMediaMessage;
        req.scene = ckN();
        this.iXN.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXN != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = E(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Du("webpageShare");
            req.message = wXMediaMessage;
            req.scene = ckN();
            this.iXN.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXN != null) {
            String tid = shareEntity.getTid();
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            wXMiniProgramObject.path = "/pages/pb/pb?tid=" + tid;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
            String title = shareEntity.getTitle();
            if (StringUtils.isNull(title)) {
                title = shareEntity.getContent();
            }
            wXMediaMessage.title = title;
            wXMediaMessage.description = shareEntity.getContent();
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.ahf())) {
                wXMediaMessage.thumbData = b(bitmap, true);
            } else {
                wXMediaMessage.thumbData = b(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Du("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.iXN.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXN != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = E(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Du("videoShare");
            req.message = wXMediaMessage;
            req.scene = ckN();
            this.iXN.sendReq(req);
        }
    }

    private int ckN() {
        if (this.iXx == 3) {
            return 0;
        }
        if (this.iXx == 2) {
            return 1;
        }
        return -1;
    }

    private String Du(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.iXJ != null) {
                        f.this.iXJ.cl(f.this.iXx, 1);
                    }
                    f.this.zf(1);
                } else if (intExtra == -2) {
                    if (f.this.iXJ != null) {
                        f.this.iXJ.cl(f.this.iXx, 3);
                    }
                    f.this.zf(3);
                } else {
                    f.this.aG(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.iXJ != null) {
                        f.this.iXJ.cl(f.this.iXx, 2);
                    }
                    f.this.zf(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, String str) {
        if (this.iXy != null && !StringUtils.isNull(this.iXy.ahf())) {
            com.baidu.tbadk.core.e.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.iXy.ahf());
        }
    }

    public byte[] E(Bitmap bitmap) {
        try {
            Bitmap e = e(bitmap, 120);
            if (e == null) {
                e = ckI();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            e.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] ckO() {
        try {
            Bitmap zh = zh(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zh.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return ckO();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            double length = byteArray.length / 1024;
            if (length <= 125.0d) {
                Log.i("fengguanghui<120:", "width:" + width + "|height" + height + "|size:" + length);
                return byteArray;
            }
            Log.i("fengguanghui_original:", "width:" + width + "|height" + height + "|size:" + length);
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
                double length2 = byteArray2.length / 1024;
                Log.i("fengguanghui>120:", "width:" + width + "|height" + intValue + "|size:" + length2);
                byteArray = byteArray2;
                height = intValue;
                length = length2;
            }
            byteArrayOutputStream.close();
            if (bitmap == null) {
                return ckO();
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
