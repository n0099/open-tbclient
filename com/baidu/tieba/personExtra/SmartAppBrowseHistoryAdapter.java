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
import d.a.c.e.p.k;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f19887a;

    /* renamed from: b  reason: collision with root package name */
    public List<SmartApp> f19888b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f19889c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f19890d;

    /* loaded from: classes5.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f19891a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f19892b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19893c;

        public HistoryRecordViewHolder(View view) {
            super(view);
            this.f19891a = view;
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.f19892b = headImageView;
            headImageView.setIsRound(true);
            this.f19892b.setPlaceHolder(1);
            this.f19893c = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void a(SmartApp smartApp) {
            this.f19891a.setTag(smartApp);
            if (!k.isEmpty(smartApp.avatar)) {
                this.f19892b.setPlaceHolder(1);
                this.f19892b.V(smartApp.avatar, 10, false, false);
            }
            if (!k.isEmpty(smartApp.name)) {
                this.f19893c.setText(smartApp.name);
            } else {
                this.f19893c.setText(R.string.intelligent_smart_app);
            }
        }

        public void b() {
            SkinManager.setBackgroundResource(this.f19891a, R.drawable.person_center_action_item_selector);
            SkinManager.setViewTextColor(this.f19893c, R.color.CAM_X0105);
        }

        public void c(View.OnClickListener onClickListener) {
            View view = this.f19891a;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }

        public void d(View.OnLongClickListener onLongClickListener) {
            View view = this.f19891a;
            if (view != null) {
                view.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    public SmartAppBrowseHistoryAdapter(Context context) {
        this.f19887a = context;
    }

    public final SmartApp g(int i2) {
        return (SmartApp) ListUtils.getItem(this.f19888b, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f19888b);
    }

    public void h(SmartApp smartApp) {
        List<SmartApp> list;
        SmartApp k = k(smartApp.id);
        if (k == null || (list = this.f19888b) == null) {
            return;
        }
        ListUtils.add(list, 0, k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i2) {
        SmartApp g2;
        if (historyRecordViewHolder == null || (g2 = g(i2)) == null) {
            return;
        }
        historyRecordViewHolder.a(g2);
        historyRecordViewHolder.c(this.f19889c);
        historyRecordViewHolder.d(this.f19890d);
        historyRecordViewHolder.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new HistoryRecordViewHolder(LayoutInflater.from(this.f19887a).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    public SmartApp k(String str) {
        if (ListUtils.isEmpty(this.f19888b)) {
            return null;
        }
        Iterator<SmartApp> it = this.f19888b.iterator();
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
        this.f19888b = list;
    }

    public void m(View.OnClickListener onClickListener) {
        this.f19889c = onClickListener;
    }

    public void n(View.OnLongClickListener onLongClickListener) {
        this.f19890d = onLongClickListener;
    }
}
