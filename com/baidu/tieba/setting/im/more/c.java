package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View asg;
    private View.OnClickListener bOY;
    private LinearLayout cPo;
    private TbSettingTextTipView ghB;
    private TbSettingTextTipView ghC;
    private TbSettingTextTipView ghD;
    private TbSettingTextTipView ghE;
    private View ghF;
    private TbSettingTextTipView ghG;
    private View ghH;
    private TbSettingTextTipView ghI;
    private MsgSettingItemView ghJ;
    private SecretSettingActivity ghK;
    private View ghL;
    private String[] ghM;
    private BdSwitchView.a ghN;
    private a ghO;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void bla();

        void blb();

        void blc();

        void bld();

        void ble();

        void blf();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.bOY = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ghO != null) {
                    if (view2 == c.this.asg) {
                        c.this.ghO.onBackPressed();
                    } else if (view2 == c.this.ghB) {
                        c.this.ghO.bla();
                    } else if (view2 == c.this.ghC) {
                        c.this.ghO.blb();
                    } else if (view2 == c.this.ghD) {
                        c.this.ghO.bld();
                    } else if (view2 == c.this.ghI) {
                        c.this.ghO.blc();
                    } else if (view2 == c.this.ghE) {
                        c.this.ghO.ble();
                    } else if (view2 == c.this.ghG) {
                        c.this.ghO.blf();
                    }
                }
            }
        };
        this.ghN = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view2, BdSwitchView.SwitchState switchState) {
                if (view2 == c.this.ghJ.getSwitchView() && c.this.ghO != null) {
                    c.this.ghO.a(switchState);
                }
            }
        };
        this.ghK = secretSettingActivity;
        secretSettingActivity.setContentView(d.i.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ghK.getLayoutMode().setNightMode(i == 1);
        this.ghK.getLayoutMode().u(this.cPo);
        this.mNavigationBar.onChangeSkinType(this.ghK.getPageContext(), i);
        this.ghJ.d(this.ghK.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.cPo = (LinearLayout) secretSettingActivity.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(d.k.secretSetting));
        this.ghB = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.black_address_list);
        this.ghC = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_bar);
        this.ghI = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_group);
        this.ghH = secretSettingActivity.findViewById(d.g.divide_line_under_privacy_attention_group);
        this.ghD = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.privacy_attention_live);
        this.ghE = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.user_mute_list);
        this.ghG = (TbSettingTextTipView) secretSettingActivity.findViewById(d.g.thread_reply_setting);
        this.ghF = secretSettingActivity.findViewById(d.g.container_thread_reply_setting);
        this.asg.setOnClickListener(this.bOY);
        this.ghB.setOnClickListener(this.bOY);
        this.ghE.setOnClickListener(this.bOY);
        this.ghI.setOnClickListener(this.bOY);
        this.ghC.setOnClickListener(this.bOY);
        this.ghD.setOnClickListener(this.bOY);
        this.ghG.setOnClickListener(this.bOY);
        this.ghL = this.ghK.findViewById(d.g.privacy_setting_container);
        this.ghM = this.ghK.getResources().getStringArray(d.b.privacy_setting_config);
        this.ghJ = (MsgSettingItemView) this.ghK.findViewById(d.g.sv_shared_location);
        this.ghJ.setLineVisibility(false);
        this.ghJ.setText(d.k.privacy_setting_shared_location);
        this.ghJ.setOnSwitchStateChangeListener(this.ghN);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.ghI.setVisibility(0);
            this.ghH.setVisibility(0);
            return;
        }
        this.ghI.setVisibility(8);
        this.ghH.setVisibility(8);
    }

    public void a(a aVar) {
        this.ghO = aVar;
    }

    public void blg() {
        this.ghB.recycle();
    }

    public void lM(boolean z) {
        if (z) {
            this.ghL.setVisibility(0);
        } else {
            this.ghL.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.d.eE().ak("reply_private_setting_switch") == 1) {
            this.ghF.setVisibility(0);
            this.ghG.setVisibility(0);
            return;
        }
        this.ghF.setVisibility(8);
        this.ghG.setVisibility(8);
    }

    public void aI(String str, int i) {
        int i2 = i - 1;
        if (this.ghM != null && i2 < this.ghM.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.ghC.setTip(this.ghM[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.ghI.setTip(this.ghM[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.ghD.setTip(this.ghM[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.ghG.setTip(this.ghK.getString(d.k.all_person));
                } else {
                    this.ghG.setTip(this.ghM[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.ghM != null) {
            int length = this.ghM.length;
            int bkV = aVar.bkV() - 1;
            if (bkV < length && bkV >= 0) {
                this.ghI.setTip(this.ghM[bkV]);
            }
            int bkU = aVar.bkU() - 1;
            if (bkU < length && bkU >= 0) {
                this.ghC.setTip(this.ghM[bkU]);
            }
            int Df = aVar.Df() - 1;
            if (Df < length && Df >= 0) {
                this.ghD.setTip(this.ghM[Df]);
            }
            int bkX = aVar.bkX() - 1;
            if (bkX < length && bkX >= 0) {
                if (bkX == 0) {
                    this.ghG.setTip(this.ghK.getString(d.k.all_person));
                } else {
                    this.ghG.setTip(this.ghM[bkX]);
                }
            }
            lN(aVar.bkW());
        }
    }

    public void lN(boolean z) {
        if (z) {
            this.ghJ.getSwitchView().jM();
        } else {
            this.ghJ.getSwitchView().jN();
        }
    }

    public boolean blh() {
        return this.ghJ.getSwitchView().fz();
    }
}
