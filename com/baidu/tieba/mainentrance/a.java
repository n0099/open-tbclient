package com.baidu.tieba.mainentrance;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private String csS;
    private final boolean icE = true;
    private ArrayList<ForumSuggestModel.Forum> icF;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.icF = arrayList;
    }

    public void ay(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.icF = arrayList;
        if (this.icF != null) {
            notifyDataSetChanged();
        }
    }

    public void DW(String str) {
        this.csS = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.icF == null) {
            return 0;
        }
        return this.icF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xC */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.icF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0551a c0551a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0551a c0551a2 = new C0551a();
            c0551a2.icH = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0551a2.icH.setGifIconSupport(false);
            c0551a2.ddX = (TextView) view.findViewById(R.id.name);
            c0551a2.icI = (TextView) view.findViewById(R.id.forum_member_count);
            c0551a2.icJ = (TextView) view.findViewById(R.id.forum_thread_count);
            c0551a2.icK = (TextView) view.findViewById(R.id.slogan);
            c0551a2.icG = view.findViewById(R.id.offical_icon);
            view.setTag(c0551a2);
            c0551a = c0551a2;
        } else {
            c0551a = (C0551a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0551a.icH.setTag(str2);
            c0551a.icH.startLoad(str2, 10, false);
            c0551a.icH.invalidate();
            if (this.icE) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0551a.ddX, str);
            c0551a.icH.setTag(item.avatar);
            c0551a.icI.setText(this.mActivity.getPageContext().getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xD(item.member_num));
            c0551a.icJ.setText(this.mActivity.getPageContext().getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xD(item.thread_num));
            if (this.icE || !TextUtils.isEmpty(item.slogan)) {
                c0551a.icK.setVisibility(0);
                c0551a.icK.setText(item.slogan);
            } else {
                c0551a.icK.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0551a.icG.setVisibility(0);
                am.setBackgroundResource(c0551a.icG, R.drawable.icon_search_official);
            } else {
                c0551a.icG.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String xD(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.csS)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.csS.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.csS.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0551a {
        TextView ddX;
        View icG;
        BarImageView icH;
        TextView icI;
        TextView icJ;
        TextView icK;

        private C0551a() {
        }
    }
}
