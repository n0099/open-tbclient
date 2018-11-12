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
    private MoreActivity gPW;
    private c gPX;
    private AlertDialog gPY;
    private View gPZ;
    private TbSettingTextTipView gQa;
    private SettingTextImageView gQb;
    private TbSettingTextTipView gQc;
    private TbSettingTextTipView gQd;
    private TbSettingTextTipView gQe;
    private MsgSettingItemView gQf;
    private TbSettingTextTipView gQg;
    private TbSettingTextTipView gQh;
    private SettingTextVersionView gQi;
    private TbSettingTextTipView gQj;
    private TbSettingTextTipView gQk;
    private TbSettingTextNewDotView gQl;
    private TextView gQm;
    private RelativeLayout gQn;
    private View gQo;
    private View gQp;
    private View gQq;
    private View gQr;
    private View gQs;
    private View gQt;
    private View gQu;
    private RelativeLayout gQv;
    private BdSwitchView gQw;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gQq = null;
        this.gQr = null;
        this.gQs = null;
        this.gQt = null;
        this.gQu = null;
        this.gQv = null;
        this.gQw = null;
        this.gPW = moreActivity;
        this.gPX = cVar;
        this.gPW.setContentView(e.h.more_activity);
        Jt();
        bvv();
    }

    public void bvt() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gQb.setVisibility(8);
        } else {
            this.gQb.setVisibility(0);
        }
    }

    public void aa(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gQb != null) {
                this.gQb.bwx();
                return;
            }
            return;
        }
        this.gQb.bwy();
        this.gQb.setIcon(str, z);
    }

    public void bvu() {
        if (this.gQi != null) {
            this.gQi.refresh();
        }
        if (this.gQl != null) {
            this.gQl.refresh();
        }
    }

    public void bvv() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gQw.nS();
        } else {
            this.gQw.nT();
        }
    }

    public void ue(int i) {
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

    public void buC() {
        this.gQb.recycle();
        this.gQc.recycle();
        this.gQd.recycle();
        this.gQe.recycle();
        this.gQg.recycle();
        this.gQh.recycle();
        this.gQi.recycle();
        this.gQj.recycle();
        this.gQk.recycle();
    }

    public void onChangeSkinType(int i) {
        fg(i);
        if (this.gPZ != null) {
            this.gPW.getLayoutMode().setNightMode(i == 1);
            this.gPW.getLayoutMode().onModeChanged(this.gPZ);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void fg(int i) {
        al.j(this.gQn, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gQb.fg(i);
        this.gPW.getLayoutMode().setNightMode(i == 1);
        this.gPW.getLayoutMode().onModeChanged(this.gQn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gQf.d(this.gPW.getPageContext(), i);
        bvu();
        this.gQw.setBackgroundRes(al.dA(e.f.bg_switch_open), al.dA(e.f.bg_switch_close), al.dA(e.f.btn_handle));
        al.j(this.gQo, e.d.cp_bg_line_d);
    }

    private void Jt() {
        View.OnClickListener clickListener = getClickListener();
        this.gQn = (RelativeLayout) this.gPW.findViewById(e.g.parent);
        this.gQo = this.gPW.findViewById(e.g.scroll);
        this.gPW.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gPW.findViewById(e.g.view_navigation_bar);
        this.gQp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gPW.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gQa = (TbSettingTextTipView) this.gPW.findViewById(e.g.accountSafeSetting);
        this.gQb = (SettingTextImageView) this.gPW.findViewById(e.g.personInfo);
        this.gQc = (TbSettingTextTipView) this.gPW.findViewById(e.g.interest_label_setting);
        this.gQc.setTopLineVisibility(true);
        this.gQd = (TbSettingTextTipView) this.gPW.findViewById(e.g.accountManager);
        this.gQd.setTopLineVisibility(true);
        this.gQe = (TbSettingTextTipView) this.gPW.findViewById(e.g.browseSetting);
        this.gQe.setBottomLineVisibility(true);
        this.gQg = (TbSettingTextTipView) this.gPW.findViewById(e.g.messageSetting);
        this.gQg.setBottomLineVisibility(true);
        this.gQe.setBottomLineVisibility(true);
        this.gQh = (TbSettingTextTipView) this.gPW.findViewById(e.g.secretSetting);
        this.gQh.setBottomLineVisibility(true);
        this.gQi = (SettingTextVersionView) this.gPW.findViewById(e.g.versionInfo);
        this.gQj = (TbSettingTextTipView) this.gPW.findViewById(e.g.feedBack);
        this.gQj.setTopLineVisibility(true);
        this.gQj.setBottomLineVisibility(true);
        this.gQk = (TbSettingTextTipView) this.gPW.findViewById(e.g.recommend);
        this.gQf = (MsgSettingItemView) this.gPW.findViewById(e.g.memberAdSetting);
        bvw();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gQk.setVisibility(8);
            this.gQk.setBottomLineVisibility(false);
        } else {
            this.gQk.setVisibility(0);
            this.gQk.setBottomLineVisibility(true);
        }
        this.gQl = (TbSettingTextNewDotView) this.gPW.findViewById(e.g.systemhelpsetting);
        this.gQm = (TextView) this.gPW.findViewById(e.g.quit);
        this.gQv = (RelativeLayout) this.gPW.findViewById(e.g.eyeshield_mode);
        this.gQw = (BdSwitchView) this.gPW.findViewById(e.g.item_switch);
        l.b(this.gPW.getPageContext().getPageActivity(), this.gQw, 10, 10, 10, 10);
        this.gQq = this.gPW.findViewById(e.g.divide_view2);
        this.gQr = this.gPW.findViewById(e.g.divide_view1);
        this.gQs = this.gPW.findViewById(e.g.divide_view3);
        this.gQt = this.gPW.findViewById(e.g.divide_view4);
        this.gQu = this.gPW.findViewById(e.g.divide_view5);
        bvu();
        bvt();
        this.gQb.bwx();
        fg(TbadkCoreApplication.getInst().getSkinType());
        this.gQr.setVisibility(0);
        this.gQs.setVisibility(0);
        this.gQt.setVisibility(0);
        this.gQu.setVisibility(0);
        U(clickListener);
        if (!bvz()) {
            this.gQe.setTip(this.gPW.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.gQq.setVisibility(8);
            this.gQv.setVisibility(8);
            return;
        }
        this.gQq.setVisibility(0);
        this.gQv.setVisibility(0);
    }

    private void bvw() {
        int i;
        int i2 = 0;
        this.gQf.setText(e.j.member_ad_setting_text);
        this.gQf.setTipImageResource(e.f.label_red_svip);
        this.gQf.setOnSwitchStateChangeListener(this.gPW);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gQf.setVisibility(8);
        } else if (i2 == 0) {
            this.gQf.nR();
        } else {
            this.gQf.nQ();
        }
    }

    public void bvx() {
        this.gQf.nR();
    }

    public void bvy() {
        this.gQf.nQ();
    }

    private boolean bvz() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void createDialog() {
        this.gPZ = LayoutInflater.from(this.gPW.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.gPW.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gPW.getLayoutMode().onModeChanged(this.gPZ);
        ((TextView) this.gPZ.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.RV();
                d.this.gPX.tZ(11);
            }
        });
        ((TextView) this.gPZ.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.RV();
                d.this.gPX.tZ(12);
            }
        });
        this.gPY = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gPY.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gPY, this.mContext.getPageActivity());
        if (this.gPY.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gPY.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gPY.getWindow().setAttributes(attributes);
            this.gPY.getWindow().setContentView(this.gPZ);
        }
    }

    private void U(View.OnClickListener onClickListener) {
        this.gQa.setOnClickListener(onClickListener);
        this.gQp.setOnClickListener(onClickListener);
        this.gQb.setOnClickListener(onClickListener);
        this.gQc.setOnClickListener(onClickListener);
        this.gQd.setOnClickListener(onClickListener);
        this.gQe.setOnClickListener(onClickListener);
        this.gQg.setOnClickListener(onClickListener);
        this.gQh.setOnClickListener(onClickListener);
        this.gQi.setOnClickListener(onClickListener);
        this.gQj.setOnClickListener(onClickListener);
        this.gQk.setOnClickListener(onClickListener);
        this.gQl.setOnClickListener(onClickListener);
        this.gQm.setOnClickListener(onClickListener);
        this.gQw.setOnSwitchStateChangeListener(this.gPW);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gQp) {
                    d.this.gPX.tZ(0);
                } else if (view == d.this.gQb) {
                    d.this.gPX.tZ(1);
                } else if (view == d.this.gQc) {
                    d.this.gPX.tZ(15);
                } else if (view == d.this.gQd) {
                    d.this.gPX.tZ(2);
                } else if (view == d.this.gQe) {
                    d.this.gPX.tZ(3);
                } else if (view == d.this.gQg) {
                    d.this.gPX.tZ(4);
                } else if (view == d.this.gQh) {
                    d.this.gPX.tZ(9);
                } else if (view == d.this.gQi) {
                    d.this.gPX.tZ(6);
                } else if (view == d.this.gQj) {
                    d.this.gPX.tZ(7);
                } else if (view == d.this.gQk) {
                    d.this.gPX.tZ(8);
                } else if (view == d.this.gQl) {
                    d.this.gPX.tZ(5);
                } else if (view == d.this.gQm) {
                    d.this.gPX.tZ(10);
                } else if (view == d.this.gQa) {
                    d.this.gPX.tZ(13);
                }
            }
        };
    }

    public void bvA() {
        if (this.gPY == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.g.a(this.gPY, this.gPW.getPageContext());
    }

    public void RV() {
        if (this.gPY != null) {
            com.baidu.adp.lib.g.g.b(this.gPY, this.gPW.getPageContext());
        }
    }

    public BdSwitchView bvB() {
        return this.gQw;
    }
}
