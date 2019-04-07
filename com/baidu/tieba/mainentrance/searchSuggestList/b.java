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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private String bih;
    private List<String> gOb;
    private Context mContext;

    public b(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.gOb = arrayList;
    }

    public void setData(List<String> list) {
        this.gOb = list;
        if (this.gOb != null) {
            notifyDataSetChanged();
        }
    }

    public void yh(String str) {
        if (!StringUtils.isNull(str)) {
            this.bih = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gOb == null) {
            return 0;
        }
        return this.gOb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.gOb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.search_suggest_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.mRootView = view.findViewById(d.g.rootview);
            aVar2.gOc = (TextView) view.findViewById(d.g.searchSuggestTitle);
            aVar2.bjN = view.findViewById(d.g.searchItemSep);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            a(aVar.gOc, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != aVar.mSkinType) {
                aVar.mSkinType = skinType;
                al.k(aVar.mRootView, d.f.addresslist_item_bg);
                al.j(aVar.gOc, d.C0277d.cp_cont_b);
                al.l(aVar.bjN, d.C0277d.cp_bg_line_c);
            }
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        View bjN;
        TextView gOc;
        View mRootView;
        int mSkinType;

        private a() {
            this.mSkinType = 3;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bih)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bih.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bih.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
