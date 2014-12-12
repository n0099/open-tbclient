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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
import tbclient.GetIconList.Discount;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.g<BuyTBeanActivity> implements TextWatcher, View.OnClickListener {
    private int aVU;
    private TextView bZU;
    private BuyTBeanActivity bZZ;
    private CustomScrollView cac;
    private NavigationBar cad;
    private NoNetworkView cae;
    private HorizontalListView caf;
    private LinearLayoutDetectsSoftKeyboard cag;
    private b cah;
    private TextView cai;
    private LinearLayout caj;
    private LinearLayout cak;
    private TextView cal;
    private EditText cam;
    private TextView can;
    private TextView cao;
    private TextView cap;
    private boolean caq;
    private boolean car;
    private d cas;
    private int cat;
    private int cau;
    private int cav;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.bZZ = buyTBeanActivity;
        initUI();
        this.bZZ.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.bZZ.setContentView(x.buy_tbean_activity);
        this.cag = (LinearLayoutDetectsSoftKeyboard) this.bZZ.findViewById(w.buy_tbean_root_ll);
        this.cag.setOnSoftKeyBoardShownListener(new k(this));
        this.cac = (CustomScrollView) this.bZZ.findViewById(w.buy_tbean_scroll_view);
        this.caf = (HorizontalListView) this.bZZ.findViewById(w.tbean_listview);
        this.cad = (NavigationBar) this.bZZ.findViewById(w.buy_tbean_navigation_bar);
        this.cae = (NoNetworkView) this.bZZ.findViewById(w.buy_tbean_no_network);
        this.cae.a(new l(this));
        this.cad.setTitleText(z.buy_tbean_title);
        this.cad.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cah = new b(this);
        this.caf.setAdapter((ListAdapter) this.cah);
        this.caf.setOnItemClickListener(new m(this));
        this.cai = (TextView) this.bZZ.findViewById(w.dq_num_tv);
        this.cai.setText(hZ(0));
        this.cal = (TextView) this.bZZ.findViewById(w.yinji_time_tv);
        this.caj = (LinearLayout) this.bZZ.findViewById(w.yinji_num_minus_ll);
        this.cak = (LinearLayout) this.bZZ.findViewById(w.yinji_num_plus_ll);
        this.caj.setOnClickListener(this);
        this.cak.setOnClickListener(this);
        this.cam = (EditText) this.bZZ.findViewById(w.yinji_num_et);
        this.cam.setText("1");
        this.cam.addTextChangedListener(this);
        this.cam.setOnFocusChangeListener(new n(this));
        this.cam.setOnClickListener(new o(this));
        this.bZU = (TextView) this.bZZ.findViewById(w.tbean_num_tv);
        this.can = (TextView) this.bZZ.findViewById(w.buy_btn_tv);
        this.can.setOnClickListener(this.bZZ);
        this.cao = (TextView) this.bZZ.findViewById(w.bottom_tip_tv);
        this.cao.setOnClickListener(this.bZZ);
        if (TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cao.setVisibility(4);
        }
        this.cap = (TextView) this.bZZ.findViewById(w.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.cas = dVar;
            this.cac.setVisibility(0);
            this.cah.setData(dVar.getIconInfoList());
            this.aVU = aio();
            this.cah.hY(this.aVU);
            this.bZZ.mHandler.postDelayed(new p(this), 300L);
            abe();
            aim();
            this.cah.notifyDataSetChanged();
        }
    }

    private void aim() {
        if (this.bZZ != null && this.cas != null && this.cas.getUserInfo() != null) {
            int aig = this.bZZ.aig();
            int intValue = this.cas.getUserInfo().scores_total.intValue();
            if (aig <= 0 || intValue >= aig) {
                this.cap.setVisibility(4);
            } else if (this.cas.getUserInfo().scores_total.intValue() < this.bZZ.aig()) {
                this.cap.setVisibility(0);
                this.cap.setText(ia(aig - intValue));
            }
        }
    }

    public void ain() {
        this.cac.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.bZZ.getLayoutMode().ab(i == 1);
        this.bZZ.getLayoutMode().h(this.cag);
        this.cad.onChangeSkinType(getPageContext(), i);
        this.cae.onChangeSkinType(getPageContext(), i);
    }

    private SpannableString hZ(int i) {
        String str;
        String str2 = String.valueOf(this.bZZ.getPageContext().getString(z.dq_left_bracket)) + " " + i + this.bZZ.getPageContext().getString(z.dq_right_bracket);
        int length = (String.valueOf(this.bZZ.getPageContext().getString(z.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(ax.getColor(t.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ax.getColor(t.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString ia(int i) {
        String string = this.bZZ.getPageContext().getString(z.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(i)).toString();
        String string2 = this.bZZ.getPageContext().getString(z.tbean_title);
        int length = string.length();
        int length2 = sb.length();
        int length3 = string2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + sb + string2);
        spannableString.setSpan(new ForegroundColorSpan(ax.getColor(t.cp_cont_d)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ax.getColor(t.cp_link_tip_a)), length, length + length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(ax.getColor(t.cp_cont_d)), length + length2, length + length2 + length3, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abe() {
        IconInfo iconInfo;
        if (this.cas != null && this.cas.getIconInfoList() != null && this.aVU >= 0 && this.aVU < this.cas.getIconInfoList().size() && (iconInfo = this.cas.getIconInfoList().get(this.aVU)) != null) {
            this.cam.setText("1");
            this.bZU.setText(String.valueOf(this.bZZ.getPageContext().getString(z.get_tbean_title)) + " " + a(iconInfo));
            this.cai.setText(hZ(ib(iconInfo.dubi.intValue())));
            this.cat = ib(iconInfo.dubi.intValue());
            this.cal.setText(String.format(getString(z.yinji_valid_time), iconInfo.duration));
            this.cao.setText(String.valueOf(String.format(getString(z.super_mem_tbean_tip), Integer.valueOf(this.cav))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == w.yinji_num_minus_ll) {
            int i2 = com.baidu.adp.lib.g.c.toInt(this.cam.getText().toString(), 0);
            if (i2 > 1) {
                this.cam.setText(new StringBuilder(String.valueOf(i2 - 1)).toString());
                this.cam.setSelection(this.cam.getText().length());
            }
        } else if (view.getId() == w.yinji_num_plus_ll && (i = com.baidu.adp.lib.g.c.toInt(this.cam.getText().toString(), 0)) < 9999) {
            this.cam.setText(new StringBuilder(String.valueOf(i + 1)).toString());
            this.cam.setSelection(this.cam.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.cas != null && this.cas.getIconInfoList() != null && this.aVU >= 0 && this.aVU < this.cas.getIconInfoList().size() && (iconInfo = this.cas.getIconInfoList().get(this.aVU)) != null) {
            this.cau = com.baidu.adp.lib.g.c.toInt(this.cam.getText().toString(), 0);
            if (this.cau == 0) {
                this.cam.setText("1");
                this.cam.setSelection(this.cam.getText().length());
            }
            this.bZU.setText(String.valueOf(this.bZZ.getPageContext().getString(z.get_tbean_title)) + " " + (a(iconInfo) * this.cau));
            this.cai.setText(hZ(ib(iconInfo.dubi.intValue()) * this.cau));
            this.cat = ib(iconInfo.dubi.intValue()) * this.cau;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int aio() {
        IconInfo iconInfo;
        if (this.cas == null || this.cas.getIconInfoList() == null || this.bZZ == null || this.cas.getUserInfo() == null) {
            return 0;
        }
        int aig = this.bZZ.aig();
        int intValue = this.cas.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.cas.getIconInfoList().size() && ((iconInfo = this.cas.getIconInfoList().get(i2)) == null || aig > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.cas.getIconInfoList().size() - 1) {
            return this.cas.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.cas != null && this.cas.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.cas.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.cav = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int ib(int i) {
        return (int) (i / 100.0f);
    }

    public int aip() {
        return this.aVU;
    }

    public int aiq() {
        return this.cat;
    }

    public int air() {
        return this.cau;
    }

    public String getString(int i) {
        return this.bZZ.getPageContext().getString(i);
    }

    public void ais() {
        if (this.caq && !this.car) {
            this.cam.clearFocus();
            com.baidu.adp.lib.util.l.c(this.bZZ.getPageContext().getPageActivity(), this.cam);
        }
    }

    public void ez(boolean z) {
        this.car = z;
    }

    public boolean ait() {
        return this.caq;
    }
}
