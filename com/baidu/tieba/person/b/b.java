package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class b extends ad.a {
    private q Vm;
    public ImageView kNZ;
    public TextView kOa;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.kNZ = (ImageView) view.findViewById(R.id.add_image_view);
        this.kOa = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(q qVar) {
        if (qVar instanceof com.baidu.tieba.person.data.c) {
            this.Vm = qVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) qVar;
            ao.setImageResource(this.kNZ, R.drawable.icon_mine_pic_add);
            if (cVar.cVv() > 0) {
                this.kOa.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.cVv())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.kOa, R.color.cp_cont_e, 1);
            ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public q pp() {
        return this.Vm;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
