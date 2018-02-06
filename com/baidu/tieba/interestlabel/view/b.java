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
    private ViewGroup eXH;
    private TextView eXI;
    private TextView eXJ;
    private ImageView eXK;
    private TextView eXL;
    private ImageView eXM;
    private TextView eXN;
    private int eXO;
    private int eXP;
    private int eXQ;

    public b(Context context) {
        this.eXH = (ViewGroup) LayoutInflater.from(context).inflate(d.h.label_recommend_header, (ViewGroup) null);
        this.eXI = (TextView) this.eXH.findViewById(d.g.choose_like_label);
        this.eXJ = (TextView) this.eXH.findViewById(d.g.recommend_interest_thread);
        this.eXK = (ImageView) this.eXH.findViewById(d.g.male_icon);
        this.eXL = (TextView) this.eXH.findViewById(d.g.male_text);
        this.eXM = (ImageView) this.eXH.findViewById(d.g.female_icon);
        this.eXN = (TextView) this.eXH.findViewById(d.g.female_text);
        this.eXK.setOnClickListener(this);
        this.eXM.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        aj.r(this.eXI, d.C0140d.cp_cont_b);
        aj.r(this.eXJ, d.C0140d.cp_cont_d);
        aj.c(this.eXK, d.f.img_lable_boy_n);
        aj.r(this.eXL, d.C0140d.cp_cont_d);
        aj.c(this.eXM, d.f.img_lable_girl_n);
        aj.r(this.eXN, d.C0140d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.D(list) == 2) {
            this.eXO = list.get(0).labelId;
            this.eXP = list.get(1).labelId;
        }
    }

    public ViewGroup aOR() {
        return this.eXH;
    }

    public int aOS() {
        return this.eXQ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eXK) {
            z = true;
        } else {
            z = view == this.eXM ? false : false;
        }
        this.eXQ = z ? this.eXO : this.eXP;
        aj.c(this.eXK, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        aj.r(this.eXL, z ? d.C0140d.cp_link_tip_a : d.C0140d.cp_cont_d);
        aj.c(this.eXM, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        aj.r(this.eXN, z ? d.C0140d.cp_cont_d : d.C0140d.cp_cont_h);
    }
}
