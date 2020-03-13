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
    private BdTypeRecyclerView gtd;
    private e iFn;
    private DetailInfoFragment iZR;
    private List<m> iZS;
    private c iZT;
    private com.baidu.tieba.pb.pb.main.adapter.c iZU;
    private b iZV;
    private g iZW;
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private View.OnClickListener iZX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.iFn == null || a.this.iFn.ckv() == null || a.this.iFn.ckv().aCf() == 0) {
                    a.this.iZR.cni().cmA();
                    a.this.iZR.cni().qR(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.iZR.cnj()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.iYy);
                }
                String str = "";
                if (a.this.iFn != null) {
                    str = a.this.iFn.getThreadId();
                }
                TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cy("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.iZR.cni().qQ(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZR = detailInfoFragment;
        this.gtd = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZT = new c(detailInfoFragment.cni(), PostData.kgE);
        this.iZU = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cni(), k.iCV);
        this.iZU.setOnClickListener(this.iZX);
        this.iZV = new b(detailInfoFragment.getContext(), o.TYPE);
        this.iZW = new g(detailInfoFragment.cni(), l.cNV);
        this.iZW.pG(true);
        this.asF.add(this.iZT);
        this.asF.add(this.iZU);
        this.asF.add(this.iZV);
        this.asF.add(this.iZW);
        bdTypeRecyclerView.addAdapters(this.asF);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.iFn = eVar;
            if (this.gtd != null) {
                this.gtd.setVisibility(0);
            }
            this.iZT.setPbData(eVar);
            this.iZW.setPbData(eVar);
            this.gtd.setData(J(eVar));
        }
    }

    private List<m> J(e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        this.iZS = new ArrayList();
        Iterator<PostData> it = eVar.ckx().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cLb() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.ckC() != null) {
            postData = eVar.ckC();
        }
        if (postData != null) {
            this.iZS.add(postData);
        }
        k kVar = new k(eVar.ckv(), eVar.getAnti());
        kVar.pv(true);
        kVar.iCX = true;
        this.iZS.add(kVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.iZR.clC().clt()) || !this.iZR.clC().cnB())) {
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
            oVar.cRg = bjVar;
            this.iZS.add(oVar);
            kVar.pv(false);
            kVar.iCX = false;
        }
        if (eVar.ckS() != null) {
            for (l lVar : eVar.ckS()) {
                this.iZS.add(lVar);
            }
        }
        return this.iZS;
    }

    public void notifyDataSetChanged() {
        if (this.gtd != null && this.gtd.getAdapter() != null) {
            this.gtd.getListAdapter().notifyDataSetChanged();
        }
    }

    public void ctv() {
        if (this.iZT != null) {
            this.iZT.notifyDataSetChanged();
        }
    }
}
