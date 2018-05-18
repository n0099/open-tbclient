package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View cQg;
    public TbImageView eva;
    private h fEe;
    public TextView fEf;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.eva = (TbImageView) view2.findViewById(d.g.photo_image_view);
        this.eva.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cQg = view2.findViewById(d.g.normal_pic_click_bg);
        this.fEf = (TextView) view2.findViewById(d.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof i) {
            this.fEe = hVar;
            i iVar = (i) hVar;
            if (iVar.isPortrait()) {
                String dU = o.dU(iVar.getSmallUrl());
                this.fEf.setVisibility(0);
                if (StringUtils.isNull(dU)) {
                    this.eva.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.eva.startLoad(dU, 25, false);
                }
            } else {
                this.eva.setDefaultResource(d.f.img_default_100);
                this.fEf.setVisibility(8);
                this.eva.startLoad(iVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.fEf, d.C0126d.cp_cont_g, 1);
            ak.j(this.fEf, d.C0126d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h xp() {
        return this.fEe;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
