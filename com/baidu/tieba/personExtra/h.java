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
/* loaded from: classes18.dex */
public class h extends RecyclerView.Adapter<a> {
    private View.OnLongClickListener ljU;
    private Context mContext;
    private List<SmartApp> mDataList;
    private View.OnClickListener mOnItemClickListener;

    public h(Context context) {
        this.mContext = context;
    }

    public void aK(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp Ow(String str) {
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
        this.ljU = onLongClickListener;
    }

    private SmartApp Fn(int i) {
        return (SmartApp) y.getItem(this.mDataList, i);
    }

    public void a(SmartApp smartApp) {
        SmartApp Ow = Ow(smartApp.id);
        if (Ow != null && this.mDataList != null) {
            y.add(this.mDataList, 0, Ow);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: H */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        SmartApp Fn;
        if (aVar != null && (Fn = Fn(i)) != null) {
            aVar.b(Fn);
            aVar.setOnClickListener(this.mOnItemClickListener);
            aVar.setOnLongClickListener(this.ljU);
            aVar.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* loaded from: classes18.dex */
    public static class a extends RecyclerView.ViewHolder {
        private HeadImageView jGM;
        private SmartApp ljV;
        private TextView mName;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.jGM = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.jGM.setIsRound(true);
            this.jGM.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void b(SmartApp smartApp) {
            this.ljV = smartApp;
            this.mRootView.setTag(smartApp);
            if (!at.isEmpty(smartApp.avatar)) {
                this.jGM.setPlaceHolder(1);
                this.jGM.startLoad(smartApp.avatar, 10, false, false);
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
