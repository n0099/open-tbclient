package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    private n Xw;
    public TbImageView abG;
    public View iRp;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public TextView mjE;

    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.abG = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.abG.setDefaultBgResource(R.color.CAM_X0205);
        this.iRp = view.findViewById(R.id.normal_pic_click_bg);
        this.mjE = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(n nVar) {
        if (nVar instanceof o) {
            this.Xw = nVar;
            o oVar = (o) nVar;
            if (oVar.bAq()) {
                String AE = q.AE(oVar.getSmallUrl());
                this.mjE.setVisibility(0);
                if (StringUtils.isNull(AE)) {
                    this.abG.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.abG.startLoad(AE, 25, false);
                }
            } else {
                this.abG.setDefaultResource(R.drawable.img_default_100);
                this.mjE.setVisibility(8);
                this.abG.startLoad(oVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.mjE, R.color.CAM_X0111, 1);
            ao.setBackgroundColor(this.mjE, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public n qx() {
        return this.Xw;
    }

    public void H(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
