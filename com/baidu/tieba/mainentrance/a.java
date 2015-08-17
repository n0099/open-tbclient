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
    private final BaseActivity<?> aSJ;
    private final boolean bPC = true;
    private ArrayList<ForumSuggestModel.Forum> bPD;
    private String bPE;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.aSJ = baseActivity;
        this.bPD = arrayList;
    }

    public void J(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bPD = arrayList;
        if (this.bPD != null) {
            notifyDataSetChanged();
        }
    }

    public void iz(String str) {
        this.bPE = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bPD == null) {
            return 0;
        }
        return this.bPD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hG */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bPD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0064a c0064a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.aSJ.getPageContext().getPageActivity()).inflate(i.g.square_dialog_search_item, (ViewGroup) null);
            C0064a c0064a2 = new C0064a(this, null);
            c0064a2.bOK = (BarImageView) view.findViewById(i.f.forum_avatar);
            c0064a2.bOK.setGifIconSupport(false);
            c0064a2.aOi = (TextView) view.findViewById(i.f.name);
            c0064a2.bOL = (TextView) view.findViewById(i.f.member_count);
            c0064a2.bOM = (TextView) view.findViewById(i.f.thread_count);
            c0064a2.bNg = (TextView) view.findViewById(i.f.slogan);
            view.setTag(c0064a2);
            c0064a = c0064a2;
        } else {
            c0064a = (C0064a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0064a.bOK.setTag(str2);
            c0064a.bOK.d(str2, 10, false);
            c0064a.bOK.invalidate();
            if (this.bPC) {
                str = this.aSJ.getPageContext().getPageActivity().getString(i.C0057i.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            b(c0064a.aOi, str);
            c0064a.bOK.setTag(item.avatar);
            c0064a.bOL.setText(String.valueOf(this.aSJ.getPageContext().getString(i.C0057i.forum_list_attention_tv)) + " " + hH(item.member_num));
            c0064a.bOM.setText(String.valueOf(this.aSJ.getPageContext().getString(i.C0057i.forum_list_thread_tv)) + " " + hH(item.thread_num));
            if (this.bPC || !TextUtils.isEmpty(item.slogan)) {
                c0064a.bNg.setVisibility(0);
                c0064a.bNg.setText(item.slogan);
            } else {
                c0064a.bNg.setVisibility(8);
            }
            this.aSJ.getLayoutMode().ad(skinType == 1);
            this.aSJ.getLayoutMode().k(view);
        }
        return view;
    }

    public String hH(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.aSJ.getPageContext().getString(i.C0057i.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bPE)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bPE.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bPE.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064a {
        TextView aOi;
        TextView bNg;
        BarImageView bOK;
        TextView bOL;
        TextView bOM;

        private C0064a() {
        }

        /* synthetic */ C0064a(a aVar, C0064a c0064a) {
            this();
        }
    }
}
