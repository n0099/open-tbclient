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
    private static int nGD = 16;
    private int ajU = 3;
    private List<com.baidu.tieba.themeCenter.avatarPendant.a> mAvatarPendantList;
    private b nGE;
    private AvatarPendantActivity nGn;
    private c.a nGo;

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.nGn = avatarPendantActivity;
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
            view = LayoutInflater.from(this.nGn.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.nta = (TextView) view.findViewById(R.id.category_name);
            aVar2.nGF = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            aVar2.nGG = view.findViewById(R.id.line_divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.themeCenter.avatarPendant.a item = getItem(i);
        if (StringUtils.isNull(item.dRg())) {
            aVar.nta.setVisibility(8);
        } else {
            aVar.nta.setVisibility(0);
            aVar.nta.setText(au.cutString(item.dRg(), nGD));
        }
        if (item != null && !y.isEmpty(item.dRh())) {
            this.nGE = new b(this.nGn);
            this.nGE.setData(item.dRh());
            aVar.nGF.setAdapter((ListAdapter) this.nGE);
            this.nGE.setAvatarPendantItemClickListener(this.nGo);
        }
        if (i == getCount() - 1) {
            aVar.nGG.setVisibility(8);
        } else {
            aVar.nGG.setVisibility(0);
        }
        ap.setBackgroundColor(aVar.nGG, R.color.CAM_X0204);
        ap.setViewTextColor(aVar.nta, R.color.CAM_X0109);
        return view;
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nGo = aVar;
    }

    /* loaded from: classes9.dex */
    private class a {
        WholeDisplayGridView nGF;
        View nGG;
        TextView nta;

        private a() {
        }
    }
}
