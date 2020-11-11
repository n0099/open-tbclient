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
    private PbListView gjo;
    private BdTypeRecyclerView iNq;
    private VideoPbFragment lNO;
    private com.baidu.tieba.pb.videopb.a.a lNZ;
    private String lOa;
    private String lOb;
    private e lpT;
    private PbActivity ltl;
    private int lNW = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.lNO != null) {
                DetailInfoFragment.this.lNO.dnm();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.lNO != null && !DetailInfoFragment.this.lNO.dre()) {
                DetailInfoFragment.this.lpT.vx(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> drv;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.lNO != null && !DetailInfoFragment.this.lNO.dre() && ((drv = DetailInfoFragment.this.lpT.drv()) == null || drv.getValue() == null || drv.getValue().booleanValue())) {
                DetailInfoFragment.this.lpT.vx(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.lNW != 0 && DetailInfoFragment.this.lNO != null) {
                    DetailInfoFragment.this.lNO.GA(8);
                }
                DetailInfoFragment.this.lNW = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.lNO != null && DetailInfoFragment.this.lNW == 0) {
                DetailInfoFragment.this.lNO.GA(0);
            }
            DetailInfoFragment.this.lNW = 2;
        }
    };
    private CustomMessageListener luD = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.djz() != null && DetailInfoFragment.this.djz().getPbData() != null) {
                DetailInfoFragment.this.djz().getPbData().diE();
                DetailInfoFragment.this.djz().dlS();
                DetailInfoFragment.this.lNZ.setData(DetailInfoFragment.this.djz().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jbQ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.djz() != null && DetailInfoFragment.this.djz().getPbData() != null) {
                DetailInfoFragment.this.Py((String) customResponsedMessage.getData());
                DetailInfoFragment.this.djz().dlS();
                DetailInfoFragment.this.lNZ.setData(DetailInfoFragment.this.djz().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.lNO = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.ltl = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jbQ);
        this.luD.setSelfListener(true);
        if (dle() != null) {
            this.luD.setTag(dle().getUniqueId());
        } else if (getPageContext() != null) {
            this.luD.setTag(getPageContext().getUniqueId());
        }
        this.luD.setPriority(-1);
        MessageManager.getInstance().registerListener(this.luD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lpT = (e) y.b(getFragmentActivity()).l(e.class);
        cw(inflate);
        return inflate;
    }

    private void cw(View view) {
        this.iNq = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.iNq.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iNq.addOnScrollListener(this.mOnScrollListener);
        this.iNq.setOnTouchListener(dld().bDT());
        this.gjo = new PbListView(getContext());
        this.gjo.getView();
        this.gjo.setText("");
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setLineGone();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gjo.bst();
        this.iNq.setNextPage(this.gjo);
        this.lNZ = new com.baidu.tieba.pb.videopb.a.a(this, this.iNq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lpT != null) {
            drT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jbQ);
        MessageManager.getInstance().unRegisterListener(this.luD);
        super.onDestroy();
    }

    private void drT() {
        f dro = this.lpT.dro();
        if (dro == null) {
            dro = this.lpT.drn();
        }
        O(dro);
    }

    private void O(f fVar) {
        if (this.lpT != null && fVar != null) {
            P(fVar);
            Q(fVar);
            this.lNZ.setData(fVar);
        }
    }

    private void P(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.dik() != null) {
                str = fVar.getThreadId();
                if (fVar.dik().getBaijiahaoData() != null) {
                    str2 = fVar.dik().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.lOa || str2 != this.lOb) {
                drU();
            }
            this.lOa = str;
            this.lOb = str2;
        }
    }

    private void Q(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.diM())) {
                drV();
                return;
            }
            drX();
            this.gjo.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void drU() {
        if (this.iNq != null) {
            this.iNq.scrollToPosition(0);
        }
        drX();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            O(fVar);
        }
    }

    public PbActivity dle() {
        return this.ltl != null ? this.ltl : this.lNO.dle();
    }

    public VideoPbFragment dld() {
        if (this.lNO == null && this.ltl != null) {
            Fragment djL = this.ltl.djL();
            if (djL instanceof VideoPbFragment) {
                this.lNO = (VideoPbFragment) djL;
            }
        }
        return this.lNO;
    }

    public PbModel djz() {
        return dld().djz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lNZ != null) {
            this.lNZ.notifyDataSetChanged();
        }
        if (this.gjo != null) {
            this.gjo.changeSkin(i);
        }
    }

    private void drV() {
        if (this.gjo != null) {
            this.gjo.s(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void drW() {
        if (this.lNZ != null) {
            this.lNZ.drD();
        }
    }

    private void drX() {
        if (this.gjo != null) {
            this.gjo.bsu();
        }
    }

    public int drQ() {
        return this.lNW;
    }

    public void vA(boolean z) {
        if (this.iNq != null) {
            this.iNq.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> diR = djz().getPbData().diR();
            for (n nVar : diR) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    diR.remove(nVar);
                    return;
                }
            }
        }
    }
}
