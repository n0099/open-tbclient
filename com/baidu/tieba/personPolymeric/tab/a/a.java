package com.baidu.tieba.personPolymeric.tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a aaa;
    private TbImageView hsL;
    private TextView kPd;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aaa != null) {
                a.this.aaa.dismiss();
            }
        }
    };
    private boolean kPc = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void cUm() {
        if (!this.kPc) {
            this.kPc = true;
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.aaa = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.aaa.kW(1);
            this.aaa.hf(true);
            this.aaa.hg(false);
            this.aaa.aP(this.mRootView);
            this.aaa.b(this.mTbPageContext).aUN();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.hsL = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        j(this.hsL);
        this.hsL.setAutoChangeStyle(true);
        this.hsL.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.hsL.setConrers(3);
        this.hsL.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.kPd = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.kPd.setOnClickListener(this.mOnClickListener);
        onChangeSkinType();
    }

    private void j(TbImageView tbImageView) {
        if (tbImageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
            int equipmentWidth = l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds40) * 2);
            layoutParams.width = equipmentWidth;
            layoutParams.height = (equipmentWidth * 214) / 380;
            tbImageView.setLayoutParams(layoutParams);
        }
    }

    public boolean cUn() {
        return this.kPc;
    }

    private void onChangeSkinType() {
        an.setImageResource(this.hsL, R.drawable.pic_person_center_dynamic_guide);
        an.setViewTextColor(this.mTip, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.kPd, (int) R.color.cp_link_tip_a);
    }
}
