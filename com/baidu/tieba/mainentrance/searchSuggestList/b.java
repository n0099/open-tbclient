package com.baidu.tieba.mainentrance.searchSuggestList;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class b extends BaseAdapter {
    private String ejE;
    private List<String> laL;
    private Context mContext;

    public b(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.laL = arrayList;
    }

    public void setData(List<String> list) {
        this.laL = list;
        if (this.laL != null) {
            notifyDataSetChanged();
        }
    }

    public void OB(String str) {
        if (!StringUtils.isNull(str)) {
            this.ejE = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.laL == null) {
            return 0;
        }
        return this.laL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.laL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.mRootView = view.findViewById(R.id.rootview);
            aVar2.laM = (TextView) view.findViewById(R.id.searchSuggestTitle);
            aVar2.elk = view.findViewById(R.id.searchItemSep);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            d(aVar.laM, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != aVar.mSkinType) {
                aVar.mSkinType = skinType;
                ap.setBackgroundResource(aVar.mRootView, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(aVar.laM, R.color.CAM_X0105);
                ap.setBackgroundColor(aVar.elk, R.color.CAM_X0204);
            }
        }
        return view;
    }

    /* loaded from: classes24.dex */
    private class a {
        View elk;
        TextView laM;
        View mRootView;
        int mSkinType;

        private a() {
            this.mSkinType = 3;
        }
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.ejE)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.ejE.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.ejE.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
