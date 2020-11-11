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
    private List<d> mDw = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDw != null) {
            return this.mDw.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Iq */
    public d getItem(int i) {
        if (this.mDw == null || i >= this.mDw.size()) {
            return null;
        }
        return this.mDw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.mDw.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a dF;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            dF = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            dF = dF(inflate);
            inflate.setTag(dF);
        }
        if (dVar == null) {
            return inflate;
        }
        dF.mDz.setText(dVar.title);
        dF.mDA.setText(dVar.content);
        dF.mDB.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        dF.mDB.setDefaultResource(R.drawable.screen_notify_default_bg);
        dF.mDB.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fD(List<d> list) {
        if (list != null && list.size() != 0) {
            this.mDw.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a {
        TextView mDA;
        TbImageView mDB;
        TextView mDz;
        View mLine;

        private a() {
        }
    }

    private a dF(View view) {
        a aVar = new a();
        aVar.mDz = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.mDA = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.mDB = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.mDB.setAutoChangeStyle(false);
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
