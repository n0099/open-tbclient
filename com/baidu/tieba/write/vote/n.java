package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.cc;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<WriteVoteActivity> {
    private View aWl;
    private int aWo;
    private EditText epr;
    private EditText epv;
    private TextView epw;
    private TextView epx;
    private cc epy;
    private ImageView epz;
    private WriteVoteActivity eqM;
    private View erh;
    private View eri;
    private ArrayList<com.baidu.tieba.write.view.j> erj;
    private RadioGroup erk;
    private RadioButton erl;
    private RadioButton erm;
    private TextView ern;
    private c ero;
    private LinearLayout erp;
    private View erq;
    private BdSwitchView err;
    private final ArrayList<g> ers;
    private final ArrayList<g> ert;
    private NavigationBar mNavigationBar;

    public View aUj() {
        return this.erh;
    }

    public TextView aUk() {
        return this.epx;
    }

    public View aUl() {
        return this.epw;
    }

    public EditText aUm() {
        return this.epr;
    }

    public EditText aUn() {
        return this.epv;
    }

    public BdSwitchView aUo() {
        return this.err;
    }

    public c aUp() {
        return this.ero;
    }

    public TextView aUq() {
        return this.ern;
    }

    public View aUr() {
        return this.erq;
    }

    public ArrayList<g> aUs() {
        return this.ers;
    }

    public ArrayList<g> aUt() {
        return this.ert;
    }

    public n(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.aWo = 0;
        this.mNavigationBar = null;
        this.epw = null;
        this.erj = new ArrayList<>();
        this.epr = null;
        this.epv = null;
        this.ers = new ArrayList<>();
        this.ert = new ArrayList<>();
        this.eqM = writeVoteActivity;
        initView();
        pm();
        aUu();
        fQ(this.aWo);
    }

    private void initView() {
        this.eqM.setContentView(t.h.write_vote_activity);
        this.aWl = (RelativeLayout) this.eqM.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) this.eqM.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eqM.getPageContext().getString(t.j.write_vote_titlebar));
        this.epw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epw.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.epw.setLayoutParams(layoutParams);
        this.epw.setEnabled(false);
        this.epr = (EditText) this.eqM.findViewById(t.g.post_title);
        this.epv = (EditText) this.eqM.findViewById(t.g.post_content);
        this.erk = (RadioGroup) this.eqM.findViewById(t.g.raidos_tabs_vote);
        this.erl = (RadioButton) this.eqM.findViewById(t.g.radio_vote_pic);
        this.erm = (RadioButton) this.eqM.findViewById(t.g.radio_vote_text);
        this.ern = (TextView) this.eqM.findViewById(t.g.endtime_day);
        this.ero = new c(this.eqM);
        this.erp = (LinearLayout) this.eqM.findViewById(t.g.vote_container);
        this.erq = this.eqM.findViewById(t.g.vote_add_layout);
        this.err = (BdSwitchView) this.eqM.findViewById(t.g.multiple_switch);
        this.err.mt();
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.eqM != null) {
            this.erh = this.eqM.findViewById(t.g.post_prefix_layout);
            this.epx = (TextView) this.eqM.findViewById(t.g.post_prefix);
            this.eri = this.eqM.findViewById(t.g.prefix_divider);
            this.epz = (ImageView) this.eqM.findViewById(t.g.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.erh.setVisibility(0);
                this.eri.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.erh.setOnClickListener(this.eqM);
                this.epz = (ImageView) this.eqM.findViewById(t.g.prefix_icon);
                if (size > 1) {
                    this.epz.setVisibility(0);
                    this.epx.setOnClickListener(this.eqM);
                }
                this.epy = new cc(this.eqM.getPageContext().getPageActivity());
                this.epy.a(this.eqM);
                this.epy.setMaxHeight(com.baidu.adp.lib.util.k.c(this.eqM.getActivity(), t.e.ds510));
                this.epy.setOutsideTouchable(true);
                this.epy.setFocusable(true);
                this.epy.setOnDismissListener(this.eqM);
                this.epy.setBackgroundDrawable(ar.getDrawable(t.d.cp_bg_line_d));
                int color = ar.getColor(t.d.write_text);
                int color2 = ar.getColor(t.d.cp_cont_c);
                ar.k(this.epx, t.d.cp_bg_line_d);
                ar.c(this.epz, t.f.icon_title_down);
                this.epx.setTextColor(color);
                this.erj.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(this.eqM.getActivity());
                    this.erj.add(jVar);
                    jVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        jVar.setPrefixTextColor(color2);
                    } else {
                        jVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        jVar.setDividerStyle(false);
                    }
                    this.epy.addView(jVar);
                }
                this.epy.py(0);
                this.epx.setText(prefixs.get(1));
                pT(1);
                return;
            }
            this.erh.setVisibility(8);
        }
    }

    private void aUu() {
        this.ers.add(new g(this.eqM, 0));
        this.ers.add(new g(this.eqM, 0));
        this.ert.add(new g(this.eqM, 1));
        this.ert.add(new g(this.eqM, 1));
    }

    private void pm() {
        this.ern.setOnClickListener(this.eqM);
        this.erq.setOnClickListener(this.eqM);
        this.epw.setOnClickListener(this.eqM);
        this.err.setOnSwitchStateChangeListener(this.eqM);
        this.ero.a(this.eqM);
        this.erk.setOnCheckedChangeListener(this.eqM);
        this.epr.addTextChangedListener(new a(31, this.epr));
        this.epv.addTextChangedListener(new a(50, this.epv));
    }

    public void fQ(int i) {
        this.aWo = i;
        aUw();
        if (this.aWo == 0) {
            ar(this.ers);
        } else if (this.aWo == 1) {
            ar(this.ert);
        }
    }

    private void aUv() {
        if (this.aWo == 0) {
            if (this.ers.size() >= 10) {
                this.erq.setVisibility(8);
            } else {
                this.erq.setVisibility(0);
            }
        } else if (this.aWo == 1) {
            if (this.ert.size() >= 20) {
                this.erq.setVisibility(8);
            } else {
                this.erq.setVisibility(0);
            }
        }
    }

    private void ar(ArrayList<g> arrayList) {
        if (arrayList != null) {
            this.erp.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && gVar.getView() != null) {
                        this.erp.addView(gVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    aUv();
                    return;
                }
            }
        }
    }

    private void aUw() {
        if (this.erl != null && this.erm != null) {
            if (this.aWo == 0) {
                ar.b(this.erl, t.d.cp_link_tip_c, 3);
                ar.b(this.erm, t.d.cp_cont_f, 3);
            } else if (this.aWo == 1) {
                ar.b(this.erm, t.d.cp_link_tip_c, 3);
                ar.b(this.erl, t.d.cp_cont_f, 3);
            }
        }
    }

    public g pR(int i) {
        g gVar = null;
        if (i == 0) {
            gVar = new g(this.eqM, 0);
            this.ers.add(gVar);
            this.erp.addView(gVar.getView());
        } else if (i == 1) {
            gVar = new g(this.eqM, 1);
            this.ert.add(gVar);
            this.erp.addView(gVar.getView());
        }
        aUv();
        return gVar;
    }

    public g b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g ct = ct(this.ers);
        if (ct != null) {
            ct.a(imageFileInfo, aVar);
        } else {
            c(imageFileInfo, aVar);
        }
        return ct;
    }

    private g c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g gVar = new g(this.eqM, 0);
        gVar.a(imageFileInfo, aVar);
        this.ers.add(gVar);
        this.erp.addView(gVar.getView());
        aUv();
        return gVar;
    }

    public void pS(int i) {
        if (this.aWo == 0) {
            g j = j(this.ers, i);
            if (j != null && j.getView() != null) {
                this.ers.remove(j);
                this.erp.removeView(j.getView());
            } else {
                return;
            }
        } else if (this.aWo == 1) {
            g j2 = j(this.ert, i);
            if (j2 != null && j2.getView() != null) {
                this.ert.remove(j2);
                this.erp.removeView(j2.getView());
            } else {
                return;
            }
        }
        aUv();
    }

    private g ct(List<g> list) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (!gVar.aUb()) {
                return gVar;
            }
        }
        return null;
    }

    private g j(List<g> list, int i) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (i == gVar.getId()) {
                return gVar;
            }
        }
        return null;
    }

    public void nI(String str) {
        if (this.ern != null) {
            this.ern.setText(str);
        }
    }

    public void iD(boolean z) {
        if (this.epw != null) {
            this.epw.setEnabled(z);
        }
    }

    private void pT(int i) {
        if (i >= 0 && i < this.erj.size()) {
            for (int i2 = 0; i2 < this.erj.size(); i2++) {
                this.erj.get(i2).iC(false);
            }
            this.erj.get(i).iC(true);
        }
    }

    public void V(int i, String str) {
        if (this.epx != null && this.epy != null && this.eqM != null) {
            this.epy.py(i);
            pT(i);
            this.epx.setText(str);
            iD(true);
            com.baidu.adp.lib.h.j.a(this.epy, this.eqM.getPageContext().getPageActivity());
        }
    }

    public void iE(boolean z) {
        if (this.erh != null) {
            this.erh.setSelected(z);
        }
    }

    public void bg(View view) {
        if (view != null && this.epx != null && this.erh != null && this.epy != null) {
            this.epx.setVisibility(0);
            this.erh.setSelected(true);
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.epy, view, 0, com.baidu.adp.lib.util.k.dip2px(this.eqM.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void ej(int i) {
        if (this.aWl != null) {
            this.eqM.getLayoutMode().ac(i == 1);
            this.eqM.getLayoutMode().x(this.aWl);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ar.k(this.epw, t.f.s_navbar_button_bg);
        aUw();
    }
}
