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
import com.baidu.tbadk.core.dialog.i;
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
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity iTV;
    private d iTW;
    private i iTX;
    private k iTY;
    private SettingTextNormalImageView iTZ;
    private SettingTextImageView iUa;
    private TbSettingTextTipView iUb;
    private TbSettingTextTipView iUc;
    private TbSettingTextTipView iUd;
    private TbSettingTextTipView iUe;
    private TbSettingTextTipView iUf;
    private TbSettingTextTipView iUg;
    private SettingTextVersionView iUh;
    private TbSettingTextTipView iUi;
    private TbSettingTextTipView iUj;
    private TbSettingTextNewDotView iUk;
    private TextView iUl;
    private RelativeLayout iUm;
    private View iUn;
    private View iUo;
    private View iUp;
    private View iUq;
    private View iUr;
    private View iUs;
    private View iUt;
    private RelativeLayout iUu;
    private BdSwitchView iUv;
    private RelativeLayout iUw;
    private BdSwitchView iUx;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iUp = null;
        this.iUq = null;
        this.iUr = null;
        this.iUs = null;
        this.iUt = null;
        this.iUu = null;
        this.iUv = null;
        this.iUw = null;
        this.iUx = null;
        this.iTV = moreActivity;
        this.iTW = dVar;
        this.iTV.setContentView(R.layout.more_activity);
        asB();
        cjo();
    }

    public void cjm() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iUa.setVisibility(8);
        } else {
            this.iUa.setVisibility(0);
        }
    }

    public void au(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iUa != null) {
                this.iUa.ckp();
                return;
            }
            return;
        }
        this.iUa.ckq();
        this.iUa.setIcon(str, z);
    }

    public void cjn() {
        if (this.iUh != null) {
            this.iUh.refresh();
        }
        if (this.iUk != null) {
            this.iUk.refresh();
        }
    }

    public void cjo() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iUv.turnOn();
        } else {
            this.iUv.turnOff();
        }
    }

    public void yY(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).bS("obj_type", "1").bS("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).bS("obj_type", "0").bS("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void cir() {
        this.iUa.recycle();
        this.iUb.recycle();
        this.iUc.recycle();
        this.iUd.recycle();
        this.iUf.recycle();
        this.iUg.recycle();
        this.iUh.recycle();
        this.iUi.recycle();
        this.iUj.recycle();
    }

    public void onChangeSkinType(int i) {
        jz(i);
        if (this.iTY != null) {
            this.iTV.getLayoutMode().setNightMode(i == 1);
            this.iTV.getLayoutMode().onModeChanged(this.iTY.ala());
        }
        if (i == 1) {
            this.iUv.turnOnNoCallback();
        } else {
            this.iUv.turnOffNoCallback();
        }
    }

    public void jz(int i) {
        am.setBackgroundColor(this.iUm, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iUa.jz(i);
        this.iTV.getLayoutMode().setNightMode(i == 1);
        this.iTV.getLayoutMode().onModeChanged(this.iUm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cjn();
        this.iUv.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.iUx.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.iUn, R.color.cp_bg_line_d);
        this.iTZ.setLocalIcon(am.ir(R.drawable.icon_mine_list_baidu));
        if (this.iTY != null) {
            this.iTY.onChangeSkinType();
        }
    }

    private void asB() {
        View.OnClickListener clickListener = getClickListener();
        this.iUm = (RelativeLayout) this.iTV.findViewById(R.id.parent);
        this.iUn = this.iTV.findViewById(R.id.scroll);
        this.iTV.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iTV.findViewById(R.id.view_navigation_bar);
        this.iUo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iTV.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iTZ = (SettingTextNormalImageView) this.iTV.findViewById(R.id.accountSafeSetting);
        this.iUa = (SettingTextImageView) this.iTV.findViewById(R.id.personInfo);
        this.iUb = (TbSettingTextTipView) this.iTV.findViewById(R.id.interest_label_setting);
        this.iUb.setTopLineVisibility(true);
        this.iUc = (TbSettingTextTipView) this.iTV.findViewById(R.id.accountManager);
        this.iUc.setTopLineVisibility(true);
        this.iUd = (TbSettingTextTipView) this.iTV.findViewById(R.id.browseSetting);
        this.iUd.setBottomLineVisibility(true);
        this.iUe = (TbSettingTextTipView) this.iTV.findViewById(R.id.adSetting);
        this.iUe.setBottomLineVisibility(true);
        this.iUf = (TbSettingTextTipView) this.iTV.findViewById(R.id.messageSetting);
        this.iUf.setBottomLineVisibility(true);
        this.iUd.setBottomLineVisibility(true);
        this.iUg = (TbSettingTextTipView) this.iTV.findViewById(R.id.secretSetting);
        this.iUg.setBottomLineVisibility(true);
        this.iUh = (SettingTextVersionView) this.iTV.findViewById(R.id.versionInfo);
        this.iUi = (TbSettingTextTipView) this.iTV.findViewById(R.id.feedBack);
        this.iUi.setTopLineVisibility(true);
        this.iUi.setBottomLineVisibility(true);
        this.iUj = (TbSettingTextTipView) this.iTV.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iUj.setVisibility(8);
            this.iUj.setBottomLineVisibility(false);
        } else {
            this.iUj.setVisibility(0);
            this.iUj.setBottomLineVisibility(true);
        }
        this.iUk = (TbSettingTextNewDotView) this.iTV.findViewById(R.id.systemhelpsetting);
        this.iUl = (TextView) this.iTV.findViewById(R.id.quit);
        this.iUu = (RelativeLayout) this.iTV.findViewById(R.id.eyeshield_mode);
        this.iUv = (BdSwitchView) this.iTV.findViewById(R.id.item_switch);
        l.addToParentArea(this.iTV.getPageContext().getPageActivity(), this.iUv, 10, 10, 10, 10);
        this.iUw = (RelativeLayout) this.iTV.findViewById(R.id.follow_system_day_night_mode);
        this.iUx = (BdSwitchView) this.iTV.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.iTV.getPageContext().getPageActivity(), this.iUx, 10, 10, 10, 10);
        this.iUp = this.iTV.findViewById(R.id.divide_view2);
        this.iUq = this.iTV.findViewById(R.id.divide_view1);
        this.iUr = this.iTV.findViewById(R.id.divide_view3);
        this.iUs = this.iTV.findViewById(R.id.divide_view4);
        this.iUt = this.iTV.findViewById(R.id.divide_view5);
        cjn();
        cjm();
        this.iUa.ckp();
        jz(TbadkCoreApplication.getInst().getSkinType());
        this.iUq.setVisibility(0);
        this.iUr.setVisibility(0);
        this.iUs.setVisibility(0);
        this.iUt.setVisibility(0);
        aa(clickListener);
        if (!cjp()) {
            this.iUd.setTip(this.iTV.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iUp.setVisibility(8);
            this.iUu.setVisibility(8);
        } else {
            this.iUp.setVisibility(0);
            this.iUu.setVisibility(0);
        }
        this.iUw.setVisibility(cjq() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_is_follow_system_mode", false)) {
            this.iUx.turnOnNoCallback();
        } else {
            this.iUx.turnOffNoCallback();
        }
    }

    private boolean cjp() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cjq() {
        if (cjp()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void FT() {
        this.iTY = new k(getPageContext().getPageActivity());
        this.iTY.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iTY);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iTV.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iTV.getLayoutMode().onModeChanged(this.iTY.ala());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.aAk();
                    e.this.iTW.yT(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.aAk();
            }
        };
        this.iTY.at(arrayList);
        this.iTY.a(cVar);
        this.iTY.a(aVar);
        this.iTX = new i(this.mContext);
        this.iTX.setCanceledOnTouchOutside(true);
        this.iTX.a(this.iTY);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.iTZ.setOnClickListener(onClickListener);
        this.iUo.setOnClickListener(onClickListener);
        this.iUa.setOnClickListener(onClickListener);
        this.iUb.setOnClickListener(onClickListener);
        this.iUc.setOnClickListener(onClickListener);
        this.iUd.setOnClickListener(onClickListener);
        this.iUe.setOnClickListener(onClickListener);
        this.iUf.setOnClickListener(onClickListener);
        this.iUg.setOnClickListener(onClickListener);
        this.iUh.setOnClickListener(onClickListener);
        this.iUi.setOnClickListener(onClickListener);
        this.iUj.setOnClickListener(onClickListener);
        this.iUk.setOnClickListener(onClickListener);
        this.iUl.setOnClickListener(onClickListener);
        this.iUv.setOnSwitchStateChangeListener(this.iTV);
        this.iUx.setOnSwitchStateChangeListener(this.iTV);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iUo) {
                    e.this.iTW.yT(0);
                } else if (view == e.this.iUa) {
                    e.this.iTW.yT(1);
                } else if (view == e.this.iUb) {
                    e.this.iTW.yT(15);
                } else if (view == e.this.iUc) {
                    e.this.iTW.yT(2);
                } else if (view == e.this.iUd) {
                    e.this.iTW.yT(3);
                } else if (view == e.this.iUf) {
                    e.this.iTW.yT(4);
                } else if (view == e.this.iUg) {
                    e.this.iTW.yT(9);
                } else if (view == e.this.iUh) {
                    e.this.iTW.yT(6);
                } else if (view == e.this.iUi) {
                    e.this.iTW.yT(7);
                } else if (view == e.this.iUj) {
                    e.this.iTW.yT(8);
                } else if (view == e.this.iUk) {
                    e.this.iTW.yT(5);
                } else if (view == e.this.iUl) {
                    e.this.iTW.yT(10);
                } else if (view == e.this.iTZ) {
                    e.this.iTW.yT(13);
                } else if (view == e.this.iUe) {
                    e.this.iTW.yT(16);
                }
            }
        };
    }

    public void cjr() {
        if (this.iTX == null) {
            FT();
        }
        this.iTX.showDialog();
    }

    public void aAk() {
        if (this.iTX != null) {
            this.iTX.dismiss();
        }
    }

    public BdSwitchView cjs() {
        return this.iUv;
    }

    public BdSwitchView cjt() {
        return this.iUx;
    }
}
