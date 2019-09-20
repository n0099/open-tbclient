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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private ArrayList<d> jee;
    View.OnClickListener jef = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof C0422a) && (dVar = ((C0422a) tag).jej) != null) {
                if (dVar.jca == null) {
                    BarFolderFirstDirActivity.h(a.this.cpd(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(a.this.cpd(), dVar.jbZ, dVar.jca, dVar.jcb)));
                }
            }
        }
    };
    private Activity mContext;

    public a(Activity activity, b bVar, boolean z) {
        this.mContext = activity;
        this.jee = bVar.cpc();
    }

    public ArrayList<d> cpc() {
        return this.jee;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.square.square.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0422a {
        public TextView bnr;
        public BarImageView jeh;
        public BestStringsFitTextView jei;
        public d jej;

        protected C0422a() {
        }
    }

    public void aD(ArrayList<d> arrayList) {
        this.jee = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jee == null) {
            return 0;
        }
        return (this.jee.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = x(viewGroup, itemViewType);
            bc.aL(view);
        }
        bc.aK(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            am.k(findViewById, R.drawable.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (C0422a) view.getTag(), i);
            }
        }
        return view;
    }

    private View x(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.mContext).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.mContext).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.jef);
        C0422a c0422a = new C0422a();
        c0422a.jeh = (BarImageView) inflate.findViewById(R.id.portrait);
        c0422a.bnr = (TextView) inflate.findViewById(R.id.name);
        c0422a.jei = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(c0422a);
        return inflate;
    }

    private void a(ViewGroup viewGroup, C0422a c0422a, int i) {
        d dVar = this.jee.get(i / 2);
        c0422a.jej = dVar;
        c0422a.bnr.setText(dVar.jbZ);
        if (dVar.jem != null) {
            c0422a.jei.setVisibility(0);
            String[] strArr = new String[dVar.jem.size()];
            for (int i2 = 0; i2 < dVar.jem.size(); i2++) {
                strArr[i2] = dVar.jem.get(i2).jbZ;
            }
            c0422a.jei.setTextArray(strArr);
        } else {
            c0422a.jei.setVisibility(8);
        }
        if (dVar.logoUrl != null) {
            int dip2px = l.dip2px(this.mContext, 45.0f);
            c0422a.jeh.setTag(dVar.logoUrl);
            c0422a.jeh.startLoad(dVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity cpd() {
        return this.mContext;
    }
}
