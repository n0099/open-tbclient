package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private Context mContext;
    private boolean bOm = false;
    private List<t> bOl = new ArrayList();

    public o(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bOl != null) {
            return this.bOl.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bOl.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        t tVar = this.bOl.get(i);
        if (this.bOm) {
            return a(tVar, view, viewGroup, true);
        }
        if (i == 0) {
            return a(tVar, view, viewGroup);
        }
        return b(tVar, view, viewGroup);
    }

    public View a(t tVar, View view, ViewGroup viewGroup, boolean z) {
        p pVar = null;
        if (view != null && (view.getTag() instanceof p)) {
            pVar = (p) view.getTag();
        }
        if (pVar == null) {
            view = com.baidu.adp.lib.g.b.ei().a(this.mContext, x.screenlock_show_item_view_1, viewGroup, false);
            pVar = R(view);
            view.setTag(pVar);
        }
        pVar.bOn.setText(tVar.content);
        pVar.bNL.setText(tVar.groupName);
        pVar.bOo.setText(hz(tVar.bOu));
        pVar.bNM.setText(aj(tVar.IU));
        if (z) {
            pVar.Td.setVisibility(0);
        } else {
            pVar.Td.setVisibility(8);
        }
        return view;
    }

    public View a(t tVar, View view, ViewGroup viewGroup) {
        q qVar = null;
        if (view != null && (view.getTag() instanceof q)) {
            qVar = (q) view.getTag();
        }
        if (qVar == null) {
            view = com.baidu.adp.lib.g.b.ei().a(this.mContext, x.screenlock_show_item_view_2, viewGroup, false);
            qVar = S(view);
            view.setTag(qVar);
        }
        qVar.bOn.setText(tVar.content);
        return view;
    }

    public View b(t tVar, View view, ViewGroup viewGroup) {
        r rVar = null;
        if (view != null && (view.getTag() instanceof r)) {
            rVar = (r) view.getTag();
        }
        if (rVar == null) {
            view = com.baidu.adp.lib.g.b.ei().a(this.mContext, x.screenlock_show_item_view_3, viewGroup, false);
            rVar = T(view);
            view.setTag(rVar);
        }
        rVar.bOq.setText(tVar.content);
        return view;
    }

    public String aj(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String hz(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<t> list) {
        this.bOl = list;
    }

    private p R(View view) {
        p pVar = new p(this, null);
        pVar.bNL = (TextView) view.findViewById(w.friend_name_show1);
        pVar.bNM = (TextView) view.findViewById(w.last_msg_time_show1);
        pVar.bOn = (TextView) view.findViewById(w.one_msg_content_show1);
        pVar.bOo = (TextView) view.findViewById(w.unread_msg_count_show1);
        pVar.Td = view.findViewById(w.line);
        return pVar;
    }

    private q S(View view) {
        q qVar = new q(this, null);
        qVar.bOn = (TextView) view.findViewById(w.msg_content_2);
        return qVar;
    }

    private r T(View view) {
        r rVar = new r(this, null);
        rVar.bOq = (TextView) view.findViewById(w.one_msg_content);
        return rVar;
    }

    public void ep(boolean z) {
        this.bOm = z;
    }
}
