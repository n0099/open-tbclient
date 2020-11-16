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
/* loaded from: classes25.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> eHj;
    private BaseActivity mActivity;
    private b mLg;
    private InterfaceC0846a mLh;
    private SimpleDateFormat mLj = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0846a {
        void A(long j, String str);
    }

    /* loaded from: classes25.dex */
    public interface b {
        void z(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0846a interfaceC0846a) {
        this.mActivity = baseActivity;
        this.mLg = bVar;
        this.mLh = interfaceC0846a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eHj = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj != null) {
            return this.eHj.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj != null) {
            return this.eHj.get(i);
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
        MuteUser muteUser = this.eHj.get(i);
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
            cVar.hBW = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.mLn = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.mLo = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.mLm = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.mLo.setTag(Integer.valueOf(i));
            cVar.mLm.setTag(Integer.valueOf(i));
            cVar.hBW.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.mLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mLg != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mLg.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.mLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mLh != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mLh.A(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mLh != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mLh.A(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.mLm.setTag(str);
            cVar.mLm.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hBW.setText(muteUser.name_show);
        } else {
            cVar.hBW.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.mLn.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.mLj.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.mLo.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class c {
        TextView hBW;
        HeadImageView mLm;
        TextView mLn;
        TextView mLo;
        View rootView;

        private c() {
        }
    }
}
