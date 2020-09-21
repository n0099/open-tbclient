package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes25.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> eiq;
    private BaseActivity mActivity;
    private b mcm;
    private InterfaceC0795a mcn;
    private SimpleDateFormat mcp = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0795a {
        void y(long j, String str);
    }

    /* loaded from: classes25.dex */
    public interface b {
        void x(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0795a interfaceC0795a) {
        this.mActivity = baseActivity;
        this.mcm = bVar;
        this.mcn = interfaceC0795a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eiq = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eiq != null) {
            return this.eiq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq != null) {
            return this.eiq.get(i);
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
        MuteUser muteUser = this.eiq.get(i);
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
            cVar.rootView = LayoutInflater.from(this.mActivity.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            cVar.gVA = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.mct = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.mcu = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.mcs = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.mcu.setTag(Integer.valueOf(i));
            cVar.mcs.setTag(Integer.valueOf(i));
            cVar.gVA.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.mcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mcm != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mcm.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.mcs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mcn != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mcn.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gVA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mcn != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mcn.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.mcs.setTag(str);
            cVar.mcs.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.gVA.setText(muteUser.name_show);
        } else {
            cVar.gVA.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.mct.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.mcp.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.mcu.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class c {
        TextView gVA;
        HeadImageView mcs;
        TextView mct;
        TextView mcu;
        View rootView;

        private c() {
        }
    }
}
