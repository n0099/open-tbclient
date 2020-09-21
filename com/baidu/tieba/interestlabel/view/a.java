package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class a implements View.OnClickListener {
    private ViewGroup hjg;
    private TextView jTT;
    private TextView jTU;
    private ImageView jTV;
    private TextView jTW;
    private ImageView jTX;
    private TextView jTY;
    private int jTZ;
    private int jUa;
    private int jUb;

    public a(Context context) {
        this.hjg = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.jTT = (TextView) this.hjg.findViewById(R.id.choose_like_label);
        this.jTU = (TextView) this.hjg.findViewById(R.id.recommend_interest_thread);
        this.jTV = (ImageView) this.hjg.findViewById(R.id.male_icon);
        this.jTW = (TextView) this.hjg.findViewById(R.id.male_text);
        this.jTX = (ImageView) this.hjg.findViewById(R.id.female_icon);
        this.jTY = (TextView) this.hjg.findViewById(R.id.female_text);
        this.jTV.setOnClickListener(this);
        this.jTX.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.jTT, R.color.cp_cont_b);
        ap.setViewTextColor(this.jTU, R.color.cp_cont_d);
        ap.setImageResource(this.jTV, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.jTW, R.color.cp_cont_d);
        ap.setImageResource(this.jTX, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.jTY, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.jTZ = list.get(0).labelId;
            this.jUa = list.get(1).labelId;
        }
    }

    public ViewGroup cOX() {
        return this.hjg;
    }

    public int cOY() {
        return this.jUb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.jTV) {
            z = true;
        } else {
            z = view == this.jTX ? false : false;
        }
        this.jUb = z ? this.jTZ : this.jUa;
        ap.setImageResource(this.jTV, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.jTW, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        ap.setImageResource(this.jTX, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.jTY, z ? R.color.cp_cont_d : R.color.cp_cont_h);
    }
}
