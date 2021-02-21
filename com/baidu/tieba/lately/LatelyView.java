package com.baidu.tieba.lately;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.a;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class LatelyView extends FrameLayout implements d<String> {
    private LinearLayoutManager XX;
    private g gJB;
    private SelectForumItemAdapter ipm;
    private RecyclerView mRecyclerView;
    private h mRefreshView;
    private int mSkinType;

    public LatelyView(Context context) {
        this(context, null);
    }

    public LatelyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LatelyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.select_forum_list);
        this.ipm = new SelectForumItemAdapter(this);
        this.ipm.setType(1);
        this.XX = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.XX);
        this.mRecyclerView.setAdapter(this.ipm);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_recently);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void aB(String str) {
        RecentlyVisitedForumData cvO = a.cvJ().cvO();
        if (cvO == null) {
            W(false, false);
            return;
        }
        LinkedList<VisitedForumData> forumData = cvO.getForumData();
        if (y.isEmpty(forumData)) {
            W(false, false);
            return;
        }
        WZ();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<VisitedForumData> it = forumData.iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (next != null) {
                j jVar = new j();
                jVar.forumId = next.getForumId();
                jVar.aVj = next.bAJ();
                jVar.forumName = next.getForumName();
                jVar.level = next.getLevel();
                jVar.fAg = next.bAP();
                jVar.fAh = next.bAQ();
                jVar.fAi = next.bAR();
                jVar.tabInfoList = next.bAS();
                jVar.fAj = next.bAT();
                if (jVar.fAg) {
                    arrayList2.add(jVar);
                } else {
                    arrayList.add(jVar);
                }
                jVar.isForumBusinessAccount = next.isForumBusinessAccount;
            }
        }
        arrayList2.addAll(arrayList);
        this.ipm.bn(arrayList2);
        this.ipm.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.d
    public void Em(String str) {
    }

    public void W(boolean z, boolean z2) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lately.LatelyView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            LatelyView.this.aB(null);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.tbds380));
            this.mRefreshView.attachView(this, z);
            if (z2) {
                this.mRefreshView.showRefreshButton();
            } else {
                this.mRefreshView.ro(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.Dk(getContext().getString(R.string.activity_select_forum_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean cqT() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // com.baidu.tieba.d
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.ipm.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.d
    public void onDestroy() {
    }
}
