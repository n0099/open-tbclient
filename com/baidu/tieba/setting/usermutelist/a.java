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
    private ArrayList<MuteUser> alt;
    private BaseActivity bkU;
    private b gwH;
    private InterfaceC0229a gwI;
    private SimpleDateFormat gwK = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0229a {
        void r(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void q(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0229a interfaceC0229a) {
        this.bkU = baseActivity;
        this.gwH = bVar;
        this.gwI = interfaceC0229a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.alt = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alt != null) {
            return this.alt.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alt != null) {
            return this.alt.get(i);
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
        MuteUser muteUser = this.alt.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bkU.getPageContext().getContext()).inflate(d.i.user_mute_list_item, (ViewGroup) null);
            cVar.bPN = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.gwO = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.gwP = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.gwN = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gwP.setTag(Integer.valueOf(i));
            cVar.gwN.setTag(Integer.valueOf(i));
            cVar.bPN.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gwP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gwH != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gwH.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gwI != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gwI.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.bPN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gwI != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gwI.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gwN.setTag(str);
            cVar.gwN.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.bPN.setText(muteUser.name_show);
        } else {
            cVar.bPN.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gwO.setText(this.bkU.getResources().getString(d.k.auto_terminate_mute_time, this.gwK.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gwP.setTag(muteUser.user_id);
        }
        this.bkU.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView bPN;
        HeadImageView gwN;
        TextView gwO;
        TextView gwP;
        View rootView;

        private c() {
        }
    }
}
