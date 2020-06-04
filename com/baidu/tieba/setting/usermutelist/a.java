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
    private b kZE;
    private InterfaceC0719a kZF;
    private SimpleDateFormat kZH = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0719a {
        void x(long j, String str);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void w(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0719a interfaceC0719a) {
        this.mActivity = baseActivity;
        this.kZE = bVar;
        this.kZF = interfaceC0719a;
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
            cVar.gnb = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.kZL = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.kZM = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.kZK = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.kZM.setTag(Integer.valueOf(i));
            cVar.kZK.setTag(Integer.valueOf(i));
            cVar.gnb.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.kZM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kZE != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kZE.w(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.kZK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kZF != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kZF.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kZF != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kZF.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.kZK.setTag(str);
            cVar.kZK.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.gnb.setText(muteUser.name_show);
        } else {
            cVar.gnb.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.kZL.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.kZH.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.kZM.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView gnb;
        HeadImageView kZK;
        TextView kZL;
        TextView kZM;
        View rootView;

        private c() {
        }
    }
}
