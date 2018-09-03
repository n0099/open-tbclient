package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.f;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View aAW;
    private LinearLayout cZh;
    private View.OnClickListener caq;
    private TbSettingTextTipView gxX;
    private TbSettingTextTipView gxY;
    private TbSettingTextTipView gxZ;
    private TbSettingTextTipView gya;
    private MsgSettingItemView gyb;
    private View gyc;
    private TbSettingTextTipView gyd;
    private View gye;
    private TbSettingTextTipView gyf;
    private MsgSettingItemView gyg;
    private SecretSettingActivity gyh;
    private View gyi;
    private String[] gyj;
    private BdSwitchView.a gyk;
    private a gyl;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void b(BdSwitchView.SwitchState switchState);

        void bpd();

        void bpe();

        void bpf();

        void bpg();

        void bph();

        void bpi();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gyl != null) {
                    if (view == c.this.aAW) {
                        c.this.gyl.onBackPressed();
                    } else if (view == c.this.gxX) {
                        c.this.gyl.bpd();
                    } else if (view == c.this.gxY) {
                        c.this.gyl.bpe();
                    } else if (view == c.this.gxZ) {
                        c.this.gyl.bpg();
                    } else if (view == c.this.gyf) {
                        c.this.gyl.bpf();
                    } else if (view == c.this.gya) {
                        c.this.gyl.bph();
                    } else if (view == c.this.gyd) {
                        c.this.gyl.bpi();
                    }
                }
            }
        };
        this.gyk = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == c.this.gyg.getSwitchView()) {
                    if (c.this.gyl != null) {
                        c.this.gyl.a(switchState);
                    }
                } else if (view == c.this.gyb.getSwitchView() && c.this.gyl != null) {
                    c.this.gyl.b(switchState);
                }
            }
        };
        this.gyh = secretSettingActivity;
        secretSettingActivity.setContentView(f.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gyh.getLayoutMode().setNightMode(i == 1);
        this.gyh.getLayoutMode().onModeChanged(this.cZh);
        this.mNavigationBar.onChangeSkinType(this.gyh.getPageContext(), i);
        this.gyg.d(this.gyh.getPageContext(), i);
        this.gyb.d(this.gyh.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.cZh = (LinearLayout) secretSettingActivity.findViewById(f.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(f.g.view_navigation_bar);
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(f.j.secretSetting));
        this.gxX = (TbSettingTextTipView) secretSettingActivity.findViewById(f.g.black_address_list);
        this.gxY = (TbSettingTextTipView) secretSettingActivity.findViewById(f.g.privacy_attention_bar);
        this.gyf = (TbSettingTextTipView) secretSettingActivity.findViewById(f.g.privacy_attention_group);
        this.gye = secretSettingActivity.findViewById(f.g.divide_line_under_privacy_attention_group);
        this.gxZ = (TbSettingTextTipView) secretSettingActivity.findViewById(f.g.privacy_attention_live);
        this.gya = (TbSettingTextTipView) secretSettingActivity.findViewById(f.g.user_mute_list);
        this.gyd = (TbSettingTextTipView) secretSettingActivity.findViewById(f.g.thread_reply_setting);
        this.gyc = secretSettingActivity.findViewById(f.g.container_thread_reply_setting);
        this.gyb = (MsgSettingItemView) this.gyh.findViewById(f.g.recently_bar_switch);
        this.gyb.setLineVisibility(false);
        this.gyb.setSpaceView(8);
        this.gyb.setText(f.j.privacy_hide_recently_bar_text);
        this.gyb.setOnSwitchStateChangeListener(this.gyk);
        lP(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
        this.aAW.setOnClickListener(this.caq);
        this.gxX.setOnClickListener(this.caq);
        this.gya.setOnClickListener(this.caq);
        this.gyf.setOnClickListener(this.caq);
        this.gxY.setOnClickListener(this.caq);
        this.gxZ.setOnClickListener(this.caq);
        this.gyd.setOnClickListener(this.caq);
        this.gyi = this.gyh.findViewById(f.g.privacy_setting_container);
        this.gyj = this.gyh.getResources().getStringArray(f.b.privacy_setting_config);
        this.gyg = (MsgSettingItemView) this.gyh.findViewById(f.g.sv_shared_location);
        this.gyg.setLineVisibility(false);
        this.gyg.setText(f.j.privacy_setting_shared_location);
        this.gyg.setOnSwitchStateChangeListener(this.gyk);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gyf.setVisibility(0);
            this.gye.setVisibility(0);
            return;
        }
        this.gyf.setVisibility(8);
        this.gye.setVisibility(8);
    }

    public void a(a aVar) {
        this.gyl = aVar;
    }

    public void bpj() {
        this.gxX.recycle();
    }

    public void lN(boolean z) {
        if (z) {
            this.gyi.setVisibility(0);
        } else {
            this.gyi.setVisibility(8);
        }
        if (d.hv().ax("reply_private_setting_switch") == 1) {
            this.gyc.setVisibility(0);
            this.gyd.setVisibility(0);
            return;
        }
        this.gyc.setVisibility(8);
        this.gyd.setVisibility(8);
    }

    public void aI(String str, int i) {
        int i2 = i - 1;
        if (this.gyj != null && i2 < this.gyj.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gxY.setTip(this.gyj[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gyf.setTip(this.gyj[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gxZ.setTip(this.gyj[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gyd.setTip(this.gyh.getString(f.j.all_person));
                } else {
                    this.gyd.setTip(this.gyj[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gyj != null) {
            int length = this.gyj.length;
            int boY = aVar.boY() - 1;
            if (boY < length && boY >= 0) {
                this.gyf.setTip(this.gyj[boY]);
            }
            int boX = aVar.boX() - 1;
            if (boX < length && boX >= 0) {
                this.gxY.setTip(this.gyj[boX]);
            }
            int GW = aVar.GW() - 1;
            if (GW < length && GW >= 0) {
                this.gxZ.setTip(this.gyj[GW]);
            }
            int bpa = aVar.bpa() - 1;
            if (bpa < length && bpa >= 0) {
                if (bpa == 0) {
                    this.gyd.setTip(this.gyh.getString(f.j.all_person));
                } else {
                    this.gyd.setTip(this.gyj[bpa]);
                }
            }
            lO(aVar.boZ());
        }
    }

    public void lO(boolean z) {
        if (z) {
            this.gyg.getSwitchView().mC();
        } else {
            this.gyg.getSwitchView().mD();
        }
    }

    public boolean bpk() {
        return this.gyg.getSwitchView().iq();
    }

    public void lP(boolean z) {
        if (z) {
            this.gyb.getSwitchView().mC();
        } else {
            this.gyb.getSwitchView().mD();
        }
    }
}
