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
/* loaded from: classes8.dex */
public class h {
    private ImageViewerActivity kVE;
    private a kVF;
    private View.OnClickListener kVG;
    private final int fWE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
    private final int kVH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    private Runnable hfK = new Runnable() { // from class: com.baidu.tieba.image.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.kVF != null) {
                h.this.kVF.dismiss();
            }
        }
    };

    public h(ImageViewerActivity imageViewerActivity) {
        this.kVE = imageViewerActivity;
        this.kVF = new a(imageViewerActivity);
    }

    public void a(MultiImageView multiImageView, int i, View.OnClickListener onClickListener) {
        ImageUrlData imageUrlData;
        if (this.kVF != null && multiImageView != null) {
            if (!this.kVF.isShowing()) {
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.kVF, multiImageView, 81, 0, com.baidu.adp.lib.util.a.getNavigationBarHeight(this.kVE) + this.fWE + i);
                String str = "";
                String str2 = "";
                String str3 = "";
                int i2 = 5;
                UrlDragImageView currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView();
                if (currentUrlDragImageView != null && (imageUrlData = currentUrlDragImageView.getmAssistUrlData()) != null) {
                    str = imageUrlData.threadId + "";
                    str2 = imageUrlData.forumId + "";
                    str3 = imageUrlData.postId + "";
                    i2 = Nx(imageUrlData.from);
                }
                TiebaStatic.log(new ar("c14045").dR("post_id", str3).dR("tid", str).dR("fid", str2).ap("obj_source", i2));
            }
            this.kVF.j(multiImageView);
            this.kVG = onClickListener;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.hfK);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.hfK, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Nx(String str) {
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
        if (this.kVF != null) {
            this.kVF.onDestroy();
        }
        this.kVE = null;
        this.kVG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends PopupWindow implements View.OnClickListener {
        private Activity activity;
        private View contentView;
        private EMTextView eVM;
        private MultiImageView kUV;
        private ImageView kVJ;
        private ImageView kVK;
        private ImageView kVL;
        private ImageView kVM;
        private ImageView kVN;
        private com.baidu.tbadk.coreExtra.share.g kVO;

        public a(Activity activity) {
            super(activity);
            this.activity = activity;
            this.kVO = new com.baidu.tbadk.coreExtra.share.g(activity, null);
            setWidth(l.getEquipmentWidth(activity) - (h.this.kVH * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            Zl();
            onChangeSkinType();
        }

        private void Zl() {
            this.contentView = LayoutInflater.from(this.activity).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
            this.eVM = (EMTextView) this.contentView.findViewById(R.id.title);
            this.kVJ = (ImageView) this.contentView.findViewById(R.id.qq_friend);
            this.kVJ.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qq40_svg));
            this.kVJ.setOnClickListener(this);
            this.kVK = (ImageView) this.contentView.findViewById(R.id.qq_zone);
            this.kVK.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
            this.kVK.setOnClickListener(this);
            this.kVL = (ImageView) this.contentView.findViewById(R.id.wechat_friend);
            this.kVL.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
            this.kVL.setOnClickListener(this);
            this.kVM = (ImageView) this.contentView.findViewById(R.id.wechat_timeline);
            this.kVM.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_circle40_svg));
            this.kVM.setOnClickListener(this);
            this.kVN = (ImageView) this.contentView.findViewById(R.id.wechat_emotion);
            this.kVN.setImageDrawable(this.activity.getDrawable(R.drawable.icon_share_wechatexpression));
            this.kVN.setOnClickListener(this);
            setContentView(this.contentView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem das = das();
            if (das != null) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (view == this.kVJ) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(das) && das.getCommandChannelArray() != null && das.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(das, this.activity, 8, null);
                            return;
                        } else {
                            this.kVO.g(das);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bqD();
                } else if (view == this.kVK) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(das) && das.getCommandChannelArray() != null && das.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(das, this.activity, 4, null);
                            return;
                        } else {
                            this.kVO.h(das);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bqD();
                } else if (view == this.kVL) {
                    if (l(das) && das.getCommandChannelArray() != null && das.getCommandChannelArray().contains(3)) {
                        com.baidu.tbadk.coreExtra.share.a.a(das, this.activity, 3, null);
                    } else if (das.fvl != 1) {
                        this.kVO.e(das);
                    }
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_source", 22).dR("tid", das.tid).dR("fid", das.fid));
                } else if (view == this.kVM) {
                    if (l(das) && das.getCommandChannelArray() != null && das.getCommandChannelArray().contains(2)) {
                        com.baidu.tbadk.coreExtra.share.a.a(das, this.activity, 2, null);
                    } else if (das.fvl != 1) {
                        if (das.fuG) {
                            das.content = "【" + das.title + "】 " + das.content;
                        }
                        this.kVO.f(das);
                    }
                } else if (view == this.kVN && h.this.kVG != null) {
                    h.this.kVG.onClick(view);
                }
            }
        }

        public void j(MultiImageView multiImageView) {
            this.kUV = multiImageView;
        }

        private ShareItem das() {
            UrlDragImageView currentUrlDragImageView;
            if (this.kUV == null || (currentUrlDragImageView = this.kUV.getCurrentUrlDragImageView()) == null) {
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
                str = this.kUV.getCurrentImageUrl();
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
                i = h.this.Nx(imageUrlData.from);
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
            return (TextUtils.isEmpty(shareItem.fvs) || TextUtils.isEmpty(shareItem.fvt)) ? false : true;
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.eVM, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.contentView).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0204);
        }

        public void onDestroy() {
            this.kUV = null;
            this.activity = null;
            this.kVO = null;
        }
    }
}
