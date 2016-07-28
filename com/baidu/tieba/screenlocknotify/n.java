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
    private boolean eUK = false;
    private boolean eUL = false;
    private List<p> eUJ = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eUJ != null) {
            return this.eUJ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eUJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.eUJ.get(i);
        if (this.eUK) {
            if (this.eUL && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.eUL) {
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
        aVar.eUM.setText(pVar.content);
        aVar.eUj.setText(pVar.groupName);
        aVar.eUN.setText(qh(pVar.eUX));
        aVar.eUk.setText(cy(pVar.lastTime));
        if (z) {
            aVar.ajP.setVisibility(0);
        } else {
            aVar.ajP.setVisibility(8);
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
        bVar.eUM.setText(pVar.content);
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
        cVar.eUP.setText(pVar.content);
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
        dVar.eUQ.setText(pVar.groupName);
        dVar.eUk.setText(cy(pVar.lastTime));
        dVar.eUR.setText(pVar.title);
        dVar.eUP.setText(pVar.content);
        dVar.eUS.setDefaultResource(u.f.icon_default_bear);
        dVar.eUS.c(pVar.pic, 10, false);
        if (z) {
            dVar.eUT.setVisibility(0);
            dVar.ajP.setVisibility(8);
        } else {
            dVar.eUT.setVisibility(8);
            dVar.ajP.setVisibility(0);
        }
        return view;
    }

    public String cy(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qh(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.eUJ = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View ajP;
        TextView eUM;
        TextView eUN;
        TextView eUj;
        TextView eUk;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView eUM;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView eUP;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        View ajP;
        TextView eUP;
        TextView eUQ;
        TextView eUR;
        TbImageView eUS;
        TextView eUT;
        TextView eUk;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a bm(View view) {
        a aVar = new a(this, null);
        aVar.eUj = (TextView) view.findViewById(u.g.friend_name_show1);
        aVar.eUk = (TextView) view.findViewById(u.g.last_msg_time_show1);
        aVar.eUM = (TextView) view.findViewById(u.g.one_msg_content_show1);
        aVar.eUN = (TextView) view.findViewById(u.g.unread_msg_count_show1);
        aVar.ajP = view.findViewById(u.g.line);
        return aVar;
    }

    private b bn(View view) {
        b bVar = new b(this, null);
        bVar.eUM = (TextView) view.findViewById(u.g.msg_content_2);
        return bVar;
    }

    private c bo(View view) {
        c cVar = new c(this, null);
        cVar.eUP = (TextView) view.findViewById(u.g.one_msg_content);
        return cVar;
    }

    private d bp(View view) {
        d dVar = new d(this, null);
        dVar.eUQ = (TextView) view.findViewById(u.g.push_msg_name);
        dVar.eUR = (TextView) view.findViewById(u.g.push_msg_title);
        dVar.eUk = (TextView) view.findViewById(u.g.push_msg_time);
        dVar.eUP = (TextView) view.findViewById(u.g.push_msg_content);
        dVar.eUT = (TextView) view.findViewById(u.g.push_msg_go);
        dVar.eUS = (TbImageView) view.findViewById(u.g.push_msg_pic);
        dVar.eUS.setAutoChangeStyle(false);
        dVar.ajP = view.findViewById(u.g.line);
        return dVar;
    }

    public void jR(boolean z) {
        this.eUK = z;
    }

    public void jS(boolean z) {
        this.eUL = z;
    }
}
