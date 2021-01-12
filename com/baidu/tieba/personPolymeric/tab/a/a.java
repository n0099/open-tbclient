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
/* loaded from: classes7.dex */
public class a {
    private com.baidu.tbadk.core.dialog.a ada;
    private TbImageView iTA;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private TextView mTip;
    private TextView mTitle;
    private TextView muh;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ada != null) {
                a.this.ada.dismiss();
            }
        }
    };
    private boolean mug = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_person_dynamic_tab_guide_has_shown", false);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void dxa() {
        if (!this.mug) {
            this.mug = true;
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_person_dynamic_tab_guide_has_shown", true);
            initView();
            this.ada = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.ada.nx(1);
            this.ada.jD(true);
            this.ada.jE(false);
            this.ada.br(this.mRootView);
            this.ada.b(this.mTbPageContext).bqe();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.iTA = (TbImageView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        i(this.iTA);
        this.iTA.setAutoChangeStyle(true);
        this.iTA.setRadius(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24));
        this.iTA.setConrers(3);
        this.iTA.setIsBitmapPic(true);
        this.mTip = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        this.muh = (TextView) this.mRootView.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.muh.setOnClickListener(this.mOnClickListener);
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

    public boolean dxb() {
        return this.mug;
    }

    private void onChangeSkinType() {
        ao.setImageResource(this.iTA, R.drawable.pic_person_center_dynamic_guide);
        ao.setViewTextColor(this.mTip, R.color.CAM_X0107);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.muh, R.color.CAM_X0302);
    }
}
