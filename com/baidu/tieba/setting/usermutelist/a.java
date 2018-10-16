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
    private BaseActivity bwX;
    private b gQN;
    private InterfaceC0272a gQO;
    private SimpleDateFormat gQQ = new SimpleDateFormat("yyyy.MM.dd");
    private ArrayList<MuteUser> mData;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0272a {
        void t(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0272a interfaceC0272a) {
        this.bwX = baseActivity;
        this.gQN = bVar;
        this.gQO = interfaceC0272a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.mData = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
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
        MuteUser muteUser = this.mData.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bwX.getPageContext().getContext()).inflate(e.h.user_mute_list_item, (ViewGroup) null);
            cVar.chf = (TextView) cVar.rootView.findViewById(e.g.item_user_name);
            cVar.gQU = (TextView) cVar.rootView.findViewById(e.g.item_mute_terminate_time);
            cVar.gQV = (TextView) cVar.rootView.findViewById(e.g.item_remove_button);
            cVar.gQT = (HeadImageView) cVar.rootView.findViewById(e.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gQV.setTag(Integer.valueOf(i));
            cVar.gQT.setTag(Integer.valueOf(i));
            cVar.chf.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gQV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gQN != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gQN.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gQT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gQO != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gQO.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.chf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gQO != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gQO.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gQT.setTag(str);
            cVar.gQT.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.chf.setText(muteUser.name_show);
        } else {
            cVar.chf.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gQU.setText(this.bwX.getResources().getString(e.j.auto_terminate_mute_time, this.gQQ.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gQV.setTag(muteUser.user_id);
        }
        this.bwX.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView chf;
        HeadImageView gQT;
        TextView gQU;
        TextView gQV;
        View rootView;

        private c() {
        }
    }
}
