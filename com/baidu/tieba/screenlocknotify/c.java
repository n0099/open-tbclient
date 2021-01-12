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
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> mSK = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mSK != null) {
            return this.mSK.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: HV */
    public d getItem(int i) {
        if (this.mSK == null || i >= this.mSK.size()) {
            return null;
        }
        return this.mSK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.mSK.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a eh;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            eh = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            eh = eh(inflate);
            inflate.setTag(eh);
        }
        if (dVar == null) {
            return inflate;
        }
        eh.mSL.setText(dVar.title);
        eh.mSM.setText(dVar.content);
        eh.mSN.setDefaultResource(R.drawable.screen_notify_default_bg);
        eh.mSN.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fR(List<d> list) {
        if (list != null && list.size() != 0) {
            this.mSK.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        View mLine;
        TextView mSL;
        TextView mSM;
        TbImageView mSN;

        private a() {
        }
    }

    private a eh(View view) {
        a aVar = new a();
        aVar.mSL = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.mSM = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.mSN = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.mSN.setAutoChangeStyle(false);
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
