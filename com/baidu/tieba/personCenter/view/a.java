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
    private TextView adD;
    private View duX;
    private TextView hCF;
    private TextView ikC;
    private TextView jUc;
    private TextView jUd;
    private TextView jUe;
    private TextView jUf;
    private TextView jUg;
    private ImageView jUh;
    private LinearLayout jUi;
    private LinearLayout jUj;
    private LinearLayout jUk;
    private LinearLayout jUl;
    private int jUm;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.jUm = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.duX = view.findViewById(R.id.bottom_divider_line);
        this.hCF = (TextView) view.findViewById(R.id.fans_num);
        this.jUc = (TextView) view.findViewById(R.id.fans_title);
        this.jUd = (TextView) view.findViewById(R.id.concer_num);
        this.jUe = (TextView) view.findViewById(R.id.concer_title);
        this.jUf = (TextView) view.findViewById(R.id.attention_bar_num);
        this.jUg = (TextView) view.findViewById(R.id.attention_bar_title);
        this.ikC = (TextView) view.findViewById(R.id.thread_num);
        this.adD = (TextView) view.findViewById(R.id.thread_title);
        this.jUi = (LinearLayout) view.findViewById(R.id.fans_action);
        this.jUj = (LinearLayout) view.findViewById(R.id.concer_action);
        this.jUk = (LinearLayout) view.findViewById(R.id.attention_action);
        this.jUl = (LinearLayout) view.findViewById(R.id.thread_action);
        this.jUh = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.duX.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.hCF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jUc, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jUd, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jUe, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jUf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jUg, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ikC, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.adD, (int) R.color.cp_cont_d);
            am.setImageResource(this.jUh, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.duX, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.aPq().kU(1).kV(4096).lb(R.color.cp_bg_line_e).kW(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aR(getView());
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
        this.jUm = dVar.jTj;
        this.hCF.setText(aq.numFormatOverWanNa(dVar.jTi));
        this.jUd.setText(Integer.toString(dVar.jTj));
        this.jUf.setText(Integer.toString(dVar.jTk));
        this.ikC.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.jTl) {
            this.jUh.setVisibility(0);
        } else {
            this.jUh.setVisibility(8);
        }
        this.jUi.setOnClickListener(this);
        this.jUj.setOnClickListener(this);
        this.jUk.setOnClickListener(this);
        this.jUl.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.jUh.setVisibility(8);
                    com.baidu.tieba.p.a.cOI().g(2, false, true);
                    TiebaStatic.log(new an("c12523").af("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").af("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.jUm, this.mUserData.getPortrait())));
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
