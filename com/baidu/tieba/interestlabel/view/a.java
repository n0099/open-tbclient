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
    private ViewGroup ibQ;
    private TextView kOU;
    private TextView kOV;
    private ImageView kOW;
    private TextView kOX;
    private ImageView kOY;
    private TextView kOZ;
    private int kPa;
    private int kPb;
    private int kPc;

    public a(Context context) {
        this.ibQ = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kOU = (TextView) this.ibQ.findViewById(R.id.choose_like_label);
        this.kOV = (TextView) this.ibQ.findViewById(R.id.recommend_interest_thread);
        this.kOW = (ImageView) this.ibQ.findViewById(R.id.male_icon);
        this.kOX = (TextView) this.ibQ.findViewById(R.id.male_text);
        this.kOY = (ImageView) this.ibQ.findViewById(R.id.female_icon);
        this.kOZ = (TextView) this.ibQ.findViewById(R.id.female_text);
        this.kOW.setOnClickListener(this);
        this.kOY.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kOU, R.color.CAM_X0105);
        ap.setViewTextColor(this.kOV, R.color.CAM_X0109);
        ap.setImageResource(this.kOW, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kOX, R.color.CAM_X0109);
        ap.setImageResource(this.kOY, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kOZ, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kPa = list.get(0).labelId;
            this.kPb = list.get(1).labelId;
        }
    }

    public ViewGroup dcV() {
        return this.ibQ;
    }

    public int dcW() {
        return this.kPc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kOW) {
            z = true;
        } else {
            z = view == this.kOY ? false : false;
        }
        this.kPc = z ? this.kPa : this.kPb;
        ap.setImageResource(this.kOW, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kOX, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ap.setImageResource(this.kOY, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kOZ, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
