package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private TextView eMA;
    private ImageView eMB;
    private TextView eMC;
    private int eMD;
    private int eME;
    private int eMF;
    private ViewGroup eMw;
    private TextView eMx;
    private TextView eMy;
    private ImageView eMz;

    public a(Context context) {
        this.eMw = (ViewGroup) LayoutInflater.from(context).inflate(d.h.label_recommend_header, (ViewGroup) null);
        this.eMx = (TextView) this.eMw.findViewById(d.g.choose_like_label);
        this.eMy = (TextView) this.eMw.findViewById(d.g.recommend_interest_thread);
        this.eMz = (ImageView) this.eMw.findViewById(d.g.male_icon);
        this.eMA = (TextView) this.eMw.findViewById(d.g.male_text);
        this.eMB = (ImageView) this.eMw.findViewById(d.g.female_icon);
        this.eMC = (TextView) this.eMw.findViewById(d.g.female_text);
        this.eMz.setOnClickListener(this);
        this.eMB.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.h(this.eMx, d.C0140d.cp_cont_b);
        am.h(this.eMy, d.C0140d.cp_cont_d);
        am.c(this.eMz, d.f.img_lable_boy_n);
        am.h(this.eMA, d.C0140d.cp_cont_d);
        am.c(this.eMB, d.f.img_lable_girl_n);
        am.h(this.eMC, d.C0140d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (w.y(list) == 2) {
            this.eMD = list.get(0).labelId;
            this.eME = list.get(1).labelId;
        }
    }

    public ViewGroup aQu() {
        return this.eMw;
    }

    public int aQv() {
        return this.eMF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eMz) {
            z = true;
        } else {
            z = view == this.eMB ? false : false;
        }
        this.eMF = z ? this.eMD : this.eME;
        am.c(this.eMz, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        am.h(this.eMA, z ? d.C0140d.cp_link_tip_a : d.C0140d.cp_cont_d);
        am.c(this.eMB, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        am.h(this.eMC, z ? d.C0140d.cp_cont_d : d.C0140d.cp_cont_h);
    }
}
