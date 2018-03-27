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
    public TbImageView bMF;
    public View dwo;
    private i giE;
    public TextView giF;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.bMF = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.bMF.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dwo = view.findViewById(d.g.normal_pic_click_bg);
        this.giF = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void f(i iVar) {
        if (iVar instanceof com.baidu.tbadk.data.i) {
            this.giE = iVar;
            com.baidu.tbadk.data.i iVar2 = (com.baidu.tbadk.data.i) iVar;
            if (iVar2.isPortrait()) {
                String ec = o.ec(iVar2.getSmallUrl());
                this.giF.setVisibility(0);
                if (StringUtils.isNull(ec)) {
                    this.bMF.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.bMF.startLoad(ec, 25, false);
                }
            } else {
                this.bMF.setDefaultResource(d.f.img_default_100);
                this.giF.setVisibility(8);
                this.bMF.startLoad(iVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.e(this.giF, d.C0141d.cp_cont_g, 1);
            aj.t(this.giF, d.C0141d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public i EG() {
        return this.giE;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
