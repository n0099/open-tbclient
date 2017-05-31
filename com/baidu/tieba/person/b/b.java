package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends z.a {
    public TbImageView aPf;
    private View.OnClickListener bhc;
    private v eGZ;
    public TextView eHa;
    public View eHb;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aPf = (TbImageView) view.findViewById(w.h.photo_image_view);
        this.aPf.setDefaultBgResource(w.e.cp_bg_line_e);
        this.eHb = view.findViewById(w.h.normal_pic_click_bg);
        this.eHa = (TextView) view.findViewById(w.h.tip_default_view);
    }

    public void f(v vVar) {
        if (vVar instanceof k) {
            this.eGZ = vVar;
            k kVar = (k) vVar;
            if (kVar.BP()) {
                String di = q.di(kVar.getSmallUrl());
                this.eHa.setVisibility(0);
                if (StringUtils.isNull(di)) {
                    this.aPf.setDefaultResource(w.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aPf.c(di, 25, false);
                }
            } else {
                this.aPf.setDefaultResource(w.g.img_default_100);
                this.eHa.setVisibility(8);
                this.aPf.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.bhc);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.c(this.eHa, w.e.cp_cont_g, 1);
            aq.k(this.eHa, w.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wH() {
        return this.eGZ;
    }

    public void u(View.OnClickListener onClickListener) {
        this.bhc = onClickListener;
    }
}
