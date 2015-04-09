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
    private int bbK;
    private TextView cqB;
    private BuyTBeanActivity cqG;
    private CustomScrollView cqJ;
    private NavigationBar cqK;
    private NoNetworkView cqL;
    private HorizontalListView cqM;
    private LinearLayoutDetectsSoftKeyboard cqN;
    private b cqO;
    private TextView cqP;
    private LinearLayout cqQ;
    private LinearLayout cqR;
    private TextView cqS;
    private EditText cqT;
    private TextView cqU;
    private TextView cqV;
    private TextView cqW;
    private boolean cqX;
    private boolean cqY;
    private d cqZ;
    private int cra;
    private int crb;
    private int crc;

    public j(BuyTBeanActivity buyTBeanActivity) {
        super(buyTBeanActivity.getPageContext());
        this.cqG = buyTBeanActivity;
        initUI();
        this.cqG.getWindow().setSoftInputMode(1);
    }

    private void initUI() {
        this.cqG.setContentView(w.buy_tbean_activity);
        this.cqN = (LinearLayoutDetectsSoftKeyboard) this.cqG.findViewById(v.buy_tbean_root_ll);
        this.cqN.setOnSoftKeyBoardShownListener(new k(this));
        this.cqJ = (CustomScrollView) this.cqG.findViewById(v.buy_tbean_scroll_view);
        this.cqM = (HorizontalListView) this.cqG.findViewById(v.tbean_listview);
        this.cqK = (NavigationBar) this.cqG.findViewById(v.buy_tbean_navigation_bar);
        this.cqL = (NoNetworkView) this.cqG.findViewById(v.buy_tbean_no_network);
        this.cqL.a(new l(this));
        this.cqK.setTitleText(y.buy_tbean_title);
        this.cqK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cqO = new b(this);
        this.cqM.setAdapter((ListAdapter) this.cqO);
        this.cqM.setOnItemClickListener(new m(this));
        this.cqP = (TextView) this.cqG.findViewById(v.dq_num_tv);
        this.cqP.setText(iE(0));
        this.cqS = (TextView) this.cqG.findViewById(v.yinji_time_tv);
        this.cqQ = (LinearLayout) this.cqG.findViewById(v.yinji_num_minus_ll);
        this.cqR = (LinearLayout) this.cqG.findViewById(v.yinji_num_plus_ll);
        this.cqQ.setOnClickListener(this);
        this.cqR.setOnClickListener(this);
        this.cqT = (EditText) this.cqG.findViewById(v.yinji_num_et);
        this.cqT.setText("1");
        this.cqT.addTextChangedListener(this);
        this.cqT.setOnFocusChangeListener(new n(this));
        this.cqT.setOnClickListener(new o(this));
        this.cqB = (TextView) this.cqG.findViewById(v.tbean_num_tv);
        this.cqU = (TextView) this.cqG.findViewById(v.buy_btn_tv);
        this.cqU.setOnClickListener(this.cqG);
        this.cqV = (TextView) this.cqG.findViewById(v.bottom_tip_tv);
        this.cqV.setOnClickListener(this.cqG);
        if (TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cqV.setVisibility(4);
        }
        this.cqW = (TextView) this.cqG.findViewById(v.wanted_tbean_num);
    }

    public void e(d dVar) {
        if (dVar != null && dVar.getIconInfoList() != null) {
            this.cqZ = dVar;
            this.cqJ.setVisibility(0);
            this.cqO.setData(dVar.getIconInfoList());
            this.bbK = aob();
            this.cqO.iD(this.bbK);
            this.cqG.mHandler.postDelayed(new p(this), 300L);
            aeg();
            anZ();
            this.cqO.notifyDataSetChanged();
        }
    }

    private void anZ() {
        if (this.cqG != null && this.cqZ != null && this.cqZ.getUserInfo() != null) {
            long anT = this.cqG.anT();
            int intValue = this.cqZ.getUserInfo().scores_total.intValue();
            if (anT <= 0 || intValue >= anT) {
                this.cqW.setVisibility(4);
            } else if (this.cqZ.getUserInfo().scores_total.intValue() < this.cqG.anT()) {
                this.cqW.setVisibility(0);
                this.cqW.setText(an(anT - intValue));
            }
        }
    }

    public void aoa() {
        this.cqJ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cqG.getLayoutMode().X(i == 1);
        this.cqG.getLayoutMode().h(this.cqN);
        this.cqK.onChangeSkinType(getPageContext(), i);
        this.cqL.onChangeSkinType(getPageContext(), i);
    }

    private SpannableString iE(int i) {
        String str;
        String str2 = String.valueOf(this.cqG.getPageContext().getString(y.dq_left_bracket)) + " " + i + this.cqG.getPageContext().getString(y.dq_right_bracket);
        int length = (String.valueOf(this.cqG.getPageContext().getString(y.cost_dq_string)) + " " + i + " ").length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.cp_cont_b)), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.cp_cont_h)), length, length2 + length, 33);
        return spannableString;
    }

    private SpannableString an(long j) {
        String string = this.cqG.getPageContext().getString(y.tbean_wanted_tip);
        String sb = new StringBuilder(String.valueOf(j)).toString();
        String string2 = this.cqG.getPageContext().getString(y.tbean_title);
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
    public void aeg() {
        IconInfo iconInfo;
        if (this.cqZ != null && this.cqZ.getIconInfoList() != null && this.bbK >= 0 && this.bbK < this.cqZ.getIconInfoList().size() && (iconInfo = this.cqZ.getIconInfoList().get(this.bbK)) != null) {
            this.cqT.setText("1");
            this.cqB.setText(String.valueOf(this.cqG.getPageContext().getString(y.get_tbean_title)) + " " + a(iconInfo));
            this.cqP.setText(iE(iF(iconInfo.dubi.intValue())));
            this.cra = iF(iconInfo.dubi.intValue());
            this.cqS.setText(String.format(getString(y.yinji_valid_time), iconInfo.duration));
            this.cqV.setText(String.valueOf(String.format(getString(y.super_mem_tbean_tip), Integer.valueOf(this.crc))) + "%");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == v.yinji_num_minus_ll) {
            int i2 = com.baidu.adp.lib.g.c.toInt(this.cqT.getText().toString(), 0);
            if (i2 > 1) {
                this.cqT.setText(new StringBuilder(String.valueOf(i2 - 1)).toString());
                this.cqT.setSelection(this.cqT.getText().length());
            }
        } else if (view.getId() == v.yinji_num_plus_ll && (i = com.baidu.adp.lib.g.c.toInt(this.cqT.getText().toString(), 0)) < 9999) {
            this.cqT.setText(new StringBuilder(String.valueOf(i + 1)).toString());
            this.cqT.setSelection(this.cqT.getText().length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IconInfo iconInfo;
        if (this.cqZ != null && this.cqZ.getIconInfoList() != null && this.bbK >= 0 && this.bbK < this.cqZ.getIconInfoList().size() && (iconInfo = this.cqZ.getIconInfoList().get(this.bbK)) != null) {
            this.crb = com.baidu.adp.lib.g.c.toInt(this.cqT.getText().toString(), 0);
            if (this.crb == 0) {
                this.cqT.setText("1");
                this.cqT.setSelection(this.cqT.getText().length());
            }
            this.cqB.setText(String.valueOf(this.cqG.getPageContext().getString(y.get_tbean_title)) + " " + (a(iconInfo) * this.crb));
            this.cqP.setText(iE(iF(iconInfo.dubi.intValue()) * this.crb));
            this.cra = iF(iconInfo.dubi.intValue()) * this.crb;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    private int aob() {
        IconInfo iconInfo;
        if (this.cqZ == null || this.cqZ.getIconInfoList() == null || this.cqG == null || this.cqZ.getUserInfo() == null) {
            return 0;
        }
        long anT = this.cqG.anT();
        int intValue = this.cqZ.getUserInfo().scores_total.intValue();
        int i = 0;
        for (int i2 = 0; i2 < this.cqZ.getIconInfoList().size() && ((iconInfo = this.cqZ.getIconInfoList().get(i2)) == null || anT > a(iconInfo) + intValue); i2++) {
            i++;
        }
        if (i > this.cqZ.getIconInfoList().size() - 1) {
            return this.cqZ.getIconInfoList().size() - 1;
        }
        return i;
    }

    public int a(IconInfo iconInfo) {
        Discount discount;
        if (iconInfo != null && iconInfo.discount != null && this.cqZ != null && this.cqZ.getUserInfo() != null) {
            List<Discount> list = iconInfo.discount;
            int i = 0;
            for (int i2 = 0; i2 < list.size() && ((discount = list.get(i2)) == null || iconInfo.non_member_t.intValue() > discount.recharge.intValue()); i2++) {
                i++;
            }
            if (i > list.size() - 1) {
                i = list.size() - 1;
            }
            r2 = list.get(i) != null ? (int) ((list.get(i).rebate.intValue() * iconInfo.non_member_t.intValue()) / 100.0f) : 0;
            if (this.cqZ.getUserInfo().is_mem.intValue() != 2) {
                r2 = iconInfo.non_member_t.intValue();
            }
            this.crc = list.get(i).rebate.intValue() - 100;
        }
        return r2;
    }

    public int iF(int i) {
        return (int) (i / 100.0f);
    }

    public int aoc() {
        return this.bbK;
    }

    public int aod() {
        return this.cra;
    }

    public int aoe() {
        return this.crb;
    }

    public String getString(int i) {
        return this.cqG.getPageContext().getString(i);
    }

    public void aof() {
        if (this.cqX && !this.cqY) {
            this.cqT.clearFocus();
            com.baidu.adp.lib.util.n.c(this.cqG.getPageContext().getPageActivity(), this.cqT);
        }
    }

    public void eR(boolean z) {
        this.cqY = z;
    }

    public boolean aog() {
        return this.cqX;
    }
}
