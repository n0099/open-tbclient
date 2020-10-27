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
    private TextView agp;
    private View eCA;
    private TextView jYs;
    private TextView jjz;
    private TextView lQA;
    private LinearLayout lQB;
    private LinearLayout lQC;
    private LinearLayout lQD;
    private LinearLayout lQE;
    private int lQF;
    private TextView lQw;
    private TextView lQx;
    private TextView lQy;
    private TextView lQz;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.lQF = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eCA = view.findViewById(R.id.bottom_divider_line);
        this.jjz = (TextView) view.findViewById(R.id.fans_num);
        this.lQw = (TextView) view.findViewById(R.id.fans_title);
        this.lQx = (TextView) view.findViewById(R.id.concer_num);
        this.lQy = (TextView) view.findViewById(R.id.concer_title);
        this.lQz = (TextView) view.findViewById(R.id.attention_bar_num);
        this.lQA = (TextView) view.findViewById(R.id.attention_bar_title);
        this.jYs = (TextView) view.findViewById(R.id.thread_num);
        this.agp = (TextView) view.findViewById(R.id.thread_title);
        this.lQB = (LinearLayout) view.findViewById(R.id.fans_action);
        this.lQC = (LinearLayout) view.findViewById(R.id.concer_action);
        this.lQD = (LinearLayout) view.findViewById(R.id.attention_action);
        this.lQE = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eCA.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.jjz, R.color.cp_cont_b);
            ap.setViewTextColor(this.lQw, R.color.cp_cont_d);
            ap.setViewTextColor(this.lQx, R.color.cp_cont_b);
            ap.setViewTextColor(this.lQy, R.color.cp_cont_d);
            ap.setViewTextColor(this.lQz, R.color.cp_cont_b);
            ap.setViewTextColor(this.lQA, R.color.cp_cont_d);
            ap.setViewTextColor(this.jYs, R.color.cp_cont_b);
            ap.setViewTextColor(this.agp, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.eCA, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.bpn().pi(1).pj(4096).pq(R.color.cp_bg_line_e).pk(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bg(getView());
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
        this.lQF = dVar.lPz;
        this.jjz.setText(at.numFormatOverWanNa(dVar.lPy));
        this.lQx.setText(Integer.toString(dVar.lPz));
        this.lQz.setText(Integer.toString(dVar.lPA));
        this.jYs.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.lQB.setOnClickListener(this);
        this.lQC.setOnClickListener(this);
        this.lQD.setOnClickListener(this);
        this.lQE.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dzw().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").aj("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").aj("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.lQF, this.mUserData.getPortrait())));
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
