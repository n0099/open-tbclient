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
    private ArrayList<MuteUser> dQf;
    private b ltC;
    private InterfaceC0735a ltD;
    private SimpleDateFormat ltF = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0735a {
        void x(long j, String str);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void w(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0735a interfaceC0735a) {
        this.mActivity = baseActivity;
        this.ltC = bVar;
        this.ltD = interfaceC0735a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.dQf = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQf != null) {
            return this.dQf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf != null) {
            return this.dQf.get(i);
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
        MuteUser muteUser = this.dQf.get(i);
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
            cVar.gzP = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.ltJ = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.ltK = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.ltI = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.ltK.setTag(Integer.valueOf(i));
            cVar.ltI.setTag(Integer.valueOf(i));
            cVar.gzP.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.ltK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ltC != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.ltC.w(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.ltI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ltD != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.ltD.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ltD != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.ltD.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.ltI.setTag(str);
            cVar.ltI.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.gzP.setText(muteUser.name_show);
        } else {
            cVar.gzP.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.ltJ.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.ltF.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.ltK.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView gzP;
        HeadImageView ltI;
        TextView ltJ;
        TextView ltK;
        View rootView;

        private c() {
        }
    }
}
