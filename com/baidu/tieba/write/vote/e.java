package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<WriteVoteActivity> {
    private int dRM;
    private EditText gQs;
    private EditText gQw;
    private TextView gQx;
    private com.baidu.tieba.write.e gQy;
    private ImageView gQz;
    private WriteVoteActivity hIG;
    private View hIZ;
    private View hJa;
    private View hJb;
    private ArrayList<com.baidu.tieba.write.d> hJc;
    private RadioGroup hJd;
    private RadioButton hJe;
    private RadioButton hJf;
    private TextView hJg;
    private c hJh;
    private LinearLayout hJi;
    private View hJj;
    private RelativeLayout hJk;
    private BdSwitchView hJl;
    private final ArrayList<d> hJm;
    private final ArrayList<d> hJn;
    private NavigationBar mNavigationBar;
    private TextView mPost;

    public View bHH() {
        return this.hJa;
    }

    public TextView bHI() {
        return this.gQx;
    }

    public View bHJ() {
        return this.mPost;
    }

    public EditText bHK() {
        return this.gQs;
    }

    public EditText bHL() {
        return this.gQw;
    }

    public BdSwitchView bHM() {
        return this.hJl;
    }

    public View bHN() {
        return this.hJk;
    }

    public c bHO() {
        return this.hJh;
    }

    public TextView bHP() {
        return this.hJg;
    }

    public View bHQ() {
        return this.hJj;
    }

    public ArrayList<d> bHR() {
        return this.hJm;
    }

    public ArrayList<d> bHS() {
        return this.hJn;
    }

    public e(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.dRM = 0;
        this.mNavigationBar = null;
        this.mPost = null;
        this.hJc = new ArrayList<>();
        this.gQs = null;
        this.gQw = null;
        this.hJm = new ArrayList<>();
        this.hJn = new ArrayList<>();
        this.hIG = writeVoteActivity;
        initView();
        initListener();
    }

    private void initView() {
        this.hIG.setContentView(d.h.write_vote_activity);
        this.hIZ = (RelativeLayout) this.hIG.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.hIG.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hIG.getPageContext().getString(d.j.write_vote_titlebar));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        aj.r(this.mPost, d.C0141d.navbar_btn_color);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setEnabled(false);
        this.gQs = (EditText) this.hIG.findViewById(d.g.post_title);
        this.gQw = (EditText) this.hIG.findViewById(d.g.post_content);
        this.hJd = (RadioGroup) this.hIG.findViewById(d.g.raidos_tabs_vote);
        this.hJe = (RadioButton) this.hIG.findViewById(d.g.radio_vote_pic);
        this.hJf = (RadioButton) this.hIG.findViewById(d.g.radio_vote_text);
        this.hJg = (TextView) this.hIG.findViewById(d.g.endtime_day);
        this.hJh = new c(this.hIG);
        this.hJi = (LinearLayout) this.hIG.findViewById(d.g.vote_container);
        this.hJj = this.hIG.findViewById(d.g.vote_add_layout);
        this.hJk = (RelativeLayout) this.hIG.findViewById(d.g.multiple_switch_layout);
        this.hJl = (BdSwitchView) this.hIG.findViewById(d.g.multiple_switch);
        this.hJl.rK();
        this.hJk.setContentDescription(this.hIG.getResources().getString(d.j.vote_multiple) + this.hIG.getResources().getString(d.j.now_state_off));
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.hIG != null) {
            this.hJa = this.hIG.findViewById(d.g.post_prefix_layout);
            this.gQx = (TextView) this.hIG.findViewById(d.g.post_prefix);
            this.hJb = this.hIG.findViewById(d.g.prefix_divider);
            this.gQz = (ImageView) this.hIG.findViewById(d.g.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.hJa.setVisibility(0);
                this.hJb.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.hJa.setOnClickListener(this.hIG);
                this.gQz = (ImageView) this.hIG.findViewById(d.g.prefix_icon);
                if (size > 1) {
                    this.gQz.setVisibility(0);
                    this.gQx.setOnClickListener(this.hIG);
                }
                this.gQy = new com.baidu.tieba.write.e(this.hIG.getPageContext().getPageActivity());
                this.gQy.a(this.hIG);
                this.gQy.setMaxHeight(l.t(this.hIG.getActivity(), d.e.ds510));
                this.gQy.setOutsideTouchable(true);
                this.gQy.setFocusable(true);
                this.gQy.setOnDismissListener(this.hIG);
                this.gQy.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_d));
                int color = aj.getColor(d.C0141d.common_color_10097);
                int color2 = aj.getColor(d.C0141d.cp_cont_c);
                aj.s(this.gQx, d.C0141d.cp_bg_line_d);
                aj.c(this.gQz, d.f.icon_title_down);
                this.gQx.setTextColor(color);
                this.hJc.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(this.hIG.getActivity());
                    this.hJc.add(dVar);
                    dVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        dVar.setPrefixTextColor(color2);
                    } else {
                        dVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        dVar.setDividerStyle(false);
                    }
                    this.gQy.addView(dVar);
                }
                this.gQy.setCurrentIndex(0);
                this.gQx.setText(prefixs.get(1));
                xI(1);
                return;
            }
            this.hJa.setVisibility(8);
        }
    }

    public void bHT() {
        this.hJm.add(new d(this.hIG, 0));
        this.hJm.add(new d(this.hIG, 0));
        this.hJn.add(new d(this.hIG, 1));
        this.hJn.add(new d(this.hIG, 1));
    }

    public void bHU() {
        if (v.D(this.hJn) == 0) {
            this.hJn.add(new d(this.hIG, 1));
            this.hJn.add(new d(this.hIG, 1));
        }
    }

    private void initListener() {
        this.hJg.setOnClickListener(this.hIG);
        this.hJj.setOnClickListener(this.hIG);
        this.mPost.setOnClickListener(this.hIG);
        this.hJk.setOnClickListener(this.hIG);
        this.hJl.setOnSwitchStateChangeListener(this.hIG);
        this.hJh.a(this.hIG);
        this.hJd.setOnCheckedChangeListener(this.hIG);
        this.gQs.addTextChangedListener(new a(31, this.gQs));
        this.gQw.addTextChangedListener(new a(50, this.gQw));
    }

    public void rZ(int i) {
        this.dRM = i;
        bHW();
        if (this.dRM == 0) {
            ay(this.hJm);
        } else if (this.dRM == 1) {
            ay(this.hJn);
        }
    }

    private void bHV() {
        if (this.dRM == 0) {
            if (this.hJm.size() >= 10) {
                this.hJj.setVisibility(8);
            } else {
                this.hJj.setVisibility(0);
            }
        } else if (this.dRM == 1) {
            if (this.hJn.size() >= 20) {
                this.hJj.setVisibility(8);
            } else {
                this.hJj.setVisibility(0);
            }
        }
    }

    private void ay(ArrayList<d> arrayList) {
        if (arrayList != null) {
            this.hJi.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    d dVar = arrayList.get(i2);
                    if (dVar != null && dVar.getView() != null) {
                        this.hJi.addView(dVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    bHV();
                    return;
                }
            }
        }
    }

    private void bHW() {
        if (this.hJe != null && this.hJf != null) {
            if (this.dRM == 0) {
                aj.e(this.hJe, d.C0141d.cp_link_tip_c, 3);
                aj.e(this.hJf, d.C0141d.cp_cont_f, 3);
            } else if (this.dRM == 1) {
                aj.e(this.hJf, d.C0141d.cp_link_tip_c, 3);
                aj.e(this.hJe, d.C0141d.cp_cont_f, 3);
            }
        }
    }

    public d xG(int i) {
        d dVar = null;
        if (i == 0) {
            dVar = new d(this.hIG, 0);
            this.hJm.add(dVar);
            this.hJi.addView(dVar.getView());
        } else if (i == 1) {
            dVar = new d(this.hIG, 1);
            this.hJn.add(dVar);
            this.hJi.addView(dVar.getView());
        }
        bHV();
        return dVar;
    }

    public d b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        d dW = dW(this.hJm);
        if (dW != null) {
            dW.a(imageFileInfo, aVar);
        } else {
            a(imageFileInfo, aVar, "");
        }
        return dW;
    }

    public d uF(String str) {
        d dVar = new d(this.hIG, 1);
        dVar.setEditText(str);
        this.hJn.add(dVar);
        this.hJi.addView(dVar.getView());
        return dVar;
    }

    public d a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar, String str) {
        d dVar = new d(this.hIG, 0);
        dVar.a(imageFileInfo, aVar);
        dVar.setEditText(str);
        this.hJm.add(dVar);
        this.hJi.addView(dVar.getView());
        bHV();
        return dVar;
    }

    public void xH(int i) {
        if (this.dRM == 0) {
            d u = u(this.hJm, i);
            if (u != null && u.getView() != null) {
                this.hJm.remove(u);
                this.hJi.removeView(u.getView());
            } else {
                return;
            }
        } else if (this.dRM == 1) {
            d u2 = u(this.hJn, i);
            if (u2 != null && u2.getView() != null) {
                this.hJn.remove(u2);
                this.hJi.removeView(u2.getView());
            } else {
                return;
            }
        }
        bHV();
    }

    private d dW(List<d> list) {
        if (list == null) {
            return null;
        }
        for (d dVar : list) {
            if (!dVar.bHy()) {
                return dVar;
            }
        }
        return null;
    }

    private d u(List<d> list, int i) {
        if (list == null) {
            return null;
        }
        for (d dVar : list) {
            if (i == dVar.getId()) {
                return dVar;
            }
        }
        return null;
    }

    public void uG(String str) {
        if (this.hJg != null) {
            this.hJg.setText(str);
            this.hJg.setContentDescription(str + getPageContext().getString(d.j.selected));
        }
    }

    public void nL(boolean z) {
        if (this.mPost != null) {
            this.mPost.setEnabled(z);
        }
    }

    private void xI(int i) {
        if (i >= 0 && i < this.hJc.size()) {
            for (int i2 = 0; i2 < this.hJc.size(); i2++) {
                this.hJc.get(i2).nD(false);
            }
            this.hJc.get(i).nD(true);
        }
    }

    public void ao(int i, String str) {
        if (this.gQx != null && this.gQy != null && this.hIG != null) {
            this.gQy.setCurrentIndex(i);
            xI(i);
            this.gQx.setText(str);
            nL(true);
            g.a(this.gQy, this.hIG.getPageContext().getPageActivity());
        }
    }

    public void nM(boolean z) {
        if (this.hJa != null) {
            this.hJa.setSelected(z);
        }
    }

    public void cW(View view) {
        if (view != null && this.gQx != null && this.hJa != null && this.gQy != null) {
            this.gQx.setVisibility(0);
            this.hJa.setSelected(true);
            g.showPopupWindowAsDropDown(this.gQy, view, 0, l.dip2px(this.hIG.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void hr(int i) {
        if (this.hIZ != null) {
            this.hIG.getLayoutMode().aQ(i == 1);
            this.hIG.getLayoutMode().aM(this.hIZ);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        aj.s(this.mPost, d.f.s_navbar_button_bg);
        bHW();
    }
}
