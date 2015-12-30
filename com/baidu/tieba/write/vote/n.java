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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.write.write.cf;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<WriteVoteActivity> {
    private View aUe;
    private int aUh;
    private EditText dUM;
    private EditText dUQ;
    private TextView dUR;
    private TextView dUS;
    private cf dUT;
    private ImageView dUU;
    private WriteVoteActivity dVT;
    private final ArrayList<g> dWA;
    private View dWo;
    private View dWp;
    private ArrayList<com.baidu.tieba.write.view.j> dWq;
    private RadioGroup dWr;
    private RadioButton dWs;
    private RadioButton dWt;
    private TextView dWu;
    private c dWv;
    private LinearLayout dWw;
    private View dWx;
    private BdSwitchView dWy;
    private final ArrayList<g> dWz;
    private NavigationBar mNavigationBar;

    public View aLo() {
        return this.dWo;
    }

    public TextView aLp() {
        return this.dUS;
    }

    public View aLq() {
        return this.dUR;
    }

    public EditText aLr() {
        return this.dUM;
    }

    public EditText aLs() {
        return this.dUQ;
    }

    public BdSwitchView aLt() {
        return this.dWy;
    }

    public c aLu() {
        return this.dWv;
    }

    public TextView aLv() {
        return this.dWu;
    }

    public View aLw() {
        return this.dWx;
    }

    public ArrayList<g> aLx() {
        return this.dWz;
    }

    public ArrayList<g> aLy() {
        return this.dWA;
    }

    public n(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.aUh = 0;
        this.mNavigationBar = null;
        this.dUR = null;
        this.dWq = new ArrayList<>();
        this.dUM = null;
        this.dUQ = null;
        this.dWz = new ArrayList<>();
        this.dWA = new ArrayList<>();
        this.dVT = writeVoteActivity;
        initView();
        initListener();
        aLz();
        fr(this.aUh);
    }

    private void initView() {
        this.dVT.setContentView(n.h.write_vote_activity);
        this.aUe = (RelativeLayout) this.dVT.findViewById(n.g.parent);
        this.mNavigationBar = (NavigationBar) this.dVT.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dVT.getPageContext().getString(n.j.write_vote_titlebar));
        this.dUR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.j.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUR.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.e.ds16);
        this.dUR.setLayoutParams(layoutParams);
        this.dUR.setEnabled(false);
        this.dUM = (EditText) this.dVT.findViewById(n.g.post_title);
        this.dUQ = (EditText) this.dVT.findViewById(n.g.post_content);
        this.dWr = (RadioGroup) this.dVT.findViewById(n.g.raidos_tabs_vote);
        this.dWs = (RadioButton) this.dVT.findViewById(n.g.radio_vote_pic);
        this.dWt = (RadioButton) this.dVT.findViewById(n.g.radio_vote_text);
        this.dWu = (TextView) this.dVT.findViewById(n.g.endtime_day);
        this.dWv = new c(this.dVT);
        this.dWw = (LinearLayout) this.dVT.findViewById(n.g.vote_container);
        this.dWx = this.dVT.findViewById(n.g.vote_add_layout);
        this.dWy = (BdSwitchView) this.dVT.findViewById(n.g.multiple_switch);
        this.dWy.mf();
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.dVT != null) {
            this.dWo = this.dVT.findViewById(n.g.post_prefix_layout);
            this.dUS = (TextView) this.dVT.findViewById(n.g.post_prefix);
            this.dWp = this.dVT.findViewById(n.g.prefix_divider);
            this.dUU = (ImageView) this.dVT.findViewById(n.g.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.dWo.setVisibility(0);
                this.dWp.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.dWo.setOnClickListener(this.dVT);
                this.dUU = (ImageView) this.dVT.findViewById(n.g.prefix_icon);
                if (size > 1) {
                    this.dUU.setVisibility(0);
                    this.dUS.setOnClickListener(this.dVT);
                }
                this.dUT = new cf(this.dVT.getPageContext().getPageActivity());
                this.dUT.a(this.dVT);
                this.dUT.setMaxHeight(com.baidu.adp.lib.util.k.d(this.dVT.getActivity(), n.e.ds510));
                this.dUT.setOutsideTouchable(true);
                this.dUT.setFocusable(true);
                this.dUT.setOnDismissListener(this.dVT);
                this.dUT.setBackgroundDrawable(as.getDrawable(n.d.cp_bg_line_d));
                int color = as.getColor(n.d.write_text);
                int color2 = as.getColor(n.d.cp_cont_c);
                as.i((View) this.dUS, n.d.cp_bg_line_d);
                as.c(this.dUU, n.f.icon_title_down);
                this.dUS.setTextColor(color);
                this.dWq.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(this.dVT.getActivity());
                    this.dWq.add(jVar);
                    jVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        jVar.setPrefixTextColor(color2);
                    } else {
                        jVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        jVar.setDividerStyle(false);
                    }
                    this.dUT.addView(jVar);
                }
                this.dUT.od(0);
                this.dUS.setText(prefixs.get(1));
                oy(1);
                return;
            }
            this.dWo.setVisibility(8);
        }
    }

    private void aLz() {
        this.dWz.add(new g(this.dVT, 0));
        this.dWz.add(new g(this.dVT, 0));
        this.dWA.add(new g(this.dVT, 1));
        this.dWA.add(new g(this.dVT, 1));
    }

    private void initListener() {
        this.dWu.setOnClickListener(this.dVT);
        this.dWx.setOnClickListener(this.dVT);
        this.dUR.setOnClickListener(this.dVT);
        this.dWy.setOnSwitchStateChangeListener(this.dVT);
        this.dWv.a(this.dVT);
        this.dWr.setOnCheckedChangeListener(this.dVT);
        this.dUM.addTextChangedListener(new a(31, this.dUM));
        this.dUQ.addTextChangedListener(new a(50, this.dUQ));
    }

    public void fr(int i) {
        this.aUh = i;
        aLB();
        if (this.aUh == 0) {
            aq(this.dWz);
        } else if (this.aUh == 1) {
            aq(this.dWA);
        }
    }

    private void aLA() {
        if (this.aUh == 0) {
            if (this.dWz.size() >= 10) {
                this.dWx.setVisibility(8);
            } else {
                this.dWx.setVisibility(0);
            }
        } else if (this.aUh == 1) {
            if (this.dWA.size() >= 20) {
                this.dWx.setVisibility(8);
            } else {
                this.dWx.setVisibility(0);
            }
        }
    }

    private void aq(ArrayList<g> arrayList) {
        if (arrayList != null) {
            this.dWw.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && gVar.getView() != null) {
                        this.dWw.addView(gVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    aLA();
                    return;
                }
            }
        }
    }

    private void aLB() {
        if (this.dWs != null && this.dWt != null) {
            if (this.aUh == 0) {
                as.b(this.dWs, n.d.cp_link_tip_c, 3);
                as.b(this.dWt, n.d.cp_cont_f, 3);
            } else if (this.aUh == 1) {
                as.b(this.dWt, n.d.cp_link_tip_c, 3);
                as.b(this.dWs, n.d.cp_cont_f, 3);
            }
        }
    }

    public g ow(int i) {
        g gVar = null;
        if (i == 0) {
            gVar = new g(this.dVT, 0);
            this.dWz.add(gVar);
            this.dWw.addView(gVar.getView());
        } else if (i == 1) {
            gVar = new g(this.dVT, 1);
            this.dWA.add(gVar);
            this.dWw.addView(gVar.getView());
        }
        aLA();
        return gVar;
    }

    public g b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g cg = cg(this.dWz);
        if (cg != null) {
            cg.a(imageFileInfo, aVar);
        } else {
            c(imageFileInfo, aVar);
        }
        return cg;
    }

    private g c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g gVar = new g(this.dVT, 0);
        gVar.a(imageFileInfo, aVar);
        this.dWz.add(gVar);
        this.dWw.addView(gVar.getView());
        aLA();
        return gVar;
    }

    public void ox(int i) {
        if (this.aUh == 0) {
            g i2 = i(this.dWz, i);
            if (i2 != null && i2.getView() != null) {
                this.dWz.remove(i2);
                this.dWw.removeView(i2.getView());
            } else {
                return;
            }
        } else if (this.aUh == 1) {
            g i3 = i(this.dWA, i);
            if (i3 != null && i3.getView() != null) {
                this.dWA.remove(i3);
                this.dWw.removeView(i3.getView());
            } else {
                return;
            }
        }
        aLA();
    }

    private g cg(List<g> list) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (!gVar.aLg()) {
                return gVar;
            }
        }
        return null;
    }

    private g i(List<g> list, int i) {
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

    public void nq(String str) {
        if (this.dWu != null) {
            this.dWu.setText(str);
        }
    }

    public void hS(boolean z) {
        if (this.dUR != null) {
            this.dUR.setEnabled(z);
        }
    }

    private void oy(int i) {
        if (i >= 0 && i < this.dWq.size()) {
            for (int i2 = 0; i2 < this.dWq.size(); i2++) {
                this.dWq.get(i2).hR(false);
            }
            this.dWq.get(i).hR(true);
        }
    }

    public void S(int i, String str) {
        if (this.dUS != null && this.dUT != null && this.dVT != null) {
            this.dUT.od(i);
            oy(i);
            this.dUS.setText(str);
            hS(true);
            com.baidu.adp.lib.h.j.a(this.dUT, this.dVT.getPageContext().getPageActivity());
        }
    }

    public void hT(boolean z) {
        if (this.dWo != null) {
            this.dWo.setSelected(z);
        }
    }

    public void aO(View view) {
        if (view != null && this.dUS != null && this.dWo != null && this.dUT != null) {
            this.dUS.setVisibility(0);
            this.dWo.setSelected(true);
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.dUT, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dVT.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void dO(int i) {
        if (this.aUe != null) {
            this.dVT.getLayoutMode().ac(i == 1);
            this.dVT.getLayoutMode().k(this.aUe);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        as.i((View) this.dUR, n.f.s_navbar_button_bg);
        aLB();
    }
}
