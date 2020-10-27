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
/* loaded from: classes22.dex */
public class DetailInfoFragment extends BaseFragment implements com.baidu.tieba.pb.videopb.a {
    private PbListView gdy;
    private BdTypeRecyclerView iHt;
    private VideoPbFragment lHS;
    private com.baidu.tieba.pb.videopb.a.a lId;
    private String lIe;
    private String lIf;
    private e ljS;
    private PbActivity lnl;
    private int lIa = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.lHS != null) {
                DetailInfoFragment.this.lHS.dkK();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.lHS != null && !DetailInfoFragment.this.lHS.doC()) {
                DetailInfoFragment.this.ljS.vo(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> doT;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.lHS != null && !DetailInfoFragment.this.lHS.doC() && ((doT = DetailInfoFragment.this.ljS.doT()) == null || doT.getValue() == null || doT.getValue().booleanValue())) {
                DetailInfoFragment.this.ljS.vo(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.lIa != 0 && DetailInfoFragment.this.lHS != null) {
                    DetailInfoFragment.this.lHS.Gn(8);
                }
                DetailInfoFragment.this.lIa = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.lHS != null && DetailInfoFragment.this.lIa == 0) {
                DetailInfoFragment.this.lHS.Gn(0);
            }
            DetailInfoFragment.this.lIa = 2;
        }
    };
    private CustomMessageListener loG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dgX() != null && DetailInfoFragment.this.dgX().getPbData() != null) {
                DetailInfoFragment.this.dgX().getPbData().dgc();
                DetailInfoFragment.this.dgX().djq();
                DetailInfoFragment.this.lId.setData(DetailInfoFragment.this.dgX().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dgX() != null && DetailInfoFragment.this.dgX().getPbData() != null) {
                DetailInfoFragment.this.Ph((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dgX().djq();
                DetailInfoFragment.this.lId.setData(DetailInfoFragment.this.dgX().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.lHS = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lnl = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.iVT);
        this.loG.setSelfListener(true);
        if (diC() != null) {
            this.loG.setTag(diC().getUniqueId());
        } else if (getPageContext() != null) {
            this.loG.setTag(getPageContext().getUniqueId());
        }
        this.loG.setPriority(-1);
        MessageManager.getInstance().registerListener(this.loG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.ljS = (e) y.b(getFragmentActivity()).l(e.class);
        cr(inflate);
        return inflate;
    }

    private void cr(View view) {
        this.iHt = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.iHt.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iHt.addOnScrollListener(this.mOnScrollListener);
        this.iHt.setOnTouchListener(diB().bBu());
        this.gdy = new PbListView(getContext());
        this.gdy.getView();
        this.gdy.setText("");
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setLineGone();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gdy.bpT();
        this.iHt.setNextPage(this.gdy);
        this.lId = new com.baidu.tieba.pb.videopb.a.a(this, this.iHt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.ljS != null) {
            dpr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iVT);
        MessageManager.getInstance().unRegisterListener(this.loG);
        super.onDestroy();
    }

    private void dpr() {
        f doM = this.ljS.doM();
        if (doM == null) {
            doM = this.ljS.doL();
        }
        O(doM);
    }

    private void O(f fVar) {
        if (this.ljS != null && fVar != null) {
            P(fVar);
            Q(fVar);
            this.lId.setData(fVar);
        }
    }

    private void P(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.dfI() != null) {
                str = fVar.getThreadId();
                if (fVar.dfI().getBaijiahaoData() != null) {
                    str2 = fVar.dfI().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.lIe || str2 != this.lIf) {
                dps();
            }
            this.lIe = str;
            this.lIf = str2;
        }
    }

    private void Q(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.dgk())) {
                dpt();
                return;
            }
            dpv();
            this.gdy.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dps() {
        if (this.iHt != null) {
            this.iHt.scrollToPosition(0);
        }
        dpv();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            O(fVar);
        }
    }

    public PbActivity diC() {
        return this.lnl != null ? this.lnl : this.lHS.diC();
    }

    public VideoPbFragment diB() {
        if (this.lHS == null && this.lnl != null) {
            Fragment dhj = this.lnl.dhj();
            if (dhj instanceof VideoPbFragment) {
                this.lHS = (VideoPbFragment) dhj;
            }
        }
        return this.lHS;
    }

    public PbModel dgX() {
        return diB().dgX();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lId != null) {
            this.lId.notifyDataSetChanged();
        }
        if (this.gdy != null) {
            this.gdy.changeSkin(i);
        }
    }

    private void dpt() {
        if (this.gdy != null) {
            this.gdy.s(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dpu() {
        if (this.lId != null) {
            this.lId.dpb();
        }
    }

    private void dpv() {
        if (this.gdy != null) {
            this.gdy.bpU();
        }
    }

    public int dpo() {
        return this.lIa;
    }

    public void vr(boolean z) {
        if (this.iHt != null) {
            this.iHt.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> dgp = dgX().getPbData().dgp();
            for (n nVar : dgp) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    dgp.remove(nVar);
                    return;
                }
            }
        }
    }
}
