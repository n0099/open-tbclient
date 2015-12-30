package com.baidu.tieba.tbean;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.GetIconList.Discount;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f<BuyTBeanActivity> implements TextWatcher, View.OnClickListener {
    private View MV;
    private RelativeLayout aHI;
    private ViewGroup bSS;
    private BuyTBeanActivity dJV;
    private LinearLayoutDetectsSoftKeyboard dJY;
    private NoNetworkView dJZ;
    private BdListView dKa;
    private d dKb;
    private LinearLayout dKc;
    private TextView dKd;
    private LinearLayout dKe;
    private TBeanEditText dKf;
    private TextView dKg;
    private TextView dKh;
    private TextView dKi;
    private boolean dKj;
    private boolean dKk;
    private e dKl;
    private IconInfo dKm;
    private int dKn;
    private int dKo;
    private int dKp;
    private View mFooterView;
    private NavigationBar mNavigationBar;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.dKo = 1;
        this.dJV = buyTBeanActivity;
        initUI();
    }

    private void initUI() {
        this.dJV.setContentView(n.h.buy_tbean_activity);
        this.dJY = (LinearLayoutDetectsSoftKeyboard) this.dJV.findViewById(n.g.buy_tbean_root_ll);
        this.dJY.setOnSoftKeyBoardShownListener(new k(this));
        this.aHI = (RelativeLayout) this.dJV.findViewById(n.g.container);
        this.dKa = (BdListView) this.dJV.findViewById(n.g.listview);
        this.bSS = (ViewGroup) this.dJV.findViewById(n.g.bottom_layout);
        this.mNavigationBar = (NavigationBar) this.dJV.findViewById(n.g.buy_tbean_navigation_bar);
        this.dJZ = (NoNetworkView) this.dJV.findViewById(n.g.buy_tbean_no_network);
        this.dJZ.a(new l(this));
        this.mNavigationBar.setTitleText(n.j.buy_tbean_title);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dKg = (TextView) this.dJV.findViewById(n.g.buy_btn_tv);
        this.dKg.setTag(this.dKm);
        this.dKg.setOnClickListener(this.dJV);
        this.dKb = new d(this.dJV.getPageContext());
        this.dKa.setOnItemClickListener(new m(this));
        this.dKh = (TextView) this.dJV.findViewById(n.g.gave_tbean_num_tv);
        this.dKi = (TextView) this.dJV.findViewById(n.g.pay_money_tv);
        this.dKc = (LinearLayout) this.dJV.findViewById(n.g.yinji_num_minus_ll);
        this.dKe = (LinearLayout) this.dJV.findViewById(n.g.yinji_num_plus_ll);
        this.dKc.setOnClickListener(this);
        this.dKe.setOnClickListener(this);
        this.dKd = (TextView) this.dJV.findViewById(n.g.minus_icon_tv);
        this.dKf = (TBeanEditText) this.dJV.findViewById(n.g.yinji_num_et);
        this.dKf.setText("1");
        this.dKf.addTextChangedListener(this);
        this.dKf.setOnFocusChangeListener(new n(this));
        this.dKf.setOnClickListener(new o(this));
        this.MV = this.dJV.findViewById(n.g.bottom_divider_line);
        this.dKa.setOnScrollListener(new p(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BdListView bdListView, ViewGroup viewGroup, int i) {
        int height;
        if (bdListView != null && viewGroup != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.bSS.getLocationOnScreen(iArr);
            viewGroup.getLocationOnScreen(iArr2);
            if (iArr != null && iArr.length == 2 && iArr2 != null && iArr2.length == 2 && (height = (iArr2[1] + viewGroup.getHeight()) - iArr[1]) > 0) {
                bdListView.setSelectionFromTop(Math.abs(((ViewGroup) bdListView.getChildAt(0)).getTop()) + height, i);
            }
        }
    }

    private void aqW() {
        if (this.dKa != null) {
            if (this.mFooterView == null) {
                this.mFooterView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.buy_tbean_list_footer, (ViewGroup) null);
            }
            if (this.dKa.getFooterViewsCount() > 0) {
                this.dKa.removeFooterView(this.mFooterView);
            }
            this.dKa.addFooterView(this.mFooterView, null, false);
        }
    }

    public void e(e eVar) {
        if (eVar == null || eVar.getIconInfoList() == null) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), n.j.no_data_tip);
            return;
        }
        this.dKl = eVar;
        this.dJY.setVisibility(0);
        this.dKb.a(eVar.getIconInfoList(), eVar.getUserInfo());
        this.dKb.nk(aGQ());
        this.dKa.setAdapter((ListAdapter) this.dKb);
        aqW();
        aGO();
        aGP();
    }

    public View getRootView() {
        return this.dJY;
    }

    public void aGM() {
        if (this.aHI != null && this.aHI.getVisibility() != 0) {
            this.aHI.setVisibility(0);
        }
    }

    public void aGN() {
        if (this.aHI != null && this.aHI.getVisibility() != 8) {
            this.aHI.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        ColorDrawable colorDrawable;
        if (this.dJV != null) {
            if (this.dJY != null) {
                com.baidu.tbadk.i.a.a(this.dJV.getPageContext(), this.dJY);
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            }
            if (this.dJZ != null) {
                this.dJZ.onChangeSkinType(getPageContext(), i);
            }
            if (this.mFooterView != null) {
                com.baidu.tbadk.i.a.a(this.dJV.getPageContext(), this.mFooterView);
            }
            if (this.dKa != null) {
                if (i == 1) {
                    colorDrawable = new ColorDrawable(this.dJV.getPageContext().getResources().getColor(n.d.cp_bg_line_c_1));
                } else {
                    colorDrawable = new ColorDrawable(this.dJV.getPageContext().getResources().getColor(n.d.cp_bg_line_c));
                }
                this.dKa.setDivider(colorDrawable);
                this.dKa.setDividerHeight(this.dJV.getPageContext().getResources().getDimensionPixelOffset(n.e.ds2));
            }
        }
    }

    private void aGO() {
        if (this.dKo <= 1) {
            this.dKo = 1;
        }
        if (this.dKc != null && this.dKd != null) {
            if (this.dKo <= 1) {
                as.i(this.dKc, n.f.btn_buy_left_n);
                as.i((View) this.dKd, n.f.icon_pay_minus_n);
                return;
            }
            as.i(this.dKc, n.f.btn_buy_left_s);
            as.i((View) this.dKd, n.f.icon_pay_minus_s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGP() {
        if (this.dKm != null && this.dKi != null && this.dKh != null && this.dKg != null) {
            this.dKn = nl(this.dKm.dubi.intValue()) * this.dKo;
            int a = a(this.dKm) * this.dKo;
            this.dKp = a;
            String string = this.dJV.getPageContext().getPageActivity().getString(n.j.pay_money, new Object[]{String.valueOf(this.dKn)});
            this.dKh.setText(no(a));
            this.dKi.setText(mG(string));
            this.dKg.setTag(this.dKm);
        }
    }

    private SpannableString mG(String str) {
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, "¥", new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.d(this.dJV.getPageContext().getPageActivity(), n.e.fontsize28)));
        return spannableString;
    }

    private SpannableString no(int i) {
        String np = q.np(i);
        Bitmap cx = as.cx(n.f.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
        bitmapDrawable.setBounds(0, 0, cx.getWidth(), cx.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
        fVar.eN(com.baidu.adp.lib.util.k.d(this.dJV.getPageContext().getPageActivity(), n.e.ds4));
        fVar.eO(com.baidu.adp.lib.util.k.d(this.dJV.getPageContext().getPageActivity(), n.e.ds4));
        String str = String.valueOf("[image]") + np;
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, "[image]", fVar);
        return spannableString;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g;
        if (view.getId() == n.g.yinji_num_minus_ll) {
            int g2 = com.baidu.adp.lib.h.b.g(this.dKf.getText().toString(), 0);
            if (g2 > 1) {
                this.dKf.setText(new StringBuilder(String.valueOf(g2 - 1)).toString());
                this.dKf.setSelection(this.dKf.getText().length());
            }
        } else if (view.getId() == n.g.yinji_num_plus_ll && (g = com.baidu.adp.lib.h.b.g(this.dKf.getText().toString(), 0)) < 9999) {
            this.dKf.setText(new StringBuilder(String.valueOf(g + 1)).toString());
            this.dKf.setSelection(this.dKf.getText().length());
        }
        aGO();
        aGP();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.dKm != null) {
            this.dKo = com.baidu.adp.lib.h.b.g(this.dKf.getText().toString(), 0);
            if (this.dKo <= 0) {
                this.dKo = 1;
                this.dKf.setText("1");
                this.dKf.setSelection(this.dKf.getText().length());
            }
            aGP();
        }
    }

    private int aGQ() {
        IconInfo iconInfo;
        int i = 0;
        if (this.dKl != null && this.dKl.getIconInfoList() != null && this.dJV != null && this.dKl.getUserInfo() != null && this.dKl.getUserInfo().scores_total != null) {
            long aGF = this.dJV.aGF();
            int intValue = this.dKl.getUserInfo().scores_total.intValue();
            int size = this.dKl.getIconInfoList().size();
            int i2 = 0;
            while (i2 < size) {
                if (this.dKl.getIconInfoList().get(i2) != null && aGF <= a(iconInfo) + intValue) {
                    break;
                }
                i2++;
                i++;
            }
            if (i > this.dKl.getIconInfoList().size() - 1) {
                i = this.dKl.getIconInfoList().size() - 1;
            }
            this.dKm = this.dKl.getIconInfoList().get(i);
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        if (iconInfo == null || iconInfo.discount == null || this.dKl == null || this.dKl.getUserInfo() == null || this.dKl.getUserInfo().is_mem == null) {
            return 0;
        }
        List<Discount> list = iconInfo.discount;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Discount discount = list.get(i);
            if (discount != null && iconInfo.non_member_t != null && discount.recharge != null && iconInfo.non_member_t.intValue() <= discount.recharge.intValue()) {
                break;
            }
            i++;
            i2++;
        }
        Discount discount2 = list.get(i2 > size + (-1) ? size - 1 : i2);
        int intValue = (discount2 == null || iconInfo.non_member_t == null || discount2.rebate == null) ? 0 : (discount2.rebate.intValue() * iconInfo.non_member_t.intValue()) / 100;
        if (this.dKl.getUserInfo().is_mem.intValue() != 2) {
            intValue = iconInfo.non_member_t.intValue();
        }
        return intValue;
    }

    public int nl(int i) {
        return (int) (i / 100.0f);
    }

    public int aGR() {
        return this.dKn;
    }

    public int aGS() {
        return this.dKo;
    }

    public int aGT() {
        return this.dKp;
    }

    public void awl() {
        if (this.dKj && !this.dKk) {
            this.dKf.clearFocus();
            com.baidu.adp.lib.util.k.c(this.dJV.getPageContext().getPageActivity(), this.dKf);
            this.dKj = false;
        }
    }

    public void hx(boolean z) {
        this.dKk = z;
    }
}
