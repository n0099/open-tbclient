package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private int eMA;
    private ViewGroup eMr;
    private TextView eMs;
    private TextView eMt;
    private ImageView eMu;
    private TextView eMv;
    private ImageView eMw;
    private TextView eMx;
    private int eMy;
    private int eMz;

    public a(Context context) {
        this.eMr = (ViewGroup) LayoutInflater.from(context).inflate(f.h.label_recommend_header, (ViewGroup) null);
        this.eMs = (TextView) this.eMr.findViewById(f.g.choose_like_label);
        this.eMt = (TextView) this.eMr.findViewById(f.g.recommend_interest_thread);
        this.eMu = (ImageView) this.eMr.findViewById(f.g.male_icon);
        this.eMv = (TextView) this.eMr.findViewById(f.g.male_text);
        this.eMw = (ImageView) this.eMr.findViewById(f.g.female_icon);
        this.eMx = (TextView) this.eMr.findViewById(f.g.female_text);
        this.eMu.setOnClickListener(this);
        this.eMw.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.h(this.eMs, f.d.cp_cont_b);
        am.h(this.eMt, f.d.cp_cont_d);
        am.c(this.eMu, f.C0146f.img_lable_boy_n);
        am.h(this.eMv, f.d.cp_cont_d);
        am.c(this.eMw, f.C0146f.img_lable_girl_n);
        am.h(this.eMx, f.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (w.y(list) == 2) {
            this.eMy = list.get(0).labelId;
            this.eMz = list.get(1).labelId;
        }
    }

    public ViewGroup aQr() {
        return this.eMr;
    }

    public int aQs() {
        return this.eMA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eMu) {
            z = true;
        } else {
            z = view == this.eMw ? false : false;
        }
        this.eMA = z ? this.eMy : this.eMz;
        am.c(this.eMu, z ? f.C0146f.img_lable_boy_s : f.C0146f.img_lable_boy_n);
        am.h(this.eMv, z ? f.d.cp_link_tip_a : f.d.cp_cont_d);
        am.c(this.eMw, z ? f.C0146f.img_lable_girl_n : f.C0146f.img_lable_girl_s);
        am.h(this.eMx, z ? f.d.cp_cont_d : f.d.cp_cont_h);
    }
}
