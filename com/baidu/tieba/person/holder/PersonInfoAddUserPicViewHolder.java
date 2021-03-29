package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.j.e.n;
import d.b.i0.e2.i.c;
/* loaded from: classes5.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f20216a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f20217b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20218c;

    /* renamed from: d  reason: collision with root package name */
    public int f20219d;

    /* renamed from: e  reason: collision with root package name */
    public n f20220e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20221f;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.f20219d = 3;
        this.f20216a = view.findViewById(R.id.add_pic_root);
        this.f20217b = (ImageView) view.findViewById(R.id.add_image_view);
        this.f20218c = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void b(n nVar) {
        if (nVar instanceof c) {
            this.f20220e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f20217b, R.drawable.icon_mine_pic_add);
            if (cVar.a() > 0) {
                this.f20218c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.a())));
            }
            a().setOnClickListener(this.f20221f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f20220e;
    }

    public void d(int i) {
        if (this.f20219d != i) {
            SkinManager.setViewTextColor(this.f20218c, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            this.f20219d = i;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f20221f = onClickListener;
    }
}
