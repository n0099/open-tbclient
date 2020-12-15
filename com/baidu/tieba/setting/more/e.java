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
    private MoreActivity mVV;
    private d mVW;
    private com.baidu.tbadk.core.dialog.i mVX;
    private k mVY;
    private SettingTextNormalImageView mVZ;
    private SettingTextImageView mWa;
    private TbSettingTextTipView mWb;
    private TbSettingTextTipView mWc;
    private TbSettingTextTipView mWd;
    private TbSettingTextTipView mWe;
    private TbSettingTextTipView mWf;
    private TbSettingTextTipView mWg;
    private TbSettingTextTipView mWh;
    private SettingTextVersionView mWi;
    private TbSettingTextTipView mWj;
    private TbSettingTextTipView mWk;
    private TbSettingTextNewDotView mWl;
    private TextView mWm;
    private RelativeLayout mWn;
    private View mWo;
    private View mWp;
    private View mWq;
    private View mWr;
    private View mWs;
    private View mWt;
    private View mWu;
    private RelativeLayout mWv;
    private BdSwitchView mWw;
    private RelativeLayout mWx;
    private BdSwitchView mWy;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.mWq = null;
        this.mWr = null;
        this.mWs = null;
        this.mWt = null;
        this.mWu = null;
        this.mWv = null;
        this.mWw = null;
        this.mWx = null;
        this.mWy = null;
        this.mVV = moreActivity;
        this.mVW = dVar;
        this.mVV.setContentView(R.layout.more_activity);
        bAL();
        dJh();
    }

    public void dJf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mWa.setVisibility(8);
        } else {
            this.mWa.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.mWa != null) {
                this.mWa.dKo();
                return;
            }
            return;
        }
        this.mWa.dKp();
        this.mWa.setIcon(str, z);
    }

    public void dJg() {
        if (this.mWi != null) {
            this.mWi.refresh();
        }
        if (this.mWl != null) {
            this.mWl.refresh();
        }
    }

    public void dJh() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mWw.turnOn();
        } else {
            this.mWw.turnOff();
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

    public void dIf() {
        this.mWa.recycle();
        this.mWb.recycle();
        this.mWc.recycle();
        this.mWd.recycle();
        this.mWe.recycle();
        this.mWg.recycle();
        this.mWh.recycle();
        this.mWi.recycle();
        this.mWj.recycle();
        this.mWk.recycle();
    }

    public void onChangeSkinType(int i) {
        rY(i);
        if (this.mVY != null) {
            this.mVV.getLayoutMode().setNightMode(i == 1);
            this.mVV.getLayoutMode().onModeChanged(this.mVY.getView());
        }
        if (i == 1) {
            this.mWw.turnOnNoCallback();
        } else {
            this.mWw.turnOffNoCallback();
        }
    }

    public void rY(int i) {
        ap.setBackgroundColor(this.mWn, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mWa.rY(i);
        this.mVV.getLayoutMode().setNightMode(i == 1);
        this.mVV.getLayoutMode().onModeChanged(this.mWn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dJg();
        this.mWw.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mWy.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.mWo, R.color.CAM_X0201);
        this.mVZ.setLocalIcon(ap.pS(R.drawable.icon_mine_list_baidu));
        if (this.mVY != null) {
            this.mVY.onChangeSkinType();
        }
        this.mVZ.rY(i);
        this.mWa.rY(i);
        this.mWb.onChangeSkinType(i);
        this.mWc.onChangeSkinType(i);
        this.mWd.onChangeSkinType(i);
        this.mWe.onChangeSkinType(i);
        this.mWf.onChangeSkinType(i);
        this.mWg.onChangeSkinType(i);
        this.mWh.onChangeSkinType(i);
        this.mWi.onChangeSkinType(i);
        this.mWj.onChangeSkinType(i);
        this.mWk.onChangeSkinType(i);
        this.mWl.onChangeSkinType(i);
    }

    private void bAL() {
        View.OnClickListener clickListener = getClickListener();
        this.mWn = (RelativeLayout) this.mVV.findViewById(R.id.parent);
        this.mWo = this.mVV.findViewById(R.id.scroll);
        this.mVV.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.mVV.findViewById(R.id.view_navigation_bar);
        this.mWp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mVV.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.mVZ = (SettingTextNormalImageView) this.mVV.findViewById(R.id.accountSafeSetting);
        this.mWa = (SettingTextImageView) this.mVV.findViewById(R.id.personInfo);
        this.mWb = (TbSettingTextTipView) this.mVV.findViewById(R.id.interest_label_setting);
        this.mWb.setTopLineVisibility(true);
        this.mWc = (TbSettingTextTipView) this.mVV.findViewById(R.id.accountManager);
        this.mWc.setTopLineVisibility(true);
        this.mWd = (TbSettingTextTipView) this.mVV.findViewById(R.id.browseSetting);
        this.mWd.setBottomLineVisibility(true);
        this.mWe = (TbSettingTextTipView) this.mVV.findViewById(R.id.youngsterSetting);
        this.mWe.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bKl()) {
            this.mWe.setTip(this.mVV.getString(R.string.youngster_settings_tip_open));
        } else {
            this.mWe.setTip(this.mVV.getString(R.string.youngster_settings_tip_close));
        }
        this.mWf = (TbSettingTextTipView) this.mVV.findViewById(R.id.adSetting);
        this.mWf.setBottomLineVisibility(true);
        this.mWg = (TbSettingTextTipView) this.mVV.findViewById(R.id.messageSetting);
        this.mWg.setBottomLineVisibility(true);
        this.mWd.setBottomLineVisibility(true);
        this.mWh = (TbSettingTextTipView) this.mVV.findViewById(R.id.secretSetting);
        this.mWh.setBottomLineVisibility(true);
        this.mWi = (SettingTextVersionView) this.mVV.findViewById(R.id.versionInfo);
        this.mWj = (TbSettingTextTipView) this.mVV.findViewById(R.id.feedBack);
        this.mWj.setTopLineVisibility(true);
        this.mWj.setBottomLineVisibility(true);
        this.mWk = (TbSettingTextTipView) this.mVV.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.mWk.setVisibility(8);
            this.mWk.setBottomLineVisibility(false);
        } else {
            this.mWk.setVisibility(0);
            this.mWk.setBottomLineVisibility(true);
        }
        this.mWl = (TbSettingTextNewDotView) this.mVV.findViewById(R.id.systemhelpsetting);
        this.mWm = (TextView) this.mVV.findViewById(R.id.quit);
        this.mWv = (RelativeLayout) this.mVV.findViewById(R.id.eyeshield_mode);
        this.mWw = (BdSwitchView) this.mVV.findViewById(R.id.item_switch);
        l.addToParentArea(this.mVV.getPageContext().getPageActivity(), this.mWw, 10, 10, 10, 10);
        this.mWx = (RelativeLayout) this.mVV.findViewById(R.id.follow_system_day_night_mode);
        this.mWy = (BdSwitchView) this.mVV.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.mVV.getPageContext().getPageActivity(), this.mWy, 10, 10, 10, 10);
        this.mWq = this.mVV.findViewById(R.id.divide_view2);
        this.mWr = this.mVV.findViewById(R.id.divide_view1);
        this.mWs = this.mVV.findViewById(R.id.divide_view3);
        this.mWt = this.mVV.findViewById(R.id.divide_view4);
        this.mWu = this.mVV.findViewById(R.id.divide_view5);
        dJg();
        dJf();
        this.mWa.dKo();
        rY(TbadkCoreApplication.getInst().getSkinType());
        this.mWr.setVisibility(0);
        this.mWs.setVisibility(0);
        this.mWt.setVisibility(0);
        this.mWu.setVisibility(0);
        ae(clickListener);
        if (!dJi()) {
            this.mWd.setTip(this.mVV.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.mWq.setVisibility(8);
            this.mWv.setVisibility(8);
        } else {
            this.mWq.setVisibility(0);
            this.mWv.setVisibility(0);
        }
        this.mWx.setVisibility(dJj() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_is_follow_system_mode", false)) {
            this.mWy.turnOnNoCallback();
        } else {
            this.mWy.turnOffNoCallback();
        }
    }

    private boolean dJi() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dJj() {
        if (dJi()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void ask() {
        this.mVY = new k(getPageContext().getPageActivity());
        this.mVY.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.mVY);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.mVV.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mVV.getLayoutMode().onModeChanged(this.mVY.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.ID();
                    e.this.mVW.JY(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.ID();
            }
        };
        this.mVY.bu(arrayList);
        this.mVY.a(cVar);
        this.mVY.a(aVar);
        this.mVX = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.mVX.setCanceledOnTouchOutside(true);
        this.mVX.a(this.mVY);
    }

    private void ae(View.OnClickListener onClickListener) {
        this.mVZ.setOnClickListener(onClickListener);
        this.mWp.setOnClickListener(onClickListener);
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
        this.mWl.setOnClickListener(onClickListener);
        this.mWm.setOnClickListener(onClickListener);
        this.mWw.setOnSwitchStateChangeListener(this.mVV);
        this.mWy.setOnSwitchStateChangeListener(this.mVV);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.mWp) {
                    e.this.mVW.JY(0);
                } else if (view == e.this.mWa) {
                    e.this.mVW.JY(1);
                } else if (view == e.this.mWb) {
                    e.this.mVW.JY(15);
                } else if (view == e.this.mWc) {
                    e.this.mVW.JY(2);
                } else if (view == e.this.mWd) {
                    e.this.mVW.JY(3);
                } else if (view == e.this.mWe) {
                    e.this.mVW.JY(17);
                } else if (view == e.this.mWg) {
                    e.this.mVW.JY(4);
                } else if (view == e.this.mWh) {
                    e.this.mVW.JY(9);
                } else if (view == e.this.mWi) {
                    e.this.mVW.JY(6);
                } else if (view == e.this.mWj) {
                    e.this.mVW.JY(7);
                } else if (view == e.this.mWk) {
                    e.this.mVW.JY(8);
                } else if (view == e.this.mWl) {
                    e.this.mVW.JY(5);
                } else if (view == e.this.mWm) {
                    e.this.mVW.JY(10);
                } else if (view == e.this.mVZ) {
                    e.this.mVW.JY(13);
                } else if (view == e.this.mWf) {
                    e.this.mVW.JY(16);
                }
            }
        };
    }

    public void dJk() {
        if (this.mVX == null) {
            ask();
        }
        this.mVX.RU();
    }

    public void ID() {
        if (this.mVX != null) {
            this.mVX.dismiss();
        }
    }

    public BdSwitchView dJl() {
        return this.mWw;
    }

    public BdSwitchView dJm() {
        return this.mWy;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mVV).areNotificationsEnabled();
        if (this.mWg != null) {
            this.mWg.setTipViewColor(R.color.CAM_X0105);
            this.mWg.setTip(areNotificationsEnabled ? "" : this.mVV.getString(R.string.may_lose_important_msg));
        }
    }
}
