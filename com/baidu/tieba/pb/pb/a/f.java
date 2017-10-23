package com.baidu.tieba.pb.pb.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class f extends k<PostData, a> {
    private View.OnClickListener baf;

    public f(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.baf = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(d.h.tv_pb_reply_more).setOnClickListener(this.baf);
        a aVar = new a(inflate);
        aVar.As();
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, a aVar) {
        aVar.setData(postData);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        private TextView ezK;

        public a(View view) {
            super(view);
            this.ezK = (TextView) view.findViewById(d.h.tv_pb_reply_more);
        }

        public void setData(PostData postData) {
            if (postData != null) {
                if (postData.ggX) {
                    Drawable drawable = aj.getDrawable(d.g.icon_emotion_smallarrow_n);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.ezK.setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                Drawable drawable2 = aj.getDrawable(d.g.icon_emotion_smallarrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.ezK.setCompoundDrawables(null, null, drawable2, null);
            }
        }

        public void As() {
            aj.i(this.ezK, d.e.cp_cont_d);
        }
    }
}
