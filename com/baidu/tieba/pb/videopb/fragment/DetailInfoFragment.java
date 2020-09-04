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
    private PbListView fEa;
    private BdTypeRecyclerView hYW;
    private PbActivity kDc;
    private com.baidu.tieba.pb.videopb.a.a kXI;
    private String kXJ;
    private String kXK;
    private VideoPbFragment kXx;
    private e kzL;
    private int kXF = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.kXx != null) {
                DetailInfoFragment.this.kXx.dar();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.kXx != null && !DetailInfoFragment.this.kXx.deh()) {
                DetailInfoFragment.this.kzL.ui(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> dey;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.kXx != null && !DetailInfoFragment.this.kXx.deh() && ((dey = DetailInfoFragment.this.kzL.dey()) == null || dey.getValue() == null || dey.getValue().booleanValue())) {
                DetailInfoFragment.this.kzL.ui(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.kXF != 0 && DetailInfoFragment.this.kXx != null) {
                    DetailInfoFragment.this.kXx.EN(8);
                }
                DetailInfoFragment.this.kXF = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.kXx != null && DetailInfoFragment.this.kXF == 0) {
                DetailInfoFragment.this.kXx.EN(0);
            }
            DetailInfoFragment.this.kXF = 2;
        }
    };
    private CustomMessageListener kEs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cWE() != null && DetailInfoFragment.this.cWE().getPbData() != null) {
                DetailInfoFragment.this.cWE().getPbData().cVG();
                DetailInfoFragment.this.cWE().cYX();
                DetailInfoFragment.this.kXI.setData(DetailInfoFragment.this.cWE().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener inn = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cWE() != null && DetailInfoFragment.this.cWE().getPbData() != null) {
                DetailInfoFragment.this.Nt((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cWE().cYX();
                DetailInfoFragment.this.kXI.setData(DetailInfoFragment.this.cWE().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.kXx = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.kDc = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.inn);
        this.kEs.setSelfListener(true);
        if (cYj() != null) {
            this.kEs.setTag(cYj().getUniqueId());
        } else if (getPageContext() != null) {
            this.kEs.setTag(getPageContext().getUniqueId());
        }
        this.kEs.setPriority(-1);
        MessageManager.getInstance().registerListener(this.kEs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.kzL = (e) y.b(getFragmentActivity()).l(e.class);
        ca(inflate);
        return inflate;
    }

    private void ca(View view) {
        this.hYW = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hYW.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hYW.addOnScrollListener(this.mOnScrollListener);
        this.hYW.setOnTouchListener(cYi().bvI());
        this.fEa = new PbListView(getContext());
        this.fEa.getView();
        this.fEa.setText("");
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setLineGone();
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fEa.bkv();
        this.hYW.setNextPage(this.fEa);
        this.kXI = new com.baidu.tieba.pb.videopb.a.a(this, this.hYW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.kzL != null) {
            deW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.inn);
        MessageManager.getInstance().unRegisterListener(this.kEs);
        super.onDestroy();
    }

    private void deW() {
        f der = this.kzL.der();
        if (der == null) {
            der = this.kzL.deq();
        }
        N(der);
    }

    private void N(f fVar) {
        if (this.kzL != null && fVar != null) {
            O(fVar);
            P(fVar);
            this.kXI.setData(fVar);
        }
    }

    private void O(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.cVm() != null) {
                str = fVar.getThreadId();
                if (fVar.cVm().getBaijiahaoData() != null) {
                    str2 = fVar.cVm().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.kXJ || str2 != this.kXK) {
                deX();
            }
            this.kXJ = str;
            this.kXK = str2;
        }
    }

    private void P(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.cVO())) {
                deY();
                return;
            }
            dfa();
            this.fEa.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void deX() {
        if (this.hYW != null) {
            this.hYW.scrollToPosition(0);
        }
        dfa();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            N(fVar);
        }
    }

    public PbActivity cYj() {
        return this.kDc != null ? this.kDc : this.kXx.cYj();
    }

    public VideoPbFragment cYi() {
        if (this.kXx == null && this.kDc != null) {
            Fragment cWQ = this.kDc.cWQ();
            if (cWQ instanceof VideoPbFragment) {
                this.kXx = (VideoPbFragment) cWQ;
            }
        }
        return this.kXx;
    }

    public PbModel cWE() {
        return cYi().cWE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kXI != null) {
            this.kXI.notifyDataSetChanged();
        }
        if (this.fEa != null) {
            this.fEa.changeSkin(i);
        }
    }

    private void deY() {
        if (this.fEa != null) {
            this.fEa.r(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void deZ() {
        if (this.kXI != null) {
            this.kXI.deG();
        }
    }

    private void dfa() {
        if (this.fEa != null) {
            this.fEa.bkw();
        }
    }

    public int deT() {
        return this.kXF;
    }

    public void ul(boolean z) {
        if (this.hYW != null) {
            this.hYW.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nt(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> cVT = cWE().getPbData().cVT();
            for (n nVar : cVT) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    cVT.remove(nVar);
                    return;
                }
            }
        }
    }
}
