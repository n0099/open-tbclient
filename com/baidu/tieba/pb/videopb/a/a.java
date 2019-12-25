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
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView gnE;
    private DetailInfoFragment iUu;
    private List<m> iUv;
    private c iUw;
    private com.baidu.tieba.pb.pb.main.adapter.c iUx;
    private b iUy;
    private g iUz;
    private f izO;
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private View.OnClickListener iUA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.izO == null || a.this.izO.chK() == null || a.this.izO.chK().azv() == 0) {
                    a.this.iUu.ckD().cjU();
                } else {
                    ((e) y.b(a.this.iUu.ckE()).l(e.class)).setCurrentTab(VideoPbFragment.iTn);
                }
                String str = "";
                if (a.this.izO != null) {
                    str = a.this.izO.getThreadId();
                }
                TiebaStatic.log(new an("c12942").Z("obj_type", 1).Z("obj_locate", 4).cp("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.iUu.ckD().cpY();
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iUu = detailInfoFragment;
        this.gnE = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iUw = new c(detailInfoFragment.ckD(), PostData.kbI);
        this.iUx = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.ckD(), l.ixk);
        this.iUx.setOnClickListener(this.iUA);
        this.iUy = new b(detailInfoFragment.getContext(), p.TYPE);
        this.iUz = new g(detailInfoFragment.ckD(), com.baidu.tbadk.core.data.l.cJF);
        this.iUz.pr(true);
        this.aoz.add(this.iUw);
        this.aoz.add(this.iUx);
        this.aoz.add(this.iUy);
        this.aoz.add(this.iUz);
        bdTypeRecyclerView.addAdapters(this.aoz);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.izO = fVar;
            if (this.gnE != null) {
                this.gnE.setVisibility(0);
            }
            this.iUw.setPbData(fVar);
            this.iUz.setPbData(fVar);
            this.gnE.setData(H(fVar));
        }
    }

    private List<m> H(f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        this.iUv = new ArrayList();
        Iterator<PostData> it = fVar.chM().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cIt() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.chR() != null) {
            postData = fVar.chR();
        }
        if (postData != null) {
            this.iUv.add(postData);
        }
        l lVar = new l();
        lVar.Nl = fVar.chK();
        lVar.pg(true);
        lVar.ixm = true;
        this.iUv.add(lVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.iUu.ciU().ciK()) || !this.iUu.ciU().ckW())) {
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
            pVar.cMR = bjVar;
            this.iUv.add(pVar);
            lVar.pg(false);
            lVar.ixm = false;
        }
        if (fVar.cij() != null) {
            for (com.baidu.tbadk.core.data.l lVar2 : fVar.cij()) {
                this.iUv.add(lVar2);
            }
        }
        return this.iUv;
    }

    public void notifyDataSetChanged() {
        if (this.gnE != null && this.gnE.getAdapter() != null) {
            this.gnE.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cqQ() {
        if (this.iUw != null) {
            this.iUw.notifyDataSetChanged();
        }
    }
}
