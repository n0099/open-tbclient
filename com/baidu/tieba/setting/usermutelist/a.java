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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<MuteUser> eTF;
    private BaseActivity mActivity;
    private b mZY;
    private InterfaceC0860a mZZ;
    private SimpleDateFormat nab = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.baidu.tieba.setting.usermutelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0860a {
        void B(long j, String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void A(long j, String str);
    }

    public a(BaseActivity baseActivity, b bVar, InterfaceC0860a interfaceC0860a) {
        this.mActivity = baseActivity;
        this.mZY = bVar;
        this.mZZ = interfaceC0860a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.eTF = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF != null) {
            return this.eTF.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eTF != null) {
            return this.eTF.get(i);
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
        MuteUser muteUser = this.eTF.get(i);
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
            cVar.hTx = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.naf = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.nag = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.nae = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.nag.setTag(Integer.valueOf(i));
            cVar.nae.setTag(Integer.valueOf(i));
            cVar.hTx.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.nag.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZY != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZY.A(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.nae.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZZ != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZZ.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.hTx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mZZ != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.mZZ.B(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.nae.setTag(str);
            cVar.nae.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.hTx.setText(muteUser.name_show);
        } else {
            cVar.hTx.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.naf.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.nab.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.nag.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c {
        TextView hTx;
        HeadImageView nae;
        TextView naf;
        TextView nag;
        View rootView;

        private c() {
        }
    }
}
