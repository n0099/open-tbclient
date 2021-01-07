package com.baidu.tieba.personExtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {
    private Context mContext;
    private List<SmartApp> mDataList;
    private View.OnClickListener mOnItemClickListener;
    private View.OnLongClickListener mur;

    public SmartAppBrowseHistoryAdapter(Context context) {
        this.mContext = context;
    }

    public void bs(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp QL(String str) {
        if (x.isEmpty(this.mDataList)) {
            return null;
        }
        Iterator<SmartApp> it = this.mDataList.iterator();
        while (it.hasNext()) {
            SmartApp next = it.next();
            if (next != null && at.equals(next.id, str)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.mOnItemClickListener = onClickListener;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        this.mur = onLongClickListener;
    }

    private SmartApp Ij(int i) {
        return (SmartApp) x.getItem(this.mDataList, i);
    }

    public void a(SmartApp smartApp) {
        SmartApp QL = QL(smartApp.id);
        if (QL != null && this.mDataList != null) {
            x.add(this.mDataList, 0, QL);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: P */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HistoryRecordViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i) {
        SmartApp Ij;
        if (historyRecordViewHolder != null && (Ij = Ij(i)) != null) {
            historyRecordViewHolder.b(Ij);
            historyRecordViewHolder.setOnClickListener(this.mOnItemClickListener);
            historyRecordViewHolder.setOnLongClickListener(this.mur);
            historyRecordViewHolder.onChangeSkinType();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.mDataList);
    }

    /* loaded from: classes8.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {
        private HeadImageView kQb;
        private TextView mName;
        private View mRootView;
        private SmartApp mus;

        public HistoryRecordViewHolder(View view) {
            super(view);
            this.mRootView = view;
            this.kQb = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.kQb.setIsRound(true);
            this.kQb.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void b(SmartApp smartApp) {
            this.mus = smartApp;
            this.mRootView.setTag(smartApp);
            if (!at.isEmpty(smartApp.avatar)) {
                this.kQb.setPlaceHolder(1);
                this.kQb.startLoad(smartApp.avatar, 10, false, false);
            }
            if (!at.isEmpty(smartApp.name)) {
                this.mName.setText(smartApp.name);
            } else {
                this.mName.setText(R.string.intelligent_smart_app);
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(onClickListener);
            }
        }

        public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
            if (this.mRootView != null) {
                this.mRootView.setOnLongClickListener(onLongClickListener);
            }
        }

        public void onChangeSkinType() {
            ao.setBackgroundResource(this.mRootView, R.drawable.person_center_action_item_selector);
            ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }
}
