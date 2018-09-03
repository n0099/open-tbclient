package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.c> {
    private TextView czz;
    private TextView dLi;
    private TextView erm;
    private TextView fVb;
    private TextView fVc;
    private TextView fVd;
    private TextView fVe;
    private TextView fVf;
    private ImageView fVg;
    private LinearLayout fVh;
    private LinearLayout fVi;
    private LinearLayout fVj;
    private LinearLayout fVk;
    private LinearLayout fVl;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dLi = (TextView) view.findViewById(f.g.fans_num);
        this.fVb = (TextView) view.findViewById(f.g.fans_title);
        this.fVc = (TextView) view.findViewById(f.g.concer_num);
        this.fVd = (TextView) view.findViewById(f.g.concer_title);
        this.fVe = (TextView) view.findViewById(f.g.attention_bar_num);
        this.fVf = (TextView) view.findViewById(f.g.attention_bar_title);
        this.erm = (TextView) view.findViewById(f.g.thread_num);
        this.czz = (TextView) view.findViewById(f.g.thread_title);
        this.mTopLine = view.findViewById(f.g.top_divider_line);
        this.fVl = (LinearLayout) view.findViewById(f.g.attention_container);
        this.fVh = (LinearLayout) view.findViewById(f.g.fans_action);
        this.fVi = (LinearLayout) view.findViewById(f.g.concer_action);
        this.fVj = (LinearLayout) view.findViewById(f.g.attention_action);
        this.fVk = (LinearLayout) view.findViewById(f.g.thread_action);
        this.fVg = (ImageView) view.findViewById(f.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dLi, f.d.cp_cont_b);
            am.h(this.fVb, f.d.cp_cont_j);
            am.h(this.fVc, f.d.cp_cont_b);
            am.h(this.fVd, f.d.cp_cont_j);
            am.h(this.fVe, f.d.cp_cont_b);
            am.h(this.fVf, f.d.cp_cont_j);
            am.h(this.erm, f.d.cp_cont_b);
            am.h(this.czz, f.d.cp_cont_j);
            am.j(this.mTopLine, f.d.cp_bg_line_e);
            this.fVg.setImageDrawable(am.v(i, f.C0146f.person_center_red_tip_shape));
            if (this.fVl != null) {
                for (int i2 = 0; i2 < this.fVl.getChildCount(); i2++) {
                    View childAt = this.fVl.getChildAt(i2);
                    if (childAt != null) {
                        am.i(childAt, f.C0146f.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.c cVar) {
        this.mUserData = cVar.fst;
        this.dLi.setText(Integer.toString(cVar.fUt));
        this.fVc.setText(Integer.toString(cVar.fUu));
        this.fVe.setText(Integer.toString(cVar.fUv));
        this.erm.setText(ap.L(cVar.threadNum));
        if (cVar.fUw) {
            this.fVg.setVisibility(0);
        } else {
            this.fVg.setVisibility(8);
        }
        this.fVh.setOnClickListener(this);
        this.fVi.setOnClickListener(this);
        this.fVj.setOnClickListener(this);
        this.fVk.setOnClickListener(this);
        d(aiB(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == f.g.fans_action) {
                if (this.mUserData != null) {
                    this.fVg.setVisibility(8);
                    com.baidu.tieba.o.a.boy().c(2, false, true);
                    TiebaStatic.log(new an("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == f.g.concer_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == f.g.attention_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == f.g.thread_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
