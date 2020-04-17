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
    private TextView adA;
    private View duT;
    private TextView hCz;
    private TextView ikw;
    private TextView jTY;
    private TextView jTZ;
    private TextView jUa;
    private TextView jUb;
    private TextView jUc;
    private ImageView jUd;
    private LinearLayout jUe;
    private LinearLayout jUf;
    private LinearLayout jUg;
    private LinearLayout jUh;
    private int jUi;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.jUi = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.duT = view.findViewById(R.id.bottom_divider_line);
        this.hCz = (TextView) view.findViewById(R.id.fans_num);
        this.jTY = (TextView) view.findViewById(R.id.fans_title);
        this.jTZ = (TextView) view.findViewById(R.id.concer_num);
        this.jUa = (TextView) view.findViewById(R.id.concer_title);
        this.jUb = (TextView) view.findViewById(R.id.attention_bar_num);
        this.jUc = (TextView) view.findViewById(R.id.attention_bar_title);
        this.ikw = (TextView) view.findViewById(R.id.thread_num);
        this.adA = (TextView) view.findViewById(R.id.thread_title);
        this.jUe = (LinearLayout) view.findViewById(R.id.fans_action);
        this.jUf = (LinearLayout) view.findViewById(R.id.concer_action);
        this.jUg = (LinearLayout) view.findViewById(R.id.attention_action);
        this.jUh = (LinearLayout) view.findViewById(R.id.thread_action);
        this.jUd = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.duT.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.hCz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jTY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jTZ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jUa, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jUb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jUc, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ikw, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.adA, (int) R.color.cp_cont_d);
            am.setImageResource(this.jUd, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.duT, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.aPt().kU(1).kV(4096).lb(R.color.cp_bg_line_e).kW(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aR(getView());
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
        this.jUi = dVar.jTf;
        this.hCz.setText(aq.numFormatOverWanNa(dVar.jTe));
        this.jTZ.setText(Integer.toString(dVar.jTf));
        this.jUb.setText(Integer.toString(dVar.jTg));
        this.ikw.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.jTh) {
            this.jUd.setVisibility(0);
        } else {
            this.jUd.setVisibility(8);
        }
        this.jUe.setOnClickListener(this);
        this.jUf.setOnClickListener(this);
        this.jUg.setOnClickListener(this);
        this.jUh.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.jUd.setVisibility(8);
                    com.baidu.tieba.p.a.cOL().g(2, false, true);
                    TiebaStatic.log(new an("c12523").af("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").af("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.jUi, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new an("c12523").af("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new an("c12523").af("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
