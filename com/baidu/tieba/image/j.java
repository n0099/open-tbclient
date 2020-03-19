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
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.n;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class j {
    private com.baidu.tbadk.core.dialog.i fLk;
    private k fLl;
    private com.baidu.tbadk.core.dialog.g fVs;
    private MultiImageView hTG;
    private final ImageViewerActivity hUq;
    private a hUr;
    private com.baidu.tieba.ueg.c hUt;
    private com.baidu.tbadk.core.dialog.g hUu;
    private com.baidu.tbadk.core.dialog.g hUv;
    private com.baidu.tbadk.core.dialog.g hUw;
    private com.baidu.tbadk.core.dialog.g hUx;
    private com.baidu.tbadk.core.dialog.g hUy;
    private PermissionJudgePolicy mPermissionJudgement;
    private String hUs = null;
    private List<com.baidu.tbadk.core.dialog.g> fLp = null;
    private CustomMessageListener hUz = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.hUq.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.kjq = null;
                if (!TextUtils.isEmpty(nVar.kjs) && !TextUtils.isEmpty(nVar.kjp) && nVar.kjp.equals(j.this.hUs)) {
                    j.this.hTG.setCurrentImageQRInfo(nVar.kjs);
                    j.this.DS(nVar.kjs);
                }
            }
        }
    };
    private k.b hUA = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.hTG.mf(j.this.hUq.bRU());
            j.this.bvh();
        }
    };
    private k.b hUB = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aW(j.this.hUq.getPageContext().getPageActivity(), j.this.hTG.getCurrentImageUrl());
            j.this.bvh();
            j.this.xr(1);
        }
    };
    private k.b hUC = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.hTG.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bvh();
            j.this.xr(2);
        }
    };
    private k.b fVt = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.hUq.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bvh();
                j.this.xr(3);
            }
        }
    };
    private k.b hUD = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.hTG != null && (currentUrlDragImageView = j.this.hTG.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.hTG.getCurrentImageUrl();
                    str2 = as.getNameMd5FromUrl(str);
                }
                ShareItem shareItem = new ShareItem();
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                    }
                }
                if (!aq.isEmpty(str)) {
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
                shareItem.dqw = true;
                shareItem.dqE = 14;
                j.this.hUq.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.hUq, shareItem, false)));
                j.this.bvh();
                j.this.xr(4);
            }
        }
    };
    private k.b hUE = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.hUq = imageViewerActivity;
        this.hUq.registerListener(this.hUz);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.hTG = multiImageView;
        if (this.fLk == null) {
            this.fLl = new k(this.hUq);
        }
        if (this.fLp == null) {
            this.fLp = new ArrayList();
        }
        byk();
        this.fLk = new com.baidu.tbadk.core.dialog.i(this.hUq.getPageContext(), this.fLl);
    }

    public void byk() {
        this.fLp.clear();
        String me = this.hTG.me(this.hUq.bRU());
        if (me != null) {
            this.hUu = new com.baidu.tbadk.core.dialog.g(me, this.fLl);
            this.hUu.a(this.hUA);
            this.fLp.add(this.hUu);
        }
        this.fVs = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.fLl);
        this.fVs.a(this.fVt);
        this.fLp.add(this.fVs);
        if (this.hUq != null && !this.hUq.cbb()) {
            this.hUw = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.fLl);
            this.hUw.a(this.hUC);
            this.fLp.add(this.hUw);
        }
        this.hUv = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.fLl);
        this.hUv.a(this.hUB);
        this.fLp.add(this.hUv);
        String currentImageQRInfo = this.hTG.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.hUy = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fLl);
            this.hUy.a(this.hUE);
            this.fLp.add(this.hUy);
        }
        this.hUx = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.fLl);
        this.hUx.a(this.hUD);
        this.fLp.add(this.hUx);
        this.fLl.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bvh();
            }
        });
        this.fLl.az(this.fLp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.hUq.getString(i);
    }

    public void bvh() {
        if (this.fLk != null && this.fLk.isShowing()) {
            this.fLk.dismiss();
        }
    }

    public void show() {
        if (this.fLk != null && !this.hUq.isFinishing()) {
            this.fLk.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.hTG.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.hUq.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.hUt != null && !j.this.hUt.isCancelled()) {
                    j.this.hUt.cancel();
                }
                j.this.hUt = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cbg() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cbh() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hUq.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.sR(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.sS(j.this.getString(R.string.qr_url_jump_external_message));
                        aVar.a(j.this.getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.image.j.8.1.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                                j.this.openUrl(currentImageQRInfo);
                            }
                        });
                        aVar.b(j.this.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.image.j.8.1.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.fH(false);
                        aVar.fI(false);
                        aVar.b(j.this.hUq.getPageContext()).aEG();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cbi() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hUq.getPageContext().getPageActivity());
                        aVar.sR(null);
                        aVar.setMessageShowCenter(true);
                        aVar.sS(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.fH(false);
                        aVar.fI(false);
                        aVar.b(j.this.hUq.getPageContext()).aEG();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.hUq.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.hUt.setPriority(3);
                j.this.hUt.execute(new String[0]);
                j.this.bvh();
                j.this.xr(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.hUq.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.hUr = new a(this.hTG.getCurrentImageUrl(), this.hTG.getCurrentImageData());
            this.hUr.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.hUq.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            Map<String, ImageUrlData> caT = j.this.hUq.caT();
            if (this.mUrl != null && caT != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = caT.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aGE().tw(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.hUq.getPageContext().getPageActivity()) == 0) {
                        return j.this.hUq.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.hUq.getPageContext().getPageActivity())) {
                    case -2:
                        return m.getSdErrorString();
                    case 0:
                        return j.this.getString(R.string.save_image_to_album);
                }
            }
            return j.this.getString(R.string.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            j.this.hUq.showToast(str);
            j.this.hUr = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.hUr = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        TiebaStatic.log(new an("c13270").cx("uid", this.hUq.getUserId()).X("obj_type", i));
    }

    public void DS(String str) {
        int i;
        boolean z = false;
        if (this.fLk != null && !this.hUq.isFinishing() && this.fLk.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.hUy = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fLl);
            this.hUy.a(this.hUE);
            int i2 = 0;
            while (true) {
                if (i2 < this.fLp.size()) {
                    if (this.hUv == null || this.fLp.get(i2) != this.hUv || (i = i2 + 1) > this.fLp.size()) {
                        i2++;
                    } else {
                        this.fLp.add(i, this.hUy);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.fLp.add(this.hUy);
            }
            this.fLl.az(this.fLp);
        }
    }

    public void ch(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.kjq = imageBitmap;
                String currentImageUrl = this.hTG.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.kjp = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.kjp = String.valueOf(BdUniqueId.gen().getId());
                }
                this.hUs = nVar.kjp;
                this.hUq.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void cbf() {
        this.hUs = null;
    }

    public void release() {
        if (this.hUr != null) {
            this.hUr.cancel();
            this.hUr = null;
        }
        if (this.hUt != null) {
            this.hUt.cancel();
            this.hUt = null;
        }
    }
}
