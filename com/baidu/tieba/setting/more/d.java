package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<MoreActivity> {
    private TbSettingTextTipView gNA;
    private TbSettingTextTipView gNB;
    private TbSettingTextNewDotView gNC;
    private TextView gND;
    private RelativeLayout gNE;
    private View gNF;
    private MoreActivity gNn;
    private c gNo;
    private AlertDialog gNp;
    private View gNq;
    private TbSettingTextTipView gNr;
    private SettingTextImageView gNs;
    private TbSettingTextTipView gNt;
    private TbSettingTextTipView gNu;
    private TbSettingTextTipView gNv;
    private MsgSettingItemView gNw;
    private TbSettingTextTipView gNx;
    private TbSettingTextTipView gNy;
    private SettingTextVersionView gNz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gNn = moreActivity;
        this.gNo = cVar;
        this.gNn.setContentView(d.h.more_activity);
        Jv();
    }

    public void bqW() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gNs.setVisibility(8);
        } else {
            this.gNs.setVisibility(0);
        }
    }

    public void X(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gNs != null) {
                this.gNs.brW();
                return;
            }
            return;
        }
        this.gNs.brX();
        this.gNs.Y(str, z);
    }

    public void bqX() {
        if (this.gNz != null) {
            this.gNz.refresh();
        }
        if (this.gNC != null) {
            this.gNC.refresh();
        }
    }

    public void bpY() {
        this.gNs.recycle();
        this.gNt.recycle();
        this.gNu.recycle();
        this.gNv.recycle();
        this.gNx.recycle();
        this.gNy.recycle();
        this.gNz.recycle();
        this.gNA.recycle();
        this.gNB.recycle();
    }

    public void onChangeSkinType(int i) {
        hr(i);
        if (this.gNq != null) {
            this.gNn.getLayoutMode().aQ(i == 1);
            this.gNn.getLayoutMode().aM(this.gNq);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void hr(int i) {
        aj.t(this.gNE, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNs.hr(i);
        this.gNn.getLayoutMode().aQ(i == 1);
        this.gNn.getLayoutMode().aM(this.gNE);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNw.d(this.gNn.getPageContext(), i);
        bqX();
    }

    private void Jv() {
        View.OnClickListener clickListener = getClickListener();
        this.gNE = (RelativeLayout) this.gNn.findViewById(d.g.parent);
        this.gNn.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gNn.findViewById(d.g.view_navigation_bar);
        this.gNF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gNn.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gNr = (TbSettingTextTipView) this.gNn.findViewById(d.g.accountSafeSetting);
        this.gNs = (SettingTextImageView) this.gNn.findViewById(d.g.personInfo);
        this.gNt = (TbSettingTextTipView) this.gNn.findViewById(d.g.interest_label_setting);
        this.gNt.setTopLineVisibility(true);
        this.gNu = (TbSettingTextTipView) this.gNn.findViewById(d.g.accountManager);
        this.gNu.setTopLineVisibility(true);
        this.gNv = (TbSettingTextTipView) this.gNn.findViewById(d.g.browseSetting);
        this.gNv.setBottomLineVisibility(true);
        this.gNx = (TbSettingTextTipView) this.gNn.findViewById(d.g.messageSetting);
        this.gNx.setBottomLineVisibility(true);
        this.gNv.setBottomLineVisibility(true);
        this.gNy = (TbSettingTextTipView) this.gNn.findViewById(d.g.secretSetting);
        this.gNy.setBottomLineVisibility(true);
        this.gNz = (SettingTextVersionView) this.gNn.findViewById(d.g.versionInfo);
        this.gNA = (TbSettingTextTipView) this.gNn.findViewById(d.g.feedBack);
        this.gNA.setTopLineVisibility(true);
        this.gNA.setBottomLineVisibility(true);
        this.gNB = (TbSettingTextTipView) this.gNn.findViewById(d.g.recommend);
        this.gNw = (MsgSettingItemView) this.gNn.findViewById(d.g.memberAdSetting);
        bqY();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gNB.setVisibility(8);
            this.gNB.setBottomLineVisibility(false);
        } else {
            this.gNB.setVisibility(0);
            this.gNB.setBottomLineVisibility(true);
        }
        this.gNC = (TbSettingTextNewDotView) this.gNn.findViewById(d.g.systemhelpsetting);
        this.gND = (TextView) this.gNn.findViewById(d.g.quit);
        bqX();
        bqW();
        this.gNs.brW();
        hr(TbadkCoreApplication.getInst().getSkinType());
        P(clickListener);
        if (!bqu()) {
            this.gNv.setTip(this.gNn.getResources().getString(d.j.browsing_settings_tip_no_night));
        }
    }

    private void bqY() {
        int i;
        int i2 = 0;
        this.gNw.setText(d.j.member_ad_setting_text);
        this.gNw.setTipImageResource(d.f.label_red_svip);
        this.gNw.setOnSwitchStateChangeListener(this.gNn);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gNw.setVisibility(8);
        } else if (i2 == 0) {
            this.gNw.rI();
        } else {
            this.gNw.rH();
        }
    }

    public void bqZ() {
        this.gNw.rI();
    }

    public void bra() {
        this.gNw.rH();
    }

    private boolean bqu() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void bee() {
        this.gNq = LayoutInflater.from(this.gNn.getPageContext().getPageActivity()).inflate(d.h.quit_dialog, (ViewGroup) null);
        this.gNn.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gNn.getLayoutMode().aM(this.gNq);
        ((TextView) this.gNq.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.abk();
                d.this.gNo.uP(11);
            }
        });
        ((TextView) this.gNq.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.abk();
                d.this.gNo.uP(12);
            }
        });
        this.gNp = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gNp.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gNp, this.mContext.getPageActivity());
        if (this.gNp.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gNp.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gNp.getWindow().setAttributes(attributes);
            this.gNp.getWindow().setContentView(this.gNq);
        }
    }

    private void P(View.OnClickListener onClickListener) {
        this.gNr.setOnClickListener(onClickListener);
        this.gNF.setOnClickListener(onClickListener);
        this.gNs.setOnClickListener(onClickListener);
        this.gNt.setOnClickListener(onClickListener);
        this.gNu.setOnClickListener(onClickListener);
        this.gNv.setOnClickListener(onClickListener);
        this.gNx.setOnClickListener(onClickListener);
        this.gNy.setOnClickListener(onClickListener);
        this.gNz.setOnClickListener(onClickListener);
        this.gNA.setOnClickListener(onClickListener);
        this.gNB.setOnClickListener(onClickListener);
        this.gNC.setOnClickListener(onClickListener);
        this.gND.setOnClickListener(onClickListener);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gNF) {
                    d.this.gNo.uP(0);
                } else if (view == d.this.gNs) {
                    d.this.gNo.uP(1);
                } else if (view == d.this.gNt) {
                    d.this.gNo.uP(15);
                } else if (view == d.this.gNu) {
                    d.this.gNo.uP(2);
                } else if (view == d.this.gNv) {
                    d.this.gNo.uP(3);
                } else if (view == d.this.gNx) {
                    d.this.gNo.uP(4);
                } else if (view == d.this.gNy) {
                    d.this.gNo.uP(9);
                } else if (view == d.this.gNz) {
                    d.this.gNo.uP(6);
                } else if (view == d.this.gNA) {
                    d.this.gNo.uP(7);
                } else if (view == d.this.gNB) {
                    d.this.gNo.uP(8);
                } else if (view == d.this.gNC) {
                    d.this.gNo.uP(5);
                } else if (view == d.this.gND) {
                    d.this.gNo.uP(10);
                } else if (view == d.this.gNr) {
                    d.this.gNo.uP(13);
                }
            }
        };
    }

    public void brb() {
        if (this.gNp == null) {
            bee();
        }
        com.baidu.adp.lib.g.g.a(this.gNp, this.gNn.getPageContext());
    }

    public void abk() {
        if (this.gNp != null) {
            com.baidu.adp.lib.g.g.b(this.gNp, this.gNn.getPageContext());
        }
    }
}
