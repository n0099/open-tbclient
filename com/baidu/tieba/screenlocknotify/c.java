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
    private List<e> gKt = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gKt != null) {
            return this.gKt.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uF */
    public e getItem(int i) {
        if (this.gKt == null || i >= this.gKt.size()) {
            return null;
        }
        return this.gKt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gKt.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cM;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cM = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            cM = cM(inflate);
            inflate.setTag(cM);
        }
        if (eVar == null) {
            return inflate;
        }
        cM.gKu.setText(eVar.title);
        cM.gKv.setText(eVar.content);
        cM.gKw.setDefaultErrorResource(d.f.screen_notify_default_bg);
        cM.gKw.setDefaultResource(d.f.screen_notify_default_bg);
        cM.gKw.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dm(List<e> list) {
        if (list != null && list.size() != 0) {
            this.gKt.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TextView gKu;
        TextView gKv;
        TbImageView gKw;
        View mLine;

        private a() {
        }
    }

    private a cM(View view) {
        a aVar = new a();
        aVar.gKu = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.gKv = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.gKw = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.gKw.setAutoChangeStyle(false);
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
