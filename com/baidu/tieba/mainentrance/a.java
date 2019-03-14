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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String bic;
    private final BaseActivity<?> cNa;
    private final boolean gMT = true;
    private ArrayList<ForumSuggestModel.Forum> gMU;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cNa = baseActivity;
        this.gMU = arrayList;
    }

    public void af(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.gMU = arrayList;
        if (this.gMU != null) {
            notifyDataSetChanged();
        }
    }

    public void yi(String str) {
        this.bic = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gMU == null) {
            return 0;
        }
        return this.gMU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ve */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.gMU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0337a c0337a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.cNa.getPageContext().getPageActivity()).inflate(d.h.square_dialog_search_item, (ViewGroup) null);
            C0337a c0337a2 = new C0337a();
            c0337a2.gMW = (BarImageView) view.findViewById(d.g.forum_avatar);
            c0337a2.gMW.setGifIconSupport(false);
            c0337a2.bSY = (TextView) view.findViewById(d.g.name);
            c0337a2.gMX = (TextView) view.findViewById(d.g.forum_member_count);
            c0337a2.gMY = (TextView) view.findViewById(d.g.forum_thread_count);
            c0337a2.gMZ = (TextView) view.findViewById(d.g.slogan);
            c0337a2.gMV = view.findViewById(d.g.offical_icon);
            view.setTag(c0337a2);
            c0337a = c0337a2;
        } else {
            c0337a = (C0337a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0337a.gMW.setTag(str2);
            c0337a.gMW.startLoad(str2, 10, false);
            c0337a.gMW.invalidate();
            if (this.gMT) {
                str = this.cNa.getPageContext().getPageActivity().getString(d.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0337a.bSY, str);
            c0337a.gMW.setTag(item.avatar);
            c0337a.gMX.setText(this.cNa.getPageContext().getString(d.j.attention) + " " + vf(item.member_num));
            c0337a.gMY.setText(this.cNa.getPageContext().getString(d.j.text_post) + " " + vf(item.thread_num));
            if (this.gMT || !TextUtils.isEmpty(item.slogan)) {
                c0337a.gMZ.setVisibility(0);
                c0337a.gMZ.setText(item.slogan);
            } else {
                c0337a.gMZ.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0337a.gMV.setVisibility(0);
                al.k(c0337a.gMV, d.f.icon_search_official);
            } else {
                c0337a.gMV.setVisibility(8);
            }
            this.cNa.getLayoutMode().setNightMode(skinType == 1);
            this.cNa.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String vf(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.cNa.getPageContext().getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bic)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bic.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bic.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0337a {
        TextView bSY;
        View gMV;
        BarImageView gMW;
        TextView gMX;
        TextView gMY;
        TextView gMZ;

        private C0337a() {
        }
    }
}
