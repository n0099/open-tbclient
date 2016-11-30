package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private HeadImageView eMq;
    private HeadImageView eMr;
    private HeadImageView eMs;
    private View mRootView;

    public c(Context context, ViewGroup viewGroup) {
        this.mRootView = LayoutInflater.from(context).inflate(r.h.item_person_center_extra_img_view, (ViewGroup) null);
        this.eMq = (HeadImageView) this.mRootView.findViewById(r.g.person_center_item_extra_img_one);
        this.eMr = (HeadImageView) this.mRootView.findViewById(r.g.person_center_item_extra_img_two);
        this.eMs = (HeadImageView) this.mRootView.findViewById(r.g.person_center_item_extra_img_three);
        viewGroup.addView(this.mRootView);
    }

    public void cG(List<String> list) {
        boolean z = !x.t(list);
        this.mRootView.setVisibility(z ? 0 : 8);
        if (z) {
            if (list.size() > 0) {
                b(this.eMq, list.get(0));
            }
            if (list.size() > 1) {
                b(this.eMr, list.get(1));
            }
            if (list.size() > 2) {
                b(this.eMs, list.get(2));
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
        at.d(this.eMq, r.f.person_center_item_extra_img_bg, i);
        at.d(this.eMr, r.f.person_center_item_extra_img_bg, i);
        at.d(this.eMs, r.f.person_center_item_extra_img_bg, i);
    }
}
