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
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> egb;
    private b lSP;
    private InterfaceC0798a lSQ;
    private SimpleDateFormat lSS = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0798a {
        void y(long j, String str);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void x(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0798a interfaceC0798a) {
        this.mActivity = baseActivity;
        this.lSP = bVar;
        this.lSQ = interfaceC0798a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.egb = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egb != null) {
            return this.egb.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb != null) {
            return this.egb.get(i);
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
        MuteUser muteUser = this.egb.get(i);
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
            cVar.gRS = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.lSW = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.lSX = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.lSV = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.lSX.setTag(Integer.valueOf(i));
            cVar.lSV.setTag(Integer.valueOf(i));
            cVar.gRS.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.lSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lSP != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lSP.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.lSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lSQ != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lSQ.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lSQ != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lSQ.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.lSV.setTag(str);
            cVar.lSV.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.gRS.setText(muteUser.name_show);
        } else {
            cVar.gRS.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.lSW.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.lSS.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.lSX.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class c {
        TextView gRS;
        HeadImageView lSV;
        TextView lSW;
        TextView lSX;
        View rootView;

        private c() {
        }
    }
}
