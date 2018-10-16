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
    private final boolean fkS = true;
    private ArrayList<ForumSuggestModel.Forum> fkT;
    private String fkU;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bwX = baseActivity;
        this.fkT = arrayList;
    }

    public void ac(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fkT = arrayList;
        if (this.fkT != null) {
            notifyDataSetChanged();
        }
    }

    public void qJ(String str) {
        this.fkU = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkT == null) {
            return 0;
        }
        return this.fkT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qt */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fkT.get(i);
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
            c0232a2.fkW = (BarImageView) view.findViewById(e.g.forum_avatar);
            c0232a2.fkW.setGifIconSupport(false);
            c0232a2.aFu = (TextView) view.findViewById(e.g.name);
            c0232a2.fkX = (TextView) view.findViewById(e.g.forum_member_count);
            c0232a2.fkY = (TextView) view.findViewById(e.g.forum_thread_count);
            c0232a2.fkZ = (TextView) view.findViewById(e.g.slogan);
            c0232a2.fkV = view.findViewById(e.g.offical_icon);
            view.setTag(c0232a2);
            c0232a = c0232a2;
        } else {
            c0232a = (C0232a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0232a.fkW.setTag(str2);
            c0232a.fkW.startLoad(str2, 10, false);
            c0232a.fkW.invalidate();
            if (this.fkS) {
                str = this.bwX.getPageContext().getPageActivity().getString(e.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0232a.aFu, str);
            c0232a.fkW.setTag(item.avatar);
            c0232a.fkX.setText(this.bwX.getPageContext().getString(e.j.attention) + " " + qu(item.member_num));
            c0232a.fkY.setText(this.bwX.getPageContext().getString(e.j.text_post) + " " + qu(item.thread_num));
            if (this.fkS || !TextUtils.isEmpty(item.slogan)) {
                c0232a.fkZ.setVisibility(0);
                c0232a.fkZ.setText(item.slogan);
            } else {
                c0232a.fkZ.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0232a.fkV.setVisibility(0);
                al.i(c0232a.fkV, e.f.icon_search_official);
            } else {
                c0232a.fkV.setVisibility(8);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fkU)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fkU.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fkU.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0232a {
        TextView aFu;
        View fkV;
        BarImageView fkW;
        TextView fkX;
        TextView fkY;
        TextView fkZ;

        private C0232a() {
        }
    }
}
