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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.c> {
    private TextView XL;
    private TextView fAB;
    private TextView gil;
    private LinearLayout hMA;
    private LinearLayout hMB;
    private LinearLayout hMC;
    private LinearLayout hMD;
    private TextView hMt;
    private TextView hMu;
    private TextView hMv;
    private TextView hMw;
    private TextView hMx;
    private ImageView hMy;
    private LinearLayout hMz;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fAB = (TextView) view.findViewById(d.g.fans_num);
        this.hMt = (TextView) view.findViewById(d.g.fans_title);
        this.hMu = (TextView) view.findViewById(d.g.concer_num);
        this.hMv = (TextView) view.findViewById(d.g.concer_title);
        this.hMw = (TextView) view.findViewById(d.g.attention_bar_num);
        this.hMx = (TextView) view.findViewById(d.g.attention_bar_title);
        this.gil = (TextView) view.findViewById(d.g.thread_num);
        this.XL = (TextView) view.findViewById(d.g.thread_title);
        this.mTopLine = view.findViewById(d.g.top_divider_line);
        this.hMD = (LinearLayout) view.findViewById(d.g.attention_container);
        this.hMz = (LinearLayout) view.findViewById(d.g.fans_action);
        this.hMA = (LinearLayout) view.findViewById(d.g.concer_action);
        this.hMB = (LinearLayout) view.findViewById(d.g.attention_action);
        this.hMC = (LinearLayout) view.findViewById(d.g.thread_action);
        this.hMy = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.fAB, d.C0236d.cp_cont_b);
            al.j(this.hMt, d.C0236d.cp_cont_j);
            al.j(this.hMu, d.C0236d.cp_cont_b);
            al.j(this.hMv, d.C0236d.cp_cont_j);
            al.j(this.hMw, d.C0236d.cp_cont_b);
            al.j(this.hMx, d.C0236d.cp_cont_j);
            al.j(this.gil, d.C0236d.cp_cont_b);
            al.j(this.XL, d.C0236d.cp_cont_j);
            al.l(this.mTopLine, d.C0236d.cp_bg_line_e);
            this.hMy.setImageDrawable(al.T(i, d.f.person_center_red_tip_shape));
            if (this.hMD != null) {
                for (int i2 = 0; i2 < this.hMD.getChildCount(); i2++) {
                    View childAt = this.hMD.getChildAt(i2);
                    if (childAt != null) {
                        al.k(childAt, d.f.person_center_action_item_selector);
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
    public void a(com.baidu.tieba.personCenter.data.c cVar) {
        this.mUserData = cVar.userData;
        this.fAB.setText(Integer.toString(cVar.hLN));
        this.hMu.setText(Integer.toString(cVar.hLO));
        this.hMw.setText(Integer.toString(cVar.hLP));
        this.gil.setText(ap.aD(cVar.threadNum));
        if (cVar.hLQ) {
            this.hMy.setVisibility(0);
        } else {
            this.hMy.setVisibility(8);
        }
        this.hMz.setOnClickListener(this);
        this.hMA.setOnClickListener(this);
        this.hMB.setOnClickListener(this);
        this.hMC.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.hMy.setVisibility(8);
                    com.baidu.tieba.o.a.bXT().d(2, false, true);
                    TiebaStatic.log(new am("c12523").T("obj_locate", 6));
                    if (com.baidu.tbadk.plugins.c.b(getTbPageContext(), "com.baidu.tieba.pluginVideo")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                    }
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 5));
                if (com.baidu.tbadk.plugins.c.b(getTbPageContext(), "com.baidu.tieba.pluginVideo")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 7));
                if (com.baidu.tbadk.plugins.c.b(getTbPageContext(), "com.baidu.tieba.pluginVideo")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 8));
                if (com.baidu.tbadk.plugins.c.b(getTbPageContext(), "com.baidu.tieba.pluginMember")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
                }
            }
        }
    }
}
