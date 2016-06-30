package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.ak;
import com.baidu.tieba.person.a.al;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class r extends y.a {
    public TextView KC;
    public View aXd;
    public int aeK;
    public View axa;
    public BaseFragmentActivity bfw;
    public HTypeListView emA;
    public ak emB;

    public r(View view, BaseFragmentActivity baseFragmentActivity) {
        super(view);
        this.aeK = 3;
        this.axa = view;
        this.bfw = baseFragmentActivity;
        this.aXd = view.findViewById(u.g.divider_view_under_photo_album);
        this.KC = (TextView) view.findViewById(u.g.text_view_photo_album);
        this.emA = (HTypeListView) view.findViewById(u.g.listview_photo_album);
        this.emB = new ak(baseFragmentActivity, this.emA);
    }

    public void a(al alVar) {
        if (alVar != null) {
            this.emB.setDatas(alVar.getPhotoAlbum());
            if (this.bfw.nT() instanceof com.baidu.tieba.personInfo.f) {
                com.baidu.tieba.personInfo.f fVar = (com.baidu.tieba.personInfo.f) this.bfw.nT();
                if (fVar.aMj()) {
                    this.emA.setSelection(com.baidu.tbadk.core.util.y.s(alVar.getPhotoAlbum()));
                    fVar.it(false);
                }
            }
        }
    }

    public void aLM() {
        if (this.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.aeK = TbadkCoreApplication.m9getInst().getSkinType();
            av.l(this.axa, u.d.cp_bg_line_d);
            av.l(this.aXd, u.d.cp_bg_line_c);
            av.c(this.KC, u.d.cp_cont_f, 1);
            this.emB.notifyDataSetChanged();
        }
    }
}
