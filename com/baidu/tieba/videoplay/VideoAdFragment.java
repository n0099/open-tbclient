package com.baidu.tieba.videoplay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemModel;
import d.a.m0.b1.p.a;
import d.a.n0.s0.a;
/* loaded from: classes5.dex */
public class VideoAdFragment extends BaseFragment implements a.b, d.a.n0.t3.c.a.a {

    /* renamed from: e  reason: collision with root package name */
    public View f21516e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f21517f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f21518g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f21519h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21520i;
    public ImageView j;
    public ImageView k;
    public VideoItemModel l;
    public String m;
    public String n;
    public d.a.n0.t3.a.a o;
    public BdUniqueId q;
    public boolean p = false;
    public int r = 3;
    public int s = -1;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoAdFragment.this.getActivity() != null) {
                VideoAdFragment.this.getActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoAdFragment.this.l != null) {
                CustomMessage customMessage = new CustomMessage(2921565);
                customMessage.setTag(VideoAdFragment.this.q);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921565, Integer.valueOf(VideoAdFragment.this.l.getHashCode()));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", VideoAdFragment.this.m).param("obj_locate", 0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.g {
        public c() {
        }

        @Override // d.a.n0.s0.a.g
        public void onAdClicked(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", VideoAdFragment.this.m).param("obj_locate", 0).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
        }

        @Override // d.a.n0.s0.a.g
        public void onAdClose(String str) {
        }

        @Override // d.a.n0.s0.a.g
        public void onAdError(String str) {
            VideoAdFragment.this.p = true;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", VideoAdFragment.this.m).param("obj_locate", 1).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
        }

        @Override // d.a.n0.s0.a.g
        public void onAdShow(String str) {
            VideoAdFragment.this.p = false;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", VideoAdFragment.this.m).param("obj_locate", 0).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
        }

        @Override // d.a.n0.s0.a.g
        public void onRewardedVideo(String str) {
        }
    }

    public void K0(BdUniqueId bdUniqueId) {
        this.q = bdUniqueId;
    }

    public void L0(String str) {
        this.m = str;
    }

    @Override // d.a.m0.b1.p.a.b
    public void O(float f2, float f3) {
    }

    @Override // d.a.n0.t3.c.a.a
    public void Q(int i2) {
        this.s = i2;
    }

    @Override // d.a.n0.t3.c.a.a
    public VideoItemModel a0() {
        return this.l;
    }

    @Override // d.a.m0.b1.p.a.b
    public void k() {
    }

    @Override // d.a.m0.b1.p.a.b
    public void m() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (this.r == i2) {
            return;
        }
        this.r = i2;
        WebPManager.setMaskDrawable(this.f21520i, R.drawable.icon_mask_header40, null);
        d.a.m0.r.u.c.d(this.f21516e).f(R.color.CAM_X0611);
        WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.n = arguments.getString("from");
            this.l = (VideoItemModel) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        }
        View inflate = layoutInflater.inflate(R.layout.video_ad_view, (ViewGroup) null);
        this.f21516e = inflate;
        this.f21517f = (FrameLayout) inflate.findViewById(R.id.fun_ad_container);
        this.f21518g = (FrameLayout) this.f21516e.findViewById(R.id.error_tip_container);
        this.f21520i = (ImageView) this.f21516e.findViewById(R.id.ad_error_image);
        this.f21519h = (LinearLayout) this.f21516e.findViewById(R.id.ad_top_container);
        this.j = (ImageView) this.f21516e.findViewById(R.id.back_btn);
        this.k = (ImageView) this.f21516e.findViewById(R.id.feed_back);
        if (DeviceInfoUtil.isHWnova() || (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity()))) {
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.f21519h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f21519h.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.n)) {
            this.j.setVisibility(8);
        }
        this.j.setOnClickListener(new a());
        this.k.setOnClickListener(new b());
        this.o = new d.a.n0.t3.a.a(getActivity(), this.f21518g);
        if (!d.a.n0.s0.a.h().k("6061002182-391683336")) {
            this.f21517f.setVisibility(8);
            this.f21520i.setVisibility(0);
            this.p = true;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.m).param("obj_locate", 2).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
            return this.f21516e;
        }
        this.f21520i.setVisibility(8);
        this.f21517f.setVisibility(0);
        d.a.n0.s0.a.h().o(getActivity(), "6061002182-391683336", this.f21517f, new c(), d.a.n0.s0.a.a("video_middle", VideoMiddleAdSwitch.isOn() ? "1" : "0"));
        return this.f21516e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        d.a.n0.t3.a.a aVar = this.o;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.p && this.o != null && isPrimary()) {
            d.a.n0.t3.a.a aVar = this.o;
            aVar.k(getString(R.string.ad_show_error));
            aVar.l();
        }
    }

    @Override // d.a.n0.t3.c.a.a
    public int q() {
        return this.s;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        d.a.n0.t3.a.a aVar;
        super.setUserVisibleHint(z);
        if (z || (aVar = this.o) == null) {
            return;
        }
        aVar.j();
    }
}
