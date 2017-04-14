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
    private HeadImageView eBf;
    private HeadImageView eBg;
    private HeadImageView eBh;
    private View mRootView;

    public c(Context context, ViewGroup viewGroup) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.item_person_center_extra_img_view, (ViewGroup) null);
        this.eBf = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_one);
        this.eBg = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_two);
        this.eBh = (HeadImageView) this.mRootView.findViewById(w.h.person_center_item_extra_img_three);
        viewGroup.addView(this.mRootView);
    }

    public void ch(List<String> list) {
        boolean z = !x.q(list);
        this.mRootView.setVisibility(z ? 0 : 8);
        if (z) {
            if (list.size() > 0) {
                b(this.eBf, list.get(0));
            }
            if (list.size() > 1) {
                b(this.eBg, list.get(1));
            }
            if (list.size() > 2) {
                b(this.eBh, list.get(2));
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
        aq.d(this.eBf, w.g.person_center_item_extra_img_bg, i);
        aq.d(this.eBg, w.g.person_center_item_extra_img_bg, i);
        aq.d(this.eBh, w.g.person_center_item_extra_img_bg, i);
    }
}
