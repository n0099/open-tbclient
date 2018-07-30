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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.b> {
    private View aIx;
    private TextView czC;
    private TextView dLm;
    private TextView erq;
    private TextView fVe;
    private TextView fVf;
    private TextView fVg;
    private TextView fVh;
    private TextView fVi;
    private ImageView fVj;
    private LinearLayout fVk;
    private LinearLayout fVl;
    private LinearLayout fVm;
    private LinearLayout fVn;
    private LinearLayout fVo;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dLm = (TextView) view.findViewById(d.g.fans_num);
        this.fVe = (TextView) view.findViewById(d.g.fans_title);
        this.fVf = (TextView) view.findViewById(d.g.concer_num);
        this.fVg = (TextView) view.findViewById(d.g.concer_title);
        this.fVh = (TextView) view.findViewById(d.g.attention_bar_num);
        this.fVi = (TextView) view.findViewById(d.g.attention_bar_title);
        this.erq = (TextView) view.findViewById(d.g.thread_num);
        this.czC = (TextView) view.findViewById(d.g.thread_title);
        this.aIx = view.findViewById(d.g.top_divider_line);
        this.fVo = (LinearLayout) view.findViewById(d.g.attention_container);
        this.fVk = (LinearLayout) view.findViewById(d.g.fans_action);
        this.fVl = (LinearLayout) view.findViewById(d.g.concer_action);
        this.fVm = (LinearLayout) view.findViewById(d.g.attention_action);
        this.fVn = (LinearLayout) view.findViewById(d.g.thread_action);
        this.fVj = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dLm, d.C0140d.cp_cont_b);
            am.h(this.fVe, d.C0140d.cp_cont_j);
            am.h(this.fVf, d.C0140d.cp_cont_b);
            am.h(this.fVg, d.C0140d.cp_cont_j);
            am.h(this.fVh, d.C0140d.cp_cont_b);
            am.h(this.fVi, d.C0140d.cp_cont_j);
            am.h(this.erq, d.C0140d.cp_cont_b);
            am.h(this.czC, d.C0140d.cp_cont_j);
            am.j(this.aIx, d.C0140d.cp_bg_line_e);
            this.fVj.setImageDrawable(am.v(i, d.f.person_center_red_tip_shape));
            if (this.fVo != null) {
                for (int i2 = 0; i2 < this.fVo.getChildCount(); i2++) {
                    View childAt = this.fVo.getChildAt(i2);
                    if (childAt != null) {
                        am.i(childAt, d.f.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.b bVar) {
        this.mUserData = bVar.fsA;
        this.dLm.setText(Integer.toString(bVar.fUA));
        this.fVf.setText(Integer.toString(bVar.fUB));
        this.fVh.setText(Integer.toString(bVar.fUC));
        this.erq.setText(ap.L(bVar.threadNum));
        if (bVar.fUD) {
            this.fVj.setVisibility(0);
        } else {
            this.fVj.setVisibility(8);
        }
        this.fVk.setOnClickListener(this);
        this.fVl.setOnClickListener(this);
        this.fVm.setOnClickListener(this);
        this.fVn.setOnClickListener(this);
        d(aiy(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.fVj.setVisibility(8);
                    com.baidu.tieba.o.a.box().c(2, false, true);
                    TiebaStatic.log(new an("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
