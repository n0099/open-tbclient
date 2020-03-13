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
    private List<d> jPA = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jPA != null) {
            return this.jPA.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bo */
    public d getItem(int i) {
        if (this.jPA == null || i >= this.jPA.size()) {
            return null;
        }
        return this.jPA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.jPA.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cQ;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cQ = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cQ = cQ(inflate);
            inflate.setTag(cQ);
        }
        if (dVar == null) {
            return inflate;
        }
        cQ.jPB.setText(dVar.title);
        cQ.jPC.setText(dVar.content);
        cQ.jPD.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cQ.jPD.setDefaultResource(R.drawable.screen_notify_default_bg);
        cQ.jPD.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void ec(List<d> list) {
        if (list != null && list.size() != 0) {
            this.jPA.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TextView jPB;
        TextView jPC;
        TbImageView jPD;
        View mLine;

        private a() {
        }
    }

    private a cQ(View view) {
        a aVar = new a();
        aVar.jPB = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.jPC = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.jPD = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.jPD.setAutoChangeStyle(false);
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
