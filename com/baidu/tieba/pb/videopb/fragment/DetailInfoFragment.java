package com.baidu.tieba.pb.videopb.fragment;

import android.arch.lifecycle.p;
import android.arch.lifecycle.y;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.List;
/* loaded from: classes16.dex */
public class DetailInfoFragment extends BaseFragment implements com.baidu.tieba.pb.videopb.a {
    private PbListView fDW;
    private BdTypeRecyclerView hYQ;
    private PbActivity kCV;
    private com.baidu.tieba.pb.videopb.a.a kXB;
    private String kXC;
    private String kXD;
    private VideoPbFragment kXq;
    private e kzE;
    private int kXy = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.kXq != null) {
                DetailInfoFragment.this.kXq.daq();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.kXq != null && !DetailInfoFragment.this.kXq.deg()) {
                DetailInfoFragment.this.kzE.ug(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> dex;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.kXq != null && !DetailInfoFragment.this.kXq.deg() && ((dex = DetailInfoFragment.this.kzE.dex()) == null || dex.getValue() == null || dex.getValue().booleanValue())) {
                DetailInfoFragment.this.kzE.ug(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.kXy != 0 && DetailInfoFragment.this.kXq != null) {
                    DetailInfoFragment.this.kXq.EN(8);
                }
                DetailInfoFragment.this.kXy = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.kXq != null && DetailInfoFragment.this.kXy == 0) {
                DetailInfoFragment.this.kXq.EN(0);
            }
            DetailInfoFragment.this.kXy = 2;
        }
    };
    private CustomMessageListener kEl = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cWD() != null && DetailInfoFragment.this.cWD().getPbData() != null) {
                DetailInfoFragment.this.cWD().getPbData().cVF();
                DetailInfoFragment.this.cWD().cYW();
                DetailInfoFragment.this.kXB.setData(DetailInfoFragment.this.cWD().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener inh = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cWD() != null && DetailInfoFragment.this.cWD().getPbData() != null) {
                DetailInfoFragment.this.Ns((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cWD().cYW();
                DetailInfoFragment.this.kXB.setData(DetailInfoFragment.this.cWD().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.kXq = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.kCV = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.inh);
        this.kEl.setSelfListener(true);
        if (cYi() != null) {
            this.kEl.setTag(cYi().getUniqueId());
        } else if (getPageContext() != null) {
            this.kEl.setTag(getPageContext().getUniqueId());
        }
        this.kEl.setPriority(-1);
        MessageManager.getInstance().registerListener(this.kEl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.kzE = (e) y.b(getFragmentActivity()).l(e.class);
        ca(inflate);
        return inflate;
    }

    private void ca(View view) {
        this.hYQ = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hYQ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hYQ.addOnScrollListener(this.mOnScrollListener);
        this.hYQ.setOnTouchListener(cYh().bvH());
        this.fDW = new PbListView(getContext());
        this.fDW.getView();
        this.fDW.setText("");
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setLineGone();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fDW.bkv();
        this.hYQ.setNextPage(this.fDW);
        this.kXB = new com.baidu.tieba.pb.videopb.a.a(this, this.hYQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.kzE != null) {
            deV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.inh);
        MessageManager.getInstance().unRegisterListener(this.kEl);
        super.onDestroy();
    }

    private void deV() {
        f deq = this.kzE.deq();
        if (deq == null) {
            deq = this.kzE.dep();
        }
        N(deq);
    }

    private void N(f fVar) {
        if (this.kzE != null && fVar != null) {
            O(fVar);
            P(fVar);
            this.kXB.setData(fVar);
        }
    }

    private void O(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.cVl() != null) {
                str = fVar.getThreadId();
                if (fVar.cVl().getBaijiahaoData() != null) {
                    str2 = fVar.cVl().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.kXC || str2 != this.kXD) {
                deW();
            }
            this.kXC = str;
            this.kXD = str2;
        }
    }

    private void P(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.cVN())) {
                deX();
                return;
            }
            deZ();
            this.fDW.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void deW() {
        if (this.hYQ != null) {
            this.hYQ.scrollToPosition(0);
        }
        deZ();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            N(fVar);
        }
    }

    public PbActivity cYi() {
        return this.kCV != null ? this.kCV : this.kXq.cYi();
    }

    public VideoPbFragment cYh() {
        if (this.kXq == null && this.kCV != null) {
            Fragment cWP = this.kCV.cWP();
            if (cWP instanceof VideoPbFragment) {
                this.kXq = (VideoPbFragment) cWP;
            }
        }
        return this.kXq;
    }

    public PbModel cWD() {
        return cYh().cWD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kXB != null) {
            this.kXB.notifyDataSetChanged();
        }
        if (this.fDW != null) {
            this.fDW.changeSkin(i);
        }
    }

    private void deX() {
        if (this.fDW != null) {
            this.fDW.r(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void deY() {
        if (this.kXB != null) {
            this.kXB.deF();
        }
    }

    private void deZ() {
        if (this.fDW != null) {
            this.fDW.bkw();
        }
    }

    public int deS() {
        return this.kXy;
    }

    public void uj(boolean z) {
        if (this.hYQ != null) {
            this.hYQ.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> cVS = cWD().getPbData().cVS();
            for (n nVar : cVS) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    cVS.remove(nVar);
                    return;
                }
            }
        }
    }
}
