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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private String bHr;
    private List<String> hmu;
    private Context mContext;

    public b(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.hmu = arrayList;
    }

    public void setData(List<String> list) {
        this.hmu = list;
        if (this.hmu != null) {
            notifyDataSetChanged();
        }
    }

    public void ze(String str) {
        if (!StringUtils.isNull(str)) {
            this.bHr = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmu == null) {
            return 0;
        }
        return this.hmu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hmu.get(i);
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
            aVar2.hmv = (TextView) view.findViewById(R.id.searchSuggestTitle);
            aVar2.bIW = view.findViewById(R.id.searchItemSep);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            b(aVar.hmv, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != aVar.mSkinType) {
                aVar.mSkinType = skinType;
                am.setBackgroundResource(aVar.mRootView, R.drawable.addresslist_item_bg);
                am.setViewTextColor(aVar.hmv, (int) R.color.cp_cont_b);
                am.setBackgroundColor(aVar.bIW, R.color.cp_bg_line_c);
            }
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        View bIW;
        TextView hmv;
        View mRootView;
        int mSkinType;

        private a() {
            this.mSkinType = 3;
        }
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bHr)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bHr.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bHr.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
