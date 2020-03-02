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
    private BdTypeRecyclerView gsQ;
    private e iFb;
    private DetailInfoFragment iZF;
    private List<m> iZG;
    private c iZH;
    private com.baidu.tieba.pb.pb.main.adapter.c iZI;
    private b iZJ;
    private g iZK;
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private View.OnClickListener iZL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.iFb == null || a.this.iFb.cku() == null || a.this.iFb.cku().aCf() == 0) {
                    a.this.iZF.cnh().cmz();
                    a.this.iZF.cnh().qR(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.iZF.cni()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.iYm);
                }
                String str = "";
                if (a.this.iFb != null) {
                    str = a.this.iFb.getThreadId();
                }
                TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cy("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.iZF.cnh().qQ(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZF = detailInfoFragment;
        this.gsQ = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZH = new c(detailInfoFragment.cnh(), PostData.kgs);
        this.iZI = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cnh(), k.iCJ);
        this.iZI.setOnClickListener(this.iZL);
        this.iZJ = new b(detailInfoFragment.getContext(), o.TYPE);
        this.iZK = new g(detailInfoFragment.cnh(), l.cNU);
        this.iZK.pG(true);
        this.asE.add(this.iZH);
        this.asE.add(this.iZI);
        this.asE.add(this.iZJ);
        this.asE.add(this.iZK);
        bdTypeRecyclerView.addAdapters(this.asE);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.iFb = eVar;
            if (this.gsQ != null) {
                this.gsQ.setVisibility(0);
            }
            this.iZH.setPbData(eVar);
            this.iZK.setPbData(eVar);
            this.gsQ.setData(J(eVar));
        }
    }

    private List<m> J(e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        this.iZG = new ArrayList();
        Iterator<PostData> it = eVar.ckw().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cLa() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.ckB() != null) {
            postData = eVar.ckB();
        }
        if (postData != null) {
            this.iZG.add(postData);
        }
        k kVar = new k(eVar.cku(), eVar.getAnti());
        kVar.pv(true);
        kVar.iCL = true;
        this.iZG.add(kVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.iZF.clB().cls()) || !this.iZF.clB().cnA())) {
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
            oVar.cRf = bjVar;
            this.iZG.add(oVar);
            kVar.pv(false);
            kVar.iCL = false;
        }
        if (eVar.ckR() != null) {
            for (l lVar : eVar.ckR()) {
                this.iZG.add(lVar);
            }
        }
        return this.iZG;
    }

    public void notifyDataSetChanged() {
        if (this.gsQ != null && this.gsQ.getAdapter() != null) {
            this.gsQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void ctu() {
        if (this.iZH != null) {
            this.iZH.notifyDataSetChanged();
        }
    }
}
