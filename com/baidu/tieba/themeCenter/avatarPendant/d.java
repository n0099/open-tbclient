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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private static int nIJ = 16;
    private int aln = 3;
    private List<com.baidu.tieba.themeCenter.avatarPendant.a> mAvatarPendantList;
    private b nIK;
    private AvatarPendantActivity nIt;
    private c.a nIu;

    public d(AvatarPendantActivity avatarPendantActivity) {
        this.nIt = avatarPendantActivity;
    }

    public void setData(List<com.baidu.tieba.themeCenter.avatarPendant.a> list) {
        this.mAvatarPendantList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kl */
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
            view = LayoutInflater.from(this.nIt.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.nvf = (TextView) view.findViewById(R.id.category_name);
            aVar2.nIL = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
            aVar2.nIM = view.findViewById(R.id.line_divider);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.themeCenter.avatarPendant.a item = getItem(i);
        if (StringUtils.isNull(item.dRp())) {
            aVar.nvf.setVisibility(8);
        } else {
            aVar.nvf.setVisibility(0);
            aVar.nvf.setText(au.cutString(item.dRp(), nIJ));
        }
        if (item != null && !y.isEmpty(item.dRq())) {
            this.nIK = new b(this.nIt);
            this.nIK.setData(item.dRq());
            aVar.nIL.setAdapter((ListAdapter) this.nIK);
            this.nIK.setAvatarPendantItemClickListener(this.nIu);
        }
        if (i == getCount() - 1) {
            aVar.nIM.setVisibility(8);
        } else {
            aVar.nIM.setVisibility(0);
        }
        ap.setBackgroundColor(aVar.nIM, R.color.CAM_X0204);
        ap.setViewTextColor(aVar.nvf, R.color.CAM_X0109);
        return view;
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nIu = aVar;
    }

    /* loaded from: classes8.dex */
    private class a {
        WholeDisplayGridView nIL;
        View nIM;
        TextView nvf;

        private a() {
        }
    }
}
