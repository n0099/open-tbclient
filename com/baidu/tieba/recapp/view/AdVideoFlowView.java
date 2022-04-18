package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.AdEnhanceButtonView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad8;
import com.repackage.bd8;
import com.repackage.db8;
import com.repackage.dc5;
import com.repackage.dd8;
import com.repackage.ed7;
import com.repackage.fd8;
import com.repackage.gj8;
import com.repackage.k78;
import com.repackage.ka8;
import com.repackage.kd8;
import com.repackage.lc8;
import com.repackage.ld8;
import com.repackage.m78;
import com.repackage.mg;
import com.repackage.na8;
import com.repackage.nc8;
import com.repackage.oz5;
import com.repackage.r78;
import com.repackage.tr4;
import com.repackage.z98;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes4.dex */
public class AdVideoFlowView extends RelativeLayout implements z98, View.OnClickListener, OnStatusChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo A;
    public AdCard B;
    public String C;
    public int D;
    public boolean E;
    public VideoItemModel F;
    public boolean G;
    public ViewGroup H;
    public ld8 I;
    public kd8 J;
    public nc8 K;
    public dc5 L;
    public int M;
    public int N;
    public db8.a O;
    public int P;
    public Handler Q;
    public boolean R;
    public boolean S;
    public ObjectAnimator T;
    public ObjectAnimator U;
    public View a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public LinearLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public TbVideoViewContainer l;
    public ImageView m;
    public TbImageView n;
    public TextView o;
    public AdTagTextView p;
    public FrameLayout q;
    public FrameLayout r;
    public AdEnhanceButtonView s;
    public VideoMiddleNiaiControllerView t;
    public Drawable u;
    public Drawable v;
    public Drawable w;
    public Drawable x;
    public Drawable y;
    public TbPageContext<BaseFragmentActivity> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoFlowView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.M = -1;
        this.N = 0;
        this.T = null;
        this.U = null;
        this.Q = new Handler();
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0078, this);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902fb);
        this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091851);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09124a);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091ccc);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090698);
        this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091248);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091cad);
        this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090695);
        this.i = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091245);
        this.k = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091ca6);
        this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09068b);
        this.n = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092288);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09229d);
        this.p = (AdTagTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090099);
        this.q = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0908dc);
        this.r = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0908dd);
        this.H = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091ec0);
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.a.findViewById(R.id.obfuscated_res_0x7f09237b);
        this.l = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.l.getControl().setContinuePlayEnable(true);
        this.l.getControl().setVideoStatusChangeListener(this);
        this.s = new AdEnhanceButtonView(context, this.q, this.r);
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = (VideoMiddleNiaiControllerView) this.a.findViewById(R.id.obfuscated_res_0x7f0913ba);
        this.t = videoMiddleNiaiControllerView;
        videoMiddleNiaiControllerView.setPlayer(this.l.getControl());
        this.t.setLoading(true);
        this.i.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.l.getControl().setOperableVideoContainer(new r78(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdVideoFlowView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.repackage.r78
            public void changeRenderViewMode(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                }
            }

            @Override // com.repackage.r78
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.repackage.r78
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.repackage.r78
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.r78
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.r78
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.r78
            public boolean onBackground(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeZ = interceptable2.invokeZ(1048582, this, z)) == null) {
                    return false;
                }
                return invokeZ.booleanValue;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, view2) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    this.a.M = 3;
                    this.a.y(34, -1);
                    if (this.a.I != null) {
                        this.a.I.e();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i3, i4, obj)) == null) {
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048586, this, i3, i4, obj)) == null) {
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                }
            }

            @Override // com.repackage.r78
            public void onScroll() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048588, this) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048589, this) == null) {
                }
            }

            @Override // com.baidu.tieba.play.TbVideoViewContainer.a
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048590, this) == null) {
                }
            }

            public boolean onVolumeDown() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.r78
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.r78
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.r78
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.repackage.r78
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.repackage.r78
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.r78
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.repackage.r78
            public void setStatistic(m78 m78Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, m78Var) == null) {
                }
            }

            @Override // com.repackage.r78
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.repackage.r78
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.repackage.r78
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
                }
            }
        });
    }

    private int getVideoControllerStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int i = this.D;
            return (i == 3 || i == 4) ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.K = this.B.tailFrame;
            if (this.J == null) {
                kd8 kd8Var = new kd8(this.z.getPageActivity(), this.H);
                this.J = kd8Var;
                kd8Var.a = 2;
            }
            ld8 b = this.J.b(this.K, this.I);
            this.I = b;
            if (b != null) {
                b.j(this.z);
                this.I.i(this.B);
                ld8 ld8Var = this.I;
                if (ld8Var instanceof fd8) {
                    ((fd8) ld8Var).z(true);
                }
                this.I.g(this.A);
                this.I.d(this.K);
                this.I.f();
                this.I.k(new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdVideoFlowView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.a.startPlay();
                            this.a.y(102, 1);
                        }
                    }
                });
                this.I.m(new CountDownTextView.c(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdVideoFlowView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
                    public void onTimeout(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            if (this.a.O != null) {
                                this.a.O.a(this.a.P);
                            }
                            this.a.I.f();
                        }
                    }
                });
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t.q(getVideoControllerStyle());
            this.m.setImageDrawable(this.u);
            this.b.setVisibility(8);
            this.d.setTextColor(gj8.a(SkinManager.getColor(R.color.CAM_X0104), tr4.a(R.string.A_X03)));
            this.g.setImageDrawable(this.x);
            this.h.setImageDrawable(this.y);
            Drawable drawable = this.w;
            VideoItemModel videoItemModel = this.F;
            if (videoItemModel != null && videoItemModel.getVideoItemData() != null) {
                drawable = TextUtils.equals(this.F.getVideoItemData().is_agreed, "1") ? this.v : this.w;
            }
            this.f.setImageDrawable(drawable);
            lc8 lc8Var = this.B.threadInfo;
            int i = lc8Var.a;
            VideoItemData videoItemData = this.F.getVideoItemData();
            if (videoItemData != null) {
                i = TextUtils.equals(videoItemData.is_agreed, "1") ? lc8Var.a + 1 : lc8Var.a;
            }
            this.c.setText(String.valueOf(i));
            this.d.setText(String.valueOf(lc8Var.c));
            this.e.setText(String.valueOf(lc8Var.b));
        }
    }

    public final void o(boolean z) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (videoMiddleNiaiControllerView = this.t) == null) {
            return;
        }
        videoMiddleNiaiControllerView.setBottomBarShow(z, getVideoControllerStyle());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            ld8 ld8Var = this.I;
            if (ld8Var instanceof fd8) {
                ((fd8) ld8Var).x();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091245) {
                u();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ca6) {
                v();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0902fb) {
                TbPageContext<BaseFragmentActivity> tbPageContext = this.z;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return;
                }
                this.z.getPageActivity().finish();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09237b) {
                w();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0908dc || view2.getId() == R.id.obfuscated_res_0x7f090099 || view2.getId() == R.id.obfuscated_res_0x7f092288 || view2.getId() == R.id.obfuscated_res_0x7f09229d) {
                s();
            }
        }
    }

    @Override // com.repackage.z98
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.N = 0;
            stopPlay();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            ld8 ld8Var = this.I;
            if (ld8Var instanceof fd8) {
                ((fd8) ld8Var).C();
            }
        }
    }

    public void onPageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.R = true;
                dc5 dc5Var = new dc5(10000L, 1000L);
                this.L = dc5Var;
                dc5Var.q(new dc5.b(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdVideoFlowView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.repackage.dc5.b
                    public void onCountDown(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                            this.a.s.update((int) (j - j2));
                        }
                    }

                    @Override // com.repackage.dc5.b
                    public void onCountDownFinish(long j) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        }
                    }
                });
                this.L.r();
                this.s.update(0);
                return;
            }
            dc5 dc5Var2 = this.L;
            if (dc5Var2 != null) {
                dc5Var2.s();
            }
            this.s.u();
            this.s.i(this.A);
            this.l.getControl().stopPlayback();
            this.l.getControl().seekTo(0);
        }
    }

    @Override // com.repackage.z98
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            x();
            y(34, 1);
        }
    }

    @Override // com.repackage.z98
    public void onPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.E = true;
            this.N = 0;
            if (z && this.S) {
                startPlay();
                return;
            }
            x();
            y(34, 1);
        }
    }

    @Override // com.baidu.tieba.play.OnStatusChangedListener
    public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, videoStatus) == null) {
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING && (videoMiddleNiaiControllerView3 = this.t) != null) {
                videoMiddleNiaiControllerView3.setLoading(false);
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView2 = this.t) != null) {
                videoMiddleNiaiControllerView2.setLoading(false);
            }
            if (videoStatus != OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING || (videoMiddleNiaiControllerView = this.t) == null) {
                return;
            }
            videoMiddleNiaiControllerView.setLoading(true);
        }
    }

    @Override // com.repackage.z98
    public void onUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.N = 0;
            this.S = z;
            if (this.E) {
                if (z) {
                    startPlay();
                    return;
                }
                x();
                y(34, 1);
            }
        }
    }

    @Override // com.repackage.z98
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.repackage.z98
    public void onViewDoubleClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.repackage.z98
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.a == null || this.G) {
            return;
        }
        this.G = true;
        TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.a.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.z.getResources().getDimensionPixelOffset(R.dimen.tbds396), this.z.getResources().getDimensionPixelOffset(R.dimen.tbds396));
        layoutParams.addRule(13);
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f11001c);
        View view2 = this.a;
        if (view2 instanceof RelativeLayout) {
            ((RelativeLayout) view2).addView(tBLottieAnimationView, layoutParams);
        }
        tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener(this, tBLottieAnimationView) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TBLottieAnimationView a;
            public final /* synthetic */ AdVideoFlowView b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, tBLottieAnimationView};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = tBLottieAnimationView;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    if (this.b.a instanceof RelativeLayout) {
                        ((RelativeLayout) this.b.a).removeView(this.a);
                    }
                    this.b.G = false;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                }
            }
        });
        tBLottieAnimationView.playAnimation();
    }

    public final ObjectAnimator r(float f, float f2, float f3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.m, PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f3));
            ofPropertyValuesHolder.setDuration(j);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void s() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = this.B.scheme;
            if (na8.C(this.A, str)) {
                i = 3;
            } else {
                i = na8.e(this.z, str, this.A.i() ? this.B.getDownloadId() : this.B.adId, this.B.getExtInfo(), this.B.cmdScheme);
            }
            if (i == 0) {
                return;
            }
            if (na8.q(i)) {
                ad8.f(this.A, i);
            } else {
                ad8.n(this.A);
            }
            ed7.h(ed7.e(this.A));
        }
    }

    public void setData(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, advertAppInfo) == null) || advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.i;
        if (iLegoAdvert instanceof AdCard) {
            this.A = advertAppInfo;
            AdCard adCard = (AdCard) iLegoAdvert;
            this.B = adCard;
            if (adCard.videoInfo == null) {
                return;
            }
            this.n.K(adCard.userImage, 30, false);
            this.o.setText(this.B.userName);
            this.p.setText(this.B.threadTitle);
            k78 k78Var = new k78();
            k78Var.e = "ad_feed";
            k78Var.d = k78Var.a("ad_feed");
            k78Var.f = k78Var.c("1");
            this.l.getControl().setVideoModel(k78Var);
            this.C = this.B.videoInfo.video_url;
            this.l.getControl().setVideoPath(this.C);
            this.s.i(advertAppInfo);
            A();
        }
    }

    @Override // com.repackage.z98
    public void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{drawable, drawable2, drawable3, drawable4, drawable5, drawable6}) == null) {
            this.u = drawable;
            this.v = drawable3;
            this.w = drawable4;
            this.x = drawable5;
            this.y = drawable6;
        }
    }

    @Override // com.repackage.z98
    public void setPageChangeHandler(db8.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, aVar, i) == null) {
            this.O = aVar;
            this.P = i;
        }
    }

    public void setPageContext(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContext) == null) {
            this.z = tbPageContext;
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ImageView imageView = this.m;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ld8 ld8Var = this.I;
            if (ld8Var != null) {
                ld8Var.f();
            }
            o(true);
            TbVideoViewContainer tbVideoViewContainer = this.l;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return;
            }
            if (TbVideoViewSet.b().c(this.C) == null || TbVideoViewSet.b().c(this.C) != this.l) {
                k78 k78Var = new k78();
                k78Var.e = "ad_feed";
                k78Var.d = k78Var.a("ad_feed");
                k78Var.f = k78Var.c("1");
                this.l.getControl().setVideoModel(k78Var);
                this.l.getControl().setVideoPath(this.C);
            }
            if (this.M == -1) {
                this.l.getControl().p(null);
                y(31, -1);
                this.t.n();
                if (!this.R) {
                    onPageSelected(true);
                }
            } else {
                this.l.getControl().b(null);
                if (this.M != 3) {
                    y(33, -1);
                }
            }
            this.Q.postDelayed(new Runnable(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdVideoFlowView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.t.p();
                    }
                }
            }, 200L);
            this.M = 1;
        }
    }

    public final void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            z();
            TbVideoViewContainer tbVideoViewContainer = this.l;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.l.getControl().stopPlayback();
            }
            this.M = -1;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            new ka8(this.A, this.B.closeInfo, this.z.getPageActivity(), getRootView(), 80, PlaceId.VIDEO_FLOW).q();
        }
    }

    public final void u() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (videoItemModel = this.F) == null || videoItemModel.getVideoItemData() == null) {
            return;
        }
        VideoItemData videoItemData = this.F.getVideoItemData();
        String str = TextUtils.equals(videoItemData.is_agreed, "1") ? "0" : "1";
        videoItemData.is_agreed = str;
        if (TextUtils.equals(str, "1")) {
            p();
        }
        int i = TextUtils.equals(videoItemData.is_agreed, "1") ? 1 : -1;
        this.f.setImageDrawable(TextUtils.equals(videoItemData.is_agreed, "1") ? this.v : this.w);
        this.c.setText(String.valueOf(mg.e(String.valueOf(this.c.getText()), 0) + i));
    }

    @Override // com.repackage.z98
    public void updateTiebaData(int i, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i, videoItemModel) == null) {
            this.D = i;
            this.F = videoItemModel;
            B();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.B.getTitle();
            shareItem.D = this.B.getTitle();
            shareItem.t = this.B.getShareLink();
            shareItem.F = 3;
            shareItem.f = true;
            String imageUrl = this.B.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.z.getPageActivity(), shareItem, true, true);
            shareDialogConfig.showDisLike = true;
            shareDialogConfig.disLikeListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdVideoFlowView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.t();
                    }
                }
            };
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            oz5.c().l(shareDialogConfig);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.N = 1;
            if (this.l.getControl().isPlaying()) {
                x();
                y(32, 0);
                z();
                return;
            }
            startPlay();
            this.m.setVisibility(8);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            z();
            TbVideoViewContainer tbVideoViewContainer = this.l;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.l.getControl().pause();
            }
            o(false);
            this.M = 2;
        }
    }

    public final void y(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048606, this, i, i2) == null) || this.A == null || this.B.videoInfo == null) {
            return;
        }
        bd8.b().d(dd8.l(this.A, i, 0, this.N, this.B.videoInfo.video_duration.intValue(), this.l.getControl().getCurrentPosition(), i2));
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            ImageView imageView = this.m;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.T == null) {
                this.T = r(0.0f, 3.0f, 3.0f, 0L);
            }
            this.T.addListener(new Animator.AnimatorListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdVideoFlowView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        if (this.a.U == null) {
                            AdVideoFlowView adVideoFlowView = this.a;
                            adVideoFlowView.U = adVideoFlowView.r(1.0f, 1.0f, 1.0f, 100L);
                        }
                        this.a.U.start();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                    }
                }
            });
            this.T.start();
        }
    }
}
