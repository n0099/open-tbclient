package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends y.a {
    public View aAy;
    private View.OnClickListener ahN;
    public ImageView eEJ;
    public TextView eEK;
    private v eEL;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aAy = view.findViewById(r.g.add_pic_root);
        this.eEJ = (ImageView) view.findViewById(r.g.add_image_view);
        this.eEK = (TextView) view.findViewById(r.g.tip_left_count_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eEL = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            av.c(this.eEJ, r.f.icon_mine_pic_add);
            if (aVar.aSD() > 0) {
                this.eEK.setText(String.format(TbadkCoreApplication.m9getInst().getString(r.j.have_left_some_picture_upload), Integer.valueOf(aVar.aSD())));
            }
            getView().setOnClickListener(this.ahN);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.c(this.eEK, r.d.cp_cont_e, 1);
            av.l(getView(), r.d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v wV() {
        return this.eEL;
    }

    public void G(View.OnClickListener onClickListener) {
        this.ahN = onClickListener;
    }
}
