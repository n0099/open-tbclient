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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView aeD;
    private View dPI;
    private TextView iRc;
    private TextView igz;
    private TextView kGR;
    private TextView kGS;
    private TextView kGT;
    private TextView kGU;
    private TextView kGV;
    private ImageView kGW;
    private LinearLayout kGX;
    private LinearLayout kGY;
    private LinearLayout kGZ;
    private LinearLayout kHa;
    private int kHb;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.kHb = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.dPI = view.findViewById(R.id.bottom_divider_line);
        this.igz = (TextView) view.findViewById(R.id.fans_num);
        this.kGR = (TextView) view.findViewById(R.id.fans_title);
        this.kGS = (TextView) view.findViewById(R.id.concer_num);
        this.kGT = (TextView) view.findViewById(R.id.concer_title);
        this.kGU = (TextView) view.findViewById(R.id.attention_bar_num);
        this.kGV = (TextView) view.findViewById(R.id.attention_bar_title);
        this.iRc = (TextView) view.findViewById(R.id.thread_num);
        this.aeD = (TextView) view.findViewById(R.id.thread_title);
        this.kGX = (LinearLayout) view.findViewById(R.id.fans_action);
        this.kGY = (LinearLayout) view.findViewById(R.id.concer_action);
        this.kGZ = (LinearLayout) view.findViewById(R.id.attention_action);
        this.kHa = (LinearLayout) view.findViewById(R.id.thread_action);
        this.kGW = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.dPI.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.igz, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.kGR, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.kGS, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.kGT, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.kGU, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.kGV, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.iRc, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.aeD, (int) R.color.cp_cont_d);
            an.setImageResource(this.kGW, R.drawable.person_center_red_tip_shape);
            an.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.dPI, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.aXp().lP(1).lQ(4096).lW(R.color.cp_bg_line_e).lR(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aR(getView());
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
        this.kHb = dVar.kFT;
        this.igz.setText(ar.numFormatOverWanNa(dVar.kFS));
        this.kGS.setText(Integer.toString(dVar.kFT));
        this.kGU.setText(Integer.toString(dVar.kFU));
        this.iRc.setText(ar.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.kFV) {
            this.kGW.setVisibility(0);
        } else {
            this.kGW.setVisibility(8);
        }
        this.kGX.setOnClickListener(this);
        this.kGY.setOnClickListener(this);
        this.kGZ.setOnClickListener(this);
        this.kHa.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.kGW.setVisibility(8);
                    com.baidu.tieba.p.a.daq().g(2, false, true);
                    TiebaStatic.log(new ao("c12523").ag("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new ao("c12523").ag("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.kHb, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new ao("c12523").ag("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new ao("c12523").ag("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
