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
    private boolean dZV = false;
    private boolean dZW = false;
    private List<p> dZU = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dZU != null) {
            return this.dZU.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dZU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.dZU.get(i);
        if (this.dZV) {
            if (this.dZW && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.dZW) {
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
            aVar = bb(view);
            view.setTag(aVar);
        }
        aVar.dZX.setText(pVar.content);
        aVar.dZu.setText(pVar.groupName);
        aVar.dZY.setText(oH(pVar.eai));
        aVar.dZv.setText(bY(pVar.eak));
        if (z) {
            aVar.amH.setVisibility(0);
        } else {
            aVar.amH.setVisibility(8);
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
            bVar = bc(view);
            view.setTag(bVar);
        }
        bVar.dZX.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_3, viewGroup, false);
            cVar = bd(view);
            view.setTag(cVar);
        }
        cVar.eaa.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_4, viewGroup, false);
            dVar = be(view);
            view.setTag(dVar);
        }
        dVar.eab.setText(pVar.groupName);
        dVar.dZv.setText(bY(pVar.eak));
        dVar.eac.setText(pVar.title);
        dVar.eaa.setText(pVar.content);
        dVar.ead.setDefaultResource(t.f.icon_default_bear);
        dVar.ead.c(pVar.pic, 10, false);
        if (z) {
            dVar.eae.setVisibility(0);
            dVar.amH.setVisibility(8);
        } else {
            dVar.eae.setVisibility(8);
            dVar.amH.setVisibility(0);
        }
        return view;
    }

    public String bY(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String oH(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.dZU = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View amH;
        TextView dZX;
        TextView dZY;
        TextView dZu;
        TextView dZv;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView dZX;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView eaa;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        View amH;
        TextView dZv;
        TextView eaa;
        TextView eab;
        TextView eac;
        TbImageView ead;
        TextView eae;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a bb(View view) {
        a aVar = new a(this, null);
        aVar.dZu = (TextView) view.findViewById(t.g.friend_name_show1);
        aVar.dZv = (TextView) view.findViewById(t.g.last_msg_time_show1);
        aVar.dZX = (TextView) view.findViewById(t.g.one_msg_content_show1);
        aVar.dZY = (TextView) view.findViewById(t.g.unread_msg_count_show1);
        aVar.amH = view.findViewById(t.g.line);
        return aVar;
    }

    private b bc(View view) {
        b bVar = new b(this, null);
        bVar.dZX = (TextView) view.findViewById(t.g.msg_content_2);
        return bVar;
    }

    private c bd(View view) {
        c cVar = new c(this, null);
        cVar.eaa = (TextView) view.findViewById(t.g.one_msg_content);
        return cVar;
    }

    private d be(View view) {
        d dVar = new d(this, null);
        dVar.eab = (TextView) view.findViewById(t.g.push_msg_name);
        dVar.eac = (TextView) view.findViewById(t.g.push_msg_title);
        dVar.dZv = (TextView) view.findViewById(t.g.push_msg_time);
        dVar.eaa = (TextView) view.findViewById(t.g.push_msg_content);
        dVar.eae = (TextView) view.findViewById(t.g.push_msg_go);
        dVar.ead = (TbImageView) view.findViewById(t.g.push_msg_pic);
        dVar.amH = view.findViewById(t.g.line);
        return dVar;
    }

    public void id(boolean z) {
        this.dZV = z;
    }

    public void ie(boolean z) {
        this.dZW = z;
    }
}
