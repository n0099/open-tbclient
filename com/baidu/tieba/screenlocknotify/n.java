package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context mContext;
    private boolean eHI = false;
    private boolean eHJ = false;
    private List<p> eHH = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHH != null) {
            return this.eHH.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eHH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.eHH.get(i);
        if (this.eHI) {
            if (this.eHJ && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.eHJ) {
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
            view = LayoutInflater.from(this.mContext).inflate(u.h.screenlock_show_item_view_1, viewGroup, false);
            aVar = bm(view);
            view.setTag(aVar);
        }
        aVar.eHK.setText(pVar.content);
        aVar.eHh.setText(pVar.groupName);
        aVar.eHL.setText(pP(pVar.eHV));
        aVar.eHi.setText(cz(pVar.lastTime));
        if (z) {
            aVar.aja.setVisibility(0);
        } else {
            aVar.aja.setVisibility(8);
        }
        return view;
    }

    public View a(p pVar, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(u.h.screenlock_show_item_view_2, viewGroup, false);
            bVar = bn(view);
            view.setTag(bVar);
        }
        bVar.eHK.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(u.h.screenlock_show_item_view_3, viewGroup, false);
            cVar = bo(view);
            view.setTag(cVar);
        }
        cVar.eHN.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(u.h.screenlock_show_item_view_4, viewGroup, false);
            dVar = bp(view);
            view.setTag(dVar);
        }
        dVar.eHO.setText(pVar.groupName);
        dVar.eHi.setText(cz(pVar.lastTime));
        dVar.eHP.setText(pVar.title);
        dVar.eHN.setText(pVar.content);
        dVar.eHQ.setDefaultResource(u.f.icon_default_bear);
        dVar.eHQ.c(pVar.pic, 10, false);
        if (z) {
            dVar.eHR.setVisibility(0);
            dVar.aja.setVisibility(8);
        } else {
            dVar.eHR.setVisibility(8);
            dVar.aja.setVisibility(0);
        }
        return view;
    }

    public String cz(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String pP(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.eHH = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aja;
        TextView eHK;
        TextView eHL;
        TextView eHh;
        TextView eHi;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView eHK;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView eHN;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        View aja;
        TextView eHN;
        TextView eHO;
        TextView eHP;
        TbImageView eHQ;
        TextView eHR;
        TextView eHi;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a bm(View view) {
        a aVar = new a(this, null);
        aVar.eHh = (TextView) view.findViewById(u.g.friend_name_show1);
        aVar.eHi = (TextView) view.findViewById(u.g.last_msg_time_show1);
        aVar.eHK = (TextView) view.findViewById(u.g.one_msg_content_show1);
        aVar.eHL = (TextView) view.findViewById(u.g.unread_msg_count_show1);
        aVar.aja = view.findViewById(u.g.line);
        return aVar;
    }

    private b bn(View view) {
        b bVar = new b(this, null);
        bVar.eHK = (TextView) view.findViewById(u.g.msg_content_2);
        return bVar;
    }

    private c bo(View view) {
        c cVar = new c(this, null);
        cVar.eHN = (TextView) view.findViewById(u.g.one_msg_content);
        return cVar;
    }

    private d bp(View view) {
        d dVar = new d(this, null);
        dVar.eHO = (TextView) view.findViewById(u.g.push_msg_name);
        dVar.eHP = (TextView) view.findViewById(u.g.push_msg_title);
        dVar.eHi = (TextView) view.findViewById(u.g.push_msg_time);
        dVar.eHN = (TextView) view.findViewById(u.g.push_msg_content);
        dVar.eHR = (TextView) view.findViewById(u.g.push_msg_go);
        dVar.eHQ = (TbImageView) view.findViewById(u.g.push_msg_pic);
        dVar.eHQ.setAutoChangeStyle(false);
        dVar.aja = view.findViewById(u.g.line);
        return dVar;
    }

    public void jD(boolean z) {
        this.eHI = z;
    }

    public void jE(boolean z) {
        this.eHJ = z;
    }
}
