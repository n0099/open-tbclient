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
    private View.OnClickListener aLl;
    private com.baidu.tieba.pb.data.e kck;
    private SortSwitchButton.a kgn;
    private BdUniqueId klp;
    private BdUniqueId klq;
    private boolean klr;

    public ap(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.klr = false;
        this.klp = BdUniqueId.gen();
        this.klq = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cl */
    public aq b(ViewGroup viewGroup) {
        aq aqVar = new aq(this.kdO.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        aqVar.v(this.kbv.kfl);
        aqVar.WY = false;
        aqVar.S(this.aLl);
        aqVar.setOnSwitchChangeListener(this.kgn);
        if (getType() == com.baidu.tieba.pb.data.l.jZY) {
            aqVar.l(this.klp);
        } else if (getType() == com.baidu.tieba.pb.data.l.jZZ) {
            aqVar.u(this.klq);
        }
        return aqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, aq aqVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tieba.pb.data.l) aqVar);
        if (aqVar != null) {
            cLC();
            lVar.kae = this.kck.jYL;
            aqVar.a(lVar);
        }
        return view;
    }

    private void cLC() {
        if (this.kck != null && this.kck.cGN() != null && this.kck.cGM() != null && this.kck.jYO && !this.klr) {
            this.klr = true;
            boolean isLike = this.kck.cGM().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("common_exp").dk("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 9).dk("obj_id", this.kck.cGM().getForumId()).ag("thread_type", this.kck.cGN().getThreadType()).dk("tid", this.kck.cGN().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("common_exp").dk("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 10).dk("obj_id", this.kck.cGM().getForumId()).ag("thread_type", this.kck.cGN().getThreadType()).dk("tid", this.kck.cGN().getId()));
            }
        }
    }

    public void onDestroy() {
        this.klr = false;
        MessageManager.getInstance().unRegisterListener(this.klp);
        MessageManager.getInstance().unRegisterListener(this.klq);
    }

    public void z(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.kgn = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.kck = eVar;
    }
}
