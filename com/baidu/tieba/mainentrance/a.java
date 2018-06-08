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
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> bkU;
    private final boolean eOh = true;
    private ArrayList<ForumSuggestModel.Forum> eOi;
    private String eOj;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bkU = baseActivity;
        this.eOi = arrayList;
    }

    public void Y(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.eOi = arrayList;
        if (this.eOi != null) {
            notifyDataSetChanged();
        }
    }

    public void py(String str) {
        this.eOj = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOi == null) {
            return 0;
        }
        return this.eOi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oV */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eOi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0195a c0195a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bkU.getPageContext().getPageActivity()).inflate(d.i.square_dialog_search_item, (ViewGroup) null);
            C0195a c0195a2 = new C0195a();
            c0195a2.eOl = (BarImageView) view.findViewById(d.g.forum_avatar);
            c0195a2.eOl.setGifIconSupport(false);
            c0195a2.ayc = (TextView) view.findViewById(d.g.name);
            c0195a2.eOm = (TextView) view.findViewById(d.g.forum_member_count);
            c0195a2.eOn = (TextView) view.findViewById(d.g.forum_thread_count);
            c0195a2.eOo = (TextView) view.findViewById(d.g.slogan);
            c0195a2.eOk = view.findViewById(d.g.offical_icon);
            view.setTag(c0195a2);
            c0195a = c0195a2;
        } else {
            c0195a = (C0195a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0195a.eOl.setTag(str2);
            c0195a.eOl.startLoad(str2, 10, false);
            c0195a.eOl.invalidate();
            if (this.eOh) {
                str = this.bkU.getPageContext().getPageActivity().getString(d.k.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0195a.ayc, str);
            c0195a.eOl.setTag(item.avatar);
            c0195a.eOm.setText(this.bkU.getPageContext().getString(d.k.attention) + " " + oW(item.member_num));
            c0195a.eOn.setText(this.bkU.getPageContext().getString(d.k.text_post) + " " + oW(item.thread_num));
            if (this.eOh || !TextUtils.isEmpty(item.slogan)) {
                c0195a.eOo.setVisibility(0);
                c0195a.eOo.setText(item.slogan);
            } else {
                c0195a.eOo.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0195a.eOk.setVisibility(0);
                al.i(c0195a.eOk, d.f.icon_search_official);
            } else {
                c0195a.eOk.setVisibility(8);
            }
            this.bkU.getLayoutMode().setNightMode(skinType == 1);
            this.bkU.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String oW(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bkU.getPageContext().getString(d.k.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eOj)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eOj.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0141d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eOj.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0195a {
        TextView ayc;
        View eOk;
        BarImageView eOl;
        TextView eOm;
        TextView eOn;
        TextView eOo;

        private C0195a() {
        }
    }
}
