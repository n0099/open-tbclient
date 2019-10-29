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
    private ViewGroup eFx;
    private TextView hbJ;
    private TextView hbK;
    private ImageView hbL;
    private TextView hbM;
    private ImageView hbN;
    private TextView hbO;
    private int hbP;
    private int hbQ;
    private int hbR;

    public a(Context context) {
        this.eFx = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hbJ = (TextView) this.eFx.findViewById(R.id.choose_like_label);
        this.hbK = (TextView) this.eFx.findViewById(R.id.recommend_interest_thread);
        this.hbL = (ImageView) this.eFx.findViewById(R.id.male_icon);
        this.hbM = (TextView) this.eFx.findViewById(R.id.male_text);
        this.hbN = (ImageView) this.eFx.findViewById(R.id.female_icon);
        this.hbO = (TextView) this.eFx.findViewById(R.id.female_text);
        this.hbL.setOnClickListener(this);
        this.hbN.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hbJ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hbK, (int) R.color.cp_cont_d);
        am.setImageResource(this.hbL, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hbM, (int) R.color.cp_cont_d);
        am.setImageResource(this.hbN, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.hbO, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.hbP = list.get(0).labelId;
            this.hbQ = list.get(1).labelId;
        }
    }

    public ViewGroup bHe() {
        return this.eFx;
    }

    public int bHf() {
        return this.hbR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hbL) {
            z = true;
        } else {
            z = view == this.hbN ? false : false;
        }
        this.hbR = z ? this.hbP : this.hbQ;
        am.setImageResource(this.hbL, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hbM, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.hbN, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hbO;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
