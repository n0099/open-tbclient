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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private PbListView fnt;
    private BdTypeRecyclerView hEN;
    private e kbG;
    private PbActivity keN;
    private VideoPbFragment kyE;
    private com.baidu.tieba.pb.videopb.a.a kyG;
    private String kyI;
    private String kyJ;
    private int kyH = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.kyE != null) {
                DetailInfoFragment.this.kyE.cLO();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.kyE != null && !DetailInfoFragment.this.kyE.cPA()) {
                DetailInfoFragment.this.kbG.sR(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> cPR;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.kyE != null && !DetailInfoFragment.this.kyE.cPA() && ((cPR = DetailInfoFragment.this.kbG.cPR()) == null || cPR.getValue() == null || cPR.getValue().booleanValue())) {
                DetailInfoFragment.this.kbG.sR(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.kyH != 0 && DetailInfoFragment.this.kyE != null) {
                    DetailInfoFragment.this.kyE.BT(8);
                }
                DetailInfoFragment.this.kyH = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.kyE != null && DetailInfoFragment.this.kyH == 0) {
                DetailInfoFragment.this.kyE.BT(0);
            }
            DetailInfoFragment.this.kyH = 2;
        }
    };
    private CustomMessageListener hSY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cIf() != null && DetailInfoFragment.this.cIf().getPbData() != null) {
                DetailInfoFragment.this.JM((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cIf().cKv();
                DetailInfoFragment.this.kyG.setData(DetailInfoFragment.this.cIf().getPbData());
            }
        }
    };

    public static DetailInfoFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.kyE = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.keN = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.hSY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.kbG = (e) y.b(getFragmentActivity()).l(e.class);
        bS(inflate);
        return inflate;
    }

    private void bS(View view) {
        this.hEN = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hEN.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hEN.addOnScrollListener(this.mOnScrollListener);
        this.hEN.setOnTouchListener(cJI().bjb());
        this.fnt = new PbListView(getContext());
        this.fnt.getView();
        this.fnt.setText("");
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setLineGone();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fnt.aXZ();
        this.hEN.setNextPage(this.fnt);
        this.kyG = new com.baidu.tieba.pb.videopb.a.a(this, this.hEN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.kbG != null) {
            cQd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hSY);
        super.onDestroy();
    }

    private void cQd() {
        com.baidu.tieba.pb.data.e cPK = this.kbG.cPK();
        if (cPK == null) {
            cPK = this.kbG.cPJ();
        }
        N(cPK);
    }

    private void N(com.baidu.tieba.pb.data.e eVar) {
        if (this.kbG != null && eVar != null) {
            O(eVar);
            P(eVar);
            this.kyG.setData(eVar);
        }
    }

    private void O(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.cGO() != null) {
                str = eVar.getThreadId();
                if (eVar.cGO().getBaijiahaoData() != null) {
                    str2 = eVar.cGO().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.kyI || str2 != this.kyJ) {
                cQe();
            }
            this.kyI = str;
            this.kyJ = str2;
        }
    }

    private void P(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (w.isEmpty(eVar.cHp())) {
                cQf();
                return;
            }
            cQh();
            this.fnt.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cQe() {
        if (this.hEN != null) {
            this.hEN.scrollToPosition(0);
        }
        cQh();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            N(eVar);
        }
    }

    public PbActivity cJJ() {
        return this.keN != null ? this.keN : this.kyE.cJJ();
    }

    public VideoPbFragment cJI() {
        if (this.kyE == null && this.keN != null) {
            Fragment cIr = this.keN.cIr();
            if (cIr instanceof VideoPbFragment) {
                this.kyE = (VideoPbFragment) cIr;
            }
        }
        return this.kyE;
    }

    public PbModel cIf() {
        return cJI().cIf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kyG != null) {
            this.kyG.notifyDataSetChanged();
        }
        if (this.fnt != null) {
            this.fnt.changeSkin(i);
        }
    }

    private void cQf() {
        if (this.fnt != null) {
            this.fnt.s(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void cQg() {
        if (this.kyG != null) {
            this.kyG.cPZ();
        }
    }

    private void cQh() {
        if (this.fnt != null) {
            this.fnt.aYa();
        }
    }

    public int cQi() {
        return this.kyH;
    }

    public void sU(boolean z) {
        if (this.hEN != null) {
            this.hEN.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JM(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> cHu = cIf().getPbData().cHu();
            for (n nVar : cHu) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    cHu.remove(nVar);
                    return;
                }
            }
        }
    }
}
