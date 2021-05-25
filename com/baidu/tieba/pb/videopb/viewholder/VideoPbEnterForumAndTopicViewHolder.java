package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.TopicEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import d.a.c.e.p.k;
import d.a.m0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f19505a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f19506b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f19507c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f19508d;

    public VideoPbEnterForumAndTopicViewHolder(Context context, View view) {
        super(view);
        this.f19505a = context;
        this.f19506b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void b() {
        ThreadForumEnterButton threadForumEnterButton = this.f19507c;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.d();
        }
        List<TopicEnterButton> list = this.f19508d;
        if (list != null) {
            for (TopicEnterButton topicEnterButton : list) {
                topicEnterButton.f();
            }
        }
    }

    public void setData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f19506b.removeAllViews();
        List<TopicEnterButton> list = this.f19508d;
        if (list != null) {
            list.clear();
        }
        if (!k.isEmpty(a2Var.i0())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f19505a);
            this.f19507c = threadForumEnterButton;
            threadForumEnterButton.a(a2Var);
            this.f19506b.addView(this.f19507c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = a2Var.F2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f19508d == null) {
            this.f19508d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : a2Var.F2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.f19505a);
            topicEnterButton.d(recommendTopicListData);
            this.f19506b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f19508d.add(topicEnterButton);
        }
    }
}
