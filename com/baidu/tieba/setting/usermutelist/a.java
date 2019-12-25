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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> cRE;
    private b jQM;
    private InterfaceC0591a jQN;
    private SimpleDateFormat jQP = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0591a {
        void u(long j, String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void t(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0591a interfaceC0591a) {
        this.mActivity = baseActivity;
        this.jQM = bVar;
        this.jQN = interfaceC0591a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.cRE = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRE != null) {
            return this.cRE.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE != null) {
            return this.cRE.get(i);
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
        MuteUser muteUser = this.cRE.get(i);
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
            cVar.fmZ = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.jQT = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.jQU = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.jQS = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.jQU.setTag(Integer.valueOf(i));
            cVar.jQS.setTag(Integer.valueOf(i));
            cVar.fmZ.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.jQU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jQM != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jQM.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.jQS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jQN != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jQN.u(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.fmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jQN != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jQN.u(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.jQS.setTag(str);
            cVar.jQS.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.fmZ.setText(muteUser.name_show);
        } else {
            cVar.fmZ.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.jQT.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.jQP.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.jQU.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c {
        TextView fmZ;
        HeadImageView jQS;
        TextView jQT;
        TextView jQU;
        View rootView;

        private c() {
        }
    }
}
