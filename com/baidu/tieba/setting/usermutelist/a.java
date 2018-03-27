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
    private ArrayList<MuteUser> aRZ;
    private BaseActivity bSF;
    private b gPa;
    private InterfaceC0231a gPb;
    private SimpleDateFormat gPd = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0231a {
        void q(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void p(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0231a interfaceC0231a) {
        this.bSF = baseActivity;
        this.gPa = bVar;
        this.gPb = interfaceC0231a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aRZ = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRZ != null) {
            return this.aRZ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRZ != null) {
            return this.aRZ.get(i);
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
        MuteUser muteUser = this.aRZ.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bSF.getPageContext().getContext()).inflate(d.h.user_mute_list_item, (ViewGroup) null);
            cVar.cql = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.gPh = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.gPi = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.gPg = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gPi.setTag(Integer.valueOf(i));
            cVar.gPg.setTag(Integer.valueOf(i));
            cVar.cql.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gPa != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gPa.p(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gPb != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gPb.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.cql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gPb != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gPb.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gPg.setTag(str);
            cVar.gPg.startLoad(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.cql.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gPh.setText(this.bSF.getResources().getString(d.j.auto_terminate_mute_time, this.gPd.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gPi.setTag(muteUser.user_id);
        }
        this.bSF.getLayoutMode().aM(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView cql;
        HeadImageView gPg;
        TextView gPh;
        TextView gPi;
        View rootView;

        private c() {
        }
    }
}
