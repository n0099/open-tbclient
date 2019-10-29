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
    private List<d> iRh = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iRh != null) {
            return this.iRh.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yG */
    public d getItem(int i) {
        if (this.iRh == null || i >= this.iRh.size()) {
            return null;
        }
        return this.iRh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.iRh.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cN;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cN = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cN = cN(inflate);
            inflate.setTag(cN);
        }
        if (dVar == null) {
            return inflate;
        }
        cN.iRi.setText(dVar.title);
        cN.iRj.setText(dVar.content);
        cN.iRk.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cN.iRk.setDefaultResource(R.drawable.screen_notify_default_bg);
        cN.iRk.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eo(List<d> list) {
        if (list != null && list.size() != 0) {
            this.iRh.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView iRi;
        TextView iRj;
        TbImageView iRk;
        View mLine;

        private a() {
        }
    }

    private a cN(View view) {
        a aVar = new a();
        aVar.iRi = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.iRj = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.iRk = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.iRk.setAutoChangeStyle(false);
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
