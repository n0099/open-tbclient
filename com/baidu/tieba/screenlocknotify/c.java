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
/* loaded from: classes15.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> lMi = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lMi != null) {
            return this.lMi.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: GD */
    public d getItem(int i) {
        if (this.lMi == null || i >= this.lMi.size()) {
            return null;
        }
        return this.lMi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.lMi.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a dk;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            dk = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            dk = dk(inflate);
            inflate.setTag(dk);
        }
        if (dVar == null) {
            return inflate;
        }
        dk.lMj.setText(dVar.title);
        dk.lMk.setText(dVar.content);
        dk.lMl.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        dk.lMl.setDefaultResource(R.drawable.screen_notify_default_bg);
        dk.lMl.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fb(List<d> list) {
        if (list != null && list.size() != 0) {
            this.lMi.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a {
        TextView lMj;
        TextView lMk;
        TbImageView lMl;
        View mLine;

        private a() {
        }
    }

    private a dk(View view) {
        a aVar = new a();
        aVar.lMj = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.lMk = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.lMl = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.lMl.setAutoChangeStyle(false);
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
