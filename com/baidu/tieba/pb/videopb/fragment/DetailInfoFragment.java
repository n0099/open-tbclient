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
/* loaded from: classes21.dex */
public class DetailInfoFragment extends BaseFragment implements com.baidu.tieba.pb.videopb.a {
    private PbListView fHm;
    private BdTypeRecyclerView iga;
    private e kIi;
    private PbActivity kLA;
    private VideoPbFragment lgd;
    private com.baidu.tieba.pb.videopb.a.a lgo;
    private String lgp;
    private String lgq;
    private int lgl = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.lgd != null) {
                DetailInfoFragment.this.lgd.ddU();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.lgd != null && !DetailInfoFragment.this.lgd.dhL()) {
                DetailInfoFragment.this.kIi.uq(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> dic;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.lgd != null && !DetailInfoFragment.this.lgd.dhL() && ((dic = DetailInfoFragment.this.kIi.dic()) == null || dic.getValue() == null || dic.getValue().booleanValue())) {
                DetailInfoFragment.this.kIi.uq(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.lgl != 0 && DetailInfoFragment.this.lgd != null) {
                    DetailInfoFragment.this.lgd.Fo(8);
                }
                DetailInfoFragment.this.lgl = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.lgd != null && DetailInfoFragment.this.lgl == 0) {
                DetailInfoFragment.this.lgd.Fo(0);
            }
            DetailInfoFragment.this.lgl = 2;
        }
    };
    private CustomMessageListener kMR = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dah() != null && DetailInfoFragment.this.dah().getPbData() != null) {
                DetailInfoFragment.this.dah().getPbData().cZl();
                DetailInfoFragment.this.dah().dcA();
                DetailInfoFragment.this.lgo.setData(DetailInfoFragment.this.dah().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener iuE = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dah() != null && DetailInfoFragment.this.dah().getPbData() != null) {
                DetailInfoFragment.this.NU((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dah().dcA();
                DetailInfoFragment.this.lgo.setData(DetailInfoFragment.this.dah().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.lgd = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.kLA = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.iuE);
        this.kMR.setSelfListener(true);
        if (dbM() != null) {
            this.kMR.setTag(dbM().getUniqueId());
        } else if (getPageContext() != null) {
            this.kMR.setTag(getPageContext().getUniqueId());
        }
        this.kMR.setPriority(-1);
        MessageManager.getInstance().registerListener(this.kMR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.kIi = (e) y.b(getFragmentActivity()).l(e.class);
        cj(inflate);
        return inflate;
    }

    private void cj(View view) {
        this.iga = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.iga.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iga.addOnScrollListener(this.mOnScrollListener);
        this.iga.setOnTouchListener(dbL().bwR());
        this.fHm = new PbListView(getContext());
        this.fHm.getView();
        this.fHm.setText("");
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setLineGone();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fHm.blq();
        this.iga.setNextPage(this.fHm);
        this.lgo = new com.baidu.tieba.pb.videopb.a.a(this, this.iga);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.kIi != null) {
            diA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iuE);
        MessageManager.getInstance().unRegisterListener(this.kMR);
        super.onDestroy();
    }

    private void diA() {
        f dhV = this.kIi.dhV();
        if (dhV == null) {
            dhV = this.kIi.dhU();
        }
        O(dhV);
    }

    private void O(f fVar) {
        if (this.kIi != null && fVar != null) {
            P(fVar);
            Q(fVar);
            this.lgo.setData(fVar);
        }
    }

    private void P(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.cYR() != null) {
                str = fVar.getThreadId();
                if (fVar.cYR().getBaijiahaoData() != null) {
                    str2 = fVar.cYR().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.lgp || str2 != this.lgq) {
                diB();
            }
            this.lgp = str;
            this.lgq = str2;
        }
    }

    private void Q(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.cZt())) {
                diC();
                return;
            }
            diE();
            this.fHm.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void diB() {
        if (this.iga != null) {
            this.iga.scrollToPosition(0);
        }
        diE();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            O(fVar);
        }
    }

    public PbActivity dbM() {
        return this.kLA != null ? this.kLA : this.lgd.dbM();
    }

    public VideoPbFragment dbL() {
        if (this.lgd == null && this.kLA != null) {
            Fragment dat = this.kLA.dat();
            if (dat instanceof VideoPbFragment) {
                this.lgd = (VideoPbFragment) dat;
            }
        }
        return this.lgd;
    }

    public PbModel dah() {
        return dbL().dah();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lgo != null) {
            this.lgo.notifyDataSetChanged();
        }
        if (this.fHm != null) {
            this.fHm.changeSkin(i);
        }
    }

    private void diC() {
        if (this.fHm != null) {
            this.fHm.r(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void diD() {
        if (this.lgo != null) {
            this.lgo.dik();
        }
    }

    private void diE() {
        if (this.fHm != null) {
            this.fHm.blr();
        }
    }

    public int dix() {
        return this.lgl;
    }

    public void ut(boolean z) {
        if (this.iga != null) {
            this.iga.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NU(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> cZy = dah().getPbData().cZy();
            for (n nVar : cZy) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    cZy.remove(nVar);
                    return;
                }
            }
        }
    }
}
