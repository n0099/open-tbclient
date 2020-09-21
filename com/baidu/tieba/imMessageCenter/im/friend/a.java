package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> eiq;
    private View.OnClickListener exX = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.jKD.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity jKD;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.jKD = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eiq = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eiq != null) {
            this.eiq.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eiq != null) {
            return this.eiq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq != null) {
            return this.eiq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0722a c0722a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0722a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0722a = null;
        }
        if (c0722a != null) {
            return c0722a.rootView;
        }
        return null;
    }

    private C0722a cMD() {
        C0722a c0722a = new C0722a();
        c0722a.rootView = LayoutInflater.from(this.jKD.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0722a.jKF = (HeadImageView) c0722a.rootView.findViewById(R.id.header_view);
        c0722a.jKF.setIsRound(true);
        c0722a.gVA = (TextView) c0722a.rootView.findViewById(R.id.user_name);
        c0722a.jKG = (Button) c0722a.rootView.findViewById(R.id.remove_button);
        c0722a.rootView.setTag(c0722a);
        c0722a.jKG.setOnClickListener(this.exX);
        return c0722a;
    }

    private C0722a a(Object obj, BlackListItemData blackListItemData) {
        C0722a c0722a;
        if (obj == null) {
            c0722a = cMD();
        } else {
            c0722a = (C0722a) obj;
        }
        a(c0722a, blackListItemData.RT());
        c0722a.gVA.setText(blackListItemData.bqp());
        c0722a.jKG.setTag(blackListItemData);
        this.jKD.getLayoutMode().onModeChanged(c0722a.rootView);
        return c0722a;
    }

    private void a(C0722a c0722a, String str) {
        if (str != null) {
            c0722a.jKF.setTag(str);
            c0722a.jKF.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0722a {
        public TextView gVA;
        public HeadImageView jKF;
        public Button jKG;
        public View rootView;

        private C0722a() {
        }
    }
}
