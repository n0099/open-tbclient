package com.baidu.tieba.themeCenter.avatarPendant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.c;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    private static int nGd = 16;
    private int ajU = 3;
    private List<com.baidu.tieba.themeCenter.avatarPendant.a> mAvatarPendantList;
    private AvatarPendantActivity nFN;
    private c.a nFO;
    private b nGe;

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.nFN = avatarPendantActivity;
    }

    public void setData(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        this.mAvatarPendantList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kg */
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
            view = LayoutInflater.from(this.nFN.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.nsA = (TextView) view.findViewById(R.id.category_name);
            aVar2.nGf = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            aVar2.nGg = view.findViewById(R.id.line_divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.themeCenter.avatarPendant.a item = getItem(i);
        if (StringUtils.isNull(item.dQY())) {
            aVar.nsA.setVisibility(8);
        } else {
            aVar.nsA.setVisibility(0);
            aVar.nsA.setText(au.cutString(item.dQY(), nGd));
        }
        if (item != null && !y.isEmpty(item.dQZ())) {
            this.nGe = new b(this.nFN);
            this.nGe.setData(item.dQZ());
            aVar.nGf.setAdapter((ListAdapter) this.nGe);
            this.nGe.setAvatarPendantItemClickListener(this.nFO);
        }
        if (i == getCount() - 1) {
            aVar.nGg.setVisibility(8);
        } else {
            aVar.nGg.setVisibility(0);
        }
        ap.setBackgroundColor(aVar.nGg, R.color.CAM_X0204);
        ap.setViewTextColor(aVar.nsA, R.color.CAM_X0109);
        return view;
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nFO = aVar;
    }

    /* loaded from: classes9.dex */
    private class a {
        WholeDisplayGridView nGf;
        View nGg;
        TextView nsA;

        private a() {
        }
    }
}
