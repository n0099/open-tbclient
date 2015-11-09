package com.baidu.tieba.personInfo;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private int arf = -1;
    private PersonInfoActivity csa;
    private RelativeLayout cuA;
    private TextView cuB;
    private TextView cuC;
    private LinearLayout cuD;
    private TextView cuE;
    private RelativeLayout cuF;
    private LinearLayout cuG;
    private TextView cuH;
    private TextView cuI;
    private TextView cuJ;
    private TextView cuK;
    private TextView cuL;
    private TextView cuM;
    private TextView cuN;
    private View cul;
    private ImageView cup;
    private ImageView cuz;
    private View line;
    private boolean mIsHost;
    private View mRootView;

    public v(PersonInfoActivity personInfoActivity, boolean z) {
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cul = this.mRootView.findViewById(i.f.root_next);
        this.cuA = (RelativeLayout) this.mRootView.findViewById(i.f.group_ll);
        this.cuA.setOnClickListener(this.csa);
        this.cuB = (TextView) this.mRootView.findViewById(i.f.group_num);
        this.cuC = (TextView) this.mRootView.findViewById(i.f.group_num_text);
        this.cuD = (LinearLayout) this.mRootView.findViewById(i.f.group_info_ll);
        this.cuE = (TextView) this.mRootView.findViewById(i.f.no_group_tip);
        this.cup = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.line = this.mRootView.findViewById(i.f.line);
        this.cuF = (RelativeLayout) this.mRootView.findViewById(i.f.bar_ll);
        this.cuF.setOnClickListener(this.csa);
        this.cuH = (TextView) this.mRootView.findViewById(i.f.bar_num);
        this.cuI = (TextView) this.mRootView.findViewById(i.f.bar_num_text);
        this.cuG = (LinearLayout) this.mRootView.findViewById(i.f.bar_info_ll);
        this.cuJ = (TextView) this.mRootView.findViewById(i.f.bar_name_1);
        this.cuK = (TextView) this.mRootView.findViewById(i.f.bar_name_2);
        this.cuL = (TextView) this.mRootView.findViewById(i.f.bar_name_3);
        this.cuM = (TextView) this.mRootView.findViewById(i.f.bar_name_4);
        this.cuN = (TextView) this.mRootView.findViewById(i.f.no_bar_tip);
        this.cuz = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        oP();
    }

    public void oP() {
        if (this.arf != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arf = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.cul, i.c.cp_bg_line_d);
            an.i(this.cuA, i.e.personinfo_select_bg);
            an.b(this.cuB, i.c.cp_cont_f, 1);
            an.b(this.cuC, i.c.cp_cont_d, 1);
            an.b(this.cuE, i.c.cp_cont_e, 1);
            an.i(this.cup, i.e.icon_dredge_arrow_r_n);
            an.j(this.line, i.c.cp_bg_line_b);
            an.i(this.cuF, i.e.personinfo_select_bg);
            an.b(this.cuH, i.c.cp_cont_f, 1);
            an.b(this.cuI, i.c.cp_cont_d, 1);
            an.b(this.cuJ, i.c.cp_cont_b, 1);
            an.b(this.cuK, i.c.cp_cont_b, 1);
            an.b(this.cuL, i.c.cp_cont_b, 1);
            an.b(this.cuM, i.c.cp_cont_b, 1);
            an.b(this.cuN, i.c.cp_cont_e, 1);
            an.i(this.cuz, i.e.icon_dredge_arrow_r_n);
        }
    }

    public void ake() {
        y ajH = this.csa.ajH();
        UserData userData = ajH.getUserData();
        PersonTainInfo akp = ajH.akp();
        c(akp, userData);
        a(akp, userData);
        oP();
    }

    private void a(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            int Ac = personPrivate != null ? personPrivate.Ac() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.cuA.setVisibility(8);
                this.line.setVisibility(8);
                return;
            }
            this.cuA.setVisibility(0);
            this.line.setVisibility(0);
            if (this.mIsHost) {
                b(personTainInfo, userData);
            } else if (Ac == 1 || (Ac == 2 && isFriend == 1)) {
                b(personTainInfo, userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuC.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cuC.setLayoutParams(layoutParams);
                this.cuB.setText("");
                this.cuB.setTextSize(0.0f);
                this.cuB.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cuD.setVisibility(8);
                this.cuE.setVisibility(0);
                this.cuE.setText(i.h.set_private);
                this.cup.setVisibility(8);
            }
        }
    }

    public void b(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            String cA = as.cA(personTainInfo != null ? personTainInfo.getGroupNum() : 0);
            this.cuB.setTextSize(0, this.csa.getResources().getDimensionPixelSize(i.d.ds72));
            if (cA.contains("w") && cA.length() > 3) {
                this.cuB.setTextSize(0, this.csa.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cuB.setCompoundDrawables(null, null, null, null);
            this.cuB.setText(cA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuC.getLayoutParams();
            layoutParams.topMargin = -this.csa.getResources().getDimensionPixelSize(i.d.ds10);
            this.cuC.setLayoutParams(layoutParams);
            List<MyGroup> group = userData.getGroup();
            if (group == null || group.size() == 0) {
                this.cuD.setVisibility(8);
                this.cup.setVisibility(8);
                this.cuE.setVisibility(0);
                this.cuE.setText(i.h.no_group_tip);
                return;
            }
            this.cuD.removeAllViews();
            this.cuD.setVisibility(0);
            this.cup.setVisibility(0);
            this.cuE.setVisibility(8);
            int size = group.size();
            int i = size > 5 ? 5 : size;
            for (int i2 = 0; i2 < i; i2++) {
                MyGroup myGroup = group.get(i2);
                if (myGroup != null && !TextUtils.isEmpty(myGroup.getmGroupName())) {
                    View inflate = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_group_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(i.f.group_name);
                    ((HeadImageView) inflate.findViewById(i.f.group_head)).d(myGroup.getGroupPortrait(), 21, false);
                    textView.setText(myGroup.getmGroupName());
                    an.b(textView, i.c.cp_cont_b, 1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = this.csa.getResources().getDimensionPixelSize(i.d.ds26);
                    this.cuD.addView(inflate, layoutParams2);
                }
            }
        }
    }

    private void c(PersonTainInfo personTainInfo, UserData userData) {
        if (userData != null && personTainInfo != null) {
            com.baidu.tbadk.data.f personPrivate = userData.getPersonPrivate();
            int Ab = personPrivate != null ? personPrivate.Ab() : 1;
            int isFriend = personTainInfo != null ? personTainInfo.getIsFriend() : 1;
            if (this.mIsHost) {
                e(userData);
            } else if (Ab == 1 || (Ab == 2 && isFriend == 1)) {
                e(userData);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuI.getLayoutParams();
                layoutParams.topMargin = 0;
                this.cuI.setLayoutParams(layoutParams);
                this.cuH.setText("");
                this.cuH.setTextSize(0.0f);
                this.cuH.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_mycenter_lock), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cuG.setVisibility(8);
                this.cuN.setVisibility(0);
                this.cuN.setText(i.h.set_private);
                this.cuz.setVisibility(8);
            }
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            String cA = as.cA(userData.getLike_bars());
            this.cuH.setTextSize(0, this.csa.getResources().getDimensionPixelSize(i.d.ds72));
            if (cA.contains("w") && cA.length() > 3) {
                this.cuH.setTextSize(0, this.csa.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cuH.setCompoundDrawables(null, null, null, null);
            this.cuH.setText(cA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuI.getLayoutParams();
            layoutParams.topMargin = -this.csa.getResources().getDimensionPixelSize(i.d.ds10);
            this.cuI.setLayoutParams(layoutParams);
            List<MyLikeForum> likeForum = userData.getLikeForum();
            if (likeForum == null || likeForum.size() == 0) {
                this.cuG.setVisibility(8);
                this.cuN.setVisibility(0);
                this.cuN.setText(i.h.no_attention_bar);
                this.cuz.setVisibility(8);
                return;
            }
            this.cuG.setVisibility(0);
            this.cuN.setVisibility(8);
            this.cuz.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < likeForum.size(); i++) {
                if (!TextUtils.isEmpty(likeForum.get(i).getForumName())) {
                    arrayList.add(likeForum.get(i).getForumName());
                }
            }
            int size = arrayList.size();
            if (size > 4) {
                size = 4;
            }
            akf();
            switch (size) {
                case 1:
                    this.cuJ.setText((CharSequence) arrayList.get(0));
                    return;
                case 2:
                    this.cuJ.setText((CharSequence) arrayList.get(0));
                    this.cuK.setText((CharSequence) arrayList.get(1));
                    return;
                case 3:
                    this.cuJ.setText((CharSequence) arrayList.get(0));
                    this.cuK.setText((CharSequence) arrayList.get(1));
                    this.cuL.setText((CharSequence) arrayList.get(2));
                    return;
                case 4:
                    this.cuJ.setText((CharSequence) arrayList.get(0));
                    this.cuK.setText((CharSequence) arrayList.get(1));
                    this.cuL.setText((CharSequence) arrayList.get(2));
                    this.cuM.setText((CharSequence) arrayList.get(3));
                    return;
                default:
                    return;
            }
        }
    }

    private void akf() {
        this.cuJ.setText((CharSequence) null);
        this.cuK.setText((CharSequence) null);
        this.cuL.setText((CharSequence) null);
        this.cuM.setText((CharSequence) null);
    }

    public RelativeLayout aka() {
        return this.cuA;
    }

    public RelativeLayout ajT() {
        return this.cuF;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
