package com.baidu.tieba.pb.videopb.a;

import android.arch.lifecycle.y;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView gsO;
    private e iEZ;
    private DetailInfoFragment iZD;
    private List<m> iZE;
    private c iZF;
    private com.baidu.tieba.pb.pb.main.adapter.c iZG;
    private b iZH;
    private g iZI;
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private View.OnClickListener iZJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.iEZ == null || a.this.iEZ.cks() == null || a.this.iEZ.cks().aCd() == 0) {
                    a.this.iZD.cnf().cmx();
                    a.this.iZD.cnf().qR(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.iZD.cng()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.iYk);
                }
                String str = "";
                if (a.this.iEZ != null) {
                    str = a.this.iEZ.getThreadId();
                }
                TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cy("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.iZD.cnf().qQ(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZD = detailInfoFragment;
        this.gsO = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZF = new c(detailInfoFragment.cnf(), PostData.kgq);
        this.iZG = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cnf(), k.iCH);
        this.iZG.setOnClickListener(this.iZJ);
        this.iZH = new b(detailInfoFragment.getContext(), o.TYPE);
        this.iZI = new g(detailInfoFragment.cnf(), l.cNT);
        this.iZI.pG(true);
        this.asE.add(this.iZF);
        this.asE.add(this.iZG);
        this.asE.add(this.iZH);
        this.asE.add(this.iZI);
        bdTypeRecyclerView.addAdapters(this.asE);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.iEZ = eVar;
            if (this.gsO != null) {
                this.gsO.setVisibility(0);
            }
            this.iZF.setPbData(eVar);
            this.iZI.setPbData(eVar);
            this.gsO.setData(J(eVar));
        }
    }

    private List<m> J(e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        this.iZE = new ArrayList();
        Iterator<PostData> it = eVar.cku().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cKY() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.ckz() != null) {
            postData = eVar.ckz();
        }
        if (postData != null) {
            this.iZE.add(postData);
        }
        k kVar = new k(eVar.cks(), eVar.getAnti());
        kVar.pv(true);
        kVar.iCJ = true;
        this.iZE.add(kVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.iZD.clz().clq()) || !this.iZD.clz().cny())) {
            o oVar = new o();
            bj bjVar = new bj();
            bjVar.tid = eVar.getThreadId();
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForumId(), 0L));
            bf bfVar = new bf();
            bfVar.avatar = eVar.getForum().getImage_url();
            bfVar.forumName = eVar.getForum().getName();
            bfVar.memberNum = eVar.getForum().getMember_num();
            bfVar.postNum = eVar.getForum().getPost_num();
            bfVar.forumId = eVar.getForumId();
            bjVar.a(bfVar);
            oVar.cRe = bjVar;
            this.iZE.add(oVar);
            kVar.pv(false);
            kVar.iCJ = false;
        }
        if (eVar.ckP() != null) {
            for (l lVar : eVar.ckP()) {
                this.iZE.add(lVar);
            }
        }
        return this.iZE;
    }

    public void notifyDataSetChanged() {
        if (this.gsO != null && this.gsO.getAdapter() != null) {
            this.gsO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cts() {
        if (this.iZF != null) {
            this.iZF.notifyDataSetChanged();
        }
    }
}
