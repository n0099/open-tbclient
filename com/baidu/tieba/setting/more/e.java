package com.baidu.tieba.setting.more;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity jUL;
    private d jUM;
    private com.baidu.tbadk.core.dialog.i jUN;
    private k jUO;
    private SettingTextNormalImageView jUP;
    private SettingTextImageView jUQ;
    private TbSettingTextTipView jUR;
    private TbSettingTextTipView jUS;
    private TbSettingTextTipView jUT;
    private TbSettingTextTipView jUU;
    private TbSettingTextTipView jUV;
    private TbSettingTextTipView jUW;
    private SettingTextVersionView jUX;
    private TbSettingTextTipView jUY;
    private TbSettingTextTipView jUZ;
    private TbSettingTextNewDotView jVa;
    private TextView jVb;
    private RelativeLayout jVc;
    private View jVd;
    private View jVe;
    private View jVf;
    private View jVg;
    private View jVh;
    private View jVi;
    private View jVj;
    private RelativeLayout jVk;
    private BdSwitchView jVl;
    private RelativeLayout jVm;
    private BdSwitchView jVn;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.jVf = null;
        this.jVg = null;
        this.jVh = null;
        this.jVi = null;
        this.jVj = null;
        this.jVk = null;
        this.jVl = null;
        this.jVm = null;
        this.jVn = null;
        this.jUL = moreActivity;
        this.jUM = dVar;
        this.jUL.setContentView(R.layout.more_activity);
        aMW();
        cGw();
    }

    public void cGu() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jUQ.setVisibility(8);
        } else {
            this.jUQ.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.jUQ != null) {
                this.jUQ.cHz();
                return;
            }
            return;
        }
        this.jUQ.cHA();
        this.jUQ.setIcon(str, z);
    }

    public void cGv() {
        if (this.jUX != null) {
            this.jUX.refresh();
        }
        if (this.jVa != null) {
            this.jVa.refresh();
        }
    }

    public void cGw() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jVl.turnOn();
        } else {
            this.jVl.turnOff();
        }
    }

    public void BP(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cx("obj_type", "1").cx("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cx("obj_type", "0").cx("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void cFy() {
        this.jUQ.recycle();
        this.jUR.recycle();
        this.jUS.recycle();
        this.jUT.recycle();
        this.jUV.recycle();
        this.jUW.recycle();
        this.jUX.recycle();
        this.jUY.recycle();
        this.jUZ.recycle();
    }

    public void onChangeSkinType(int i) {
        mg(i);
        if (this.jUO != null) {
            this.jUL.getLayoutMode().setNightMode(i == 1);
            this.jUL.getLayoutMode().onModeChanged(this.jUO.getView());
        }
        if (i == 1) {
            this.jVl.turnOnNoCallback();
        } else {
            this.jVl.turnOffNoCallback();
        }
    }

    public void mg(int i) {
        am.setBackgroundColor(this.jVc, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jUQ.mg(i);
        this.jUL.getLayoutMode().setNightMode(i == 1);
        this.jUL.getLayoutMode().onModeChanged(this.jVc);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cGv();
        this.jVl.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jVn.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.jVd, R.color.cp_bg_line_d);
        this.jUP.setLocalIcon(am.ku(R.drawable.icon_mine_list_baidu));
        if (this.jUO != null) {
            this.jUO.onChangeSkinType();
        }
        this.jUP.mg(i);
        this.jUQ.mg(i);
        this.jUR.onChangeSkinType(i);
        this.jUS.onChangeSkinType(i);
        this.jUT.onChangeSkinType(i);
        this.jUU.onChangeSkinType(i);
        this.jUV.onChangeSkinType(i);
        this.jUW.onChangeSkinType(i);
        this.jUX.onChangeSkinType(i);
        this.jUY.onChangeSkinType(i);
        this.jUZ.onChangeSkinType(i);
        this.jVa.onChangeSkinType(i);
    }

    private void aMW() {
        View.OnClickListener clickListener = getClickListener();
        this.jVc = (RelativeLayout) this.jUL.findViewById(R.id.parent);
        this.jVd = this.jUL.findViewById(R.id.scroll);
        this.jUL.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.jUL.findViewById(R.id.view_navigation_bar);
        this.jVe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jUL.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.jUP = (SettingTextNormalImageView) this.jUL.findViewById(R.id.accountSafeSetting);
        this.jUQ = (SettingTextImageView) this.jUL.findViewById(R.id.personInfo);
        this.jUR = (TbSettingTextTipView) this.jUL.findViewById(R.id.interest_label_setting);
        this.jUR.setTopLineVisibility(true);
        this.jUS = (TbSettingTextTipView) this.jUL.findViewById(R.id.accountManager);
        this.jUS.setTopLineVisibility(true);
        this.jUT = (TbSettingTextTipView) this.jUL.findViewById(R.id.browseSetting);
        this.jUT.setBottomLineVisibility(true);
        this.jUU = (TbSettingTextTipView) this.jUL.findViewById(R.id.adSetting);
        this.jUU.setBottomLineVisibility(true);
        this.jUV = (TbSettingTextTipView) this.jUL.findViewById(R.id.messageSetting);
        this.jUV.setBottomLineVisibility(true);
        this.jUT.setBottomLineVisibility(true);
        this.jUW = (TbSettingTextTipView) this.jUL.findViewById(R.id.secretSetting);
        this.jUW.setBottomLineVisibility(true);
        this.jUX = (SettingTextVersionView) this.jUL.findViewById(R.id.versionInfo);
        this.jUY = (TbSettingTextTipView) this.jUL.findViewById(R.id.feedBack);
        this.jUY.setTopLineVisibility(true);
        this.jUY.setBottomLineVisibility(true);
        this.jUZ = (TbSettingTextTipView) this.jUL.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.jUZ.setVisibility(8);
            this.jUZ.setBottomLineVisibility(false);
        } else {
            this.jUZ.setVisibility(0);
            this.jUZ.setBottomLineVisibility(true);
        }
        this.jVa = (TbSettingTextNewDotView) this.jUL.findViewById(R.id.systemhelpsetting);
        this.jVb = (TextView) this.jUL.findViewById(R.id.quit);
        this.jVk = (RelativeLayout) this.jUL.findViewById(R.id.eyeshield_mode);
        this.jVl = (BdSwitchView) this.jUL.findViewById(R.id.item_switch);
        l.addToParentArea(this.jUL.getPageContext().getPageActivity(), this.jVl, 10, 10, 10, 10);
        this.jVm = (RelativeLayout) this.jUL.findViewById(R.id.follow_system_day_night_mode);
        this.jVn = (BdSwitchView) this.jUL.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.jUL.getPageContext().getPageActivity(), this.jVn, 10, 10, 10, 10);
        this.jVf = this.jUL.findViewById(R.id.divide_view2);
        this.jVg = this.jUL.findViewById(R.id.divide_view1);
        this.jVh = this.jUL.findViewById(R.id.divide_view3);
        this.jVi = this.jUL.findViewById(R.id.divide_view4);
        this.jVj = this.jUL.findViewById(R.id.divide_view5);
        cGv();
        cGu();
        this.jUQ.cHz();
        mg(TbadkCoreApplication.getInst().getSkinType());
        this.jVg.setVisibility(0);
        this.jVh.setVisibility(0);
        this.jVi.setVisibility(0);
        this.jVj.setVisibility(0);
        aa(clickListener);
        if (!cGx()) {
            this.jUT.setTip(this.jUL.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.jVf.setVisibility(8);
            this.jVk.setVisibility(8);
        } else {
            this.jVf.setVisibility(0);
            this.jVk.setVisibility(0);
        }
        this.jVm.setVisibility(cGy() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_is_follow_system_mode", false)) {
            this.jVn.turnOnNoCallback();
        } else {
            this.jVn.turnOffNoCallback();
        }
    }

    private boolean cGx() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cGy() {
        if (cGx()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void Pb() {
        this.jUO = new k(getPageContext().getPageActivity());
        this.jUO.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.jUO);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.jUL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jUL.getLayoutMode().onModeChanged(this.jUO.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.sS();
                    e.this.jUM.BK(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.sS();
            }
        };
        this.jUO.az(arrayList);
        this.jUO.a(cVar);
        this.jUO.a(aVar);
        this.jUN = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.jUN.setCanceledOnTouchOutside(true);
        this.jUN.a(this.jUO);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.jUP.setOnClickListener(onClickListener);
        this.jVe.setOnClickListener(onClickListener);
        this.jUQ.setOnClickListener(onClickListener);
        this.jUR.setOnClickListener(onClickListener);
        this.jUS.setOnClickListener(onClickListener);
        this.jUT.setOnClickListener(onClickListener);
        this.jUU.setOnClickListener(onClickListener);
        this.jUV.setOnClickListener(onClickListener);
        this.jUW.setOnClickListener(onClickListener);
        this.jUX.setOnClickListener(onClickListener);
        this.jUY.setOnClickListener(onClickListener);
        this.jUZ.setOnClickListener(onClickListener);
        this.jVa.setOnClickListener(onClickListener);
        this.jVb.setOnClickListener(onClickListener);
        this.jVl.setOnSwitchStateChangeListener(this.jUL);
        this.jVn.setOnSwitchStateChangeListener(this.jUL);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.jVe) {
                    e.this.jUM.BK(0);
                } else if (view == e.this.jUQ) {
                    e.this.jUM.BK(1);
                } else if (view == e.this.jUR) {
                    e.this.jUM.BK(15);
                } else if (view == e.this.jUS) {
                    e.this.jUM.BK(2);
                } else if (view == e.this.jUT) {
                    e.this.jUM.BK(3);
                } else if (view == e.this.jUV) {
                    e.this.jUM.BK(4);
                } else if (view == e.this.jUW) {
                    e.this.jUM.BK(9);
                } else if (view == e.this.jUX) {
                    e.this.jUM.BK(6);
                } else if (view == e.this.jUY) {
                    e.this.jUM.BK(7);
                } else if (view == e.this.jUZ) {
                    e.this.jUM.BK(8);
                } else if (view == e.this.jVa) {
                    e.this.jUM.BK(5);
                } else if (view == e.this.jVb) {
                    e.this.jUM.BK(10);
                } else if (view == e.this.jUP) {
                    e.this.jUM.BK(13);
                } else if (view == e.this.jUU) {
                    e.this.jUM.BK(16);
                }
            }
        };
    }

    public void cGz() {
        if (this.jUN == null) {
            Pb();
        }
        this.jUN.showDialog();
    }

    public void sS() {
        if (this.jUN != null) {
            this.jUN.dismiss();
        }
    }

    public BdSwitchView cGA() {
        return this.jVl;
    }

    public BdSwitchView cGB() {
        return this.jVn;
    }
}
