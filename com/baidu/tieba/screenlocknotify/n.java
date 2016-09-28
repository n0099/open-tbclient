package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context mContext;
    private boolean ffE = false;
    private boolean ffF = false;
    private List<p> ffD = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ffD != null) {
            return this.ffD.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ffD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.ffD.get(i);
        if (this.ffE) {
            if (this.ffF && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.ffF) {
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
            view = LayoutInflater.from(this.mContext).inflate(r.h.screenlock_show_item_view_1, viewGroup, false);
            aVar = bj(view);
            view.setTag(aVar);
        }
        aVar.ffG.setText(pVar.content);
        aVar.ffd.setText(pVar.groupName);
        aVar.ffH.setText(qX(pVar.ffR));
        aVar.ffe.setText(cR(pVar.lastTime));
        if (z) {
            aVar.amC.setVisibility(0);
        } else {
            aVar.amC.setVisibility(8);
        }
        return view;
    }

    public View a(p pVar, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        }
        if (bVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(r.h.screenlock_show_item_view_2, viewGroup, false);
            bVar = bk(view);
            view.setTag(bVar);
        }
        bVar.ffG.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(r.h.screenlock_show_item_view_3, viewGroup, false);
            cVar = bl(view);
            view.setTag(cVar);
        }
        cVar.ffJ.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(r.h.screenlock_show_item_view_4, viewGroup, false);
            dVar = bm(view);
            view.setTag(dVar);
        }
        dVar.ffK.setText(pVar.groupName);
        dVar.ffe.setText(cR(pVar.lastTime));
        dVar.ffL.setText(pVar.title);
        dVar.ffJ.setText(pVar.content);
        dVar.ffM.setDefaultResource(r.f.icon_default_bear);
        dVar.ffM.c(pVar.pic, 10, false);
        if (z) {
            dVar.ffN.setVisibility(0);
            dVar.amC.setVisibility(8);
        } else {
            dVar.ffN.setVisibility(8);
            dVar.amC.setVisibility(0);
        }
        return view;
    }

    public String cR(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qX(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.ffD = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View amC;
        TextView ffG;
        TextView ffH;
        TextView ffd;
        TextView ffe;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView ffG;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView ffJ;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        View amC;
        TextView ffJ;
        TextView ffK;
        TextView ffL;
        TbImageView ffM;
        TextView ffN;
        TextView ffe;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a bj(View view) {
        a aVar = new a(this, null);
        aVar.ffd = (TextView) view.findViewById(r.g.friend_name_show1);
        aVar.ffe = (TextView) view.findViewById(r.g.last_msg_time_show1);
        aVar.ffG = (TextView) view.findViewById(r.g.one_msg_content_show1);
        aVar.ffH = (TextView) view.findViewById(r.g.unread_msg_count_show1);
        aVar.amC = view.findViewById(r.g.line);
        return aVar;
    }

    private b bk(View view) {
        b bVar = new b(this, null);
        bVar.ffG = (TextView) view.findViewById(r.g.msg_content_2);
        return bVar;
    }

    private c bl(View view) {
        c cVar = new c(this, null);
        cVar.ffJ = (TextView) view.findViewById(r.g.one_msg_content);
        return cVar;
    }

    private d bm(View view) {
        d dVar = new d(this, null);
        dVar.ffK = (TextView) view.findViewById(r.g.push_msg_name);
        dVar.ffL = (TextView) view.findViewById(r.g.push_msg_title);
        dVar.ffe = (TextView) view.findViewById(r.g.push_msg_time);
        dVar.ffJ = (TextView) view.findViewById(r.g.push_msg_content);
        dVar.ffN = (TextView) view.findViewById(r.g.push_msg_go);
        dVar.ffM = (TbImageView) view.findViewById(r.g.push_msg_pic);
        dVar.ffM.setAutoChangeStyle(false);
        dVar.amC = view.findViewById(r.g.line);
        return dVar;
    }

    public void kg(boolean z) {
        this.ffE = z;
    }

    public void kh(boolean z) {
        this.ffF = z;
    }
}
