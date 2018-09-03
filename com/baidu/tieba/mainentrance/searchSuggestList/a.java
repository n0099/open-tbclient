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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private String eVQ;
    private List<String> eXe;
    private Context mContext;

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.eXe = arrayList;
    }

    public void setData(List<String> list) {
        this.eXe = list;
        if (this.eXe != null) {
            notifyDataSetChanged();
        }
    }

    public void pC(String str) {
        if (!StringUtils.isNull(str)) {
            this.eVQ = str.trim();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXe == null) {
            return 0;
        }
        return this.eXe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eXe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0197a c0197a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(f.h.search_suggest_item, (ViewGroup) null);
            C0197a c0197a2 = new C0197a();
            c0197a2.mRootView = view.findViewById(f.g.rootview);
            c0197a2.eXf = (TextView) view.findViewById(f.g.searchSuggestTitle);
            c0197a2.cUL = view.findViewById(f.g.searchItemSep);
            view.setTag(c0197a2);
            c0197a = c0197a2;
        } else {
            c0197a = (C0197a) view.getTag();
        }
        String item = getItem(i);
        if (!StringUtils.isNull(item)) {
            a(c0197a.eXf, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c0197a.mSkinType) {
                c0197a.mSkinType = skinType;
                am.i(c0197a.mRootView, f.C0146f.addresslist_item_bg);
                am.h(c0197a.eXf, f.d.cp_cont_b);
                am.j(c0197a.cUL, f.d.cp_bg_line_c);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0197a {
        View cUL;
        TextView eXf;
        View mRootView;
        int mSkinType;

        private C0197a() {
            this.mSkinType = 3;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eVQ)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eVQ.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(f.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eVQ.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
