package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends r.a {
    public ImageView gim;
    public TextView gin;
    private i gio;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.g.add_pic_root);
        this.gim = (ImageView) view.findViewById(d.g.add_image_view);
        this.gin = (TextView) view.findViewById(d.g.tip_left_count_view);
    }

    public void f(i iVar) {
        if (iVar instanceof com.baidu.tieba.person.data.c) {
            this.gio = iVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) iVar;
            aj.c(this.gim, d.f.icon_mine_pic_add);
            if (cVar.biA() > 0) {
                this.gin.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.have_left_some_picture_upload), Integer.valueOf(cVar.biA())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.e(this.gin, d.C0141d.cp_cont_e, 1);
            aj.t(getView(), d.C0141d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public i EF() {
        return this.gio;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
