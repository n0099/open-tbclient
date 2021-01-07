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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView aif;
    private View eXI;
    private TextView jQi;
    private TextView kDp;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;
    private TextView mqc;
    private TextView mqd;
    private TextView mqe;
    private TextView mqf;
    private TextView mqg;
    private LinearLayout mqh;
    private LinearLayout mqi;
    private LinearLayout mqj;
    private LinearLayout mqk;
    private int mql;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mql = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eXI = view.findViewById(R.id.bottom_divider_line);
        this.jQi = (TextView) view.findViewById(R.id.fans_num);
        this.mqc = (TextView) view.findViewById(R.id.fans_title);
        this.mqd = (TextView) view.findViewById(R.id.concer_num);
        this.mqe = (TextView) view.findViewById(R.id.concer_title);
        this.mqf = (TextView) view.findViewById(R.id.attention_bar_num);
        this.mqg = (TextView) view.findViewById(R.id.attention_bar_title);
        this.kDp = (TextView) view.findViewById(R.id.thread_num);
        this.aif = (TextView) view.findViewById(R.id.thread_title);
        this.mqh = (LinearLayout) view.findViewById(R.id.fans_action);
        this.mqi = (LinearLayout) view.findViewById(R.id.concer_action);
        this.mqj = (LinearLayout) view.findViewById(R.id.attention_action);
        this.mqk = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eXI.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.jQi, R.color.CAM_X0105);
            ao.setViewTextColor(this.mqc, R.color.CAM_X0109);
            ao.setViewTextColor(this.mqd, R.color.CAM_X0105);
            ao.setViewTextColor(this.mqe, R.color.CAM_X0109);
            ao.setViewTextColor(this.mqf, R.color.CAM_X0105);
            ao.setViewTextColor(this.mqg, R.color.CAM_X0109);
            ao.setViewTextColor(this.kDp, R.color.CAM_X0105);
            ao.setViewTextColor(this.aif, R.color.CAM_X0109);
            ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ao.setBackgroundColor(this.eXI, R.color.CAM_X0204);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.f.a.bwU().qB(1).qC(4096).qI(R.color.CAM_X0205).qD(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bz(getView());
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
        this.mql = dVar.mpe;
        this.jQi.setText(at.numFormatOverWanNa(dVar.mpd));
        this.mqd.setText(Integer.toString(dVar.mpe));
        this.mqf.setText(Integer.toString(dVar.mpf));
        this.kDp.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.mqh.setOnClickListener(this);
        this.mqi.setOnClickListener(this);
        this.mqj.setOnClickListener(this);
        this.mqk.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dGE().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.mql, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new aq("c12523").an("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new aq("c12523").an("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
