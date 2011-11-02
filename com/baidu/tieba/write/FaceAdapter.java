package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.FaceHelper;
import com.baidu.tieba.util.UtilHelper;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FaceAdapter extends BaseAdapter {
    private Context mContext;
    private HashMap<String, Integer> mFace = FaceHelper.getWriteFace();
    private ArrayList<Integer> mFaceList = FaceHelper.getWriteFaceList();
    private HashMap<Integer, SoftReference<Bitmap>> mSoftBitmap = new HashMap<>();

    public FaceAdapter(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mFaceList != null) {
            return this.mFaceList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        SoftReference<Bitmap> soft;
        int resId = this.mFaceList.get(position).intValue();
        Integer key = this.mFace.get(Integer.valueOf(resId));
        Bitmap bm = null;
        if (key != null && (soft = this.mSoftBitmap.get(key)) != null) {
            bm = soft.get();
        }
        if (bm == null && (bm = BitmapHelper.getResBitmap(this.mContext, resId)) != null && key != null) {
            SoftReference<Bitmap> soft2 = new SoftReference<>(bm);
            this.mSoftBitmap.put(key, soft2);
        }
        return bm;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view;
        if (convertView == null) {
            view = new ImageView(this.mContext);
            view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int px = UtilHelper.dip2px(this.mContext, 50.0f);
            view.setLayoutParams(new AbsListView.LayoutParams(px, px));
            convertView = view;
        } else {
            view = (ImageView) convertView;
        }
        view.setFocusable(false);
        view.setImageBitmap((Bitmap) getItem(position));
        return convertView;
    }

    public String getName(int position) {
        int key = this.mFaceList.get(position).intValue();
        for (Map.Entry<String, Integer> entry : this.mFace.entrySet()) {
            if (entry.getValue().intValue() == key) {
                return entry.getKey();
            }
        }
        return null;
    }
}
