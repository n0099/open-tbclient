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
/* loaded from: classes7.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a aeo;
    private TbImageView jbe;
    private TextView mFC;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aeo != null) {
                a.this.aeo.dismiss();
            }
        }
    };
    private boolean mFB = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void dzz() {
        if (!this.mFB) {
            this.mFB = true;
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.aeo = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.aeo.nB(1);
            this.aeo.jF(true);
            this.aeo.jG(false);
            this.aeo.bn(this.mRootView);
            this.aeo.b(this.mTbPageContext).bqz();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.jbe = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        i(this.jbe);
        this.jbe.setAutoChangeStyle(true);
        this.jbe.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.jbe.setConrers(3);
        this.jbe.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.mFC = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.mFC.setOnClickListener(this.mOnClickListener);
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

    public boolean dzA() {
        return this.mFB;
    }

    private void onChangeSkinType() {
        ap.setImageResource(this.jbe, R.drawable.pic_person_center_dynamic_guide);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0107);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.mFC, R.color.CAM_X0302);
    }
}
