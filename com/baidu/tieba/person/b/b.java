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
    private f aFr;
    public TbImageView aSB;
    private View.OnClickListener aYH;
    public View cjV;
    public TextView ffE;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aSB = (TbImageView) view.findViewById(d.h.photo_image_view);
        this.aSB.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cjV = view.findViewById(d.h.normal_pic_click_bg);
        this.ffE = (TextView) view.findViewById(d.h.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof k) {
            this.aFr = fVar;
            k kVar = (k) fVar;
            if (kVar.Cy()) {
                String dG = o.dG(kVar.getSmallUrl());
                this.ffE.setVisibility(0);
                if (StringUtils.isNull(dG)) {
                    this.aSB.setDefaultResource(d.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aSB.c(dG, 25, false);
                }
            } else {
                this.aSB.setDefaultResource(d.g.img_default_100);
                this.ffE.setVisibility(8);
                this.aSB.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aYH);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.ffE, d.e.cp_cont_g, 1);
            aj.k(this.ffE, d.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f xu() {
        return this.aFr;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aYH = onClickListener;
    }
}
