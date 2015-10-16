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
import com.baidu.tieba.write.write.cd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<WriteVoteActivity> {
    private View cxl;
    private EditText dmD;
    private TextView dmE;
    private TextView dmF;
    private cd dmG;
    private ImageView dmH;
    private EditText dmz;
    private WriteVoteActivity dnC;
    private View dnX;
    private View dnY;
    private ArrayList<com.baidu.tieba.write.view.g> dnZ;
    private RadioGroup doa;
    private RadioButton dob;
    private RadioButton doc;
    private TextView dod;
    private c doe;
    private LinearLayout dof;
    private View dog;
    private BdSwitchView doh;
    private final ArrayList<g> doi;
    private final ArrayList<g> doj;
    private int mCurrentTab;
    private NavigationBar mNavigationBar;

    public View aCI() {
        return this.dnX;
    }

    public TextView aCJ() {
        return this.dmF;
    }

    public View aCK() {
        return this.dmE;
    }

    public EditText aCL() {
        return this.dmz;
    }

    public EditText aCM() {
        return this.dmD;
    }

    public BdSwitchView aCN() {
        return this.doh;
    }

    public c aCO() {
        return this.doe;
    }

    public TextView aCP() {
        return this.dod;
    }

    public View aCQ() {
        return this.dog;
    }

    public ArrayList<g> aCR() {
        return this.doi;
    }

    public ArrayList<g> aCS() {
        return this.doj;
    }

    public n(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.mCurrentTab = 0;
        this.mNavigationBar = null;
        this.dmE = null;
        this.dnZ = new ArrayList<>();
        this.dmz = null;
        this.dmD = null;
        this.doi = new ArrayList<>();
        this.doj = new ArrayList<>();
        this.dnC = writeVoteActivity;
        initView();
        initListener();
        aCT();
        gt(this.mCurrentTab);
    }

    private void initView() {
        this.dnC.setContentView(i.g.write_vote_activity);
        this.cxl = (RelativeLayout) this.dnC.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.dnC.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dnC.getPageContext().getString(i.h.write_vote_titlebar));
        this.dmE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmE.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dmE.setLayoutParams(layoutParams);
        this.dmE.setEnabled(false);
        this.dmz = (EditText) this.dnC.findViewById(i.f.post_title);
        this.dmD = (EditText) this.dnC.findViewById(i.f.post_content);
        this.doa = (RadioGroup) this.dnC.findViewById(i.f.raidos_tabs_vote);
        this.dob = (RadioButton) this.dnC.findViewById(i.f.radio_vote_pic);
        this.doc = (RadioButton) this.dnC.findViewById(i.f.radio_vote_text);
        this.dod = (TextView) this.dnC.findViewById(i.f.endtime_day);
        this.doe = new c(this.dnC);
        this.dof = (LinearLayout) this.dnC.findViewById(i.f.vote_container);
        this.dog = this.dnC.findViewById(i.f.vote_add_layout);
        this.doh = (BdSwitchView) this.dnC.findViewById(i.f.multiple_switch);
        this.doh.mC();
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.dnC != null) {
            this.dnX = this.dnC.findViewById(i.f.post_prefix_layout);
            this.dmF = (TextView) this.dnC.findViewById(i.f.post_prefix);
            this.dnY = this.dnC.findViewById(i.f.prefix_divider);
            this.dmH = (ImageView) this.dnC.findViewById(i.f.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.dnX.setVisibility(0);
                this.dnY.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.dnX.setOnClickListener(this.dnC);
                this.dmH = (ImageView) this.dnC.findViewById(i.f.prefix_icon);
                if (size > 1) {
                    this.dmH.setVisibility(0);
                    this.dmF.setOnClickListener(this.dnC);
                }
                this.dmG = new cd(this.dnC.getPageContext().getPageActivity());
                this.dmG.a(this.dnC);
                this.dmG.setMaxHeight(com.baidu.adp.lib.util.k.d(this.dnC.getActivity(), i.d.ds510));
                this.dmG.setOutsideTouchable(true);
                this.dmG.setFocusable(true);
                this.dmG.setOnDismissListener(this.dnC);
                this.dmG.setBackgroundDrawable(an.getDrawable(i.c.cp_bg_line_d));
                int color = an.getColor(i.c.write_text);
                int color2 = an.getColor(i.c.cp_cont_c);
                an.i((View) this.dmF, i.c.cp_bg_line_d);
                an.c(this.dmH, i.e.icon_title_down);
                this.dmF.setTextColor(color);
                this.dnZ.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.view.g gVar = new com.baidu.tieba.write.view.g(this.dnC.getActivity());
                    this.dnZ.add(gVar);
                    gVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        gVar.setPrefixTextColor(color2);
                    } else {
                        gVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        gVar.setDividerStyle(false);
                    }
                    this.dmG.addView(gVar);
                }
                this.dmG.lL(0);
                this.dmF.setText(prefixs.get(1));
                mg(1);
                return;
            }
            this.dnX.setVisibility(8);
        }
    }

    private void aCT() {
        this.doi.add(new g(this.dnC, 0));
        this.doi.add(new g(this.dnC, 0));
        this.doj.add(new g(this.dnC, 1));
        this.doj.add(new g(this.dnC, 1));
    }

    private void initListener() {
        this.dod.setOnClickListener(this.dnC);
        this.dog.setOnClickListener(this.dnC);
        this.dmE.setOnClickListener(this.dnC);
        this.doh.setOnSwitchStateChangeListener(this.dnC);
        this.doe.a(this.dnC);
        this.doa.setOnCheckedChangeListener(this.dnC);
        this.dmz.addTextChangedListener(new a(31, this.dmz));
        this.dmD.addTextChangedListener(new a(50, this.dmD));
    }

    public void gt(int i) {
        this.mCurrentTab = i;
        aCV();
        if (this.mCurrentTab == 0) {
            aj(this.doi);
        } else if (this.mCurrentTab == 1) {
            aj(this.doj);
        }
    }

    private void aCU() {
        if (this.mCurrentTab == 0) {
            if (this.doi.size() >= 10) {
                this.dog.setVisibility(8);
            } else {
                this.dog.setVisibility(0);
            }
        } else if (this.mCurrentTab == 1) {
            if (this.doj.size() >= 20) {
                this.dog.setVisibility(8);
            } else {
                this.dog.setVisibility(0);
            }
        }
    }

    private void aj(ArrayList<g> arrayList) {
        if (arrayList != null) {
            this.dof.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && gVar.getView() != null) {
                        this.dof.addView(gVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    aCU();
                    return;
                }
            }
        }
    }

    private void aCV() {
        if (this.dob != null && this.doc != null) {
            if (this.mCurrentTab == 0) {
                an.b(this.dob, i.c.cp_link_tip_c, 3);
                an.b(this.doc, i.c.cp_cont_f, 3);
            } else if (this.mCurrentTab == 1) {
                an.b(this.doc, i.c.cp_link_tip_c, 3);
                an.b(this.dob, i.c.cp_cont_f, 3);
            }
        }
    }

    public g me(int i) {
        g gVar = null;
        if (i == 0) {
            gVar = new g(this.dnC, 0);
            this.doi.add(gVar);
            this.dof.addView(gVar.getView());
        } else if (i == 1) {
            gVar = new g(this.dnC, 1);
            this.doj.add(gVar);
            this.dof.addView(gVar.getView());
        }
        aCU();
        return gVar;
    }

    public g b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g bL = bL(this.doi);
        if (bL != null) {
            bL.a(imageFileInfo, aVar);
        } else {
            c(imageFileInfo, aVar);
        }
        return bL;
    }

    private g c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g gVar = new g(this.dnC, 0);
        gVar.a(imageFileInfo, aVar);
        this.doi.add(gVar);
        this.dof.addView(gVar.getView());
        aCU();
        return gVar;
    }

    public void mf(int i) {
        if (this.mCurrentTab == 0) {
            g h = h(this.doi, i);
            if (h != null && h.getView() != null) {
                this.doi.remove(h);
                this.dof.removeView(h.getView());
            } else {
                return;
            }
        } else if (this.mCurrentTab == 1) {
            g h2 = h(this.doj, i);
            if (h2 != null && h2.getView() != null) {
                this.doj.remove(h2);
                this.dof.removeView(h2.getView());
            } else {
                return;
            }
        }
        aCU();
    }

    private g bL(List<g> list) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (!gVar.aCA()) {
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

    public void mt(String str) {
        if (this.dod != null) {
            this.dod.setText(str);
        }
    }

    public void gY(boolean z) {
        if (this.dmE != null) {
            this.dmE.setEnabled(z);
        }
    }

    private void mg(int i) {
        if (i >= 0 && i < this.dnZ.size()) {
            for (int i2 = 0; i2 < this.dnZ.size(); i2++) {
                this.dnZ.get(i2).gX(false);
            }
            this.dnZ.get(i).gX(true);
        }
    }

    public void P(int i, String str) {
        if (this.dmF != null && this.dmG != null && this.dnC != null) {
            this.dmG.lL(i);
            mg(i);
            this.dmF.setText(str);
            gY(true);
            com.baidu.adp.lib.g.j.a(this.dmG, this.dnC.getPageContext().getPageActivity());
        }
    }

    public void gZ(boolean z) {
        if (this.dnX != null) {
            this.dnX.setSelected(z);
        }
    }

    public void aA(View view) {
        if (view != null && this.dmF != null && this.dnX != null && this.dmG != null) {
            this.dmF.setVisibility(0);
            this.dnX.setSelected(true);
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.dmG, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dnC.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void dF(int i) {
        if (this.cxl != null) {
            this.dnC.getLayoutMode().ad(i == 1);
            this.dnC.getLayoutMode().k(this.cxl);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        an.i((View) this.dmE, i.e.s_navbar_button_bg);
        aCV();
    }
}
