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
    private f aFh;
    public TbImageView aTr;
    public View cqS;
    public TextView fhK;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aTr = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.aTr.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cqS = view.findViewById(d.g.normal_pic_click_bg);
        this.fhK = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof l) {
            this.aFh = fVar;
            l lVar = (l) fVar;
            if (lVar.Cl()) {
                String dE = o.dE(lVar.getSmallUrl());
                this.fhK.setVisibility(0);
                if (StringUtils.isNull(dE)) {
                    this.aTr.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aTr.startLoad(dE, 25, false);
                }
            } else {
                this.aTr.setDefaultResource(d.f.img_default_100);
                this.fhK.setVisibility(8);
                this.aTr.startLoad(lVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.fhK, d.C0080d.cp_cont_g, 1);
            aj.k(this.fhK, d.C0080d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f wT() {
        return this.aFh;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
