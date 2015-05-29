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
    private int beo;
    private TextView cuF;
    private BuyTBeanActivity cuK;
    private CustomScrollView cuN;
    private NavigationBar cuO;
    private NoNetworkView cuP;
    private HorizontalListView cuQ;
    private LinearLayoutDetectsSoftKeyboard cuR;
    private b cuS;
    private TextView cuT;
    private LinearLayout cuU;
    private LinearLayout cuV;
    private TextView cuW;
    private EditText cuX;
    private TextView cuY;
    private TextView cuZ;
    private TextView cva;
    private boolean cvb;
    private boolean cvc;
    private d cvd;
    private int cve;
    private int cvf;
    private int cvg;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.cuK = buyTBeanActivity;
        initUI();
        this.cuK.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.cuK.setContentView(r.buy_tbean_activity);
        this.cuR = (LinearLayoutDetectsSoftKeyboard) this.cuK.findViewById(q.buy_tbean_root_ll);
        this.cuR.setOnSoftKeyBoardShownListener(new k(this));
        this.cuN = (CustomScrollView) this.cuK.findViewById(q.buy_tbean_scroll_view);
        this.cuQ = (HorizontalListView) this.cuK.findViewById(q.tbean_listview);
        this.cuO = (NavigationBar) this.cuK.findViewById(q.buy_tbean_navigation_bar);
        this.cuP = (NoNetworkView) this.cuK.findViewById(q.buy_tbean_no_network);
        this.cuP.a(new l(this));
        this.cuO.setTitleText(t.buy_tbean_title);
        this.cuO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cuS = new b(this);
        this.cuQ.setAdapter((ListAdapter) this.cuS);
        this.cuQ.setOnItemClickListener(new m(this));
        this.cuT = (TextView) this.cuK.findViewById(q.dq_num_tv);
        this.cuT.setText(ja(0));
        this.cuW = (TextView) this.cuK.findViewById(q.yinji_time_tv);
        this.cuU = (LinearLayout) this.cuK.findViewById(q.yinji_num_minus_ll);
        this.cuV = (LinearLayout) this.cuK.findViewById(q.yinji_num_plus_ll);
        this.cuU.setOnClickListener(this);
        this.cuV.setOnClickListener(this);
        this.cuX = (EditText) this.cuK.findViewById(q.yinji_num_et);
        this.cuX.setText("1");
        this.cuX.addTextChangedListener(this);
        this.cuX.setOnFocusChangeListener(new n(this));
        this.cuX.setOnClickListener(new o(this));
        this.cuF = (TextView) this.cuK.findViewById(q.tbean_num_tv);
        this.cuY = (TextView) this.cuK.findViewById(q.buy_btn_tv);
        this.cuY.setOnClickListener(this.cuK);
        this.cuZ = (TextView) this.cuK.findViewById(q.bottom_tip_tv);
        this.cuZ.setOnClickListener(this.cuK);
        if (TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cuZ.setVisibility(4);
        }
        this.cva = (TextView) this.cuK.findViewById(q.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.cvd = dVar;
            this.cuN.setVisibility(0);
            this.cuS.setData(dVar.getIconInfoList());
            this.beo = apT();
            this.cuS.iZ(this.beo);
            this.cuK.mHandler.postDelayed(new p(this), 300L);
            afl();
            apR();
            this.cuS.notifyDataSetChanged();
        }
    }

    private void apR() {
        if (this.cuK != null && this.cvd != null && this.cvd.getUserInfo() != null) {
            long apL = this.cuK.apL();
            int intValue = this.cvd.getUserInfo().scores_total.intValue();
            if (apL <= 0 || intValue >= apL) {
                this.cva.setVisibility(4);
            } else if (this.cvd.getUserInfo().scores_total.intValue() < this.cuK.apL()) {
                this.cva.setVisibility(0);
                this.cva.setText(ao(apL - intValue));
            }
        }
    }

    public void apS() {
        this.cuN.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cuK.getLayoutMode().ab(i == 1);
        this.cuK.getLayoutMode().j(this.cuR);
        this.cuO.onChangeSkinType(getPageContext(), i);
        this.cuP.onChangeSkinType(getPageContext(), i);
    }

    private SpannableString ja(int i) {
        String str;
        String str2 = String.valueOf(this.cuK.getPageContext().getString(t.dq_left_bracket)) + " " + i + this.cuK.getPageContext().getString(t.dq_right_bracket);
        int length = (String.valueOf(this.cuK.getPageContext().getString(t.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString ao(long j) {
        String string = this.cuK.getPageContext().getString(t.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(j)).toString();
        String string2 = this.cuK.getPageContext().getString(t.tbean_title);
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
    public void afl() {
        IconInfo iconInfo;
        if (this.cvd != null && this.cvd.getIconInfoList() != null && this.beo >= 0 && this.beo < this.cvd.getIconInfoList().size() && (iconInfo = this.cvd.getIconInfoList().get(this.beo)) != null) {
            this.cuX.setText("1");
            this.cuF.setText(String.valueOf(this.cuK.getPageContext().getString(t.get_tbean_title)) + " " + a(iconInfo));
            this.cuT.setText(ja(jb(iconInfo.dubi.intValue())));
            this.cve = jb(iconInfo.dubi.intValue());
            this.cuW.setText(String.format(getString(t.yinji_valid_time), iconInfo.duration));
            this.cuZ.setText(String.valueOf(String.format(getString(t.super_mem_tbean_tip), Integer.valueOf(this.cvg))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == q.yinji_num_minus_ll) {
            int i2 = com.baidu.adp.lib.g.c.toInt(this.cuX.getText().toString(), 0);
            if (i2 > 1) {
                this.cuX.setText(new StringBuilder(String.valueOf(i2 - 1)).toString());
                this.cuX.setSelection(this.cuX.getText().length());
            }
        } else if (view.getId() == q.yinji_num_plus_ll && (i = com.baidu.adp.lib.g.c.toInt(this.cuX.getText().toString(), 0)) < 9999) {
            this.cuX.setText(new StringBuilder(String.valueOf(i + 1)).toString());
            this.cuX.setSelection(this.cuX.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.cvd != null && this.cvd.getIconInfoList() != null && this.beo >= 0 && this.beo < this.cvd.getIconInfoList().size() && (iconInfo = this.cvd.getIconInfoList().get(this.beo)) != null) {
            this.cvf = com.baidu.adp.lib.g.c.toInt(this.cuX.getText().toString(), 0);
            if (this.cvf == 0) {
                this.cuX.setText("1");
                this.cuX.setSelection(this.cuX.getText().length());
            }
            this.cuF.setText(String.valueOf(this.cuK.getPageContext().getString(t.get_tbean_title)) + " " + (a(iconInfo) * this.cvf));
            this.cuT.setText(ja(jb(iconInfo.dubi.intValue()) * this.cvf));
            this.cve = jb(iconInfo.dubi.intValue()) * this.cvf;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int apT() {
        IconInfo iconInfo;
        if (this.cvd == null || this.cvd.getIconInfoList() == null || this.cuK == null || this.cvd.getUserInfo() == null) {
            return 0;
        }
        long apL = this.cuK.apL();
        int intValue = this.cvd.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.cvd.getIconInfoList().size() && ((iconInfo = this.cvd.getIconInfoList().get(i2)) == null || apL > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.cvd.getIconInfoList().size() - 1) {
            return this.cvd.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.cvd != null && this.cvd.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.cvd.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.cvg = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int jb(int i) {
        return (int) (i / 100.0f);
    }

    public int apU() {
        return this.beo;
    }

    public int apV() {
        return this.cve;
    }

    public int apW() {
        return this.cvf;
    }

    public String getString(int i) {
        return this.cuK.getPageContext().getString(i);
    }

    public void afQ() {
        if (this.cvb && !this.cvc) {
            this.cuX.clearFocus();
            com.baidu.adp.lib.util.n.c(this.cuK.getPageContext().getPageActivity(), this.cuX);
        }
    }

    public void fk(boolean z) {
        this.cvc = z;
    }

    public boolean apX() {
        return this.cvb;
    }
}
