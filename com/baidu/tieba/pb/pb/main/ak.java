package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ak extends k<com.baidu.tieba.pb.data.i, al> {
    private com.baidu.tieba.pb.data.d hPJ;
    private BdUniqueId hVE;
    private BdUniqueId hVF;
    private boolean hVG;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hVG = false;
        this.hVE = BdUniqueId.gen();
        this.hVF = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public al onCreateViewHolder(ViewGroup viewGroup) {
        al alVar = new al(this.hPu.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        alVar.Qk = false;
        alVar.P(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.i.hLb) {
            alVar.j(this.hVE);
        } else if (getType() == com.baidu.tieba.pb.data.i.hLc) {
            alVar.q(this.hVF);
        }
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.i iVar, al alVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, alVar);
        if (alVar != null) {
            bXQ();
            alVar.a(iVar);
        }
        return view;
    }

    private void bXQ() {
        if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTx() != null && this.hPJ.hKO && !this.hVG) {
            this.hVG = true;
            boolean isLike = this.hPJ.bTx().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").bT("page_type", "a005").P("obj_isad", 1).P("obj_adlocate", 9).bT(VideoPlayActivityConfig.OBJ_ID, this.hPJ.bTy().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").bT("page_type", "a005").P("obj_isad", 1).P("obj_adlocate", 10).bT(VideoPlayActivityConfig.OBJ_ID, this.hPJ.bTy().getId()));
            }
        }
    }

    public void onDestroy() {
        this.hVG = false;
        MessageManager.getInstance().unRegisterListener(this.hVE);
        MessageManager.getInstance().unRegisterListener(this.hVF);
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hPJ = dVar;
    }
}
