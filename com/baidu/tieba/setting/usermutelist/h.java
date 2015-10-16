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
    private ArrayList<MuteUser> Xh;
    private BaseActivity aSe;
    private b cPe;
    private a cPf;
    private SimpleDateFormat cPh = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void h(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.aSe = baseActivity;
        this.cPe = bVar;
        this.cPf = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.Xh = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xh != null) {
            return this.Xh.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xh != null) {
            return this.Xh.get(i);
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
        MuteUser muteUser = this.Xh.get(i);
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
            cVar.rootView = LayoutInflater.from(this.aSe.getPageContext().getContext()).inflate(i.g.user_mute_list_item, (ViewGroup) null);
            cVar.aHY = (TextView) cVar.rootView.findViewById(i.f.item_user_name);
            cVar.cPl = (TextView) cVar.rootView.findViewById(i.f.item_mute_terminate_time);
            cVar.cPm = (TextView) cVar.rootView.findViewById(i.f.item_remove_button);
            cVar.cPk = (HeadImageView) cVar.rootView.findViewById(i.f.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.cPm.setTag(Integer.valueOf(i));
            cVar.cPk.setTag(Integer.valueOf(i));
            cVar.aHY.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.cPm.setOnClickListener(new i(this, muteUser));
        cVar.cPk.setOnClickListener(new j(this, muteUser));
        cVar.aHY.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.cPk.setTag(str);
            cVar.cPk.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aHY.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.cPl.setText(this.aSe.getResources().getString(i.h.auto_terminate_mute_time, this.cPh.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.cPm.setTag(muteUser.user_id);
        }
        this.aSe.getLayoutMode().k(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aHY;
        HeadImageView cPk;
        TextView cPl;
        TextView cPm;
        View rootView;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
