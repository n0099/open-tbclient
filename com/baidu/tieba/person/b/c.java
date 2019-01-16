package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View dzc;
    public TbImageView foX;
    private h guF;
    public TextView guG;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.foX = (TbImageView) view.findViewById(e.g.photo_image_view);
        this.foX.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dzc = view.findViewById(e.g.normal_pic_click_bg);
        this.guG = (TextView) view.findViewById(e.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof m) {
            this.guF = hVar;
            m mVar = (m) hVar;
            if (mVar.isPortrait()) {
                String fH = o.fH(mVar.getSmallUrl());
                this.guG.setVisibility(0);
                if (StringUtils.isNull(fH)) {
                    this.foX.setDefaultResource(e.f.pic_mycenter_avatar_def_i);
                } else {
                    this.foX.startLoad(fH, 25, false);
                }
            } else {
                this.foX.setDefaultResource(e.f.img_default_100);
                this.guG.setVisibility(8);
                this.foX.startLoad(mVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.guG, e.d.cp_cont_g, 1);
            al.j(this.guG, e.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h FP() {
        return this.guF;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
