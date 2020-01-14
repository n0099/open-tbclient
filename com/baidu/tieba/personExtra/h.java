package com.baidu.tieba.personExtra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class h extends RecyclerView.Adapter<a> {
    private View.OnLongClickListener jlf;
    private Context mContext;
    private List<SmartApp> mDataList;
    private View.OnClickListener mOnItemClickListener;

    public h(Context context) {
        this.mContext = context;
    }

    public void av(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp GC(String str) {
        if (v.isEmpty(this.mDataList)) {
            return null;
        }
        Iterator<SmartApp> it = this.mDataList.iterator();
        while (it.hasNext()) {
            SmartApp next = it.next();
            if (next != null && aq.equals(next.id, str)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public void V(View.OnClickListener onClickListener) {
        this.mOnItemClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.jlf = onLongClickListener;
    }

    private SmartApp zN(int i) {
        return (SmartApp) v.getItem(this.mDataList, i);
    }

    public void b(SmartApp smartApp) {
        SmartApp GC = GC(smartApp.id);
        if (GC != null && this.mDataList != null) {
            v.add(this.mDataList, 0, GC);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.smart_app_history_record_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        SmartApp zN;
        if (aVar != null && (zN = zN(i)) != null) {
            aVar.c(zN);
            aVar.setOnClickListener(this.mOnItemClickListener);
            aVar.setOnLongClickListener(this.jlf);
            aVar.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.getCount(this.mDataList);
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        private HeadImageView hOM;
        private SmartApp jlg;
        private TextView mName;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.hOM = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.hOM.setIsRound(true);
            this.hOM.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void c(SmartApp smartApp) {
            this.jlg = smartApp;
            this.mRootView.setTag(smartApp);
            if (!aq.isEmpty(smartApp.avatar)) {
                this.hOM.setPlaceHolder(1);
                this.hOM.startLoad(smartApp.avatar, 10, false, false);
            }
            if (!aq.isEmpty(smartApp.name)) {
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
            am.setBackgroundResource(this.mRootView, R.drawable.person_center_action_item_selector);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }
}
