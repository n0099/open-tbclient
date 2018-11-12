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
    private List<String> fnA;
    private Context mContext;
    private String mKeyWord;

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.fnA = arrayList;
    }

    public void setData(List<String> list) {
        this.fnA = list;
        if (this.fnA != null) {
            notifyDataSetChanged();
        }
    }

    public void qK(String str) {
        if (!StringUtils.isNull(str)) {
            this.mKeyWord = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fnA == null) {
            return 0;
        }
        return this.fnA.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fnA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0259a c0259a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(e.h.search_suggest_item, (ViewGroup) null);
            C0259a c0259a2 = new C0259a();
            c0259a2.mRootView = view.findViewById(e.g.rootview);
            c0259a2.fnB = (TextView) view.findViewById(e.g.searchSuggestTitle);
            c0259a2.mDividerView = view.findViewById(e.g.searchItemSep);
            view.setTag(c0259a2);
            c0259a = c0259a2;
        } else {
            c0259a = (C0259a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            a(c0259a.fnB, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c0259a.mSkinType) {
                c0259a.mSkinType = skinType;
                al.i(c0259a.mRootView, e.f.addresslist_item_bg);
                al.h(c0259a.fnB, e.d.cp_cont_b);
                al.j(c0259a.mDividerView, e.d.cp_bg_line_c);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0259a {
        TextView fnB;
        View mDividerView;
        View mRootView;
        int mSkinType;

        private C0259a() {
            this.mSkinType = 3;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mKeyWord)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.mKeyWord.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.mKeyWord.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
