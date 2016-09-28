package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends y.a {
    public TbImageView aKh;
    private View.OnClickListener ahN;
    private v eEL;
    public TextView eEM;
    public View eEN;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.mSkinType = 3;
        this.aKh = (TbImageView) view.findViewById(r.g.photo_image_view);
        this.aKh.setDefaultBgResource(r.d.cp_bg_line_e);
        this.eEN = view.findViewById(r.g.normal_pic_click_bg);
        this.eEM = (TextView) view.findViewById(r.g.tip_default_view);
    }

    public void c(v vVar) {
        if (vVar instanceof k) {
            this.eEL = vVar;
            k kVar = (k) vVar;
            if (kVar.Ci()) {
                String dm = q.dm(kVar.getSmallUrl());
                this.eEM.setVisibility(0);
                if (StringUtils.isNull(dm)) {
                    this.aKh.setDefaultResource(r.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aKh.c(dm, 25, false);
                }
            } else {
                this.aKh.setDefaultResource(r.f.img_default_100);
                this.eEM.setVisibility(8);
                this.aKh.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.ahN);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.c(this.eEM, r.d.cp_cont_g, 1);
            av.l(this.eEM, r.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wV() {
        return this.eEL;
    }

    public void G(View.OnClickListener onClickListener) {
        this.ahN = onClickListener;
    }
}
