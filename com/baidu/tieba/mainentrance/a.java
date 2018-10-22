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
    private final BaseActivity<?> bwX;
    private final boolean fkT = true;
    private ArrayList<ForumSuggestModel.Forum> fkU;
    private String fkV;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bwX = baseActivity;
        this.fkU = arrayList;
    }

    public void ac(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fkU = arrayList;
        if (this.fkU != null) {
            notifyDataSetChanged();
        }
    }

    public void qJ(String str) {
        this.fkV = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkU == null) {
            return 0;
        }
        return this.fkU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qt */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fkU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0232a c0232a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bwX.getPageContext().getPageActivity()).inflate(e.h.square_dialog_search_item, (ViewGroup) null);
            C0232a c0232a2 = new C0232a();
            c0232a2.fkX = (BarImageView) view.findViewById(e.g.forum_avatar);
            c0232a2.fkX.setGifIconSupport(false);
            c0232a2.aFu = (TextView) view.findViewById(e.g.name);
            c0232a2.fkY = (TextView) view.findViewById(e.g.forum_member_count);
            c0232a2.fkZ = (TextView) view.findViewById(e.g.forum_thread_count);
            c0232a2.fla = (TextView) view.findViewById(e.g.slogan);
            c0232a2.fkW = view.findViewById(e.g.offical_icon);
            view.setTag(c0232a2);
            c0232a = c0232a2;
        } else {
            c0232a = (C0232a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0232a.fkX.setTag(str2);
            c0232a.fkX.startLoad(str2, 10, false);
            c0232a.fkX.invalidate();
            if (this.fkT) {
                str = this.bwX.getPageContext().getPageActivity().getString(e.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0232a.aFu, str);
            c0232a.fkX.setTag(item.avatar);
            c0232a.fkY.setText(this.bwX.getPageContext().getString(e.j.attention) + " " + qu(item.member_num));
            c0232a.fkZ.setText(this.bwX.getPageContext().getString(e.j.text_post) + " " + qu(item.thread_num));
            if (this.fkT || !TextUtils.isEmpty(item.slogan)) {
                c0232a.fla.setVisibility(0);
                c0232a.fla.setText(item.slogan);
            } else {
                c0232a.fla.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0232a.fkW.setVisibility(0);
                al.i(c0232a.fkW, e.f.icon_search_official);
            } else {
                c0232a.fkW.setVisibility(8);
            }
            this.bwX.getLayoutMode().setNightMode(skinType == 1);
            this.bwX.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String qu(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bwX.getPageContext().getString(e.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fkV)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fkV.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fkV.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0232a {
        TextView aFu;
        View fkW;
        BarImageView fkX;
        TextView fkY;
        TextView fkZ;
        TextView fla;

        private C0232a() {
        }
    }
}
