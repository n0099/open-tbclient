package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends y.a {
    private View.OnClickListener Fn;
    public View awk;
    public ImageView dBj;
    public TextView dBk;
    private v dBl;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.awk = view.findViewById(t.g.add_pic_root);
        this.dBj = (ImageView) view.findViewById(t.g.add_image_view);
        this.dBk = (TextView) view.findViewById(t.g.tip_left_count_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.b) {
            this.dBl = vVar;
            com.baidu.tieba.person.data.b bVar = (com.baidu.tieba.person.data.b) vVar;
            at.c(this.dBj, t.f.icon_pic_add);
            if (bVar.aCe() > 0) {
                this.dBk.setText(String.format(TbadkCoreApplication.m11getInst().getString(t.j.have_left_some_picture_upload), Integer.valueOf(bVar.aCe())));
                at.c(this.dBk, t.d.cp_cont_c, 1);
            }
            at.k(getView(), t.f.add_pic_item_bg);
            getView().setOnClickListener(this.Fn);
        }
    }

    public v vL() {
        return this.dBl;
    }

    public void I(View.OnClickListener onClickListener) {
        this.Fn = onClickListener;
    }
}
