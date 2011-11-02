package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtListAdapter extends BaseAdapter {
    private Context mContext;
    private AsyncImageLoader mImageLoader;
    private ArrayList<MetaData> mData = null;
    private boolean mHasMore = false;
    private boolean mIsProcessMore = false;
    private ArrayList<ProgressBar> mProgressbars = new ArrayList<>();

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

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.mHasMore = hasMore;
    }

    public boolean getIsProcessMore() {
        return this.mIsProcessMore;
    }

    public void setisProcessMore(boolean isProcessMore) {
        this.mIsProcessMore = isProcessMore;
    }

    public AtListAdapter(Context context) {
        this.mContext = null;
        this.mImageLoader = null;
        this.mContext = context;
        this.mImageLoader = new AsyncImageLoader(this.mContext);
    }

    public AsyncImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public void setData(ArrayList<MetaData> data) {
        this.mData = data;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int num = 0;
        if (this.mData != null) {
            num = this.mData.size();
        }
        if (this.mHasMore) {
            return num + 1;
        }
        return num;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (this.mData == null || position >= this.mData.size()) {
            return null;
        }
        Object obj = this.mData.get(position);
        return obj;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        if (this.mData == null || position >= this.mData.size()) {
            return -1L;
        }
        long id = position;
        return id;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (this.mData == null) {
            return convertView;
        }
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(this.mContext);
            holder = new ViewHolder();
            if (getItemViewType(position) == 0) {
                convertView = mInflater.inflate(R.layout.at_list_item, (ViewGroup) null);
                holder.mPhoto = (ImageView) convertView.findViewById(R.id.photo);
                holder.mName = (TextView) convertView.findViewById(R.id.name);
            } else {
                convertView = mInflater.inflate(R.layout.page_item, (ViewGroup) null);
                holder.mName = (TextView) convertView.findViewById(R.id.page_text);
                holder.mProgress = (ProgressBar) convertView.findViewById(R.id.progress);
                this.mProgressbars.add(holder.mProgress);
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (getItemViewType(position) == 0) {
            String portrait = this.mData.get(position).getPortrait();
            Bitmap bm = this.mImageLoader.getPhoto(portrait);
            if (bm != null) {
                holder.mPhoto.setTag(null);
                holder.mPhoto.setImageBitmap(bm);
            } else {
                holder.mPhoto.setTag(portrait);
                holder.mPhoto.setImageResource(R.drawable.photo);
            }
            holder.mName.setText(this.mData.get(position).getName_show());
        } else if (this.mIsProcessMore) {
            holder.mName.setText(this.mContext.getString(R.string.loading));
            holder.mProgress.setVisibility(0);
        } else {
            holder.mName.setText(this.mContext.getString(R.string.load_more));
            holder.mProgress.setVisibility(8);
        }
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return (this.mData == null || position >= this.mData.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mName;
        ImageView mPhoto;
        ProgressBar mProgress;

        private ViewHolder() {
        }
    }
}
