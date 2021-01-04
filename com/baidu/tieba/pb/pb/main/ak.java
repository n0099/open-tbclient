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
    private com.baidu.tieba.pb.data.f lJI;
    private SortSwitchButton.a lOj;
    private BdUniqueId lTJ;
    private BdUniqueId lTK;
    private boolean lTL;

    public ak(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lTL = false;
        this.lTJ = BdUniqueId.gen();
        this.lTK = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cB */
    public PbReplyTitleViewHolder e(ViewGroup viewGroup) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.lLF.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lIO != null) {
            pbReplyTitleViewHolder.v(this.lIO.lNe);
        }
        pbReplyTitleViewHolder.ZU = false;
        pbReplyTitleViewHolder.W(this.bdp);
        pbReplyTitleViewHolder.setOnSwitchChangeListener(this.lOj);
        if (getType() == com.baidu.tieba.pb.data.n.lHi) {
            pbReplyTitleViewHolder.l(this.lTJ);
        } else if (getType() == com.baidu.tieba.pb.data.n.lHj) {
            pbReplyTitleViewHolder.u(this.lTK);
        }
        return pbReplyTitleViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            drE();
            nVar.lHo = this.lJI.lFR;
            pbReplyTitleViewHolder.a(nVar);
        }
        return view;
    }

    private void drE() {
        if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmD() != null && this.lJI.lFU && !this.lTL) {
            this.lTL = true;
            boolean isLike = this.lJI.dmD().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dX("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 9).dX("obj_id", this.lJI.dmD().getForumId()).an("thread_type", this.lJI.dmE().getThreadType()).dX("tid", this.lJI.dmE().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dX("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 10).dX("obj_id", this.lJI.dmD().getForumId()).an("thread_type", this.lJI.dmE().getThreadType()).dX("tid", this.lJI.dmE().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lTL = false;
        MessageManager.getInstance().unRegisterListener(this.lTJ);
        MessageManager.getInstance().unRegisterListener(this.lTK);
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lOj = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lJI = fVar;
    }
}
