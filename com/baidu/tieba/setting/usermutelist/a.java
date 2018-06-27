package com.baidu.tieba.setting.usermutelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> alT;
    private BaseActivity bmt;
    private b gAA;
    private InterfaceC0231a gAB;
    private SimpleDateFormat gAD = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0231a {
        void r(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void q(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0231a interfaceC0231a) {
        this.bmt = baseActivity;
        this.gAA = bVar;
        this.gAB = interfaceC0231a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.alT = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alT != null) {
            return this.alT.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alT != null) {
            return this.alT.get(i);
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
        MuteUser muteUser = this.alT.get(i);
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
            cVar.rootView = LayoutInflater.from(this.bmt.getPageContext().getContext()).inflate(d.i.user_mute_list_item, (ViewGroup) null);
            cVar.bRW = (TextView) cVar.rootView.findViewById(d.g.item_user_name);
            cVar.gAH = (TextView) cVar.rootView.findViewById(d.g.item_mute_terminate_time);
            cVar.gAI = (TextView) cVar.rootView.findViewById(d.g.item_remove_button);
            cVar.gAG = (HeadImageView) cVar.rootView.findViewById(d.g.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.gAI.setTag(Integer.valueOf(i));
            cVar.gAG.setTag(Integer.valueOf(i));
            cVar.bRW.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.gAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gAA != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gAA.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gAG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gAB != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gAB.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.bRW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gAB != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.gAB.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.gAG.setTag(str);
            cVar.gAG.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.bRW.setText(muteUser.name_show);
        } else {
            cVar.bRW.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.gAH.setText(this.bmt.getResources().getString(d.k.auto_terminate_mute_time, this.gAD.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.gAI.setTag(muteUser.user_id);
        }
        this.bmt.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView bRW;
        HeadImageView gAG;
        TextView gAH;
        TextView gAI;
        View rootView;

        private c() {
        }
    }
}
