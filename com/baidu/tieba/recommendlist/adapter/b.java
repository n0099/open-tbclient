package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HTypeListView;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.b, a> {
    private x bzc;

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
        List<IAdapterData> list = bVar.mVY;
        if (a(aVar.mVD, list)) {
            aVar.mVE = new com.baidu.tieba.recommendlist.adapter.a(this.mContext, com.baidu.tieba.recommendlist.data.a.mVV);
            aVar.mVD.addAdapter(aVar.mVE);
        }
        if (list.size() > 3) {
            aVar.mVE.JB(102);
            aVar.mVD.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16));
        } else {
            aVar.mVE.JB(101);
            aVar.mVD.setDividerWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds30));
        }
        aVar.mVE.setAlaLiveShowData(this.bzc);
        aVar.mVD.setData(bVar.mVY);
        return view;
    }

    private boolean a(HTypeListView hTypeListView, List<IAdapterData> list) {
        return (hTypeListView.getCount() > 3 && list.size() <= 3) || (hTypeListView.getCount() <= 3 && list.size() > 3);
    }

    public void setAlaLiveShowData(x xVar) {
        this.bzc = xVar;
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private HTypeListView mVD;
        private com.baidu.tieba.recommendlist.adapter.a mVE;

        private a(View view) {
            super(view);
            this.mVD = (HTypeListView) view.findViewById(a.f.followListView);
            this.mVE = new com.baidu.tieba.recommendlist.adapter.a(view.getContext(), com.baidu.tieba.recommendlist.data.a.mVV);
            this.mVD.addAdapter(this.mVE);
        }
    }
}
