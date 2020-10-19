package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aEX;
    private LinearLayout ieS;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView mmM;
    private TbSettingTextTipView mmN;
    private TbSettingTextTipView mmO;
    private TbSettingTextTipView mmP;
    private TbSettingTextTipView mmQ;
    private View mmR;
    private TbSettingTextTipView mmS;
    private TbSettingTextTipView mmT;
    private SecretSettingActivity mmU;
    private View mmV;
    private String[] mmW;
    private TbSettingTextTipView mmX;
    private a mmY;

    /* loaded from: classes26.dex */
    public interface a {
        void dxA();

        void dxB();

        void dxC();

        void dxD();

        void dxE();

        void dxx();

        void dxy();

        void dxz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mmY != null) {
                    if (view == c.this.mBack) {
                        c.this.mmY.onBackPressed();
                    } else if (view == c.this.mmM) {
                        c.this.mmY.dxx();
                    } else if (view == c.this.mmN) {
                        c.this.mmY.dxy();
                    } else if (view == c.this.mmP) {
                        c.this.mmY.dxA();
                    } else if (view == c.this.mmT) {
                        c.this.mmY.dxz();
                    } else if (view == c.this.mmQ) {
                        c.this.mmY.dxB();
                    } else if (view == c.this.mmS) {
                        c.this.mmY.dxC();
                    } else if (view == c.this.mmX) {
                        c.this.mmY.dxD();
                    } else if (view == c.this.mmO) {
                        c.this.mmY.dxE();
                    }
                }
            }
        };
        this.mmU = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        i(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.mmU.getLayoutMode().setNightMode(i == 1);
        this.mmU.getLayoutMode().onModeChanged(this.ieS);
        this.mNavigationBar.onChangeSkinType(this.mmU.getPageContext(), i);
    }

    private void i(SecretSettingActivity secretSettingActivity) {
        this.ieS = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.mmM = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.mmN = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.mmO = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
        this.mmT = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.mmP = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.mmQ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.mmS = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.mmR = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aEX);
        this.mmM.setOnClickListener(this.aEX);
        this.mmQ.setOnClickListener(this.aEX);
        this.mmT.setOnClickListener(this.aEX);
        this.mmN.setOnClickListener(this.aEX);
        this.mmO.setOnClickListener(this.aEX);
        this.mmP.setOnClickListener(this.aEX);
        this.mmS.setOnClickListener(this.aEX);
        this.mmV = this.mmU.findViewById(R.id.privacy_setting_container);
        this.mmW = this.mmU.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.mmT.setVisibility(0);
        } else {
            this.mmT.setVisibility(8);
        }
        this.mmX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.mmX.setOnClickListener(this.aEX);
        UserData bwG = com.baidu.tbadk.getUserInfo.b.bwE().bwG();
        if (bwG != null && bwG.getBazhuGradeData() != null && !StringUtils.isNull(bwG.getBazhuGradeData().getDesc()) && !StringUtils.isNull(bwG.getBazhuGradeData().getLevel())) {
            this.mmO.setVisibility(0);
        } else {
            this.mmO.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.mmY = aVar;
    }

    public void dxF() {
        this.mmM.recycle();
    }

    public void wp(boolean z) {
        if (z) {
            this.mmV.setVisibility(0);
        } else {
            this.mmV.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.mmR.setVisibility(0);
            this.mmS.setVisibility(0);
            return;
        }
        this.mmR.setVisibility(8);
        this.mmS.setVisibility(8);
    }

    public void bG(String str, int i) {
        int i2 = i - 1;
        if (this.mmW != null && i2 < this.mmW.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.mmN.setTip(this.mmW[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.mmT.setTip(this.mmW[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.mmP.setTip(this.mmW[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.mmS.setTip(this.mmU.getString(R.string.all_person));
                } else {
                    this.mmS.setTip(this.mmW[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                di(com.baidu.tbadk.core.sharedPref.b.blO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), com.baidu.tbadk.core.sharedPref.b.blO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.mmW != null) {
            int length = this.mmW.length;
            int dxs = aVar.dxs() - 1;
            if (dxs < length && dxs >= 0) {
                this.mmT.setTip(this.mmW[dxs]);
            }
            int dxq = aVar.dxq() - 1;
            if (dxq < length && dxq >= 0) {
                this.mmN.setTip(this.mmW[dxq]);
            }
            int dxr = aVar.dxr() - 1;
            if (dxr < length && dxr >= 0) {
                this.mmP.setTip(this.mmW[dxr]);
            }
            int dxu = aVar.dxu() - 1;
            if (dxu < length && dxu >= 0) {
                if (dxu == 0) {
                    this.mmS.setTip(this.mmU.getString(R.string.all_person));
                } else {
                    this.mmS.setTip(this.mmW[dxu]);
                }
            }
            di(aVar.getBazhuShowInside(), aVar.getBazhuShowOutside());
        }
    }

    public void di(int i, int i2) {
        if (i2 == 3 && i == 3) {
            this.mmO.setTip(this.mmU.getString(R.string.mark_tip_no));
        } else if (i2 == 3) {
            this.mmO.setTip(this.mmU.getString(R.string.mark_tip_inside));
        } else if (i == 3) {
            this.mmO.setTip(this.mmU.getString(R.string.mark_tip_outside));
        } else {
            this.mmO.setTip(this.mmU.getString(R.string.mark_tip_all));
        }
    }
}
