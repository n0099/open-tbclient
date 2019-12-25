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
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a Ft;
    private TbImageView gcj;
    private TextView jlx;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Ft != null) {
                a.this.Ft.dismiss();
            }
        }
    };
    private boolean jlw = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void cuX() {
        if (!this.jlw) {
            this.jlw = true;
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.Ft = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.Ft.jI(1);
            this.Ft.fu(true);
            this.Ft.fv(false);
            this.Ft.aK(this.mRootView);
            this.Ft.b(this.mTbPageContext).aBW();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.gcj = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        j(this.gcj);
        this.gcj.setAutoChangeStyle(true);
        this.gcj.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.gcj.setConrers(3);
        this.gcj.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.jlx = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.jlx.setOnClickListener(this.mOnClickListener);
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

    public boolean cuY() {
        return this.jlw;
    }

    private void onChangeSkinType() {
        am.setImageResource(this.gcj, R.drawable.pic_person_center_dynamic_guide);
        am.setViewTextColor(this.mTip, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jlx, (int) R.color.cp_link_tip_a);
    }
}
