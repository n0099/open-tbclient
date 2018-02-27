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
    private ArrayList<MuteUser> aRX;
    private BaseActivity bSC;
    private b gOK;
    private InterfaceC0231a gOL;
    private SimpleDateFormat gON = new SimpleDateFormat("yyyy.MM.dd");

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
        this.bSC = baseActivity;
        this.gOK = bVar;
        this.gOL = interfaceC0231a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aRX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRX != null) {
            return this.aRX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRX != null) {
            return this.aRX.get(i);
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
        MuteUser muteUser = this.aRX.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bSC.getPageContext().getContext()).inflate(d.h.user_mute_list_item, (ViewGroup) null);
            cVar.cqi = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.gOR = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.gOS = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.gOQ = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gOS.setTag(Integer.valueOf(i));
            cVar.gOQ.setTag(Integer.valueOf(i));
            cVar.cqi.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gOK != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gOK.p(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gOL != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gOL.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.cqi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gOL != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gOL.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gOQ.setTag(str);
            cVar.gOQ.startLoad(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.cqi.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gOR.setText(this.bSC.getResources().getString(d.j.auto_terminate_mute_time, this.gON.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gOS.setTag(muteUser.user_id);
        }
        this.bSC.getLayoutMode().aM(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView cqi;
        HeadImageView gOQ;
        TextView gOR;
        TextView gOS;
        View rootView;

        private c() {
        }
    }
}
