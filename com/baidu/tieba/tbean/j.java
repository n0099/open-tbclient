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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.List;
import tbclient.GetIconList.Discount;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.g<BuyTBeanActivity> implements TextWatcher, View.OnClickListener {
    private int bep;
    private TextView cuG;
    private BuyTBeanActivity cuL;
    private CustomScrollView cuO;
    private NavigationBar cuP;
    private NoNetworkView cuQ;
    private HorizontalListView cuR;
    private LinearLayoutDetectsSoftKeyboard cuS;
    private b cuT;
    private TextView cuU;
    private LinearLayout cuV;
    private LinearLayout cuW;
    private TextView cuX;
    private EditText cuY;
    private TextView cuZ;
    private TextView cva;
    private TextView cvb;
    private boolean cvc;
    private boolean cvd;
    private d cve;
    private int cvf;
    private int cvg;
    private int cvh;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.cuL = buyTBeanActivity;
        initUI();
        this.cuL.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.cuL.setContentView(r.buy_tbean_activity);
        this.cuS = (LinearLayoutDetectsSoftKeyboard) this.cuL.findViewById(q.buy_tbean_root_ll);
        this.cuS.setOnSoftKeyBoardShownListener(new k(this));
        this.cuO = (CustomScrollView) this.cuL.findViewById(q.buy_tbean_scroll_view);
        this.cuR = (HorizontalListView) this.cuL.findViewById(q.tbean_listview);
        this.cuP = (NavigationBar) this.cuL.findViewById(q.buy_tbean_navigation_bar);
        this.cuQ = (NoNetworkView) this.cuL.findViewById(q.buy_tbean_no_network);
        this.cuQ.a(new l(this));
        this.cuP.setTitleText(t.buy_tbean_title);
        this.cuP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cuT = new b(this);
        this.cuR.setAdapter((ListAdapter) this.cuT);
        this.cuR.setOnItemClickListener(new m(this));
        this.cuU = (TextView) this.cuL.findViewById(q.dq_num_tv);
        this.cuU.setText(ja(0));
        this.cuX = (TextView) this.cuL.findViewById(q.yinji_time_tv);
        this.cuV = (LinearLayout) this.cuL.findViewById(q.yinji_num_minus_ll);
        this.cuW = (LinearLayout) this.cuL.findViewById(q.yinji_num_plus_ll);
        this.cuV.setOnClickListener(this);
        this.cuW.setOnClickListener(this);
        this.cuY = (EditText) this.cuL.findViewById(q.yinji_num_et);
        this.cuY.setText("1");
        this.cuY.addTextChangedListener(this);
        this.cuY.setOnFocusChangeListener(new n(this));
        this.cuY.setOnClickListener(new o(this));
        this.cuG = (TextView) this.cuL.findViewById(q.tbean_num_tv);
        this.cuZ = (TextView) this.cuL.findViewById(q.buy_btn_tv);
        this.cuZ.setOnClickListener(this.cuL);
        this.cva = (TextView) this.cuL.findViewById(q.bottom_tip_tv);
        this.cva.setOnClickListener(this.cuL);
        if (TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cva.setVisibility(4);
        }
        this.cvb = (TextView) this.cuL.findViewById(q.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.cve = dVar;
            this.cuO.setVisibility(0);
            this.cuT.setData(dVar.getIconInfoList());
            this.bep = apU();
            this.cuT.iZ(this.bep);
            this.cuL.mHandler.postDelayed(new p(this), 300L);
            afm();
            apS();
            this.cuT.notifyDataSetChanged();
        }
    }

    private void apS() {
        if (this.cuL != null && this.cve != null && this.cve.getUserInfo() != null) {
            long apM = this.cuL.apM();
            int intValue = this.cve.getUserInfo().scores_total.intValue();
            if (apM <= 0 || intValue >= apM) {
                this.cvb.setVisibility(4);
            } else if (this.cve.getUserInfo().scores_total.intValue() < this.cuL.apM()) {
                this.cvb.setVisibility(0);
                this.cvb.setText(ao(apM - intValue));
            }
        }
    }

    public void apT() {
        this.cuO.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cuL.getLayoutMode().ab(i == 1);
        this.cuL.getLayoutMode().j(this.cuS);
        this.cuP.onChangeSkinType(getPageContext(), i);
        this.cuQ.onChangeSkinType(getPageContext(), i);
    }

    private SpannableString ja(int i) {
        String str;
        String str2 = String.valueOf(this.cuL.getPageContext().getString(t.dq_left_bracket)) + " " + i + this.cuL.getPageContext().getString(t.dq_right_bracket);
        int length = (String.valueOf(this.cuL.getPageContext().getString(t.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString ao(long j) {
        String string = this.cuL.getPageContext().getString(t.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(j)).toString();
        String string2 = this.cuL.getPageContext().getString(t.tbean_title);
        int length = string.length();
        int length2 = sb.length();
        int length3 = string2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + sb + string2);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_d)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_link_tip_a)), length, length + length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_d)), length + length2, length + length2 + length3, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        IconInfo iconInfo;
        if (this.cve != null && this.cve.getIconInfoList() != null && this.bep >= 0 && this.bep < this.cve.getIconInfoList().size() && (iconInfo = this.cve.getIconInfoList().get(this.bep)) != null) {
            this.cuY.setText("1");
            this.cuG.setText(String.valueOf(this.cuL.getPageContext().getString(t.get_tbean_title)) + " " + a(iconInfo));
            this.cuU.setText(ja(jb(iconInfo.dubi.intValue())));
            this.cvf = jb(iconInfo.dubi.intValue());
            this.cuX.setText(String.format(getString(t.yinji_valid_time), iconInfo.duration));
            this.cva.setText(String.valueOf(String.format(getString(t.super_mem_tbean_tip), Integer.valueOf(this.cvh))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == q.yinji_num_minus_ll) {
            int i2 = com.baidu.adp.lib.g.c.toInt(this.cuY.getText().toString(), 0);
            if (i2 > 1) {
                this.cuY.setText(new StringBuilder(String.valueOf(i2 - 1)).toString());
                this.cuY.setSelection(this.cuY.getText().length());
            }
        } else if (view.getId() == q.yinji_num_plus_ll && (i = com.baidu.adp.lib.g.c.toInt(this.cuY.getText().toString(), 0)) < 9999) {
            this.cuY.setText(new StringBuilder(String.valueOf(i + 1)).toString());
            this.cuY.setSelection(this.cuY.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.cve != null && this.cve.getIconInfoList() != null && this.bep >= 0 && this.bep < this.cve.getIconInfoList().size() && (iconInfo = this.cve.getIconInfoList().get(this.bep)) != null) {
            this.cvg = com.baidu.adp.lib.g.c.toInt(this.cuY.getText().toString(), 0);
            if (this.cvg == 0) {
                this.cuY.setText("1");
                this.cuY.setSelection(this.cuY.getText().length());
            }
            this.cuG.setText(String.valueOf(this.cuL.getPageContext().getString(t.get_tbean_title)) + " " + (a(iconInfo) * this.cvg));
            this.cuU.setText(ja(jb(iconInfo.dubi.intValue()) * this.cvg));
            this.cvf = jb(iconInfo.dubi.intValue()) * this.cvg;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int apU() {
        IconInfo iconInfo;
        if (this.cve == null || this.cve.getIconInfoList() == null || this.cuL == null || this.cve.getUserInfo() == null) {
            return 0;
        }
        long apM = this.cuL.apM();
        int intValue = this.cve.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.cve.getIconInfoList().size() && ((iconInfo = this.cve.getIconInfoList().get(i2)) == null || apM > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.cve.getIconInfoList().size() - 1) {
            return this.cve.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.cve != null && this.cve.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.cve.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.cvh = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int jb(int i) {
        return (int) (i / 100.0f);
    }

    public int apV() {
        return this.bep;
    }

    public int apW() {
        return this.cvf;
    }

    public int apX() {
        return this.cvg;
    }

    public String getString(int i) {
        return this.cuL.getPageContext().getString(i);
    }

    public void afR() {
        if (this.cvc && !this.cvd) {
            this.cuY.clearFocus();
            com.baidu.adp.lib.util.n.c(this.cuL.getPageContext().getPageActivity(), this.cuY);
        }
    }

    public void fk(boolean z) {
        this.cvd = z;
    }

    public boolean apY() {
        return this.cvc;
    }
}
