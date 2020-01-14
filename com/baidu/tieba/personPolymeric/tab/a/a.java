package com.baidu.tieba.personPolymeric.tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a Fy;
    private TbImageView gfu;
    private TextView jpf;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Fy != null) {
                a.this.Fy.dismiss();
            }
        }
    };
    private boolean jpe = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void cwg() {
        if (!this.jpe) {
            this.jpe = true;
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.Fy = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.Fy.jI(1);
            this.Fy.fz(true);
            this.Fy.fA(false);
            this.Fy.aO(this.mRootView);
            this.Fy.b(this.mTbPageContext).aCp();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.gfu = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        j(this.gfu);
        this.gfu.setAutoChangeStyle(true);
        this.gfu.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.gfu.setConrers(3);
        this.gfu.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.jpf = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.jpf.setOnClickListener(this.mOnClickListener);
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

    public boolean cwh() {
        return this.jpe;
    }

    private void onChangeSkinType() {
        am.setImageResource(this.gfu, R.drawable.pic_person_center_dynamic_guide);
        am.setViewTextColor(this.mTip, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jpf, (int) R.color.cp_link_tip_a);
    }
}
