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
    private ArrayList<MuteUser> cVR;
    private b jVr;
    private InterfaceC0603a jVs;
    private SimpleDateFormat jVu = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0603a {
        void v(long j, String str);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void u(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0603a interfaceC0603a) {
        this.mActivity = baseActivity;
        this.jVr = bVar;
        this.jVs = interfaceC0603a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.cVR = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVR != null) {
            return this.cVR.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR != null) {
            return this.cVR.get(i);
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
        MuteUser muteUser = this.cVR.get(i);
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
            cVar.fsM = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.jVy = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.jVz = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.jVx = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.jVz.setTag(Integer.valueOf(i));
            cVar.jVx.setTag(Integer.valueOf(i));
            cVar.fsM.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.jVz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVr != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVr.u(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.jVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVs != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVs.v(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.fsM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVs != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVs.v(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.jVx.setTag(str);
            cVar.jVx.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.fsM.setText(muteUser.name_show);
        } else {
            cVar.fsM.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.jVy.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.jVu.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.jVz.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView fsM;
        HeadImageView jVx;
        TextView jVy;
        TextView jVz;
        View rootView;

        private c() {
        }
    }
}
