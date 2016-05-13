package com.baidu.tieba.person.god.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.bg;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoGodEnterView extends LinearLayout implements View.OnClickListener {
    private View dAA;
    private PersonInfoEnterItemView dAB;
    private PersonInfoEnterItemView dAC;
    private PersonInfoEnterItemView dAD;
    private View dAE;
    private View dAF;
    private ImageView dAG;
    private bg dAy;
    private Context mContext;
    private UserData mUser;

    public PersonInfoGodEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public PersonInfoGodEnterView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.personinfo_god_enter_view, this);
        this.dAA = inflate.findViewById(t.g.layout_views);
        this.dAB = (PersonInfoEnterItemView) inflate.findViewById(t.g.view_threads);
        this.dAC = (PersonInfoEnterItemView) inflate.findViewById(t.g.view_forums);
        this.dAD = (PersonInfoEnterItemView) inflate.findViewById(t.g.viewr_groups);
        this.dAE = inflate.findViewById(t.g.layout_bottom_arrow);
        this.dAF = inflate.findViewById(t.g.arrow_line);
        this.dAG = (ImageView) inflate.findViewById(t.g.iv_arrow);
        this.dAE.setOnClickListener(this);
        this.dAG.setOnClickListener(this);
        this.dAB.setOnClickListener(this);
        this.dAC.setOnClickListener(this);
        this.dAD.setOnClickListener(this);
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.dAy = bgVar;
            this.mUser = bgVar.getUserData();
            if (aCH()) {
                this.dAB.setVisibility(0);
                this.dAB.setIcon(t.f.icon_mine_tie);
                this.dAB.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dAB.setVisibility(8);
            }
            if (aCI()) {
                this.dAD.setVisibility(0);
                this.dAD.setIcon(t.f.icon_mine_group);
                this.dAD.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dAD.setVisibility(8);
            }
            if (aCJ()) {
                this.dAC.setVisibility(0);
                this.dAC.setIcon(t.f.icon_mine_ba);
                this.dAC.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dAC.setVisibility(8);
            }
            if (com.baidu.tbadk.core.sharedPref.b.sR().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", true)) {
                hp(true);
            } else {
                hp(false);
            }
            abF();
        }
    }

    private boolean aCH() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PersonPostActivityConfig.class);
    }

    private boolean aCI() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    private boolean aCJ() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PersonBarActivityConfig.class);
    }

    private void abF() {
        if (this.mUser != null) {
            this.dAC.setTitle(this.mContext.getString(t.j.person_forums));
            if (this.mUser.getSex() == 1) {
                this.dAB.setTitle(this.mContext.getString(t.j.person_threads_him));
                this.dAD.setTitle(this.mContext.getString(t.j.person_groups_him));
                return;
            }
            this.dAB.setTitle(this.mContext.getString(t.j.person_threads_her));
            this.dAD.setTitle(this.mContext.getString(t.j.person_groups_her));
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (this.dAB != null) {
            this.dAB.g(tbPageContext);
        }
        if (this.dAD != null) {
            this.dAD.g(tbPageContext);
        }
        if (this.dAC != null) {
            this.dAC.g(tbPageContext);
        }
        at.k(this.dAF, t.d.cp_bg_line_b);
        at.k(this.dAA, t.d.cp_bg_line_d);
        at.k(this.dAE, t.d.cp_bg_line_d);
        aCK();
    }

    private void aCK() {
        if (this.dAG != null && this.dAA != null) {
            if (this.dAA.getVisibility() == 8) {
                this.dAG.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_down));
            } else {
                this.dAG.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_up));
            }
        }
    }

    private void hp(boolean z) {
        if (z) {
            this.dAA.setVisibility(0);
            this.dAF.setVisibility(0);
            this.dAG.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_up));
            return;
        }
        this.dAA.setVisibility(8);
        this.dAF.setVisibility(8);
        this.dAG.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_down));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dAE == view || this.dAG == view) {
            if (this.dAG != null && this.dAA != null) {
                if (this.dAA.getVisibility() == 8) {
                    hp(true);
                } else {
                    hp(false);
                }
            }
        } else if (view == this.dAB) {
            if (this.mUser != null && this.dAy != null && bl.ac(this.mContext)) {
                if (my(1)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex(), this.mUser.getPortrait())));
                    TiebaStatic.log(new aw("c10618").s("obj_type", 1).ac("obj_id", this.mUser.getUserId()));
                    return;
                }
                TiebaStatic.log(new aw("c10618").s("obj_type", 3).ac("obj_id", this.mUser.getUserId()));
                BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).sd();
            }
        } else if (view == this.dAC) {
            if (this.mUser != null && this.dAy != null && bl.ac(this.mContext)) {
                if (my(2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mContext, this.mUser.getLike_bars(), this.mUser.getUserId(), this.mUser.getSex())));
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).sd();
            }
        } else if (view == this.dAD && this.mUser != null && this.dAy != null && bl.ac(this.mContext)) {
            if (my(3)) {
                TiebaStatic.log(new aw("c10620").s("obj_type", 1).ac("obj_id", this.mUser.getUserId()));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex())));
                return;
            }
            TiebaStatic.log(new aw("c10620").s("obj_type", 3).ac("obj_id", this.mUser.getUserId()));
            BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).sd();
        }
    }

    private boolean my(int i) {
        int i2;
        if (this.mUser == null || this.dAy == null) {
            return false;
        }
        h personPrivate = this.mUser.getPersonPrivate();
        PersonTainInfo aDD = this.dAy.aDD();
        if (personPrivate == null) {
            i2 = 1;
        } else if (i == 1) {
            i2 = personPrivate.AE();
        } else if (i == 2) {
            i2 = personPrivate.AC();
        } else if (i != 3) {
            return false;
        } else {
            i2 = personPrivate.AD();
        }
        return i2 == 1 || (i2 == 2 && (aDD != null ? aDD.getIsFriend() : 1) == 1);
    }
}
