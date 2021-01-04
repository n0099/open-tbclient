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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private BdTypeRecyclerView jlj;
    private VideoPbViewModel lIZ;
    private PbActivity lME;
    private com.baidu.tieba.pb.videopb.a.a mhH;
    private String mhI;
    private String mhJ;
    private VideoPbFragment mhw;
    private int mhE = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.mhw != null) {
                DetailInfoFragment.this.mhw.drO();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.mhw != null && !DetailInfoFragment.this.mhw.dvN()) {
                DetailInfoFragment.this.lIZ.we(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> dwe;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.mhw != null && !DetailInfoFragment.this.mhw.dvN() && ((dwe = DetailInfoFragment.this.lIZ.dwe()) == null || dwe.getValue() == null || dwe.getValue().booleanValue())) {
                DetailInfoFragment.this.lIZ.we(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mhE != 0 && DetailInfoFragment.this.mhw != null) {
                    DetailInfoFragment.this.mhw.HI(8);
                }
                DetailInfoFragment.this.mhE = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.mhw != null && DetailInfoFragment.this.mhE == 0) {
                DetailInfoFragment.this.mhw.HI(0);
            }
            DetailInfoFragment.this.mhE = 2;
        }
    };
    private CustomMessageListener lNX = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dnV() != null && DetailInfoFragment.this.dnV().getPbData() != null) {
                DetailInfoFragment.this.dnV().getPbData().dmY();
                DetailInfoFragment.this.dnV().dqs();
                DetailInfoFragment.this.mhH.setData(DetailInfoFragment.this.dnV().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dnV() != null && DetailInfoFragment.this.dnV().getPbData() != null) {
                DetailInfoFragment.this.PI((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dnV().dqs();
                DetailInfoFragment.this.mhH.setData(DetailInfoFragment.this.dnV().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.mhw = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lME = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jom);
        this.lNX.setSelfListener(true);
        if (dpD() != null) {
            this.lNX.setTag(dpD().getUniqueId());
        } else if (getPageContext() != null) {
            this.lNX.setTag(getPageContext().getUniqueId());
        }
        this.lNX.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lNX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lIZ = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        cR(inflate);
        return inflate;
    }

    private void cR(View view) {
        this.jlj = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.jlj.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jlj.addOnScrollListener(this.mOnScrollListener);
        this.jlj.setOnTouchListener(dpC().bJe());
        this.gCf = new PbListView(getContext());
        this.gCf.getView();
        this.gCf.setText("");
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.bxC();
        this.jlj.setNextPage(this.gCf);
        this.mhH = new com.baidu.tieba.pb.videopb.a.a(this, this.jlj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lIZ != null) {
            dwC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jom);
        MessageManager.getInstance().unRegisterListener(this.lNX);
        super.onDestroy();
    }

    private void dwC() {
        f dvX = this.lIZ.dvX();
        if (dvX == null) {
            dvX = this.lIZ.dvW();
        }
        Q(dvX);
    }

    private void Q(f fVar) {
        if (this.lIZ != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mhH.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2;
        if (fVar != null) {
            if (fVar.dmE() != null) {
                str2 = fVar.getThreadId();
                str = fVar.dmE().getBaijiahaoData() != null ? fVar.dmE().getBaijiahaoData().oriUgcNid : null;
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != this.mhI || str != this.mhJ) {
                dwD();
            }
            this.mhI = str2;
            this.mhJ = str;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (x.isEmpty(fVar.dng())) {
                dwE();
                return;
            }
            dwG();
            this.gCf.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dwD() {
        if (this.jlj != null) {
            this.jlj.scrollToPosition(0);
        }
        dwG();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity dpD() {
        return this.lME != null ? this.lME : this.mhw.dpD();
    }

    public VideoPbFragment dpC() {
        if (this.mhw == null && this.lME != null) {
            Fragment doh = this.lME.doh();
            if (doh instanceof VideoPbFragment) {
                this.mhw = (VideoPbFragment) doh;
            }
        }
        return this.mhw;
    }

    public PbModel dnV() {
        return dpC().dnV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mhH != null) {
            this.mhH.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
    }

    private void dwE() {
        if (this.gCf != null) {
            this.gCf.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dwF() {
        if (this.mhH != null) {
            this.mhH.dwm();
        }
    }

    private void dwG() {
        if (this.gCf != null) {
            this.gCf.bxD();
        }
    }

    public int dwz() {
        return this.mhE;
    }

    public void wi(boolean z) {
        if (this.jlj != null) {
            this.jlj.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PI(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<o> dnl = dnV().getPbData().dnl();
            for (o oVar : dnl) {
                if (TextUtils.equals(str, oVar.getAdId())) {
                    dnl.remove(oVar);
                    return;
                }
            }
        }
    }
}
