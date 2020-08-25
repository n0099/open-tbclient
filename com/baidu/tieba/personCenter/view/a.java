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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView afC;
    private View efA;
    private TextView iAJ;
    private TextView joo;
    private TextView lfK;
    private TextView lfL;
    private TextView lfM;
    private TextView lfN;
    private TextView lfO;
    private LinearLayout lfP;
    private LinearLayout lfQ;
    private LinearLayout lfR;
    private LinearLayout lfS;
    private int lfT;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.lfT = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.efA = view.findViewById(R.id.bottom_divider_line);
        this.iAJ = (TextView) view.findViewById(R.id.fans_num);
        this.lfK = (TextView) view.findViewById(R.id.fans_title);
        this.lfL = (TextView) view.findViewById(R.id.concer_num);
        this.lfM = (TextView) view.findViewById(R.id.concer_title);
        this.lfN = (TextView) view.findViewById(R.id.attention_bar_num);
        this.lfO = (TextView) view.findViewById(R.id.attention_bar_title);
        this.joo = (TextView) view.findViewById(R.id.thread_num);
        this.afC = (TextView) view.findViewById(R.id.thread_title);
        this.lfP = (LinearLayout) view.findViewById(R.id.fans_action);
        this.lfQ = (LinearLayout) view.findViewById(R.id.concer_action);
        this.lfR = (LinearLayout) view.findViewById(R.id.attention_action);
        this.lfS = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.efA.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.iAJ, R.color.cp_cont_b);
            ap.setViewTextColor(this.lfK, R.color.cp_cont_d);
            ap.setViewTextColor(this.lfL, R.color.cp_cont_b);
            ap.setViewTextColor(this.lfM, R.color.cp_cont_d);
            ap.setViewTextColor(this.lfN, R.color.cp_cont_b);
            ap.setViewTextColor(this.lfO, R.color.cp_cont_d);
            ap.setViewTextColor(this.joo, R.color.cp_cont_b);
            ap.setViewTextColor(this.afC, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.efA, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.bjP().on(1).oo(4096).ou(R.color.cp_bg_line_e).op(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aZ(getView());
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
        this.lfT = dVar.leM;
        this.iAJ.setText(at.numFormatOverWanNa(dVar.leL));
        this.lfL.setText(Integer.toString(dVar.leM));
        this.lfN.setText(Integer.toString(dVar.leN));
        this.joo.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.lfP.setOnClickListener(this);
        this.lfQ.setOnClickListener(this);
        this.lfR.setOnClickListener(this);
        this.lfS.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.doQ().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.lfT, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new aq("c12523").ai("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new aq("c12523").ai("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
