package com.baidu.tieba.pb.pb.main.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.a.c.e.p.k;
import d.a.i0.f0.h;
import d.a.i0.r.q.a2;
import d.a.j0.d2.h.e;
/* loaded from: classes3.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f20031e;

    /* renamed from: f  reason: collision with root package name */
    public Context f20032f;

    /* renamed from: g  reason: collision with root package name */
    public d f20033g;

    /* renamed from: h  reason: collision with root package name */
    public d f20034h;

    /* renamed from: i  reason: collision with root package name */
    public d f20035i;
    public d j;
    public e k;
    public AgreeData l;
    public d.a.j0.d3.h0.e m;
    public d.a.i0.r.q.e n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.h0.e)) {
                return;
            }
            AgreeData agreeData = ((d.a.j0.d3.h0.e) customResponsedMessage.getData()).f53077b;
            if (ThreadAgreeAndShareLayout.this.l == null || agreeData == null || ThreadAgreeAndShareLayout.this.m == null || ThreadAgreeAndShareLayout.this.l.isInPost || ThreadAgreeAndShareLayout.this.m.f53076a == ThreadAgreeAndShareLayout.this.m.f53076a) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (ThreadAgreeAndShareLayout.this.k == null || ThreadAgreeAndShareLayout.this.k.L() == null || ThreadAgreeAndShareLayout.this.k.L().V() == null || !TextUtils.equals(str, ThreadAgreeAndShareLayout.this.k.L().V().oriUgcNid)) {
                    return;
                }
                ThreadAgreeAndShareLayout.this.o(agreeData);
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = ThreadAgreeAndShareLayout.this.l.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            ThreadAgreeAndShareLayout.this.o(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.h0.e)) {
                return;
            }
            d.a.j0.d3.h0.e eVar = (d.a.j0.d3.h0.e) customResponsedMessage.getData();
            AgreeData agreeData = eVar.f53077b;
            if (ThreadAgreeAndShareLayout.this.l == null || TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.l.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !ThreadAgreeAndShareLayout.this.l.postId.equals(agreeData.postId) || ThreadAgreeAndShareLayout.this.l.isInThread || ThreadAgreeAndShareLayout.this.m.f53076a == eVar.f53076a) {
                return;
            }
            ThreadAgreeAndShareLayout.this.o(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAgreeAndShareLayout.this.k(view);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public View f20039a;

        /* renamed from: b  reason: collision with root package name */
        public View f20040b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20041c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f20042d;

        public d(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.f20039a = inflate;
            this.f20040b = inflate.findViewById(R.id.item_bg);
            this.f20041c = (TextView) inflate.findViewById(R.id.item_text);
            this.f20042d = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public void c(Animator.AnimatorListener animatorListener) {
            this.f20042d.addAnimatorListener(animatorListener);
        }

        public void d() {
            TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).defaultStrokeColor(R.color.cp_cont_f_alpha50).defaultColor(R.color.CAM_X0201).into(this.f20040b);
        }

        public TBLottieAnimationView e() {
            return this.f20042d;
        }

        public TextView f() {
            return this.f20041c;
        }

        public View g() {
            return this.f20039a;
        }

        public void h() {
            this.f20042d.playAnimation();
        }

        public void i(int i2) {
            SkinManager.setImageResource(this.f20042d, i2);
        }

        public void j(ImageView.ScaleType scaleType) {
            this.f20042d.setScaleType(scaleType);
        }

        public void k(int i2) {
            this.f20041c.setText(i2);
        }

        public void l(int i2) {
            SkinManager.setViewTextColor(this.f20041c, i2, 1);
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public final d f(int i2) {
        d dVar = new d(this.f20032f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i2;
        addView(dVar.g(), layoutParams);
        return dVar;
    }

    public final void g(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        h.i(agreeEvent);
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public TbPageContext getTbPageContext() {
        if (this.f20031e == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.f20031e = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.f20031e = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.f20031e;
    }

    public void h() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        if (this.n == null) {
            return;
        }
        int i3 = 0;
        e eVar = this.k;
        String str6 = null;
        if (eVar == null || eVar.L() == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            i2 = 1;
        } else {
            a2 L = this.k.L();
            if (L.O1()) {
                i2 = 2;
            } else if (L.R1()) {
                i2 = 3;
            } else if (L.P1()) {
                i2 = 4;
            } else {
                i2 = L.Q1() ? 5 : 1;
            }
            String L0 = L.L0();
            if (L.V() != null && !k.isEmpty(L.V().oriUgcVid)) {
                str6 = L.V().oriUgcVid;
            }
            int U0 = L.U0();
            str3 = L.R0;
            str4 = L.T0;
            str5 = L.S0;
            str = L.U0;
            i3 = U0;
            str2 = str6;
            str6 = L0;
        }
        int i4 = this.n.f49130a;
        String str7 = str2;
        String str8 = str;
        String str9 = str5;
        if (i4 != 1) {
            if (i4 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.n.f49136g).param("obj_locate", this.n.f49137h).param("obj_id", this.n.f49138i).param("obj_name", i2).param("nid", str6).param("card_type", i3).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
                if (getTbPageContext() != null) {
                    d.a.i0.j0.c.e(getTbPageContext().getPageActivity(), param);
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.n.f49131b).param("obj_param1", this.n.f49132c).param("obj_source", this.n.f49133d).param("obj_id", this.n.f49134e).param("obj_name", i2).param("nid", str6).param("card_type", i3).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
        if (getTbPageContext() != null) {
            d.a.i0.j0.c.e(getTbPageContext().getPageActivity(), param2);
        }
        d.a.i0.i0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(param2);
    }

    public final void i() {
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        this.f20033g = f(0);
        this.f20034h = f(dimenPixelSize);
        this.f20035i = f(dimenPixelSize);
        this.j = f(dimenPixelSize);
        this.f20035i.j(ImageView.ScaleType.FIT_XY);
        this.j.j(ImageView.ScaleType.FIT_XY);
        this.f20035i.k(R.string.share_weixin_friend);
        this.j.k(R.string.share_weixin_timeline);
        this.f20033g.j(ImageView.ScaleType.CENTER_INSIDE);
        this.f20033g.c(this);
        this.f20034h.j(ImageView.ScaleType.CENTER_INSIDE);
        this.f20034h.c(this);
        this.f20033g.e().setOnClickListener(this.q);
        this.f20034h.e().setOnClickListener(this.q);
        this.f20035i.e().setOnClickListener(this.q);
        this.j.e().setOnClickListener(this.q);
        j();
    }

    public void j() {
        this.f20035i.l(R.color.CAM_X0107);
        this.j.l(R.color.CAM_X0107);
        this.f20035i.i(R.drawable.icon_weixin_112);
        this.j.i(R.drawable.icon_pengyouqun_112);
        this.f20033g.d();
        this.f20034h.d();
        this.f20035i.d();
        this.j.d();
        m();
    }

    public final void k(View view) {
        e eVar;
        if (this.l != null && ViewHelper.checkUpIsLogin(getContext())) {
            if (view != this.f20033g.e() && view != this.f20034h.e()) {
                if (view == this.f20035i.e()) {
                    e eVar2 = this.k;
                    if (eVar2 != null) {
                        d.a.j0.d2.k.e.d1.b.l(this.f20032f, eVar2.L(), 3);
                        return;
                    }
                    return;
                } else if (view != this.j.e() || (eVar = this.k) == null) {
                    return;
                } else {
                    d.a.j0.d2.k.e.d1.b.l(this.f20032f, eVar.L(), 2);
                    return;
                }
            }
            int i2 = 0;
            if (view == this.f20033g.e()) {
                this.f20033g.h();
                d.a.i0.r.q.e eVar3 = this.n;
                if (eVar3 != null) {
                    eVar3.f49130a = 1;
                    eVar3.f49131b = 4;
                }
                AgreeData agreeData = this.l;
                if (agreeData.hasAgree) {
                    if (agreeData.agreeType == 2) {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = false;
                        agreeData.diffAgreeNum--;
                        agreeData.agreeNum--;
                        m();
                        d.a.i0.r.q.e eVar4 = this.n;
                        if (eVar4 != null) {
                            eVar4.f49134e = 1;
                        }
                        i2 = 1;
                    } else {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = true;
                        agreeData.diffAgreeNum += 2;
                        agreeData.agreeNum++;
                        agreeData.disAgreeNum--;
                        n(true);
                        d.a.i0.r.q.e eVar5 = this.n;
                        if (eVar5 != null) {
                            eVar5.f49134e = 0;
                        }
                    }
                } else {
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = true;
                    agreeData.diffAgreeNum++;
                    agreeData.agreeNum++;
                    n(true);
                }
                l(i2);
            } else if (view == this.f20034h.e()) {
                this.f20034h.h();
                d.a.i0.r.q.e eVar6 = this.n;
                if (eVar6 != null) {
                    eVar6.f49130a = 2;
                    eVar6.f49131b = 4;
                }
                AgreeData agreeData2 = this.l;
                if (agreeData2.hasAgree) {
                    if (agreeData2.agreeType == 5) {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = false;
                        agreeData2.diffAgreeNum++;
                        agreeData2.disAgreeNum--;
                        m();
                        d.a.i0.r.q.e eVar7 = this.n;
                        if (eVar7 != null) {
                            eVar7.f49138i = 0;
                        }
                        i2 = 1;
                    } else {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = true;
                        agreeData2.diffAgreeNum -= 2;
                        agreeData2.agreeNum--;
                        agreeData2.disAgreeNum++;
                        n(false);
                        d.a.i0.r.q.e eVar8 = this.n;
                        if (eVar8 != null) {
                            eVar8.f49138i = 1;
                        }
                    }
                } else {
                    agreeData2.agreeType = 5;
                    agreeData2.hasAgree = true;
                    agreeData2.diffAgreeNum--;
                    agreeData2.disAgreeNum++;
                    n(false);
                    d.a.i0.r.q.e eVar9 = this.n;
                    if (eVar9 != null) {
                        eVar9.f49138i = 1;
                    }
                }
                l(i2);
            }
            d.a.j0.d3.h0.e eVar10 = this.m;
            AgreeData agreeData3 = this.l;
            eVar10.f53077b = agreeData3;
            if (agreeData3.isInThread) {
                e eVar11 = this.k;
                if (eVar11 != null && eVar11.L() != null && this.k.L().V() != null) {
                    this.l.nid = this.k.L().V().oriUgcNid;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.m));
                g(this.l, AgreeEvent.IS_THREAD);
            } else if (agreeData3.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.m));
                g(this.l, AgreeEvent.IS_POST);
            }
            setStatisticData(this.n);
            h();
        }
    }

    public void l(int i2) {
        if (this.l == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", this.l.threadId);
        httpMessage.addParam("op_type", i2);
        AgreeData agreeData = this.l;
        if (agreeData.objType == 0) {
            agreeData.objType = 3;
        }
        httpMessage.addParam("obj_type", this.l.objType);
        httpMessage.addParam("agree_type", this.l.agreeType);
        httpMessage.addParam("forum_id", this.l.forumId);
        d.a.i0.i0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            httpMessage.addParam("obj_source", f2.a());
        }
        if (!TextUtils.isEmpty(this.l.postId)) {
            httpMessage.addParam("post_id", this.l.postId);
        }
        e eVar = this.k;
        if (eVar != null && eVar.L() != null && this.k.L().V() != null) {
            BaijiahaoData V = this.k.L().V();
            httpMessage.addParam("ori_ugc_tid", V.oriUgcTid);
            httpMessage.addParam("ori_ugc_nid", V.oriUgcNid);
            httpMessage.addParam("ori_ugc_vid", V.oriUgcVid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, V.oriUgcType);
        }
        httpMessage.setTag(getPageId());
        httpMessage.setExtra(Integer.valueOf(i2));
        httpMessage.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void m() {
        if (this.l == null) {
            return;
        }
        TBLottieAnimationView e2 = this.f20033g.e();
        SkinManager.setLottieAnimation(e2, R.raw.lottie_agree);
        TBLottieAnimationView e3 = this.f20034h.e();
        SkinManager.setLottieAnimation(e3, R.raw.lottie_disagree);
        TextView f2 = this.f20033g.f();
        TextView f3 = this.f20034h.f();
        f2.setText(StringHelper.numFormatOverWanNa(this.l.agreeNum));
        f3.setText(StringHelper.numFormatOverWanNa(this.l.disAgreeNum));
        AgreeData agreeData = this.l;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                e3.setProgress(0.0f);
                e2.setProgress(1.0f);
                f2.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                f3.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else {
                e2.setProgress(0.0f);
                e3.setProgress(1.0f);
                f2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                f3.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        } else {
            e2.setMinAndMaxProgress(0.0f, 0.0f);
            e3.setMinAndMaxProgress(0.0f, 0.0f);
            e2.setProgress(0.0f);
            e3.setProgress(0.0f);
            f2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            f3.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1) {
            e2.setAlpha(0.5f);
            e3.setAlpha(0.5f);
        } else if (skinType == 4) {
            e2.setAlpha(0.66f);
            e3.setAlpha(0.66f);
        } else {
            e2.setAlpha(1.0f);
            e3.setAlpha(1.0f);
        }
        e eVar = this.k;
        if (eVar == null || eVar.L() == null) {
            return;
        }
        setVisibility(this.k.L().y2() ? 8 : 0);
    }

    public void n(boolean z) {
        if (this.l == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.f20033g.f20042d;
        TBLottieAnimationView tBLottieAnimationView2 = this.f20034h.f20042d;
        TextView textView = this.f20033g.f20041c;
        TextView textView2 = this.f20034h.f20041c;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(StringHelper.numFormatOverWanNa(this.l.agreeNum));
        textView2.setText(StringHelper.numFormatOverWanNa(this.l.disAgreeNum));
        tBLottieAnimationView.clearColorFilter();
        tBLottieAnimationView2.clearColorFilter();
        if (z) {
            tBLottieAnimationView.playAnimation();
            tBLottieAnimationView2.cancelAnimation();
            tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            tBLottieAnimationView2.playAnimation();
            tBLottieAnimationView.cancelAnimation();
            tBLottieAnimationView.setMinAndMaxProgress(0.0f, 0.0f);
        }
        tBLottieAnimationView.setFrame(0);
        tBLottieAnimationView2.setFrame(0);
        AgreeData agreeData = this.l;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                return;
            }
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
            return;
        }
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public final void o(AgreeData agreeData) {
        AgreeData agreeData2;
        if (agreeData == null || (agreeData2 = this.l) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
        agreeData2.agreeNum = agreeData.agreeNum;
        agreeData2.disAgreeNum = agreeData.disAgreeNum;
        m();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.o);
        MessageManager.getInstance().registerListener(this.p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.p);
    }

    public void setData(e eVar, AgreeData agreeData) {
        if (agreeData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.k = eVar;
        this.l = agreeData;
        agreeData.isInThread = true;
        m();
    }

    public void setStatisticData(d.a.i0.r.q.e eVar) {
        this.n = eVar;
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new a(2016528);
        this.p = new b(2016530);
        this.q = new c();
        setOrientation(0);
        setGravity(17);
        this.f20032f = context;
        d.a.j0.d3.h0.e eVar = new d.a.j0.d3.h0.e();
        this.m = eVar;
        eVar.f53076a = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        i();
        this.n = new d.a.i0.r.q.e();
    }
}
