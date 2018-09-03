package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> als;
    private BaseActivity bnc;
    private b gBL;
    private InterfaceC0231a gBM;
    private SimpleDateFormat gBO = new SimpleDateFormat("yyyy.MM.dd");

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
        this.bnc = baseActivity;
        this.gBL = bVar;
        this.gBM = interfaceC0231a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.als = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.als != null) {
            return this.als.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.als != null) {
            return this.als.get(i);
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
        MuteUser muteUser = this.als.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bnc.getPageContext().getContext()).inflate(f.h.user_mute_list_item, (ViewGroup) null);
            cVar.bSQ = (TextView) cVar.rootView.findViewById(f.g.item_user_name);
            cVar.gBS = (TextView) cVar.rootView.findViewById(f.g.item_mute_terminate_time);
            cVar.gBT = (TextView) cVar.rootView.findViewById(f.g.item_remove_button);
            cVar.gBR = (HeadImageView) cVar.rootView.findViewById(f.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gBT.setTag(Integer.valueOf(i));
            cVar.gBR.setTag(Integer.valueOf(i));
            cVar.bSQ.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gBL != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gBL.p(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gBM != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gBM.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.bSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gBM != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gBM.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gBR.setTag(str);
            cVar.gBR.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.bSQ.setText(muteUser.name_show);
        } else {
            cVar.bSQ.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gBS.setText(this.bnc.getResources().getString(f.j.auto_terminate_mute_time, this.gBO.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gBT.setTag(muteUser.user_id);
        }
        this.bnc.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView bSQ;
        HeadImageView gBR;
        TextView gBS;
        TextView gBT;
        View rootView;

        private c() {
        }
    }
}
