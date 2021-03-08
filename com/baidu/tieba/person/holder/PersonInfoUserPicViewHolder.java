package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.data.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    private n YL;
    public TbImageView acX;
    public View iYT;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public TextView muX;

    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.acX = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.acX.setDefaultBgResource(R.color.CAM_X0205);
        this.iYT = view.findViewById(R.id.normal_pic_click_bg);
        this.muX = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(n nVar) {
        if (nVar instanceof o) {
            this.YL = nVar;
            o oVar = (o) nVar;
            if (oVar.bAL()) {
                String Bc = r.Bc(oVar.getSmallUrl());
                this.muX.setVisibility(0);
                if (StringUtils.isNull(Bc)) {
                    this.acX.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.acX.startLoad(Bc, 25, false);
                }
            } else {
                this.acX.setDefaultResource(R.drawable.img_default_100);
                this.muX.setVisibility(8);
                this.acX.startLoad(oVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.muX, R.color.CAM_X0111, 1);
            ap.setBackgroundColor(this.muX, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public n qv() {
        return this.YL;
    }

    public void I(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
