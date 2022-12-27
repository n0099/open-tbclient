package com.baidu.tieba;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.mf8;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class r46 extends h46<x56> implements View.OnClickListener, gr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TextView B;
    public View C;
    public wf8 D;
    public x56 E;
    public View F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public String K;
    public mf8 L;
    public Animation M;
    public TextView N;
    public TextView O;
    public Handler P;
    public Runnable Q;
    public Runnable R;
    public final View.OnClickListener S;
    public final View.OnClickListener T;
    public ThreadCommentAndPraiseInfoLayout i;
    public View j;
    public FrameLayout k;
    public ThreadGodReplyLayout l;
    public NEGFeedBackView m;
    public String n;
    public ThreadSourceShareAndPraiseLayout o;
    public TbPageContext<?> p;
    public RelativeLayout q;
    public TextView r;
    public ThreadUserInfoLayout s;
    public HeadPendantClickableView t;
    public TbImageView u;
    public ImageView v;
    public TbVideoViewContainer w;
    public TextView x;
    public LinearLayout y;
    public TextView z;

    @Override // com.baidu.tieba.h46
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? R.layout.card_home_page_auto_video_view_new : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a extends tn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r46 r46Var, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r46Var, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = str2;
        }

        @Override // com.baidu.tieba.tn5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sp4.x(TbadkCoreApplication.getInst().getApplicationContext(), false, this.i);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
            }
        }

        @Override // com.baidu.tieba.tn5, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mf8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r46 a;

        public b(r46 r46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r46Var;
        }

        @Override // com.baidu.tieba.mf8.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i2 < i && i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                r46 r46Var = this.a;
                r46Var.M(r46Var.E);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h46
    /* renamed from: E */
    public void i(x56 x56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, x56Var) == null) {
            this.E = x56Var;
            F();
        }
    }

    public final void M(x56 x56Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, x56Var) != null) || x56Var == null || (threadData = x56Var.a) == null || threadData.getId() == null) {
        }
    }

    @Override // com.baidu.tieba.gr5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.n = str;
        }
    }

    public int t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            return fr5.c().b(this.n, i);
        }
        return invokeI.intValue;
    }

    public final void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.E);
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                yi.P(this.p.getPageActivity(), R.string.no_network_guide);
            } else {
                w(ThreadCardUtils.computeViewArea(this.k));
            }
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.E);
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                yi.P(this.p.getPageActivity(), R.string.no_network_guide);
            } else {
                w(ThreadCardUtils.computeViewArea(this.k));
            }
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            x56 x56Var = this.E;
            if (x56Var != null && (threadData = x56Var.a) != null && threadData.getThreadVideoSegment() != null && !TextUtils.isEmpty(this.E.a.getThreadVideoSegment().video_url)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            x56 x56Var = this.E;
            if (x56Var.R && !x56Var.S) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.P.removeMessages(202);
            this.P.removeMessages(203);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ah.a().removeCallbacks(this.Q);
            ah.a().removeCallbacks(this.R);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.w;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                return this.w.getControl().getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.w;
            if (tbVideoViewContainer == null) {
                return false;
            }
            return tbVideoViewContainer.getControl().isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            H();
            G();
            K(true, 1);
            TbVideoViewContainer tbVideoViewContainer = this.w;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().stopPlayback();
                mf8 mf8Var = this.L;
                if (mf8Var != null) {
                    mf8Var.n();
                }
            }
            this.I = false;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.K;
        }
        return (String) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    public final void F() {
        ThreadData threadData;
        boolean z;
        ThreadData threadData2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            x56 x56Var = this.E;
            if (x56Var != null && (threadData = x56Var.a) != null && threadData.getAuthor() != null) {
                this.q.setVisibility(0);
                z();
                if (!C() && s46.k(this.E.a.getId())) {
                    s46.l(this.r, this.E.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    s46.l(this.l.getGodReplyContent(), this.E.getThreadData().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                }
                this.E.getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.E.getThreadData().getSpan_str());
                if (this.E.getThreadData().canShowNaniTail() && !StringUtils.isNull(this.E.getThreadData().getTid())) {
                    String str = ry4.l().r("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.E.getThreadData().getTid();
                    spannableStringBuilder.append((CharSequence) this.E.getThreadData().generateNaniTail(new a(this, 2, str, str)));
                }
                this.r.setOnTouchListener(new u49(spannableStringBuilder));
                this.r.setText(spannableStringBuilder);
                this.s.j(this.E.getThreadData());
                this.s.setUserAfterClickListener(this.S);
                if (this.s.getHeaderImg() != null) {
                    this.s.getHeaderImg().setAfterClickListener(this.T);
                    if (this.s.getIsSimpleThread()) {
                        this.s.getHeaderImg().setVisibility(8);
                        this.t.setVisibility(8);
                    } else if (this.E.getThreadData() != null && this.E.getThreadData().getAuthor() != null && this.E.getThreadData().getAuthor().getPendantData() != null && !StringUtils.isNull(this.E.getThreadData().getAuthor().getPendantData().getImgUrl())) {
                        this.s.getHeaderImg().setVisibility(4);
                        this.t.setVisibility(0);
                        this.t.setData(this.E.getThreadData());
                    } else {
                        this.t.setVisibility(8);
                        this.s.getHeaderImg().setVisibility(0);
                        if (this.E.getThreadData().middle_page_num > 0 && this.E.getThreadData().middle_page_pass_flag == 0) {
                            this.E.getThreadData().getAuthor().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                            this.s.getHeaderImg().setData(this.E.getThreadData(), false);
                        } else {
                            this.s.getHeaderImg().setData(this.E.getThreadData());
                            this.s.getHeaderImg().setOnInterceptClickEventListener(null);
                        }
                    }
                }
                this.x.setText(StringHelper.stringForVideoTime(this.E.a.getThreadVideoInfo().video_duration.intValue() * 1000));
                this.z.setText(String.format(this.p.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.E.a.getThreadVideoInfo().play_count.intValue())));
                if (this.m != null && this.E.getThreadData() != null) {
                    rt4 rt4Var = new rt4();
                    rt4Var.o(this.E.getThreadData().getTid());
                    rt4Var.k(this.E.getThreadData().getFid());
                    rt4Var.n(this.E.getThreadData().getNid());
                    rt4Var.j(this.E.feedBackReasonMap);
                    this.m.setData(rt4Var);
                    this.m.setFirstRowSingleColumn(true);
                    NEGFeedBackView nEGFeedBackView = this.m;
                    if (this.J) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    nEGFeedBackView.setVisibility(i);
                }
                this.l.setData(this.E.getThreadData().getTopAgreePost());
                L(t(1));
                j(this.p, TbadkCoreApplication.getInst().getSkinType());
                if (s46.k(this.E.a.getId())) {
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
                }
                x56 x56Var2 = this.E;
                if (x56Var2 != null && (threadData2 = x56Var2.a) != null && threadData2.getThreadVideoInfo() != null && this.E.a.getThreadVideoInfo().is_vertical.intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.O.setVisibility(0);
                    if (B()) {
                        this.O.setText(String.format("%s | %s", this.p.getResources().getString(R.string.nani_video), this.p.getResources().getString(R.string.video_preview)));
                        return;
                    } else {
                        this.O.setText(this.p.getString(R.string.nani_video));
                        return;
                    }
                } else if (B()) {
                    this.O.setVisibility(0);
                    this.O.setText(this.p.getString(R.string.video_preview));
                    return;
                } else {
                    this.O.setVisibility(8);
                    return;
                }
            }
            this.q.setVisibility(8);
        }
    }

    public final void J() {
        x56 x56Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (x56Var = this.E) != null && x56Var.a != null) {
            zf8 zf8Var = new zf8();
            if (this.E.T == 0) {
                str = "index";
            } else {
                str = "hot_juhe";
            }
            zf8Var.a = str;
            zf8Var.c = this.E.a.getTid();
            zf8Var.d = this.E.a.getFid() + "";
            zf8Var.e = TbadkCoreApplication.getCurrentAccount();
            x56 x56Var2 = this.E;
            ThreadData threadData = x56Var2.a;
            zf8Var.f = threadData.mRecomSource;
            String str2 = threadData.mRecomAbTag;
            zf8Var.l = str2;
            zf8Var.g = str2;
            zf8Var.h = threadData.mRecomWeight;
            zf8Var.i = "";
            zf8Var.k = x56Var2.g();
            if (this.E.a.getThreadVideoInfo() != null) {
                zf8Var.m = this.E.a.getThreadVideoInfo().video_md5;
            }
            of8.e(this.E.a.getThreadVideoInfo().video_md5, "", "1", zf8Var, this.w.getControl().getPcdnState());
        }
    }

    public final void z() {
        x56 x56Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            H();
            G();
            if (this.u != null && this.k != null && this.w != null) {
                if (dr4.c().g() && (x56Var = this.E) != null && (threadData = x56Var.a) != null && threadData.getThreadVideoInfo() != null) {
                    this.u.setPlaceHolder(3);
                    this.u.K(this.E.a.getThreadVideoInfo().thumbnail_url, 10, false);
                    this.k.setVisibility(0);
                    stopPlay();
                    this.K = this.E.a.getThreadVideoInfo().video_url;
                    if (B()) {
                        this.K = this.E.a.getThreadVideoSegment().video_url;
                    }
                    if (StringUtils.isNull(this.E.a.getThreadVideoInfo().video_url)) {
                        K(true, 4);
                    }
                    this.w.getControl().setThreadDataForStatistic(this.E.a);
                } else {
                    this.k.setVisibility(8);
                }
                this.L.j(new b(this));
            }
        }
    }

    public final void K(boolean z, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && this.v != null && this.u != null && this.F != null && this.D != null && this.C != null && this.B != null) {
            if (!z && this.H == i) {
                return;
            }
            this.H = i;
            ah.a().removeCallbacks(this.R);
            ah.a().removeCallbacks(this.Q);
            if (i == 2) {
                this.v.setVisibility(8);
                this.M.cancel();
                this.u.clearAnimation();
                this.u.setVisibility(0);
                this.F.setVisibility(0);
                this.y.setVisibility(0);
                this.N.setVisibility(8);
                this.D.g();
                this.C.setVisibility(8);
                this.B.setVisibility(8);
                ah.a().postDelayed(this.R, 60000L);
            } else if (i == 3) {
                this.v.setVisibility(8);
                this.u.startAnimation(this.M);
                this.F.setVisibility(8);
                this.y.setVisibility(8);
                x56 x56Var = this.E;
                if (x56Var != null && x56Var.getThreadData() != null && this.E.getThreadData().middle_page_num > 0) {
                    this.N.setVisibility(0);
                }
                this.D.c();
                this.C.setVisibility(8);
                this.B.setVisibility(8);
                x56 x56Var2 = this.E;
                if (x56Var2 != null && (threadData = x56Var2.a) != null && threadData.getThreadVideoInfo() != null) {
                    this.E.a.getThreadVideoInfo().video_length.intValue();
                    this.E.a.getThreadVideoInfo().video_duration.intValue();
                    this.E.a.getTid();
                }
            } else if (i == 4) {
                this.v.setVisibility(8);
                this.u.startAnimation(this.M);
                this.F.setVisibility(8);
                this.D.b();
                this.C.setVisibility(0);
                this.B.setVisibility(0);
                ah.a().postDelayed(this.Q, 2000L);
            } else {
                this.v.setVisibility(0);
                this.M.cancel();
                this.u.clearAnimation();
                this.u.setVisibility(0);
                this.F.setVisibility(0);
                this.y.setVisibility(0);
                this.D.b();
                this.C.setVisibility(8);
                this.B.setVisibility(8);
            }
            x56 x56Var3 = this.E;
            if (x56Var3 != null && x56Var3.getThreadData() != null && this.E.getThreadData().middle_page_num > 0) {
                this.y.setVisibility(8);
            }
        }
    }

    public void L(int i) {
        x56 x56Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (x56Var = this.E) != null && (threadData = x56Var.a) != null) {
            if (i == 1) {
                if (threadData.middle_page_num > 0) {
                    this.o.b.setShowPraiseNum(false);
                    this.o.b.setShareVisible(false);
                    this.N.setText(StringHelper.numFormatOverWan(this.E.a.middle_page_num));
                    this.N.setVisibility(0);
                } else {
                    this.o.b.setShowPraiseNum(true);
                    this.o.b.setShareVisible(true);
                    this.N.setVisibility(8);
                }
                this.o.g(this.E.a);
                this.i.setVisibility(8);
                this.s.l(false);
                return;
            }
            this.o.setVisibility(8);
            this.s.l(true);
            if (this.E.a.middle_page_num > 0) {
                this.i.setShowPraiseNum(false);
                this.i.setShareVisible(false);
                this.N.setText(StringHelper.numFormatOverWan(this.E.a.middle_page_num));
                this.N.setVisibility(0);
            } else {
                this.i.setShowPraiseNum(true);
                this.i.setShareVisible(true);
                this.N.setVisibility(8);
            }
            if (this.i.setData(this.E.a)) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            x56 x56Var = this.E;
            if (x56Var != null && (threadData2 = x56Var.a) != null && threadData2.middle_page_num > 0) {
                if (e() != null) {
                    e().a(view2, this.E);
                }
                this.p.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.p.getPageActivity(), this.E.a.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, s46.g(), this.E.getPbInputLocate())));
                return;
            }
            if (view2 == this.q || view2 == this.l) {
                y(view2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
            }
            if (view2 == this.w) {
                x56 x56Var2 = this.E;
                if (x56Var2 != null) {
                    x56Var2.f = 5;
                }
                x56 x56Var3 = this.E;
                boolean z = false;
                if (x56Var3 != null && (threadData = x56Var3.a) != null && threadData.getThreadVideoInfo() != null && this.E.a.getThreadVideoInfo().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    x(this.w);
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    A(this.w);
                } else {
                    y(h());
                }
            }
        }
    }

    public final void y(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            x56 x56Var = this.E;
            if (x56Var != null) {
                x56Var.f = 1;
            }
            if (e() != null) {
                e().a(view2, this.E);
            }
            x56 x56Var2 = this.E;
            if (x56Var2 != null && x56Var2.a != null) {
                if (!C()) {
                    s46.a(this.E.a.getId());
                    s46.l(this.r, this.E.a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                PbActivityConfig addLocateParam = new PbActivityConfig(this.p.getPageActivity()).createFromThreadCfg(this.E.a, null, s46.g(), 18003, true, false, false).addLocateParam(this.E.getPbInputLocate());
                if (this.E.T == 0) {
                    str = "index";
                } else {
                    str = "hot_juhe";
                }
                addLocateParam.setVideo_source(str);
                if (this.E.T == 0) {
                    addLocateParam.setFrom("from_personalize");
                }
                addLocateParam.setForumId(String.valueOf(this.E.a.getFid()));
                addLocateParam.setForumName(this.E.a.getForum_name());
                addLocateParam.setStartFrom(this.h);
                if (view2 == this.l) {
                    addLocateParam.setJumpGodReply(true);
                }
                this.p.sendMessage(new CustomMessage(2004001, addLocateParam));
            }
        }
    }

    @Override // com.baidu.tieba.h46
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, tbPageContext, i) == null) && this.G != i) {
            SkinManager.setBackgroundResource(this.q, R.drawable.addresslist_item_bg);
            SkinManager.setImageResource(this.v, R.drawable.btn_icon_play_video_n);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.N, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.C, R.color.common_color_10014);
            SkinManager.setBackgroundColor(this.A, R.color.CAM_X0204);
            TextView textView = this.O;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.O, R.drawable.video_play_count_bg);
            }
            if (this.B != null) {
                this.B.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.l.k();
            NEGFeedBackView nEGFeedBackView = this.m;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            this.s.h();
            this.i.onChangeSkinType();
            this.o.f();
            this.u.setPlaceHolder(3);
            this.t.getHeadView().setPlaceHolder(1);
            this.G = i;
        }
    }

    public void startPlay() {
        x56 x56Var;
        ThreadData threadData;
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && !this.I && (x56Var = this.E) != null && (threadData = x56Var.a) != null && threadData.getThreadVideoInfo() != null && (tbVideoViewContainer = this.w) != null) {
            tbVideoViewContainer.getControl().stopPlayback();
            if (wk5.b(1, this.K)) {
                K(true, 2);
                if (StringUtils.isNull(this.K)) {
                    CommonStatisticUtils.staticUrlNullReport("index", this.E.g);
                    this.K = this.E.a.getThreadVideoInfo().video_url;
                }
                this.I = true;
                this.w.getControl().setVideoPath(this.K, this.E.g);
                mf8 mf8Var = this.L;
                if (mf8Var != null) {
                    mf8Var.m();
                }
                J();
            }
        }
    }

    public final void w(Rect rect) {
        x56 x56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, rect) == null) && (x56Var = this.E) != null && x56Var.a != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.E.a);
            videoItemData.mRecomExtra = this.E.g();
            videoItemData.mRecomAbTag = this.E.c();
            videoItemData.mRecomSource = this.E.o();
            videoItemData.mRecomWeight = this.E.z();
            arrayList.add(videoItemData);
            String str = null;
            if (this.E.a.getBaijiahaoData() != null) {
                str = this.E.a.getBaijiahaoData().oriUgcNid;
            }
            sj5.d(this.b.getPageActivity(), arrayList, str, false, 0, rect, "from_nani_video", "personalize_page", this.E.getPbInputLocate(), "index", "", false, false, this.E.a.getFid());
        }
    }
}
