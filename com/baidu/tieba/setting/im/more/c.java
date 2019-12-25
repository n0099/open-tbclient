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
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aqZ;
    private LinearLayout fZh;
    private TbSettingTextTipView jMA;
    private SecretSettingActivity jMB;
    private View jMC;
    private String[] jMD;
    private TbSettingTextTipView jME;
    private a jMF;
    private TbSettingTextTipView jMu;
    private TbSettingTextTipView jMv;
    private TbSettingTextTipView jMw;
    private TbSettingTextTipView jMx;
    private View jMy;
    private TbSettingTextTipView jMz;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes10.dex */
    public interface a {
        void cCn();

        void cCo();

        void cCp();

        void cCq();

        void cCr();

        void cCs();

        void cCt();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.jMF != null) {
                    if (view == c.this.mBack) {
                        c.this.jMF.onBackPressed();
                    } else if (view == c.this.jMu) {
                        c.this.jMF.cCn();
                    } else if (view == c.this.jMv) {
                        c.this.jMF.cCo();
                    } else if (view == c.this.jMw) {
                        c.this.jMF.cCq();
                    } else if (view == c.this.jMA) {
                        c.this.jMF.cCp();
                    } else if (view == c.this.jMx) {
                        c.this.jMF.cCr();
                    } else if (view == c.this.jMz) {
                        c.this.jMF.cCs();
                    } else if (view == c.this.jME) {
                        c.this.jMF.cCt();
                    }
                }
            }
        };
        this.jMB = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.jMB.getLayoutMode().setNightMode(i == 1);
        this.jMB.getLayoutMode().onModeChanged(this.fZh);
        this.mNavigationBar.onChangeSkinType(this.jMB.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fZh = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.jMu = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.jMv = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.jMA = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.jMw = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.jMx = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.jMz = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.jMy = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aqZ);
        this.jMu.setOnClickListener(this.aqZ);
        this.jMx.setOnClickListener(this.aqZ);
        this.jMA.setOnClickListener(this.aqZ);
        this.jMv.setOnClickListener(this.aqZ);
        this.jMw.setOnClickListener(this.aqZ);
        this.jMz.setOnClickListener(this.aqZ);
        this.jMC = this.jMB.findViewById(R.id.privacy_setting_container);
        this.jMD = this.jMB.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.jMA.setVisibility(0);
        } else {
            this.jMA.setVisibility(8);
        }
        this.jME = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.jME.setOnClickListener(this.aqZ);
    }

    public void a(a aVar) {
        this.jMF = aVar;
    }

    public void cCu() {
        this.jMu.recycle();
    }

    public void rW(boolean z) {
        if (z) {
            this.jMC.setVisibility(0);
        } else {
            this.jMC.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.jMy.setVisibility(0);
            this.jMz.setVisibility(0);
            return;
        }
        this.jMy.setVisibility(8);
        this.jMz.setVisibility(8);
    }

    public void bs(String str, int i) {
        int i2 = i - 1;
        if (this.jMD != null && i2 < this.jMD.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.jMv.setTip(this.jMD[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.jMA.setTip(this.jMD[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.jMw.setTip(this.jMD[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.jMz.setTip(this.jMB.getString(R.string.all_person));
                } else {
                    this.jMz.setTip(this.jMD[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.jMD != null) {
            int length = this.jMD.length;
            int cCi = aVar.cCi() - 1;
            if (cCi < length && cCi >= 0) {
                this.jMA.setTip(this.jMD[cCi]);
            }
            int cCg = aVar.cCg() - 1;
            if (cCg < length && cCg >= 0) {
                this.jMv.setTip(this.jMD[cCg]);
            }
            int cCh = aVar.cCh() - 1;
            if (cCh < length && cCh >= 0) {
                this.jMw.setTip(this.jMD[cCh]);
            }
            int cCk = aVar.cCk() - 1;
            if (cCk < length && cCk >= 0) {
                if (cCk == 0) {
                    this.jMz.setTip(this.jMB.getString(R.string.all_person));
                } else {
                    this.jMz.setTip(this.jMD[cCk]);
                }
            }
        }
    }
}
