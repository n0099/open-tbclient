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
    private ViewGroup ibO;
    private TextView kOS;
    private TextView kOT;
    private ImageView kOU;
    private TextView kOV;
    private ImageView kOW;
    private TextView kOX;
    private int kOY;
    private int kOZ;
    private int kPa;

    public a(Context context) {
        this.ibO = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kOS = (TextView) this.ibO.findViewById(R.id.choose_like_label);
        this.kOT = (TextView) this.ibO.findViewById(R.id.recommend_interest_thread);
        this.kOU = (ImageView) this.ibO.findViewById(R.id.male_icon);
        this.kOV = (TextView) this.ibO.findViewById(R.id.male_text);
        this.kOW = (ImageView) this.ibO.findViewById(R.id.female_icon);
        this.kOX = (TextView) this.ibO.findViewById(R.id.female_text);
        this.kOU.setOnClickListener(this);
        this.kOW.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kOS, R.color.CAM_X0105);
        ap.setViewTextColor(this.kOT, R.color.CAM_X0109);
        ap.setImageResource(this.kOU, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kOV, R.color.CAM_X0109);
        ap.setImageResource(this.kOW, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kOX, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kOY = list.get(0).labelId;
            this.kOZ = list.get(1).labelId;
        }
    }

    public ViewGroup dcU() {
        return this.ibO;
    }

    public int dcV() {
        return this.kPa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kOU) {
            z = true;
        } else {
            z = view == this.kOW ? false : false;
        }
        this.kPa = z ? this.kOY : this.kOZ;
        ap.setImageResource(this.kOU, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kOV, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ap.setImageResource(this.kOW, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kOX, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
