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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> eXu;
    private BaseActivity mActivity;
    private b nml;
    private InterfaceC0871a nmm;
    private SimpleDateFormat nmo = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0871a {
        void C(long j, String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void B(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0871a interfaceC0871a) {
        this.mActivity = baseActivity;
        this.nml = bVar;
        this.nmm = interfaceC0871a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eXu = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu != null) {
            return this.eXu.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu != null) {
            return this.eXu.get(i);
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
        MuteUser muteUser = this.eXu.get(i);
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
            cVar.hZP = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.nms = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.nmt = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.nmr = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.nmt.setTag(Integer.valueOf(i));
            cVar.nmr.setTag(Integer.valueOf(i));
            cVar.hZP.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.nmt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nml != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.nml.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.nmr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nmm != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.nmm.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hZP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nmm != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.nmm.C(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.nmr.setTag(str);
            cVar.nmr.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hZP.setText(muteUser.name_show);
        } else {
            cVar.hZP.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.nms.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.nmo.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.nmt.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c {
        TextView hZP;
        HeadImageView nmr;
        TextView nms;
        TextView nmt;
        View rootView;

        private c() {
        }
    }
}
