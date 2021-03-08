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
    private TextView aiu;
    private View eWL;
    private TextView jUw;
    private TextView kJg;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;
    private TextView mwP;
    private TextView mwQ;
    private TextView mwR;
    private TextView mwS;
    private TextView mwT;
    private LinearLayout mwU;
    private LinearLayout mwV;
    private LinearLayout mwW;
    private LinearLayout mwX;
    private int mwY;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mwY = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eWL = view.findViewById(R.id.bottom_divider_line);
        this.jUw = (TextView) view.findViewById(R.id.fans_num);
        this.mwP = (TextView) view.findViewById(R.id.fans_title);
        this.mwQ = (TextView) view.findViewById(R.id.concer_num);
        this.mwR = (TextView) view.findViewById(R.id.concer_title);
        this.mwS = (TextView) view.findViewById(R.id.attention_bar_num);
        this.mwT = (TextView) view.findViewById(R.id.attention_bar_title);
        this.kJg = (TextView) view.findViewById(R.id.thread_num);
        this.aiu = (TextView) view.findViewById(R.id.thread_title);
        this.mwU = (LinearLayout) view.findViewById(R.id.fans_action);
        this.mwV = (LinearLayout) view.findViewById(R.id.concer_action);
        this.mwW = (LinearLayout) view.findViewById(R.id.attention_action);
        this.mwX = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eWL.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.jUw, R.color.CAM_X0105);
            ap.setViewTextColor(this.mwP, R.color.CAM_X0109);
            ap.setViewTextColor(this.mwQ, R.color.CAM_X0105);
            ap.setViewTextColor(this.mwR, R.color.CAM_X0109);
            ap.setViewTextColor(this.mwS, R.color.CAM_X0105);
            ap.setViewTextColor(this.mwT, R.color.CAM_X0109);
            ap.setViewTextColor(this.kJg, R.color.CAM_X0105);
            ap.setViewTextColor(this.aiu, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.eWL, R.color.CAM_X0204);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.f.a.btx().pa(1).pb(4096).ph(R.color.CAM_X0205).pc(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bv(getView());
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
        this.mwY = dVar.mvS;
        this.jUw.setText(au.numFormatOverWanNa(dVar.mvR));
        this.mwQ.setText(Integer.toString(dVar.mvS));
        this.mwS.setText(Integer.toString(dVar.mvT));
        this.kJg.setText(au.longNumFormatOver9999wan(dVar.threadNum));
        this.mwU.setOnClickListener(this);
        this.mwV.setOnClickListener(this);
        this.mwW.setOnClickListener(this);
        this.mwX.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dFm().h(2, false, true);
                    TiebaStatic.log(new ar("c12523").aq("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new ar("c12523").aq("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.mwY, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new ar("c12523").aq("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new ar("c12523").aq("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
