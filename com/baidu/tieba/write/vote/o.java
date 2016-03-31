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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.cg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<WriteVoteActivity> {
    private View baU;
    private int baX;
    private EditText eJn;
    private EditText eJr;
    private TextView eJs;
    private TextView eJt;
    private cg eJu;
    private ImageView eJv;
    private WriteVoteActivity eKG;
    private View eLa;
    private View eLb;
    private ArrayList<com.baidu.tieba.write.view.j> eLc;
    private RadioGroup eLd;
    private RadioButton eLe;
    private RadioButton eLf;
    private TextView eLg;
    private c eLh;
    private LinearLayout eLi;
    private View eLj;
    private RelativeLayout eLk;
    private BdSwitchView eLl;
    private final ArrayList<g> eLm;
    private final ArrayList<g> eLn;
    private NavigationBar mNavigationBar;

    public View baJ() {
        return this.eLa;
    }

    public TextView baK() {
        return this.eJt;
    }

    public View baL() {
        return this.eJs;
    }

    public EditText baM() {
        return this.eJn;
    }

    public EditText baN() {
        return this.eJr;
    }

    public BdSwitchView baO() {
        return this.eLl;
    }

    public View baP() {
        return this.eLk;
    }

    public c baQ() {
        return this.eLh;
    }

    public TextView baR() {
        return this.eLg;
    }

    public View baS() {
        return this.eLj;
    }

    public ArrayList<g> baT() {
        return this.eLm;
    }

    public ArrayList<g> baU() {
        return this.eLn;
    }

    public o(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.baX = 0;
        this.mNavigationBar = null;
        this.eJs = null;
        this.eLc = new ArrayList<>();
        this.eJn = null;
        this.eJr = null;
        this.eLm = new ArrayList<>();
        this.eLn = new ArrayList<>();
        this.eKG = writeVoteActivity;
        initView();
        pf();
    }

    private void initView() {
        this.eKG.setContentView(t.h.write_vote_activity);
        this.baU = (RelativeLayout) this.eKG.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) this.eKG.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eKG.getPageContext().getString(t.j.write_vote_titlebar));
        this.eJs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJs.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.eJs.setLayoutParams(layoutParams);
        this.eJs.setEnabled(false);
        this.eJn = (EditText) this.eKG.findViewById(t.g.post_title);
        this.eJr = (EditText) this.eKG.findViewById(t.g.post_content);
        this.eLd = (RadioGroup) this.eKG.findViewById(t.g.raidos_tabs_vote);
        this.eLe = (RadioButton) this.eKG.findViewById(t.g.radio_vote_pic);
        this.eLf = (RadioButton) this.eKG.findViewById(t.g.radio_vote_text);
        this.eLg = (TextView) this.eKG.findViewById(t.g.endtime_day);
        this.eLh = new c(this.eKG);
        this.eLi = (LinearLayout) this.eKG.findViewById(t.g.vote_container);
        this.eLj = this.eKG.findViewById(t.g.vote_add_layout);
        this.eLk = (RelativeLayout) this.eKG.findViewById(t.g.multiple_switch_layout);
        this.eLl = (BdSwitchView) this.eKG.findViewById(t.g.multiple_switch);
        this.eLl.ml();
        this.eLk.setContentDescription(String.valueOf(this.eKG.getResources().getString(t.j.vote_multiple)) + this.eKG.getResources().getString(t.j.now_state_off));
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.eKG != null) {
            this.eLa = this.eKG.findViewById(t.g.post_prefix_layout);
            this.eJt = (TextView) this.eKG.findViewById(t.g.post_prefix);
            this.eLb = this.eKG.findViewById(t.g.prefix_divider);
            this.eJv = (ImageView) this.eKG.findViewById(t.g.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.eLa.setVisibility(0);
                this.eLb.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.eLa.setOnClickListener(this.eKG);
                this.eJv = (ImageView) this.eKG.findViewById(t.g.prefix_icon);
                if (size > 1) {
                    this.eJv.setVisibility(0);
                    this.eJt.setOnClickListener(this.eKG);
                }
                this.eJu = new cg(this.eKG.getPageContext().getPageActivity());
                this.eJu.a(this.eKG);
                this.eJu.setMaxHeight(com.baidu.adp.lib.util.k.c(this.eKG.getActivity(), t.e.ds510));
                this.eJu.setOutsideTouchable(true);
                this.eJu.setFocusable(true);
                this.eJu.setOnDismissListener(this.eKG);
                this.eJu.setBackgroundDrawable(at.getDrawable(t.d.cp_bg_line_d));
                int color = at.getColor(t.d.write_text);
                int color2 = at.getColor(t.d.cp_cont_c);
                at.k(this.eJt, t.d.cp_bg_line_d);
                at.c(this.eJv, t.f.icon_title_down);
                this.eJt.setTextColor(color);
                this.eLc.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(this.eKG.getActivity());
                    this.eLc.add(jVar);
                    jVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        jVar.setPrefixTextColor(color2);
                    } else {
                        jVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        jVar.setDividerStyle(false);
                    }
                    this.eJu.addView(jVar);
                }
                this.eJu.qr(0);
                this.eJt.setText(prefixs.get(1));
                qN(1);
                return;
            }
            this.eLa.setVisibility(8);
        }
    }

    public void baV() {
        this.eLm.add(new g(this.eKG, 0));
        this.eLm.add(new g(this.eKG, 0));
        this.eLn.add(new g(this.eKG, 1));
        this.eLn.add(new g(this.eKG, 1));
    }

    public void baW() {
        if (y.p(this.eLn) == 0) {
            this.eLn.add(new g(this.eKG, 1));
            this.eLn.add(new g(this.eKG, 1));
        }
    }

    private void pf() {
        this.eLg.setOnClickListener(this.eKG);
        this.eLj.setOnClickListener(this.eKG);
        this.eJs.setOnClickListener(this.eKG);
        this.eLk.setOnClickListener(this.eKG);
        this.eLl.setOnSwitchStateChangeListener(this.eKG);
        this.eLh.a(this.eKG);
        this.eLd.setOnCheckedChangeListener(this.eKG);
        this.eJn.addTextChangedListener(new a(31, this.eJn));
        this.eJr.addTextChangedListener(new a(50, this.eJr));
    }

    public void gg(int i) {
        this.baX = i;
        baY();
        if (this.baX == 0) {
            as(this.eLm);
        } else if (this.baX == 1) {
            as(this.eLn);
        }
    }

    private void baX() {
        if (this.baX == 0) {
            if (this.eLm.size() >= 10) {
                this.eLj.setVisibility(8);
            } else {
                this.eLj.setVisibility(0);
            }
        } else if (this.baX == 1) {
            if (this.eLn.size() >= 20) {
                this.eLj.setVisibility(8);
            } else {
                this.eLj.setVisibility(0);
            }
        }
    }

    private void as(ArrayList<g> arrayList) {
        if (arrayList != null) {
            this.eLi.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && gVar.getView() != null) {
                        this.eLi.addView(gVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    baX();
                    return;
                }
            }
        }
    }

    private void baY() {
        if (this.eLe != null && this.eLf != null) {
            if (this.baX == 0) {
                at.b(this.eLe, t.d.cp_link_tip_c, 3);
                at.b(this.eLf, t.d.cp_cont_f, 3);
            } else if (this.baX == 1) {
                at.b(this.eLf, t.d.cp_link_tip_c, 3);
                at.b(this.eLe, t.d.cp_cont_f, 3);
            }
        }
    }

    public g qL(int i) {
        g gVar = null;
        if (i == 0) {
            gVar = new g(this.eKG, 0);
            this.eLm.add(gVar);
            this.eLi.addView(gVar.getView());
        } else if (i == 1) {
            gVar = new g(this.eKG, 1);
            this.eLn.add(gVar);
            this.eLi.addView(gVar.getView());
        }
        baX();
        return gVar;
    }

    public g b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g cJ = cJ(this.eLm);
        if (cJ != null) {
            cJ.a(imageFileInfo, aVar);
        } else {
            a(imageFileInfo, aVar, "");
        }
        return cJ;
    }

    public g oW(String str) {
        g gVar = new g(this.eKG, 1);
        gVar.oU(str);
        this.eLn.add(gVar);
        this.eLi.addView(gVar.getView());
        return gVar;
    }

    public g a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar, String str) {
        g gVar = new g(this.eKG, 0);
        gVar.a(imageFileInfo, aVar);
        gVar.oU(str);
        this.eLm.add(gVar);
        this.eLi.addView(gVar.getView());
        baX();
        return gVar;
    }

    public void qM(int i) {
        if (this.baX == 0) {
            g n = n(this.eLm, i);
            if (n != null && n.getView() != null) {
                this.eLm.remove(n);
                this.eLi.removeView(n.getView());
            } else {
                return;
            }
        } else if (this.baX == 1) {
            g n2 = n(this.eLn, i);
            if (n2 != null && n2.getView() != null) {
                this.eLn.remove(n2);
                this.eLi.removeView(n2.getView());
            } else {
                return;
            }
        }
        baX();
    }

    private g cJ(List<g> list) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (!gVar.baB()) {
                return gVar;
            }
        }
        return null;
    }

    private g n(List<g> list, int i) {
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

    public void oX(String str) {
        if (this.eLg != null) {
            this.eLg.setText(str);
            this.eLg.setContentDescription(String.valueOf(str) + getPageContext().getString(t.j.selected));
        }
    }

    public void jt(boolean z) {
        if (this.eJs != null) {
            this.eJs.setEnabled(z);
        }
    }

    private void qN(int i) {
        if (i >= 0 && i < this.eLc.size()) {
            for (int i2 = 0; i2 < this.eLc.size(); i2++) {
                this.eLc.get(i2).js(false);
            }
            this.eLc.get(i).js(true);
        }
    }

    public void R(int i, String str) {
        if (this.eJt != null && this.eJu != null && this.eKG != null) {
            this.eJu.qr(i);
            qN(i);
            this.eJt.setText(str);
            jt(true);
            com.baidu.adp.lib.h.j.a(this.eJu, this.eKG.getPageContext().getPageActivity());
        }
    }

    public void ju(boolean z) {
        if (this.eLa != null) {
            this.eLa.setSelected(z);
        }
    }

    public void bl(View view) {
        if (view != null && this.eJt != null && this.eLa != null && this.eJu != null) {
            this.eJt.setVisibility(0);
            this.eLa.setSelected(true);
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.eJu, view, 0, com.baidu.adp.lib.util.k.dip2px(this.eKG.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void em(int i) {
        if (this.baU != null) {
            this.eKG.getLayoutMode().ab(i == 1);
            this.eKG.getLayoutMode().x(this.baU);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        at.k(this.eJs, t.f.s_navbar_button_bg);
        baY();
    }
}
