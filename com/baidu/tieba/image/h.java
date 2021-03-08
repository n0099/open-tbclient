package com.baidu.tieba.image;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes7.dex */
public class h {
    private ImageViewerActivity kXG;
    private a kXH;
    private View.OnClickListener kXI;
    private final int fYe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
    private final int kXJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    private Runnable hht = new Runnable() { // from class: com.baidu.tieba.image.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.kXH != null) {
                h.this.kXH.dismiss();
            }
        }
    };

    public h(ImageViewerActivity imageViewerActivity) {
        this.kXG = imageViewerActivity;
        this.kXH = new a(imageViewerActivity);
    }

    public void a(MultiImageView multiImageView, int i, View.OnClickListener onClickListener) {
        ImageUrlData imageUrlData;
        if (this.kXH != null && multiImageView != null) {
            if (!this.kXH.isShowing()) {
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.kXH, multiImageView, 81, 0, com.baidu.adp.lib.util.a.getNavigationBarHeight(this.kXG) + this.fYe + i);
                String str = "";
                String str2 = "";
                String str3 = "";
                int i2 = 5;
                UrlDragImageView currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView();
                if (currentUrlDragImageView != null && (imageUrlData = currentUrlDragImageView.getmAssistUrlData()) != null) {
                    str = imageUrlData.threadId + "";
                    str2 = imageUrlData.forumId + "";
                    str3 = imageUrlData.postId + "";
                    i2 = ND(imageUrlData.from);
                }
                TiebaStatic.log(new ar("c14045").dR("post_id", str3).dR("tid", str).dR("fid", str2).aq("obj_source", i2));
            }
            this.kXH.j(multiImageView);
            this.kXI = onClickListener;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.hht);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.hht, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ND(String str) {
        if ("index".equals(str)) {
            return 1;
        }
        if (ImageViewerConfig.FROM_CONCERN.equals(str)) {
            return 2;
        }
        if ("hot_topic".equals(str)) {
            return 3;
        }
        if ("frs".equals(str)) {
            return 4;
        }
        return 5;
    }

    public void onDestroy() {
        if (this.kXH != null) {
            this.kXH.onDestroy();
        }
        this.kXG = null;
        this.kXI = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends PopupWindow implements View.OnClickListener {
        private Activity activity;
        private View contentView;
        private EMTextView eXl;
        private MultiImageView kWX;
        private ImageView kXL;
        private ImageView kXM;
        private ImageView kXN;
        private ImageView kXO;
        private ImageView kXP;
        private com.baidu.tbadk.coreExtra.share.g kXQ;

        public a(Activity activity) {
            super(activity);
            this.activity = activity;
            this.kXQ = new com.baidu.tbadk.coreExtra.share.g(activity, null);
            setWidth(l.getEquipmentWidth(activity) - (h.this.kXJ * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            Zo();
            onChangeSkinType();
        }

        private void Zo() {
            this.contentView = LayoutInflater.from(this.activity).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
            this.eXl = (EMTextView) this.contentView.findViewById(R.id.title);
            this.kXL = (ImageView) this.contentView.findViewById(R.id.qq_friend);
            this.kXL.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qq40_svg));
            this.kXL.setOnClickListener(this);
            this.kXM = (ImageView) this.contentView.findViewById(R.id.qq_zone);
            this.kXM.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
            this.kXM.setOnClickListener(this);
            this.kXN = (ImageView) this.contentView.findViewById(R.id.wechat_friend);
            this.kXN.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
            this.kXN.setOnClickListener(this);
            this.kXO = (ImageView) this.contentView.findViewById(R.id.wechat_timeline);
            this.kXO.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_circle40_svg));
            this.kXO.setOnClickListener(this);
            this.kXP = (ImageView) this.contentView.findViewById(R.id.wechat_emotion);
            this.kXP.setImageDrawable(this.activity.getDrawable(R.drawable.icon_share_wechatexpression));
            this.kXP.setOnClickListener(this);
            setContentView(this.contentView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem daB = daB();
            if (daB != null) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (view == this.kXL) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(daB) && daB.getCommandChannelArray() != null && daB.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(daB, this.activity, 8, null);
                            return;
                        } else {
                            this.kXQ.g(daB);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bqF();
                } else if (view == this.kXM) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(daB) && daB.getCommandChannelArray() != null && daB.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(daB, this.activity, 4, null);
                            return;
                        } else {
                            this.kXQ.h(daB);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bqF();
                } else if (view == this.kXN) {
                    if (l(daB) && daB.getCommandChannelArray() != null && daB.getCommandChannelArray().contains(3)) {
                        com.baidu.tbadk.coreExtra.share.a.a(daB, this.activity, 3, null);
                    } else if (daB.fwK != 1) {
                        this.kXQ.e(daB);
                    }
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aq("obj_source", 22).dR("tid", daB.tid).dR("fid", daB.fid));
                } else if (view == this.kXO) {
                    if (l(daB) && daB.getCommandChannelArray() != null && daB.getCommandChannelArray().contains(2)) {
                        com.baidu.tbadk.coreExtra.share.a.a(daB, this.activity, 2, null);
                    } else if (daB.fwK != 1) {
                        if (daB.fwf) {
                            daB.content = "【" + daB.title + "】 " + daB.content;
                        }
                        this.kXQ.f(daB);
                    }
                } else if (view == this.kXP && h.this.kXI != null) {
                    h.this.kXI.onClick(view);
                }
            }
        }

        public void j(MultiImageView multiImageView) {
            this.kWX = multiImageView;
        }

        private ShareItem daB() {
            UrlDragImageView currentUrlDragImageView;
            if (this.kWX == null || (currentUrlDragImageView = this.kWX.getCurrentUrlDragImageView()) == null) {
                return null;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kWX.getCurrentImageUrl();
                str2 = aw.getNameMd5FromUrl(str);
            }
            ShareItem shareItem = new ShareItem();
            int i = 5;
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
                shareItem.tid = j + "";
                shareItem.fid = imageUrlData.forumId;
                i = h.this.ND(imageUrlData.from);
            }
            if (!au.isEmpty(str)) {
                shareItem.imageUri = Uri.parse(str);
                shareItem.shareType = 2;
                Bundle bundle = new Bundle();
                bundle.putString("path", TbConfig.IMAGE_CACHE_DIR_NAME);
                bundle.putString("name", str2);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.diskPicOperate = bundle;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("tid", shareItem.tid);
            bundle2.putString("fid", shareItem.fid);
            bundle2.putString("uid", TbadkCoreApplication.getCurrentAccount());
            bundle2.putInt("obj_source", i);
            bundle2.putInt("obj_locate", 12);
            shareItem.ae(bundle2);
            return shareItem;
        }

        private boolean l(ShareItem shareItem) {
            return (TextUtils.isEmpty(shareItem.fwR) || TextUtils.isEmpty(shareItem.fwS)) ? false : true;
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.eXl, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.contentView).oh(R.string.J_X06).setBackGroundColor(R.color.CAM_X0204);
        }

        public void onDestroy() {
            this.kWX = null;
            this.activity = null;
            this.kXQ = null;
        }
    }
}
