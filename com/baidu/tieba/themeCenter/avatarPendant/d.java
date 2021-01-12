package com.baidu.tieba.themeCenter.avatarPendant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.c;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private static int nws = 16;
    private int akf = 3;
    private List<com.baidu.tieba.themeCenter.avatarPendant.a> mAvatarPendantList;
    private AvatarPendantActivity nwc;
    private c.a nwd;
    private b nwt;

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.nwc = avatarPendantActivity;
    }

    public void setData(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        this.mAvatarPendantList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JM */
    public com.baidu.tieba.themeCenter.avatarPendant.a getItem(int i) {
        if (this.mAvatarPendantList == null || this.mAvatarPendantList.size() <= 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.mAvatarPendantList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mAvatarPendantList != null) {
            return this.mAvatarPendantList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.nwc.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.niS = (TextView) view.findViewById(R.id.category_name);
            aVar2.nwu = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            aVar2.nwv = view.findViewById(R.id.line_divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.themeCenter.avatarPendant.a item = getItem(i);
        if (StringUtils.isNull(item.dON())) {
            aVar.niS.setVisibility(8);
        } else {
            aVar.niS.setVisibility(0);
            aVar.niS.setText(at.cutString(item.dON(), nws));
        }
        if (item != null && !x.isEmpty(item.dOO())) {
            this.nwt = new b(this.nwc);
            this.nwt.setData(item.dOO());
            aVar.nwu.setAdapter((ListAdapter) this.nwt);
            this.nwt.setAvatarPendantItemClickListener(this.nwd);
        }
        if (i == getCount() - 1) {
            aVar.nwv.setVisibility(8);
        } else {
            aVar.nwv.setVisibility(0);
        }
        ao.setBackgroundColor(aVar.nwv, R.color.CAM_X0204);
        ao.setViewTextColor(aVar.niS, R.color.CAM_X0109);
        return view;
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nwd = aVar;
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView niS;
        WholeDisplayGridView nwu;
        View nwv;

        private a() {
        }
    }
}
