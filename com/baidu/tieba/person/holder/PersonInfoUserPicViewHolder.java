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
import d.a.c.k.e.n;
import d.a.n0.t.o;
/* loaded from: classes5.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f19795a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19796b;

    /* renamed from: c  reason: collision with root package name */
    public View f19797c;

    /* renamed from: d  reason: collision with root package name */
    public n f19798d;

    /* renamed from: e  reason: collision with root package name */
    public int f19799e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19800f;

    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        this.f19799e = 3;
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.f19795a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f19797c = view.findViewById(R.id.normal_pic_click_bg);
        this.f19796b = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void b(n nVar) {
        if (nVar instanceof o) {
            this.f19798d = nVar;
            o oVar = (o) nVar;
            if (oVar.e()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(oVar.c());
                this.f19796b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.f19795a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.f19795a.U(headPortraitFilter, 25, false);
                }
            } else {
                this.f19795a.setDefaultResource(R.drawable.img_default_100);
                this.f19796b.setVisibility(8);
                this.f19795a.U(oVar.c(), 10, false);
            }
            a().setOnClickListener(this.f19800f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f19798d;
    }

    public void d(int i2) {
        if (this.f19799e != i2) {
            SkinManager.setViewTextColor(this.f19796b, R.color.CAM_X0111, 1);
            SkinManager.setBackgroundColor(this.f19796b, R.color.black_alpha50);
            this.f19799e = i2;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f19800f = onClickListener;
    }
}
