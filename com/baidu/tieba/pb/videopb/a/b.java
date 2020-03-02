package com.baidu.tieba.pb.videopb.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.pb.videopb.e.a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public com.baidu.tieba.pb.videopb.e.a b(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.mContext);
        cardForumHeadLayout.setPadding(l.getDimens(this.mContext, R.dimen.tbds32), 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(this.mContext, R.dimen.tbds156));
        layoutParams.leftMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        layoutParams.rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds76);
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        return new com.baidu.tieba.pb.videopb.e.a(frameLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, com.baidu.tieba.pb.videopb.e.a aVar) {
        if (oVar != null) {
            aVar.setData(oVar.cRf);
        }
        aVar.aHN();
        return view;
    }
}
