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
    private View.OnClickListener aYB;
    private com.baidu.tieba.pb.data.f lFd;
    private SortSwitchButton.a lJE;
    private BdUniqueId lPe;
    private BdUniqueId lPf;
    private boolean lPg;

    public ak(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lPg = false;
        this.lPe = BdUniqueId.gen();
        this.lPf = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cB */
    public PbReplyTitleViewHolder e(ViewGroup viewGroup) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.lHa.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lEi != null) {
            pbReplyTitleViewHolder.v(this.lEi.lIz);
        }
        pbReplyTitleViewHolder.ZS = false;
        pbReplyTitleViewHolder.W(this.aYB);
        pbReplyTitleViewHolder.setOnSwitchChangeListener(this.lJE);
        if (getType() == com.baidu.tieba.pb.data.n.lCC) {
            pbReplyTitleViewHolder.l(this.lPe);
        } else if (getType() == com.baidu.tieba.pb.data.n.lCD) {
            pbReplyTitleViewHolder.u(this.lPf);
        }
        return pbReplyTitleViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            dnN();
            nVar.lCI = this.lFd.lBl;
            pbReplyTitleViewHolder.a(nVar);
        }
        return view;
    }

    private void dnN() {
        if (this.lFd != null && this.lFd.diN() != null && this.lFd.diM() != null && this.lFd.lBo && !this.lPg) {
            this.lPg = true;
            boolean isLike = this.lFd.diM().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dW("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 9).dW("obj_id", this.lFd.diM().getForumId()).an("thread_type", this.lFd.diN().getThreadType()).dW("tid", this.lFd.diN().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dW("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 10).dW("obj_id", this.lFd.diM().getForumId()).an("thread_type", this.lFd.diN().getThreadType()).dW("tid", this.lFd.diN().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lPg = false;
        MessageManager.getInstance().unRegisterListener(this.lPe);
        MessageManager.getInstance().unRegisterListener(this.lPf);
    }

    public void C(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lJE = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lFd = fVar;
    }
}
