package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<e> fKU = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fKU != null) {
            return this.fKU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sc */
    public e getItem(int i) {
        if (this.fKU == null || i >= this.fKU.size()) {
            return null;
        }
        return this.fKU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fKU.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bt;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bt = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.j.screenlock_show_item_view_4, viewGroup, false);
            bt = bt(inflate);
            inflate.setTag(bt);
        }
        if (eVar == null) {
            return inflate;
        }
        bt.fKV.setText(eVar.title);
        bt.fKW.setText(eVar.content);
        bt.fKX.setDefaultErrorResource(d.g.screen_notify_default_bg);
        bt.fKX.setDefaultResource(d.g.screen_notify_default_bg);
        bt.fKX.a(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void db(List<e> list) {
        if (list != null && list.size() != 0) {
            this.fKU.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View auM;
        TextView fKV;
        TextView fKW;
        TbImageView fKX;

        private a() {
        }
    }

    private a bt(View view) {
        a aVar = new a();
        aVar.fKV = (TextView) view.findViewById(d.h.push_msg_title);
        aVar.fKW = (TextView) view.findViewById(d.h.push_msg_content);
        aVar.fKX = (TbImageView) view.findViewById(d.h.push_msg_pic);
        aVar.fKX.setAutoChangeStyle(false);
        aVar.auM = view.findViewById(d.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
