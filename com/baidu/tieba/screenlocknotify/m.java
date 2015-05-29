package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private Context mContext;
    private boolean cdi = false;
    private List<r> cdh = new ArrayList();

    public m(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cdh != null) {
            return this.cdh.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cdh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        r rVar = this.cdh.get(i);
        if (this.cdi) {
            return a(rVar, view, viewGroup, true);
        }
        if (i == 0) {
            return a(rVar, view, viewGroup);
        }
        return b(rVar, view, viewGroup);
    }

    public View a(r rVar, View view, ViewGroup viewGroup, boolean z) {
        n nVar = null;
        if (view != null && (view.getTag() instanceof n)) {
            nVar = (n) view.getTag();
        }
        if (nVar == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.screenlock_show_item_view_1, viewGroup, false);
            nVar = U(view);
            view.setTag(nVar);
        }
        nVar.cdj.setText(rVar.content);
        nVar.ccH.setText(rVar.groupName);
        nVar.cdk.setText(ip(rVar.cdq));
        nVar.ccI.setText(an(rVar.cds));
        if (z) {
            nVar.mLine.setVisibility(0);
        } else {
            nVar.mLine.setVisibility(8);
        }
        return view;
    }

    public View a(r rVar, View view, ViewGroup viewGroup) {
        o oVar = null;
        if (view != null && (view.getTag() instanceof o)) {
            oVar = (o) view.getTag();
        }
        if (oVar == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.screenlock_show_item_view_2, viewGroup, false);
            oVar = V(view);
            view.setTag(oVar);
        }
        oVar.cdj.setText(rVar.content);
        return view;
    }

    public View b(r rVar, View view, ViewGroup viewGroup) {
        p pVar = null;
        if (view != null && (view.getTag() instanceof p)) {
            pVar = (p) view.getTag();
        }
        if (pVar == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.screenlock_show_item_view_3, viewGroup, false);
            pVar = W(view);
            view.setTag(pVar);
        }
        pVar.cdm.setText(rVar.content);
        return view;
    }

    public String an(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String ip(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<r> list) {
        this.cdh = list;
    }

    private n U(View view) {
        n nVar = new n(this, null);
        nVar.ccH = (TextView) view.findViewById(com.baidu.tieba.q.friend_name_show1);
        nVar.ccI = (TextView) view.findViewById(com.baidu.tieba.q.last_msg_time_show1);
        nVar.cdj = (TextView) view.findViewById(com.baidu.tieba.q.one_msg_content_show1);
        nVar.cdk = (TextView) view.findViewById(com.baidu.tieba.q.unread_msg_count_show1);
        nVar.mLine = view.findViewById(com.baidu.tieba.q.line);
        return nVar;
    }

    private o V(View view) {
        o oVar = new o(this, null);
        oVar.cdj = (TextView) view.findViewById(com.baidu.tieba.q.msg_content_2);
        return oVar;
    }

    private p W(View view) {
        p pVar = new p(this, null);
        pVar.cdm = (TextView) view.findViewById(com.baidu.tieba.q.one_msg_content);
        return pVar;
    }

    public void eC(boolean z) {
        this.cdi = z;
    }
}
