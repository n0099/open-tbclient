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
    private final BaseActivity<?> bBi;
    private final boolean fvV = true;
    private ArrayList<ForumSuggestModel.Forum> fvW;
    private String mKeyWord;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bBi = baseActivity;
        this.fvW = arrayList;
    }

    public void ab(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.fvW = arrayList;
        if (this.fvW != null) {
            notifyDataSetChanged();
        }
    }

    public void rp(String str) {
        this.mKeyWord = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fvW == null) {
            return 0;
        }
        return this.fvW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rt */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.fvW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0269a c0269a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bBi.getPageContext().getPageActivity()).inflate(e.h.square_dialog_search_item, (ViewGroup) null);
            C0269a c0269a2 = new C0269a();
            c0269a2.fvY = (BarImageView) view.findViewById(e.g.forum_avatar);
            c0269a2.fvY.setGifIconSupport(false);
            c0269a2.aJM = (TextView) view.findViewById(e.g.name);
            c0269a2.fvZ = (TextView) view.findViewById(e.g.forum_member_count);
            c0269a2.fwa = (TextView) view.findViewById(e.g.forum_thread_count);
            c0269a2.fwb = (TextView) view.findViewById(e.g.slogan);
            c0269a2.fvX = view.findViewById(e.g.offical_icon);
            view.setTag(c0269a2);
            c0269a = c0269a2;
        } else {
            c0269a = (C0269a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0269a.fvY.setTag(str2);
            c0269a.fvY.startLoad(str2, 10, false);
            c0269a.fvY.invalidate();
            if (this.fvV) {
                str = this.bBi.getPageContext().getPageActivity().getString(e.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0269a.aJM, str);
            c0269a.fvY.setTag(item.avatar);
            c0269a.fvZ.setText(this.bBi.getPageContext().getString(e.j.attention) + " " + ru(item.member_num));
            c0269a.fwa.setText(this.bBi.getPageContext().getString(e.j.text_post) + " " + ru(item.thread_num));
            if (this.fvV || !TextUtils.isEmpty(item.slogan)) {
                c0269a.fwb.setVisibility(0);
                c0269a.fwb.setText(item.slogan);
            } else {
                c0269a.fwb.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0269a.fvX.setVisibility(0);
                al.i(c0269a.fvX, e.f.icon_search_official);
            } else {
                c0269a.fvX.setVisibility(8);
            }
            this.bBi.getLayoutMode().setNightMode(skinType == 1);
            this.bBi.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String ru(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bBi.getPageContext().getString(e.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mKeyWord)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.mKeyWord.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.mKeyWord.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0269a {
        TextView aJM;
        View fvX;
        BarImageView fvY;
        TextView fvZ;
        TextView fwa;
        TextView fwb;

        private C0269a() {
        }
    }
}
