package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.data.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbAppMultiPicViewHolder extends PbAppNewBaseViewHolder {
    public View bbk;
    public TextView bbp;
    public TbImageView bbq;
    public TbImageView bbr;
    public TbImageView bbs;

    public PbAppMultiPicViewHolder(View view) {
        super(view);
        this.bbk = view.findViewById(n.f.pb_app_multi_pic_container);
        this.bbp = (TextView) view.findViewById(n.f.recommend_desc);
        this.bbq = (TbImageView) view.findViewById(n.f.pb_app_multi_pic_left);
        this.bbr = (TbImageView) view.findViewById(n.f.pb_app_multi_pic_center);
        this.bbs = (TbImageView) view.findViewById(n.f.pb_app_multi_pic_right);
    }

    @Override // com.baidu.tieba.recapp.view.PbAppNewBaseViewHolder, com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(com.baidu.tieba.tbadkCore.data.n nVar, int i, boolean z) {
        d.a aVar;
        super.update(nVar, i, z);
        if (nVar != null && nVar.aCS() != null && (aVar = nVar.aCS().dzd) != null) {
            if (StringUtils.isNull(aVar.dze)) {
                this.bbp.setVisibility(8);
            } else {
                this.bbp.setVisibility(0);
                this.bbp.setText(aVar.dze);
            }
            a(aVar);
        }
    }

    private void a(d.a aVar) {
        if (aVar == null) {
            this.bbk.setVisibility(8);
            return;
        }
        ArrayList<String> arrayList = aVar.dzg;
        if (arrayList == null || arrayList.size() <= 0) {
            this.bbk.setVisibility(8);
        } else if (!m.rh().rn()) {
            this.bbk.setVisibility(8);
        } else {
            this.bbk.setVisibility(0);
            int size = arrayList.size();
            lM(size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                this.bbq.d(arrayList.get(0), i, false);
            } else if (size == 2) {
                this.bbq.d(arrayList.get(0), i, false);
                this.bbr.d(arrayList.get(1), i, false);
            } else if (size >= 3) {
                this.bbq.d(arrayList.get(0), i, false);
                this.bbr.d(arrayList.get(1), i, false);
                this.bbs.d(arrayList.get(2), i, false);
            }
        }
    }

    private void lM(int i) {
        if (i > 0) {
            if (i == 1) {
                this.bbq.setVisibility(0);
                this.bbr.setVisibility(4);
                this.bbs.setVisibility(4);
            } else if (i == 2) {
                this.bbq.setVisibility(0);
                this.bbr.setVisibility(0);
                this.bbs.setVisibility(4);
            } else if (i >= 3) {
                this.bbq.setVisibility(0);
                this.bbr.setVisibility(0);
                this.bbs.setVisibility(0);
            }
        }
    }
}
