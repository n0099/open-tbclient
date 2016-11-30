package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends y.a {
    public View aBq;
    private View.OnClickListener aNB;
    public ImageView eLi;
    public TextView eLj;
    private v eLk;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aBq = view.findViewById(r.g.add_pic_root);
        this.eLi = (ImageView) view.findViewById(r.g.add_image_view);
        this.eLj = (TextView) view.findViewById(r.g.tip_left_count_view);
    }

    public void d(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eLk = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            at.c(this.eLi, r.f.icon_mine_pic_add);
            if (aVar.aUK() > 0) {
                this.eLj.setText(String.format(TbadkCoreApplication.m9getInst().getString(r.j.have_left_some_picture_upload), Integer.valueOf(aVar.aUK())));
            }
            getView().setOnClickListener(this.aNB);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            at.c(this.eLj, r.d.cp_cont_e, 1);
            at.l(getView(), r.d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v wX() {
        return this.eLk;
    }

    public void x(View.OnClickListener onClickListener) {
        this.aNB = onClickListener;
    }
}
