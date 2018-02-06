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
    private String fhd;
    private List<String> fir;
    private Context mContext;

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.fir = arrayList;
    }

    public void setData(List<String> list) {
        this.fir = list;
        if (this.fir != null) {
            notifyDataSetChanged();
        }
    }

    public void oC(String str) {
        if (!StringUtils.isNull(str)) {
            this.fhd = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fir == null) {
            return 0;
        }
        return this.fir.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fir.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0197a c0197a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.search_suggest_item, (ViewGroup) null);
            C0197a c0197a2 = new C0197a();
            c0197a2.mRootView = view.findViewById(d.g.rootview);
            c0197a2.fis = (TextView) view.findViewById(d.g.searchSuggestTitle);
            c0197a2.drs = view.findViewById(d.g.searchItemSep);
            view.setTag(c0197a2);
            c0197a = c0197a2;
        } else {
            c0197a = (C0197a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            b(c0197a.fis, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c0197a.mSkinType) {
                c0197a.mSkinType = skinType;
                aj.s(c0197a.mRootView, d.f.addresslist_item_bg);
                aj.r(c0197a.fis, d.C0140d.cp_cont_b);
                aj.t(c0197a.drs, d.C0140d.cp_bg_line_c);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0197a {
        View drs;
        TextView fis;
        View mRootView;
        int mSkinType;

        private C0197a() {
            this.mSkinType = 3;
        }
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fhd)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fhd.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0140d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fhd.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
