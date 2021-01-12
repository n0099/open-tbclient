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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> eTF;
    private View.OnClickListener fjU = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.kGH.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity kGH;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.kGH = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eTF = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eTF != null) {
            this.eTF.remove(blackListItemData);
        }
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
        C0764a c0764a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0764a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0764a = null;
        }
        if (c0764a != null) {
            return c0764a.rootView;
        }
        return null;
    }

    private C0764a cWy() {
        C0764a c0764a = new C0764a();
        c0764a.rootView = LayoutInflater.from(this.kGH.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0764a.kGJ = (HeadImageView) c0764a.rootView.findViewById(R.id.header_view);
        c0764a.kGJ.setIsRound(true);
        c0764a.hTx = (TextView) c0764a.rootView.findViewById(R.id.user_name);
        c0764a.kGK = (Button) c0764a.rootView.findViewById(R.id.remove_button);
        c0764a.rootView.setTag(c0764a);
        c0764a.kGK.setOnClickListener(this.fjU);
        return c0764a;
    }

    private C0764a a(Object obj, BlackListItemData blackListItemData) {
        C0764a c0764a;
        if (obj == null) {
            c0764a = cWy();
        } else {
            c0764a = (C0764a) obj;
        }
        a(c0764a, blackListItemData.XU());
        c0764a.hTx.setText(blackListItemData.byI());
        c0764a.kGK.setTag(blackListItemData);
        this.kGH.getLayoutMode().onModeChanged(c0764a.rootView);
        return c0764a;
    }

    private void a(C0764a c0764a, String str) {
        if (str != null) {
            c0764a.kGJ.setTag(str);
            c0764a.kGJ.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0764a {
        public TextView hTx;
        public HeadImageView kGJ;
        public Button kGK;
        public View rootView;

        private C0764a() {
        }
    }
}
