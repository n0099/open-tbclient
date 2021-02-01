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
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> ncg = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ncg != null) {
            return this.ncg.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ip */
    public d getItem(int i) {
        if (this.ncg == null || i >= this.ncg.size()) {
            return null;
        }
        return this.ncg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.ncg.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a ef;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            ef = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            ef = ef(inflate);
            inflate.setTag(ef);
        }
        if (dVar == null) {
            return inflate;
        }
        ef.nch.setText(dVar.title);
        ef.nci.setText(dVar.content);
        ef.ncj.setDefaultResource(R.drawable.screen_notify_default_bg);
        ef.ncj.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fP(List<d> list) {
        if (list != null && list.size() != 0) {
            this.ncg.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        View mLine;
        TextView nch;
        TextView nci;
        TbImageView ncj;

        private a() {
        }
    }

    private a ef(View view) {
        a aVar = new a();
        aVar.nch = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.nci = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.ncj = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.ncj.setAutoChangeStyle(false);
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
