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
    private BaseActivity bxI;
    private b gSm;
    private InterfaceC0300a gSn;
    private SimpleDateFormat gSp = new SimpleDateFormat("yyyy.MM.dd");
    private ArrayList<MuteUser> mData;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0300a {
        void t(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0300a interfaceC0300a) {
        this.bxI = baseActivity;
        this.gSm = bVar;
        this.gSn = interfaceC0300a;
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
            cVar.rootView = LayoutInflater.from(this.bxI.getPageContext().getContext()).inflate(e.h.user_mute_list_item, (ViewGroup) null);
            cVar.chp = (TextView) cVar.rootView.findViewById(e.g.item_user_name);
            cVar.gSt = (TextView) cVar.rootView.findViewById(e.g.item_mute_terminate_time);
            cVar.gSu = (TextView) cVar.rootView.findViewById(e.g.item_remove_button);
            cVar.gSs = (HeadImageView) cVar.rootView.findViewById(e.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gSu.setTag(Integer.valueOf(i));
            cVar.gSs.setTag(Integer.valueOf(i));
            cVar.chp.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gSu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gSm != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gSm.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gSn != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gSn.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.chp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gSn != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gSn.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gSs.setTag(str);
            cVar.gSs.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.chp.setText(muteUser.name_show);
        } else {
            cVar.chp.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gSt.setText(this.bxI.getResources().getString(e.j.auto_terminate_mute_time, this.gSp.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gSu.setTag(muteUser.user_id);
        }
        this.bxI.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView chp;
        HeadImageView gSs;
        TextView gSt;
        TextView gSu;
        View rootView;

        private c() {
        }
    }
}
