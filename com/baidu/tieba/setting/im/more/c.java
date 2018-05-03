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
    private View.OnClickListener bOi;
    private LinearLayout cOh;
    private TbSettingTextTipView ggA;
    private View ggB;
    private TbSettingTextTipView ggC;
    private MsgSettingItemView ggD;
    private SecretSettingActivity ggE;
    private View ggF;
    private String[] ggG;
    private BdSwitchView.a ggH;
    private a ggI;
    private TbSettingTextTipView ggv;
    private TbSettingTextTipView ggw;
    private TbSettingTextTipView ggx;
    private TbSettingTextTipView ggy;
    private View ggz;
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
        this.bOi = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ggI != null) {
                    if (view2 == c.this.asg) {
                        c.this.ggI.onBackPressed();
                    } else if (view2 == c.this.ggv) {
                        c.this.ggI.blb();
                    } else if (view2 == c.this.ggw) {
                        c.this.ggI.blc();
                    } else if (view2 == c.this.ggx) {
                        c.this.ggI.ble();
                    } else if (view2 == c.this.ggC) {
                        c.this.ggI.bld();
                    } else if (view2 == c.this.ggy) {
                        c.this.ggI.blf();
                    } else if (view2 == c.this.ggA) {
                        c.this.ggI.blg();
                    }
                }
            }
        };
        this.ggH = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view2, BdSwitchView.SwitchState switchState) {
                if (view2 == c.this.ggD.getSwitchView() && c.this.ggI != null) {
                    c.this.ggI.a(switchState);
                }
            }
        };
        this.ggE = secretSettingActivity;
        secretSettingActivity.setContentView(d.i.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ggE.getLayoutMode().setNightMode(i == 1);
        this.ggE.getLayoutMode().u(this.cOh);
        this.mNavigationBar.onChangeSkinType(this.ggE.getPageContext(), i);
        this.ggD.d(this.ggE.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.cOh = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.k.secretSetting));
        this.ggv = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.ggw = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.ggC = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.ggB = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.ggx = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.ggy = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.ggA = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.ggz = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.asg.setOnClickListener(this.bOi);
        this.ggv.setOnClickListener(this.bOi);
        this.ggy.setOnClickListener(this.bOi);
        this.ggC.setOnClickListener(this.bOi);
        this.ggw.setOnClickListener(this.bOi);
        this.ggx.setOnClickListener(this.bOi);
        this.ggA.setOnClickListener(this.bOi);
        this.ggF = this.ggE.findViewById(d.g.privacy_setting_container);
        this.ggG = this.ggE.getResources().getStringArray(d.b.privacy_setting_config);
        this.ggD = (MsgSettingItemView) this.ggE.findViewById(d.g.sv_shared_location);
        this.ggD.setLineVisibility(false);
        this.ggD.setText(d.k.privacy_setting_shared_location);
        this.ggD.setOnSwitchStateChangeListener(this.ggH);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.ggC.setVisibility(0);
            this.ggB.setVisibility(0);
            return;
        }
        this.ggC.setVisibility(8);
        this.ggB.setVisibility(8);
    }

    public void a(a aVar) {
        this.ggI = aVar;
    }

    public void blh() {
        this.ggv.recycle();
    }

    public void lL(boolean z) {
        if (z) {
            this.ggF.setVisibility(0);
        } else {
            this.ggF.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.eE().ak("reply_private_setting_switch") == 1) {
            this.ggz.setVisibility(0);
            this.ggA.setVisibility(0);
            return;
        }
        this.ggz.setVisibility(8);
        this.ggA.setVisibility(8);
    }

    public void aI(String str, int i) {
        int i2 = i - 1;
        if (this.ggG != null && i2 < this.ggG.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.ggw.setTip(this.ggG[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.ggC.setTip(this.ggG[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.ggx.setTip(this.ggG[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.ggA.setTip(this.ggE.getString(d.k.all_person));
                } else {
                    this.ggA.setTip(this.ggG[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.ggG != null) {
            int length = this.ggG.length;
            int bkW = aVar.bkW() - 1;
            if (bkW < length && bkW >= 0) {
                this.ggC.setTip(this.ggG[bkW]);
            }
            int bkV = aVar.bkV() - 1;
            if (bkV < length && bkV >= 0) {
                this.ggw.setTip(this.ggG[bkV]);
            }
            int Dh = aVar.Dh() - 1;
            if (Dh < length && Dh >= 0) {
                this.ggx.setTip(this.ggG[Dh]);
            }
            int bkY = aVar.bkY() - 1;
            if (bkY < length && bkY >= 0) {
                if (bkY == 0) {
                    this.ggA.setTip(this.ggE.getString(d.k.all_person));
                } else {
                    this.ggA.setTip(this.ggG[bkY]);
                }
            }
            lM(aVar.bkX());
        }
    }

    public void lM(boolean z) {
        if (z) {
            this.ggD.getSwitchView().jM();
        } else {
            this.ggD.getSwitchView().jN();
        }
    }

    public boolean bli() {
        return this.ggD.getSwitchView().fz();
    }
}
