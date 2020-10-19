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
    private PbListView fTv;
    private BdTypeRecyclerView iuX;
    private e kXt;
    private PbActivity laM;
    private com.baidu.tieba.pb.videopb.a.a lvF;
    private String lvG;
    private String lvH;
    private VideoPbFragment lvu;
    private int lvC = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.lvu != null) {
                DetailInfoFragment.this.lvu.dhD();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.lvu != null && !DetailInfoFragment.this.lvu.dlu()) {
                DetailInfoFragment.this.kXt.uX(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> dlL;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.lvu != null && !DetailInfoFragment.this.lvu.dlu() && ((dlL = DetailInfoFragment.this.kXt.dlL()) == null || dlL.getValue() == null || dlL.getValue().booleanValue())) {
                DetailInfoFragment.this.kXt.uX(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.lvC != 0 && DetailInfoFragment.this.lvu != null) {
                    DetailInfoFragment.this.lvu.FU(8);
                }
                DetailInfoFragment.this.lvC = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.lvu != null && DetailInfoFragment.this.lvC == 0) {
                DetailInfoFragment.this.lvu.FU(0);
            }
            DetailInfoFragment.this.lvC = 2;
        }
    };
    private CustomMessageListener lcd = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.ddQ() != null && DetailInfoFragment.this.ddQ().getPbData() != null) {
                DetailInfoFragment.this.ddQ().getPbData().dcU();
                DetailInfoFragment.this.ddQ().dgj();
                DetailInfoFragment.this.lvF.setData(DetailInfoFragment.this.ddQ().getPbData());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener iJx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.ddQ() != null && DetailInfoFragment.this.ddQ().getPbData() != null) {
                DetailInfoFragment.this.OJ((String) customResponsedMessage.getData());
                DetailInfoFragment.this.ddQ().dgj();
                DetailInfoFragment.this.lvF.setData(DetailInfoFragment.this.ddQ().getPbData());
            }
        }
    };

    public static DetailInfoFragment ad(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.lvu = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.laM = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.iJx);
        this.lcd.setSelfListener(true);
        if (dfv() != null) {
            this.lcd.setTag(dfv().getUniqueId());
        } else if (getPageContext() != null) {
            this.lcd.setTag(getPageContext().getUniqueId());
        }
        this.lcd.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lcd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.kXt = (e) y.b(getFragmentActivity()).l(e.class);
        cn(inflate);
        return inflate;
    }

    private void cn(View view) {
        this.iuX = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.iuX.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iuX.addOnScrollListener(this.mOnScrollListener);
        this.iuX.setOnTouchListener(dfu().bzB());
        this.fTv = new PbListView(getContext());
        this.fTv.getView();
        this.fTv.setText("");
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setLineGone();
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fTv.boa();
        this.iuX.setNextPage(this.fTv);
        this.lvF = new com.baidu.tieba.pb.videopb.a.a(this, this.iuX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.kXt != null) {
            dmj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iJx);
        MessageManager.getInstance().unRegisterListener(this.lcd);
        super.onDestroy();
    }

    private void dmj() {
        f dlE = this.kXt.dlE();
        if (dlE == null) {
            dlE = this.kXt.dlD();
        }
        O(dlE);
    }

    private void O(f fVar) {
        if (this.kXt != null && fVar != null) {
            P(fVar);
            Q(fVar);
            this.lvF.setData(fVar);
        }
    }

    private void P(f fVar) {
        String str;
        String str2 = null;
        if (fVar != null) {
            if (fVar.dcA() != null) {
                str = fVar.getThreadId();
                if (fVar.dcA().getBaijiahaoData() != null) {
                    str2 = fVar.dcA().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.lvG || str2 != this.lvH) {
                dmk();
            }
            this.lvG = str;
            this.lvH = str2;
        }
    }

    private void Q(f fVar) {
        if (fVar != null) {
            if (com.baidu.tbadk.core.util.y.isEmpty(fVar.ddc())) {
                dml();
                return;
            }
            dmn();
            this.fTv.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void dmk() {
        if (this.iuX != null) {
            this.iuX.scrollToPosition(0);
        }
        dmn();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (fVar != null && getActivity() != null) {
            O(fVar);
        }
    }

    public PbActivity dfv() {
        return this.laM != null ? this.laM : this.lvu.dfv();
    }

    public VideoPbFragment dfu() {
        if (this.lvu == null && this.laM != null) {
            Fragment dec = this.laM.dec();
            if (dec instanceof VideoPbFragment) {
                this.lvu = (VideoPbFragment) dec;
            }
        }
        return this.lvu;
    }

    public PbModel ddQ() {
        return dfu().ddQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lvF != null) {
            this.lvF.notifyDataSetChanged();
        }
        if (this.fTv != null) {
            this.fTv.changeSkin(i);
        }
    }

    private void dml() {
        if (this.fTv != null) {
            this.fTv.r(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void dmm() {
        if (this.lvF != null) {
            this.lvF.dlT();
        }
    }

    private void dmn() {
        if (this.fTv != null) {
            this.fTv.bob();
        }
    }

    public int dmg() {
        return this.lvC;
    }

    public void va(boolean z) {
        if (this.iuX != null) {
            this.iuX.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> ddh = ddQ().getPbData().ddh();
            for (n nVar : ddh) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    ddh.remove(nVar);
                    return;
                }
            }
        }
    }
}
