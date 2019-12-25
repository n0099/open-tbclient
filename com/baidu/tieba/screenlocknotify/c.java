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
/* loaded from: classes5.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> jKJ = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jKJ != null) {
            return this.jKJ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ba */
    public d getItem(int i) {
        if (this.jKJ == null || i >= this.jKJ.size()) {
            return null;
        }
        return this.jKJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.jKJ.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cI;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cI = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cI = cI(inflate);
            inflate.setTag(cI);
        }
        if (dVar == null) {
            return inflate;
        }
        cI.jKK.setText(dVar.title);
        cI.jKL.setText(dVar.content);
        cI.jKM.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cI.jKM.setDefaultResource(R.drawable.screen_notify_default_bg);
        cI.jKM.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eg(List<d> list) {
        if (list != null && list.size() != 0) {
            this.jKJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {
        TextView jKK;
        TextView jKL;
        TbImageView jKM;
        View mLine;

        private a() {
        }
    }

    private a cI(View view) {
        a aVar = new a();
        aVar.jKK = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.jKL = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.jKM = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.jKM.setAutoChangeStyle(false);
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
