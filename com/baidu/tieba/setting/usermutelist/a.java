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
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> dvq;
    private b kGp;
    private InterfaceC0644a kGq;
    private SimpleDateFormat kGs = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0644a {
        void x(long j, String str);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void w(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0644a interfaceC0644a) {
        this.mActivity = baseActivity;
        this.kGp = bVar;
        this.kGq = interfaceC0644a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.dvq = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvq != null) {
            return this.dvq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq != null) {
            return this.dvq.get(i);
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
        MuteUser muteUser = this.dvq.get(i);
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
            cVar.fXT = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.kGw = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.kGx = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.kGv = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.kGx.setTag(Integer.valueOf(i));
            cVar.kGv.setTag(Integer.valueOf(i));
            cVar.fXT.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.kGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kGp != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kGp.w(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.kGv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kGq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kGq.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.fXT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kGq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kGq.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.kGv.setTag(str);
            cVar.kGv.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.fXT.setText(muteUser.name_show);
        } else {
            cVar.fXT.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.kGw.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.kGs.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.kGx.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView fXT;
        HeadImageView kGv;
        TextView kGw;
        TextView kGx;
        View rootView;

        private c() {
        }
    }
}
