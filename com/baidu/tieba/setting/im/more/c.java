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
    private View.OnClickListener aBk;
    private LinearLayout hIM;
    private TbSettingTextTipView lNO;
    private TbSettingTextTipView lNP;
    private TbSettingTextTipView lNQ;
    private TbSettingTextTipView lNR;
    private View lNS;
    private TbSettingTextTipView lNT;
    private TbSettingTextTipView lNU;
    private SecretSettingActivity lNV;
    private View lNW;
    private String[] lNX;
    private TbSettingTextTipView lNY;
    private a lNZ;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes20.dex */
    public interface a {
        void dpW();

        void dpX();

        void dpY();

        void dpZ();

        void dqa();

        void dqb();

        void dqc();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.lNZ != null) {
                    if (view == c.this.mBack) {
                        c.this.lNZ.onBackPressed();
                    } else if (view == c.this.lNO) {
                        c.this.lNZ.dpW();
                    } else if (view == c.this.lNP) {
                        c.this.lNZ.dpX();
                    } else if (view == c.this.lNQ) {
                        c.this.lNZ.dpZ();
                    } else if (view == c.this.lNU) {
                        c.this.lNZ.dpY();
                    } else if (view == c.this.lNR) {
                        c.this.lNZ.dqa();
                    } else if (view == c.this.lNT) {
                        c.this.lNZ.dqb();
                    } else if (view == c.this.lNY) {
                        c.this.lNZ.dqc();
                    }
                }
            }
        };
        this.lNV = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.lNV.getLayoutMode().setNightMode(i == 1);
        this.lNV.getLayoutMode().onModeChanged(this.hIM);
        this.mNavigationBar.onChangeSkinType(this.lNV.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.hIM = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.lNO = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.lNP = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.lNU = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.lNQ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.lNR = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.lNT = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.lNS = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aBk);
        this.lNO.setOnClickListener(this.aBk);
        this.lNR.setOnClickListener(this.aBk);
        this.lNU.setOnClickListener(this.aBk);
        this.lNP.setOnClickListener(this.aBk);
        this.lNQ.setOnClickListener(this.aBk);
        this.lNT.setOnClickListener(this.aBk);
        this.lNW = this.lNV.findViewById(R.id.privacy_setting_container);
        this.lNX = this.lNV.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.lNU.setVisibility(0);
        } else {
            this.lNU.setVisibility(8);
        }
        this.lNY = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.lNY.setOnClickListener(this.aBk);
    }

    public void a(a aVar) {
        this.lNZ = aVar;
    }

    public void dqd() {
        this.lNO.recycle();
    }

    public void vy(boolean z) {
        if (z) {
            this.lNW.setVisibility(0);
        } else {
            this.lNW.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.lNS.setVisibility(0);
            this.lNT.setVisibility(0);
            return;
        }
        this.lNS.setVisibility(8);
        this.lNT.setVisibility(8);
    }

    public void bF(String str, int i) {
        int i2 = i - 1;
        if (this.lNX != null && i2 < this.lNX.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.lNP.setTip(this.lNX[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.lNU.setTip(this.lNX[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.lNQ.setTip(this.lNX[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.lNT.setTip(this.lNV.getString(R.string.all_person));
                } else {
                    this.lNT.setTip(this.lNX[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.lNX != null) {
            int length = this.lNX.length;
            int dpR = aVar.dpR() - 1;
            if (dpR < length && dpR >= 0) {
                this.lNU.setTip(this.lNX[dpR]);
            }
            int dpP = aVar.dpP() - 1;
            if (dpP < length && dpP >= 0) {
                this.lNP.setTip(this.lNX[dpP]);
            }
            int dpQ = aVar.dpQ() - 1;
            if (dpQ < length && dpQ >= 0) {
                this.lNQ.setTip(this.lNX[dpQ]);
            }
            int dpT = aVar.dpT() - 1;
            if (dpT < length && dpT >= 0) {
                if (dpT == 0) {
                    this.lNT.setTip(this.lNV.getString(R.string.all_person));
                } else {
                    this.lNT.setTip(this.lNX[dpT]);
                }
            }
        }
    }
}
