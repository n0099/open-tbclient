package com.baidu.tieba.personExtra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes11.dex */
public class h extends RecyclerView.Adapter<a> {
    private View.OnLongClickListener kLb;
    private Context mContext;
    private List<SmartApp> mDataList;
    private View.OnClickListener mOnItemClickListener;

    public h(Context context) {
        this.mContext = context;
    }

    public void aD(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp KP(String str) {
        if (w.isEmpty(this.mDataList)) {
            return null;
        }
        Iterator<SmartApp> it = this.mDataList.iterator();
        while (it.hasNext()) {
            SmartApp next = it.next();
            if (next != null && ar.equals(next.id, str)) {
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
        this.kLb = onLongClickListener;
    }

    private SmartApp Cs(int i) {
        return (SmartApp) w.getItem(this.mDataList, i);
    }

    public void a(SmartApp smartApp) {
        SmartApp KP = KP(smartApp.id);
        if (KP != null && this.mDataList != null) {
            w.add(this.mDataList, 0, KP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: G */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        SmartApp Cs;
        if (aVar != null && (Cs = Cs(i)) != null) {
            aVar.b(Cs);
            aVar.setOnClickListener(this.mOnItemClickListener);
            aVar.setOnLongClickListener(this.kLb);
            aVar.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.getCount(this.mDataList);
    }

    /* loaded from: classes11.dex */
    public static class a extends RecyclerView.ViewHolder {
        private HeadImageView jji;
        private SmartApp kLc;
        private TextView mName;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.jji = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.jji.setIsRound(true);
            this.jji.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void b(SmartApp smartApp) {
            this.kLc = smartApp;
            this.mRootView.setTag(smartApp);
            if (!ar.isEmpty(smartApp.avatar)) {
                this.jji.setPlaceHolder(1);
                this.jji.startLoad(smartApp.avatar, 10, false, false);
            }
            if (!ar.isEmpty(smartApp.name)) {
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
            an.setBackgroundResource(this.mRootView, R.drawable.person_center_action_item_selector);
            an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }
}
