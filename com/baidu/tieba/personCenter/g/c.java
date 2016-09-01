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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private HeadImageView eDN;
    private HeadImageView eDO;
    private HeadImageView eDP;
    private View mRootView;

    public c(Context context, ViewGroup viewGroup) {
        this.mRootView = LayoutInflater.from(context).inflate(t.h.item_person_center_extra_img_view, (ViewGroup) null);
        this.eDN = (HeadImageView) this.mRootView.findViewById(t.g.person_center_item_extra_img_one);
        this.eDO = (HeadImageView) this.mRootView.findViewById(t.g.person_center_item_extra_img_two);
        this.eDP = (HeadImageView) this.mRootView.findViewById(t.g.person_center_item_extra_img_three);
        viewGroup.addView(this.mRootView);
    }

    public void cD(List<String> list) {
        boolean z = !y.t(list);
        this.mRootView.setVisibility(z ? 0 : 8);
        if (z) {
            if (list.size() > 0) {
                b(this.eDN, list.get(0));
            }
            if (list.size() > 1) {
                b(this.eDO, list.get(1));
            }
            if (list.size() > 2) {
                b(this.eDP, list.get(2));
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
        av.d(this.eDN, t.f.person_center_item_extra_img_bg, i);
        av.d(this.eDO, t.f.person_center_item_extra_img_bg, i);
        av.d(this.eDP, t.f.person_center_item_extra_img_bg, i);
    }
}
