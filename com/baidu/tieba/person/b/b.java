package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends j.a {
    private f aGc;
    public TbImageView aSU;
    private View.OnClickListener aYY;
    public View cfv;
    public TextView fgv;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aSU = (TbImageView) view.findViewById(d.h.photo_image_view);
        this.aSU.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cfv = view.findViewById(d.h.normal_pic_click_bg);
        this.fgv = (TextView) view.findViewById(d.h.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof k) {
            this.aGc = fVar;
            k kVar = (k) fVar;
            if (kVar.CD()) {
                String dP = n.dP(kVar.getSmallUrl());
                this.fgv.setVisibility(0);
                if (StringUtils.isNull(dP)) {
                    this.aSU.setDefaultResource(d.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aSU.c(dP, 25, false);
                }
            } else {
                this.aSU.setDefaultResource(d.g.img_default_100);
                this.fgv.setVisibility(8);
                this.aSU.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aYY);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.c(this.fgv, d.e.cp_cont_g, 1);
            ai.k(this.fgv, d.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f xs() {
        return this.aGc;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aYY = onClickListener;
    }
}
