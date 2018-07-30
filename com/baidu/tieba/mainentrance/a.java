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
    private final BaseActivity<?> bmZ;
    private final boolean eVT = true;
    private ArrayList<ForumSuggestModel.Forum> eVU;
    private String eVV;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bmZ = baseActivity;
        this.eVU = arrayList;
    }

    public void ac(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.eVU = arrayList;
        if (this.eVU != null) {
            notifyDataSetChanged();
        }
    }

    public void pA(String str) {
        this.eVV = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVU == null) {
            return 0;
        }
        return this.eVU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pr */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eVU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0196a c0196a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bmZ.getPageContext().getPageActivity()).inflate(d.h.square_dialog_search_item, (ViewGroup) null);
            C0196a c0196a2 = new C0196a();
            c0196a2.eVX = (BarImageView) view.findViewById(d.g.forum_avatar);
            c0196a2.eVX.setGifIconSupport(false);
            c0196a2.axT = (TextView) view.findViewById(d.g.name);
            c0196a2.eVY = (TextView) view.findViewById(d.g.forum_member_count);
            c0196a2.eVZ = (TextView) view.findViewById(d.g.forum_thread_count);
            c0196a2.eWa = (TextView) view.findViewById(d.g.slogan);
            c0196a2.eVW = view.findViewById(d.g.offical_icon);
            view.setTag(c0196a2);
            c0196a = c0196a2;
        } else {
            c0196a = (C0196a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0196a.eVX.setTag(str2);
            c0196a.eVX.startLoad(str2, 10, false);
            c0196a.eVX.invalidate();
            if (this.eVT) {
                str = this.bmZ.getPageContext().getPageActivity().getString(d.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0196a.axT, str);
            c0196a.eVX.setTag(item.avatar);
            c0196a.eVY.setText(this.bmZ.getPageContext().getString(d.j.attention) + " " + ps(item.member_num));
            c0196a.eVZ.setText(this.bmZ.getPageContext().getString(d.j.text_post) + " " + ps(item.thread_num));
            if (this.eVT || !TextUtils.isEmpty(item.slogan)) {
                c0196a.eWa.setVisibility(0);
                c0196a.eWa.setText(item.slogan);
            } else {
                c0196a.eWa.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0196a.eVW.setVisibility(0);
                am.i(c0196a.eVW, d.f.icon_search_official);
            } else {
                c0196a.eVW.setVisibility(8);
            }
            this.bmZ.getLayoutMode().setNightMode(skinType == 1);
            this.bmZ.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String ps(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bmZ.getPageContext().getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eVV)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eVV.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eVV.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0196a {
        TextView axT;
        View eVW;
        BarImageView eVX;
        TextView eVY;
        TextView eVZ;
        TextView eWa;

        private C0196a() {
        }
    }
}
