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
    private boolean fcW = false;
    private boolean fcX = false;
    private List<p> fcV = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fcV != null) {
            return this.fcV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.fcV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.fcV.get(i);
        if (this.fcW) {
            if (this.fcX && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.fcX) {
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
            aVar = bl(view);
            view.setTag(aVar);
        }
        aVar.fcY.setText(pVar.content);
        aVar.fcv.setText(pVar.groupName);
        aVar.fcZ.setText(qJ(pVar.fdj));
        aVar.fcw.setText(cR(pVar.lastTime));
        if (z) {
            aVar.amU.setVisibility(0);
        } else {
            aVar.amU.setVisibility(8);
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
            bVar = bm(view);
            view.setTag(bVar);
        }
        bVar.fcY.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_3, viewGroup, false);
            cVar = bn(view);
            view.setTag(cVar);
        }
        cVar.fdb.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_4, viewGroup, false);
            dVar = bo(view);
            view.setTag(dVar);
        }
        dVar.fdc.setText(pVar.groupName);
        dVar.fcw.setText(cR(pVar.lastTime));
        dVar.fdd.setText(pVar.title);
        dVar.fdb.setText(pVar.content);
        dVar.fde.setDefaultResource(t.f.icon_default_bear);
        dVar.fde.c(pVar.pic, 10, false);
        if (z) {
            dVar.fdf.setVisibility(0);
            dVar.amU.setVisibility(8);
        } else {
            dVar.fdf.setVisibility(8);
            dVar.amU.setVisibility(0);
        }
        return view;
    }

    public String cR(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qJ(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.fcV = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View amU;
        TextView fcY;
        TextView fcZ;
        TextView fcv;
        TextView fcw;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView fcY;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView fdb;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        View amU;
        TextView fcw;
        TextView fdb;
        TextView fdc;
        TextView fdd;
        TbImageView fde;
        TextView fdf;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a bl(View view) {
        a aVar = new a(this, null);
        aVar.fcv = (TextView) view.findViewById(t.g.friend_name_show1);
        aVar.fcw = (TextView) view.findViewById(t.g.last_msg_time_show1);
        aVar.fcY = (TextView) view.findViewById(t.g.one_msg_content_show1);
        aVar.fcZ = (TextView) view.findViewById(t.g.unread_msg_count_show1);
        aVar.amU = view.findViewById(t.g.line);
        return aVar;
    }

    private b bm(View view) {
        b bVar = new b(this, null);
        bVar.fcY = (TextView) view.findViewById(t.g.msg_content_2);
        return bVar;
    }

    private c bn(View view) {
        c cVar = new c(this, null);
        cVar.fdb = (TextView) view.findViewById(t.g.one_msg_content);
        return cVar;
    }

    private d bo(View view) {
        d dVar = new d(this, null);
        dVar.fdc = (TextView) view.findViewById(t.g.push_msg_name);
        dVar.fdd = (TextView) view.findViewById(t.g.push_msg_title);
        dVar.fcw = (TextView) view.findViewById(t.g.push_msg_time);
        dVar.fdb = (TextView) view.findViewById(t.g.push_msg_content);
        dVar.fdf = (TextView) view.findViewById(t.g.push_msg_go);
        dVar.fde = (TbImageView) view.findViewById(t.g.push_msg_pic);
        dVar.fde.setAutoChangeStyle(false);
        dVar.amU = view.findViewById(t.g.line);
        return dVar;
    }

    public void kd(boolean z) {
        this.fcW = z;
    }

    public void ke(boolean z) {
        this.fcX = z;
    }
}
