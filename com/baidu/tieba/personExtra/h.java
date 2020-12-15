package com.baidu.tieba.personExtra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes24.dex */
public class h extends RecyclerView.Adapter<a> {
    private Context mContext;
    private List<SmartApp> mDataList;
    private View.OnClickListener mOnItemClickListener;
    private View.OnLongClickListener mpf;

    public h(Context context) {
        this.mContext = context;
    }

    public void bl(List<SmartApp> list) {
        this.mDataList = list;
    }

    public SmartApp Rg(String str) {
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
        this.mpf = onLongClickListener;
    }

    private SmartApp Ip(int i) {
        return (SmartApp) y.getItem(this.mDataList, i);
    }

    public void a(SmartApp smartApp) {
        SmartApp Rg = Rg(smartApp.id);
        if (Rg != null && this.mDataList != null) {
            y.add(this.mDataList, 0, Rg);
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
        SmartApp Ip;
        if (aVar != null && (Ip = Ip(i)) != null) {
            aVar.b(Ip);
            aVar.setOnClickListener(this.mOnItemClickListener);
            aVar.setOnLongClickListener(this.mpf);
            aVar.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* loaded from: classes24.dex */
    public static class a extends RecyclerView.ViewHolder {
        private HeadImageView kKS;
        private TextView mName;
        private View mRootView;
        private SmartApp mpg;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.kKS = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.kKS.setIsRound(true);
            this.kKS.setPlaceHolder(1);
            this.mName = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void b(SmartApp smartApp) {
            this.mpg = smartApp;
            this.mRootView.setTag(smartApp);
            if (!au.isEmpty(smartApp.avatar)) {
                this.kKS.setPlaceHolder(1);
                this.kKS.startLoad(smartApp.avatar, 10, false, false);
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
            ap.setViewTextColor(this.mName, (int) R.color.CAM_X0105);
        }
    }
}
