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
import com.baidu.tbadk.core.util.bc;
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
    private int aXm;
    private TextView cbN;
    private BuyTBeanActivity cbS;
    private CustomScrollView cbV;
    private NavigationBar cbW;
    private NoNetworkView cbX;
    private HorizontalListView cbY;
    private LinearLayoutDetectsSoftKeyboard cbZ;
    private b cca;
    private TextView ccb;
    private LinearLayout ccc;
    private LinearLayout ccd;
    private TextView cce;
    private EditText ccf;
    private TextView ccg;
    private TextView cch;
    private TextView cci;
    private boolean ccj;
    private boolean cck;
    private d ccl;
    private int ccm;
    private int ccn;
    private int cco;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.cbS = buyTBeanActivity;
        initUI();
        this.cbS.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.cbS.setContentView(x.buy_tbean_activity);
        this.cbZ = (LinearLayoutDetectsSoftKeyboard) this.cbS.findViewById(w.buy_tbean_root_ll);
        this.cbZ.setOnSoftKeyBoardShownListener(new k(this));
        this.cbV = (CustomScrollView) this.cbS.findViewById(w.buy_tbean_scroll_view);
        this.cbY = (HorizontalListView) this.cbS.findViewById(w.tbean_listview);
        this.cbW = (NavigationBar) this.cbS.findViewById(w.buy_tbean_navigation_bar);
        this.cbX = (NoNetworkView) this.cbS.findViewById(w.buy_tbean_no_network);
        this.cbX.a(new l(this));
        this.cbW.setTitleText(z.buy_tbean_title);
        this.cbW.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cca = new b(this);
        this.cbY.setAdapter((ListAdapter) this.cca);
        this.cbY.setOnItemClickListener(new m(this));
        this.ccb = (TextView) this.cbS.findViewById(w.dq_num_tv);
        this.ccb.setText(ij(0));
        this.cce = (TextView) this.cbS.findViewById(w.yinji_time_tv);
        this.ccc = (LinearLayout) this.cbS.findViewById(w.yinji_num_minus_ll);
        this.ccd = (LinearLayout) this.cbS.findViewById(w.yinji_num_plus_ll);
        this.ccc.setOnClickListener(this);
        this.ccd.setOnClickListener(this);
        this.ccf = (EditText) this.cbS.findViewById(w.yinji_num_et);
        this.ccf.setText("1");
        this.ccf.addTextChangedListener(this);
        this.ccf.setOnFocusChangeListener(new n(this));
        this.ccf.setOnClickListener(new o(this));
        this.cbN = (TextView) this.cbS.findViewById(w.tbean_num_tv);
        this.ccg = (TextView) this.cbS.findViewById(w.buy_btn_tv);
        this.ccg.setOnClickListener(this.cbS);
        this.cch = (TextView) this.cbS.findViewById(w.bottom_tip_tv);
        this.cch.setOnClickListener(this.cbS);
        if (TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cch.setVisibility(4);
        }
        this.cci = (TextView) this.cbS.findViewById(w.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.ccl = dVar;
            this.cbV.setVisibility(0);
            this.cca.setData(dVar.getIconInfoList());
            this.aXm = aiO();
            this.cca.ii(this.aXm);
            this.cbS.mHandler.postDelayed(new p(this), 300L);
            abD();
            aiM();
            this.cca.notifyDataSetChanged();
        }
    }

    private void aiM() {
        if (this.cbS != null && this.ccl != null && this.ccl.getUserInfo() != null) {
            int aiF = this.cbS.aiF();
            int intValue = this.ccl.getUserInfo().scores_total.intValue();
            if (aiF <= 0 || intValue >= aiF) {
                this.cci.setVisibility(4);
            } else if (this.ccl.getUserInfo().scores_total.intValue() < this.cbS.aiF()) {
                this.cci.setVisibility(0);
                this.cci.setText(ik(aiF - intValue));
            }
        }
    }

    public void aiN() {
        this.cbV.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cbS.getLayoutMode().ab(i == 1);
        this.cbS.getLayoutMode().h(this.cbZ);
        this.cbW.onChangeSkinType(getPageContext(), i);
        this.cbX.onChangeSkinType(getPageContext(), i);
    }

    private SpannableString ij(int i) {
        String str;
        String str2 = String.valueOf(this.cbS.getPageContext().getString(z.dq_left_bracket)) + " " + i + this.cbS.getPageContext().getString(z.dq_right_bracket);
        int length = (String.valueOf(this.cbS.getPageContext().getString(z.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString ik(int i) {
        String string = this.cbS.getPageContext().getString(z.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(i)).toString();
        String string2 = this.cbS.getPageContext().getString(z.tbean_title);
        int length = string.length();
        int length2 = sb.length();
        int length3 = string2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + sb + string2);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_cont_d)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_link_tip_a)), length, length + length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_cont_d)), length + length2, length + length2 + length3, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        IconInfo iconInfo;
        if (this.ccl != null && this.ccl.getIconInfoList() != null && this.aXm >= 0 && this.aXm < this.ccl.getIconInfoList().size() && (iconInfo = this.ccl.getIconInfoList().get(this.aXm)) != null) {
            this.ccf.setText("1");
            this.cbN.setText(String.valueOf(this.cbS.getPageContext().getString(z.get_tbean_title)) + " " + a(iconInfo));
            this.ccb.setText(ij(il(iconInfo.dubi.intValue())));
            this.ccm = il(iconInfo.dubi.intValue());
            this.cce.setText(String.format(getString(z.yinji_valid_time), iconInfo.duration));
            this.cch.setText(String.valueOf(String.format(getString(z.super_mem_tbean_tip), Integer.valueOf(this.cco))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == w.yinji_num_minus_ll) {
            int i2 = com.baidu.adp.lib.g.c.toInt(this.ccf.getText().toString(), 0);
            if (i2 > 1) {
                this.ccf.setText(new StringBuilder(String.valueOf(i2 - 1)).toString());
                this.ccf.setSelection(this.ccf.getText().length());
            }
        } else if (view.getId() == w.yinji_num_plus_ll && (i = com.baidu.adp.lib.g.c.toInt(this.ccf.getText().toString(), 0)) < 9999) {
            this.ccf.setText(new StringBuilder(String.valueOf(i + 1)).toString());
            this.ccf.setSelection(this.ccf.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.ccl != null && this.ccl.getIconInfoList() != null && this.aXm >= 0 && this.aXm < this.ccl.getIconInfoList().size() && (iconInfo = this.ccl.getIconInfoList().get(this.aXm)) != null) {
            this.ccn = com.baidu.adp.lib.g.c.toInt(this.ccf.getText().toString(), 0);
            if (this.ccn == 0) {
                this.ccf.setText("1");
                this.ccf.setSelection(this.ccf.getText().length());
            }
            this.cbN.setText(String.valueOf(this.cbS.getPageContext().getString(z.get_tbean_title)) + " " + (a(iconInfo) * this.ccn));
            this.ccb.setText(ij(il(iconInfo.dubi.intValue()) * this.ccn));
            this.ccm = il(iconInfo.dubi.intValue()) * this.ccn;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int aiO() {
        IconInfo iconInfo;
        if (this.ccl == null || this.ccl.getIconInfoList() == null || this.cbS == null || this.ccl.getUserInfo() == null) {
            return 0;
        }
        int aiF = this.cbS.aiF();
        int intValue = this.ccl.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.ccl.getIconInfoList().size() && ((iconInfo = this.ccl.getIconInfoList().get(i2)) == null || aiF > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.ccl.getIconInfoList().size() - 1) {
            return this.ccl.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.ccl != null && this.ccl.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.ccl.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.cco = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int il(int i) {
        return (int) (i / 100.0f);
    }

    public int aiP() {
        return this.aXm;
    }

    public int aiQ() {
        return this.ccm;
    }

    public int aiR() {
        return this.ccn;
    }

    public String getString(int i) {
        return this.cbS.getPageContext().getString(i);
    }

    public void aiS() {
        if (this.ccj && !this.cck) {
            this.ccf.clearFocus();
            com.baidu.adp.lib.util.l.c(this.cbS.getPageContext().getPageActivity(), this.ccf);
        }
    }

    public void eG(boolean z) {
        this.cck = z;
    }

    public boolean aiT() {
        return this.ccj;
    }
}
