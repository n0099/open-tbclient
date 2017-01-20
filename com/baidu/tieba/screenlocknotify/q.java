package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<s> fai = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fai != null) {
            return this.fai.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ra */
    public s getItem(int i) {
        if (this.fai == null || i >= this.fai.size()) {
            return null;
        }
        return this.fai.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fai.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bo;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bo = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(r.j.screenlock_show_item_view_4, viewGroup, false);
            bo = bo(inflate);
            inflate.setTag(bo);
        }
        if (sVar == null) {
            return inflate;
        }
        bo.faj.setText(sVar.title);
        bo.fak.setText(sVar.content);
        bo.fal.setDefaultErrorResource(r.g.screen_notify_default_bg);
        bo.fal.setDefaultResource(r.g.screen_notify_default_bg);
        bo.fal.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cV(List<s> list) {
        if (list != null && list.size() != 0) {
            this.fai.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View ame;
        TextView faj;
        TextView fak;
        TbImageView fal;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bo(View view) {
        a aVar = new a(this, null);
        aVar.faj = (TextView) view.findViewById(r.h.push_msg_title);
        aVar.fak = (TextView) view.findViewById(r.h.push_msg_content);
        aVar.fal = (TbImageView) view.findViewById(r.h.push_msg_pic);
        aVar.fal.setAutoChangeStyle(false);
        aVar.ame = view.findViewById(r.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
