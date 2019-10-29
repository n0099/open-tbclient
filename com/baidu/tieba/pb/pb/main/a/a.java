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
public class a extends k<j, C0485a> {
    private View.OnClickListener cpK;
    private b hYa;
    private final LinkedList<C0485a> hYb;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hYb = new LinkedList<>();
        this.hYa = new b(this.hNY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public C0485a b(ViewGroup viewGroup) {
        C0485a c0485a = new C0485a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.hYb.add(c0485a);
        return c0485a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, C0485a c0485a) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) c0485a);
        if (jVar != null && c0485a != null) {
            c0485a.hYc.setOnClickOutListener(this.cpK);
            c0485a.hYc.setPostId(getPostId());
            c0485a.hYc.setForumId(getForumId());
            c0485a.a(jVar);
        }
        return view;
    }

    public void onDestroy() {
        bWs();
        if (this.hYa != null) {
            this.hYa.onDestroy();
        }
    }

    private void bWs() {
        Iterator<C0485a> it = this.hYb.iterator();
        while (it.hasNext()) {
            C0485a next = it.next();
            if (next != null && next.hYc != null) {
                next.hYc.onDestroy();
            }
        }
    }

    public void oz(String str) {
        Iterator<C0485a> it = this.hYb.iterator();
        while (it.hasNext()) {
            C0485a next = it.next();
            if (next != null && next.hYc != null) {
                next.hYc.oz(str);
            }
        }
    }

    private String getPostId() {
        bh bWt = bWt();
        return bWt != null ? bWt.aiW() : "";
    }

    private String getForumId() {
        return this.hNY.bRF() != null ? this.hNY.bRF().getForumId() : "";
    }

    private bh bWt() {
        if (this.hNY.bRF() == null || this.hNY.bRF().getPbData() == null) {
            return null;
        }
        return this.hNY.bRF().getPbData().bQz();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cpK = onClickListener;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0485a extends v.a {
        public PbThreadCommentAndPraiseInfoLayout hYc;
        public View hYd;

        public C0485a(View view) {
            super(view);
            if (view != null) {
                this.hYc = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.bXQ = 4;
                dVar.bXV = 7;
                this.hYc.setAgreeStatisticData(dVar);
                this.hYd = view.findViewById(R.id.bottom_divider_line);
                this.hYd.setVisibility(0);
            }
        }

        public void a(j jVar) {
            if (jVar != null && jVar.cry != null) {
                if (jVar.cry.akv() != null) {
                    jVar.cry.akv().postId = jVar.cry.aiW();
                }
                this.hYc.setData(jVar.cry);
                this.hYd.setVisibility(jVar.bRg() ? 0 : 8);
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            am.setBackgroundColor(this.hYd, R.color.cp_bg_line_e);
            this.hYc.onChangeSkinType();
        }
    }
}
