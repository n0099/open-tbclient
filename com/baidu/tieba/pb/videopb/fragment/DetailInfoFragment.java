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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private PbListView fsC;
    private BdTypeRecyclerView hKL;
    private VideoPbFragment kHG;
    private com.baidu.tieba.pb.videopb.a.a kHS;
    private String kHT;
    private String kHU;
    private e kkm;
    private PbActivity knE;
    private int kHO = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.kHG != null) {
                DetailInfoFragment.this.kHG.cPA();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.kHG != null && !DetailInfoFragment.this.kHG.cTo()) {
                DetailInfoFragment.this.kkm.tx(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> cTF;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.kHG != null && !DetailInfoFragment.this.kHG.cTo() && ((cTF = DetailInfoFragment.this.kkm.cTF()) == null || cTF.getValue() == null || cTF.getValue().booleanValue())) {
                DetailInfoFragment.this.kkm.tx(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.kHO != 0 && DetailInfoFragment.this.kHG != null) {
                    DetailInfoFragment.this.kHG.Ct(8);
                }
                DetailInfoFragment.this.kHO = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.kHG != null && DetailInfoFragment.this.kHO == 0) {
                DetailInfoFragment.this.kHG.Ct(0);
            }
            DetailInfoFragment.this.kHO = 2;
        }
    };
    private CustomMessageListener koU = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cLP() != null && DetailInfoFragment.this.cLP().getPbData() != null) {
                DetailInfoFragment.this.cLP().getPbData().cKR();
                DetailInfoFragment.this.cLP().cOg();
                DetailInfoFragment.this.kHS.setData(DetailInfoFragment.this.cLP().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener hYZ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cLP() != null && DetailInfoFragment.this.cLP().getPbData() != null) {
                DetailInfoFragment.this.Kz((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cLP().cOg();
                DetailInfoFragment.this.kHS.setData(DetailInfoFragment.this.cLP().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.kHG = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.knE = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.hYZ);
        this.koU.setSelfListener(true);
        if (cNt() != null) {
            this.koU.setTag(cNt().getUniqueId());
        } else if (getPageContext() != null) {
            this.koU.setTag(getPageContext().getUniqueId());
        }
        this.koU.setPriority(-1);
        MessageManager.getInstance().registerListener(this.koU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.kkm = (e) y.b(getFragmentActivity()).l(e.class);
        bY(inflate);
        return inflate;
    }

    private void bY(View view) {
        this.hKL = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hKL.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hKL.addOnScrollListener(this.mOnScrollListener);
        this.hKL.setOnTouchListener(cNs().bmU());
        this.fsC = new PbListView(getContext());
        this.fsC.getView();
        this.fsC.setText("");
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fsC.bbZ();
        this.hKL.setNextPage(this.fsC);
        this.kHS = new com.baidu.tieba.pb.videopb.a.a(this, this.hKL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.kkm != null) {
            cTY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hYZ);
        MessageManager.getInstance().unRegisterListener(this.koU);
        super.onDestroy();
    }

    private void cTY() {
        f cTy = this.kkm.cTy();
        if (cTy == null) {
            cTy = this.kkm.cTx();
        }
        N(cTy);
    }

    private void N(f fVar) {
        if (this.kkm != null && fVar != null) {
            O(fVar);
            P(fVar);
            this.kHS.setData(fVar);
        }
    }

    private void O(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.cKx() != null) {
                str = fVar.getThreadId();
                if (fVar.cKx().getBaijiahaoData() != null) {
                    str2 = fVar.cKx().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.kHT || str2 != this.kHU) {
                cTZ();
            }
            this.kHT = str;
            this.kHU = str2;
        }
    }

    private void P(f fVar) {
        if (fVar != null) {
            if (x.isEmpty(fVar.cKZ())) {
                cUa();
                return;
            }
            cUc();
            this.fsC.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cTZ() {
        if (this.hKL != null) {
            this.hKL.scrollToPosition(0);
        }
        cUc();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            N(fVar);
        }
    }

    public PbActivity cNt() {
        return this.knE != null ? this.knE : this.kHG.cNt();
    }

    public VideoPbFragment cNs() {
        if (this.kHG == null && this.knE != null) {
            Fragment cMb = this.knE.cMb();
            if (cMb instanceof VideoPbFragment) {
                this.kHG = (VideoPbFragment) cMb;
            }
        }
        return this.kHG;
    }

    public PbModel cLP() {
        return cNs().cLP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kHS != null) {
            this.kHS.notifyDataSetChanged();
        }
        if (this.fsC != null) {
            this.fsC.changeSkin(i);
        }
    }

    private void cUa() {
        if (this.fsC != null) {
            this.fsC.s(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void cUb() {
        if (this.kHS != null) {
            this.kHS.cTN();
        }
    }

    private void cUc() {
        if (this.fsC != null) {
            this.fsC.bca();
        }
    }

    public int cTW() {
        return this.kHO;
    }

    public void tA(boolean z) {
        if (this.hKL != null) {
            this.hKL.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kz(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> cLe = cLP().getPbData().cLe();
            for (n nVar : cLe) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    cLe.remove(nVar);
                    return;
                }
            }
        }
    }
}
