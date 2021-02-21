package com.baidu.tieba.themeCenter.avatarPendant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.c;
import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private List<DressItemData> mDataList;
    private AvatarPendantActivity nGn;
    private c.a nGo;

    public b(AvatarPendantActivity avatarPendantActivity) {
        this.nGn = avatarPendantActivity;
    }

    public void setData(List<DressItemData> list) {
        this.mDataList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDataList != null) {
            return this.mDataList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kf */
    public DressItemData getItem(int i) {
        if (this.mDataList == null || this.mDataList.size() <= 0 || this.mDataList.size() <= i) {
            return null;
        }
        return this.mDataList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.nGn.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.nGp = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
            aVar2.nGp.setAvatarPendantItemClickListener(this.nGo);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        DressItemData item = getItem(i);
        if (item != null) {
            aVar.nGp.d(item);
        }
        ek(view);
        return view;
    }

    private void ek(View view) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view != null) {
            this.nGn.getLayoutMode().setNightMode(skinType == 1);
            this.nGn.getLayoutMode().onModeChanged(view);
        }
    }

    /* loaded from: classes9.dex */
    private class a {
        AvatarPendantPerItemView nGp;

        private a() {
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nGo = aVar;
    }
}
