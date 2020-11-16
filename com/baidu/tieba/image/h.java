package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class h implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private i hZg;
    private k hZh;
    private com.baidu.tbadk.core.dialog.g ijN;
    private MultiImageView kyz;
    private final ImageViewerActivity kzm;
    private a kzn;
    private com.baidu.tieba.ueg.c kzp;
    private com.baidu.tbadk.core.dialog.g kzq;
    private com.baidu.tbadk.core.dialog.g kzr;
    private com.baidu.tbadk.core.dialog.g kzs;
    private com.baidu.tbadk.core.dialog.g kzt;
    private com.baidu.tbadk.core.dialog.g kzu;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kzo = null;
    private List<com.baidu.tbadk.core.dialog.g> hZl = null;
    private CustomMessageListener kzv = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !h.this.kzm.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.mYR = null;
                if (!TextUtils.isEmpty(oVar.mYT) && !TextUtils.isEmpty(oVar.mYQ) && oVar.mYQ.equals(h.this.kzo)) {
                    h.this.kyz.setCurrentImageQRInfo(oVar.mYT);
                    h.this.Nb(oVar.mYT);
                }
            }
        }
    };
    private k.b kzw = new k.b() { // from class: com.baidu.tieba.image.h.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            h.this.kyz.rw(h.this.kzm.cNM());
            h.this.cnO();
        }
    };
    private k.b kzx = new k.b() { // from class: com.baidu.tieba.image.h.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            e.aN(h.this.kzm.getPageContext().getPageActivity(), h.this.kyz.getCurrentImageUrl());
            h.this.cnO();
            h.this.Eq(1);
        }
    };
    private k.b kzy = new k.b() { // from class: com.baidu.tieba.image.h.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = h.this.kyz.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            h.this.cnO();
            h.this.Eq(2);
        }
    };
    private k.b ijO = new k.b() { // from class: com.baidu.tieba.image.h.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = h.this.kzm.getPageContext().getPageActivity();
            if (h.this.mPermissionJudgement == null) {
                h.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            h.this.mPermissionJudgement.clearRequestPermissionList();
            h.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!h.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                h.this.saveImage();
                h.this.cnO();
                h.this.Eq(3);
            }
        }
    };
    private k.b kzz = new k.b() { // from class: com.baidu.tieba.image.h.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            h.this.bxc();
            h.this.cnO();
            h.this.Eq(4);
            h.this.cXn();
        }
    };
    private k.b kzA = new AnonymousClass8();

    public h(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kzm = imageViewerActivity;
        this.kzm.registerListener(this.kzv);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.kyz = multiImageView;
        if (this.hZg == null) {
            this.hZh = new k(this.kzm);
        }
        if (this.hZl == null) {
            this.hZl = new ArrayList();
        }
        cqT();
        this.hZg = new i(this.kzm.getPageContext(), this.hZh);
    }

    public void cqT() {
        this.hZl.clear();
        String rv = this.kyz.rv(this.kzm.cNM());
        if (rv != null) {
            this.kzq = new com.baidu.tbadk.core.dialog.g(rv, this.hZh);
            this.kzq.a(this.kzw);
            this.hZl.add(this.kzq);
        }
        this.ijN = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.hZh);
        this.ijN.a(this.ijO);
        this.hZl.add(this.ijN);
        if (this.kzm != null && !this.kzm.cXj()) {
            this.kzs = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.hZh);
            this.kzs.a(this.kzy);
            this.hZl.add(this.kzs);
        }
        this.kzr = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.hZh);
        this.kzr.a(this.kzx);
        this.hZl.add(this.kzr);
        String currentImageQRInfo = this.kyz.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kzu = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hZh);
            this.kzu.a(this.kzA);
            this.hZl.add(this.kzu);
        }
        this.kzt = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.hZh);
        this.kzt.a(this.kzz);
        this.hZl.add(this.kzt);
        this.hZh.a(new k.a() { // from class: com.baidu.tieba.image.h.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                h.this.cnO();
            }
        });
        this.hZh.br(this.hZl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kzm.getString(i);
    }

    public void cnO() {
        if (this.hZg != null && this.hZg.isShowing()) {
            this.hZg.dismiss();
        }
    }

    public void show() {
        if (this.hZg != null && !this.kzm.isFinishing()) {
            this.hZg.PA();
        }
    }

    /* renamed from: com.baidu.tieba.image.h$8  reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = h.this.kyz.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(h.this.kzm.getPageContext().getPageActivity(), h.this.getString(R.string.network_not_available));
                    return;
                }
                if (h.this.kzp != null && !h.this.kzp.isCancelled()) {
                    h.this.kzp.cancel();
                }
                h.this.kzp = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.h.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cXp() {
                        h.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cXq() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(h.this.kzm.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.AI(h.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.AJ(h.this.getString(R.string.qr_url_jump_external_message));
                        aVar.a(h.this.getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.image.h.8.1.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                                h.this.openUrl(currentImageQRInfo);
                            }
                        });
                        aVar.b(h.this.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.image.h.8.1.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.iW(false);
                        aVar.iX(false);
                        aVar.b(h.this.kzm.getPageContext()).bog();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cXr() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(h.this.kzm.getPageContext().getPageActivity());
                        aVar.AI(null);
                        aVar.setMessageShowCenter(true);
                        aVar.AJ(h.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(h.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.h.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.iW(false);
                        aVar.iX(false);
                        aVar.b(h.this.kzm.getPageContext()).bog();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(h.this.kzm.getPageContext().getPageActivity(), h.this.getString(R.string.qr_scan_error));
                    }
                });
                h.this.kzp.setPriority(3);
                h.this.kzp.execute(new String[0]);
                h.this.cnO();
                h.this.Eq(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kzm.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kzn = new a(this.kyz.getCurrentImageUrl(), this.kyz.getCurrentImageData());
            this.kzn.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kzm.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bxc() {
        UrlDragImageView currentUrlDragImageView;
        if (this.kyz != null && (currentUrlDragImageView = this.kyz.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kyz.getCurrentImageUrl();
                str2 = aw.getNameMd5FromUrl(str);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!au.isEmpty(str)) {
                shareItem.imageUri = Uri.parse(str);
                shareItem.shareType = 1;
                Bundle bundle = new Bundle();
                bundle.putString("path", TbConfig.IMAGE_CACHE_DIR_NAME);
                bundle.putString("name", str2);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.diskPicOperate = bundle;
            }
            shareItem.isFromImageViewer = true;
            shareItem.fge = 14;
            this.kzm.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.kzm, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bxb() {
        Activity pageActivity = this.kzm.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            saveImage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private byte[] mData;
        private String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            ImageUrlData imageUrlData;
            String nameMd5FromUrl;
            Map<String, ImageUrlData> cXa = h.this.kzm.cXa();
            if (this.mUrl != null && cXa != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cXa.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        imageUrlData = null;
                        break;
                    }
                    Map.Entry<String, ImageUrlData> next = it.next();
                    if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.mUrl)) {
                        imageUrlData = next.getValue();
                        break;
                    }
                }
                if (imageUrlData != null) {
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + at.bqz().Bt(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, h.this.kzm.getPageContext().getPageActivity()) == 0) {
                        return h.this.kzm.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, h.this.kzm.getPageContext().getPageActivity())) {
                    case -2:
                        return n.getSdErrorString();
                    case 0:
                        return h.this.getString(R.string.save_image_to_album);
                }
            }
            return h.this.getString(R.string.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            h.this.kzm.showToast(str);
            h.this.kzn = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            h.this.kzn = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq(int i) {
        TiebaStatic.log(new ar("c13270").dR("uid", this.kzm.getUserId()).ak("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXn() {
    }

    public void Nb(String str) {
        int i;
        boolean z = false;
        if (this.hZg != null && !this.kzm.isFinishing() && this.hZg.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kzu = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hZh);
            this.kzu.a(this.kzA);
            int i2 = 0;
            while (true) {
                if (i2 < this.hZl.size()) {
                    if (this.kzr == null || this.hZl.get(i2) != this.kzr || (i = i2 + 1) > this.hZl.size()) {
                        i2++;
                    } else {
                        this.hZl.add(i, this.kzu);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.hZl.add(this.kzu);
            }
            this.hZh.br(this.hZl);
        }
    }

    public void da(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.mYR = imageBitmap;
                String currentImageUrl = this.kyz.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.mYQ = String.valueOf(System.currentTimeMillis()) + aw.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.mYQ = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kzo = oVar.mYQ;
                this.kzm.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cXo() {
        this.kzo = null;
    }

    public void release() {
        if (this.kzn != null) {
            this.kzn.cancel();
            this.kzn = null;
        }
        if (this.kzp != null) {
            this.kzp.cancel();
            this.kzp = null;
        }
    }

    public void onChangeSkinType() {
        if (this.hZh != null) {
            this.hZh.onChangeSkinType();
        }
    }
}
