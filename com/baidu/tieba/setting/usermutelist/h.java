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
    private ArrayList<MuteUser> Xk;
    private BaseActivity aSm;
    private b cQA;
    private a cQB;
    private SimpleDateFormat cQD = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void h(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.aSm = baseActivity;
        this.cQA = bVar;
        this.cQB = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.Xk = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xk != null) {
            return this.Xk.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xk != null) {
            return this.Xk.get(i);
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
        MuteUser muteUser = this.Xk.get(i);
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
            cVar.rootView = LayoutInflater.from(this.aSm.getPageContext().getContext()).inflate(i.g.user_mute_list_item, (ViewGroup) null);
            cVar.aGS = (TextView) cVar.rootView.findViewById(i.f.item_user_name);
            cVar.cQH = (TextView) cVar.rootView.findViewById(i.f.item_mute_terminate_time);
            cVar.cQI = (TextView) cVar.rootView.findViewById(i.f.item_remove_button);
            cVar.cQG = (HeadImageView) cVar.rootView.findViewById(i.f.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.cQI.setTag(Integer.valueOf(i));
            cVar.cQG.setTag(Integer.valueOf(i));
            cVar.aGS.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.cQI.setOnClickListener(new i(this, muteUser));
        cVar.cQG.setOnClickListener(new j(this, muteUser));
        cVar.aGS.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.cQG.setTag(str);
            cVar.cQG.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aGS.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.cQH.setText(this.aSm.getResources().getString(i.h.auto_terminate_mute_time, this.cQD.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.cQI.setTag(muteUser.user_id);
        }
        this.aSm.getLayoutMode().k(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aGS;
        HeadImageView cQG;
        TextView cQH;
        TextView cQI;
        View rootView;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
