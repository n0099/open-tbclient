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
    private TbSettingTextTipView gAa;
    private TbSettingTextNewDotView gAb;
    private TextView gAc;
    private RelativeLayout gAd;
    private View gAe;
    private View gAf;
    private View gAg;
    private View gAh;
    private View gAi;
    private View gAj;
    private View gAk;
    private RelativeLayout gAl;
    private BdSwitchView gAm;
    private MoreActivity gzM;
    private c gzN;
    private AlertDialog gzO;
    private View gzP;
    private TbSettingTextTipView gzQ;
    private SettingTextImageView gzR;
    private TbSettingTextTipView gzS;
    private TbSettingTextTipView gzT;
    private TbSettingTextTipView gzU;
    private MsgSettingItemView gzV;
    private TbSettingTextTipView gzW;
    private TbSettingTextTipView gzX;
    private SettingTextVersionView gzY;
    private TbSettingTextTipView gzZ;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gAg = null;
        this.gAh = null;
        this.gAi = null;
        this.gAj = null;
        this.gAk = null;
        this.gAl = null;
        this.gAm = null;
        this.gzM = moreActivity;
        this.gzN = cVar;
        this.gzM.setContentView(d.h.more_activity);
        FQ();
        bqg();
    }

    public void bqe() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gzR.setVisibility(8);
        } else {
            this.gzR.setVisibility(0);
        }
    }

    public void S(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gzR != null) {
                this.gzR.brh();
                return;
            }
            return;
        }
        this.gzR.bri();
        this.gzR.setIcon(str, z);
    }

    public void bqf() {
        if (this.gzY != null) {
            this.gzY.refresh();
        }
        if (this.gAb != null) {
            this.gAb.refresh();
        }
    }

    public void bqg() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gAm.mE();
        } else {
            this.gAm.mF();
        }
    }

    public void sQ(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an("c10647").af("obj_type", "1").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an("c10647").af("obj_type", "0").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bpi() {
        this.gzR.recycle();
        this.gzS.recycle();
        this.gzT.recycle();
        this.gzU.recycle();
        this.gzW.recycle();
        this.gzX.recycle();
        this.gzY.recycle();
        this.gzZ.recycle();
        this.gAa.recycle();
    }

    public void onChangeSkinType(int i) {
        ey(i);
        if (this.gzP != null) {
            this.gzM.getLayoutMode().setNightMode(i == 1);
            this.gzM.getLayoutMode().onModeChanged(this.gzP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ey(int i) {
        am.j(this.gAd, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gzR.ey(i);
        this.gzM.getLayoutMode().setNightMode(i == 1);
        this.gzM.getLayoutMode().onModeChanged(this.gAd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gzV.d(this.gzM.getPageContext(), i);
        bqf();
        this.gAm.setBackgroundRes(am.cT(d.f.bg_switch_open), am.cT(d.f.bg_switch_close), am.cT(d.f.btn_handle));
        am.j(this.gAe, d.C0140d.cp_bg_line_d);
    }

    private void FQ() {
        View.OnClickListener clickListener = getClickListener();
        this.gAd = (RelativeLayout) this.gzM.findViewById(d.g.parent);
        this.gAe = this.gzM.findViewById(d.g.scroll);
        this.gzM.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gzM.findViewById(d.g.view_navigation_bar);
        this.gAf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gzM.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gzQ = (TbSettingTextTipView) this.gzM.findViewById(d.g.accountSafeSetting);
        this.gzR = (SettingTextImageView) this.gzM.findViewById(d.g.personInfo);
        this.gzS = (TbSettingTextTipView) this.gzM.findViewById(d.g.interest_label_setting);
        this.gzS.setTopLineVisibility(true);
        this.gzT = (TbSettingTextTipView) this.gzM.findViewById(d.g.accountManager);
        this.gzT.setTopLineVisibility(true);
        this.gzU = (TbSettingTextTipView) this.gzM.findViewById(d.g.browseSetting);
        this.gzU.setBottomLineVisibility(true);
        this.gzW = (TbSettingTextTipView) this.gzM.findViewById(d.g.messageSetting);
        this.gzW.setBottomLineVisibility(true);
        this.gzU.setBottomLineVisibility(true);
        this.gzX = (TbSettingTextTipView) this.gzM.findViewById(d.g.secretSetting);
        this.gzX.setBottomLineVisibility(true);
        this.gzY = (SettingTextVersionView) this.gzM.findViewById(d.g.versionInfo);
        this.gzZ = (TbSettingTextTipView) this.gzM.findViewById(d.g.feedBack);
        this.gzZ.setTopLineVisibility(true);
        this.gzZ.setBottomLineVisibility(true);
        this.gAa = (TbSettingTextTipView) this.gzM.findViewById(d.g.recommend);
        this.gzV = (MsgSettingItemView) this.gzM.findViewById(d.g.memberAdSetting);
        bqh();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gAa.setVisibility(8);
            this.gAa.setBottomLineVisibility(false);
        } else {
            this.gAa.setVisibility(0);
            this.gAa.setBottomLineVisibility(true);
        }
        this.gAb = (TbSettingTextNewDotView) this.gzM.findViewById(d.g.systemhelpsetting);
        this.gAc = (TextView) this.gzM.findViewById(d.g.quit);
        this.gAl = (RelativeLayout) this.gzM.findViewById(d.g.eyeshield_mode);
        this.gAm = (BdSwitchView) this.gzM.findViewById(d.g.item_switch);
        l.a(this.gzM.getPageContext().getPageActivity(), this.gAm, 10, 10, 10, 10);
        this.gAg = this.gzM.findViewById(d.g.divide_view2);
        this.gAh = this.gzM.findViewById(d.g.divide_view1);
        this.gAi = this.gzM.findViewById(d.g.divide_view3);
        this.gAj = this.gzM.findViewById(d.g.divide_view4);
        this.gAk = this.gzM.findViewById(d.g.divide_view5);
        bqf();
        bqe();
        this.gzR.brh();
        ey(TbadkCoreApplication.getInst().getSkinType());
        this.gAh.setVisibility(0);
        this.gAi.setVisibility(0);
        this.gAj.setVisibility(0);
        this.gAk.setVisibility(0);
        T(clickListener);
        if (!bqk()) {
            this.gzU.setTip(this.gzM.getResources().getString(d.j.browsing_settings_tip_no_night));
            this.gAg.setVisibility(8);
            this.gAl.setVisibility(8);
            return;
        }
        this.gAg.setVisibility(0);
        this.gAl.setVisibility(0);
    }

    private void bqh() {
        int i;
        int i2 = 0;
        this.gzV.setText(d.j.member_ad_setting_text);
        this.gzV.setTipImageResource(d.f.label_red_svip);
        this.gzV.setOnSwitchStateChangeListener(this.gzM);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gzV.setVisibility(8);
        } else if (i2 == 0) {
            this.gzV.mD();
        } else {
            this.gzV.mC();
        }
    }

    public void bqi() {
        this.gzV.mD();
    }

    public void bqj() {
        this.gzV.mC();
    }

    private boolean bqk() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void bda() {
        this.gzP = LayoutInflater.from(this.gzM.getPageContext().getPageActivity()).inflate(d.h.quit_dialog, (ViewGroup) null);
        this.gzM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gzM.getLayoutMode().onModeChanged(this.gzP);
        ((TextView) this.gzP.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ZB();
                d.this.gzN.sL(11);
            }
        });
        ((TextView) this.gzP.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ZB();
                d.this.gzN.sL(12);
            }
        });
        this.gzO = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gzO.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gzO, this.mContext.getPageActivity());
        if (this.gzO.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gzO.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gzO.getWindow().setAttributes(attributes);
            this.gzO.getWindow().setContentView(this.gzP);
        }
    }

    private void T(View.OnClickListener onClickListener) {
        this.gzQ.setOnClickListener(onClickListener);
        this.gAf.setOnClickListener(onClickListener);
        this.gzR.setOnClickListener(onClickListener);
        this.gzS.setOnClickListener(onClickListener);
        this.gzT.setOnClickListener(onClickListener);
        this.gzU.setOnClickListener(onClickListener);
        this.gzW.setOnClickListener(onClickListener);
        this.gzX.setOnClickListener(onClickListener);
        this.gzY.setOnClickListener(onClickListener);
        this.gzZ.setOnClickListener(onClickListener);
        this.gAa.setOnClickListener(onClickListener);
        this.gAb.setOnClickListener(onClickListener);
        this.gAc.setOnClickListener(onClickListener);
        this.gAm.setOnSwitchStateChangeListener(this.gzM);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gAf) {
                    d.this.gzN.sL(0);
                } else if (view == d.this.gzR) {
                    d.this.gzN.sL(1);
                } else if (view == d.this.gzS) {
                    d.this.gzN.sL(15);
                } else if (view == d.this.gzT) {
                    d.this.gzN.sL(2);
                } else if (view == d.this.gzU) {
                    d.this.gzN.sL(3);
                } else if (view == d.this.gzW) {
                    d.this.gzN.sL(4);
                } else if (view == d.this.gzX) {
                    d.this.gzN.sL(9);
                } else if (view == d.this.gzY) {
                    d.this.gzN.sL(6);
                } else if (view == d.this.gzZ) {
                    d.this.gzN.sL(7);
                } else if (view == d.this.gAa) {
                    d.this.gzN.sL(8);
                } else if (view == d.this.gAb) {
                    d.this.gzN.sL(5);
                } else if (view == d.this.gAc) {
                    d.this.gzN.sL(10);
                } else if (view == d.this.gzQ) {
                    d.this.gzN.sL(13);
                }
            }
        };
    }

    public void bql() {
        if (this.gzO == null) {
            bda();
        }
        com.baidu.adp.lib.g.g.a(this.gzO, this.gzM.getPageContext());
    }

    public void ZB() {
        if (this.gzO != null) {
            com.baidu.adp.lib.g.g.b(this.gzO, this.gzM.getPageContext());
        }
    }

    public BdSwitchView bqm() {
        return this.gAm;
    }
}
