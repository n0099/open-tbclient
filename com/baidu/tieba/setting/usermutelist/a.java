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
    private b mZk;
    private InterfaceC0861a mZl;
    private SimpleDateFormat mZn = new SimpleDateFormat("yyyy.MM.dd");

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
        this.mZk = bVar;
        this.mZl = interfaceC0861a;
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
            cVar.hLD = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.mZr = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.mZs = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.mZq = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.mZs.setTag(Integer.valueOf(i));
            cVar.mZq.setTag(Integer.valueOf(i));
            cVar.hLD.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.mZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZk != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZk.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.mZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZl != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZl.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hLD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZl != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZl.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.mZq.setTag(str);
            cVar.mZq.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hLD.setText(muteUser.name_show);
        } else {
            cVar.hLD.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.mZr.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.mZn.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.mZs.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class c {
        TextView hLD;
        HeadImageView mZq;
        TextView mZr;
        TextView mZs;
        View rootView;

        private c() {
        }
    }
}
