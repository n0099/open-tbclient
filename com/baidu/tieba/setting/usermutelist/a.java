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
    private ArrayList<MuteUser> aFI;
    private BaseActivity cNa;
    private b iuX;
    private InterfaceC0382a iuY;
    private SimpleDateFormat iva = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0382a {
        void t(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0382a interfaceC0382a) {
        this.cNa = baseActivity;
        this.iuX = bVar;
        this.iuY = interfaceC0382a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aFI = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFI != null) {
            return this.aFI.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFI != null) {
            return this.aFI.get(i);
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
        MuteUser muteUser = this.aFI.get(i);
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
            cVar.rootView = LayoutInflater.from(this.cNa.getPageContext().getContext()).inflate(d.h.user_mute_list_item, (ViewGroup) null);
            cVar.dAX = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.ive = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.ivf = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.ivd = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.ivf.setTag(Integer.valueOf(i));
            cVar.ivd.setTag(Integer.valueOf(i));
            cVar.dAX.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.ivf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iuX != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iuX.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.ivd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iuY != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iuY.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.dAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iuY != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iuY.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.ivd.setTag(str);
            cVar.ivd.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.dAX.setText(muteUser.name_show);
        } else {
            cVar.dAX.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.ive.setText(this.cNa.getResources().getString(d.j.auto_terminate_mute_time, this.iva.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.ivf.setTag(muteUser.user_id);
        }
        this.cNa.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView dAX;
        HeadImageView ivd;
        TextView ive;
        TextView ivf;
        View rootView;

        private c() {
        }
    }
}
