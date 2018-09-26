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
    private String fdl;
    private List<String> fez;
    private Context mContext;

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.fez = arrayList;
    }

    public void setData(List<String> list) {
        this.fez = list;
        if (this.fez != null) {
            notifyDataSetChanged();
        }
    }

    public void qh(String str) {
        if (!StringUtils.isNull(str)) {
            this.fdl = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fez == null) {
            return 0;
        }
        return this.fez.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fez.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0199a c0199a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(e.h.search_suggest_item, (ViewGroup) null);
            C0199a c0199a2 = new C0199a();
            c0199a2.mRootView = view.findViewById(e.g.rootview);
            c0199a2.feA = (TextView) view.findViewById(e.g.searchSuggestTitle);
            c0199a2.daE = view.findViewById(e.g.searchItemSep);
            view.setTag(c0199a2);
            c0199a = c0199a2;
        } else {
            c0199a = (C0199a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            a(c0199a.feA, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c0199a.mSkinType) {
                c0199a.mSkinType = skinType;
                al.i(c0199a.mRootView, e.f.addresslist_item_bg);
                al.h(c0199a.feA, e.d.cp_cont_b);
                al.j(c0199a.daE, e.d.cp_bg_line_c);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0199a {
        View daE;
        TextView feA;
        View mRootView;
        int mSkinType;

        private C0199a() {
            this.mSkinType = 3;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fdl)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fdl.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fdl.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
