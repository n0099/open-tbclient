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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private ArrayList<d> jbJ;
    View.OnClickListener jbK = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof C0411a) && (dVar = ((C0411a) tag).jbO) != null) {
                if (dVar.iZF == null) {
                    BarFolderFirstDirActivity.h(a.this.coq(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(a.this.coq(), dVar.iZE, dVar.iZF, dVar.iZG)));
                }
            }
        }
    };
    private Activity mContext;

    public a(Activity activity, b bVar, boolean z) {
        this.mContext = activity;
        this.jbJ = bVar.cop();
    }

    public ArrayList<d> cop() {
        return this.jbJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.square.square.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0411a {
        public TextView bmT;
        public BarImageView jbM;
        public BestStringsFitTextView jbN;
        public d jbO;

        protected C0411a() {
        }
    }

    public void aD(ArrayList<d> arrayList) {
        this.jbJ = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jbJ == null) {
            return 0;
        }
        return (this.jbJ.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = x(viewGroup, itemViewType);
            bd.aL(view);
        }
        bd.aK(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            am.k(findViewById, R.drawable.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (C0411a) view.getTag(), i);
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
        inflate.setOnClickListener(this.jbK);
        C0411a c0411a = new C0411a();
        c0411a.jbM = (BarImageView) inflate.findViewById(R.id.portrait);
        c0411a.bmT = (TextView) inflate.findViewById(R.id.name);
        c0411a.jbN = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(c0411a);
        return inflate;
    }

    private void a(ViewGroup viewGroup, C0411a c0411a, int i) {
        d dVar = this.jbJ.get(i / 2);
        c0411a.jbO = dVar;
        c0411a.bmT.setText(dVar.iZE);
        if (dVar.jbR != null) {
            c0411a.jbN.setVisibility(0);
            String[] strArr = new String[dVar.jbR.size()];
            for (int i2 = 0; i2 < dVar.jbR.size(); i2++) {
                strArr[i2] = dVar.jbR.get(i2).iZE;
            }
            c0411a.jbN.setTextArray(strArr);
        } else {
            c0411a.jbN.setVisibility(8);
        }
        if (dVar.logoUrl != null) {
            int dip2px = l.dip2px(this.mContext, 45.0f);
            c0411a.jbM.setTag(dVar.logoUrl);
            c0411a.jbM.startLoad(dVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity coq() {
        return this.mContext;
    }
}
