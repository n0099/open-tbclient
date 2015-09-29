package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context mContext;
    private boolean cKe = false;
    private boolean cKf = false;
    private List<p> cKd = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cKd != null) {
            return this.cKd.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cKd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.cKd.get(i);
        if (this.cKe) {
            if (this.cKf && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.cKf) {
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
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_1, viewGroup, false);
            aVar = aq(view);
            view.setTag(aVar);
        }
        aVar.cKg.setText(pVar.content);
        aVar.cJC.setText(pVar.groupName);
        aVar.cKh.setText(kr(pVar.cKr));
        aVar.cJD.setText(aX(pVar.cIs));
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
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_2, viewGroup, false);
            bVar = ar(view);
            view.setTag(bVar);
        }
        bVar.cKg.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_3, viewGroup, false);
            cVar = as(view);
            view.setTag(cVar);
        }
        cVar.cKj.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_4, viewGroup, false);
            dVar = at(view);
            view.setTag(dVar);
        }
        dVar.cKk.setText(pVar.groupName);
        dVar.cJD.setText(aX(pVar.cIs));
        dVar.cKl.setText(pVar.title);
        dVar.cKj.setText(pVar.content);
        dVar.cKm.setDefaultResource(i.e.icon_default_bear);
        dVar.cKm.d(pVar.pic, 10, false);
        if (z) {
            dVar.cKn.setVisibility(0);
            dVar.mLine.setVisibility(8);
        } else {
            dVar.cKn.setVisibility(8);
            dVar.mLine.setVisibility(0);
        }
        return view;
    }

    public String aX(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String kr(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.cKd = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView cJC;
        TextView cJD;
        TextView cKg;
        TextView cKh;
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
        TextView cKg;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView cKj;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        TextView cJD;
        TextView cKj;
        TextView cKk;
        TextView cKl;
        TbImageView cKm;
        TextView cKn;
        View mLine;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a aq(View view) {
        a aVar = new a(this, null);
        aVar.cJC = (TextView) view.findViewById(i.f.friend_name_show1);
        aVar.cJD = (TextView) view.findViewById(i.f.last_msg_time_show1);
        aVar.cKg = (TextView) view.findViewById(i.f.one_msg_content_show1);
        aVar.cKh = (TextView) view.findViewById(i.f.unread_msg_count_show1);
        aVar.mLine = view.findViewById(i.f.line);
        return aVar;
    }

    private b ar(View view) {
        b bVar = new b(this, null);
        bVar.cKg = (TextView) view.findViewById(i.f.msg_content_2);
        return bVar;
    }

    private c as(View view) {
        c cVar = new c(this, null);
        cVar.cKj = (TextView) view.findViewById(i.f.one_msg_content);
        return cVar;
    }

    private d at(View view) {
        d dVar = new d(this, null);
        dVar.cKk = (TextView) view.findViewById(i.f.push_msg_name);
        dVar.cKl = (TextView) view.findViewById(i.f.push_msg_title);
        dVar.cJD = (TextView) view.findViewById(i.f.push_msg_time);
        dVar.cKj = (TextView) view.findViewById(i.f.push_msg_content);
        dVar.cKn = (TextView) view.findViewById(i.f.push_msg_go);
        dVar.cKm = (TbImageView) view.findViewById(i.f.push_msg_pic);
        dVar.mLine = view.findViewById(i.f.line);
        return dVar;
    }

    public void fP(boolean z) {
        this.cKe = z;
    }

    public void fQ(boolean z) {
        this.cKf = z;
    }
}
