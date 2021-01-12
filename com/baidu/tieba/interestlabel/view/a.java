package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private ViewGroup ijH;
    private TextView kPU;
    private TextView kPV;
    private ImageView kPW;
    private TextView kPX;
    private ImageView kPY;
    private TextView kPZ;
    private int kQa;
    private int kQb;
    private int kQc;

    public a(Context context) {
        this.ijH = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kPU = (TextView) this.ijH.findViewById(R.id.choose_like_label);
        this.kPV = (TextView) this.ijH.findViewById(R.id.recommend_interest_thread);
        this.kPW = (ImageView) this.ijH.findViewById(R.id.male_icon);
        this.kPX = (TextView) this.ijH.findViewById(R.id.male_text);
        this.kPY = (ImageView) this.ijH.findViewById(R.id.female_icon);
        this.kPZ = (TextView) this.ijH.findViewById(R.id.female_text);
        this.kPW.setOnClickListener(this);
        this.kPY.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setViewTextColor(this.kPU, R.color.CAM_X0105);
        ao.setViewTextColor(this.kPV, R.color.CAM_X0109);
        ao.setImageResource(this.kPW, R.drawable.img_lable_boy_n);
        ao.setViewTextColor(this.kPX, R.color.CAM_X0109);
        ao.setImageResource(this.kPY, R.drawable.img_lable_girl_n);
        ao.setViewTextColor(this.kPZ, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (x.getCount(list) == 2) {
            this.kQa = list.get(0).labelId;
            this.kQb = list.get(1).labelId;
        }
    }

    public ViewGroup cYO() {
        return this.ijH;
    }

    public int cYP() {
        return this.kQc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kPW) {
            z = true;
        } else {
            z = view == this.kPY ? false : false;
        }
        this.kQc = z ? this.kQa : this.kQb;
        ao.setImageResource(this.kPW, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ao.setViewTextColor(this.kPX, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ao.setImageResource(this.kPY, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ao.setViewTextColor(this.kPZ, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
