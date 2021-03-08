package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class h extends BaseAdapter {
    private ArrayList<com.baidu.tieba.yuyinala.charm.audiencelist.a> eXu = new ArrayList<>();
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.tieba.yuyinala.charm.audiencelist.a> list) {
        if (list != null) {
            this.eXu.clear();
            this.eXu.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LN */
    public com.baidu.tieba.yuyinala.charm.audiencelist.a getItem(int i) {
        if (this.eXu == null) {
            return null;
        }
        return this.eXu.get(i);
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
            aVar = new a();
            aVar.osb = (OnlineAudienceItemView) view.findViewById(a.f.item);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (alaLiveUserInfoData = getItem(i).aJD) != null) {
            if (aVar.osb.getTag() == null || !TextUtils.equals(((AlaLiveUserInfoData) aVar.osb.getTag()).userUk, alaLiveUserInfoData.userUk)) {
                aVar.osb.osa.setData4Yuyin(alaLiveUserInfoData);
                aVar.osb.setTag(alaLiveUserInfoData);
            }
            aVar.osb.setData(i + 1, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.contribution, alaLiveUserInfoData.contributionStr, alaLiveUserInfoData.nobleRoleId);
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes10.dex */
    private class a {
        private OnlineAudienceItemView osb;

        private a() {
        }
    }
}
