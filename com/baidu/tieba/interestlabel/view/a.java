package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private ViewGroup ewM;
    private TextView hdG;
    private TextView hdH;
    private ImageView hdI;
    private TextView hdJ;
    private ImageView hdK;
    private TextView hdL;
    private int hdM;
    private int hdN;
    private int hdO;

    public a(Context context) {
        this.ewM = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hdG = (TextView) this.ewM.findViewById(R.id.choose_like_label);
        this.hdH = (TextView) this.ewM.findViewById(R.id.recommend_interest_thread);
        this.hdI = (ImageView) this.ewM.findViewById(R.id.male_icon);
        this.hdJ = (TextView) this.ewM.findViewById(R.id.male_text);
        this.hdK = (ImageView) this.ewM.findViewById(R.id.female_icon);
        this.hdL = (TextView) this.ewM.findViewById(R.id.female_text);
        this.hdI.setOnClickListener(this);
        this.hdK.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.j(this.hdG, R.color.cp_cont_b);
        am.j(this.hdH, R.color.cp_cont_d);
        am.c(this.hdI, (int) R.drawable.img_lable_boy_n);
        am.j(this.hdJ, R.color.cp_cont_d);
        am.c(this.hdK, (int) R.drawable.img_lable_girl_n);
        am.j(this.hdL, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.Z(list) == 2) {
            this.hdM = list.get(0).bGk;
            this.hdN = list.get(1).bGk;
        }
    }

    public ViewGroup bKu() {
        return this.ewM;
    }

    public int bKv() {
        return this.hdO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hdI) {
            z = true;
        } else {
            z = view == this.hdK ? false : false;
        }
        this.hdO = z ? this.hdM : this.hdN;
        am.c(this.hdI, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.j(this.hdJ, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.c(this.hdK, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hdL;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.j(textView, i);
    }
}
