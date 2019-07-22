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
    private ViewGroup euV;
    private TextView haU;
    private TextView haV;
    private ImageView haW;
    private TextView haX;
    private ImageView haY;
    private TextView haZ;
    private int hba;
    private int hbb;
    private int hbc;

    public a(Context context) {
        this.euV = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.haU = (TextView) this.euV.findViewById(R.id.choose_like_label);
        this.haV = (TextView) this.euV.findViewById(R.id.recommend_interest_thread);
        this.haW = (ImageView) this.euV.findViewById(R.id.male_icon);
        this.haX = (TextView) this.euV.findViewById(R.id.male_text);
        this.haY = (ImageView) this.euV.findViewById(R.id.female_icon);
        this.haZ = (TextView) this.euV.findViewById(R.id.female_text);
        this.haW.setOnClickListener(this);
        this.haY.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.j(this.haU, R.color.cp_cont_b);
        am.j(this.haV, R.color.cp_cont_d);
        am.c(this.haW, (int) R.drawable.img_lable_boy_n);
        am.j(this.haX, R.color.cp_cont_d);
        am.c(this.haY, (int) R.drawable.img_lable_girl_n);
        am.j(this.haZ, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.Z(list) == 2) {
            this.hba = list.get(0).bFL;
            this.hbb = list.get(1).bFL;
        }
    }

    public ViewGroup bJt() {
        return this.euV;
    }

    public int bJu() {
        return this.hbc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.haW) {
            z = true;
        } else {
            z = view == this.haY ? false : false;
        }
        this.hbc = z ? this.hba : this.hbb;
        am.c(this.haW, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.j(this.haX, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.c(this.haY, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.haZ;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.j(textView, i);
    }
}
