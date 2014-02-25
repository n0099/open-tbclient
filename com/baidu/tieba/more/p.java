package com.baidu.tieba.more;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private com.baidu.tieba.f a;
    private View.OnClickListener d;
    private ArrayList<AccountData> c = null;
    private boolean b = false;

    public p(com.baidu.tieba.f fVar, View.OnClickListener onClickListener) {
        this.a = fVar;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [131=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0186  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        View view2;
        try {
            try {
                try {
                    if (view == null) {
                        LayoutInflater from = LayoutInflater.from(this.a);
                        if (getItemViewType(i) == 0) {
                            view2 = from.inflate(R.layout.account_item, (ViewGroup) null);
                            qVar = new q(this, null);
                            qVar.a = (TextView) view2.findViewById(R.id.account);
                            qVar.c = (ImageView) view2.findViewById(R.id.active);
                            qVar.d = (Button) view2.findViewById(R.id.delete);
                            qVar.e = (LinearLayout) view2.findViewById(R.id.account_item_line_layout);
                            qVar.d.setOnClickListener(this.d);
                            view2.setTag(qVar);
                        } else {
                            view2 = from.inflate(R.layout.account_add_item, (ViewGroup) null);
                            qVar = new q(this, null);
                            qVar.b = (TextView) view2.findViewById(R.id.add_text);
                            view2.setTag(qVar);
                        }
                    } else {
                        qVar = (q) view.getTag();
                        view2 = view;
                    }
                    if (getItemViewType(i) == 0) {
                        if (TiebaApplication.g().al() == 1) {
                            qVar.a.setTextColor(bq.a(1));
                        } else {
                            qVar.a.setTextColor(-12895429);
                        }
                        AccountData accountData = (AccountData) getItem(i);
                        qVar.c.setVisibility(8);
                        qVar.d.setVisibility(8);
                        qVar.d.setTag(accountData);
                        if (accountData != null) {
                            qVar.a.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                qVar.c.setVisibility(0);
                            }
                            if (this.b) {
                                qVar.d.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            qVar.e.setVisibility(8);
                        } else {
                            qVar.e.setVisibility(0);
                        }
                    } else {
                        if (TiebaApplication.g().al() == 1) {
                            qVar.b.setTextColor(bq.a(1));
                        } else {
                            qVar.b.setTextColor(-12895429);
                        }
                        qVar.e.setVisibility(8);
                    }
                    this.a.getLayoutMode().a(TiebaApplication.g().al() == 1);
                    this.a.getLayoutMode().a(view2);
                    return view2;
                } catch (Throwable th) {
                    th = th;
                    this.a.getLayoutMode().a(TiebaApplication.g().al() == 1);
                    this.a.getLayoutMode().a(view);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", e.getMessage());
                this.a.getLayoutMode().a(TiebaApplication.g().al() != 1);
                this.a.getLayoutMode().a(view);
                return view;
            }
        } catch (Exception e2) {
            e = e2;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", e.getMessage());
            this.a.getLayoutMode().a(TiebaApplication.g().al() != 1);
            this.a.getLayoutMode().a(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.a.getLayoutMode().a(TiebaApplication.g().al() == 1);
            this.a.getLayoutMode().a(view);
            throw th;
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
