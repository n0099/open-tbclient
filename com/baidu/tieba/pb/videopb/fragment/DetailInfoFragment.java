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
    private PbListView eli;
    private BdTypeRecyclerView gsO;
    private e iEh;
    private PbActivity iGZ;
    private VideoPbFragment iZW;
    private com.baidu.tieba.pb.videopb.a.a iZY;
    private String jaa;
    private String jab;
    private int iZZ = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.iZW != null) {
                DetailInfoFragment.this.iZW.cpi();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.iZW != null && !DetailInfoFragment.this.iZW.csT()) {
                DetailInfoFragment.this.iEh.qV(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> ctk;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.iZW != null && !DetailInfoFragment.this.iZW.csT() && ((ctk = DetailInfoFragment.this.iEh.ctk()) == null || ctk.getValue() == null || ctk.getValue().booleanValue())) {
                DetailInfoFragment.this.iEh.qV(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.iZZ != 0 && DetailInfoFragment.this.iZW != null) {
                    DetailInfoFragment.this.iZW.zv(8);
                }
                DetailInfoFragment.this.iZZ = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.iZW != null && DetailInfoFragment.this.iZZ == 0) {
                DetailInfoFragment.this.iZW.zv(0);
            }
            DetailInfoFragment.this.iZZ = 2;
        }
    };

    public static DetailInfoFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.iZW = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iGZ = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.iEh = (e) y.b(getFragmentActivity()).l(e.class);
        bJ(inflate);
        return inflate;
    }

    private void bJ(View view) {
        this.gsO = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.gsO.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gsO.addOnScrollListener(this.mOnScrollListener);
        this.gsO.setOnTouchListener(cnf().aSn());
        this.eli = new PbListView(getContext());
        this.eli.getView();
        this.eli.setText("");
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setLineGone();
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.eli.aHE();
        this.gsO.setNextPage(this.eli);
        this.iZY = new com.baidu.tieba.pb.videopb.a.a(this, this.gsO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iEh != null) {
            ctw();
        }
    }

    private void ctw() {
        com.baidu.tieba.pb.data.e ctd = this.iEh.ctd();
        if (ctd == null) {
            ctd = this.iEh.ctc();
        }
        K(ctd);
    }

    private void K(com.baidu.tieba.pb.data.e eVar) {
        if (this.iEh != null && eVar != null) {
            L(eVar);
            M(eVar);
            this.iZY.setData(eVar);
        }
    }

    private void L(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.cks() != null) {
                str = eVar.getThreadId();
                if (eVar.cks().getBaijiahaoData() != null) {
                    str2 = eVar.cks().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.jaa || str2 != this.jab) {
                ctx();
            }
            this.jaa = str;
            this.jab = str2;
        }
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.ckP())) {
                cty();
                return;
            }
            ctA();
            this.eli.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void ctx() {
        if (this.gsO != null) {
            this.gsO.scrollToPosition(0);
        }
        ctA();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            K(eVar);
        }
    }

    public PbActivity cng() {
        return this.iGZ != null ? this.iGZ : this.iZW.cng();
    }

    public VideoPbFragment cnf() {
        if (this.iZW == null && this.iGZ != null) {
            Fragment clL = this.iGZ.clL();
            if (clL instanceof VideoPbFragment) {
                this.iZW = (VideoPbFragment) clL;
            }
        }
        return this.iZW;
    }

    public PbModel clz() {
        return cnf().clz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iZY != null) {
            this.iZY.notifyDataSetChanged();
        }
        if (this.eli != null) {
            this.eli.changeSkin(i);
        }
    }

    private void cty() {
        if (this.eli != null) {
            this.eli.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void ctz() {
        if (this.iZY != null) {
            this.iZY.cts();
        }
    }

    private void ctA() {
        if (this.eli != null) {
            this.eli.aHF();
        }
    }

    public int ctB() {
        return this.iZZ;
    }

    public void qY(boolean z) {
        if (this.gsO != null) {
            this.gsO.setCanFling(z);
        }
    }
}
