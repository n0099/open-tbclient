package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class b extends aa.a {
    private o UO;
    public ImageView klj;
    public TextView klk;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.klj = (ImageView) view.findViewById(R.id.add_image_view);
        this.klk = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(o oVar) {
        if (oVar instanceof com.baidu.tieba.person.data.c) {
            this.UO = oVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) oVar;
            am.setImageResource(this.klj, R.drawable.icon_mine_pic_add);
            if (cVar.cNn() > 0) {
                this.klk.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.cNn())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.klk, R.color.cp_cont_e, 1);
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public o oX() {
        return this.UO;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
