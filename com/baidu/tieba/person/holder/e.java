package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends y.a {
    private View.OnClickListener afk;
    public View axO;
    public ImageView eum;
    public TextView eun;
    private v euo;
    private int mSkinType;

    public e(View view) {
        super(view);
        this.mSkinType = 3;
        this.axO = view.findViewById(u.g.add_pic_root);
        this.eum = (ImageView) view.findViewById(u.g.add_image_view);
        this.eun = (TextView) view.findViewById(u.g.tip_left_count_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.b) {
            this.euo = vVar;
            com.baidu.tieba.person.data.b bVar = (com.baidu.tieba.person.data.b) vVar;
            av.c(this.eum, u.f.icon_pic_add);
            if (bVar.aND() > 0) {
                this.eun.setText(String.format(TbadkCoreApplication.m10getInst().getString(u.j.have_left_some_picture_upload), Integer.valueOf(bVar.aND())));
                av.c(this.eun, u.d.cp_cont_c, 1);
            }
            av.k(getView(), u.f.add_pic_item_bg);
            getView().setOnClickListener(this.afk);
        }
    }

    public v vP() {
        return this.euo;
    }

    public void J(View.OnClickListener onClickListener) {
        this.afk = onClickListener;
    }
}
