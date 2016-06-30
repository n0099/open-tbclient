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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.bp;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonInfoGodEnterView extends LinearLayout implements View.OnClickListener {
    private bp eje;
    private View ejg;
    private PersonInfoEnterItemView ejh;
    private PersonInfoEnterItemView eji;
    private PersonInfoEnterItemView ejj;
    private View ejk;
    private View ejl;
    private ImageView ejm;
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
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.personinfo_god_enter_view, this);
        this.ejg = inflate.findViewById(u.g.layout_views);
        this.ejh = (PersonInfoEnterItemView) inflate.findViewById(u.g.view_threads);
        this.eji = (PersonInfoEnterItemView) inflate.findViewById(u.g.view_forums);
        this.ejj = (PersonInfoEnterItemView) inflate.findViewById(u.g.viewr_groups);
        this.ejk = inflate.findViewById(u.g.layout_bottom_arrow);
        this.ejl = inflate.findViewById(u.g.arrow_line);
        this.ejm = (ImageView) inflate.findViewById(u.g.iv_arrow);
        this.ejk.setOnClickListener(this);
        this.ejm.setOnClickListener(this);
        this.ejh.setOnClickListener(this);
        this.eji.setOnClickListener(this);
        this.ejj.setOnClickListener(this);
    }

    public void setData(bp bpVar) {
        if (bpVar != null) {
            this.eje = bpVar;
            this.mUser = bpVar.getUserData();
            if (aLB()) {
                this.ejh.setVisibility(0);
                this.ejh.setIcon(u.f.icon_mine_tie);
                this.ejh.setBackgroundResource(u.f.bg_icon_mine_selector);
            } else {
                this.ejh.setVisibility(8);
            }
            if (aLC()) {
                this.ejj.setVisibility(0);
                this.ejj.setIcon(u.f.icon_mine_group);
                this.ejj.setBackgroundResource(u.f.bg_icon_mine_selector);
            } else {
                this.ejj.setVisibility(8);
            }
            if (aLD()) {
                this.eji.setVisibility(0);
                this.eji.setIcon(u.f.icon_mine_ba);
                this.eji.setBackgroundResource(u.f.bg_icon_mine_selector);
            } else {
                this.eji.setVisibility(8);
            }
            if (com.baidu.tbadk.core.sharedPref.b.sO().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", true)) {
                ik(true);
            } else {
                ik(false);
            }
            ajR();
        }
    }

    private boolean aLB() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PersonPostActivityConfig.class);
    }

    private boolean aLC() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    private boolean aLD() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PersonBarActivityConfig.class);
    }

    private void ajR() {
        if (this.mUser != null) {
            this.eji.setTitle(this.mContext.getString(u.j.person_forums));
            if (this.mUser.getSex() == 1) {
                this.ejh.setTitle(this.mContext.getString(u.j.person_threads_him));
                this.ejj.setTitle(this.mContext.getString(u.j.person_groups_him));
                return;
            }
            this.ejh.setTitle(this.mContext.getString(u.j.person_threads_her));
            this.ejj.setTitle(this.mContext.getString(u.j.person_groups_her));
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (this.ejh != null) {
            this.ejh.n(tbPageContext);
        }
        if (this.ejj != null) {
            this.ejj.n(tbPageContext);
        }
        if (this.eji != null) {
            this.eji.n(tbPageContext);
        }
        av.k(this.ejl, u.d.cp_bg_line_b);
        av.k(this.ejg, u.d.cp_bg_line_d);
        av.k(this.ejk, u.d.cp_bg_line_d);
        aLE();
    }

    private void aLE() {
        if (this.ejm != null && this.ejg != null) {
            if (this.ejg.getVisibility() == 8) {
                this.ejm.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_down));
            } else {
                this.ejm.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_up));
            }
        }
    }

    private void ik(boolean z) {
        if (z) {
            this.ejg.setVisibility(0);
            this.ejl.setVisibility(0);
            this.ejm.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_up));
            return;
        }
        this.ejg.setVisibility(8);
        this.ejl.setVisibility(8);
        this.ejm.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_down));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ejk == view || this.ejm == view) {
            if (this.ejm != null && this.ejg != null) {
                if (this.ejg.getVisibility() == 8) {
                    ik(true);
                } else {
                    ik(false);
                }
            }
        } else if (view == this.ejh) {
            if (this.mUser != null && this.eje != null && bn.ab(this.mContext)) {
                if (oa(1)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex(), this.mUser.getPortrait())));
                    TiebaStatic.log(new ay("c10618").s("obj_type", 1).ab("obj_id", this.mUser.getUserId()));
                    return;
                }
                TiebaStatic.log(new ay("c10618").s("obj_type", 3).ab("obj_id", this.mUser.getUserId()));
                BdToast.a(this.mContext, this.mContext.getResources().getString(u.j.user_set_private)).sb();
            }
        } else if (view == this.eji) {
            if (this.mUser != null && this.eje != null && bn.ab(this.mContext)) {
                if (oa(2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mContext, this.mUser.getLike_bars(), this.mUser.getUserId(), this.mUser.getSex())));
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getResources().getString(u.j.user_set_private)).sb();
            }
        } else if (view == this.ejj && this.mUser != null && this.eje != null && bn.ab(this.mContext)) {
            if (oa(3)) {
                TiebaStatic.log(new ay("c10620").s("obj_type", 1).ab("obj_id", this.mUser.getUserId()));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex())));
                return;
            }
            TiebaStatic.log(new ay("c10620").s("obj_type", 3).ab("obj_id", this.mUser.getUserId()));
            BdToast.a(this.mContext, this.mContext.getResources().getString(u.j.user_set_private)).sb();
        }
    }

    private boolean oa(int i) {
        int i2;
        if (this.mUser == null || this.eje == null) {
            return false;
        }
        j personPrivate = this.mUser.getPersonPrivate();
        PersonTainInfo aMy = this.eje.aMy();
        if (personPrivate == null) {
            i2 = 1;
        } else if (i == 1) {
            i2 = personPrivate.AN();
        } else if (i == 2) {
            i2 = personPrivate.AL();
        } else if (i != 3) {
            return false;
        } else {
            i2 = personPrivate.AM();
        }
        return i2 == 1 || (i2 == 2 && (aMy != null ? aMy.getIsFriend() : 1) == 1);
    }
}
