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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes8.dex */
public class h {
    private ImageViewerActivity kRS;
    private a kRT;
    private View.OnClickListener kRU;
    private final int fYX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
    private final int kRV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    private Runnable hht = new Runnable() { // from class: com.baidu.tieba.image.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.kRT != null) {
                h.this.kRT.dismiss();
            }
        }
    };

    public h(ImageViewerActivity imageViewerActivity) {
        this.kRS = imageViewerActivity;
        this.kRT = new a(imageViewerActivity);
    }

    public void a(MultiImageView multiImageView, int i, View.OnClickListener onClickListener) {
        ImageUrlData imageUrlData;
        if (this.kRT != null && multiImageView != null) {
            if (!this.kRT.isShowing()) {
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.kRT, multiImageView, 81, 0, com.baidu.adp.lib.util.a.getNavigationBarHeight(this.kRS) + this.fYX + i);
                String str = "";
                String str2 = "";
                String str3 = "";
                int i2 = 5;
                UrlDragImageView currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView();
                if (currentUrlDragImageView != null && (imageUrlData = currentUrlDragImageView.getmAssistUrlData()) != null) {
                    str = imageUrlData.threadId + "";
                    str2 = imageUrlData.forumId + "";
                    str3 = imageUrlData.postId + "";
                    i2 = NQ(imageUrlData.from);
                }
                TiebaStatic.log(new aq("c14045").dX("post_id", str3).dX("tid", str).dX("fid", str2).an("obj_source", i2));
            }
            this.kRT.j(multiImageView);
            this.kRU = onClickListener;
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.hht);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.hht, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int NQ(String str) {
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
        if (this.kRT != null) {
            this.kRT.onDestroy();
        }
        this.kRS = null;
        this.kRU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends PopupWindow implements View.OnClickListener {
        private Activity activity;
        private View contentView;
        private EMTextView eYh;
        private ImageView kRX;
        private ImageView kRY;
        private ImageView kRZ;
        private MultiImageView kRj;
        private ImageView kSa;
        private ImageView kSb;
        private com.baidu.tbadk.coreExtra.share.g kSc;

        public a(Activity activity) {
            super(activity);
            this.activity = activity;
            this.kSc = new com.baidu.tbadk.coreExtra.share.g(activity, null);
            setWidth(l.getEquipmentWidth(activity) - (h.this.kRV * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            abn();
            onChangeSkinType();
        }

        private void abn() {
            this.contentView = LayoutInflater.from(this.activity).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
            this.eYh = (EMTextView) this.contentView.findViewById(R.id.title);
            this.kRX = (ImageView) this.contentView.findViewById(R.id.qq_friend);
            this.kRX.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qq40_svg));
            this.kRX.setOnClickListener(this);
            this.kRY = (ImageView) this.contentView.findViewById(R.id.qq_zone);
            this.kRY.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
            this.kRY.setOnClickListener(this);
            this.kRZ = (ImageView) this.contentView.findViewById(R.id.wechat_friend);
            this.kRZ.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
            this.kRZ.setOnClickListener(this);
            this.kSa = (ImageView) this.contentView.findViewById(R.id.wechat_timeline);
            this.kSa.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_circle40_svg));
            this.kSa.setOnClickListener(this);
            this.kSb = (ImageView) this.contentView.findViewById(R.id.wechat_emotion);
            this.kSb.setImageDrawable(this.activity.getDrawable(R.drawable.icon_share_wechatexpression));
            this.kSb.setOnClickListener(this);
            setContentView(this.contentView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem dce = dce();
            if (dce != null) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (view == this.kRX) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(dce) && dce.getCommandChannelArray() != null && dce.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(dce, this.activity, 8, null);
                            return;
                        } else {
                            this.kSc.g(dce);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bud();
                } else if (view == this.kRY) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(dce) && dce.getCommandChannelArray() != null && dce.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(dce, this.activity, 4, null);
                            return;
                        } else {
                            this.kSc.h(dce);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bud();
                } else if (view == this.kRZ) {
                    if (l(dce) && dce.getCommandChannelArray() != null && dce.getCommandChannelArray().contains(3)) {
                        com.baidu.tbadk.coreExtra.share.a.a(dce, this.activity, 3, null);
                    } else if (dce.fxC != 1) {
                        this.kSc.e(dce);
                    }
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_source", 22).dX("tid", dce.tid).dX("fid", dce.fid));
                } else if (view == this.kSa) {
                    if (l(dce) && dce.getCommandChannelArray() != null && dce.getCommandChannelArray().contains(2)) {
                        com.baidu.tbadk.coreExtra.share.a.a(dce, this.activity, 2, null);
                    } else if (dce.fxC != 1) {
                        if (dce.fwX) {
                            dce.content = "【" + dce.title + "】 " + dce.content;
                        }
                        this.kSc.f(dce);
                    }
                } else if (view == this.kSb && h.this.kRU != null) {
                    h.this.kRU.onClick(view);
                }
            }
        }

        public void j(MultiImageView multiImageView) {
            this.kRj = multiImageView;
        }

        private ShareItem dce() {
            UrlDragImageView currentUrlDragImageView;
            if (this.kRj == null || (currentUrlDragImageView = this.kRj.getCurrentUrlDragImageView()) == null) {
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
                str = this.kRj.getCurrentImageUrl();
                str2 = av.getNameMd5FromUrl(str);
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
                i = h.this.NQ(imageUrlData.from);
            }
            if (!at.isEmpty(str)) {
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
            return (TextUtils.isEmpty(shareItem.fxJ) || TextUtils.isEmpty(shareItem.fxK)) ? false : true;
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.eYh, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.contentView).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0204);
        }

        public void onDestroy() {
            this.kRj = null;
            this.activity = null;
            this.kSc = null;
        }
    }
}
