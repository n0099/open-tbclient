package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.List;
/* loaded from: classes2.dex */
public class DetailInfoFragment extends BaseFragment implements com.baidu.tieba.pb.videopb.a {
    private PbListView gAi;
    private BdTypeRecyclerView jmj;
    private VideoPbViewModel lNi;
    private PbActivity lQT;
    private VideoPbFragment mlS;
    private com.baidu.tieba.pb.videopb.a.a mme;
    private String mmf;
    private String mmg;
    private int mma = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.mlS != null) {
                DetailInfoFragment.this.mlS.dql();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.mlS != null && !DetailInfoFragment.this.mlS.cFv()) {
                DetailInfoFragment.this.lNi.wr(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> duz;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.mlS != null && !DetailInfoFragment.this.mlS.cFv() && ((duz = DetailInfoFragment.this.lNi.duz()) == null || duz.getValue() == null || duz.getValue().booleanValue())) {
                DetailInfoFragment.this.lNi.wr(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mma != 0 && DetailInfoFragment.this.mlS != null) {
                    DetailInfoFragment.this.mlS.Gv(8);
                }
                DetailInfoFragment.this.mma = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.mlS != null && DetailInfoFragment.this.mma == 0) {
                DetailInfoFragment.this.mlS.Gv(0);
            }
            DetailInfoFragment.this.mma = 2;
        }
    };
    private CustomMessageListener lSp = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dmq() != null && DetailInfoFragment.this.dmq().getPbData() != null) {
                DetailInfoFragment.this.dmq().getPbData().dlt();
                DetailInfoFragment.this.dmq().doP();
                DetailInfoFragment.this.mme.setData(DetailInfoFragment.this.dmq().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dmq() != null && DetailInfoFragment.this.dmq().getPbData() != null) {
                DetailInfoFragment.this.Pr((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dmq().doP();
                DetailInfoFragment.this.mme.setData(DetailInfoFragment.this.dmq().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.mlS = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lQT = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jpm);
        this.lSp.setSelfListener(true);
        if (doa() != null) {
            this.lSp.setTag(doa().getUniqueId());
        } else if (getPageContext() != null) {
            this.lSp.setTag(getPageContext().getUniqueId());
        }
        this.lSp.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lSp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lNi = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        cP(inflate);
        return inflate;
    }

    private void cP(View view) {
        this.jmj = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.jmj.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jmj.addOnScrollListener(this.mOnScrollListener);
        this.jmj.setOnTouchListener(dnZ().bFG());
        this.gAi = new PbListView(getContext());
        this.gAi.getView();
        this.gAi.setText("");
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setLineGone();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAi.bud();
        this.jmj.setNextPage(this.gAi);
        this.mme = new com.baidu.tieba.pb.videopb.a.a(this, this.jmj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lNi != null) {
            duY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jpm);
        MessageManager.getInstance().unRegisterListener(this.lSp);
        super.onDestroy();
    }

    private void duY() {
        f dus = this.lNi.dus();
        if (dus == null) {
            dus = this.lNi.dur();
        }
        Q(dus);
    }

    private void Q(f fVar) {
        if (this.lNi != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mme.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2;
        if (fVar != null) {
            if (fVar.dkZ() != null) {
                str2 = fVar.getThreadId();
                str = fVar.dkZ().getBaijiahaoData() != null ? fVar.dkZ().getBaijiahaoData().oriUgcNid : null;
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != this.mmf || str != this.mmg) {
                duZ();
            }
            this.mmf = str2;
            this.mmg = str;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (y.isEmpty(fVar.dlB())) {
                dva();
                return;
            }
            dvc();
            this.gAi.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void duZ() {
        if (this.jmj != null) {
            this.jmj.scrollToPosition(0);
        }
        dvc();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity doa() {
        return this.lQT != null ? this.lQT : this.mlS.doa();
    }

    public VideoPbFragment dnZ() {
        if (this.mlS == null && this.lQT != null) {
            Fragment dmC = this.lQT.dmC();
            if (dmC instanceof VideoPbFragment) {
                this.mlS = (VideoPbFragment) dmC;
            }
        }
        return this.mlS;
    }

    public PbModel dmq() {
        return dnZ().dmq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mme != null) {
            this.mme.notifyDataSetChanged();
        }
        if (this.gAi != null) {
            this.gAi.changeSkin(i);
        }
    }

    private void dva() {
        if (this.gAi != null) {
            this.gAi.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dvb() {
        if (this.mme != null) {
            this.mme.duG();
        }
    }

    private void dvc() {
        if (this.gAi != null) {
            this.gAi.bue();
        }
    }

    public int duV() {
        return this.mma;
    }

    public void wv(boolean z) {
        if (this.jmj != null) {
            this.jmj.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<o> dlG = dmq().getPbData().dlG();
            for (o oVar : dlG) {
                if (TextUtils.equals(str, oVar.getAdId())) {
                    dlG.remove(oVar);
                    return;
                }
            }
        }
    }
}
