package com.baidu.tieba.tbean;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
import tbclient.GetIconList.Discount;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f implements TextWatcher, View.OnClickListener {
    private int aUv;
    private TextView bNK;
    private BuyTBeanActivity bNP;
    private CustomScrollView bNS;
    private NavigationBar bNT;
    private NoNetworkView bNU;
    private HorizontalListView bNV;
    private LinearLayoutDetectsSoftKeyboard bNW;
    private b bNX;
    private TextView bNY;
    private LinearLayout bNZ;
    private LinearLayout bOa;
    private TextView bOb;
    private EditText bOc;
    private TextView bOd;
    private TextView bOe;
    private TextView bOf;
    private boolean bOg;
    private boolean bOh;
    private d bOi;
    private int bOj;
    private int bOk;
    private int bOl;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity);
        this.bNP = buyTBeanActivity;
        initUI();
        this.bNP.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.bNP.setContentView(w.buy_tbean_activity);
        this.bNW = (LinearLayoutDetectsSoftKeyboard) this.bNP.findViewById(v.buy_tbean_root_ll);
        this.bNW.setOnSoftKeyBoardShownListener(new k(this));
        this.bNS = (CustomScrollView) this.bNP.findViewById(v.buy_tbean_scroll_view);
        this.bNV = (HorizontalListView) this.bNP.findViewById(v.tbean_listview);
        this.bNT = (NavigationBar) this.bNP.findViewById(v.buy_tbean_navigation_bar);
        this.bNU = (NoNetworkView) this.bNP.findViewById(v.buy_tbean_no_network);
        this.bNU.a(new l(this));
        this.bNT.setTitleText(y.buy_tbean_title);
        this.bNT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bNX = new b(this);
        this.bNV.setAdapter((ListAdapter) this.bNX);
        this.bNV.setOnItemClickListener(new m(this));
        this.bNY = (TextView) this.bNP.findViewById(v.dq_num_tv);
        this.bNY.setText(hq(0));
        this.bOb = (TextView) this.bNP.findViewById(v.yinji_time_tv);
        this.bNZ = (LinearLayout) this.bNP.findViewById(v.yinji_num_minus_ll);
        this.bOa = (LinearLayout) this.bNP.findViewById(v.yinji_num_plus_ll);
        this.bNZ.setOnClickListener(this);
        this.bOa.setOnClickListener(this);
        this.bOc = (EditText) this.bNP.findViewById(v.yinji_num_et);
        this.bOc.setText("1");
        this.bOc.addTextChangedListener(this);
        this.bOc.setOnFocusChangeListener(new n(this));
        this.bOc.setOnClickListener(new o(this));
        this.bNK = (TextView) this.bNP.findViewById(v.tbean_num_tv);
        this.bOd = (TextView) this.bNP.findViewById(v.buy_btn_tv);
        this.bOd.setOnClickListener(this.bNP);
        this.bOe = (TextView) this.bNP.findViewById(v.bottom_tip_tv);
        this.bOe.setOnClickListener(this.bNP);
        this.bOf = (TextView) this.bNP.findViewById(v.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.bOi = dVar;
            this.bNS.setVisibility(0);
            this.bNX.setData(dVar.getIconInfoList());
            this.aUv = adU();
            this.bNX.hp(this.aUv);
            this.bNP.mHandler.postDelayed(new p(this), 300L);
            aaJ();
            adS();
            this.bNX.notifyDataSetChanged();
        }
    }

    private void adS() {
        if (this.bNP != null && this.bOi != null && this.bOi.getUserInfo() != null) {
            int adM = this.bNP.adM();
            int intValue = this.bOi.getUserInfo().scores_total.intValue();
            if (adM <= 0 || intValue >= adM) {
                this.bOf.setVisibility(4);
            } else if (this.bOi.getUserInfo().scores_total.intValue() < this.bNP.adM()) {
                this.bOf.setVisibility(0);
                this.bOf.setText(hr(adM - intValue));
            }
        }
    }

    public void adT() {
        this.bNS.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.bNP.getLayoutMode().L(i == 1);
        this.bNP.getLayoutMode().h(this.bNW);
        this.bNT.onChangeSkinType(i);
        this.bNU.onChangeSkinType(i);
    }

    private SpannableString hq(int i) {
        String str;
        String str2 = String.valueOf(this.bNP.getString(y.dq_left_bracket)) + " " + i + this.bNP.getString(y.dq_right_bracket);
        int length = (String.valueOf(this.bNP.getString(y.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString hr(int i) {
        String string = this.bNP.getString(y.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(i)).toString();
        String string2 = this.bNP.getString(y.tbean_title);
        int length = string.length();
        int length2 = sb.length();
        int length3 = string2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + sb + string2);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_d)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_link_tip_a)), length, length + length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_d)), length + length2, length + length2 + length3, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaJ() {
        IconInfo iconInfo;
        if (this.bOi != null && this.bOi.getIconInfoList() != null && this.aUv >= 0 && this.aUv < this.bOi.getIconInfoList().size() && (iconInfo = this.bOi.getIconInfoList().get(this.aUv)) != null) {
            this.bOc.setText("1");
            this.bNK.setText(String.valueOf(this.bNP.getString(y.get_tbean_title)) + " " + a(iconInfo));
            this.bNY.setText(hq(hs(iconInfo.dubi.intValue())));
            this.bOj = hs(iconInfo.dubi.intValue());
            this.bOb.setText(String.format(getString(y.yinji_valid_time), iconInfo.duration));
            this.bOe.setText(String.valueOf(String.format(getString(y.super_mem_tbean_tip), Integer.valueOf(this.bOl))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int f;
        if (view.getId() == v.yinji_num_minus_ll) {
            int f2 = com.baidu.adp.lib.g.c.f(this.bOc.getText().toString(), 0);
            if (f2 > 1) {
                this.bOc.setText(new StringBuilder(String.valueOf(f2 - 1)).toString());
                this.bOc.setSelection(this.bOc.getText().length());
            }
        } else if (view.getId() == v.yinji_num_plus_ll && (f = com.baidu.adp.lib.g.c.f(this.bOc.getText().toString(), 0)) < 9999) {
            this.bOc.setText(new StringBuilder(String.valueOf(f + 1)).toString());
            this.bOc.setSelection(this.bOc.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.bOi != null && this.bOi.getIconInfoList() != null && this.aUv >= 0 && this.aUv < this.bOi.getIconInfoList().size() && (iconInfo = this.bOi.getIconInfoList().get(this.aUv)) != null) {
            this.bOk = com.baidu.adp.lib.g.c.f(this.bOc.getText().toString(), 0);
            if (this.bOk == 0) {
                this.bOc.setText("1");
                this.bOc.setSelection(this.bOc.getText().length());
            }
            this.bNK.setText(String.valueOf(this.bNP.getString(y.get_tbean_title)) + " " + (a(iconInfo) * this.bOk));
            this.bNY.setText(hq(hs(iconInfo.dubi.intValue()) * this.bOk));
            this.bOj = hs(iconInfo.dubi.intValue()) * this.bOk;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int adU() {
        IconInfo iconInfo;
        if (this.bOi == null || this.bOi.getIconInfoList() == null || this.bNP == null || this.bOi.getUserInfo() == null) {
            return 0;
        }
        int adM = this.bNP.adM();
        int intValue = this.bOi.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.bOi.getIconInfoList().size() && ((iconInfo = this.bOi.getIconInfoList().get(i2)) == null || adM > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.bOi.getIconInfoList().size() - 1) {
            return this.bOi.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.bOi != null && this.bOi.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.bOi.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.bOl = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int hs(int i) {
        return (int) (i / 100.0f);
    }

    public int adV() {
        return this.aUv;
    }

    public int adW() {
        return this.bOj;
    }

    public int adX() {
        return this.bOk;
    }

    public String getString(int i) {
        return this.bNP.getString(i);
    }

    public void adY() {
        if (this.bOg && !this.bOh) {
            this.bOc.clearFocus();
            com.baidu.adp.lib.util.m.b(this.bNP, this.bOc);
        }
    }

    public void eI(boolean z) {
        this.bOh = z;
    }

    public boolean adZ() {
        return this.bOg;
    }
}
