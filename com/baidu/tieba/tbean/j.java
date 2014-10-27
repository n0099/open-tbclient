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
    private int aUh;
    private BuyTBeanActivity bNA;
    private CustomScrollView bND;
    private NavigationBar bNE;
    private NoNetworkView bNF;
    private HorizontalListView bNG;
    private LinearLayoutDetectsSoftKeyboard bNH;
    private b bNI;
    private TextView bNJ;
    private LinearLayout bNK;
    private LinearLayout bNL;
    private TextView bNM;
    private EditText bNN;
    private TextView bNO;
    private TextView bNP;
    private TextView bNQ;
    private boolean bNR;
    private boolean bNS;
    private d bNT;
    private int bNU;
    private int bNV;
    private int bNW;
    private TextView bNv;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity);
        this.bNA = buyTBeanActivity;
        initUI();
        this.bNA.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.bNA.setContentView(w.buy_tbean_activity);
        this.bNH = (LinearLayoutDetectsSoftKeyboard) this.bNA.findViewById(v.buy_tbean_root_ll);
        this.bNH.setOnSoftKeyBoardShownListener(new k(this));
        this.bND = (CustomScrollView) this.bNA.findViewById(v.buy_tbean_scroll_view);
        this.bNG = (HorizontalListView) this.bNA.findViewById(v.tbean_listview);
        this.bNE = (NavigationBar) this.bNA.findViewById(v.buy_tbean_navigation_bar);
        this.bNF = (NoNetworkView) this.bNA.findViewById(v.buy_tbean_no_network);
        this.bNF.a(new l(this));
        this.bNE.setTitleText(y.buy_tbean_title);
        this.bNE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bNI = new b(this);
        this.bNG.setAdapter((ListAdapter) this.bNI);
        this.bNG.setOnItemClickListener(new m(this));
        this.bNJ = (TextView) this.bNA.findViewById(v.dq_num_tv);
        this.bNJ.setText(hq(0));
        this.bNM = (TextView) this.bNA.findViewById(v.yinji_time_tv);
        this.bNK = (LinearLayout) this.bNA.findViewById(v.yinji_num_minus_ll);
        this.bNL = (LinearLayout) this.bNA.findViewById(v.yinji_num_plus_ll);
        this.bNK.setOnClickListener(this);
        this.bNL.setOnClickListener(this);
        this.bNN = (EditText) this.bNA.findViewById(v.yinji_num_et);
        this.bNN.setText("1");
        this.bNN.addTextChangedListener(this);
        this.bNN.setOnFocusChangeListener(new n(this));
        this.bNN.setOnClickListener(new o(this));
        this.bNv = (TextView) this.bNA.findViewById(v.tbean_num_tv);
        this.bNO = (TextView) this.bNA.findViewById(v.buy_btn_tv);
        this.bNO.setOnClickListener(this.bNA);
        this.bNP = (TextView) this.bNA.findViewById(v.bottom_tip_tv);
        this.bNP.setOnClickListener(this.bNA);
        this.bNQ = (TextView) this.bNA.findViewById(v.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.bNT = dVar;
            this.bND.setVisibility(0);
            this.bNI.setData(dVar.getIconInfoList());
            this.aUh = adR();
            this.bNI.hp(this.aUh);
            this.bNA.mHandler.postDelayed(new p(this), 300L);
            Hu();
            adP();
            this.bNI.notifyDataSetChanged();
        }
    }

    private void adP() {
        if (this.bNA != null && this.bNT != null && this.bNT.getUserInfo() != null) {
            int adJ = this.bNA.adJ();
            int intValue = this.bNT.getUserInfo().scores_total.intValue();
            if (adJ <= 0 || intValue >= adJ) {
                this.bNQ.setVisibility(4);
            } else if (this.bNT.getUserInfo().scores_total.intValue() < this.bNA.adJ()) {
                this.bNQ.setVisibility(0);
                this.bNQ.setText(hr(adJ - intValue));
            }
        }
    }

    public void adQ() {
        this.bND.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.bNA.getLayoutMode().L(i == 1);
        this.bNA.getLayoutMode().h(this.bNH);
        this.bNE.onChangeSkinType(i);
        this.bNF.onChangeSkinType(i);
    }

    private SpannableString hq(int i) {
        String str;
        String str2 = String.valueOf(this.bNA.getString(y.dq_left_bracket)) + " " + i + this.bNA.getString(y.dq_right_bracket);
        int length = (String.valueOf(this.bNA.getString(y.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString hr(int i) {
        String string = this.bNA.getString(y.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(i)).toString();
        String string2 = this.bNA.getString(y.tbean_title);
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
    public void Hu() {
        IconInfo iconInfo;
        if (this.bNT != null && this.bNT.getIconInfoList() != null && this.aUh >= 0 && this.aUh < this.bNT.getIconInfoList().size() && (iconInfo = this.bNT.getIconInfoList().get(this.aUh)) != null) {
            this.bNN.setText("1");
            this.bNv.setText(String.valueOf(this.bNA.getString(y.get_tbean_title)) + " " + a(iconInfo));
            this.bNJ.setText(hq(hs(iconInfo.dubi.intValue())));
            this.bNU = hs(iconInfo.dubi.intValue());
            this.bNM.setText(String.format(getString(y.yinji_valid_time), iconInfo.duration));
            this.bNP.setText(String.valueOf(String.format(getString(y.super_mem_tbean_tip), Integer.valueOf(this.bNW))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int f;
        if (view.getId() == v.yinji_num_minus_ll) {
            int f2 = com.baidu.adp.lib.g.c.f(this.bNN.getText().toString(), 0);
            if (f2 > 1) {
                this.bNN.setText(new StringBuilder(String.valueOf(f2 - 1)).toString());
                this.bNN.setSelection(this.bNN.getText().length());
            }
        } else if (view.getId() == v.yinji_num_plus_ll && (f = com.baidu.adp.lib.g.c.f(this.bNN.getText().toString(), 0)) < 9999) {
            this.bNN.setText(new StringBuilder(String.valueOf(f + 1)).toString());
            this.bNN.setSelection(this.bNN.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.bNT != null && this.bNT.getIconInfoList() != null && this.aUh >= 0 && this.aUh < this.bNT.getIconInfoList().size() && (iconInfo = this.bNT.getIconInfoList().get(this.aUh)) != null) {
            this.bNV = com.baidu.adp.lib.g.c.f(this.bNN.getText().toString(), 0);
            if (this.bNV == 0) {
                this.bNN.setText("1");
                this.bNN.setSelection(this.bNN.getText().length());
            }
            this.bNv.setText(String.valueOf(this.bNA.getString(y.get_tbean_title)) + " " + (a(iconInfo) * this.bNV));
            this.bNJ.setText(hq(hs(iconInfo.dubi.intValue()) * this.bNV));
            this.bNU = hs(iconInfo.dubi.intValue()) * this.bNV;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int adR() {
        IconInfo iconInfo;
        if (this.bNT == null || this.bNT.getIconInfoList() == null || this.bNA == null || this.bNT.getUserInfo() == null) {
            return 0;
        }
        int adJ = this.bNA.adJ();
        int intValue = this.bNT.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.bNT.getIconInfoList().size() && ((iconInfo = this.bNT.getIconInfoList().get(i2)) == null || adJ > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.bNT.getIconInfoList().size() - 1) {
            return this.bNT.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.bNT != null && this.bNT.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.bNT.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.bNW = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int hs(int i) {
        return (int) (i / 100.0f);
    }

    public int adS() {
        return this.aUh;
    }

    public int adT() {
        return this.bNU;
    }

    public int adU() {
        return this.bNV;
    }

    public String getString(int i) {
        return this.bNA.getString(i);
    }

    public void adV() {
        if (this.bNR && !this.bNS) {
            this.bNN.clearFocus();
            com.baidu.adp.lib.util.m.b(this.bNA, this.bNN);
        }
    }

    public void eI(boolean z) {
        this.bNS = z;
    }

    public boolean adW() {
        return this.bNR;
    }
}
