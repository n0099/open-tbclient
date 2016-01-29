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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.data.f;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.bf;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoGodEnterView extends LinearLayout implements View.OnClickListener {
    private bf dcQ;
    private View dcS;
    private PersonInfoEnterItemView dcT;
    private PersonInfoEnterItemView dcU;
    private PersonInfoEnterItemView dcV;
    private View dcW;
    private View dcX;
    private ImageView dcY;
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
        this.dcS = inflate.findViewById(t.g.layout_views);
        this.dcT = (PersonInfoEnterItemView) inflate.findViewById(t.g.view_threads);
        this.dcU = (PersonInfoEnterItemView) inflate.findViewById(t.g.view_forums);
        this.dcV = (PersonInfoEnterItemView) inflate.findViewById(t.g.viewr_groups);
        this.dcW = inflate.findViewById(t.g.layout_bottom_arrow);
        this.dcX = inflate.findViewById(t.g.arrow_line);
        this.dcY = (ImageView) inflate.findViewById(t.g.iv_arrow);
        this.dcW.setOnClickListener(this);
        this.dcY.setOnClickListener(this);
        this.dcT.setOnClickListener(this);
        this.dcU.setOnClickListener(this);
        this.dcV.setOnClickListener(this);
    }

    public void setData(bf bfVar) {
        if (bfVar != null) {
            this.dcQ = bfVar;
            this.mUser = bfVar.getUserData();
            if (auH()) {
                this.dcT.setVisibility(0);
                this.dcT.setIcon(t.f.icon_mine_tie);
                this.dcT.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dcT.setVisibility(8);
            }
            if (auI()) {
                this.dcV.setVisibility(0);
                this.dcV.setIcon(t.f.icon_mine_group);
                this.dcV.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dcV.setVisibility(8);
            }
            if (auJ()) {
                this.dcU.setVisibility(0);
                this.dcU.setIcon(t.f.icon_mine_ba);
                this.dcU.setBackgroundResource(t.f.bg_icon_mine_selector);
            } else {
                this.dcU.setVisibility(8);
            }
            if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", true)) {
                fW(true);
            } else {
                fW(false);
            }
            Yl();
        }
    }

    private boolean auH() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonPostActivityConfig.class);
    }

    private boolean auI() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    private boolean auJ() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonBarActivityConfig.class);
    }

    private void Yl() {
        if (this.mUser != null) {
            this.dcU.setTitle(this.mContext.getString(t.j.person_forums));
            if (this.mUser.getSex() == 1) {
                this.dcT.setTitle(this.mContext.getString(t.j.person_threads_him));
                this.dcV.setTitle(this.mContext.getString(t.j.person_groups_him));
                return;
            }
            this.dcT.setTitle(this.mContext.getString(t.j.person_threads_her));
            this.dcV.setTitle(this.mContext.getString(t.j.person_groups_her));
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (this.dcT != null) {
            this.dcT.f(tbPageContext);
        }
        if (this.dcV != null) {
            this.dcV.f(tbPageContext);
        }
        if (this.dcU != null) {
            this.dcU.f(tbPageContext);
        }
        ar.k(this.dcX, t.d.cp_bg_line_b);
        ar.k(this.dcS, t.d.cp_bg_line_d);
        ar.k(this.dcW, t.d.cp_bg_line_d);
        auK();
    }

    private void auK() {
        if (this.dcY != null && this.dcS != null) {
            if (this.dcS.getVisibility() == 8) {
                this.dcY.setImageDrawable(ar.getDrawable(t.f.icon_mine_arrow_down));
            } else {
                this.dcY.setImageDrawable(ar.getDrawable(t.f.icon_mine_arrow_up));
            }
        }
    }

    private void fW(boolean z) {
        if (z) {
            this.dcS.setVisibility(0);
            this.dcX.setVisibility(0);
            this.dcY.setImageDrawable(ar.getDrawable(t.f.icon_mine_arrow_up));
            return;
        }
        this.dcS.setVisibility(8);
        this.dcX.setVisibility(8);
        this.dcY.setImageDrawable(ar.getDrawable(t.f.icon_mine_arrow_down));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dcW == view || this.dcY == view) {
            if (this.dcY != null && this.dcS != null) {
                if (this.dcS.getVisibility() == 8) {
                    fW(true);
                } else {
                    fW(false);
                }
            }
        } else if (view == this.dcT) {
            if (this.mUser != null && this.dcQ != null && bi.ah(this.mContext)) {
                if (ly(1)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex(), this.mUser.getPortrait())));
                    TiebaStatic.log(new au("c10618").r("obj_type", 1).aa("obj_id", this.mUser.getUserId()));
                    return;
                }
                TiebaStatic.log(new au("c10618").r("obj_type", 3).aa("obj_id", this.mUser.getUserId()));
                BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).us();
            }
        } else if (view == this.dcU) {
            if (this.mUser != null && this.dcQ != null && bi.ah(this.mContext)) {
                if (ly(2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mContext, this.mUser.getLike_bars(), this.mUser.getUserId(), this.mUser.getSex())));
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).us();
            }
        } else if (view == this.dcV && this.mUser != null && this.dcQ != null && bi.ah(this.mContext)) {
            if (ly(3)) {
                TiebaStatic.log(new au("c10620").r("obj_type", 1).aa("obj_id", this.mUser.getUserId()));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mContext, this.mUser.getUserId(), this.mUser.getSex())));
                return;
            }
            TiebaStatic.log(new au("c10620").r("obj_type", 3).aa("obj_id", this.mUser.getUserId()));
            BdToast.a(this.mContext, this.mContext.getResources().getString(t.j.user_set_private)).us();
        }
    }

    private boolean ly(int i) {
        int i2;
        if (this.mUser == null || this.dcQ == null) {
            return false;
        }
        f personPrivate = this.mUser.getPersonPrivate();
        PersonTainInfo avA = this.dcQ.avA();
        if (personPrivate == null) {
            i2 = 1;
        } else if (i == 1) {
            i2 = personPrivate.Ce();
        } else if (i == 2) {
            i2 = personPrivate.Cc();
        } else if (i != 3) {
            return false;
        } else {
            i2 = personPrivate.Cd();
        }
        return i2 == 1 || (i2 == 2 && (avA != null ? avA.getIsFriend() : 1) == 1);
    }
}
