package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.d> {
    private TextView Kb;
    private View cRh;
    private TextView gLU;
    private TextView hts;
    private TextView jdA;
    private TextView jdB;
    private ImageView jdC;
    private LinearLayout jdD;
    private LinearLayout jdE;
    private LinearLayout jdF;
    private LinearLayout jdG;
    private int jdH;
    private TextView jdx;
    private TextView jdy;
    private TextView jdz;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.jdH = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.cRh = view.findViewById(R.id.bottom_divider_line);
        this.gLU = (TextView) view.findViewById(R.id.fans_num);
        this.jdx = (TextView) view.findViewById(R.id.fans_title);
        this.jdy = (TextView) view.findViewById(R.id.concer_num);
        this.jdz = (TextView) view.findViewById(R.id.concer_title);
        this.jdA = (TextView) view.findViewById(R.id.attention_bar_num);
        this.jdB = (TextView) view.findViewById(R.id.attention_bar_title);
        this.hts = (TextView) view.findViewById(R.id.thread_num);
        this.Kb = (TextView) view.findViewById(R.id.thread_title);
        this.jdD = (LinearLayout) view.findViewById(R.id.fans_action);
        this.jdE = (LinearLayout) view.findViewById(R.id.concer_action);
        this.jdF = (LinearLayout) view.findViewById(R.id.attention_action);
        this.jdG = (LinearLayout) view.findViewById(R.id.thread_action);
        this.jdC = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.cRh.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gLU, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jdx, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jdy, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jdz, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jdA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jdB, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hts, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.Kb, (int) R.color.cp_cont_d);
            am.setImageResource(this.jdC, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.cRh, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.f.a.aEs().kt(1).ku(4096).kA(R.color.cp_bg_line_e).kv(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aM(getView());
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.d dVar) {
        this.mUserData = dVar.userData;
        this.jdH = dVar.jcG;
        this.gLU.setText(aq.numFormatOverWanNa(dVar.jcF));
        this.jdy.setText(Integer.toString(dVar.jcG));
        this.jdA.setText(Integer.toString(dVar.jcH));
        this.hts.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.jcI) {
            this.jdC.setVisibility(0);
        } else {
            this.jdC.setVisibility(8);
        }
        this.jdD.setOnClickListener(this);
        this.jdE.setOnClickListener(this);
        this.jdF.setOnClickListener(this);
        this.jdG.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.jdC.setVisibility(8);
                    com.baidu.tieba.o.a.cBe().g(2, false, true);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.getBaijiahaoInfo() != null)));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.getBaijiahaoInfo() != null).updateFollowNum(this.jdH, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new an("c12523").Z("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new an("c12523").Z("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
