package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends z.a {
    public TbImageView aQx;
    public View bYj;
    private View.OnClickListener bkk;
    private v eQO;
    public TextView eQP;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aQx = (TbImageView) view.findViewById(w.h.photo_image_view);
        this.aQx.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bYj = view.findViewById(w.h.normal_pic_click_bg);
        this.eQP = (TextView) view.findViewById(w.h.tip_default_view);
    }

    public void f(v vVar) {
        if (vVar instanceof k) {
            this.eQO = vVar;
            k kVar = (k) vVar;
            if (kVar.Cj()) {
                String dC = s.dC(kVar.getSmallUrl());
                this.eQP.setVisibility(0);
                if (StringUtils.isNull(dC)) {
                    this.aQx.setDefaultResource(w.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aQx.c(dC, 25, false);
                }
            } else {
                this.aQx.setDefaultResource(w.g.img_default_100);
                this.eQP.setVisibility(8);
                this.aQx.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.bkk);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            as.c(this.eQP, w.e.cp_cont_g, 1);
            as.k(this.eQP, w.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wZ() {
        return this.eQO;
    }

    public void v(View.OnClickListener onClickListener) {
        this.bkk = onClickListener;
    }
}
