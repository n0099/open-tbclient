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
    private ArrayList<MuteUser> dJp;
    private b kYv;
    private InterfaceC0718a kYw;
    private SimpleDateFormat kYy = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0718a {
        void x(long j, String str);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void w(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0718a interfaceC0718a) {
        this.mActivity = baseActivity;
        this.kYv = bVar;
        this.kYw = interfaceC0718a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.dJp = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dJp != null) {
            return this.dJp.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp != null) {
            return this.dJp.get(i);
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
        MuteUser muteUser = this.dJp.get(i);
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
            cVar.gmQ = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.kYC = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.kYD = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.kYB = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.kYD.setTag(Integer.valueOf(i));
            cVar.kYB.setTag(Integer.valueOf(i));
            cVar.gmQ.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.kYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kYv != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kYv.w(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.kYB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kYw != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kYw.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gmQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kYw != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kYw.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.kYB.setTag(str);
            cVar.kYB.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.gmQ.setText(muteUser.name_show);
        } else {
            cVar.gmQ.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.kYC.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.kYy.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.kYD.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView gmQ;
        HeadImageView kYB;
        TextView kYC;
        TextView kYD;
        View rootView;

        private c() {
        }
    }
}
