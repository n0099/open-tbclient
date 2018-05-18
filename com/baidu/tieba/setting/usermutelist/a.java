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
    private ArrayList<MuteUser> adv;
    private BaseActivity bcK;
    private b glj;
    private InterfaceC0212a glk;
    private SimpleDateFormat glm = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0212a {
        void r(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void q(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0212a interfaceC0212a) {
        this.bcK = baseActivity;
        this.glj = bVar;
        this.glk = interfaceC0212a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.adv = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.adv != null) {
            return this.adv.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.adv != null) {
            return this.adv.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        c cVar;
        MuteUser muteUser = this.adv.get(i);
        if (muteUser != null) {
            cVar = a(view2 != null ? view2.getTag() : null, muteUser, i);
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
            cVar.rootView = LayoutInflater.from(this.bcK.getPageContext().getContext()).inflate(d.i.user_mute_list_item, (ViewGroup) null);
            cVar.bHL = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.glq = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.glr = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.glp = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.glr.setTag(Integer.valueOf(i));
            cVar.glp.setTag(Integer.valueOf(i));
            cVar.bHL.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.glr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.glj != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.glj.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.glp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.glk != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.glk.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.bHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.glk != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.glk.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.glp.setTag(str);
            cVar.glp.startLoad(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.bHL.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.glq.setText(this.bcK.getResources().getString(d.k.auto_terminate_mute_time, this.glm.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.glr.setTag(muteUser.user_id);
        }
        this.bcK.getLayoutMode().u(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView bHL;
        HeadImageView glp;
        TextView glq;
        TextView glr;
        View rootView;

        private c() {
        }
    }
}
