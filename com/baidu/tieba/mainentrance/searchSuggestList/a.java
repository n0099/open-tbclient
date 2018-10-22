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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private String fkV;
    private List<String> fmj;
    private Context mContext;

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.fmj = arrayList;
    }

    public void setData(List<String> list) {
        this.fmj = list;
        if (this.fmj != null) {
            notifyDataSetChanged();
        }
    }

    public void qJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.fkV = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fmj == null) {
            return 0;
        }
        return this.fmj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fmj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0233a c0233a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(e.h.search_suggest_item, (ViewGroup) null);
            C0233a c0233a2 = new C0233a();
            c0233a2.mRootView = view.findViewById(e.g.rootview);
            c0233a2.fmk = (TextView) view.findViewById(e.g.searchSuggestTitle);
            c0233a2.mDividerView = view.findViewById(e.g.searchItemSep);
            view.setTag(c0233a2);
            c0233a = c0233a2;
        } else {
            c0233a = (C0233a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            a(c0233a.fmk, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c0233a.mSkinType) {
                c0233a.mSkinType = skinType;
                al.i(c0233a.mRootView, e.f.addresslist_item_bg);
                al.h(c0233a.fmk, e.d.cp_cont_b);
                al.j(c0233a.mDividerView, e.d.cp_bg_line_c);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0233a {
        TextView fmk;
        View mDividerView;
        View mRootView;
        int mSkinType;

        private C0233a() {
            this.mSkinType = 3;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fkV)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fkV.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fkV.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
