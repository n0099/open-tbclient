package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> jOq = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jOq != null) {
            return this.jOq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bf */
    public d getItem(int i) {
        if (this.jOq == null || i >= this.jOq.size()) {
            return null;
        }
        return this.jOq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.jOq.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cO;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cO = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cO = cO(inflate);
            inflate.setTag(cO);
        }
        if (dVar == null) {
            return inflate;
        }
        cO.jOr.setText(dVar.title);
        cO.jOs.setText(dVar.content);
        cO.jOt.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cO.jOt.setDefaultResource(R.drawable.screen_notify_default_bg);
        cO.jOt.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eg(List<d> list) {
        if (list != null && list.size() != 0) {
            this.jOq.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        TextView jOr;
        TextView jOs;
        TbImageView jOt;
        View mLine;

        private a() {
        }
    }

    private a cO(View view) {
        a aVar = new a();
        aVar.jOr = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.jOs = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.jOt = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.jOt.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(R.id.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
