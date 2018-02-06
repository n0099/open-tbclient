package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends r.a {
    public TbImageView bMP;
    public View dwx;
    public TextView giA;
    private i giz;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.bMP = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.bMP.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dwx = view.findViewById(d.g.normal_pic_click_bg);
        this.giA = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void f(i iVar) {
        if (iVar instanceof com.baidu.tbadk.data.i) {
            this.giz = iVar;
            com.baidu.tbadk.data.i iVar2 = (com.baidu.tbadk.data.i) iVar;
            if (iVar2.isPortrait()) {
                String ec = o.ec(iVar2.getSmallUrl());
                this.giA.setVisibility(0);
                if (StringUtils.isNull(ec)) {
                    this.bMP.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.bMP.startLoad(ec, 25, false);
                }
            } else {
                this.bMP.setDefaultResource(d.f.img_default_100);
                this.giA.setVisibility(8);
                this.bMP.startLoad(iVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.e(this.giA, d.C0140d.cp_cont_g, 1);
            aj.t(this.giA, d.C0140d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public i EG() {
        return this.giz;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
