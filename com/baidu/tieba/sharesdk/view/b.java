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
/* loaded from: classes7.dex */
public class b extends d {
    private k.b iCp;
    private k.b kNO;
    private k.b kNP;
    private k.b kNQ;
    private k.b kNS;
    private View.OnClickListener kNp;
    private Context mContext;
    private LinearLayout nba;
    private LinearLayout nbb;
    private View nbc;
    private View nbd;
    private String originImgText;
    private boolean showAddEmotion;
    private boolean showQRCode;
    private static final int nbe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
    private static final int nbf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
    private static final int kNq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);

    public b(Context context, String str, boolean z, boolean z2, k.b bVar, k.b bVar2, k.b bVar3, k.b bVar4, k.b bVar5, View.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.originImgText = str;
        this.showAddEmotion = z;
        this.showQRCode = z2;
        this.iCp = bVar;
        this.kNQ = bVar2;
        this.kNO = bVar3;
        this.kNP = bVar4;
        this.kNS = bVar5;
        this.kNp = onClickListener;
        this.nba = (LinearLayout) this.mRootView.findViewById(R.id.first_line);
        this.nbb = (LinearLayout) this.mRootView.findViewById(R.id.second_line);
        dHj();
    }

    private void dHj() {
        this.naS.clear();
        a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        a aVar = new a(this.mContext);
        aVar.setItemIcon(R.drawable.icon_share_wechatexpression);
        aVar.setItemName(R.string.share_weixin_emotion_1);
        aVar.IE(R.string.share_weixin_emotion_2);
        aVar.setOnClickListener(this);
        this.naS.add(aVar.dHl());
        a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        if (this.originImgText != null) {
            ds(R.string.original_img_look, R.drawable.icon_pure_share_original40);
        }
        LinearLayout dr = dr(R.string.save_to_local, R.drawable.icon_pure_share_download40);
        dr.setOnClickListener(this);
        dr.setTag(Integer.valueOf(R.drawable.icon_pure_share_download40 + R.string.save_to_local));
        this.naS.add(dr);
        if (this.showAddEmotion) {
            ds(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
        }
        ds(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
        if (this.showQRCode) {
            ds(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
        }
        this.nbc = new View(this.mContext);
        this.nbd = new View(this.mContext);
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public boolean dHk() {
        this.nba.removeAllViews();
        this.nbb.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(6, this.naS.size())) {
                break;
            }
            this.nba.addView(this.naS.get(i2), new ViewGroup.LayoutParams(nbe, nbf));
            i = i2 + 1;
        }
        this.nba.addView(this.nbc, new ViewGroup.LayoutParams(kNq, -1));
        for (int i3 = 6; i3 < this.naS.size(); i3++) {
            this.nbb.addView(this.naS.get(i3), new ViewGroup.LayoutParams(nbe, nbf));
        }
        this.nbb.addView(this.nbd, new ViewGroup.LayoutParams(kNq, -1));
        return true;
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cEG() {
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
            if (this.kNO != null) {
                this.kNO.onClick();
            }
        } else if (i == R.drawable.icon_pure_share_download40 + R.string.save_to_local) {
            if (this.iCp != null) {
                this.iCp.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_expression40) {
            if (this.kNQ != null) {
                this.kNQ.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_scan40) {
            if (this.kNP != null) {
                this.kNP.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_qrcode40) {
            if (this.kNS != null) {
                this.kNS.onClick();
            }
        } else if (i == R.drawable.icon_share_wechatexpression && this.kNp != null) {
            this.kNp.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends ShareDialogItemView {
        private Context context;
        private EMTextView nbg;
        private LinearLayout.LayoutParams nbh;

        public a(Context context) {
            super(context);
            this.context = context;
        }

        public void setItemIcon(int i) {
            this.nbJ = new ImageView(this.context);
            setTag(Integer.valueOf(i));
            this.nbJ.setScaleType(ImageView.ScaleType.FIT_XY);
            WebPManager.a(this.nbJ, i, (WebPManager.ResourceStateType) null);
            dHq();
        }

        public void IE(int i) {
            this.nbg = new EMTextView(this.context);
            this.nbg.setTextSize(0, nbI);
            this.nbg.setText(i);
            ao.setViewTextColor(this.nbg, R.color.CAM_X0107);
            this.nbh = new LinearLayout.LayoutParams(-2, -2);
            this.nbh.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
            this.nbh.gravity = 1;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView dHl() {
            super.dHl();
            addView(this.nbg, this.nbh);
            return this;
        }
    }
}
