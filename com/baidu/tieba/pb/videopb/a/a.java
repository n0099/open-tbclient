package com.baidu.tieba.pb.videopb.a;

import android.arch.lifecycle.y;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView gqN;
    private f iDs;
    private DetailInfoFragment iYc;
    private List<m> iYd;
    private c iYe;
    private com.baidu.tieba.pb.pb.main.adapter.c iYf;
    private b iYg;
    private g iYh;
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private View.OnClickListener iYi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.iDs == null || a.this.iDs.ciS() == null || a.this.iDs.ciS().azO() == 0) {
                    a.this.iYc.clL().clc();
                    a.this.iYc.clL().qO(false);
                } else {
                    ((e) y.b(a.this.iYc.clM()).l(e.class)).setCurrentTab(VideoPbFragment.iWV);
                }
                String str = "";
                if (a.this.iDs != null) {
                    str = a.this.iDs.getThreadId();
                }
                TiebaStatic.log(new an("c12942").Z("obj_type", 1).Z("obj_locate", 4).cp("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.iYc.clL().crh();
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iYc = detailInfoFragment;
        this.gqN = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iYe = new c(detailInfoFragment.clL(), PostData.kfq);
        this.iYf = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.clL(), l.iAO);
        this.iYf.setOnClickListener(this.iYi);
        this.iYg = new b(detailInfoFragment.getContext(), p.TYPE);
        this.iYh = new g(detailInfoFragment.clL(), com.baidu.tbadk.core.data.l.cJQ);
        this.iYh.pD(true);
        this.apl.add(this.iYe);
        this.apl.add(this.iYf);
        this.apl.add(this.iYg);
        this.apl.add(this.iYh);
        bdTypeRecyclerView.addAdapters(this.apl);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.iDs = fVar;
            if (this.gqN != null) {
                this.gqN.setVisibility(0);
            }
            this.iYe.setPbData(fVar);
            this.iYh.setPbData(fVar);
            this.gqN.setData(H(fVar));
        }
    }

    private List<m> H(f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        this.iYd = new ArrayList();
        Iterator<PostData> it = fVar.ciU().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cJz() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.ciZ() != null) {
            postData = fVar.ciZ();
        }
        if (postData != null) {
            this.iYd.add(postData);
        }
        l lVar = new l();
        lVar.Np = fVar.ciS();
        lVar.ps(true);
        lVar.iAQ = true;
        this.iYd.add(lVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.iYc.ckc().cjS()) || !this.iYc.ckc().cme())) {
            p pVar = new p();
            bj bjVar = new bj();
            bjVar.tid = fVar.getThreadId();
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForumId(), 0L));
            bf bfVar = new bf();
            bfVar.avatar = fVar.getForum().getImage_url();
            bfVar.forumName = fVar.getForum().getName();
            bfVar.memberNum = fVar.getForum().getMember_num();
            bfVar.postNum = fVar.getForum().getPost_num();
            bfVar.forumId = fVar.getForumId();
            bjVar.a(bfVar);
            pVar.cNb = bjVar;
            this.iYd.add(pVar);
            lVar.ps(false);
            lVar.iAQ = false;
        }
        if (fVar.cjr() != null) {
            for (com.baidu.tbadk.core.data.l lVar2 : fVar.cjr()) {
                this.iYd.add(lVar2);
            }
        }
        return this.iYd;
    }

    public void notifyDataSetChanged() {
        if (this.gqN != null && this.gqN.getAdapter() != null) {
            this.gqN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void crZ() {
        if (this.iYe != null) {
            this.iYe.notifyDataSetChanged();
        }
    }
}
