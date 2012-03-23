package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.model.BarlistModel;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class EditBarAdapter extends BaseAdapter {
    private Context mContext;
    private BarlistModel mData;

    public EditBarAdapter(Context context, BarlistModel data) {
        this.mContext = context;
        this.mData = data;
    }

    public void setData(BarlistModel data) {
        this.mData = data;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null || this.mData.getForum_list() == null) {
            return 0;
        }
        return this.mData.getForum_list().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (this.mData == null || this.mData.getForum_list() == null || position < 0 || position >= this.mData.getForum_list().size()) {
            return null;
        }
        return this.mData.getForum_list().get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        ForumData data;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.edit_bar_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder(this, null);
                try {
                    holder2.mName = (TextView) convertView.findViewById(R.id.name);
                    holder2.mNameText = new StringBuffer(10);
                    holder2.mDegree = (TextView) convertView.findViewById(R.id.degree);
                    holder2.mDegreeText = new StringBuffer(10);
                    convertView.setTag(holder2);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "getView", ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (this.mData != null && this.mData.getForum_list() != null && position >= 0 && position < this.mData.getForum_list().size() && (data = this.mData.getForum_list().get(position)) != null) {
                holder.mNameText.delete(0, holder.mNameText.length());
                holder.mNameText.append(data.getName());
                holder.mNameText.append(this.mContext.getString(R.string.bar));
                holder.mName.setText(holder.mNameText);
                if (data.isIs_like() == 1) {
                    holder.mDegreeText.delete(0, holder.mDegreeText.length());
                    holder.mDegreeText.append(this.mContext.getString(R.string.degree));
                    holder.mDegreeText.append(data.getUser_level());
                    holder.mDegree.setText(holder.mDegreeText);
                    holder.mDegree.setVisibility(0);
                } else {
                    holder.mDegree.setVisibility(8);
                }
            }
        } catch (Exception e2) {
            ex = e2;
        }
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mDegree;
        StringBuffer mDegreeText;
        TextView mName;
        StringBuffer mNameText;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(EditBarAdapter editBarAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
