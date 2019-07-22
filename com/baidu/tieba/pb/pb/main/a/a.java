package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends k<j, C0374a> {
    private View.OnClickListener cat;
    private final LinkedList<C0374a> hWA;
    private b hWz;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hWA = new LinkedList<>();
        this.hWz = new b(this.hMD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public C0374a onCreateViewHolder(ViewGroup viewGroup) {
        C0374a c0374a = new C0374a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hWA.add(c0374a);
        return c0374a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, C0374a c0374a) {
        super.onFillViewHolder(i, view, viewGroup, jVar, c0374a);
        if (jVar != null && c0374a != null) {
            c0374a.hWB.setOnClickOutListener(this.cat);
            c0374a.hWB.setPostId(getPostId());
            c0374a.hWB.setForumId(getForumId());
            c0374a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bYm();
        if (this.hWz != null) {
            this.hWz.onDestroy();
        }
    }

    private void bYm() {
        Iterator<C0374a> it = this.hWA.iterator();
        while (it.hasNext()) {
            C0374a next = it.next();
            if (next != null && next.hWB != null) {
                next.hWB.onDestroy();
            }
        }
    }

    public void oS(String str) {
        Iterator<C0374a> it = this.hWA.iterator();
        while (it.hasNext()) {
            C0374a next = it.next();
            if (next != null && next.hWB != null) {
                next.hWB.oS(str);
            }
        }
    }

    private String getPostId() {
        bg bYn = bYn();
        return bYn != null ? bYn.aeN() : "";
    }

    private String getForumId() {
        return this.hMD.bTD() != null ? this.hMD.bTD().getForumId() : "";
    }

    private bg bYn() {
        if (this.hMD.bTD() == null || this.hMD.bTD().getPbData() == null) {
            return null;
        }
        return this.hMD.bTD().getPbData().bSx();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cat = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0374a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hWB;
        public View hWC;

        public C0374a(View view) {
            super(view);
            if (view != null) {
                this.hWB = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bFz = 4;
                dVar.bFE = 7;
                this.hWB.setAgreeStatisticData(dVar);
                this.hWC = view.findViewById(R.id.bottom_divider_line);
                this.hWC.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.ccj != null) {
                if (jVar.ccj.agn() != null) {
                    jVar.ccj.agn().postId = jVar.ccj.aeN();
                }
                this.hWB.setData(jVar.ccj);
                this.hWC.setVisibility(jVar.bTe() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.l(this.hWC, R.color.cp_bg_line_e);
            this.hWB.onChangeSkinType();
        }
    }
}
