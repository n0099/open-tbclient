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
import d.b.c.e.p.k;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20089a;

    /* renamed from: b  reason: collision with root package name */
    public List<SmartApp> f20090b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f20091c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f20092d;

    /* loaded from: classes3.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f20093a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f20094b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20095c;

        public HistoryRecordViewHolder(View view) {
            super(view);
            this.f20093a = view;
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.f20094b = headImageView;
            headImageView.setIsRound(true);
            this.f20094b.setPlaceHolder(1);
            this.f20095c = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void a(SmartApp smartApp) {
            this.f20093a.setTag(smartApp);
            if (!k.isEmpty(smartApp.avatar)) {
                this.f20094b.setPlaceHolder(1);
                this.f20094b.X(smartApp.avatar, 10, false, false);
            }
            if (!k.isEmpty(smartApp.name)) {
                this.f20095c.setText(smartApp.name);
            } else {
                this.f20095c.setText(R.string.intelligent_smart_app);
            }
        }

        public void b() {
            SkinManager.setBackgroundResource(this.f20093a, R.drawable.person_center_action_item_selector);
            SkinManager.setViewTextColor(this.f20095c, R.color.CAM_X0105);
        }

        public void c(View.OnClickListener onClickListener) {
            View view = this.f20093a;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }

        public void d(View.OnLongClickListener onLongClickListener) {
            View view = this.f20093a;
            if (view != null) {
                view.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    public SmartAppBrowseHistoryAdapter(Context context) {
        this.f20089a = context;
    }

    public final SmartApp g(int i) {
        return (SmartApp) ListUtils.getItem(this.f20090b, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f20090b);
    }

    public void h(SmartApp smartApp) {
        List<SmartApp> list;
        SmartApp k = k(smartApp.id);
        if (k == null || (list = this.f20090b) == null) {
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
        historyRecordViewHolder.c(this.f20091c);
        historyRecordViewHolder.d(this.f20092d);
        historyRecordViewHolder.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HistoryRecordViewHolder(LayoutInflater.from(this.f20089a).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    public SmartApp k(String str) {
        if (ListUtils.isEmpty(this.f20090b)) {
            return null;
        }
        Iterator<SmartApp> it = this.f20090b.iterator();
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
        this.f20090b = list;
    }

    public void m(View.OnClickListener onClickListener) {
        this.f20091c = onClickListener;
    }

    public void n(View.OnLongClickListener onLongClickListener) {
        this.f20092d = onLongClickListener;
    }
}
