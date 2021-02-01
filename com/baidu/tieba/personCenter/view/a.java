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
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView ahb;
    private View eVm;
    private TextView jSz;
    private TextView kGQ;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;
    private TextView muA;
    private TextView muB;
    private TextView muC;
    private LinearLayout muD;
    private LinearLayout muE;
    private LinearLayout muF;
    private LinearLayout muG;
    private int muH;
    private TextView muy;
    private TextView muz;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.muH = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eVm = view.findViewById(R.id.bottom_divider_line);
        this.jSz = (TextView) view.findViewById(R.id.fans_num);
        this.muy = (TextView) view.findViewById(R.id.fans_title);
        this.muz = (TextView) view.findViewById(R.id.concer_num);
        this.muA = (TextView) view.findViewById(R.id.concer_title);
        this.muB = (TextView) view.findViewById(R.id.attention_bar_num);
        this.muC = (TextView) view.findViewById(R.id.attention_bar_title);
        this.kGQ = (TextView) view.findViewById(R.id.thread_num);
        this.ahb = (TextView) view.findViewById(R.id.thread_title);
        this.muD = (LinearLayout) view.findViewById(R.id.fans_action);
        this.muE = (LinearLayout) view.findViewById(R.id.concer_action);
        this.muF = (LinearLayout) view.findViewById(R.id.attention_action);
        this.muG = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eVm.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.jSz, R.color.CAM_X0105);
            ap.setViewTextColor(this.muy, R.color.CAM_X0109);
            ap.setViewTextColor(this.muz, R.color.CAM_X0105);
            ap.setViewTextColor(this.muA, R.color.CAM_X0109);
            ap.setViewTextColor(this.muB, R.color.CAM_X0105);
            ap.setViewTextColor(this.muC, R.color.CAM_X0109);
            ap.setViewTextColor(this.kGQ, R.color.CAM_X0105);
            ap.setViewTextColor(this.ahb, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.eVm, R.color.CAM_X0204);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.f.a.btu().oZ(1).pa(4096).pg(R.color.CAM_X0205).pb(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bv(getView());
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
        this.muH = dVar.mtB;
        this.jSz.setText(au.numFormatOverWanNa(dVar.mtA));
        this.muz.setText(Integer.toString(dVar.mtB));
        this.muB.setText(Integer.toString(dVar.mtC));
        this.kGQ.setText(au.longNumFormatOver9999wan(dVar.threadNum));
        this.muD.setOnClickListener(this);
        this.muE.setOnClickListener(this);
        this.muF.setOnClickListener(this);
        this.muG.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dEW().h(2, false, true);
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.muH, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new ar("c12523").ap("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new ar("c12523").ap("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
