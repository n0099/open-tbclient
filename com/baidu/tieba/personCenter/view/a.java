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
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView afW;
    private View ehT;
    private TextView iIk;
    private TextView jwX;
    private TextView loN;
    private TextView loO;
    private TextView loP;
    private TextView loQ;
    private TextView loR;
    private LinearLayout loS;
    private LinearLayout loT;
    private LinearLayout loU;
    private LinearLayout loV;
    private int loW;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.loW = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.ehT = view.findViewById(R.id.bottom_divider_line);
        this.iIk = (TextView) view.findViewById(R.id.fans_num);
        this.loN = (TextView) view.findViewById(R.id.fans_title);
        this.loO = (TextView) view.findViewById(R.id.concer_num);
        this.loP = (TextView) view.findViewById(R.id.concer_title);
        this.loQ = (TextView) view.findViewById(R.id.attention_bar_num);
        this.loR = (TextView) view.findViewById(R.id.attention_bar_title);
        this.jwX = (TextView) view.findViewById(R.id.thread_num);
        this.afW = (TextView) view.findViewById(R.id.thread_title);
        this.loS = (LinearLayout) view.findViewById(R.id.fans_action);
        this.loT = (LinearLayout) view.findViewById(R.id.concer_action);
        this.loU = (LinearLayout) view.findViewById(R.id.attention_action);
        this.loV = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.ehT.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.iIk, R.color.cp_cont_b);
            ap.setViewTextColor(this.loN, R.color.cp_cont_d);
            ap.setViewTextColor(this.loO, R.color.cp_cont_b);
            ap.setViewTextColor(this.loP, R.color.cp_cont_d);
            ap.setViewTextColor(this.loQ, R.color.cp_cont_b);
            ap.setViewTextColor(this.loR, R.color.cp_cont_d);
            ap.setViewTextColor(this.jwX, R.color.cp_cont_b);
            ap.setViewTextColor(this.afW, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.ehT, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.bkK().oz(1).oA(4096).oG(R.color.cp_bg_line_e).oB(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bb(getView());
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
        this.loW = dVar.lnL;
        this.iIk.setText(at.numFormatOverWanNa(dVar.lnK));
        this.loO.setText(Integer.toString(dVar.lnL));
        this.loQ.setText(Integer.toString(dVar.lnM));
        this.jwX.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.loS.setOnClickListener(this);
        this.loT.setOnClickListener(this);
        this.loU.setOnClickListener(this);
        this.loV.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dsD().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.loW, this.mUserData.getPortrait())));
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
