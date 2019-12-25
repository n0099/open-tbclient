package com.baidu.tieba.pb.videopb.fragment;

import android.arch.lifecycle.p;
import android.arch.lifecycle.y;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a;
import com.baidu.tieba.pb.videopb.e;
/* loaded from: classes6.dex */
public class DetailInfoFragment extends BaseFragment implements a {
    private PbListView egU;
    private BdTypeRecyclerView gnE;
    private PbActivity iBR;
    private VideoPbFragment iUN;
    private com.baidu.tieba.pb.videopb.a.a iUP;
    private String iUR;
    private String iUS;
    private e iyU;
    private int iUQ = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.iUN != null) {
                DetailInfoFragment.this.iUN.cmK();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.iUN != null && !DetailInfoFragment.this.iUN.cqv()) {
                DetailInfoFragment.this.iyU.qD(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> cqI;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.iUN != null && !DetailInfoFragment.this.iUN.cqv() && ((cqI = DetailInfoFragment.this.iyU.cqI()) == null || cqI.getValue() == null || cqI.getValue().booleanValue())) {
                DetailInfoFragment.this.iyU.qD(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.iUQ != 0 && DetailInfoFragment.this.iUN != null) {
                    DetailInfoFragment.this.iUN.zk(8);
                }
                DetailInfoFragment.this.iUQ = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.iUN != null && DetailInfoFragment.this.iUQ == 0) {
                DetailInfoFragment.this.iUN.zk(0);
            }
            DetailInfoFragment.this.iUQ = 2;
        }
    };

    public static DetailInfoFragment S(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.iUN = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iBR = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.iyU = (e) y.b(getFragmentActivity()).l(e.class);
        bE(inflate);
        return inflate;
    }

    private void bE(View view) {
        this.gnE = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.gnE.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gnE.addOnScrollListener(this.mOnScrollListener);
        this.gnE.setOnTouchListener(ckD().aPD());
        this.egU = new PbListView(getContext());
        this.egU.getView();
        this.egU.setText("");
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setLineGone();
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.egU.aEZ();
        this.gnE.setNextPage(this.egU);
        this.iUP = new com.baidu.tieba.pb.videopb.a.a(this, this.gnE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iyU != null) {
            cqU();
        }
    }

    private void cqU() {
        f cqB = this.iyU.cqB();
        if (cqB == null) {
            cqB = this.iyU.cqA();
        }
        I(cqB);
    }

    private void I(f fVar) {
        if (this.iyU != null && fVar != null) {
            J(fVar);
            K(fVar);
            this.iUP.setData(fVar);
        }
    }

    private void J(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.chK() != null) {
                str = fVar.getThreadId();
                if (fVar.chK().getBaijiahaoData() != null) {
                    str2 = fVar.chK().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.iUR || str2 != this.iUS) {
                cqV();
            }
            this.iUR = str;
            this.iUS = str2;
        }
    }

    private void K(f fVar) {
        if (fVar != null) {
            if (v.isEmpty(fVar.cij())) {
                cqW();
                return;
            }
            cqY();
            this.egU.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cqV() {
        if (this.gnE != null) {
            this.gnE.scrollToPosition(0);
        }
        cqY();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            I(fVar);
        }
    }

    public PbActivity ckE() {
        return this.iBR != null ? this.iBR : this.iUN.ckE();
    }

    public VideoPbFragment ckD() {
        if (this.iUN == null && this.iBR != null) {
            Fragment cji = this.iBR.cji();
            if (cji instanceof VideoPbFragment) {
                this.iUN = (VideoPbFragment) cji;
            }
        }
        return this.iUN;
    }

    public PbModel ciU() {
        return ckD().ciU();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iUP != null) {
            this.iUP.notifyDataSetChanged();
        }
        if (this.egU != null) {
            this.egU.changeSkin(i);
        }
    }

    private void cqW() {
        if (this.egU != null) {
            this.egU.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void cqX() {
        if (this.iUP != null) {
            this.iUP.cqQ();
        }
    }

    private void cqY() {
        if (this.egU != null) {
            this.egU.aFa();
        }
    }

    public int cqZ() {
        return this.iUQ;
    }

    public void qG(boolean z) {
        if (this.gnE != null) {
            this.gnE.setCanFling(z);
        }
    }
}
