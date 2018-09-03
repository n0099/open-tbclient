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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View cZZ;
    public TbImageView eNW;
    private h fTF;
    public TextView fTG;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.eNW = (TbImageView) view.findViewById(f.g.photo_image_view);
        this.eNW.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cZZ = view.findViewById(f.g.normal_pic_click_bg);
        this.fTG = (TextView) view.findViewById(f.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof j) {
            this.fTF = hVar;
            j jVar = (j) hVar;
            if (jVar.isPortrait()) {
                String ev = p.ev(jVar.getSmallUrl());
                this.fTG.setVisibility(0);
                if (StringUtils.isNull(ev)) {
                    this.eNW.setDefaultResource(f.C0146f.pic_mycenter_avatar_def_i);
                } else {
                    this.eNW.startLoad(ev, 25, false);
                }
            } else {
                this.eNW.setDefaultResource(f.C0146f.img_default_100);
                this.fTG.setVisibility(8);
                this.eNW.startLoad(jVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fTG, f.d.cp_cont_g, 1);
            am.j(this.fTG, f.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h AW() {
        return this.fTF;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
