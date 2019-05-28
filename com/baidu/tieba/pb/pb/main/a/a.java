package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends k<j, C0375a> {
    private View.OnClickListener bZq;
    private b hQl;
    private final LinkedList<C0375a> hQm;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hQm = new LinkedList<>();
        this.hQl = new b(this.hGp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0375a onCreateViewHolder(ViewGroup viewGroup) {
        C0375a c0375a = new C0375a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hQm.add(c0375a);
        return c0375a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, C0375a c0375a) {
        super.onFillViewHolder(i, view, viewGroup, jVar, c0375a);
        if (jVar != null && c0375a != null) {
            c0375a.hQn.setOnClickOutListener(this.bZq);
            c0375a.hQn.setPostId(getPostId());
            c0375a.hQn.setForumId(getForumId());
            c0375a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bVx();
        if (this.hQl != null) {
            this.hQl.onDestroy();
        }
    }

    private void bVx() {
        Iterator<C0375a> it = this.hQm.iterator();
        while (it.hasNext()) {
            C0375a next = it.next();
            if (next != null && next.hQn != null) {
                next.hQn.onDestroy();
            }
        }
    }

    public void oC(String str) {
        Iterator<C0375a> it = this.hQm.iterator();
        while (it.hasNext()) {
            C0375a next = it.next();
            if (next != null && next.hQn != null) {
                next.hQn.oC(str);
            }
        }
    }

    private String getPostId() {
        bg bVy = bVy();
        return bVy != null ? bVy.adL() : "";
    }

    private String getForumId() {
        return this.hGp.bQR() != null ? this.hGp.bQR().getForumId() : "";
    }

    private bg bVy() {
        if (this.hGp.bQR() == null || this.hGp.bQR().getPbData() == null) {
            return null;
        }
        return this.hGp.bQR().getPbData().bPL();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bZq = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0375a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hQn;
        public View hQo;

        public C0375a(View view) {
            super(view);
            if (view != null) {
                this.hQn = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bEy = 4;
                dVar.bED = 7;
                this.hQn.setAgreeStatisticData(dVar);
                this.hQo = view.findViewById(R.id.bottom_divider_line);
                this.hQo.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.cbg != null) {
                if (jVar.cbg.afl() != null) {
                    jVar.cbg.afl().postId = jVar.cbg.adL();
                }
                this.hQn.setData(jVar.cbg);
                this.hQo.setVisibility(jVar.bQs() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hQo, R.color.cp_bg_line_e);
            this.hQn.onChangeSkinType();
        }
    }
}
