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
    private ArrayList<MuteUser> YX;
    private BaseActivity bdK;
    private b dMn;
    private a dMo;
    private SimpleDateFormat dMq = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void k(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void j(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.bdK = baseActivity;
        this.dMn = bVar;
        this.dMo = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.YX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YX != null) {
            return this.YX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YX != null) {
            return this.YX.get(i);
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
        MuteUser muteUser = this.YX.get(i);
        if (muteUser != null) {
            cVar = a(view != null ? view.getTag() : null, muteUser, i);
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return cVar.azA;
        }
        return null;
    }

    private c a(Object obj, MuteUser muteUser, int i) {
        c cVar;
        if (obj == null) {
            cVar = new c(this, null);
            cVar.azA = LayoutInflater.from(this.bdK.getPageContext().getContext()).inflate(t.h.user_mute_list_item, (ViewGroup) null);
            cVar.aMu = (TextView) cVar.azA.findViewById(t.g.item_user_name);
            cVar.dMu = (TextView) cVar.azA.findViewById(t.g.item_mute_terminate_time);
            cVar.dMv = (TextView) cVar.azA.findViewById(t.g.item_remove_button);
            cVar.dMt = (HeadImageView) cVar.azA.findViewById(t.g.item_header_view);
            cVar.azA.setTag(cVar);
            cVar.dMv.setTag(Integer.valueOf(i));
            cVar.dMt.setTag(Integer.valueOf(i));
            cVar.aMu.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.dMv.setOnClickListener(new i(this, muteUser));
        cVar.dMt.setOnClickListener(new j(this, muteUser));
        cVar.aMu.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.dMt.setTag(str);
            cVar.dMt.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aMu.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.dMu.setText(this.bdK.getResources().getString(t.j.auto_terminate_mute_time, this.dMq.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.dMv.setTag(muteUser.user_id);
        }
        this.bdK.getLayoutMode().x(cVar.azA);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aMu;
        View azA;
        HeadImageView dMt;
        TextView dMu;
        TextView dMv;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
