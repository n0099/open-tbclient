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
/* loaded from: classes23.dex */
public class a implements View.OnClickListener {
    private ViewGroup hyb;
    private TextView kiT;
    private TextView kiU;
    private ImageView kiV;
    private TextView kiW;
    private ImageView kiX;
    private TextView kiY;
    private int kiZ;
    private int kja;
    private int kjb;

    public a(Context context) {
        this.hyb = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kiT = (TextView) this.hyb.findViewById(R.id.choose_like_label);
        this.kiU = (TextView) this.hyb.findViewById(R.id.recommend_interest_thread);
        this.kiV = (ImageView) this.hyb.findViewById(R.id.male_icon);
        this.kiW = (TextView) this.hyb.findViewById(R.id.male_text);
        this.kiX = (ImageView) this.hyb.findViewById(R.id.female_icon);
        this.kiY = (TextView) this.hyb.findViewById(R.id.female_text);
        this.kiV.setOnClickListener(this);
        this.kiX.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kiT, R.color.cp_cont_b);
        ap.setViewTextColor(this.kiU, R.color.cp_cont_d);
        ap.setImageResource(this.kiV, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kiW, R.color.cp_cont_d);
        ap.setImageResource(this.kiX, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kiY, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kiZ = list.get(0).labelId;
            this.kja = list.get(1).labelId;
        }
    }

    public ViewGroup cSF() {
        return this.hyb;
    }

    public int cSG() {
        return this.kjb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kiV) {
            z = true;
        } else {
            z = view == this.kiX ? false : false;
        }
        this.kjb = z ? this.kiZ : this.kja;
        ap.setImageResource(this.kiV, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kiW, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        ap.setImageResource(this.kiX, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kiY, z ? R.color.cp_cont_d : R.color.cp_cont_h);
    }
}
