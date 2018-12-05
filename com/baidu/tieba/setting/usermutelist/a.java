package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private BaseActivity bBf;
    private b gZc;
    private InterfaceC0311a gZd;
    private SimpleDateFormat gZf = new SimpleDateFormat("yyyy.MM.dd");
    private ArrayList<MuteUser> mData;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0311a {
        void t(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0311a interfaceC0311a) {
        this.bBf = baseActivity;
        this.gZc = bVar;
        this.gZd = interfaceC0311a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.mData = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
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
        MuteUser muteUser = this.mData.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bBf.getPageContext().getContext()).inflate(e.h.user_mute_list_item, (ViewGroup) null);
            cVar.clh = (TextView) cVar.rootView.findViewById(e.g.item_user_name);
            cVar.gZj = (TextView) cVar.rootView.findViewById(e.g.item_mute_terminate_time);
            cVar.gZk = (TextView) cVar.rootView.findViewById(e.g.item_remove_button);
            cVar.gZi = (HeadImageView) cVar.rootView.findViewById(e.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gZk.setTag(Integer.valueOf(i));
            cVar.gZi.setTag(Integer.valueOf(i));
            cVar.clh.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gZk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gZc != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gZc.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gZd != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gZd.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.clh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gZd != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gZd.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gZi.setTag(str);
            cVar.gZi.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.clh.setText(muteUser.name_show);
        } else {
            cVar.clh.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gZj.setText(this.bBf.getResources().getString(e.j.auto_terminate_mute_time, this.gZf.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gZk.setTag(muteUser.user_id);
        }
        this.bBf.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView clh;
        HeadImageView gZi;
        TextView gZj;
        TextView gZk;
        View rootView;

        private c() {
        }
    }
}
