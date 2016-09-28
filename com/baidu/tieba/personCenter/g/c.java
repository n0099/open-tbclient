package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private HeadImageView eFR;
    private HeadImageView eFS;
    private HeadImageView eFT;
    private View mRootView;

    public c(Context context, ViewGroup viewGroup) {
        this.mRootView = LayoutInflater.from(context).inflate(r.h.item_person_center_extra_img_view, (ViewGroup) null);
        this.eFR = (HeadImageView) this.mRootView.findViewById(r.g.person_center_item_extra_img_one);
        this.eFS = (HeadImageView) this.mRootView.findViewById(r.g.person_center_item_extra_img_two);
        this.eFT = (HeadImageView) this.mRootView.findViewById(r.g.person_center_item_extra_img_three);
        viewGroup.addView(this.mRootView);
    }

    public void cE(List<String> list) {
        boolean z = !y.t(list);
        this.mRootView.setVisibility(z ? 0 : 8);
        if (z) {
            if (list.size() > 0) {
                b(this.eFR, list.get(0));
            }
            if (list.size() > 1) {
                b(this.eFS, list.get(1));
            }
            if (list.size() > 2) {
                b(this.eFT, list.get(2));
            }
        }
    }

    private void b(HeadImageView headImageView, String str) {
        if (!StringUtils.isNull(str)) {
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setEvent(new d(this, headImageView));
            headImageView.c(str, 10, false);
        }
    }

    public void onChangeSkinType(int i) {
        av.d(this.eFR, r.f.person_center_item_extra_img_bg, i);
        av.d(this.eFS, r.f.person_center_item_extra_img_bg, i);
        av.d(this.eFT, r.f.person_center_item_extra_img_bg, i);
    }
}
