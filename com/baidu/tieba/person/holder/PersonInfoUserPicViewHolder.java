package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.m0.t.o;
/* loaded from: classes5.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f19636a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19637b;

    /* renamed from: c  reason: collision with root package name */
    public View f19638c;

    /* renamed from: d  reason: collision with root package name */
    public n f19639d;

    /* renamed from: e  reason: collision with root package name */
    public int f19640e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19641f;

    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        this.f19640e = 3;
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.f19636a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f19638c = view.findViewById(R.id.normal_pic_click_bg);
        this.f19637b = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void b(n nVar) {
        if (nVar instanceof o) {
            this.f19639d = nVar;
            o oVar = (o) nVar;
            if (oVar.f()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(oVar.e());
                this.f19637b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.f19636a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.f19636a.V(headPortraitFilter, 25, false);
                }
            } else {
                this.f19636a.setDefaultResource(R.drawable.img_default_100);
                this.f19637b.setVisibility(8);
                this.f19636a.V(oVar.e(), 10, false);
            }
            a().setOnClickListener(this.f19641f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f19639d;
    }

    public void d(int i2) {
        if (this.f19640e != i2) {
            SkinManager.setViewTextColor(this.f19637b, R.color.CAM_X0111, 1);
            SkinManager.setBackgroundColor(this.f19637b, R.color.black_alpha50);
            this.f19640e = i2;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f19641f = onClickListener;
    }
}
