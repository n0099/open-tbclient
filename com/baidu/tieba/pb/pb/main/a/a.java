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
    private b hQi;
    private final LinkedList<C0375a> hQj;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hQj = new LinkedList<>();
        this.hQi = new b(this.hGm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public C0375a onCreateViewHolder(ViewGroup viewGroup) {
        C0375a c0375a = new C0375a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hQj.add(c0375a);
        return c0375a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, C0375a c0375a) {
        super.onFillViewHolder(i, view, viewGroup, jVar, c0375a);
        if (jVar != null && c0375a != null) {
            c0375a.hQk.setOnClickOutListener(this.bZq);
            c0375a.hQk.setPostId(getPostId());
            c0375a.hQk.setForumId(getForumId());
            c0375a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bVu();
        if (this.hQi != null) {
            this.hQi.onDestroy();
        }
    }

    private void bVu() {
        Iterator<C0375a> it = this.hQj.iterator();
        while (it.hasNext()) {
            C0375a next = it.next();
            if (next != null && next.hQk != null) {
                next.hQk.onDestroy();
            }
        }
    }

    public void oC(String str) {
        Iterator<C0375a> it = this.hQj.iterator();
        while (it.hasNext()) {
            C0375a next = it.next();
            if (next != null && next.hQk != null) {
                next.hQk.oC(str);
            }
        }
    }

    private String getPostId() {
        bg bVv = bVv();
        return bVv != null ? bVv.adL() : "";
    }

    private String getForumId() {
        return this.hGm.bQO() != null ? this.hGm.bQO().getForumId() : "";
    }

    private bg bVv() {
        if (this.hGm.bQO() == null || this.hGm.bQO().getPbData() == null) {
            return null;
        }
        return this.hGm.bQO().getPbData().bPI();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bZq = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0375a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hQk;
        public View hQl;

        public C0375a(View view) {
            super(view);
            if (view != null) {
                this.hQk = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bEy = 4;
                dVar.bED = 7;
                this.hQk.setAgreeStatisticData(dVar);
                this.hQl = view.findViewById(R.id.bottom_divider_line);
                this.hQl.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.cbg != null) {
                if (jVar.cbg.afl() != null) {
                    jVar.cbg.afl().postId = jVar.cbg.adL();
                }
                this.hQk.setData(jVar.cbg);
                this.hQl.setVisibility(jVar.bQp() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            al.l(this.hQl, R.color.cp_bg_line_e);
            this.hQk.onChangeSkinType();
        }
    }
}
