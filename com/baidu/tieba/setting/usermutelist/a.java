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
    private BaseActivity bcJ;
    private b gkd;
    private InterfaceC0212a gke;
    private SimpleDateFormat gkg = new SimpleDateFormat("yyyy.MM.dd");

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
        this.bcJ = baseActivity;
        this.gkd = bVar;
        this.gke = interfaceC0212a;
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
            cVar.rootView = LayoutInflater.from(this.bcJ.getPageContext().getContext()).inflate(d.i.user_mute_list_item, (ViewGroup) null);
            cVar.bGo = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.gkk = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.gkl = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.gkj = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gkl.setTag(Integer.valueOf(i));
            cVar.gkj.setTag(Integer.valueOf(i));
            cVar.bGo.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gkl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gkd != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gkd.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gkj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gke != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gke.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.bGo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gke != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gke.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gkj.setTag(str);
            cVar.gkj.startLoad(str, 12, false);
        }
        if (muteUser.user_name != null) {
            cVar.bGo.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gkk.setText(this.bcJ.getResources().getString(d.k.auto_terminate_mute_time, this.gkg.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gkl.setTag(muteUser.user_id);
        }
        this.bcJ.getLayoutMode().u(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView bGo;
        HeadImageView gkj;
        TextView gkk;
        TextView gkl;
        View rootView;

        private c() {
        }
    }
}
