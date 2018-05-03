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
    public View cOZ;
    public TbImageView etS;
    private h fCY;
    public TextView fCZ;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.etS = (TbImageView) view2.findViewById(d.g.photo_image_view);
        this.etS.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cOZ = view2.findViewById(d.g.normal_pic_click_bg);
        this.fCZ = (TextView) view2.findViewById(d.g.tip_default_view);
    }

    public void g(h hVar) {
        if (hVar instanceof i) {
            this.fCY = hVar;
            i iVar = (i) hVar;
            if (iVar.isPortrait()) {
                String dU = o.dU(iVar.getSmallUrl());
                this.fCZ.setVisibility(0);
                if (StringUtils.isNull(dU)) {
                    this.etS.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.etS.startLoad(dU, 25, false);
                }
            } else {
                this.etS.setDefaultResource(d.f.img_default_100);
                this.fCZ.setVisibility(8);
                this.etS.startLoad(iVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.fCZ, d.C0126d.cp_cont_g, 1);
            ak.j(this.fCZ, d.C0126d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public h xq() {
        return this.fCY;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
