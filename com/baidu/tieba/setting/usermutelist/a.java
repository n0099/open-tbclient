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
    private ArrayList<MuteUser> dvu;
    private b kGt;
    private InterfaceC0665a kGu;
    private SimpleDateFormat kGw = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0665a {
        void x(long j, String str);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void w(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0665a interfaceC0665a) {
        this.mActivity = baseActivity;
        this.kGt = bVar;
        this.kGu = interfaceC0665a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.dvu = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvu != null) {
            return this.dvu.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvu != null) {
            return this.dvu.get(i);
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
        MuteUser muteUser = this.dvu.get(i);
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
            cVar.fXY = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.kGA = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.kGB = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.kGz = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.kGB.setTag(Integer.valueOf(i));
            cVar.kGz.setTag(Integer.valueOf(i));
            cVar.fXY.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.kGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kGt != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kGt.w(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.kGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kGu != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kGu.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.fXY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kGu != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.kGu.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.kGz.setTag(str);
            cVar.kGz.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.fXY.setText(muteUser.name_show);
        } else {
            cVar.fXY.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.kGA.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.kGw.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.kGB.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView fXY;
        TextView kGA;
        TextView kGB;
        HeadImageView kGz;
        View rootView;

        private c() {
        }
    }
}
