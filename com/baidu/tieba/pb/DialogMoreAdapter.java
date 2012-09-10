package com.baidu.tieba.pb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.PbModel;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DialogMoreAdapter extends BaseAdapter {
    private Context mContext;
    private boolean mIsProgress;
    private PbModel mModel;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

    public DialogMoreAdapter(Context context, PbModel model) {
        this.mContext = context;
        this.mModel = model;
    }

    public void releaseProgressBar() {
        if (this.mProgressbars != null) {
            for (int i = 0; i < this.mProgressbars.size(); i++) {
                try {
                    this.mProgressbars.get(i).setVisibility(8);
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "releaseProgressBar", ex.getMessage());
                }
            }
            this.mProgressbars.clear();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.dialog_more_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder(this, null);
                try {
                    holder2.mText = (TextView) convertView.findViewById(R.id.text);
                    holder2.mNum = (TextView) convertView.findViewById(R.id.num);
                    holder2.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                    holder2.mImage = (ImageView) convertView.findViewById(R.id.image);
                    this.mProgressbars.add(holder2.mProgress);
                    convertView.setTag(holder2);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e("DialogMoreAdapter", "getView", "error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
        } catch (Exception e2) {
            ex = e2;
        }
        if (this.mModel == null) {
            return convertView;
        }
        holder.mText.setTextColor(-1);
        if (position == 0) {
            holder.mNum.setVisibility(8);
            holder.mProgress.setVisibility(8);
            if (!PbActivity.isAnonymityUser(this.mModel)) {
                holder.mText.setTextColor(-1);
            } else {
                holder.mText.setTextColor(-7960954);
            }
            holder.mText.setText(this.mContext.getString(R.string.view_host));
            if (this.mModel.getHostMode()) {
                holder.mImage.setVisibility(0);
            } else {
                holder.mImage.setVisibility(8);
            }
        } else if (position == 1) {
            holder.mNum.setVisibility(8);
            holder.mProgress.setVisibility(8);
            holder.mText.setText(this.mContext.getString(R.string.view_reverse));
            if (this.mModel.getSequence()) {
                holder.mImage.setVisibility(8);
            } else {
                holder.mImage.setVisibility(0);
            }
        }
        return convertView;
    }

    public void setIsProgress(boolean isProgress) {
        this.mIsProgress = isProgress;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        if (position != 0 || this.mModel.isCanTip()) {
            return (position == 1 && PbActivity.isAnonymityUser(this.mModel)) ? false : true;
        }
        return false;
    }

    public boolean isIsProgress() {
        return this.mIsProgress;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        ImageView mImage;
        TextView mNum;
        ProgressBar mProgress;
        TextView mText;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(DialogMoreAdapter dialogMoreAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
