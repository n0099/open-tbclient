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
    private TextView afE;
    private View efE;
    private TextView iAP;
    private TextView jou;
    private TextView lfR;
    private TextView lfS;
    private TextView lfT;
    private TextView lfU;
    private TextView lfV;
    private LinearLayout lfW;
    private LinearLayout lfX;
    private LinearLayout lfY;
    private LinearLayout lfZ;
    private int lga;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.lga = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.efE = view.findViewById(R.id.bottom_divider_line);
        this.iAP = (TextView) view.findViewById(R.id.fans_num);
        this.lfR = (TextView) view.findViewById(R.id.fans_title);
        this.lfS = (TextView) view.findViewById(R.id.concer_num);
        this.lfT = (TextView) view.findViewById(R.id.concer_title);
        this.lfU = (TextView) view.findViewById(R.id.attention_bar_num);
        this.lfV = (TextView) view.findViewById(R.id.attention_bar_title);
        this.jou = (TextView) view.findViewById(R.id.thread_num);
        this.afE = (TextView) view.findViewById(R.id.thread_title);
        this.lfW = (LinearLayout) view.findViewById(R.id.fans_action);
        this.lfX = (LinearLayout) view.findViewById(R.id.concer_action);
        this.lfY = (LinearLayout) view.findViewById(R.id.attention_action);
        this.lfZ = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.efE.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.iAP, R.color.cp_cont_b);
            ap.setViewTextColor(this.lfR, R.color.cp_cont_d);
            ap.setViewTextColor(this.lfS, R.color.cp_cont_b);
            ap.setViewTextColor(this.lfT, R.color.cp_cont_d);
            ap.setViewTextColor(this.lfU, R.color.cp_cont_b);
            ap.setViewTextColor(this.lfV, R.color.cp_cont_d);
            ap.setViewTextColor(this.jou, R.color.cp_cont_b);
            ap.setViewTextColor(this.afE, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.efE, R.color.cp_bg_line_c);
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
        this.lga = dVar.leT;
        this.iAP.setText(at.numFormatOverWanNa(dVar.leS));
        this.lfS.setText(Integer.toString(dVar.leT));
        this.lfU.setText(Integer.toString(dVar.leU));
        this.jou.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.lfW.setOnClickListener(this);
        this.lfX.setOnClickListener(this);
        this.lfY.setOnClickListener(this);
        this.lfZ.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.doT().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.lga, this.mUserData.getPortrait())));
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
