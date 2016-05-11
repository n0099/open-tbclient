package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.ak;
import com.baidu.tieba.person.a.al;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class r extends y.a {
    public TextView KC;
    public View aTI;
    public int aej;
    public View awk;
    public BaseFragmentActivity cSp;
    public HTypeListView dDO;
    public ak dDP;

    public r(View view, BaseFragmentActivity baseFragmentActivity) {
        super(view);
        this.aej = 3;
        this.awk = view;
        this.cSp = baseFragmentActivity;
        this.aTI = view.findViewById(t.g.divider_view_under_photo_album);
        this.KC = (TextView) view.findViewById(t.g.text_view_photo_album);
        this.dDO = (HTypeListView) view.findViewById(t.g.listview_photo_album);
        this.dDP = new ak(baseFragmentActivity, this.dDO);
    }

    public void a(al alVar) {
        if (alVar != null) {
            this.dDP.setDatas(alVar.getPhotoAlbum());
            if (this.cSp.nY() instanceof com.baidu.tieba.personInfo.f) {
                com.baidu.tieba.personInfo.f fVar = (com.baidu.tieba.personInfo.f) this.cSp.nY();
                if (fVar.aDl()) {
                    this.dDO.setSelection(com.baidu.tbadk.core.util.y.r(alVar.getPhotoAlbum()));
                    fVar.hy(false);
                }
            }
        }
    }

    public void aCN() {
        if (this.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            this.aej = TbadkCoreApplication.m11getInst().getSkinType();
            at.l(this.awk, t.d.cp_bg_line_d);
            at.l(this.aTI, t.d.cp_bg_line_c);
            at.c(this.KC, t.d.cp_cont_f, 1);
            this.dDP.notifyDataSetChanged();
        }
    }
}
