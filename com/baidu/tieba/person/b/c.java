package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends y.a {
    private View.OnClickListener aew;
    public View axa;
    public ImageView ejM;
    public TextView ejN;
    private v ejO;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.axa = view.findViewById(u.g.add_pic_root);
        this.ejM = (ImageView) view.findViewById(u.g.add_image_view);
        this.ejN = (TextView) view.findViewById(u.g.tip_left_count_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.b) {
            this.ejO = vVar;
            com.baidu.tieba.person.data.b bVar = (com.baidu.tieba.person.data.b) vVar;
            av.c(this.ejM, u.f.icon_pic_add);
            if (bVar.aLa() > 0) {
                this.ejN.setText(String.format(TbadkCoreApplication.m9getInst().getString(u.j.have_left_some_picture_upload), Integer.valueOf(bVar.aLa())));
                av.c(this.ejN, u.d.cp_cont_c, 1);
            }
            av.k(getView(), u.f.add_pic_item_bg);
            getView().setOnClickListener(this.aew);
        }
    }

    public v vP() {
        return this.ejO;
    }

    public void I(View.OnClickListener onClickListener) {
        this.aew = onClickListener;
    }
}
