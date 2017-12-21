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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.a> {
    private View ayf;
    private TextView bZY;
    private TextView dKj;
    private TextView dep;
    private ImageView dtb;
    private TextView fto;
    private TextView ftp;
    private TextView ftq;
    private TextView ftr;
    private TextView fts;
    private LinearLayout ftt;
    private LinearLayout ftu;
    private LinearLayout ftv;
    private LinearLayout ftw;
    private LinearLayout ftx;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dep = (TextView) view.findViewById(d.g.fans_num);
        this.fto = (TextView) view.findViewById(d.g.fans_title);
        this.ftp = (TextView) view.findViewById(d.g.concer_num);
        this.ftq = (TextView) view.findViewById(d.g.concer_title);
        this.ftr = (TextView) view.findViewById(d.g.attention_bar_num);
        this.fts = (TextView) view.findViewById(d.g.attention_bar_title);
        this.dKj = (TextView) view.findViewById(d.g.thread_num);
        this.bZY = (TextView) view.findViewById(d.g.thread_title);
        this.ayf = view.findViewById(d.g.top_divider_line);
        this.ftx = (LinearLayout) view.findViewById(d.g.attention_container);
        this.ftt = (LinearLayout) view.findViewById(d.g.fans_action);
        this.ftu = (LinearLayout) view.findViewById(d.g.concer_action);
        this.ftv = (LinearLayout) view.findViewById(d.g.attention_action);
        this.ftw = (LinearLayout) view.findViewById(d.g.thread_action);
        this.dtb = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.dep, d.C0095d.cp_cont_b);
            aj.i(this.fto, d.C0095d.cp_cont_j);
            aj.i(this.ftp, d.C0095d.cp_cont_b);
            aj.i(this.ftq, d.C0095d.cp_cont_j);
            aj.i(this.ftr, d.C0095d.cp_cont_b);
            aj.i(this.fts, d.C0095d.cp_cont_j);
            aj.i(this.dKj, d.C0095d.cp_cont_b);
            aj.i(this.bZY, d.C0095d.cp_cont_j);
            aj.k(this.ayf, d.C0095d.cp_bg_line_e);
            this.dtb.setImageDrawable(aj.v(i, d.f.person_center_red_tip_shape));
            if (this.ftx != null) {
                for (int i2 = 0; i2 < this.ftx.getChildCount(); i2++) {
                    View childAt = this.ftx.getChildAt(i2);
                    if (childAt != null) {
                        aj.j(childAt, d.f.person_center_action_item_selector);
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
    public void a(com.baidu.tieba.personCenter.data.a aVar) {
        this.mUserData = aVar.ePx;
        this.dep.setText(Integer.toString(aVar.fsM));
        this.ftp.setText(Integer.toString(aVar.fsN));
        this.ftr.setText(Integer.toString(aVar.fsO));
        this.dKj.setText(am.F(aVar.threadNum));
        if (aVar.fsP) {
            this.dtb.setVisibility(0);
        } else {
            this.dtb.setVisibility(8);
        }
        this.ftt.setOnClickListener(this);
        this.ftu.setOnClickListener(this);
        this.ftv.setOnClickListener(this);
        this.ftw.setOnClickListener(this);
        d(abs(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.dtb.setVisibility(8);
                    com.baidu.tieba.m.a.bmN().c(2, false, true);
                    TiebaStatic.log(new ak("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
