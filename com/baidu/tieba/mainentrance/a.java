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
    private final BaseActivity<?> bdK;
    private final boolean cvw = true;
    private ArrayList<ForumSuggestModel.Forum> cvx;
    private String cvy;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bdK = baseActivity;
        this.cvx = arrayList;
    }

    public void O(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cvx = arrayList;
        if (this.cvx != null) {
            notifyDataSetChanged();
        }
    }

    public void jJ(String str) {
        this.cvy = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cvx == null) {
            return 0;
        }
        return this.cvx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ke */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.cvx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0069a c0069a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bdK.getPageContext().getPageActivity()).inflate(t.h.square_dialog_search_item, (ViewGroup) null);
            C0069a c0069a2 = new C0069a(this, null);
            c0069a2.cuz = (BarImageView) view.findViewById(t.g.forum_avatar);
            c0069a2.cuz.setGifIconSupport(false);
            c0069a2.aPa = (TextView) view.findViewById(t.g.name);
            c0069a2.cuA = (TextView) view.findViewById(t.g.forum_member_count);
            c0069a2.cuB = (TextView) view.findViewById(t.g.forum_thread_count);
            c0069a2.csS = (TextView) view.findViewById(t.g.slogan);
            view.setTag(c0069a2);
            c0069a = c0069a2;
        } else {
            c0069a = (C0069a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0069a.cuz.setTag(str2);
            c0069a.cuz.d(str2, 10, false);
            c0069a.cuz.invalidate();
            if (this.cvw) {
                str = this.bdK.getPageContext().getPageActivity().getString(t.j.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0069a.aPa, str);
            c0069a.cuz.setTag(item.avatar);
            c0069a.cuA.setText(String.valueOf(this.bdK.getPageContext().getString(t.j.forum_list_attention_tv)) + " " + kf(item.member_num));
            c0069a.cuB.setText(String.valueOf(this.bdK.getPageContext().getString(t.j.forum_list_thread_tv)) + " " + kf(item.thread_num));
            if (this.cvw || !TextUtils.isEmpty(item.slogan)) {
                c0069a.csS.setVisibility(0);
                c0069a.csS.setText(item.slogan);
            } else {
                c0069a.csS.setVisibility(8);
            }
            this.bdK.getLayoutMode().ac(skinType == 1);
            this.bdK.getLayoutMode().x(view);
        }
        return view;
    }

    public String kf(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.bdK.getPageContext().getString(t.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cvy)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cvy.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cvy.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0069a {
        TextView aPa;
        TextView csS;
        TextView cuA;
        TextView cuB;
        BarImageView cuz;

        private C0069a() {
        }

        /* synthetic */ C0069a(a aVar, C0069a c0069a) {
            this();
        }
    }
}
