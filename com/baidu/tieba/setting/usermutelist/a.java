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
    private ArrayList<MuteUser> eCX;
    private BaseActivity mActivity;
    private b mEv;
    private InterfaceC0828a mEw;
    private SimpleDateFormat mEy = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0828a {
        void z(long j, String str);
    }

    /* loaded from: classes26.dex */
    public interface b {
        void y(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0828a interfaceC0828a) {
        this.mActivity = baseActivity;
        this.mEv = bVar;
        this.mEw = interfaceC0828a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eCX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCX != null) {
            return this.eCX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX != null) {
            return this.eCX.get(i);
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
        MuteUser muteUser = this.eCX.get(i);
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
            cVar.hws = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.mEC = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.mED = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.mEB = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.mED.setTag(Integer.valueOf(i));
            cVar.mEB.setTag(Integer.valueOf(i));
            cVar.hws.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.mED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mEv != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mEv.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.mEB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mEw != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mEw.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mEw != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mEw.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.mEB.setTag(str);
            cVar.mEB.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hws.setText(muteUser.name_show);
        } else {
            cVar.hws.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.mEC.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.mEy.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.mED.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class c {
        TextView hws;
        HeadImageView mEB;
        TextView mEC;
        TextView mED;
        View rootView;

        private c() {
        }
    }
}
