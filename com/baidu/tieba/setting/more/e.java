package com.baidu.tieba.setting.more;

import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private NavigationBar mNavigationBar;
    private MoreActivity mVT;
    private d mVU;
    private com.baidu.tbadk.core.dialog.i mVV;
    private k mVW;
    private SettingTextNormalImageView mVX;
    private SettingTextImageView mVY;
    private TbSettingTextTipView mVZ;
    private TbSettingTextTipView mWa;
    private TbSettingTextTipView mWb;
    private TbSettingTextTipView mWc;
    private TbSettingTextTipView mWd;
    private TbSettingTextTipView mWe;
    private TbSettingTextTipView mWf;
    private SettingTextVersionView mWg;
    private TbSettingTextTipView mWh;
    private TbSettingTextTipView mWi;
    private TbSettingTextNewDotView mWj;
    private TextView mWk;
    private RelativeLayout mWl;
    private View mWm;
    private View mWn;
    private View mWo;
    private View mWp;
    private View mWq;
    private View mWr;
    private View mWs;
    private RelativeLayout mWt;
    private BdSwitchView mWu;
    private RelativeLayout mWv;
    private BdSwitchView mWw;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.mWo = null;
        this.mWp = null;
        this.mWq = null;
        this.mWr = null;
        this.mWs = null;
        this.mWt = null;
        this.mWu = null;
        this.mWv = null;
        this.mWw = null;
        this.mVT = moreActivity;
        this.mVU = dVar;
        this.mVT.setContentView(R.layout.more_activity);
        bAL();
        dJg();
    }

    public void dJe() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mVY.setVisibility(8);
        } else {
            this.mVY.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.mVY != null) {
                this.mVY.dKn();
                return;
            }
            return;
        }
        this.mVY.dKo();
        this.mVY.setIcon(str, z);
    }

    public void dJf() {
        if (this.mWg != null) {
            this.mWg.refresh();
        }
        if (this.mWj != null) {
            this.mWj.refresh();
        }
    }

    public void dJg() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mWu.turnOn();
        } else {
            this.mWu.turnOff();
        }
    }

    public void Kd(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dY("obj_type", "1").dY("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dY("obj_type", "0").dY("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dIe() {
        this.mVY.recycle();
        this.mVZ.recycle();
        this.mWa.recycle();
        this.mWb.recycle();
        this.mWc.recycle();
        this.mWe.recycle();
        this.mWf.recycle();
        this.mWg.recycle();
        this.mWh.recycle();
        this.mWi.recycle();
    }

    public void onChangeSkinType(int i) {
        rY(i);
        if (this.mVW != null) {
            this.mVT.getLayoutMode().setNightMode(i == 1);
            this.mVT.getLayoutMode().onModeChanged(this.mVW.getView());
        }
        if (i == 1) {
            this.mWu.turnOnNoCallback();
        } else {
            this.mWu.turnOffNoCallback();
        }
    }

    public void rY(int i) {
        ap.setBackgroundColor(this.mWl, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mVY.rY(i);
        this.mVT.getLayoutMode().setNightMode(i == 1);
        this.mVT.getLayoutMode().onModeChanged(this.mWl);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dJf();
        this.mWu.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mWw.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.mWm, R.color.CAM_X0201);
        this.mVX.setLocalIcon(ap.pS(R.drawable.icon_mine_list_baidu));
        if (this.mVW != null) {
            this.mVW.onChangeSkinType();
        }
        this.mVX.rY(i);
        this.mVY.rY(i);
        this.mVZ.onChangeSkinType(i);
        this.mWa.onChangeSkinType(i);
        this.mWb.onChangeSkinType(i);
        this.mWc.onChangeSkinType(i);
        this.mWd.onChangeSkinType(i);
        this.mWe.onChangeSkinType(i);
        this.mWf.onChangeSkinType(i);
        this.mWg.onChangeSkinType(i);
        this.mWh.onChangeSkinType(i);
        this.mWi.onChangeSkinType(i);
        this.mWj.onChangeSkinType(i);
    }

    private void bAL() {
        View.OnClickListener clickListener = getClickListener();
        this.mWl = (RelativeLayout) this.mVT.findViewById(R.id.parent);
        this.mWm = this.mVT.findViewById(R.id.scroll);
        this.mVT.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.mVT.findViewById(R.id.view_navigation_bar);
        this.mWn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mVT.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.mVX = (SettingTextNormalImageView) this.mVT.findViewById(R.id.accountSafeSetting);
        this.mVY = (SettingTextImageView) this.mVT.findViewById(R.id.personInfo);
        this.mVZ = (TbSettingTextTipView) this.mVT.findViewById(R.id.interest_label_setting);
        this.mVZ.setTopLineVisibility(true);
        this.mWa = (TbSettingTextTipView) this.mVT.findViewById(R.id.accountManager);
        this.mWa.setTopLineVisibility(true);
        this.mWb = (TbSettingTextTipView) this.mVT.findViewById(R.id.browseSetting);
        this.mWb.setBottomLineVisibility(true);
        this.mWc = (TbSettingTextTipView) this.mVT.findViewById(R.id.youngsterSetting);
        this.mWc.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bKl()) {
            this.mWc.setTip(this.mVT.getString(R.string.youngster_settings_tip_open));
        } else {
            this.mWc.setTip(this.mVT.getString(R.string.youngster_settings_tip_close));
        }
        this.mWd = (TbSettingTextTipView) this.mVT.findViewById(R.id.adSetting);
        this.mWd.setBottomLineVisibility(true);
        this.mWe = (TbSettingTextTipView) this.mVT.findViewById(R.id.messageSetting);
        this.mWe.setBottomLineVisibility(true);
        this.mWb.setBottomLineVisibility(true);
        this.mWf = (TbSettingTextTipView) this.mVT.findViewById(R.id.secretSetting);
        this.mWf.setBottomLineVisibility(true);
        this.mWg = (SettingTextVersionView) this.mVT.findViewById(R.id.versionInfo);
        this.mWh = (TbSettingTextTipView) this.mVT.findViewById(R.id.feedBack);
        this.mWh.setTopLineVisibility(true);
        this.mWh.setBottomLineVisibility(true);
        this.mWi = (TbSettingTextTipView) this.mVT.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.mWi.setVisibility(8);
            this.mWi.setBottomLineVisibility(false);
        } else {
            this.mWi.setVisibility(0);
            this.mWi.setBottomLineVisibility(true);
        }
        this.mWj = (TbSettingTextNewDotView) this.mVT.findViewById(R.id.systemhelpsetting);
        this.mWk = (TextView) this.mVT.findViewById(R.id.quit);
        this.mWt = (RelativeLayout) this.mVT.findViewById(R.id.eyeshield_mode);
        this.mWu = (BdSwitchView) this.mVT.findViewById(R.id.item_switch);
        l.addToParentArea(this.mVT.getPageContext().getPageActivity(), this.mWu, 10, 10, 10, 10);
        this.mWv = (RelativeLayout) this.mVT.findViewById(R.id.follow_system_day_night_mode);
        this.mWw = (BdSwitchView) this.mVT.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.mVT.getPageContext().getPageActivity(), this.mWw, 10, 10, 10, 10);
        this.mWo = this.mVT.findViewById(R.id.divide_view2);
        this.mWp = this.mVT.findViewById(R.id.divide_view1);
        this.mWq = this.mVT.findViewById(R.id.divide_view3);
        this.mWr = this.mVT.findViewById(R.id.divide_view4);
        this.mWs = this.mVT.findViewById(R.id.divide_view5);
        dJf();
        dJe();
        this.mVY.dKn();
        rY(TbadkCoreApplication.getInst().getSkinType());
        this.mWp.setVisibility(0);
        this.mWq.setVisibility(0);
        this.mWr.setVisibility(0);
        this.mWs.setVisibility(0);
        ae(clickListener);
        if (!dJh()) {
            this.mWb.setTip(this.mVT.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.mWo.setVisibility(8);
            this.mWt.setVisibility(8);
        } else {
            this.mWo.setVisibility(0);
            this.mWt.setVisibility(0);
        }
        this.mWv.setVisibility(dJi() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_is_follow_system_mode", false)) {
            this.mWw.turnOnNoCallback();
        } else {
            this.mWw.turnOffNoCallback();
        }
    }

    private boolean dJh() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dJi() {
        if (dJh()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void ask() {
        this.mVW = new k(getPageContext().getPageActivity());
        this.mVW.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.mVW);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.mVT.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mVT.getLayoutMode().onModeChanged(this.mVW.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.ID();
                    e.this.mVU.JY(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.ID();
            }
        };
        this.mVW.bu(arrayList);
        this.mVW.a(cVar);
        this.mVW.a(aVar);
        this.mVV = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.mVV.setCanceledOnTouchOutside(true);
        this.mVV.a(this.mVW);
    }

    private void ae(View.OnClickListener onClickListener) {
        this.mVX.setOnClickListener(onClickListener);
        this.mWn.setOnClickListener(onClickListener);
        this.mVY.setOnClickListener(onClickListener);
        this.mVZ.setOnClickListener(onClickListener);
        this.mWa.setOnClickListener(onClickListener);
        this.mWb.setOnClickListener(onClickListener);
        this.mWc.setOnClickListener(onClickListener);
        this.mWd.setOnClickListener(onClickListener);
        this.mWe.setOnClickListener(onClickListener);
        this.mWf.setOnClickListener(onClickListener);
        this.mWg.setOnClickListener(onClickListener);
        this.mWh.setOnClickListener(onClickListener);
        this.mWi.setOnClickListener(onClickListener);
        this.mWj.setOnClickListener(onClickListener);
        this.mWk.setOnClickListener(onClickListener);
        this.mWu.setOnSwitchStateChangeListener(this.mVT);
        this.mWw.setOnSwitchStateChangeListener(this.mVT);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.mWn) {
                    e.this.mVU.JY(0);
                } else if (view == e.this.mVY) {
                    e.this.mVU.JY(1);
                } else if (view == e.this.mVZ) {
                    e.this.mVU.JY(15);
                } else if (view == e.this.mWa) {
                    e.this.mVU.JY(2);
                } else if (view == e.this.mWb) {
                    e.this.mVU.JY(3);
                } else if (view == e.this.mWc) {
                    e.this.mVU.JY(17);
                } else if (view == e.this.mWe) {
                    e.this.mVU.JY(4);
                } else if (view == e.this.mWf) {
                    e.this.mVU.JY(9);
                } else if (view == e.this.mWg) {
                    e.this.mVU.JY(6);
                } else if (view == e.this.mWh) {
                    e.this.mVU.JY(7);
                } else if (view == e.this.mWi) {
                    e.this.mVU.JY(8);
                } else if (view == e.this.mWj) {
                    e.this.mVU.JY(5);
                } else if (view == e.this.mWk) {
                    e.this.mVU.JY(10);
                } else if (view == e.this.mVX) {
                    e.this.mVU.JY(13);
                } else if (view == e.this.mWd) {
                    e.this.mVU.JY(16);
                }
            }
        };
    }

    public void dJj() {
        if (this.mVV == null) {
            ask();
        }
        this.mVV.RU();
    }

    public void ID() {
        if (this.mVV != null) {
            this.mVV.dismiss();
        }
    }

    public BdSwitchView dJk() {
        return this.mWu;
    }

    public BdSwitchView dJl() {
        return this.mWw;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mVT).areNotificationsEnabled();
        if (this.mWe != null) {
            this.mWe.setTipViewColor(R.color.CAM_X0105);
            this.mWe.setTip(areNotificationsEnabled ? "" : this.mVT.getString(R.string.may_lose_important_msg));
        }
    }
}
