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
/* loaded from: classes7.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {
    private View.OnLongClickListener mBd;
    private Context mContext;
    private List<SmartApp> mDataList;
    private View.OnClickListener mOnItemClickListener;

    public SmartAppBrowseHistoryAdapter(Context context) {
        this.mContext = context;
    }

    public void bn(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp QC(String str) {
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
        this.mBd = onLongClickListener;
    }

    private SmartApp GX(int i) {
        return (SmartApp) y.getItem(this.mDataList, i);
    }

    public void a(SmartApp smartApp) {
        SmartApp QC = QC(smartApp.id);
        if (QC != null && this.mDataList != null) {
            y.add(this.mDataList, 0, QC);
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
        SmartApp GX;
        if (historyRecordViewHolder != null && (GX = GX(i)) != null) {
            historyRecordViewHolder.b(GX);
            historyRecordViewHolder.setOnClickListener(this.mOnItemClickListener);
            historyRecordViewHolder.setOnLongClickListener(this.mBd);
            historyRecordViewHolder.onChangeSkinType();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* loaded from: classes7.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {
        private HeadImageView kVP;
        private SmartApp mBe;
        private TextView mName;
        private View mRootView;

        public HistoryRecordViewHolder(View view) {
            super(view);
            this.mRootView = view;
            this.kVP = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.kVP.setIsRound(true);
            this.kVP.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void b(SmartApp smartApp) {
            this.mBe = smartApp;
            this.mRootView.setTag(smartApp);
            if (!au.isEmpty(smartApp.avatar)) {
                this.kVP.setPlaceHolder(1);
                this.kVP.startLoad(smartApp.avatar, 10, false, false);
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
