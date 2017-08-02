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
    private f aEK;
    public TbImageView aRG;
    private View.OnClickListener aXL;
    public View cdC;
    public TextView fdo;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aRG = (TbImageView) view.findViewById(d.h.photo_image_view);
        this.aRG.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cdC = view.findViewById(d.h.normal_pic_click_bg);
        this.fdo = (TextView) view.findViewById(d.h.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof k) {
            this.aEK = fVar;
            k kVar = (k) fVar;
            if (kVar.Cv()) {
                String dF = n.dF(kVar.getSmallUrl());
                this.fdo.setVisibility(0);
                if (StringUtils.isNull(dF)) {
                    this.aRG.setDefaultResource(d.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aRG.c(dF, 25, false);
                }
            } else {
                this.aRG.setDefaultResource(d.g.img_default_100);
                this.fdo.setVisibility(8);
                this.aRG.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aXL);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.c(this.fdo, d.e.cp_cont_g, 1);
            ai.k(this.fdo, d.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f xk() {
        return this.aEK;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aXL = onClickListener;
    }
}
