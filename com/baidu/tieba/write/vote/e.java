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
    private int dRR;
    private EditText gQI;
    private EditText gQM;
    private TextView gQN;
    private com.baidu.tieba.write.e gQO;
    private ImageView gQP;
    private ArrayList<com.baidu.tieba.write.d> hJA;
    private RadioGroup hJB;
    private RadioButton hJC;
    private RadioButton hJD;
    private TextView hJE;
    private c hJF;
    private LinearLayout hJG;
    private View hJH;
    private RelativeLayout hJI;
    private BdSwitchView hJJ;
    private final ArrayList<d> hJK;
    private final ArrayList<d> hJL;
    private WriteVoteActivity hJe;
    private View hJx;
    private View hJy;
    private View hJz;
    private NavigationBar mNavigationBar;
    private TextView mPost;

    public View bHM() {
        return this.hJy;
    }

    public TextView bHN() {
        return this.gQN;
    }

    public View bHO() {
        return this.mPost;
    }

    public EditText bHP() {
        return this.gQI;
    }

    public EditText bHQ() {
        return this.gQM;
    }

    public BdSwitchView bHR() {
        return this.hJJ;
    }

    public View bHS() {
        return this.hJI;
    }

    public c bHT() {
        return this.hJF;
    }

    public TextView bHU() {
        return this.hJE;
    }

    public View bHV() {
        return this.hJH;
    }

    public ArrayList<d> bHW() {
        return this.hJK;
    }

    public ArrayList<d> bHX() {
        return this.hJL;
    }

    public e(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.dRR = 0;
        this.mNavigationBar = null;
        this.mPost = null;
        this.hJA = new ArrayList<>();
        this.gQI = null;
        this.gQM = null;
        this.hJK = new ArrayList<>();
        this.hJL = new ArrayList<>();
        this.hJe = writeVoteActivity;
        initView();
        initListener();
    }

    private void initView() {
        this.hJe.setContentView(d.h.write_vote_activity);
        this.hJx = (RelativeLayout) this.hJe.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.hJe.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hJe.getPageContext().getString(d.j.write_vote_titlebar));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        aj.r(this.mPost, d.C0141d.navbar_btn_color);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setEnabled(false);
        this.gQI = (EditText) this.hJe.findViewById(d.g.post_title);
        this.gQM = (EditText) this.hJe.findViewById(d.g.post_content);
        this.hJB = (RadioGroup) this.hJe.findViewById(d.g.raidos_tabs_vote);
        this.hJC = (RadioButton) this.hJe.findViewById(d.g.radio_vote_pic);
        this.hJD = (RadioButton) this.hJe.findViewById(d.g.radio_vote_text);
        this.hJE = (TextView) this.hJe.findViewById(d.g.endtime_day);
        this.hJF = new c(this.hJe);
        this.hJG = (LinearLayout) this.hJe.findViewById(d.g.vote_container);
        this.hJH = this.hJe.findViewById(d.g.vote_add_layout);
        this.hJI = (RelativeLayout) this.hJe.findViewById(d.g.multiple_switch_layout);
        this.hJJ = (BdSwitchView) this.hJe.findViewById(d.g.multiple_switch);
        this.hJJ.rK();
        this.hJI.setContentDescription(this.hJe.getResources().getString(d.j.vote_multiple) + this.hJe.getResources().getString(d.j.now_state_off));
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.hJe != null) {
            this.hJy = this.hJe.findViewById(d.g.post_prefix_layout);
            this.gQN = (TextView) this.hJe.findViewById(d.g.post_prefix);
            this.hJz = this.hJe.findViewById(d.g.prefix_divider);
            this.gQP = (ImageView) this.hJe.findViewById(d.g.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.hJy.setVisibility(0);
                this.hJz.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.hJy.setOnClickListener(this.hJe);
                this.gQP = (ImageView) this.hJe.findViewById(d.g.prefix_icon);
                if (size > 1) {
                    this.gQP.setVisibility(0);
                    this.gQN.setOnClickListener(this.hJe);
                }
                this.gQO = new com.baidu.tieba.write.e(this.hJe.getPageContext().getPageActivity());
                this.gQO.a(this.hJe);
                this.gQO.setMaxHeight(l.t(this.hJe.getActivity(), d.e.ds510));
                this.gQO.setOutsideTouchable(true);
                this.gQO.setFocusable(true);
                this.gQO.setOnDismissListener(this.hJe);
                this.gQO.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_d));
                int color = aj.getColor(d.C0141d.common_color_10097);
                int color2 = aj.getColor(d.C0141d.cp_cont_c);
                aj.s(this.gQN, d.C0141d.cp_bg_line_d);
                aj.c(this.gQP, d.f.icon_title_down);
                this.gQN.setTextColor(color);
                this.hJA.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(this.hJe.getActivity());
                    this.hJA.add(dVar);
                    dVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        dVar.setPrefixTextColor(color2);
                    } else {
                        dVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        dVar.setDividerStyle(false);
                    }
                    this.gQO.addView(dVar);
                }
                this.gQO.setCurrentIndex(0);
                this.gQN.setText(prefixs.get(1));
                xI(1);
                return;
            }
            this.hJy.setVisibility(8);
        }
    }

    public void bHY() {
        this.hJK.add(new d(this.hJe, 0));
        this.hJK.add(new d(this.hJe, 0));
        this.hJL.add(new d(this.hJe, 1));
        this.hJL.add(new d(this.hJe, 1));
    }

    public void bHZ() {
        if (v.D(this.hJL) == 0) {
            this.hJL.add(new d(this.hJe, 1));
            this.hJL.add(new d(this.hJe, 1));
        }
    }

    private void initListener() {
        this.hJE.setOnClickListener(this.hJe);
        this.hJH.setOnClickListener(this.hJe);
        this.mPost.setOnClickListener(this.hJe);
        this.hJI.setOnClickListener(this.hJe);
        this.hJJ.setOnSwitchStateChangeListener(this.hJe);
        this.hJF.a(this.hJe);
        this.hJB.setOnCheckedChangeListener(this.hJe);
        this.gQI.addTextChangedListener(new a(31, this.gQI));
        this.gQM.addTextChangedListener(new a(50, this.gQM));
    }

    public void rZ(int i) {
        this.dRR = i;
        bIb();
        if (this.dRR == 0) {
            ay(this.hJK);
        } else if (this.dRR == 1) {
            ay(this.hJL);
        }
    }

    private void bIa() {
        if (this.dRR == 0) {
            if (this.hJK.size() >= 10) {
                this.hJH.setVisibility(8);
            } else {
                this.hJH.setVisibility(0);
            }
        } else if (this.dRR == 1) {
            if (this.hJL.size() >= 20) {
                this.hJH.setVisibility(8);
            } else {
                this.hJH.setVisibility(0);
            }
        }
    }

    private void ay(ArrayList<d> arrayList) {
        if (arrayList != null) {
            this.hJG.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    d dVar = arrayList.get(i2);
                    if (dVar != null && dVar.getView() != null) {
                        this.hJG.addView(dVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    bIa();
                    return;
                }
            }
        }
    }

    private void bIb() {
        if (this.hJC != null && this.hJD != null) {
            if (this.dRR == 0) {
                aj.e(this.hJC, d.C0141d.cp_link_tip_c, 3);
                aj.e(this.hJD, d.C0141d.cp_cont_f, 3);
            } else if (this.dRR == 1) {
                aj.e(this.hJD, d.C0141d.cp_link_tip_c, 3);
                aj.e(this.hJC, d.C0141d.cp_cont_f, 3);
            }
        }
    }

    public d xG(int i) {
        d dVar = null;
        if (i == 0) {
            dVar = new d(this.hJe, 0);
            this.hJK.add(dVar);
            this.hJG.addView(dVar.getView());
        } else if (i == 1) {
            dVar = new d(this.hJe, 1);
            this.hJL.add(dVar);
            this.hJG.addView(dVar.getView());
        }
        bIa();
        return dVar;
    }

    public d b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        d dW = dW(this.hJK);
        if (dW != null) {
            dW.a(imageFileInfo, aVar);
        } else {
            a(imageFileInfo, aVar, "");
        }
        return dW;
    }

    public d uF(String str) {
        d dVar = new d(this.hJe, 1);
        dVar.setEditText(str);
        this.hJL.add(dVar);
        this.hJG.addView(dVar.getView());
        return dVar;
    }

    public d a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar, String str) {
        d dVar = new d(this.hJe, 0);
        dVar.a(imageFileInfo, aVar);
        dVar.setEditText(str);
        this.hJK.add(dVar);
        this.hJG.addView(dVar.getView());
        bIa();
        return dVar;
    }

    public void xH(int i) {
        if (this.dRR == 0) {
            d u = u(this.hJK, i);
            if (u != null && u.getView() != null) {
                this.hJK.remove(u);
                this.hJG.removeView(u.getView());
            } else {
                return;
            }
        } else if (this.dRR == 1) {
            d u2 = u(this.hJL, i);
            if (u2 != null && u2.getView() != null) {
                this.hJL.remove(u2);
                this.hJG.removeView(u2.getView());
            } else {
                return;
            }
        }
        bIa();
    }

    private d dW(List<d> list) {
        if (list == null) {
            return null;
        }
        for (d dVar : list) {
            if (!dVar.bHD()) {
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
        if (this.hJE != null) {
            this.hJE.setText(str);
            this.hJE.setContentDescription(str + getPageContext().getString(d.j.selected));
        }
    }

    public void nQ(boolean z) {
        if (this.mPost != null) {
            this.mPost.setEnabled(z);
        }
    }

    private void xI(int i) {
        if (i >= 0 && i < this.hJA.size()) {
            for (int i2 = 0; i2 < this.hJA.size(); i2++) {
                this.hJA.get(i2).nI(false);
            }
            this.hJA.get(i).nI(true);
        }
    }

    public void ao(int i, String str) {
        if (this.gQN != null && this.gQO != null && this.hJe != null) {
            this.gQO.setCurrentIndex(i);
            xI(i);
            this.gQN.setText(str);
            nQ(true);
            g.a(this.gQO, this.hJe.getPageContext().getPageActivity());
        }
    }

    public void nR(boolean z) {
        if (this.hJy != null) {
            this.hJy.setSelected(z);
        }
    }

    public void cW(View view) {
        if (view != null && this.gQN != null && this.hJy != null && this.gQO != null) {
            this.gQN.setVisibility(0);
            this.hJy.setSelected(true);
            g.showPopupWindowAsDropDown(this.gQO, view, 0, l.dip2px(this.hJe.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void hr(int i) {
        if (this.hJx != null) {
            this.hJe.getLayoutMode().aQ(i == 1);
            this.hJe.getLayoutMode().aM(this.hJx);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        aj.s(this.mPost, d.f.s_navbar_button_bg);
        bIb();
    }
}
