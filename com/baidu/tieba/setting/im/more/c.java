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
    private View aBf;
    private View.OnClickListener bZi;
    private LinearLayout cWw;
    private TbSettingTextTipView gwM;
    private TbSettingTextTipView gwN;
    private TbSettingTextTipView gwO;
    private TbSettingTextTipView gwP;
    private MsgSettingItemView gwQ;
    private View gwR;
    private TbSettingTextTipView gwS;
    private View gwT;
    private TbSettingTextTipView gwU;
    private MsgSettingItemView gwV;
    private SecretSettingActivity gwW;
    private View gwX;
    private String[] gwY;
    private BdSwitchView.a gwZ;
    private a gxa;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void b(BdSwitchView.SwitchState switchState);

        void bqA();

        void bqB();

        void bqC();

        void bqD();

        void bqE();

        void bqz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.bZi = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gxa != null) {
                    if (view == c.this.aBf) {
                        c.this.gxa.onBackPressed();
                    } else if (view == c.this.gwM) {
                        c.this.gxa.bqz();
                    } else if (view == c.this.gwN) {
                        c.this.gxa.bqA();
                    } else if (view == c.this.gwO) {
                        c.this.gxa.bqC();
                    } else if (view == c.this.gwU) {
                        c.this.gxa.bqB();
                    } else if (view == c.this.gwP) {
                        c.this.gxa.bqD();
                    } else if (view == c.this.gwS) {
                        c.this.gxa.bqE();
                    }
                }
            }
        };
        this.gwZ = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == c.this.gwV.getSwitchView()) {
                    if (c.this.gxa != null) {
                        c.this.gxa.a(switchState);
                    }
                } else if (view == c.this.gwQ.getSwitchView() && c.this.gxa != null) {
                    c.this.gxa.b(switchState);
                }
            }
        };
        this.gwW = secretSettingActivity;
        secretSettingActivity.setContentView(d.i.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gwW.getLayoutMode().setNightMode(i == 1);
        this.gwW.getLayoutMode().onModeChanged(this.cWw);
        this.mNavigationBar.onChangeSkinType(this.gwW.getPageContext(), i);
        this.gwV.d(this.gwW.getPageContext(), i);
        this.gwQ.d(this.gwW.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.cWw = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.k.secretSetting));
        this.gwM = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.gwN = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.gwU = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.gwT = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.gwO = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.gwP = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.gwS = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.gwR = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.gwQ = (MsgSettingItemView) this.gwW.findViewById(d.g.recently_bar_switch);
        this.gwQ.setLineVisibility(false);
        this.gwQ.setSpaceView(8);
        this.gwQ.setText(d.k.privacy_hide_recently_bar_text);
        this.gwQ.setOnSwitchStateChangeListener(this.gwZ);
        me(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
        this.aBf.setOnClickListener(this.bZi);
        this.gwM.setOnClickListener(this.bZi);
        this.gwP.setOnClickListener(this.bZi);
        this.gwU.setOnClickListener(this.bZi);
        this.gwN.setOnClickListener(this.bZi);
        this.gwO.setOnClickListener(this.bZi);
        this.gwS.setOnClickListener(this.bZi);
        this.gwX = this.gwW.findViewById(d.g.privacy_setting_container);
        this.gwY = this.gwW.getResources().getStringArray(d.b.privacy_setting_config);
        this.gwV = (MsgSettingItemView) this.gwW.findViewById(d.g.sv_shared_location);
        this.gwV.setLineVisibility(false);
        this.gwV.setText(d.k.privacy_setting_shared_location);
        this.gwV.setOnSwitchStateChangeListener(this.gwZ);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gwU.setVisibility(0);
            this.gwT.setVisibility(0);
            return;
        }
        this.gwU.setVisibility(8);
        this.gwT.setVisibility(8);
    }

    public void a(a aVar) {
        this.gxa = aVar;
    }

    public void bqF() {
        this.gwM.recycle();
    }

    public void mc(boolean z) {
        if (z) {
            this.gwX.setVisibility(0);
        } else {
            this.gwX.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.hv().aw("reply_private_setting_switch") == 1) {
            this.gwR.setVisibility(0);
            this.gwS.setVisibility(0);
            return;
        }
        this.gwR.setVisibility(8);
        this.gwS.setVisibility(8);
    }

    public void aM(String str, int i) {
        int i2 = i - 1;
        if (this.gwY != null && i2 < this.gwY.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gwN.setTip(this.gwY[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gwU.setTip(this.gwY[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gwO.setTip(this.gwY[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gwS.setTip(this.gwW.getString(d.k.all_person));
                } else {
                    this.gwS.setTip(this.gwY[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gwY != null) {
            int length = this.gwY.length;
            int bqu = aVar.bqu() - 1;
            if (bqu < length && bqu >= 0) {
                this.gwU.setTip(this.gwY[bqu]);
            }
            int bqt = aVar.bqt() - 1;
            if (bqt < length && bqt >= 0) {
                this.gwN.setTip(this.gwY[bqt]);
            }
            int Ha = aVar.Ha() - 1;
            if (Ha < length && Ha >= 0) {
                this.gwO.setTip(this.gwY[Ha]);
            }
            int bqw = aVar.bqw() - 1;
            if (bqw < length && bqw >= 0) {
                if (bqw == 0) {
                    this.gwS.setTip(this.gwW.getString(d.k.all_person));
                } else {
                    this.gwS.setTip(this.gwY[bqw]);
                }
            }
            md(aVar.bqv());
        }
    }

    public void md(boolean z) {
        if (z) {
            this.gwV.getSwitchView().mA();
        } else {
            this.gwV.getSwitchView().mB();
        }
    }

    public boolean bqG() {
        return this.gwV.getSwitchView().ip();
    }

    public void me(boolean z) {
        if (z) {
            this.gwQ.getSwitchView().mA();
        } else {
            this.gwQ.getSwitchView().mB();
        }
    }
}
