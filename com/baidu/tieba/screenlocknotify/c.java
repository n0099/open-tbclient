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
    private List<e> fIr = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fIr != null) {
            return this.fIr.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: so */
    public e getItem(int i) {
        if (this.fIr == null || i >= this.fIr.size()) {
            return null;
        }
        return this.fIr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fIr.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bB;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bB = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.j.screenlock_show_item_view_4, viewGroup, false);
            bB = bB(inflate);
            inflate.setTag(bB);
        }
        if (eVar == null) {
            return inflate;
        }
        bB.fIs.setText(eVar.title);
        bB.fIt.setText(eVar.content);
        bB.fIu.setDefaultErrorResource(d.g.screen_notify_default_bg);
        bB.fIu.setDefaultResource(d.g.screen_notify_default_bg);
        bB.fIu.a(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cY(List<e> list) {
        if (list != null && list.size() != 0) {
            this.fIr.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View aYL;
        TextView fIs;
        TextView fIt;
        TbImageView fIu;

        private a() {
        }
    }

    private a bB(View view) {
        a aVar = new a();
        aVar.fIs = (TextView) view.findViewById(d.h.push_msg_title);
        aVar.fIt = (TextView) view.findViewById(d.h.push_msg_content);
        aVar.fIu = (TbImageView) view.findViewById(d.h.push_msg_pic);
        aVar.fIu.setAutoChangeStyle(false);
        aVar.aYL = view.findViewById(d.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
