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
import com.baidu.tieba.util.as;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1499a;
    private View.OnClickListener d;
    private ArrayList<AccountData> c = null;
    private boolean b = false;

    public o(Context context, View.OnClickListener onClickListener) {
        this.f1499a = context;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00bd: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x00bc */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        p pVar;
        View view4;
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.f1499a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.account_item, (ViewGroup) null);
                        pVar = new p(this, null);
                        pVar.f1500a = (TextView) view4.findViewById(R.id.account);
                        pVar.c = (ImageView) view4.findViewById(R.id.active);
                        pVar.d = (Button) view4.findViewById(R.id.delete);
                        pVar.d.setOnClickListener(this.d);
                        view4.setTag(pVar);
                    } else {
                        view4 = from.inflate(R.layout.account_add_item, (ViewGroup) null);
                        pVar = new p(this, null);
                        pVar.b = (TextView) view4.findViewById(R.id.add_text);
                        view4.setTag(pVar);
                    }
                } else {
                    pVar = (p) view.getTag();
                    view4 = view;
                }
                if (getItemViewType(i) == 0) {
                    if (TiebaApplication.g().ap() == 1) {
                        pVar.f1500a.setTextColor(as.a(1));
                    } else {
                        pVar.f1500a.setTextColor(-12895429);
                    }
                    AccountData accountData = (AccountData) getItem(i);
                    pVar.c.setVisibility(8);
                    pVar.d.setVisibility(8);
                    pVar.d.setTag(accountData);
                    if (accountData != null) {
                        pVar.f1500a.setText(accountData.getAccount());
                        if (accountData.getIsActive() == 1) {
                            pVar.c.setVisibility(0);
                        }
                        if (this.b) {
                            pVar.d.setVisibility(0);
                            return view4;
                        }
                    }
                    return view4;
                } else if (TiebaApplication.g().ap() == 1) {
                    pVar.b.setTextColor(as.a(1));
                    return view4;
                } else {
                    pVar.b.setTextColor(-12895429);
                    return view4;
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                av.b(getClass().getName(), "getView", exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            av.b(getClass().getName(), "getView", exc.getMessage());
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
