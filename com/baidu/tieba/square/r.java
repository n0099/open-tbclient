package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    private ArrayList<u> bMK = null;
    View.OnClickListener bML = new s(this);
    private Context mContext;

    public r(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void a(u uVar) {
        if (uVar != null) {
            this.bMK = K(uVar.sG());
        }
    }

    private ArrayList<u> K(ArrayList<u> arrayList) {
        if (arrayList != null) {
            int size = (arrayList.size() / 2) * 2;
            int i = size <= 4 ? size : 4;
            if (i > 0) {
                return new ArrayList<>(arrayList.subList(0, i));
            }
            return null;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bMK == null) {
            return 0;
        }
        return Math.round(this.bMK.size() / 2) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == getCount() + (-1) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = V(i, itemViewType);
        }
        t tVar = (t) view.getTag();
        int skinType = TbadkApplication.m251getInst().getSkinType();
        int count = getCount();
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mContext;
        baseFragmentActivity.getLayoutMode().L(skinType == 1);
        baseFragmentActivity.getLayoutMode().h(view);
        if (count > 2) {
            if (i == 0) {
                aw.h(tVar.Hl, com.baidu.tieba.u.bg_hot_up);
            } else if (i == count - 2) {
                aw.h(tVar.Hl, com.baidu.tieba.u.bg_hot_down);
            }
        } else if (count == 2 && i == 0) {
            aw.h(tVar.Hl, com.baidu.tieba.u.bg_hot);
        }
        if (i >= 0 && this.bMK != null) {
            if (i * 2 < this.bMK.size()) {
                u uVar = this.bMK.get(i * 2);
                tVar.bMN.setText(uVar.getTitle());
                uVar.hs(String.valueOf(String.valueOf(i)) + "_first");
                tVar.bMN.setTag(uVar);
            }
            if ((i * 2) + 1 < this.bMK.size()) {
                u uVar2 = this.bMK.get((i * 2) + 1);
                tVar.bMO.setText(uVar2.getTitle());
                uVar2.hs(String.valueOf(String.valueOf(i)) + "_second");
                tVar.bMO.setTag(uVar2);
            }
        }
        return view;
    }

    private View V(int i, int i2) {
        if (i2 == 0) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.forum_list_recommend_item, null);
            t tVar = new t(this, null);
            tVar.Hl = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.container);
            tVar.bMN = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_list_title_1);
            tVar.bMO = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_list_title_2);
            tVar.bMN.setClickable(true);
            tVar.bMO.setClickable(true);
            tVar.bMN.setOnClickListener(this.bML);
            tVar.bMO.setOnClickListener(this.bML);
            inflate.setTag(tVar);
            return inflate;
        } else if (i2 == 1) {
            com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.mContext);
            iVar.setHeightPx(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_forum_list_paddingBottom));
            return iVar;
        } else {
            return null;
        }
    }
}
