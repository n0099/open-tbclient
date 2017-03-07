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
    private HeadImageView eDi;
    private HeadImageView eDj;
    private HeadImageView eDk;
    private View mRootView;

    public c(Context context, ViewGroup viewGroup) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.item_person_center_extra_img_view, (ViewGroup) null);
        this.eDi = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_one);
        this.eDj = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_two);
        this.eDk = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_three);
        viewGroup.addView(this.mRootView);
    }

    public void ci(List<String> list) {
        boolean z = !x.q(list);
        this.mRootView.setVisibility(z ? 0 : 8);
        if (z) {
            if (list.size() > 0) {
                b(this.eDi, list.get(0));
            }
            if (list.size() > 1) {
                b(this.eDj, list.get(1));
            }
            if (list.size() > 2) {
                b(this.eDk, list.get(2));
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
        aq.d(this.eDi, w.g.person_center_item_extra_img_bg, i);
        aq.d(this.eDj, w.g.person_center_item_extra_img_bg, i);
        aq.d(this.eDk, w.g.person_center_item_extra_img_bg, i);
    }
}
