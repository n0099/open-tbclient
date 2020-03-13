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
    private View cVv;
    private TextView gRD;
    private TextView hzi;
    private TextView jim;
    private TextView jin;
    private TextView jio;
    private TextView jip;
    private TextView jiq;
    private ImageView jir;
    private LinearLayout jis;
    private LinearLayout jit;
    private LinearLayout jiu;
    private LinearLayout jiv;
    private int jiw;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.jiw = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.cVv = view.findViewById(R.id.bottom_divider_line);
        this.gRD = (TextView) view.findViewById(R.id.fans_num);
        this.jim = (TextView) view.findViewById(R.id.fans_title);
        this.jin = (TextView) view.findViewById(R.id.concer_num);
        this.jio = (TextView) view.findViewById(R.id.concer_title);
        this.jip = (TextView) view.findViewById(R.id.attention_bar_num);
        this.jiq = (TextView) view.findViewById(R.id.attention_bar_title);
        this.hzi = (TextView) view.findViewById(R.id.thread_num);
        this.KD = (TextView) view.findViewById(R.id.thread_title);
        this.jis = (LinearLayout) view.findViewById(R.id.fans_action);
        this.jit = (LinearLayout) view.findViewById(R.id.concer_action);
        this.jiu = (LinearLayout) view.findViewById(R.id.attention_action);
        this.jiv = (LinearLayout) view.findViewById(R.id.thread_action);
        this.jir = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.cVv.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gRD, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jim, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jin, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jio, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jip, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jiq, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hzi, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.KD, (int) R.color.cp_cont_d);
            am.setImageResource(this.jir, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.cVv, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.aHa().kK(1).kL(4096).kR(R.color.cp_bg_line_e).kM(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aQ(getView());
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
        this.jiw = dVar.jhv;
        this.gRD.setText(aq.numFormatOverWanNa(dVar.jhu));
        this.jin.setText(Integer.toString(dVar.jhv));
        this.jip.setText(Integer.toString(dVar.jhw));
        this.hzi.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.jhx) {
            this.jir.setVisibility(0);
        } else {
            this.jir.setVisibility(8);
        }
        this.jis.setOnClickListener(this);
        this.jit.setOnClickListener(this);
        this.jiu.setOnClickListener(this);
        this.jiv.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.jir.setVisibility(8);
                    com.baidu.tieba.p.a.cDQ().g(2, false, true);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").X("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.jiw, this.mUserData.getPortrait())));
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
