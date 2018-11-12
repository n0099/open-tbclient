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
    private final BaseActivity<?> bxI;
    private final boolean fml = true;
    private ArrayList<ForumSuggestModel.Forum> fmm;
    private String mKeyWord;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bxI = baseActivity;
        this.fmm = arrayList;
    }

    public void ab(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fmm = arrayList;
        if (this.fmm != null) {
            notifyDataSetChanged();
        }
    }

    public void qK(String str) {
        this.mKeyWord = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fmm == null) {
            return 0;
        }
        return this.fmm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qM */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fmm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0258a c0258a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bxI.getPageContext().getPageActivity()).inflate(e.h.square_dialog_search_item, (ViewGroup) null);
            C0258a c0258a2 = new C0258a();
            c0258a2.fmo = (BarImageView) view.findViewById(e.g.forum_avatar);
            c0258a2.fmo.setGifIconSupport(false);
            c0258a2.aGk = (TextView) view.findViewById(e.g.name);
            c0258a2.fmp = (TextView) view.findViewById(e.g.forum_member_count);
            c0258a2.fmq = (TextView) view.findViewById(e.g.forum_thread_count);
            c0258a2.fmr = (TextView) view.findViewById(e.g.slogan);
            c0258a2.fmn = view.findViewById(e.g.offical_icon);
            view.setTag(c0258a2);
            c0258a = c0258a2;
        } else {
            c0258a = (C0258a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0258a.fmo.setTag(str2);
            c0258a.fmo.startLoad(str2, 10, false);
            c0258a.fmo.invalidate();
            if (this.fml) {
                str = this.bxI.getPageContext().getPageActivity().getString(e.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0258a.aGk, str);
            c0258a.fmo.setTag(item.avatar);
            c0258a.fmp.setText(this.bxI.getPageContext().getString(e.j.attention) + " " + qN(item.member_num));
            c0258a.fmq.setText(this.bxI.getPageContext().getString(e.j.text_post) + " " + qN(item.thread_num));
            if (this.fml || !TextUtils.isEmpty(item.slogan)) {
                c0258a.fmr.setVisibility(0);
                c0258a.fmr.setText(item.slogan);
            } else {
                c0258a.fmr.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0258a.fmn.setVisibility(0);
                al.i(c0258a.fmn, e.f.icon_search_official);
            } else {
                c0258a.fmn.setVisibility(8);
            }
            this.bxI.getLayoutMode().setNightMode(skinType == 1);
            this.bxI.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String qN(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bxI.getPageContext().getString(e.j.member_count_unit);
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
    private class C0258a {
        TextView aGk;
        View fmn;
        BarImageView fmo;
        TextView fmp;
        TextView fmq;
        TextView fmr;

        private C0258a() {
        }
    }
}
