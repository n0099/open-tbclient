package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private ViewGroup eXJ;
    private TextView eXK;
    private TextView eXL;
    private ImageView eXM;
    private TextView eXN;
    private ImageView eXO;
    private TextView eXP;
    private int eXQ;
    private int eXR;
    private int eXS;

    public b(Context context) {
        this.eXJ = (ViewGroup) LayoutInflater.from(context).inflate(d.h.label_recommend_header, (ViewGroup) null);
        this.eXK = (TextView) this.eXJ.findViewById(d.g.choose_like_label);
        this.eXL = (TextView) this.eXJ.findViewById(d.g.recommend_interest_thread);
        this.eXM = (ImageView) this.eXJ.findViewById(d.g.male_icon);
        this.eXN = (TextView) this.eXJ.findViewById(d.g.male_text);
        this.eXO = (ImageView) this.eXJ.findViewById(d.g.female_icon);
        this.eXP = (TextView) this.eXJ.findViewById(d.g.female_text);
        this.eXM.setOnClickListener(this);
        this.eXO.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        aj.r(this.eXK, d.C0141d.cp_cont_b);
        aj.r(this.eXL, d.C0141d.cp_cont_d);
        aj.c(this.eXM, d.f.img_lable_boy_n);
        aj.r(this.eXN, d.C0141d.cp_cont_d);
        aj.c(this.eXO, d.f.img_lable_girl_n);
        aj.r(this.eXP, d.C0141d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.D(list) == 2) {
            this.eXQ = list.get(0).labelId;
            this.eXR = list.get(1).labelId;
        }
    }

    public ViewGroup aOR() {
        return this.eXJ;
    }

    public int aOS() {
        return this.eXS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eXM) {
            z = true;
        } else {
            z = view == this.eXO ? false : false;
        }
        this.eXS = z ? this.eXQ : this.eXR;
        aj.c(this.eXM, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        aj.r(this.eXN, z ? d.C0141d.cp_link_tip_a : d.C0141d.cp_cont_d);
        aj.c(this.eXO, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        aj.r(this.eXP, z ? d.C0141d.cp_cont_d : d.C0141d.cp_cont_h);
    }
}
