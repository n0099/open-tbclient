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
public class ak extends l<com.baidu.tieba.pb.data.o, PbReplyTitleViewHolder> {
    private View.OnClickListener bbI;
    private com.baidu.tieba.pb.data.f lNT;
    private SortSwitchButton.a lSB;
    private BdUniqueId lYa;
    private BdUniqueId lYb;
    private boolean lYc;

    public ak(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lYc = false;
        this.lYa = BdUniqueId.gen();
        this.lYb = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cB */
    public PbReplyTitleViewHolder e(ViewGroup viewGroup) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.lPU.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lMX != null) {
            pbReplyTitleViewHolder.w(this.lMX.lRw);
        }
        pbReplyTitleViewHolder.ZO = false;
        pbReplyTitleViewHolder.W(this.bbI);
        pbReplyTitleViewHolder.setOnSwitchChangeListener(this.lSB);
        if (getType() == com.baidu.tieba.pb.data.o.lLq) {
            pbReplyTitleViewHolder.l(this.lYa);
        } else if (getType() == com.baidu.tieba.pb.data.o.lLr) {
            pbReplyTitleViewHolder.v(this.lYb);
        }
        return pbReplyTitleViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            dqb();
            oVar.lLw = this.lNT.lJY;
            pbReplyTitleViewHolder.a(oVar);
        }
        return view;
    }

    private void dqb() {
        if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkY() != null && this.lNT.lKb && !this.lYc) {
            this.lYc = true;
            boolean isLike = this.lNT.dkY().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_adlocate", 9).dR("obj_id", this.lNT.dkY().getForumId()).ap("thread_type", this.lNT.dkZ().getThreadType()).dR("tid", this.lNT.dkZ().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_adlocate", 10).dR("obj_id", this.lNT.dkY().getForumId()).ap("thread_type", this.lNT.dkZ().getThreadType()).dR("tid", this.lNT.dkZ().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lYc = false;
        MessageManager.getInstance().unRegisterListener(this.lYa);
        MessageManager.getInstance().unRegisterListener(this.lYb);
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lSB = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lNT = fVar;
    }
}
