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
    private List<d> iSj = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iSj != null) {
            return this.iSj.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Aa */
    public d getItem(int i) {
        if (this.iSj == null || i >= this.iSj.size()) {
            return null;
        }
        return this.iSj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.iSj.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cR;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cR = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cR = cR(inflate);
            inflate.setTag(cR);
        }
        if (dVar == null) {
            return inflate;
        }
        cR.iSk.setText(dVar.title);
        cR.iSl.setText(dVar.content);
        cR.iSm.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cR.iSm.setDefaultResource(R.drawable.screen_notify_default_bg);
        cR.iSm.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eb(List<d> list) {
        if (list != null && list.size() != 0) {
            this.iSj.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView iSk;
        TextView iSl;
        TbImageView iSm;
        View mLine;

        private a() {
        }
    }

    private a cR(View view) {
        a aVar = new a();
        aVar.iSk = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.iSl = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.iSm = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.iSm.setAutoChangeStyle(false);
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
