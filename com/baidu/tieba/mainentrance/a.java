package com.baidu.tieba.mainentrance;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> bek;
    private final boolean cLn = true;
    private ArrayList<ForumSuggestModel.Forum> cLo;
    private String cLp;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bek = baseActivity;
        this.cLo = arrayList;
    }

    public void O(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cLo = arrayList;
        if (this.cLo != null) {
            notifyDataSetChanged();
        }
    }

    public void kA(String str) {
        this.cLp = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cLo == null) {
            return 0;
        }
        return this.cLo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kv */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.cLo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0063a c0063a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bek.getPageContext().getPageActivity()).inflate(t.h.square_dialog_search_item, (ViewGroup) null);
            C0063a c0063a2 = new C0063a(this, null);
            c0063a2.cEQ = (BarImageView) view.findViewById(t.g.forum_avatar);
            c0063a2.cEQ.setGifIconSupport(false);
            c0063a2.aZB = (TextView) view.findViewById(t.g.name);
            c0063a2.cER = (TextView) view.findViewById(t.g.forum_member_count);
            c0063a2.cES = (TextView) view.findViewById(t.g.forum_thread_count);
            c0063a2.cET = (TextView) view.findViewById(t.g.slogan);
            view.setTag(c0063a2);
            c0063a = c0063a2;
        } else {
            c0063a = (C0063a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m11getInst().getSkinType();
            String str2 = item.avatar;
            c0063a.cEQ.setTag(str2);
            c0063a.cEQ.c(str2, 10, false);
            c0063a.cEQ.invalidate();
            if (this.cLn) {
                str = this.bek.getPageContext().getPageActivity().getString(t.j.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0063a.aZB, str);
            c0063a.cEQ.setTag(item.avatar);
            c0063a.cER.setText(String.valueOf(this.bek.getPageContext().getString(t.j.forum_list_attention_tv)) + " " + kw(item.member_num));
            c0063a.cES.setText(String.valueOf(this.bek.getPageContext().getString(t.j.forum_list_thread_tv)) + " " + kw(item.thread_num));
            if (this.cLn || !TextUtils.isEmpty(item.slogan)) {
                c0063a.cET.setVisibility(0);
                c0063a.cET.setText(item.slogan);
            } else {
                c0063a.cET.setVisibility(8);
            }
            this.bek.getLayoutMode().ae(skinType == 1);
            this.bek.getLayoutMode().x(view);
        }
        return view;
    }

    public String kw(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.bek.getPageContext().getString(t.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cLp)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cLp.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cLp.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0063a {
        TextView aZB;
        BarImageView cEQ;
        TextView cER;
        TextView cES;
        TextView cET;

        private C0063a() {
        }

        /* synthetic */ C0063a(a aVar, C0063a c0063a) {
            this();
        }
    }
}
