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
    private f aGa;
    public TbImageView aSS;
    private View.OnClickListener aYW;
    public View ceI;
    public TextView feA;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aSS = (TbImageView) view.findViewById(d.h.photo_image_view);
        this.aSS.setDefaultBgResource(d.e.cp_bg_line_e);
        this.ceI = view.findViewById(d.h.normal_pic_click_bg);
        this.feA = (TextView) view.findViewById(d.h.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof k) {
            this.aGa = fVar;
            k kVar = (k) fVar;
            if (kVar.CD()) {
                String dL = n.dL(kVar.getSmallUrl());
                this.feA.setVisibility(0);
                if (StringUtils.isNull(dL)) {
                    this.aSS.setDefaultResource(d.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aSS.c(dL, 25, false);
                }
            } else {
                this.aSS.setDefaultResource(d.g.img_default_100);
                this.feA.setVisibility(8);
                this.aSS.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aYW);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.c(this.feA, d.e.cp_cont_g, 1);
            ai.k(this.feA, d.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f xs() {
        return this.aGa;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aYW = onClickListener;
    }
}
