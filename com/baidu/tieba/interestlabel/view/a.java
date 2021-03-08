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
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private ViewGroup irm;
    private TextView lam;
    private TextView lan;
    private ImageView lao;
    private TextView lap;
    private ImageView laq;
    private TextView lar;
    private int las;
    private int lau;
    private int lav;

    public a(Context context) {
        this.irm = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.lam = (TextView) this.irm.findViewById(R.id.choose_like_label);
        this.lan = (TextView) this.irm.findViewById(R.id.recommend_interest_thread);
        this.lao = (ImageView) this.irm.findViewById(R.id.male_icon);
        this.lap = (TextView) this.irm.findViewById(R.id.male_text);
        this.laq = (ImageView) this.irm.findViewById(R.id.female_icon);
        this.lar = (TextView) this.irm.findViewById(R.id.female_text);
        this.lao.setOnClickListener(this);
        this.laq.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.lam, R.color.CAM_X0105);
        ap.setViewTextColor(this.lan, R.color.CAM_X0109);
        ap.setImageResource(this.lao, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.lap, R.color.CAM_X0109);
        ap.setImageResource(this.laq, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.lar, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.las = list.get(0).labelId;
            this.lau = list.get(1).labelId;
        }
    }

    public ViewGroup dbc() {
        return this.irm;
    }

    public int dbd() {
        return this.lav;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.lao) {
            z = true;
        } else {
            z = view == this.laq ? false : false;
        }
        this.lav = z ? this.las : this.lau;
        ap.setImageResource(this.lao, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.lap, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ap.setImageResource(this.laq, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.lar, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
