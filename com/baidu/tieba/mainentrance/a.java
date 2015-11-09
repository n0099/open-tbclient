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
    private final BaseActivity<?> aSm;
    private final boolean bUw = true;
    private ArrayList<ForumSuggestModel.Forum> bUx;
    private String bUy;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.aSm = baseActivity;
        this.bUx = arrayList;
    }

    public void I(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bUx = arrayList;
        if (this.bUx != null) {
            notifyDataSetChanged();
        }
    }

    public void iV(String str) {
        this.bUy = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bUx == null) {
            return 0;
        }
        return this.bUx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: im */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bUx.get(i);
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
            view = LayoutInflater.from(this.aSm.getPageContext().getPageActivity()).inflate(i.g.square_dialog_search_item, (ViewGroup) null);
            C0065a c0065a2 = new C0065a(this, null);
            c0065a2.bTy = (BarImageView) view.findViewById(i.f.forum_avatar);
            c0065a2.bTy.setGifIconSupport(false);
            c0065a2.aNK = (TextView) view.findViewById(i.f.name);
            c0065a2.bTz = (TextView) view.findViewById(i.f.forum_member_count);
            c0065a2.bTA = (TextView) view.findViewById(i.f.forum_thread_count);
            c0065a2.bRV = (TextView) view.findViewById(i.f.slogan);
            view.setTag(c0065a2);
            c0065a = c0065a2;
        } else {
            c0065a = (C0065a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0065a.bTy.setTag(str2);
            c0065a.bTy.d(str2, 10, false);
            c0065a.bTy.invalidate();
            if (this.bUw) {
                str = this.aSm.getPageContext().getPageActivity().getString(i.h.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0065a.aNK, str);
            c0065a.bTy.setTag(item.avatar);
            c0065a.bTz.setText(String.valueOf(this.aSm.getPageContext().getString(i.h.forum_list_attention_tv)) + " " + in(item.member_num));
            c0065a.bTA.setText(String.valueOf(this.aSm.getPageContext().getString(i.h.forum_list_thread_tv)) + " " + in(item.thread_num));
            if (this.bUw || !TextUtils.isEmpty(item.slogan)) {
                c0065a.bRV.setVisibility(0);
                c0065a.bRV.setText(item.slogan);
            } else {
                c0065a.bRV.setVisibility(8);
            }
            this.aSm.getLayoutMode().ad(skinType == 1);
            this.aSm.getLayoutMode().k(view);
        }
        return view;
    }

    public String in(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.aSm.getPageContext().getString(i.h.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bUy)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bUy.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bUy.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0065a {
        TextView aNK;
        TextView bRV;
        TextView bTA;
        BarImageView bTy;
        TextView bTz;

        private C0065a() {
        }

        /* synthetic */ C0065a(a aVar, C0065a c0065a) {
            this();
        }
    }
}
