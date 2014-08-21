package com.baidu.tieba.signall;

import android.content.Context;
import android.text.TextUtils;
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
public class o extends BaseAdapter implements AbsListView.OnScrollListener, ae {
    private b b;
    private Context c;
    private boolean e;
    private ArrayList<d> a = new ArrayList<>();
    private HashMap<String, ad> d = new HashMap<>();
    private boolean f = true;

    public o(Context context, TextView textView) {
        this.c = context;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.b = bVar;
            this.a = bVar.i();
            if (this.a.size() == 0) {
                this.f = false;
            } else {
                this.f = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof a ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f) {
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
            View a = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.signallforum_item, null);
            r rVar = new r(this);
            rVar.a = (BarImageView) a.findViewById(com.baidu.tieba.u.signallforum_item_avatar);
            rVar.a.setIsRound(false);
            rVar.a.setGifIconSupport(false);
            rVar.c = (TextView) a.findViewById(com.baidu.tieba.u.signallforum_item_name);
            rVar.d = (TextView) a.findViewById(com.baidu.tieba.u.signallforum_item_level);
            rVar.e = (TextView) a.findViewById(com.baidu.tieba.u.signallforum_item_exp);
            rVar.f = (FrameLayout) a.findViewById(com.baidu.tieba.u.signallforum_item_res_container);
            rVar.g = (TextView) a.findViewById(com.baidu.tieba.u.signallforum_item_days);
            rVar.h = (RelativeLayout) a.findViewById(com.baidu.tieba.u.signallforum_item_resign_container);
            rVar.i = (ImageView) a.findViewById(com.baidu.tieba.u.signallforum_item_resign_icon);
            rVar.j = (ProgressBar) a.findViewById(com.baidu.tieba.u.signallforum_item_resign_progress);
            rVar.k = (TextView) a.findViewById(com.baidu.tieba.u.signallforum_item_resign_text);
            rVar.l = (TextView) a.findViewById(com.baidu.tieba.u.signallforum_item_error);
            rVar.b = (LinearLayout) a.findViewById(com.baidu.tieba.u.signallforum_item_level_container);
            rVar.m = (TextView) a.findViewById(com.baidu.tieba.u.signallforum_item_increaseexp);
            a.setTag(rVar);
            return a;
        }
        View a2 = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.signallforum_header, null);
        q qVar = new q(this);
        qVar.a = (TextView) a2.findViewById(com.baidu.tieba.u.signallforum_head_title);
        qVar.b = (TextView) a2.findViewById(com.baidu.tieba.u.signallforum_head_res);
        a2.setTag(qVar);
        return a2;
    }

    private void a(View view, View view2, int i) {
        String str;
        BaseActivity baseActivity = (BaseActivity) this.c;
        baseActivity.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        baseActivity.getLayoutMode().a(view);
        r rVar = (r) view.getTag();
        d dVar = (d) getItem(i);
        if (dVar != null) {
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
            rVar.c.setText(str);
            rVar.d.setText(new StringBuilder(String.valueOf(dVar.g())).toString());
            rVar.d.setBackgroundResource(com.baidu.tbadk.core.util.d.b(dVar.g()));
            rVar.e.setText(String.valueOf(dVar.h()) + "/" + dVar.i());
            rVar.m.clearAnimation();
            if (dVar.j()) {
                rVar.b.setVisibility(0);
                rVar.l.setVisibility(8);
                rVar.g.setVisibility(0);
                rVar.h.setVisibility(8);
                rVar.g.setText(String.format(this.c.getString(com.baidu.tieba.x.signallforum_days), Integer.valueOf(dVar.f())));
                if (dVar.o()) {
                    rVar.e.setText(this.c.getString(com.baidu.tieba.x.signallforum_uplevel));
                    rVar.m.setVisibility(8);
                } else {
                    rVar.e.setText(String.valueOf(dVar.h()) + "/" + dVar.i());
                    rVar.m.setVisibility(0);
                }
                int m = dVar.m();
                if (m > 0) {
                    rVar.m.setVisibility(0);
                    rVar.m.setText("+" + m);
                } else {
                    rVar.m.setVisibility(8);
                }
            } else if (dVar.k()) {
                String n = dVar.n();
                if (!TextUtils.isEmpty(n)) {
                    rVar.b.setVisibility(8);
                    rVar.l.setVisibility(0);
                    rVar.m.setVisibility(8);
                    rVar.l.setText(n);
                } else {
                    rVar.b.setVisibility(0);
                    rVar.l.setVisibility(8);
                    rVar.m.setVisibility(8);
                }
                rVar.g.setVisibility(8);
                rVar.h.setVisibility(0);
                if (dVar.l()) {
                    rVar.i.setVisibility(4);
                    rVar.j.setVisibility(0);
                    rVar.k.setText(com.baidu.tieba.x.signallforum_resigning);
                } else {
                    rVar.i.setVisibility(0);
                    rVar.j.setVisibility(4);
                    rVar.k.setText(com.baidu.tieba.x.signallforum_resign);
                }
                rVar.h.setOnClickListener(new p(this, dVar, rVar));
            } else {
                rVar.g.setVisibility(8);
                rVar.h.setVisibility(8);
                rVar.m.setVisibility(8);
                rVar.b.setVisibility(0);
                rVar.l.setVisibility(8);
            }
            String d = dVar.d();
            rVar.a.setTag(d);
            rVar.a.a(d, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.f) {
            return b();
        }
        int itemViewType = getItemViewType(i);
        View a = view == null ? a(itemViewType) : view;
        if (itemViewType == 1) {
            if (a.getTag() != null && (a.getTag() instanceof q)) {
                view2 = a;
                qVar = (q) a.getTag();
            } else {
                View a2 = a(itemViewType);
                view2 = a2;
                qVar = (q) a2.getTag();
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            BaseActivity baseActivity = (BaseActivity) this.c;
            baseActivity.getLayoutMode().a(skinType == 1);
            baseActivity.getLayoutMode().a(view2.findViewById(com.baidu.tieba.u.sign_all_forum_tip));
            qVar.a.setText(((a) getItem(i)).a());
            a(qVar.b, i);
            return view2;
        }
        if (a.getTag() == null || !(a.getTag() instanceof r)) {
            a = a(itemViewType);
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
        View a = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.sign_all_forum_nodata_item, null);
        BaseActivity baseActivity = (BaseActivity) this.c;
        baseActivity.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        baseActivity.getLayoutMode().a(a);
        return a;
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

    @Override // com.baidu.tieba.signall.ae
    public void a(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.d.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ae
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.j.a(this.c, str2);
        }
        synchronized (this) {
            this.d.remove(str);
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
                if (!this.e) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void a() {
        this.e = true;
        synchronized (this) {
            for (Map.Entry<String, ad> entry : this.d.entrySet()) {
                entry.getValue().a();
            }
            this.d.clear();
        }
    }
}
