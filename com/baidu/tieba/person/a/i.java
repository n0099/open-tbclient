package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends c<com.baidu.tieba.person.data.f, com.baidu.tieba.person.b.g> {
    private com.baidu.adp.widget.ListView.v dai;
    private boolean isSelf;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public com.baidu.tieba.person.b.g b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.g(LayoutInflater.from(this.mContext).inflate(t.h.person_info_forum_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.f fVar, com.baidu.tieba.person.b.g gVar) {
        a(gVar, view);
        if (fVar != null && this.aXE) {
            a(gVar, fVar);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.f fVar) {
        if (gVar != null && fVar != null) {
            this.isSelf = fVar.isSelf();
            this.userId = fVar.getUserId();
            if (this.isSelf) {
                c(gVar, fVar);
            } else if (fVar.aui() == 1 || (fVar.aui() == 2 && fVar.getIsFriend() == 1)) {
                c(gVar, fVar);
            } else {
                b(gVar, fVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            gVar.deh.setVisibility(8);
            gVar.dee.setVisibility(8);
            gVar.def.setVisibility(8);
            gVar.dem.setVisibility(0);
            gVar.dei.setVisibility(0);
            String string = this.mContext.getResources().getString(t.j.my_attention_bar);
            if (fVar.dbA) {
                gVar.aOS.setVisibility(0);
            } else {
                gVar.aOS.setVisibility(8);
            }
            if (!fVar.isSelf()) {
                if (fVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(t.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(t.j.his_attention_bar);
                }
            }
            gVar.dej.setText(string);
            gVar.dek.setText(t.j.set_private);
            gVar.dei.setOnClickListener(new j(this));
        }
    }

    private void c(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            String string = this.mContext.getResources().getString(t.j.my_attention_bar);
            if (fVar.dbA) {
                gVar.aOS.setVisibility(0);
            } else {
                gVar.aOS.setVisibility(8);
            }
            if (!fVar.isSelf()) {
                if (fVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(t.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(t.j.his_attention_bar);
                }
            }
            gVar.deh.setVisibility(0);
            gVar.dee.setVisibility(0);
            gVar.def.setVisibility(0);
            gVar.dem.setVisibility(8);
            gVar.dei.setVisibility(8);
            gVar.ded.setText(string);
            gVar.dej.setText(string);
            if (com.baidu.tbadk.core.util.x.o(fVar.auh()) > 0) {
                gVar.deg.setText(new StringBuilder(String.valueOf(fVar.getCount())).toString());
                if (com.baidu.tbadk.core.util.x.o(fVar.auh()) <= 3) {
                    gVar.del.setVisibility(8);
                } else {
                    gVar.del.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.x.b(fVar.auh(), 0) != null) {
                    gVar.ddX.setText(kZ(((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 0)).getForumName()));
                    gVar.ddX.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.x.b(fVar.auh(), 1) != null) {
                    gVar.ddY.setText(kZ(((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 1)).getForumName()));
                    gVar.ddY.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.x.b(fVar.auh(), 2) != null) {
                    gVar.ddZ.setText(kZ(((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 2)).getForumName()));
                    gVar.ddZ.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.x.b(fVar.auh(), 3) != null) {
                    gVar.dea.setText(kZ(((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 3)).getForumName()));
                    gVar.dea.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.x.b(fVar.auh(), 4) != null) {
                    gVar.deb.setText(kZ(((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 4)).getForumName()));
                    gVar.deb.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.x.b(fVar.auh(), 5) != null) {
                    gVar.dec.setText(kZ(((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 5)).getForumName()));
                    gVar.dec.setVisibility(0);
                }
                gVar.dee.setOnClickListener(aua());
                gVar.ddX.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 0)));
                gVar.ddY.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 1)));
                gVar.ddZ.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 2)));
                gVar.dea.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 3)));
                gVar.deb.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 4)));
                gVar.dec.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.x.b(fVar.auh(), 5)));
            } else {
                gVar.dei.setVisibility(0);
                gVar.deh.setVisibility(8);
                gVar.dee.setVisibility(8);
            }
            gVar.dei.setOnClickListener(aua());
        }
    }

    private void a(com.baidu.tieba.person.b.g gVar, View view) {
        if (gVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(gVar.deh, t.d.cp_bg_line_d);
            ar.k(gVar.dei, t.f.addresslist_item_bg);
            ar.k(gVar.ddX, t.f.home_like_item_bg);
            ar.k(gVar.ddY, t.f.home_like_item_bg);
            ar.k(gVar.ddZ, t.f.home_like_item_bg);
            ar.k(gVar.dea, t.f.home_like_item_bg);
            ar.k(gVar.deb, t.f.home_like_item_bg);
            ar.k(gVar.dec, t.f.home_like_item_bg);
            ar.b(gVar.ddX, t.d.cp_cont_f, 1);
            ar.b(gVar.ddY, t.d.cp_cont_f, 1);
            ar.b(gVar.ddZ, t.d.cp_cont_f, 1);
            ar.b(gVar.dea, t.d.cp_cont_f, 1);
            ar.b(gVar.deb, t.d.cp_cont_f, 1);
            ar.b(gVar.dec, t.d.cp_cont_f, 1);
            ar.l(gVar.aOS, t.d.cp_bg_line_c);
            ar.l(view, t.d.cp_bg_line_d);
            ar.l(gVar.def, t.d.cp_bg_line_c);
            ar.b(gVar.ded, t.d.cp_cont_f, 1);
            ar.b(gVar.deg, t.d.cp_cont_c, 1);
            ar.c(gVar.ddH, t.f.icon_arrow_tab);
            ar.b(gVar.dej, t.d.cp_cont_f, 1);
            ar.b(gVar.dek, t.d.cp_cont_d, 1);
            ar.c(gVar.dem, t.f.icon_mycenter_lock);
            gVar.ahU = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.dai = vVar;
    }

    public View.OnClickListener aua() {
        return new k(this);
    }

    public View.OnClickListener a(MyLikeForum myLikeForum) {
        if (myLikeForum == null) {
            return null;
        }
        return new l(this, myLikeForum);
    }

    private String kZ(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (aw.dx(str) >= 11) {
            return aw.j(str, 10);
        }
        return String.valueOf(str) + this.mContext.getResources().getString(t.j.bar);
    }
}
