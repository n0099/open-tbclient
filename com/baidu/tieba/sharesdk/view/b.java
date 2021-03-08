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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends d {
    private k.b iJW;
    private View.OnClickListener kXI;
    private k.b kYh;
    private k.b kYi;
    private k.b kYj;
    private k.b kYl;
    private Context mContext;
    private LinearLayout nnm;
    private LinearLayout nnn;
    private View nno;
    private View nnp;
    private String originImgText;
    private boolean showAddEmotion;
    private boolean showQRCode;
    private static final int nnq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
    private static final int nnr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
    private static final int kXJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);

    public b(Context context, String str, boolean z, boolean z2, k.b bVar, k.b bVar2, k.b bVar3, k.b bVar4, k.b bVar5, View.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.originImgText = str;
        this.showAddEmotion = z;
        this.showQRCode = z2;
        this.iJW = bVar;
        this.kYj = bVar2;
        this.kYh = bVar3;
        this.kYi = bVar4;
        this.kYl = bVar5;
        this.kXI = onClickListener;
        this.nnm = (LinearLayout) this.mRootView.findViewById(R.id.first_line);
        this.nnn = (LinearLayout) this.mRootView.findViewById(R.id.second_line);
        dJK();
    }

    private void dJK() {
        this.nne.clear();
        a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        a aVar = new a(this.mContext);
        aVar.setItemIcon(R.drawable.icon_share_wechatexpression);
        aVar.setItemName(R.string.share_weixin_emotion_1);
        aVar.Jc(R.string.share_weixin_emotion_2);
        aVar.setOnClickListener(this);
        this.nne.add(aVar.dJM());
        a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        if (this.originImgText != null) {
            dq(R.string.original_img_look, R.drawable.icon_pure_share_original40);
        }
        LinearLayout dp = dp(R.string.save_to_local, R.drawable.icon_pure_share_download40);
        dp.setOnClickListener(this);
        dp.setTag(Integer.valueOf(R.drawable.icon_pure_share_download40 + R.string.save_to_local));
        this.nne.add(dp);
        if (this.showAddEmotion) {
            dq(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
        }
        dq(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
        if (this.showQRCode) {
            dq(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
        }
        this.nno = new View(this.mContext);
        this.nnp = new View(this.mContext);
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public boolean dJL() {
        this.nnm.removeAllViews();
        this.nnn.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(6, this.nne.size())) {
                break;
            }
            this.nnm.addView(this.nne.get(i2), new ViewGroup.LayoutParams(nnq, nnr));
            i = i2 + 1;
        }
        this.nnm.addView(this.nno, new ViewGroup.LayoutParams(kXJ, -1));
        for (int i3 = 6; i3 < this.nne.size(); i3++) {
            this.nnn.addView(this.nne.get(i3), new ViewGroup.LayoutParams(nnq, nnr));
        }
        this.nnn.addView(this.nnp, new ViewGroup.LayoutParams(kXJ, -1));
        return true;
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cGg() {
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
            if (this.kYh != null) {
                this.kYh.onClick();
            }
        } else if (i == R.drawable.icon_pure_share_download40 + R.string.save_to_local) {
            if (this.iJW != null) {
                this.iJW.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_expression40) {
            if (this.kYj != null) {
                this.kYj.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_scan40) {
            if (this.kYi != null) {
                this.kYi.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_qrcode40) {
            if (this.kYl != null) {
                this.kYl.onClick();
            }
        } else if (i == R.drawable.icon_share_wechatexpression && this.kXI != null) {
            this.kXI.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends ShareDialogItemView {
        private Context context;
        private EMTextView nns;
        private LinearLayout.LayoutParams nnt;

        public a(Context context) {
            super(context);
            this.context = context;
        }

        public void setItemIcon(int i) {
            this.nnV = new ImageView(this.context);
            setTag(Integer.valueOf(i));
            this.nnV.setScaleType(ImageView.ScaleType.FIT_XY);
            WebPManager.a(this.nnV, i, (WebPManager.ResourceStateType) null);
            dJR();
        }

        public void Jc(int i) {
            this.nns = new EMTextView(this.context);
            this.nns.setTextSize(0, nnU);
            this.nns.setText(i);
            ap.setViewTextColor(this.nns, R.color.CAM_X0107);
            this.nnt = new LinearLayout.LayoutParams(-2, -2);
            this.nnt.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
            this.nnt.gravity = 1;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView dJM() {
            super.dJM();
            addView(this.nns, this.nnt);
            return this;
        }
    }
}
