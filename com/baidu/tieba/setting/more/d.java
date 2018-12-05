package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity gWM;
    private c gWN;
    private AlertDialog gWO;
    private View gWP;
    private TbSettingTextTipView gWQ;
    private SettingTextImageView gWR;
    private TbSettingTextTipView gWS;
    private TbSettingTextTipView gWT;
    private TbSettingTextTipView gWU;
    private MsgSettingItemView gWV;
    private TbSettingTextTipView gWW;
    private TbSettingTextTipView gWX;
    private SettingTextVersionView gWY;
    private TbSettingTextTipView gWZ;
    private TbSettingTextTipView gXa;
    private TbSettingTextNewDotView gXb;
    private TextView gXc;
    private RelativeLayout gXd;
    private View gXe;
    private View gXf;
    private View gXg;
    private View gXh;
    private View gXi;
    private View gXj;
    private View gXk;
    private RelativeLayout gXl;
    private BdSwitchView gXm;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gXg = null;
        this.gXh = null;
        this.gXi = null;
        this.gXj = null;
        this.gXk = null;
        this.gXl = null;
        this.gXm = null;
        this.gWM = moreActivity;
        this.gWN = cVar;
        this.gWM.setContentView(e.h.more_activity);
        Kx();
        bxo();
    }

    public void bxm() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gWR.setVisibility(8);
        } else {
            this.gWR.setVisibility(0);
        }
    }

    public void ac(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gWR != null) {
                this.gWR.byq();
                return;
            }
            return;
        }
        this.gWR.byr();
        this.gWR.setIcon(str, z);
    }

    public void bxn() {
        if (this.gWY != null) {
            this.gWY.refresh();
        }
        if (this.gXb != null) {
            this.gXb.refresh();
        }
    }

    public void bxo() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gXm.nR();
        } else {
            this.gXm.nS();
        }
    }

    public void uy(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").aA("obj_type", "1").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").aA("obj_type", "0").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bwv() {
        this.gWR.recycle();
        this.gWS.recycle();
        this.gWT.recycle();
        this.gWU.recycle();
        this.gWW.recycle();
        this.gWX.recycle();
        this.gWY.recycle();
        this.gWZ.recycle();
        this.gXa.recycle();
    }

    public void onChangeSkinType(int i) {
        fu(i);
        if (this.gWP != null) {
            this.gWM.getLayoutMode().setNightMode(i == 1);
            this.gWM.getLayoutMode().onModeChanged(this.gWP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void fu(int i) {
        al.j(this.gXd, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gWR.fu(i);
        this.gWM.getLayoutMode().setNightMode(i == 1);
        this.gWM.getLayoutMode().onModeChanged(this.gXd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gWV.d(this.gWM.getPageContext(), i);
        bxn();
        this.gXm.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this.gXe, e.d.cp_bg_line_d);
    }

    private void Kx() {
        View.OnClickListener clickListener = getClickListener();
        this.gXd = (RelativeLayout) this.gWM.findViewById(e.g.parent);
        this.gXe = this.gWM.findViewById(e.g.scroll);
        this.gWM.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gWM.findViewById(e.g.view_navigation_bar);
        this.gXf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gWM.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gWQ = (TbSettingTextTipView) this.gWM.findViewById(e.g.accountSafeSetting);
        this.gWR = (SettingTextImageView) this.gWM.findViewById(e.g.personInfo);
        this.gWS = (TbSettingTextTipView) this.gWM.findViewById(e.g.interest_label_setting);
        this.gWS.setTopLineVisibility(true);
        this.gWT = (TbSettingTextTipView) this.gWM.findViewById(e.g.accountManager);
        this.gWT.setTopLineVisibility(true);
        this.gWU = (TbSettingTextTipView) this.gWM.findViewById(e.g.browseSetting);
        this.gWU.setBottomLineVisibility(true);
        this.gWW = (TbSettingTextTipView) this.gWM.findViewById(e.g.messageSetting);
        this.gWW.setBottomLineVisibility(true);
        this.gWU.setBottomLineVisibility(true);
        this.gWX = (TbSettingTextTipView) this.gWM.findViewById(e.g.secretSetting);
        this.gWX.setBottomLineVisibility(true);
        this.gWY = (SettingTextVersionView) this.gWM.findViewById(e.g.versionInfo);
        this.gWZ = (TbSettingTextTipView) this.gWM.findViewById(e.g.feedBack);
        this.gWZ.setTopLineVisibility(true);
        this.gWZ.setBottomLineVisibility(true);
        this.gXa = (TbSettingTextTipView) this.gWM.findViewById(e.g.recommend);
        this.gWV = (MsgSettingItemView) this.gWM.findViewById(e.g.memberAdSetting);
        bxp();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gXa.setVisibility(8);
            this.gXa.setBottomLineVisibility(false);
        } else {
            this.gXa.setVisibility(0);
            this.gXa.setBottomLineVisibility(true);
        }
        this.gXb = (TbSettingTextNewDotView) this.gWM.findViewById(e.g.systemhelpsetting);
        this.gXc = (TextView) this.gWM.findViewById(e.g.quit);
        this.gXl = (RelativeLayout) this.gWM.findViewById(e.g.eyeshield_mode);
        this.gXm = (BdSwitchView) this.gWM.findViewById(e.g.item_switch);
        l.b(this.gWM.getPageContext().getPageActivity(), this.gXm, 10, 10, 10, 10);
        this.gXg = this.gWM.findViewById(e.g.divide_view2);
        this.gXh = this.gWM.findViewById(e.g.divide_view1);
        this.gXi = this.gWM.findViewById(e.g.divide_view3);
        this.gXj = this.gWM.findViewById(e.g.divide_view4);
        this.gXk = this.gWM.findViewById(e.g.divide_view5);
        bxn();
        bxm();
        this.gWR.byq();
        fu(TbadkCoreApplication.getInst().getSkinType());
        this.gXh.setVisibility(0);
        this.gXi.setVisibility(0);
        this.gXj.setVisibility(0);
        this.gXk.setVisibility(0);
        U(clickListener);
        if (!bxs()) {
            this.gWU.setTip(this.gWM.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.gXg.setVisibility(8);
            this.gXl.setVisibility(8);
            return;
        }
        this.gXg.setVisibility(0);
        this.gXl.setVisibility(0);
    }

    private void bxp() {
        int i;
        int i2 = 0;
        this.gWV.setText(e.j.member_ad_setting_text);
        this.gWV.setTipImageResource(e.f.label_red_svip);
        this.gWV.setOnSwitchStateChangeListener(this.gWM);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gWV.setVisibility(8);
        } else if (i2 == 0) {
            this.gWV.nQ();
        } else {
            this.gWV.nP();
        }
    }

    public void bxq() {
        this.gWV.nQ();
    }

    public void bxr() {
        this.gWV.nP();
    }

    private boolean bxs() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void createDialog() {
        this.gWP = LayoutInflater.from(this.gWM.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.gWM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gWM.getLayoutMode().onModeChanged(this.gWP);
        ((TextView) this.gWP.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Tb();
                d.this.gWN.ut(11);
            }
        });
        ((TextView) this.gWP.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Tb();
                d.this.gWN.ut(12);
            }
        });
        this.gWO = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gWO.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gWO, this.mContext.getPageActivity());
        if (this.gWO.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gWO.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gWO.getWindow().setAttributes(attributes);
            this.gWO.getWindow().setContentView(this.gWP);
        }
    }

    private void U(View.OnClickListener onClickListener) {
        this.gWQ.setOnClickListener(onClickListener);
        this.gXf.setOnClickListener(onClickListener);
        this.gWR.setOnClickListener(onClickListener);
        this.gWS.setOnClickListener(onClickListener);
        this.gWT.setOnClickListener(onClickListener);
        this.gWU.setOnClickListener(onClickListener);
        this.gWW.setOnClickListener(onClickListener);
        this.gWX.setOnClickListener(onClickListener);
        this.gWY.setOnClickListener(onClickListener);
        this.gWZ.setOnClickListener(onClickListener);
        this.gXa.setOnClickListener(onClickListener);
        this.gXb.setOnClickListener(onClickListener);
        this.gXc.setOnClickListener(onClickListener);
        this.gXm.setOnSwitchStateChangeListener(this.gWM);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gXf) {
                    d.this.gWN.ut(0);
                } else if (view == d.this.gWR) {
                    d.this.gWN.ut(1);
                } else if (view == d.this.gWS) {
                    d.this.gWN.ut(15);
                } else if (view == d.this.gWT) {
                    d.this.gWN.ut(2);
                } else if (view == d.this.gWU) {
                    d.this.gWN.ut(3);
                } else if (view == d.this.gWW) {
                    d.this.gWN.ut(4);
                } else if (view == d.this.gWX) {
                    d.this.gWN.ut(9);
                } else if (view == d.this.gWY) {
                    d.this.gWN.ut(6);
                } else if (view == d.this.gWZ) {
                    d.this.gWN.ut(7);
                } else if (view == d.this.gXa) {
                    d.this.gWN.ut(8);
                } else if (view == d.this.gXb) {
                    d.this.gWN.ut(5);
                } else if (view == d.this.gXc) {
                    d.this.gWN.ut(10);
                } else if (view == d.this.gWQ) {
                    d.this.gWN.ut(13);
                }
            }
        };
    }

    public void bxt() {
        if (this.gWO == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.g.a(this.gWO, this.gWM.getPageContext());
    }

    public void Tb() {
        if (this.gWO != null) {
            com.baidu.adp.lib.g.g.b(this.gWO, this.gWM.getPageContext());
        }
    }

    public BdSwitchView bxu() {
        return this.gXm;
    }
}
