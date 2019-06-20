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
    private ArrayList<MuteUser> aHF;
    private BaseActivity cVq;
    private b iNC;
    private InterfaceC0401a iND;
    private SimpleDateFormat iNF = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0401a {
        void r(long j, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void q(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0401a interfaceC0401a) {
        this.cVq = baseActivity;
        this.iNC = bVar;
        this.iND = interfaceC0401a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.aHF = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHF != null) {
            return this.aHF.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF != null) {
            return this.aHF.get(i);
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
        MuteUser muteUser = this.aHF.get(i);
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
            cVar.rootView = LayoutInflater.from(this.cVq.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            cVar.epe = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.iNJ = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.iNK = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.iNI = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.iNK.setTag(Integer.valueOf(i));
            cVar.iNI.setTag(Integer.valueOf(i));
            cVar.epe.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.iNK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iNC != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iNC.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.iNI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iND != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iND.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.epe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iND != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iND.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.iNI.setTag(str);
            cVar.iNI.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.epe.setText(muteUser.name_show);
        } else {
            cVar.epe.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.iNJ.setText(this.cVq.getResources().getString(R.string.auto_terminate_mute_time, this.iNF.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.iNK.setTag(muteUser.user_id);
        }
        this.cVq.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView epe;
        HeadImageView iNI;
        TextView iNJ;
        TextView iNK;
        View rootView;

        private c() {
        }
    }
}
