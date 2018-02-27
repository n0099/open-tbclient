package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes3.dex */
public class b extends c<SecretSettingActivity> {
    private View bgy;
    private View.OnClickListener cxV;
    private LinearLayout dvt;
    private TbSettingTextTipView gLg;
    private TbSettingTextTipView gLh;
    private TbSettingTextTipView gLi;
    private TbSettingTextTipView gLj;
    private View gLk;
    private TbSettingTextTipView gLl;
    private MsgSettingItemView gLm;
    private SecretSettingActivity gLn;
    private View gLo;
    private String[] gLp;
    private BdSwitchView.a gLq;
    private a gLr;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void bpS();

        void bpT();

        void bpU();

        void bpV();

        void bpW();

        void onBackPressed();
    }

    public b(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gLr != null) {
                    if (view == b.this.bgy) {
                        b.this.gLr.onBackPressed();
                    } else if (view == b.this.gLg) {
                        b.this.gLr.bpS();
                    } else if (view == b.this.gLh) {
                        b.this.gLr.bpT();
                    } else if (view == b.this.gLi) {
                        b.this.gLr.bpV();
                    } else if (view == b.this.gLl) {
                        b.this.gLr.bpU();
                    } else if (view == b.this.gLj) {
                        b.this.gLr.bpW();
                    }
                }
            }
        };
        this.gLq = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.b.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == b.this.gLm.getSwitchView() && b.this.gLr != null) {
                    b.this.gLr.a(switchState);
                }
            }
        };
        this.gLn = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gLn.getLayoutMode().aQ(i == 1);
        this.gLn.getLayoutMode().aM(this.dvt);
        this.mNavigationBar.onChangeSkinType(this.gLn.getPageContext(), i);
        this.gLm.d(this.gLn.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dvt = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.gLg = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.gLh = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.gLl = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.gLk = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.gLi = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.gLj = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.bgy.setOnClickListener(this.cxV);
        this.gLg.setOnClickListener(this.cxV);
        this.gLj.setOnClickListener(this.cxV);
        this.gLl.setOnClickListener(this.cxV);
        this.gLh.setOnClickListener(this.cxV);
        this.gLi.setOnClickListener(this.cxV);
        this.gLo = this.gLn.findViewById(d.g.privacy_setting_container);
        this.gLp = this.gLn.getResources().getStringArray(d.b.privacy_setting_config);
        this.gLm = (MsgSettingItemView) this.gLn.findViewById(d.g.sv_shared_location);
        this.gLm.setLineVisibility(false);
        this.gLm.setText(d.j.privacy_setting_shared_location);
        this.gLm.setOnSwitchStateChangeListener(this.gLq);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gLl.setVisibility(0);
            this.gLk.setVisibility(0);
            return;
        }
        this.gLl.setVisibility(8);
        this.gLk.setVisibility(8);
    }

    public void a(a aVar) {
        this.gLr = aVar;
    }

    public void bpX() {
        this.gLg.recycle();
    }

    public void mf(boolean z) {
        if (z) {
            this.gLo.setVisibility(0);
        } else {
            this.gLo.setVisibility(8);
        }
    }

    public void aH(String str, int i) {
        int i2 = i - 1;
        if (this.gLp != null && i2 < this.gLp.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gLh.setTip(this.gLp[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gLl.setTip(this.gLp[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gLi.setTip(this.gLp[i2]);
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gLp != null) {
            int length = this.gLp.length;
            int bpO = aVar.bpO() - 1;
            if (bpO < length && bpO >= 0) {
                this.gLl.setTip(this.gLp[bpO]);
            }
            int bpN = aVar.bpN() - 1;
            if (bpN < length && bpN >= 0) {
                this.gLh.setTip(this.gLp[bpN]);
            }
            int KA = aVar.KA() - 1;
            if (KA < length && KA >= 0) {
                this.gLi.setTip(this.gLp[KA]);
            }
            mg(aVar.bpP());
        }
    }

    public void mg(boolean z) {
        if (z) {
            this.gLm.getSwitchView().rH();
        } else {
            this.gLm.getSwitchView().rI();
        }
    }

    public boolean bpY() {
        return this.gLm.getSwitchView().nv();
    }
}
