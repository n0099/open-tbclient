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
    private List<d> lny = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lny != null) {
            return this.lny.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DK */
    public d getItem(int i) {
        if (this.lny == null || i >= this.lny.size()) {
            return null;
        }
        return this.lny.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.lny.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a da;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            da = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            da = da(inflate);
            inflate.setTag(da);
        }
        if (dVar == null) {
            return inflate;
        }
        da.lnz.setText(dVar.title);
        da.lnA.setText(dVar.content);
        da.lnB.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        da.lnB.setDefaultResource(R.drawable.screen_notify_default_bg);
        da.lnB.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eN(List<d> list) {
        if (list != null && list.size() != 0) {
            this.lny.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TextView lnA;
        TbImageView lnB;
        TextView lnz;
        View mLine;

        private a() {
        }
    }

    private a da(View view) {
        a aVar = new a();
        aVar.lnz = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.lnA = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.lnB = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.lnB.setAutoChangeStyle(false);
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
