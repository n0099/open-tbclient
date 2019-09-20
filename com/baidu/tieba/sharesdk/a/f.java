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
    private int iXI;
    private ShareEntity iXJ;
    private final com.baidu.adp.lib.f.b<f.a> iXQ;
    private com.baidu.tieba.sharesdk.b.b iXU;
    private IWXAPI iXY;
    private b iXZ;
    private final a iYa;

    public f(Context context, int i) {
        super(context);
        this.iXQ = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i2) {
                super.onLoaded(aVar, str, i2);
                if (aVar == null || aVar.bWG == null || !f.this.b(f.this.iXJ, aVar)) {
                    f.this.iYa.onLoaded((com.baidu.adp.widget.ImageView.a) null, str, i2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                f.this.iYa.onCancelled(str);
            }
        };
        this.iYa = new a();
        this.context = context.getApplicationContext();
        this.iXI = i;
        this.iXY = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    private void cmV() {
        if (this.context != null) {
            this.iXZ = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.context.registerReceiver(this.iXZ, intentFilter);
        }
    }

    private void cmW() {
        if (this.context != null && this.iXZ != null) {
            this.context.unregisterReceiver(this.iXZ);
        }
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void t(BdUniqueId bdUniqueId) {
        super.t(bdUniqueId);
        cmV();
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void onDestroy() {
        cmW();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iXY == null) {
            Ax(2);
            if (bVar != null) {
                bVar.cs(0, 2);
                return;
            }
            return;
        }
        this.iXJ = shareEntity;
        this.iXU = bVar;
        this.iXI = shareEntity.cmQ();
        if (!this.iXY.isWXAppInstalled()) {
            if (this.iXU != null) {
                this.iXU.cs(this.iXI, 2);
            }
            BdToast.a(getAppContext(), getAppContext().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.ceL).agW();
            return;
        }
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.nK() != null) {
            b(this.iXJ, a2.nK());
        } else if (pO(shareEntity.cmP())) {
            EO(shareEntity.cmP());
        } else {
            String acZ = shareEntity.acZ();
            if (!TextUtils.isEmpty(acZ) && (acZ.startsWith("http://") || acZ.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                if (this.iXJ.cmR() != 0) {
                    com.baidu.adp.lib.f.c.iE().a(acZ, 34, this.iXQ, 0, 0, getPageId(), new Object[0]);
                } else {
                    com.baidu.adp.lib.f.c.iE().a(acZ, 10, this.iYa, 0, 0, getPageId(), new Object[0]);
                }
            } else if (w(shareEntity.getImageUri())) {
                EO(shareEntity.getImageUri().getPath());
            } else {
                cmX();
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
                f.this.cmX();
                return;
            }
            Bitmap nK = aVar.nK();
            if (!TextUtils.isEmpty(f.this.iXJ.getLinkUrl())) {
                if (f.this.iXI == 2) {
                    f.this.c(f.this.iXJ, nK);
                    return;
                }
                String tid = f.this.iXJ.getTid();
                if (!f.this.iXJ.cmc || StringUtils.isNull(tid) || tid.equals("0")) {
                    f.this.c(f.this.iXJ, nK);
                } else {
                    f.this.d(f.this.iXJ, nK);
                }
            } else if (!TextUtils.isEmpty(f.this.iXJ.getVideoUrl())) {
                f.this.e(f.this.iXJ, nK);
            } else if (TextUtils.isEmpty(f.this.iXJ.getContent())) {
                f.this.b(f.this.iXJ, nK);
            } else {
                f.this.cmX();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.iXU != null) {
                f.this.iXU.cs(f.this.iXI, 3);
            }
            f.this.Ax(3);
        }
    }

    private void EO(String str) {
        Bitmap EL = EL(str);
        if (EL == null) {
            EL = cmT();
        }
        if (EL != null) {
            b(this.iXJ, EL);
        } else {
            d(this.iXJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmX() {
        Bitmap cmT = cmT();
        if (cmT != null) {
            b(this.iXJ, cmT);
        } else {
            d(this.iXJ);
        }
    }

    private void d(ShareEntity shareEntity) {
        if (shareEntity != null && this.iXY != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = EP("textShare");
            req.message = wXMediaMessage;
            req.scene = cmY();
            this.iXY.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXY != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            wXImageObject.imageData = com.baidu.adp.lib.util.d.jJ().Bitmap2Bytes(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = G(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = EP("imageShare");
            req.message = wXMediaMessage;
            req.scene = cmY();
            this.iXY.sendReq(req);
        }
    }

    private boolean a(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.iXY == null || aVar == null || StringUtils.isNull(aVar.path) || aVar.bWG == null || aVar.bWG.nK() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(aVar.path);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = G(aVar.bWG.nK());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = EP("imageShare");
        req.message = wXMediaMessage;
        req.scene = cmY();
        this.iXY.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ShareEntity shareEntity, f.a aVar) {
        return (this.iXI == 2 || this.iXJ.cmR() == 1) ? a(shareEntity, aVar) : c(shareEntity, aVar);
    }

    private boolean c(ShareEntity shareEntity, f.a aVar) {
        if (shareEntity == null || this.iXY == null || aVar == null || aVar.bWG == null || StringUtils.isNull(aVar.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = aVar.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = G(aVar.bWG.nK());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = EP("imageShare");
        req.message = wXMediaMessage;
        req.scene = cmY();
        this.iXY.sendReq(req);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXY != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = G(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = EP("webpageShare");
            req.message = wXMediaMessage;
            req.scene = cmY();
            this.iXY.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXY != null) {
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
            if ("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg".equals(shareEntity.acZ())) {
                wXMediaMessage.thumbData = c(bitmap, true);
            } else {
                wXMediaMessage.thumbData = c(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = EP("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.iXY.sendReq(req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity != null && this.iXY != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = G(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = EP("videoShare");
            req.message = wXMediaMessage;
            req.scene = cmY();
            this.iXY.sendReq(req);
        }
    }

    private int cmY() {
        if (this.iXI == 3) {
            return 0;
        }
        if (this.iXI == 2) {
            return 1;
        }
        return -1;
    }

    private String EP(String str) {
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
                    if (f.this.iXU != null) {
                        f.this.iXU.cs(f.this.iXI, 1);
                    }
                    f.this.Ax(1);
                } else if (intExtra == -2) {
                    if (f.this.iXU != null) {
                        f.this.iXU.cs(f.this.iXI, 3);
                    }
                    f.this.Ax(3);
                } else {
                    f.this.aF(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.iXU != null) {
                        f.this.iXU.cs(f.this.iXI, 2);
                    }
                    f.this.Ax(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(int i, String str) {
        if (this.iXJ != null && !StringUtils.isNull(this.iXJ.acZ())) {
            com.baidu.tbadk.core.e.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.iXJ.acZ());
        }
    }

    public byte[] G(Bitmap bitmap) {
        try {
            Bitmap f = f(bitmap, 120);
            if (f == null) {
                f = cmT();
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

    public byte[] cmZ() {
        try {
            Bitmap Az = Az(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Az.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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
                return cmZ();
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
                return cmZ();
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
