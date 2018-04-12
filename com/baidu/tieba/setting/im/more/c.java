package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View asg;
    private View.OnClickListener bOj;
    private LinearLayout cOk;
    private TbSettingTextTipView ggA;
    private TbSettingTextTipView ggB;
    private View ggC;
    private TbSettingTextTipView ggD;
    private View ggE;
    private TbSettingTextTipView ggF;
    private MsgSettingItemView ggG;
    private SecretSettingActivity ggH;
    private View ggI;
    private String[] ggJ;
    private BdSwitchView.a ggK;
    private a ggL;
    private TbSettingTextTipView ggy;
    private TbSettingTextTipView ggz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void blb();

        void blc();

        void bld();

        void ble();

        void blf();

        void blg();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ggL != null) {
                    if (view2 == c.this.asg) {
                        c.this.ggL.onBackPressed();
                    } else if (view2 == c.this.ggy) {
                        c.this.ggL.blb();
                    } else if (view2 == c.this.ggz) {
                        c.this.ggL.blc();
                    } else if (view2 == c.this.ggA) {
                        c.this.ggL.ble();
                    } else if (view2 == c.this.ggF) {
                        c.this.ggL.bld();
                    } else if (view2 == c.this.ggB) {
                        c.this.ggL.blf();
                    } else if (view2 == c.this.ggD) {
                        c.this.ggL.blg();
                    }
                }
            }
        };
        this.ggK = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view2, BdSwitchView.SwitchState switchState) {
                if (view2 == c.this.ggG.getSwitchView() && c.this.ggL != null) {
                    c.this.ggL.a(switchState);
                }
            }
        };
        this.ggH = secretSettingActivity;
        secretSettingActivity.setContentView(d.i.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ggH.getLayoutMode().setNightMode(i == 1);
        this.ggH.getLayoutMode().u(this.cOk);
        this.mNavigationBar.onChangeSkinType(this.ggH.getPageContext(), i);
        this.ggG.d(this.ggH.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.cOk = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.k.secretSetting));
        this.ggy = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.ggz = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.ggF = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.ggE = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.ggA = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.ggB = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.ggD = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.ggC = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.asg.setOnClickListener(this.bOj);
        this.ggy.setOnClickListener(this.bOj);
        this.ggB.setOnClickListener(this.bOj);
        this.ggF.setOnClickListener(this.bOj);
        this.ggz.setOnClickListener(this.bOj);
        this.ggA.setOnClickListener(this.bOj);
        this.ggD.setOnClickListener(this.bOj);
        this.ggI = this.ggH.findViewById(d.g.privacy_setting_container);
        this.ggJ = this.ggH.getResources().getStringArray(d.b.privacy_setting_config);
        this.ggG = (MsgSettingItemView) this.ggH.findViewById(d.g.sv_shared_location);
        this.ggG.setLineVisibility(false);
        this.ggG.setText(d.k.privacy_setting_shared_location);
        this.ggG.setOnSwitchStateChangeListener(this.ggK);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.ggF.setVisibility(0);
            this.ggE.setVisibility(0);
            return;
        }
        this.ggF.setVisibility(8);
        this.ggE.setVisibility(8);
    }

    public void a(a aVar) {
        this.ggL = aVar;
    }

    public void blh() {
        this.ggy.recycle();
    }

    public void lL(boolean z) {
        if (z) {
            this.ggI.setVisibility(0);
        } else {
            this.ggI.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.eE().ak("reply_private_setting_switch") == 1) {
            this.ggC.setVisibility(0);
            this.ggD.setVisibility(0);
            return;
        }
        this.ggC.setVisibility(8);
        this.ggD.setVisibility(8);
    }

    public void aI(String str, int i) {
        int i2 = i - 1;
        if (this.ggJ != null && i2 < this.ggJ.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.ggz.setTip(this.ggJ[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.ggF.setTip(this.ggJ[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.ggA.setTip(this.ggJ[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.ggD.setTip(this.ggH.getString(d.k.all_person));
                } else {
                    this.ggD.setTip(this.ggJ[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.ggJ != null) {
            int length = this.ggJ.length;
            int bkW = aVar.bkW() - 1;
            if (bkW < length && bkW >= 0) {
                this.ggF.setTip(this.ggJ[bkW]);
            }
            int bkV = aVar.bkV() - 1;
            if (bkV < length && bkV >= 0) {
                this.ggz.setTip(this.ggJ[bkV]);
            }
            int Dh = aVar.Dh() - 1;
            if (Dh < length && Dh >= 0) {
                this.ggA.setTip(this.ggJ[Dh]);
            }
            int bkY = aVar.bkY() - 1;
            if (bkY < length && bkY >= 0) {
                if (bkY == 0) {
                    this.ggD.setTip(this.ggH.getString(d.k.all_person));
                } else {
                    this.ggD.setTip(this.ggJ[bkY]);
                }
            }
            lM(aVar.bkX());
        }
    }

    public void lM(boolean z) {
        if (z) {
            this.ggG.getSwitchView().jM();
        } else {
            this.ggG.getSwitchView().jN();
        }
    }

    public boolean bli() {
        return this.ggG.getSwitchView().fz();
    }
}
