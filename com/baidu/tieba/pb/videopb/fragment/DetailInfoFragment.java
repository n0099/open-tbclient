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
    private PbListView gxy;
    private BdTypeRecyclerView jgC;
    private VideoPbViewModel lEt;
    private PbActivity lHZ;
    private VideoPbFragment mcQ;
    private com.baidu.tieba.pb.videopb.a.a mdb;
    private String mdc;
    private String mdd;
    private int mcY = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.mcQ != null) {
                DetailInfoFragment.this.mcQ.dnX();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.mcQ != null && !DetailInfoFragment.this.mcQ.drW()) {
                DetailInfoFragment.this.lEt.wa(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> dsn;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.mcQ != null && !DetailInfoFragment.this.mcQ.drW() && ((dsn = DetailInfoFragment.this.lEt.dsn()) == null || dsn.getValue() == null || dsn.getValue().booleanValue())) {
                DetailInfoFragment.this.lEt.wa(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.mcY != 0 && DetailInfoFragment.this.mcQ != null) {
                    DetailInfoFragment.this.mcQ.Gc(8);
                }
                DetailInfoFragment.this.mcY = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.mcQ != null && DetailInfoFragment.this.mcY == 0) {
                DetailInfoFragment.this.mcQ.Gc(0);
            }
            DetailInfoFragment.this.mcY = 2;
        }
    };
    private CustomMessageListener lJs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dkd() != null && DetailInfoFragment.this.dkd().getPbData() != null) {
                DetailInfoFragment.this.dkd().getPbData().djh();
                DetailInfoFragment.this.dkd().dmA();
                DetailInfoFragment.this.mdb.setData(DetailInfoFragment.this.dkd().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.dkd() != null && DetailInfoFragment.this.dkd().getPbData() != null) {
                DetailInfoFragment.this.OA((String) customResponsedMessage.getData());
                DetailInfoFragment.this.dkd().dmA();
                DetailInfoFragment.this.mdb.setData(DetailInfoFragment.this.dkd().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.mcQ = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lHZ = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jjF);
        this.lJs.setSelfListener(true);
        if (dlL() != null) {
            this.lJs.setTag(dlL().getUniqueId());
        } else if (getPageContext() != null) {
            this.lJs.setTag(getPageContext().getUniqueId());
        }
        this.lJs.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lJs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lEt = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        cR(inflate);
        return inflate;
    }

    private void cR(View view) {
        this.jgC = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.jgC.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jgC.addOnScrollListener(this.mOnScrollListener);
        this.jgC.setOnTouchListener(dlK().bFn());
        this.gxy = new PbListView(getContext());
        this.gxy.getView();
        this.gxy.setText("");
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.btJ();
        this.jgC.setNextPage(this.gxy);
        this.mdb = new com.baidu.tieba.pb.videopb.a.a(this, this.jgC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lEt != null) {
            dsL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jjF);
        MessageManager.getInstance().unRegisterListener(this.lJs);
        super.onDestroy();
    }

    private void dsL() {
        f dsg = this.lEt.dsg();
        if (dsg == null) {
            dsg = this.lEt.dsf();
        }
        Q(dsg);
    }

    private void Q(f fVar) {
        if (this.lEt != null && fVar != null) {
            R(fVar);
            S(fVar);
            this.mdb.setData(fVar);
        }
    }

    private void R(f fVar) {
        String str;
        String str2;
        if (fVar != null) {
            if (fVar.diN() != null) {
                str2 = fVar.getThreadId();
                str = fVar.diN().getBaijiahaoData() != null ? fVar.diN().getBaijiahaoData().oriUgcNid : null;
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != this.mdc || str != this.mdd) {
                dsM();
            }
            this.mdc = str2;
            this.mdd = str;
        }
    }

    private void S(f fVar) {
        if (fVar != null) {
            if (x.isEmpty(fVar.djp())) {
                dsN();
                return;
            }
            dsP();
            this.gxy.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dsM() {
        if (this.jgC != null) {
            this.jgC.scrollToPosition(0);
        }
        dsP();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            Q(fVar);
        }
    }

    public PbActivity dlL() {
        return this.lHZ != null ? this.lHZ : this.mcQ.dlL();
    }

    public VideoPbFragment dlK() {
        if (this.mcQ == null && this.lHZ != null) {
            Fragment dkp = this.lHZ.dkp();
            if (dkp instanceof VideoPbFragment) {
                this.mcQ = (VideoPbFragment) dkp;
            }
        }
        return this.mcQ;
    }

    public PbModel dkd() {
        return dlK().dkd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mdb != null) {
            this.mdb.notifyDataSetChanged();
        }
        if (this.gxy != null) {
            this.gxy.changeSkin(i);
        }
    }

    private void dsN() {
        if (this.gxy != null) {
            this.gxy.t(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dsO() {
        if (this.mdb != null) {
            this.mdb.dsv();
        }
    }

    private void dsP() {
        if (this.gxy != null) {
            this.gxy.btK();
        }
    }

    public int dsI() {
        return this.mcY;
    }

    public void we(boolean z) {
        if (this.jgC != null) {
            this.jgC.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OA(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<o> dju = dkd().getPbData().dju();
            for (o oVar : dju) {
                if (TextUtils.equals(str, oVar.getAdId())) {
                    dju.remove(oVar);
                    return;
                }
            }
        }
    }
}
