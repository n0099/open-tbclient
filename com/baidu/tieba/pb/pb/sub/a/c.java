package com.baidu.tieba.pb.pb.sub.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.pb.pb.sub.b.a, a> {
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.sub_pb_no_reply_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.pb.sub.b.a aVar, a aVar2) {
        aVar2.onChangeSkinType();
        return aVar2.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        private TextView kam;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.kam = (TextView) view.findViewById(R.id.no_reply_list_view);
        }

        public void onChangeSkinType() {
            if (this.mSkinType != TbadkApplication.getInst().getSkinType()) {
                am.setViewTextColor(this.kam, (int) R.color.cp_cont_d);
            }
            this.mSkinType = TbadkApplication.getInst().getSkinType();
        }
    }
}
