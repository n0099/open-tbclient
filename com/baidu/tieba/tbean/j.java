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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.GetIconList.Discount;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f<BuyTBeanActivity> implements TextWatcher, View.OnClickListener {
    private View Nn;
    private RelativeLayout aIK;
    private View aXv;
    private ViewGroup bWW;
    private BuyTBeanActivity eaa;
    private LinearLayoutDetectsSoftKeyboard ead;
    private NoNetworkView eae;
    private BdListView eaf;
    private d eag;
    private LinearLayout eah;
    private TextView eai;
    private LinearLayout eaj;
    private TBeanEditText eak;
    private TextView eal;
    private TextView eam;
    private TextView ean;
    private boolean eao;
    private boolean eap;
    private e eaq;
    private IconInfo ear;
    private int eas;
    private int eat;
    private int eau;
    private NavigationBar mNavigationBar;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.eat = 1;
        this.eaa = buyTBeanActivity;
        qD();
    }

    private void qD() {
        this.eaa.setContentView(t.h.buy_tbean_activity);
        this.ead = (LinearLayoutDetectsSoftKeyboard) this.eaa.findViewById(t.g.buy_tbean_root_ll);
        this.ead.setOnSoftKeyBoardShownListener(new k(this));
        this.aIK = (RelativeLayout) this.eaa.findViewById(t.g.container);
        this.eaf = (BdListView) this.eaa.findViewById(t.g.listview);
        this.bWW = (ViewGroup) this.eaa.findViewById(t.g.bottom_layout);
        this.mNavigationBar = (NavigationBar) this.eaa.findViewById(t.g.buy_tbean_navigation_bar);
        this.eae = (NoNetworkView) this.eaa.findViewById(t.g.buy_tbean_no_network);
        this.eae.a(new l(this));
        this.mNavigationBar.setTitleText(t.j.buy_tbean_title);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eal = (TextView) this.eaa.findViewById(t.g.buy_btn_tv);
        this.eal.setTag(this.ear);
        this.eal.setOnClickListener(this.eaa);
        this.eag = new d(this.eaa.getPageContext());
        this.eaf.setOnItemClickListener(new m(this));
        this.eam = (TextView) this.eaa.findViewById(t.g.gave_tbean_num_tv);
        this.ean = (TextView) this.eaa.findViewById(t.g.pay_money_tv);
        this.eah = (LinearLayout) this.eaa.findViewById(t.g.yinji_num_minus_ll);
        this.eaj = (LinearLayout) this.eaa.findViewById(t.g.yinji_num_plus_ll);
        this.eah.setOnClickListener(this);
        this.eaj.setOnClickListener(this);
        this.eai = (TextView) this.eaa.findViewById(t.g.minus_icon_tv);
        this.eak = (TBeanEditText) this.eaa.findViewById(t.g.yinji_num_et);
        this.eak.setText("1");
        this.eak.addTextChangedListener(this);
        this.eak.setOnFocusChangeListener(new n(this));
        this.eak.setOnClickListener(new o(this));
        this.Nn = this.eaa.findViewById(t.g.bottom_divider_line);
        this.eaf.setOnScrollListener(new p(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BdListView bdListView, ViewGroup viewGroup, int i) {
        int height;
        if (bdListView != null && viewGroup != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.bWW.getLocationOnScreen(iArr);
            viewGroup.getLocationOnScreen(iArr2);
            if (iArr != null && iArr.length == 2 && iArr2 != null && iArr2.length == 2 && (height = (iArr2[1] + viewGroup.getHeight()) - iArr[1]) > 0) {
                bdListView.setSelectionFromTop(Math.abs(((ViewGroup) bdListView.getChildAt(0)).getTop()) + height, i);
            }
        }
    }

    private void awn() {
        if (this.eaf != null) {
            if (this.aXv == null) {
                this.aXv = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.buy_tbean_list_footer, (ViewGroup) null);
            }
            if (this.eaf.getFooterViewsCount() > 0) {
                this.eaf.removeFooterView(this.aXv);
            }
            this.eaf.addFooterView(this.aXv, null, false);
        }
    }

    public void e(e eVar) {
        if (eVar == null || eVar.getIconInfoList() == null) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.no_data_tip);
            return;
        }
        this.eaq = eVar;
        this.ead.setVisibility(0);
        this.eag.a(eVar.getIconInfoList(), eVar.getUserInfo());
        this.eag.oy(aNU());
        this.eaf.setAdapter((ListAdapter) this.eag);
        awn();
        aNS();
        aNT();
    }

    public View getRootView() {
        return this.ead;
    }

    public void aNQ() {
        if (this.aIK != null && this.aIK.getVisibility() != 0) {
            this.aIK.setVisibility(0);
        }
    }

    public void aNR() {
        if (this.aIK != null && this.aIK.getVisibility() != 8) {
            this.aIK.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        ColorDrawable colorDrawable;
        if (this.eaa != null) {
            if (this.ead != null) {
                com.baidu.tbadk.i.a.a(this.eaa.getPageContext(), this.ead);
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            }
            if (this.eae != null) {
                this.eae.onChangeSkinType(getPageContext(), i);
            }
            if (this.aXv != null) {
                com.baidu.tbadk.i.a.a(this.eaa.getPageContext(), this.aXv);
            }
            if (this.eaf != null) {
                if (i == 1) {
                    colorDrawable = new ColorDrawable(this.eaa.getPageContext().getResources().getColor(t.d.cp_bg_line_c_1));
                } else {
                    colorDrawable = new ColorDrawable(this.eaa.getPageContext().getResources().getColor(t.d.cp_bg_line_c));
                }
                this.eaf.setDivider(colorDrawable);
                this.eaf.setDividerHeight(this.eaa.getPageContext().getResources().getDimensionPixelOffset(t.e.ds2));
            }
        }
    }

    private void aNS() {
        if (this.eat <= 1) {
            this.eat = 1;
        }
        if (this.eah != null && this.eai != null) {
            if (this.eat <= 1) {
                ar.k(this.eah, t.f.btn_buy_left_n);
                ar.k(this.eai, t.f.icon_pay_minus_n);
                return;
            }
            ar.k(this.eah, t.f.btn_buy_left_s);
            ar.k(this.eai, t.f.icon_pay_minus_s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNT() {
        if (this.ear != null && this.ean != null && this.eam != null && this.eal != null) {
            this.eas = oz(this.ear.dubi.intValue()) * this.eat;
            int a = a(this.ear) * this.eat;
            this.eau = a;
            String string = this.eaa.getPageContext().getPageActivity().getString(t.j.pay_money, new Object[]{String.valueOf(this.eas)});
            this.eam.setText(oC(a));
            this.ean.setText(mX(string));
            this.eal.setTag(this.ear);
        }
    }

    private SpannableString mX(String str) {
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, "¥", new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.c(this.eaa.getPageContext().getPageActivity(), t.e.fontsize28)));
        return spannableString;
    }

    private SpannableString oC(int i) {
        String oD = q.oD(i);
        Bitmap cO = ar.cO(t.f.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
        fVar.fi(com.baidu.adp.lib.util.k.c(this.eaa.getPageContext().getPageActivity(), t.e.ds4));
        fVar.fj(com.baidu.adp.lib.util.k.c(this.eaa.getPageContext().getPageActivity(), t.e.ds4));
        String str = String.valueOf("[image]") + oD;
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, "[image]", fVar);
        return spannableString;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g;
        if (view.getId() == t.g.yinji_num_minus_ll) {
            int g2 = com.baidu.adp.lib.h.b.g(this.eak.getText().toString(), 0);
            if (g2 > 1) {
                this.eak.setText(new StringBuilder(String.valueOf(g2 - 1)).toString());
                this.eak.setSelection(this.eak.getText().length());
            }
        } else if (view.getId() == t.g.yinji_num_plus_ll && (g = com.baidu.adp.lib.h.b.g(this.eak.getText().toString(), 0)) < 9999) {
            this.eak.setText(new StringBuilder(String.valueOf(g + 1)).toString());
            this.eak.setSelection(this.eak.getText().length());
        }
        aNS();
        aNT();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.ear != null) {
            this.eat = com.baidu.adp.lib.h.b.g(this.eak.getText().toString(), 0);
            if (this.eat <= 0) {
                this.eat = 1;
                this.eak.setText("1");
                this.eak.setSelection(this.eak.getText().length());
            }
            aNT();
        }
    }

    private int aNU() {
        IconInfo iconInfo;
        int i = 0;
        if (this.eaq != null && this.eaq.getIconInfoList() != null && this.eaa != null && this.eaq.getUserInfo() != null && this.eaq.getUserInfo().scores_total != null) {
            long aNJ = this.eaa.aNJ();
            int intValue = this.eaq.getUserInfo().scores_total.intValue();
            int size = this.eaq.getIconInfoList().size();
            int i2 = 0;
            while (i2 < size) {
                if (this.eaq.getIconInfoList().get(i2) != null && aNJ <= a(iconInfo) + intValue) {
                    break;
                }
                i2++;
                i++;
            }
            if (i > this.eaq.getIconInfoList().size() - 1) {
                i = this.eaq.getIconInfoList().size() - 1;
            }
            this.ear = this.eaq.getIconInfoList().get(i);
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        if (iconInfo == null || iconInfo.discount == null || this.eaq == null || this.eaq.getUserInfo() == null || this.eaq.getUserInfo().is_mem == null) {
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
        if (this.eaq.getUserInfo().is_mem.intValue() != 2) {
            intValue = iconInfo.non_member_t.intValue();
        }
        return intValue;
    }

    public int oz(int i) {
        return (int) (i / 100.0f);
    }

    public int aNV() {
        return this.eas;
    }

    public int aNW() {
        return this.eat;
    }

    public int aNX() {
        return this.eau;
    }

    public void aCG() {
        if (this.eao && !this.eap) {
            this.eak.clearFocus();
            com.baidu.adp.lib.util.k.c(this.eaa.getPageContext().getPageActivity(), this.eak);
            this.eao = false;
        }
    }

    public void hY(boolean z) {
        this.eap = z;
    }
}
