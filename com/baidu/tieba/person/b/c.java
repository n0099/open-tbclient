package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends j.a {
    private f aFQ;
    public TbImageView aWA;
    public View czW;
    public TextView fre;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aWA = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.aWA.setDefaultBgResource(d.C0082d.cp_bg_line_e);
        this.czW = view.findViewById(d.g.normal_pic_click_bg);
        this.fre = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof l) {
            this.aFQ = fVar;
            l lVar = (l) fVar;
            if (lVar.CG()) {
                String dE = o.dE(lVar.getSmallUrl());
                this.fre.setVisibility(0);
                if (StringUtils.isNull(dE)) {
                    this.aWA.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aWA.startLoad(dE, 25, false);
                }
            } else {
                this.aWA.setDefaultResource(d.f.img_default_100);
                this.fre.setVisibility(8);
                this.aWA.startLoad(lVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.fre, d.C0082d.cp_cont_g, 1);
            aj.k(this.fre, d.C0082d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f wU() {
        return this.aFQ;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
