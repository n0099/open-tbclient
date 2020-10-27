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
/* loaded from: classes26.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private TbSettingTextTipView mBA;
    private SettingTextVersionView mBB;
    private TbSettingTextTipView mBC;
    private TbSettingTextTipView mBD;
    private TbSettingTextNewDotView mBE;
    private TextView mBF;
    private RelativeLayout mBG;
    private View mBH;
    private View mBI;
    private View mBJ;
    private View mBK;
    private View mBL;
    private View mBM;
    private View mBN;
    private RelativeLayout mBO;
    private BdSwitchView mBP;
    private RelativeLayout mBQ;
    private BdSwitchView mBR;
    private MoreActivity mBo;
    private d mBp;
    private com.baidu.tbadk.core.dialog.i mBq;
    private k mBr;
    private SettingTextNormalImageView mBs;
    private SettingTextImageView mBt;
    private TbSettingTextTipView mBu;
    private TbSettingTextTipView mBv;
    private TbSettingTextTipView mBw;
    private TbSettingTextTipView mBx;
    private TbSettingTextTipView mBy;
    private TbSettingTextTipView mBz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.mBJ = null;
        this.mBK = null;
        this.mBL = null;
        this.mBM = null;
        this.mBN = null;
        this.mBO = null;
        this.mBP = null;
        this.mBQ = null;
        this.mBR = null;
        this.mBo = moreActivity;
        this.mBp = dVar;
        this.mBo.setContentView(R.layout.more_activity);
        bvw();
        dBO();
    }

    public void dBM() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mBt.setVisibility(8);
        } else {
            this.mBt.setVisibility(0);
        }
    }

    public void bb(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.mBt != null) {
                this.mBt.dCV();
                return;
            }
            return;
        }
        this.mBt.dCW();
        this.mBt.setIcon(str, z);
    }

    public void dBN() {
        if (this.mBB != null) {
            this.mBB.refresh();
        }
        if (this.mBE != null) {
            this.mBE.refresh();
        }
    }

    public void dBO() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mBP.turnOn();
        } else {
            this.mBP.turnOff();
        }
    }

    public void Iy(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "1").dR("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "0").dR("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dAN() {
        this.mBt.recycle();
        this.mBu.recycle();
        this.mBv.recycle();
        this.mBw.recycle();
        this.mBx.recycle();
        this.mBz.recycle();
        this.mBA.recycle();
        this.mBB.recycle();
        this.mBC.recycle();
        this.mBD.recycle();
    }

    public void onChangeSkinType(int i) {
        qP(i);
        if (this.mBr != null) {
            this.mBo.getLayoutMode().setNightMode(i == 1);
            this.mBo.getLayoutMode().onModeChanged(this.mBr.getView());
        }
        if (i == 1) {
            this.mBP.turnOnNoCallback();
        } else {
            this.mBP.turnOffNoCallback();
        }
    }

    public void qP(int i) {
        ap.setBackgroundColor(this.mBG, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mBt.qP(i);
        this.mBo.getLayoutMode().setNightMode(i == 1);
        this.mBo.getLayoutMode().onModeChanged(this.mBG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dBN();
        this.mBP.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mBR.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.mBH, R.color.cp_bg_line_d);
        this.mBs.setLocalIcon(ap.oM(R.drawable.icon_mine_list_baidu));
        if (this.mBr != null) {
            this.mBr.onChangeSkinType();
        }
        this.mBs.qP(i);
        this.mBt.qP(i);
        this.mBu.onChangeSkinType(i);
        this.mBv.onChangeSkinType(i);
        this.mBw.onChangeSkinType(i);
        this.mBx.onChangeSkinType(i);
        this.mBy.onChangeSkinType(i);
        this.mBz.onChangeSkinType(i);
        this.mBA.onChangeSkinType(i);
        this.mBB.onChangeSkinType(i);
        this.mBC.onChangeSkinType(i);
        this.mBD.onChangeSkinType(i);
        this.mBE.onChangeSkinType(i);
    }

    private void bvw() {
        View.OnClickListener clickListener = getClickListener();
        this.mBG = (RelativeLayout) this.mBo.findViewById(R.id.parent);
        this.mBH = this.mBo.findViewById(R.id.scroll);
        this.mBo.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.mBo.findViewById(R.id.view_navigation_bar);
        this.mBI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mBo.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.mBs = (SettingTextNormalImageView) this.mBo.findViewById(R.id.accountSafeSetting);
        this.mBt = (SettingTextImageView) this.mBo.findViewById(R.id.personInfo);
        this.mBu = (TbSettingTextTipView) this.mBo.findViewById(R.id.interest_label_setting);
        this.mBu.setTopLineVisibility(true);
        this.mBv = (TbSettingTextTipView) this.mBo.findViewById(R.id.accountManager);
        this.mBv.setTopLineVisibility(true);
        this.mBw = (TbSettingTextTipView) this.mBo.findViewById(R.id.browseSetting);
        this.mBw.setBottomLineVisibility(true);
        this.mBx = (TbSettingTextTipView) this.mBo.findViewById(R.id.youngsterSetting);
        this.mBx.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bET()) {
            this.mBx.setTip(this.mBo.getString(R.string.youngster_settings_tip_open));
        } else {
            this.mBx.setTip(this.mBo.getString(R.string.youngster_settings_tip_close));
        }
        this.mBy = (TbSettingTextTipView) this.mBo.findViewById(R.id.adSetting);
        this.mBy.setBottomLineVisibility(true);
        this.mBz = (TbSettingTextTipView) this.mBo.findViewById(R.id.messageSetting);
        this.mBz.setBottomLineVisibility(true);
        this.mBw.setBottomLineVisibility(true);
        this.mBA = (TbSettingTextTipView) this.mBo.findViewById(R.id.secretSetting);
        this.mBA.setBottomLineVisibility(true);
        this.mBB = (SettingTextVersionView) this.mBo.findViewById(R.id.versionInfo);
        this.mBC = (TbSettingTextTipView) this.mBo.findViewById(R.id.feedBack);
        this.mBC.setTopLineVisibility(true);
        this.mBC.setBottomLineVisibility(true);
        this.mBD = (TbSettingTextTipView) this.mBo.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.mBD.setVisibility(8);
            this.mBD.setBottomLineVisibility(false);
        } else {
            this.mBD.setVisibility(0);
            this.mBD.setBottomLineVisibility(true);
        }
        this.mBE = (TbSettingTextNewDotView) this.mBo.findViewById(R.id.systemhelpsetting);
        this.mBF = (TextView) this.mBo.findViewById(R.id.quit);
        this.mBO = (RelativeLayout) this.mBo.findViewById(R.id.eyeshield_mode);
        this.mBP = (BdSwitchView) this.mBo.findViewById(R.id.item_switch);
        l.addToParentArea(this.mBo.getPageContext().getPageActivity(), this.mBP, 10, 10, 10, 10);
        this.mBQ = (RelativeLayout) this.mBo.findViewById(R.id.follow_system_day_night_mode);
        this.mBR = (BdSwitchView) this.mBo.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.mBo.getPageContext().getPageActivity(), this.mBR, 10, 10, 10, 10);
        this.mBJ = this.mBo.findViewById(R.id.divide_view2);
        this.mBK = this.mBo.findViewById(R.id.divide_view1);
        this.mBL = this.mBo.findViewById(R.id.divide_view3);
        this.mBM = this.mBo.findViewById(R.id.divide_view4);
        this.mBN = this.mBo.findViewById(R.id.divide_view5);
        dBN();
        dBM();
        this.mBt.dCV();
        qP(TbadkCoreApplication.getInst().getSkinType());
        this.mBK.setVisibility(0);
        this.mBL.setVisibility(0);
        this.mBM.setVisibility(0);
        this.mBN.setVisibility(0);
        ad(clickListener);
        if (!dBP()) {
            this.mBw.setTip(this.mBo.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.mBJ.setVisibility(8);
            this.mBO.setVisibility(8);
        } else {
            this.mBJ.setVisibility(0);
            this.mBO.setVisibility(0);
        }
        this.mBQ.setVisibility(dBQ() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_is_follow_system_mode", false)) {
            this.mBR.turnOnNoCallback();
        } else {
            this.mBR.turnOffNoCallback();
        }
    }

    private boolean dBP() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dBQ() {
        if (dBP()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void ank() {
        this.mBr = new k(getPageContext().getPageActivity());
        this.mBr.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.mBr);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.mBo.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mBo.getLayoutMode().onModeChanged(this.mBr.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.GU();
                    e.this.mBp.It(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.GU();
            }
        };
        this.mBr.bk(arrayList);
        this.mBr.a(cVar);
        this.mBr.a(aVar);
        this.mBq = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.mBq.setCanceledOnTouchOutside(true);
        this.mBq.a(this.mBr);
    }

    private void ad(View.OnClickListener onClickListener) {
        this.mBs.setOnClickListener(onClickListener);
        this.mBI.setOnClickListener(onClickListener);
        this.mBt.setOnClickListener(onClickListener);
        this.mBu.setOnClickListener(onClickListener);
        this.mBv.setOnClickListener(onClickListener);
        this.mBw.setOnClickListener(onClickListener);
        this.mBx.setOnClickListener(onClickListener);
        this.mBy.setOnClickListener(onClickListener);
        this.mBz.setOnClickListener(onClickListener);
        this.mBA.setOnClickListener(onClickListener);
        this.mBB.setOnClickListener(onClickListener);
        this.mBC.setOnClickListener(onClickListener);
        this.mBD.setOnClickListener(onClickListener);
        this.mBE.setOnClickListener(onClickListener);
        this.mBF.setOnClickListener(onClickListener);
        this.mBP.setOnSwitchStateChangeListener(this.mBo);
        this.mBR.setOnSwitchStateChangeListener(this.mBo);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.mBI) {
                    e.this.mBp.It(0);
                } else if (view == e.this.mBt) {
                    e.this.mBp.It(1);
                } else if (view == e.this.mBu) {
                    e.this.mBp.It(15);
                } else if (view == e.this.mBv) {
                    e.this.mBp.It(2);
                } else if (view == e.this.mBw) {
                    e.this.mBp.It(3);
                } else if (view == e.this.mBx) {
                    e.this.mBp.It(17);
                } else if (view == e.this.mBz) {
                    e.this.mBp.It(4);
                } else if (view == e.this.mBA) {
                    e.this.mBp.It(9);
                } else if (view == e.this.mBB) {
                    e.this.mBp.It(6);
                } else if (view == e.this.mBC) {
                    e.this.mBp.It(7);
                } else if (view == e.this.mBD) {
                    e.this.mBp.It(8);
                } else if (view == e.this.mBE) {
                    e.this.mBp.It(5);
                } else if (view == e.this.mBF) {
                    e.this.mBp.It(10);
                } else if (view == e.this.mBs) {
                    e.this.mBp.It(13);
                } else if (view == e.this.mBy) {
                    e.this.mBp.It(16);
                }
            }
        };
    }

    public void dBR() {
        if (this.mBq == null) {
            ank();
        }
        this.mBq.PJ();
    }

    public void GU() {
        if (this.mBq != null) {
            this.mBq.dismiss();
        }
    }

    public BdSwitchView dBS() {
        return this.mBP;
    }

    public BdSwitchView dBT() {
        return this.mBR;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mBo).areNotificationsEnabled();
        if (this.mBz != null) {
            this.mBz.setTipViewColor(R.color.cp_cont_b);
            this.mBz.setTip(areNotificationsEnabled ? "" : this.mBo.getString(R.string.may_lose_important_msg));
        }
    }
}
