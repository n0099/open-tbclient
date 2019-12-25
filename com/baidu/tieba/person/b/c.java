package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends v.a {
    public TbImageView Ed;
    public View fZW;
    private m jbJ;
    public TextView jbK;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Ed = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.Ed.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fZW = view.findViewById(R.id.normal_pic_click_bg);
        this.jbK = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(m mVar) {
        if (mVar instanceof n) {
            this.jbJ = mVar;
            n nVar = (n) mVar;
            if (nVar.aLj()) {
                String sU = o.sU(nVar.getSmallUrl());
                this.jbK.setVisibility(0);
                if (StringUtils.isNull(sU)) {
                    this.Ed.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.Ed.startLoad(sU, 25, false);
                }
            } else {
                this.Ed.setDefaultResource(R.drawable.img_default_100);
                this.jbK.setVisibility(8);
                this.Ed.startLoad(nVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jbK, R.color.cp_cont_g, 1);
            am.setBackgroundColor(this.jbK, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m aFN() {
        return this.jbJ;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
