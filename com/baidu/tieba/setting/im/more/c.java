package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View aMW;
    private View.OnClickListener cts;
    private LinearLayout dxC;
    private TbSettingTextTipView gXU;
    private TbSettingTextTipView gXV;
    private TbSettingTextTipView gXW;
    private TbSettingTextTipView gXX;
    private View gXY;
    private TbSettingTextTipView gXZ;
    private View gYa;
    private TbSettingTextTipView gYb;
    private SecretSettingActivity gYc;
    private View gYd;
    private String[] gYe;
    private TbSettingTextTipView gYf;
    private a gYg;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void bxb();

        void bxc();

        void bxd();

        void bxe();

        void bxf();

        void bxg();

        void bxh();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gYg != null) {
                    if (view == c.this.aMW) {
                        c.this.gYg.onBackPressed();
                    } else if (view == c.this.gXU) {
                        c.this.gYg.bxb();
                    } else if (view == c.this.gXV) {
                        c.this.gYg.bxc();
                    } else if (view == c.this.gXW) {
                        c.this.gYg.bxe();
                    } else if (view == c.this.gYb) {
                        c.this.gYg.bxd();
                    } else if (view == c.this.gXX) {
                        c.this.gYg.bxf();
                    } else if (view == c.this.gXZ) {
                        c.this.gYg.bxg();
                    } else if (view == c.this.gYf) {
                        c.this.gYg.bxh();
                    }
                }
            }
        };
        this.gYc = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.gYc.getLayoutMode().setNightMode(i == 1);
        this.gYc.getLayoutMode().onModeChanged(this.dxC);
        this.mNavigationBar.onChangeSkinType(this.gYc.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dxC = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gXU = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gXV = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gYb = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gYa = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gXW = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gXX = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gXZ = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gXY = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.aMW.setOnClickListener(this.cts);
        this.gXU.setOnClickListener(this.cts);
        this.gXX.setOnClickListener(this.cts);
        this.gYb.setOnClickListener(this.cts);
        this.gXV.setOnClickListener(this.cts);
        this.gXW.setOnClickListener(this.cts);
        this.gXZ.setOnClickListener(this.cts);
        this.gYd = this.gYc.findViewById(e.g.privacy_setting_container);
        this.gYe = this.gYc.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gYb.setVisibility(0);
            this.gYa.setVisibility(0);
        } else {
            this.gYb.setVisibility(8);
            this.gYa.setVisibility(8);
        }
        this.gYf = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gYf.setOnClickListener(this.cts);
    }

    public void a(a aVar) {
        this.gYg = aVar;
    }

    public void bxi() {
        this.gXU.recycle();
    }

    public void mV(boolean z) {
        if (z) {
            this.gYd.setVisibility(0);
        } else {
            this.gYd.setVisibility(8);
        }
        if (d.iQ().aO("reply_private_setting_switch") == 1) {
            this.gXY.setVisibility(0);
            this.gXZ.setVisibility(0);
            return;
        }
        this.gXY.setVisibility(8);
        this.gXZ.setVisibility(8);
    }

    public void aT(String str, int i) {
        int i2 = i - 1;
        if (this.gYe != null && i2 < this.gYe.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gXV.setTip(this.gYe[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gYb.setTip(this.gYe[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gXW.setTip(this.gYe[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gXZ.setTip(this.gYc.getString(e.j.all_person));
                } else {
                    this.gXZ.setTip(this.gYe[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gYe != null) {
            int length = this.gYe.length;
            int bwW = aVar.bwW() - 1;
            if (bwW < length && bwW >= 0) {
                this.gYb.setTip(this.gYe[bwW]);
            }
            int bwV = aVar.bwV() - 1;
            if (bwV < length && bwV >= 0) {
                this.gXV.setTip(this.gYe[bwV]);
            }
            int LC = aVar.LC() - 1;
            if (LC < length && LC >= 0) {
                this.gXW.setTip(this.gYe[LC]);
            }
            int bwY = aVar.bwY() - 1;
            if (bwY < length && bwY >= 0) {
                if (bwY == 0) {
                    this.gXZ.setTip(this.gYc.getString(e.j.all_person));
                } else {
                    this.gXZ.setTip(this.gYe[bwY]);
                }
            }
        }
    }
}
