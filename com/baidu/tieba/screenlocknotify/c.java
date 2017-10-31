package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<e> fQR = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fQR != null) {
            return this.fQR.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sF */
    public e getItem(int i) {
        if (this.fQR == null || i >= this.fQR.size()) {
            return null;
        }
        return this.fQR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fQR.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bF;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bF = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            bF = bF(inflate);
            inflate.setTag(bF);
        }
        if (eVar == null) {
            return inflate;
        }
        bF.fQS.setText(eVar.title);
        bF.fQT.setText(eVar.content);
        bF.fQU.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bF.fQU.setDefaultResource(d.f.screen_notify_default_bg);
        bF.fQU.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void da(List<e> list) {
        if (list != null && list.size() != 0) {
            this.fQR.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TextView fQS;
        TextView fQT;
        TbImageView fQU;
        View mLine;

        private a() {
        }
    }

    private a bF(View view) {
        a aVar = new a();
        aVar.fQS = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.fQT = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.fQU = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.fQU.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(d.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
