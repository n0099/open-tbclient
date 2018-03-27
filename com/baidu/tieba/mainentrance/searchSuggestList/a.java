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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private String fhf;
    private List<String> fiv;
    private Context mContext;

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.fiv = arrayList;
    }

    public void setData(List<String> list) {
        this.fiv = list;
        if (this.fiv != null) {
            notifyDataSetChanged();
        }
    }

    public void oC(String str) {
        if (!StringUtils.isNull(str)) {
            this.fhf = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiv == null) {
            return 0;
        }
        return this.fiv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fiv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0198a c0198a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.search_suggest_item, (ViewGroup) null);
            C0198a c0198a2 = new C0198a();
            c0198a2.mRootView = view.findViewById(d.g.rootview);
            c0198a2.fiw = (TextView) view.findViewById(d.g.searchSuggestTitle);
            c0198a2.drj = view.findViewById(d.g.searchItemSep);
            view.setTag(c0198a2);
            c0198a = c0198a2;
        } else {
            c0198a = (C0198a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            b(c0198a.fiw, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c0198a.mSkinType) {
                c0198a.mSkinType = skinType;
                aj.s(c0198a.mRootView, d.f.addresslist_item_bg);
                aj.r(c0198a.fiw, d.C0141d.cp_cont_b);
                aj.t(c0198a.drj, d.C0141d.cp_bg_line_c);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0198a {
        View drj;
        TextView fiw;
        View mRootView;
        int mSkinType;

        private C0198a() {
            this.mSkinType = 3;
        }
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fhf)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fhf.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0141d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fhf.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
