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
    private ArrayList<MuteUser> eOt;
    private BaseActivity mActivity;
    private b mZi;
    private InterfaceC0861a mZj;
    private SimpleDateFormat mZl = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0861a {
        void C(long j, String str);
    }

    /* loaded from: classes26.dex */
    public interface b {
        void B(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0861a interfaceC0861a) {
        this.mActivity = baseActivity;
        this.mZi = bVar;
        this.mZj = interfaceC0861a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eOt = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt != null) {
            return this.eOt.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt != null) {
            return this.eOt.get(i);
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
        MuteUser muteUser = this.eOt.get(i);
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
            cVar.hLB = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.mZp = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.mZq = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.mZo = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.mZq.setTag(Integer.valueOf(i));
            cVar.mZo.setTag(Integer.valueOf(i));
            cVar.hLB.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.mZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZi != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZi.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.mZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZj != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZj.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZj != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZj.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.mZo.setTag(str);
            cVar.mZo.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hLB.setText(muteUser.name_show);
        } else {
            cVar.hLB.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.mZp.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.mZl.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.mZq.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class c {
        TextView hLB;
        HeadImageView mZo;
        TextView mZp;
        TextView mZq;
        View rootView;

        private c() {
        }
    }
}
