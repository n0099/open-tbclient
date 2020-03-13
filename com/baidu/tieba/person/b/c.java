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
/* loaded from: classes11.dex */
public class c extends v.a {
    public TbImageView EB;
    public View gfw;
    private m jgB;
    public TextView jgC;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.EB = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.EB.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gfw = view.findViewById(R.id.normal_pic_click_bg);
        this.jgC = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(m mVar) {
        if (mVar instanceof n) {
            this.jgB = mVar;
            n nVar = (n) mVar;
            if (nVar.aOb()) {
                String tn = o.tn(nVar.getSmallUrl());
                this.jgC.setVisibility(0);
                if (StringUtils.isNull(tn)) {
                    this.EB.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.EB.startLoad(tn, 25, false);
                }
            } else {
                this.EB.setDefaultResource(R.drawable.img_default_100);
                this.jgC.setVisibility(8);
                this.EB.startLoad(nVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jgC, R.color.cp_cont_g, 1);
            am.setBackgroundColor(this.jgC, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m aIy() {
        return this.jgB;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
