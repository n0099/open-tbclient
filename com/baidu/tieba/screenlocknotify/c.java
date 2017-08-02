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
    private List<e> fJI = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJI != null) {
            return this.fJI.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sd */
    public e getItem(int i) {
        if (this.fJI == null || i >= this.fJI.size()) {
            return null;
        }
        return this.fJI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fJI.get(i), view, viewGroup);
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
        bt.fJJ.setText(eVar.title);
        bt.fJK.setText(eVar.content);
        bt.fJL.setDefaultErrorResource(d.g.screen_notify_default_bg);
        bt.fJL.setDefaultResource(d.g.screen_notify_default_bg);
        bt.fJL.a(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void db(List<e> list) {
        if (list != null && list.size() != 0) {
            this.fJI.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View atu;
        TextView fJJ;
        TextView fJK;
        TbImageView fJL;

        private a() {
        }
    }

    private a bt(View view) {
        a aVar = new a();
        aVar.fJJ = (TextView) view.findViewById(d.h.push_msg_title);
        aVar.fJK = (TextView) view.findViewById(d.h.push_msg_content);
        aVar.fJL = (TbImageView) view.findViewById(d.h.push_msg_pic);
        aVar.fJL.setAutoChangeStyle(false);
        aVar.atu = view.findViewById(d.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
