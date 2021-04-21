package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.j0.f2.i.c;
/* loaded from: classes3.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19916a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19917b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19918c;

    /* renamed from: d  reason: collision with root package name */
    public int f19919d;

    /* renamed from: e  reason: collision with root package name */
    public n f19920e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19921f;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.f19919d = 3;
        this.f19916a = view.findViewById(R.id.add_pic_root);
        this.f19917b = (ImageView) view.findViewById(R.id.add_image_view);
        this.f19918c = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void b(n nVar) {
        if (nVar instanceof c) {
            this.f19920e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f19917b, R.drawable.icon_mine_pic_add);
            if (cVar.a() > 0) {
                this.f19918c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.a())));
            }
            a().setOnClickListener(this.f19921f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f19920e;
    }

    public void d(int i) {
        if (this.f19919d != i) {
            SkinManager.setViewTextColor(this.f19918c, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            this.f19919d = i;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f19921f = onClickListener;
    }
}
