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
    private boolean cKD = false;
    private boolean cKE = false;
    private List<p> cKC = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cKC != null) {
            return this.cKC.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cKC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.cKC.get(i);
        if (this.cKD) {
            if (this.cKE && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.cKE) {
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
        aVar.cKF.setText(pVar.content);
        aVar.cKb.setText(pVar.groupName);
        aVar.cKG.setText(kt(pVar.cKQ));
        aVar.cKc.setText(bf(pVar.cIR));
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
        bVar.cKF.setText(pVar.content);
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
        cVar.cKI.setText(pVar.content);
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
        dVar.cKJ.setText(pVar.groupName);
        dVar.cKc.setText(bf(pVar.cIR));
        dVar.cKK.setText(pVar.title);
        dVar.cKI.setText(pVar.content);
        dVar.cKL.setDefaultResource(i.e.icon_default_bear);
        dVar.cKL.d(pVar.pic, 10, false);
        if (z) {
            dVar.cKM.setVisibility(0);
            dVar.mLine.setVisibility(8);
        } else {
            dVar.cKM.setVisibility(8);
            dVar.mLine.setVisibility(0);
        }
        return view;
    }

    public String bf(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String kt(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.cKC = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView cKF;
        TextView cKG;
        TextView cKb;
        TextView cKc;
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
        TextView cKF;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView cKI;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        TextView cKI;
        TextView cKJ;
        TextView cKK;
        TbImageView cKL;
        TextView cKM;
        TextView cKc;
        View mLine;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a aq(View view) {
        a aVar = new a(this, null);
        aVar.cKb = (TextView) view.findViewById(i.f.friend_name_show1);
        aVar.cKc = (TextView) view.findViewById(i.f.last_msg_time_show1);
        aVar.cKF = (TextView) view.findViewById(i.f.one_msg_content_show1);
        aVar.cKG = (TextView) view.findViewById(i.f.unread_msg_count_show1);
        aVar.mLine = view.findViewById(i.f.line);
        return aVar;
    }

    private b ar(View view) {
        b bVar = new b(this, null);
        bVar.cKF = (TextView) view.findViewById(i.f.msg_content_2);
        return bVar;
    }

    private c as(View view) {
        c cVar = new c(this, null);
        cVar.cKI = (TextView) view.findViewById(i.f.one_msg_content);
        return cVar;
    }

    private d at(View view) {
        d dVar = new d(this, null);
        dVar.cKJ = (TextView) view.findViewById(i.f.push_msg_name);
        dVar.cKK = (TextView) view.findViewById(i.f.push_msg_title);
        dVar.cKc = (TextView) view.findViewById(i.f.push_msg_time);
        dVar.cKI = (TextView) view.findViewById(i.f.push_msg_content);
        dVar.cKM = (TextView) view.findViewById(i.f.push_msg_go);
        dVar.cKL = (TbImageView) view.findViewById(i.f.push_msg_pic);
        dVar.mLine = view.findViewById(i.f.line);
        return dVar;
    }

    public void fP(boolean z) {
        this.cKD = z;
    }

    public void fQ(boolean z) {
        this.cKE = z;
    }
}
