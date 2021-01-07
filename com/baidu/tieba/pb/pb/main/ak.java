package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
/* loaded from: classes2.dex */
public class ak extends l<com.baidu.tieba.pb.data.n, PbReplyTitleViewHolder> {
    private View.OnClickListener bdp;
    private com.baidu.tieba.pb.data.f lJH;
    private SortSwitchButton.a lOi;
    private BdUniqueId lTI;
    private BdUniqueId lTJ;
    private boolean lTK;

    public ak(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lTK = false;
        this.lTI = BdUniqueId.gen();
        this.lTJ = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cB */
    public PbReplyTitleViewHolder e(ViewGroup viewGroup) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.lLE.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lIN != null) {
            pbReplyTitleViewHolder.v(this.lIN.lNd);
        }
        pbReplyTitleViewHolder.ZU = false;
        pbReplyTitleViewHolder.W(this.bdp);
        pbReplyTitleViewHolder.setOnSwitchChangeListener(this.lOi);
        if (getType() == com.baidu.tieba.pb.data.n.lHh) {
            pbReplyTitleViewHolder.l(this.lTI);
        } else if (getType() == com.baidu.tieba.pb.data.n.lHi) {
            pbReplyTitleViewHolder.u(this.lTJ);
        }
        return pbReplyTitleViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            drF();
            nVar.lHn = this.lJH.lFQ;
            pbReplyTitleViewHolder.a(nVar);
        }
        return view;
    }

    private void drF() {
        if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmE() != null && this.lJH.lFT && !this.lTK) {
            this.lTK = true;
            boolean isLike = this.lJH.dmE().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dX("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 9).dX("obj_id", this.lJH.dmE().getForumId()).an("thread_type", this.lJH.dmF().getThreadType()).dX("tid", this.lJH.dmF().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dX("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 10).dX("obj_id", this.lJH.dmE().getForumId()).an("thread_type", this.lJH.dmF().getThreadType()).dX("tid", this.lJH.dmF().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lTK = false;
        MessageManager.getInstance().unRegisterListener(this.lTI);
        MessageManager.getInstance().unRegisterListener(this.lTJ);
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lOi = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lJH = fVar;
    }
}
