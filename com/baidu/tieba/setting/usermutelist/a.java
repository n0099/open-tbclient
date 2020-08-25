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
    private ArrayList<MuteUser> efX;
    private b lSA;
    private InterfaceC0798a lSB;
    private SimpleDateFormat lSD = new SimpleDateFormat("yyyy.MM.dd");
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
        this.lSA = bVar;
        this.lSB = interfaceC0798a;
    }

    public void setData(ArrayList<MuteUser> arrayList) {
        this.efX = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.efX != null) {
            return this.efX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efX != null) {
            return this.efX.get(i);
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
        MuteUser muteUser = this.efX.get(i);
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
            cVar.gRO = (TextView) cVar.rootView.findViewById(R.id.item_user_name);
            cVar.lSH = (TextView) cVar.rootView.findViewById(R.id.item_mute_terminate_time);
            cVar.lSI = (TextView) cVar.rootView.findViewById(R.id.item_remove_button);
            cVar.lSG = (HeadImageView) cVar.rootView.findViewById(R.id.item_header_view);
            cVar.rootView.setTag(cVar);
            cVar.lSI.setTag(Integer.valueOf(i));
            cVar.lSG.setTag(Integer.valueOf(i));
            cVar.gRO.setTag(Integer.valueOf(i));
        } else {
            cVar = (c) obj;
        }
        cVar.lSI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lSA != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lSA.x(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.lSG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lSB != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lSB.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        cVar.gRO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.usermutelist.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lSB != null && muteUser.user_id != null && muteUser.user_name != null) {
                    a.this.lSB.y(muteUser.user_id.longValue(), muteUser.user_name);
                }
            }
        });
        String str = muteUser.portrait;
        if (str != null) {
            cVar.lSG.setTag(str);
            cVar.lSG.startLoad(str, 12, false);
        }
        if (muteUser.name_show != null) {
            cVar.gRO.setText(muteUser.name_show);
        } else {
            cVar.gRO.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            cVar.lSH.setText(this.mActivity.getResources().getString(R.string.auto_terminate_mute_time, this.lSD.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        if (muteUser.user_id != null) {
            cVar.lSI.setTag(muteUser.user_id);
        }
        this.mActivity.getLayoutMode().onModeChanged(cVar.rootView);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class c {
        TextView gRO;
        HeadImageView lSG;
        TextView lSH;
        TextView lSI;
        View rootView;

        private c() {
        }
    }
}
