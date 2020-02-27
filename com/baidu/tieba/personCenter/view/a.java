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
    private View cVt;
    private TextView gRp;
    private TextView hyU;
    private TextView jhX;
    private TextView jhY;
    private TextView jhZ;
    private TextView jia;
    private TextView jib;
    private ImageView jic;
    private LinearLayout jie;
    private LinearLayout jif;
    private LinearLayout jig;
    private LinearLayout jih;
    private int jii;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.jii = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.cVt = view.findViewById(R.id.bottom_divider_line);
        this.gRp = (TextView) view.findViewById(R.id.fans_num);
        this.jhX = (TextView) view.findViewById(R.id.fans_title);
        this.jhY = (TextView) view.findViewById(R.id.concer_num);
        this.jhZ = (TextView) view.findViewById(R.id.concer_title);
        this.jia = (TextView) view.findViewById(R.id.attention_bar_num);
        this.jib = (TextView) view.findViewById(R.id.attention_bar_title);
        this.hyU = (TextView) view.findViewById(R.id.thread_num);
        this.KD = (TextView) view.findViewById(R.id.thread_title);
        this.jie = (LinearLayout) view.findViewById(R.id.fans_action);
        this.jif = (LinearLayout) view.findViewById(R.id.concer_action);
        this.jig = (LinearLayout) view.findViewById(R.id.attention_action);
        this.jih = (LinearLayout) view.findViewById(R.id.thread_action);
        this.jic = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.cVt.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gRp, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jhX, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jhY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jhZ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jia, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jib, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hyU, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.KD, (int) R.color.cp_cont_d);
            am.setImageResource(this.jic, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.cVt, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.f.a.aGX().kK(1).kL(4096).kR(R.color.cp_bg_line_e).kM(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aQ(getView());
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
        this.jii = dVar.jhh;
        this.gRp.setText(aq.numFormatOverWanNa(dVar.jhg));
        this.jhY.setText(Integer.toString(dVar.jhh));
        this.jia.setText(Integer.toString(dVar.jhi));
        this.hyU.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.jhj) {
            this.jic.setVisibility(0);
        } else {
            this.jic.setVisibility(8);
        }
        this.jie.setOnClickListener(this);
        this.jif.setOnClickListener(this);
        this.jig.setOnClickListener(this);
        this.jih.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.jic.setVisibility(8);
                    com.baidu.tieba.p.a.cDN().g(2, false, true);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").X("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.jii, this.mUserData.getPortrait())));
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
