package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bh;
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
public class a extends k<j, C0480a> {
    private View.OnClickListener coS;
    private b hXj;
    private final LinkedList<C0480a> hXk;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hXk = new LinkedList<>();
        this.hXj = new b(this.hNh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public C0480a b(ViewGroup viewGroup) {
        C0480a c0480a = new C0480a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hXk.add(c0480a);
        return c0480a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, C0480a c0480a) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) c0480a);
        if (jVar != null && c0480a != null) {
            c0480a.hXl.setOnClickOutListener(this.coS);
            c0480a.hXl.setPostId(getPostId());
            c0480a.hXl.setForumId(getForumId());
            c0480a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bWq();
        if (this.hXj != null) {
            this.hXj.onDestroy();
        }
    }

    private void bWq() {
        Iterator<C0480a> it = this.hXk.iterator();
        while (it.hasNext()) {
            C0480a next = it.next();
            if (next != null && next.hXl != null) {
                next.hXl.onDestroy();
            }
        }
    }

    public void oz(String str) {
        Iterator<C0480a> it = this.hXk.iterator();
        while (it.hasNext()) {
            C0480a next = it.next();
            if (next != null && next.hXl != null) {
                next.hXl.oz(str);
            }
        }
    }

    private String getPostId() {
        bh bWr = bWr();
        return bWr != null ? bWr.aiU() : "";
    }

    private String getForumId() {
        return this.hNh.bRD() != null ? this.hNh.bRD().getForumId() : "";
    }

    private bh bWr() {
        if (this.hNh.bRD() == null || this.hNh.bRD().getPbData() == null) {
            return null;
        }
        return this.hNh.bRD().getPbData().bQx();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.coS = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0480a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hXl;
        public View hXm;

        public C0480a(View view) {
            super(view);
            if (view != null) {
                this.hXl = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bWZ = 4;
                dVar.bXe = 7;
                this.hXl.setAgreeStatisticData(dVar);
                this.hXm = view.findViewById(R.id.bottom_divider_line);
                this.hXm.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.cqG != null) {
                if (jVar.cqG.akt() != null) {
                    jVar.cqG.akt().postId = jVar.cqG.aiU();
                }
                this.hXl.setData(jVar.cqG);
                this.hXm.setVisibility(jVar.bRe() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.hXm, R.color.cp_bg_line_e);
            this.hXl.onChangeSkinType();
        }
    }
}
