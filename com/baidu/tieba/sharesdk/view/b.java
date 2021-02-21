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
/* loaded from: classes8.dex */
public class b extends d {
    private k.b iIn;
    private View.OnClickListener kVG;
    private k.b kWf;
    private k.b kWg;
    private k.b kWh;
    private k.b kWj;
    private Context mContext;
    private LinearLayout nli;
    private LinearLayout nlj;
    private View nlk;
    private View nll;
    private String originImgText;
    private boolean showAddEmotion;
    private boolean showQRCode;
    private static final int nlm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
    private static final int nln = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
    private static final int kVH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);

    public b(Context context, String str, boolean z, boolean z2, k.b bVar, k.b bVar2, k.b bVar3, k.b bVar4, k.b bVar5, View.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.originImgText = str;
        this.showAddEmotion = z;
        this.showQRCode = z2;
        this.iIn = bVar;
        this.kWh = bVar2;
        this.kWf = bVar3;
        this.kWg = bVar4;
        this.kWj = bVar5;
        this.kVG = onClickListener;
        this.nli = (LinearLayout) this.mRootView.findViewById(R.id.first_line);
        this.nlj = (LinearLayout) this.mRootView.findViewById(R.id.second_line);
        dJC();
    }

    private void dJC() {
        this.nla.clear();
        a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        a aVar = new a(this.mContext);
        aVar.setItemIcon(R.drawable.icon_share_wechatexpression);
        aVar.setItemName(R.string.share_weixin_emotion_1);
        aVar.IY(R.string.share_weixin_emotion_2);
        aVar.setOnClickListener(this);
        this.nla.add(aVar.dJE());
        a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        if (this.originImgText != null) {
            dq(R.string.original_img_look, R.drawable.icon_pure_share_original40);
        }
        LinearLayout dp = dp(R.string.save_to_local, R.drawable.icon_pure_share_download40);
        dp.setOnClickListener(this);
        dp.setTag(Integer.valueOf(R.drawable.icon_pure_share_download40 + R.string.save_to_local));
        this.nla.add(dp);
        if (this.showAddEmotion) {
            dq(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
        }
        dq(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
        if (this.showQRCode) {
            dq(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
        }
        this.nlk = new View(this.mContext);
        this.nll = new View(this.mContext);
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public boolean dJD() {
        this.nli.removeAllViews();
        this.nlj.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(6, this.nla.size())) {
                break;
            }
            this.nli.addView(this.nla.get(i2), new ViewGroup.LayoutParams(nlm, nln));
            i = i2 + 1;
        }
        this.nli.addView(this.nlk, new ViewGroup.LayoutParams(kVH, -1));
        for (int i3 = 6; i3 < this.nla.size(); i3++) {
            this.nlj.addView(this.nla.get(i3), new ViewGroup.LayoutParams(nlm, nln));
        }
        this.nlj.addView(this.nll, new ViewGroup.LayoutParams(kVH, -1));
        return true;
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cGa() {
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
            if (this.kWf != null) {
                this.kWf.onClick();
            }
        } else if (i == R.drawable.icon_pure_share_download40 + R.string.save_to_local) {
            if (this.iIn != null) {
                this.iIn.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_expression40) {
            if (this.kWh != null) {
                this.kWh.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_scan40) {
            if (this.kWg != null) {
                this.kWg.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_qrcode40) {
            if (this.kWj != null) {
                this.kWj.onClick();
            }
        } else if (i == R.drawable.icon_share_wechatexpression && this.kVG != null) {
            this.kVG.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends ShareDialogItemView {
        private Context context;
        private EMTextView nlo;
        private LinearLayout.LayoutParams nlp;

        public a(Context context) {
            super(context);
            this.context = context;
        }

        public void setItemIcon(int i) {
            this.nlR = new ImageView(this.context);
            setTag(Integer.valueOf(i));
            this.nlR.setScaleType(ImageView.ScaleType.FIT_XY);
            WebPManager.a(this.nlR, i, (WebPManager.ResourceStateType) null);
            dJJ();
        }

        public void IY(int i) {
            this.nlo = new EMTextView(this.context);
            this.nlo.setTextSize(0, nlQ);
            this.nlo.setText(i);
            ap.setViewTextColor(this.nlo, R.color.CAM_X0107);
            this.nlp = new LinearLayout.LayoutParams(-2, -2);
            this.nlp.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
            this.nlp.gravity = 1;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView dJE() {
            super.dJE();
            addView(this.nlo, this.nlp);
            return this;
        }
    }
}
