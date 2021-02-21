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
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a acU;
    private TbImageView iZv;
    private TextView mDA;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.acU != null) {
                a.this.acU.dismiss();
            }
        }
    };
    private boolean mDz = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void dzq() {
        if (!this.mDz) {
            this.mDz = true;
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.acU = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.acU.nA(1);
            this.acU.jF(true);
            this.acU.jG(false);
            this.acU.bn(this.mRootView);
            this.acU.b(this.mTbPageContext).bqx();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.iZv = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        i(this.iZv);
        this.iZv.setAutoChangeStyle(true);
        this.iZv.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.iZv.setConrers(3);
        this.iZv.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.mDA = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.mDA.setOnClickListener(this.mOnClickListener);
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

    public boolean dzr() {
        return this.mDz;
    }

    private void onChangeSkinType() {
        ap.setImageResource(this.iZv, R.drawable.pic_person_center_dynamic_guide);
        ap.setViewTextColor(this.mTip, R.color.CAM_X0107);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.mDA, R.color.CAM_X0302);
    }
}
