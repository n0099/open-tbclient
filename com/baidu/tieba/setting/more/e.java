package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private TbSettingTextTipView isA;
    private SettingTextVersionView isB;
    private TbSettingTextTipView isC;
    private TbSettingTextTipView isD;
    private TbSettingTextNewDotView isE;
    private TextView isF;
    private RelativeLayout isG;
    private View isH;
    private View isI;
    private View isJ;
    private View isK;
    private View isL;
    private View isM;
    private View isN;
    private RelativeLayout isO;
    private BdSwitchView isP;
    private MoreActivity isp;
    private d isq;
    private com.baidu.tbadk.core.dialog.g isr;
    private i iss;
    private SettingTextNormalImageView ist;
    private SettingTextImageView isu;
    private TbSettingTextTipView isv;
    private TbSettingTextTipView isw;
    private TbSettingTextTipView isx;
    private TbSettingTextTipView isy;
    private TbSettingTextTipView isz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.isJ = null;
        this.isK = null;
        this.isL = null;
        this.isM = null;
        this.isN = null;
        this.isO = null;
        this.isP = null;
        this.isp = moreActivity;
        this.isq = dVar;
        this.isp.setContentView(d.h.more_activity);
        akn();
        bZC();
    }

    public void bZA() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.isu.setVisibility(8);
        } else {
            this.isu.setVisibility(0);
        }
    }

    public void at(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.isu != null) {
                this.isu.caB();
                return;
            }
            return;
        }
        this.isu.caC();
        this.isu.setIcon(str, z);
    }

    public void bZB() {
        if (this.isB != null) {
            this.isB.refresh();
        }
        if (this.isE != null) {
            this.isE.refresh();
        }
    }

    public void bZC() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.isP.oa();
        } else {
            this.isP.ob();
        }
    }

    public void yz(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").bJ("obj_type", "1").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").bJ("obj_type", "0").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bYE() {
        this.isu.recycle();
        this.isv.recycle();
        this.isw.recycle();
        this.isx.recycle();
        this.isz.recycle();
        this.isA.recycle();
        this.isB.recycle();
        this.isC.recycle();
        this.isD.recycle();
    }

    public void onChangeSkinType(int i) {
        jf(i);
        if (this.iss != null) {
            this.isp.getLayoutMode().setNightMode(i == 1);
            this.isp.getLayoutMode().onModeChanged(this.iss.abf());
        }
    }

    public void jf(int i) {
        al.l(this.isG, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.isu.jf(i);
        this.isp.getLayoutMode().setNightMode(i == 1);
        this.isp.getLayoutMode().onModeChanged(this.isG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bZB();
        this.isP.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        al.l(this.isH, d.C0277d.cp_bg_line_d);
        this.ist.setLocalIcon(al.ht(d.f.icon_mine_list_baidu));
        if (this.iss != null) {
            this.iss.onChangeSkinType();
        }
    }

    private void akn() {
        View.OnClickListener clickListener = getClickListener();
        this.isG = (RelativeLayout) this.isp.findViewById(d.g.parent);
        this.isH = this.isp.findViewById(d.g.scroll);
        this.isp.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.isp.findViewById(d.g.view_navigation_bar);
        this.isI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.isp.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.ist = (SettingTextNormalImageView) this.isp.findViewById(d.g.accountSafeSetting);
        this.isu = (SettingTextImageView) this.isp.findViewById(d.g.personInfo);
        this.isv = (TbSettingTextTipView) this.isp.findViewById(d.g.interest_label_setting);
        this.isv.setTopLineVisibility(true);
        this.isw = (TbSettingTextTipView) this.isp.findViewById(d.g.accountManager);
        this.isw.setTopLineVisibility(true);
        this.isx = (TbSettingTextTipView) this.isp.findViewById(d.g.browseSetting);
        this.isx.setBottomLineVisibility(true);
        this.isy = (TbSettingTextTipView) this.isp.findViewById(d.g.adSetting);
        this.isy.setBottomLineVisibility(true);
        this.isz = (TbSettingTextTipView) this.isp.findViewById(d.g.messageSetting);
        this.isz.setBottomLineVisibility(true);
        this.isx.setBottomLineVisibility(true);
        this.isA = (TbSettingTextTipView) this.isp.findViewById(d.g.secretSetting);
        this.isA.setBottomLineVisibility(true);
        this.isB = (SettingTextVersionView) this.isp.findViewById(d.g.versionInfo);
        this.isC = (TbSettingTextTipView) this.isp.findViewById(d.g.feedBack);
        this.isC.setTopLineVisibility(true);
        this.isC.setBottomLineVisibility(true);
        this.isD = (TbSettingTextTipView) this.isp.findViewById(d.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.isD.setVisibility(8);
            this.isD.setBottomLineVisibility(false);
        } else {
            this.isD.setVisibility(0);
            this.isD.setBottomLineVisibility(true);
        }
        this.isE = (TbSettingTextNewDotView) this.isp.findViewById(d.g.systemhelpsetting);
        this.isF = (TextView) this.isp.findViewById(d.g.quit);
        this.isO = (RelativeLayout) this.isp.findViewById(d.g.eyeshield_mode);
        this.isP = (BdSwitchView) this.isp.findViewById(d.g.item_switch);
        l.b(this.isp.getPageContext().getPageActivity(), this.isP, 10, 10, 10, 10);
        this.isJ = this.isp.findViewById(d.g.divide_view2);
        this.isK = this.isp.findViewById(d.g.divide_view1);
        this.isL = this.isp.findViewById(d.g.divide_view3);
        this.isM = this.isp.findViewById(d.g.divide_view4);
        this.isN = this.isp.findViewById(d.g.divide_view5);
        bZB();
        bZA();
        this.isu.caB();
        jf(TbadkCoreApplication.getInst().getSkinType());
        this.isK.setVisibility(0);
        this.isL.setVisibility(0);
        this.isM.setVisibility(0);
        this.isN.setVisibility(0);
        U(clickListener);
        if (!bZD()) {
            this.isx.setTip(this.isp.getResources().getString(d.j.browsing_settings_tip_no_night));
            this.isJ.setVisibility(8);
            this.isO.setVisibility(8);
            return;
        }
        this.isJ.setVisibility(0);
        this.isO.setVisibility(0);
    }

    private boolean bZD() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void zm() {
        this.iss = new i(getPageContext().getPageActivity());
        this.iss.setTitleText(getPageContext().getString(d.j.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.f fVar = new com.baidu.tbadk.core.dialog.f(getPageContext().getString(d.j.quite_current_account), this.iss);
        fVar.setTextColor(d.C0277d.cp_cont_h);
        arrayList.add(fVar);
        this.isp.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.isp.getLayoutMode().onModeChanged(this.iss.abf());
        i.c cVar = new i.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                if (i == fVar.getId()) {
                    e.this.atv();
                    e.this.isq.yu(12);
                }
            }
        };
        i.a aVar = new i.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                e.this.atv();
            }
        };
        this.iss.P(arrayList);
        this.iss.a(cVar);
        this.iss.a(aVar);
        this.isr = new com.baidu.tbadk.core.dialog.g(this.mContext);
        this.isr.setCanceledOnTouchOutside(true);
        this.isr.setContentView(this.iss.abh());
    }

    private void U(View.OnClickListener onClickListener) {
        this.ist.setOnClickListener(onClickListener);
        this.isI.setOnClickListener(onClickListener);
        this.isu.setOnClickListener(onClickListener);
        this.isv.setOnClickListener(onClickListener);
        this.isw.setOnClickListener(onClickListener);
        this.isx.setOnClickListener(onClickListener);
        this.isy.setOnClickListener(onClickListener);
        this.isz.setOnClickListener(onClickListener);
        this.isA.setOnClickListener(onClickListener);
        this.isB.setOnClickListener(onClickListener);
        this.isC.setOnClickListener(onClickListener);
        this.isD.setOnClickListener(onClickListener);
        this.isE.setOnClickListener(onClickListener);
        this.isF.setOnClickListener(onClickListener);
        this.isP.setOnSwitchStateChangeListener(this.isp);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.isI) {
                    e.this.isq.yu(0);
                } else if (view == e.this.isu) {
                    e.this.isq.yu(1);
                } else if (view == e.this.isv) {
                    e.this.isq.yu(15);
                } else if (view == e.this.isw) {
                    e.this.isq.yu(2);
                } else if (view == e.this.isx) {
                    e.this.isq.yu(3);
                } else if (view == e.this.isz) {
                    e.this.isq.yu(4);
                } else if (view == e.this.isA) {
                    e.this.isq.yu(9);
                } else if (view == e.this.isB) {
                    e.this.isq.yu(6);
                } else if (view == e.this.isC) {
                    e.this.isq.yu(7);
                } else if (view == e.this.isD) {
                    e.this.isq.yu(8);
                } else if (view == e.this.isE) {
                    e.this.isq.yu(5);
                } else if (view == e.this.isF) {
                    e.this.isq.yu(10);
                } else if (view == e.this.ist) {
                    e.this.isq.yu(13);
                } else if (view == e.this.isy) {
                    e.this.isq.yu(16);
                }
            }
        };
    }

    public void bZE() {
        if (this.isr == null) {
            zm();
        }
        this.isr.showDialog();
    }

    public void atv() {
        if (this.isr != null) {
            this.isr.dismiss();
        }
    }

    public BdSwitchView bZF() {
        return this.isP;
    }
}
