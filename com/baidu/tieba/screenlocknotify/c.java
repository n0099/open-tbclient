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
    private List<e> fMP = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fMP != null) {
            return this.fMP.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sm */
    public e getItem(int i) {
        if (this.fMP == null || i >= this.fMP.size()) {
            return null;
        }
        return this.fMP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fMP.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bu;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bu = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.j.screenlock_show_item_view_4, viewGroup, false);
            bu = bu(inflate);
            inflate.setTag(bu);
        }
        if (eVar == null) {
            return inflate;
        }
        bu.fMQ.setText(eVar.title);
        bu.fMR.setText(eVar.content);
        bu.fMS.setDefaultErrorResource(d.g.screen_notify_default_bg);
        bu.fMS.setDefaultResource(d.g.screen_notify_default_bg);
        bu.fMS.a(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void de(List<e> list) {
        if (list != null && list.size() != 0) {
            this.fMP.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View auO;
        TextView fMQ;
        TextView fMR;
        TbImageView fMS;

        private a() {
        }
    }

    private a bu(View view) {
        a aVar = new a();
        aVar.fMQ = (TextView) view.findViewById(d.h.push_msg_title);
        aVar.fMR = (TextView) view.findViewById(d.h.push_msg_content);
        aVar.fMS = (TbImageView) view.findViewById(d.h.push_msg_pic);
        aVar.fMS.setAutoChangeStyle(false);
        aVar.auO = view.findViewById(d.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
