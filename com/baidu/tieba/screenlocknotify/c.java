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
    private List<d> mkW = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mkW != null) {
            return this.mkW.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: HK */
    public d getItem(int i) {
        if (this.mkW == null || i >= this.mkW.size()) {
            return null;
        }
        return this.mkW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.mkW.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a dw;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            dw = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            dw = dw(inflate);
            inflate.setTag(dw);
        }
        if (dVar == null) {
            return inflate;
        }
        dw.mkX.setText(dVar.title);
        dw.mkY.setText(dVar.content);
        dw.mkZ.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        dw.mkZ.setDefaultResource(R.drawable.screen_notify_default_bg);
        dw.mkZ.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fm(List<d> list) {
        if (list != null && list.size() != 0) {
            this.mkW.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a {
        View mLine;
        TextView mkX;
        TextView mkY;
        TbImageView mkZ;

        private a() {
        }
    }

    private a dw(View view) {
        a aVar = new a();
        aVar.mkX = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.mkY = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.mkZ = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.mkZ.setAutoChangeStyle(false);
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
