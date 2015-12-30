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
    private final BaseActivity<?> bbA;
    private final boolean coN = true;
    private ArrayList<ForumSuggestModel.Forum> coO;
    private String coP;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bbA = baseActivity;
        this.coO = arrayList;
    }

    public void N(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.coO = arrayList;
        if (this.coO != null) {
            notifyDataSetChanged();
        }
    }

    public void jE(String str) {
        this.coP = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.coO == null) {
            return 0;
        }
        return this.coO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jE */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.coO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0067a c0067a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.bbA.getPageContext().getPageActivity()).inflate(n.h.square_dialog_search_item, (ViewGroup) null);
            C0067a c0067a2 = new C0067a(this, null);
            c0067a2.cnQ = (BarImageView) view.findViewById(n.g.forum_avatar);
            c0067a2.cnQ.setGifIconSupport(false);
            c0067a2.aNz = (TextView) view.findViewById(n.g.name);
            c0067a2.cnR = (TextView) view.findViewById(n.g.forum_member_count);
            c0067a2.cnS = (TextView) view.findViewById(n.g.forum_thread_count);
            c0067a2.cmn = (TextView) view.findViewById(n.g.slogan);
            view.setTag(c0067a2);
            c0067a = c0067a2;
        } else {
            c0067a = (C0067a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            c0067a.cnQ.setTag(str2);
            c0067a.cnQ.d(str2, 10, false);
            c0067a.cnQ.invalidate();
            if (this.coN) {
                str = this.bbA.getPageContext().getPageActivity().getString(n.j.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0067a.aNz, str);
            c0067a.cnQ.setTag(item.avatar);
            c0067a.cnR.setText(String.valueOf(this.bbA.getPageContext().getString(n.j.forum_list_attention_tv)) + " " + jF(item.member_num));
            c0067a.cnS.setText(String.valueOf(this.bbA.getPageContext().getString(n.j.forum_list_thread_tv)) + " " + jF(item.thread_num));
            if (this.coN || !TextUtils.isEmpty(item.slogan)) {
                c0067a.cmn.setVisibility(0);
                c0067a.cmn.setText(item.slogan);
            } else {
                c0067a.cmn.setVisibility(8);
            }
            this.bbA.getLayoutMode().ac(skinType == 1);
            this.bbA.getLayoutMode().k(view);
        }
        return view;
    }

    public String jF(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.bbA.getPageContext().getString(n.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.coP)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.coP.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.coP.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0067a {
        TextView aNz;
        TextView cmn;
        BarImageView cnQ;
        TextView cnR;
        TextView cnS;

        private C0067a() {
        }

        /* synthetic */ C0067a(a aVar, C0067a c0067a) {
            this();
        }
    }
}
