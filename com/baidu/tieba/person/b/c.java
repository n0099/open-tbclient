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
    public TbImageView bMC;
    public View dwl;
    private i gio;
    public TextView gip;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.bMC = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.bMC.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dwl = view.findViewById(d.g.normal_pic_click_bg);
        this.gip = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void f(i iVar) {
        if (iVar instanceof com.baidu.tbadk.data.i) {
            this.gio = iVar;
            com.baidu.tbadk.data.i iVar2 = (com.baidu.tbadk.data.i) iVar;
            if (iVar2.isPortrait()) {
                String ec = o.ec(iVar2.getSmallUrl());
                this.gip.setVisibility(0);
                if (StringUtils.isNull(ec)) {
                    this.bMC.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.bMC.startLoad(ec, 25, false);
                }
            } else {
                this.bMC.setDefaultResource(d.f.img_default_100);
                this.gip.setVisibility(8);
                this.bMC.startLoad(iVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.e(this.gip, d.C0141d.cp_cont_g, 1);
            aj.t(this.gip, d.C0141d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public i EF() {
        return this.gio;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
