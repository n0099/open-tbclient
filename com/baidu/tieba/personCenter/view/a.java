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
    private TextView XM;
    private TextView fAA;
    private TextView gil;
    private TextView hMo;
    private TextView hMp;
    private TextView hMq;
    private TextView hMr;
    private TextView hMs;
    private ImageView hMt;
    private LinearLayout hMu;
    private LinearLayout hMv;
    private LinearLayout hMw;
    private LinearLayout hMx;
    private LinearLayout hMy;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fAA = (TextView) view.findViewById(d.g.fans_num);
        this.hMo = (TextView) view.findViewById(d.g.fans_title);
        this.hMp = (TextView) view.findViewById(d.g.concer_num);
        this.hMq = (TextView) view.findViewById(d.g.concer_title);
        this.hMr = (TextView) view.findViewById(d.g.attention_bar_num);
        this.hMs = (TextView) view.findViewById(d.g.attention_bar_title);
        this.gil = (TextView) view.findViewById(d.g.thread_num);
        this.XM = (TextView) view.findViewById(d.g.thread_title);
        this.mTopLine = view.findViewById(d.g.top_divider_line);
        this.hMy = (LinearLayout) view.findViewById(d.g.attention_container);
        this.hMu = (LinearLayout) view.findViewById(d.g.fans_action);
        this.hMv = (LinearLayout) view.findViewById(d.g.concer_action);
        this.hMw = (LinearLayout) view.findViewById(d.g.attention_action);
        this.hMx = (LinearLayout) view.findViewById(d.g.thread_action);
        this.hMt = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.fAA, d.C0277d.cp_cont_b);
            al.j(this.hMo, d.C0277d.cp_cont_j);
            al.j(this.hMp, d.C0277d.cp_cont_b);
            al.j(this.hMq, d.C0277d.cp_cont_j);
            al.j(this.hMr, d.C0277d.cp_cont_b);
            al.j(this.hMs, d.C0277d.cp_cont_j);
            al.j(this.gil, d.C0277d.cp_cont_b);
            al.j(this.XM, d.C0277d.cp_cont_j);
            al.l(this.mTopLine, d.C0277d.cp_bg_line_e);
            this.hMt.setImageDrawable(al.T(i, d.f.person_center_red_tip_shape));
            if (this.hMy != null) {
                for (int i2 = 0; i2 < this.hMy.getChildCount(); i2++) {
                    View childAt = this.hMy.getChildAt(i2);
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
        this.fAA.setText(Integer.toString(cVar.hLI));
        this.hMp.setText(Integer.toString(cVar.hLJ));
        this.hMr.setText(Integer.toString(cVar.hLK));
        this.gil.setText(ap.aD(cVar.threadNum));
        if (cVar.hLL) {
            this.hMt.setVisibility(0);
        } else {
            this.hMt.setVisibility(8);
        }
        this.hMu.setOnClickListener(this);
        this.hMv.setOnClickListener(this);
        this.hMw.setOnClickListener(this);
        this.hMx.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.hMt.setVisibility(8);
                    com.baidu.tieba.o.a.bXW().d(2, false, true);
                    TiebaStatic.log(new am("c12523").T("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
