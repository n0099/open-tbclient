package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.ai;
import com.baidu.tieba.person.a.aj;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class r extends y.a {
    public TextView KB;
    public View aYb;
    public int afy;
    public View axO;
    public BaseFragmentActivity bgI;
    public HTypeListView ewZ;
    public ai exa;

    public r(View view, BaseFragmentActivity baseFragmentActivity) {
        super(view);
        this.afy = 3;
        this.axO = view;
        this.bgI = baseFragmentActivity;
        this.aYb = view.findViewById(u.g.divider_view_under_photo_album);
        this.KB = (TextView) view.findViewById(u.g.text_view_photo_album);
        this.ewZ = (HTypeListView) view.findViewById(u.g.listview_photo_album);
        this.exa = new ai(baseFragmentActivity, this.ewZ);
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            this.exa.setDatas(ajVar.getPhotoAlbum());
            if (this.bgI.nI() instanceof com.baidu.tieba.personInfo.h) {
                com.baidu.tieba.personInfo.h hVar = (com.baidu.tieba.personInfo.h) this.bgI.nI();
                if (hVar.aPo()) {
                    this.ewZ.setSelection(com.baidu.tbadk.core.util.y.s(ajVar.getPhotoAlbum()));
                    hVar.iy(false);
                }
            }
        }
    }

    public void aOp() {
        if (this.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            this.afy = TbadkCoreApplication.m10getInst().getSkinType();
            av.l(this.axO, u.d.cp_bg_line_d);
            av.l(this.aYb, u.d.cp_bg_line_c);
            av.c(this.KB, u.d.cp_cont_f, 1);
            this.exa.notifyDataSetChanged();
        }
    }
}
