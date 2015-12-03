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
    private View MF;
    private RelativeLayout aGi;
    private ViewGroup bPm;
    private LinearLayout dCA;
    private TextView dCB;
    private LinearLayout dCC;
    private TBeanEditText dCD;
    private TextView dCE;
    private TextView dCF;
    private TextView dCG;
    private boolean dCH;
    private boolean dCI;
    private e dCJ;
    private IconInfo dCK;
    private int dCL;
    private int dCM;
    private int dCN;
    private BuyTBeanActivity dCt;
    private LinearLayoutDetectsSoftKeyboard dCw;
    private NoNetworkView dCx;
    private BdListView dCy;
    private d dCz;
    private View mFooterView;
    private NavigationBar mNavigationBar;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.dCM = 1;
        this.dCt = buyTBeanActivity;
        initUI();
    }

    private void initUI() {
        this.dCt.setContentView(n.g.buy_tbean_activity);
        this.dCw = (LinearLayoutDetectsSoftKeyboard) this.dCt.findViewById(n.f.buy_tbean_root_ll);
        this.dCw.setOnSoftKeyBoardShownListener(new k(this));
        this.aGi = (RelativeLayout) this.dCt.findViewById(n.f.container);
        this.dCy = (BdListView) this.dCt.findViewById(n.f.listview);
        this.bPm = (ViewGroup) this.dCt.findViewById(n.f.bottom_layout);
        this.mNavigationBar = (NavigationBar) this.dCt.findViewById(n.f.buy_tbean_navigation_bar);
        this.dCx = (NoNetworkView) this.dCt.findViewById(n.f.buy_tbean_no_network);
        this.dCx.a(new l(this));
        this.mNavigationBar.setTitleText(n.i.buy_tbean_title);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dCE = (TextView) this.dCt.findViewById(n.f.buy_btn_tv);
        this.dCE.setTag(this.dCK);
        this.dCE.setOnClickListener(this.dCt);
        this.dCz = new d(this.dCt.getPageContext());
        this.dCy.setOnItemClickListener(new m(this));
        this.dCF = (TextView) this.dCt.findViewById(n.f.gave_tbean_num_tv);
        this.dCG = (TextView) this.dCt.findViewById(n.f.pay_money_tv);
        this.dCA = (LinearLayout) this.dCt.findViewById(n.f.yinji_num_minus_ll);
        this.dCC = (LinearLayout) this.dCt.findViewById(n.f.yinji_num_plus_ll);
        this.dCA.setOnClickListener(this);
        this.dCC.setOnClickListener(this);
        this.dCB = (TextView) this.dCt.findViewById(n.f.minus_icon_tv);
        this.dCD = (TBeanEditText) this.dCt.findViewById(n.f.yinji_num_et);
        this.dCD.setText("1");
        this.dCD.addTextChangedListener(this);
        this.dCD.setOnFocusChangeListener(new n(this));
        this.dCD.setOnClickListener(new o(this));
        this.MF = this.dCt.findViewById(n.f.bottom_divider_line);
        this.dCy.setOnScrollListener(new p(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BdListView bdListView, ViewGroup viewGroup, int i) {
        int height;
        if (bdListView != null && viewGroup != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.bPm.getLocationOnScreen(iArr);
            viewGroup.getLocationOnScreen(iArr2);
            if (iArr != null && iArr.length == 2 && iArr2 != null && iArr2.length == 2 && (height = (iArr2[1] + viewGroup.getHeight()) - iArr[1]) > 0) {
                bdListView.setSelectionFromTop(Math.abs(((ViewGroup) bdListView.getChildAt(0)).getTop()) + height, i);
            }
        }
    }

    private void TW() {
        if (this.dCy != null) {
            if (this.mFooterView == null) {
                this.mFooterView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.buy_tbean_list_footer, (ViewGroup) null);
            }
            if (this.dCy.getFooterViewsCount() > 0) {
                this.dCy.removeFooterView(this.mFooterView);
            }
            this.dCy.addFooterView(this.mFooterView, null, false);
        }
    }

    public void e(e eVar) {
        if (eVar == null || eVar.getIconInfoList() == null) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), n.i.no_data_tip);
            return;
        }
        this.dCJ = eVar;
        this.dCw.setVisibility(0);
        this.dCz.a(eVar.getIconInfoList(), eVar.getUserInfo());
        this.dCz.mI(aEC());
        this.dCy.setAdapter((ListAdapter) this.dCz);
        TW();
        aEA();
        aEB();
    }

    public View getRootView() {
        return this.dCw;
    }

    public void aEy() {
        if (this.aGi != null && this.aGi.getVisibility() != 0) {
            this.aGi.setVisibility(0);
        }
    }

    public void aEz() {
        if (this.aGi != null && this.aGi.getVisibility() != 8) {
            this.aGi.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        ColorDrawable colorDrawable;
        if (this.dCt != null) {
            if (this.dCw != null) {
                com.baidu.tbadk.i.a.a(this.dCt.getPageContext(), this.dCw);
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            }
            if (this.dCx != null) {
                this.dCx.onChangeSkinType(getPageContext(), i);
            }
            if (this.mFooterView != null) {
                com.baidu.tbadk.i.a.a(this.dCt.getPageContext(), this.mFooterView);
            }
            if (this.dCy != null) {
                if (i == 1) {
                    colorDrawable = new ColorDrawable(this.dCt.getPageContext().getResources().getColor(n.c.cp_bg_line_c_1));
                } else {
                    colorDrawable = new ColorDrawable(this.dCt.getPageContext().getResources().getColor(n.c.cp_bg_line_c));
                }
                this.dCy.setDivider(colorDrawable);
                this.dCy.setDividerHeight(this.dCt.getPageContext().getResources().getDimensionPixelOffset(n.d.ds2));
            }
        }
    }

    private void aEA() {
        if (this.dCM <= 1) {
            this.dCM = 1;
        }
        if (this.dCA != null && this.dCB != null) {
            if (this.dCM <= 1) {
                as.i(this.dCA, n.e.btn_buy_left_n);
                as.i((View) this.dCB, n.e.icon_pay_minus_n);
                return;
            }
            as.i(this.dCA, n.e.btn_buy_left_s);
            as.i((View) this.dCB, n.e.icon_pay_minus_s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEB() {
        if (this.dCK != null && this.dCG != null && this.dCF != null && this.dCE != null) {
            this.dCL = mJ(this.dCK.dubi.intValue()) * this.dCM;
            int a = a(this.dCK) * this.dCM;
            this.dCN = a;
            String string = this.dCt.getPageContext().getPageActivity().getString(n.i.pay_money, new Object[]{String.valueOf(this.dCL)});
            this.dCF.setText(mM(a));
            this.dCG.setText(mJ(string));
            this.dCE.setTag(this.dCK);
        }
    }

    private SpannableString mJ(String str) {
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, "¥", new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.d(this.dCt.getPageContext().getPageActivity(), n.d.fontsize28)));
        return spannableString;
    }

    private SpannableString mM(int i) {
        String mN = q.mN(i);
        Bitmap cE = as.cE(n.e.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
        bitmapDrawable.setBounds(0, 0, cE.getWidth(), cE.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
        fVar.eT(com.baidu.adp.lib.util.k.d(this.dCt.getPageContext().getPageActivity(), n.d.ds4));
        fVar.eU(com.baidu.adp.lib.util.k.d(this.dCt.getPageContext().getPageActivity(), n.d.ds4));
        String str = String.valueOf("[image]") + mN;
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, "[image]", fVar);
        return spannableString;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g;
        if (view.getId() == n.f.yinji_num_minus_ll) {
            int g2 = com.baidu.adp.lib.h.b.g(this.dCD.getText().toString(), 0);
            if (g2 > 1) {
                this.dCD.setText(new StringBuilder(String.valueOf(g2 - 1)).toString());
                this.dCD.setSelection(this.dCD.getText().length());
            }
        } else if (view.getId() == n.f.yinji_num_plus_ll && (g = com.baidu.adp.lib.h.b.g(this.dCD.getText().toString(), 0)) < 9999) {
            this.dCD.setText(new StringBuilder(String.valueOf(g + 1)).toString());
            this.dCD.setSelection(this.dCD.getText().length());
        }
        aEA();
        aEB();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.dCK != null) {
            this.dCM = com.baidu.adp.lib.h.b.g(this.dCD.getText().toString(), 0);
            if (this.dCM <= 0) {
                this.dCM = 1;
                this.dCD.setText("1");
                this.dCD.setSelection(this.dCD.getText().length());
            }
            aEB();
        }
    }

    private int aEC() {
        IconInfo iconInfo;
        int i = 0;
        if (this.dCJ != null && this.dCJ.getIconInfoList() != null && this.dCt != null && this.dCJ.getUserInfo() != null && this.dCJ.getUserInfo().scores_total != null) {
            long aEr = this.dCt.aEr();
            int intValue = this.dCJ.getUserInfo().scores_total.intValue();
            int size = this.dCJ.getIconInfoList().size();
            int i2 = 0;
            while (i2 < size) {
                if (this.dCJ.getIconInfoList().get(i2) != null && aEr <= a(iconInfo) + intValue) {
                    break;
                }
                i2++;
                i++;
            }
            if (i > this.dCJ.getIconInfoList().size() - 1) {
                i = this.dCJ.getIconInfoList().size() - 1;
            }
            this.dCK = this.dCJ.getIconInfoList().get(i);
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        if (iconInfo == null || iconInfo.discount == null || this.dCJ == null || this.dCJ.getUserInfo() == null || this.dCJ.getUserInfo().is_mem == null) {
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
        if (this.dCJ.getUserInfo().is_mem.intValue() != 2) {
            intValue = iconInfo.non_member_t.intValue();
        }
        return intValue;
    }

    public int mJ(int i) {
        return (int) (i / 100.0f);
    }

    public int aED() {
        return this.dCL;
    }

    public int aEE() {
        return this.dCM;
    }

    public int aEF() {
        return this.dCN;
    }

    public void aus() {
        if (this.dCH && !this.dCI) {
            this.dCD.clearFocus();
            com.baidu.adp.lib.util.k.c(this.dCt.getPageContext().getPageActivity(), this.dCD);
            this.dCH = false;
        }
    }

    public void ho(boolean z) {
        this.dCI = z;
    }
}
