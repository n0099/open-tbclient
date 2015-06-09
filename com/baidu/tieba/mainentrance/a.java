package com.baidu.tieba.mainentrance;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final boolean bBt = true;
    private ArrayList<ForumSuggestModel.Forum> bBu;
    private String bBv;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.bBu = arrayList;
    }

    public void D(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bBu = arrayList;
        if (this.bBu != null) {
            notifyDataSetChanged();
        }
    }

    public void hW(String str) {
        this.bBv = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBu == null) {
            return 0;
        }
        return this.bBu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hc */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bBu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.square_dialog_search_item, null);
            b bVar2 = new b(this, null);
            bVar2.bAS = (BarImageView) view.findViewById(com.baidu.tieba.q.forum_avatar);
            bVar2.bAS.setGifIconSupport(false);
            bVar2.aGI = (TextView) view.findViewById(com.baidu.tieba.q.name);
            bVar2.bAT = (TextView) view.findViewById(com.baidu.tieba.q.member_count);
            bVar2.bAU = (TextView) view.findViewById(com.baidu.tieba.q.thread_count);
            bVar2.bzq = (TextView) view.findViewById(com.baidu.tieba.q.slogan);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            bVar.bAS.setTag(str2);
            bVar.bAS.c(str2, 10, false);
            bVar.bAS.invalidate();
            if (this.bBt) {
                str = this.mActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.t.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            b(bVar.aGI, str);
            bVar.bAS.setTag(item.avatar);
            bVar.bAT.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.t.forum_list_attention_tv)) + " " + hd(item.member_num));
            bVar.bAU.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.t.forum_list_thread_tv)) + " " + hd(item.thread_num));
            if (this.bBt || !TextUtils.isEmpty(item.slogan)) {
                bVar.bzq.setVisibility(0);
                bVar.bzq.setText(item.slogan);
            } else {
                bVar.bzq.setVisibility(8);
            }
            this.mActivity.getLayoutMode().ab(skinType == 1);
            this.mActivity.getLayoutMode().j(view);
        }
        return view;
    }

    public String hd(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.mActivity.getPageContext().getString(com.baidu.tieba.t.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bBv)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bBv.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bBv.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
