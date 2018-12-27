package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View dyt;
    public TbImageView fod;
    private h gtB;
    public TextView gtC;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.fod = (TbImageView) view.findViewById(e.g.photo_image_view);
        this.fod.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dyt = view.findViewById(e.g.normal_pic_click_bg);
        this.gtC = (TextView) view.findViewById(e.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof k) {
            this.gtB = hVar;
            k kVar = (k) hVar;
            if (kVar.isPortrait()) {
                String fu = o.fu(kVar.getSmallUrl());
                this.gtC.setVisibility(0);
                if (StringUtils.isNull(fu)) {
                    this.fod.setDefaultResource(e.f.pic_mycenter_avatar_def_i);
                } else {
                    this.fod.startLoad(fu, 25, false);
                }
            } else {
                this.fod.setDefaultResource(e.f.img_default_100);
                this.gtC.setVisibility(8);
                this.fod.startLoad(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.gtC, e.d.cp_cont_g, 1);
            al.j(this.gtC, e.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h FC() {
        return this.gtB;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
