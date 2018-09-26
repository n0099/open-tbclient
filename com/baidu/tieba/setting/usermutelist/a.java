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
    private ArrayList<MuteUser> anX;
    private BaseActivity bsQ;
    private b gJp;
    private InterfaceC0237a gJq;
    private SimpleDateFormat gJs = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0237a {
        void t(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0237a interfaceC0237a) {
        this.bsQ = baseActivity;
        this.gJp = bVar;
        this.gJq = interfaceC0237a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.anX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anX != null) {
            return this.anX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX != null) {
            return this.anX.get(i);
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
        MuteUser muteUser = this.anX.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bsQ.getPageContext().getContext()).inflate(e.h.user_mute_list_item, (ViewGroup) null);
            cVar.bYF = (TextView) cVar.rootView.findViewById(e.g.item_user_name);
            cVar.gJw = (TextView) cVar.rootView.findViewById(e.g.item_mute_terminate_time);
            cVar.gJx = (TextView) cVar.rootView.findViewById(e.g.item_remove_button);
            cVar.gJv = (HeadImageView) cVar.rootView.findViewById(e.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gJx.setTag(Integer.valueOf(i));
            cVar.gJv.setTag(Integer.valueOf(i));
            cVar.bYF.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gJx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gJp != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gJp.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gJv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gJq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gJq.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.bYF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gJq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gJq.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gJv.setTag(str);
            cVar.gJv.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.bYF.setText(muteUser.name_show);
        } else {
            cVar.bYF.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gJw.setText(this.bsQ.getResources().getString(e.j.auto_terminate_mute_time, this.gJs.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gJx.setTag(muteUser.user_id);
        }
        this.bsQ.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView bYF;
        HeadImageView gJv;
        TextView gJw;
        TextView gJx;
        View rootView;

        private c() {
        }
    }
}
