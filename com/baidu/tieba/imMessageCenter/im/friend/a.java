package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> adv;
    private View.OnClickListener bNl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object tag = view2.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.elT.a(view2, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity elT;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.elT = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.adv = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.adv != null) {
            this.adv.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.adv != null) {
            return this.adv.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.adv != null) {
            return this.adv.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0166a c0166a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0166a = a(view2 != null ? view2.getTag() : null, blackListItemData);
        } else {
            c0166a = null;
        }
        if (c0166a != null) {
            return c0166a.rootView;
        }
        return null;
    }

    private C0166a aHG() {
        C0166a c0166a = new C0166a();
        c0166a.rootView = LayoutInflater.from(this.elT.getPageContext().getContext()).inflate(d.i.im_black_list_item, (ViewGroup) null);
        c0166a.elV = (HeadImageView) c0166a.rootView.findViewById(d.g.header_view);
        c0166a.elV.setIsRound(true);
        c0166a.bHL = (TextView) c0166a.rootView.findViewById(d.g.user_name);
        c0166a.elW = (Button) c0166a.rootView.findViewById(d.g.remove_button);
        c0166a.rootView.setTag(c0166a);
        c0166a.elW.setOnClickListener(this.bNl);
        return c0166a;
    }

    private C0166a a(Object obj, BlackListItemData blackListItemData) {
        C0166a c0166a;
        if (obj == null) {
            c0166a = aHG();
        } else {
            c0166a = (C0166a) obj;
        }
        a(c0166a, blackListItemData.aCM());
        c0166a.bHL.setText(blackListItemData.getUserName());
        c0166a.elW.setTag(blackListItemData);
        this.elT.getLayoutMode().u(c0166a.rootView);
        return c0166a;
    }

    private void a(C0166a c0166a, String str) {
        if (str != null) {
            c0166a.elV.setTag(str);
            c0166a.elV.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0166a {
        public TextView bHL;
        public HeadImageView elV;
        public Button elW;
        public View rootView;

        private C0166a() {
        }
    }
}
