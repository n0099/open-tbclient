package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<HotTopicBussinessData> aUW;
    private ViewGroup dsD = null;
    private HotTopicChangeFourmActivity ghk;
    private final Context mContext;

    public b(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.ghk = hotTopicChangeFourmActivity;
        this.mContext = this.ghk.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.aUW = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (z.t(this.aUW)) {
            return 0;
        }
        return this.aUW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tK */
    public HotTopicBussinessData getItem(int i) {
        if (this.aUW != null && i < this.aUW.size()) {
            return this.aUW.get(i);
        }
        return null;
    }

    private String sl(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return String.valueOf(str.substring(0, 13)) + "...";
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dsD == null) {
            this.dsD = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.mRootView;
        }
        return null;
    }

    private a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        a aVar;
        if (obj == null) {
            aVar = bsQ();
        } else {
            aVar = (a) obj;
        }
        aVar.ghm.setText(sl(hotTopicBussinessData.mForumName));
        aVar.ghl.c(hotTopicBussinessData.mForumAvatar, 10, false);
        as.j(aVar.mRootView, w.g.select_forum_item_bg);
        as.i(aVar.ghm, w.e.cp_cont_b);
        as.k(aVar.cii, w.e.cp_bg_line_e);
        return aVar;
    }

    private a bsQ() {
        a aVar = new a(this, null);
        aVar.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.hot_topic_change_item, (ViewGroup) null);
        as.j(aVar.mRootView, w.g.select_forum_item_bg);
        as.i(aVar.ghm, w.e.cp_cont_b);
        aVar.ghm = (TextView) aVar.mRootView.findViewById(w.h.fourm_tv);
        aVar.cii = aVar.mRootView.findViewById(w.h.line_view);
        aVar.ghl = (TbImageView) aVar.mRootView.findViewById(w.h.icon_img);
        aVar.ghl.setDefaultBgResource(w.e.cp_bg_line_e);
        aVar.ghl.setDefaultResource(w.g.transparent_bg);
        aVar.ghl.setDefaultErrorResource(w.g.icon_default_ba_120);
        aVar.mRootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View cii;
        public TbImageView ghl;
        public TextView ghm;
        public View mRootView;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
