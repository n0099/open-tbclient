package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View cZl;
    public TbImageView eGr;
    private h fPy;
    public TextView fPz;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.eGr = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.eGr.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cZl = view.findViewById(d.g.normal_pic_click_bg);
        this.fPz = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof j) {
            this.fPy = hVar;
            j jVar = (j) hVar;
            if (jVar.isPortrait()) {
                String eu = p.eu(jVar.getSmallUrl());
                this.fPz.setVisibility(0);
                if (StringUtils.isNull(eu)) {
                    this.eGr.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.eGr.startLoad(eu, 25, false);
                }
            } else {
                this.eGr.setDefaultResource(d.f.img_default_100);
                this.fPz.setVisibility(8);
                this.eGr.startLoad(jVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fPz, d.C0141d.cp_cont_g, 1);
            al.j(this.fPz, d.C0141d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h AQ() {
        return this.fPy;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
