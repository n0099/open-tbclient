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
    private View.OnClickListener aOK;
    private LinearLayout gOx;
    private TbSettingTextTipView kBV;
    private TbSettingTextTipView kBW;
    private TbSettingTextTipView kBX;
    private TbSettingTextTipView kBY;
    private View kBZ;
    private TbSettingTextTipView kCa;
    private TbSettingTextTipView kCb;
    private SecretSettingActivity kCc;
    private View kCd;
    private String[] kCe;
    private TbSettingTextTipView kCf;
    private a kCg;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cPP();

        void cPQ();

        void cPR();

        void cPS();

        void cPT();

        void cPU();

        void cPV();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.kCg != null) {
                    if (view == c.this.mBack) {
                        c.this.kCg.onBackPressed();
                    } else if (view == c.this.kBV) {
                        c.this.kCg.cPP();
                    } else if (view == c.this.kBW) {
                        c.this.kCg.cPQ();
                    } else if (view == c.this.kBX) {
                        c.this.kCg.cPS();
                    } else if (view == c.this.kCb) {
                        c.this.kCg.cPR();
                    } else if (view == c.this.kBY) {
                        c.this.kCg.cPT();
                    } else if (view == c.this.kCa) {
                        c.this.kCg.cPU();
                    } else if (view == c.this.kCf) {
                        c.this.kCg.cPV();
                    }
                }
            }
        };
        this.kCc = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.kCc.getLayoutMode().setNightMode(i == 1);
        this.kCc.getLayoutMode().onModeChanged(this.gOx);
        this.mNavigationBar.onChangeSkinType(this.kCc.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.gOx = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.kBV = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.kBW = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.kCb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.kBX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.kBY = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.kCa = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.kBZ = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aOK);
        this.kBV.setOnClickListener(this.aOK);
        this.kBY.setOnClickListener(this.aOK);
        this.kCb.setOnClickListener(this.aOK);
        this.kBW.setOnClickListener(this.aOK);
        this.kBX.setOnClickListener(this.aOK);
        this.kCa.setOnClickListener(this.aOK);
        this.kCd = this.kCc.findViewById(R.id.privacy_setting_container);
        this.kCe = this.kCc.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.kCb.setVisibility(0);
        } else {
            this.kCb.setVisibility(8);
        }
        this.kCf = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.kCf.setOnClickListener(this.aOK);
    }

    public void a(a aVar) {
        this.kCg = aVar;
    }

    public void cPW() {
        this.kBV.recycle();
    }

    public void ts(boolean z) {
        if (z) {
            this.kCd.setVisibility(0);
        } else {
            this.kCd.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.kBZ.setVisibility(0);
            this.kCa.setVisibility(0);
            return;
        }
        this.kBZ.setVisibility(8);
        this.kCa.setVisibility(8);
    }

    public void bC(String str, int i) {
        int i2 = i - 1;
        if (this.kCe != null && i2 < this.kCe.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.kBW.setTip(this.kCe[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.kCb.setTip(this.kCe[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.kBX.setTip(this.kCe[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.kCa.setTip(this.kCc.getString(R.string.all_person));
                } else {
                    this.kCa.setTip(this.kCe[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.kCe != null) {
            int length = this.kCe.length;
            int cPK = aVar.cPK() - 1;
            if (cPK < length && cPK >= 0) {
                this.kCb.setTip(this.kCe[cPK]);
            }
            int cPI = aVar.cPI() - 1;
            if (cPI < length && cPI >= 0) {
                this.kBW.setTip(this.kCe[cPI]);
            }
            int cPJ = aVar.cPJ() - 1;
            if (cPJ < length && cPJ >= 0) {
                this.kBX.setTip(this.kCe[cPJ]);
            }
            int cPM = aVar.cPM() - 1;
            if (cPM < length && cPM >= 0) {
                if (cPM == 0) {
                    this.kCa.setTip(this.kCc.getString(R.string.all_person));
                } else {
                    this.kCa.setTip(this.kCe[cPM]);
                }
            }
        }
    }
}
