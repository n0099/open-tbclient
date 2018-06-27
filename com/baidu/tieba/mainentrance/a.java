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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> bmt;
    private final boolean eRY = true;
    private ArrayList<ForumSuggestModel.Forum> eRZ;
    private String eSa;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bmt = baseActivity;
        this.eRZ = arrayList;
    }

    public void ac(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.eRZ = arrayList;
        if (this.eRZ != null) {
            notifyDataSetChanged();
        }
    }

    public void pz(String str) {
        this.eSa = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eRZ == null) {
            return 0;
        }
        return this.eRZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pc */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eRZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0197a c0197a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bmt.getPageContext().getPageActivity()).inflate(d.i.square_dialog_search_item, (ViewGroup) null);
            C0197a c0197a2 = new C0197a();
            c0197a2.eSc = (BarImageView) view.findViewById(d.g.forum_avatar);
            c0197a2.eSc.setGifIconSupport(false);
            c0197a2.ayV = (TextView) view.findViewById(d.g.name);
            c0197a2.eSd = (TextView) view.findViewById(d.g.forum_member_count);
            c0197a2.eSe = (TextView) view.findViewById(d.g.forum_thread_count);
            c0197a2.eSf = (TextView) view.findViewById(d.g.slogan);
            c0197a2.eSb = view.findViewById(d.g.offical_icon);
            view.setTag(c0197a2);
            c0197a = c0197a2;
        } else {
            c0197a = (C0197a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0197a.eSc.setTag(str2);
            c0197a.eSc.startLoad(str2, 10, false);
            c0197a.eSc.invalidate();
            if (this.eRY) {
                str = this.bmt.getPageContext().getPageActivity().getString(d.k.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0197a.ayV, str);
            c0197a.eSc.setTag(item.avatar);
            c0197a.eSd.setText(this.bmt.getPageContext().getString(d.k.attention) + " " + pd(item.member_num));
            c0197a.eSe.setText(this.bmt.getPageContext().getString(d.k.text_post) + " " + pd(item.thread_num));
            if (this.eRY || !TextUtils.isEmpty(item.slogan)) {
                c0197a.eSf.setVisibility(0);
                c0197a.eSf.setText(item.slogan);
            } else {
                c0197a.eSf.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0197a.eSb.setVisibility(0);
                am.i(c0197a.eSb, d.f.icon_search_official);
            } else {
                c0197a.eSb.setVisibility(8);
            }
            this.bmt.getLayoutMode().setNightMode(skinType == 1);
            this.bmt.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String pd(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bmt.getPageContext().getString(d.k.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eSa)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eSa.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(d.C0142d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eSa.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0197a {
        TextView ayV;
        View eSb;
        BarImageView eSc;
        TextView eSd;
        TextView eSe;
        TextView eSf;

        private C0197a() {
        }
    }
}
