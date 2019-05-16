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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.d.f;
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
    private int iNL;
    private ShareEntity iNM;
    private final com.baidu.adp.lib.f.b<f.a> iNT;
    private com.baidu.tieba.sharesdk.b.b iNX;
    private IWXAPI iOb;
    private b iOc;
    private final a iOd;

    public f(Context context, int i) {
        super(context);
        this.iNT = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.bUH == null || !f.this.b(f.this.iNM, aVar)) {
                    f.this.iOd.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.iOd.onCancelled(str);
            }
        };
        this.iOd = new a();
        this.context = context.getApplicationContext();
        this.iNL = i;
        this.iOb = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void ciX() {
        if (this.context != null) {
            this.iOc = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.iOc, intentFilter);
        }
    }

    private void ciY() {
        if (this.context != null && this.iOc != null) {
            this.context.unregisterReceiver(this.iOc);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void t(BdUniqueId bdUniqueId) {
        super.t(bdUniqueId);
        ciX();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        ciY();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iOb == null) {
            zM(2);
            if (bVar != null) {
                bVar.cm(0, 2);
                return;
            }
            return;
        }
        this.iNM = shareEntity;
        this.iNX = bVar;
        this.iNL = shareEntity.ciS();
        if (!this.iOb.isWXAppInstalled()) {
            if (this.iNX != null) {
                this.iNX.cm(this.iNL, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.ccI).afO();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.ns() != null) {
            b(this.iNM, a2.ns());
        } else if (pn(shareEntity.ciR())) {
            Dy(shareEntity.ciR());
        } else {
            String abS = shareEntity.abS();
            if (!TextUtils.isEmpty(abS) && (abS.startsWith("http://") || abS.startsWith("https://"))) {
                if (this.iNM.ciT() != 0) {
                    com.baidu.adp.lib.f.c.iv().a(abS, 34, this.iNT, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.iv().a(abS, 10, this.iOd, 0, 0, getPageId(), new Object[0]);
                }
            } else if (w(shareEntity.getImageUri())) {
                Dy(shareEntity.getImageUri().getPath());
            } else {
                ciZ();
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
                f.this.ciZ();
                return;
            }
            Bitmap ns = aVar.ns();
            if (!TextUtils.isEmpty(f.this.iNM.getLinkUrl())) {
                if (f.this.iNL == 2) {
                    f.this.c(f.this.iNM, ns);
                    return;
                }
                String tid = f.this.iNM.getTid();
                if (StringUtils.isNull(tid) || tid.equals("0")) {
                    f.this.c(f.this.iNM, ns);
                } else {
                    f.this.d(f.this.iNM, ns);
                }
            } else if (!TextUtils.isEmpty(f.this.iNM.getVideoUrl())) {
                f.this.e(f.this.iNM, ns);
            } else if (TextUtils.isEmpty(f.this.iNM.getContent())) {
                f.this.b(f.this.iNM, ns);
            } else {
                f.this.ciZ();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.iNX != null) {
                f.this.iNX.cm(f.this.iNL, 3);
            }
            f.this.zM(3);
        }
    }

    private void Dy(String str) {
        Bitmap Dv = Dv(str);
        if (Dv == null) {
            Dv = ciV();
        }
        if (Dv != null) {
            b(this.iNM, Dv);
        } else {
            d(this.iNM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciZ() {
        Bitmap ciV = ciV();
        if (ciV != null) {
            b(this.iNM, ciV);
        } else {
            d(this.iNM);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.iOb != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Dz("textShare");
            req.message = wXMediaMessage;
            req.scene = cja();
            this.iOb.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iOb != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.jA().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = G(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Dz("imageShare");
            req.message = wXMediaMessage;
            req.scene = cja();
            this.iOb.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.iOb == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.bUH == null || aVar.bUH.ns() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = G(aVar.bUH.ns());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Dz("imageShare");
        req.message = wXMediaMessage;
        req.scene = cja();
        this.iOb.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.iNL == 2 || this.iNM.ciT() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.iOb == null || aVar == null || aVar.bUH == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = G(aVar.bUH.ns());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = Dz("imageShare");
        req.message = wXMediaMessage;
        req.scene = cja();
        this.iOb.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iOb != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = G(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Dz("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cja();
            this.iOb.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iOb != null) {
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.abS())) {
                wXMediaMessage.thumbData = c(bitmap, true);
            } else {
                wXMediaMessage.thumbData = c(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Dz("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.iOb.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iOb != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = G(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = Dz("videoShare");
            req.message = wXMediaMessage;
            req.scene = cja();
            this.iOb.sendReq(req);
        }
    }

    private int cja() {
        if (this.iNL == 3) {
            return 0;
        }
        if (this.iNL == 2) {
            return 1;
        }
        return -1;
    }

    private String Dz(String str) {
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
                    if (f.this.iNX != null) {
                        f.this.iNX.cm(f.this.iNL, 1);
                    }
                    f.this.zM(1);
                } else if (intExtra == -2) {
                    if (f.this.iNX != null) {
                        f.this.iNX.cm(f.this.iNL, 3);
                    }
                    f.this.zM(3);
                } else {
                    f.this.aF(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.iNX != null) {
                        f.this.iNX.cm(f.this.iNL, 2);
                    }
                    f.this.zM(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(int i, String str) {
        if (this.iNM != null && !StringUtils.isNull(this.iNM.abS())) {
            com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.iNM.abS());
        }
    }

    public byte[] G(Bitmap bitmap) {
        try {
            Bitmap f = f(bitmap, 120);
            if (f == null) {
                f = ciV();
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

    public byte[] cjb() {
        try {
            Bitmap zO = zO(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zO.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] c(Bitmap bitmap, boolean z) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (z || bitmap == null) {
                return cjb();
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
                return cjb();
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
