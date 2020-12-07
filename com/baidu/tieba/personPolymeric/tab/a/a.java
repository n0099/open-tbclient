package com.baidu.tieba.personPolymeric.tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a acq;
    private TbImageView iLU;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private TextView mtx;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.acq != null) {
                a.this.acq.dismiss();
            }
        }
    };
    private boolean mtw = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void dBb() {
        if (!this.mtw) {
            this.mtw = true;
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.acq = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.acq.oT(1);
            this.acq.jl(true);
            this.acq.jm(false);
            this.acq.bi(this.mRootView);
            this.acq.b(this.mTbPageContext).brv();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.iLU = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        i(this.iLU);
        this.iLU.setAutoChangeStyle(true);
        this.iLU.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.iLU.setConrers(3);
        this.iLU.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.mtx = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.mtx.setOnClickListener(this.mOnClickListener);
        onChangeSkinType();
    }

    private void i(TbImageView tbImageView) {
        if (tbImageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
            int equipmentWidth = l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds40) * 2);
            layoutParams.width = equipmentWidth;
            layoutParams.height = (equipmentWidth * 214) / 380;
            tbImageView.setLayoutParams(layoutParams);
        }
    }

    public boolean dBc() {
        return this.mtw;
    }

    private void onChangeSkinType() {
        ap.setImageResource(this.iLU, R.drawable.pic_person_center_dynamic_guide);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0107);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.mtx, R.color.CAM_X0302);
    }
}
