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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private String eCP;
    private List<String> eEe;
    private Context mContext;

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.eEe = arrayList;
    }

    public void setData(List<String> list) {
        this.eEe = list;
        if (this.eEe != null) {
            notifyDataSetChanged();
        }
    }

    public void oK(String str) {
        if (!StringUtils.isNull(str)) {
            this.eCP = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eEe == null) {
            return 0;
        }
        return this.eEe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eEe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0180a c0180a;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(d.i.search_suggest_item, (ViewGroup) null);
            C0180a c0180a2 = new C0180a();
            c0180a2.mRootView = view2.findViewById(d.g.rootview);
            c0180a2.eEf = (TextView) view2.findViewById(d.g.searchSuggestTitle);
            c0180a2.cKV = view2.findViewById(d.g.searchItemSep);
            view2.setTag(c0180a2);
            c0180a = c0180a2;
        } else {
            c0180a = (C0180a) view2.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            a(c0180a.eEf, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c0180a.mSkinType) {
                c0180a.mSkinType = skinType;
                ak.i(c0180a.mRootView, d.f.addresslist_item_bg);
                ak.h(c0180a.eEf, d.C0126d.cp_cont_b);
                ak.j(c0180a.cKV, d.C0126d.cp_bg_line_c);
            }
        }
        return view2;
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0180a {
        View cKV;
        TextView eEf;
        View mRootView;
        int mSkinType;

        private C0180a() {
            this.mSkinType = 3;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eCP)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eCP.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eCP.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
