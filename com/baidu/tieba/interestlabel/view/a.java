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
    private ViewGroup ipp;
    private TextView kXW;
    private TextView kXX;
    private ImageView kXY;
    private TextView kXZ;
    private ImageView kYa;
    private TextView kYb;
    private int kYc;
    private int kYd;
    private int kYe;

    public a(Context context) {
        this.ipp = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kXW = (TextView) this.ipp.findViewById(R.id.choose_like_label);
        this.kXX = (TextView) this.ipp.findViewById(R.id.recommend_interest_thread);
        this.kXY = (ImageView) this.ipp.findViewById(R.id.male_icon);
        this.kXZ = (TextView) this.ipp.findViewById(R.id.male_text);
        this.kYa = (ImageView) this.ipp.findViewById(R.id.female_icon);
        this.kYb = (TextView) this.ipp.findViewById(R.id.female_text);
        this.kXY.setOnClickListener(this);
        this.kYa.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kXW, R.color.CAM_X0105);
        ap.setViewTextColor(this.kXX, R.color.CAM_X0109);
        ap.setImageResource(this.kXY, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kXZ, R.color.CAM_X0109);
        ap.setImageResource(this.kYa, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kYb, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kYc = list.get(0).labelId;
            this.kYd = list.get(1).labelId;
        }
    }

    public ViewGroup daM() {
        return this.ipp;
    }

    public int daN() {
        return this.kYe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kXY) {
            z = true;
        } else {
            z = view == this.kYa ? false : false;
        }
        this.kYe = z ? this.kYc : this.kYd;
        ap.setImageResource(this.kXY, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kXZ, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ap.setImageResource(this.kYa, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kYb, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
