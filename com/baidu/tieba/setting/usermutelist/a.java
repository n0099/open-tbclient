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
    private ArrayList<MuteUser> aSi;
    private BaseActivity bSO;
    private b gOZ;
    private InterfaceC0230a gPa;
    private SimpleDateFormat gPc = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0230a {
        void q(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void p(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0230a interfaceC0230a) {
        this.bSO = baseActivity;
        this.gOZ = bVar;
        this.gPa = interfaceC0230a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aSi = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aSi != null) {
            return this.aSi.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aSi != null) {
            return this.aSi.get(i);
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
        MuteUser muteUser = this.aSi.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bSO.getPageContext().getContext()).inflate(d.h.user_mute_list_item, (ViewGroup) null);
            cVar.cqu = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.gPg = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.gPh = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.gPf = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gPh.setTag(Integer.valueOf(i));
            cVar.gPf.setTag(Integer.valueOf(i));
            cVar.cqu.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gPh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gOZ != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gOZ.p(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gPa != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gPa.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.cqu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gPa != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gPa.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gPf.setTag(str);
            cVar.gPf.startLoad(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.cqu.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gPg.setText(this.bSO.getResources().getString(d.j.auto_terminate_mute_time, this.gPc.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gPh.setTag(muteUser.user_id);
        }
        this.bSO.getLayoutMode().aM(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView cqu;
        HeadImageView gPf;
        TextView gPg;
        TextView gPh;
        View rootView;

        private c() {
        }
    }
}
