package com.baidu.tieba.sharesdk.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends d {
    private k.b iGW;
    private View.OnClickListener kRU;
    private k.b kSt;
    private k.b kSu;
    private k.b kSv;
    private k.b kSx;
    private Context mContext;
    private LinearLayout nfG;
    private LinearLayout nfH;
    private View nfI;
    private View nfJ;
    private String originImgText;
    private boolean showAddEmotion;
    private boolean showQRCode;
    private static final int nfK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
    private static final int nfL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
    private static final int kRV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);

    public b(Context context, String str, boolean z, boolean z2, k.b bVar, k.b bVar2, k.b bVar3, k.b bVar4, k.b bVar5, View.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.originImgText = str;
        this.showAddEmotion = z;
        this.showQRCode = z2;
        this.iGW = bVar;
        this.kSv = bVar2;
        this.kSt = bVar3;
        this.kSu = bVar4;
        this.kSx = bVar5;
        this.kRU = onClickListener;
        this.nfG = (LinearLayout) this.mRootView.findViewById(R.id.first_line);
        this.nfH = (LinearLayout) this.mRootView.findViewById(R.id.second_line);
        dLa();
    }

    private void dLa() {
        this.nfy.clear();
        a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        a aVar = new a(this.mContext);
        aVar.setItemIcon(R.drawable.icon_share_wechatexpression);
        aVar.setItemName(R.string.share_weixin_emotion_1);
        aVar.Kl(R.string.share_weixin_emotion_2);
        aVar.setOnClickListener(this);
        this.nfy.add(aVar.dLc());
        a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        if (this.originImgText != null) {
            ds(R.string.original_img_look, R.drawable.icon_pure_share_original40);
        }
        LinearLayout dr = dr(R.string.save_to_local, R.drawable.icon_pure_share_download40);
        dr.setOnClickListener(this);
        dr.setTag(Integer.valueOf(R.drawable.icon_pure_share_download40 + R.string.save_to_local));
        this.nfy.add(dr);
        if (this.showAddEmotion) {
            ds(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
        }
        ds(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
        if (this.showQRCode) {
            ds(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
        }
        this.nfI = new View(this.mContext);
        this.nfJ = new View(this.mContext);
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public boolean dLb() {
        this.nfG.removeAllViews();
        this.nfH.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(6, this.nfy.size())) {
                break;
            }
            this.nfG.addView(this.nfy.get(i2), new ViewGroup.LayoutParams(nfK, nfL));
            i = i2 + 1;
        }
        this.nfG.addView(this.nfI, new ViewGroup.LayoutParams(kRV, -1));
        for (int i3 = 6; i3 < this.nfy.size(); i3++) {
            this.nfH.addView(this.nfy.get(i3), new ViewGroup.LayoutParams(nfK, nfL));
        }
        this.nfH.addView(this.nfJ, new ViewGroup.LayoutParams(kRV, -1));
        return true;
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cIx() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.image_viewer_share_dialog_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public void a(View view, int i, View.OnClickListener onClickListener) {
        super.a(view, i, onClickListener);
    }

    @Override // com.baidu.tieba.sharesdk.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int i = -1;
        if (view.getTag() != null) {
            i = ((Integer) view.getTag()).intValue();
        }
        if (i == R.drawable.icon_pure_share_original40) {
            if (this.kSt != null) {
                this.kSt.onClick();
            }
        } else if (i == R.drawable.icon_pure_share_download40 + R.string.save_to_local) {
            if (this.iGW != null) {
                this.iGW.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_expression40) {
            if (this.kSv != null) {
                this.kSv.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_scan40) {
            if (this.kSu != null) {
                this.kSu.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_qrcode40) {
            if (this.kSx != null) {
                this.kSx.onClick();
            }
        } else if (i == R.drawable.icon_share_wechatexpression && this.kRU != null) {
            this.kRU.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends ShareDialogItemView {
        private Context context;
        private EMTextView nfM;
        private LinearLayout.LayoutParams nfN;

        public a(Context context) {
            super(context);
            this.context = context;
        }

        public void setItemIcon(int i) {
            this.ngp = new ImageView(this.context);
            setTag(Integer.valueOf(i));
            this.ngp.setScaleType(ImageView.ScaleType.FIT_XY);
            WebPManager.a(this.ngp, i, (WebPManager.ResourceStateType) null);
            dLh();
        }

        public void Kl(int i) {
            this.nfM = new EMTextView(this.context);
            this.nfM.setTextSize(0, ngo);
            this.nfM.setText(i);
            ao.setViewTextColor(this.nfM, R.color.CAM_X0107);
            this.nfN = new LinearLayout.LayoutParams(-2, -2);
            this.nfN.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
            this.nfN.gravity = 1;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView dLc() {
            super.dLc();
            addView(this.nfM, this.nfN);
            return this;
        }
    }
}
