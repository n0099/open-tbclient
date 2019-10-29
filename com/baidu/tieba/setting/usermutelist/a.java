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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> bbZ;
    private b iXi;
    private InterfaceC0512a iXj;
    private SimpleDateFormat iXl = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0512a {
        void t(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0512a interfaceC0512a) {
        this.mActivity = baseActivity;
        this.iXi = bVar;
        this.iXj = interfaceC0512a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.bbZ = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ != null) {
            return this.bbZ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ != null) {
            return this.bbZ.get(i);
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
        MuteUser muteUser = this.bbZ.get(i);
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
            cVar.ewr = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.iXp = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.iXq = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.iXo = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.iXq.setTag(Integer.valueOf(i));
            cVar.iXo.setTag(Integer.valueOf(i));
            cVar.ewr.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.iXq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iXi != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iXi.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.iXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iXj != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iXj.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.ewr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iXj != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iXj.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.iXo.setTag(str);
            cVar.iXo.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.ewr.setText(muteUser.name_show);
        } else {
            cVar.ewr.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.iXp.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.iXl.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.iXq.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView ewr;
        HeadImageView iXo;
        TextView iXp;
        TextView iXq;
        View rootView;

        private c() {
        }
    }
}
