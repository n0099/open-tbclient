package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aBm;
    private LinearLayout hIS;
    private TbSettingTextTipView lOb;
    private TbSettingTextTipView lOc;
    private TbSettingTextTipView lOd;
    private TbSettingTextTipView lOe;
    private View lOf;
    private TbSettingTextTipView lOg;
    private TbSettingTextTipView lOh;
    private SecretSettingActivity lOi;
    private View lOj;
    private String[] lOk;
    private TbSettingTextTipView lOl;
    private a lOm;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes20.dex */
    public interface a {
        void dpZ();

        void dqa();

        void dqb();

        void dqc();

        void dqd();

        void dqe();

        void dqf();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.lOm != null) {
                    if (view == c.this.mBack) {
                        c.this.lOm.onBackPressed();
                    } else if (view == c.this.lOb) {
                        c.this.lOm.dpZ();
                    } else if (view == c.this.lOc) {
                        c.this.lOm.dqa();
                    } else if (view == c.this.lOd) {
                        c.this.lOm.dqc();
                    } else if (view == c.this.lOh) {
                        c.this.lOm.dqb();
                    } else if (view == c.this.lOe) {
                        c.this.lOm.dqd();
                    } else if (view == c.this.lOg) {
                        c.this.lOm.dqe();
                    } else if (view == c.this.lOl) {
                        c.this.lOm.dqf();
                    }
                }
            }
        };
        this.lOi = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.lOi.getLayoutMode().setNightMode(i == 1);
        this.lOi.getLayoutMode().onModeChanged(this.hIS);
        this.mNavigationBar.onChangeSkinType(this.lOi.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.hIS = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.lOb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.lOc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.lOh = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.lOd = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.lOe = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.lOg = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.lOf = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aBm);
        this.lOb.setOnClickListener(this.aBm);
        this.lOe.setOnClickListener(this.aBm);
        this.lOh.setOnClickListener(this.aBm);
        this.lOc.setOnClickListener(this.aBm);
        this.lOd.setOnClickListener(this.aBm);
        this.lOg.setOnClickListener(this.aBm);
        this.lOj = this.lOi.findViewById(R.id.privacy_setting_container);
        this.lOk = this.lOi.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.lOh.setVisibility(0);
        } else {
            this.lOh.setVisibility(8);
        }
        this.lOl = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.lOl.setOnClickListener(this.aBm);
    }

    public void a(a aVar) {
        this.lOm = aVar;
    }

    public void dqg() {
        this.lOb.recycle();
    }

    public void vA(boolean z) {
        if (z) {
            this.lOj.setVisibility(0);
        } else {
            this.lOj.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.lOf.setVisibility(0);
            this.lOg.setVisibility(0);
            return;
        }
        this.lOf.setVisibility(8);
        this.lOg.setVisibility(8);
    }

    public void bF(String str, int i) {
        int i2 = i - 1;
        if (this.lOk != null && i2 < this.lOk.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.lOc.setTip(this.lOk[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.lOh.setTip(this.lOk[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.lOd.setTip(this.lOk[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.lOg.setTip(this.lOi.getString(R.string.all_person));
                } else {
                    this.lOg.setTip(this.lOk[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.lOk != null) {
            int length = this.lOk.length;
            int dpU = aVar.dpU() - 1;
            if (dpU < length && dpU >= 0) {
                this.lOh.setTip(this.lOk[dpU]);
            }
            int dpS = aVar.dpS() - 1;
            if (dpS < length && dpS >= 0) {
                this.lOc.setTip(this.lOk[dpS]);
            }
            int dpT = aVar.dpT() - 1;
            if (dpT < length && dpT >= 0) {
                this.lOd.setTip(this.lOk[dpT]);
            }
            int dpW = aVar.dpW() - 1;
            if (dpW < length && dpW >= 0) {
                if (dpW == 0) {
                    this.lOg.setTip(this.lOi.getString(R.string.all_person));
                } else {
                    this.lOg.setTip(this.lOk[dpW]);
                }
            }
        }
    }
}
