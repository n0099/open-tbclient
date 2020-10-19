package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HTypeListView;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.b, a> {
    private u bnM;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.h.ala_follow_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.b bVar, a aVar) {
        com.baidu.tieba.recommendlist.adapter.a aVar2 = new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.mjy);
        aVar2.g(this.bnM);
        List<IAdapterData> list = bVar.mjB;
        aVar.mjn.addAdapter(aVar2);
        aVar.mjn.setData(bVar.mjB);
        if (list.size() > 3) {
            aVar2.HJ(102);
            aVar.mjn.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds16));
        } else {
            aVar2.HJ(101);
            aVar.mjn.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30));
        }
        return view;
    }

    public void g(u uVar) {
        this.bnM = uVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private HTypeListView mjn;

        private a(View view) {
            super(view);
            this.mjn = (HTypeListView) view.findViewById(a.g.followListView);
        }
    }
}
