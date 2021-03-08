package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HTypeListView;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.b, a> {
    private ab bzn;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cY */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.b bVar, a aVar) {
        List<IAdapterData> list = bVar.ndo;
        if (a(aVar.ncT, list)) {
            aVar.ncU = new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.ndl);
            aVar.ncT.addAdapter(aVar.ncU);
        }
        if (list.size() > 3) {
            aVar.ncU.Is(102);
            aVar.ncT.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16));
        } else {
            aVar.ncU.Is(101);
            aVar.ncT.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30));
        }
        aVar.ncU.setAlaLiveShowData(this.bzn);
        aVar.ncT.setData(bVar.ndo);
        return view;
    }

    private boolean a(HTypeListView hTypeListView, List<IAdapterData> list) {
        return (hTypeListView.getCount() > 3 && list.size() <= 3) || (hTypeListView.getCount() <= 3 && list.size() > 3);
    }

    public void setAlaLiveShowData(ab abVar) {
        this.bzn = abVar;
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private HTypeListView ncT;
        private com.baidu.tieba.recommendlist.adapter.a ncU;

        private a(View view) {
            super(view);
            this.ncT = (HTypeListView) view.findViewById(a.f.followListView);
            this.ncU = new com.baidu.tieba.recommendlist.adapter.a(view.getContext(), com.baidu.tieba.recommendlist.data.a.ndl);
            this.ncT.addAdapter(this.ncU);
        }
    }
}
