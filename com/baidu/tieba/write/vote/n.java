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
    private View aQm;
    private int aQr;
    private EditText dNn;
    private EditText dNr;
    private TextView dNs;
    private TextView dNt;
    private cf dNu;
    private ImageView dNv;
    private View dOP;
    private View dOQ;
    private ArrayList<com.baidu.tieba.write.view.j> dOR;
    private RadioGroup dOS;
    private RadioButton dOT;
    private RadioButton dOU;
    private TextView dOV;
    private c dOW;
    private LinearLayout dOX;
    private View dOY;
    private BdSwitchView dOZ;
    private WriteVoteActivity dOu;
    private final ArrayList<g> dPa;
    private final ArrayList<g> dPb;
    private NavigationBar mNavigationBar;

    public View aIT() {
        return this.dOP;
    }

    public TextView aIU() {
        return this.dNt;
    }

    public View aIV() {
        return this.dNs;
    }

    public EditText aIW() {
        return this.dNn;
    }

    public EditText aIX() {
        return this.dNr;
    }

    public BdSwitchView aIY() {
        return this.dOZ;
    }

    public c aIZ() {
        return this.dOW;
    }

    public TextView aJa() {
        return this.dOV;
    }

    public View aJb() {
        return this.dOY;
    }

    public ArrayList<g> aJc() {
        return this.dPa;
    }

    public ArrayList<g> aJd() {
        return this.dPb;
    }

    public n(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.aQr = 0;
        this.mNavigationBar = null;
        this.dNs = null;
        this.dOR = new ArrayList<>();
        this.dNn = null;
        this.dNr = null;
        this.dPa = new ArrayList<>();
        this.dPb = new ArrayList<>();
        this.dOu = writeVoteActivity;
        initView();
        initListener();
        aJe();
        fw(this.aQr);
    }

    private void initView() {
        this.dOu.setContentView(n.g.write_vote_activity);
        this.aQm = (RelativeLayout) this.dOu.findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) this.dOu.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dOu.getPageContext().getString(n.i.write_vote_titlebar));
        this.dNs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.i.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dNs.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.d.ds16);
        this.dNs.setLayoutParams(layoutParams);
        this.dNs.setEnabled(false);
        this.dNn = (EditText) this.dOu.findViewById(n.f.post_title);
        this.dNr = (EditText) this.dOu.findViewById(n.f.post_content);
        this.dOS = (RadioGroup) this.dOu.findViewById(n.f.raidos_tabs_vote);
        this.dOT = (RadioButton) this.dOu.findViewById(n.f.radio_vote_pic);
        this.dOU = (RadioButton) this.dOu.findViewById(n.f.radio_vote_text);
        this.dOV = (TextView) this.dOu.findViewById(n.f.endtime_day);
        this.dOW = new c(this.dOu);
        this.dOX = (LinearLayout) this.dOu.findViewById(n.f.vote_container);
        this.dOY = this.dOu.findViewById(n.f.vote_add_layout);
        this.dOZ = (BdSwitchView) this.dOu.findViewById(n.f.multiple_switch);
        this.dOZ.mH();
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.dOu != null) {
            this.dOP = this.dOu.findViewById(n.f.post_prefix_layout);
            this.dNt = (TextView) this.dOu.findViewById(n.f.post_prefix);
            this.dOQ = this.dOu.findViewById(n.f.prefix_divider);
            this.dNv = (ImageView) this.dOu.findViewById(n.f.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.dOP.setVisibility(0);
                this.dOQ.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.dOP.setOnClickListener(this.dOu);
                this.dNv = (ImageView) this.dOu.findViewById(n.f.prefix_icon);
                if (size > 1) {
                    this.dNv.setVisibility(0);
                    this.dNt.setOnClickListener(this.dOu);
                }
                this.dNu = new cf(this.dOu.getPageContext().getPageActivity());
                this.dNu.a(this.dOu);
                this.dNu.setMaxHeight(com.baidu.adp.lib.util.k.d(this.dOu.getActivity(), n.d.ds510));
                this.dNu.setOutsideTouchable(true);
                this.dNu.setFocusable(true);
                this.dNu.setOnDismissListener(this.dOu);
                this.dNu.setBackgroundDrawable(as.getDrawable(n.c.cp_bg_line_d));
                int color = as.getColor(n.c.write_text);
                int color2 = as.getColor(n.c.cp_cont_c);
                as.i((View) this.dNt, n.c.cp_bg_line_d);
                as.c(this.dNv, n.e.icon_title_down);
                this.dNt.setTextColor(color);
                this.dOR.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(this.dOu.getActivity());
                    this.dOR.add(jVar);
                    jVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        jVar.setPrefixTextColor(color2);
                    } else {
                        jVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        jVar.setDividerStyle(false);
                    }
                    this.dNu.addView(jVar);
                }
                this.dNu.nl(0);
                this.dNt.setText(prefixs.get(1));
                nG(1);
                return;
            }
            this.dOP.setVisibility(8);
        }
    }

    private void aJe() {
        this.dPa.add(new g(this.dOu, 0));
        this.dPa.add(new g(this.dOu, 0));
        this.dPb.add(new g(this.dOu, 1));
        this.dPb.add(new g(this.dOu, 1));
    }

    private void initListener() {
        this.dOV.setOnClickListener(this.dOu);
        this.dOY.setOnClickListener(this.dOu);
        this.dNs.setOnClickListener(this.dOu);
        this.dOZ.setOnSwitchStateChangeListener(this.dOu);
        this.dOW.a(this.dOu);
        this.dOS.setOnCheckedChangeListener(this.dOu);
        this.dNn.addTextChangedListener(new a(31, this.dNn));
        this.dNr.addTextChangedListener(new a(50, this.dNr));
    }

    public void fw(int i) {
        this.aQr = i;
        aJg();
        if (this.aQr == 0) {
            aq(this.dPa);
        } else if (this.aQr == 1) {
            aq(this.dPb);
        }
    }

    private void aJf() {
        if (this.aQr == 0) {
            if (this.dPa.size() >= 10) {
                this.dOY.setVisibility(8);
            } else {
                this.dOY.setVisibility(0);
            }
        } else if (this.aQr == 1) {
            if (this.dPb.size() >= 20) {
                this.dOY.setVisibility(8);
            } else {
                this.dOY.setVisibility(0);
            }
        }
    }

    private void aq(ArrayList<g> arrayList) {
        if (arrayList != null) {
            this.dOX.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && gVar.getView() != null) {
                        this.dOX.addView(gVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    aJf();
                    return;
                }
            }
        }
    }

    private void aJg() {
        if (this.dOT != null && this.dOU != null) {
            if (this.aQr == 0) {
                as.b(this.dOT, n.c.cp_link_tip_c, 3);
                as.b(this.dOU, n.c.cp_cont_f, 3);
            } else if (this.aQr == 1) {
                as.b(this.dOU, n.c.cp_link_tip_c, 3);
                as.b(this.dOT, n.c.cp_cont_f, 3);
            }
        }
    }

    public g nE(int i) {
        g gVar = null;
        if (i == 0) {
            gVar = new g(this.dOu, 0);
            this.dPa.add(gVar);
            this.dOX.addView(gVar.getView());
        } else if (i == 1) {
            gVar = new g(this.dOu, 1);
            this.dPb.add(gVar);
            this.dOX.addView(gVar.getView());
        }
        aJf();
        return gVar;
    }

    public g b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g cd = cd(this.dPa);
        if (cd != null) {
            cd.a(imageFileInfo, aVar);
        } else {
            c(imageFileInfo, aVar);
        }
        return cd;
    }

    private g c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g gVar = new g(this.dOu, 0);
        gVar.a(imageFileInfo, aVar);
        this.dPa.add(gVar);
        this.dOX.addView(gVar.getView());
        aJf();
        return gVar;
    }

    public void nF(int i) {
        if (this.aQr == 0) {
            g h = h(this.dPa, i);
            if (h != null && h.getView() != null) {
                this.dPa.remove(h);
                this.dOX.removeView(h.getView());
            } else {
                return;
            }
        } else if (this.aQr == 1) {
            g h2 = h(this.dPb, i);
            if (h2 != null && h2.getView() != null) {
                this.dPb.remove(h2);
                this.dOX.removeView(h2.getView());
            } else {
                return;
            }
        }
        aJf();
    }

    private g cd(List<g> list) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (!gVar.aIL()) {
                return gVar;
            }
        }
        return null;
    }

    private g h(List<g> list, int i) {
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

    public void ns(String str) {
        if (this.dOV != null) {
            this.dOV.setText(str);
        }
    }

    public void hJ(boolean z) {
        if (this.dNs != null) {
            this.dNs.setEnabled(z);
        }
    }

    private void nG(int i) {
        if (i >= 0 && i < this.dOR.size()) {
            for (int i2 = 0; i2 < this.dOR.size(); i2++) {
                this.dOR.get(i2).hI(false);
            }
            this.dOR.get(i).hI(true);
        }
    }

    public void R(int i, String str) {
        if (this.dNt != null && this.dNu != null && this.dOu != null) {
            this.dNu.nl(i);
            nG(i);
            this.dNt.setText(str);
            hJ(true);
            com.baidu.adp.lib.h.j.a(this.dNu, this.dOu.getPageContext().getPageActivity());
        }
    }

    public void hK(boolean z) {
        if (this.dOP != null) {
            this.dOP.setSelected(z);
        }
    }

    public void aI(View view) {
        if (view != null && this.dNt != null && this.dOP != null && this.dNu != null) {
            this.dNt.setVisibility(0);
            this.dOP.setSelected(true);
            com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(this.dNu, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dOu.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void dU(int i) {
        if (this.aQm != null) {
            this.dOu.getLayoutMode().af(i == 1);
            this.dOu.getLayoutMode().k(this.aQm);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        as.i((View) this.dNs, n.e.s_navbar_button_bg);
        aJg();
    }
}
