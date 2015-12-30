package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<MuteUser> YA;
    private BaseActivity bbA;
    private b dwj;
    private a dwk;
    private SimpleDateFormat dwm = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void k(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void j(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.bbA = baseActivity;
        this.dwj = bVar;
        this.dwk = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.YA = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YA != null) {
            return this.YA.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YA != null) {
            return this.YA.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        MuteUser muteUser = this.YA.get(i);
        if (muteUser != null) {
            cVar = a(view != null ? view.getTag() : null, muteUser, i);
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return cVar.rootView;
        }
        return null;
    }

    private c a(Object obj, MuteUser muteUser, int i) {
        c cVar;
        if (obj == null) {
            cVar = new c(this, null);
            cVar.rootView = LayoutInflater.from(this.bbA.getPageContext().getContext()).inflate(n.h.user_mute_list_item, (ViewGroup) null);
            cVar.aLp = (TextView) cVar.rootView.findViewById(n.g.item_user_name);
            cVar.dwq = (TextView) cVar.rootView.findViewById(n.g.item_mute_terminate_time);
            cVar.dwr = (TextView) cVar.rootView.findViewById(n.g.item_remove_button);
            cVar.dwp = (HeadImageView) cVar.rootView.findViewById(n.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.dwr.setTag(Integer.valueOf(i));
            cVar.dwp.setTag(Integer.valueOf(i));
            cVar.aLp.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.dwr.setOnClickListener(new i(this, muteUser));
        cVar.dwp.setOnClickListener(new j(this, muteUser));
        cVar.aLp.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.dwp.setTag(str);
            cVar.dwp.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aLp.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.dwq.setText(this.bbA.getResources().getString(n.j.auto_terminate_mute_time, this.dwm.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.dwr.setTag(muteUser.user_id);
        }
        this.bbA.getLayoutMode().k(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aLp;
        HeadImageView dwp;
        TextView dwq;
        TextView dwr;
        View rootView;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
