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
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView ago;
    private View eub;
    private TextView iXc;
    private TextView jLU;
    private TextView lEa;
    private TextView lEb;
    private TextView lEc;
    private TextView lEd;
    private TextView lEe;
    private LinearLayout lEf;
    private LinearLayout lEg;
    private LinearLayout lEh;
    private LinearLayout lEi;
    private int lEj;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.lEj = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eub = view.findViewById(R.id.bottom_divider_line);
        this.iXc = (TextView) view.findViewById(R.id.fans_num);
        this.lEa = (TextView) view.findViewById(R.id.fans_title);
        this.lEb = (TextView) view.findViewById(R.id.concer_num);
        this.lEc = (TextView) view.findViewById(R.id.concer_title);
        this.lEd = (TextView) view.findViewById(R.id.attention_bar_num);
        this.lEe = (TextView) view.findViewById(R.id.attention_bar_title);
        this.jLU = (TextView) view.findViewById(R.id.thread_num);
        this.ago = (TextView) view.findViewById(R.id.thread_title);
        this.lEf = (LinearLayout) view.findViewById(R.id.fans_action);
        this.lEg = (LinearLayout) view.findViewById(R.id.concer_action);
        this.lEh = (LinearLayout) view.findViewById(R.id.attention_action);
        this.lEi = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eub.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.iXc, R.color.cp_cont_b);
            ap.setViewTextColor(this.lEa, R.color.cp_cont_d);
            ap.setViewTextColor(this.lEb, R.color.cp_cont_b);
            ap.setViewTextColor(this.lEc, R.color.cp_cont_d);
            ap.setViewTextColor(this.lEd, R.color.cp_cont_b);
            ap.setViewTextColor(this.lEe, R.color.cp_cont_d);
            ap.setViewTextColor(this.jLU, R.color.cp_cont_b);
            ap.setViewTextColor(this.ago, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.eub, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.bnu().oX(1).oY(4096).pe(R.color.cp_bg_line_e).oZ(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bf(getView());
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
        this.lEj = dVar.lDc;
        this.iXc.setText(at.numFormatOverWanNa(dVar.lDb));
        this.lEb.setText(Integer.toString(dVar.lDc));
        this.lEd.setText(Integer.toString(dVar.lDd));
        this.jLU.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.lEf.setOnClickListener(this);
        this.lEg.setOnClickListener(this);
        this.lEh.setOnClickListener(this);
        this.lEi.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dwo().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").aj("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").aj("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.lEj, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new aq("c12523").aj("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new aq("c12523").aj("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
