package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<MuteUser> Xe;
    private BaseActivity aSJ;
    private b czg;
    private a czh;
    private SimpleDateFormat czj = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void g(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.aSJ = baseActivity;
        this.czg = bVar;
        this.czh = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.Xe = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xe != null) {
            return this.Xe.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xe != null) {
            return this.Xe.get(i);
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
        MuteUser muteUser = this.Xe.get(i);
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
            cVar.rootView = LayoutInflater.from(this.aSJ.getPageContext().getContext()).inflate(i.g.user_mute_list_item, (ViewGroup) null);
            cVar.aII = (TextView) cVar.rootView.findViewById(i.f.item_user_name);
            cVar.czn = (TextView) cVar.rootView.findViewById(i.f.item_mute_terminate_time);
            cVar.czo = (TextView) cVar.rootView.findViewById(i.f.item_remove_button);
            cVar.czm = (HeadImageView) cVar.rootView.findViewById(i.f.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.czo.setTag(Integer.valueOf(i));
            cVar.czm.setTag(Integer.valueOf(i));
            cVar.aII.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.czo.setOnClickListener(new i(this, muteUser));
        cVar.czm.setOnClickListener(new j(this, muteUser));
        cVar.aII.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.czm.setTag(str);
            cVar.czm.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aII.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.czn.setText(this.aSJ.getResources().getString(i.C0057i.auto_terminate_mute_time, this.czj.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.czo.setTag(muteUser.user_id);
        }
        this.aSJ.getLayoutMode().k(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aII;
        HeadImageView czm;
        TextView czn;
        TextView czo;
        View rootView;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
