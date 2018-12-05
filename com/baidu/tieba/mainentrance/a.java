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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> bBf;
    private final boolean ftd = true;
    private ArrayList<ForumSuggestModel.Forum> fte;
    private String mKeyWord;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bBf = baseActivity;
        this.fte = arrayList;
    }

    public void ab(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fte = arrayList;
        if (this.fte != null) {
            notifyDataSetChanged();
        }
    }

    public void rm(String str) {
        this.mKeyWord = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fte == null) {
            return 0;
        }
        return this.fte.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rg */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fte.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0269a c0269a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bBf.getPageContext().getPageActivity()).inflate(e.h.square_dialog_search_item, (ViewGroup) null);
            C0269a c0269a2 = new C0269a();
            c0269a2.ftg = (BarImageView) view.findViewById(e.g.forum_avatar);
            c0269a2.ftg.setGifIconSupport(false);
            c0269a2.aJK = (TextView) view.findViewById(e.g.name);
            c0269a2.fth = (TextView) view.findViewById(e.g.forum_member_count);
            c0269a2.fti = (TextView) view.findViewById(e.g.forum_thread_count);
            c0269a2.ftj = (TextView) view.findViewById(e.g.slogan);
            c0269a2.ftf = view.findViewById(e.g.offical_icon);
            view.setTag(c0269a2);
            c0269a = c0269a2;
        } else {
            c0269a = (C0269a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0269a.ftg.setTag(str2);
            c0269a.ftg.startLoad(str2, 10, false);
            c0269a.ftg.invalidate();
            if (this.ftd) {
                str = this.bBf.getPageContext().getPageActivity().getString(e.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0269a.aJK, str);
            c0269a.ftg.setTag(item.avatar);
            c0269a.fth.setText(this.bBf.getPageContext().getString(e.j.attention) + " " + rh(item.member_num));
            c0269a.fti.setText(this.bBf.getPageContext().getString(e.j.text_post) + " " + rh(item.thread_num));
            if (this.ftd || !TextUtils.isEmpty(item.slogan)) {
                c0269a.ftj.setVisibility(0);
                c0269a.ftj.setText(item.slogan);
            } else {
                c0269a.ftj.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0269a.ftf.setVisibility(0);
                al.i(c0269a.ftf, e.f.icon_search_official);
            } else {
                c0269a.ftf.setVisibility(8);
            }
            this.bBf.getLayoutMode().setNightMode(skinType == 1);
            this.bBf.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String rh(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bBf.getPageContext().getString(e.j.member_count_unit);
        }
        return String.valueOf(i);
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

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0269a {
        TextView aJK;
        View ftf;
        BarImageView ftg;
        TextView fth;
        TextView fti;
        TextView ftj;

        private C0269a() {
        }
    }
}
