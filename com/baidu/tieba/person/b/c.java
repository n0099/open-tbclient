package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends v.a {
    public TbImageView Bx;
    public View fly;
    private m ijS;
    public TextView ijT;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Bx = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.Bx.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fly = view.findViewById(R.id.normal_pic_click_bg);
        this.ijT = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(m mVar) {
        if (mVar instanceof com.baidu.tbadk.data.m) {
            this.ijS = mVar;
            com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
            if (mVar2.atE()) {
                String nK = o.nK(mVar2.getSmallUrl());
                this.ijT.setVisibility(0);
                if (StringUtils.isNull(nK)) {
                    this.Bx.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.Bx.startLoad(nK, 25, false);
                }
            } else {
                this.Bx.setDefaultResource(R.drawable.img_default_100);
                this.ijT.setVisibility(8);
                this.Bx.startLoad(mVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.ijT, R.color.cp_cont_g, 1);
            am.setBackgroundColor(this.ijT, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m aok() {
        return this.ijS;
    }

    public void C(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
