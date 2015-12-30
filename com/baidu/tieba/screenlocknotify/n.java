package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context mContext;
    private boolean drx = false;
    private boolean dry = false;
    private List<p> drw = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.drw != null) {
            return this.drw.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.drw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.drw.get(i);
        if (this.drx) {
            if (this.dry && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.dry) {
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
            view = LayoutInflater.from(this.mContext).inflate(n.h.screenlock_show_item_view_1, viewGroup, false);
            aVar = aF(view);
            view.setTag(aVar);
        }
        aVar.drz.setText(pVar.content);
        aVar.dqW.setText(pVar.groupName);
        aVar.drA.setText(mq(pVar.drK));
        aVar.dqX.setText(bK(pVar.drM));
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
            view = LayoutInflater.from(this.mContext).inflate(n.h.screenlock_show_item_view_2, viewGroup, false);
            bVar = aG(view);
            view.setTag(bVar);
        }
        bVar.drz.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.h.screenlock_show_item_view_3, viewGroup, false);
            cVar = aH(view);
            view.setTag(cVar);
        }
        cVar.drC.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.h.screenlock_show_item_view_4, viewGroup, false);
            dVar = aI(view);
            view.setTag(dVar);
        }
        dVar.drD.setText(pVar.groupName);
        dVar.dqX.setText(bK(pVar.drM));
        dVar.drE.setText(pVar.title);
        dVar.drC.setText(pVar.content);
        dVar.drF.setDefaultResource(n.f.icon_default_bear);
        dVar.drF.d(pVar.pic, 10, false);
        if (z) {
            dVar.drG.setVisibility(0);
            dVar.mLine.setVisibility(8);
        } else {
            dVar.drG.setVisibility(8);
            dVar.mLine.setVisibility(0);
        }
        return view;
    }

    public String bK(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String mq(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.drw = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView dqW;
        TextView dqX;
        TextView drA;
        TextView drz;
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
        TextView drz;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView drC;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        TextView dqX;
        TextView drC;
        TextView drD;
        TextView drE;
        TbImageView drF;
        TextView drG;
        View mLine;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a aF(View view) {
        a aVar = new a(this, null);
        aVar.dqW = (TextView) view.findViewById(n.g.friend_name_show1);
        aVar.dqX = (TextView) view.findViewById(n.g.last_msg_time_show1);
        aVar.drz = (TextView) view.findViewById(n.g.one_msg_content_show1);
        aVar.drA = (TextView) view.findViewById(n.g.unread_msg_count_show1);
        aVar.mLine = view.findViewById(n.g.line);
        return aVar;
    }

    private b aG(View view) {
        b bVar = new b(this, null);
        bVar.drz = (TextView) view.findViewById(n.g.msg_content_2);
        return bVar;
    }

    private c aH(View view) {
        c cVar = new c(this, null);
        cVar.drC = (TextView) view.findViewById(n.g.one_msg_content);
        return cVar;
    }

    private d aI(View view) {
        d dVar = new d(this, null);
        dVar.drD = (TextView) view.findViewById(n.g.push_msg_name);
        dVar.drE = (TextView) view.findViewById(n.g.push_msg_title);
        dVar.dqX = (TextView) view.findViewById(n.g.push_msg_time);
        dVar.drC = (TextView) view.findViewById(n.g.push_msg_content);
        dVar.drG = (TextView) view.findViewById(n.g.push_msg_go);
        dVar.drF = (TbImageView) view.findViewById(n.g.push_msg_pic);
        dVar.mLine = view.findViewById(n.g.line);
        return dVar;
    }

    public void gQ(boolean z) {
        this.drx = z;
    }

    public void gR(boolean z) {
        this.dry = z;
    }
}
