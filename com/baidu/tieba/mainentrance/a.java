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
    private final BaseActivity<?> aSe;
    private final boolean bTV = true;
    private ArrayList<ForumSuggestModel.Forum> bTW;
    private String bTX;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.aSe = baseActivity;
        this.bTW = arrayList;
    }

    public void I(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bTW = arrayList;
        if (this.bTW != null) {
            notifyDataSetChanged();
        }
    }

    public void iT(String str) {
        this.bTX = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bTW == null) {
            return 0;
        }
        return this.bTW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hY */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bTW.get(i);
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
            view = LayoutInflater.from(this.aSe.getPageContext().getPageActivity()).inflate(i.g.square_dialog_search_item, (ViewGroup) null);
            C0065a c0065a2 = new C0065a(this, null);
            c0065a2.bTd = (BarImageView) view.findViewById(i.f.forum_avatar);
            c0065a2.bTd.setGifIconSupport(false);
            c0065a2.aNC = (TextView) view.findViewById(i.f.name);
            c0065a2.bTe = (TextView) view.findViewById(i.f.forum_member_count);
            c0065a2.bTf = (TextView) view.findViewById(i.f.forum_thread_count);
            c0065a2.bRA = (TextView) view.findViewById(i.f.slogan);
            view.setTag(c0065a2);
            c0065a = c0065a2;
        } else {
            c0065a = (C0065a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0065a.bTd.setTag(str2);
            c0065a.bTd.d(str2, 10, false);
            c0065a.bTd.invalidate();
            if (this.bTV) {
                str = this.aSe.getPageContext().getPageActivity().getString(i.h.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0065a.aNC, str);
            c0065a.bTd.setTag(item.avatar);
            c0065a.bTe.setText(String.valueOf(this.aSe.getPageContext().getString(i.h.forum_list_attention_tv)) + " " + hZ(item.member_num));
            c0065a.bTf.setText(String.valueOf(this.aSe.getPageContext().getString(i.h.forum_list_thread_tv)) + " " + hZ(item.thread_num));
            if (this.bTV || !TextUtils.isEmpty(item.slogan)) {
                c0065a.bRA.setVisibility(0);
                c0065a.bRA.setText(item.slogan);
            } else {
                c0065a.bRA.setVisibility(8);
            }
            this.aSe.getLayoutMode().ad(skinType == 1);
            this.aSe.getLayoutMode().k(view);
        }
        return view;
    }

    public String hZ(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.aSe.getPageContext().getString(i.h.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bTX)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bTX.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bTX.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0065a {
        TextView aNC;
        TextView bRA;
        BarImageView bTd;
        TextView bTe;
        TextView bTf;

        private C0065a() {
        }

        /* synthetic */ C0065a(a aVar, C0065a c0065a) {
            this();
        }
    }
}
