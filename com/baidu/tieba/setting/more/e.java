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
    private TbSettingTextTipView isB;
    private SettingTextVersionView isC;
    private TbSettingTextTipView isD;
    private TbSettingTextTipView isE;
    private TbSettingTextNewDotView isF;
    private TextView isG;
    private RelativeLayout isH;
    private View isI;
    private View isJ;
    private View isK;
    private View isL;
    private View isM;
    private View isN;
    private View isO;
    private RelativeLayout isP;
    private BdSwitchView isQ;
    private MoreActivity isq;
    private d isr;
    private com.baidu.tbadk.core.dialog.g iss;
    private i ist;
    private SettingTextNormalImageView isu;
    private SettingTextImageView isv;
    private TbSettingTextTipView isw;
    private TbSettingTextTipView isx;
    private TbSettingTextTipView isy;
    private TbSettingTextTipView isz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.isK = null;
        this.isL = null;
        this.isM = null;
        this.isN = null;
        this.isO = null;
        this.isP = null;
        this.isQ = null;
        this.isq = moreActivity;
        this.isr = dVar;
        this.isq.setContentView(d.h.more_activity);
        akn();
        bZC();
    }

    public void bZA() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.isv.setVisibility(8);
        } else {
            this.isv.setVisibility(0);
        }
    }

    public void at(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.isv != null) {
                this.isv.caB();
                return;
            }
            return;
        }
        this.isv.caC();
        this.isv.setIcon(str, z);
    }

    public void bZB() {
        if (this.isC != null) {
            this.isC.refresh();
        }
        if (this.isF != null) {
            this.isF.refresh();
        }
    }

    public void bZC() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.isQ.oa();
        } else {
            this.isQ.ob();
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
        this.isv.recycle();
        this.isw.recycle();
        this.isx.recycle();
        this.isy.recycle();
        this.isA.recycle();
        this.isB.recycle();
        this.isC.recycle();
        this.isD.recycle();
        this.isE.recycle();
    }

    public void onChangeSkinType(int i) {
        jf(i);
        if (this.ist != null) {
            this.isq.getLayoutMode().setNightMode(i == 1);
            this.isq.getLayoutMode().onModeChanged(this.ist.abf());
        }
    }

    public void jf(int i) {
        al.l(this.isH, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.isv.jf(i);
        this.isq.getLayoutMode().setNightMode(i == 1);
        this.isq.getLayoutMode().onModeChanged(this.isH);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bZB();
        this.isQ.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        al.l(this.isI, d.C0277d.cp_bg_line_d);
        this.isu.setLocalIcon(al.ht(d.f.icon_mine_list_baidu));
        if (this.ist != null) {
            this.ist.onChangeSkinType();
        }
    }

    private void akn() {
        View.OnClickListener clickListener = getClickListener();
        this.isH = (RelativeLayout) this.isq.findViewById(d.g.parent);
        this.isI = this.isq.findViewById(d.g.scroll);
        this.isq.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.isq.findViewById(d.g.view_navigation_bar);
        this.isJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.isq.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.isu = (SettingTextNormalImageView) this.isq.findViewById(d.g.accountSafeSetting);
        this.isv = (SettingTextImageView) this.isq.findViewById(d.g.personInfo);
        this.isw = (TbSettingTextTipView) this.isq.findViewById(d.g.interest_label_setting);
        this.isw.setTopLineVisibility(true);
        this.isx = (TbSettingTextTipView) this.isq.findViewById(d.g.accountManager);
        this.isx.setTopLineVisibility(true);
        this.isy = (TbSettingTextTipView) this.isq.findViewById(d.g.browseSetting);
        this.isy.setBottomLineVisibility(true);
        this.isz = (TbSettingTextTipView) this.isq.findViewById(d.g.adSetting);
        this.isz.setBottomLineVisibility(true);
        this.isA = (TbSettingTextTipView) this.isq.findViewById(d.g.messageSetting);
        this.isA.setBottomLineVisibility(true);
        this.isy.setBottomLineVisibility(true);
        this.isB = (TbSettingTextTipView) this.isq.findViewById(d.g.secretSetting);
        this.isB.setBottomLineVisibility(true);
        this.isC = (SettingTextVersionView) this.isq.findViewById(d.g.versionInfo);
        this.isD = (TbSettingTextTipView) this.isq.findViewById(d.g.feedBack);
        this.isD.setTopLineVisibility(true);
        this.isD.setBottomLineVisibility(true);
        this.isE = (TbSettingTextTipView) this.isq.findViewById(d.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.isE.setVisibility(8);
            this.isE.setBottomLineVisibility(false);
        } else {
            this.isE.setVisibility(0);
            this.isE.setBottomLineVisibility(true);
        }
        this.isF = (TbSettingTextNewDotView) this.isq.findViewById(d.g.systemhelpsetting);
        this.isG = (TextView) this.isq.findViewById(d.g.quit);
        this.isP = (RelativeLayout) this.isq.findViewById(d.g.eyeshield_mode);
        this.isQ = (BdSwitchView) this.isq.findViewById(d.g.item_switch);
        l.b(this.isq.getPageContext().getPageActivity(), this.isQ, 10, 10, 10, 10);
        this.isK = this.isq.findViewById(d.g.divide_view2);
        this.isL = this.isq.findViewById(d.g.divide_view1);
        this.isM = this.isq.findViewById(d.g.divide_view3);
        this.isN = this.isq.findViewById(d.g.divide_view4);
        this.isO = this.isq.findViewById(d.g.divide_view5);
        bZB();
        bZA();
        this.isv.caB();
        jf(TbadkCoreApplication.getInst().getSkinType());
        this.isL.setVisibility(0);
        this.isM.setVisibility(0);
        this.isN.setVisibility(0);
        this.isO.setVisibility(0);
        U(clickListener);
        if (!bZD()) {
            this.isy.setTip(this.isq.getResources().getString(d.j.browsing_settings_tip_no_night));
            this.isK.setVisibility(8);
            this.isP.setVisibility(8);
            return;
        }
        this.isK.setVisibility(0);
        this.isP.setVisibility(0);
    }

    private boolean bZD() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void zm() {
        this.ist = new i(getPageContext().getPageActivity());
        this.ist.setTitleText(getPageContext().getString(d.j.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.f fVar = new com.baidu.tbadk.core.dialog.f(getPageContext().getString(d.j.quite_current_account), this.ist);
        fVar.setTextColor(d.C0277d.cp_cont_h);
        arrayList.add(fVar);
        this.isq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.isq.getLayoutMode().onModeChanged(this.ist.abf());
        i.c cVar = new i.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                if (i == fVar.getId()) {
                    e.this.atv();
                    e.this.isr.yu(12);
                }
            }
        };
        i.a aVar = new i.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                e.this.atv();
            }
        };
        this.ist.P(arrayList);
        this.ist.a(cVar);
        this.ist.a(aVar);
        this.iss = new com.baidu.tbadk.core.dialog.g(this.mContext);
        this.iss.setCanceledOnTouchOutside(true);
        this.iss.setContentView(this.ist.abh());
    }

    private void U(View.OnClickListener onClickListener) {
        this.isu.setOnClickListener(onClickListener);
        this.isJ.setOnClickListener(onClickListener);
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
        this.isG.setOnClickListener(onClickListener);
        this.isQ.setOnSwitchStateChangeListener(this.isq);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.isJ) {
                    e.this.isr.yu(0);
                } else if (view == e.this.isv) {
                    e.this.isr.yu(1);
                } else if (view == e.this.isw) {
                    e.this.isr.yu(15);
                } else if (view == e.this.isx) {
                    e.this.isr.yu(2);
                } else if (view == e.this.isy) {
                    e.this.isr.yu(3);
                } else if (view == e.this.isA) {
                    e.this.isr.yu(4);
                } else if (view == e.this.isB) {
                    e.this.isr.yu(9);
                } else if (view == e.this.isC) {
                    e.this.isr.yu(6);
                } else if (view == e.this.isD) {
                    e.this.isr.yu(7);
                } else if (view == e.this.isE) {
                    e.this.isr.yu(8);
                } else if (view == e.this.isF) {
                    e.this.isr.yu(5);
                } else if (view == e.this.isG) {
                    e.this.isr.yu(10);
                } else if (view == e.this.isu) {
                    e.this.isr.yu(13);
                } else if (view == e.this.isz) {
                    e.this.isr.yu(16);
                }
            }
        };
    }

    public void bZE() {
        if (this.iss == null) {
            zm();
        }
        this.iss.showDialog();
    }

    public void atv() {
        if (this.iss != null) {
            this.iss.dismiss();
        }
    }

    public BdSwitchView bZF() {
        return this.isQ;
    }
}
