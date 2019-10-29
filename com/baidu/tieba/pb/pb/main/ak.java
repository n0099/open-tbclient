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
    private View.OnClickListener ZX;
    private com.baidu.tieba.pb.data.d hOn;
    private BdUniqueId hUm;
    private BdUniqueId hUn;
    private boolean hUo;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hUo = false;
        this.hUm = BdUniqueId.gen();
        this.hUn = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public al b(ViewGroup viewGroup) {
        al alVar = new al(this.hNY.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        alVar.Ac = false;
        alVar.Q(this.ZX);
        if (getType() == com.baidu.tieba.pb.data.i.hJH) {
            alVar.j(this.hUm);
        } else if (getType() == com.baidu.tieba.pb.data.i.hJI) {
            alVar.r(this.hUn);
        }
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.i iVar, al alVar) {
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.pb.data.i) alVar);
        if (alVar != null) {
            bUS();
            alVar.a(iVar);
        }
        return view;
    }

    private void bUS() {
        if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQy() != null && this.hOn.hJt && !this.hUo) {
            this.hUo = true;
            boolean isLike = this.hOn.bQy().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 9).bS("obj_id", this.hOn.bQz().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 10).bS("obj_id", this.hOn.bQz().getId()));
            }
        }
    }

    public void onDestroy() {
        this.hUo = false;
        MessageManager.getInstance().unRegisterListener(this.hUm);
        MessageManager.getInstance().unRegisterListener(this.hUn);
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZX = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hOn = dVar;
    }
}
