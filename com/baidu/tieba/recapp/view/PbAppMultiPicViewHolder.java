package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.d;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbAppMultiPicViewHolder extends PbAppNewBaseViewHolder {
    public View bhL;
    public TextView bhQ;
    public TbImageView bhR;
    public TbImageView bhS;
    public TbImageView bhT;

    public PbAppMultiPicViewHolder(View view) {
        super(view);
        this.bhL = view.findViewById(t.g.pb_app_multi_pic_container);
        this.bhQ = (TextView) view.findViewById(t.g.recommend_desc);
        this.bhR = (TbImageView) view.findViewById(t.g.pb_app_multi_pic_left);
        this.bhS = (TbImageView) view.findViewById(t.g.pb_app_multi_pic_center);
        this.bhT = (TbImageView) view.findViewById(t.g.pb_app_multi_pic_right);
    }

    @Override // com.baidu.tieba.recapp.view.PbAppNewBaseViewHolder, com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        d.a aVar;
        super.update(qVar, i, z);
        if (qVar != null && qVar.aMl() != null && (aVar = qVar.aMl().dWs) != null) {
            if (StringUtils.isNull(aVar.dWt)) {
                this.bhQ.setVisibility(8);
            } else {
                this.bhQ.setVisibility(0);
                this.bhQ.setText(aVar.dWt);
            }
            a(aVar);
        }
    }

    private void a(d.a aVar) {
        if (aVar == null) {
            this.bhL.setVisibility(8);
            return;
        }
        ArrayList<String> arrayList = aVar.dWv;
        if (arrayList == null || arrayList.size() <= 0) {
            this.bhL.setVisibility(8);
        } else if (!l.rn().rt()) {
            this.bhL.setVisibility(8);
        } else {
            this.bhL.setVisibility(0);
            int size = arrayList.size();
            np(size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                this.bhR.d(arrayList.get(0), i, false);
            } else if (size == 2) {
                this.bhR.d(arrayList.get(0), i, false);
                this.bhS.d(arrayList.get(1), i, false);
            } else if (size >= 3) {
                this.bhR.d(arrayList.get(0), i, false);
                this.bhS.d(arrayList.get(1), i, false);
                this.bhT.d(arrayList.get(2), i, false);
            }
        }
    }

    private void np(int i) {
        if (i > 0) {
            if (i == 1) {
                this.bhR.setVisibility(0);
                this.bhS.setVisibility(4);
                this.bhT.setVisibility(4);
            } else if (i == 2) {
                this.bhR.setVisibility(0);
                this.bhS.setVisibility(0);
                this.bhT.setVisibility(4);
            } else {
                this.bhR.setVisibility(0);
                this.bhS.setVisibility(0);
                this.bhT.setVisibility(0);
            }
        }
    }
}
