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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private ViewGroup ioq;
    private TextView kUA;
    private ImageView kUB;
    private TextView kUC;
    private ImageView kUD;
    private TextView kUE;
    private int kUF;
    private int kUG;
    private int kUH;
    private TextView kUz;

    public a(Context context) {
        this.ioq = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kUz = (TextView) this.ioq.findViewById(R.id.choose_like_label);
        this.kUA = (TextView) this.ioq.findViewById(R.id.recommend_interest_thread);
        this.kUB = (ImageView) this.ioq.findViewById(R.id.male_icon);
        this.kUC = (TextView) this.ioq.findViewById(R.id.male_text);
        this.kUD = (ImageView) this.ioq.findViewById(R.id.female_icon);
        this.kUE = (TextView) this.ioq.findViewById(R.id.female_text);
        this.kUB.setOnClickListener(this);
        this.kUD.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setViewTextColor(this.kUz, R.color.CAM_X0105);
        ao.setViewTextColor(this.kUA, R.color.CAM_X0109);
        ao.setImageResource(this.kUB, R.drawable.img_lable_boy_n);
        ao.setViewTextColor(this.kUC, R.color.CAM_X0109);
        ao.setImageResource(this.kUD, R.drawable.img_lable_girl_n);
        ao.setViewTextColor(this.kUE, R.color.CAM_X0109);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (x.getCount(list) == 2) {
            this.kUF = list.get(0).labelId;
            this.kUG = list.get(1).labelId;
        }
    }

    public ViewGroup dcG() {
        return this.ioq;
    }

    public int dcH() {
        return this.kUH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kUB) {
            z = true;
        } else {
            z = view == this.kUD ? false : false;
        }
        this.kUH = z ? this.kUF : this.kUG;
        ao.setImageResource(this.kUB, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ao.setViewTextColor(this.kUC, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
        ao.setImageResource(this.kUD, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ao.setViewTextColor(this.kUE, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
    }
}
