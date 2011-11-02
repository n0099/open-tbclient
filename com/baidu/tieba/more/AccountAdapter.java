package com.baidu.tieba.more;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<AccountData> mData = null;
    private boolean mEditState = false;
    private View.OnClickListener mListener;

    public AccountAdapter(Context context, View.OnClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    public void setData(ArrayList<AccountData> data) {
        this.mData = data;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int num = 0;
        if (this.mData != null) {
            num = this.mData.size();
        }
        return num + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (this.mData == null || position < 0 || position >= this.mData.size()) {
            return null;
        }
        Object obj = this.mData.get(position);
        return obj;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        if (getItem(position) != null) {
            return position;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Exception ex;
        ViewHolder holder = null;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                if (getItemViewType(position) == 0) {
                    convertView = mInflater.inflate(R.layout.account_item, (ViewGroup) null);
                    ViewHolder holder2 = new ViewHolder();
                    try {
                        holder2.mAccount = (TextView) convertView.findViewById(R.id.account);
                        holder2.mActive = (ImageView) convertView.findViewById(R.id.active);
                        holder2.mDelete = (Button) convertView.findViewById(R.id.delete);
                        holder2.mDelete.setOnClickListener(this.mListener);
                        convertView.setTag(holder2);
                        holder = holder2;
                    } catch (Exception e) {
                        ex = e;
                        TiebaLog.e(getClass().getName(), "getView", ex.getMessage());
                        return convertView;
                    }
                } else {
                    convertView = mInflater.inflate(R.layout.account_add_item, (ViewGroup) null);
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (getItemViewType(position) == 0) {
                AccountData account = (AccountData) getItem(position);
                holder.mActive.setVisibility(8);
                holder.mDelete.setVisibility(8);
                holder.mDelete.setTag(account);
                if (account != null) {
                    holder.mAccount.setText(account.getAccount());
                    if (account.getIsActive() == 1) {
                        holder.mActive.setVisibility(0);
                    }
                    if (this.mEditState) {
                        holder.mDelete.setVisibility(0);
                    }
                }
            }
        } catch (Exception e2) {
            ex = e2;
        }
        return convertView;
    }

    public void setEditState(boolean editState) {
        this.mEditState = editState;
    }

    public boolean getEditState() {
        return this.mEditState;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        if (getItemId(position) >= 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void setListener(View.OnClickListener listener) {
        this.mListener = listener;
    }

    public View.OnClickListener getListener() {
        return this.mListener;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mAccount;
        ImageView mActive;
        Button mDelete;

        private ViewHolder() {
        }
    }
}
