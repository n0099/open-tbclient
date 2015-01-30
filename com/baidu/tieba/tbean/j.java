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
    private int aXn;
    private TextView cbO;
    private BuyTBeanActivity cbT;
    private CustomScrollView cbW;
    private NavigationBar cbX;
    private NoNetworkView cbY;
    private HorizontalListView cbZ;
    private LinearLayoutDetectsSoftKeyboard cca;
    private b ccb;
    private TextView ccc;
    private LinearLayout ccd;
    private LinearLayout cce;
    private TextView ccf;
    private EditText ccg;
    private TextView cch;
    private TextView cci;
    private TextView ccj;
    private boolean cck;
    private boolean ccl;
    private d ccm;
    private int ccn;
    private int cco;
    private int ccp;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.cbT = buyTBeanActivity;
        initUI();
        this.cbT.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.cbT.setContentView(x.buy_tbean_activity);
        this.cca = (LinearLayoutDetectsSoftKeyboard) this.cbT.findViewById(w.buy_tbean_root_ll);
        this.cca.setOnSoftKeyBoardShownListener(new k(this));
        this.cbW = (CustomScrollView) this.cbT.findViewById(w.buy_tbean_scroll_view);
        this.cbZ = (HorizontalListView) this.cbT.findViewById(w.tbean_listview);
        this.cbX = (NavigationBar) this.cbT.findViewById(w.buy_tbean_navigation_bar);
        this.cbY = (NoNetworkView) this.cbT.findViewById(w.buy_tbean_no_network);
        this.cbY.a(new l(this));
        this.cbX.setTitleText(z.buy_tbean_title);
        this.cbX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ccb = new b(this);
        this.cbZ.setAdapter((ListAdapter) this.ccb);
        this.cbZ.setOnItemClickListener(new m(this));
        this.ccc = (TextView) this.cbT.findViewById(w.dq_num_tv);
        this.ccc.setText(ij(0));
        this.ccf = (TextView) this.cbT.findViewById(w.yinji_time_tv);
        this.ccd = (LinearLayout) this.cbT.findViewById(w.yinji_num_minus_ll);
        this.cce = (LinearLayout) this.cbT.findViewById(w.yinji_num_plus_ll);
        this.ccd.setOnClickListener(this);
        this.cce.setOnClickListener(this);
        this.ccg = (EditText) this.cbT.findViewById(w.yinji_num_et);
        this.ccg.setText("1");
        this.ccg.addTextChangedListener(this);
        this.ccg.setOnFocusChangeListener(new n(this));
        this.ccg.setOnClickListener(new o(this));
        this.cbO = (TextView) this.cbT.findViewById(w.tbean_num_tv);
        this.cch = (TextView) this.cbT.findViewById(w.buy_btn_tv);
        this.cch.setOnClickListener(this.cbT);
        this.cci = (TextView) this.cbT.findViewById(w.bottom_tip_tv);
        this.cci.setOnClickListener(this.cbT);
        if (TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cci.setVisibility(4);
        }
        this.ccj = (TextView) this.cbT.findViewById(w.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.ccm = dVar;
            this.cbW.setVisibility(0);
            this.ccb.setData(dVar.getIconInfoList());
            this.aXn = aiT();
            this.ccb.ii(this.aXn);
            this.cbT.mHandler.postDelayed(new p(this), 300L);
            abI();
            aiR();
            this.ccb.notifyDataSetChanged();
        }
    }

    private void aiR() {
        if (this.cbT != null && this.ccm != null && this.ccm.getUserInfo() != null) {
            int aiK = this.cbT.aiK();
            int intValue = this.ccm.getUserInfo().scores_total.intValue();
            if (aiK <= 0 || intValue >= aiK) {
                this.ccj.setVisibility(4);
            } else if (this.ccm.getUserInfo().scores_total.intValue() < this.cbT.aiK()) {
                this.ccj.setVisibility(0);
                this.ccj.setText(ik(aiK - intValue));
            }
        }
    }

    public void aiS() {
        this.cbW.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cbT.getLayoutMode().ab(i == 1);
        this.cbT.getLayoutMode().h(this.cca);
        this.cbX.onChangeSkinType(getPageContext(), i);
        this.cbY.onChangeSkinType(getPageContext(), i);
    }

    private SpannableString ij(int i) {
        String str;
        String str2 = String.valueOf(this.cbT.getPageContext().getString(z.dq_left_bracket)) + " " + i + this.cbT.getPageContext().getString(z.dq_right_bracket);
        int length = (String.valueOf(this.cbT.getPageContext().getString(z.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString ik(int i) {
        String string = this.cbT.getPageContext().getString(z.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(i)).toString();
        String string2 = this.cbT.getPageContext().getString(z.tbean_title);
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
    public void abI() {
        IconInfo iconInfo;
        if (this.ccm != null && this.ccm.getIconInfoList() != null && this.aXn >= 0 && this.aXn < this.ccm.getIconInfoList().size() && (iconInfo = this.ccm.getIconInfoList().get(this.aXn)) != null) {
            this.ccg.setText("1");
            this.cbO.setText(String.valueOf(this.cbT.getPageContext().getString(z.get_tbean_title)) + " " + a(iconInfo));
            this.ccc.setText(ij(il(iconInfo.dubi.intValue())));
            this.ccn = il(iconInfo.dubi.intValue());
            this.ccf.setText(String.format(getString(z.yinji_valid_time), iconInfo.duration));
            this.cci.setText(String.valueOf(String.format(getString(z.super_mem_tbean_tip), Integer.valueOf(this.ccp))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == w.yinji_num_minus_ll) {
            int i2 = com.baidu.adp.lib.g.c.toInt(this.ccg.getText().toString(), 0);
            if (i2 > 1) {
                this.ccg.setText(new StringBuilder(String.valueOf(i2 - 1)).toString());
                this.ccg.setSelection(this.ccg.getText().length());
            }
        } else if (view.getId() == w.yinji_num_plus_ll && (i = com.baidu.adp.lib.g.c.toInt(this.ccg.getText().toString(), 0)) < 9999) {
            this.ccg.setText(new StringBuilder(String.valueOf(i + 1)).toString());
            this.ccg.setSelection(this.ccg.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.ccm != null && this.ccm.getIconInfoList() != null && this.aXn >= 0 && this.aXn < this.ccm.getIconInfoList().size() && (iconInfo = this.ccm.getIconInfoList().get(this.aXn)) != null) {
            this.cco = com.baidu.adp.lib.g.c.toInt(this.ccg.getText().toString(), 0);
            if (this.cco == 0) {
                this.ccg.setText("1");
                this.ccg.setSelection(this.ccg.getText().length());
            }
            this.cbO.setText(String.valueOf(this.cbT.getPageContext().getString(z.get_tbean_title)) + " " + (a(iconInfo) * this.cco));
            this.ccc.setText(ij(il(iconInfo.dubi.intValue()) * this.cco));
            this.ccn = il(iconInfo.dubi.intValue()) * this.cco;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int aiT() {
        IconInfo iconInfo;
        if (this.ccm == null || this.ccm.getIconInfoList() == null || this.cbT == null || this.ccm.getUserInfo() == null) {
            return 0;
        }
        int aiK = this.cbT.aiK();
        int intValue = this.ccm.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.ccm.getIconInfoList().size() && ((iconInfo = this.ccm.getIconInfoList().get(i2)) == null || aiK > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.ccm.getIconInfoList().size() - 1) {
            return this.ccm.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.ccm != null && this.ccm.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.ccm.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.ccp = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int il(int i) {
        return (int) (i / 100.0f);
    }

    public int aiU() {
        return this.aXn;
    }

    public int aiV() {
        return this.ccn;
    }

    public int aiW() {
        return this.cco;
    }

    public String getString(int i) {
        return this.cbT.getPageContext().getString(i);
    }

    public void aiX() {
        if (this.cck && !this.ccl) {
            this.ccg.clearFocus();
            com.baidu.adp.lib.util.l.c(this.cbT.getPageContext().getPageActivity(), this.ccg);
        }
    }

    public void eG(boolean z) {
        this.ccl = z;
    }

    public boolean aiY() {
        return this.cck;
    }
}
