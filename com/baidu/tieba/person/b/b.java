package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends j.a {
    private f aFu;
    public TbImageView aSE;
    private View.OnClickListener aYK;
    public View cjd;
    public TextView feL;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aSE = (TbImageView) view.findViewById(d.h.photo_image_view);
        this.aSE.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cjd = view.findViewById(d.h.normal_pic_click_bg);
        this.feL = (TextView) view.findViewById(d.h.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof k) {
            this.aFu = fVar;
            k kVar = (k) fVar;
            if (kVar.Cy()) {
                String dG = o.dG(kVar.getSmallUrl());
                this.feL.setVisibility(0);
                if (StringUtils.isNull(dG)) {
                    this.aSE.setDefaultResource(d.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aSE.c(dG, 25, false);
                }
            } else {
                this.aSE.setDefaultResource(d.g.img_default_100);
                this.feL.setVisibility(8);
                this.aSE.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aYK);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.feL, d.e.cp_cont_g, 1);
            aj.k(this.feL, d.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f xu() {
        return this.aFu;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aYK = onClickListener;
    }
}
