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
    private boolean dHB = false;
    private boolean dHC = false;
    private List<p> dHA = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dHA != null) {
            return this.dHA.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dHA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.dHA.get(i);
        if (this.dHB) {
            if (this.dHC && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.dHC) {
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
            aVar = aW(view);
            view.setTag(aVar);
        }
        aVar.dHD.setText(pVar.content);
        aVar.dHa.setText(pVar.groupName);
        aVar.dHE.setText(nC(pVar.dHO));
        aVar.dHb.setText(bO(pVar.dHQ));
        if (z) {
            aVar.amq.setVisibility(0);
        } else {
            aVar.amq.setVisibility(8);
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
            bVar = aX(view);
            view.setTag(bVar);
        }
        bVar.dHD.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_3, viewGroup, false);
            cVar = aY(view);
            view.setTag(cVar);
        }
        cVar.dHG.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.screenlock_show_item_view_4, viewGroup, false);
            dVar = aZ(view);
            view.setTag(dVar);
        }
        dVar.dHH.setText(pVar.groupName);
        dVar.dHb.setText(bO(pVar.dHQ));
        dVar.dHI.setText(pVar.title);
        dVar.dHG.setText(pVar.content);
        dVar.dHJ.setDefaultResource(t.f.icon_default_bear);
        dVar.dHJ.d(pVar.pic, 10, false);
        if (z) {
            dVar.dHK.setVisibility(0);
            dVar.amq.setVisibility(8);
        } else {
            dVar.dHK.setVisibility(8);
            dVar.amq.setVisibility(0);
        }
        return view;
    }

    public String bO(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String nC(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.dHA = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View amq;
        TextView dHD;
        TextView dHE;
        TextView dHa;
        TextView dHb;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView dHD;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView dHG;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        View amq;
        TextView dHG;
        TextView dHH;
        TextView dHI;
        TbImageView dHJ;
        TextView dHK;
        TextView dHb;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a aW(View view) {
        a aVar = new a(this, null);
        aVar.dHa = (TextView) view.findViewById(t.g.friend_name_show1);
        aVar.dHb = (TextView) view.findViewById(t.g.last_msg_time_show1);
        aVar.dHD = (TextView) view.findViewById(t.g.one_msg_content_show1);
        aVar.dHE = (TextView) view.findViewById(t.g.unread_msg_count_show1);
        aVar.amq = view.findViewById(t.g.line);
        return aVar;
    }

    private b aX(View view) {
        b bVar = new b(this, null);
        bVar.dHD = (TextView) view.findViewById(t.g.msg_content_2);
        return bVar;
    }

    private c aY(View view) {
        c cVar = new c(this, null);
        cVar.dHG = (TextView) view.findViewById(t.g.one_msg_content);
        return cVar;
    }

    private d aZ(View view) {
        d dVar = new d(this, null);
        dVar.dHH = (TextView) view.findViewById(t.g.push_msg_name);
        dVar.dHI = (TextView) view.findViewById(t.g.push_msg_title);
        dVar.dHb = (TextView) view.findViewById(t.g.push_msg_time);
        dVar.dHG = (TextView) view.findViewById(t.g.push_msg_content);
        dVar.dHK = (TextView) view.findViewById(t.g.push_msg_go);
        dVar.dHJ = (TbImageView) view.findViewById(t.g.push_msg_pic);
        dVar.amq = view.findViewById(t.g.line);
        return dVar;
    }

    public void hq(boolean z) {
        this.dHB = z;
    }

    public void hr(boolean z) {
        this.dHC = z;
    }
}
