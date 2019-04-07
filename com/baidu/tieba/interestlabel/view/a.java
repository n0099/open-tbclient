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
    private ViewGroup gDm;
    private TextView gDn;
    private TextView gDo;
    private ImageView gDp;
    private TextView gDq;
    private ImageView gDr;
    private TextView gDs;
    private int gDt;
    private int gDu;
    private int gDv;

    public a(Context context) {
        this.gDm = (ViewGroup) LayoutInflater.from(context).inflate(d.h.label_recommend_header, (ViewGroup) null);
        this.gDn = (TextView) this.gDm.findViewById(d.g.choose_like_label);
        this.gDo = (TextView) this.gDm.findViewById(d.g.recommend_interest_thread);
        this.gDp = (ImageView) this.gDm.findViewById(d.g.male_icon);
        this.gDq = (TextView) this.gDm.findViewById(d.g.male_text);
        this.gDr = (ImageView) this.gDm.findViewById(d.g.female_icon);
        this.gDs = (TextView) this.gDm.findViewById(d.g.female_text);
        this.gDp.setOnClickListener(this);
        this.gDr.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gDn, d.C0277d.cp_cont_b);
        al.j(this.gDo, d.C0277d.cp_cont_d);
        al.c(this.gDp, d.f.img_lable_boy_n);
        al.j(this.gDq, d.C0277d.cp_cont_d);
        al.c(this.gDr, d.f.img_lable_girl_n);
        al.j(this.gDs, d.C0277d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.S(list) == 2) {
            this.gDt = list.get(0).labelId;
            this.gDu = list.get(1).labelId;
        }
    }

    public ViewGroup byY() {
        return this.gDm;
    }

    public int byZ() {
        return this.gDv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.gDp) {
            z = true;
        } else {
            z = view == this.gDr ? false : false;
        }
        this.gDv = z ? this.gDt : this.gDu;
        al.c(this.gDp, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        al.j(this.gDq, z ? d.C0277d.cp_link_tip_a : d.C0277d.cp_cont_d);
        al.c(this.gDr, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        al.j(this.gDs, z ? d.C0277d.cp_cont_d : d.C0277d.cp_cont_h);
    }
}
