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
    private List<d> ncG = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ncG != null) {
            return this.ncG.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ip */
    public d getItem(int i) {
        if (this.ncG == null || i >= this.ncG.size()) {
            return null;
        }
        return this.ncG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.ncG.get(i), view, viewGroup);
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
        ef.ncH.setText(dVar.title);
        ef.ncI.setText(dVar.content);
        ef.ncJ.setDefaultResource(R.drawable.screen_notify_default_bg);
        ef.ncJ.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fP(List<d> list) {
        if (list != null && list.size() != 0) {
            this.ncG.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        View mLine;
        TextView ncH;
        TextView ncI;
        TbImageView ncJ;

        private a() {
        }
    }

    private a ef(View view) {
        a aVar = new a();
        aVar.ncH = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.ncI = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.ncJ = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.ncJ.setAutoChangeStyle(false);
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
