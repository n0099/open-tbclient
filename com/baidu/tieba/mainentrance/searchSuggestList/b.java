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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class b extends BaseAdapter {
    private String drQ;
    private List<String> jHv;
    private Context mContext;

    public b(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.jHv = arrayList;
    }

    public void setData(List<String> list) {
        this.jHv = list;
        if (this.jHv != null) {
            notifyDataSetChanged();
        }
    }

    public void IX(String str) {
        if (!StringUtils.isNull(str)) {
            this.drQ = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jHv == null) {
            return 0;
        }
        return this.jHv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.jHv.get(i);
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
            aVar2.jHw = (TextView) view.findViewById(R.id.searchSuggestTitle);
            aVar2.dty = view.findViewById(R.id.searchItemSep);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            c(aVar.jHw, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != aVar.mSkinType) {
                aVar.mSkinType = skinType;
                ao.setBackgroundResource(aVar.mRootView, R.drawable.addresslist_item_bg);
                ao.setViewTextColor(aVar.jHw, R.color.cp_cont_b);
                ao.setBackgroundColor(aVar.dty, R.color.cp_bg_line_c);
            }
        }
        return view;
    }

    /* loaded from: classes18.dex */
    private class a {
        View dty;
        TextView jHw;
        View mRootView;
        int mSkinType;

        private a() {
            this.mSkinType = 3;
        }
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.drQ)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.drQ.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.drQ.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
