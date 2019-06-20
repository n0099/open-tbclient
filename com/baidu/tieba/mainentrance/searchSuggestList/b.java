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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private String bol;
    private List<String> hfy;
    private Context mContext;

    public b(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.hfy = arrayList;
    }

    public void setData(List<String> list) {
        this.hfy = list;
        if (this.hfy != null) {
            notifyDataSetChanged();
        }
    }

    public void zz(String str) {
        if (!StringUtils.isNull(str)) {
            this.bol = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hfy == null) {
            return 0;
        }
        return this.hfy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hfy.get(i);
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
            aVar2.hfz = (TextView) view.findViewById(R.id.searchSuggestTitle);
            aVar2.bpR = view.findViewById(R.id.searchItemSep);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            a(aVar.hfz, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != aVar.mSkinType) {
                aVar.mSkinType = skinType;
                al.k(aVar.mRootView, R.drawable.addresslist_item_bg);
                al.j(aVar.hfz, R.color.cp_cont_b);
                al.l(aVar.bpR, R.color.cp_bg_line_c);
            }
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        View bpR;
        TextView hfz;
        View mRootView;
        int mSkinType;

        private a() {
            this.mSkinType = 3;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bol)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bol.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bol.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
