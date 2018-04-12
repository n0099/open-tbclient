package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private ViewGroup esq;
    private TextView esr;
    private TextView ess;
    private ImageView est;
    private TextView esu;
    private ImageView esv;
    private TextView esw;
    private int esx;
    private int esy;
    private int esz;

    public a(Context context) {
        this.esq = (ViewGroup) LayoutInflater.from(context).inflate(d.i.label_recommend_header, (ViewGroup) null);
        this.esr = (TextView) this.esq.findViewById(d.g.choose_like_label);
        this.ess = (TextView) this.esq.findViewById(d.g.recommend_interest_thread);
        this.est = (ImageView) this.esq.findViewById(d.g.male_icon);
        this.esu = (TextView) this.esq.findViewById(d.g.male_text);
        this.esv = (ImageView) this.esq.findViewById(d.g.female_icon);
        this.esw = (TextView) this.esq.findViewById(d.g.female_text);
        this.est.setOnClickListener(this);
        this.esv.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ak.h(this.esr, d.C0126d.cp_cont_b);
        ak.h(this.ess, d.C0126d.cp_cont_d);
        ak.c(this.est, d.f.img_lable_boy_n);
        ak.h(this.esu, d.C0126d.cp_cont_d);
        ak.c(this.esv, d.f.img_lable_girl_n);
        ak.h(this.esw, d.C0126d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.v(list) == 2) {
            this.esx = list.get(0).labelId;
            this.esy = list.get(1).labelId;
        }
    }

    public ViewGroup aJT() {
        return this.esq;
    }

    public int aJU() {
        return this.esz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z;
        if (view2 == this.est) {
            z = true;
        } else {
            z = view2 == this.esv ? false : false;
        }
        this.esz = z ? this.esx : this.esy;
        ak.c(this.est, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        ak.h(this.esu, z ? d.C0126d.cp_link_tip_a : d.C0126d.cp_cont_d);
        ak.c(this.esv, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        ak.h(this.esw, z ? d.C0126d.cp_cont_d : d.C0126d.cp_cont_h);
    }
}
