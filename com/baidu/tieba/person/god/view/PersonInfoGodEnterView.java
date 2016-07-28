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
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.bn;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonInfoGodEnterView extends LinearLayout implements View.OnClickListener {
    private bn etj;
    private View etl;
    private PersonInfoEnterItemView etm;
    private PersonInfoEnterItemView etn;
    private PersonInfoEnterItemView eto;
    private View etp;
    private View etq;
    private ImageView etr;
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
        this.etl = inflate.findViewById(u.g.layout_views);
        this.etm = (PersonInfoEnterItemView) inflate.findViewById(u.g.view_threads);
        this.etn = (PersonInfoEnterItemView) inflate.findViewById(u.g.view_forums);
        this.eto = (PersonInfoEnterItemView) inflate.findViewById(u.g.viewr_groups);
        this.etp = inflate.findViewById(u.g.layout_bottom_arrow);
        this.etq = inflate.findViewById(u.g.arrow_line);
        this.etr = (ImageView) inflate.findViewById(u.g.iv_arrow);
        this.etp.setOnClickListener(this);
        this.etr.setOnClickListener(this);
        this.etm.setOnClickListener(this);
        this.etn.setOnClickListener(this);
        this.eto.setOnClickListener(this);
    }

    public void setData(bn bnVar) {
        if (bnVar != null) {
            this.etj = bnVar;
            this.mUser = bnVar.getUserData();
            if (aOe()) {
                this.etm.setVisibility(0);
                this.etm.setIcon(u.f.icon_mine_tie);
                this.etm.setBackgroundResource(u.f.bg_icon_mine_selector);
            } else {
                this.etm.setVisibility(8);
            }
            if (aOf()) {
                this.eto.setVisibility(0);
                this.eto.setIcon(u.f.icon_mine_group);
                this.eto.setBackgroundResource(u.f.bg_icon_mine_selector);
            } else {
                this.eto.setVisibility(8);
            }
            if (aOg()) {
                this.etn.setVisibility(0);
                this.etn.setIcon(u.f.icon_mine_ba);
                this.etn.setBackgroundResource(u.f.bg_icon_mine_selector);
            } else {
                this.etn.setVisibility(8);
            }
            if (com.baidu.tbadk.core.sharedPref.b.sN().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", true)) {
                it(true);
            } else {
                it(false);
            }
            akB();
        }
    }

    private boolean aOe() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PersonPostActivityConfig.class);
    }

    private boolean aOf() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    private boolean aOg() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PersonBarActivityConfig.class);
    }

    private void akB() {
        if (this.mUser != null) {
            this.etn.setTitle(this.mContext.getString(u.j.person_forums));
            if (this.mUser.getSex() == 1) {
                this.etm.setTitle(this.mContext.getString(u.j.person_threads_him));
                this.eto.setTitle(this.mContext.getString(u.j.person_groups_him));
                return;
            }
            this.etm.setTitle(this.mContext.getString(u.j.person_threads_her));
            this.eto.setTitle(this.mContext.getString(u.j.person_groups_her));
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (this.etm != null) {
            this.etm.n(tbPageContext);
        }
        if (this.eto != null) {
            this.eto.n(tbPageContext);
        }
        if (this.etn != null) {
            this.etn.n(tbPageContext);
        }
        av.k(this.etq, u.d.cp_bg_line_b);
        av.k(this.etl, u.d.cp_bg_line_d);
        av.k(this.etp, u.d.cp_bg_line_d);
        aOh();
    }

    private void aOh() {
        if (this.etr != null && this.etl != null) {
            if (this.etl.getVisibility() == 8) {
                this.etr.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_down));
            } else {
                this.etr.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_up));
            }
        }
    }

    private void it(boolean z) {
        if (z) {
            this.etl.setVisibility(0);
            this.etq.setVisibility(0);
            this.etr.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_up));
            return;
        }
        this.etl.setVisibility(8);
        this.etq.setVisibility(8);
        this.etr.setImageDrawable(av.getDrawable(u.f.icon_mine_arrow_down));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.etp == view || this.etr == view) {
            if (this.etr != null && this.etl != null) {
                if (this.etl.getVisibility() == 8) {
                    it(true);
                } else {
                    it(false);
                }
            }
        } else if (view == this.etm) {
            if (this.mUser != null && this.etj != null && com.baidu.tbadk.core.util.bn.ab(this.mContext)) {
                if (ol(1)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex(), this.mUser.getPortrait())));
                    TiebaStatic.log(new ay("c10618").s("obj_type", 1).ab("obj_id", this.mUser.getUserId()));
                    return;
                }
                TiebaStatic.log(new ay("c10618").s("obj_type", 3).ab("obj_id", this.mUser.getUserId()));
                BdToast.a(this.mContext, this.mContext.getResources().getString(u.j.user_set_private)).sa();
            }
        } else if (view == this.etn) {
            if (this.mUser != null && this.etj != null && com.baidu.tbadk.core.util.bn.ab(this.mContext)) {
                if (ol(2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mContext, this.mUser.getLike_bars(), this.mUser.getUserId(), this.mUser.getSex())));
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getResources().getString(u.j.user_set_private)).sa();
            }
        } else if (view == this.eto && this.mUser != null && this.etj != null && com.baidu.tbadk.core.util.bn.ab(this.mContext)) {
            if (ol(3)) {
                TiebaStatic.log(new ay("c10620").s("obj_type", 1).ab("obj_id", this.mUser.getUserId()));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex())));
                return;
            }
            TiebaStatic.log(new ay("c10620").s("obj_type", 3).ab("obj_id", this.mUser.getUserId()));
            BdToast.a(this.mContext, this.mContext.getResources().getString(u.j.user_set_private)).sa();
        }
    }

    private boolean ol(int i) {
        int i2;
        if (this.mUser == null || this.etj == null) {
            return false;
        }
        j personPrivate = this.mUser.getPersonPrivate();
        PersonTainInfo aPD = this.etj.aPD();
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
        return i2 == 1 || (i2 == 2 && (aPD != null ? aPD.getIsFriend() : 1) == 1);
    }
}
