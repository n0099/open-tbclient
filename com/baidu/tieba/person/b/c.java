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
    public View dob;
    public TbImageView fda;
    private h giy;
    public TextView giz;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.fda = (TbImageView) view.findViewById(e.g.photo_image_view);
        this.fda.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dob = view.findViewById(e.g.normal_pic_click_bg);
        this.giz = (TextView) view.findViewById(e.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof k) {
            this.giy = hVar;
            k kVar = (k) hVar;
            if (kVar.isPortrait()) {
                String fc = o.fc(kVar.getSmallUrl());
                this.giz.setVisibility(0);
                if (StringUtils.isNull(fc)) {
                    this.fda.setDefaultResource(e.f.pic_mycenter_avatar_def_i);
                } else {
                    this.fda.startLoad(fc, 25, false);
                }
            } else {
                this.fda.setDefaultResource(e.f.img_default_100);
                this.giz.setVisibility(8);
                this.fda.startLoad(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.giz, e.d.cp_cont_g, 1);
            al.j(this.giz, e.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h En() {
        return this.giy;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
