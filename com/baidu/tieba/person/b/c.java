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
    public View dad;
    public TbImageView eOb;
    private h fTN;
    public TextView fTO;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.eOb = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.eOb.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dad = view.findViewById(d.g.normal_pic_click_bg);
        this.fTO = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof j) {
            this.fTN = hVar;
            j jVar = (j) hVar;
            if (jVar.isPortrait()) {
                String ev = p.ev(jVar.getSmallUrl());
                this.fTO.setVisibility(0);
                if (StringUtils.isNull(ev)) {
                    this.eOb.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.eOb.startLoad(ev, 25, false);
                }
            } else {
                this.eOb.setDefaultResource(d.f.img_default_100);
                this.fTO.setVisibility(8);
                this.eOb.startLoad(jVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fTO, d.C0140d.cp_cont_g, 1);
            am.j(this.fTO, d.C0140d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h AZ() {
        return this.fTN;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
