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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private ViewGroup ipD;
    private TextView kYk;
    private TextView kYl;
    private ImageView kYm;
    private TextView kYn;
    private ImageView kYo;
    private TextView kYp;
    private int kYq;
    private int kYr;
    private int kYs;

    public a(Context context) {
        this.ipD = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kYk = (TextView) this.ipD.findViewById(R.id.choose_like_label);
        this.kYl = (TextView) this.ipD.findViewById(R.id.recommend_interest_thread);
        this.kYm = (ImageView) this.ipD.findViewById(R.id.male_icon);
        this.kYn = (TextView) this.ipD.findViewById(R.id.male_text);
        this.kYo = (ImageView) this.ipD.findViewById(R.id.female_icon);
        this.kYp = (TextView) this.ipD.findViewById(R.id.female_text);
        this.kYm.setOnClickListener(this);
        this.kYo.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kYk, R.color.CAM_X0105);
        ap.setViewTextColor(this.kYl, R.color.CAM_X0109);
        ap.setImageResource(this.kYm, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kYn, R.color.CAM_X0109);
        ap.setImageResource(this.kYo, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kYp, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kYq = list.get(0).labelId;
            this.kYr = list.get(1).labelId;
        }
    }

    public ViewGroup daT() {
        return this.ipD;
    }

    public int daU() {
        return this.kYs;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kYm) {
            z = true;
        } else {
            z = view == this.kYo ? false : false;
        }
        this.kYs = z ? this.kYq : this.kYr;
        ap.setImageResource(this.kYm, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kYn, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ap.setImageResource(this.kYo, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kYp, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
