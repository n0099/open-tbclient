package com.baidu.tieba.pb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ContextMenuAdapter extends BaseAdapter {
    String[] mData;
    LayoutInflater mInflater;

    public ContextMenuAdapter(Context context, String[] data) {
        this.mInflater = null;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (this.mData == null || position < 0 || position >= getCount()) {
            return null;
        }
        return this.mData[position];
    }

    public void setItem(int position, String str) {
        if (this.mData != null && position >= 0 && position < getCount()) {
            this.mData[position] = str;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.mInflater.inflate(R.layout.context_menu_item, (ViewGroup) null);
        }
        TextView tx = (TextView) convertView;
        tx.setText(this.mData[position]);
        return convertView;
    }
}
