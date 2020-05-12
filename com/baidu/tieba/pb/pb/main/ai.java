package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ai extends l<com.baidu.tieba.pb.data.j, aj> {
    private View.OnClickListener aDi;
    private com.baidu.tieba.pb.data.e jqG;
    private BdUniqueId jze;
    private BdUniqueId jzf;
    private boolean jzg;

    public ai(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jzg = false;
        this.jze = BdUniqueId.gen();
        this.jzf = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public aj b(ViewGroup viewGroup) {
        aj ajVar = new aj(this.jse.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        ajVar.Wf = false;
        ajVar.R(this.aDi);
        if (getType() == com.baidu.tieba.pb.data.j.joA) {
            ajVar.j(this.jze);
        } else if (getType() == com.baidu.tieba.pb.data.j.joB) {
            ajVar.s(this.jzf);
        }
        return ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, aj ajVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) ajVar);
        if (ajVar != null) {
            czZ();
            ajVar.a(jVar);
        }
        return view;
    }

    private void czZ() {
        if (this.jqG != null && this.jqG.cvs() != null && this.jqG.cvr() != null && this.jqG.jnC && !this.jzg) {
            this.jzg = true;
            boolean isLike = this.jqG.cvr().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 9).cI("obj_id", this.jqG.cvr().getForumId()).af("thread_type", this.jqG.cvs().getThreadType()).cI("tid", this.jqG.cvs().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 10).cI("obj_id", this.jqG.cvr().getForumId()).af("thread_type", this.jqG.cvs().getThreadType()).cI("tid", this.jqG.cvs().getId()));
            }
        }
    }

    public void onDestroy() {
        this.jzg = false;
        MessageManager.getInstance().unRegisterListener(this.jze);
        MessageManager.getInstance().unRegisterListener(this.jzf);
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqG = eVar;
    }
}
