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
    private SettingTextVersionView gNA;
    private TbSettingTextTipView gNB;
    private TbSettingTextTipView gNC;
    private TbSettingTextNewDotView gND;
    private TextView gNE;
    private RelativeLayout gNF;
    private View gNG;
    private MoreActivity gNo;
    private c gNp;
    private AlertDialog gNq;
    private View gNr;
    private TbSettingTextTipView gNs;
    private SettingTextImageView gNt;
    private TbSettingTextTipView gNu;
    private TbSettingTextTipView gNv;
    private TbSettingTextTipView gNw;
    private MsgSettingItemView gNx;
    private TbSettingTextTipView gNy;
    private TbSettingTextTipView gNz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gNo = moreActivity;
        this.gNp = cVar;
        this.gNo.setContentView(d.h.more_activity);
        Jv();
    }

    public void bqW() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gNt.setVisibility(8);
        } else {
            this.gNt.setVisibility(0);
        }
    }

    public void W(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gNt != null) {
                this.gNt.brW();
                return;
            }
            return;
        }
        this.gNt.brX();
        this.gNt.X(str, z);
    }

    public void bqX() {
        if (this.gNA != null) {
            this.gNA.refresh();
        }
        if (this.gND != null) {
            this.gND.refresh();
        }
    }

    public void bpY() {
        this.gNt.recycle();
        this.gNu.recycle();
        this.gNv.recycle();
        this.gNw.recycle();
        this.gNy.recycle();
        this.gNz.recycle();
        this.gNA.recycle();
        this.gNB.recycle();
        this.gNC.recycle();
    }

    public void onChangeSkinType(int i) {
        hr(i);
        if (this.gNr != null) {
            this.gNo.getLayoutMode().aQ(i == 1);
            this.gNo.getLayoutMode().aM(this.gNr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void hr(int i) {
        aj.t(this.gNF, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNt.hr(i);
        this.gNo.getLayoutMode().aQ(i == 1);
        this.gNo.getLayoutMode().aM(this.gNF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNx.d(this.gNo.getPageContext(), i);
        bqX();
    }

    private void Jv() {
        View.OnClickListener clickListener = getClickListener();
        this.gNF = (RelativeLayout) this.gNo.findViewById(d.g.parent);
        this.gNo.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gNo.findViewById(d.g.view_navigation_bar);
        this.gNG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gNo.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gNs = (TbSettingTextTipView) this.gNo.findViewById(d.g.accountSafeSetting);
        this.gNt = (SettingTextImageView) this.gNo.findViewById(d.g.personInfo);
        this.gNu = (TbSettingTextTipView) this.gNo.findViewById(d.g.interest_label_setting);
        this.gNu.setTopLineVisibility(true);
        this.gNv = (TbSettingTextTipView) this.gNo.findViewById(d.g.accountManager);
        this.gNv.setTopLineVisibility(true);
        this.gNw = (TbSettingTextTipView) this.gNo.findViewById(d.g.browseSetting);
        this.gNw.setBottomLineVisibility(true);
        this.gNy = (TbSettingTextTipView) this.gNo.findViewById(d.g.messageSetting);
        this.gNy.setBottomLineVisibility(true);
        this.gNw.setBottomLineVisibility(true);
        this.gNz = (TbSettingTextTipView) this.gNo.findViewById(d.g.secretSetting);
        this.gNz.setBottomLineVisibility(true);
        this.gNA = (SettingTextVersionView) this.gNo.findViewById(d.g.versionInfo);
        this.gNB = (TbSettingTextTipView) this.gNo.findViewById(d.g.feedBack);
        this.gNB.setTopLineVisibility(true);
        this.gNB.setBottomLineVisibility(true);
        this.gNC = (TbSettingTextTipView) this.gNo.findViewById(d.g.recommend);
        this.gNx = (MsgSettingItemView) this.gNo.findViewById(d.g.memberAdSetting);
        bqY();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gNC.setVisibility(8);
            this.gNC.setBottomLineVisibility(false);
        } else {
            this.gNC.setVisibility(0);
            this.gNC.setBottomLineVisibility(true);
        }
        this.gND = (TbSettingTextNewDotView) this.gNo.findViewById(d.g.systemhelpsetting);
        this.gNE = (TextView) this.gNo.findViewById(d.g.quit);
        bqX();
        bqW();
        this.gNt.brW();
        hr(TbadkCoreApplication.getInst().getSkinType());
        P(clickListener);
        if (!bqu()) {
            this.gNw.setTip(this.gNo.getResources().getString(d.j.browsing_settings_tip_no_night));
        }
    }

    private void bqY() {
        int i;
        int i2 = 0;
        this.gNx.setText(d.j.member_ad_setting_text);
        this.gNx.setTipImageResource(d.f.label_red_svip);
        this.gNx.setOnSwitchStateChangeListener(this.gNo);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gNx.setVisibility(8);
        } else if (i2 == 0) {
            this.gNx.rI();
        } else {
            this.gNx.rH();
        }
    }

    public void bqZ() {
        this.gNx.rI();
    }

    public void bra() {
        this.gNx.rH();
    }

    private boolean bqu() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void bee() {
        this.gNr = LayoutInflater.from(this.gNo.getPageContext().getPageActivity()).inflate(d.h.quit_dialog, (ViewGroup) null);
        this.gNo.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gNo.getLayoutMode().aM(this.gNr);
        ((TextView) this.gNr.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.abk();
                d.this.gNp.uQ(11);
            }
        });
        ((TextView) this.gNr.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.abk();
                d.this.gNp.uQ(12);
            }
        });
        this.gNq = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gNq.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gNq, this.mContext.getPageActivity());
        if (this.gNq.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gNq.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gNq.getWindow().setAttributes(attributes);
            this.gNq.getWindow().setContentView(this.gNr);
        }
    }

    private void P(View.OnClickListener onClickListener) {
        this.gNs.setOnClickListener(onClickListener);
        this.gNG.setOnClickListener(onClickListener);
        this.gNt.setOnClickListener(onClickListener);
        this.gNu.setOnClickListener(onClickListener);
        this.gNv.setOnClickListener(onClickListener);
        this.gNw.setOnClickListener(onClickListener);
        this.gNy.setOnClickListener(onClickListener);
        this.gNz.setOnClickListener(onClickListener);
        this.gNA.setOnClickListener(onClickListener);
        this.gNB.setOnClickListener(onClickListener);
        this.gNC.setOnClickListener(onClickListener);
        this.gND.setOnClickListener(onClickListener);
        this.gNE.setOnClickListener(onClickListener);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gNG) {
                    d.this.gNp.uQ(0);
                } else if (view == d.this.gNt) {
                    d.this.gNp.uQ(1);
                } else if (view == d.this.gNu) {
                    d.this.gNp.uQ(15);
                } else if (view == d.this.gNv) {
                    d.this.gNp.uQ(2);
                } else if (view == d.this.gNw) {
                    d.this.gNp.uQ(3);
                } else if (view == d.this.gNy) {
                    d.this.gNp.uQ(4);
                } else if (view == d.this.gNz) {
                    d.this.gNp.uQ(9);
                } else if (view == d.this.gNA) {
                    d.this.gNp.uQ(6);
                } else if (view == d.this.gNB) {
                    d.this.gNp.uQ(7);
                } else if (view == d.this.gNC) {
                    d.this.gNp.uQ(8);
                } else if (view == d.this.gND) {
                    d.this.gNp.uQ(5);
                } else if (view == d.this.gNE) {
                    d.this.gNp.uQ(10);
                } else if (view == d.this.gNs) {
                    d.this.gNp.uQ(13);
                }
            }
        };
    }

    public void brb() {
        if (this.gNq == null) {
            bee();
        }
        com.baidu.adp.lib.g.g.a(this.gNq, this.gNo.getPageContext());
    }

    public void abk() {
        if (this.gNq != null) {
            com.baidu.adp.lib.g.g.b(this.gNq, this.gNo.getPageContext());
        }
    }
}
