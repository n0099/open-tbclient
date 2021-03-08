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
    private View.OnClickListener bIm;

    public PbReplyLoadMoreAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bIm = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public ReplyLoadMoreViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.bIm);
        ReplyLoadMoreViewHolder replyLoadMoreViewHolder = new ReplyLoadMoreViewHolder(inflate);
        replyLoadMoreViewHolder.bzq();
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
        private TextView lOG;

        public ReplyLoadMoreViewHolder(View view) {
            super(view);
            this.lOG = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void setData(PostData postData) {
            if (postData != null) {
                if (postData.nzD) {
                    Drawable drawable = ap.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.lOG.setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                Drawable drawable2 = ap.getDrawable(R.drawable.icon_emotion_smallarrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.lOG.setCompoundDrawables(null, null, drawable2, null);
            }
        }

        public void bzq() {
            ap.setViewTextColor(this.lOG, R.color.CAM_X0109);
        }
    }
}
