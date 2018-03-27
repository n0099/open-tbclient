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
    private View bgB;
    private View.OnClickListener cxY;
    private LinearLayout dvw;
    private View gLA;
    private TbSettingTextTipView gLB;
    private MsgSettingItemView gLC;
    private SecretSettingActivity gLD;
    private View gLE;
    private String[] gLF;
    private BdSwitchView.a gLG;
    private a gLH;
    private TbSettingTextTipView gLw;
    private TbSettingTextTipView gLx;
    private TbSettingTextTipView gLy;
    private TbSettingTextTipView gLz;
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
        this.cxY = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gLH != null) {
                    if (view == b.this.bgB) {
                        b.this.gLH.onBackPressed();
                    } else if (view == b.this.gLw) {
                        b.this.gLH.bpT();
                    } else if (view == b.this.gLx) {
                        b.this.gLH.bpU();
                    } else if (view == b.this.gLy) {
                        b.this.gLH.bpW();
                    } else if (view == b.this.gLB) {
                        b.this.gLH.bpV();
                    } else if (view == b.this.gLz) {
                        b.this.gLH.bpX();
                    }
                }
            }
        };
        this.gLG = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.b.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == b.this.gLC.getSwitchView() && b.this.gLH != null) {
                    b.this.gLH.a(switchState);
                }
            }
        };
        this.gLD = secretSettingActivity;
        secretSettingActivity.setContentView(d.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gLD.getLayoutMode().aQ(i == 1);
        this.gLD.getLayoutMode().aM(this.dvw);
        this.mNavigationBar.onChangeSkinType(this.gLD.getPageContext(), i);
        this.gLC.d(this.gLD.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dvw = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.j.secretSetting));
        this.gLw = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.gLx = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.gLB = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.gLA = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.gLy = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.gLz = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.bgB.setOnClickListener(this.cxY);
        this.gLw.setOnClickListener(this.cxY);
        this.gLz.setOnClickListener(this.cxY);
        this.gLB.setOnClickListener(this.cxY);
        this.gLx.setOnClickListener(this.cxY);
        this.gLy.setOnClickListener(this.cxY);
        this.gLE = this.gLD.findViewById(d.g.privacy_setting_container);
        this.gLF = this.gLD.getResources().getStringArray(d.b.privacy_setting_config);
        this.gLC = (MsgSettingItemView) this.gLD.findViewById(d.g.sv_shared_location);
        this.gLC.setLineVisibility(false);
        this.gLC.setText(d.j.privacy_setting_shared_location);
        this.gLC.setOnSwitchStateChangeListener(this.gLG);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gLB.setVisibility(0);
            this.gLA.setVisibility(0);
            return;
        }
        this.gLB.setVisibility(8);
        this.gLA.setVisibility(8);
    }

    public void a(a aVar) {
        this.gLH = aVar;
    }

    public void bpY() {
        this.gLw.recycle();
    }

    public void mk(boolean z) {
        if (z) {
            this.gLE.setVisibility(0);
        } else {
            this.gLE.setVisibility(8);
        }
    }

    public void aH(String str, int i) {
        int i2 = i - 1;
        if (this.gLF != null && i2 < this.gLF.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gLx.setTip(this.gLF[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gLB.setTip(this.gLF[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gLy.setTip(this.gLF[i2]);
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gLF != null) {
            int length = this.gLF.length;
            int bpP = aVar.bpP() - 1;
            if (bpP < length && bpP >= 0) {
                this.gLB.setTip(this.gLF[bpP]);
            }
            int bpO = aVar.bpO() - 1;
            if (bpO < length && bpO >= 0) {
                this.gLx.setTip(this.gLF[bpO]);
            }
            int KB = aVar.KB() - 1;
            if (KB < length && KB >= 0) {
                this.gLy.setTip(this.gLF[KB]);
            }
            ml(aVar.bpQ());
        }
    }

    public void ml(boolean z) {
        if (z) {
            this.gLC.getSwitchView().rH();
        } else {
            this.gLC.getSwitchView().rI();
        }
    }

    public boolean bpZ() {
        return this.gLC.getSwitchView().nv();
    }
}
