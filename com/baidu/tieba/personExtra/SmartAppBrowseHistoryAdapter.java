package com.baidu.tieba.personExtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20388a;

    /* renamed from: b  reason: collision with root package name */
    public List<SmartApp> f20389b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f20390c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f20391d;

    /* loaded from: classes5.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f20392a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f20393b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20394c;

        public HistoryRecordViewHolder(View view) {
            super(view);
            this.f20392a = view;
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.f20393b = headImageView;
            headImageView.setIsRound(true);
            this.f20393b.setPlaceHolder(1);
            this.f20394c = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void a(SmartApp smartApp) {
            this.f20392a.setTag(smartApp);
            if (!k.isEmpty(smartApp.avatar)) {
                this.f20393b.setPlaceHolder(1);
                this.f20393b.X(smartApp.avatar, 10, false, false);
            }
            if (!k.isEmpty(smartApp.name)) {
                this.f20394c.setText(smartApp.name);
            } else {
                this.f20394c.setText(R.string.intelligent_smart_app);
            }
        }

        public void b() {
            SkinManager.setBackgroundResource(this.f20392a, R.drawable.person_center_action_item_selector);
            SkinManager.setViewTextColor(this.f20394c, R.color.CAM_X0105);
        }

        public void c(View.OnClickListener onClickListener) {
            View view = this.f20392a;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }

        public void d(View.OnLongClickListener onLongClickListener) {
            View view = this.f20392a;
            if (view != null) {
                view.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    public SmartAppBrowseHistoryAdapter(Context context) {
        this.f20388a = context;
    }

    public final SmartApp g(int i) {
        return (SmartApp) ListUtils.getItem(this.f20389b, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f20389b);
    }

    public void h(SmartApp smartApp) {
        List<SmartApp> list;
        SmartApp k = k(smartApp.id);
        if (k == null || (list = this.f20389b) == null) {
            return;
        }
        ListUtils.add(list, 0, k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i) {
        SmartApp g2;
        if (historyRecordViewHolder == null || (g2 = g(i)) == null) {
            return;
        }
        historyRecordViewHolder.a(g2);
        historyRecordViewHolder.c(this.f20390c);
        historyRecordViewHolder.d(this.f20391d);
        historyRecordViewHolder.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HistoryRecordViewHolder(LayoutInflater.from(this.f20388a).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    public SmartApp k(String str) {
        if (ListUtils.isEmpty(this.f20389b)) {
            return null;
        }
        Iterator<SmartApp> it = this.f20389b.iterator();
        while (it.hasNext()) {
            SmartApp next = it.next();
            if (next != null && StringHelper.equals(next.id, str)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public void l(List<SmartApp> list) {
        this.f20389b = list;
    }

    public void m(View.OnClickListener onClickListener) {
        this.f20390c = onClickListener;
    }

    public void n(View.OnLongClickListener onLongClickListener) {
        this.f20391d = onLongClickListener;
    }
}
