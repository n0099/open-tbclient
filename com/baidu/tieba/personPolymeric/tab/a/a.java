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
/* loaded from: classes11.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a Zd;
    private TbImageView gRz;
    private TextView kce;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Zd != null) {
                a.this.Zd.dismiss();
            }
        }
    };
    private boolean kcd = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void cII() {
        if (!this.kcd) {
            this.kcd = true;
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.Zd = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.Zd.kg(1);
            this.Zd.gE(true);
            this.Zd.gF(false);
            this.Zd.aP(this.mRootView);
            this.Zd.b(this.mTbPageContext).aMU();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.gRz = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        j(this.gRz);
        this.gRz.setAutoChangeStyle(true);
        this.gRz.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.gRz.setConrers(3);
        this.gRz.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.kce = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.kce.setOnClickListener(this.mOnClickListener);
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

    public boolean cIJ() {
        return this.kcd;
    }

    private void onChangeSkinType() {
        am.setImageResource(this.gRz, R.drawable.pic_person_center_dynamic_guide);
        am.setViewTextColor(this.mTip, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kce, (int) R.color.cp_link_tip_a);
    }
}
