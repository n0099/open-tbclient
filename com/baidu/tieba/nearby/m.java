package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.a.ab;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ah;
import com.baidu.tieba.view.ImageViewDrawer;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private Context a;
    private aa b;
    private ArrayList c = null;
    private com.baidu.tieba.c.a d;

    public m(Context context) {
        this.a = null;
        this.b = null;
        this.d = null;
        this.a = context;
        this.b = null;
        this.d = new com.baidu.tieba.c.a(this.a);
        this.d.a("_mini");
        int a = ah.a(this.a, 40.0f);
        this.d.a(a, a);
    }

    public com.baidu.tieba.c.a a() {
        return this.d;
    }

    public void a(aa aaVar) {
        this.b = aaVar;
        this.c = null;
    }

    public void a(ArrayList arrayList) {
        this.b = null;
        this.c = arrayList;
    }

    public ArrayList b() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return 1;
        }
        if (this.c != null) {
            return 0 + this.c.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b != null) {
            return this.b;
        }
        if (this.c != null && i >= 0 && i < this.c.size()) {
            return this.c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x009b: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x009a */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        n nVar;
        View view4;
        ab abVar;
        try {
            int itemViewType = getItemViewType(i);
            try {
                if (view == null) {
                    if (itemViewType == 0) {
                        LayoutInflater from = LayoutInflater.from(this.a);
                        nVar = new n(this, null);
                        view4 = from.inflate(R.layout.lbs_forum_item, (ViewGroup) null);
                        nVar.b = (TextView) view4.findViewById(R.id.title);
                        nVar.e = (RatingBar) view4.findViewById(R.id.ratingbar);
                        view4.setTag(nVar);
                    } else {
                        LayoutInflater from2 = LayoutInflater.from(this.a);
                        nVar = new n(this, null);
                        view4 = from2.inflate(R.layout.lbs_thread_item, (ViewGroup) null);
                        nVar.a = (ImageViewDrawer) view4.findViewById(R.id.image);
                        nVar.b = (TextView) view4.findViewById(R.id.title);
                        nVar.c = (TextView) view4.findViewById(R.id.time);
                        nVar.d = (TextView) view4.findViewById(R.id.reply_num);
                        view4.setTag(nVar);
                    }
                } else {
                    nVar = (n) view.getTag();
                    view4 = view;
                }
                if (itemViewType == 0 && this.b != null) {
                    nVar.b.setText(this.b.a());
                    nVar.e.setRating(this.b.b());
                    return view4;
                }
                if (itemViewType == 1 && this.c != null && (getItem(i) instanceof ab) && (abVar = (ab) getItem(i)) != null) {
                    nVar.b.setText(abVar.c());
                    if (abVar.e() <= 0) {
                        nVar.d.setVisibility(8);
                    } else {
                        nVar.d.setVisibility(0);
                        nVar.d.setText(String.valueOf(abVar.e()));
                    }
                    nVar.c.setText(ae.e(new Date(abVar.f() * 1000)));
                    nVar.a.setTag(null);
                    nVar.a.setImageSearchUrl(null);
                    if (abVar.a() == 1 && abVar.d() != null) {
                        nVar.a.setDefaultId(R.drawable.lbs_def_image);
                        nVar.a.setVisibility(0);
                        nVar.a.setTag(abVar.d());
                        nVar.a.setImageSearchUrl(String.valueOf(abVar.d()) + "_mini");
                        return view4;
                    } else if (abVar.a() == 0) {
                        nVar.a.setVisibility(8);
                        return view4;
                    } else if (abVar.a() == 2) {
                        nVar.a.setDefaultId(R.drawable.def_video_pic);
                        nVar.a.setVisibility(0);
                        return view4;
                    }
                }
                return view4;
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                af.b(getClass().getName(), "getView", exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.b != null ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return super.isEnabled(i);
    }
}
