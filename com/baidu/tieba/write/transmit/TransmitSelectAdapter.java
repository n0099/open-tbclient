package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.o0.m1.a;
import d.a.o0.w3.q.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes5.dex */
public class TransmitSelectAdapter extends d.a.c.k.e.a<c, TransmitSelectViewHolder> {
    public d.a.o0.m1.a m;
    public ArrayList<HotTopicBussinessData> n;
    public List<TransmitForumData> o;
    public w p;
    public a.b q;

    /* loaded from: classes5.dex */
    public static class TransmitSelectViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22050a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22051b;

        public TransmitSelectViewHolder(View view) {
            super(view);
            this.f22050a = (TextView) view.findViewById(R.id.select_by_self);
            this.f22051b = (ImageView) view.findViewById(R.id.add_icon);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements w {
        public a() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if (!j.z()) {
                l.L(TransmitSelectAdapter.this.f43012e, R.string.neterror);
            }
            TiebaStatic.log(new StatisticItem("c12053"));
            if (!ListUtils.isEmpty(TransmitSelectAdapter.this.n)) {
                TransmitSelectAdapter.this.v0();
                return;
            }
            TransmitSelectAdapter transmitSelectAdapter = TransmitSelectAdapter.this;
            transmitSelectAdapter.m = new d.a.o0.m1.a(transmitSelectAdapter.f43016i);
            TransmitSelectAdapter.this.m.g(TransmitSelectAdapter.this.q);
            TransmitSelectAdapter.this.m.f();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.o0.m1.a.b
        public void a(boolean z, int i2, String str, List<ForumInfo> list) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(list) > 0) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ForumInfo forumInfo = list.get(i3);
                    if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !TransmitSelectAdapter.this.t0(forumInfo.forum_id.longValue())) {
                        arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                    }
                }
                if (TransmitSelectAdapter.this.n == null) {
                    TransmitSelectAdapter.this.n = arrayList;
                    TransmitSelectAdapter.this.v0();
                }
            }
        }
    }

    public TransmitSelectAdapter(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        this.p = new a();
        this.q = new b();
        a0(this.p);
        this.o = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, c cVar, TransmitSelectViewHolder transmitSelectViewHolder) {
        x0(i2, view, viewGroup, cVar, transmitSelectViewHolder);
        return view;
    }

    public void q0() {
        d.a.o0.m1.a aVar = this.m;
        if (aVar != null) {
            aVar.e();
        }
    }

    public HotTopicBussinessData s0(int i2) {
        if (ListUtils.isEmpty(this.n)) {
            return null;
        }
        return this.n.remove(i2);
    }

    public final boolean t0(long j) {
        List<TransmitForumData> list = this.o;
        if (list == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : list) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    public final void v0() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.f43012e, 25005, this.n);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicChangeActivityConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: w0 */
    public TransmitSelectViewHolder Q(ViewGroup viewGroup) {
        return new TransmitSelectViewHolder(LayoutInflater.from(this.f43012e).inflate(R.layout.transmit_select_layout, (ViewGroup) null));
    }

    public View x0(int i2, View view, ViewGroup viewGroup, c cVar, TransmitSelectViewHolder transmitSelectViewHolder) {
        SkinManager.setViewTextColor(transmitSelectViewHolder.f22050a, R.color.CAM_X0302);
        SkinManager.setImageResource(transmitSelectViewHolder.f22051b, R.drawable.icon_post_add_ba_n);
        return view;
    }
}
