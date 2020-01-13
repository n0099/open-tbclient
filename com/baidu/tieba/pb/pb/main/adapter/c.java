package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.m;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class c extends m<l, a> {
    private static int WJ;
    private View.OnClickListener dcw;
    private d iOT;
    private final LinkedList<a> iOU;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iOU = new LinkedList<>();
        if (bVar != null && bVar.ckc() != null) {
            WJ = bVar.ckc().cmO();
        }
        this.iOT = new d(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.iOU.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (l) aVar);
        if (lVar != null && aVar != null) {
            aVar.iOV.setOnClickOutListener(this.dcw);
            aVar.iOV.setPostId(getPostId());
            aVar.iOV.setForumId(getForumId());
            aVar.b(lVar);
        }
        return view;
    }

    public void onDestroy() {
        cpj();
        if (this.iOT != null) {
            this.iOT.onDestroy();
        }
    }

    private void cpj() {
        Iterator<a> it = this.iOU.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iOV != null) {
                next.iOV.onDestroy();
            }
        }
    }

    public void tH(String str) {
        Iterator<a> it = this.iOU.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.iOV != null) {
                next.iOV.tH(str);
            }
        }
    }

    private String getPostId() {
        bj cpk = cpk();
        return cpk != null ? cpk.aAn() : "";
    }

    private String getForumId() {
        return this.iEA.ckc() != null ? this.iEA.ckc().getForumId() : "";
    }

    private bj cpk() {
        if (this.iEA.ckc() == null || this.iEA.ckc().getPbData() == null) {
            return null;
        }
        return this.iEA.ckc().getPbData().ciS();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dcw = onClickListener;
    }

    /* loaded from: classes7.dex */
    public static class a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout iOV;
        public View iOW;
        private int iOX;

        public a(View view) {
            super(view);
            if (view != null) {
                this.iOV = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cJx = 4;
                dVar.cJD = 7;
                dVar.cJy = this.iOX;
                dVar.cJB = c.WJ;
                this.iOV.setAgreeStatisticData(dVar);
                this.iOW = view.findViewById(R.id.bottom_divider_line);
                this.iOW.setVisibility(0);
            }
        }

        public void b(l lVar) {
            if (lVar != null && lVar.Np != null) {
                if (lVar.Np.aBM() != null) {
                    lVar.Np.aBM().postId = lVar.Np.aAn();
                }
                this.iOV.setData(lVar.Np);
                this.iOW.setVisibility(lVar.cjD() ? 0 : 8);
                if (lVar.Np.aAX() && lVar.Np.aAo() != null) {
                    this.iOX = 2;
                } else {
                    this.iOX = 1;
                }
                if (lVar.iAQ) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.iOW, R.color.cp_bg_line_b);
            this.iOV.onChangeSkinType();
        }
    }
}
