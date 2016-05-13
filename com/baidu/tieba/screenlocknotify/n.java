package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context mContext;
    private boolean edc = false;
    private boolean edd = false;
    private List<p> edb = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.edb != null) {
            return this.edb.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.edb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.edb.get(i);
        if (this.edc) {
            if (this.edd && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.edd) {
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
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_1, viewGroup, false);
            aVar = be(view);
            view.setTag(aVar);
        }
        aVar.ede.setText(pVar.content);
        aVar.ecB.setText(pVar.groupName);
        aVar.edf.setText(oA(pVar.edp));
        aVar.ecC.setText(bY(pVar.lastTime));
        if (z) {
            aVar.aiu.setVisibility(0);
        } else {
            aVar.aiu.setVisibility(8);
        }
        return view;
    }

    public View a(p pVar, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_2, viewGroup, false);
            bVar = bf(view);
            view.setTag(bVar);
        }
        bVar.ede.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_3, viewGroup, false);
            cVar = bg(view);
            view.setTag(cVar);
        }
        cVar.edh.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_4, viewGroup, false);
            dVar = bh(view);
            view.setTag(dVar);
        }
        dVar.edi.setText(pVar.groupName);
        dVar.ecC.setText(bY(pVar.lastTime));
        dVar.edj.setText(pVar.title);
        dVar.edh.setText(pVar.content);
        dVar.edk.setDefaultResource(t.f.icon_default_bear);
        dVar.edk.c(pVar.pic, 10, false);
        if (z) {
            dVar.edl.setVisibility(0);
            dVar.aiu.setVisibility(8);
        } else {
            dVar.edl.setVisibility(8);
            dVar.aiu.setVisibility(0);
        }
        return view;
    }

    public String bY(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String oA(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.edb = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aiu;
        TextView ecB;
        TextView ecC;
        TextView ede;
        TextView edf;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView ede;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView edh;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        View aiu;
        TextView ecC;
        TextView edh;
        TextView edi;
        TextView edj;
        TbImageView edk;
        TextView edl;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a be(View view) {
        a aVar = new a(this, null);
        aVar.ecB = (TextView) view.findViewById(t.g.friend_name_show1);
        aVar.ecC = (TextView) view.findViewById(t.g.last_msg_time_show1);
        aVar.ede = (TextView) view.findViewById(t.g.one_msg_content_show1);
        aVar.edf = (TextView) view.findViewById(t.g.unread_msg_count_show1);
        aVar.aiu = view.findViewById(t.g.line);
        return aVar;
    }

    private b bf(View view) {
        b bVar = new b(this, null);
        bVar.ede = (TextView) view.findViewById(t.g.msg_content_2);
        return bVar;
    }

    private c bg(View view) {
        c cVar = new c(this, null);
        cVar.edh = (TextView) view.findViewById(t.g.one_msg_content);
        return cVar;
    }

    private d bh(View view) {
        d dVar = new d(this, null);
        dVar.edi = (TextView) view.findViewById(t.g.push_msg_name);
        dVar.edj = (TextView) view.findViewById(t.g.push_msg_title);
        dVar.ecC = (TextView) view.findViewById(t.g.push_msg_time);
        dVar.edh = (TextView) view.findViewById(t.g.push_msg_content);
        dVar.edl = (TextView) view.findViewById(t.g.push_msg_go);
        dVar.edk = (TbImageView) view.findViewById(t.g.push_msg_pic);
        dVar.aiu = view.findViewById(t.g.line);
        return dVar;
    }

    public void iS(boolean z) {
        this.edc = z;
    }

    public void iT(boolean z) {
        this.edd = z;
    }
}
