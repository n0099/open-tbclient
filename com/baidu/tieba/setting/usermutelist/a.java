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
    private ArrayList<MuteUser> aFL;
    private BaseActivity cNc;
    private b iuH;
    private InterfaceC0382a iuI;
    private SimpleDateFormat iuK = new SimpleDateFormat("yyyy.MM.dd");

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
        this.cNc = baseActivity;
        this.iuH = bVar;
        this.iuI = interfaceC0382a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aFL = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFL != null) {
            return this.aFL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFL != null) {
            return this.aFL.get(i);
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
        MuteUser muteUser = this.aFL.get(i);
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
            cVar.rootView = LayoutInflater.from(this.cNc.getPageContext().getContext()).inflate(d.h.user_mute_list_item, (ViewGroup) null);
            cVar.eeA = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.iuO = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.iuP = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.iuN = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.iuP.setTag(Integer.valueOf(i));
            cVar.iuN.setTag(Integer.valueOf(i));
            cVar.eeA.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.iuP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iuH != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iuH.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.iuN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iuI != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iuI.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.eeA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iuI != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iuI.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.iuN.setTag(str);
            cVar.iuN.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.eeA.setText(muteUser.name_show);
        } else {
            cVar.eeA.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.iuO.setText(this.cNc.getResources().getString(d.j.auto_terminate_mute_time, this.iuK.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.iuP.setTag(muteUser.user_id);
        }
        this.cNc.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView eeA;
        HeadImageView iuN;
        TextView iuO;
        TextView iuP;
        View rootView;

        private c() {
        }
    }
}
