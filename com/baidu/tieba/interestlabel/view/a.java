package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private ViewGroup eIC;
    private TextView eID;
    private TextView eIE;
    private ImageView eIF;
    private TextView eIG;
    private ImageView eIH;
    private TextView eII;
    private int eIJ;
    private int eIK;
    private int eIL;

    public a(Context context) {
        this.eIC = (ViewGroup) LayoutInflater.from(context).inflate(d.i.label_recommend_header, (ViewGroup) null);
        this.eID = (TextView) this.eIC.findViewById(d.g.choose_like_label);
        this.eIE = (TextView) this.eIC.findViewById(d.g.recommend_interest_thread);
        this.eIF = (ImageView) this.eIC.findViewById(d.g.male_icon);
        this.eIG = (TextView) this.eIC.findViewById(d.g.male_text);
        this.eIH = (ImageView) this.eIC.findViewById(d.g.female_icon);
        this.eII = (TextView) this.eIC.findViewById(d.g.female_text);
        this.eIF.setOnClickListener(this);
        this.eIH.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.h(this.eID, d.C0142d.cp_cont_b);
        am.h(this.eIE, d.C0142d.cp_cont_d);
        am.c(this.eIF, d.f.img_lable_boy_n);
        am.h(this.eIG, d.C0142d.cp_cont_d);
        am.c(this.eIH, d.f.img_lable_girl_n);
        am.h(this.eII, d.C0142d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (w.z(list) == 2) {
            this.eIJ = list.get(0).labelId;
            this.eIK = list.get(1).labelId;
        }
    }

    public ViewGroup aPu() {
        return this.eIC;
    }

    public int aPv() {
        return this.eIL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eIF) {
            z = true;
        } else {
            z = view == this.eIH ? false : false;
        }
        this.eIL = z ? this.eIJ : this.eIK;
        am.c(this.eIF, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        am.h(this.eIG, z ? d.C0142d.cp_link_tip_a : d.C0142d.cp_cont_d);
        am.c(this.eIH, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        am.h(this.eII, z ? d.C0142d.cp_cont_d : d.C0142d.cp_cont_h);
    }
}
