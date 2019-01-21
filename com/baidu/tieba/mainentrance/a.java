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
    private final BaseActivity<?> bBW;
    private final boolean fwQ = true;
    private ArrayList<ForumSuggestModel.Forum> fwR;
    private String mKeyWord;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bBW = baseActivity;
        this.fwR = arrayList;
    }

    public void ab(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fwR = arrayList;
        if (this.fwR != null) {
            notifyDataSetChanged();
        }
    }

    public void rF(String str) {
        this.mKeyWord = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fwR == null) {
            return 0;
        }
        return this.fwR.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rv */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fwR.get(i);
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
            view = LayoutInflater.from(this.bBW.getPageContext().getPageActivity()).inflate(e.h.square_dialog_search_item, (ViewGroup) null);
            C0269a c0269a2 = new C0269a();
            c0269a2.fwT = (BarImageView) view.findViewById(e.g.forum_avatar);
            c0269a2.fwT.setGifIconSupport(false);
            c0269a2.aKp = (TextView) view.findViewById(e.g.name);
            c0269a2.fwU = (TextView) view.findViewById(e.g.forum_member_count);
            c0269a2.fwV = (TextView) view.findViewById(e.g.forum_thread_count);
            c0269a2.fwW = (TextView) view.findViewById(e.g.slogan);
            c0269a2.fwS = view.findViewById(e.g.offical_icon);
            view.setTag(c0269a2);
            c0269a = c0269a2;
        } else {
            c0269a = (C0269a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0269a.fwT.setTag(str2);
            c0269a.fwT.startLoad(str2, 10, false);
            c0269a.fwT.invalidate();
            if (this.fwQ) {
                str = this.bBW.getPageContext().getPageActivity().getString(e.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0269a.aKp, str);
            c0269a.fwT.setTag(item.avatar);
            c0269a.fwU.setText(this.bBW.getPageContext().getString(e.j.attention) + " " + rw(item.member_num));
            c0269a.fwV.setText(this.bBW.getPageContext().getString(e.j.text_post) + " " + rw(item.thread_num));
            if (this.fwQ || !TextUtils.isEmpty(item.slogan)) {
                c0269a.fwW.setVisibility(0);
                c0269a.fwW.setText(item.slogan);
            } else {
                c0269a.fwW.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0269a.fwS.setVisibility(0);
                al.i(c0269a.fwS, e.f.icon_search_official);
            } else {
                c0269a.fwS.setVisibility(8);
            }
            this.bBW.getLayoutMode().setNightMode(skinType == 1);
            this.bBW.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String rw(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bBW.getPageContext().getString(e.j.member_count_unit);
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
        TextView aKp;
        View fwS;
        BarImageView fwT;
        TextView fwU;
        TextView fwV;
        TextView fwW;

        private C0269a() {
        }
    }
}
