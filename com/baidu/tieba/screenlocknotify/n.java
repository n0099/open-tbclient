package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context mContext;
    private boolean dkp = false;
    private boolean dkq = false;
    private List<p> dko = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dko != null) {
            return this.dko.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dko.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.dko.get(i);
        if (this.dkp) {
            if (this.dkq && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.dkq) {
            return b(pVar, view, viewGroup, getCount() == 1);
        } else if (i == 0) {
            return a(pVar, view, viewGroup);
        } else {
            return b(pVar, view, viewGroup);
        }
    }

    public View a(p pVar, View view, ViewGroup viewGroup, boolean z) {
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.g.screenlock_show_item_view_1, viewGroup, false);
            aVar = az(view);
            view.setTag(aVar);
        }
        aVar.dkr.setText(pVar.content);
        aVar.djO.setText(pVar.groupName);
        aVar.dks.setText(lP(pVar.dkC));
        aVar.djP.setText(bB(pVar.dkE));
        if (z) {
            aVar.mLine.setVisibility(0);
        } else {
            aVar.mLine.setVisibility(8);
        }
        return view;
    }

    public View a(p pVar, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.g.screenlock_show_item_view_2, viewGroup, false);
            bVar = aA(view);
            view.setTag(bVar);
        }
        bVar.dkr.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.g.screenlock_show_item_view_3, viewGroup, false);
            cVar = aB(view);
            view.setTag(cVar);
        }
        cVar.dku.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.g.screenlock_show_item_view_4, viewGroup, false);
            dVar = aC(view);
            view.setTag(dVar);
        }
        dVar.dkv.setText(pVar.groupName);
        dVar.djP.setText(bB(pVar.dkE));
        dVar.dkw.setText(pVar.title);
        dVar.dku.setText(pVar.content);
        dVar.dkx.setDefaultResource(n.e.icon_default_bear);
        dVar.dkx.d(pVar.pic, 10, false);
        if (z) {
            dVar.dky.setVisibility(0);
            dVar.mLine.setVisibility(8);
        } else {
            dVar.dky.setVisibility(8);
            dVar.mLine.setVisibility(0);
        }
        return view;
    }

    public String bB(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String lP(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.dko = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView djO;
        TextView djP;
        TextView dkr;
        TextView dks;
        View mLine;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView dkr;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView dku;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        TextView djP;
        TextView dku;
        TextView dkv;
        TextView dkw;
        TbImageView dkx;
        TextView dky;
        View mLine;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a az(View view) {
        a aVar = new a(this, null);
        aVar.djO = (TextView) view.findViewById(n.f.friend_name_show1);
        aVar.djP = (TextView) view.findViewById(n.f.last_msg_time_show1);
        aVar.dkr = (TextView) view.findViewById(n.f.one_msg_content_show1);
        aVar.dks = (TextView) view.findViewById(n.f.unread_msg_count_show1);
        aVar.mLine = view.findViewById(n.f.line);
        return aVar;
    }

    private b aA(View view) {
        b bVar = new b(this, null);
        bVar.dkr = (TextView) view.findViewById(n.f.msg_content_2);
        return bVar;
    }

    private c aB(View view) {
        c cVar = new c(this, null);
        cVar.dku = (TextView) view.findViewById(n.f.one_msg_content);
        return cVar;
    }

    private d aC(View view) {
        d dVar = new d(this, null);
        dVar.dkv = (TextView) view.findViewById(n.f.push_msg_name);
        dVar.dkw = (TextView) view.findViewById(n.f.push_msg_title);
        dVar.djP = (TextView) view.findViewById(n.f.push_msg_time);
        dVar.dku = (TextView) view.findViewById(n.f.push_msg_content);
        dVar.dky = (TextView) view.findViewById(n.f.push_msg_go);
        dVar.dkx = (TbImageView) view.findViewById(n.f.push_msg_pic);
        dVar.mLine = view.findViewById(n.f.line);
        return dVar;
    }

    public void gI(boolean z) {
        this.dkp = z;
    }

    public void gJ(boolean z) {
        this.dkq = z;
    }
}
