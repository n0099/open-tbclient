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
    private MoreActivity gMY;
    private c gMZ;
    private AlertDialog gNa;
    private View gNb;
    private TbSettingTextTipView gNc;
    private SettingTextImageView gNd;
    private TbSettingTextTipView gNe;
    private TbSettingTextTipView gNf;
    private TbSettingTextTipView gNg;
    private MsgSettingItemView gNh;
    private TbSettingTextTipView gNi;
    private TbSettingTextTipView gNj;
    private SettingTextVersionView gNk;
    private TbSettingTextTipView gNl;
    private TbSettingTextTipView gNm;
    private TbSettingTextNewDotView gNn;
    private TextView gNo;
    private RelativeLayout gNp;
    private View gNq;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gMY = moreActivity;
        this.gMZ = cVar;
        this.gMY.setContentView(d.h.more_activity);
        Ju();
    }

    public void bqV() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gNd.setVisibility(8);
        } else {
            this.gNd.setVisibility(0);
        }
    }

    public void W(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gNd != null) {
                this.gNd.brV();
                return;
            }
            return;
        }
        this.gNd.brW();
        this.gNd.X(str, z);
    }

    public void bqW() {
        if (this.gNk != null) {
            this.gNk.refresh();
        }
        if (this.gNn != null) {
            this.gNn.refresh();
        }
    }

    public void bpX() {
        this.gNd.recycle();
        this.gNe.recycle();
        this.gNf.recycle();
        this.gNg.recycle();
        this.gNi.recycle();
        this.gNj.recycle();
        this.gNk.recycle();
        this.gNl.recycle();
        this.gNm.recycle();
    }

    public void onChangeSkinType(int i) {
        hr(i);
        if (this.gNb != null) {
            this.gMY.getLayoutMode().aQ(i == 1);
            this.gMY.getLayoutMode().aM(this.gNb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void hr(int i) {
        aj.t(this.gNp, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNd.hr(i);
        this.gMY.getLayoutMode().aQ(i == 1);
        this.gMY.getLayoutMode().aM(this.gNp);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gNh.d(this.gMY.getPageContext(), i);
        bqW();
    }

    private void Ju() {
        View.OnClickListener clickListener = getClickListener();
        this.gNp = (RelativeLayout) this.gMY.findViewById(d.g.parent);
        this.gMY.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gMY.findViewById(d.g.view_navigation_bar);
        this.gNq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gMY.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gNc = (TbSettingTextTipView) this.gMY.findViewById(d.g.accountSafeSetting);
        this.gNd = (SettingTextImageView) this.gMY.findViewById(d.g.personInfo);
        this.gNe = (TbSettingTextTipView) this.gMY.findViewById(d.g.interest_label_setting);
        this.gNe.setTopLineVisibility(true);
        this.gNf = (TbSettingTextTipView) this.gMY.findViewById(d.g.accountManager);
        this.gNf.setTopLineVisibility(true);
        this.gNg = (TbSettingTextTipView) this.gMY.findViewById(d.g.browseSetting);
        this.gNg.setBottomLineVisibility(true);
        this.gNi = (TbSettingTextTipView) this.gMY.findViewById(d.g.messageSetting);
        this.gNi.setBottomLineVisibility(true);
        this.gNg.setBottomLineVisibility(true);
        this.gNj = (TbSettingTextTipView) this.gMY.findViewById(d.g.secretSetting);
        this.gNj.setBottomLineVisibility(true);
        this.gNk = (SettingTextVersionView) this.gMY.findViewById(d.g.versionInfo);
        this.gNl = (TbSettingTextTipView) this.gMY.findViewById(d.g.feedBack);
        this.gNl.setTopLineVisibility(true);
        this.gNl.setBottomLineVisibility(true);
        this.gNm = (TbSettingTextTipView) this.gMY.findViewById(d.g.recommend);
        this.gNh = (MsgSettingItemView) this.gMY.findViewById(d.g.memberAdSetting);
        bqX();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gNm.setVisibility(8);
            this.gNm.setBottomLineVisibility(false);
        } else {
            this.gNm.setVisibility(0);
            this.gNm.setBottomLineVisibility(true);
        }
        this.gNn = (TbSettingTextNewDotView) this.gMY.findViewById(d.g.systemhelpsetting);
        this.gNo = (TextView) this.gMY.findViewById(d.g.quit);
        bqW();
        bqV();
        this.gNd.brV();
        hr(TbadkCoreApplication.getInst().getSkinType());
        P(clickListener);
        if (!bqt()) {
            this.gNg.setTip(this.gMY.getResources().getString(d.j.browsing_settings_tip_no_night));
        }
    }

    private void bqX() {
        int i;
        int i2 = 0;
        this.gNh.setText(d.j.member_ad_setting_text);
        this.gNh.setTipImageResource(d.f.label_red_svip);
        this.gNh.setOnSwitchStateChangeListener(this.gMY);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gNh.setVisibility(8);
        } else if (i2 == 0) {
            this.gNh.rI();
        } else {
            this.gNh.rH();
        }
    }

    public void bqY() {
        this.gNh.rI();
    }

    public void bqZ() {
        this.gNh.rH();
    }

    private boolean bqt() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void bed() {
        this.gNb = LayoutInflater.from(this.gMY.getPageContext().getPageActivity()).inflate(d.h.quit_dialog, (ViewGroup) null);
        this.gMY.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gMY.getLayoutMode().aM(this.gNb);
        ((TextView) this.gNb.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.abj();
                d.this.gMZ.uQ(11);
            }
        });
        ((TextView) this.gNb.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.abj();
                d.this.gMZ.uQ(12);
            }
        });
        this.gNa = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gNa.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gNa, this.mContext.getPageActivity());
        if (this.gNa.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gNa.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gNa.getWindow().setAttributes(attributes);
            this.gNa.getWindow().setContentView(this.gNb);
        }
    }

    private void P(View.OnClickListener onClickListener) {
        this.gNc.setOnClickListener(onClickListener);
        this.gNq.setOnClickListener(onClickListener);
        this.gNd.setOnClickListener(onClickListener);
        this.gNe.setOnClickListener(onClickListener);
        this.gNf.setOnClickListener(onClickListener);
        this.gNg.setOnClickListener(onClickListener);
        this.gNi.setOnClickListener(onClickListener);
        this.gNj.setOnClickListener(onClickListener);
        this.gNk.setOnClickListener(onClickListener);
        this.gNl.setOnClickListener(onClickListener);
        this.gNm.setOnClickListener(onClickListener);
        this.gNn.setOnClickListener(onClickListener);
        this.gNo.setOnClickListener(onClickListener);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gNq) {
                    d.this.gMZ.uQ(0);
                } else if (view == d.this.gNd) {
                    d.this.gMZ.uQ(1);
                } else if (view == d.this.gNe) {
                    d.this.gMZ.uQ(15);
                } else if (view == d.this.gNf) {
                    d.this.gMZ.uQ(2);
                } else if (view == d.this.gNg) {
                    d.this.gMZ.uQ(3);
                } else if (view == d.this.gNi) {
                    d.this.gMZ.uQ(4);
                } else if (view == d.this.gNj) {
                    d.this.gMZ.uQ(9);
                } else if (view == d.this.gNk) {
                    d.this.gMZ.uQ(6);
                } else if (view == d.this.gNl) {
                    d.this.gMZ.uQ(7);
                } else if (view == d.this.gNm) {
                    d.this.gMZ.uQ(8);
                } else if (view == d.this.gNn) {
                    d.this.gMZ.uQ(5);
                } else if (view == d.this.gNo) {
                    d.this.gMZ.uQ(10);
                } else if (view == d.this.gNc) {
                    d.this.gMZ.uQ(13);
                }
            }
        };
    }

    public void bra() {
        if (this.gNa == null) {
            bed();
        }
        com.baidu.adp.lib.g.g.a(this.gNa, this.gMY.getPageContext());
    }

    public void abj() {
        if (this.gNa != null) {
            com.baidu.adp.lib.g.g.b(this.gNa, this.gMY.getPageContext());
        }
    }
}
