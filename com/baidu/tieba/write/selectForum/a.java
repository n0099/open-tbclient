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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity huR;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.huR = hotTopicChangeFourmActivity;
        this.mContext = this.huR.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.A(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vy */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String vF(String str) {
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
        C0254a c0254a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0254a = a(view != null ? view.getTag() : null, item);
        } else {
            c0254a = null;
        }
        if (c0254a != null) {
            return c0254a.mRootView;
        }
        return null;
    }

    private C0254a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0254a c0254a;
        if (obj == null) {
            c0254a = bHP();
        } else {
            c0254a = (C0254a) obj;
        }
        c0254a.huT.setText(vF(hotTopicBussinessData.mForumName));
        c0254a.huS.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.i(c0254a.mRootView, d.f.select_forum_item_bg);
        am.h(c0254a.huT, d.C0142d.cp_cont_b);
        am.j(c0254a.dsv, d.C0142d.cp_bg_line_e);
        return c0254a;
    }

    private C0254a bHP() {
        C0254a c0254a = new C0254a();
        c0254a.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.hot_topic_change_item, (ViewGroup) null);
        am.i(c0254a.mRootView, d.f.select_forum_item_bg);
        am.h(c0254a.huT, d.C0142d.cp_cont_b);
        c0254a.huT = (TextView) c0254a.mRootView.findViewById(d.g.fourm_tv);
        c0254a.dsv = c0254a.mRootView.findViewById(d.g.line_view);
        c0254a.huS = (TbImageView) c0254a.mRootView.findViewById(d.g.icon_img);
        c0254a.huS.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        c0254a.huS.setDefaultResource(d.f.transparent_bg);
        c0254a.huS.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0254a.mRootView.setTag(c0254a);
        return c0254a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0254a {
        public View dsv;
        public TbImageView huS;
        public TextView huT;
        public View mRootView;

        private C0254a() {
        }
    }
}
