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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.cf;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<WriteVoteActivity> {
    private View cyH;
    private EditText doh;
    private EditText dol;
    private TextView dom;
    private TextView don;
    private cf doo;
    private ImageView dop;
    private View dpM;
    private View dpN;
    private ArrayList<com.baidu.tieba.write.view.j> dpO;
    private RadioGroup dpP;
    private RadioButton dpQ;
    private RadioButton dpR;
    private TextView dpS;
    private c dpT;
    private LinearLayout dpU;
    private View dpV;
    private BdSwitchView dpW;
    private final ArrayList<g> dpX;
    private final ArrayList<g> dpY;
    private WriteVoteActivity dpr;
    private int mCurrentTab;
    private NavigationBar mNavigationBar;

    public View aDw() {
        return this.dpM;
    }

    public TextView aDx() {
        return this.don;
    }

    public View aDy() {
        return this.dom;
    }

    public EditText aDz() {
        return this.doh;
    }

    public EditText aDA() {
        return this.dol;
    }

    public BdSwitchView aDB() {
        return this.dpW;
    }

    public c aDC() {
        return this.dpT;
    }

    public TextView aDD() {
        return this.dpS;
    }

    public View aDE() {
        return this.dpV;
    }

    public ArrayList<g> aDF() {
        return this.dpX;
    }

    public ArrayList<g> aDG() {
        return this.dpY;
    }

    public n(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.mCurrentTab = 0;
        this.mNavigationBar = null;
        this.dom = null;
        this.dpO = new ArrayList<>();
        this.doh = null;
        this.dol = null;
        this.dpX = new ArrayList<>();
        this.dpY = new ArrayList<>();
        this.dpr = writeVoteActivity;
        initView();
        initListener();
        aDH();
        gG(this.mCurrentTab);
    }

    private void initView() {
        this.dpr.setContentView(i.g.write_vote_activity);
        this.cyH = (RelativeLayout) this.dpr.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.dpr.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dpr.getPageContext().getString(i.h.write_vote_titlebar));
        this.dom = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dom.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dom.setLayoutParams(layoutParams);
        this.dom.setEnabled(false);
        this.doh = (EditText) this.dpr.findViewById(i.f.post_title);
        this.dol = (EditText) this.dpr.findViewById(i.f.post_content);
        this.dpP = (RadioGroup) this.dpr.findViewById(i.f.raidos_tabs_vote);
        this.dpQ = (RadioButton) this.dpr.findViewById(i.f.radio_vote_pic);
        this.dpR = (RadioButton) this.dpr.findViewById(i.f.radio_vote_text);
        this.dpS = (TextView) this.dpr.findViewById(i.f.endtime_day);
        this.dpT = new c(this.dpr);
        this.dpU = (LinearLayout) this.dpr.findViewById(i.f.vote_container);
        this.dpV = this.dpr.findViewById(i.f.vote_add_layout);
        this.dpW = (BdSwitchView) this.dpr.findViewById(i.f.multiple_switch);
        this.dpW.mD();
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.dpr != null) {
            this.dpM = this.dpr.findViewById(i.f.post_prefix_layout);
            this.don = (TextView) this.dpr.findViewById(i.f.post_prefix);
            this.dpN = this.dpr.findViewById(i.f.prefix_divider);
            this.dop = (ImageView) this.dpr.findViewById(i.f.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.dpM.setVisibility(0);
                this.dpN.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.dpM.setOnClickListener(this.dpr);
                this.dop = (ImageView) this.dpr.findViewById(i.f.prefix_icon);
                if (size > 1) {
                    this.dop.setVisibility(0);
                    this.don.setOnClickListener(this.dpr);
                }
                this.doo = new cf(this.dpr.getPageContext().getPageActivity());
                this.doo.a(this.dpr);
                this.doo.setMaxHeight(com.baidu.adp.lib.util.k.d(this.dpr.getActivity(), i.d.ds510));
                this.doo.setOutsideTouchable(true);
                this.doo.setFocusable(true);
                this.doo.setOnDismissListener(this.dpr);
                this.doo.setBackgroundDrawable(an.getDrawable(i.c.cp_bg_line_d));
                int color = an.getColor(i.c.write_text);
                int color2 = an.getColor(i.c.cp_cont_c);
                an.i((View) this.don, i.c.cp_bg_line_d);
                an.c(this.dop, i.e.icon_title_down);
                this.don.setTextColor(color);
                this.dpO.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(this.dpr.getActivity());
                    this.dpO.add(jVar);
                    jVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        jVar.setPrefixTextColor(color2);
                    } else {
                        jVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        jVar.setDividerStyle(false);
                    }
                    this.doo.addView(jVar);
                }
                this.doo.lZ(0);
                this.don.setText(prefixs.get(1));
                mu(1);
                return;
            }
            this.dpM.setVisibility(8);
        }
    }

    private void aDH() {
        this.dpX.add(new g(this.dpr, 0));
        this.dpX.add(new g(this.dpr, 0));
        this.dpY.add(new g(this.dpr, 1));
        this.dpY.add(new g(this.dpr, 1));
    }

    private void initListener() {
        this.dpS.setOnClickListener(this.dpr);
        this.dpV.setOnClickListener(this.dpr);
        this.dom.setOnClickListener(this.dpr);
        this.dpW.setOnSwitchStateChangeListener(this.dpr);
        this.dpT.a(this.dpr);
        this.dpP.setOnCheckedChangeListener(this.dpr);
        this.doh.addTextChangedListener(new a(31, this.doh));
        this.dol.addTextChangedListener(new a(50, this.dol));
    }

    public void gG(int i) {
        this.mCurrentTab = i;
        aDJ();
        if (this.mCurrentTab == 0) {
            aj(this.dpX);
        } else if (this.mCurrentTab == 1) {
            aj(this.dpY);
        }
    }

    private void aDI() {
        if (this.mCurrentTab == 0) {
            if (this.dpX.size() >= 10) {
                this.dpV.setVisibility(8);
            } else {
                this.dpV.setVisibility(0);
            }
        } else if (this.mCurrentTab == 1) {
            if (this.dpY.size() >= 20) {
                this.dpV.setVisibility(8);
            } else {
                this.dpV.setVisibility(0);
            }
        }
    }

    private void aj(ArrayList<g> arrayList) {
        if (arrayList != null) {
            this.dpU.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && gVar.getView() != null) {
                        this.dpU.addView(gVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    aDI();
                    return;
                }
            }
        }
    }

    private void aDJ() {
        if (this.dpQ != null && this.dpR != null) {
            if (this.mCurrentTab == 0) {
                an.b(this.dpQ, i.c.cp_link_tip_c, 3);
                an.b(this.dpR, i.c.cp_cont_f, 3);
            } else if (this.mCurrentTab == 1) {
                an.b(this.dpR, i.c.cp_link_tip_c, 3);
                an.b(this.dpQ, i.c.cp_cont_f, 3);
            }
        }
    }

    public g ms(int i) {
        g gVar = null;
        if (i == 0) {
            gVar = new g(this.dpr, 0);
            this.dpX.add(gVar);
            this.dpU.addView(gVar.getView());
        } else if (i == 1) {
            gVar = new g(this.dpr, 1);
            this.dpY.add(gVar);
            this.dpU.addView(gVar.getView());
        }
        aDI();
        return gVar;
    }

    public g b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g bP = bP(this.dpX);
        if (bP != null) {
            bP.a(imageFileInfo, aVar);
        } else {
            c(imageFileInfo, aVar);
        }
        return bP;
    }

    private g c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g gVar = new g(this.dpr, 0);
        gVar.a(imageFileInfo, aVar);
        this.dpX.add(gVar);
        this.dpU.addView(gVar.getView());
        aDI();
        return gVar;
    }

    public void mt(int i) {
        if (this.mCurrentTab == 0) {
            g h = h(this.dpX, i);
            if (h != null && h.getView() != null) {
                this.dpX.remove(h);
                this.dpU.removeView(h.getView());
            } else {
                return;
            }
        } else if (this.mCurrentTab == 1) {
            g h2 = h(this.dpY, i);
            if (h2 != null && h2.getView() != null) {
                this.dpY.remove(h2);
                this.dpU.removeView(h2.getView());
            } else {
                return;
            }
        }
        aDI();
    }

    private g bP(List<g> list) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (!gVar.aDo()) {
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

    public void mx(String str) {
        if (this.dpS != null) {
            this.dpS.setText(str);
        }
    }

    public void hb(boolean z) {
        if (this.dom != null) {
            this.dom.setEnabled(z);
        }
    }

    private void mu(int i) {
        if (i >= 0 && i < this.dpO.size()) {
            for (int i2 = 0; i2 < this.dpO.size(); i2++) {
                this.dpO.get(i2).ha(false);
            }
            this.dpO.get(i).ha(true);
        }
    }

    public void Q(int i, String str) {
        if (this.don != null && this.doo != null && this.dpr != null) {
            this.doo.lZ(i);
            mu(i);
            this.don.setText(str);
            hb(true);
            com.baidu.adp.lib.g.j.a(this.doo, this.dpr.getPageContext().getPageActivity());
        }
    }

    public void hc(boolean z) {
        if (this.dpM != null) {
            this.dpM.setSelected(z);
        }
    }

    public void az(View view) {
        if (view != null && this.don != null && this.dpM != null && this.doo != null) {
            this.don.setVisibility(0);
            this.dpM.setSelected(true);
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.doo, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dpr.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void dF(int i) {
        if (this.cyH != null) {
            this.dpr.getLayoutMode().ad(i == 1);
            this.dpr.getLayoutMode().k(this.cyH);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        an.i((View) this.dom, i.e.s_navbar_button_bg);
        aDJ();
    }
}
