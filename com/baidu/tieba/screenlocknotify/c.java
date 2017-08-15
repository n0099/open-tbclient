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
    private List<e> fMO = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fMO != null) {
            return this.fMO.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sm */
    public e getItem(int i) {
        if (this.fMO == null || i >= this.fMO.size()) {
            return null;
        }
        return this.fMO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fMO.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bv;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bv = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.j.screenlock_show_item_view_4, viewGroup, false);
            bv = bv(inflate);
            inflate.setTag(bv);
        }
        if (eVar == null) {
            return inflate;
        }
        bv.fMP.setText(eVar.title);
        bv.fMQ.setText(eVar.content);
        bv.fMR.setDefaultErrorResource(d.g.screen_notify_default_bg);
        bv.fMR.setDefaultResource(d.g.screen_notify_default_bg);
        bv.fMR.a(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void de(List<e> list) {
        if (list != null && list.size() != 0) {
            this.fMO.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View auN;
        TextView fMP;
        TextView fMQ;
        TbImageView fMR;

        private a() {
        }
    }

    private a bv(View view) {
        a aVar = new a();
        aVar.fMP = (TextView) view.findViewById(d.h.push_msg_title);
        aVar.fMQ = (TextView) view.findViewById(d.h.push_msg_content);
        aVar.fMR = (TbImageView) view.findViewById(d.h.push_msg_pic);
        aVar.fMR.setAutoChangeStyle(false);
        aVar.auN = view.findViewById(d.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
