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
    private View.OnClickListener aDc;
    private com.baidu.tieba.pb.data.e jqC;
    private BdUniqueId jza;
    private BdUniqueId jzb;
    private boolean jzc;

    public ai(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jzc = false;
        this.jza = BdUniqueId.gen();
        this.jzb = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public aj b(ViewGroup viewGroup) {
        aj ajVar = new aj(this.jsa.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        ajVar.Wb = false;
        ajVar.R(this.aDc);
        if (getType() == com.baidu.tieba.pb.data.j.jow) {
            ajVar.j(this.jza);
        } else if (getType() == com.baidu.tieba.pb.data.j.jox) {
            ajVar.s(this.jzb);
        }
        return ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, aj ajVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) ajVar);
        if (ajVar != null) {
            cAb();
            ajVar.a(jVar);
        }
        return view;
    }

    private void cAb() {
        if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvt() != null && this.jqC.jny && !this.jzc) {
            this.jzc = true;
            boolean isLike = this.jqC.cvt().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 9).cI("obj_id", this.jqC.cvt().getForumId()).af("thread_type", this.jqC.cvu().getThreadType()).cI("tid", this.jqC.cvu().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 10).cI("obj_id", this.jqC.cvt().getForumId()).af("thread_type", this.jqC.cvu().getThreadType()).cI("tid", this.jqC.cvu().getId()));
            }
        }
    }

    public void onDestroy() {
        this.jzc = false;
        MessageManager.getInstance().unRegisterListener(this.jza);
        MessageManager.getInstance().unRegisterListener(this.jzb);
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqC = eVar;
    }
}
