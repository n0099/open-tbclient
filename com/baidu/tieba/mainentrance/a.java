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
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> aRT;
    private final boolean bTK = true;
    private ArrayList<ForumSuggestModel.Forum> bTL;
    private String bTM;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.aRT = baseActivity;
        this.bTL = arrayList;
    }

    public void I(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bTL = arrayList;
        if (this.bTL != null) {
            notifyDataSetChanged();
        }
    }

    public void iT(String str) {
        this.bTM = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bTL == null) {
            return 0;
        }
        return this.bTL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hY */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bTL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0065a c0065a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.aRT.getPageContext().getPageActivity()).inflate(i.g.square_dialog_search_item, (ViewGroup) null);
            C0065a c0065a2 = new C0065a(this, null);
            c0065a2.bSS = (BarImageView) view.findViewById(i.f.forum_avatar);
            c0065a2.bSS.setGifIconSupport(false);
            c0065a2.aNr = (TextView) view.findViewById(i.f.name);
            c0065a2.bST = (TextView) view.findViewById(i.f.forum_member_count);
            c0065a2.bSU = (TextView) view.findViewById(i.f.forum_thread_count);
            c0065a2.bRp = (TextView) view.findViewById(i.f.slogan);
            view.setTag(c0065a2);
            c0065a = c0065a2;
        } else {
            c0065a = (C0065a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0065a.bSS.setTag(str2);
            c0065a.bSS.d(str2, 10, false);
            c0065a.bSS.invalidate();
            if (this.bTK) {
                str = this.aRT.getPageContext().getPageActivity().getString(i.h.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0065a.aNr, str);
            c0065a.bSS.setTag(item.avatar);
            c0065a.bST.setText(String.valueOf(this.aRT.getPageContext().getString(i.h.forum_list_attention_tv)) + " " + hZ(item.member_num));
            c0065a.bSU.setText(String.valueOf(this.aRT.getPageContext().getString(i.h.forum_list_thread_tv)) + " " + hZ(item.thread_num));
            if (this.bTK || !TextUtils.isEmpty(item.slogan)) {
                c0065a.bRp.setVisibility(0);
                c0065a.bRp.setText(item.slogan);
            } else {
                c0065a.bRp.setVisibility(8);
            }
            this.aRT.getLayoutMode().ad(skinType == 1);
            this.aRT.getLayoutMode().k(view);
        }
        return view;
    }

    public String hZ(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.aRT.getPageContext().getString(i.h.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bTM)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bTM.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bTM.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0065a {
        TextView aNr;
        TextView bRp;
        BarImageView bSS;
        TextView bST;
        TextView bSU;

        private C0065a() {
        }

        /* synthetic */ C0065a(a aVar, C0065a c0065a) {
            this();
        }
    }
}
