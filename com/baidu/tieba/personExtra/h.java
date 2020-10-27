package com.baidu.tieba.personExtra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes24.dex */
public class h extends RecyclerView.Adapter<a> {
    private View.OnLongClickListener lUG;
    private Context mContext;
    private List<SmartApp> mDataList;
    private View.OnClickListener mOnItemClickListener;

    public h(Context context) {
        this.mContext = context;
    }

    public void bb(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp Ql(String str) {
        if (y.isEmpty(this.mDataList)) {
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
        this.lUG = onLongClickListener;
    }

    private SmartApp GN(int i) {
        return (SmartApp) y.getItem(this.mDataList, i);
    }

    public void a(SmartApp smartApp) {
        SmartApp Ql = Ql(smartApp.id);
        if (Ql != null && this.mDataList != null) {
            y.add(this.mDataList, 0, Ql);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: L */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        SmartApp GN;
        if (aVar != null && (GN = GN(i)) != null) {
            aVar.b(GN);
            aVar.setOnClickListener(this.mOnItemClickListener);
            aVar.setOnLongClickListener(this.lUG);
            aVar.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* loaded from: classes24.dex */
    public static class a extends RecyclerView.ViewHolder {
        private HeadImageView kqR;
        private SmartApp lUH;
        private TextView mName;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.kqR = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.kqR.setIsRound(true);
            this.kqR.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void b(SmartApp smartApp) {
            this.lUH = smartApp;
            this.mRootView.setTag(smartApp);
            if (!at.isEmpty(smartApp.avatar)) {
                this.kqR.setPlaceHolder(1);
                this.kqR.startLoad(smartApp.avatar, 10, false, false);
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
            ap.setBackgroundResource(this.mRootView, R.drawable.person_center_action_item_selector);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        }
    }
}
