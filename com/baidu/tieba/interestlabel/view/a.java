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
    private TextView etA;
    private ImageView etB;
    private TextView etC;
    private int etD;
    private int etE;
    private int etF;
    private ViewGroup etw;
    private TextView etx;
    private TextView ety;
    private ImageView etz;

    public a(Context context) {
        this.etw = (ViewGroup) LayoutInflater.from(context).inflate(d.i.label_recommend_header, (ViewGroup) null);
        this.etx = (TextView) this.etw.findViewById(d.g.choose_like_label);
        this.ety = (TextView) this.etw.findViewById(d.g.recommend_interest_thread);
        this.etz = (ImageView) this.etw.findViewById(d.g.male_icon);
        this.etA = (TextView) this.etw.findViewById(d.g.male_text);
        this.etB = (ImageView) this.etw.findViewById(d.g.female_icon);
        this.etC = (TextView) this.etw.findViewById(d.g.female_text);
        this.etz.setOnClickListener(this);
        this.etB.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ak.h(this.etx, d.C0126d.cp_cont_b);
        ak.h(this.ety, d.C0126d.cp_cont_d);
        ak.c(this.etz, d.f.img_lable_boy_n);
        ak.h(this.etA, d.C0126d.cp_cont_d);
        ak.c(this.etB, d.f.img_lable_girl_n);
        ak.h(this.etC, d.C0126d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.v(list) == 2) {
            this.etD = list.get(0).labelId;
            this.etE = list.get(1).labelId;
        }
    }

    public ViewGroup aJS() {
        return this.etw;
    }

    public int aJT() {
        return this.etF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z;
        if (view2 == this.etz) {
            z = true;
        } else {
            z = view2 == this.etB ? false : false;
        }
        this.etF = z ? this.etD : this.etE;
        ak.c(this.etz, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        ak.h(this.etA, z ? d.C0126d.cp_link_tip_a : d.C0126d.cp_cont_d);
        ak.c(this.etB, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        ak.h(this.etC, z ? d.C0126d.cp_cont_d : d.C0126d.cp_cont_h);
    }
}
