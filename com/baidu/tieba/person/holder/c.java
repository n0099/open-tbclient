package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends y.a {
    public View aAK;
    private View.OnClickListener aMS;
    public ImageView eoN;
    public TextView eoO;
    private v eoP;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aAK = view.findViewById(r.g.add_pic_root);
        this.eoN = (ImageView) view.findViewById(r.g.add_image_view);
        this.eoO = (TextView) view.findViewById(r.g.tip_left_count_view);
    }

    public void e(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eoP = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            ar.c(this.eoN, r.f.icon_mine_pic_add);
            if (aVar.aOz() > 0) {
                this.eoO.setText(String.format(TbadkCoreApplication.m9getInst().getString(r.j.have_left_some_picture_upload), Integer.valueOf(aVar.aOz())));
            }
            getView().setOnClickListener(this.aMS);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ar.c(this.eoO, r.d.cp_cont_e, 1);
            ar.l(getView(), r.d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v wK() {
        return this.eoP;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aMS = onClickListener;
    }
}
