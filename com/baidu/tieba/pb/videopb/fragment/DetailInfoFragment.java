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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.List;
/* loaded from: classes9.dex */
public class DetailInfoFragment extends BaseFragment implements a {
    private PbListView fcj;
    private BdTypeRecyclerView hrX;
    private e jHW;
    private PbActivity jLc;
    private VideoPbFragment keQ;
    private com.baidu.tieba.pb.videopb.a.a keS;
    private String keU;
    private String keV;
    private int keT = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.keQ != null) {
                DetailInfoFragment.this.keQ.cHw();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.keQ != null && !DetailInfoFragment.this.keQ.cLi()) {
                DetailInfoFragment.this.jHW.sD(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> cLz;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.keQ != null && !DetailInfoFragment.this.keQ.cLi() && ((cLz = DetailInfoFragment.this.jHW.cLz()) == null || cLz.getValue() == null || cLz.getValue().booleanValue())) {
                DetailInfoFragment.this.jHW.sD(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.keT != 0 && DetailInfoFragment.this.keQ != null) {
                    DetailInfoFragment.this.keQ.AR(8);
                }
                DetailInfoFragment.this.keT = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.keQ != null && DetailInfoFragment.this.keT == 0) {
                DetailInfoFragment.this.keQ.AR(0);
            }
            DetailInfoFragment.this.keT = 2;
        }
    };
    private CustomMessageListener hFL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cDO() != null && DetailInfoFragment.this.cDO().getPbData() != null) {
                DetailInfoFragment.this.Jk((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cDO().cGe();
                DetailInfoFragment.this.keS.setData(DetailInfoFragment.this.cDO().getPbData());
            }
        }
    };

    public static DetailInfoFragment aa(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.keQ = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.jLc = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.hFL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.jHW = (e) y.b(getFragmentActivity()).l(e.class);
        bP(inflate);
        return inflate;
    }

    private void bP(View view) {
        this.hrX = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hrX.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hrX.addOnScrollListener(this.mOnScrollListener);
        this.hrX.setOnTouchListener(cFr().bgN());
        this.fcj = new PbListView(getContext());
        this.fcj.getView();
        this.fcj.setText("");
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setLineGone();
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fcj.aWf();
        this.hrX.setNextPage(this.fcj);
        this.keS = new com.baidu.tieba.pb.videopb.a.a(this, this.hrX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.jHW != null) {
            cLL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hFL);
        super.onDestroy();
    }

    private void cLL() {
        com.baidu.tieba.pb.data.e cLs = this.jHW.cLs();
        if (cLs == null) {
            cLs = this.jHW.cLr();
        }
        M(cLs);
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (this.jHW != null && eVar != null) {
            N(eVar);
            O(eVar);
            this.keS.setData(eVar);
        }
    }

    private void N(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.cCy() != null) {
                str = eVar.getThreadId();
                if (eVar.cCy().getBaijiahaoData() != null) {
                    str2 = eVar.cCy().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.keU || str2 != this.keV) {
                cLM();
            }
            this.keU = str;
            this.keV = str2;
        }
    }

    private void O(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.cCY())) {
                cLN();
                return;
            }
            cLP();
            this.fcj.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cLM() {
        if (this.hrX != null) {
            this.hrX.scrollToPosition(0);
        }
        cLP();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            M(eVar);
        }
    }

    public PbActivity cFs() {
        return this.jLc != null ? this.jLc : this.keQ.cFs();
    }

    public VideoPbFragment cFr() {
        if (this.keQ == null && this.jLc != null) {
            Fragment cEa = this.jLc.cEa();
            if (cEa instanceof VideoPbFragment) {
                this.keQ = (VideoPbFragment) cEa;
            }
        }
        return this.keQ;
    }

    public PbModel cDO() {
        return cFr().cDO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.keS != null) {
            this.keS.notifyDataSetChanged();
        }
        if (this.fcj != null) {
            this.fcj.changeSkin(i);
        }
    }

    private void cLN() {
        if (this.fcj != null) {
            this.fcj.s(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void cLO() {
        if (this.keS != null) {
            this.keS.cLH();
        }
    }

    private void cLP() {
        if (this.fcj != null) {
            this.fcj.aWg();
        }
    }

    public int cLQ() {
        return this.keT;
    }

    public void sG(boolean z) {
        if (this.hrX != null) {
            this.hrX.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> cDd = cDO().getPbData().cDd();
            for (n nVar : cDd) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    cDd.remove(nVar);
                    return;
                }
            }
        }
    }
}
