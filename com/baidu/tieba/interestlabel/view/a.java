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
    private ViewGroup hQU;
    private TextView kBA;
    private TextView kBB;
    private ImageView kBC;
    private TextView kBD;
    private ImageView kBE;
    private TextView kBF;
    private int kBG;
    private int kBH;
    private int kBI;

    public a(Context context) {
        this.hQU = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kBA = (TextView) this.hQU.findViewById(R.id.choose_like_label);
        this.kBB = (TextView) this.hQU.findViewById(R.id.recommend_interest_thread);
        this.kBC = (ImageView) this.hQU.findViewById(R.id.male_icon);
        this.kBD = (TextView) this.hQU.findViewById(R.id.male_text);
        this.kBE = (ImageView) this.hQU.findViewById(R.id.female_icon);
        this.kBF = (TextView) this.hQU.findViewById(R.id.female_text);
        this.kBC.setOnClickListener(this);
        this.kBE.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kBA, R.color.CAM_X0105);
        ap.setViewTextColor(this.kBB, R.color.CAM_X0109);
        ap.setImageResource(this.kBC, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kBD, R.color.CAM_X0109);
        ap.setImageResource(this.kBE, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kBF, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kBG = list.get(0).labelId;
            this.kBH = list.get(1).labelId;
        }
    }

    public ViewGroup cXJ() {
        return this.hQU;
    }

    public int cXK() {
        return this.kBI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kBC) {
            z = true;
        } else {
            z = view == this.kBE ? false : false;
        }
        this.kBI = z ? this.kBG : this.kBH;
        ap.setImageResource(this.kBC, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kBD, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ap.setImageResource(this.kBE, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kBF, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
