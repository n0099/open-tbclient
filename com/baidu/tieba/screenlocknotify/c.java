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
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> iQq = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iQq != null) {
            return this.iQq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yF */
    public d getItem(int i) {
        if (this.iQq == null || i >= this.iQq.size()) {
            return null;
        }
        return this.iQq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.iQq.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cN;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cN = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cN = cN(inflate);
            inflate.setTag(cN);
        }
        if (dVar == null) {
            return inflate;
        }
        cN.iQr.setText(dVar.title);
        cN.iQs.setText(dVar.content);
        cN.iQt.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cN.iQt.setDefaultResource(R.drawable.screen_notify_default_bg);
        cN.iQt.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eo(List<d> list) {
        if (list != null && list.size() != 0) {
            this.iQq.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView iQr;
        TextView iQs;
        TbImageView iQt;
        View mLine;

        private a() {
        }
    }

    private a cN(View view) {
        a aVar = new a();
        aVar.iQr = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.iQs = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.iQt = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.iQt.setAutoChangeStyle(false);
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
