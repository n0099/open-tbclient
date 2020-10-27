package com.baidu.tieba.lately;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.b.b;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.c.a;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class LatelyView extends FrameLayout implements d<String> {
    private LinearLayoutManager Xf;
    private g gmB;
    private b hKg;
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
        this.hKg = new b(this);
        this.hKg.setType(1);
        this.Xf = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.Xf);
        this.mRecyclerView.setAdapter(this.hKg);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_recently);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void az(String str) {
        RecentlyVisitedForumData cpa = a.coV().cpa();
        if (cpa == null) {
            U(false, false);
            return;
        }
        LinkedList<VisitedForumData> forumData = cpa.getForumData();
        if (y.isEmpty(forumData)) {
            U(false, false);
            return;
        }
        TK();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<VisitedForumData> it = forumData.iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (next != null) {
                i iVar = new i();
                iVar.forumId = next.getForumId();
                iVar.bfv = next.bwA();
                iVar.forumName = next.getForumName();
                iVar.level = next.getLevel();
                iVar.fgp = next.bwG();
                iVar.fgq = next.bwH();
                iVar.fgr = next.bwI();
                iVar.tabInfoList = next.bwJ();
                iVar.fgs = next.bwK();
                if (iVar.fgp) {
                    arrayList2.add(iVar);
                } else {
                    arrayList.add(iVar);
                }
            }
        }
        arrayList2.addAll(arrayList);
        this.hKg.bb(arrayList2);
        this.hKg.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.d
    public void EC(String str) {
    }

    public void U(boolean z, boolean z2) {
        if (!cki()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lately.LatelyView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            LatelyView.this.az(null);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.tbds380));
            this.mRefreshView.attachView(this, z);
            if (z2) {
                this.mRefreshView.showRefreshButton();
            } else {
                this.mRefreshView.ru(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.DP(getContext().getString(R.string.activity_select_forum_recently_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean cki() {
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
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.hKg.notifyDataSetChanged();
        }
    }
}
