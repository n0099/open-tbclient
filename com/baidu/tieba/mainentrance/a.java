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
    private final boolean bBs = true;
    private ArrayList<ForumSuggestModel.Forum> bBt;
    private String bBu;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.bBt = arrayList;
    }

    public void D(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bBt = arrayList;
        if (this.bBt != null) {
            notifyDataSetChanged();
        }
    }

    public void hW(String str) {
        this.bBu = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBt == null) {
            return 0;
        }
        return this.bBt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hc */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bBt.get(i);
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
            bVar2.bAR = (BarImageView) view.findViewById(com.baidu.tieba.q.forum_avatar);
            bVar2.bAR.setGifIconSupport(false);
            bVar2.aGH = (TextView) view.findViewById(com.baidu.tieba.q.name);
            bVar2.bAS = (TextView) view.findViewById(com.baidu.tieba.q.member_count);
            bVar2.bAT = (TextView) view.findViewById(com.baidu.tieba.q.thread_count);
            bVar2.bzp = (TextView) view.findViewById(com.baidu.tieba.q.slogan);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str2 = item.avatar;
            bVar.bAR.setTag(str2);
            bVar.bAR.c(str2, 10, false);
            bVar.bAR.invalidate();
            if (this.bBs) {
                str = this.mActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.t.official_msg_list_name, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            b(bVar.aGH, str);
            bVar.bAR.setTag(item.avatar);
            bVar.bAS.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.t.forum_list_attention_tv)) + " " + hd(item.member_num));
            bVar.bAT.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.t.forum_list_thread_tv)) + " " + hd(item.thread_num));
            if (this.bBs || !TextUtils.isEmpty(item.slogan)) {
                bVar.bzp.setVisibility(0);
                bVar.bzp.setText(item.slogan);
            } else {
                bVar.bzp.setVisibility(8);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bBu)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bBu.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bBu.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
