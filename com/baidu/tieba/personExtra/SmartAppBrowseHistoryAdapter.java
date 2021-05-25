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
    public Context f19810a;

    /* renamed from: b  reason: collision with root package name */
    public List<SmartApp> f19811b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f19812c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f19813d;

    /* loaded from: classes5.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f19814a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f19815b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19816c;

        public HistoryRecordViewHolder(View view) {
            super(view);
            this.f19814a = view;
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.f19815b = headImageView;
            headImageView.setIsRound(true);
            this.f19815b.setPlaceHolder(1);
            this.f19816c = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void a(SmartApp smartApp) {
            this.f19814a.setTag(smartApp);
            if (!k.isEmpty(smartApp.avatar)) {
                this.f19815b.setPlaceHolder(1);
                this.f19815b.W(smartApp.avatar, 10, false, false);
            }
            if (!k.isEmpty(smartApp.name)) {
                this.f19816c.setText(smartApp.name);
            } else {
                this.f19816c.setText(R.string.intelligent_smart_app);
            }
        }

        public void b() {
            SkinManager.setBackgroundResource(this.f19814a, R.drawable.person_center_action_item_selector);
            SkinManager.setViewTextColor(this.f19816c, R.color.CAM_X0105);
        }

        public void c(View.OnClickListener onClickListener) {
            View view = this.f19814a;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }

        public void d(View.OnLongClickListener onLongClickListener) {
            View view = this.f19814a;
            if (view != null) {
                view.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    public SmartAppBrowseHistoryAdapter(Context context) {
        this.f19810a = context;
    }

    public final SmartApp c(int i2) {
        return (SmartApp) ListUtils.getItem(this.f19811b, i2);
    }

    public void d(SmartApp smartApp) {
        List<SmartApp> list;
        SmartApp g2 = g(smartApp.id);
        if (g2 == null || (list = this.f19811b) == null) {
            return;
        }
        ListUtils.add(list, 0, g2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i2) {
        SmartApp c2;
        if (historyRecordViewHolder == null || (c2 = c(i2)) == null) {
            return;
        }
        historyRecordViewHolder.a(c2);
        historyRecordViewHolder.c(this.f19812c);
        historyRecordViewHolder.d(this.f19813d);
        historyRecordViewHolder.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new HistoryRecordViewHolder(LayoutInflater.from(this.f19810a).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    public SmartApp g(String str) {
        if (ListUtils.isEmpty(this.f19811b)) {
            return null;
        }
        Iterator<SmartApp> it = this.f19811b.iterator();
        while (it.hasNext()) {
            SmartApp next = it.next();
            if (next != null && StringHelper.equals(next.id, str)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f19811b);
    }

    public void h(List<SmartApp> list) {
        this.f19811b = list;
    }

    public void i(View.OnClickListener onClickListener) {
        this.f19812c = onClickListener;
    }

    public void j(View.OnLongClickListener onLongClickListener) {
        this.f19813d = onLongClickListener;
    }
}
