package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends y.a {
    public TbImageView aOv;
    private View.OnClickListener aRG;
    private v eCj;
    public TextView eCk;
    public View eCl;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.mSkinType = 3;
        this.aOv = (TbImageView) view.findViewById(w.h.photo_image_view);
        this.aOv.setDefaultBgResource(w.e.cp_bg_line_e);
        this.eCl = view.findViewById(w.h.normal_pic_click_bg);
        this.eCk = (TextView) view.findViewById(w.h.tip_default_view);
    }

    public void e(v vVar) {
        if (vVar instanceof k) {
            this.eCj = vVar;
            k kVar = (k) vVar;
            if (kVar.Cs()) {
                String dg = q.dg(kVar.getSmallUrl());
                this.eCk.setVisibility(0);
                if (StringUtils.isNull(dg)) {
                    this.aOv.setDefaultResource(w.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aOv.c(dg, 25, false);
                }
            } else {
                this.aOv.setDefaultResource(w.g.img_default_100);
                this.eCk.setVisibility(8);
                this.aOv.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aRG);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.c(this.eCk, w.e.cp_cont_g, 1);
            aq.k(this.eCk, w.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v xb() {
        return this.eCj;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aRG = onClickListener;
    }
}
