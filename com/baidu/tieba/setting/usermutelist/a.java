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
    private BaseActivity cVo;
    private b iNw;
    private InterfaceC0401a iNx;
    private SimpleDateFormat iNz = new SimpleDateFormat("yyyy.MM.dd");

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
        this.cVo = baseActivity;
        this.iNw = bVar;
        this.iNx = interfaceC0401a;
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
            cVar.rootView = LayoutInflater.from(this.cVo.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            cVar.epd = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.iND = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.iNE = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.iNC = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.iNE.setTag(Integer.valueOf(i));
            cVar.iNC.setTag(Integer.valueOf(i));
            cVar.epd.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.iNE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iNw != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iNw.q(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.iNC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iNx != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iNx.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.epd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iNx != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.iNx.r(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.iNC.setTag(str);
            cVar.iNC.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.epd.setText(muteUser.name_show);
        } else {
            cVar.epd.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.iND.setText(this.cVo.getResources().getString(R.string.auto_terminate_mute_time, this.iNz.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.iNE.setTag(muteUser.user_id);
        }
        this.cVo.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView epd;
        HeadImageView iNC;
        TextView iND;
        TextView iNE;
        View rootView;

        private c() {
        }
    }
}
