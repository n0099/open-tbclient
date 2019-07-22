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
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String boY;
    private final BaseActivity<?> cWM;
    private final boolean hkr = true;
    private ArrayList<ForumSuggestModel.Forum> hks;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cWM = baseActivity;
        this.hks = arrayList;
    }

    public void aj(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.hks = arrayList;
        if (this.hks != null) {
            notifyDataSetChanged();
        }
    }

    public void Ak(String str) {
        this.boY = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hks == null) {
            return 0;
        }
        return this.hks.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wK */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hks.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0354a c0354a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.cWM.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0354a c0354a2 = new C0354a();
            c0354a2.hku = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0354a2.hku.setGifIconSupport(false);
            c0354a2.cbW = (TextView) view.findViewById(R.id.name);
            c0354a2.hkv = (TextView) view.findViewById(R.id.forum_member_count);
            c0354a2.hkw = (TextView) view.findViewById(R.id.forum_thread_count);
            c0354a2.hkx = (TextView) view.findViewById(R.id.slogan);
            c0354a2.hkt = view.findViewById(R.id.offical_icon);
            view.setTag(c0354a2);
            c0354a = c0354a2;
        } else {
            c0354a = (C0354a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0354a.hku.setTag(str2);
            c0354a.hku.startLoad(str2, 10, false);
            c0354a.hku.invalidate();
            if (this.hkr) {
                str = this.cWM.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0354a.cbW, str);
            c0354a.hku.setTag(item.avatar);
            c0354a.hkv.setText(this.cWM.getPageContext().getString(R.string.attention) + " " + wL(item.member_num));
            c0354a.hkw.setText(this.cWM.getPageContext().getString(R.string.text_post) + " " + wL(item.thread_num));
            if (this.hkr || !TextUtils.isEmpty(item.slogan)) {
                c0354a.hkx.setVisibility(0);
                c0354a.hkx.setText(item.slogan);
            } else {
                c0354a.hkx.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0354a.hkt.setVisibility(0);
                am.k(c0354a.hkt, R.drawable.icon_search_official);
            } else {
                c0354a.hkt.setVisibility(8);
            }
            this.cWM.getLayoutMode().setNightMode(skinType == 1);
            this.cWM.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String wL(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.cWM.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.boY)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.boY.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.boY.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0354a {
        TextView cbW;
        View hkt;
        BarImageView hku;
        TextView hkv;
        TextView hkw;
        TextView hkx;

        private C0354a() {
        }
    }
}
