package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View cXo;
    public TbImageView eKh;
    private h fTA;
    public TextView fTB;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.eKh = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.eKh.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cXo = view.findViewById(d.g.normal_pic_click_bg);
        this.fTB = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof j) {
            this.fTA = hVar;
            j jVar = (j) hVar;
            if (jVar.isPortrait()) {
                String ex = p.ex(jVar.getSmallUrl());
                this.fTB.setVisibility(0);
                if (StringUtils.isNull(ex)) {
                    this.eKh.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.eKh.startLoad(ex, 25, false);
                }
            } else {
                this.eKh.setDefaultResource(d.f.img_default_100);
                this.fTB.setVisibility(8);
                this.eKh.startLoad(jVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fTB, d.C0142d.cp_cont_g, 1);
            am.j(this.fTB, d.C0142d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h Bi() {
        return this.fTA;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
