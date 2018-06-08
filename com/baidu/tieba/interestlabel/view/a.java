package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private ViewGroup eEM;
    private TextView eEN;
    private TextView eEO;
    private ImageView eEP;
    private TextView eEQ;
    private ImageView eER;
    private TextView eES;
    private int eET;
    private int eEU;
    private int eEV;

    public a(Context context) {
        this.eEM = (ViewGroup) LayoutInflater.from(context).inflate(d.i.label_recommend_header, (ViewGroup) null);
        this.eEN = (TextView) this.eEM.findViewById(d.g.choose_like_label);
        this.eEO = (TextView) this.eEM.findViewById(d.g.recommend_interest_thread);
        this.eEP = (ImageView) this.eEM.findViewById(d.g.male_icon);
        this.eEQ = (TextView) this.eEM.findViewById(d.g.male_text);
        this.eER = (ImageView) this.eEM.findViewById(d.g.female_icon);
        this.eES = (TextView) this.eEM.findViewById(d.g.female_text);
        this.eEP.setOnClickListener(this);
        this.eER.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.eEN, d.C0141d.cp_cont_b);
        al.h(this.eEO, d.C0141d.cp_cont_d);
        al.c(this.eEP, d.f.img_lable_boy_n);
        al.h(this.eEQ, d.C0141d.cp_cont_d);
        al.c(this.eER, d.f.img_lable_girl_n);
        al.h(this.eES, d.C0141d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (w.y(list) == 2) {
            this.eET = list.get(0).labelId;
            this.eEU = list.get(1).labelId;
        }
    }

    public ViewGroup aOO() {
        return this.eEM;
    }

    public int aOP() {
        return this.eEV;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eEP) {
            z = true;
        } else {
            z = view == this.eER ? false : false;
        }
        this.eEV = z ? this.eET : this.eEU;
        al.c(this.eEP, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        al.h(this.eEQ, z ? d.C0141d.cp_link_tip_a : d.C0141d.cp_cont_d);
        al.c(this.eER, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        al.h(this.eES, z ? d.C0141d.cp_cont_d : d.C0141d.cp_cont_h);
    }
}
