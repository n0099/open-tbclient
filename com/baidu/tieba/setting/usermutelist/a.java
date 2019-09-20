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
    private ArrayList<MuteUser> aIL;
    private BaseActivity cXM;
    private b iXt;
    private InterfaceC0417a iXu;
    private SimpleDateFormat iXw = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0417a {
        void r(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void q(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0417a interfaceC0417a) {
        this.cXM = baseActivity;
        this.iXt = bVar;
        this.iXu = interfaceC0417a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aIL = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIL != null) {
            return this.aIL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL != null) {
            return this.aIL.get(i);
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
        MuteUser muteUser = this.aIL.get(i);
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
            cVar.rootView = LayoutInflater.from(this.cXM.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            cVar.evT = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.iXA = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.iXB = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.iXz = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.iXB.setTag(Integer.valueOf(i));
            cVar.iXz.setTag(Integer.valueOf(i));
            cVar.evT.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.iXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iXt != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iXt.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.iXz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iXu != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iXu.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.evT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iXu != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iXu.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.iXz.setTag(str);
            cVar.iXz.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.evT.setText(muteUser.name_show);
        } else {
            cVar.evT.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.iXA.setText(this.cXM.getResources().getString(R.string.auto_terminate_mute_time, this.iXw.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.iXB.setTag(muteUser.user_id);
        }
        this.cXM.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView evT;
        TextView iXA;
        TextView iXB;
        HeadImageView iXz;
        View rootView;

        private c() {
        }
    }
}
