package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends y.a {
    public View aAV;
    private View.OnClickListener aif;
    public ImageView eCG;
    public TextView eCH;
    private v eCI;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aAV = view.findViewById(t.g.add_pic_root);
        this.eCG = (ImageView) view.findViewById(t.g.add_image_view);
        this.eCH = (TextView) view.findViewById(t.g.tip_left_count_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eCI = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            av.c(this.eCG, t.f.icon_mine_pic_add);
            if (aVar.aSf() > 0) {
                this.eCH.setText(String.format(TbadkCoreApplication.m9getInst().getString(t.j.have_left_some_picture_upload), Integer.valueOf(aVar.aSf())));
            }
            getView().setOnClickListener(this.aif);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.c(this.eCH, t.d.cp_cont_e, 1);
            av.l(getView(), t.d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v wT() {
        return this.eCI;
    }

    public void H(View.OnClickListener onClickListener) {
        this.aif = onClickListener;
    }
}
