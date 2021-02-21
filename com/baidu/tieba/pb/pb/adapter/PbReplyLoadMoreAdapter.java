package com.baidu.tieba.pb.pb.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbReplyLoadMoreAdapter extends l<PostData, ReplyLoadMoreViewHolder> {
    private View.OnClickListener bGM;

    public PbReplyLoadMoreAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bGM = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public ReplyLoadMoreViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.bGM);
        ReplyLoadMoreViewHolder replyLoadMoreViewHolder = new ReplyLoadMoreViewHolder(inflate);
        replyLoadMoreViewHolder.bzn();
        return replyLoadMoreViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, ReplyLoadMoreViewHolder replyLoadMoreViewHolder) {
        replyLoadMoreViewHolder.setData(postData);
        return replyLoadMoreViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class ReplyLoadMoreViewHolder extends TypeAdapter.ViewHolder {
        private TextView lME;

        public ReplyLoadMoreViewHolder(View view) {
            super(view);
            this.lME = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void setData(PostData postData) {
            if (postData != null) {
                if (postData.nxy) {
                    Drawable drawable = ap.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.lME.setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                Drawable drawable2 = ap.getDrawable(R.drawable.icon_emotion_smallarrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.lME.setCompoundDrawables(null, null, drawable2, null);
            }
        }

        public void bzn() {
            ap.setViewTextColor(this.lME, R.color.CAM_X0109);
        }
    }
}
