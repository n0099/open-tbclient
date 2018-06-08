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
    private View aAn;
    private View.OnClickListener bWZ;
    private LinearLayout cYt;
    private TbSettingTextTipView gsV;
    private TbSettingTextTipView gsW;
    private TbSettingTextTipView gsX;
    private TbSettingTextTipView gsY;
    private View gsZ;
    private TbSettingTextTipView gta;
    private View gtb;
    private TbSettingTextTipView gtc;
    private MsgSettingItemView gtd;
    private SecretSettingActivity gte;
    private View gtf;
    private String[] gtg;
    private BdSwitchView.a gth;
    private a gti;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void bpY();

        void bpZ();

        void bqa();

        void bqb();

        void bqc();

        void bqd();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gti != null) {
                    if (view == c.this.aAn) {
                        c.this.gti.onBackPressed();
                    } else if (view == c.this.gsV) {
                        c.this.gti.bpY();
                    } else if (view == c.this.gsW) {
                        c.this.gti.bpZ();
                    } else if (view == c.this.gsX) {
                        c.this.gti.bqb();
                    } else if (view == c.this.gtc) {
                        c.this.gti.bqa();
                    } else if (view == c.this.gsY) {
                        c.this.gti.bqc();
                    } else if (view == c.this.gta) {
                        c.this.gti.bqd();
                    }
                }
            }
        };
        this.gth = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == c.this.gtd.getSwitchView() && c.this.gti != null) {
                    c.this.gti.a(switchState);
                }
            }
        };
        this.gte = secretSettingActivity;
        secretSettingActivity.setContentView(d.i.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gte.getLayoutMode().setNightMode(i == 1);
        this.gte.getLayoutMode().onModeChanged(this.cYt);
        this.mNavigationBar.onChangeSkinType(this.gte.getPageContext(), i);
        this.gtd.d(this.gte.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.cYt = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.k.secretSetting));
        this.gsV = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.gsW = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.gtc = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.gtb = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.gsX = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.gsY = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.gta = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.gsZ = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.aAn.setOnClickListener(this.bWZ);
        this.gsV.setOnClickListener(this.bWZ);
        this.gsY.setOnClickListener(this.bWZ);
        this.gtc.setOnClickListener(this.bWZ);
        this.gsW.setOnClickListener(this.bWZ);
        this.gsX.setOnClickListener(this.bWZ);
        this.gta.setOnClickListener(this.bWZ);
        this.gtf = this.gte.findViewById(d.g.privacy_setting_container);
        this.gtg = this.gte.getResources().getStringArray(d.b.privacy_setting_config);
        this.gtd = (MsgSettingItemView) this.gte.findViewById(d.g.sv_shared_location);
        this.gtd.setLineVisibility(false);
        this.gtd.setText(d.k.privacy_setting_shared_location);
        this.gtd.setOnSwitchStateChangeListener(this.gth);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gtc.setVisibility(0);
            this.gtb.setVisibility(0);
            return;
        }
        this.gtc.setVisibility(8);
        this.gtb.setVisibility(8);
    }

    public void a(a aVar) {
        this.gti = aVar;
    }

    public void bqe() {
        this.gsV.recycle();
    }

    public void lS(boolean z) {
        if (z) {
            this.gtf.setVisibility(0);
        } else {
            this.gtf.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.hv().aw("reply_private_setting_switch") == 1) {
            this.gsZ.setVisibility(0);
            this.gta.setVisibility(0);
            return;
        }
        this.gsZ.setVisibility(8);
        this.gta.setVisibility(8);
    }

    public void aL(String str, int i) {
        int i2 = i - 1;
        if (this.gtg != null && i2 < this.gtg.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gsW.setTip(this.gtg[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gtc.setTip(this.gtg[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gsX.setTip(this.gtg[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gta.setTip(this.gte.getString(d.k.all_person));
                } else {
                    this.gta.setTip(this.gtg[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gtg != null) {
            int length = this.gtg.length;
            int bpT = aVar.bpT() - 1;
            if (bpT < length && bpT >= 0) {
                this.gtc.setTip(this.gtg[bpT]);
            }
            int bpS = aVar.bpS() - 1;
            if (bpS < length && bpS >= 0) {
                this.gsW.setTip(this.gtg[bpS]);
            }
            int GI = aVar.GI() - 1;
            if (GI < length && GI >= 0) {
                this.gsX.setTip(this.gtg[GI]);
            }
            int bpV = aVar.bpV() - 1;
            if (bpV < length && bpV >= 0) {
                if (bpV == 0) {
                    this.gta.setTip(this.gte.getString(d.k.all_person));
                } else {
                    this.gta.setTip(this.gtg[bpV]);
                }
            }
            lT(aVar.bpU());
        }
    }

    public void lT(boolean z) {
        if (z) {
            this.gtd.getSwitchView().mA();
        } else {
            this.gtd.getSwitchView().mB();
        }
    }

    public boolean bqf() {
        return this.gtd.getSwitchView().ip();
    }
}
