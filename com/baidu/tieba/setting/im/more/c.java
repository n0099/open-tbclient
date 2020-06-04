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
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aUZ;
    private LinearLayout hdA;
    private TbSettingTextTipView kVk;
    private TbSettingTextTipView kVl;
    private TbSettingTextTipView kVm;
    private TbSettingTextTipView kVn;
    private View kVo;
    private TbSettingTextTipView kVp;
    private TbSettingTextTipView kVq;
    private SecretSettingActivity kVr;
    private View kVs;
    private String[] kVt;
    private TbSettingTextTipView kVu;
    private a kVv;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cXg();

        void cXh();

        void cXi();

        void cXj();

        void cXk();

        void cXl();

        void cXm();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.kVv != null) {
                    if (view == c.this.mBack) {
                        c.this.kVv.onBackPressed();
                    } else if (view == c.this.kVk) {
                        c.this.kVv.cXg();
                    } else if (view == c.this.kVl) {
                        c.this.kVv.cXh();
                    } else if (view == c.this.kVm) {
                        c.this.kVv.cXj();
                    } else if (view == c.this.kVq) {
                        c.this.kVv.cXi();
                    } else if (view == c.this.kVn) {
                        c.this.kVv.cXk();
                    } else if (view == c.this.kVp) {
                        c.this.kVv.cXl();
                    } else if (view == c.this.kVu) {
                        c.this.kVv.cXm();
                    }
                }
            }
        };
        this.kVr = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.kVr.getLayoutMode().setNightMode(i == 1);
        this.kVr.getLayoutMode().onModeChanged(this.hdA);
        this.mNavigationBar.onChangeSkinType(this.kVr.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.hdA = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.kVk = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.kVl = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.kVq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.kVm = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.kVn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.kVp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.kVo = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aUZ);
        this.kVk.setOnClickListener(this.aUZ);
        this.kVn.setOnClickListener(this.aUZ);
        this.kVq.setOnClickListener(this.aUZ);
        this.kVl.setOnClickListener(this.aUZ);
        this.kVm.setOnClickListener(this.aUZ);
        this.kVp.setOnClickListener(this.aUZ);
        this.kVs = this.kVr.findViewById(R.id.privacy_setting_container);
        this.kVt = this.kVr.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.kVq.setVisibility(0);
        } else {
            this.kVq.setVisibility(8);
        }
        this.kVu = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.kVu.setOnClickListener(this.aUZ);
    }

    public void a(a aVar) {
        this.kVv = aVar;
    }

    public void cXn() {
        this.kVk.recycle();
    }

    public void tQ(boolean z) {
        if (z) {
            this.kVs.setVisibility(0);
        } else {
            this.kVs.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.kVo.setVisibility(0);
            this.kVp.setVisibility(0);
            return;
        }
        this.kVo.setVisibility(8);
        this.kVp.setVisibility(8);
    }

    public void bD(String str, int i) {
        int i2 = i - 1;
        if (this.kVt != null && i2 < this.kVt.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.kVl.setTip(this.kVt[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.kVq.setTip(this.kVt[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.kVm.setTip(this.kVt[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.kVp.setTip(this.kVr.getString(R.string.all_person));
                } else {
                    this.kVp.setTip(this.kVt[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.kVt != null) {
            int length = this.kVt.length;
            int cXb = aVar.cXb() - 1;
            if (cXb < length && cXb >= 0) {
                this.kVq.setTip(this.kVt[cXb]);
            }
            int cWZ = aVar.cWZ() - 1;
            if (cWZ < length && cWZ >= 0) {
                this.kVl.setTip(this.kVt[cWZ]);
            }
            int cXa = aVar.cXa() - 1;
            if (cXa < length && cXa >= 0) {
                this.kVm.setTip(this.kVt[cXa]);
            }
            int cXd = aVar.cXd() - 1;
            if (cXd < length && cXd >= 0) {
                if (cXd == 0) {
                    this.kVp.setTip(this.kVr.getString(R.string.all_person));
                } else {
                    this.kVp.setTip(this.kVt[cXd]);
                }
            }
        }
    }
}
