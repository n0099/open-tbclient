package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.j0.f2.i.c;
/* loaded from: classes4.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f20420a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f20421b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20422c;

    /* renamed from: d  reason: collision with root package name */
    public int f20423d;

    /* renamed from: e  reason: collision with root package name */
    public n f20424e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20425f;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.f20423d = 3;
        this.f20420a = view.findViewById(R.id.add_pic_root);
        this.f20421b = (ImageView) view.findViewById(R.id.add_image_view);
        this.f20422c = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void b(n nVar) {
        if (nVar instanceof c) {
            this.f20424e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f20421b, R.drawable.icon_mine_pic_add);
            if (cVar.c() > 0) {
                this.f20422c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.c())));
            }
            a().setOnClickListener(this.f20425f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f20424e;
    }

    public void d(int i2) {
        if (this.f20423d != i2) {
            SkinManager.setViewTextColor(this.f20422c, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            this.f20423d = i2;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f20425f = onClickListener;
    }
}
