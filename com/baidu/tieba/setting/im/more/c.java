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
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener arL;
    private LinearLayout gcq;
    private TbSettingTextTipView jPX;
    private TbSettingTextTipView jPY;
    private TbSettingTextTipView jPZ;
    private TbSettingTextTipView jQa;
    private View jQb;
    private TbSettingTextTipView jQc;
    private TbSettingTextTipView jQd;
    private SecretSettingActivity jQe;
    private View jQf;
    private String[] jQg;
    private TbSettingTextTipView jQh;
    private a jQi;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes11.dex */
    public interface a {
        void cDr();

        void cDs();

        void cDt();

        void cDu();

        void cDv();

        void cDw();

        void cDx();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.jQi != null) {
                    if (view == c.this.mBack) {
                        c.this.jQi.onBackPressed();
                    } else if (view == c.this.jPX) {
                        c.this.jQi.cDr();
                    } else if (view == c.this.jPY) {
                        c.this.jQi.cDs();
                    } else if (view == c.this.jPZ) {
                        c.this.jQi.cDu();
                    } else if (view == c.this.jQd) {
                        c.this.jQi.cDt();
                    } else if (view == c.this.jQa) {
                        c.this.jQi.cDv();
                    } else if (view == c.this.jQc) {
                        c.this.jQi.cDw();
                    } else if (view == c.this.jQh) {
                        c.this.jQi.cDx();
                    }
                }
            }
        };
        this.jQe = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.jQe.getLayoutMode().setNightMode(i == 1);
        this.jQe.getLayoutMode().onModeChanged(this.gcq);
        this.mNavigationBar.onChangeSkinType(this.jQe.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.gcq = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.jPX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.jPY = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.jQd = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.jPZ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.jQa = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.jQc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.jQb = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.arL);
        this.jPX.setOnClickListener(this.arL);
        this.jQa.setOnClickListener(this.arL);
        this.jQd.setOnClickListener(this.arL);
        this.jPY.setOnClickListener(this.arL);
        this.jPZ.setOnClickListener(this.arL);
        this.jQc.setOnClickListener(this.arL);
        this.jQf = this.jQe.findViewById(R.id.privacy_setting_container);
        this.jQg = this.jQe.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.jQd.setVisibility(0);
        } else {
            this.jQd.setVisibility(8);
        }
        this.jQh = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.jQh.setOnClickListener(this.arL);
    }

    public void a(a aVar) {
        this.jQi = aVar;
    }

    public void cDy() {
        this.jPX.recycle();
    }

    public void si(boolean z) {
        if (z) {
            this.jQf.setVisibility(0);
        } else {
            this.jQf.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.jQb.setVisibility(0);
            this.jQc.setVisibility(0);
            return;
        }
        this.jQb.setVisibility(8);
        this.jQc.setVisibility(8);
    }

    public void bt(String str, int i) {
        int i2 = i - 1;
        if (this.jQg != null && i2 < this.jQg.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.jPY.setTip(this.jQg[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.jQd.setTip(this.jQg[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.jPZ.setTip(this.jQg[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.jQc.setTip(this.jQe.getString(R.string.all_person));
                } else {
                    this.jQc.setTip(this.jQg[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.jQg != null) {
            int length = this.jQg.length;
            int cDm = aVar.cDm() - 1;
            if (cDm < length && cDm >= 0) {
                this.jQd.setTip(this.jQg[cDm]);
            }
            int cDk = aVar.cDk() - 1;
            if (cDk < length && cDk >= 0) {
                this.jPY.setTip(this.jQg[cDk]);
            }
            int cDl = aVar.cDl() - 1;
            if (cDl < length && cDl >= 0) {
                this.jPZ.setTip(this.jQg[cDl]);
            }
            int cDo = aVar.cDo() - 1;
            if (cDo < length && cDo >= 0) {
                if (cDo == 0) {
                    this.jQc.setTip(this.jQe.getString(R.string.all_person));
                } else {
                    this.jQc.setTip(this.jQg[cDo]);
                }
            }
        }
    }
}
