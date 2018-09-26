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
    private final BaseActivity<?> bsQ;
    private final boolean fdj = true;
    private ArrayList<ForumSuggestModel.Forum> fdk;
    private String fdl;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bsQ = baseActivity;
        this.fdk = arrayList;
    }

    public void ac(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fdk = arrayList;
        if (this.fdk != null) {
            notifyDataSetChanged();
        }
    }

    public void qh(String str) {
        this.fdl = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fdk == null) {
            return 0;
        }
        return this.fdk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pV */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fdk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0198a c0198a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bsQ.getPageContext().getPageActivity()).inflate(e.h.square_dialog_search_item, (ViewGroup) null);
            C0198a c0198a2 = new C0198a();
            c0198a2.fdn = (BarImageView) view.findViewById(e.g.forum_avatar);
            c0198a2.fdn.setGifIconSupport(false);
            c0198a2.aAN = (TextView) view.findViewById(e.g.name);
            c0198a2.fdo = (TextView) view.findViewById(e.g.forum_member_count);
            c0198a2.fdp = (TextView) view.findViewById(e.g.forum_thread_count);
            c0198a2.fdq = (TextView) view.findViewById(e.g.slogan);
            c0198a2.fdm = view.findViewById(e.g.offical_icon);
            view.setTag(c0198a2);
            c0198a = c0198a2;
        } else {
            c0198a = (C0198a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0198a.fdn.setTag(str2);
            c0198a.fdn.startLoad(str2, 10, false);
            c0198a.fdn.invalidate();
            if (this.fdj) {
                str = this.bsQ.getPageContext().getPageActivity().getString(e.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0198a.aAN, str);
            c0198a.fdn.setTag(item.avatar);
            c0198a.fdo.setText(this.bsQ.getPageContext().getString(e.j.attention) + " " + pW(item.member_num));
            c0198a.fdp.setText(this.bsQ.getPageContext().getString(e.j.text_post) + " " + pW(item.thread_num));
            if (this.fdj || !TextUtils.isEmpty(item.slogan)) {
                c0198a.fdq.setVisibility(0);
                c0198a.fdq.setText(item.slogan);
            } else {
                c0198a.fdq.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0198a.fdm.setVisibility(0);
                al.i(c0198a.fdm, e.f.icon_search_official);
            } else {
                c0198a.fdm.setVisibility(8);
            }
            this.bsQ.getLayoutMode().setNightMode(skinType == 1);
            this.bsQ.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String pW(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bsQ.getPageContext().getString(e.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fdl)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fdl.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fdl.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0198a {
        TextView aAN;
        View fdm;
        BarImageView fdn;
        TextView fdo;
        TextView fdp;
        TextView fdq;

        private C0198a() {
        }
    }
}
