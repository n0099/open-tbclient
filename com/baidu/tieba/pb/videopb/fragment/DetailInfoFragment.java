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
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a;
import com.baidu.tieba.pb.videopb.e;
/* loaded from: classes9.dex */
public class DetailInfoFragment extends BaseFragment implements a {
    private PbListView elj;
    private BdTypeRecyclerView gsQ;
    private e iEj;
    private PbActivity iHb;
    private VideoPbFragment iZY;
    private com.baidu.tieba.pb.videopb.a.a jaa;
    private String jac;
    private String jad;
    private int jab = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.iZY != null) {
                DetailInfoFragment.this.iZY.cpk();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.iZY != null && !DetailInfoFragment.this.iZY.csV()) {
                DetailInfoFragment.this.iEj.qV(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> ctm;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.iZY != null && !DetailInfoFragment.this.iZY.csV() && ((ctm = DetailInfoFragment.this.iEj.ctm()) == null || ctm.getValue() == null || ctm.getValue().booleanValue())) {
                DetailInfoFragment.this.iEj.qV(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.jab != 0 && DetailInfoFragment.this.iZY != null) {
                    DetailInfoFragment.this.iZY.zv(8);
                }
                DetailInfoFragment.this.jab = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.iZY != null && DetailInfoFragment.this.jab == 0) {
                DetailInfoFragment.this.iZY.zv(0);
            }
            DetailInfoFragment.this.jab = 2;
        }
    };

    public static DetailInfoFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.iZY = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iHb = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.iEj = (e) y.b(getFragmentActivity()).l(e.class);
        bJ(inflate);
        return inflate;
    }

    private void bJ(View view) {
        this.gsQ = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.gsQ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gsQ.addOnScrollListener(this.mOnScrollListener);
        this.gsQ.setOnTouchListener(cnh().aSp());
        this.elj = new PbListView(getContext());
        this.elj.getView();
        this.elj.setText("");
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setLineGone();
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elj.aHG();
        this.gsQ.setNextPage(this.elj);
        this.jaa = new com.baidu.tieba.pb.videopb.a.a(this, this.gsQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iEj != null) {
            cty();
        }
    }

    private void cty() {
        com.baidu.tieba.pb.data.e ctf = this.iEj.ctf();
        if (ctf == null) {
            ctf = this.iEj.cte();
        }
        K(ctf);
    }

    private void K(com.baidu.tieba.pb.data.e eVar) {
        if (this.iEj != null && eVar != null) {
            L(eVar);
            M(eVar);
            this.jaa.setData(eVar);
        }
    }

    private void L(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.cku() != null) {
                str = eVar.getThreadId();
                if (eVar.cku().getBaijiahaoData() != null) {
                    str2 = eVar.cku().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.jac || str2 != this.jad) {
                ctz();
            }
            this.jac = str;
            this.jad = str2;
        }
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.ckR())) {
                ctA();
                return;
            }
            ctC();
            this.elj.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void ctz() {
        if (this.gsQ != null) {
            this.gsQ.scrollToPosition(0);
        }
        ctC();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            K(eVar);
        }
    }

    public PbActivity cni() {
        return this.iHb != null ? this.iHb : this.iZY.cni();
    }

    public VideoPbFragment cnh() {
        if (this.iZY == null && this.iHb != null) {
            Fragment clN = this.iHb.clN();
            if (clN instanceof VideoPbFragment) {
                this.iZY = (VideoPbFragment) clN;
            }
        }
        return this.iZY;
    }

    public PbModel clB() {
        return cnh().clB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jaa != null) {
            this.jaa.notifyDataSetChanged();
        }
        if (this.elj != null) {
            this.elj.changeSkin(i);
        }
    }

    private void ctA() {
        if (this.elj != null) {
            this.elj.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void ctB() {
        if (this.jaa != null) {
            this.jaa.ctu();
        }
    }

    private void ctC() {
        if (this.elj != null) {
            this.elj.aHH();
        }
    }

    public int ctD() {
        return this.jab;
    }

    public void qY(boolean z) {
        if (this.gsQ != null) {
            this.gsQ.setCanFling(z);
        }
    }
}
