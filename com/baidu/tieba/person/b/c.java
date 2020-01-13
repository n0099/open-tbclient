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
/* loaded from: classes9.dex */
public class c extends v.a {
    public TbImageView Ei;
    public View gdg;
    private m jfm;
    public TextView jfn;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Ei = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.Ei.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gdg = view.findViewById(R.id.normal_pic_click_bg);
        this.jfn = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(m mVar) {
        if (mVar instanceof n) {
            this.jfm = mVar;
            n nVar = (n) mVar;
            if (nVar.aLC()) {
                String sX = o.sX(nVar.getSmallUrl());
                this.jfn.setVisibility(0);
                if (StringUtils.isNull(sX)) {
                    this.Ei.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.Ei.startLoad(sX, 25, false);
                }
            } else {
                this.Ei.setDefaultResource(R.drawable.img_default_100);
                this.jfn.setVisibility(8);
                this.Ei.startLoad(nVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jfn, R.color.cp_cont_g, 1);
            am.setBackgroundColor(this.jfn, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m aGg() {
        return this.jfm;
    }

    public void C(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
