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
    private TextView iZm;
    private TextView imD;
    private TextView kPS;
    private TextView kPT;
    private TextView kPU;
    private TextView kPV;
    private TextView kPW;
    private LinearLayout kPX;
    private LinearLayout kPY;
    private LinearLayout kPZ;
    private LinearLayout kQa;
    private int kQb;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.kQb = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.dWa = view.findViewById(R.id.bottom_divider_line);
        this.imD = (TextView) view.findViewById(R.id.fans_num);
        this.kPS = (TextView) view.findViewById(R.id.fans_title);
        this.kPT = (TextView) view.findViewById(R.id.concer_num);
        this.kPU = (TextView) view.findViewById(R.id.concer_title);
        this.kPV = (TextView) view.findViewById(R.id.attention_bar_num);
        this.kPW = (TextView) view.findViewById(R.id.attention_bar_title);
        this.iZm = (TextView) view.findViewById(R.id.thread_num);
        this.aet = (TextView) view.findViewById(R.id.thread_title);
        this.kPX = (LinearLayout) view.findViewById(R.id.fans_action);
        this.kPY = (LinearLayout) view.findViewById(R.id.concer_action);
        this.kPZ = (LinearLayout) view.findViewById(R.id.attention_action);
        this.kQa = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.dWa.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.imD, R.color.cp_cont_b);
            ao.setViewTextColor(this.kPS, R.color.cp_cont_d);
            ao.setViewTextColor(this.kPT, R.color.cp_cont_b);
            ao.setViewTextColor(this.kPU, R.color.cp_cont_d);
            ao.setViewTextColor(this.kPV, R.color.cp_cont_b);
            ao.setViewTextColor(this.kPW, R.color.cp_cont_d);
            ao.setViewTextColor(this.iZm, R.color.cp_cont_b);
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
        this.kQb = dVar.kOU;
        this.imD.setText(as.numFormatOverWanNa(dVar.kOT));
        this.kPT.setText(Integer.toString(dVar.kOU));
        this.kPV.setText(Integer.toString(dVar.kOV));
        this.iZm.setText(as.longNumFormatOver9999wan(dVar.threadNum));
        this.kPX.setOnClickListener(this);
        this.kPY.setOnClickListener(this);
        this.kPZ.setOnClickListener(this);
        this.kQa.setOnClickListener(this);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.kQb, this.mUserData.getPortrait())));
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
