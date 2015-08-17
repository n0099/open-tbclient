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
    private boolean cuH = false;
    private boolean cuI = false;
    private List<p> cuG = new ArrayList();

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cuG != null) {
            return this.cuG.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cuG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar = this.cuG.get(i);
        if (this.cuH) {
            if (this.cuI && pVar.customGroupType == 4) {
                return b(pVar, view, viewGroup, false);
            }
            return a(pVar, view, viewGroup, true);
        } else if (this.cuI) {
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
            aVar = ag(view);
            view.setTag(aVar);
        }
        aVar.cuJ.setText(pVar.content);
        aVar.cuf.setText(pVar.groupName);
        aVar.cuK.setText(ji(pVar.cuU));
        aVar.cug.setText(av(pVar.csY));
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
            bVar = ah(view);
            view.setTag(bVar);
        }
        bVar.cuJ.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_3, viewGroup, false);
            cVar = ai(view);
            view.setTag(cVar);
        }
        cVar.cuM.setText(pVar.content);
        return view;
    }

    public View b(p pVar, View view, ViewGroup viewGroup, boolean z) {
        d dVar = null;
        if (view != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        }
        if (dVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.screenlock_show_item_view_4, viewGroup, false);
            dVar = aj(view);
            view.setTag(dVar);
        }
        dVar.cuN.setText(pVar.groupName);
        dVar.cug.setText(av(pVar.csY));
        dVar.cuO.setText(pVar.title);
        dVar.cuM.setText(pVar.content);
        dVar.cuP.d(pVar.pic, 10, false);
        if (z) {
            dVar.cuQ.setVisibility(0);
            dVar.mLine.setVisibility(8);
        } else {
            dVar.cuQ.setVisibility(8);
            dVar.mLine.setVisibility(0);
        }
        return view;
    }

    public String av(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String ji(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<p> list) {
        this.cuG = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView cuJ;
        TextView cuK;
        TextView cuf;
        TextView cug;
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
        TextView cuJ;

        private b() {
        }

        /* synthetic */ b(n nVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView cuM;

        private c() {
        }

        /* synthetic */ c(n nVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {
        TextView cuM;
        TextView cuN;
        TextView cuO;
        TbImageView cuP;
        TextView cuQ;
        TextView cug;
        View mLine;

        private d() {
        }

        /* synthetic */ d(n nVar, d dVar) {
            this();
        }
    }

    private a ag(View view) {
        a aVar = new a(this, null);
        aVar.cuf = (TextView) view.findViewById(i.f.friend_name_show1);
        aVar.cug = (TextView) view.findViewById(i.f.last_msg_time_show1);
        aVar.cuJ = (TextView) view.findViewById(i.f.one_msg_content_show1);
        aVar.cuK = (TextView) view.findViewById(i.f.unread_msg_count_show1);
        aVar.mLine = view.findViewById(i.f.line);
        return aVar;
    }

    private b ah(View view) {
        b bVar = new b(this, null);
        bVar.cuJ = (TextView) view.findViewById(i.f.msg_content_2);
        return bVar;
    }

    private c ai(View view) {
        c cVar = new c(this, null);
        cVar.cuM = (TextView) view.findViewById(i.f.one_msg_content);
        return cVar;
    }

    private d aj(View view) {
        d dVar = new d(this, null);
        dVar.cuN = (TextView) view.findViewById(i.f.push_msg_name);
        dVar.cuO = (TextView) view.findViewById(i.f.push_msg_title);
        dVar.cug = (TextView) view.findViewById(i.f.push_msg_time);
        dVar.cuM = (TextView) view.findViewById(i.f.push_msg_content);
        dVar.cuQ = (TextView) view.findViewById(i.f.push_msg_go);
        dVar.cuP = (TbImageView) view.findViewById(i.f.push_msg_pic);
        dVar.mLine = view.findViewById(i.f.line);
        return dVar;
    }

    public void eT(boolean z) {
        this.cuH = z;
    }

    public void eU(boolean z) {
        this.cuI = z;
    }
}
