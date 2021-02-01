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
    private k.b iHZ;
    private k.b kVR;
    private k.b kVS;
    private k.b kVT;
    private k.b kVV;
    private View.OnClickListener kVs;
    private Context mContext;
    private LinearLayout nkI;
    private LinearLayout nkJ;
    private View nkK;
    private View nkL;
    private String originImgText;
    private boolean showAddEmotion;
    private boolean showQRCode;
    private static final int nkM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
    private static final int nkN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
    private static final int kVt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);

    public b(Context context, String str, boolean z, boolean z2, k.b bVar, k.b bVar2, k.b bVar3, k.b bVar4, k.b bVar5, View.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.originImgText = str;
        this.showAddEmotion = z;
        this.showQRCode = z2;
        this.iHZ = bVar;
        this.kVT = bVar2;
        this.kVR = bVar3;
        this.kVS = bVar4;
        this.kVV = bVar5;
        this.kVs = onClickListener;
        this.nkI = (LinearLayout) this.mRootView.findViewById(R.id.first_line);
        this.nkJ = (LinearLayout) this.mRootView.findViewById(R.id.second_line);
        dJu();
    }

    private void dJu() {
        this.nkA.clear();
        a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        a aVar = new a(this.mContext);
        aVar.setItemIcon(R.drawable.icon_share_wechatexpression);
        aVar.setItemName(R.string.share_weixin_emotion_1);
        aVar.IY(R.string.share_weixin_emotion_2);
        aVar.setOnClickListener(this);
        this.nkA.add(aVar.dJw());
        a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        if (this.originImgText != null) {
            dp(R.string.original_img_look, R.drawable.icon_pure_share_original40);
        }
        LinearLayout linearLayout = m47do(R.string.save_to_local, R.drawable.icon_pure_share_download40);
        linearLayout.setOnClickListener(this);
        linearLayout.setTag(Integer.valueOf(R.drawable.icon_pure_share_download40 + R.string.save_to_local));
        this.nkA.add(linearLayout);
        if (this.showAddEmotion) {
            dp(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
        }
        dp(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
        if (this.showQRCode) {
            dp(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
        }
        this.nkK = new View(this.mContext);
        this.nkL = new View(this.mContext);
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    public boolean dJv() {
        this.nkI.removeAllViews();
        this.nkJ.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(6, this.nkA.size())) {
                break;
            }
            this.nkI.addView(this.nkA.get(i2), new ViewGroup.LayoutParams(nkM, nkN));
            i = i2 + 1;
        }
        this.nkI.addView(this.nkK, new ViewGroup.LayoutParams(kVt, -1));
        for (int i3 = 6; i3 < this.nkA.size(); i3++) {
            this.nkJ.addView(this.nkA.get(i3), new ViewGroup.LayoutParams(nkM, nkN));
        }
        this.nkJ.addView(this.nkL, new ViewGroup.LayoutParams(kVt, -1));
        return true;
    }

    @Override // com.baidu.tieba.sharesdk.view.d
    protected View cFT() {
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
            if (this.kVR != null) {
                this.kVR.onClick();
            }
        } else if (i == R.drawable.icon_pure_share_download40 + R.string.save_to_local) {
            if (this.iHZ != null) {
                this.iHZ.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_expression40) {
            if (this.kVT != null) {
                this.kVT.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_scan40) {
            if (this.kVS != null) {
                this.kVS.onClick();
            }
        } else if (i == R.drawable.icon_share_homepage_qrcode40) {
            if (this.kVV != null) {
                this.kVV.onClick();
            }
        } else if (i == R.drawable.icon_share_wechatexpression && this.kVs != null) {
            this.kVs.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends ShareDialogItemView {
        private Context context;
        private EMTextView nkO;
        private LinearLayout.LayoutParams nkP;

        public a(Context context) {
            super(context);
            this.context = context;
        }

        public void setItemIcon(int i) {
            this.nlr = new ImageView(this.context);
            setTag(Integer.valueOf(i));
            this.nlr.setScaleType(ImageView.ScaleType.FIT_XY);
            WebPManager.a(this.nlr, i, (WebPManager.ResourceStateType) null);
            dJB();
        }

        public void IY(int i) {
            this.nkO = new EMTextView(this.context);
            this.nkO.setTextSize(0, nlq);
            this.nkO.setText(i);
            ap.setViewTextColor(this.nkO, R.color.CAM_X0107);
            this.nkP = new LinearLayout.LayoutParams(-2, -2);
            this.nkP.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
            this.nkP.gravity = 1;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView dJw() {
            super.dJw();
            addView(this.nkO, this.nkP);
            return this;
        }
    }
}
