package com.baidu.tieba.personExtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
    private View.OnLongClickListener myM;

    public SmartAppBrowseHistoryAdapter(Context context) {
        this.mContext = context;
    }

    public void bn(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp Qv(String str) {
        if (y.isEmpty(this.mDataList)) {
            return null;
        }
        Iterator<SmartApp> it = this.mDataList.iterator();
        while (it.hasNext()) {
            SmartApp next = it.next();
            if (next != null && au.equals(next.id, str)) {
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
        this.myM = onLongClickListener;
    }

    private SmartApp GU(int i) {
        return (SmartApp) y.getItem(this.mDataList, i);
    }

    public void a(SmartApp smartApp) {
        SmartApp Qv = Qv(smartApp.id);
        if (Qv != null && this.mDataList != null) {
            y.add(this.mDataList, 0, Qv);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: Q */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HistoryRecordViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i) {
        SmartApp GU;
        if (historyRecordViewHolder != null && (GU = GU(i)) != null) {
            historyRecordViewHolder.b(GU);
            historyRecordViewHolder.setOnClickListener(this.mOnItemClickListener);
            historyRecordViewHolder.setOnLongClickListener(this.myM);
            historyRecordViewHolder.onChangeSkinType();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* loaded from: classes8.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {
        private HeadImageView kTz;
        private TextView mName;
        private View mRootView;
        private SmartApp myN;

        public HistoryRecordViewHolder(View view) {
            super(view);
            this.mRootView = view;
            this.kTz = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.kTz.setIsRound(true);
            this.kTz.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void b(SmartApp smartApp) {
            this.myN = smartApp;
            this.mRootView.setTag(smartApp);
            if (!au.isEmpty(smartApp.avatar)) {
                this.kTz.setPlaceHolder(1);
                this.kTz.startLoad(smartApp.avatar, 10, false, false);
            }
            if (!au.isEmpty(smartApp.name)) {
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
            ap.setBackgroundResource(this.mRootView, R.drawable.person_center_action_item_selector);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }
}
