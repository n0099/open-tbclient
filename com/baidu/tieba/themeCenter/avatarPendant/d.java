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
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    private static int nAX = 16;
    private int akW = 3;
    private List<com.baidu.tieba.themeCenter.avatarPendant.a> mAvatarPendantList;
    private AvatarPendantActivity nAH;
    private c.a nAI;
    private b nAY;

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.nAH = avatarPendantActivity;
    }

    public void setData(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        this.mAvatarPendantList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lt */
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
            view = LayoutInflater.from(this.nAH.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.nnw = (TextView) view.findViewById(R.id.category_name);
            aVar2.nAZ = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            aVar2.nBa = view.findViewById(R.id.line_divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.themeCenter.avatarPendant.a item = getItem(i);
        if (StringUtils.isNull(item.dSF())) {
            aVar.nnw.setVisibility(8);
        } else {
            aVar.nnw.setVisibility(0);
            aVar.nnw.setText(at.cutString(item.dSF(), nAX));
        }
        if (item != null && !x.isEmpty(item.dSG())) {
            this.nAY = new b(this.nAH);
            this.nAY.setData(item.dSG());
            aVar.nAZ.setAdapter((ListAdapter) this.nAY);
            this.nAY.setAvatarPendantItemClickListener(this.nAI);
        }
        if (i == getCount() - 1) {
            aVar.nBa.setVisibility(8);
        } else {
            aVar.nBa.setVisibility(0);
        }
        ao.setBackgroundColor(aVar.nBa, R.color.CAM_X0204);
        ao.setViewTextColor(aVar.nnw, R.color.CAM_X0109);
        return view;
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nAI = aVar;
    }

    /* loaded from: classes9.dex */
    private class a {
        WholeDisplayGridView nAZ;
        View nBa;
        TextView nnw;

        private a() {
        }
    }
}
