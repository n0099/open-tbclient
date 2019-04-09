package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private ViewGroup gDn;
    private TextView gDo;
    private TextView gDp;
    private ImageView gDq;
    private TextView gDr;
    private ImageView gDs;
    private TextView gDt;
    private int gDu;
    private int gDv;
    private int gDw;

    public a(Context context) {
        this.gDn = (ViewGroup) LayoutInflater.from(context).inflate(d.h.label_recommend_header, (ViewGroup) null);
        this.gDo = (TextView) this.gDn.findViewById(d.g.choose_like_label);
        this.gDp = (TextView) this.gDn.findViewById(d.g.recommend_interest_thread);
        this.gDq = (ImageView) this.gDn.findViewById(d.g.male_icon);
        this.gDr = (TextView) this.gDn.findViewById(d.g.male_text);
        this.gDs = (ImageView) this.gDn.findViewById(d.g.female_icon);
        this.gDt = (TextView) this.gDn.findViewById(d.g.female_text);
        this.gDq.setOnClickListener(this);
        this.gDs.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gDo, d.C0277d.cp_cont_b);
        al.j(this.gDp, d.C0277d.cp_cont_d);
        al.c(this.gDq, d.f.img_lable_boy_n);
        al.j(this.gDr, d.C0277d.cp_cont_d);
        al.c(this.gDs, d.f.img_lable_girl_n);
        al.j(this.gDt, d.C0277d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.S(list) == 2) {
            this.gDu = list.get(0).labelId;
            this.gDv = list.get(1).labelId;
        }
    }

    public ViewGroup byY() {
        return this.gDn;
    }

    public int byZ() {
        return this.gDw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.gDq) {
            z = true;
        } else {
            z = view == this.gDs ? false : false;
        }
        this.gDw = z ? this.gDu : this.gDv;
        al.c(this.gDq, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        al.j(this.gDr, z ? d.C0277d.cp_link_tip_a : d.C0277d.cp_cont_d);
        al.c(this.gDs, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        al.j(this.gDt, z ? d.C0277d.cp_cont_d : d.C0277d.cp_cont_h);
    }
}
