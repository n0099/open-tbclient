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
    private final BaseActivity<?> bSO;
    private final boolean fhb = true;
    private ArrayList<ForumSuggestModel.Forum> fhc;
    private String fhd;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bSO = baseActivity;
        this.fhc = arrayList;
    }

    public void X(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fhc = arrayList;
        if (this.fhc != null) {
            notifyDataSetChanged();
        }
    }

    public void oC(String str) {
        this.fhd = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fhc == null) {
            return 0;
        }
        return this.fhc.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ro */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fhc.get(i);
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
            view = LayoutInflater.from(this.bSO.getPageContext().getPageActivity()).inflate(d.h.square_dialog_search_item, (ViewGroup) null);
            C0196a c0196a2 = new C0196a();
            c0196a2.fhf = (BarImageView) view.findViewById(d.g.forum_avatar);
            c0196a2.fhf.setGifIconSupport(false);
            c0196a2.beO = (TextView) view.findViewById(d.g.name);
            c0196a2.fhg = (TextView) view.findViewById(d.g.forum_member_count);
            c0196a2.fhh = (TextView) view.findViewById(d.g.forum_thread_count);
            c0196a2.fhi = (TextView) view.findViewById(d.g.slogan);
            c0196a2.fhe = view.findViewById(d.g.offical_icon);
            view.setTag(c0196a2);
            c0196a = c0196a2;
        } else {
            c0196a = (C0196a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0196a.fhf.setTag(str2);
            c0196a.fhf.startLoad(str2, 10, false);
            c0196a.fhf.invalidate();
            if (this.fhb) {
                str = this.bSO.getPageContext().getPageActivity().getString(d.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            b(c0196a.beO, str);
            c0196a.fhf.setTag(item.avatar);
            c0196a.fhg.setText(this.bSO.getPageContext().getString(d.j.attention) + " " + rp(item.member_num));
            c0196a.fhh.setText(this.bSO.getPageContext().getString(d.j.text_post) + " " + rp(item.thread_num));
            if (this.fhb || !TextUtils.isEmpty(item.slogan)) {
                c0196a.fhi.setVisibility(0);
                c0196a.fhi.setText(item.slogan);
            } else {
                c0196a.fhi.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0196a.fhe.setVisibility(0);
                aj.s(c0196a.fhe, d.f.icon_search_official);
            } else {
                c0196a.fhe.setVisibility(8);
            }
            this.bSO.getLayoutMode().aQ(skinType == 1);
            this.bSO.getLayoutMode().aM(view);
        }
        return view;
    }

    public String rp(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bSO.getPageContext().getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.fhd)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.fhd.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0140d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.fhd.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0196a {
        TextView beO;
        View fhe;
        BarImageView fhf;
        TextView fhg;
        TextView fhh;
        TextView fhi;

        private C0196a() {
        }
    }
}
