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
    private String bih;
    private final BaseActivity<?> cNc;
    private final boolean gMG = true;
    private ArrayList<ForumSuggestModel.Forum> gMH;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cNc = baseActivity;
        this.gMH = arrayList;
    }

    public void af(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.gMH = arrayList;
        if (this.gMH != null) {
            notifyDataSetChanged();
        }
    }

    public void yh(String str) {
        this.bih = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gMH == null) {
            return 0;
        }
        return this.gMH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: va */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.gMH.get(i);
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
            view = LayoutInflater.from(this.cNc.getPageContext().getPageActivity()).inflate(d.h.square_dialog_search_item, (ViewGroup) null);
            C0337a c0337a2 = new C0337a();
            c0337a2.gMJ = (BarImageView) view.findViewById(d.g.forum_avatar);
            c0337a2.gMJ.setGifIconSupport(false);
            c0337a2.bTa = (TextView) view.findViewById(d.g.name);
            c0337a2.gMK = (TextView) view.findViewById(d.g.forum_member_count);
            c0337a2.gML = (TextView) view.findViewById(d.g.forum_thread_count);
            c0337a2.gMM = (TextView) view.findViewById(d.g.slogan);
            c0337a2.gMI = view.findViewById(d.g.offical_icon);
            view.setTag(c0337a2);
            c0337a = c0337a2;
        } else {
            c0337a = (C0337a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0337a.gMJ.setTag(str2);
            c0337a.gMJ.startLoad(str2, 10, false);
            c0337a.gMJ.invalidate();
            if (this.gMG) {
                str = this.cNc.getPageContext().getPageActivity().getString(d.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0337a.bTa, str);
            c0337a.gMJ.setTag(item.avatar);
            c0337a.gMK.setText(this.cNc.getPageContext().getString(d.j.attention) + " " + vb(item.member_num));
            c0337a.gML.setText(this.cNc.getPageContext().getString(d.j.text_post) + " " + vb(item.thread_num));
            if (this.gMG || !TextUtils.isEmpty(item.slogan)) {
                c0337a.gMM.setVisibility(0);
                c0337a.gMM.setText(item.slogan);
            } else {
                c0337a.gMM.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0337a.gMI.setVisibility(0);
                al.k(c0337a.gMI, d.f.icon_search_official);
            } else {
                c0337a.gMI.setVisibility(8);
            }
            this.cNc.getLayoutMode().setNightMode(skinType == 1);
            this.cNc.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String vb(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.cNc.getPageContext().getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bih)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bih.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bih.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0337a {
        TextView bTa;
        View gMI;
        BarImageView gMJ;
        TextView gMK;
        TextView gML;
        TextView gMM;

        private C0337a() {
        }
    }
}
