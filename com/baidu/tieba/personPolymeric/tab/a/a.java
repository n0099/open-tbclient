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
/* loaded from: classes18.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a aaD;
    private TbImageView hLS;
    private TextView lou;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aaD != null) {
                a.this.aaD.dismiss();
            }
        }
    };
    private boolean lot = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void djj() {
        if (!this.lot) {
            this.lot = true;
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.aaD = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.aaD.nw(1);
            this.aaD.ig(true);
            this.aaD.ih(false);
            this.aaD.aX(this.mRootView);
            this.aaD.b(this.mTbPageContext).bhg();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.hLS = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        j(this.hLS);
        this.hLS.setAutoChangeStyle(true);
        this.hLS.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.hLS.setConrers(3);
        this.hLS.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.lou = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.lou.setOnClickListener(this.mOnClickListener);
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

    public boolean djk() {
        return this.lot;
    }

    private void onChangeSkinType() {
        ap.setImageResource(this.hLS, R.drawable.pic_person_center_dynamic_guide);
        ap.setViewTextColor(this.mTip, (int) R.color.cp_cont_j);
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.lou, (int) R.color.cp_link_tip_a);
    }
}
