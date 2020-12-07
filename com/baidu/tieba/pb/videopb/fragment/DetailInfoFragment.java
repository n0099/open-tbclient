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
    private PbListView gre;
    private BdTypeRecyclerView iYU;
    private e lDR;
    private PbActivity lHn;
    private VideoPbFragment mci;
    private com.baidu.tieba.pb.videopb.a.a mct;
    private String mcu;
    private String mcv;
    private int mcq = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.mci != null) {
                DetailInfoFragment.this.mci.dsb();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.mci != null && !DetailInfoFragment.this.mci.dvX()) {
                DetailInfoFragment.this.lDR.wd(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> dwo;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.mci != null && !DetailInfoFragment.this.mci.dvX() && ((dwo = DetailInfoFragment.this.lDR.dwo()) == null || dwo.getValue() == null || dwo.getValue().booleanValue())) {
                DetailInfoFragment.this.lDR.wd(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mcq != 0 && DetailInfoFragment.this.mci != null) {
                    DetailInfoFragment.this.mci.HP(8);
                }
                DetailInfoFragment.this.mcq = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.mci != null && DetailInfoFragment.this.mcq == 0) {
                DetailInfoFragment.this.mci.HP(0);
            }
            DetailInfoFragment.this.mcq = 2;
        }
    };
    private CustomMessageListener lIG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dok() != null && DetailInfoFragment.this.dok().getPbData() != null) {
                DetailInfoFragment.this.dok().getPbData().dnn();
                DetailInfoFragment.this.dok().dqF();
                DetailInfoFragment.this.mct.setData(DetailInfoFragment.this.dok().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jqg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dok() != null && DetailInfoFragment.this.dok().getPbData() != null) {
                DetailInfoFragment.this.Qc((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dok().dqF();
                DetailInfoFragment.this.mct.setData(DetailInfoFragment.this.dok().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.mci = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lHn = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jqg);
        this.lIG.setSelfListener(true);
        if (dpQ() != null) {
            this.lIG.setTag(dpQ().getUniqueId());
        } else if (getPageContext() != null) {
            this.lIG.setTag(getPageContext().getUniqueId());
        }
        this.lIG.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lIG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lDR = (e) y.b(getFragmentActivity()).l(e.class);
        cH(inflate);
        return inflate;
    }

    private void cH(View view) {
        this.iYU = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.iYU.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iYU.addOnScrollListener(this.mOnScrollListener);
        this.iYU.setOnTouchListener(dpP().bGL());
        this.gre = new PbListView(getContext());
        this.gre.getView();
        this.gre.setText("");
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setLineGone();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gre.bvh();
        this.iYU.setNextPage(this.gre);
        this.mct = new com.baidu.tieba.pb.videopb.a.a(this, this.iYU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lDR != null) {
            dwM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jqg);
        MessageManager.getInstance().unRegisterListener(this.lIG);
        super.onDestroy();
    }

    private void dwM() {
        f dwh = this.lDR.dwh();
        if (dwh == null) {
            dwh = this.lDR.dwg();
        }
        Q(dwh);
    }

    private void Q(f fVar) {
        if (this.lDR != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mct.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.dmT() != null) {
                str = fVar.getThreadId();
                if (fVar.dmT().getBaijiahaoData() != null) {
                    str2 = fVar.dmT().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.mcu || str2 != this.mcv) {
                dwN();
            }
            this.mcu = str;
            this.mcv = str2;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.dnw())) {
                dwO();
                return;
            }
            dwQ();
            this.gre.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dwN() {
        if (this.iYU != null) {
            this.iYU.scrollToPosition(0);
        }
        dwQ();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity dpQ() {
        return this.lHn != null ? this.lHn : this.mci.dpQ();
    }

    public VideoPbFragment dpP() {
        if (this.mci == null && this.lHn != null) {
            Fragment dow = this.lHn.dow();
            if (dow instanceof VideoPbFragment) {
                this.mci = (VideoPbFragment) dow;
            }
        }
        return this.mci;
    }

    public PbModel dok() {
        return dpP().dok();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mct != null) {
            this.mct.notifyDataSetChanged();
        }
        if (this.gre != null) {
            this.gre.changeSkin(i);
        }
    }

    private void dwO() {
        if (this.gre != null) {
            this.gre.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dwP() {
        if (this.mct != null) {
            this.mct.dww();
        }
    }

    private void dwQ() {
        if (this.gre != null) {
            this.gre.bvi();
        }
    }

    public int dwJ() {
        return this.mcq;
    }

    public void wh(boolean z) {
        if (this.iYU != null) {
            this.iYU.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qc(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> dnB = dok().getPbData().dnB();
            for (n nVar : dnB) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    dnB.remove(nVar);
                    return;
                }
            }
        }
    }
}
