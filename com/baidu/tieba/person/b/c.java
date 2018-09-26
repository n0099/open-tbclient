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
    public View dfW;
    public TbImageView eVr;
    private h gaV;
    public TextView gaW;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.eVr = (TbImageView) view.findViewById(e.g.photo_image_view);
        this.eVr.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dfW = view.findViewById(e.g.normal_pic_click_bg);
        this.gaW = (TextView) view.findViewById(e.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof k) {
            this.gaV = hVar;
            k kVar = (k) hVar;
            if (kVar.isPortrait()) {
                String eN = o.eN(kVar.getSmallUrl());
                this.gaW.setVisibility(0);
                if (StringUtils.isNull(eN)) {
                    this.eVr.setDefaultResource(e.f.pic_mycenter_avatar_def_i);
                } else {
                    this.eVr.startLoad(eN, 25, false);
                }
            } else {
                this.eVr.setDefaultResource(e.f.img_default_100);
                this.gaW.setVisibility(8);
                this.eVr.startLoad(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.gaW, e.d.cp_cont_g, 1);
            al.j(this.gaW, e.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h Ci() {
        return this.gaV;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
