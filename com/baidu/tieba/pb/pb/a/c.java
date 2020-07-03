package com.baidu.tieba.pb.pb.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class c extends m<PostData, a> {
    private View.OnClickListener beA;

    public c(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.beA = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public a b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
        inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.beA);
        a aVar = new a(inflate);
        aVar.bdo();
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, a aVar) {
        aVar.setData(postData);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        private TextView kaN;

        public a(View view) {
            super(view);
            this.kaN = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void setData(PostData postData) {
            if (postData != null) {
                if (postData.lGn) {
                    Drawable drawable = an.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.kaN.setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                Drawable drawable2 = an.getDrawable(R.drawable.icon_emotion_smallarrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.kaN.setCompoundDrawables(null, null, drawable2, null);
            }
        }

        public void bdo() {
            an.setViewTextColor(this.kaN, (int) R.color.cp_cont_d);
        }
    }
}
