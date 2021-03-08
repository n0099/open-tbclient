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
    private PbListView gCf;
    private BdTypeRecyclerView joh;
    private VideoPbViewModel lPz;
    private PbActivity lTk;
    private VideoPbFragment moj;
    private com.baidu.tieba.pb.videopb.a.a mow;
    private String mox;
    private String moy;
    private int mos = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.moj != null) {
                DetailInfoFragment.this.moj.dqB();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.moj != null && !DetailInfoFragment.this.moj.cFI()) {
                DetailInfoFragment.this.lPz.wr(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> duP;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.moj != null && !DetailInfoFragment.this.moj.cFI() && ((duP = DetailInfoFragment.this.lPz.duP()) == null || duP.getValue() == null || duP.getValue().booleanValue())) {
                DetailInfoFragment.this.lPz.wr(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mos != 0 && DetailInfoFragment.this.moj != null) {
                    DetailInfoFragment.this.moj.Gy(8);
                }
                DetailInfoFragment.this.mos = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.moj != null && DetailInfoFragment.this.mos == 0) {
                DetailInfoFragment.this.moj.Gy(0);
            }
            DetailInfoFragment.this.mos = 2;
        }
    };
    private CustomMessageListener lUG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dmG() != null && DetailInfoFragment.this.dmG().getPbData() != null) {
                DetailInfoFragment.this.dmG().getPbData().dlJ();
                DetailInfoFragment.this.dmG().dpf();
                DetailInfoFragment.this.mow.setData(DetailInfoFragment.this.dmG().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dmG() != null && DetailInfoFragment.this.dmG().getPbData() != null) {
                DetailInfoFragment.this.Py((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dmG().dpf();
                DetailInfoFragment.this.mow.setData(DetailInfoFragment.this.dmG().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.moj = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lTk = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jrj);
        this.lUG.setSelfListener(true);
        if (doq() != null) {
            this.lUG.setTag(doq().getUniqueId());
        } else if (getPageContext() != null) {
            this.lUG.setTag(getPageContext().getUniqueId());
        }
        this.lUG.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lUG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lPz = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        cP(inflate);
        return inflate;
    }

    private void cP(View view) {
        this.joh = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.joh.setLayoutManager(new LinearLayoutManager(getContext()));
        this.joh.addOnScrollListener(this.mOnScrollListener);
        this.joh.setOnTouchListener(dop().bFK());
        this.gCf = new PbListView(getContext());
        this.gCf.getView();
        this.gCf.setText("");
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.bug();
        this.joh.setNextPage(this.gCf);
        this.mow = new com.baidu.tieba.pb.videopb.a.a(this, this.joh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lPz != null) {
            dvo();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jrj);
        MessageManager.getInstance().unRegisterListener(this.lUG);
        super.onDestroy();
    }

    private void dvo() {
        f duI = this.lPz.duI();
        if (duI == null) {
            duI = this.lPz.duH();
        }
        Q(duI);
    }

    private void Q(f fVar) {
        if (this.lPz != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mow.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2;
        if (fVar != null) {
            if (fVar.dlp() != null) {
                str2 = fVar.getThreadId();
                str = fVar.dlp().getBaijiahaoData() != null ? fVar.dlp().getBaijiahaoData().oriUgcNid : null;
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != this.mox || str != this.moy) {
                dvp();
            }
            this.mox = str2;
            this.moy = str;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (y.isEmpty(fVar.dlR())) {
                dvq();
                return;
            }
            dvs();
            this.gCf.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dvp() {
        if (this.joh != null) {
            this.joh.scrollToPosition(0);
        }
        dvs();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity doq() {
        return this.lTk != null ? this.lTk : this.moj.doq();
    }

    public VideoPbFragment dop() {
        if (this.moj == null && this.lTk != null) {
            Fragment dmS = this.lTk.dmS();
            if (dmS instanceof VideoPbFragment) {
                this.moj = (VideoPbFragment) dmS;
            }
        }
        return this.moj;
    }

    public PbModel dmG() {
        return dop().dmG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mow != null) {
            this.mow.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
    }

    private void dvq() {
        if (this.gCf != null) {
            this.gCf.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dvr() {
        if (this.mow != null) {
            this.mow.duW();
        }
    }

    private void dvs() {
        if (this.gCf != null) {
            this.gCf.buh();
        }
    }

    public int dvl() {
        return this.mos;
    }

    public void wv(boolean z) {
        if (this.joh != null) {
            this.joh.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<o> dlW = dmG().getPbData().dlW();
            for (o oVar : dlW) {
                if (TextUtils.equals(str, oVar.getAdId())) {
                    dlW.remove(oVar);
                    return;
                }
            }
        }
    }
}
