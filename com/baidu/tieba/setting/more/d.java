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
    private BdSwitchView gHA;
    private MoreActivity gHa;
    private c gHb;
    private AlertDialog gHc;
    private View gHd;
    private TbSettingTextTipView gHe;
    private SettingTextImageView gHf;
    private TbSettingTextTipView gHg;
    private TbSettingTextTipView gHh;
    private TbSettingTextTipView gHi;
    private MsgSettingItemView gHj;
    private TbSettingTextTipView gHk;
    private TbSettingTextTipView gHl;
    private SettingTextVersionView gHm;
    private TbSettingTextTipView gHn;
    private TbSettingTextTipView gHo;
    private TbSettingTextNewDotView gHp;
    private TextView gHq;
    private RelativeLayout gHr;
    private View gHs;
    private View gHt;
    private View gHu;
    private View gHv;
    private View gHw;
    private View gHx;
    private View gHy;
    private RelativeLayout gHz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gHu = null;
        this.gHv = null;
        this.gHw = null;
        this.gHx = null;
        this.gHy = null;
        this.gHz = null;
        this.gHA = null;
        this.gHa = moreActivity;
        this.gHb = cVar;
        this.gHa.setContentView(e.h.more_activity);
        Hg();
        bsK();
    }

    public void bsI() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gHf.setVisibility(8);
        } else {
            this.gHf.setVisibility(0);
        }
    }

    public void T(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gHf != null) {
                this.gHf.btM();
                return;
            }
            return;
        }
        this.gHf.btN();
        this.gHf.setIcon(str, z);
    }

    public void bsJ() {
        if (this.gHm != null) {
            this.gHm.refresh();
        }
        if (this.gHp != null) {
            this.gHp.refresh();
        }
    }

    public void bsK() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gHA.nK();
        } else {
            this.gHA.nL();
        }
    }

    public void to(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").al("obj_type", "1").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").al("obj_type", "0").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void brR() {
        this.gHf.recycle();
        this.gHg.recycle();
        this.gHh.recycle();
        this.gHi.recycle();
        this.gHk.recycle();
        this.gHl.recycle();
        this.gHm.recycle();
        this.gHn.recycle();
        this.gHo.recycle();
    }

    public void onChangeSkinType(int i) {
        eJ(i);
        if (this.gHd != null) {
            this.gHa.getLayoutMode().setNightMode(i == 1);
            this.gHa.getLayoutMode().onModeChanged(this.gHd);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void eJ(int i) {
        al.j(this.gHr, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gHf.eJ(i);
        this.gHa.getLayoutMode().setNightMode(i == 1);
        this.gHa.getLayoutMode().onModeChanged(this.gHr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gHj.d(this.gHa.getPageContext(), i);
        bsJ();
        this.gHA.setBackgroundRes(al.dc(e.f.bg_switch_open), al.dc(e.f.bg_switch_close), al.dc(e.f.btn_handle));
        al.j(this.gHs, e.d.cp_bg_line_d);
    }

    private void Hg() {
        View.OnClickListener clickListener = getClickListener();
        this.gHr = (RelativeLayout) this.gHa.findViewById(e.g.parent);
        this.gHs = this.gHa.findViewById(e.g.scroll);
        this.gHa.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gHa.findViewById(e.g.view_navigation_bar);
        this.gHt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gHa.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gHe = (TbSettingTextTipView) this.gHa.findViewById(e.g.accountSafeSetting);
        this.gHf = (SettingTextImageView) this.gHa.findViewById(e.g.personInfo);
        this.gHg = (TbSettingTextTipView) this.gHa.findViewById(e.g.interest_label_setting);
        this.gHg.setTopLineVisibility(true);
        this.gHh = (TbSettingTextTipView) this.gHa.findViewById(e.g.accountManager);
        this.gHh.setTopLineVisibility(true);
        this.gHi = (TbSettingTextTipView) this.gHa.findViewById(e.g.browseSetting);
        this.gHi.setBottomLineVisibility(true);
        this.gHk = (TbSettingTextTipView) this.gHa.findViewById(e.g.messageSetting);
        this.gHk.setBottomLineVisibility(true);
        this.gHi.setBottomLineVisibility(true);
        this.gHl = (TbSettingTextTipView) this.gHa.findViewById(e.g.secretSetting);
        this.gHl.setBottomLineVisibility(true);
        this.gHm = (SettingTextVersionView) this.gHa.findViewById(e.g.versionInfo);
        this.gHn = (TbSettingTextTipView) this.gHa.findViewById(e.g.feedBack);
        this.gHn.setTopLineVisibility(true);
        this.gHn.setBottomLineVisibility(true);
        this.gHo = (TbSettingTextTipView) this.gHa.findViewById(e.g.recommend);
        this.gHj = (MsgSettingItemView) this.gHa.findViewById(e.g.memberAdSetting);
        bsL();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gHo.setVisibility(8);
            this.gHo.setBottomLineVisibility(false);
        } else {
            this.gHo.setVisibility(0);
            this.gHo.setBottomLineVisibility(true);
        }
        this.gHp = (TbSettingTextNewDotView) this.gHa.findViewById(e.g.systemhelpsetting);
        this.gHq = (TextView) this.gHa.findViewById(e.g.quit);
        this.gHz = (RelativeLayout) this.gHa.findViewById(e.g.eyeshield_mode);
        this.gHA = (BdSwitchView) this.gHa.findViewById(e.g.item_switch);
        l.a(this.gHa.getPageContext().getPageActivity(), this.gHA, 10, 10, 10, 10);
        this.gHu = this.gHa.findViewById(e.g.divide_view2);
        this.gHv = this.gHa.findViewById(e.g.divide_view1);
        this.gHw = this.gHa.findViewById(e.g.divide_view3);
        this.gHx = this.gHa.findViewById(e.g.divide_view4);
        this.gHy = this.gHa.findViewById(e.g.divide_view5);
        bsJ();
        bsI();
        this.gHf.btM();
        eJ(TbadkCoreApplication.getInst().getSkinType());
        this.gHv.setVisibility(0);
        this.gHw.setVisibility(0);
        this.gHx.setVisibility(0);
        this.gHy.setVisibility(0);
        S(clickListener);
        if (!bsO()) {
            this.gHi.setTip(this.gHa.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.gHu.setVisibility(8);
            this.gHz.setVisibility(8);
            return;
        }
        this.gHu.setVisibility(0);
        this.gHz.setVisibility(0);
    }

    private void bsL() {
        int i;
        int i2 = 0;
        this.gHj.setText(e.j.member_ad_setting_text);
        this.gHj.setTipImageResource(e.f.label_red_svip);
        this.gHj.setOnSwitchStateChangeListener(this.gHa);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gHj.setVisibility(8);
        } else if (i2 == 0) {
            this.gHj.nJ();
        } else {
            this.gHj.nI();
        }
    }

    public void bsM() {
        this.gHj.nJ();
    }

    public void bsN() {
        this.gHj.nI();
    }

    private boolean bsO() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void PR() {
        this.gHd = LayoutInflater.from(this.gHa.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.gHa.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gHa.getLayoutMode().onModeChanged(this.gHd);
        ((TextView) this.gHd.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.PS();
                d.this.gHb.tj(11);
            }
        });
        ((TextView) this.gHd.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.PS();
                d.this.gHb.tj(12);
            }
        });
        this.gHc = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gHc.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gHc, this.mContext.getPageActivity());
        if (this.gHc.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gHc.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gHc.getWindow().setAttributes(attributes);
            this.gHc.getWindow().setContentView(this.gHd);
        }
    }

    private void S(View.OnClickListener onClickListener) {
        this.gHe.setOnClickListener(onClickListener);
        this.gHt.setOnClickListener(onClickListener);
        this.gHf.setOnClickListener(onClickListener);
        this.gHg.setOnClickListener(onClickListener);
        this.gHh.setOnClickListener(onClickListener);
        this.gHi.setOnClickListener(onClickListener);
        this.gHk.setOnClickListener(onClickListener);
        this.gHl.setOnClickListener(onClickListener);
        this.gHm.setOnClickListener(onClickListener);
        this.gHn.setOnClickListener(onClickListener);
        this.gHo.setOnClickListener(onClickListener);
        this.gHp.setOnClickListener(onClickListener);
        this.gHq.setOnClickListener(onClickListener);
        this.gHA.setOnSwitchStateChangeListener(this.gHa);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gHt) {
                    d.this.gHb.tj(0);
                } else if (view == d.this.gHf) {
                    d.this.gHb.tj(1);
                } else if (view == d.this.gHg) {
                    d.this.gHb.tj(15);
                } else if (view == d.this.gHh) {
                    d.this.gHb.tj(2);
                } else if (view == d.this.gHi) {
                    d.this.gHb.tj(3);
                } else if (view == d.this.gHk) {
                    d.this.gHb.tj(4);
                } else if (view == d.this.gHl) {
                    d.this.gHb.tj(9);
                } else if (view == d.this.gHm) {
                    d.this.gHb.tj(6);
                } else if (view == d.this.gHn) {
                    d.this.gHb.tj(7);
                } else if (view == d.this.gHo) {
                    d.this.gHb.tj(8);
                } else if (view == d.this.gHp) {
                    d.this.gHb.tj(5);
                } else if (view == d.this.gHq) {
                    d.this.gHb.tj(10);
                } else if (view == d.this.gHe) {
                    d.this.gHb.tj(13);
                }
            }
        };
    }

    public void bsP() {
        if (this.gHc == null) {
            PR();
        }
        com.baidu.adp.lib.g.g.a(this.gHc, this.gHa.getPageContext());
    }

    public void PS() {
        if (this.gHc != null) {
            com.baidu.adp.lib.g.g.b(this.gHc, this.gHa.getPageContext());
        }
    }

    public BdSwitchView bsQ() {
        return this.gHA;
    }
}
