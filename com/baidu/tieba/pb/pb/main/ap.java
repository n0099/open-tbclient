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
/* loaded from: classes9.dex */
public class ap extends m<com.baidu.tieba.pb.data.l, aq> {
    private View.OnClickListener aIH;
    private com.baidu.tieba.pb.data.e jIA;
    private SortSwitchButton.a jMC;
    private BdUniqueId jRA;
    private boolean jRB;
    private BdUniqueId jRz;

    public ap(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jRB = false;
        this.jRz = BdUniqueId.gen();
        this.jRA = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bZ */
    public aq b(ViewGroup viewGroup) {
        aq aqVar = new aq(this.jKg.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        aqVar.v(this.jHL.jLA);
        aqVar.Wt = false;
        aqVar.R(this.aIH);
        aqVar.setOnSwitchChangeListener(this.jMC);
        if (getType() == com.baidu.tieba.pb.data.l.jGo) {
            aqVar.l(this.jRz);
        } else if (getType() == com.baidu.tieba.pb.data.l.jGp) {
            aqVar.u(this.jRA);
        }
        return aqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, aq aqVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tieba.pb.data.l) aqVar);
        if (aqVar != null) {
            cHl();
            lVar.jGu = this.jIA.jFb;
            aqVar.a(lVar);
        }
        return view;
    }

    private void cHl() {
        if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCx() != null && this.jIA.jFe && !this.jRB) {
            this.jRB = true;
            boolean isLike = this.jIA.cCx().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 9).dh("obj_id", this.jIA.cCx().getForumId()).ag("thread_type", this.jIA.cCy().getThreadType()).dh("tid", this.jIA.cCy().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 10).dh("obj_id", this.jIA.cCx().getForumId()).ag("thread_type", this.jIA.cCy().getThreadType()).dh("tid", this.jIA.cCy().getId()));
            }
        }
    }

    public void onDestroy() {
        this.jRB = false;
        MessageManager.getInstance().unRegisterListener(this.jRz);
        MessageManager.getInstance().unRegisterListener(this.jRA);
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.jMC = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jIA = eVar;
    }
}
