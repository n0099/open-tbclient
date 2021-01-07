package com.baidu.tieba.personPolymeric.tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a adc;
    private TbImageView iYh;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private TextView myL;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.adc != null) {
                a.this.adc.dismiss();
            }
        }
    };
    private boolean myK = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void dAS() {
        if (!this.myK) {
            this.myK = true;
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.adc = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.adc.pd(1);
            this.adc.jH(true);
            this.adc.jI(false);
            this.adc.br(this.mRootView);
            this.adc.b(this.mTbPageContext).btY();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.iYh = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        i(this.iYh);
        this.iYh.setAutoChangeStyle(true);
        this.iYh.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.iYh.setConrers(3);
        this.iYh.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.myL = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.myL.setOnClickListener(this.mOnClickListener);
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

    public boolean dAT() {
        return this.myK;
    }

    private void onChangeSkinType() {
        ao.setImageResource(this.iYh, R.drawable.pic_person_center_dynamic_guide);
        ao.setViewTextColor(this.mTip, R.color.CAM_X0107);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.myL, R.color.CAM_X0302);
    }
}
