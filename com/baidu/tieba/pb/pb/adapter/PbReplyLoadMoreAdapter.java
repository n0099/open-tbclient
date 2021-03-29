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
import d.b.i0.c2.k.e.m;
import d.b.i0.c2.o.b;
/* loaded from: classes4.dex */
public class PbReplyLoadMoreAdapter extends m<PostData, ReplyLoadMoreViewHolder> {
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public static class ReplyLoadMoreViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f19493a;

        public ReplyLoadMoreViewHolder(View view) {
            super(view);
            this.f19493a = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void b() {
            SkinManager.setViewTextColor(this.f19493a, R.color.CAM_X0109);
        }

        public void c(PostData postData) {
            if (postData == null) {
                return;
            }
            if (postData.D) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f19493a.setCompoundDrawables(null, null, drawable, null);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_emotion_smallarrow_down);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f19493a.setCompoundDrawables(null, null, drawable2, null);
        }
    }

    public PbReplyLoadMoreAdapter(b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public ReplyLoadMoreViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42358e).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.s);
        ReplyLoadMoreViewHolder replyLoadMoreViewHolder = new ReplyLoadMoreViewHolder(inflate);
        replyLoadMoreViewHolder.b();
        return replyLoadMoreViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, PostData postData, ReplyLoadMoreViewHolder replyLoadMoreViewHolder) {
        replyLoadMoreViewHolder.c(postData);
        return replyLoadMoreViewHolder.a();
    }

    public void m0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
