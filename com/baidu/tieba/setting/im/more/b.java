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
    private View bgK;
    private View.OnClickListener cyh;
    private LinearLayout dvF;
    private TbSettingTextTipView gLA;
    private MsgSettingItemView gLB;
    private SecretSettingActivity gLC;
    private View gLD;
    private String[] gLE;
    private BdSwitchView.a gLF;
    private a gLG;
    private TbSettingTextTipView gLv;
    private TbSettingTextTipView gLw;
    private TbSettingTextTipView gLx;
    private TbSettingTextTipView gLy;
    private View gLz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void bpT();

        void bpU();

        void bpV();

        void bpW();

        void bpX();

        void onBackPressed();
    }

    public b(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gLG != null) {
                    if (view == b.this.bgK) {
                        b.this.gLG.onBackPressed();
                    } else if (view == b.this.gLv) {
                        b.this.gLG.bpT();
                    } else if (view == b.this.gLw) {
                        b.this.gLG.bpU();
                    } else if (view == b.this.gLx) {
                        b.this.gLG.bpW();
                    } else if (view == b.this.gLA) {
                        b.this.gLG.bpV();
                    } else if (view == b.this.gLy) {
                        b.this.gLG.bpX();
                    }
                }
            }
        };
        this.gLF = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.b.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == b.this.gLB.getSwitchView() && b.this.gLG != null) {
                    b.this.gLG.a(switchState);
                }
            }
        };
        this.gLC = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gLC.getLayoutMode().aQ(i == 1);
        this.gLC.getLayoutMode().aM(this.dvF);
        this.mNavigationBar.onChangeSkinType(this.gLC.getPageContext(), i);
        this.gLB.d(this.gLC.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dvF = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.gLv = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.gLw = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.gLA = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.gLz = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.gLx = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.gLy = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.bgK.setOnClickListener(this.cyh);
        this.gLv.setOnClickListener(this.cyh);
        this.gLy.setOnClickListener(this.cyh);
        this.gLA.setOnClickListener(this.cyh);
        this.gLw.setOnClickListener(this.cyh);
        this.gLx.setOnClickListener(this.cyh);
        this.gLD = this.gLC.findViewById(d.g.privacy_setting_container);
        this.gLE = this.gLC.getResources().getStringArray(d.b.privacy_setting_config);
        this.gLB = (MsgSettingItemView) this.gLC.findViewById(d.g.sv_shared_location);
        this.gLB.setLineVisibility(false);
        this.gLB.setText(d.j.privacy_setting_shared_location);
        this.gLB.setOnSwitchStateChangeListener(this.gLF);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gLA.setVisibility(0);
            this.gLz.setVisibility(0);
            return;
        }
        this.gLA.setVisibility(8);
        this.gLz.setVisibility(8);
    }

    public void a(a aVar) {
        this.gLG = aVar;
    }

    public void bpY() {
        this.gLv.recycle();
    }

    public void mf(boolean z) {
        if (z) {
            this.gLD.setVisibility(0);
        } else {
            this.gLD.setVisibility(8);
        }
    }

    public void aH(String str, int i) {
        int i2 = i - 1;
        if (this.gLE != null && i2 < this.gLE.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gLw.setTip(this.gLE[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gLA.setTip(this.gLE[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gLx.setTip(this.gLE[i2]);
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gLE != null) {
            int length = this.gLE.length;
            int bpP = aVar.bpP() - 1;
            if (bpP < length && bpP >= 0) {
                this.gLA.setTip(this.gLE[bpP]);
            }
            int bpO = aVar.bpO() - 1;
            if (bpO < length && bpO >= 0) {
                this.gLw.setTip(this.gLE[bpO]);
            }
            int KB = aVar.KB() - 1;
            if (KB < length && KB >= 0) {
                this.gLx.setTip(this.gLE[KB]);
            }
            mg(aVar.bpQ());
        }
    }

    public void mg(boolean z) {
        if (z) {
            this.gLB.getSwitchView().rH();
        } else {
            this.gLB.getSwitchView().rI();
        }
    }

    public boolean bpZ() {
        return this.gLB.getSwitchView().nv();
    }
}
