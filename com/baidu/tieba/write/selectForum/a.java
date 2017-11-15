package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewGroup brZ = null;
    private HotTopicChangeFourmActivity gTE;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.gTE = hotTopicChangeFourmActivity;
        this.mContext = this.gTE.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.v(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vs */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String tX(String str) {
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
        C0142a c0142a;
        if (this.brZ == null) {
            this.brZ = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0142a = a(view != null ? view.getTag() : null, item);
        } else {
            c0142a = null;
        }
        if (c0142a != null) {
            return c0142a.mRootView;
        }
        return null;
    }

    private C0142a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0142a c0142a;
        if (obj == null) {
            c0142a = bDA();
        } else {
            c0142a = (C0142a) obj;
        }
        c0142a.gTG.setText(tX(hotTopicBussinessData.mForumName));
        c0142a.gTF.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0142a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0142a.gTG, d.C0080d.cp_cont_b);
        aj.k(c0142a.cGm, d.C0080d.cp_bg_line_e);
        return c0142a;
    }

    private C0142a bDA() {
        C0142a c0142a = new C0142a();
        c0142a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0142a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0142a.gTG, d.C0080d.cp_cont_b);
        c0142a.gTG = (TextView) c0142a.mRootView.findViewById(d.g.fourm_tv);
        c0142a.cGm = c0142a.mRootView.findViewById(d.g.line_view);
        c0142a.gTF = (TbImageView) c0142a.mRootView.findViewById(d.g.icon_img);
        c0142a.gTF.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        c0142a.gTF.setDefaultResource(d.f.transparent_bg);
        c0142a.gTF.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0142a.mRootView.setTag(c0142a);
        return c0142a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0142a {
        public View cGm;
        public TbImageView gTF;
        public TextView gTG;
        public View mRootView;

        private C0142a() {
        }
    }
}
