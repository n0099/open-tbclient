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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.cd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<WriteVoteActivity> {
    private View cxa;
    private EditText dlZ;
    private EditText dmd;
    private TextView dme;
    private TextView dmf;
    private cd dmg;
    private ImageView dmh;
    private RadioGroup dnA;
    private RadioButton dnB;
    private RadioButton dnC;
    private TextView dnD;
    private c dnE;
    private LinearLayout dnF;
    private View dnG;
    private BdSwitchView dnH;
    private final ArrayList<g> dnI;
    private final ArrayList<g> dnJ;
    private WriteVoteActivity dnc;
    private View dnx;
    private View dny;
    private ArrayList<com.baidu.tieba.write.view.g> dnz;
    private int mCurrentTab;
    private NavigationBar mNavigationBar;

    public View aCy() {
        return this.dnx;
    }

    public TextView aCz() {
        return this.dmf;
    }

    public View aCA() {
        return this.dme;
    }

    public EditText aCB() {
        return this.dlZ;
    }

    public EditText aCC() {
        return this.dmd;
    }

    public BdSwitchView aCD() {
        return this.dnH;
    }

    public c aCE() {
        return this.dnE;
    }

    public TextView aCF() {
        return this.dnD;
    }

    public View aCG() {
        return this.dnG;
    }

    public ArrayList<g> aCH() {
        return this.dnI;
    }

    public ArrayList<g> aCI() {
        return this.dnJ;
    }

    public n(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.mCurrentTab = 0;
        this.mNavigationBar = null;
        this.dme = null;
        this.dnz = new ArrayList<>();
        this.dlZ = null;
        this.dmd = null;
        this.dnI = new ArrayList<>();
        this.dnJ = new ArrayList<>();
        this.dnc = writeVoteActivity;
        initView();
        initListener();
        aCJ();
        gt(this.mCurrentTab);
    }

    private void initView() {
        this.dnc.setContentView(i.g.write_vote_activity);
        this.cxa = (RelativeLayout) this.dnc.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.dnc.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dnc.getPageContext().getString(i.h.write_vote_titlebar));
        this.dme = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.send_post));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dme.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dme.setLayoutParams(layoutParams);
        this.dme.setEnabled(false);
        this.dlZ = (EditText) this.dnc.findViewById(i.f.post_title);
        this.dmd = (EditText) this.dnc.findViewById(i.f.post_content);
        this.dnA = (RadioGroup) this.dnc.findViewById(i.f.raidos_tabs_vote);
        this.dnB = (RadioButton) this.dnc.findViewById(i.f.radio_vote_pic);
        this.dnC = (RadioButton) this.dnc.findViewById(i.f.radio_vote_text);
        this.dnD = (TextView) this.dnc.findViewById(i.f.endtime_day);
        this.dnE = new c(this.dnc);
        this.dnF = (LinearLayout) this.dnc.findViewById(i.f.vote_container);
        this.dnG = this.dnc.findViewById(i.f.vote_add_layout);
        this.dnH = (BdSwitchView) this.dnc.findViewById(i.f.multiple_switch);
        this.dnH.mC();
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.dnc != null) {
            this.dnx = this.dnc.findViewById(i.f.post_prefix_layout);
            this.dmf = (TextView) this.dnc.findViewById(i.f.post_prefix);
            this.dny = this.dnc.findViewById(i.f.prefix_divider);
            this.dmh = (ImageView) this.dnc.findViewById(i.f.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.dnx.setVisibility(0);
                this.dny.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.dnx.setOnClickListener(this.dnc);
                this.dmh = (ImageView) this.dnc.findViewById(i.f.prefix_icon);
                if (size > 1) {
                    this.dmh.setVisibility(0);
                    this.dmf.setOnClickListener(this.dnc);
                }
                this.dmg = new cd(this.dnc.getPageContext().getPageActivity());
                this.dmg.a(this.dnc);
                this.dmg.setMaxHeight(com.baidu.adp.lib.util.k.d(this.dnc.getActivity(), i.d.ds510));
                this.dmg.setOutsideTouchable(true);
                this.dmg.setFocusable(true);
                this.dmg.setOnDismissListener(this.dnc);
                this.dmg.setBackgroundDrawable(am.getDrawable(i.c.cp_bg_line_d));
                int color = am.getColor(i.c.write_text);
                int color2 = am.getColor(i.c.cp_cont_c);
                am.i((View) this.dmf, i.c.cp_bg_line_d);
                am.c(this.dmh, i.e.icon_title_down);
                this.dmf.setTextColor(color);
                this.dnz.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.view.g gVar = new com.baidu.tieba.write.view.g(this.dnc.getActivity());
                    this.dnz.add(gVar);
                    gVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        gVar.setPrefixTextColor(color2);
                    } else {
                        gVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        gVar.setDividerStyle(false);
                    }
                    this.dmg.addView(gVar);
                }
                this.dmg.lJ(0);
                this.dmf.setText(prefixs.get(1));
                me(1);
                return;
            }
            this.dnx.setVisibility(8);
        }
    }

    private void aCJ() {
        this.dnI.add(new g(this.dnc, 0));
        this.dnI.add(new g(this.dnc, 0));
        this.dnJ.add(new g(this.dnc, 1));
        this.dnJ.add(new g(this.dnc, 1));
    }

    private void initListener() {
        this.dnD.setOnClickListener(this.dnc);
        this.dnG.setOnClickListener(this.dnc);
        this.dme.setOnClickListener(this.dnc);
        this.dnH.setOnSwitchStateChangeListener(this.dnc);
        this.dnE.a(this.dnc);
        this.dnA.setOnCheckedChangeListener(this.dnc);
        this.dlZ.addTextChangedListener(new a(31, this.dlZ));
        this.dmd.addTextChangedListener(new a(50, this.dmd));
    }

    public void gt(int i) {
        this.mCurrentTab = i;
        aCL();
        if (this.mCurrentTab == 0) {
            aj(this.dnI);
        } else if (this.mCurrentTab == 1) {
            aj(this.dnJ);
        }
    }

    private void aCK() {
        if (this.mCurrentTab == 0) {
            if (this.dnI.size() >= 10) {
                this.dnG.setVisibility(8);
            } else {
                this.dnG.setVisibility(0);
            }
        } else if (this.mCurrentTab == 1) {
            if (this.dnJ.size() >= 20) {
                this.dnG.setVisibility(8);
            } else {
                this.dnG.setVisibility(0);
            }
        }
    }

    private void aj(ArrayList<g> arrayList) {
        if (arrayList != null) {
            this.dnF.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && gVar.getView() != null) {
                        this.dnF.addView(gVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    aCK();
                    return;
                }
            }
        }
    }

    private void aCL() {
        if (this.dnB != null && this.dnC != null) {
            if (this.mCurrentTab == 0) {
                am.b(this.dnB, i.c.cp_link_tip_c, 3);
                am.b(this.dnC, i.c.cp_cont_f, 3);
            } else if (this.mCurrentTab == 1) {
                am.b(this.dnC, i.c.cp_link_tip_c, 3);
                am.b(this.dnB, i.c.cp_cont_f, 3);
            }
        }
    }

    public g mc(int i) {
        g gVar = null;
        if (i == 0) {
            gVar = new g(this.dnc, 0);
            this.dnI.add(gVar);
            this.dnF.addView(gVar.getView());
        } else if (i == 1) {
            gVar = new g(this.dnc, 1);
            this.dnJ.add(gVar);
            this.dnF.addView(gVar.getView());
        }
        aCK();
        return gVar;
    }

    public g b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g bK = bK(this.dnI);
        if (bK != null) {
            bK.a(imageFileInfo, aVar);
        } else {
            c(imageFileInfo, aVar);
        }
        return bK;
    }

    private g c(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        g gVar = new g(this.dnc, 0);
        gVar.a(imageFileInfo, aVar);
        this.dnI.add(gVar);
        this.dnF.addView(gVar.getView());
        aCK();
        return gVar;
    }

    public void md(int i) {
        if (this.mCurrentTab == 0) {
            g h = h(this.dnI, i);
            if (h != null && h.getView() != null) {
                this.dnI.remove(h);
                this.dnF.removeView(h.getView());
            } else {
                return;
            }
        } else if (this.mCurrentTab == 1) {
            g h2 = h(this.dnJ, i);
            if (h2 != null && h2.getView() != null) {
                this.dnJ.remove(h2);
                this.dnF.removeView(h2.getView());
            } else {
                return;
            }
        }
        aCK();
    }

    private g bK(List<g> list) {
        if (list == null) {
            return null;
        }
        for (g gVar : list) {
            if (!gVar.aCq()) {
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

    public void mq(String str) {
        if (this.dnD != null) {
            this.dnD.setText(str);
        }
    }

    public void gY(boolean z) {
        if (this.dme != null) {
            this.dme.setEnabled(z);
        }
    }

    private void me(int i) {
        if (i >= 0 && i < this.dnz.size()) {
            for (int i2 = 0; i2 < this.dnz.size(); i2++) {
                this.dnz.get(i2).gX(false);
            }
            this.dnz.get(i).gX(true);
        }
    }

    public void P(int i, String str) {
        if (this.dmf != null && this.dmg != null && this.dnc != null) {
            this.dmg.lJ(i);
            me(i);
            this.dmf.setText(str);
            gY(true);
            com.baidu.adp.lib.g.j.a(this.dmg, this.dnc.getPageContext().getPageActivity());
        }
    }

    public void gZ(boolean z) {
        if (this.dnx != null) {
            this.dnx.setSelected(z);
        }
    }

    public void aA(View view) {
        if (view != null && this.dmf != null && this.dnx != null && this.dmg != null) {
            this.dmf.setVisibility(0);
            this.dnx.setSelected(true);
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.dmg, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dnc.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void dF(int i) {
        if (this.cxa != null) {
            this.dnc.getLayoutMode().ad(i == 1);
            this.dnc.getLayoutMode().k(this.cxa);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.i((View) this.dme, i.e.s_navbar_button_bg);
        aCL();
    }
}
