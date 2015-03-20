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
import com.baidu.tbadk.core.util.ba;
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
public class j extends com.baidu.adp.base.g<BuyTBeanActivity> implements TextWatcher, View.OnClickListener {
    private int bbu;
    private LinearLayout cqA;
    private LinearLayout cqB;
    private TextView cqC;
    private EditText cqD;
    private TextView cqE;
    private TextView cqF;
    private TextView cqG;
    private boolean cqH;
    private boolean cqI;
    private d cqJ;
    private int cqK;
    private int cqL;
    private int cqM;
    private TextView cql;
    private BuyTBeanActivity cqq;
    private CustomScrollView cqt;
    private NavigationBar cqu;
    private NoNetworkView cqv;
    private HorizontalListView cqw;
    private LinearLayoutDetectsSoftKeyboard cqx;
    private b cqy;
    private TextView cqz;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.cqq = buyTBeanActivity;
        initUI();
        this.cqq.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.cqq.setContentView(w.buy_tbean_activity);
        this.cqx = (LinearLayoutDetectsSoftKeyboard) this.cqq.findViewById(v.buy_tbean_root_ll);
        this.cqx.setOnSoftKeyBoardShownListener(new k(this));
        this.cqt = (CustomScrollView) this.cqq.findViewById(v.buy_tbean_scroll_view);
        this.cqw = (HorizontalListView) this.cqq.findViewById(v.tbean_listview);
        this.cqu = (NavigationBar) this.cqq.findViewById(v.buy_tbean_navigation_bar);
        this.cqv = (NoNetworkView) this.cqq.findViewById(v.buy_tbean_no_network);
        this.cqv.a(new l(this));
        this.cqu.setTitleText(y.buy_tbean_title);
        this.cqu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cqy = new b(this);
        this.cqw.setAdapter((ListAdapter) this.cqy);
        this.cqw.setOnItemClickListener(new m(this));
        this.cqz = (TextView) this.cqq.findViewById(v.dq_num_tv);
        this.cqz.setText(iB(0));
        this.cqC = (TextView) this.cqq.findViewById(v.yinji_time_tv);
        this.cqA = (LinearLayout) this.cqq.findViewById(v.yinji_num_minus_ll);
        this.cqB = (LinearLayout) this.cqq.findViewById(v.yinji_num_plus_ll);
        this.cqA.setOnClickListener(this);
        this.cqB.setOnClickListener(this);
        this.cqD = (EditText) this.cqq.findViewById(v.yinji_num_et);
        this.cqD.setText("1");
        this.cqD.addTextChangedListener(this);
        this.cqD.setOnFocusChangeListener(new n(this));
        this.cqD.setOnClickListener(new o(this));
        this.cql = (TextView) this.cqq.findViewById(v.tbean_num_tv);
        this.cqE = (TextView) this.cqq.findViewById(v.buy_btn_tv);
        this.cqE.setOnClickListener(this.cqq);
        this.cqF = (TextView) this.cqq.findViewById(v.bottom_tip_tv);
        this.cqF.setOnClickListener(this.cqq);
        if (TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cqF.setVisibility(4);
        }
        this.cqG = (TextView) this.cqq.findViewById(v.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.cqJ = dVar;
            this.cqt.setVisibility(0);
            this.cqy.setData(dVar.getIconInfoList());
            this.bbu = anM();
            this.cqy.iA(this.bbu);
            this.cqq.mHandler.postDelayed(new p(this), 300L);
            adR();
            anK();
            this.cqy.notifyDataSetChanged();
        }
    }

    private void anK() {
        if (this.cqq != null && this.cqJ != null && this.cqJ.getUserInfo() != null) {
            long anE = this.cqq.anE();
            int intValue = this.cqJ.getUserInfo().scores_total.intValue();
            if (anE <= 0 || intValue >= anE) {
                this.cqG.setVisibility(4);
            } else if (this.cqJ.getUserInfo().scores_total.intValue() < this.cqq.anE()) {
                this.cqG.setVisibility(0);
                this.cqG.setText(an(anE - intValue));
            }
        }
    }

    public void anL() {
        this.cqt.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cqq.getLayoutMode().X(i == 1);
        this.cqq.getLayoutMode().h(this.cqx);
        this.cqu.onChangeSkinType(getPageContext(), i);
        this.cqv.onChangeSkinType(getPageContext(), i);
    }

    private SpannableString iB(int i) {
        String str;
        String str2 = String.valueOf(this.cqq.getPageContext().getString(y.dq_left_bracket)) + " " + i + this.cqq.getPageContext().getString(y.dq_right_bracket);
        int length = (String.valueOf(this.cqq.getPageContext().getString(y.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString an(long j) {
        String string = this.cqq.getPageContext().getString(y.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(j)).toString();
        String string2 = this.cqq.getPageContext().getString(y.tbean_title);
        int length = string.length();
        int length2 = sb.length();
        int length3 = string2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + sb + string2);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.cp_cont_d)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.cp_link_tip_a)), length, length + length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.cp_cont_d)), length + length2, length + length2 + length3, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adR() {
        IconInfo iconInfo;
        if (this.cqJ != null && this.cqJ.getIconInfoList() != null && this.bbu >= 0 && this.bbu < this.cqJ.getIconInfoList().size() && (iconInfo = this.cqJ.getIconInfoList().get(this.bbu)) != null) {
            this.cqD.setText("1");
            this.cql.setText(String.valueOf(this.cqq.getPageContext().getString(y.get_tbean_title)) + " " + a(iconInfo));
            this.cqz.setText(iB(iC(iconInfo.dubi.intValue())));
            this.cqK = iC(iconInfo.dubi.intValue());
            this.cqC.setText(String.format(getString(y.yinji_valid_time), iconInfo.duration));
            this.cqF.setText(String.valueOf(String.format(getString(y.super_mem_tbean_tip), Integer.valueOf(this.cqM))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == v.yinji_num_minus_ll) {
            int i2 = com.baidu.adp.lib.g.c.toInt(this.cqD.getText().toString(), 0);
            if (i2 > 1) {
                this.cqD.setText(new StringBuilder(String.valueOf(i2 - 1)).toString());
                this.cqD.setSelection(this.cqD.getText().length());
            }
        } else if (view.getId() == v.yinji_num_plus_ll && (i = com.baidu.adp.lib.g.c.toInt(this.cqD.getText().toString(), 0)) < 9999) {
            this.cqD.setText(new StringBuilder(String.valueOf(i + 1)).toString());
            this.cqD.setSelection(this.cqD.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.cqJ != null && this.cqJ.getIconInfoList() != null && this.bbu >= 0 && this.bbu < this.cqJ.getIconInfoList().size() && (iconInfo = this.cqJ.getIconInfoList().get(this.bbu)) != null) {
            this.cqL = com.baidu.adp.lib.g.c.toInt(this.cqD.getText().toString(), 0);
            if (this.cqL == 0) {
                this.cqD.setText("1");
                this.cqD.setSelection(this.cqD.getText().length());
            }
            this.cql.setText(String.valueOf(this.cqq.getPageContext().getString(y.get_tbean_title)) + " " + (a(iconInfo) * this.cqL));
            this.cqz.setText(iB(iC(iconInfo.dubi.intValue()) * this.cqL));
            this.cqK = iC(iconInfo.dubi.intValue()) * this.cqL;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int anM() {
        IconInfo iconInfo;
        if (this.cqJ == null || this.cqJ.getIconInfoList() == null || this.cqq == null || this.cqJ.getUserInfo() == null) {
            return 0;
        }
        long anE = this.cqq.anE();
        int intValue = this.cqJ.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.cqJ.getIconInfoList().size() && ((iconInfo = this.cqJ.getIconInfoList().get(i2)) == null || anE > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.cqJ.getIconInfoList().size() - 1) {
            return this.cqJ.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.cqJ != null && this.cqJ.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.cqJ.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.cqM = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int iC(int i) {
        return (int) (i / 100.0f);
    }

    public int anN() {
        return this.bbu;
    }

    public int anO() {
        return this.cqK;
    }

    public int anP() {
        return this.cqL;
    }

    public String getString(int i) {
        return this.cqq.getPageContext().getString(i);
    }

    public void anQ() {
        if (this.cqH && !this.cqI) {
            this.cqD.clearFocus();
            com.baidu.adp.lib.util.n.c(this.cqq.getPageContext().getPageActivity(), this.cqD);
        }
    }

    public void eT(boolean z) {
        this.cqI = z;
    }

    public boolean anR() {
        return this.cqH;
    }
}
