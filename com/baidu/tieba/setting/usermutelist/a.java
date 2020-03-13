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
    private ArrayList<MuteUser> cVS;
    private b jVD;
    private InterfaceC0603a jVE;
    private SimpleDateFormat jVG = new SimpleDateFormat("yyyy.MM.dd");
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
        this.jVD = bVar;
        this.jVE = interfaceC0603a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.cVS = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVS != null) {
            return this.cVS.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVS != null) {
            return this.cVS.get(i);
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
        MuteUser muteUser = this.cVS.get(i);
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
            cVar.fsZ = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.jVK = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.jVL = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.jVJ = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.jVL.setTag(Integer.valueOf(i));
            cVar.jVJ.setTag(Integer.valueOf(i));
            cVar.fsZ.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.jVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVD != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVD.u(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.jVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVE != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVE.v(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.fsZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVE != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVE.v(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.jVJ.setTag(str);
            cVar.jVJ.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.fsZ.setText(muteUser.name_show);
        } else {
            cVar.fsZ.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.jVK.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.jVG.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.jVL.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView fsZ;
        HeadImageView jVJ;
        TextView jVK;
        TextView jVL;
        View rootView;

        private c() {
        }
    }
}
