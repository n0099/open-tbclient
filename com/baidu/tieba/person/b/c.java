package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class c extends af.a {
    private q Wi;
    public TbImageView ZF;
    public View hQI;
    public TextView lmP;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.ZF = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.ZF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hQI = view.findViewById(R.id.normal_pic_click_bg);
        this.lmP = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof n) {
            this.Wi = qVar;
            n nVar = (n) qVar;
            if (nVar.brW()) {
                String As = com.baidu.tbadk.core.util.q.As(nVar.getSmallUrl());
                this.lmP.setVisibility(0);
                if (StringUtils.isNull(As)) {
                    this.ZF.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.ZF.startLoad(As, 25, false);
                }
            } else {
                this.ZF.setDefaultResource(R.drawable.img_default_100);
                this.lmP.setVisibility(8);
                this.ZF.startLoad(nVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.lmP, R.color.cp_cont_g, 1);
            ap.setBackgroundColor(this.lmP, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q qT() {
        return this.Wi;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
