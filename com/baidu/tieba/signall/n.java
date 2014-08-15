package com.baidu.tieba.signall;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends BaseAdapter implements AbsListView.OnScrollListener, ad {
    private b b;
    private Context c;
    private LayoutInflater d;
    private boolean f;
    private ArrayList<d> a = new ArrayList<>();
    private HashMap<String, ac> e = new HashMap<>();
    private boolean g = true;

    public n(Context context, TextView textView) {
        this.c = context;
        this.d = (LayoutInflater) this.c.getSystemService("layout_inflater");
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.b = bVar;
            this.a = bVar.i();
            if (this.a.size() == 0) {
                this.g = false;
            } else {
                this.g = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.a.size() > i) {
            if (this.a.get(i) instanceof a) {
                return 1;
            }
            return 0;
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.g) {
            return this.a.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a.size() > i) {
            return this.a.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View a(int i) {
        if (i == 0) {
            View inflate = this.d.inflate(com.baidu.tieba.v.signallforum_item, (ViewGroup) null);
            q qVar = new q(this);
            qVar.a = (BarImageView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_avatar);
            qVar.a.setIsRound(false);
            qVar.a.setGifIconSupport(false);
            qVar.c = (TextView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_name);
            qVar.d = (TextView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_level);
            qVar.e = (TextView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_exp);
            qVar.f = (FrameLayout) inflate.findViewById(com.baidu.tieba.u.signallforum_item_res_container);
            qVar.g = (TextView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_days);
            qVar.h = (RelativeLayout) inflate.findViewById(com.baidu.tieba.u.signallforum_item_resign_container);
            qVar.i = (ImageView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_resign_icon);
            qVar.j = (ProgressBar) inflate.findViewById(com.baidu.tieba.u.signallforum_item_resign_progress);
            qVar.k = (TextView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_resign_text);
            qVar.l = (TextView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_error);
            qVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.signallforum_item_level_container);
            qVar.m = (TextView) inflate.findViewById(com.baidu.tieba.u.signallforum_item_increaseexp);
            inflate.setTag(qVar);
            return inflate;
        }
        View inflate2 = this.d.inflate(com.baidu.tieba.v.signallforum_header, (ViewGroup) null);
        p pVar = new p(this);
        pVar.a = (TextView) inflate2.findViewById(com.baidu.tieba.u.signallforum_head_title);
        pVar.b = (TextView) inflate2.findViewById(com.baidu.tieba.u.signallforum_head_res);
        inflate2.setTag(pVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        BaseActivity baseActivity = (BaseActivity) this.c;
        baseActivity.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        baseActivity.getLayoutMode().a(view);
        q qVar = (q) view.getTag();
        d dVar = (d) getItem(i);
        String c = dVar.c();
        if (c != null && c.length() > 8) {
            char[] charArray = c.toCharArray();
            int i2 = 0;
            for (int i3 = 0; i3 < charArray.length; i3++) {
                if (StringUtils.isChinese(charArray[i3])) {
                    i2 += 2;
                } else {
                    i2++;
                }
                if (i2 > 16) {
                    str = String.valueOf(c.substring(0, i3)) + "...";
                    break;
                }
            }
        }
        str = c;
        qVar.c.setText(str);
        qVar.d.setText(new StringBuilder(String.valueOf(dVar.g())).toString());
        qVar.d.setBackgroundResource(com.baidu.tbadk.core.util.d.b(dVar.g()));
        qVar.e.setText(String.valueOf(dVar.h()) + "/" + dVar.i());
        qVar.m.clearAnimation();
        if (dVar.j()) {
            qVar.b.setVisibility(0);
            qVar.l.setVisibility(8);
            qVar.g.setVisibility(0);
            qVar.h.setVisibility(8);
            qVar.g.setText(String.format(this.c.getString(com.baidu.tieba.x.signallforum_days), Integer.valueOf(dVar.f())));
            if (dVar.o()) {
                qVar.e.setText(this.c.getString(com.baidu.tieba.x.signallforum_uplevel));
                qVar.m.setVisibility(8);
            } else {
                qVar.e.setText(String.valueOf(dVar.h()) + "/" + dVar.i());
                qVar.m.setVisibility(0);
            }
            int m = dVar.m();
            if (m > 0) {
                qVar.m.setVisibility(0);
                qVar.m.setText("+" + m);
            } else {
                qVar.m.setVisibility(8);
            }
        } else if (dVar.k()) {
            String n = dVar.n();
            if (!TextUtils.isEmpty(n)) {
                qVar.b.setVisibility(8);
                qVar.l.setVisibility(0);
                qVar.m.setVisibility(8);
                qVar.l.setText(n);
            } else {
                qVar.b.setVisibility(0);
                qVar.l.setVisibility(8);
                qVar.m.setVisibility(8);
            }
            qVar.g.setVisibility(8);
            qVar.h.setVisibility(0);
            if (dVar.l()) {
                qVar.i.setVisibility(4);
                qVar.j.setVisibility(0);
                qVar.k.setText(com.baidu.tieba.x.signallforum_resigning);
            } else {
                qVar.i.setVisibility(0);
                qVar.j.setVisibility(4);
                qVar.k.setText(com.baidu.tieba.x.signallforum_resign);
            }
            qVar.h.setOnClickListener(new o(this, dVar, qVar));
        } else {
            qVar.g.setVisibility(8);
            qVar.h.setVisibility(8);
            qVar.m.setVisibility(8);
            qVar.b.setVisibility(0);
            qVar.l.setVisibility(8);
        }
        String d = dVar.d();
        qVar.a.setTag(d);
        qVar.a.a(d, 10, false);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        p pVar;
        if (!this.g) {
            return b();
        }
        int itemViewType = getItemViewType(i);
        View a = view == null ? a(itemViewType) : view;
        if (itemViewType == 1) {
            if (a != null && a.getTag() != null && (a.getTag() instanceof p)) {
                view2 = a;
                pVar = (p) a.getTag();
            } else {
                View a2 = a(itemViewType);
                view2 = a2;
                pVar = (p) a2.getTag();
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            BaseActivity baseActivity = (BaseActivity) this.c;
            baseActivity.getLayoutMode().a(skinType == 1);
            baseActivity.getLayoutMode().a(view2.findViewById(com.baidu.tieba.u.sign_all_forum_tip));
            pVar.a.setText(((a) getItem(i)).a());
            a(pVar.b, i);
            return view2;
        }
        a(a, viewGroup, i);
        return a;
    }

    private void a(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int a = this.b == null ? 7 : this.b.a();
        if (this.a == null || this.a.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.a.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.c())) {
                    if (next.g() >= a) {
                        if (next.j()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.j()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.c.getString(com.baidu.tieba.x.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.c.getString(com.baidu.tieba.x.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View b() {
        View inflate = this.d.inflate(com.baidu.tieba.v.sign_all_forum_nodata_item, (ViewGroup) null);
        BaseActivity baseActivity = (BaseActivity) this.c;
        baseActivity.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        baseActivity.getLayoutMode().a(inflate);
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.signall.ad
    public void a(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.e.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ad
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.j.a(this.c, str2);
        }
        synchronized (this) {
            this.e.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.a.get(i);
            if (new StringBuilder(String.valueOf(dVar.b())).toString().equals(str)) {
                dVar.a(z);
                dVar.b(!z);
                dVar.c(false);
                if (z) {
                    dVar.b(signData.getCountSignNum());
                    dVar.d(signData.getBonusPoint());
                    dVar.a(1);
                    ai.c().a(dVar.c(), signData.getBonusPoint(), -1);
                    ArrayList<d> l = this.b.l();
                    if (l.contains(dVar)) {
                        l.remove(dVar);
                        this.b.k().add(dVar);
                    }
                } else {
                    dVar.a(str2);
                }
                if (!this.f) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void a() {
        this.f = true;
        synchronized (this) {
            for (Map.Entry<String, ac> entry : this.e.entrySet()) {
                entry.getValue().a();
            }
            this.e.clear();
        }
    }
}
