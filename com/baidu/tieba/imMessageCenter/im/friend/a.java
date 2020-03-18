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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> cWf;
    private View.OnClickListener fgS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.hOh.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity hOh;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.hOh = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.cWf = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.cWf != null) {
            this.cWf.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWf != null) {
            return this.cWf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf != null) {
            return this.cWf.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0540a c0540a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0540a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0540a = null;
        }
        if (c0540a != null) {
            return c0540a.rootView;
        }
        return null;
    }

    private C0540a bZg() {
        C0540a c0540a = new C0540a();
        c0540a.rootView = LayoutInflater.from(this.hOh.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0540a.hOj = (HeadImageView) c0540a.rootView.findViewById(R.id.header_view);
        c0540a.hOj.setIsRound(true);
        c0540a.ftz = (TextView) c0540a.rootView.findViewById(R.id.user_name);
        c0540a.hOk = (Button) c0540a.rootView.findViewById(R.id.remove_button);
        c0540a.rootView.setTag(c0540a);
        c0540a.hOk.setOnClickListener(this.fgS);
        return c0540a;
    }

    private C0540a a(Object obj, BlackListItemData blackListItemData) {
        C0540a c0540a;
        if (obj == null) {
            c0540a = bZg();
        } else {
            c0540a = (C0540a) obj;
        }
        a(c0540a, blackListItemData.BQ());
        c0540a.ftz.setText(blackListItemData.aMu());
        c0540a.hOk.setTag(blackListItemData);
        this.hOh.getLayoutMode().onModeChanged(c0540a.rootView);
        return c0540a;
    }

    private void a(C0540a c0540a, String str) {
        if (str != null) {
            c0540a.hOj.setTag(str);
            c0540a.hOj.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0540a {
        public TextView ftz;
        public HeadImageView hOj;
        public Button hOk;
        public View rootView;

        private C0540a() {
        }
    }
}
