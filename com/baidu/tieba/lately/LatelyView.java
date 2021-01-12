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
import com.baidu.tbadk.core.util.x;
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
    private LinearLayoutManager Yb;
    private g gGD;
    private SelectForumItemAdapter ijq;
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
        this.ijq = new SelectForumItemAdapter(this);
        this.ijq.setType(1);
        this.Yb = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.Yb);
        this.mRecyclerView.setAdapter(this.ijq);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_recently);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void aB(String str) {
        RecentlyVisitedForumData cuv = a.cuq().cuv();
        if (cuv == null) {
            W(false, false);
            return;
        }
        LinkedList<VisitedForumData> forumData = cuv.getForumData();
        if (x.isEmpty(forumData)) {
            W(false, false);
            return;
        }
        Vq();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<VisitedForumData> it = forumData.iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (next != null) {
                j jVar = new j();
                jVar.forumId = next.getForumId();
                jVar.aSf = next.bAr();
                jVar.forumName = next.getForumName();
                jVar.level = next.getLevel();
                jVar.fxQ = next.bAx();
                jVar.fxR = next.bAy();
                jVar.fxS = next.bAz();
                jVar.tabInfoList = next.bAA();
                jVar.fxT = next.bAB();
                if (jVar.fxQ) {
                    arrayList2.add(jVar);
                } else {
                    arrayList.add(jVar);
                }
                jVar.isForumBusinessAccount = next.isForumBusinessAccount;
            }
        }
        arrayList2.addAll(arrayList);
        this.ijq.bs(arrayList2);
        this.ijq.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.d
    public void DR(String str) {
    }

    public void W(boolean z, boolean z2) {
        if (!cpC()) {
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
                this.mRefreshView.rj(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.CV(getContext().getString(R.string.activity_select_forum_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean cpC() {
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
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.ijq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.d
    public void onDestroy() {
    }
}
