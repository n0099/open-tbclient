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
    public View f20215a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f20216b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20217c;

    /* renamed from: d  reason: collision with root package name */
    public int f20218d;

    /* renamed from: e  reason: collision with root package name */
    public n f20219e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20220f;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.f20218d = 3;
        this.f20215a = view.findViewById(R.id.add_pic_root);
        this.f20216b = (ImageView) view.findViewById(R.id.add_image_view);
        this.f20217c = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void b(n nVar) {
        if (nVar instanceof c) {
            this.f20219e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f20216b, R.drawable.icon_mine_pic_add);
            if (cVar.a() > 0) {
                this.f20217c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.a())));
            }
            a().setOnClickListener(this.f20220f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        return this.f20219e;
    }

    public void d(int i) {
        if (this.f20218d != i) {
            SkinManager.setViewTextColor(this.f20217c, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            this.f20218d = i;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.f20220f = onClickListener;
    }
}
