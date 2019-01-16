package com.baidu.tieba.pb.pb.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class d extends k<PostData, a> {
    private View.OnClickListener dhP;

    public d(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dhP = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(e.g.tv_pb_reply_more).setOnClickListener(this.dhP);
        a aVar = new a(inflate);
        aVar.KD();
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

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        private TextView fVo;

        public a(View view) {
            super(view);
            this.fVo = (TextView) view.findViewById(e.g.tv_pb_reply_more);
        }

        public void setData(PostData postData) {
            if (postData != null) {
                if (postData.hqc) {
                    Drawable drawable = al.getDrawable(e.f.icon_emotion_smallarrow_n);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.fVo.setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                Drawable drawable2 = al.getDrawable(e.f.icon_emotion_smallarrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.fVo.setCompoundDrawables(null, null, drawable2, null);
            }
        }

        public void KD() {
            al.h(this.fVo, e.d.cp_cont_d);
        }
    }
}
