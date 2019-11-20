package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.d> {
    private TextView Fm;
    private TextView fXw;
    private TextView gFo;
    private TextView ilB;
    private TextView ilC;
    private TextView ilD;
    private TextView ilE;
    private TextView ilF;
    private ImageView ilG;
    private LinearLayout ilH;
    private LinearLayout ilI;
    private LinearLayout ilJ;
    private LinearLayout ilK;
    private LinearLayout ilL;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fXw = (TextView) view.findViewById(R.id.fans_num);
        this.ilB = (TextView) view.findViewById(R.id.fans_title);
        this.ilC = (TextView) view.findViewById(R.id.concer_num);
        this.ilD = (TextView) view.findViewById(R.id.concer_title);
        this.ilE = (TextView) view.findViewById(R.id.attention_bar_num);
        this.ilF = (TextView) view.findViewById(R.id.attention_bar_title);
        this.gFo = (TextView) view.findViewById(R.id.thread_num);
        this.Fm = (TextView) view.findViewById(R.id.thread_title);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.ilL = (LinearLayout) view.findViewById(R.id.attention_container);
        this.ilH = (LinearLayout) view.findViewById(R.id.fans_action);
        this.ilI = (LinearLayout) view.findViewById(R.id.concer_action);
        this.ilJ = (LinearLayout) view.findViewById(R.id.attention_action);
        this.ilK = (LinearLayout) view.findViewById(R.id.thread_action);
        this.ilG = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fXw, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ilB, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.ilC, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ilD, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.ilE, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ilF, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.gFo, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.Fm, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.ilG.setImageDrawable(am.getDrawable(i, (int) R.drawable.person_center_red_tip_shape));
            if (this.ilL != null) {
                for (int i2 = 0; i2 < this.ilL.getChildCount(); i2++) {
                    View childAt = this.ilL.getChildAt(i2);
                    if (childAt != null) {
                        childAt.setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
                    }
                }
            }
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
        this.fXw.setText(Integer.toString(dVar.ikL));
        this.ilC.setText(Integer.toString(dVar.ikM));
        this.ilE.setText(Integer.toString(dVar.ikN));
        this.gFo.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.ikO) {
            this.ilG.setVisibility(0);
        } else {
            this.ilG.setVisibility(8);
        }
        this.ilH.setOnClickListener(this);
        this.ilI.setOnClickListener(this);
        this.ilJ.setOnClickListener(this);
        this.ilK.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.ilG.setVisibility(8);
                    com.baidu.tieba.o.a.chb().e(2, false, true);
                    TiebaStatic.log(new an("c12523").O("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == R.id.concer_action) {
                TiebaStatic.log(new an("c12523").O("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new an("c12523").O("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new an("c12523").O("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
