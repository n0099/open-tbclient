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
/* loaded from: classes7.dex */
public class DetailInfoFragment extends BaseFragment implements a {
    private PbListView ehe;
    private BdTypeRecyclerView gqN;
    private e iCy;
    private PbActivity iFv;
    private String iYA;
    private VideoPbFragment iYv;
    private com.baidu.tieba.pb.videopb.a.a iYx;
    private String iYz;
    private int iYy = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.iYv != null) {
                DetailInfoFragment.this.iYv.cnR();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.iYv != null && !DetailInfoFragment.this.iYv.crE()) {
                DetailInfoFragment.this.iCy.qQ(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> crR;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.iYv != null && !DetailInfoFragment.this.iYv.crE() && ((crR = DetailInfoFragment.this.iCy.crR()) == null || crR.getValue() == null || crR.getValue().booleanValue())) {
                DetailInfoFragment.this.iCy.qQ(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.iYy != 0 && DetailInfoFragment.this.iYv != null) {
                    DetailInfoFragment.this.iYv.zp(8);
                }
                DetailInfoFragment.this.iYy = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.iYv != null && DetailInfoFragment.this.iYy == 0) {
                DetailInfoFragment.this.iYv.zp(0);
            }
            DetailInfoFragment.this.iYy = 2;
        }
    };

    public static DetailInfoFragment S(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.iYv = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iFv = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.iCy = (e) y.b(getFragmentActivity()).l(e.class);
        bJ(inflate);
        return inflate;
    }

    private void bJ(View view) {
        this.gqN = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.gqN.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gqN.addOnScrollListener(this.mOnScrollListener);
        this.gqN.setOnTouchListener(clL().aPW());
        this.ehe = new PbListView(getContext());
        this.ehe.getView();
        this.ehe.setText("");
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setLineGone();
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ehe.aFs();
        this.gqN.setNextPage(this.ehe);
        this.iYx = new com.baidu.tieba.pb.videopb.a.a(this, this.gqN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iCy != null) {
            csd();
        }
    }

    private void csd() {
        f crK = this.iCy.crK();
        if (crK == null) {
            crK = this.iCy.crJ();
        }
        I(crK);
    }

    private void I(f fVar) {
        if (this.iCy != null && fVar != null) {
            J(fVar);
            K(fVar);
            this.iYx.setData(fVar);
        }
    }

    private void J(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.ciS() != null) {
                str = fVar.getThreadId();
                if (fVar.ciS().getBaijiahaoData() != null) {
                    str2 = fVar.ciS().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.iYz || str2 != this.iYA) {
                cse();
            }
            this.iYz = str;
            this.iYA = str2;
        }
    }

    private void K(f fVar) {
        if (fVar != null) {
            if (v.isEmpty(fVar.cjr())) {
                csf();
                return;
            }
            csh();
            this.ehe.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cse() {
        if (this.gqN != null) {
            this.gqN.scrollToPosition(0);
        }
        csh();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            I(fVar);
        }
    }

    public PbActivity clM() {
        return this.iFv != null ? this.iFv : this.iYv.clM();
    }

    public VideoPbFragment clL() {
        if (this.iYv == null && this.iFv != null) {
            Fragment ckq = this.iFv.ckq();
            if (ckq instanceof VideoPbFragment) {
                this.iYv = (VideoPbFragment) ckq;
            }
        }
        return this.iYv;
    }

    public PbModel ckc() {
        return clL().ckc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iYx != null) {
            this.iYx.notifyDataSetChanged();
        }
        if (this.ehe != null) {
            this.ehe.changeSkin(i);
        }
    }

    private void csf() {
        if (this.ehe != null) {
            this.ehe.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void csg() {
        if (this.iYx != null) {
            this.iYx.crZ();
        }
    }

    private void csh() {
        if (this.ehe != null) {
            this.ehe.aFt();
        }
    }

    public int csi() {
        return this.iYy;
    }

    public void qT(boolean z) {
        if (this.gqN != null) {
            this.gqN.setCanFling(z);
        }
    }
}
