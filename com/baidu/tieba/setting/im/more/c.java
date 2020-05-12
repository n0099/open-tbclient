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
    private View.OnClickListener aOQ;
    private LinearLayout gOD;
    private TbSettingTextTipView kBZ;
    private TbSettingTextTipView kCa;
    private TbSettingTextTipView kCb;
    private TbSettingTextTipView kCc;
    private View kCd;
    private TbSettingTextTipView kCe;
    private TbSettingTextTipView kCf;
    private SecretSettingActivity kCg;
    private View kCh;
    private String[] kCi;
    private TbSettingTextTipView kCj;
    private a kCk;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cPN();

        void cPO();

        void cPP();

        void cPQ();

        void cPR();

        void cPS();

        void cPT();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.kCk != null) {
                    if (view == c.this.mBack) {
                        c.this.kCk.onBackPressed();
                    } else if (view == c.this.kBZ) {
                        c.this.kCk.cPN();
                    } else if (view == c.this.kCa) {
                        c.this.kCk.cPO();
                    } else if (view == c.this.kCb) {
                        c.this.kCk.cPQ();
                    } else if (view == c.this.kCf) {
                        c.this.kCk.cPP();
                    } else if (view == c.this.kCc) {
                        c.this.kCk.cPR();
                    } else if (view == c.this.kCe) {
                        c.this.kCk.cPS();
                    } else if (view == c.this.kCj) {
                        c.this.kCk.cPT();
                    }
                }
            }
        };
        this.kCg = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.kCg.getLayoutMode().setNightMode(i == 1);
        this.kCg.getLayoutMode().onModeChanged(this.gOD);
        this.mNavigationBar.onChangeSkinType(this.kCg.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.gOD = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.kBZ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.kCa = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.kCf = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.kCb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.kCc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.kCe = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.kCd = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aOQ);
        this.kBZ.setOnClickListener(this.aOQ);
        this.kCc.setOnClickListener(this.aOQ);
        this.kCf.setOnClickListener(this.aOQ);
        this.kCa.setOnClickListener(this.aOQ);
        this.kCb.setOnClickListener(this.aOQ);
        this.kCe.setOnClickListener(this.aOQ);
        this.kCh = this.kCg.findViewById(R.id.privacy_setting_container);
        this.kCi = this.kCg.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.kCf.setVisibility(0);
        } else {
            this.kCf.setVisibility(8);
        }
        this.kCj = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.kCj.setOnClickListener(this.aOQ);
    }

    public void a(a aVar) {
        this.kCk = aVar;
    }

    public void cPU() {
        this.kBZ.recycle();
    }

    public void ts(boolean z) {
        if (z) {
            this.kCh.setVisibility(0);
        } else {
            this.kCh.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.kCd.setVisibility(0);
            this.kCe.setVisibility(0);
            return;
        }
        this.kCd.setVisibility(8);
        this.kCe.setVisibility(8);
    }

    public void bC(String str, int i) {
        int i2 = i - 1;
        if (this.kCi != null && i2 < this.kCi.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.kCa.setTip(this.kCi[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.kCf.setTip(this.kCi[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.kCb.setTip(this.kCi[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.kCe.setTip(this.kCg.getString(R.string.all_person));
                } else {
                    this.kCe.setTip(this.kCi[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.kCi != null) {
            int length = this.kCi.length;
            int cPI = aVar.cPI() - 1;
            if (cPI < length && cPI >= 0) {
                this.kCf.setTip(this.kCi[cPI]);
            }
            int cPG = aVar.cPG() - 1;
            if (cPG < length && cPG >= 0) {
                this.kCa.setTip(this.kCi[cPG]);
            }
            int cPH = aVar.cPH() - 1;
            if (cPH < length && cPH >= 0) {
                this.kCb.setTip(this.kCi[cPH]);
            }
            int cPK = aVar.cPK() - 1;
            if (cPK < length && cPK >= 0) {
                if (cPK == 0) {
                    this.kCe.setTip(this.kCg.getString(R.string.all_person));
                } else {
                    this.kCe.setTip(this.kCi[cPK]);
                }
            }
        }
    }
}
