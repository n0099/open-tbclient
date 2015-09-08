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
    private ArrayList<MuteUser> Xn;
    private BaseActivity aSX;
    private b cHE;
    private a cHF;
    private SimpleDateFormat cHH = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void g(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.aSX = baseActivity;
        this.cHE = bVar;
        this.cHF = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.Xn = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xn != null) {
            return this.Xn.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xn != null) {
            return this.Xn.get(i);
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
        MuteUser muteUser = this.Xn.get(i);
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
            cVar.rootView = LayoutInflater.from(this.aSX.getPageContext().getContext()).inflate(i.g.user_mute_list_item, (ViewGroup) null);
            cVar.aIV = (TextView) cVar.rootView.findViewById(i.f.item_user_name);
            cVar.cHL = (TextView) cVar.rootView.findViewById(i.f.item_mute_terminate_time);
            cVar.cHM = (TextView) cVar.rootView.findViewById(i.f.item_remove_button);
            cVar.cHK = (HeadImageView) cVar.rootView.findViewById(i.f.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.cHM.setTag(Integer.valueOf(i));
            cVar.cHK.setTag(Integer.valueOf(i));
            cVar.aIV.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.cHM.setOnClickListener(new i(this, muteUser));
        cVar.cHK.setOnClickListener(new j(this, muteUser));
        cVar.aIV.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.cHK.setTag(str);
            cVar.cHK.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aIV.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.cHL.setText(this.aSX.getResources().getString(i.h.auto_terminate_mute_time, this.cHH.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.cHM.setTag(muteUser.user_id);
        }
        this.aSX.getLayoutMode().k(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aIV;
        HeadImageView cHK;
        TextView cHL;
        TextView cHM;
        View rootView;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
