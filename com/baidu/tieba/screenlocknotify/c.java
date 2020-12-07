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
    private List<d> mRT = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mRT != null) {
            return this.mRT.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JI */
    public d getItem(int i) {
        if (this.mRT == null || i >= this.mRT.size()) {
            return null;
        }
        return this.mRT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.mRT.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a dX;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            dX = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            dX = dX(inflate);
            inflate.setTag(dX);
        }
        if (dVar == null) {
            return inflate;
        }
        dX.mRU.setText(dVar.title);
        dX.mRV.setText(dVar.content);
        dX.mRW.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        dX.mRW.setDefaultResource(R.drawable.screen_notify_default_bg);
        dX.mRW.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fR(List<d> list) {
        if (list != null && list.size() != 0) {
            this.mRT.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a {
        View mLine;
        TextView mRU;
        TextView mRV;
        TbImageView mRW;

        private a() {
        }
    }

    private a dX(View view) {
        a aVar = new a();
        aVar.mRU = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.mRV = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.mRW = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.mRW.setAutoChangeStyle(false);
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
