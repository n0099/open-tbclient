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
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private ArrayList<d> iUp;
    View.OnClickListener iUq = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof C0406a) && (dVar = ((C0406a) tag).iUu) != null) {
                if (dVar.iSk == null) {
                    BarFolderFirstDirActivity.h(a.this.clg(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(a.this.clg(), dVar.iSj, dVar.iSk, dVar.iSl)));
                }
            }
        }
    };
    private Activity mContext;

    public a(Activity activity, b bVar, boolean z) {
        this.mContext = activity;
        this.iUp = bVar.clf();
    }

    public ArrayList<d> clf() {
        return this.iUp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.square.square.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0406a {
        public TextView bmf;
        public BarImageView iUs;
        public BestStringsFitTextView iUt;
        public d iUu;

        protected C0406a() {
        }
    }

    public void aD(ArrayList<d> arrayList) {
        this.iUp = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iUp == null) {
            return 0;
        }
        return (this.iUp.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = x(viewGroup, itemViewType);
            bc.aJ(view);
        }
        bc.aI(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            al.k(findViewById, R.drawable.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (C0406a) view.getTag(), i);
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
        inflate.setOnClickListener(this.iUq);
        C0406a c0406a = new C0406a();
        c0406a.iUs = (BarImageView) inflate.findViewById(R.id.portrait);
        c0406a.bmf = (TextView) inflate.findViewById(R.id.name);
        c0406a.iUt = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(c0406a);
        return inflate;
    }

    private void a(ViewGroup viewGroup, C0406a c0406a, int i) {
        d dVar = this.iUp.get(i / 2);
        c0406a.iUu = dVar;
        c0406a.bmf.setText(dVar.iSj);
        if (dVar.iUx != null) {
            c0406a.iUt.setVisibility(0);
            String[] strArr = new String[dVar.iUx.size()];
            for (int i2 = 0; i2 < dVar.iUx.size(); i2++) {
                strArr[i2] = dVar.iUx.get(i2).iSj;
            }
            c0406a.iUt.setTextArray(strArr);
        } else {
            c0406a.iUt.setVisibility(8);
        }
        if (dVar.logoUrl != null) {
            int dip2px = l.dip2px(this.mContext, 45.0f);
            c0406a.iUs.setTag(dVar.logoUrl);
            c0406a.iUs.startLoad(dVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity clg() {
        return this.mContext;
    }
}
