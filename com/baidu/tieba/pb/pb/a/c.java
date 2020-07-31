package com.baidu.tieba.pb.pb.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class c extends o<PostData, a> {
    private View.OnClickListener beT;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.beT = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public a b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.beT);
        a aVar = new a(inflate);
        aVar.bgV();
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, a aVar) {
        aVar.setData(postData);
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private TextView kjr;

        public a(View view) {
            super(view);
            this.kjr = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void setData(PostData postData) {
            if (postData != null) {
                if (postData.lNB) {
                    Drawable drawable = ao.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.kjr.setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                Drawable drawable2 = ao.getDrawable(R.drawable.icon_emotion_smallarrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.kjr.setCompoundDrawables(null, null, drawable2, null);
            }
        }

        public void bgV() {
            ao.setViewTextColor(this.kjr, R.color.cp_cont_d);
        }
    }
}
