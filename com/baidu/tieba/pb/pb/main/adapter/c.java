package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.l;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class c extends l<k, a> {
    private static int aqP;
    private View.OnClickListener dGz;
    private d jCm;
    private final LinkedList<a> jCn;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jCn = new LinkedList<>();
        if (bVar != null && bVar.cwD() != null) {
            aqP = bVar.cwD().czj();
        }
        this.jCm = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.jCn.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) aVar);
        if (kVar != null && aVar != null) {
            aVar.jCo.setOnClickOutListener(this.dGz);
            aVar.jCo.setPostId(getPostId());
            aVar.jCo.setForumId(getForumId());
            aVar.b(kVar);
        }
        return view;
    }

    public void onDestroy() {
        cBF();
        if (this.jCm != null) {
            this.jCm.onDestroy();
        }
    }

    private void cBF() {
        Iterator<a> it = this.jCn.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.jCo != null) {
                next.jCo.onDestroy();
            }
        }
    }

    public void vl(String str) {
        if (this.jCn.size() > 0) {
            Iterator<a> it = this.jCn.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.jCo != null) {
                    next.jCo.vl(str);
                }
            }
        } else if (cBG() != null) {
            this.jCm.d(cBG().aMs());
        }
    }

    private String getPostId() {
        bj cBG = cBG();
        return cBG != null ? cBG.aKU() : "";
    }

    private String getForumId() {
        return this.jsa.cwD() != null ? this.jsa.cwD().getForumId() : "";
    }

    private bj cBG() {
        if (this.jsa.cwD() == null || this.jsa.cwD().getPbData() == null) {
            return null;
        }
        return this.jsa.cwD().getPbData().cvu();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dGz = onClickListener;
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        public PbThreadCommentAndPraiseInfoLayout jCo;
        public View jCp;
        private int jCq;

        public a(View view) {
            super(view);
            if (view != null) {
                this.jCo = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.dmT = 4;
                dVar.dmZ = 7;
                dVar.dmU = this.jCq;
                dVar.dmX = c.aqP;
                this.jCo.setAgreeStatisticData(dVar);
                this.jCp = view.findViewById(R.id.bottom_divider_line);
                this.jCp.setVisibility(0);
            }
        }

        public void b(k kVar) {
            if (kVar != null && kVar.aIw() != null) {
                bj aIw = kVar.aIw();
                if (aIw.aMs() != null) {
                    aIw.aMs().postId = aIw.aKU();
                }
                this.jCo.a(aIw, kVar.getAnti());
                this.jCp.setVisibility(kVar.cwf() ? 0 : 8);
                if (aIw.aJr() && aIw.aKV() != null) {
                    this.jCq = 2;
                } else {
                    this.jCq = 1;
                }
                if (kVar.joE) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.jCp, R.color.cp_bg_line_b);
            this.jCo.onChangeSkinType();
        }
    }
}
