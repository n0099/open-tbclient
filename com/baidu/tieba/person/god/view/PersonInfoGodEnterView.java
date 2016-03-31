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
import com.baidu.tbadk.data.g;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.bf;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoGodEnterView extends LinearLayout implements View.OnClickListener {
    private ImageView dxA;
    private bf dxs;
    private View dxu;
    private PersonInfoEnterItemView dxv;
    private PersonInfoEnterItemView dxw;
    private PersonInfoEnterItemView dxx;
    private View dxy;
    private View dxz;
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
        this.dxu = inflate.findViewById(t.g.layout_views);
        this.dxv = (PersonInfoEnterItemView) inflate.findViewById(t.g.view_threads);
        this.dxw = (PersonInfoEnterItemView) inflate.findViewById(t.g.view_forums);
        this.dxx = (PersonInfoEnterItemView) inflate.findViewById(t.g.viewr_groups);
        this.dxy = inflate.findViewById(t.g.layout_bottom_arrow);
        this.dxz = inflate.findViewById(t.g.arrow_line);
        this.dxA = (ImageView) inflate.findViewById(t.g.iv_arrow);
        this.dxy.setOnClickListener(this);
        this.dxA.setOnClickListener(this);
        this.dxv.setOnClickListener(this);
        this.dxw.setOnClickListener(this);
        this.dxx.setOnClickListener(this);
    }

    public void setData(bf bfVar) {
        if (bfVar != null) {
            this.dxs = bfVar;
            this.mUser = bfVar.getUserData();
            if (aCn()) {
                this.dxv.setVisibility(0);
                this.dxv.setIcon(t.f.icon_mine_tie);
                this.dxv.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dxv.setVisibility(8);
            }
            if (aCo()) {
                this.dxx.setVisibility(0);
                this.dxx.setIcon(t.f.icon_mine_group);
                this.dxx.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dxx.setVisibility(8);
            }
            if (aCp()) {
                this.dxw.setVisibility(0);
                this.dxw.setIcon(t.f.icon_mine_ba);
                this.dxw.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dxw.setVisibility(8);
            }
            if (com.baidu.tbadk.core.sharedPref.b.vk().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", true)) {
                gJ(true);
            } else {
                gJ(false);
            }
            abE();
        }
    }

    private boolean aCn() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonPostActivityConfig.class);
    }

    private boolean aCo() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    private boolean aCp() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonBarActivityConfig.class);
    }

    private void abE() {
        if (this.mUser != null) {
            this.dxw.setTitle(this.mContext.getString(t.j.person_forums));
            if (this.mUser.getSex() == 1) {
                this.dxv.setTitle(this.mContext.getString(t.j.person_threads_him));
                this.dxx.setTitle(this.mContext.getString(t.j.person_groups_him));
                return;
            }
            this.dxv.setTitle(this.mContext.getString(t.j.person_threads_her));
            this.dxx.setTitle(this.mContext.getString(t.j.person_groups_her));
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (this.dxv != null) {
            this.dxv.f(tbPageContext);
        }
        if (this.dxx != null) {
            this.dxx.f(tbPageContext);
        }
        if (this.dxw != null) {
            this.dxw.f(tbPageContext);
        }
        at.k(this.dxz, t.d.cp_bg_line_b);
        at.k(this.dxu, t.d.cp_bg_line_d);
        at.k(this.dxy, t.d.cp_bg_line_d);
        aCq();
    }

    private void aCq() {
        if (this.dxA != null && this.dxu != null) {
            if (this.dxu.getVisibility() == 8) {
                this.dxA.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_down));
            } else {
                this.dxA.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_up));
            }
        }
    }

    private void gJ(boolean z) {
        if (z) {
            this.dxu.setVisibility(0);
            this.dxz.setVisibility(0);
            this.dxA.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_up));
            return;
        }
        this.dxu.setVisibility(8);
        this.dxz.setVisibility(8);
        this.dxA.setImageDrawable(at.getDrawable(t.f.icon_mine_arrow_down));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dxy == view || this.dxA == view) {
            if (this.dxA != null && this.dxu != null) {
                if (this.dxu.getVisibility() == 8) {
                    gJ(true);
                } else {
                    gJ(false);
                }
            }
        } else if (view == this.dxv) {
            if (this.mUser != null && this.dxs != null && bl.ad(this.mContext)) {
                if (mH(1)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex(), this.mUser.getPortrait())));
                    TiebaStatic.log(new aw("c10618").r("obj_type", 1).ac("obj_id", this.mUser.getUserId()));
                    return;
                }
                TiebaStatic.log(new aw("c10618").r("obj_type", 3).ac("obj_id", this.mUser.getUserId()));
                BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).ux();
            }
        } else if (view == this.dxw) {
            if (this.mUser != null && this.dxs != null && bl.ad(this.mContext)) {
                if (mH(2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mContext, this.mUser.getLike_bars(), this.mUser.getUserId(), this.mUser.getSex())));
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).ux();
            }
        } else if (view == this.dxx && this.mUser != null && this.dxs != null && bl.ad(this.mContext)) {
            if (mH(3)) {
                TiebaStatic.log(new aw("c10620").r("obj_type", 1).ac("obj_id", this.mUser.getUserId()));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex())));
                return;
            }
            TiebaStatic.log(new aw("c10620").r("obj_type", 3).ac("obj_id", this.mUser.getUserId()));
            BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).ux();
        }
    }

    private boolean mH(int i) {
        int i2;
        if (this.mUser == null || this.dxs == null) {
            return false;
        }
        g personPrivate = this.mUser.getPersonPrivate();
        PersonTainInfo aDf = this.dxs.aDf();
        if (personPrivate == null) {
            i2 = 1;
        } else if (i == 1) {
            i2 = personPrivate.CJ();
        } else if (i == 2) {
            i2 = personPrivate.CH();
        } else if (i != 3) {
            return false;
        } else {
            i2 = personPrivate.CI();
        }
        return i2 == 1 || (i2 == 2 && (aDf != null ? aDf.getIsFriend() : 1) == 1);
    }
}
