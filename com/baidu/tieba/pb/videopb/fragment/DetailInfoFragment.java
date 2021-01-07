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
    private VideoPbViewModel lIY;
    private PbActivity lMD;
    private com.baidu.tieba.pb.videopb.a.a mhG;
    private String mhH;
    private String mhI;
    private VideoPbFragment mhv;
    private int mhD = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.mhv != null) {
                DetailInfoFragment.this.mhv.drP();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.mhv != null && !DetailInfoFragment.this.mhv.dvO()) {
                DetailInfoFragment.this.lIY.we(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> dwf;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.mhv != null && !DetailInfoFragment.this.mhv.dvO() && ((dwf = DetailInfoFragment.this.lIY.dwf()) == null || dwf.getValue() == null || dwf.getValue().booleanValue())) {
                DetailInfoFragment.this.lIY.we(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mhD != 0 && DetailInfoFragment.this.mhv != null) {
                    DetailInfoFragment.this.mhv.HI(8);
                }
                DetailInfoFragment.this.mhD = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.mhv != null && DetailInfoFragment.this.mhD == 0) {
                DetailInfoFragment.this.mhv.HI(0);
            }
            DetailInfoFragment.this.mhD = 2;
        }
    };
    private CustomMessageListener lNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dnW() != null && DetailInfoFragment.this.dnW().getPbData() != null) {
                DetailInfoFragment.this.dnW().getPbData().dmZ();
                DetailInfoFragment.this.dnW().dqt();
                DetailInfoFragment.this.mhG.setData(DetailInfoFragment.this.dnW().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dnW() != null && DetailInfoFragment.this.dnW().getPbData() != null) {
                DetailInfoFragment.this.PH((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dnW().dqt();
                DetailInfoFragment.this.mhG.setData(DetailInfoFragment.this.dnW().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.mhv = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lMD = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jom);
        this.lNW.setSelfListener(true);
        if (dpE() != null) {
            this.lNW.setTag(dpE().getUniqueId());
        } else if (getPageContext() != null) {
            this.lNW.setTag(getPageContext().getUniqueId());
        }
        this.lNW.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lNW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lIY = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        cR(inflate);
        return inflate;
    }

    private void cR(View view) {
        this.jlj = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.jlj.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jlj.addOnScrollListener(this.mOnScrollListener);
        this.jlj.setOnTouchListener(dpD().bJf());
        this.gCf = new PbListView(getContext());
        this.gCf.getView();
        this.gCf.setText("");
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.bxD();
        this.jlj.setNextPage(this.gCf);
        this.mhG = new com.baidu.tieba.pb.videopb.a.a(this, this.jlj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lIY != null) {
            dwD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jom);
        MessageManager.getInstance().unRegisterListener(this.lNW);
        super.onDestroy();
    }

    private void dwD() {
        f dvY = this.lIY.dvY();
        if (dvY == null) {
            dvY = this.lIY.dvX();
        }
        Q(dvY);
    }

    private void Q(f fVar) {
        if (this.lIY != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mhG.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2;
        if (fVar != null) {
            if (fVar.dmF() != null) {
                str2 = fVar.getThreadId();
                str = fVar.dmF().getBaijiahaoData() != null ? fVar.dmF().getBaijiahaoData().oriUgcNid : null;
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != this.mhH || str != this.mhI) {
                dwE();
            }
            this.mhH = str2;
            this.mhI = str;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (x.isEmpty(fVar.dnh())) {
                dwF();
                return;
            }
            dwH();
            this.gCf.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dwE() {
        if (this.jlj != null) {
            this.jlj.scrollToPosition(0);
        }
        dwH();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity dpE() {
        return this.lMD != null ? this.lMD : this.mhv.dpE();
    }

    public VideoPbFragment dpD() {
        if (this.mhv == null && this.lMD != null) {
            Fragment doi = this.lMD.doi();
            if (doi instanceof VideoPbFragment) {
                this.mhv = (VideoPbFragment) doi;
            }
        }
        return this.mhv;
    }

    public PbModel dnW() {
        return dpD().dnW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mhG != null) {
            this.mhG.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
    }

    private void dwF() {
        if (this.gCf != null) {
            this.gCf.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dwG() {
        if (this.mhG != null) {
            this.mhG.dwn();
        }
    }

    private void dwH() {
        if (this.gCf != null) {
            this.gCf.bxE();
        }
    }

    public int dwA() {
        return this.mhD;
    }

    public void wi(boolean z) {
        if (this.jlj != null) {
            this.jlj.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PH(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<o> dnm = dnW().getPbData().dnm();
            for (o oVar : dnm) {
                if (TextUtils.equals(str, oVar.getAdId())) {
                    dnm.remove(oVar);
                    return;
                }
            }
        }
    }
}
