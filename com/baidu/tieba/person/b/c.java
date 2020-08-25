package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class c extends af.a {
    private q VP;
    public TbImageView Zl;
    public View hJB;
    public TextView ldR;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Zl = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.Zl.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hJB = view.findViewById(R.id.normal_pic_click_bg);
        this.ldR = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof m) {
            this.VP = qVar;
            m mVar = (m) qVar;
            if (mVar.brb()) {
                String zV = com.baidu.tbadk.core.util.q.zV(mVar.getSmallUrl());
                this.ldR.setVisibility(0);
                if (StringUtils.isNull(zV)) {
                    this.Zl.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.Zl.startLoad(zV, 25, false);
                }
            } else {
                this.Zl.setDefaultResource(R.drawable.img_default_100);
                this.ldR.setVisibility(8);
                this.Zl.startLoad(mVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ldR, R.color.cp_cont_g, 1);
            ap.setBackgroundColor(this.ldR, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q qO() {
        return this.VP;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
