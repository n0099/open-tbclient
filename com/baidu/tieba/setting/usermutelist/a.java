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
    private ArrayList<MuteUser> aIn;
    private BaseActivity cWM;
    private b iTU;
    private InterfaceC0400a iTV;
    private SimpleDateFormat iTX = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0400a {
        void r(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void q(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0400a interfaceC0400a) {
        this.cWM = baseActivity;
        this.iTU = bVar;
        this.iTV = interfaceC0400a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aIn = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIn != null) {
            return this.aIn.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn != null) {
            return this.aIn.get(i);
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
        MuteUser muteUser = this.aIn.get(i);
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
            cVar.rootView = LayoutInflater.from(this.cWM.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            cVar.euc = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.iUb = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.iUc = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.iUa = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.iUc.setTag(Integer.valueOf(i));
            cVar.iUa.setTag(Integer.valueOf(i));
            cVar.euc.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.iUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iTU != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iTU.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.iUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iTV != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iTV.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.euc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iTV != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iTV.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.iUa.setTag(str);
            cVar.iUa.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.euc.setText(muteUser.name_show);
        } else {
            cVar.euc.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.iUb.setText(this.cWM.getResources().getString(R.string.auto_terminate_mute_time, this.iTX.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.iUc.setTag(muteUser.user_id);
        }
        this.cWM.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView euc;
        HeadImageView iUa;
        TextView iUb;
        TextView iUc;
        View rootView;

        private c() {
        }
    }
}
