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
    private View.OnClickListener akE;
    private com.baidu.tieba.pb.data.e iGv;
    private BdUniqueId iOR;
    private BdUniqueId iOS;
    private boolean iOT;

    public ai(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iOT = false;
        this.iOR = BdUniqueId.gen();
        this.iOS = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public aj b(ViewGroup viewGroup) {
        aj ajVar = new aj(this.iHT.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        ajVar.CF = false;
        ajVar.Q(this.akE);
        if (getType() == com.baidu.tieba.pb.data.j.iEq) {
            ajVar.j(this.iOR);
        } else if (getType() == com.baidu.tieba.pb.data.j.iEr) {
            ajVar.s(this.iOS);
        }
        return ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, aj ajVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) ajVar);
        if (ajVar != null) {
            cpv();
            ajVar.a(jVar);
        }
        return view;
    }

    private void cpv() {
        if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckO() != null && this.iGv.iDs && !this.iOT) {
            this.iOT = true;
            boolean isLike = this.iGv.ckO().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cx("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 9).cx("obj_id", this.iGv.ckO().getForumId()).X("thread_type", this.iGv.ckP().getThreadType()).cx("tid", this.iGv.ckP().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cx("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 10).cx("obj_id", this.iGv.ckO().getForumId()).X("thread_type", this.iGv.ckP().getThreadType()).cx("tid", this.iGv.ckP().getId()));
            }
        }
    }

    public void onDestroy() {
        this.iOT = false;
        MessageManager.getInstance().unRegisterListener(this.iOR);
        MessageManager.getInstance().unRegisterListener(this.iOS);
    }

    public void y(View.OnClickListener onClickListener) {
        this.akE = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iGv = eVar;
    }
}
