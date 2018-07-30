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
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> gwU = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gwU != null) {
            return this.gwU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sz */
    public d getItem(int i) {
        if (this.gwU == null || i >= this.gwU.size()) {
            return null;
        }
        return this.gwU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gwU.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bz;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bz = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            bz = bz(inflate);
            inflate.setTag(bz);
        }
        if (dVar == null) {
            return inflate;
        }
        bz.gwV.setText(dVar.title);
        bz.gwW.setText(dVar.content);
        bz.gwX.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bz.gwX.setDefaultResource(d.f.screen_notify_default_bg);
        bz.gwX.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dm(List<d> list) {
        if (list != null && list.size() != 0) {
            this.gwU.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gwV;
        TextView gwW;
        TbImageView gwX;
        View mLine;

        private a() {
        }
    }

    private a bz(View view) {
        a aVar = new a();
        aVar.gwV = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.gwW = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.gwX = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.gwX.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(d.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
