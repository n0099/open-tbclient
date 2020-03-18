package com.baidu.tieba.pb.videopb.a;

import android.arch.lifecycle.y;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView gtH;
    private com.baidu.adp.widget.ListView.a hfS;
    private e iGO;
    private com.baidu.adp.widget.ListView.a iGo;
    private DetailInfoFragment jbr;
    private List<m> jbs;
    private c jbt;
    private com.baidu.tieba.pb.pb.main.adapter.c jbu;
    private b jbv;
    private g jbw;
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private View.OnClickListener jbx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.iGO == null || a.this.iGO.ckP() == null || a.this.iGO.ckP().aCi() == 0) {
                    a.this.jbr.cnD().cmV();
                    a.this.jbr.cnD().qX(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.jbr.cnE()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.iZZ);
                }
                String str = "";
                if (a.this.iGO != null) {
                    str = a.this.iGO.getThreadId();
                }
                TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cx("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.jbr.cnD().qW(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jbr = detailInfoFragment;
        this.gtH = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jbt = new c(detailInfoFragment.cnD(), PostData.kih);
        this.jbu = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cnD(), k.iEw);
        this.jbu.setOnClickListener(this.jbx);
        this.jbv = new b(detailInfoFragment.getContext(), o.TYPE);
        this.jbw = new g(detailInfoFragment.cnD(), l.cOi);
        this.jbw.pM(true);
        this.asP.add(this.jbt);
        this.asP.add(this.jbu);
        this.asP.add(this.jbv);
        this.asP.add(this.jbw);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.asP);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.hfS = r.cCQ().a(detailInfoFragment.cnD().getBaseFragmentActivity(), AdvertAppInfo.cMW);
        this.iGo = r.cCQ().a(detailInfoFragment.cnD().getBaseFragmentActivity(), AdvertAppInfo.cNa);
        this.asP.add(this.hfS);
        this.asP.add(this.iGo);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.iGO = eVar;
            if (this.gtH != null) {
                this.gtH.setVisibility(0);
            }
            this.jbt.setPbData(eVar);
            this.jbw.setPbData(eVar);
            this.gtH.setData(J(eVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<m> J(e eVar) {
        PostData postData;
        com.baidu.tieba.tbadkCore.data.m mVar;
        int i;
        int i2;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        int i3;
        int i4;
        int i5;
        if (eVar == null) {
            return null;
        }
        this.jbs = new ArrayList();
        Iterator<PostData> it = eVar.ckR().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cLv() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.ckW() != null) {
            postData = eVar.ckW();
        }
        if (postData != null) {
            this.jbs.add(postData);
        }
        k kVar = new k(eVar.ckP(), eVar.getAnti());
        kVar.pB(true);
        kVar.iEy = true;
        this.jbs.add(kVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.jbr.clX().clO()) || !this.jbr.clX().cnW())) {
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
            oVar.cRt = bjVar;
            this.jbs.add(oVar);
            kVar.pB(false);
            kVar.iEy = false;
        }
        List<com.baidu.tieba.tbadkCore.data.m> clr = eVar.clr();
        int i6 = -1;
        if (clr == null || clr.isEmpty()) {
            mVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.m mVar3 = clr.get(0);
            mVar = mVar3;
            i6 = mVar3.getPosition();
        }
        if (eVar.clm() != null) {
            int i7 = i6;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.m mVar4 = mVar;
            int i9 = 1;
            for (l lVar : eVar.clm()) {
                if (clr == null || i9 != i7) {
                    int i10 = i9;
                    i = i7;
                    i2 = i8;
                    mVar2 = mVar4;
                    i3 = i10;
                } else {
                    if (mVar4 != null) {
                        this.jbs.add(mVar4);
                        i8++;
                        if (mVar4.getType() != AdvertAppInfo.cMW) {
                            i4 = i8;
                            i5 = i9 + 1;
                            if (i4 >= clr.size()) {
                                com.baidu.tieba.tbadkCore.data.m mVar5 = clr.get(i4);
                                i3 = i5;
                                mVar2 = mVar5;
                                i = mVar5.getPosition();
                                i2 = i4;
                            } else {
                                i = i7;
                                i2 = i4;
                                int i11 = i5;
                                mVar2 = mVar4;
                                i3 = i11;
                            }
                        }
                    }
                    i4 = i8;
                    i5 = i9;
                    if (i4 >= clr.size()) {
                    }
                }
                this.jbs.add(lVar);
                int i12 = i3 + 1;
                mVar4 = mVar2;
                i8 = i2;
                i7 = i;
                i9 = i12;
            }
        }
        return this.jbs;
    }

    public void notifyDataSetChanged() {
        if (this.gtH != null && this.gtH.getAdapter() != null) {
            this.gtH.getListAdapter().notifyDataSetChanged();
        }
    }

    public void ctQ() {
        if (this.jbt != null) {
            this.jbt.notifyDataSetChanged();
        }
    }
}
