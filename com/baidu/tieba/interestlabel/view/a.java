package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private ViewGroup evc;
    private TextView hbM;
    private TextView hbN;
    private ImageView hbO;
    private TextView hbP;
    private ImageView hbQ;
    private TextView hbR;
    private int hbS;
    private int hbT;
    private int hbU;

    public a(Context context) {
        this.evc = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hbM = (TextView) this.evc.findViewById(R.id.choose_like_label);
        this.hbN = (TextView) this.evc.findViewById(R.id.recommend_interest_thread);
        this.hbO = (ImageView) this.evc.findViewById(R.id.male_icon);
        this.hbP = (TextView) this.evc.findViewById(R.id.male_text);
        this.hbQ = (ImageView) this.evc.findViewById(R.id.female_icon);
        this.hbR = (TextView) this.evc.findViewById(R.id.female_text);
        this.hbO.setOnClickListener(this);
        this.hbQ.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.j(this.hbM, R.color.cp_cont_b);
        am.j(this.hbN, R.color.cp_cont_d);
        am.c(this.hbO, (int) R.drawable.img_lable_boy_n);
        am.j(this.hbP, R.color.cp_cont_d);
        am.c(this.hbQ, (int) R.drawable.img_lable_girl_n);
        am.j(this.hbR, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.Z(list) == 2) {
            this.hbS = list.get(0).bFM;
            this.hbT = list.get(1).bFM;
        }
    }

    public ViewGroup bJH() {
        return this.evc;
    }

    public int bJI() {
        return this.hbU;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hbO) {
            z = true;
        } else {
            z = view == this.hbQ ? false : false;
        }
        this.hbU = z ? this.hbS : this.hbT;
        am.c(this.hbO, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.j(this.hbP, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.c(this.hbQ, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hbR;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.j(textView, i);
    }
}
