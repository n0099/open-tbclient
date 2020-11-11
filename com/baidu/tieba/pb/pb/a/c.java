package com.baidu.tieba.pb.pb.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class c extends o<PostData, a> {
    private View.OnClickListener bzF;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bzF = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public a c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.bzF);
        a aVar = new a(inflate);
        aVar.bxE();
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, a aVar) {
        aVar.setData(postData);
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private TextView lpa;

        public a(View view) {
            super(view);
            this.lpa = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void setData(PostData postData) {
            if (postData != null) {
                if (postData.mXr) {
                    Drawable drawable = ap.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.lpa.setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                Drawable drawable2 = ap.getDrawable(R.drawable.icon_emotion_smallarrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.lpa.setCompoundDrawables(null, null, drawable2, null);
            }
        }

        public void bxE() {
            ap.setViewTextColor(this.lpa, R.color.cp_cont_d);
        }
    }
}
