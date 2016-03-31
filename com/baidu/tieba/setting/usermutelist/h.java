package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<MuteUser> Xq;
    private BaseActivity bix;
    private b eeN;
    private a eeO;
    private SimpleDateFormat eeQ = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void t(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void s(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.bix = baseActivity;
        this.eeN = bVar;
        this.eeO = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.Xq = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xq != null) {
            return this.Xq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xq != null) {
            return this.Xq.get(i);
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
        MuteUser muteUser = this.Xq.get(i);
        if (muteUser != null) {
            cVar = a(view != null ? view.getTag() : null, muteUser, i);
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return cVar.aAh;
        }
        return null;
    }

    private c a(Object obj, MuteUser muteUser, int i) {
        c cVar;
        if (obj == null) {
            cVar = new c(this, null);
            cVar.aAh = LayoutInflater.from(this.bix.getPageContext().getContext()).inflate(t.h.user_mute_list_item, (ViewGroup) null);
            cVar.aPp = (TextView) cVar.aAh.findViewById(t.g.item_user_name);
            cVar.eeU = (TextView) cVar.aAh.findViewById(t.g.item_mute_terminate_time);
            cVar.eeV = (TextView) cVar.aAh.findViewById(t.g.item_remove_button);
            cVar.eeT = (HeadImageView) cVar.aAh.findViewById(t.g.item_header_view);
            cVar.aAh.setTag(cVar);
            cVar.eeV.setTag(Integer.valueOf(i));
            cVar.eeT.setTag(Integer.valueOf(i));
            cVar.aPp.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.eeV.setOnClickListener(new i(this, muteUser));
        cVar.eeT.setOnClickListener(new j(this, muteUser));
        cVar.aPp.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.eeT.setTag(str);
            cVar.eeT.c(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aPp.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.eeU.setText(this.bix.getResources().getString(t.j.auto_terminate_mute_time, this.eeQ.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.eeV.setTag(muteUser.user_id);
        }
        this.bix.getLayoutMode().x(cVar.aAh);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        View aAh;
        TextView aPp;
        HeadImageView eeT;
        TextView eeU;
        TextView eeV;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
