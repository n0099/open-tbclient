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
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> aXA;
    private final boolean ckJ = true;
    private ArrayList<ForumSuggestModel.Forum> ckK;
    private String ckL;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.aXA = baseActivity;
        this.ckK = arrayList;
    }

    public void O(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.ckK = arrayList;
        if (this.ckK != null) {
            notifyDataSetChanged();
        }
    }

    public void jq(String str) {
        this.ckL = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ckK == null) {
            return 0;
        }
        return this.ckK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jg */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.ckK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0073a c0073a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.aXA.getPageContext().getPageActivity()).inflate(n.g.square_dialog_search_item, (ViewGroup) null);
            C0073a c0073a2 = new C0073a(this, null);
            c0073a2.cjM = (BarImageView) view.findViewById(n.f.forum_avatar);
            c0073a2.cjM.setGifIconSupport(false);
            c0073a2.aLY = (TextView) view.findViewById(n.f.name);
            c0073a2.cjN = (TextView) view.findViewById(n.f.forum_member_count);
            c0073a2.cjO = (TextView) view.findViewById(n.f.forum_thread_count);
            c0073a2.cii = (TextView) view.findViewById(n.f.slogan);
            view.setTag(c0073a2);
            c0073a = c0073a2;
        } else {
            c0073a = (C0073a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0073a.cjM.setTag(str2);
            c0073a.cjM.d(str2, 10, false);
            c0073a.cjM.invalidate();
            if (this.ckJ) {
                str = this.aXA.getPageContext().getPageActivity().getString(n.i.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0073a.aLY, str);
            c0073a.cjM.setTag(item.avatar);
            c0073a.cjN.setText(String.valueOf(this.aXA.getPageContext().getString(n.i.forum_list_attention_tv)) + " " + jh(item.member_num));
            c0073a.cjO.setText(String.valueOf(this.aXA.getPageContext().getString(n.i.forum_list_thread_tv)) + " " + jh(item.thread_num));
            if (this.ckJ || !TextUtils.isEmpty(item.slogan)) {
                c0073a.cii.setVisibility(0);
                c0073a.cii.setText(item.slogan);
            } else {
                c0073a.cii.setVisibility(8);
            }
            this.aXA.getLayoutMode().af(skinType == 1);
            this.aXA.getLayoutMode().k(view);
        }
        return view;
    }

    public String jh(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.aXA.getPageContext().getString(n.i.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.ckL)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.ckL.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.ckL.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0073a {
        TextView aLY;
        TextView cii;
        BarImageView cjM;
        TextView cjN;
        TextView cjO;

        private C0073a() {
        }

        /* synthetic */ C0073a(a aVar, C0073a c0073a) {
            this();
        }
    }
}
