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
    private View eIp;
    private TextView jpx;
    private TextView kep;
    private LinearLayout lWA;
    private int lWB;
    private TextView lWs;
    private TextView lWt;
    private TextView lWu;
    private TextView lWv;
    private TextView lWw;
    private LinearLayout lWx;
    private LinearLayout lWy;
    private LinearLayout lWz;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.lWB = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eIp = view.findViewById(R.id.bottom_divider_line);
        this.jpx = (TextView) view.findViewById(R.id.fans_num);
        this.lWs = (TextView) view.findViewById(R.id.fans_title);
        this.lWt = (TextView) view.findViewById(R.id.concer_num);
        this.lWu = (TextView) view.findViewById(R.id.concer_title);
        this.lWv = (TextView) view.findViewById(R.id.attention_bar_num);
        this.lWw = (TextView) view.findViewById(R.id.attention_bar_title);
        this.kep = (TextView) view.findViewById(R.id.thread_num);
        this.agp = (TextView) view.findViewById(R.id.thread_title);
        this.lWx = (LinearLayout) view.findViewById(R.id.fans_action);
        this.lWy = (LinearLayout) view.findViewById(R.id.concer_action);
        this.lWz = (LinearLayout) view.findViewById(R.id.attention_action);
        this.lWA = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eIp.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.jpx, R.color.cp_cont_b);
            ap.setViewTextColor(this.lWs, R.color.cp_cont_d);
            ap.setViewTextColor(this.lWt, R.color.cp_cont_b);
            ap.setViewTextColor(this.lWu, R.color.cp_cont_d);
            ap.setViewTextColor(this.lWv, R.color.cp_cont_b);
            ap.setViewTextColor(this.lWw, R.color.cp_cont_d);
            ap.setViewTextColor(this.kep, R.color.cp_cont_b);
            ap.setViewTextColor(this.agp, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.eIp, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.brN().pt(1).pu(4096).pA(R.color.cp_bg_line_e).pv(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bk(getView());
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
        this.lWB = dVar.lVv;
        this.jpx.setText(at.numFormatOverWanNa(dVar.lVu));
        this.lWt.setText(Integer.toString(dVar.lVv));
        this.lWv.setText(Integer.toString(dVar.lVw));
        this.kep.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.lWx.setOnClickListener(this);
        this.lWy.setOnClickListener(this);
        this.lWz.setOnClickListener(this);
        this.lWA.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dBY().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.lWB, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new aq("c12523").al("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new aq("c12523").al("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
