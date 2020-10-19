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
    private ArrayList<MuteUser> euy;
    private BaseActivity mActivity;
    private b mrQ;
    private InterfaceC0813a mrR;
    private SimpleDateFormat mrT = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0813a {
        void z(long j, String str);
    }

    /* loaded from: classes26.dex */
    public interface b {
        void y(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0813a interfaceC0813a) {
        this.mActivity = baseActivity;
        this.mrQ = bVar;
        this.mrR = interfaceC0813a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.euy = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.euy != null) {
            return this.euy.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy != null) {
            return this.euy.get(i);
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
        MuteUser muteUser = this.euy.get(i);
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
            cVar.hkx = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.mrX = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.mrY = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.mrW = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.mrY.setTag(Integer.valueOf(i));
            cVar.mrW.setTag(Integer.valueOf(i));
            cVar.hkx.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.mrY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mrQ != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mrQ.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.mrW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mrR != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mrR.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hkx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mrR != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mrR.z(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.mrW.setTag(str);
            cVar.mrW.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hkx.setText(muteUser.name_show);
        } else {
            cVar.hkx.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.mrX.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.mrT.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.mrY.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class c {
        TextView hkx;
        HeadImageView mrW;
        TextView mrX;
        TextView mrY;
        View rootView;

        private c() {
        }
    }
}
