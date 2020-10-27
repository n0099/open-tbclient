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
    private com.baidu.tbadk.core.dialog.a abn;
    private TbImageView iuq;
    private TextView lYZ;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.abn != null) {
                a.this.abn.dismiss();
            }
        }
    };
    private boolean lYY = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void dtH() {
        if (!this.lYY) {
            this.lYY = true;
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.abn = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.abn.op(1);
            this.abn.iM(true);
            this.abn.iN(false);
            this.abn.bb(this.mRootView);
            this.abn.b(this.mTbPageContext).bmC();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.iuq = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        j(this.iuq);
        this.iuq.setAutoChangeStyle(true);
        this.iuq.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.iuq.setConrers(3);
        this.iuq.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.lYZ = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.lYZ.setOnClickListener(this.mOnClickListener);
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

    public boolean dtI() {
        return this.lYY;
    }

    private void onChangeSkinType() {
        ap.setImageResource(this.iuq, R.drawable.pic_person_center_dynamic_guide);
        ap.setViewTextColor(this.mTip, R.color.cp_cont_j);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.lYZ, R.color.cp_link_tip_a);
    }
}
