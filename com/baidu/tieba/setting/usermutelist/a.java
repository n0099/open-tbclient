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
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> dWx;
    private b lAT;
    private InterfaceC0745a lAU;
    private SimpleDateFormat lAW = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0745a {
        void z(long j, String str);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void y(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0745a interfaceC0745a) {
        this.mActivity = baseActivity;
        this.lAT = bVar;
        this.lAU = interfaceC0745a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.dWx = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx != null) {
            return this.dWx.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx != null) {
            return this.dWx.get(i);
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
        MuteUser muteUser = this.dWx.get(i);
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
            cVar.gFm = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.lBa = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.lBb = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.lAZ = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.lBb.setTag(Integer.valueOf(i));
            cVar.lAZ.setTag(Integer.valueOf(i));
            cVar.gFm.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.lBb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lAT != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lAT.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.lAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lAU != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lAU.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lAU != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lAU.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.lAZ.setTag(str);
            cVar.lAZ.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.gFm.setText(muteUser.name_show);
        } else {
            cVar.gFm.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.lBa.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.lAW.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.lBb.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class c {
        TextView gFm;
        HeadImageView lAZ;
        TextView lBa;
        TextView lBb;
        View rootView;

        private c() {
        }
    }
}
