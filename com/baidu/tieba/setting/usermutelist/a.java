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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> eVV;
    private BaseActivity mActivity;
    private b nkh;
    private InterfaceC0865a nki;
    private SimpleDateFormat nkk = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0865a {
        void C(long j, String str);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void B(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0865a interfaceC0865a) {
        this.mActivity = baseActivity;
        this.nkh = bVar;
        this.nki = interfaceC0865a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eVV = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV != null) {
            return this.eVV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV != null) {
            return this.eVV.get(i);
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
        MuteUser muteUser = this.eVV.get(i);
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
            cVar.hYg = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.nko = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.nkp = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.nkn = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.nkp.setTag(Integer.valueOf(i));
            cVar.nkn.setTag(Integer.valueOf(i));
            cVar.hYg.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.nkp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nkh != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.nkh.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.nkn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nki != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.nki.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nki != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.nki.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.nkn.setTag(str);
            cVar.nkn.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hYg.setText(muteUser.name_show);
        } else {
            cVar.hYg.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.nko.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.nkk.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.nkp.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        TextView hYg;
        HeadImageView nkn;
        TextView nko;
        TextView nkp;
        View rootView;

        private c() {
        }
    }
}
