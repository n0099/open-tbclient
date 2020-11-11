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
/* loaded from: classes26.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> eIM;
    private BaseActivity mActivity;
    private SimpleDateFormat mKA = new SimpleDateFormat("yyyy.MM.dd");
    private b mKx;
    private InterfaceC0843a mKy;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0843a {
        void A(long j, String str);
    }

    /* loaded from: classes26.dex */
    public interface b {
        void z(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0843a interfaceC0843a) {
        this.mActivity = baseActivity;
        this.mKx = bVar;
        this.mKy = interfaceC0843a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eIM = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM != null) {
            return this.eIM.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM != null) {
            return this.eIM.get(i);
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
        MuteUser muteUser = this.eIM.get(i);
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
            cVar.hCp = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.mKE = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.mKF = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.mKD = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.mKF.setTag(Integer.valueOf(i));
            cVar.mKD.setTag(Integer.valueOf(i));
            cVar.hCp.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.mKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mKx != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mKx.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.mKD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mKy != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mKy.A(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mKy != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mKy.A(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.mKD.setTag(str);
            cVar.mKD.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hCp.setText(muteUser.name_show);
        } else {
            cVar.hCp.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.mKE.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.mKA.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.mKF.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class c {
        TextView hCp;
        HeadImageView mKD;
        TextView mKE;
        TextView mKF;
        View rootView;

        private c() {
        }
    }
}
