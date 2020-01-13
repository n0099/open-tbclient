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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> cRO;
    private View.OnClickListener fcW = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.hKv.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity hKv;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.hKv = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.cRO = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.cRO != null) {
            this.cRO.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO != null) {
            return this.cRO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO != null) {
            return this.cRO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0532a c0532a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0532a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0532a = null;
        }
        if (c0532a != null) {
            return c0532a.rootView;
        }
        return null;
    }

    private C0532a bXk() {
        C0532a c0532a = new C0532a();
        c0532a.rootView = LayoutInflater.from(this.hKv.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0532a.hKx = (HeadImageView) c0532a.rootView.findViewById(R.id.header_view);
        c0532a.hKx.setIsRound(true);
        c0532a.fqi = (TextView) c0532a.rootView.findViewById(R.id.user_name);
        c0532a.hKy = (Button) c0532a.rootView.findViewById(R.id.remove_button);
        c0532a.rootView.setTag(c0532a);
        c0532a.hKy.setOnClickListener(this.fcW);
        return c0532a;
    }

    private C0532a a(Object obj, BlackListItemData blackListItemData) {
        C0532a c0532a;
        if (obj == null) {
            c0532a = bXk();
        } else {
            c0532a = (C0532a) obj;
        }
        a(c0532a, blackListItemData.zr());
        c0532a.fqi.setText(blackListItemData.aJT());
        c0532a.hKy.setTag(blackListItemData);
        this.hKv.getLayoutMode().onModeChanged(c0532a.rootView);
        return c0532a;
    }

    private void a(C0532a c0532a, String str) {
        if (str != null) {
            c0532a.hKx.setTag(str);
            c0532a.hKx.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0532a {
        public TextView fqi;
        public HeadImageView hKx;
        public Button hKy;
        public View rootView;

        private C0532a() {
        }
    }
}
