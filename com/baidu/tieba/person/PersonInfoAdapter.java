package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.PersonInfoModel;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class PersonInfoAdapter extends BaseAdapter {
    private Context mContext;
    private PersonInfoModel mData;

    public PersonInfoAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(PersonInfoModel data) {
        this.mData = data;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            if (this.mData.getIsSelf()) {
                return 4;
            }
            return 3;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        if (this.mData != null) {
            if (this.mData.getIsSelf()) {
                return position;
            }
            if (position > 0) {
                return position + 1;
            }
            return position;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Exception ex;
        ViewHolder holder;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.person_info_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder();
                try {
                    holder2.mText = (TextView) convertView.findViewById(R.id.text);
                    holder2.mNum = (TextView) convertView.findViewById(R.id.num);
                    holder2.mImage = (ImageView) convertView.findViewById(R.id.icon);
                    holder2.mNotify_fans = (TextView) convertView.findViewById(R.id.notify_num);
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
        } catch (Exception e2) {
            ex = e2;
        }
        if (this.mData == null) {
            return convertView;
        }
        holder.mNotify_fans.setVisibility(8);
        long id = getItemId(position);
        if (id == 0) {
            if (this.mData.getIsSelf()) {
                holder.mText.setText(R.string.my_bar);
            } else {
                holder.mText.setText(R.string.hisbars);
            }
        } else if (id == 1) {
            holder.mText.setText(R.string.my_mark);
        } else if (id == 2) {
            holder.mText.setText(R.string.attention);
        } else if (id == 3) {
            holder.mText.setText(R.string.fans);
        }
        if (this.mData.getUser() != null) {
            StringBuffer strbuff = new StringBuffer(10);
            strbuff.append("(");
            if (id == 0) {
                strbuff.append(String.valueOf(this.mData.getUser().getLike_bars()));
            } else if (id == 1) {
                strbuff.append(String.valueOf(this.mData.getMark()));
            } else if (id == 2) {
                strbuff.append(String.valueOf(this.mData.getUser().getConcern_num()));
            } else if (id == 3) {
                if (this.mData.getNotify_fans() > 0) {
                    holder.mNotify_fans.setVisibility(0);
                    holder.mNotify_fans.setText(String.valueOf(this.mData.getNotify_fans()));
                }
                strbuff.append(String.valueOf(this.mData.getUser().getFans_num()));
            }
            strbuff.append(")");
            holder.mNum.setText(strbuff.toString());
        }
        if (this.mData.getIsSelf()) {
            holder.mImage.setVisibility(0);
        } else {
            holder.mImage.setVisibility(8);
        }
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        if (this.mData != null && this.mData.getIsSelf()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        ImageView mImage;
        TextView mNotify_fans;
        TextView mNum;
        TextView mText;

        private ViewHolder() {
        }
    }
}
