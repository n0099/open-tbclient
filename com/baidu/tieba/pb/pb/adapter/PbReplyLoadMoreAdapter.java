package com.baidu.tieba.pb.pb.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.n0.e2.k.e.o;
import d.a.n0.e2.o.i;
/* loaded from: classes3.dex */
public class PbReplyLoadMoreAdapter extends o<PostData, ReplyLoadMoreViewHolder> {
    public View.OnClickListener s;

    /* loaded from: classes3.dex */
    public static class ReplyLoadMoreViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f18840a;

        public ReplyLoadMoreViewHolder(View view) {
            super(view);
            this.f18840a = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void b() {
            SkinManager.setViewTextColor(this.f18840a, R.color.CAM_X0109);
        }

        public void c(PostData postData) {
            if (postData == null) {
                return;
            }
            if (postData.D) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f18840a.setCompoundDrawables(null, null, drawable, null);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_emotion_smallarrow_down);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f18840a.setCompoundDrawables(null, null, drawable2, null);
        }
    }

    public PbReplyLoadMoreAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ReplyLoadMoreViewHolder P(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f39228e).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.s);
        ReplyLoadMoreViewHolder replyLoadMoreViewHolder = new ReplyLoadMoreViewHolder(inflate);
        replyLoadMoreViewHolder.b();
        return replyLoadMoreViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.e2.k.e.o, d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, PostData postData, ReplyLoadMoreViewHolder replyLoadMoreViewHolder) {
        replyLoadMoreViewHolder.c(postData);
        return replyLoadMoreViewHolder.a();
    }

    public void i0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
