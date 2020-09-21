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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private View lZA;
    private View lZB;
    private View lZC;
    private View lZD;
    private View lZE;
    private View lZF;
    private RelativeLayout lZG;
    private BdSwitchView lZH;
    private RelativeLayout lZI;
    private BdSwitchView lZJ;
    private MoreActivity lZg;
    private d lZh;
    private com.baidu.tbadk.core.dialog.i lZi;
    private k lZj;
    private SettingTextNormalImageView lZk;
    private SettingTextImageView lZl;
    private TbSettingTextTipView lZm;
    private TbSettingTextTipView lZn;
    private TbSettingTextTipView lZo;
    private TbSettingTextTipView lZp;
    private TbSettingTextTipView lZq;
    private TbSettingTextTipView lZr;
    private TbSettingTextTipView lZs;
    private SettingTextVersionView lZt;
    private TbSettingTextTipView lZu;
    private TbSettingTextTipView lZv;
    private TbSettingTextNewDotView lZw;
    private TextView lZx;
    private RelativeLayout lZy;
    private View lZz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.lZB = null;
        this.lZC = null;
        this.lZD = null;
        this.lZE = null;
        this.lZF = null;
        this.lZG = null;
        this.lZH = null;
        this.lZI = null;
        this.lZJ = null;
        this.lZg = moreActivity;
        this.lZh = dVar;
        this.lZg.setContentView(R.layout.more_activity);
        bqT();
        duV();
    }

    public void duT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lZl.setVisibility(8);
        } else {
            this.lZl.setVisibility(0);
        }
    }

    public void aV(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.lZl != null) {
                this.lZl.dwc();
                return;
            }
            return;
        }
        this.lZl.dwd();
        this.lZl.setIcon(str, z);
    }

    public void duU() {
        if (this.lZt != null) {
            this.lZt.refresh();
        }
        if (this.lZw != null) {
            this.lZw.refresh();
        }
    }

    public void duV() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lZH.turnOn();
        } else {
            this.lZH.turnOff();
        }
    }

    public void Hz(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dF("obj_type", "1").dF("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dF("obj_type", "0").dF("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dtU() {
        this.lZl.recycle();
        this.lZm.recycle();
        this.lZn.recycle();
        this.lZo.recycle();
        this.lZp.recycle();
        this.lZr.recycle();
        this.lZs.recycle();
        this.lZt.recycle();
        this.lZu.recycle();
        this.lZv.recycle();
    }

    public void onChangeSkinType(int i) {
        qg(i);
        if (this.lZj != null) {
            this.lZg.getLayoutMode().setNightMode(i == 1);
            this.lZg.getLayoutMode().onModeChanged(this.lZj.getView());
        }
        if (i == 1) {
            this.lZH.turnOnNoCallback();
        } else {
            this.lZH.turnOffNoCallback();
        }
    }

    public void qg(int i) {
        ap.setBackgroundColor(this.lZy, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lZl.qg(i);
        this.lZg.getLayoutMode().setNightMode(i == 1);
        this.lZg.getLayoutMode().onModeChanged(this.lZy);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        duU();
        this.lZH.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.lZJ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.lZz, R.color.cp_bg_line_d);
        this.lZk.setLocalIcon(ap.oe(R.drawable.icon_mine_list_baidu));
        if (this.lZj != null) {
            this.lZj.onChangeSkinType();
        }
        this.lZk.qg(i);
        this.lZl.qg(i);
        this.lZm.onChangeSkinType(i);
        this.lZn.onChangeSkinType(i);
        this.lZo.onChangeSkinType(i);
        this.lZp.onChangeSkinType(i);
        this.lZq.onChangeSkinType(i);
        this.lZr.onChangeSkinType(i);
        this.lZs.onChangeSkinType(i);
        this.lZt.onChangeSkinType(i);
        this.lZu.onChangeSkinType(i);
        this.lZv.onChangeSkinType(i);
        this.lZw.onChangeSkinType(i);
    }

    private void bqT() {
        View.OnClickListener clickListener = getClickListener();
        this.lZy = (RelativeLayout) this.lZg.findViewById(R.id.parent);
        this.lZz = this.lZg.findViewById(R.id.scroll);
        this.lZg.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.lZg.findViewById(R.id.view_navigation_bar);
        this.lZA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lZg.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.lZk = (SettingTextNormalImageView) this.lZg.findViewById(R.id.accountSafeSetting);
        this.lZl = (SettingTextImageView) this.lZg.findViewById(R.id.personInfo);
        this.lZm = (TbSettingTextTipView) this.lZg.findViewById(R.id.interest_label_setting);
        this.lZm.setTopLineVisibility(true);
        this.lZn = (TbSettingTextTipView) this.lZg.findViewById(R.id.accountManager);
        this.lZn.setTopLineVisibility(true);
        this.lZo = (TbSettingTextTipView) this.lZg.findViewById(R.id.browseSetting);
        this.lZo.setBottomLineVisibility(true);
        this.lZp = (TbSettingTextTipView) this.lZg.findViewById(R.id.youngsterSetting);
        this.lZp.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.b.bAo()) {
            this.lZp.setTip(this.lZg.getString(R.string.youngster_settings_tip_open));
        } else {
            this.lZp.setTip(this.lZg.getString(R.string.youngster_settings_tip_close));
        }
        this.lZq = (TbSettingTextTipView) this.lZg.findViewById(R.id.adSetting);
        this.lZq.setBottomLineVisibility(true);
        this.lZr = (TbSettingTextTipView) this.lZg.findViewById(R.id.messageSetting);
        this.lZr.setBottomLineVisibility(true);
        this.lZo.setBottomLineVisibility(true);
        this.lZs = (TbSettingTextTipView) this.lZg.findViewById(R.id.secretSetting);
        this.lZs.setBottomLineVisibility(true);
        this.lZt = (SettingTextVersionView) this.lZg.findViewById(R.id.versionInfo);
        this.lZu = (TbSettingTextTipView) this.lZg.findViewById(R.id.feedBack);
        this.lZu.setTopLineVisibility(true);
        this.lZu.setBottomLineVisibility(true);
        this.lZv = (TbSettingTextTipView) this.lZg.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.lZv.setVisibility(8);
            this.lZv.setBottomLineVisibility(false);
        } else {
            this.lZv.setVisibility(0);
            this.lZv.setBottomLineVisibility(true);
        }
        this.lZw = (TbSettingTextNewDotView) this.lZg.findViewById(R.id.systemhelpsetting);
        this.lZx = (TextView) this.lZg.findViewById(R.id.quit);
        this.lZG = (RelativeLayout) this.lZg.findViewById(R.id.eyeshield_mode);
        this.lZH = (BdSwitchView) this.lZg.findViewById(R.id.item_switch);
        l.addToParentArea(this.lZg.getPageContext().getPageActivity(), this.lZH, 10, 10, 10, 10);
        this.lZI = (RelativeLayout) this.lZg.findViewById(R.id.follow_system_day_night_mode);
        this.lZJ = (BdSwitchView) this.lZg.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.lZg.getPageContext().getPageActivity(), this.lZJ, 10, 10, 10, 10);
        this.lZB = this.lZg.findViewById(R.id.divide_view2);
        this.lZC = this.lZg.findViewById(R.id.divide_view1);
        this.lZD = this.lZg.findViewById(R.id.divide_view3);
        this.lZE = this.lZg.findViewById(R.id.divide_view4);
        this.lZF = this.lZg.findViewById(R.id.divide_view5);
        duU();
        duT();
        this.lZl.dwc();
        qg(TbadkCoreApplication.getInst().getSkinType());
        this.lZC.setVisibility(0);
        this.lZD.setVisibility(0);
        this.lZE.setVisibility(0);
        this.lZF.setVisibility(0);
        ad(clickListener);
        if (!duW()) {
            this.lZo.setTip(this.lZg.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.lZB.setVisibility(8);
            this.lZG.setVisibility(8);
        } else {
            this.lZB.setVisibility(0);
            this.lZG.setVisibility(0);
        }
        this.lZI.setVisibility(duX() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_is_follow_system_mode", false)) {
            this.lZJ.turnOnNoCallback();
        } else {
            this.lZJ.turnOffNoCallback();
        }
    }

    private boolean duW() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean duX() {
        if (duW()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void aiF() {
        this.lZj = new k(getPageContext().getPageActivity());
        this.lZj.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.lZj);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.lZg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lZg.getLayoutMode().onModeChanged(this.lZj.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.FD();
                    e.this.lZh.Hu(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.FD();
            }
        };
        this.lZj.aX(arrayList);
        this.lZj.a(cVar);
        this.lZj.a(aVar);
        this.lZi = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.lZi.setCanceledOnTouchOutside(true);
        this.lZi.a(this.lZj);
    }

    private void ad(View.OnClickListener onClickListener) {
        this.lZk.setOnClickListener(onClickListener);
        this.lZA.setOnClickListener(onClickListener);
        this.lZl.setOnClickListener(onClickListener);
        this.lZm.setOnClickListener(onClickListener);
        this.lZn.setOnClickListener(onClickListener);
        this.lZo.setOnClickListener(onClickListener);
        this.lZp.setOnClickListener(onClickListener);
        this.lZq.setOnClickListener(onClickListener);
        this.lZr.setOnClickListener(onClickListener);
        this.lZs.setOnClickListener(onClickListener);
        this.lZt.setOnClickListener(onClickListener);
        this.lZu.setOnClickListener(onClickListener);
        this.lZv.setOnClickListener(onClickListener);
        this.lZw.setOnClickListener(onClickListener);
        this.lZx.setOnClickListener(onClickListener);
        this.lZH.setOnSwitchStateChangeListener(this.lZg);
        this.lZJ.setOnSwitchStateChangeListener(this.lZg);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.lZA) {
                    e.this.lZh.Hu(0);
                } else if (view == e.this.lZl) {
                    e.this.lZh.Hu(1);
                } else if (view == e.this.lZm) {
                    e.this.lZh.Hu(15);
                } else if (view == e.this.lZn) {
                    e.this.lZh.Hu(2);
                } else if (view == e.this.lZo) {
                    e.this.lZh.Hu(3);
                } else if (view == e.this.lZp) {
                    e.this.lZh.Hu(17);
                } else if (view == e.this.lZr) {
                    e.this.lZh.Hu(4);
                } else if (view == e.this.lZs) {
                    e.this.lZh.Hu(9);
                } else if (view == e.this.lZt) {
                    e.this.lZh.Hu(6);
                } else if (view == e.this.lZu) {
                    e.this.lZh.Hu(7);
                } else if (view == e.this.lZv) {
                    e.this.lZh.Hu(8);
                } else if (view == e.this.lZw) {
                    e.this.lZh.Hu(5);
                } else if (view == e.this.lZx) {
                    e.this.lZh.Hu(10);
                } else if (view == e.this.lZk) {
                    e.this.lZh.Hu(13);
                } else if (view == e.this.lZq) {
                    e.this.lZh.Hu(16);
                }
            }
        };
    }

    public void duY() {
        if (this.lZi == null) {
            aiF();
        }
        this.lZi.NY();
    }

    public void FD() {
        if (this.lZi != null) {
            this.lZi.dismiss();
        }
    }

    public BdSwitchView duZ() {
        return this.lZH;
    }

    public BdSwitchView dva() {
        return this.lZJ;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.lZg).areNotificationsEnabled();
        if (this.lZr != null) {
            this.lZr.setTipViewColor(R.color.cp_cont_b);
            this.lZr.setTip(areNotificationsEnabled ? "" : this.lZg.getString(R.string.may_lose_important_msg));
        }
    }
}
