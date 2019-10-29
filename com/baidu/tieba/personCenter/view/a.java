package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.d> {
    private TextView FM;
    private TextView fYn;
    private TextView gGf;
    private LinearLayout imA;
    private LinearLayout imB;
    private LinearLayout imC;
    private LinearLayout imD;
    private TextView imt;
    private TextView imu;
    private TextView imv;
    private TextView imw;
    private TextView imx;
    private ImageView imy;
    private LinearLayout imz;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fYn = (TextView) view.findViewById(R.id.fans_num);
        this.imt = (TextView) view.findViewById(R.id.fans_title);
        this.imu = (TextView) view.findViewById(R.id.concer_num);
        this.imv = (TextView) view.findViewById(R.id.concer_title);
        this.imw = (TextView) view.findViewById(R.id.attention_bar_num);
        this.imx = (TextView) view.findViewById(R.id.attention_bar_title);
        this.gGf = (TextView) view.findViewById(R.id.thread_num);
        this.FM = (TextView) view.findViewById(R.id.thread_title);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.imD = (LinearLayout) view.findViewById(R.id.attention_container);
        this.imz = (LinearLayout) view.findViewById(R.id.fans_action);
        this.imA = (LinearLayout) view.findViewById(R.id.concer_action);
        this.imB = (LinearLayout) view.findViewById(R.id.attention_action);
        this.imC = (LinearLayout) view.findViewById(R.id.thread_action);
        this.imy = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fYn, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.imt, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.imu, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.imv, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.imw, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.imx, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.gGf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.FM, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.imy.setImageDrawable(am.getDrawable(i, (int) R.drawable.person_center_red_tip_shape));
            if (this.imD != null) {
                for (int i2 = 0; i2 < this.imD.getChildCount(); i2++) {
                    View childAt = this.imD.getChildAt(i2);
                    if (childAt != null) {
                        childAt.setBackgroundDrawable(am.it(R.color.cp_bg_line_e));
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.d dVar) {
        this.mUserData = dVar.userData;
        this.fYn.setText(Integer.toString(dVar.ilC));
        this.imu.setText(Integer.toString(dVar.ilD));
        this.imw.setText(Integer.toString(dVar.ilE));
        this.gGf.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.ilF) {
            this.imy.setVisibility(0);
        } else {
            this.imy.setVisibility(8);
        }
        this.imz.setOnClickListener(this);
        this.imA.setOnClickListener(this);
        this.imB.setOnClickListener(this);
        this.imC.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.imy.setVisibility(8);
                    com.baidu.tieba.o.a.chd().e(2, false, true);
                    TiebaStatic.log(new an("c12523").O("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == R.id.concer_action) {
                TiebaStatic.log(new an("c12523").O("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new an("c12523").O("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new an("c12523").O("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
