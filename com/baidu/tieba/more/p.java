package com.baidu.tieba.more;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.bl;
import com.baidu.tieba.util.bo;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private Context a;
    private View.OnClickListener d;
    private ArrayList<AccountData> c = null;
    private boolean b = false;

    public p(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.d = onClickListener;
    }

    public void a(ArrayList<AccountData> arrayList) {
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.c != null) {
            i = this.c.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        r rVar;
        View view3;
        r rVar2;
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                try {
                    if (getItemViewType(i) == 0) {
                        View inflate = from.inflate(R.layout.account_item, (ViewGroup) null);
                        r rVar3 = new r(this);
                        rVar3.a = (TextView) inflate.findViewById(R.id.account);
                        rVar3.c = (ImageView) inflate.findViewById(R.id.active);
                        rVar3.d = (Button) inflate.findViewById(R.id.delete);
                        rVar3.d.setOnClickListener(this.d);
                        inflate.setTag(rVar3);
                        rVar2 = rVar3;
                        view3 = inflate;
                    } else {
                        View inflate2 = from.inflate(R.layout.account_add_item, (ViewGroup) null);
                        r rVar4 = new r(this);
                        rVar4.b = (TextView) inflate2.findViewById(R.id.add_text);
                        inflate2.setTag(rVar4);
                        rVar2 = rVar4;
                        view3 = inflate2;
                    }
                    rVar = rVar2;
                } catch (Exception e) {
                    exc = e;
                    view2 = rVar;
                    bo.b(getClass().getName(), "getView", exc.getMessage());
                    return view2;
                }
            } else {
                rVar = (r) view.getTag();
                view3 = view;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        try {
            if (getItemViewType(i) == 0) {
                if (TiebaApplication.g().an() == 1) {
                    rVar.a.setTextColor(bl.a(1));
                } else {
                    rVar.a.setTextColor(-12895429);
                }
                AccountData accountData = (AccountData) getItem(i);
                rVar.c.setVisibility(8);
                rVar.d.setVisibility(8);
                rVar.d.setTag(accountData);
                if (accountData != null) {
                    rVar.a.setText(accountData.getAccount());
                    if (accountData.getIsActive() == 1) {
                        rVar.c.setVisibility(0);
                    }
                    if (this.b) {
                        rVar.d.setVisibility(0);
                    }
                }
            } else if (TiebaApplication.g().an() == 1) {
                rVar.b.setTextColor(bl.a(1));
            } else {
                rVar.b.setTextColor(-12895429);
            }
            return view3;
        } catch (Exception e3) {
            view2 = view3;
            exc = e3;
            bo.b(getClass().getName(), "getView", exc.getMessage());
            return view2;
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
