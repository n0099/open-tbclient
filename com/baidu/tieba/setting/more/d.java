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
    private TbSettingTextTipView gOA;
    private SettingTextImageView gOB;
    private TbSettingTextTipView gOC;
    private TbSettingTextTipView gOD;
    private TbSettingTextTipView gOE;
    private MsgSettingItemView gOF;
    private TbSettingTextTipView gOG;
    private TbSettingTextTipView gOH;
    private SettingTextVersionView gOI;
    private TbSettingTextTipView gOJ;
    private TbSettingTextTipView gOK;
    private TbSettingTextNewDotView gOL;
    private TextView gOM;
    private RelativeLayout gON;
    private View gOO;
    private View gOP;
    private View gOQ;
    private View gOR;
    private View gOS;
    private View gOT;
    private View gOU;
    private RelativeLayout gOV;
    private BdSwitchView gOW;
    private MoreActivity gOw;
    private c gOx;
    private AlertDialog gOy;
    private View gOz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gOQ = null;
        this.gOR = null;
        this.gOS = null;
        this.gOT = null;
        this.gOU = null;
        this.gOV = null;
        this.gOW = null;
        this.gOw = moreActivity;
        this.gOx = cVar;
        this.gOw.setContentView(e.h.more_activity);
        Jh();
        bvZ();
    }

    public void bvX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gOB.setVisibility(8);
        } else {
            this.gOB.setVisibility(0);
        }
    }

    public void aa(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gOB != null) {
                this.gOB.bxb();
                return;
            }
            return;
        }
        this.gOB.bxc();
        this.gOB.setIcon(str, z);
    }

    public void bvY() {
        if (this.gOI != null) {
            this.gOI.refresh();
        }
        if (this.gOL != null) {
            this.gOL.refresh();
        }
    }

    public void bvZ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gOW.nU();
        } else {
            this.gOW.nV();
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
        this.gOB.recycle();
        this.gOC.recycle();
        this.gOD.recycle();
        this.gOE.recycle();
        this.gOG.recycle();
        this.gOH.recycle();
        this.gOI.recycle();
        this.gOJ.recycle();
        this.gOK.recycle();
    }

    public void onChangeSkinType(int i) {
        eS(i);
        if (this.gOz != null) {
            this.gOw.getLayoutMode().setNightMode(i == 1);
            this.gOw.getLayoutMode().onModeChanged(this.gOz);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void eS(int i) {
        al.j(this.gON, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOB.eS(i);
        this.gOw.getLayoutMode().setNightMode(i == 1);
        this.gOw.getLayoutMode().onModeChanged(this.gON);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOF.d(this.gOw.getPageContext(), i);
        bvY();
        this.gOW.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        al.j(this.gOO, e.d.cp_bg_line_d);
    }

    private void Jh() {
        View.OnClickListener clickListener = getClickListener();
        this.gON = (RelativeLayout) this.gOw.findViewById(e.g.parent);
        this.gOO = this.gOw.findViewById(e.g.scroll);
        this.gOw.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gOw.findViewById(e.g.view_navigation_bar);
        this.gOP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gOw.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gOA = (TbSettingTextTipView) this.gOw.findViewById(e.g.accountSafeSetting);
        this.gOB = (SettingTextImageView) this.gOw.findViewById(e.g.personInfo);
        this.gOC = (TbSettingTextTipView) this.gOw.findViewById(e.g.interest_label_setting);
        this.gOC.setTopLineVisibility(true);
        this.gOD = (TbSettingTextTipView) this.gOw.findViewById(e.g.accountManager);
        this.gOD.setTopLineVisibility(true);
        this.gOE = (TbSettingTextTipView) this.gOw.findViewById(e.g.browseSetting);
        this.gOE.setBottomLineVisibility(true);
        this.gOG = (TbSettingTextTipView) this.gOw.findViewById(e.g.messageSetting);
        this.gOG.setBottomLineVisibility(true);
        this.gOE.setBottomLineVisibility(true);
        this.gOH = (TbSettingTextTipView) this.gOw.findViewById(e.g.secretSetting);
        this.gOH.setBottomLineVisibility(true);
        this.gOI = (SettingTextVersionView) this.gOw.findViewById(e.g.versionInfo);
        this.gOJ = (TbSettingTextTipView) this.gOw.findViewById(e.g.feedBack);
        this.gOJ.setTopLineVisibility(true);
        this.gOJ.setBottomLineVisibility(true);
        this.gOK = (TbSettingTextTipView) this.gOw.findViewById(e.g.recommend);
        this.gOF = (MsgSettingItemView) this.gOw.findViewById(e.g.memberAdSetting);
        bwa();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gOK.setVisibility(8);
            this.gOK.setBottomLineVisibility(false);
        } else {
            this.gOK.setVisibility(0);
            this.gOK.setBottomLineVisibility(true);
        }
        this.gOL = (TbSettingTextNewDotView) this.gOw.findViewById(e.g.systemhelpsetting);
        this.gOM = (TextView) this.gOw.findViewById(e.g.quit);
        this.gOV = (RelativeLayout) this.gOw.findViewById(e.g.eyeshield_mode);
        this.gOW = (BdSwitchView) this.gOw.findViewById(e.g.item_switch);
        l.a(this.gOw.getPageContext().getPageActivity(), this.gOW, 10, 10, 10, 10);
        this.gOQ = this.gOw.findViewById(e.g.divide_view2);
        this.gOR = this.gOw.findViewById(e.g.divide_view1);
        this.gOS = this.gOw.findViewById(e.g.divide_view3);
        this.gOT = this.gOw.findViewById(e.g.divide_view4);
        this.gOU = this.gOw.findViewById(e.g.divide_view5);
        bvY();
        bvX();
        this.gOB.bxb();
        eS(TbadkCoreApplication.getInst().getSkinType());
        this.gOR.setVisibility(0);
        this.gOS.setVisibility(0);
        this.gOT.setVisibility(0);
        this.gOU.setVisibility(0);
        S(clickListener);
        if (!bwd()) {
            this.gOE.setTip(this.gOw.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.gOQ.setVisibility(8);
            this.gOV.setVisibility(8);
            return;
        }
        this.gOQ.setVisibility(0);
        this.gOV.setVisibility(0);
    }

    private void bwa() {
        int i;
        int i2 = 0;
        this.gOF.setText(e.j.member_ad_setting_text);
        this.gOF.setTipImageResource(e.f.label_red_svip);
        this.gOF.setOnSwitchStateChangeListener(this.gOw);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gOF.setVisibility(8);
        } else if (i2 == 0) {
            this.gOF.nT();
        } else {
            this.gOF.nS();
        }
    }

    public void bwb() {
        this.gOF.nT();
    }

    public void bwc() {
        this.gOF.nS();
    }

    private boolean bwd() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void createDialog() {
        this.gOz = LayoutInflater.from(this.gOw.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.gOw.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gOw.getLayoutMode().onModeChanged(this.gOz);
        ((TextView) this.gOz.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.RM();
                d.this.gOx.tG(11);
            }
        });
        ((TextView) this.gOz.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.RM();
                d.this.gOx.tG(12);
            }
        });
        this.gOy = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gOy.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gOy, this.mContext.getPageActivity());
        if (this.gOy.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gOy.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gOy.getWindow().setAttributes(attributes);
            this.gOy.getWindow().setContentView(this.gOz);
        }
    }

    private void S(View.OnClickListener onClickListener) {
        this.gOA.setOnClickListener(onClickListener);
        this.gOP.setOnClickListener(onClickListener);
        this.gOB.setOnClickListener(onClickListener);
        this.gOC.setOnClickListener(onClickListener);
        this.gOD.setOnClickListener(onClickListener);
        this.gOE.setOnClickListener(onClickListener);
        this.gOG.setOnClickListener(onClickListener);
        this.gOH.setOnClickListener(onClickListener);
        this.gOI.setOnClickListener(onClickListener);
        this.gOJ.setOnClickListener(onClickListener);
        this.gOK.setOnClickListener(onClickListener);
        this.gOL.setOnClickListener(onClickListener);
        this.gOM.setOnClickListener(onClickListener);
        this.gOW.setOnSwitchStateChangeListener(this.gOw);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gOP) {
                    d.this.gOx.tG(0);
                } else if (view == d.this.gOB) {
                    d.this.gOx.tG(1);
                } else if (view == d.this.gOC) {
                    d.this.gOx.tG(15);
                } else if (view == d.this.gOD) {
                    d.this.gOx.tG(2);
                } else if (view == d.this.gOE) {
                    d.this.gOx.tG(3);
                } else if (view == d.this.gOG) {
                    d.this.gOx.tG(4);
                } else if (view == d.this.gOH) {
                    d.this.gOx.tG(9);
                } else if (view == d.this.gOI) {
                    d.this.gOx.tG(6);
                } else if (view == d.this.gOJ) {
                    d.this.gOx.tG(7);
                } else if (view == d.this.gOK) {
                    d.this.gOx.tG(8);
                } else if (view == d.this.gOL) {
                    d.this.gOx.tG(5);
                } else if (view == d.this.gOM) {
                    d.this.gOx.tG(10);
                } else if (view == d.this.gOA) {
                    d.this.gOx.tG(13);
                }
            }
        };
    }

    public void bwe() {
        if (this.gOy == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.g.a(this.gOy, this.gOw.getPageContext());
    }

    public void RM() {
        if (this.gOy != null) {
            com.baidu.adp.lib.g.g.b(this.gOy, this.gOw.getPageContext());
        }
    }

    public BdSwitchView bwf() {
        return this.gOW;
    }
}
