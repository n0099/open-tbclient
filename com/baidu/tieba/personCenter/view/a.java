package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView aet;
    private View dWa;
    private TextView iZo;
    private TextView imF;
    private TextView kPU;
    private TextView kPV;
    private TextView kPW;
    private TextView kPX;
    private TextView kPY;
    private LinearLayout kPZ;
    private LinearLayout kQa;
    private LinearLayout kQb;
    private LinearLayout kQc;
    private int kQd;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.kQd = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.dWa = view.findViewById(R.id.bottom_divider_line);
        this.imF = (TextView) view.findViewById(R.id.fans_num);
        this.kPU = (TextView) view.findViewById(R.id.fans_title);
        this.kPV = (TextView) view.findViewById(R.id.concer_num);
        this.kPW = (TextView) view.findViewById(R.id.concer_title);
        this.kPX = (TextView) view.findViewById(R.id.attention_bar_num);
        this.kPY = (TextView) view.findViewById(R.id.attention_bar_title);
        this.iZo = (TextView) view.findViewById(R.id.thread_num);
        this.aet = (TextView) view.findViewById(R.id.thread_title);
        this.kPZ = (LinearLayout) view.findViewById(R.id.fans_action);
        this.kQa = (LinearLayout) view.findViewById(R.id.concer_action);
        this.kQb = (LinearLayout) view.findViewById(R.id.attention_action);
        this.kQc = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.dWa.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.imF, R.color.cp_cont_b);
            ao.setViewTextColor(this.kPU, R.color.cp_cont_d);
            ao.setViewTextColor(this.kPV, R.color.cp_cont_b);
            ao.setViewTextColor(this.kPW, R.color.cp_cont_d);
            ao.setViewTextColor(this.kPX, R.color.cp_cont_b);
            ao.setViewTextColor(this.kPY, R.color.cp_cont_d);
            ao.setViewTextColor(this.iZo, R.color.cp_cont_b);
            ao.setViewTextColor(this.aet, R.color.cp_cont_d);
            ao.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.dWa, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.bbq().mj(1).mk(4096).mq(R.color.cp_bg_line_e).ml(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aX(getView());
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personCenter.c.d dVar) {
        this.mUserData = dVar.userData;
        this.kQd = dVar.kOW;
        this.imF.setText(as.numFormatOverWanNa(dVar.kOV));
        this.kPV.setText(Integer.toString(dVar.kOW));
        this.kPX.setText(Integer.toString(dVar.kOX));
        this.iZo.setText(as.longNumFormatOver9999wan(dVar.threadNum));
        this.kPZ.setOnClickListener(this);
        this.kQa.setOnClickListener(this);
        this.kQb.setOnClickListener(this);
        this.kQc.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.ddy().g(2, false, true);
                    TiebaStatic.log(new ap("c12523").ah("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new ap("c12523").ah("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.kQd, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new ap("c12523").ah("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new ap("c12523").ah("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
