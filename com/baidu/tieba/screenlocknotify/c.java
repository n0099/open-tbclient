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
    private List<d> iOJ = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iOJ != null) {
            return this.iOJ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zV */
    public d getItem(int i) {
        if (this.iOJ == null || i >= this.iOJ.size()) {
            return null;
        }
        return this.iOJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.iOJ.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cP;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cP = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cP = cP(inflate);
            inflate.setTag(cP);
        }
        if (dVar == null) {
            return inflate;
        }
        cP.iOK.setText(dVar.title);
        cP.iOL.setText(dVar.content);
        cP.iOM.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cP.iOM.setDefaultResource(R.drawable.screen_notify_default_bg);
        cP.iOM.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void ec(List<d> list) {
        if (list != null && list.size() != 0) {
            this.iOJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView iOK;
        TextView iOL;
        TbImageView iOM;
        View mLine;

        private a() {
        }
    }

    private a cP(View view) {
        a aVar = new a();
        aVar.iOK = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.iOL = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.iOM = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.iOM.setAutoChangeStyle(false);
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
