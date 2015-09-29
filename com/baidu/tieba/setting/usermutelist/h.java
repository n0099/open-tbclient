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
    private ArrayList<MuteUser> Xf;
    private BaseActivity aRT;
    private b cOF;
    private a cOG;
    private SimpleDateFormat cOI = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void h(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.aRT = baseActivity;
        this.cOF = bVar;
        this.cOG = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.Xf = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xf != null) {
            return this.Xf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xf != null) {
            return this.Xf.get(i);
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
        MuteUser muteUser = this.Xf.get(i);
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
            cVar.rootView = LayoutInflater.from(this.aRT.getPageContext().getContext()).inflate(i.g.user_mute_list_item, (ViewGroup) null);
            cVar.aHN = (TextView) cVar.rootView.findViewById(i.f.item_user_name);
            cVar.cOM = (TextView) cVar.rootView.findViewById(i.f.item_mute_terminate_time);
            cVar.cON = (TextView) cVar.rootView.findViewById(i.f.item_remove_button);
            cVar.cOL = (HeadImageView) cVar.rootView.findViewById(i.f.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.cON.setTag(Integer.valueOf(i));
            cVar.cOL.setTag(Integer.valueOf(i));
            cVar.aHN.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.cON.setOnClickListener(new i(this, muteUser));
        cVar.cOL.setOnClickListener(new j(this, muteUser));
        cVar.aHN.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.cOL.setTag(str);
            cVar.cOL.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aHN.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.cOM.setText(this.aRT.getResources().getString(i.h.auto_terminate_mute_time, this.cOI.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.cON.setTag(muteUser.user_id);
        }
        this.aRT.getLayoutMode().k(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aHN;
        HeadImageView cOL;
        TextView cOM;
        TextView cON;
        View rootView;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
