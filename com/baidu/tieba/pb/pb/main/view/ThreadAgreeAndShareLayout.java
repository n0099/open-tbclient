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
import d.b.b.e.p.k;
import d.b.h0.f0.g;
import d.b.h0.r.q.a2;
import d.b.i0.c2.h.e;
/* loaded from: classes4.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f19858e;

    /* renamed from: f  reason: collision with root package name */
    public Context f19859f;

    /* renamed from: g  reason: collision with root package name */
    public d f19860g;

    /* renamed from: h  reason: collision with root package name */
    public d f19861h;
    public d i;
    public d j;
    public e k;
    public AgreeData l;
    public d.b.i0.c3.h0.e m;
    public d.b.h0.r.q.e n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.h0.e)) {
                return;
            }
            AgreeData agreeData = ((d.b.i0.c3.h0.e) customResponsedMessage.getData()).f53376b;
            if (ThreadAgreeAndShareLayout.this.l == null || agreeData == null || ThreadAgreeAndShareLayout.this.m == null || ThreadAgreeAndShareLayout.this.l.isInPost || ThreadAgreeAndShareLayout.this.m.f53375a == ThreadAgreeAndShareLayout.this.m.f53375a) {
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

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.h0.e)) {
                return;
            }
            d.b.i0.c3.h0.e eVar = (d.b.i0.c3.h0.e) customResponsedMessage.getData();
            AgreeData agreeData = eVar.f53376b;
            if (ThreadAgreeAndShareLayout.this.l == null || TextUtils.isEmpty(ThreadAgreeAndShareLayout.this.l.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !ThreadAgreeAndShareLayout.this.l.postId.equals(agreeData.postId) || ThreadAgreeAndShareLayout.this.l.isInThread || ThreadAgreeAndShareLayout.this.m.f53375a == eVar.f53375a) {
                return;
            }
            ThreadAgreeAndShareLayout.this.o(agreeData);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAgreeAndShareLayout.this.k(view);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public View f19865a;

        /* renamed from: b  reason: collision with root package name */
        public View f19866b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19867c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f19868d;

        public d(Context context) {
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.f19865a = inflate;
            this.f19866b = inflate.findViewById(R.id.item_bg);
            this.f19867c = (TextView) inflate.findViewById(R.id.item_text);
            this.f19868d = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public void c(Animator.AnimatorListener animatorListener) {
            this.f19868d.addAnimatorListener(animatorListener);
        }

        public void d() {
            TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).defaultStrokeColor(R.color.cp_cont_f_alpha50).defaultColor(R.color.CAM_X0201).into(this.f19866b);
        }

        public TBLottieAnimationView e() {
            return this.f19868d;
        }

        public TextView f() {
            return this.f19867c;
        }

        public View g() {
            return this.f19865a;
        }

        public void h() {
            this.f19868d.playAnimation();
        }

        public void i(int i) {
            SkinManager.setImageResource(this.f19868d, i);
        }

        public void j(ImageView.ScaleType scaleType) {
            this.f19868d.setScaleType(scaleType);
        }

        public void k(int i) {
            this.f19867c.setText(i);
        }

        public void l(int i) {
            SkinManager.setViewTextColor(this.f19867c, i, 1);
        }
    }

    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
    }

    public final d f(int i) {
        d dVar = new d(this.f19859f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = i;
        addView(dVar.g(), layoutParams);
        return dVar;
    }

    public final void g(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.g(agreeEvent);
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public TbPageContext getTbPageContext() {
        if (this.f19858e == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.f19858e = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.f19858e = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.f19858e;
    }

    public void h() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        if (this.n == null) {
            return;
        }
        int i2 = 0;
        e eVar = this.k;
        String str6 = null;
        if (eVar == null || eVar.L() == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            i = 1;
        } else {
            a2 L = this.k.L();
            if (L.O1()) {
                i = 2;
            } else if (L.R1()) {
                i = 3;
            } else if (L.P1()) {
                i = 4;
            } else {
                i = L.Q1() ? 5 : 1;
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
            i2 = U0;
            str2 = str6;
            str6 = L0;
        }
        int i3 = this.n.f50761a;
        String str7 = str2;
        String str8 = str;
        String str9 = str5;
        if (i3 != 1) {
            if (i3 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.n.f50767g).param("obj_locate", this.n.f50768h).param("obj_id", this.n.i).param("obj_name", i).param("nid", str6).param("card_type", i2).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
                if (getTbPageContext() != null) {
                    d.b.h0.j0.c.e(getTbPageContext().getPageActivity(), param);
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.n.f50762b).param("obj_param1", this.n.f50763c).param("obj_source", this.n.f50764d).param("obj_id", this.n.f50765e).param("obj_name", i).param("nid", str6).param("card_type", i2).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
        if (getTbPageContext() != null) {
            d.b.h0.j0.c.e(getTbPageContext().getPageActivity(), param2);
        }
        d.b.h0.i0.c f2 = TbPageExtraHelper.f(this);
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
        this.f19860g = f(0);
        this.f19861h = f(dimenPixelSize);
        this.i = f(dimenPixelSize);
        this.j = f(dimenPixelSize);
        this.i.j(ImageView.ScaleType.FIT_XY);
        this.j.j(ImageView.ScaleType.FIT_XY);
        this.i.k(R.string.share_weixin_friend);
        this.j.k(R.string.share_weixin_timeline);
        this.f19860g.j(ImageView.ScaleType.CENTER_INSIDE);
        this.f19860g.c(this);
        this.f19861h.j(ImageView.ScaleType.CENTER_INSIDE);
        this.f19861h.c(this);
        this.f19860g.e().setOnClickListener(this.q);
        this.f19861h.e().setOnClickListener(this.q);
        this.i.e().setOnClickListener(this.q);
        this.j.e().setOnClickListener(this.q);
        j();
    }

    public void j() {
        this.i.l(R.color.CAM_X0107);
        this.j.l(R.color.CAM_X0107);
        this.i.i(R.drawable.icon_weixin_112);
        this.j.i(R.drawable.icon_pengyouqun_112);
        this.f19860g.d();
        this.f19861h.d();
        this.i.d();
        this.j.d();
        m();
    }

    public final void k(View view) {
        e eVar;
        if (this.l != null && ViewHelper.checkUpIsLogin(getContext())) {
            if (view != this.f19860g.e() && view != this.f19861h.e()) {
                if (view == this.i.e()) {
                    e eVar2 = this.k;
                    if (eVar2 != null) {
                        d.b.i0.c2.k.e.b1.b.l(this.f19859f, eVar2.L(), 3);
                        return;
                    }
                    return;
                } else if (view != this.j.e() || (eVar = this.k) == null) {
                    return;
                } else {
                    d.b.i0.c2.k.e.b1.b.l(this.f19859f, eVar.L(), 2);
                    return;
                }
            }
            int i = 0;
            if (view == this.f19860g.e()) {
                this.f19860g.h();
                d.b.h0.r.q.e eVar3 = this.n;
                if (eVar3 != null) {
                    eVar3.f50761a = 1;
                    eVar3.f50762b = 4;
                }
                AgreeData agreeData = this.l;
                if (agreeData.hasAgree) {
                    if (agreeData.agreeType == 2) {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = false;
                        agreeData.diffAgreeNum--;
                        agreeData.agreeNum--;
                        m();
                        d.b.h0.r.q.e eVar4 = this.n;
                        if (eVar4 != null) {
                            eVar4.f50765e = 1;
                        }
                        i = 1;
                    } else {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = true;
                        agreeData.diffAgreeNum += 2;
                        agreeData.agreeNum++;
                        agreeData.disAgreeNum--;
                        n(true);
                        d.b.h0.r.q.e eVar5 = this.n;
                        if (eVar5 != null) {
                            eVar5.f50765e = 0;
                        }
                    }
                } else {
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = true;
                    agreeData.diffAgreeNum++;
                    agreeData.agreeNum++;
                    n(true);
                }
                l(i);
            } else if (view == this.f19861h.e()) {
                this.f19861h.h();
                d.b.h0.r.q.e eVar6 = this.n;
                if (eVar6 != null) {
                    eVar6.f50761a = 2;
                    eVar6.f50762b = 4;
                }
                AgreeData agreeData2 = this.l;
                if (agreeData2.hasAgree) {
                    if (agreeData2.agreeType == 5) {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = false;
                        agreeData2.diffAgreeNum++;
                        agreeData2.disAgreeNum--;
                        m();
                        d.b.h0.r.q.e eVar7 = this.n;
                        if (eVar7 != null) {
                            eVar7.i = 0;
                        }
                        i = 1;
                    } else {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = true;
                        agreeData2.diffAgreeNum -= 2;
                        agreeData2.agreeNum--;
                        agreeData2.disAgreeNum++;
                        n(false);
                        d.b.h0.r.q.e eVar8 = this.n;
                        if (eVar8 != null) {
                            eVar8.i = 1;
                        }
                    }
                } else {
                    agreeData2.agreeType = 5;
                    agreeData2.hasAgree = true;
                    agreeData2.diffAgreeNum--;
                    agreeData2.disAgreeNum++;
                    n(false);
                    d.b.h0.r.q.e eVar9 = this.n;
                    if (eVar9 != null) {
                        eVar9.i = 1;
                    }
                }
                l(i);
            }
            d.b.i0.c3.h0.e eVar10 = this.m;
            AgreeData agreeData3 = this.l;
            eVar10.f53376b = agreeData3;
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

    public void l(int i) {
        if (this.l == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", this.l.threadId);
        httpMessage.addParam("op_type", i);
        AgreeData agreeData = this.l;
        if (agreeData.objType == 0) {
            agreeData.objType = 3;
        }
        httpMessage.addParam("obj_type", this.l.objType);
        httpMessage.addParam("agree_type", this.l.agreeType);
        httpMessage.addParam("forum_id", this.l.forumId);
        d.b.h0.i0.c f2 = TbPageExtraHelper.f(this);
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
        httpMessage.setExtra(Integer.valueOf(i));
        httpMessage.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void m() {
        if (this.l == null) {
            return;
        }
        TBLottieAnimationView e2 = this.f19860g.e();
        SkinManager.setLottieAnimation(e2, R.raw.lottie_agree);
        TBLottieAnimationView e3 = this.f19861h.e();
        SkinManager.setLottieAnimation(e3, R.raw.lottie_disagree);
        TextView f2 = this.f19860g.f();
        TextView f3 = this.f19861h.f();
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
        setVisibility(this.k.L().x2() ? 8 : 0);
    }

    public void n(boolean z) {
        if (this.l == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.f19860g.f19868d;
        TBLottieAnimationView tBLottieAnimationView2 = this.f19861h.f19868d;
        TextView textView = this.f19860g.f19867c;
        TextView textView2 = this.f19861h.f19867c;
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

    public void setStatisticData(d.b.h0.r.q.e eVar) {
        this.n = eVar;
    }

    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new a(2016528);
        this.p = new b(2016530);
        this.q = new c();
        setOrientation(0);
        setGravity(17);
        this.f19859f = context;
        d.b.i0.c3.h0.e eVar = new d.b.i0.c3.h0.e();
        this.m = eVar;
        eVar.f53375a = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        i();
        this.n = new d.b.h0.r.q.e();
    }
}
