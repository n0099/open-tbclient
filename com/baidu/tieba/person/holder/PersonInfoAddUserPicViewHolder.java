package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.n0.g2.i.c;
/* loaded from: classes5.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19630a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19631b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19632c;

    /* renamed from: d  reason: collision with root package name */
    public int f19633d;

    /* renamed from: e  reason: collision with root package name */
    public n f19634e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19635f;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.f19633d = 3;
        this.f19630a = view.findViewById(R.id.add_pic_root);
        this.f19631b = (ImageView) view.findViewById(R.id.add_image_view);
        this.f19632c = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void b(n nVar) {
        if (nVar instanceof c) {
            this.f19634e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f19631b, R.drawable.icon_mine_pic_add);
            if (cVar.c() > 0) {
                this.f19632c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.c())));
            }
            a().setOnClickListener(this.f19635f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f19634e;
    }

    public void d(int i2) {
        if (this.f19633d != i2) {
            SkinManager.setViewTextColor(this.f19632c, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            this.f19633d = i2;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f19635f = onClickListener;
    }
}
