package com.baidu.tieba.personCenter.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private HeadImageView ezJ;
    private HeadImageView ezK;
    private HeadImageView ezL;
    private View mRootView;

    public c(Context context, ViewGroup viewGroup) {
        this.mRootView = LayoutInflater.from(context).inflate(r.j.item_person_center_extra_img_view, (ViewGroup) null);
        this.ezJ = (HeadImageView) this.mRootView.findViewById(r.h.person_center_item_extra_img_one);
        this.ezK = (HeadImageView) this.mRootView.findViewById(r.h.person_center_item_extra_img_two);
        this.ezL = (HeadImageView) this.mRootView.findViewById(r.h.person_center_item_extra_img_three);
        viewGroup.addView(this.mRootView);
    }

    public void cB(List<String> list) {
        boolean z = !w.s(list);
        this.mRootView.setVisibility(z ? 0 : 8);
        if (z) {
            if (list.size() > 0) {
                b(this.ezJ, list.get(0));
            }
            if (list.size() > 1) {
                b(this.ezK, list.get(1));
            }
            if (list.size() > 2) {
                b(this.ezL, list.get(2));
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
        ap.d(this.ezJ, r.g.person_center_item_extra_img_bg, i);
        ap.d(this.ezK, r.g.person_center_item_extra_img_bg, i);
        ap.d(this.ezL, r.g.person_center_item_extra_img_bg, i);
    }
}
