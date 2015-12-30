package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.data.d;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbAppMultiPicViewHolder extends PbAppNewBaseViewHolder {
    public View bfj;
    public TextView bfo;
    public TbImageView bfp;
    public TbImageView bfq;
    public TbImageView bfr;

    public PbAppMultiPicViewHolder(View view) {
        super(view);
        this.bfj = view.findViewById(n.g.pb_app_multi_pic_container);
        this.bfo = (TextView) view.findViewById(n.g.recommend_desc);
        this.bfp = (TbImageView) view.findViewById(n.g.pb_app_multi_pic_left);
        this.bfq = (TbImageView) view.findViewById(n.g.pb_app_multi_pic_center);
        this.bfr = (TbImageView) view.findViewById(n.g.pb_app_multi_pic_right);
    }

    @Override // com.baidu.tieba.recapp.view.PbAppNewBaseViewHolder, com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        d.a aVar;
        super.update(qVar, i, z);
        if (qVar != null && qVar.aFf() != null && (aVar = qVar.aFf().dGx) != null) {
            if (StringUtils.isNull(aVar.dGy)) {
                this.bfo.setVisibility(8);
            } else {
                this.bfo.setVisibility(0);
                this.bfo.setText(aVar.dGy);
            }
            a(aVar);
        }
    }

    private void a(d.a aVar) {
        if (aVar == null) {
            this.bfj.setVisibility(8);
            return;
        }
        ArrayList<String> arrayList = aVar.dGA;
        if (arrayList == null || arrayList.size() <= 0) {
            this.bfj.setVisibility(8);
        } else if (!m.qQ().qW()) {
            this.bfj.setVisibility(8);
        } else {
            this.bfj.setVisibility(0);
            int size = arrayList.size();
            ml(size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                this.bfp.d(arrayList.get(0), i, false);
            } else if (size == 2) {
                this.bfp.d(arrayList.get(0), i, false);
                this.bfq.d(arrayList.get(1), i, false);
            } else if (size >= 3) {
                this.bfp.d(arrayList.get(0), i, false);
                this.bfq.d(arrayList.get(1), i, false);
                this.bfr.d(arrayList.get(2), i, false);
            }
        }
    }

    private void ml(int i) {
        if (i > 0) {
            if (i == 1) {
                this.bfp.setVisibility(0);
                this.bfq.setVisibility(4);
                this.bfr.setVisibility(4);
            } else if (i == 2) {
                this.bfp.setVisibility(0);
                this.bfq.setVisibility(0);
                this.bfr.setVisibility(4);
            } else if (i >= 3) {
                this.bfp.setVisibility(0);
                this.bfq.setVisibility(0);
                this.bfr.setVisibility(0);
            }
        }
    }
}
