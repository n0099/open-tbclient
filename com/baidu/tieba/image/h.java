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
/* loaded from: classes7.dex */
public class h {
    private ImageViewerActivity kNn;
    private a kNo;
    private View.OnClickListener kNp;
    private final int fUq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
    private final int kNq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    private Runnable hcN = new Runnable() { // from class: com.baidu.tieba.image.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.kNo != null) {
                h.this.kNo.dismiss();
            }
        }
    };

    public h(ImageViewerActivity imageViewerActivity) {
        this.kNn = imageViewerActivity;
        this.kNo = new a(imageViewerActivity);
    }

    public void a(MultiImageView multiImageView, int i, View.OnClickListener onClickListener) {
        ImageUrlData imageUrlData;
        if (this.kNo != null && multiImageView != null) {
            if (!this.kNo.isShowing()) {
                com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.kNo, multiImageView, 81, 0, com.baidu.adp.lib.util.a.getNavigationBarHeight(this.kNn) + this.fUq + i);
                String str = "";
                String str2 = "";
                String str3 = "";
                int i2 = 5;
                UrlDragImageView currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView();
                if (currentUrlDragImageView != null && (imageUrlData = currentUrlDragImageView.getmAssistUrlData()) != null) {
                    str = imageUrlData.threadId + "";
                    str2 = imageUrlData.forumId + "";
                    str3 = imageUrlData.postId + "";
                    i2 = MH(imageUrlData.from);
                }
                TiebaStatic.log(new aq("c14045").dW("post_id", str3).dW("tid", str).dW("fid", str2).an("obj_source", i2));
            }
            this.kNo.j(multiImageView);
            this.kNp = onClickListener;
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.hcN);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.hcN, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MH(String str) {
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
        if (this.kNo != null) {
            this.kNo.onDestroy();
        }
        this.kNn = null;
        this.kNp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends PopupWindow implements View.OnClickListener {
        private Activity activity;
        private View contentView;
        private EMTextView eTw;
        private MultiImageView kME;
        private ImageView kNs;
        private ImageView kNt;
        private ImageView kNu;
        private ImageView kNv;
        private ImageView kNw;
        private com.baidu.tbadk.coreExtra.share.g kNx;

        public a(Activity activity) {
            super(activity);
            this.activity = activity;
            this.kNx = new com.baidu.tbadk.coreExtra.share.g(activity, null);
            setWidth(l.getEquipmentWidth(activity) - (h.this.kNq * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            Xv();
            onChangeSkinType();
        }

        private void Xv() {
            this.contentView = LayoutInflater.from(this.activity).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
            this.eTw = (EMTextView) this.contentView.findViewById(R.id.title);
            this.kNs = (ImageView) this.contentView.findViewById(R.id.qq_friend);
            this.kNs.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qq40_svg));
            this.kNs.setOnClickListener(this);
            this.kNt = (ImageView) this.contentView.findViewById(R.id.qq_zone);
            this.kNt.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
            this.kNt.setOnClickListener(this);
            this.kNu = (ImageView) this.contentView.findViewById(R.id.wechat_friend);
            this.kNu.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
            this.kNu.setOnClickListener(this);
            this.kNv = (ImageView) this.contentView.findViewById(R.id.wechat_timeline);
            this.kNv.setImageDrawable(this.activity.getDrawable(R.drawable.icon_mask_share_circle40_svg));
            this.kNv.setOnClickListener(this);
            this.kNw = (ImageView) this.contentView.findViewById(R.id.wechat_emotion);
            this.kNw.setImageDrawable(this.activity.getDrawable(R.drawable.icon_share_wechatexpression));
            this.kNw.setOnClickListener(this);
            setContentView(this.contentView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem cYn = cYn();
            if (cYn != null) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (view == this.kNs) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(cYn) && cYn.getCommandChannelArray() != null && cYn.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(cYn, this.activity, 8, null);
                            return;
                        } else {
                            this.kNx.g(cYn);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bqk();
                } else if (view == this.kNt) {
                    if (z.isInstalledPackage(this.activity, "com.tencent.mobileqq")) {
                        if (l(cYn) && cYn.getCommandChannelArray() != null && cYn.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(cYn, this.activity, 4, null);
                            return;
                        } else {
                            this.kNx.h(cYn);
                            return;
                        }
                    }
                    BdToast.b(this.activity, this.activity.getText(R.string.share_qq_not_install)).bqk();
                } else if (view == this.kNu) {
                    if (l(cYn) && cYn.getCommandChannelArray() != null && cYn.getCommandChannelArray().contains(3)) {
                        com.baidu.tbadk.coreExtra.share.a.a(cYn, this.activity, 3, null);
                    } else if (cYn.fsT != 1) {
                        this.kNx.e(cYn);
                    }
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_source", 22).dW("tid", cYn.tid).dW("fid", cYn.fid));
                } else if (view == this.kNv) {
                    if (l(cYn) && cYn.getCommandChannelArray() != null && cYn.getCommandChannelArray().contains(2)) {
                        com.baidu.tbadk.coreExtra.share.a.a(cYn, this.activity, 2, null);
                    } else if (cYn.fsT != 1) {
                        if (cYn.fso) {
                            cYn.content = "【" + cYn.title + "】 " + cYn.content;
                        }
                        this.kNx.f(cYn);
                    }
                } else if (view == this.kNw && h.this.kNp != null) {
                    h.this.kNp.onClick(view);
                }
            }
        }

        public void j(MultiImageView multiImageView) {
            this.kME = multiImageView;
        }

        private ShareItem cYn() {
            UrlDragImageView currentUrlDragImageView;
            if (this.kME == null || (currentUrlDragImageView = this.kME.getCurrentUrlDragImageView()) == null) {
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
                str = this.kME.getCurrentImageUrl();
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
                i = h.this.MH(imageUrlData.from);
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
            return (TextUtils.isEmpty(shareItem.fta) || TextUtils.isEmpty(shareItem.ftb)) ? false : true;
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.eTw, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.contentView).od(R.string.J_X06).setBackGroundColor(R.color.CAM_X0204);
        }

        public void onDestroy() {
            this.kME = null;
            this.activity = null;
            this.kNx = null;
        }
    }
}
