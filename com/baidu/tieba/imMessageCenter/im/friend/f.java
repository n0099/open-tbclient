package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<BlackListItemData> VL;
    private View.OnClickListener bYE = new g(this);
    private IMBlackListActivity dhI;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dhI = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.VL = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.VL != null) {
            this.VL.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.VL != null) {
            return this.VL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.VL != null) {
            return this.VL.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            aVar = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.rootView;
        }
        return null;
    }

    private a avi() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.dhI.getPageContext().getContext()).inflate(r.j.im_black_list_item, (ViewGroup) null);
        aVar.dhK = (HeadImageView) aVar.rootView.findViewById(r.h.header_view);
        aVar.dhK.setIsRound(true);
        aVar.blu = (TextView) aVar.rootView.findViewById(r.h.user_name);
        aVar.dhL = (Button) aVar.rootView.findViewById(r.h.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.dhL.setOnClickListener(this.bYE);
        return aVar;
    }

    private a a(Object obj, BlackListItemData blackListItemData) {
        a aVar;
        if (obj == null) {
            aVar = avi();
        } else {
            aVar = (a) obj;
        }
        a(aVar, blackListItemData.apX());
        aVar.blu.setText(blackListItemData.getUserName());
        aVar.dhL.setTag(blackListItemData);
        this.dhI.getLayoutMode().v(aVar.rootView);
        return aVar;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dhK.setTag(str);
            aVar.dhK.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView blu;
        public HeadImageView dhK;
        public Button dhL;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
