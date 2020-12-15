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
    private PbListView grg;
    private BdTypeRecyclerView iYW;
    private e lDT;
    private PbActivity lHp;
    private VideoPbFragment mck;
    private com.baidu.tieba.pb.videopb.a.a mcv;
    private String mcw;
    private String mcx;
    private int mcs = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.mck != null) {
                DetailInfoFragment.this.mck.dsc();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.mck != null && !DetailInfoFragment.this.mck.dvY()) {
                DetailInfoFragment.this.lDT.wd(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> dwp;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.mck != null && !DetailInfoFragment.this.mck.dvY() && ((dwp = DetailInfoFragment.this.lDT.dwp()) == null || dwp.getValue() == null || dwp.getValue().booleanValue())) {
                DetailInfoFragment.this.lDT.wd(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mcs != 0 && DetailInfoFragment.this.mck != null) {
                    DetailInfoFragment.this.mck.HP(8);
                }
                DetailInfoFragment.this.mcs = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.mck != null && DetailInfoFragment.this.mcs == 0) {
                DetailInfoFragment.this.mck.HP(0);
            }
            DetailInfoFragment.this.mcs = 2;
        }
    };
    private CustomMessageListener lII = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dol() != null && DetailInfoFragment.this.dol().getPbData() != null) {
                DetailInfoFragment.this.dol().getPbData().dno();
                DetailInfoFragment.this.dol().dqG();
                DetailInfoFragment.this.mcv.setData(DetailInfoFragment.this.dol().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jqi = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dol() != null && DetailInfoFragment.this.dol().getPbData() != null) {
                DetailInfoFragment.this.Qc((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dol().dqG();
                DetailInfoFragment.this.mcv.setData(DetailInfoFragment.this.dol().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.mck = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lHp = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jqi);
        this.lII.setSelfListener(true);
        if (dpR() != null) {
            this.lII.setTag(dpR().getUniqueId());
        } else if (getPageContext() != null) {
            this.lII.setTag(getPageContext().getUniqueId());
        }
        this.lII.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lII);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lDT = (e) y.b(getFragmentActivity()).l(e.class);
        cH(inflate);
        return inflate;
    }

    private void cH(View view) {
        this.iYW = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.iYW.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iYW.addOnScrollListener(this.mOnScrollListener);
        this.iYW.setOnTouchListener(dpQ().bGL());
        this.grg = new PbListView(getContext());
        this.grg.getView();
        this.grg.setText("");
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setLineGone();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.grg.bvh();
        this.iYW.setNextPage(this.grg);
        this.mcv = new com.baidu.tieba.pb.videopb.a.a(this, this.iYW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lDT != null) {
            dwN();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jqi);
        MessageManager.getInstance().unRegisterListener(this.lII);
        super.onDestroy();
    }

    private void dwN() {
        f dwi = this.lDT.dwi();
        if (dwi == null) {
            dwi = this.lDT.dwh();
        }
        Q(dwi);
    }

    private void Q(f fVar) {
        if (this.lDT != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mcv.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.dmU() != null) {
                str = fVar.getThreadId();
                if (fVar.dmU().getBaijiahaoData() != null) {
                    str2 = fVar.dmU().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.mcw || str2 != this.mcx) {
                dwO();
            }
            this.mcw = str;
            this.mcx = str2;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.dnx())) {
                dwP();
                return;
            }
            dwR();
            this.grg.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dwO() {
        if (this.iYW != null) {
            this.iYW.scrollToPosition(0);
        }
        dwR();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity dpR() {
        return this.lHp != null ? this.lHp : this.mck.dpR();
    }

    public VideoPbFragment dpQ() {
        if (this.mck == null && this.lHp != null) {
            Fragment dox = this.lHp.dox();
            if (dox instanceof VideoPbFragment) {
                this.mck = (VideoPbFragment) dox;
            }
        }
        return this.mck;
    }

    public PbModel dol() {
        return dpQ().dol();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mcv != null) {
            this.mcv.notifyDataSetChanged();
        }
        if (this.grg != null) {
            this.grg.changeSkin(i);
        }
    }

    private void dwP() {
        if (this.grg != null) {
            this.grg.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dwQ() {
        if (this.mcv != null) {
            this.mcv.dwx();
        }
    }

    private void dwR() {
        if (this.grg != null) {
            this.grg.bvi();
        }
    }

    public int dwK() {
        return this.mcs;
    }

    public void wh(boolean z) {
        if (this.iYW != null) {
            this.iYW.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qc(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> dnC = dol().getPbData().dnC();
            for (n nVar : dnC) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    dnC.remove(nVar);
                    return;
                }
            }
        }
    }
}
