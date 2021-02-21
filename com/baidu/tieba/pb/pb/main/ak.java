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
    private com.baidu.tieba.pb.data.f lOi;
    private SortSwitchButton.a lSQ;
    private BdUniqueId lYp;
    private BdUniqueId lYq;
    private boolean lYr;

    public ak(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lYr = false;
        this.lYp = BdUniqueId.gen();
        this.lYq = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cB */
    public PbReplyTitleViewHolder e(ViewGroup viewGroup) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.lQj.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lNm != null) {
            pbReplyTitleViewHolder.w(this.lNm.lRL);
        }
        pbReplyTitleViewHolder.ZO = false;
        pbReplyTitleViewHolder.W(this.bbI);
        pbReplyTitleViewHolder.setOnSwitchChangeListener(this.lSQ);
        if (getType() == com.baidu.tieba.pb.data.o.lLF) {
            pbReplyTitleViewHolder.l(this.lYp);
        } else if (getType() == com.baidu.tieba.pb.data.o.lLG) {
            pbReplyTitleViewHolder.v(this.lYq);
        }
        return pbReplyTitleViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            dqi();
            oVar.lLL = this.lOi.lKm;
            pbReplyTitleViewHolder.a(oVar);
        }
        return view;
    }

    private void dqi() {
        if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlf() != null && this.lOi.lKp && !this.lYr) {
            this.lYr = true;
            boolean isLike = this.lOi.dlf().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_adlocate", 9).dR("obj_id", this.lOi.dlf().getForumId()).ap("thread_type", this.lOi.dlg().getThreadType()).dR("tid", this.lOi.dlg().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_adlocate", 10).dR("obj_id", this.lOi.dlf().getForumId()).ap("thread_type", this.lOi.dlg().getThreadType()).dR("tid", this.lOi.dlg().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lYr = false;
        MessageManager.getInstance().unRegisterListener(this.lYp);
        MessageManager.getInstance().unRegisterListener(this.lYq);
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lSQ = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lOi = fVar;
    }
}
