package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> aFH;
    private BaseActivity cNd;
    private b ivd;
    private InterfaceC0306a ive;
    private SimpleDateFormat ivg = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0306a {
        void t(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0306a interfaceC0306a) {
        this.cNd = baseActivity;
        this.ivd = bVar;
        this.ive = interfaceC0306a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aFH = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFH != null) {
            return this.aFH.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFH != null) {
            return this.aFH.get(i);
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
        MuteUser muteUser = this.aFH.get(i);
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

    private c a(Object obj, final MuteUser muteUser, int i) {
        c cVar;
        if (obj == null) {
            cVar = new c();
            cVar.rootView = LayoutInflater.from(this.cNd.getPageContext().getContext()).inflate(d.h.user_mute_list_item, (ViewGroup) null);
            cVar.dBb = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.ivk = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.ivl = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.ivj = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.ivl.setTag(Integer.valueOf(i));
            cVar.ivj.setTag(Integer.valueOf(i));
            cVar.dBb.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.ivl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ivd != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.ivd.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.ivj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ive != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.ive.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.dBb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ive != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.ive.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.ivj.setTag(str);
            cVar.ivj.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.dBb.setText(muteUser.name_show);
        } else {
            cVar.dBb.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.ivk.setText(this.cNd.getResources().getString(d.j.auto_terminate_mute_time, this.ivg.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.ivl.setTag(muteUser.user_id);
        }
        this.cNd.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView dBb;
        HeadImageView ivj;
        TextView ivk;
        TextView ivl;
        View rootView;

        private c() {
        }
    }
}
