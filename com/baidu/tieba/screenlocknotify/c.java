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
    private List<d> iIr = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iIr != null) {
            return this.iIr.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zp */
    public d getItem(int i) {
        if (this.iIr == null || i >= this.iIr.size()) {
            return null;
        }
        return this.iIr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.iIr.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cM;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cM = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cM = cM(inflate);
            inflate.setTag(cM);
        }
        if (dVar == null) {
            return inflate;
        }
        cM.iIs.setText(dVar.title);
        cM.iIt.setText(dVar.content);
        cM.iIu.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cM.iIu.setDefaultResource(R.drawable.screen_notify_default_bg);
        cM.iIu.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void ea(List<d> list) {
        if (list != null && list.size() != 0) {
            this.iIr.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView iIs;
        TextView iIt;
        TbImageView iIu;
        View mLine;

        private a() {
        }
    }

    private a cM(View view) {
        a aVar = new a();
        aVar.iIs = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.iIt = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.iIu = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.iIu.setAutoChangeStyle(false);
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
