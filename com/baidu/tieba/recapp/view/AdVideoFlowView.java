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
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
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
import com.repackage.bd7;
import com.repackage.dh0;
import com.repackage.eb8;
import com.repackage.eh0;
import com.repackage.fb8;
import com.repackage.fd5;
import com.repackage.ga8;
import com.repackage.h98;
import com.repackage.iy0;
import com.repackage.jb8;
import com.repackage.kb8;
import com.repackage.ng;
import com.repackage.q68;
import com.repackage.r98;
import com.repackage.s68;
import com.repackage.sg8;
import com.repackage.t98;
import com.repackage.ta8;
import com.repackage.tr4;
import com.repackage.va8;
import com.repackage.x68;
import com.repackage.xz5;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdVideoFlowView extends RelativeLayout implements h98, View.OnClickListener, OnStatusChangedListener {
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
    public kb8 I;
    public jb8 J;
    public va8 K;
    public fd5 L;
    public int M;
    public int N;
    public ga8.a O;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d006f, this);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902f6);
        this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0918d8);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09128b);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091d6d);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090659);
        this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091289);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091d48);
        this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090656);
        this.i = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091286);
        this.k = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091d3f);
        this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09064c);
        this.n = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09231a);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09232f);
        this.p = (AdTagTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090095);
        this.q = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0908ac);
        this.r = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0908ad);
        this.H = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091f5d);
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.a.findViewById(R.id.obfuscated_res_0x7f092409);
        this.l = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.l.getControl().setContinuePlayEnable(true);
        this.l.getControl().setVideoStatusChangeListener(this);
        this.l.getControl().setLooping(false);
        this.s = new AdEnhanceButtonView(context, this.q, this.r);
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = (VideoMiddleNiaiControllerView) this.a.findViewById(R.id.obfuscated_res_0x7f091408);
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
        this.l.getControl().setOperableVideoContainer(new x68(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.1
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

            @Override // com.repackage.x68
            public void changeRenderViewMode(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                }
            }

            @Override // com.repackage.x68
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.repackage.x68
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.repackage.x68
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.x68
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.x68
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.x68
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
                    this.a.x(34, -1);
                    if (this.a.I != null) {
                        this.a.I.d();
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

            @Override // com.repackage.x68
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

            @Override // com.repackage.x68
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.x68
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.x68
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.repackage.x68
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.repackage.x68
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.x68
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.repackage.x68
            public void setStatistic(s68 s68Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, s68Var) == null) {
                }
            }

            @Override // com.repackage.x68
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.repackage.x68
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.repackage.x68
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
            this.t.q(getVideoControllerStyle());
            this.m.setImageDrawable(this.u);
            this.b.setVisibility(8);
            this.d.setTextColor(sg8.a(SkinManager.getColor(R.color.CAM_X0104), tr4.a(R.string.A_X03)));
            this.g.setImageDrawable(this.x);
            this.h.setImageDrawable(this.y);
            Drawable drawable = this.w;
            VideoItemModel videoItemModel = this.F;
            if (videoItemModel != null && videoItemModel.getVideoItemData() != null) {
                drawable = TextUtils.equals(this.F.getVideoItemData().is_agreed, "1") ? this.v : this.w;
            }
            this.f.setImageDrawable(drawable);
            ta8 ta8Var = this.B.threadInfo;
            int i = ta8Var.a;
            VideoItemData videoItemData = this.F.getVideoItemData();
            if (videoItemData != null) {
                i = TextUtils.equals(videoItemData.is_agreed, "1") ? ta8Var.a + 1 : ta8Var.a;
            }
            this.c.setText(String.valueOf(i));
            this.d.setText(String.valueOf(ta8Var.c));
            this.e.setText(String.valueOf(ta8Var.b));
        }
    }

    public final void o(boolean z) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (videoMiddleNiaiControllerView = this.t) == null) {
            return;
        }
        videoMiddleNiaiControllerView.setBottomBarShow(z, getVideoControllerStyle());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091286) {
                t();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d3f) {
                u();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0902f6) {
                TbPageContext<BaseFragmentActivity> tbPageContext = this.z;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return;
                }
                this.z.getPageActivity().finish();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092409) {
                v();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0908ac || view2.getId() == R.id.obfuscated_res_0x7f090095 || view2.getId() == R.id.obfuscated_res_0x7f09231a || view2.getId() == R.id.obfuscated_res_0x7f09232f) {
                r();
            }
        }
    }

    @Override // com.repackage.h98
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.N = 0;
            stopPlay();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void onPageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.R = true;
                fd5 fd5Var = new fd5(10000L, 1000L);
                this.L = fd5Var;
                fd5Var.n(new fd5.b(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.7
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

                    @Override // com.repackage.fd5.b
                    public void onCountDown(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                            this.a.s.update((int) (j - j2));
                        }
                    }

                    @Override // com.repackage.fd5.b
                    public void onCountDownFinish(long j) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        }
                    }
                });
                this.L.o();
                this.s.update(0);
                return;
            }
            fd5 fd5Var2 = this.L;
            if (fd5Var2 != null) {
                fd5Var2.p();
            }
            this.s.r();
            this.s.i(this.A);
            this.l.getControl().stopPlayback();
            this.l.getControl().seekTo(0);
        }
    }

    @Override // com.repackage.h98
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            w();
            x(34, 1);
        }
    }

    @Override // com.repackage.h98
    public void onPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.E = true;
            this.N = 0;
            if (z && this.S) {
                startPlay();
                return;
            }
            w();
            x(34, 1);
        }
    }

    @Override // com.baidu.tieba.play.OnStatusChangedListener
    public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoStatus) == null) {
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

    @Override // com.repackage.h98
    public void onUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.N = 0;
            this.S = z;
            if (this.E) {
                if (z) {
                    startPlay();
                    return;
                }
                w();
                x(34, 1);
            }
        }
    }

    @Override // com.repackage.h98
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.repackage.h98
    public void onViewDoubleClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.repackage.h98
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.a == null || this.G) {
            return;
        }
        this.G = true;
        TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.a.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.z.getResources().getDimensionPixelOffset(R.dimen.tbds396), this.z.getResources().getDimensionPixelOffset(R.dimen.tbds396));
        layoutParams.addRule(13);
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f11001d);
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

    public final ObjectAnimator q(float f, float f2, float f3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.m, PropertyValuesHolder.ofFloat("alpha", f), PropertyValuesHolder.ofFloat("scaleX", f2), PropertyValuesHolder.ofFloat("scaleY", f3));
            ofPropertyValuesHolder.setDuration(j);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void r() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            String str = this.B.scheme;
            if (!eh0.n(this.A.q) ? dh0.b(this.z.getPageActivity(), this.A.p) : false) {
                i = 3;
            } else {
                i = t98.b(this.z, str, this.A.g() ? this.B.getDownloadId() : this.B.adId, this.B.getExtInfo(), this.B.cmdScheme);
            }
            if (i == 0) {
                return;
            }
            if (t98.h(i)) {
                eb8.e(this.A, i);
            } else {
                eb8.l(this.A);
            }
            bd7.c(this.A);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            new r98(this.A, this.B.closeInfo, this.z.getPageActivity(), getRootView(), 80, PlaceId.VIDEO_FLOW).q();
        }
    }

    public void setData(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, advertAppInfo) == null) || advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
        if (iLegoAdvert instanceof AdCard) {
            this.A = advertAppInfo;
            AdCard adCard = (AdCard) iLegoAdvert;
            this.B = adCard;
            if (adCard.videoInfo == null) {
                return;
            }
            this.n.J(adCard.userImage, 30, false);
            this.o.setText(this.B.userName);
            this.p.setText(this.B.threadTitle);
            q68 q68Var = new q68();
            q68Var.e = "ad_feed";
            q68Var.d = q68Var.a("ad_feed");
            q68Var.f = q68Var.c("1");
            this.l.getControl().setVideoModel(q68Var);
            this.C = this.B.videoInfo.video_url;
            this.l.getControl().setVideoPath(this.C);
            this.s.i(advertAppInfo);
            z();
        }
    }

    @Override // com.repackage.h98
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

    @Override // com.repackage.h98
    public void setPageChangeHandler(ga8.a aVar, int i) {
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
            kb8 kb8Var = this.I;
            if (kb8Var != null) {
                kb8Var.e();
            }
            o(true);
            TbVideoViewContainer tbVideoViewContainer = this.l;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return;
            }
            if (TbVideoViewSet.b().c(this.C) == null || TbVideoViewSet.b().c(this.C) != this.l) {
                q68 q68Var = new q68();
                q68Var.e = "ad_feed";
                q68Var.d = q68Var.a("ad_feed");
                q68Var.f = q68Var.c("1");
                this.l.getControl().setVideoModel(q68Var);
                this.l.getControl().setVideoPath(this.C);
            }
            if (this.M == -1) {
                this.l.getControl().p(null);
                x(31, -1);
                this.t.n();
                if (!this.R) {
                    onPageSelected(true);
                }
            } else {
                this.l.getControl().b(null);
                if (this.M != 3) {
                    x(33, -1);
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
            y();
            TbVideoViewContainer tbVideoViewContainer = this.l;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.l.getControl().stopPlayback();
            }
            this.M = -1;
        }
    }

    public final void t() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (videoItemModel = this.F) == null || videoItemModel.getVideoItemData() == null) {
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
        this.c.setText(String.valueOf(ng.e(String.valueOf(this.c.getText()), 0) + i));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.u = this.B.getTitle();
            shareItem.G = this.B.getTitle();
            shareItem.w = this.B.getShareLink();
            shareItem.I = 3;
            shareItem.f = true;
            shareItem.n = true;
            String imageUrl = this.B.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                shareItem.y = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.z.getPageActivity(), shareItem, true, true);
            shareDialogConfig.showDisLike = true;
            shareDialogConfig.mIsAd = true;
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
                        this.a.s();
                    }
                }
            };
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            xz5.c().l(shareDialogConfig);
        }
    }

    @Override // com.repackage.h98
    public void updateTiebaData(int i, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i, videoItemModel) == null) {
            this.D = i;
            this.F = videoItemModel;
            A();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.N = 1;
            if (this.l.getControl().isPlaying()) {
                w();
                x(32, 0);
                y();
                return;
            }
            startPlay();
            this.m.setVisibility(8);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            y();
            TbVideoViewContainer tbVideoViewContainer = this.l;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.l.getControl().pause();
            }
            o(false);
            this.M = 2;
        }
    }

    public final void x(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048605, this, i, i2) == null) || this.A == null || this.B.videoInfo == null) {
            return;
        }
        int currentPosition = this.l.getControl().getCurrentPosition();
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.v(this.A.j).z(String.valueOf(i)).q(String.valueOf(this.A.position + 1)).p(this.A.g).k(String.valueOf(this.N)).l(String.valueOf(Math.round(currentPosition / 1000.0f))).m(String.valueOf(this.B.videoInfo.video_duration));
        if (i2 != -1 && i == 32) {
            clogBuilder.o(String.valueOf(i2));
        }
        if (i == 34) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", this.B.videoInfo.video_duration);
                jSONObject.put(CriusAttrConstants.POSITION, currentPosition);
                jSONObject.put("start_type", this.N);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            clogBuilder.A(jSONObject.toString());
        }
        if (i == 102) {
            clogBuilder.j("replaybtn");
        }
        iy0.b(clogBuilder);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ImageView imageView = this.m;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.T == null) {
                this.T = q(0.0f, 3.0f, 3.0f, 0L);
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
                            adVideoFlowView.U = adVideoFlowView.q(1.0f, 1.0f, 1.0f, 100L);
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

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.K = this.B.tailFrame;
            if (this.J == null) {
                jb8 jb8Var = new jb8(this.z.getPageActivity(), this.H);
                this.J = jb8Var;
                jb8Var.a = 2;
            }
            kb8 b = this.J.b(this.K, this.I);
            this.I = b;
            if (b != null) {
                b.h(this.z);
                this.I.g(this.B);
                kb8 kb8Var = this.I;
                if (kb8Var instanceof fb8) {
                    ((fb8) kb8Var).m(true);
                }
                this.I.f(this.A);
                this.I.c(this.K);
                this.I.e();
                this.I.i(new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.4
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
                            this.a.x(102, 1);
                        }
                    }
                });
                this.I.j(new CountDownTextView.c(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.5
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
                            this.a.I.e();
                        }
                    }
                });
            }
        }
    }
}
