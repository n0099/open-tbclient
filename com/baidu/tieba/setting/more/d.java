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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity gyE;
    private c gyF;
    private AlertDialog gyG;
    private View gyH;
    private TbSettingTextTipView gyI;
    private SettingTextImageView gyJ;
    private TbSettingTextTipView gyK;
    private TbSettingTextTipView gyL;
    private TbSettingTextTipView gyM;
    private MsgSettingItemView gyN;
    private TbSettingTextTipView gyO;
    private TbSettingTextTipView gyP;
    private SettingTextVersionView gyQ;
    private TbSettingTextTipView gyR;
    private TbSettingTextTipView gyS;
    private TbSettingTextNewDotView gyT;
    private TextView gyU;
    private RelativeLayout gyV;
    private View gyW;
    private View gyX;
    private View gyY;
    private View gyZ;
    private View gza;
    private View gzb;
    private View gzc;
    private RelativeLayout gzd;
    private BdSwitchView gze;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gyY = null;
        this.gyZ = null;
        this.gza = null;
        this.gzb = null;
        this.gzc = null;
        this.gzd = null;
        this.gze = null;
        this.gyE = moreActivity;
        this.gyF = cVar;
        this.gyE.setContentView(d.i.more_activity);
        FU();
        brD();
    }

    public void brB() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gyJ.setVisibility(8);
        } else {
            this.gyJ.setVisibility(0);
        }
    }

    public void T(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gyJ != null) {
                this.gyJ.bsE();
                return;
            }
            return;
        }
        this.gyJ.bsF();
        this.gyJ.setIcon(str, z);
    }

    public void brC() {
        if (this.gyQ != null) {
            this.gyQ.refresh();
        }
        if (this.gyT != null) {
            this.gyT.refresh();
        }
    }

    public void brD() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gze.mC();
        } else {
            this.gze.mD();
        }
    }

    public void sS(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an("c10647").ah("obj_type", "1").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an("c10647").ah("obj_type", "0").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bqF() {
        this.gyJ.recycle();
        this.gyK.recycle();
        this.gyL.recycle();
        this.gyM.recycle();
        this.gyO.recycle();
        this.gyP.recycle();
        this.gyQ.recycle();
        this.gyR.recycle();
        this.gyS.recycle();
    }

    public void onChangeSkinType(int i) {
        ev(i);
        if (this.gyH != null) {
            this.gyE.getLayoutMode().setNightMode(i == 1);
            this.gyE.getLayoutMode().onModeChanged(this.gyH);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ev(int i) {
        am.j(this.gyV, d.C0142d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gyJ.ev(i);
        this.gyE.getLayoutMode().setNightMode(i == 1);
        this.gyE.getLayoutMode().onModeChanged(this.gyV);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gyN.d(this.gyE.getPageContext(), i);
        brC();
        this.gze.setBackgroundRes(am.cR(d.f.bg_switch_open), am.cR(d.f.bg_switch_close), am.cR(d.f.btn_handle));
        am.j(this.gyW, d.C0142d.cp_bg_line_d);
    }

    private void FU() {
        View.OnClickListener clickListener = getClickListener();
        this.gyV = (RelativeLayout) this.gyE.findViewById(d.g.parent);
        this.gyW = this.gyE.findViewById(d.g.scroll);
        this.gyE.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gyE.findViewById(d.g.view_navigation_bar);
        this.gyX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gyE.getPageContext().getString(d.k.setup));
        this.mNavigationBar.showBottomLine();
        this.gyI = (TbSettingTextTipView) this.gyE.findViewById(d.g.accountSafeSetting);
        this.gyJ = (SettingTextImageView) this.gyE.findViewById(d.g.personInfo);
        this.gyK = (TbSettingTextTipView) this.gyE.findViewById(d.g.interest_label_setting);
        this.gyK.setTopLineVisibility(true);
        this.gyL = (TbSettingTextTipView) this.gyE.findViewById(d.g.accountManager);
        this.gyL.setTopLineVisibility(true);
        this.gyM = (TbSettingTextTipView) this.gyE.findViewById(d.g.browseSetting);
        this.gyM.setBottomLineVisibility(true);
        this.gyO = (TbSettingTextTipView) this.gyE.findViewById(d.g.messageSetting);
        this.gyO.setBottomLineVisibility(true);
        this.gyM.setBottomLineVisibility(true);
        this.gyP = (TbSettingTextTipView) this.gyE.findViewById(d.g.secretSetting);
        this.gyP.setBottomLineVisibility(true);
        this.gyQ = (SettingTextVersionView) this.gyE.findViewById(d.g.versionInfo);
        this.gyR = (TbSettingTextTipView) this.gyE.findViewById(d.g.feedBack);
        this.gyR.setTopLineVisibility(true);
        this.gyR.setBottomLineVisibility(true);
        this.gyS = (TbSettingTextTipView) this.gyE.findViewById(d.g.recommend);
        this.gyN = (MsgSettingItemView) this.gyE.findViewById(d.g.memberAdSetting);
        brE();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gyS.setVisibility(8);
            this.gyS.setBottomLineVisibility(false);
        } else {
            this.gyS.setVisibility(0);
            this.gyS.setBottomLineVisibility(true);
        }
        this.gyT = (TbSettingTextNewDotView) this.gyE.findViewById(d.g.systemhelpsetting);
        this.gyU = (TextView) this.gyE.findViewById(d.g.quit);
        this.gzd = (RelativeLayout) this.gyE.findViewById(d.g.eyeshield_mode);
        this.gze = (BdSwitchView) this.gyE.findViewById(d.g.item_switch);
        l.a(this.gyE.getPageContext().getPageActivity(), this.gze, 10, 10, 10, 10);
        this.gyY = this.gyE.findViewById(d.g.divide_view2);
        this.gyZ = this.gyE.findViewById(d.g.divide_view1);
        this.gza = this.gyE.findViewById(d.g.divide_view3);
        this.gzb = this.gyE.findViewById(d.g.divide_view4);
        this.gzc = this.gyE.findViewById(d.g.divide_view5);
        brC();
        brB();
        this.gyJ.bsE();
        ev(TbadkCoreApplication.getInst().getSkinType());
        this.gyZ.setVisibility(0);
        this.gza.setVisibility(0);
        this.gzb.setVisibility(0);
        this.gzc.setVisibility(0);
        V(clickListener);
        if (!brH()) {
            this.gyM.setTip(this.gyE.getResources().getString(d.k.browsing_settings_tip_no_night));
            this.gyY.setVisibility(8);
            this.gzd.setVisibility(8);
            return;
        }
        this.gyY.setVisibility(0);
        this.gzd.setVisibility(0);
    }

    private void brE() {
        int i;
        int i2 = 0;
        this.gyN.setText(d.k.member_ad_setting_text);
        this.gyN.setTipImageResource(d.f.label_red_svip);
        this.gyN.setOnSwitchStateChangeListener(this.gyE);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gyN.setVisibility(8);
        } else if (i2 == 0) {
            this.gyN.mB();
        } else {
            this.gyN.mA();
        }
    }

    public void brF() {
        this.gyN.mB();
    }

    public void brG() {
        this.gyN.mA();
    }

    private boolean brH() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void beH() {
        this.gyH = LayoutInflater.from(this.gyE.getPageContext().getPageActivity()).inflate(d.i.quit_dialog, (ViewGroup) null);
        this.gyE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gyE.getLayoutMode().onModeChanged(this.gyH);
        ((TextView) this.gyH.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Zr();
                d.this.gyF.sN(11);
            }
        });
        ((TextView) this.gyH.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Zr();
                d.this.gyF.sN(12);
            }
        });
        this.gyG = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gyG.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gyG, this.mContext.getPageActivity());
        if (this.gyG.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gyG.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gyG.getWindow().setAttributes(attributes);
            this.gyG.getWindow().setContentView(this.gyH);
        }
    }

    private void V(View.OnClickListener onClickListener) {
        this.gyI.setOnClickListener(onClickListener);
        this.gyX.setOnClickListener(onClickListener);
        this.gyJ.setOnClickListener(onClickListener);
        this.gyK.setOnClickListener(onClickListener);
        this.gyL.setOnClickListener(onClickListener);
        this.gyM.setOnClickListener(onClickListener);
        this.gyO.setOnClickListener(onClickListener);
        this.gyP.setOnClickListener(onClickListener);
        this.gyQ.setOnClickListener(onClickListener);
        this.gyR.setOnClickListener(onClickListener);
        this.gyS.setOnClickListener(onClickListener);
        this.gyT.setOnClickListener(onClickListener);
        this.gyU.setOnClickListener(onClickListener);
        this.gze.setOnSwitchStateChangeListener(this.gyE);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gyX) {
                    d.this.gyF.sN(0);
                } else if (view == d.this.gyJ) {
                    d.this.gyF.sN(1);
                } else if (view == d.this.gyK) {
                    d.this.gyF.sN(15);
                } else if (view == d.this.gyL) {
                    d.this.gyF.sN(2);
                } else if (view == d.this.gyM) {
                    d.this.gyF.sN(3);
                } else if (view == d.this.gyO) {
                    d.this.gyF.sN(4);
                } else if (view == d.this.gyP) {
                    d.this.gyF.sN(9);
                } else if (view == d.this.gyQ) {
                    d.this.gyF.sN(6);
                } else if (view == d.this.gyR) {
                    d.this.gyF.sN(7);
                } else if (view == d.this.gyS) {
                    d.this.gyF.sN(8);
                } else if (view == d.this.gyT) {
                    d.this.gyF.sN(5);
                } else if (view == d.this.gyU) {
                    d.this.gyF.sN(10);
                } else if (view == d.this.gyI) {
                    d.this.gyF.sN(13);
                }
            }
        };
    }

    public void brI() {
        if (this.gyG == null) {
            beH();
        }
        com.baidu.adp.lib.g.g.a(this.gyG, this.gyE.getPageContext());
    }

    public void Zr() {
        if (this.gyG != null) {
            com.baidu.adp.lib.g.g.b(this.gyG, this.gyE.getPageContext());
        }
    }

    public BdSwitchView brJ() {
        return this.gze;
    }
}
