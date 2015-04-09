package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private Context mContext;
    private boolean bYX = false;
    private List<r> bYW = new ArrayList();

    public m(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bYW != null) {
            return this.bYW.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bYW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        r rVar = this.bYW.get(i);
        if (this.bYX) {
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
            view = com.baidu.adp.lib.g.b.hH().a(this.mContext, w.screenlock_show_item_view_1, viewGroup, false);
            nVar = T(view);
            view.setTag(nVar);
        }
        nVar.bYY.setText(rVar.content);
        nVar.bYv.setText(rVar.groupName);
        nVar.bYZ.setText(hR(rVar.bZf));
        nVar.bYw.setText(am(rVar.Uy));
        if (z) {
            nVar.adg.setVisibility(0);
        } else {
            nVar.adg.setVisibility(8);
        }
        return view;
    }

    public View a(r rVar, View view, ViewGroup viewGroup) {
        o oVar = null;
        if (view != null && (view.getTag() instanceof o)) {
            oVar = (o) view.getTag();
        }
        if (oVar == null) {
            view = com.baidu.adp.lib.g.b.hH().a(this.mContext, w.screenlock_show_item_view_2, viewGroup, false);
            oVar = U(view);
            view.setTag(oVar);
        }
        oVar.bYY.setText(rVar.content);
        return view;
    }

    public View b(r rVar, View view, ViewGroup viewGroup) {
        p pVar = null;
        if (view != null && (view.getTag() instanceof p)) {
            pVar = (p) view.getTag();
        }
        if (pVar == null) {
            view = com.baidu.adp.lib.g.b.hH().a(this.mContext, w.screenlock_show_item_view_3, viewGroup, false);
            pVar = V(view);
            view.setTag(pVar);
        }
        pVar.bZb.setText(rVar.content);
        return view;
    }

    public String am(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String hR(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public void setData(List<r> list) {
        this.bYW = list;
    }

    private n T(View view) {
        n nVar = new n(this, null);
        nVar.bYv = (TextView) view.findViewById(v.friend_name_show1);
        nVar.bYw = (TextView) view.findViewById(v.last_msg_time_show1);
        nVar.bYY = (TextView) view.findViewById(v.one_msg_content_show1);
        nVar.bYZ = (TextView) view.findViewById(v.unread_msg_count_show1);
        nVar.adg = view.findViewById(v.line);
        return nVar;
    }

    private o U(View view) {
        o oVar = new o(this, null);
        oVar.bYY = (TextView) view.findViewById(v.msg_content_2);
        return oVar;
    }

    private p V(View view) {
        p pVar = new p(this, null);
        pVar.bZb = (TextView) view.findViewById(v.one_msg_content);
        return pVar;
    }

    public void em(boolean z) {
        this.bYX = z;
    }
}
