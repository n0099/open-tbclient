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
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.c.d> {
    private TextView KD;
    private View cVI;
    private TextView gSK;
    private TextView hAI;
    private TextView jjL;
    private TextView jjM;
    private TextView jjN;
    private TextView jjO;
    private TextView jjP;
    private ImageView jjQ;
    private LinearLayout jjR;
    private LinearLayout jjS;
    private LinearLayout jjT;
    private LinearLayout jjU;
    private int jjV;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.jjV = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.cVI = view.findViewById(R.id.bottom_divider_line);
        this.gSK = (TextView) view.findViewById(R.id.fans_num);
        this.jjL = (TextView) view.findViewById(R.id.fans_title);
        this.jjM = (TextView) view.findViewById(R.id.concer_num);
        this.jjN = (TextView) view.findViewById(R.id.concer_title);
        this.jjO = (TextView) view.findViewById(R.id.attention_bar_num);
        this.jjP = (TextView) view.findViewById(R.id.attention_bar_title);
        this.hAI = (TextView) view.findViewById(R.id.thread_num);
        this.KD = (TextView) view.findViewById(R.id.thread_title);
        this.jjR = (LinearLayout) view.findViewById(R.id.fans_action);
        this.jjS = (LinearLayout) view.findViewById(R.id.concer_action);
        this.jjT = (LinearLayout) view.findViewById(R.id.attention_action);
        this.jjU = (LinearLayout) view.findViewById(R.id.thread_action);
        this.jjQ = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.cVI.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gSK, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jjL, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jjM, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jjN, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jjO, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jjP, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hAI, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.KD, (int) R.color.cp_cont_d);
            am.setImageResource(this.jjQ, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.cVI, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.aHe().kK(1).kL(4096).kR(R.color.cp_bg_line_e).kM(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aQ(getView());
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.c.d dVar) {
        this.mUserData = dVar.userData;
        this.jjV = dVar.jiV;
        this.gSK.setText(aq.numFormatOverWanNa(dVar.jiU));
        this.jjM.setText(Integer.toString(dVar.jiV));
        this.jjO.setText(Integer.toString(dVar.jiW));
        this.hAI.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.jiX) {
            this.jjQ.setVisibility(0);
        } else {
            this.jjQ.setVisibility(8);
        }
        this.jjR.setOnClickListener(this);
        this.jjS.setOnClickListener(this);
        this.jjT.setOnClickListener(this);
        this.jjU.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.jjQ.setVisibility(8);
                    com.baidu.tieba.p.a.cEk().g(2, false, true);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").X("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.jjV, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new an("c12523").X("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new an("c12523").X("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
