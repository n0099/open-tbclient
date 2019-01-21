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
    private BaseActivity bBW;
    private b hdm;
    private InterfaceC0311a hdn;
    private SimpleDateFormat hdp = new SimpleDateFormat("yyyy.MM.dd");
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
        this.bBW = baseActivity;
        this.hdm = bVar;
        this.hdn = interfaceC0311a;
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
            cVar.rootView = LayoutInflater.from(this.bBW.getPageContext().getContext()).inflate(e.h.user_mute_list_item, (ViewGroup) null);
            cVar.cma = (TextView) cVar.rootView.findViewById(e.g.item_user_name);
            cVar.hdt = (TextView) cVar.rootView.findViewById(e.g.item_mute_terminate_time);
            cVar.hdu = (TextView) cVar.rootView.findViewById(e.g.item_remove_button);
            cVar.hds = (HeadImageView) cVar.rootView.findViewById(e.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.hdu.setTag(Integer.valueOf(i));
            cVar.hds.setTag(Integer.valueOf(i));
            cVar.cma.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.hdu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hdm != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.hdm.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hds.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hdn != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.hdn.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.cma.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hdn != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.hdn.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.hds.setTag(str);
            cVar.hds.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.cma.setText(muteUser.name_show);
        } else {
            cVar.cma.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.hdt.setText(this.bBW.getResources().getString(e.j.auto_terminate_mute_time, this.hdp.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.hdu.setTag(muteUser.user_id);
        }
        this.bBW.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView cma;
        HeadImageView hds;
        TextView hdt;
        TextView hdu;
        View rootView;

        private c() {
        }
    }
}
