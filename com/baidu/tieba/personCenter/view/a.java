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
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.a> {
    private View axw;
    private TextView bRS;
    private TextView cTW;
    private TextView dBn;
    private ImageView diR;
    private LinearLayout fjA;
    private TextView fjr;
    private TextView fjs;
    private TextView fjt;
    private TextView fju;
    private TextView fjv;
    private LinearLayout fjw;
    private LinearLayout fjx;
    private LinearLayout fjy;
    private LinearLayout fjz;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.cTW = (TextView) view.findViewById(d.g.fans_num);
        this.fjr = (TextView) view.findViewById(d.g.fans_title);
        this.fjs = (TextView) view.findViewById(d.g.concer_num);
        this.fjt = (TextView) view.findViewById(d.g.concer_title);
        this.fju = (TextView) view.findViewById(d.g.attention_bar_num);
        this.fjv = (TextView) view.findViewById(d.g.attention_bar_title);
        this.dBn = (TextView) view.findViewById(d.g.thread_num);
        this.bRS = (TextView) view.findViewById(d.g.thread_title);
        this.axw = view.findViewById(d.g.top_divider_line);
        this.fjA = (LinearLayout) view.findViewById(d.g.attention_container);
        this.fjw = (LinearLayout) view.findViewById(d.g.fans_action);
        this.fjx = (LinearLayout) view.findViewById(d.g.concer_action);
        this.fjy = (LinearLayout) view.findViewById(d.g.attention_action);
        this.fjz = (LinearLayout) view.findViewById(d.g.thread_action);
        this.diR = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.cTW, d.C0080d.cp_cont_b);
            aj.i(this.fjr, d.C0080d.cp_cont_j);
            aj.i(this.fjs, d.C0080d.cp_cont_b);
            aj.i(this.fjt, d.C0080d.cp_cont_j);
            aj.i(this.fju, d.C0080d.cp_cont_b);
            aj.i(this.fjv, d.C0080d.cp_cont_j);
            aj.i(this.dBn, d.C0080d.cp_cont_b);
            aj.i(this.bRS, d.C0080d.cp_cont_j);
            aj.k(this.axw, d.C0080d.cp_bg_line_e);
            this.diR.setImageDrawable(aj.u(i, d.f.person_center_red_tip_shape));
            if (this.fjA != null) {
                for (int i2 = 0; i2 < this.fjA.getChildCount(); i2++) {
                    View childAt = this.fjA.getChildAt(i2);
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
        this.mUserData = aVar.eGG;
        this.cTW.setText(Integer.toString(aVar.fiL));
        this.fjs.setText(Integer.toString(aVar.fiM));
        this.fju.setText(Integer.toString(aVar.fiN));
        this.dBn.setText(am.F(aVar.threadNum));
        if (aVar.fiO) {
            this.diR.setVisibility(0);
        } else {
            this.diR.setVisibility(8);
        }
        this.fjw.setOnClickListener(this);
        this.fjx.setOnClickListener(this);
        this.fjy.setOnClickListener(this);
        this.fjz.setOnClickListener(this);
        d(ZI(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.diR.setVisibility(8);
                    com.baidu.tieba.j.a.bkh().c(2, false, true);
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false, true)));
            }
        }
    }
}
