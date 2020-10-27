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
/* loaded from: classes21.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> mxx = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mxx != null) {
            return this.mxx.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Id */
    public d getItem(int i) {
        if (this.mxx == null || i >= this.mxx.size()) {
            return null;
        }
        return this.mxx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.mxx.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a dA;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            dA = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            dA = dA(inflate);
            inflate.setTag(dA);
        }
        if (dVar == null) {
            return inflate;
        }
        dA.mxy.setText(dVar.title);
        dA.mxz.setText(dVar.content);
        dA.mxA.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        dA.mxA.setDefaultResource(R.drawable.screen_notify_default_bg);
        dA.mxA.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fv(List<d> list) {
        if (list != null && list.size() != 0) {
            this.mxx.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a {
        View mLine;
        TbImageView mxA;
        TextView mxy;
        TextView mxz;

        private a() {
        }
    }

    private a dA(View view) {
        a aVar = new a();
        aVar.mxy = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.mxz = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.mxA = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.mxA.setAutoChangeStyle(false);
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
