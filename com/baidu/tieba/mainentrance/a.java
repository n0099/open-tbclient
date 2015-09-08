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
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> aSX;
    private final boolean bQi = true;
    private ArrayList<ForumSuggestModel.Forum> bQj;
    private String bQk;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.aSX = baseActivity;
        this.bQj = arrayList;
    }

    public void I(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bQj = arrayList;
        if (this.bQj != null) {
            notifyDataSetChanged();
        }
    }

    public void iI(String str) {
        this.bQk = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bQj == null) {
            return 0;
        }
        return this.bQj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hQ */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bQj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0065a c0065a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.aSX.getPageContext().getPageActivity()).inflate(i.g.square_dialog_search_item, (ViewGroup) null);
            C0065a c0065a2 = new C0065a(this, null);
            c0065a2.bPq = (BarImageView) view.findViewById(i.f.forum_avatar);
            c0065a2.bPq.setGifIconSupport(false);
            c0065a2.aOv = (TextView) view.findViewById(i.f.name);
            c0065a2.bPr = (TextView) view.findViewById(i.f.member_count);
            c0065a2.bPs = (TextView) view.findViewById(i.f.thread_count);
            c0065a2.bNN = (TextView) view.findViewById(i.f.slogan);
            view.setTag(c0065a2);
            c0065a = c0065a2;
        } else {
            c0065a = (C0065a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0065a.bPq.setTag(str2);
            c0065a.bPq.d(str2, 10, false);
            c0065a.bPq.invalidate();
            if (this.bQi) {
                str = this.aSX.getPageContext().getPageActivity().getString(i.h.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0065a.aOv, str);
            c0065a.bPq.setTag(item.avatar);
            c0065a.bPr.setText(String.valueOf(this.aSX.getPageContext().getString(i.h.forum_list_attention_tv)) + " " + hR(item.member_num));
            c0065a.bPs.setText(String.valueOf(this.aSX.getPageContext().getString(i.h.forum_list_thread_tv)) + " " + hR(item.thread_num));
            if (this.bQi || !TextUtils.isEmpty(item.slogan)) {
                c0065a.bNN.setVisibility(0);
                c0065a.bNN.setText(item.slogan);
            } else {
                c0065a.bNN.setVisibility(8);
            }
            this.aSX.getLayoutMode().ad(skinType == 1);
            this.aSX.getLayoutMode().k(view);
        }
        return view;
    }

    public String hR(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.aSX.getPageContext().getString(i.h.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bQk)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bQk.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bQk.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0065a {
        TextView aOv;
        TextView bNN;
        BarImageView bPq;
        TextView bPr;
        TextView bPs;

        private C0065a() {
        }

        /* synthetic */ C0065a(a aVar, C0065a c0065a) {
            this();
        }
    }
}
