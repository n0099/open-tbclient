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
    private final BaseActivity<?> bix;
    private final boolean cKr = true;
    private ArrayList<ForumSuggestModel.Forum> cKs;
    private String cKt;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bix = baseActivity;
        this.cKs = arrayList;
    }

    public void N(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cKs = arrayList;
        if (this.cKs != null) {
            notifyDataSetChanged();
        }
    }

    public void kw(String str) {
        this.cKt = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cKs == null) {
            return 0;
        }
        return this.cKs.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kN */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.cKs.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0070a c0070a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bix.getPageContext().getPageActivity()).inflate(t.h.square_dialog_search_item, (ViewGroup) null);
            C0070a c0070a2 = new C0070a(this, null);
            c0070a2.cEY = (BarImageView) view.findViewById(t.g.forum_avatar);
            c0070a2.cEY.setGifIconSupport(false);
            c0070a2.aRQ = (TextView) view.findViewById(t.g.name);
            c0070a2.cEZ = (TextView) view.findViewById(t.g.forum_member_count);
            c0070a2.cFa = (TextView) view.findViewById(t.g.forum_thread_count);
            c0070a2.cDs = (TextView) view.findViewById(t.g.slogan);
            view.setTag(c0070a2);
            c0070a = c0070a2;
        } else {
            c0070a = (C0070a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0070a.cEY.setTag(str2);
            c0070a.cEY.c(str2, 10, false);
            c0070a.cEY.invalidate();
            if (this.cKr) {
                str = this.bix.getPageContext().getPageActivity().getString(t.j.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0070a.aRQ, str);
            c0070a.cEY.setTag(item.avatar);
            c0070a.cEZ.setText(String.valueOf(this.bix.getPageContext().getString(t.j.forum_list_attention_tv)) + " " + kO(item.member_num));
            c0070a.cFa.setText(String.valueOf(this.bix.getPageContext().getString(t.j.forum_list_thread_tv)) + " " + kO(item.thread_num));
            if (this.cKr || !TextUtils.isEmpty(item.slogan)) {
                c0070a.cDs.setVisibility(0);
                c0070a.cDs.setText(item.slogan);
            } else {
                c0070a.cDs.setVisibility(8);
            }
            this.bix.getLayoutMode().ab(skinType == 1);
            this.bix.getLayoutMode().x(view);
        }
        return view;
    }

    public String kO(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.bix.getPageContext().getString(t.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cKt)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cKt.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cKt.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0070a {
        TextView aRQ;
        TextView cDs;
        BarImageView cEY;
        TextView cEZ;
        TextView cFa;

        private C0070a() {
        }

        /* synthetic */ C0070a(a aVar, C0070a c0070a) {
            this();
        }
    }
}
