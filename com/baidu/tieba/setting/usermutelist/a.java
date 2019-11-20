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
    private ArrayList<MuteUser> bbH;
    private b iWr;
    private InterfaceC0512a iWs;
    private SimpleDateFormat iWu = new SimpleDateFormat("yyyy.MM.dd");
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
        this.iWr = bVar;
        this.iWs = interfaceC0512a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.bbH = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH != null) {
            return this.bbH.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH != null) {
            return this.bbH.get(i);
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
        MuteUser muteUser = this.bbH.get(i);
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
            cVar.evA = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.iWy = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.iWz = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.iWx = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.iWz.setTag(Integer.valueOf(i));
            cVar.iWx.setTag(Integer.valueOf(i));
            cVar.evA.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.iWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iWr != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iWr.s(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.iWx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iWs != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iWs.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.evA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iWs != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iWs.t(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.iWx.setTag(str);
            cVar.iWx.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.evA.setText(muteUser.name_show);
        } else {
            cVar.evA.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.iWy.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.iWu.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.iWz.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView evA;
        HeadImageView iWx;
        TextView iWy;
        TextView iWz;
        View rootView;

        private c() {
        }
    }
}
