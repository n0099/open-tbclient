package com.baidu.tieba.personCenter.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private HeadImageView eDv;
    private HeadImageView eDw;
    private HeadImageView eDx;
    private View mRootView;

    public c(Context context, ViewGroup viewGroup) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.item_person_center_extra_img_view, (ViewGroup) null);
        this.eDv = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_one);
        this.eDw = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_two);
        this.eDx = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_three);
        viewGroup.addView(this.mRootView);
    }

    public void ci(List<String> list) {
        boolean z = !x.q(list);
        this.mRootView.setVisibility(z ? 0 : 8);
        if (z) {
            if (list.size() > 0) {
                b(this.eDv, list.get(0));
            }
            if (list.size() > 1) {
                b(this.eDw, list.get(1));
            }
            if (list.size() > 2) {
                b(this.eDx, list.get(2));
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
        aq.d(this.eDv, w.g.person_center_item_extra_img_bg, i);
        aq.d(this.eDw, w.g.person_center_item_extra_img_bg, i);
        aq.d(this.eDx, w.g.person_center_item_extra_img_bg, i);
    }
}
