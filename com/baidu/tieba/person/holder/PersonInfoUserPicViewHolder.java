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
import d.b.b.j.e.n;
/* loaded from: classes5.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f20222a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20223b;

    /* renamed from: c  reason: collision with root package name */
    public View f20224c;

    /* renamed from: d  reason: collision with root package name */
    public n f20225d;

    /* renamed from: e  reason: collision with root package name */
    public int f20226e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20227f;

    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        this.f20226e = 3;
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.f20222a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f20224c = view.findViewById(R.id.normal_pic_click_bg);
        this.f20223b = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void b(n nVar) {
        if (nVar instanceof d.b.h0.t.n) {
            this.f20225d = nVar;
            d.b.h0.t.n nVar2 = (d.b.h0.t.n) nVar;
            if (nVar2.f()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(nVar2.e());
                this.f20223b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.f20222a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.f20222a.W(headPortraitFilter, 25, false);
                }
            } else {
                this.f20222a.setDefaultResource(R.drawable.img_default_100);
                this.f20223b.setVisibility(8);
                this.f20222a.W(nVar2.e(), 10, false);
            }
            a().setOnClickListener(this.f20227f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f20225d;
    }

    public void d(int i) {
        if (this.f20226e != i) {
            SkinManager.setViewTextColor(this.f20223b, R.color.CAM_X0111, 1);
            SkinManager.setBackgroundColor(this.f20223b, R.color.black_alpha50);
            this.f20226e = i;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f20227f = onClickListener;
    }
}
