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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> eYq;
    private BaseActivity mActivity;
    private b neE;
    private InterfaceC0877a neF;
    private SimpleDateFormat neH = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0877a {
        void B(long j, String str);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void A(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0877a interfaceC0877a) {
        this.mActivity = baseActivity;
        this.neE = bVar;
        this.neF = interfaceC0877a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eYq = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eYq != null) {
            return this.eYq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq != null) {
            return this.eYq.get(i);
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
        MuteUser muteUser = this.eYq.get(i);
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
            cVar.hYe = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.neL = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.neM = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.neK = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.neM.setTag(Integer.valueOf(i));
            cVar.neK.setTag(Integer.valueOf(i));
            cVar.hYe.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.neM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.neE != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.neE.A(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.neK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.neF != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.neF.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hYe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.neF != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.neF.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.neK.setTag(str);
            cVar.neK.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hYe.setText(muteUser.name_show);
        } else {
            cVar.hYe.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.neL.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.neH.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.neM.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        TextView hYe;
        HeadImageView neK;
        TextView neL;
        TextView neM;
        View rootView;

        private c() {
        }
    }
}
