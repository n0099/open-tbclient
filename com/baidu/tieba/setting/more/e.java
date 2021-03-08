package com.baidu.tieba.setting.more;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
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
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.base.d<MoreActivity> {
    private NavigationBar mNavigationBar;
    private MoreActivity niY;
    private d niZ;
    private RelativeLayout njA;
    private BdSwitchView njB;
    private com.baidu.tbadk.core.dialog.i nja;
    private k njb;
    private SettingTextNormalImageView njc;
    private SettingTextImageView njd;
    private TbSettingTextTipView nje;
    private TbSettingTextTipView njf;
    private TbSettingTextTipView njg;
    private TbSettingTextTipView njh;
    private TbSettingTextTipView nji;
    private TbSettingTextTipView njj;
    private TbSettingTextTipView njk;
    private SettingTextVersionView njl;
    private TbSettingTextTipView njm;
    private TbSettingTextTipView njn;
    private TbSettingTextNewDotView njo;
    private TextView njp;
    private RelativeLayout njq;
    private View njr;
    private View njs;
    private View njt;
    private View nju;
    private View njv;
    private View njw;
    private View njx;
    private RelativeLayout njy;
    private BdSwitchView njz;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.njt = null;
        this.nju = null;
        this.njv = null;
        this.njw = null;
        this.njx = null;
        this.njy = null;
        this.njz = null;
        this.njA = null;
        this.njB = null;
        this.niY = moreActivity;
        this.niZ = dVar;
        this.niY.setContentView(R.layout.more_activity);
        bzH();
        dHG();
    }

    public void dHE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.njd.setVisibility(8);
        } else {
            this.njd.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.njd != null) {
                this.njd.dIN();
                return;
            }
            return;
        }
        this.njd.dIO();
        this.njd.setIcon(str, z);
    }

    public void dHF() {
        if (this.njl != null) {
            this.njl.refresh();
        }
        if (this.njo != null) {
            this.njo.refresh();
        }
    }

    public void dHG() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.njz.turnOn();
        } else {
            this.njz.turnOff();
        }
    }

    public void IO(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "1").dR("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "0").dR("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dGF() {
        this.njd.recycle();
        this.nje.recycle();
        this.njf.recycle();
        this.njg.recycle();
        this.njh.recycle();
        this.njj.recycle();
        this.njk.recycle();
        this.njl.recycle();
        this.njm.recycle();
        this.njn.recycle();
    }

    public void onChangeSkinType(int i) {
        qK(i);
        if (this.njb != null) {
            this.niY.getLayoutMode().setNightMode(i == 1);
            this.niY.getLayoutMode().onModeChanged(this.njb.getView());
        }
        if (i == 1) {
            this.njz.turnOnNoCallback();
        } else {
            this.njz.turnOffNoCallback();
        }
    }

    public void qK(int i) {
        ap.setBackgroundColor(this.njq, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.njd.qK(i);
        this.niY.getLayoutMode().setNightMode(i == 1);
        this.niY.getLayoutMode().onModeChanged(this.njq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dHF();
        this.njz.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.njB.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.njr, R.color.CAM_X0201);
        this.njc.setLocalIcon(ap.oB(R.drawable.icon_mine_list_baidu));
        if (this.njb != null) {
            this.njb.onChangeSkinType();
        }
        this.njc.qK(i);
        this.njd.qK(i);
        this.nje.onChangeSkinType(i);
        this.njf.onChangeSkinType(i);
        this.njg.onChangeSkinType(i);
        this.njh.onChangeSkinType(i);
        this.nji.onChangeSkinType(i);
        this.njj.onChangeSkinType(i);
        this.njk.onChangeSkinType(i);
        this.njl.onChangeSkinType(i);
        this.njm.onChangeSkinType(i);
        this.njn.onChangeSkinType(i);
        this.njo.onChangeSkinType(i);
    }

    private void bzH() {
        View.OnClickListener clickListener = getClickListener();
        this.njq = (RelativeLayout) this.niY.findViewById(R.id.parent);
        this.njr = this.niY.findViewById(R.id.scroll);
        this.niY.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.niY.findViewById(R.id.view_navigation_bar);
        this.njs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.niY.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.njc = (SettingTextNormalImageView) this.niY.findViewById(R.id.accountSafeSetting);
        this.njd = (SettingTextImageView) this.niY.findViewById(R.id.personInfo);
        this.nje = (TbSettingTextTipView) this.niY.findViewById(R.id.interest_label_setting);
        this.nje.setTopLineVisibility(true);
        this.njf = (TbSettingTextTipView) this.niY.findViewById(R.id.accountManager);
        this.njf.setTopLineVisibility(true);
        this.njg = (TbSettingTextTipView) this.niY.findViewById(R.id.browseSetting);
        this.njg.setBottomLineVisibility(true);
        this.njh = (TbSettingTextTipView) this.niY.findViewById(R.id.youngsterSetting);
        this.njh.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bJj()) {
            this.njh.setTip(this.niY.getString(R.string.youngster_settings_tip_open));
        } else {
            this.njh.setTip(this.niY.getString(R.string.youngster_settings_tip_close));
        }
        this.nji = (TbSettingTextTipView) this.niY.findViewById(R.id.adSetting);
        this.nji.setBottomLineVisibility(true);
        this.njj = (TbSettingTextTipView) this.niY.findViewById(R.id.messageSetting);
        this.njj.setBottomLineVisibility(true);
        this.njg.setBottomLineVisibility(true);
        this.njk = (TbSettingTextTipView) this.niY.findViewById(R.id.secretSetting);
        this.njk.setBottomLineVisibility(true);
        this.njl = (SettingTextVersionView) this.niY.findViewById(R.id.versionInfo);
        this.njm = (TbSettingTextTipView) this.niY.findViewById(R.id.feedBack);
        this.njm.setTopLineVisibility(true);
        this.njm.setBottomLineVisibility(true);
        this.njn = (TbSettingTextTipView) this.niY.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.njn.setVisibility(8);
            this.njn.setBottomLineVisibility(false);
        } else {
            this.njn.setVisibility(0);
            this.njn.setBottomLineVisibility(true);
        }
        this.njo = (TbSettingTextNewDotView) this.niY.findViewById(R.id.systemhelpsetting);
        this.njp = (TextView) this.niY.findViewById(R.id.quit);
        this.njy = (RelativeLayout) this.niY.findViewById(R.id.eyeshield_mode);
        this.njz = (BdSwitchView) this.niY.findViewById(R.id.item_switch);
        l.addToParentArea(this.niY.getPageContext().getPageActivity(), this.njz, 10, 10, 10, 10);
        this.njA = (RelativeLayout) this.niY.findViewById(R.id.follow_system_day_night_mode);
        this.njB = (BdSwitchView) this.niY.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.niY.getPageContext().getPageActivity(), this.njB, 10, 10, 10, 10);
        this.njt = this.niY.findViewById(R.id.divide_view2);
        this.nju = this.niY.findViewById(R.id.divide_view1);
        this.njv = this.niY.findViewById(R.id.divide_view3);
        this.njw = this.niY.findViewById(R.id.divide_view4);
        this.njx = this.niY.findViewById(R.id.divide_view5);
        dHF();
        dHE();
        this.njd.dIN();
        qK(TbadkCoreApplication.getInst().getSkinType());
        this.nju.setVisibility(0);
        this.njv.setVisibility(0);
        this.njw.setVisibility(0);
        this.njx.setVisibility(0);
        ah(clickListener);
        if (!dHH()) {
            this.njg.setTip(this.niY.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.njt.setVisibility(8);
            this.njy.setVisibility(8);
        } else {
            this.njt.setVisibility(0);
            this.njy.setVisibility(0);
        }
        this.njA.setVisibility(dHI() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_is_follow_system_mode", false)) {
            this.njB.turnOnNoCallback();
        } else {
            this.njB.turnOffNoCallback();
        }
    }

    private boolean dHH() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dHI() {
        if (dHH()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void aqj() {
        this.njb = new k(getPageContext().getPageActivity());
        this.njb.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.njb);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.niY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.niY.getLayoutMode().onModeChanged(this.njb.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.FD();
                    e.this.niZ.IJ(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.FD();
            }
        };
        this.njb.bw(arrayList);
        this.njb.a(cVar);
        this.njb.a(aVar);
        this.nja = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.nja.setCanceledOnTouchOutside(true);
        this.nja.a(this.njb);
    }

    private void ah(View.OnClickListener onClickListener) {
        this.njc.setOnClickListener(onClickListener);
        this.njs.setOnClickListener(onClickListener);
        this.njd.setOnClickListener(onClickListener);
        this.nje.setOnClickListener(onClickListener);
        this.njf.setOnClickListener(onClickListener);
        this.njg.setOnClickListener(onClickListener);
        this.njh.setOnClickListener(onClickListener);
        this.nji.setOnClickListener(onClickListener);
        this.njj.setOnClickListener(onClickListener);
        this.njk.setOnClickListener(onClickListener);
        this.njl.setOnClickListener(onClickListener);
        this.njm.setOnClickListener(onClickListener);
        this.njn.setOnClickListener(onClickListener);
        this.njo.setOnClickListener(onClickListener);
        this.njp.setOnClickListener(onClickListener);
        this.njz.setOnSwitchStateChangeListener(this.niY);
        this.njB.setOnSwitchStateChangeListener(this.niY);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.njs) {
                    e.this.niZ.IJ(0);
                } else if (view == e.this.njd) {
                    e.this.niZ.IJ(1);
                } else if (view == e.this.nje) {
                    e.this.niZ.IJ(15);
                } else if (view == e.this.njf) {
                    e.this.niZ.IJ(2);
                } else if (view == e.this.njg) {
                    e.this.niZ.IJ(3);
                } else if (view == e.this.njh) {
                    e.this.niZ.IJ(17);
                } else if (view == e.this.njj) {
                    e.this.niZ.IJ(4);
                } else if (view == e.this.njk) {
                    e.this.niZ.IJ(9);
                } else if (view == e.this.njl) {
                    e.this.niZ.IJ(6);
                } else if (view == e.this.njm) {
                    e.this.niZ.IJ(7);
                } else if (view == e.this.njn) {
                    e.this.niZ.IJ(8);
                } else if (view == e.this.njo) {
                    e.this.niZ.IJ(5);
                } else if (view == e.this.njp) {
                    e.this.niZ.IJ(10);
                } else if (view == e.this.njc) {
                    e.this.niZ.IJ(13);
                } else if (view == e.this.nji) {
                    e.this.niZ.IJ(16);
                }
            }
        };
    }

    public void dHJ() {
        if (this.nja == null) {
            aqj();
        }
        this.nja.QH();
    }

    public void FD() {
        if (this.nja != null) {
            this.nja.dismiss();
        }
    }

    public BdSwitchView dHK() {
        return this.njz;
    }

    public BdSwitchView dHL() {
        return this.njB;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.niY).areNotificationsEnabled();
        if (this.njj != null) {
            this.njj.setTipViewColor(R.color.CAM_X0105);
            this.njj.setTip(areNotificationsEnabled ? "" : this.niY.getString(R.string.may_lose_important_msg));
        }
    }
}
