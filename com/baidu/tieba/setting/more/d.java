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
    private View gOA;
    private TbSettingTextTipView gOB;
    private SettingTextImageView gOC;
    private TbSettingTextTipView gOD;
    private TbSettingTextTipView gOE;
    private TbSettingTextTipView gOF;
    private MsgSettingItemView gOG;
    private TbSettingTextTipView gOH;
    private TbSettingTextTipView gOI;
    private SettingTextVersionView gOJ;
    private TbSettingTextTipView gOK;
    private TbSettingTextTipView gOL;
    private TbSettingTextNewDotView gOM;
    private TextView gON;
    private RelativeLayout gOO;
    private View gOP;
    private View gOQ;
    private View gOR;
    private View gOS;
    private View gOT;
    private View gOU;
    private View gOV;
    private RelativeLayout gOW;
    private BdSwitchView gOX;
    private MoreActivity gOx;
    private c gOy;
    private AlertDialog gOz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gOR = null;
        this.gOS = null;
        this.gOT = null;
        this.gOU = null;
        this.gOV = null;
        this.gOW = null;
        this.gOX = null;
        this.gOx = moreActivity;
        this.gOy = cVar;
        this.gOx.setContentView(e.h.more_activity);
        Jh();
        bvZ();
    }

    public void bvX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gOC.setVisibility(8);
        } else {
            this.gOC.setVisibility(0);
        }
    }

    public void aa(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gOC != null) {
                this.gOC.bxb();
                return;
            }
            return;
        }
        this.gOC.bxc();
        this.gOC.setIcon(str, z);
    }

    public void bvY() {
        if (this.gOJ != null) {
            this.gOJ.refresh();
        }
        if (this.gOM != null) {
            this.gOM.refresh();
        }
    }

    public void bvZ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gOX.nU();
        } else {
            this.gOX.nV();
        }
    }

    public void tL(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").ax("obj_type", "1").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").ax("obj_type", "0").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bvg() {
        this.gOC.recycle();
        this.gOD.recycle();
        this.gOE.recycle();
        this.gOF.recycle();
        this.gOH.recycle();
        this.gOI.recycle();
        this.gOJ.recycle();
        this.gOK.recycle();
        this.gOL.recycle();
    }

    public void onChangeSkinType(int i) {
        eS(i);
        if (this.gOA != null) {
            this.gOx.getLayoutMode().setNightMode(i == 1);
            this.gOx.getLayoutMode().onModeChanged(this.gOA);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void eS(int i) {
        al.j(this.gOO, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOC.eS(i);
        this.gOx.getLayoutMode().setNightMode(i == 1);
        this.gOx.getLayoutMode().onModeChanged(this.gOO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOG.d(this.gOx.getPageContext(), i);
        bvY();
        this.gOX.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        al.j(this.gOP, e.d.cp_bg_line_d);
    }

    private void Jh() {
        View.OnClickListener clickListener = getClickListener();
        this.gOO = (RelativeLayout) this.gOx.findViewById(e.g.parent);
        this.gOP = this.gOx.findViewById(e.g.scroll);
        this.gOx.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gOx.findViewById(e.g.view_navigation_bar);
        this.gOQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gOx.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gOB = (TbSettingTextTipView) this.gOx.findViewById(e.g.accountSafeSetting);
        this.gOC = (SettingTextImageView) this.gOx.findViewById(e.g.personInfo);
        this.gOD = (TbSettingTextTipView) this.gOx.findViewById(e.g.interest_label_setting);
        this.gOD.setTopLineVisibility(true);
        this.gOE = (TbSettingTextTipView) this.gOx.findViewById(e.g.accountManager);
        this.gOE.setTopLineVisibility(true);
        this.gOF = (TbSettingTextTipView) this.gOx.findViewById(e.g.browseSetting);
        this.gOF.setBottomLineVisibility(true);
        this.gOH = (TbSettingTextTipView) this.gOx.findViewById(e.g.messageSetting);
        this.gOH.setBottomLineVisibility(true);
        this.gOF.setBottomLineVisibility(true);
        this.gOI = (TbSettingTextTipView) this.gOx.findViewById(e.g.secretSetting);
        this.gOI.setBottomLineVisibility(true);
        this.gOJ = (SettingTextVersionView) this.gOx.findViewById(e.g.versionInfo);
        this.gOK = (TbSettingTextTipView) this.gOx.findViewById(e.g.feedBack);
        this.gOK.setTopLineVisibility(true);
        this.gOK.setBottomLineVisibility(true);
        this.gOL = (TbSettingTextTipView) this.gOx.findViewById(e.g.recommend);
        this.gOG = (MsgSettingItemView) this.gOx.findViewById(e.g.memberAdSetting);
        bwa();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gOL.setVisibility(8);
            this.gOL.setBottomLineVisibility(false);
        } else {
            this.gOL.setVisibility(0);
            this.gOL.setBottomLineVisibility(true);
        }
        this.gOM = (TbSettingTextNewDotView) this.gOx.findViewById(e.g.systemhelpsetting);
        this.gON = (TextView) this.gOx.findViewById(e.g.quit);
        this.gOW = (RelativeLayout) this.gOx.findViewById(e.g.eyeshield_mode);
        this.gOX = (BdSwitchView) this.gOx.findViewById(e.g.item_switch);
        l.a(this.gOx.getPageContext().getPageActivity(), this.gOX, 10, 10, 10, 10);
        this.gOR = this.gOx.findViewById(e.g.divide_view2);
        this.gOS = this.gOx.findViewById(e.g.divide_view1);
        this.gOT = this.gOx.findViewById(e.g.divide_view3);
        this.gOU = this.gOx.findViewById(e.g.divide_view4);
        this.gOV = this.gOx.findViewById(e.g.divide_view5);
        bvY();
        bvX();
        this.gOC.bxb();
        eS(TbadkCoreApplication.getInst().getSkinType());
        this.gOS.setVisibility(0);
        this.gOT.setVisibility(0);
        this.gOU.setVisibility(0);
        this.gOV.setVisibility(0);
        S(clickListener);
        if (!bwd()) {
            this.gOF.setTip(this.gOx.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.gOR.setVisibility(8);
            this.gOW.setVisibility(8);
            return;
        }
        this.gOR.setVisibility(0);
        this.gOW.setVisibility(0);
    }

    private void bwa() {
        int i;
        int i2 = 0;
        this.gOG.setText(e.j.member_ad_setting_text);
        this.gOG.setTipImageResource(e.f.label_red_svip);
        this.gOG.setOnSwitchStateChangeListener(this.gOx);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gOG.setVisibility(8);
        } else if (i2 == 0) {
            this.gOG.nT();
        } else {
            this.gOG.nS();
        }
    }

    public void bwb() {
        this.gOG.nT();
    }

    public void bwc() {
        this.gOG.nS();
    }

    private boolean bwd() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void createDialog() {
        this.gOA = LayoutInflater.from(this.gOx.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.gOx.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gOx.getLayoutMode().onModeChanged(this.gOA);
        ((TextView) this.gOA.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.RM();
                d.this.gOy.tG(11);
            }
        });
        ((TextView) this.gOA.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.RM();
                d.this.gOy.tG(12);
            }
        });
        this.gOz = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gOz.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gOz, this.mContext.getPageActivity());
        if (this.gOz.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gOz.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gOz.getWindow().setAttributes(attributes);
            this.gOz.getWindow().setContentView(this.gOA);
        }
    }

    private void S(View.OnClickListener onClickListener) {
        this.gOB.setOnClickListener(onClickListener);
        this.gOQ.setOnClickListener(onClickListener);
        this.gOC.setOnClickListener(onClickListener);
        this.gOD.setOnClickListener(onClickListener);
        this.gOE.setOnClickListener(onClickListener);
        this.gOF.setOnClickListener(onClickListener);
        this.gOH.setOnClickListener(onClickListener);
        this.gOI.setOnClickListener(onClickListener);
        this.gOJ.setOnClickListener(onClickListener);
        this.gOK.setOnClickListener(onClickListener);
        this.gOL.setOnClickListener(onClickListener);
        this.gOM.setOnClickListener(onClickListener);
        this.gON.setOnClickListener(onClickListener);
        this.gOX.setOnSwitchStateChangeListener(this.gOx);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gOQ) {
                    d.this.gOy.tG(0);
                } else if (view == d.this.gOC) {
                    d.this.gOy.tG(1);
                } else if (view == d.this.gOD) {
                    d.this.gOy.tG(15);
                } else if (view == d.this.gOE) {
                    d.this.gOy.tG(2);
                } else if (view == d.this.gOF) {
                    d.this.gOy.tG(3);
                } else if (view == d.this.gOH) {
                    d.this.gOy.tG(4);
                } else if (view == d.this.gOI) {
                    d.this.gOy.tG(9);
                } else if (view == d.this.gOJ) {
                    d.this.gOy.tG(6);
                } else if (view == d.this.gOK) {
                    d.this.gOy.tG(7);
                } else if (view == d.this.gOL) {
                    d.this.gOy.tG(8);
                } else if (view == d.this.gOM) {
                    d.this.gOy.tG(5);
                } else if (view == d.this.gON) {
                    d.this.gOy.tG(10);
                } else if (view == d.this.gOB) {
                    d.this.gOy.tG(13);
                }
            }
        };
    }

    public void bwe() {
        if (this.gOz == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.g.a(this.gOz, this.gOx.getPageContext());
    }

    public void RM() {
        if (this.gOz != null) {
            com.baidu.adp.lib.g.g.b(this.gOz, this.gOx.getPageContext());
        }
    }

    public BdSwitchView bwf() {
        return this.gOX;
    }
}
