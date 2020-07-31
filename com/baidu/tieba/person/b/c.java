package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class c extends ad.a {
    private q Vm;
    public TbImageView YF;
    public View hwm;
    public TextView kNZ;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.YF = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.YF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hwm = view.findViewById(R.id.normal_pic_click_bg);
        this.kNZ = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof m) {
            this.Vm = qVar;
            m mVar = (m) qVar;
            if (mVar.bip()) {
                String xH = com.baidu.tbadk.core.util.q.xH(mVar.getSmallUrl());
                this.kNZ.setVisibility(0);
                if (StringUtils.isNull(xH)) {
                    this.YF.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.YF.startLoad(xH, 25, false);
                }
            } else {
                this.YF.setDefaultResource(R.drawable.img_default_100);
                this.kNZ.setVisibility(8);
                this.YF.startLoad(mVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.kNZ, R.color.cp_cont_g, 1);
            ao.setBackgroundColor(this.kNZ, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q pp() {
        return this.Vm;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
