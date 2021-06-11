package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.n0.g2.i.c;
/* loaded from: classes5.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19707a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19708b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19709c;

    /* renamed from: d  reason: collision with root package name */
    public int f19710d;

    /* renamed from: e  reason: collision with root package name */
    public n f19711e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19712f;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.f19710d = 3;
        this.f19707a = view.findViewById(R.id.add_pic_root);
        this.f19708b = (ImageView) view.findViewById(R.id.add_image_view);
        this.f19709c = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void b(n nVar) {
        if (nVar instanceof c) {
            this.f19711e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f19708b, R.drawable.icon_mine_pic_add);
            if (cVar.b() > 0) {
                this.f19709c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.b())));
            }
            a().setOnClickListener(this.f19712f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f19711e;
    }

    public void d(int i2) {
        if (this.f19710d != i2) {
            SkinManager.setViewTextColor(this.f19709c, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            this.f19710d = i2;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f19712f = onClickListener;
    }
}
