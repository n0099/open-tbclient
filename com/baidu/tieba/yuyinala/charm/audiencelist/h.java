package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h extends BaseAdapter {
    private ArrayList<com.baidu.tieba.yuyinala.charm.audiencelist.a> eOt = new ArrayList<>();
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.yuyinala.charm.audiencelist.a> list) {
        if (list != null) {
            this.eOt.clear();
            this.eOt.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Nj */
    public com.baidu.tieba.yuyinala.charm.audiencelist.a getItem(int i) {
        if (this.eOt == null) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_charm_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.oix = (OnlineAudienceItemView) view.findViewById(a.f.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (alaLiveUserInfoData = getItem(i).aJV) != null) {
            aVar.oix.setData(i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.contribution, alaLiveUserInfoData.nobleRoleId);
            aVar.oix.oiw.setData4Yuyin(alaLiveUserInfoData);
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    private class a {
        private OnlineAudienceItemView oix;

        private a() {
        }
    }
}
