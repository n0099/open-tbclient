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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> cRO;
    private b jUp;
    private InterfaceC0596a jUq;
    private SimpleDateFormat jUs = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0596a {
        void u(long j, String str);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void t(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0596a interfaceC0596a) {
        this.mActivity = baseActivity;
        this.jUp = bVar;
        this.jUq = interfaceC0596a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.cRO = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO != null) {
            return this.cRO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO != null) {
            return this.cRO.get(i);
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
        MuteUser muteUser = this.cRO.get(i);
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
            cVar.fqi = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.jUw = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.jUx = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.jUv = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.jUx.setTag(Integer.valueOf(i));
            cVar.jUv.setTag(Integer.valueOf(i));
            cVar.fqi.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.jUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jUp != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jUp.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.jUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jUq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jUq.u(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.fqi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jUq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jUq.u(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.jUv.setTag(str);
            cVar.jUv.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.fqi.setText(muteUser.name_show);
        } else {
            cVar.fqi.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.jUw.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.jUs.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.jUx.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c {
        TextView fqi;
        HeadImageView jUv;
        TextView jUw;
        TextView jUx;
        View rootView;

        private c() {
        }
    }
}
