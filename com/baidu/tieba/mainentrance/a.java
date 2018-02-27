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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> bSC;
    private final boolean fgP = true;
    private ArrayList<ForumSuggestModel.Forum> fgQ;
    private String fgR;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bSC = baseActivity;
        this.fgQ = arrayList;
    }

    public void X(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fgQ = arrayList;
        if (this.fgQ != null) {
            notifyDataSetChanged();
        }
    }

    public void oC(String str) {
        this.fgR = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fgQ == null) {
            return 0;
        }
        return this.fgQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rp */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fgQ.get(i);
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
            view = LayoutInflater.from(this.bSC.getPageContext().getPageActivity()).inflate(d.h.square_dialog_search_item, (ViewGroup) null);
            C0197a c0197a2 = new C0197a();
            c0197a2.fgT = (BarImageView) view.findViewById(d.g.forum_avatar);
            c0197a2.fgT.setGifIconSupport(false);
            c0197a2.beC = (TextView) view.findViewById(d.g.name);
            c0197a2.fgU = (TextView) view.findViewById(d.g.forum_member_count);
            c0197a2.fgV = (TextView) view.findViewById(d.g.forum_thread_count);
            c0197a2.fgW = (TextView) view.findViewById(d.g.slogan);
            c0197a2.fgS = view.findViewById(d.g.offical_icon);
            view.setTag(c0197a2);
            c0197a = c0197a2;
        } else {
            c0197a = (C0197a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0197a.fgT.setTag(str2);
            c0197a.fgT.startLoad(str2, 10, false);
            c0197a.fgT.invalidate();
            if (this.fgP) {
                str = this.bSC.getPageContext().getPageActivity().getString(d.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            b(c0197a.beC, str);
            c0197a.fgT.setTag(item.avatar);
            c0197a.fgU.setText(this.bSC.getPageContext().getString(d.j.attention) + " " + rq(item.member_num));
            c0197a.fgV.setText(this.bSC.getPageContext().getString(d.j.text_post) + " " + rq(item.thread_num));
            if (this.fgP || !TextUtils.isEmpty(item.slogan)) {
                c0197a.fgW.setVisibility(0);
                c0197a.fgW.setText(item.slogan);
            } else {
                c0197a.fgW.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0197a.fgS.setVisibility(0);
                aj.s(c0197a.fgS, d.f.icon_search_official);
            } else {
                c0197a.fgS.setVisibility(8);
            }
            this.bSC.getLayoutMode().aQ(skinType == 1);
            this.bSC.getLayoutMode().aM(view);
        }
        return view;
    }

    public String rq(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bSC.getPageContext().getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fgR)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fgR.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0141d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fgR.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0197a {
        TextView beC;
        View fgS;
        BarImageView fgT;
        TextView fgU;
        TextView fgV;
        TextView fgW;

        private C0197a() {
        }
    }
}
