package com.baidu.tieba.square.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private ArrayList<d> iBv;
    View.OnClickListener iBw = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof C0387a) && (dVar = ((C0387a) tag).iBA) != null) {
                if (dVar.izr == null) {
                    BarFolderFirstDirActivity.h(a.this.ccZ(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(a.this.ccZ(), dVar.izq, dVar.izr, dVar.izs)));
                }
            }
        }
    };
    private Activity mContext;

    public a(Activity activity, b bVar, boolean z) {
        this.mContext = activity;
        this.iBv = bVar.ccY();
    }

    public ArrayList<d> ccY() {
        return this.iBv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.square.square.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0387a {
        public TextView dfp;
        public d iBA;
        public BarImageView iBy;
        public BestStringsFitTextView iBz;

        protected C0387a() {
        }
    }

    public void az(ArrayList<d> arrayList) {
        this.iBv = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iBv == null) {
            return 0;
        }
        return (this.iBv.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = t(viewGroup, itemViewType);
            bc.aD(view);
        }
        bc.aC(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(d.g.container);
            al.k(findViewById, d.f.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (C0387a) view.getTag(), i);
            }
        }
        return view;
    }

    private View t(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.mContext).inflate(d.h.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.mContext).inflate(d.h.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.iBw);
        C0387a c0387a = new C0387a();
        c0387a.iBy = (BarImageView) inflate.findViewById(d.g.portrait);
        c0387a.dfp = (TextView) inflate.findViewById(d.g.name);
        c0387a.iBz = (BestStringsFitTextView) inflate.findViewById(d.g.description);
        inflate.setTag(c0387a);
        return inflate;
    }

    private void a(ViewGroup viewGroup, C0387a c0387a, int i) {
        d dVar = this.iBv.get(i / 2);
        c0387a.iBA = dVar;
        c0387a.dfp.setText(dVar.izq);
        if (dVar.iBD != null) {
            c0387a.iBz.setVisibility(0);
            String[] strArr = new String[dVar.iBD.size()];
            for (int i2 = 0; i2 < dVar.iBD.size(); i2++) {
                strArr[i2] = dVar.iBD.get(i2).izq;
            }
            c0387a.iBz.setTextArray(strArr);
        } else {
            c0387a.iBz.setVisibility(8);
        }
        if (dVar.logoUrl != null) {
            int dip2px = l.dip2px(this.mContext, 45.0f);
            c0387a.iBy.setTag(dVar.logoUrl);
            c0387a.iBy.startLoad(dVar.logoUrl, 10, dip2px, dip2px, false);
        }
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
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getCount() <= 0 || i != getCount() - 1) {
            return Math.abs(i) % 2 == 1 ? 3 : 1;
        }
        return 2;
    }

    protected Activity ccZ() {
        return this.mContext;
    }
}
