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
    private ArrayList<MuteUser> XX;
    private BaseActivity aXA;
    private b doW;
    private a doX;
    private SimpleDateFormat doZ = new SimpleDateFormat("yyyy.MM.dd");

    /* loaded from: classes.dex */
    public interface a {
        void k(long j, String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void j(long j, String str);
    }

    public h(BaseActivity baseActivity, b bVar, a aVar) {
        this.aXA = baseActivity;
        this.doW = bVar;
        this.doX = aVar;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.XX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XX != null) {
            return this.XX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.XX != null) {
            return this.XX.get(i);
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
        MuteUser muteUser = this.XX.get(i);
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
            cVar.rootView = LayoutInflater.from(this.aXA.getPageContext().getContext()).inflate(n.g.user_mute_list_item, (ViewGroup) null);
            cVar.aJR = (TextView) cVar.rootView.findViewById(n.f.item_user_name);
            cVar.dpd = (TextView) cVar.rootView.findViewById(n.f.item_mute_terminate_time);
            cVar.dpe = (TextView) cVar.rootView.findViewById(n.f.item_remove_button);
            cVar.dpc = (HeadImageView) cVar.rootView.findViewById(n.f.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.dpe.setTag(Integer.valueOf(i));
            cVar.dpc.setTag(Integer.valueOf(i));
            cVar.aJR.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.dpe.setOnClickListener(new i(this, muteUser));
        cVar.dpc.setOnClickListener(new j(this, muteUser));
        cVar.aJR.setOnClickListener(new k(this, muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            cVar.dpc.setTag(str);
            cVar.dpc.d(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.aJR.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.dpd.setText(this.aXA.getResources().getString(n.i.auto_terminate_mute_time, this.doZ.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.dpe.setTag(muteUser.user_id);
        }
        this.aXA.getLayoutMode().k(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView aJR;
        HeadImageView dpc;
        TextView dpd;
        TextView dpe;
        View rootView;

        private c() {
        }

        /* synthetic */ c(h hVar, c cVar) {
            this();
        }
    }
}
