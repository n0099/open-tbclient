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
    private PbListView giV;
    private BdTypeRecyclerView iOd;
    private VideoPbFragment lOe;
    private com.baidu.tieba.pb.videopb.a.a lOp;
    private String lOq;
    private String lOr;
    private e lqi;
    private PbActivity ltC;
    private int lOm = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.lOe != null) {
                DetailInfoFragment.this.lOe.dmK();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.lOe != null && !DetailInfoFragment.this.lOe.dqE()) {
                DetailInfoFragment.this.lqi.vA(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> dqV;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.lOe != null && !DetailInfoFragment.this.lOe.dqE() && ((dqV = DetailInfoFragment.this.lqi.dqV()) == null || dqV.getValue() == null || dqV.getValue().booleanValue())) {
                DetailInfoFragment.this.lqi.vA(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.lOm != 0 && DetailInfoFragment.this.lOe != null) {
                    DetailInfoFragment.this.lOe.GY(8);
                }
                DetailInfoFragment.this.lOm = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.lOe != null && DetailInfoFragment.this.lOm == 0) {
                DetailInfoFragment.this.lOe.GY(0);
            }
            DetailInfoFragment.this.lOm = 2;
        }
    };
    private CustomMessageListener luT = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.diV() != null && DetailInfoFragment.this.diV().getPbData() != null) {
                DetailInfoFragment.this.diV().getPbData().dib();
                DetailInfoFragment.this.diV().dlp();
                DetailInfoFragment.this.lOp.setData(DetailInfoFragment.this.diV().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jcD = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.diV() != null && DetailInfoFragment.this.diV().getPbData() != null) {
                DetailInfoFragment.this.OU((String) customResponsedMessage.getData());
                DetailInfoFragment.this.diV().dlp();
                DetailInfoFragment.this.lOp.setData(DetailInfoFragment.this.diV().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.lOe = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.ltC = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.jcD);
        this.luT.setSelfListener(true);
        if (dkB() != null) {
            this.luT.setTag(dkB().getUniqueId());
        } else if (getPageContext() != null) {
            this.luT.setTag(getPageContext().getUniqueId());
        }
        this.luT.setPriority(-1);
        MessageManager.getInstance().registerListener(this.luT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.lqi = (e) y.b(getFragmentActivity()).l(e.class);
        cA(inflate);
        return inflate;
    }

    private void cA(View view) {
        this.iOd = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.iOd.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iOd.addOnScrollListener(this.mOnScrollListener);
        this.iOd.setOnTouchListener(dkA().bDk());
        this.giV = new PbListView(getContext());
        this.giV.getView();
        this.giV.setText("");
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setLineGone();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.giV.brI();
        this.iOd.setNextPage(this.giV);
        this.lOp = new com.baidu.tieba.pb.videopb.a.a(this, this.iOd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.lqi != null) {
            drt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jcD);
        MessageManager.getInstance().unRegisterListener(this.luT);
        super.onDestroy();
    }

    private void drt() {
        f dqO = this.lqi.dqO();
        if (dqO == null) {
            dqO = this.lqi.dqN();
        }
        P(dqO);
    }

    private void P(f fVar) {
        if (this.lqi != null && fVar != null) {
            Q(fVar);
            R(fVar);
            this.lOp.setData(fVar);
        }
    }

    private void Q(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.dhH() != null) {
                str = fVar.getThreadId();
                if (fVar.dhH().getBaijiahaoData() != null) {
                    str2 = fVar.dhH().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.lOq || str2 != this.lOr) {
                dru();
            }
            this.lOq = str;
            this.lOr = str2;
        }
    }

    private void R(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.dij())) {
                drv();
                return;
            }
            drx();
            this.giV.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dru() {
        if (this.iOd != null) {
            this.iOd.scrollToPosition(0);
        }
        drx();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            P(fVar);
        }
    }

    public PbActivity dkB() {
        return this.ltC != null ? this.ltC : this.lOe.dkB();
    }

    public VideoPbFragment dkA() {
        if (this.lOe == null && this.ltC != null) {
            Fragment djh = this.ltC.djh();
            if (djh instanceof VideoPbFragment) {
                this.lOe = (VideoPbFragment) djh;
            }
        }
        return this.lOe;
    }

    public PbModel diV() {
        return dkA().diV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lOp != null) {
            this.lOp.notifyDataSetChanged();
        }
        if (this.giV != null) {
            this.giV.changeSkin(i);
        }
    }

    private void drv() {
        if (this.giV != null) {
            this.giV.s(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void drw() {
        if (this.lOp != null) {
            this.lOp.drd();
        }
    }

    private void drx() {
        if (this.giV != null) {
            this.giV.brJ();
        }
    }

    public int drq() {
        return this.lOm;
    }

    public void vD(boolean z) {
        if (this.iOd != null) {
            this.iOd.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OU(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> dio = diV().getPbData().dio();
            for (n nVar : dio) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    dio.remove(nVar);
                    return;
                }
            }
        }
    }
}
