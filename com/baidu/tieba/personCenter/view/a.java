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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView agu;
    private View eGI;
    private TextView jqe;
    private TextView kfa;
    private TextView lWK;
    private TextView lWL;
    private TextView lWM;
    private TextView lWN;
    private TextView lWO;
    private LinearLayout lWP;
    private LinearLayout lWQ;
    private LinearLayout lWR;
    private LinearLayout lWS;
    private int lWT;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.lWT = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eGI = view.findViewById(R.id.bottom_divider_line);
        this.jqe = (TextView) view.findViewById(R.id.fans_num);
        this.lWK = (TextView) view.findViewById(R.id.fans_title);
        this.lWL = (TextView) view.findViewById(R.id.concer_num);
        this.lWM = (TextView) view.findViewById(R.id.concer_title);
        this.lWN = (TextView) view.findViewById(R.id.attention_bar_num);
        this.lWO = (TextView) view.findViewById(R.id.attention_bar_title);
        this.kfa = (TextView) view.findViewById(R.id.thread_num);
        this.agu = (TextView) view.findViewById(R.id.thread_title);
        this.lWP = (LinearLayout) view.findViewById(R.id.fans_action);
        this.lWQ = (LinearLayout) view.findViewById(R.id.concer_action);
        this.lWR = (LinearLayout) view.findViewById(R.id.attention_action);
        this.lWS = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eGI.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.jqe, R.color.CAM_X0105);
            ap.setViewTextColor(this.lWK, R.color.CAM_X0109);
            ap.setViewTextColor(this.lWL, R.color.CAM_X0105);
            ap.setViewTextColor(this.lWM, R.color.CAM_X0109);
            ap.setViewTextColor(this.lWN, R.color.CAM_X0105);
            ap.setViewTextColor(this.lWO, R.color.CAM_X0109);
            ap.setViewTextColor(this.kfa, R.color.CAM_X0105);
            ap.setViewTextColor(this.agu, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.eGI, R.color.CAM_X0204);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.brb().pQ(1).pR(4096).pX(R.color.CAM_X0205).pS(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bn(getView());
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
        this.lWT = dVar.lVN;
        this.jqe.setText(au.numFormatOverWanNa(dVar.lVM));
        this.lWL.setText(Integer.toString(dVar.lVN));
        this.lWN.setText(Integer.toString(dVar.lVO));
        this.kfa.setText(au.longNumFormatOver9999wan(dVar.threadNum));
        this.lWP.setOnClickListener(this);
        this.lWQ.setOnClickListener(this);
        this.lWR.setOnClickListener(this);
        this.lWS.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.q.a.dBC().h(2, false, true);
                    TiebaStatic.log(new ar("c12523").ak("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new ar("c12523").ak("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.lWT, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new ar("c12523").ak("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new ar("c12523").ak("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
