package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity jPm;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.jPm = hotTopicChangeFourmActivity;
        this.mContext = this.jPm.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Db */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String GL(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return str.substring(0, 13) + "...";
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0434a c0434a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0434a = a(view != null ? view.getTag() : null, item);
        } else {
            c0434a = null;
        }
        if (c0434a != null) {
            return c0434a.mRootView;
        }
        return null;
    }

    private C0434a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0434a c0434a;
        if (obj == null) {
            c0434a = cAH();
        } else {
            c0434a = (C0434a) obj;
        }
        c0434a.jPo.setText(GL(hotTopicBussinessData.mForumName));
        c0434a.jPn.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.k(c0434a.mRootView, R.drawable.select_forum_item_bg);
        am.j(c0434a.jPo, R.color.cp_cont_b);
        am.l(c0434a.fDO, R.color.cp_bg_line_e);
        return c0434a;
    }

    private C0434a cAH() {
        C0434a c0434a = new C0434a();
        c0434a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.k(c0434a.mRootView, R.drawable.select_forum_item_bg);
        am.j(c0434a.jPo, R.color.cp_cont_b);
        c0434a.jPo = (TextView) c0434a.mRootView.findViewById(R.id.fourm_tv);
        c0434a.fDO = c0434a.mRootView.findViewById(R.id.line_view);
        c0434a.jPn = (TbImageView) c0434a.mRootView.findViewById(R.id.icon_img);
        c0434a.jPn.setDefaultBgResource(R.color.cp_bg_line_e);
        c0434a.jPn.setDefaultResource(R.drawable.transparent_bg);
        c0434a.jPn.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0434a.mRootView.setTag(c0434a);
        return c0434a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0434a {
        public View fDO;
        public TbImageView jPn;
        public TextView jPo;
        public View mRootView;

        private C0434a() {
        }
    }
}
