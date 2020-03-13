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
    private PbListView elw;
    private BdTypeRecyclerView gtd;
    private e iEv;
    private PbActivity iHn;
    private VideoPbFragment jak;
    private com.baidu.tieba.pb.videopb.a.a jam;
    private String jao;
    private String jap;
    private int jan = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.jak != null) {
                DetailInfoFragment.this.jak.cpl();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.jak != null && !DetailInfoFragment.this.jak.csW()) {
                DetailInfoFragment.this.iEv.qV(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> ctn;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.jak != null && !DetailInfoFragment.this.jak.csW() && ((ctn = DetailInfoFragment.this.iEv.ctn()) == null || ctn.getValue() == null || ctn.getValue().booleanValue())) {
                DetailInfoFragment.this.iEv.qV(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.jan != 0 && DetailInfoFragment.this.jak != null) {
                    DetailInfoFragment.this.jak.zv(8);
                }
                DetailInfoFragment.this.jan = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.jak != null && DetailInfoFragment.this.jan == 0) {
                DetailInfoFragment.this.jak.zv(0);
            }
            DetailInfoFragment.this.jan = 2;
        }
    };

    public static DetailInfoFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.jak = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iHn = (PbActivity) context;
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
        this.iEv = (e) y.b(getFragmentActivity()).l(e.class);
        bJ(inflate);
        return inflate;
    }

    private void bJ(View view) {
        this.gtd = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.gtd.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gtd.addOnScrollListener(this.mOnScrollListener);
        this.gtd.setOnTouchListener(cni().aSq());
        this.elw = new PbListView(getContext());
        this.elw.getView();
        this.elw.setText("");
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setLineGone();
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elw.aHH();
        this.gtd.setNextPage(this.elw);
        this.jam = new com.baidu.tieba.pb.videopb.a.a(this, this.gtd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iEv != null) {
            ctz();
        }
    }

    private void ctz() {
        com.baidu.tieba.pb.data.e ctg = this.iEv.ctg();
        if (ctg == null) {
            ctg = this.iEv.ctf();
        }
        K(ctg);
    }

    private void K(com.baidu.tieba.pb.data.e eVar) {
        if (this.iEv != null && eVar != null) {
            L(eVar);
            M(eVar);
            this.jam.setData(eVar);
        }
    }

    private void L(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.ckv() != null) {
                str = eVar.getThreadId();
                if (eVar.ckv().getBaijiahaoData() != null) {
                    str2 = eVar.ckv().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.jao || str2 != this.jap) {
                ctA();
            }
            this.jao = str;
            this.jap = str2;
        }
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.ckS())) {
                ctB();
                return;
            }
            ctD();
            this.elw.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void ctA() {
        if (this.gtd != null) {
            this.gtd.scrollToPosition(0);
        }
        ctD();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            K(eVar);
        }
    }

    public PbActivity cnj() {
        return this.iHn != null ? this.iHn : this.jak.cnj();
    }

    public VideoPbFragment cni() {
        if (this.jak == null && this.iHn != null) {
            Fragment clO = this.iHn.clO();
            if (clO instanceof VideoPbFragment) {
                this.jak = (VideoPbFragment) clO;
            }
        }
        return this.jak;
    }

    public PbModel clC() {
        return cni().clC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jam != null) {
            this.jam.notifyDataSetChanged();
        }
        if (this.elw != null) {
            this.elw.changeSkin(i);
        }
    }

    private void ctB() {
        if (this.elw != null) {
            this.elw.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void ctC() {
        if (this.jam != null) {
            this.jam.ctv();
        }
    }

    private void ctD() {
        if (this.elw != null) {
            this.elw.aHI();
        }
    }

    public int ctE() {
        return this.jan;
    }

    public void qY(boolean z) {
        if (this.gtd != null) {
            this.gtd.setCanFling(z);
        }
    }
}
