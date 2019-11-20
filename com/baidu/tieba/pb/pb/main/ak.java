package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ak extends k<com.baidu.tieba.pb.data.i, al> {
    private View.OnClickListener ZF;
    private com.baidu.tieba.pb.data.d hNw;
    private BdUniqueId hTv;
    private BdUniqueId hTw;
    private boolean hTx;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hTx = false;
        this.hTv = BdUniqueId.gen();
        this.hTw = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public al b(ViewGroup viewGroup) {
        al alVar = new al(this.hNh.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        alVar.zC = false;
        alVar.Q(this.ZF);
        if (getType() == com.baidu.tieba.pb.data.i.hIQ) {
            alVar.j(this.hTv);
        } else if (getType() == com.baidu.tieba.pb.data.i.hIR) {
            alVar.r(this.hTw);
        }
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.i iVar, al alVar) {
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.pb.data.i) alVar);
        if (alVar != null) {
            bUQ();
            alVar.a(iVar);
        }
        return view;
    }

    private void bUQ() {
        if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQw() != null && this.hNw.hIC && !this.hTx) {
            this.hTx = true;
            boolean isLike = this.hNw.bQw().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 9).bS("obj_id", this.hNw.bQx().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 10).bS("obj_id", this.hNw.bQx().getId()));
            }
        }
    }

    public void onDestroy() {
        this.hTx = false;
        MessageManager.getInstance().unRegisterListener(this.hTv);
        MessageManager.getInstance().unRegisterListener(this.hTw);
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hNw = dVar;
    }
}
