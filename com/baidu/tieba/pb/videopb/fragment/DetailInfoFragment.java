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
    private PbListView gAw;
    private BdTypeRecyclerView jmy;
    private VideoPbViewModel lNx;
    private PbActivity lRi;
    private VideoPbFragment mmh;
    private com.baidu.tieba.pb.videopb.a.a mmt;
    private String mmu;
    private String mmv;
    private int mmp = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.mmh != null) {
                DetailInfoFragment.this.mmh.dqs();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.mmh != null && !DetailInfoFragment.this.mmh.cFC()) {
                DetailInfoFragment.this.lNx.wr(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> duG;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.mmh != null && !DetailInfoFragment.this.mmh.cFC() && ((duG = DetailInfoFragment.this.lNx.duG()) == null || duG.getValue() == null || duG.getValue().booleanValue())) {
                DetailInfoFragment.this.lNx.wr(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mmp != 0 && DetailInfoFragment.this.mmh != null) {
                    DetailInfoFragment.this.mmh.Gv(8);
                }
                DetailInfoFragment.this.mmp = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.mmh != null && DetailInfoFragment.this.mmp == 0) {
                DetailInfoFragment.this.mmh.Gv(0);
            }
            DetailInfoFragment.this.mmp = 2;
        }
    };
    private CustomMessageListener lSE = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dmx() != null && DetailInfoFragment.this.dmx().getPbData() != null) {
                DetailInfoFragment.this.dmx().getPbData().dlA();
                DetailInfoFragment.this.dmx().doW();
                DetailInfoFragment.this.mmt.setData(DetailInfoFragment.this.dmx().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dmx() != null && DetailInfoFragment.this.dmx().getPbData() != null) {
                DetailInfoFragment.this.Ps((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dmx().doW();
                DetailInfoFragment.this.mmt.setData(DetailInfoFragment.this.dmx().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.mmh = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lRi = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jpA);
        this.lSE.setSelfListener(true);
        if (doh() != null) {
            this.lSE.setTag(doh().getUniqueId());
        } else if (getPageContext() != null) {
            this.lSE.setTag(getPageContext().getUniqueId());
        }
        this.lSE.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lNx = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        cP(inflate);
        return inflate;
    }

    private void cP(View view) {
        this.jmy = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.jmy.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jmy.addOnScrollListener(this.mOnScrollListener);
        this.jmy.setOnTouchListener(dog().bFG());
        this.gAw = new PbListView(getContext());
        this.gAw.getView();
        this.gAw.setText("");
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setLineGone();
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAw.bud();
        this.jmy.setNextPage(this.gAw);
        this.mmt = new com.baidu.tieba.pb.videopb.a.a(this, this.jmy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lNx != null) {
            dvf();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jpA);
        MessageManager.getInstance().unRegisterListener(this.lSE);
        super.onDestroy();
    }

    private void dvf() {
        f duz = this.lNx.duz();
        if (duz == null) {
            duz = this.lNx.duy();
        }
        Q(duz);
    }

    private void Q(f fVar) {
        if (this.lNx != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mmt.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2;
        if (fVar != null) {
            if (fVar.dlg() != null) {
                str2 = fVar.getThreadId();
                str = fVar.dlg().getBaijiahaoData() != null ? fVar.dlg().getBaijiahaoData().oriUgcNid : null;
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != this.mmu || str != this.mmv) {
                dvg();
            }
            this.mmu = str2;
            this.mmv = str;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (y.isEmpty(fVar.dlI())) {
                dvh();
                return;
            }
            dvj();
            this.gAw.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dvg() {
        if (this.jmy != null) {
            this.jmy.scrollToPosition(0);
        }
        dvj();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity doh() {
        return this.lRi != null ? this.lRi : this.mmh.doh();
    }

    public VideoPbFragment dog() {
        if (this.mmh == null && this.lRi != null) {
            Fragment dmJ = this.lRi.dmJ();
            if (dmJ instanceof VideoPbFragment) {
                this.mmh = (VideoPbFragment) dmJ;
            }
        }
        return this.mmh;
    }

    public PbModel dmx() {
        return dog().dmx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mmt != null) {
            this.mmt.notifyDataSetChanged();
        }
        if (this.gAw != null) {
            this.gAw.changeSkin(i);
        }
    }

    private void dvh() {
        if (this.gAw != null) {
            this.gAw.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dvi() {
        if (this.mmt != null) {
            this.mmt.duN();
        }
    }

    private void dvj() {
        if (this.gAw != null) {
            this.gAw.bue();
        }
    }

    public int dvc() {
        return this.mmp;
    }

    public void wv(boolean z) {
        if (this.jmy != null) {
            this.jmy.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ps(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<o> dlN = dmx().getPbData().dlN();
            for (o oVar : dlN) {
                if (TextUtils.equals(str, oVar.getAdId())) {
                    dlN.remove(oVar);
                    return;
                }
            }
        }
    }
}
