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
    private com.baidu.tieba.pb.data.e jHu;
    private SortSwitchButton.a jLw;
    private BdUniqueId jQt;
    private BdUniqueId jQu;
    private boolean jQv;

    public ap(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jQv = false;
        this.jQt = BdUniqueId.gen();
        this.jQu = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bZ */
    public aq b(ViewGroup viewGroup) {
        aq aqVar = new aq(this.jJa.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        aqVar.v(this.jGF.jKu);
        aqVar.Wt = false;
        aqVar.R(this.aIH);
        aqVar.setOnSwitchChangeListener(this.jLw);
        if (getType() == com.baidu.tieba.pb.data.l.jFi) {
            aqVar.l(this.jQt);
        } else if (getType() == com.baidu.tieba.pb.data.l.jFj) {
            aqVar.u(this.jQu);
        }
        return aqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, aq aqVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tieba.pb.data.l) aqVar);
        if (aqVar != null) {
            cGV();
            lVar.jFo = this.jHu.jDV;
            aqVar.a(lVar);
        }
        return view;
    }

    private void cGV() {
        if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCh() != null && this.jHu.jDY && !this.jQv) {
            this.jQv = true;
            boolean isLike = this.jHu.cCh().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 9).dh("obj_id", this.jHu.cCh().getForumId()).ag("thread_type", this.jHu.cCi().getThreadType()).dh("tid", this.jHu.cCi().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 10).dh("obj_id", this.jHu.cCh().getForumId()).ag("thread_type", this.jHu.cCi().getThreadType()).dh("tid", this.jHu.cCi().getId()));
            }
        }
    }

    public void onDestroy() {
        this.jQv = false;
        MessageManager.getInstance().unRegisterListener(this.jQt);
        MessageManager.getInstance().unRegisterListener(this.jQu);
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.jLw = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jHu = eVar;
    }
}
