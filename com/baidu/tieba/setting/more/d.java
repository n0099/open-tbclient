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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity guM;
    private c guN;
    private AlertDialog guO;
    private View guP;
    private TbSettingTextTipView guQ;
    private SettingTextImageView guR;
    private TbSettingTextTipView guS;
    private TbSettingTextTipView guT;
    private TbSettingTextTipView guU;
    private MsgSettingItemView guV;
    private TbSettingTextTipView guW;
    private TbSettingTextTipView guX;
    private SettingTextVersionView guY;
    private TbSettingTextTipView guZ;
    private TbSettingTextTipView gva;
    private TbSettingTextNewDotView gvb;
    private TextView gvc;
    private RelativeLayout gvd;
    private View gve;
    private View gvf;
    private View gvg;
    private View gvh;
    private View gvi;
    private View gvj;
    private View gvk;
    private RelativeLayout gvl;
    private BdSwitchView gvm;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gvg = null;
        this.gvh = null;
        this.gvi = null;
        this.gvj = null;
        this.gvk = null;
        this.gvl = null;
        this.gvm = null;
        this.guM = moreActivity;
        this.guN = cVar;
        this.guM.setContentView(d.i.more_activity);
        FC();
        brc();
    }

    public void bra() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.guR.setVisibility(8);
        } else {
            this.guR.setVisibility(0);
        }
    }

    public void S(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.guR != null) {
                this.guR.bsd();
                return;
            }
            return;
        }
        this.guR.bse();
        this.guR.setIcon(str, z);
    }

    public void brb() {
        if (this.guY != null) {
            this.guY.refresh();
        }
        if (this.gvb != null) {
            this.gvb.refresh();
        }
    }

    public void brc() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gvm.mC();
        } else {
            this.gvm.mD();
        }
    }

    public void sI(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").ah("obj_type", "1").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").ah("obj_type", "0").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bqe() {
        this.guR.recycle();
        this.guS.recycle();
        this.guT.recycle();
        this.guU.recycle();
        this.guW.recycle();
        this.guX.recycle();
        this.guY.recycle();
        this.guZ.recycle();
        this.gva.recycle();
    }

    public void onChangeSkinType(int i) {
        eu(i);
        if (this.guP != null) {
            this.guM.getLayoutMode().setNightMode(i == 1);
            this.guM.getLayoutMode().onModeChanged(this.guP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void eu(int i) {
        al.j(this.gvd, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.guR.eu(i);
        this.guM.getLayoutMode().setNightMode(i == 1);
        this.guM.getLayoutMode().onModeChanged(this.gvd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.guV.d(this.guM.getPageContext(), i);
        brb();
        this.gvm.setBackgroundRes(al.cQ(d.f.bg_switch_open), al.cQ(d.f.bg_switch_close), al.cQ(d.f.btn_handle));
        al.j(this.gve, d.C0141d.cp_bg_line_d);
    }

    private void FC() {
        View.OnClickListener clickListener = getClickListener();
        this.gvd = (RelativeLayout) this.guM.findViewById(d.g.parent);
        this.gve = this.guM.findViewById(d.g.scroll);
        this.guM.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.guM.findViewById(d.g.view_navigation_bar);
        this.gvf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.guM.getPageContext().getString(d.k.setup));
        this.mNavigationBar.showBottomLine();
        this.guQ = (TbSettingTextTipView) this.guM.findViewById(d.g.accountSafeSetting);
        this.guR = (SettingTextImageView) this.guM.findViewById(d.g.personInfo);
        this.guS = (TbSettingTextTipView) this.guM.findViewById(d.g.interest_label_setting);
        this.guS.setTopLineVisibility(true);
        this.guT = (TbSettingTextTipView) this.guM.findViewById(d.g.accountManager);
        this.guT.setTopLineVisibility(true);
        this.guU = (TbSettingTextTipView) this.guM.findViewById(d.g.browseSetting);
        this.guU.setBottomLineVisibility(true);
        this.guW = (TbSettingTextTipView) this.guM.findViewById(d.g.messageSetting);
        this.guW.setBottomLineVisibility(true);
        this.guU.setBottomLineVisibility(true);
        this.guX = (TbSettingTextTipView) this.guM.findViewById(d.g.secretSetting);
        this.guX.setBottomLineVisibility(true);
        this.guY = (SettingTextVersionView) this.guM.findViewById(d.g.versionInfo);
        this.guZ = (TbSettingTextTipView) this.guM.findViewById(d.g.feedBack);
        this.guZ.setTopLineVisibility(true);
        this.guZ.setBottomLineVisibility(true);
        this.gva = (TbSettingTextTipView) this.guM.findViewById(d.g.recommend);
        this.guV = (MsgSettingItemView) this.guM.findViewById(d.g.memberAdSetting);
        brd();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gva.setVisibility(8);
            this.gva.setBottomLineVisibility(false);
        } else {
            this.gva.setVisibility(0);
            this.gva.setBottomLineVisibility(true);
        }
        this.gvb = (TbSettingTextNewDotView) this.guM.findViewById(d.g.systemhelpsetting);
        this.gvc = (TextView) this.guM.findViewById(d.g.quit);
        this.gvl = (RelativeLayout) this.guM.findViewById(d.g.eyeshield_mode);
        this.gvm = (BdSwitchView) this.guM.findViewById(d.g.item_switch);
        l.a(this.guM.getPageContext().getPageActivity(), this.gvm, 10, 10, 10, 10);
        this.gvg = this.guM.findViewById(d.g.divide_view2);
        this.gvh = this.guM.findViewById(d.g.divide_view1);
        this.gvi = this.guM.findViewById(d.g.divide_view3);
        this.gvj = this.guM.findViewById(d.g.divide_view4);
        this.gvk = this.guM.findViewById(d.g.divide_view5);
        brb();
        bra();
        this.guR.bsd();
        eu(TbadkCoreApplication.getInst().getSkinType());
        this.gvh.setVisibility(0);
        this.gvi.setVisibility(0);
        this.gvj.setVisibility(0);
        this.gvk.setVisibility(0);
        R(clickListener);
        if (!brg()) {
            this.guU.setTip(this.guM.getResources().getString(d.k.browsing_settings_tip_no_night));
            this.gvg.setVisibility(8);
            this.gvl.setVisibility(8);
            return;
        }
        this.gvg.setVisibility(0);
        this.gvl.setVisibility(0);
    }

    private void brd() {
        int i;
        int i2 = 0;
        this.guV.setText(d.k.member_ad_setting_text);
        this.guV.setTipImageResource(d.f.label_red_svip);
        this.guV.setOnSwitchStateChangeListener(this.guM);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.guV.setVisibility(8);
        } else if (i2 == 0) {
            this.guV.mB();
        } else {
            this.guV.mA();
        }
    }

    public void bre() {
        this.guV.mB();
    }

    public void brf() {
        this.guV.mA();
    }

    private boolean brg() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void bdZ() {
        this.guP = LayoutInflater.from(this.guM.getPageContext().getPageActivity()).inflate(d.i.quit_dialog, (ViewGroup) null);
        this.guM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.guM.getLayoutMode().onModeChanged(this.guP);
        ((TextView) this.guP.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.YO();
                d.this.guN.sD(11);
            }
        });
        ((TextView) this.guP.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.YO();
                d.this.guN.sD(12);
            }
        });
        this.guO = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.guO.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.guO, this.mContext.getPageActivity());
        if (this.guO.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.guO.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.guO.getWindow().setAttributes(attributes);
            this.guO.getWindow().setContentView(this.guP);
        }
    }

    private void R(View.OnClickListener onClickListener) {
        this.guQ.setOnClickListener(onClickListener);
        this.gvf.setOnClickListener(onClickListener);
        this.guR.setOnClickListener(onClickListener);
        this.guS.setOnClickListener(onClickListener);
        this.guT.setOnClickListener(onClickListener);
        this.guU.setOnClickListener(onClickListener);
        this.guW.setOnClickListener(onClickListener);
        this.guX.setOnClickListener(onClickListener);
        this.guY.setOnClickListener(onClickListener);
        this.guZ.setOnClickListener(onClickListener);
        this.gva.setOnClickListener(onClickListener);
        this.gvb.setOnClickListener(onClickListener);
        this.gvc.setOnClickListener(onClickListener);
        this.gvm.setOnSwitchStateChangeListener(this.guM);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gvf) {
                    d.this.guN.sD(0);
                } else if (view == d.this.guR) {
                    d.this.guN.sD(1);
                } else if (view == d.this.guS) {
                    d.this.guN.sD(15);
                } else if (view == d.this.guT) {
                    d.this.guN.sD(2);
                } else if (view == d.this.guU) {
                    d.this.guN.sD(3);
                } else if (view == d.this.guW) {
                    d.this.guN.sD(4);
                } else if (view == d.this.guX) {
                    d.this.guN.sD(9);
                } else if (view == d.this.guY) {
                    d.this.guN.sD(6);
                } else if (view == d.this.guZ) {
                    d.this.guN.sD(7);
                } else if (view == d.this.gva) {
                    d.this.guN.sD(8);
                } else if (view == d.this.gvb) {
                    d.this.guN.sD(5);
                } else if (view == d.this.gvc) {
                    d.this.guN.sD(10);
                } else if (view == d.this.guQ) {
                    d.this.guN.sD(13);
                }
            }
        };
    }

    public void brh() {
        if (this.guO == null) {
            bdZ();
        }
        com.baidu.adp.lib.g.g.a(this.guO, this.guM.getPageContext());
    }

    public void YO() {
        if (this.guO != null) {
            com.baidu.adp.lib.g.g.b(this.guO, this.guM.getPageContext());
        }
    }

    public BdSwitchView bri() {
        return this.gvm;
    }
}
