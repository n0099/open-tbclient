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
    private View aAZ;
    private LinearLayout cZl;
    private View.OnClickListener cas;
    private TbSettingTextTipView gxU;
    private TbSettingTextTipView gxV;
    private TbSettingTextTipView gxW;
    private TbSettingTextTipView gxX;
    private MsgSettingItemView gxY;
    private View gxZ;
    private TbSettingTextTipView gya;
    private View gyb;
    private TbSettingTextTipView gyc;
    private MsgSettingItemView gyd;
    private SecretSettingActivity gye;
    private View gyf;
    private String[] gyg;
    private BdSwitchView.a gyh;
    private a gyi;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void b(BdSwitchView.SwitchState switchState);

        void bpc();

        void bpd();

        void bpe();

        void bpf();

        void bpg();

        void bph();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gyi != null) {
                    if (view == c.this.aAZ) {
                        c.this.gyi.onBackPressed();
                    } else if (view == c.this.gxU) {
                        c.this.gyi.bpc();
                    } else if (view == c.this.gxV) {
                        c.this.gyi.bpd();
                    } else if (view == c.this.gxW) {
                        c.this.gyi.bpf();
                    } else if (view == c.this.gyc) {
                        c.this.gyi.bpe();
                    } else if (view == c.this.gxX) {
                        c.this.gyi.bpg();
                    } else if (view == c.this.gya) {
                        c.this.gyi.bph();
                    }
                }
            }
        };
        this.gyh = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == c.this.gyd.getSwitchView()) {
                    if (c.this.gyi != null) {
                        c.this.gyi.a(switchState);
                    }
                } else if (view == c.this.gxY.getSwitchView() && c.this.gyi != null) {
                    c.this.gyi.b(switchState);
                }
            }
        };
        this.gye = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gye.getLayoutMode().setNightMode(i == 1);
        this.gye.getLayoutMode().onModeChanged(this.cZl);
        this.mNavigationBar.onChangeSkinType(this.gye.getPageContext(), i);
        this.gyd.d(this.gye.getPageContext(), i);
        this.gxY.d(this.gye.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.cZl = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.gxU = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.gxV = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.gyc = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.gyb = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.gxW = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.gxX = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.gya = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.gxZ = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.gxY = (MsgSettingItemView) this.gye.findViewById(d.g.recently_bar_switch);
        this.gxY.setLineVisibility(false);
        this.gxY.setSpaceView(8);
        this.gxY.setText(d.j.privacy_hide_recently_bar_text);
        this.gxY.setOnSwitchStateChangeListener(this.gyh);
        lP(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
        this.aAZ.setOnClickListener(this.cas);
        this.gxU.setOnClickListener(this.cas);
        this.gxX.setOnClickListener(this.cas);
        this.gyc.setOnClickListener(this.cas);
        this.gxV.setOnClickListener(this.cas);
        this.gxW.setOnClickListener(this.cas);
        this.gya.setOnClickListener(this.cas);
        this.gyf = this.gye.findViewById(d.g.privacy_setting_container);
        this.gyg = this.gye.getResources().getStringArray(d.b.privacy_setting_config);
        this.gyd = (MsgSettingItemView) this.gye.findViewById(d.g.sv_shared_location);
        this.gyd.setLineVisibility(false);
        this.gyd.setText(d.j.privacy_setting_shared_location);
        this.gyd.setOnSwitchStateChangeListener(this.gyh);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gyc.setVisibility(0);
            this.gyb.setVisibility(0);
            return;
        }
        this.gyc.setVisibility(8);
        this.gyb.setVisibility(8);
    }

    public void a(a aVar) {
        this.gyi = aVar;
    }

    public void bpi() {
        this.gxU.recycle();
    }

    public void lN(boolean z) {
        if (z) {
            this.gyf.setVisibility(0);
        } else {
            this.gyf.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.hv().ax("reply_private_setting_switch") == 1) {
            this.gxZ.setVisibility(0);
            this.gya.setVisibility(0);
            return;
        }
        this.gxZ.setVisibility(8);
        this.gya.setVisibility(8);
    }

    public void aI(String str, int i) {
        int i2 = i - 1;
        if (this.gyg != null && i2 < this.gyg.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gxV.setTip(this.gyg[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gyc.setTip(this.gyg[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gxW.setTip(this.gyg[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gya.setTip(this.gye.getString(d.j.all_person));
                } else {
                    this.gya.setTip(this.gyg[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gyg != null) {
            int length = this.gyg.length;
            int boX = aVar.boX() - 1;
            if (boX < length && boX >= 0) {
                this.gyc.setTip(this.gyg[boX]);
            }
            int boW = aVar.boW() - 1;
            if (boW < length && boW >= 0) {
                this.gxV.setTip(this.gyg[boW]);
            }
            int GW = aVar.GW() - 1;
            if (GW < length && GW >= 0) {
                this.gxW.setTip(this.gyg[GW]);
            }
            int boZ = aVar.boZ() - 1;
            if (boZ < length && boZ >= 0) {
                if (boZ == 0) {
                    this.gya.setTip(this.gye.getString(d.j.all_person));
                } else {
                    this.gya.setTip(this.gyg[boZ]);
                }
            }
            lO(aVar.boY());
        }
    }

    public void lO(boolean z) {
        if (z) {
            this.gyd.getSwitchView().mC();
        } else {
            this.gyd.getSwitchView().mD();
        }
    }

    public boolean bpj() {
        return this.gyd.getSwitchView().iq();
    }

    public void lP(boolean z) {
        if (z) {
            this.gxY.getSwitchView().mC();
        } else {
            this.gxY.getSwitchView().mD();
        }
    }
}
