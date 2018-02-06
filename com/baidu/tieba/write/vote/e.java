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
    private int dRY;
    private EditText gQH;
    private EditText gQL;
    private TextView gQM;
    private com.baidu.tieba.write.e gQN;
    private ImageView gQO;
    private WriteVoteActivity hIT;
    private final ArrayList<d> hJA;
    private View hJm;
    private View hJn;
    private View hJo;
    private ArrayList<com.baidu.tieba.write.d> hJp;
    private RadioGroup hJq;
    private RadioButton hJr;
    private RadioButton hJs;
    private TextView hJt;
    private c hJu;
    private LinearLayout hJv;
    private View hJw;
    private RelativeLayout hJx;
    private BdSwitchView hJy;
    private final ArrayList<d> hJz;
    private NavigationBar mNavigationBar;
    private TextView mPost;

    public View bHI() {
        return this.hJn;
    }

    public TextView bHJ() {
        return this.gQM;
    }

    public View bHK() {
        return this.mPost;
    }

    public EditText bHL() {
        return this.gQH;
    }

    public EditText bHM() {
        return this.gQL;
    }

    public BdSwitchView bHN() {
        return this.hJy;
    }

    public View bHO() {
        return this.hJx;
    }

    public c bHP() {
        return this.hJu;
    }

    public TextView bHQ() {
        return this.hJt;
    }

    public View bHR() {
        return this.hJw;
    }

    public ArrayList<d> bHS() {
        return this.hJz;
    }

    public ArrayList<d> bHT() {
        return this.hJA;
    }

    public e(WriteVoteActivity writeVoteActivity) {
        super(writeVoteActivity.getPageContext());
        this.dRY = 0;
        this.mNavigationBar = null;
        this.mPost = null;
        this.hJp = new ArrayList<>();
        this.gQH = null;
        this.gQL = null;
        this.hJz = new ArrayList<>();
        this.hJA = new ArrayList<>();
        this.hIT = writeVoteActivity;
        initView();
        initListener();
    }

    private void initView() {
        this.hIT.setContentView(d.h.write_vote_activity);
        this.hJm = (RelativeLayout) this.hIT.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.hIT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hIT.getPageContext().getString(d.j.write_vote_titlebar));
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        aj.r(this.mPost, d.C0140d.navbar_btn_color);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setEnabled(false);
        this.gQH = (EditText) this.hIT.findViewById(d.g.post_title);
        this.gQL = (EditText) this.hIT.findViewById(d.g.post_content);
        this.hJq = (RadioGroup) this.hIT.findViewById(d.g.raidos_tabs_vote);
        this.hJr = (RadioButton) this.hIT.findViewById(d.g.radio_vote_pic);
        this.hJs = (RadioButton) this.hIT.findViewById(d.g.radio_vote_text);
        this.hJt = (TextView) this.hIT.findViewById(d.g.endtime_day);
        this.hJu = new c(this.hIT);
        this.hJv = (LinearLayout) this.hIT.findViewById(d.g.vote_container);
        this.hJw = this.hIT.findViewById(d.g.vote_add_layout);
        this.hJx = (RelativeLayout) this.hIT.findViewById(d.g.multiple_switch_layout);
        this.hJy = (BdSwitchView) this.hIT.findViewById(d.g.multiple_switch);
        this.hJy.rK();
        this.hJx.setContentDescription(this.hIT.getResources().getString(d.j.vote_multiple) + this.hIT.getResources().getString(d.j.now_state_off));
    }

    public void b(PostPrefixData postPrefixData) {
        if (postPrefixData != null && this.hIT != null) {
            this.hJn = this.hIT.findViewById(d.g.post_prefix_layout);
            this.gQM = (TextView) this.hIT.findViewById(d.g.post_prefix);
            this.hJo = this.hIT.findViewById(d.g.prefix_divider);
            this.gQO = (ImageView) this.hIT.findViewById(d.g.prefix_icon);
            if (postPrefixData != null && postPrefixData.getPrefixs() != null && postPrefixData.getPrefixs().size() > 1) {
                this.hJn.setVisibility(0);
                this.hJo.setVisibility(0);
                ArrayList<String> prefixs = postPrefixData.getPrefixs();
                int size = prefixs.size();
                this.hJn.setOnClickListener(this.hIT);
                this.gQO = (ImageView) this.hIT.findViewById(d.g.prefix_icon);
                if (size > 1) {
                    this.gQO.setVisibility(0);
                    this.gQM.setOnClickListener(this.hIT);
                }
                this.gQN = new com.baidu.tieba.write.e(this.hIT.getPageContext().getPageActivity());
                this.gQN.a(this.hIT);
                this.gQN.setMaxHeight(l.t(this.hIT.getActivity(), d.e.ds510));
                this.gQN.setOutsideTouchable(true);
                this.gQN.setFocusable(true);
                this.gQN.setOnDismissListener(this.hIT);
                this.gQN.setBackgroundDrawable(aj.getDrawable(d.C0140d.cp_bg_line_d));
                int color = aj.getColor(d.C0140d.common_color_10097);
                int color2 = aj.getColor(d.C0140d.cp_cont_c);
                aj.s(this.gQM, d.C0140d.cp_bg_line_d);
                aj.c(this.gQO, d.f.icon_title_down);
                this.gQM.setTextColor(color);
                this.hJp.clear();
                for (int i = 0; i < size; i++) {
                    com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(this.hIT.getActivity());
                    this.hJp.add(dVar);
                    dVar.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        dVar.setPrefixTextColor(color2);
                    } else {
                        dVar.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        dVar.setDividerStyle(false);
                    }
                    this.gQN.addView(dVar);
                }
                this.gQN.setCurrentIndex(0);
                this.gQM.setText(prefixs.get(1));
                xH(1);
                return;
            }
            this.hJn.setVisibility(8);
        }
    }

    public void bHU() {
        this.hJz.add(new d(this.hIT, 0));
        this.hJz.add(new d(this.hIT, 0));
        this.hJA.add(new d(this.hIT, 1));
        this.hJA.add(new d(this.hIT, 1));
    }

    public void bHV() {
        if (v.D(this.hJA) == 0) {
            this.hJA.add(new d(this.hIT, 1));
            this.hJA.add(new d(this.hIT, 1));
        }
    }

    private void initListener() {
        this.hJt.setOnClickListener(this.hIT);
        this.hJw.setOnClickListener(this.hIT);
        this.mPost.setOnClickListener(this.hIT);
        this.hJx.setOnClickListener(this.hIT);
        this.hJy.setOnSwitchStateChangeListener(this.hIT);
        this.hJu.a(this.hIT);
        this.hJq.setOnCheckedChangeListener(this.hIT);
        this.gQH.addTextChangedListener(new a(31, this.gQH));
        this.gQL.addTextChangedListener(new a(50, this.gQL));
    }

    public void rY(int i) {
        this.dRY = i;
        bHX();
        if (this.dRY == 0) {
            ay(this.hJz);
        } else if (this.dRY == 1) {
            ay(this.hJA);
        }
    }

    private void bHW() {
        if (this.dRY == 0) {
            if (this.hJz.size() >= 10) {
                this.hJw.setVisibility(8);
            } else {
                this.hJw.setVisibility(0);
            }
        } else if (this.dRY == 1) {
            if (this.hJA.size() >= 20) {
                this.hJw.setVisibility(8);
            } else {
                this.hJw.setVisibility(0);
            }
        }
    }

    private void ay(ArrayList<d> arrayList) {
        if (arrayList != null) {
            this.hJv.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    d dVar = arrayList.get(i2);
                    if (dVar != null && dVar.getView() != null) {
                        this.hJv.addView(dVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    bHW();
                    return;
                }
            }
        }
    }

    private void bHX() {
        if (this.hJr != null && this.hJs != null) {
            if (this.dRY == 0) {
                aj.e(this.hJr, d.C0140d.cp_link_tip_c, 3);
                aj.e(this.hJs, d.C0140d.cp_cont_f, 3);
            } else if (this.dRY == 1) {
                aj.e(this.hJs, d.C0140d.cp_link_tip_c, 3);
                aj.e(this.hJr, d.C0140d.cp_cont_f, 3);
            }
        }
    }

    public d xF(int i) {
        d dVar = null;
        if (i == 0) {
            dVar = new d(this.hIT, 0);
            this.hJz.add(dVar);
            this.hJv.addView(dVar.getView());
        } else if (i == 1) {
            dVar = new d(this.hIT, 1);
            this.hJA.add(dVar);
            this.hJv.addView(dVar.getView());
        }
        bHW();
        return dVar;
    }

    public d b(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar) {
        d dW = dW(this.hJz);
        if (dW != null) {
            dW.a(imageFileInfo, aVar);
        } else {
            a(imageFileInfo, aVar, "");
        }
        return dW;
    }

    public d uF(String str) {
        d dVar = new d(this.hIT, 1);
        dVar.setEditText(str);
        this.hJA.add(dVar);
        this.hJv.addView(dVar.getView());
        return dVar;
    }

    public d a(ImageFileInfo imageFileInfo, com.baidu.adp.widget.a.a aVar, String str) {
        d dVar = new d(this.hIT, 0);
        dVar.a(imageFileInfo, aVar);
        dVar.setEditText(str);
        this.hJz.add(dVar);
        this.hJv.addView(dVar.getView());
        bHW();
        return dVar;
    }

    public void xG(int i) {
        if (this.dRY == 0) {
            d u = u(this.hJz, i);
            if (u != null && u.getView() != null) {
                this.hJz.remove(u);
                this.hJv.removeView(u.getView());
            } else {
                return;
            }
        } else if (this.dRY == 1) {
            d u2 = u(this.hJA, i);
            if (u2 != null && u2.getView() != null) {
                this.hJA.remove(u2);
                this.hJv.removeView(u2.getView());
            } else {
                return;
            }
        }
        bHW();
    }

    private d dW(List<d> list) {
        if (list == null) {
            return null;
        }
        for (d dVar : list) {
            if (!dVar.bHz()) {
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
        if (this.hJt != null) {
            this.hJt.setText(str);
            this.hJt.setContentDescription(str + getPageContext().getString(d.j.selected));
        }
    }

    public void nL(boolean z) {
        if (this.mPost != null) {
            this.mPost.setEnabled(z);
        }
    }

    private void xH(int i) {
        if (i >= 0 && i < this.hJp.size()) {
            for (int i2 = 0; i2 < this.hJp.size(); i2++) {
                this.hJp.get(i2).nD(false);
            }
            this.hJp.get(i).nD(true);
        }
    }

    public void ao(int i, String str) {
        if (this.gQM != null && this.gQN != null && this.hIT != null) {
            this.gQN.setCurrentIndex(i);
            xH(i);
            this.gQM.setText(str);
            nL(true);
            g.a(this.gQN, this.hIT.getPageContext().getPageActivity());
        }
    }

    public void nM(boolean z) {
        if (this.hJn != null) {
            this.hJn.setSelected(z);
        }
    }

    public void cW(View view) {
        if (view != null && this.gQM != null && this.hJn != null && this.gQN != null) {
            this.gQM.setVisibility(0);
            this.hJn.setSelected(true);
            g.showPopupWindowAsDropDown(this.gQN, view, 0, l.dip2px(this.hIT.getPageContext().getPageActivity(), 1.0f));
        }
    }

    public void hr(int i) {
        if (this.hJm != null) {
            this.hIT.getLayoutMode().aQ(i == 1);
            this.hIT.getLayoutMode().aM(this.hJm);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        aj.s(this.mPost, d.f.s_navbar_button_bg);
        bHX();
    }
}
