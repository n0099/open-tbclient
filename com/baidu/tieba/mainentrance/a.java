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
import com.baidu.tieba.f;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> bnc;
    private final boolean eVO = true;
    private ArrayList<ForumSuggestModel.Forum> eVP;
    private String eVQ;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bnc = baseActivity;
        this.eVP = arrayList;
    }

    public void ac(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.eVP = arrayList;
        if (this.eVP != null) {
            notifyDataSetChanged();
        }
    }

    public void pC(String str) {
        this.eVQ = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVP == null) {
            return 0;
        }
        return this.eVP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pr */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eVP.get(i);
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
            view = LayoutInflater.from(this.bnc.getPageContext().getPageActivity()).inflate(f.h.square_dialog_search_item, (ViewGroup) null);
            C0196a c0196a2 = new C0196a();
            c0196a2.eVS = (BarImageView) view.findViewById(f.g.forum_avatar);
            c0196a2.eVS.setGifIconSupport(false);
            c0196a2.axQ = (TextView) view.findViewById(f.g.name);
            c0196a2.eVT = (TextView) view.findViewById(f.g.forum_member_count);
            c0196a2.eVU = (TextView) view.findViewById(f.g.forum_thread_count);
            c0196a2.eVV = (TextView) view.findViewById(f.g.slogan);
            c0196a2.eVR = view.findViewById(f.g.offical_icon);
            view.setTag(c0196a2);
            c0196a = c0196a2;
        } else {
            c0196a = (C0196a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0196a.eVS.setTag(str2);
            c0196a.eVS.startLoad(str2, 10, false);
            c0196a.eVS.invalidate();
            if (this.eVO) {
                str = this.bnc.getPageContext().getPageActivity().getString(f.j.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0196a.axQ, str);
            c0196a.eVS.setTag(item.avatar);
            c0196a.eVT.setText(this.bnc.getPageContext().getString(f.j.attention) + " " + ps(item.member_num));
            c0196a.eVU.setText(this.bnc.getPageContext().getString(f.j.text_post) + " " + ps(item.thread_num));
            if (this.eVO || !TextUtils.isEmpty(item.slogan)) {
                c0196a.eVV.setVisibility(0);
                c0196a.eVV.setText(item.slogan);
            } else {
                c0196a.eVV.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0196a.eVR.setVisibility(0);
                am.i(c0196a.eVR, f.C0146f.icon_search_official);
            } else {
                c0196a.eVR.setVisibility(8);
            }
            this.bnc.getLayoutMode().setNightMode(skinType == 1);
            this.bnc.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String ps(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bnc.getPageContext().getString(f.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eVQ)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eVQ.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(f.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eVQ.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0196a {
        TextView axQ;
        View eVR;
        BarImageView eVS;
        TextView eVT;
        TextView eVU;
        TextView eVV;

        private C0196a() {
        }
    }
}
