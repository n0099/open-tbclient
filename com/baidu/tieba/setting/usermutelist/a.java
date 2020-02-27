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
    private ArrayList<MuteUser> cVQ;
    private b jVp;
    private InterfaceC0603a jVq;
    private SimpleDateFormat jVs = new SimpleDateFormat("yyyy.MM.dd");
    private BaseActivity mActivity;

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0603a {
        void v(long j, String str);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void u(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0603a interfaceC0603a) {
        this.mActivity = baseActivity;
        this.jVp = bVar;
        this.jVq = interfaceC0603a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.cVQ = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVQ != null) {
            return this.cVQ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVQ != null) {
            return this.cVQ.get(i);
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
        MuteUser muteUser = this.cVQ.get(i);
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
            cVar.fsL = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.jVw = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.jVx = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.jVv = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.jVx.setTag(Integer.valueOf(i));
            cVar.jVv.setTag(Integer.valueOf(i));
            cVar.fsL.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.jVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVp != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVp.u(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.jVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVq.v(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.fsL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jVq != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.jVq.v(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.jVv.setTag(str);
            cVar.jVv.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.fsL.setText(muteUser.name_show);
        } else {
            cVar.fsL.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.jVw.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.jVs.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.jVx.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        TextView fsL;
        HeadImageView jVv;
        TextView jVw;
        TextView jVx;
        View rootView;

        private c() {
        }
    }
}
