package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity kKy;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.kKy = hotTopicChangeFourmActivity;
        this.mContext = this.kKy.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DZ */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Kv(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return str.substring(0, 13) + StringHelper.STRING_MORE;
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0620a c0620a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0620a = a(view != null ? view.getTag() : null, item);
        } else {
            c0620a = null;
        }
        if (c0620a != null) {
            return c0620a.mRootView;
        }
        return null;
    }

    private C0620a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0620a c0620a;
        if (obj == null) {
            c0620a = cSA();
        } else {
            c0620a = (C0620a) obj;
        }
        c0620a.kKA.setText(Kv(hotTopicBussinessData.mForumName));
        c0620a.kKz.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0620a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0620a.kKA, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0620a.gtk, R.color.cp_bg_line_e);
        return c0620a;
    }

    private C0620a cSA() {
        C0620a c0620a = new C0620a();
        c0620a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0620a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0620a.kKA, (int) R.color.cp_cont_b);
        c0620a.kKA = (TextView) c0620a.mRootView.findViewById(R.id.fourm_tv);
        c0620a.gtk = c0620a.mRootView.findViewById(R.id.line_view);
        c0620a.kKz = (TbImageView) c0620a.mRootView.findViewById(R.id.icon_img);
        c0620a.kKz.setDefaultBgResource(R.color.cp_bg_line_e);
        c0620a.kKz.setDefaultResource(R.drawable.transparent_bg);
        c0620a.kKz.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0620a.mRootView.setTag(c0620a);
        return c0620a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0620a {
        public View gtk;
        public TextView kKA;
        public TbImageView kKz;
        public View mRootView;

        private C0620a() {
        }
    }
}
