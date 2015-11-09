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
    private boolean cLZ = false;
    private boolean cMa = false;
    private List<p> cLY = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cLY != null) {
            return this.cLY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cLY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.cLY.get(i);
        if (this.cLZ) {
            if (this.cMa && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.cMa) {
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
            aVar = ap(view);
            view.setTag(aVar);
        }
        aVar.cMb.setText(pVar.content);
        aVar.cLx.setText(pVar.groupName);
        aVar.cMc.setText(kH(pVar.cMm));
        aVar.cLy.setText(bf(pVar.cKn));
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
            bVar = aq(view);
            view.setTag(bVar);
        }
        bVar.cMb.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_3, viewGroup, false);
            cVar = ar(view);
            view.setTag(cVar);
        }
        cVar.cMe.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_4, viewGroup, false);
            dVar = as(view);
            view.setTag(dVar);
        }
        dVar.cMf.setText(pVar.groupName);
        dVar.cLy.setText(bf(pVar.cKn));
        dVar.cMg.setText(pVar.title);
        dVar.cMe.setText(pVar.content);
        dVar.cMh.setDefaultResource(i.e.icon_default_bear);
        dVar.cMh.d(pVar.pic, 10, false);
        if (z) {
            dVar.cMi.setVisibility(0);
            dVar.mLine.setVisibility(8);
        } else {
            dVar.cMi.setVisibility(8);
            dVar.mLine.setVisibility(0);
        }
        return view;
    }

    public String bf(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String kH(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.cLY = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView cLx;
        TextView cLy;
        TextView cMb;
        TextView cMc;
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
        TextView cMb;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView cMe;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        TextView cLy;
        TextView cMe;
        TextView cMf;
        TextView cMg;
        TbImageView cMh;
        TextView cMi;
        View mLine;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a ap(View view) {
        a aVar = new a(this, null);
        aVar.cLx = (TextView) view.findViewById(i.f.friend_name_show1);
        aVar.cLy = (TextView) view.findViewById(i.f.last_msg_time_show1);
        aVar.cMb = (TextView) view.findViewById(i.f.one_msg_content_show1);
        aVar.cMc = (TextView) view.findViewById(i.f.unread_msg_count_show1);
        aVar.mLine = view.findViewById(i.f.line);
        return aVar;
    }

    private b aq(View view) {
        b bVar = new b(this, null);
        bVar.cMb = (TextView) view.findViewById(i.f.msg_content_2);
        return bVar;
    }

    private c ar(View view) {
        c cVar = new c(this, null);
        cVar.cMe = (TextView) view.findViewById(i.f.one_msg_content);
        return cVar;
    }

    private d as(View view) {
        d dVar = new d(this, null);
        dVar.cMf = (TextView) view.findViewById(i.f.push_msg_name);
        dVar.cMg = (TextView) view.findViewById(i.f.push_msg_title);
        dVar.cLy = (TextView) view.findViewById(i.f.push_msg_time);
        dVar.cMe = (TextView) view.findViewById(i.f.push_msg_content);
        dVar.cMi = (TextView) view.findViewById(i.f.push_msg_go);
        dVar.cMh = (TbImageView) view.findViewById(i.f.push_msg_pic);
        dVar.mLine = view.findViewById(i.f.line);
        return dVar;
    }

    public void fS(boolean z) {
        this.cLZ = z;
    }

    public void fT(boolean z) {
        this.cMa = z;
    }
}
