package com.baidu.tieba.personPolymeric.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.p.aj;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tbadk.k.f brt;
    public PbListView bvA;
    private NoNetworkView bvz;
    private PluginErrorTipView cSz;
    protected BdPersonListView fZo;
    private b fZp;
    private ImageView fZq;
    protected PersonExpandImageView fZr;
    protected View fZs;
    private ImageView fZt;
    protected NavigationBar fZv;
    protected RelativeLayout fZw;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float dGf = 360.0f;
    private a fZu = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fZr);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
        }
    };

    /* loaded from: classes3.dex */
    public interface b {
        void bt(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.fZo = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.cSz = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fZv = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.fZw = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.bvA = new PbListView(this.mContext.getPageActivity());
            this.bvA.getView();
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            this.bvA.dA(d.C0140d.cp_cont_e);
            this.bvA.dB(d.C0140d.cp_bg_line_d);
            this.bvA.setHeight(l.f(this.mContext.getPageActivity(), d.e.ds140));
            this.bvA.dy(l.f(this.mContext.getPageActivity(), d.e.ds12));
            this.bvA.At();
            this.bvA.dx(d.C0140d.cp_bg_line_e);
            this.fZo.setNextPage(this.bvA);
            this.fZr = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fZr.setInitHeight(this.mContext.getResources().getDimensionPixelSize(d.e.tbds496));
            this.fZs = view.findViewById(d.g.view_top_background_cover);
            this.fZs.setVisibility(8);
            this.fZo.setOuterExpandView(this.fZr);
            this.fZt = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.fZu.fZz = gVar;
            view.setOnClickListener(this.fZu);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b fZy = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g fZz;
        public UserData fsA;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c12502").af("obj_locate", "3"));
            this.fZy.cVg = 10;
            this.fZy.cVh = new Bundle();
            this.fZy.cVh.putSerializable(UserData.TYPE_USER, this.fsA);
            if (this.fZz != null) {
                this.fZz.a(view, this.fZy);
            }
        }
    }

    public void lg(boolean z) {
        this.fZw.setVisibility(8);
        this.fZv.setVisibility(0);
        this.fZv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.fZv.setCenterTextTitle(this.mContext.getString(d.j.ta_homepage));
        } else {
            this.fZv.setCenterTextTitle(this.mContext.getString(d.j.my_homepage));
        }
        this.fZv.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.ah(null, this.mContext.getString(d.j.user_to_anti)), null);
        }
        am.h(this.mNoDataView.getSuTextView(), d.C0140d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aDk() {
        if (this.mRootView != null) {
            this.fZo.setVisibility(8);
            if (this.fZq != null) {
                this.fZq.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ba.aT(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ba.aU(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(d.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(d.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ba.aU(d.this.mContext.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.mContext, i);
            }
            am.i(this.mRootView, d.C0140d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.fZv.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(d.f.s_navbar_bg)));
            if (this.fZo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.fZo.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bvz.onChangeSkinType(this.mContext, i);
            this.cSz.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.fZp = bVar;
    }

    public void Uk() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.brt == null) {
            if (i < 0) {
                this.brt = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.brt = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.brt.onChangeSkinType();
        }
        this.brt.c(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.brt != null) {
            this.brt.Q(this.mRootView);
            this.brt = null;
        }
    }

    public void lh(boolean z) {
        if (z) {
            bja();
        }
    }

    public void ry(int i) {
        this.fZo.setVisibility(i);
    }

    public void E(String str, boolean z) {
        if (!aDj()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.js()) {
                            d.this.Uk();
                            d.this.lh(true);
                            if (d.this.fZp != null) {
                                d.this.fZp.bt(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fh(this.mContext.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.hk(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.Jk();
            this.refreshView.onChangeSkinType();
            this.fZo.setVisibility(8);
            if (this.fZq != null) {
                this.fZq.setVisibility(8);
            }
        }
    }

    public boolean aDj() {
        if (this.refreshView != null) {
            return this.refreshView.Jc();
        }
        return false;
    }

    public void Ax() {
        if (this.bvA != null) {
            this.bvA.Ax();
        }
    }

    public void Ay() {
        if (this.bvA != null) {
            this.bvA.Ay();
        }
    }

    public void eI(boolean z) {
        if (this.fZo != null && this.bvA != null) {
            this.bvA.Ay();
            if (z) {
                this.bvA.setText(this.mContext.getString(d.j.list_no_more));
            } else {
                this.bvA.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.fZo != null && this.bvA != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    Un();
                    return;
                }
            }
            this.bvA.Ay();
            if (z) {
                this.bvA.setText(this.mContext.getString(d.j.list_no_more));
            } else {
                this.bvA.setText("");
            }
        }
    }

    public void Un() {
        if (this.fZo != null && this.bvA != null) {
            this.fZo.setNextPage(null);
            this.bvA.AC();
        }
    }

    public void rz(int i) {
        if (i == 0) {
            this.bvA.dB(d.C0140d.cp_bg_line_d);
            this.bvA.dx(d.C0140d.cp_bg_line_e);
            this.bvA.dA(d.C0140d.cp_cont_e);
            this.bvA.At();
        } else if (i == 1) {
            this.bvA.dB(d.C0140d.cp_bg_line_c);
            this.bvA.dA(d.C0140d.cp_cont_d);
            this.bvA.Au();
        }
        this.bvA.dC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dc(List<com.baidu.adp.widget.ListView.h> list) {
        if (w.z(list)) {
            list = new ArrayList<>();
        }
        if (this.fZo.getVisibility() != 0) {
            this.fZo.setVisibility(0);
        }
        this.fZo.setData(list);
    }

    public void bja() {
        if (aj.iq()) {
            if (this.fZq == null) {
                this.fZq = new ImageView(this.mContext.getPageActivity());
                this.fZq.setImageResource(d.f.icon_nichengjun);
                this.fZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.aYV(), true)));
                    }
                });
            }
            if (this.fZq.getParent() != null) {
                ((ViewGroup) this.fZq.getParent()).removeView(this.fZq);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.f(this.mContext.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.f(this.mContext.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fZq, layoutParams);
            }
        } else if (this.fZq != null && this.fZq.getParent() != null && this.fZq.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fZq);
        }
    }

    public void f(UserData userData) {
        this.fZs.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.IQ().fe(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fZr.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.ih().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fZu.fsA = userData;
    }

    public void M(float f) {
        if (!this.fZt.isShown()) {
            this.fZt.setVisibility(0);
            this.fZt.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dGf, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fZt.startAnimation(rotateAnimation);
        this.dGf = f;
    }

    public void aAh() {
        this.fZt.clearAnimation();
        this.fZt.setImageDrawable(null);
        this.fZt.setVisibility(8);
    }

    public void nn() {
        if (!this.fZt.isShown()) {
            this.fZt.setVisibility(0);
            this.fZt.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fZt.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
