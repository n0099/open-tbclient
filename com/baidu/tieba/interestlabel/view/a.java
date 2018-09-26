package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private ViewGroup eTM;
    private TextView eTN;
    private TextView eTO;
    private ImageView eTP;
    private TextView eTQ;
    private ImageView eTR;
    private TextView eTS;
    private int eTT;
    private int eTU;
    private int eTV;

    public a(Context context) {
        this.eTM = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.eTN = (TextView) this.eTM.findViewById(e.g.choose_like_label);
        this.eTO = (TextView) this.eTM.findViewById(e.g.recommend_interest_thread);
        this.eTP = (ImageView) this.eTM.findViewById(e.g.male_icon);
        this.eTQ = (TextView) this.eTM.findViewById(e.g.male_text);
        this.eTR = (ImageView) this.eTM.findViewById(e.g.female_icon);
        this.eTS = (TextView) this.eTM.findViewById(e.g.female_text);
        this.eTP.setOnClickListener(this);
        this.eTR.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.eTN, e.d.cp_cont_b);
        al.h(this.eTO, e.d.cp_cont_d);
        al.c(this.eTP, e.f.img_lable_boy_n);
        al.h(this.eTQ, e.d.cp_cont_d);
        al.c(this.eTR, e.f.img_lable_girl_n);
        al.h(this.eTS, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.y(list) == 2) {
            this.eTT = list.get(0).labelId;
            this.eTU = list.get(1).labelId;
        }
    }

    public ViewGroup aSF() {
        return this.eTM;
    }

    public int aSG() {
        return this.eTV;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eTP) {
            z = true;
        } else {
            z = view == this.eTR ? false : false;
        }
        this.eTV = z ? this.eTT : this.eTU;
        al.c(this.eTP, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.eTQ, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.eTR, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.eTS, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
