package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.VCenterTextSpan;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.ab5;
import com.baidu.tieba.ae5;
import com.baidu.tieba.ag;
import com.baidu.tieba.ai5;
import com.baidu.tieba.ak5;
import com.baidu.tieba.aq9;
import com.baidu.tieba.bg;
import com.baidu.tieba.bk5;
import com.baidu.tieba.bx5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cea;
import com.baidu.tieba.cy6;
import com.baidu.tieba.d25;
import com.baidu.tieba.dh5;
import com.baidu.tieba.di;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dt6;
import com.baidu.tieba.dw4;
import com.baidu.tieba.ej9;
import com.baidu.tieba.ek5;
import com.baidu.tieba.fk5;
import com.baidu.tieba.fl9;
import com.baidu.tieba.fq9;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gg9;
import com.baidu.tieba.gm9;
import com.baidu.tieba.gw5;
import com.baidu.tieba.h05;
import com.baidu.tieba.h16;
import com.baidu.tieba.h9;
import com.baidu.tieba.hi5;
import com.baidu.tieba.hk5;
import com.baidu.tieba.iq9;
import com.baidu.tieba.it4;
import com.baidu.tieba.ix5;
import com.baidu.tieba.jn6;
import com.baidu.tieba.jo9;
import com.baidu.tieba.jt4;
import com.baidu.tieba.k16;
import com.baidu.tieba.ki5;
import com.baidu.tieba.km9;
import com.baidu.tieba.l95;
import com.baidu.tieba.lf5;
import com.baidu.tieba.lfa;
import com.baidu.tieba.li5;
import com.baidu.tieba.lo9;
import com.baidu.tieba.me5;
import com.baidu.tieba.mi5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.nm9;
import com.baidu.tieba.noa;
import com.baidu.tieba.nq9;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.pi9;
import com.baidu.tieba.po9;
import com.baidu.tieba.qd5;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.s45;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sr5;
import com.baidu.tieba.t45;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.uc5;
import com.baidu.tieba.uf5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.vfa;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.wp9;
import com.baidu.tieba.xr5;
import com.baidu.tieba.y35;
import com.baidu.tieba.yh9;
import com.baidu.tieba.yl9;
import com.baidu.tieba.zfa;
import com.baidu.tieba.zh5;
import com.baidu.tieba.zj5;
import com.baidu.tieba.zp9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes7.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements k16, VoiceManager.i, aq9, TbRichTextView.t, zp9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int V0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener A0;
    public LinearLayout B;
    public CustomMessageListener B0;
    public View C;
    public ak5 C0;
    public View D;
    public final NewWriteModel.d D0;
    public LinearLayout E;
    public View.OnClickListener E0;
    public ImageView F;
    public CustomMessageListener F0;
    public TextView G;
    public final h9 G0;
    public ImageView H;
    public View.OnTouchListener H0;
    public ImageView I;
    public final cy6.b I0;
    public ImageView J;
    public NewWriteModel.d J0;
    public nq9 K;
    public bk5 K0;
    public TextView L;
    public final View.OnClickListener L0;
    public String M;
    public View.OnClickListener M0;
    public boolean N;
    public final AdapterView.OnItemClickListener N0;
    public String O;
    public CustomMessageListener O0;
    public boolean P;
    public CustomMessageListener P0;
    public boolean Q;
    public CustomMessageListener Q0;
    public boolean R;
    public final ItemCardHelper.c R0;
    public boolean S;
    public CustomMessageListener S0;

    /* renamed from: T  reason: collision with root package name */
    public ReplyPrivacyCheckController f1158T;
    public final View.OnLongClickListener T0;
    public km9 U;
    public SortSwitchButton.f U0;
    public PermissionJudgePolicy V;
    public fk5 W;
    public ek5 X;
    public EditorTools Y;
    public fl9 Z;
    public AbsPbActivity a;
    public PbFakeFloorModel a0;
    public long b;
    public cy6 b0;
    public RelativeLayout c;
    public int[] c0;
    public CustomViewPager d;
    public int d0;
    public VideoPbFragmentAdapter e;
    public int e0;
    public View f;
    public int f0;
    public jn6 g;
    public int g0;
    public View h;
    public int h0;
    public View i;
    public boolean i0;
    public View j;
    @NonNull
    public TiePlusEventController.g j0;
    public MaskView k;
    public PbFallingView l;
    public boolean m;
    public View n;
    public fq9 o;
    public l95 p;
    public dw4 q;
    public me5 r;
    public final PbModel.h r0;
    public ForumManageModel s;
    public final dw4.a s0;
    public VoiceManager t;
    public ak5 t0;
    public ag<GifView> u;
    public final CustomMessageListener u0;
    public ag<TextView> v;
    public CustomMessageListener v0;
    public ag<ImageView> w;
    public final CustomMessageListener w0;
    public ag<View> x;
    public CustomMessageListener x0;
    public ag<LinearLayout> y;
    public HttpMessageListener y0;
    public ag<RelativeLayout> z;
    public CustomMessageListener z0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1317086303, "Lcom/baidu/tieba/pb/videopb/AbsVideoPbFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1317086303, "Lcom/baidu/tieba/pb/videopb/AbsVideoPbFragment;");
        }
    }

    public abstract int E3();

    @Override // com.baidu.tieba.k16
    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract int G3();

    @Override // com.baidu.tieba.zp9
    public void J1(boolean z2, int i2, int i3, int i4, yh9 yh9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), yh9Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // com.baidu.tieba.aq9
    public PbFragment M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final int O3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.aq9
    public AbsVideoPbFragment Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k16
    public ag<TiebaPlusRecommendCard> T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k16
    public ag<FestivalTipView> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k16
    public void e0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048652, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.k16
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public abstract boolean h4();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView q1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k16
    public void t1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048707, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k16
    public ag<ItemCardView> u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class e implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ e b;

            public a(e eVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (postWriteCallBackData = this.a) != null) {
                    this.b.a.p4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements s45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements s45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                    jo9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public e(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qd5Var, writeData, antiData}) == null) {
                if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.W() != null && this.a.W().s1() != null) {
                        statisticItem.param("fid", this.a.W().s1().l());
                    }
                    statisticItem.param("tid", this.a.W().M1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.V4();
                this.a.G4(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    ab5.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.W() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.W().A0(postWriteCallBackData.getPostId());
                        if (this.a.C3() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.g0 = absVideoPbFragment.C3().l2();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.h0 = absVideoPbFragment2.C3().m2();
                            this.a.W().R2(this.a.g0, this.a.h0);
                        }
                    }
                    if (this.a.d != null) {
                        this.a.d.setCurrentItem(0);
                    }
                    this.a.o.G();
                    this.a.U.c();
                    if (this.a.X != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.D4(absVideoPbFragment3.X.z());
                    }
                    this.a.W3();
                    this.a.N4(true);
                    this.a.W().X1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.M4(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && this.a.C3() != null) {
                            this.a.C3().u2();
                        }
                    } else if (this.a.W().V0()) {
                        yh9 s1 = this.a.W().s1();
                        if (s1 != null && s1.O() != null && s1.O().getAuthor() != null && (userId = s1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.W().j3()) {
                            this.a.I4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.W().j3()) {
                        this.a.I4();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    if (writeData != null) {
                        str2 = writeData.getContent();
                    }
                    absVideoPbFragment4.g3(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.X.y() || this.a.X.A()) {
                        this.a.X.w(false, postWriteCallBackData);
                    }
                    this.a.U.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.f1158T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    s45 s45Var = new s45(this.a.getActivity());
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        s45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        s45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new b(this));
                    s45Var.setPositiveButton(R.string.open_now, new c(this));
                    s45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (qd5Var != null || i == 227001) {
                } else {
                    this.a.L4(i, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ m b;

            public a(m mVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (postWriteCallBackData = this.a) != null) {
                    this.b.a.p4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements s45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements s45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public c(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                    jo9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public m(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qd5Var, writeData, antiData}) == null) {
                if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.W() != null && this.a.W().s1() != null) {
                        statisticItem.param("fid", this.a.W().s1().l());
                    }
                    if (this.a.W() != null) {
                        statisticItem.param("tid", this.a.W().M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    ab5.b(writeData.getContent(), "4");
                }
                if (z) {
                    km9 km9Var = this.a.U;
                    if (km9Var != null) {
                        km9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        uf5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.f1158T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    s45 s45Var = new s45(this.a.getActivity());
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        s45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        s45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new b(this));
                    s45Var.setPositiveButton(R.string.open_now, new c(this));
                    s45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    if (absVideoPbFragment.U != null) {
                        if (absVideoPbFragment.Z != null && this.a.Z.f() != null && this.a.Z.f().z()) {
                            this.a.Z.f().w(postWriteCallBackData);
                        }
                        this.a.U.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p0 a;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }

            public a(p0 p0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                km9 km9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (km9Var = this.a.c.U) != null && km9Var.g() != null) {
                    if (!this.a.c.U.g().e()) {
                        this.a.c.U.b(false);
                    }
                    this.a.c.U.g().l(false);
                }
            }
        }

        public p0(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int dimens;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    dimens = BdUtilHelper.getDimens(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = equipmentHeight / 2;
                    dimens = BdUtilHelper.getDimens(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = equipmentHeight - (i + dimens);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.c0[1] + absVideoPbFragment.d0) - i2;
                if (absVideoPbFragment.Q3() != null) {
                    this.c.Q3().smoothScrollBy(0, i3);
                }
                if (this.c.Z != null) {
                    this.c.X.a().setVisibility(8);
                    this.c.Z.t(this.a, this.b, this.c.R3(), (this.c.W() == null || this.c.W().s1() == null || this.c.W().s1().O() == null || !this.c.W().s1().O().isBjh()) ? false : false);
                    this.c.Z.q(this.c.E3());
                    hk5 f = this.c.Z.f();
                    if (f != null && this.c.W() != null && this.c.W().s1() != null) {
                        f.J(this.c.W().s1().c());
                        f.f0(this.c.W().s1().O());
                    }
                    if (this.c.U.f() == null && this.c.Z.f().u() != null) {
                        this.c.Z.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.U.n(absVideoPbFragment2.Z.f().u().i());
                        this.c.Z.f().P(this.c.C0);
                    }
                }
                this.c.U3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q0 a;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }

            public a(q0 q0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = q0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                km9 km9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (km9Var = this.a.c.U) != null && km9Var.g() != null) {
                    if (!this.a.c.U.g().e()) {
                        this.a.c.U.b(false);
                    }
                    this.a.c.U.g().l(false);
                }
            }
        }

        public q0(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int dimens;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    dimens = BdUtilHelper.getDimens(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = equipmentHeight / 2;
                    dimens = BdUtilHelper.getDimens(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = equipmentHeight - (i + dimens);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.c0[1] + absVideoPbFragment.d0) - i2;
                if (absVideoPbFragment.Q3() != null) {
                    this.c.Q3().smoothScrollBy(0, i3);
                }
                if (this.c.Z != null) {
                    this.c.X.a().setVisibility(8);
                    this.c.Z.t(this.a, this.b, this.c.R3(), (this.c.W() == null || this.c.W().s1() == null || this.c.W().s1().O() == null || !this.c.W().s1().O().isBjh()) ? false : false);
                    this.c.Z.q(this.c.E3());
                    hk5 f = this.c.Z.f();
                    if (f != null && this.c.W() != null && this.c.W().s1() != null) {
                        f.J(this.c.W().s1().c());
                        f.f0(this.c.W().s1().O());
                    }
                    if (this.c.U.f() == null && this.c.Z.f().u() != null) {
                        this.c.Z.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.U.n(absVideoPbFragment2.Z.f().u().i());
                        this.c.Z.f().P(this.c.C0);
                    }
                }
                this.c.U3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof noa) && customResponsedMessage.getOrginalMessage().getTag() == this.a.o.D) {
                noa noaVar = (noa) customResponsedMessage.getData();
                this.a.o.W();
                SparseArray<Object> sparseArray = (SparseArray) this.a.o.P();
                DataRes dataRes = noaVar.a;
                boolean z = false;
                if (noaVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (di.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    this.a.o.z0(z, sparseArray);
                } else if (intValue == 1) {
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.o.j0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof View)) {
                return;
            }
            ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.c);
        }
    }

    /* loaded from: classes7.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                gg9 gg9Var = (gg9) customResponsedMessage.getData();
                int type = gg9Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (gg9Var.a() == null) {
                                this.a.u4(false, null);
                                return;
                            } else {
                                this.a.u4(true, (MarkData) gg9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.v3((ForumManageModel.b) gg9Var.a(), false);
                    return;
                }
                this.a.v4((pi9) gg9Var.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                fq9 fq9Var = this.a.o;
                if (tag == fq9Var.D) {
                    fq9Var.W();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    yh9 s1 = this.a.W().s1();
                    if (s1 != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.setUserId(str);
                        s1.v().add(muteUser);
                    }
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.mute_success));
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                        String errorString = userMuteAddResponseMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            errorString = this.a.getResources().getString(R.string.mute_error_beyond_limit);
                        }
                        this.a.o.E0(errorString);
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                        this.a.o.y0();
                    } else {
                        String errorString2 = userMuteAddResponseMessage.getErrorString();
                        if (di.isEmpty(errorString2)) {
                            errorString2 = this.a.getResources().getString(R.string.mute_fail);
                        }
                        this.a.p.c(errorString2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public b0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.c, 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.c, j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.i0) {
                return;
            }
            this.a.S4();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                fq9 fq9Var = this.a.o;
                if (tag == fq9Var.D) {
                    fq9Var.W();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (di.isEmpty(muteMessage)) {
                        muteMessage = this.a.getResources().getString(R.string.un_mute_fail);
                    }
                    this.a.p.c(muteMessage);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public c0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.Q4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l.setTag(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof CustomResponsedMessage) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            this.a.Z4();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ak5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public d(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.ak5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                km9 km9Var = this.a.U;
                if (km9Var != null && km9Var.g() != null && this.a.U.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.U.g().c());
                    if (this.a.Z != null && this.a.Z.f() != null && this.a.Z.f().z()) {
                        this.a.Z.f().w(this.a.U.h());
                    }
                    this.a.U.b(true);
                    return true;
                }
                return !this.a.m3(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public d0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                if (absVideoPbFragment.f1158T != null && absVideoPbFragment.W() != null && this.a.W().s1() != null && this.a.W().s1().c() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.f1158T.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.W().s1().c().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.X.o0();
                this.a.t3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(AbsVideoPbFragment absVideoPbFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.getView() != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.hideLoadingView(absVideoPbFragment.getView());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage == null || !(httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    return;
                }
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                if (!TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                    return;
                }
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.getString(R.string.block_user_success)).show((ViewGroup) this.a.getView());
                    this.a.J4(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e29);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public e0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                return;
            }
            this.a.r4();
            if (this.a.W() != null && this.a.W().s1() != null && this.a.W().s1().O() != null && this.a.W().s1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.W().N1()).param("fid", this.a.W().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.W().M1()).param("fid", this.a.W().s1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.a.W().getForumId());
                statisticItem.param("tid", this.a.W().M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.F3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 11);
                statisticItem.param("obj_locate", this.a.E3());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public f(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.O);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ViewGroup.LayoutParams layoutParams = this.a.B.getLayoutParams();
                layoutParams.height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144);
                this.a.B.setLayoutParams(layoutParams);
                this.a.w4();
                if (this.a.C3() != null) {
                    this.a.C3().u2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.X != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.D4(absVideoPbFragment.X.z());
            }
            this.a.N4(false);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements dw4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public g0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.dw4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.H4();
                if (z && this.a.W() != null) {
                    if (this.a.q != null) {
                        this.a.q.h(z2);
                        this.a.z4(z2);
                    }
                    this.a.W().i3(z2);
                    if (this.a.W().s1() != null && (O = this.a.W().s1().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (!this.a.W().d1()) {
                        if (this.a.C3() != null) {
                            this.a.C3().u2();
                        }
                    } else {
                        this.a.k4();
                    }
                    if (z2) {
                        if (this.a.q != null) {
                            if (this.a.q.f() != null && this.a.W() != null && this.a.W().s1() != null && this.a.W().s1().O() != null && this.a.W().s1().O().getAuthor() != null) {
                                MarkData f = this.a.q.f();
                                MetaData author = this.a.W().s1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                        this.a.o.v0(author);
                                    } else {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
                                    }
                                } else {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.f3();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public h(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.W() != null) {
                    switch (this.a.s.getLoadDataMode()) {
                        case 0:
                            this.a.W().X1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.v3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.w3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.x3(absVideoPbFragment.s.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.w3(absVideoPbFragment2.s.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.o.e0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.w3(absVideoPbFragment3.s.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public h0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.w4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public i(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.b0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public i0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(zfa zfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zfaVar) == null) {
                this.a.a0.e0(zfaVar);
                if (this.a.C3() != null) {
                    this.a.C3().u2();
                }
                this.a.Z.g();
                this.a.Y.t();
                this.a.N4(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements cy6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public j(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.cy6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ej9.d();
                } else {
                    ej9.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public j0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.o.n0(true);
                return this.a.o.Q().onLongClick(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements TiePlusEventController.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public k(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.g
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public final int b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (i == 2) {
                    return 1;
                }
                if (i == 0) {
                    return 2;
                }
                return i == 1 ? 3 : 0;
            }
            return invokeI.intValue;
        }

        public k0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                fq9 fq9Var = this.a.o;
                if (fq9Var != null) {
                    fq9Var.G();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.W() != null && !this.a.W().isLoading) {
                    this.a.V4();
                    this.a.I4();
                    z = true;
                    if (this.a.W().s1() != null && this.a.W().s1().f != null && this.a.W().s1().f.size() > i) {
                        int intValue = this.a.W().s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.W().N1()).param("fid", this.a.W().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.W().m3(intValue)) {
                            this.a.m = true;
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public l(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) && s45Var != null) {
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public l0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public m0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.w4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ s45 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public n(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = absVideoPbFragment;
            this.a = markData;
            this.b = markData2;
            this.c = s45Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
                if (this.d.q != null) {
                    if (this.d.q.e()) {
                        this.d.q.d();
                        this.d.q.h(false);
                    }
                    this.d.q.i(this.a);
                    this.d.q.h(true);
                    this.d.q.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.W4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements ai5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public n0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.ai5
        public void E(zh5 zh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zh5Var) == null) {
                Object obj = zh5Var.c;
                if ((obj instanceof uc5) && EmotionGroupType.isSendAsPic(((uc5) obj).getType())) {
                    if (this.a.V == null) {
                        this.a.V = new PermissionJudgePolicy();
                    }
                    this.a.V.clearRequestPermissionList();
                    this.a.V.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.V.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.X.f((uc5) zh5Var.c);
                    this.a.X.w(false, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ s45 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public o(AbsVideoPbFragment absVideoPbFragment, MarkData markData, s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = markData;
            this.b = s45Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.W4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public o0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            km9 km9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (km9Var = this.a.U) != null && km9Var.e() != null) {
                if (!this.a.U.e().e()) {
                    this.a.U.a(false);
                }
                this.a.U.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.Y == null || this.a.Y.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public p(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements bk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public q(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.bk5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i;
            String str;
            int i2;
            int i3;
            String jumpUrlWithTid;
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b05) {
                    if (this.a.W() != null) {
                        this.a.W().r2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.W().M1());
                    statisticItem2.param("fid", this.a.W().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", this.a.W().getForumId());
                    statisticItem3.param("tid", this.a.W().M1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", this.a.F3());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 3);
                    statisticItem3.param("obj_locate", this.a.E3());
                    TiebaStatic.log(statisticItem3);
                    if (!this.a.A) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof zfa) {
                                zfa zfaVar = (zfa) obj;
                                if (this.a.W() == null || this.a.W().s1() == null || this.a.a0 == null || zfaVar.r() == null || zfaVar.I() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.Z != null) {
                                    this.a.Z.g();
                                }
                                pi9 pi9Var = new pi9();
                                pi9Var.v(this.a.W().s1().k());
                                pi9Var.z(this.a.W().s1().O());
                                pi9Var.x(zfaVar);
                                this.a.a0.j0(pi9Var);
                                this.a.a0.setPostId(zfaVar.S());
                                this.a.j4(view2, zfaVar.r().getUserId(), "", zfaVar);
                                TiebaStatic.log("c11743");
                                wp9.b(this.a.W().s1(), zfaVar, zfaVar.e0, 8, 1);
                                if (this.a.X != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.D4(absVideoPbFragment.X.z());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.A = false;
                } else {
                    if (view2.getId() == R.id.pb_video_more && this.a.getPageContext().getPageActivity() != null && this.a.W() != null && this.a.a != null && this.a.a.getIntent() != null) {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.W().M1(), false, true);
                            this.a.C4(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.W().M1(), true, false);
                            this.a.C4(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.W().getForumId());
                        statisticItem4.param("fname", this.a.W().R0());
                        statisticItem4.param("tid", this.a.W().M1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.C3() == null || this.a.C3().p2() == null || view2 != this.a.C3().p2()) && view2.getId() != R.id.pb_more) {
                        fq9 fq9Var = this.a.o;
                        if (fq9Var != null && fq9Var.R() != null && view2 == this.a.o.R().y()) {
                            this.a.o.J();
                            return;
                        }
                        fq9 fq9Var2 = this.a.o;
                        if ((fq9Var2 == null || fq9Var2.R() == null || view2 != this.a.o.R().E()) && view2.getId() != R.id.obfuscated_res_0x7f090b80 && view2.getId() != R.id.obfuscated_res_0x7f091f01) {
                            if (this.a.o.R() != null && view2 == this.a.o.R().G()) {
                                if (this.a.W() == null) {
                                    return;
                                }
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.V4();
                                this.a.I4();
                                this.a.W().g3(1);
                                return;
                            }
                            fq9 fq9Var3 = this.a.o;
                            if (fq9Var3 != null && fq9Var3.R() != null && view2 == this.a.o.R().E()) {
                                this.a.o.J();
                                return;
                            }
                            fq9 fq9Var4 = this.a.o;
                            if (fq9Var4 != null && ((fq9Var4.R() != null && view2 == this.a.o.R().M()) || view2.getId() == R.id.obfuscated_res_0x7f091b47)) {
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                } else if (this.a.m) {
                                    view2.setTag(Integer.valueOf(this.a.W().J1()));
                                    return;
                                } else {
                                    this.a.V4();
                                    this.a.I4();
                                    this.a.o.D0(view2);
                                    return;
                                }
                            }
                            fq9 fq9Var5 = this.a.o;
                            if (fq9Var5 != null && fq9Var5.R() != null && view2 == this.a.o.R().L()) {
                                if (this.a.W() == null || this.a.W().s1() == null || this.a.W().s1().O() == null) {
                                    return;
                                }
                                this.a.o.J();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment2 = this.a;
                                absVideoPbFragment2.o.V(absVideoPbFragment2.W().s1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091acc) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                fq9 fq9Var6 = this.a.o;
                                if (fq9Var6 != null) {
                                    fq9Var6.u0(sparseArray);
                                }
                            } else {
                                fq9 fq9Var7 = this.a.o;
                                if (fq9Var7 != null && fq9Var7.R() != null && view2 == this.a.o.R().J()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                    this.a.onChangeSkinType(skinType);
                                    UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                    if (skinType == 0) {
                                        TbadkCoreApplication.getInst().setSkinType(4);
                                    } else {
                                        SharedPrefHelper.getInstance().putBoolean("key_is_follow_system_mode", false);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                    }
                                    this.a.o.K();
                                    return;
                                }
                                fq9 fq9Var8 = this.a.o;
                                if (fq9Var8 != null && fq9Var8.R() != null && view2 == this.a.o.R().K()) {
                                    this.a.o.K();
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.o.B0(absVideoPbFragment3.N0);
                                    return;
                                }
                                fq9 fq9Var9 = this.a.o;
                                if (fq9Var9 != null && fq9Var9.R() != null && view2 == this.a.o.R().D()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.W().M1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.o.J();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                fq9 fq9Var10 = this.a.o;
                                if (fq9Var10 != null && (view2 == fq9Var10.N() || (this.a.o.R() != null && (view2 == this.a.o.R().H() || view2 == this.a.o.R().I())))) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.W() == null || this.a.W().s1() == null || this.a.s.g0()) {
                                        return;
                                    } else {
                                        this.a.o.G();
                                        if (this.a.o.R() != null && view2 == this.a.o.R().I()) {
                                            i3 = this.a.W().s1().O().getIs_top() == 1 ? 5 : 4;
                                        } else if (this.a.o.R() != null && view2 == this.a.o.R().H()) {
                                            i3 = this.a.W().s1().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i3 = view2 == this.a.o.N() ? 2 : 0;
                                        }
                                        ForumData k = this.a.W().s1().k();
                                        String name = k.getName();
                                        String id = k.getId();
                                        String id2 = this.a.W().s1().O().getId();
                                        this.a.showProgressBar();
                                        this.a.s.k0(id, name, id2, i3, this.a.o.O());
                                        return;
                                    }
                                }
                                fq9 fq9Var11 = this.a.o;
                                if (fq9Var11 != null && fq9Var11.R() != null && view2 == this.a.o.R().A()) {
                                    if (this.a.W() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.a.o.G();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    SparseArray<Object> J3 = absVideoPbFragment4.J3(absVideoPbFragment4.W().s1(), this.a.W().L1(), 1);
                                    if (J3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.W().s1().k().getId(), this.a.W().s1().k().getName(), this.a.W().s1().O().getId(), String.valueOf(this.a.W().s1().V().getUserId()), (String) J3.get(R.id.tag_forbid_user_name), (String) J3.get(R.id.tag_forbid_user_name_show), (String) J3.get(R.id.tag_forbid_user_post_id), (String) J3.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                fq9 fq9Var12 = this.a.o;
                                if (fq9Var12 != null && fq9Var12.R() != null && view2 == this.a.o.R().u()) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> J32 = absVideoPbFragment5.J3(absVideoPbFragment5.W().s1(), this.a.W().L1(), 1);
                                    if (J32 != null) {
                                        this.a.o.i0(((Integer) J32.get(R.id.tag_del_post_type)).intValue(), (String) J32.get(R.id.tag_del_post_id), ((Integer) J32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) J32.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.a.o.J();
                                    if (this.a.W() == null || this.a.W().s1() == null || this.a.W().s1().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.W().s1().O();
                                    StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem5.param("tid", O.getId());
                                    statisticItem5.param("fid", O.getFid());
                                    statisticItem5.param("fname", O.getForum_name());
                                    TiebaStatic.log(statisticItem5);
                                    StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem6.param("tid", O.getId());
                                    statisticItem6.param("fid", O.getFid());
                                    statisticItem6.param("fname", O.getForum_name());
                                    statisticItem6.param("obj_source", 3);
                                    TiebaStatic.log(statisticItem6);
                                    return;
                                }
                                fq9 fq9Var13 = this.a.o;
                                if (fq9Var13 != null && fq9Var13.R() != null && view2 == this.a.o.R().z()) {
                                    if (this.a.W() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> J33 = absVideoPbFragment6.J3(absVideoPbFragment6.W().s1(), this.a.W().L1(), 1);
                                    if (J33 != null) {
                                        if (StringUtils.isNull((String) J33.get(R.id.tag_del_multi_forum))) {
                                            this.a.o.f0(((Integer) J33.get(R.id.tag_del_post_type)).intValue(), (String) J33.get(R.id.tag_del_post_id), ((Integer) J33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) J33.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.a.o.g0(((Integer) J33.get(R.id.tag_del_post_type)).intValue(), (String) J33.get(R.id.tag_del_post_id), ((Integer) J33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) J33.get(R.id.tag_del_post_is_self)).booleanValue(), (String) J33.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.a.o.J();
                                } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0922f7 && view2.getId() != R.id.obfuscated_res_0x7f091ace && view2.getId() != R.id.obfuscated_res_0x7f091946 && view2.getId() != R.id.obfuscated_res_0x7f091b39) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b37 && view2.getId() != R.id.obfuscated_res_0x7f091d1b && view2.getId() != R.id.obfuscated_res_0x7f091ac8) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ab5 && view2.getId() != R.id.collect_num_container) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091aba && view2.getId() != R.id.share_more_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091ab7 && view2.getId() != R.id.thread_info_commont_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f09277b) {
                                                        if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                            if (this.a.W() == null) {
                                                                return;
                                                            }
                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                            statisticItem7.param("tid", this.a.W().M1());
                                                            statisticItem7.param("fid", this.a.W().getForumId());
                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem7.param("obj_locate", 2);
                                                            TiebaStatic.log(statisticItem7);
                                                            return;
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091afc && view2.getId() != R.id.obfuscated_res_0x7f091ac2) {
                                                            if (view2.getId() == R.id.obfuscated_res_0x7f091260) {
                                                                this.a.w4();
                                                                return;
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f090874 && view2.getId() != R.id.obfuscated_res_0x7f090b7d) {
                                                                if (this.a.o.R() != null && view2 == this.a.o.R().x()) {
                                                                    this.a.o.G();
                                                                    if (this.a.W() != null) {
                                                                        this.a.g.f(this.a.W().M1());
                                                                    }
                                                                    if (this.a.W() != null && this.a.W().isPrivacy()) {
                                                                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                        if (this.a.W().s1() != null) {
                                                                            this.a.g.d(3, 3, this.a.W().s1().Q());
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    this.a.g.b();
                                                                    int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.W() == null || this.a.W().s1() == null || this.a.W().s1().Q() == null || !this.a.W().s1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                    if (this.a.W() == null || this.a.W().s1() == null) {
                                                                        return;
                                                                    }
                                                                    this.a.g.d(3, i5, this.a.W().s1().Q());
                                                                    return;
                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091ad0 || view2.getId() == R.id.obfuscated_res_0x7f091b31) {
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.W().M1());
                                                                    statisticItem8.param("fid", this.a.W().getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    StatisticItem statisticItem9 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                    statisticItem9.param("fid", this.a.W().getForumId());
                                                                    statisticItem9.param("tid", this.a.W().M1());
                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem9.param("post_id", this.a.F3());
                                                                    statisticItem9.param("obj_source", 1);
                                                                    statisticItem9.param("obj_type", 2);
                                                                    statisticItem9.param("obj_locate", this.a.E3());
                                                                    TiebaStatic.log(statisticItem9);
                                                                    this.a.o.n0(false);
                                                                    this.a.o.Q().onLongClick(view2);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof zfa)) {
                                                                    return;
                                                                }
                                                                zfa zfaVar2 = (zfa) sparseArray2.get(R.id.tag_load_sub_data);
                                                                View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                if (zfaVar2 == null || view3 == null) {
                                                                    return;
                                                                }
                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090875);
                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090876);
                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b7d);
                                                                if (zfaVar2.C0()) {
                                                                    zfaVar2.f1(false);
                                                                    po9.e(zfaVar2);
                                                                } else {
                                                                    if (this.a.W() != null ? po9.c(this.a.W().s1(), zfaVar2) : false) {
                                                                        zfaVar2.f1(true);
                                                                        findViewById.setVisibility(0);
                                                                    }
                                                                }
                                                                SkinManager.setBackgroundColor(findViewById, zfaVar2.C0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                SkinManager.setViewTextColor(eMTextView, zfaVar2.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                WebPManager.setPureDrawable(imageView, zfaVar2.C0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, zfaVar2.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                return;
                                                            }
                                                        } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                BrowserHelper.startWebActivity(view2.getContext(), string, string2, true, true, true);
                                                            }
                                                            this.a.w4();
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (this.a.g0 >= 0) {
                                                        if (this.a.W() != null) {
                                                            this.a.W().N2();
                                                        }
                                                        if (this.a.C3() != null && this.a.C3().U1() != null) {
                                                            this.a.C3().U1().s(this.a.W().s1());
                                                        }
                                                        this.a.g0 = 0;
                                                        this.a.h0 = Integer.MIN_VALUE;
                                                        if (this.a.W() == null || this.a.C3() == null) {
                                                            return;
                                                        }
                                                        this.a.C3().B2(this.a.W().l1(), this.a.W().k1());
                                                        this.a.W().R2(0, 0);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.W() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                                    if (absVideoPbFragment7.o == null || absVideoPbFragment7.d == null || this.a.W().s1() == null || this.a.W().s1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    yh9 s1 = this.a.W().s1();
                                                    if (s1.O().getReply_num() == 0) {
                                                        this.a.r4();
                                                        return;
                                                    } else if (this.a.C3() == null || this.a.Q3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.W().M1()).param("fid", this.a.W().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView Q3 = this.a.Q3();
                                                        if (Q3 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = Q3.canScrollVertically(1);
                                                        boolean canScrollVertically2 = Q3.canScrollVertically(-1);
                                                        if (Q3.getLayoutManager() == null || !(Q3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) Q3.getLayoutManager();
                                                        if (canScrollVertically2 || !canScrollVertically) {
                                                            str = "obj_source";
                                                            int firstVisiblePosition = Q3.getFirstVisiblePosition();
                                                            View childAt = Q3.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.e0 = firstVisiblePosition;
                                                            this.a.f0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-equipmentHeight) || Q3.getCount() < 6)) {
                                                                Q3.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                Q3.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        } else if (this.a.e0 == -1 && this.a.f0 == Integer.MIN_VALUE) {
                                                            return;
                                                        } else {
                                                            if (this.a.e0 > 3 || (this.a.e0 == 3 && this.a.f0 < (-equipmentHeight))) {
                                                                str = "obj_source";
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + equipmentHeight);
                                                                Q3.smoothScrollBy(0, equipmentHeight);
                                                            } else if (this.a.e0 >= 2) {
                                                                str = "obj_source";
                                                                int i6 = equipmentHeight / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + i6);
                                                                Q3.smoothScrollBy(0, i6);
                                                            } else {
                                                                str = "obj_source";
                                                                if (this.a.e0 == 1) {
                                                                    int i7 = equipmentHeight / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + i7);
                                                                    Q3.smoothScrollBy(0, i7);
                                                                } else {
                                                                    Q3.smoothScrollBy(0, -this.a.f0);
                                                                }
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        }
                                                        TiebaStatic.log(param);
                                                        sr5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem10 = new StatisticItem("c12942");
                                                        statisticItem10.param("obj_type", i2);
                                                        statisticItem10.param("obj_locate", 4);
                                                        statisticItem10.param("tid", this.a.W().M1());
                                                        statisticItem10.param("nid", s1.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem10);
                                                        if (this.a.W() == null || this.a.W().s1() == null || this.a.W().s1().O() == null || this.a.W().s1().O().getAuthor() == null) {
                                                            return;
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.W().M1()).param("fid", this.a.W().s1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem11.param("fid", this.a.W().getForumId());
                                                        statisticItem11.param("tid", this.a.W().M1());
                                                        statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem11.param("post_id", this.a.F3());
                                                        statisticItem11.param(str, 1);
                                                        statisticItem11.param("obj_type", 12);
                                                        statisticItem11.param("obj_locate", this.a.E3());
                                                        TiebaStatic.log(statisticItem11);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            this.a.T3(true);
                                        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                        } else {
                                            AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                            if (absVideoPbFragment8.o == null || absVideoPbFragment8.W() == null || this.a.C3() == null) {
                                                return;
                                            }
                                            this.a.o.G();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ab5 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.k3(11009) || this.a.W() == null) {
                                                    return;
                                                }
                                                this.a.l4();
                                                if (this.a.W().s1() != null && this.a.W().s1().O() != null && this.a.W().s1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.W().M1()).param("fid", this.a.W().s1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                    StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem12.param("fid", this.a.W().getForumId());
                                                    statisticItem12.param("tid", this.a.W().M1());
                                                    statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem12.param("post_id", this.a.F3());
                                                    statisticItem12.param("obj_source", 1);
                                                    statisticItem12.param("obj_type", 13);
                                                    statisticItem12.param("obj_locate", this.a.E3());
                                                    TiebaStatic.log(statisticItem12);
                                                }
                                                if (this.a.W().s1().O() == null || this.a.W().s1().O().getAuthor() == null || this.a.W().s1().O().getAuthor().getUserId() == null || this.a.q == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                                int T2 = absVideoPbFragment9.o.T(absVideoPbFragment9.W().s1());
                                                ThreadData O2 = this.a.W().s1().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.W().M1()).param("obj_locate", 1).param("obj_id", this.a.W().s1().O().getAuthor().getUserId()).param("obj_type", !this.a.q.e()).param("obj_source", T2).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.j = view2;
                                        }
                                    } else if (this.a.W() == null) {
                                    } else {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091b37) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.W().M1());
                                            statisticItem13.param("fid", this.a.W().getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091d1b) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.i = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b37 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.i = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof zfa) {
                                                zfa zfaVar3 = (zfa) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091b37 && (statisticItem = zfaVar3.f0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d1b || view2.getId() == R.id.obfuscated_res_0x7f091ac8) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.W().N1()).param("fid", this.a.W().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", zfaVar3.S()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.a.W() == null || this.a.W().s1() == null || this.a.a0 == null || zfaVar3.r() == null || zfaVar3.I() == 1) {
                                                    return;
                                                }
                                                if (this.a.Z != null) {
                                                    this.a.Z.g();
                                                }
                                                pi9 pi9Var2 = new pi9();
                                                pi9Var2.v(this.a.W().s1().k());
                                                pi9Var2.z(this.a.W().s1().O());
                                                pi9Var2.x(zfaVar3);
                                                this.a.a0.j0(pi9Var2);
                                                this.a.a0.setPostId(zfaVar3.S());
                                                this.a.j4(view2, zfaVar3.r().getUserId(), "", zfaVar3);
                                                if (this.a.X != null) {
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                    absVideoPbFragment10.D4(absVideoPbFragment10.X.z());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091946) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.W().M1());
                                        statisticItem14.param("fid", this.a.W().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem14);
                                        StatisticItem statisticItem15 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem15.param("fid", this.a.W().getForumId());
                                        statisticItem15.param("tid", this.a.W().M1());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("post_id", this.a.F3());
                                        statisticItem15.param("obj_source", 1);
                                        statisticItem15.param("obj_type", 8);
                                        statisticItem15.param("obj_locate", this.a.E3());
                                        TiebaStatic.log(statisticItem15);
                                    }
                                    if ((view2.getId() != R.id.obfuscated_res_0x7f091ace && view2.getId() != R.id.obfuscated_res_0x7f091b39) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091ace) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.W().getForumId());
                                            statisticItem16.param("tid", this.a.W().M1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param("post_id", this.a.F3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 9);
                                            statisticItem16.param("obj_locate", this.a.E3());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                        if (!this.a.checkUpIsLogin()) {
                                            wp9.v("c10517", this.a.W().s1().l(), 3);
                                            return;
                                        } else if (this.a.W() == null || this.a.W().s1() == null) {
                                            return;
                                        } else {
                                            fq9 fq9Var14 = this.a.o;
                                            if (fq9Var14 != null) {
                                                fq9Var14.G();
                                            }
                                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                            zfa zfaVar4 = (zfa) sparseArray4.get(R.id.tag_load_sub_data);
                                            zfa zfaVar5 = (zfa) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                            if (zfaVar4 == null) {
                                                return;
                                            }
                                            if (zfaVar4.N() == 1) {
                                                TiebaStatic.log(new StatisticItem("c12630"));
                                            }
                                            StatisticItem statisticItem17 = zfaVar4.f0;
                                            if (statisticItem17 != null) {
                                                StatisticItem copy2 = statisticItem17.copy();
                                                copy2.delete("obj_locate");
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091946) {
                                                    copy2.param("obj_locate", 6);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091ace) {
                                                    copy2.param("obj_locate", 8);
                                                }
                                                TiebaStatic.log(copy2);
                                            }
                                            this.a.V4();
                                            TiebaStatic.log("c11742");
                                            if (zfaVar5 != null) {
                                                this.a.T4(zfaVar4, zfaVar5, false, true);
                                                return;
                                            } else {
                                                this.a.T4(zfaVar4, null, false, false);
                                                return;
                                            }
                                        }
                                    }
                                    this.a.h = view2;
                                }
                            }
                        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                        } else {
                            this.a.o.G();
                            if (this.a.m) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.V4();
                            this.a.I4();
                            boolean k3 = this.a.W().k3(this.a.F3());
                            view2.setTag(Boolean.valueOf(k3));
                            if (k3) {
                                this.a.P4();
                                i4 = 1;
                                this.a.m = true;
                            } else {
                                i4 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                        }
                    } else if (!this.a.m && this.a.W().p2(true)) {
                        this.a.m = true;
                        if (this.a.C3() != null) {
                            this.a.C3().G2();
                        }
                    }
                }
            }
        }

        public r(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements ak5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public r0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.ak5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                km9 km9Var = this.a.U;
                if (km9Var != null && km9Var.e() != null && this.a.U.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.U.e().c());
                    if (this.a.X != null && (this.a.X.y() || this.a.X.A())) {
                        this.a.X.w(false, this.a.U.h());
                    }
                    this.a.U.a(true);
                    return true;
                }
                return !this.a.m3(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s extends bx5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public s(AbsVideoPbFragment absVideoPbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absVideoPbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bx5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel W = this.b.W();
                if (W != null) {
                    W.U2(this.a);
                }
                return lo9.c(this.b.B3(), 2, W);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements bg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public s0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (h05.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = h05.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t implements gw5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public t(AbsVideoPbFragment absVideoPbFragment, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gw5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.setStats(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements bg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public t0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.m();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.p();
                gifView.m();
                gifView.setImageDrawable(null);
                gifView.q();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (h05.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = h05.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public u(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            } else {
                z3 = false;
            }
            fq9 fq9Var = this.a.o;
            if (fq9Var != null) {
                if (z) {
                    if (z2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.a.o.C(sparseArray);
                        return;
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.o.k0(view2);
                } else if (z2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.a.o.C(sparseArray);
                } else if (z3) {
                    fq9Var.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements bg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public u0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).l();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).k();
            }
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).k();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.G0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class v implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yh9Var) == null) {
            }
        }

        public v(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, yh9 yh9Var, String str, int i4) {
            String R3;
            hi5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), yh9Var, str, Integer.valueOf(i4)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907b5));
                }
                this.a.H4();
                this.a.Y3();
                if (this.a.m) {
                    this.a.m = false;
                }
                this.a.N4(false);
                if (z && yh9Var != null) {
                    ThreadData O = yh9Var.O();
                    this.a.q4(yh9Var);
                    this.a.s4(z, i, i2, i3, yh9Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(yh9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(yh9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(yh9Var.V().getBimg_end_time());
                    if (yh9Var.F() != null && yh9Var.F().size() >= 1 && yh9Var.F().get(0) != null) {
                        this.a.W().S2(yh9Var.F().get(0).S());
                    } else if (yh9Var.Y() != null) {
                        this.a.W().S2(yh9Var.Y().S());
                    }
                    if (this.a.q != null) {
                        this.a.q.h(yh9Var.q());
                    }
                    AntiData c = yh9Var.c();
                    if (c != null) {
                        this.a.O = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.O) && this.a.X != null && this.a.X.a() != null && (o = this.a.X.a().o(6)) != null && !TextUtils.isEmpty(this.a.O)) {
                            ((View) o).setOnClickListener(this.a.E0);
                        }
                    }
                    if (this.a.f1158T != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.f1158T.setLikeUserData(attentionHostData);
                    }
                    if (this.a.W() != null && this.a.W().c2()) {
                        R3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        R3 = this.a.R3();
                    }
                    if (!StringUtils.isNull(R3)) {
                        this.a.X.d0(TbSingleton.getInstance().getAdVertiComment(yh9Var.q0(), yh9Var.r0(), R3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.W().M1());
                            jSONObject.put("fid", this.a.W().getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        dt6.b().b(new ae5(this.a.W().M1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (this.a.C3() == null) {
                        return;
                    }
                    if (i != -1) {
                        ArrayList<zfa> arrayList = null;
                        if (this.a.W() != null && this.a.W().s1() != null) {
                            arrayList = this.a.W().s1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).I() != 1)) {
                            this.a.C3().D2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else if (this.a.C3().v2()) {
                            this.a.C3().E2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fee));
                        } else {
                            this.a.C3().E2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fef));
                        }
                    } else {
                        this.a.C3().D2("");
                    }
                    this.a.C3().i2();
                }
                cea.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements bg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        public v0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.pb_text_voice_layout);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setGravity(16);
                linearLayout.setBaselineAligned(true);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                return linearLayout;
            }
            return (LinearLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class w implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public w(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.W() != null && this.a.W().C1() != i + 1) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.A4(absVideoPbFragment.O3(i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements bg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        public w0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new RelativeLayout(this.a.getPageContext().getPageActivity());
            }
            return (RelativeLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h16.a)) {
                h16.a aVar = (h16.a) customResponsedMessage.getData();
                h16.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements Comparator<AdverSegmentData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public x0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AdverSegmentData adverSegmentData, AdverSegmentData adverSegmentData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, adverSegmentData, adverSegmentData2)) == null) {
                return adverSegmentData.compareTo(adverSegmentData2);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeMessageData agreeMessageData;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && (agreeMessageData = (AgreeMessageData) customResponsedMessage.getData()) != null && (agreeData = agreeMessageData.agreeData) != null && agreeData.agreeType == 2 && this.a.K != null && this.a.W() != null && !lo9.h(this.a.W().M1())) {
                this.a.K.n(2);
                lo9.b(this.a.W().M1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public y0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String R3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.W() != null && this.a.W().c2()) {
                    R3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    R3 = this.a.R3();
                }
                if (!StringUtils.isNull(R3) && this.a.W() != null && this.a.W().s1() != null) {
                    R3 = TbSingleton.getInstance().getAdVertiComment(this.a.W().s1().q0(), this.a.W().s1().r0(), R3);
                }
                if (this.a.X != null) {
                    this.a.X.d0(R3);
                }
                if (this.a.G != null) {
                    this.a.G.setText(R3);
                }
                this.a.N4(false);
                this.a.Q4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public z(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.X.H(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.Z != null && this.a.Z.f() != null) {
                    this.a.Z.f().I();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.W() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.X != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.D4(absVideoPbFragment.X.z());
                }
                this.a.w4();
                this.a.o.G();
            }
        }
    }

    public AbsVideoPbFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.m = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.A = false;
        this.D = null;
        this.G = null;
        this.N = false;
        this.O = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.c0 = new int[2];
        this.e0 = -1;
        this.f0 = Integer.MIN_VALUE;
        this.g0 = 0;
        this.h0 = Integer.MIN_VALUE;
        this.i0 = false;
        this.j0 = new k(this);
        this.r0 = new v(this);
        this.s0 = new g0(this);
        this.t0 = new r0(this);
        this.u0 = new z0(this, 2004016);
        this.v0 = new a1(this, 2004007);
        this.w0 = new b1(this, 2921391);
        this.x0 = new c1(this, 2016450);
        this.y0 = new d1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.z0 = new a(this, 2001426);
        this.A0 = new b(this, 2001427);
        this.B0 = new c(this, 2001428);
        this.C0 = new d(this);
        this.D0 = new e(this);
        this.E0 = new f(this);
        this.F0 = new g(this, 2004008);
        this.G0 = new h(this);
        this.H0 = new i(this);
        this.I0 = new j(this);
        this.J0 = new m(this);
        this.K0 = new q(this);
        this.L0 = new r(this);
        this.M0 = new u(this);
        this.N0 = new w(this);
        this.O0 = new x(this, 2001332);
        this.P0 = new y(this, 2016528);
        this.Q0 = new a0(this, 2001440);
        this.R0 = new b0(this);
        this.S0 = new f0(this, 2921509);
        this.T0 = new j0(this);
        this.U0 = new k0(this);
    }

    public void G4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            fq9 fq9Var = this.o;
            if (fq9Var == null) {
                return;
            }
            if (z2) {
                fq9Var.G();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.o.H();
            } else {
                this.o.G();
            }
        }
    }

    @Override // com.baidu.tieba.k16
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.k16
    public void N(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, context, str) == null) {
            nm9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    public final void Z3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i2, i3) == null) {
            fx5.b(new s(this, i3), new t(this, i3, i2));
        }
    }

    @Override // com.baidu.tieba.k16
    public void o0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048678, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.A = true;
    }

    public void p4(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048696, this, adverSegmentData, i2) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.A(adverSegmentData, getPageContext(), i2, false);
        }
    }

    public final void A4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && W() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(W().M1());
            sendMessage(privacySettingMessage);
        }
    }

    public final void C4(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).c2());
            }
        }
    }

    public void D4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.N = z2;
        }
    }

    public void E4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.m = z2;
        }
    }

    public final void K4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z2) == null) {
            this.X.Y(z2);
            this.X.b0(z2);
            this.X.j0(z2);
        }
    }

    public void N4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048612, this, z2) != null) || this.D == null) {
            return;
        }
        D4(this.X.z());
        if (this.N) {
            O4(z2);
        } else {
            V3(z2);
        }
    }

    public final void R4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            iq9.c(d0(), B3(), i2);
        }
    }

    public void o4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048680, this, i2) == null) && i2 == 0) {
            cea.g().h(getUniqueId(), false);
            if (Q3() != null) {
                i3(Q3(), true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z2) == null) {
            View view2 = this.f;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) {
            super.onUserChanged(z2);
            i4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (customViewPager = this.d) != null) {
                if (z2) {
                    i2 = customViewPager.getCurrentItem();
                } else {
                    i2 = -1;
                }
                videoPbFragmentAdapter.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048686, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(G3(), viewGroup, false);
            f4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    public LinearLayout A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.E;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k16
    public ag<LinearLayout> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.y == null) {
                this.y = new ag<>(new v0(this), 15, 0);
            }
            return this.y;
        }
        return (ag) invokeV.objValue;
    }

    public final void B4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.setFallingFeedbackListener(new y0(this));
        }
    }

    public DetailInfoAndReplyFragment C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.e.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.t == null) {
                this.t = VoiceManager.instance();
            }
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            PbModel I1 = this.a.I1();
            if (I1 == null) {
                return false;
            }
            return I1.l2();
        }
        return invokeV.booleanValue;
    }

    public View.OnClickListener H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.L0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void H4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            hideProgressBar();
            if (C3() != null) {
                C3().i2();
                C3().j2();
            }
        }
    }

    public View.OnClickListener I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.M0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void I4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public dw4 K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.q;
        }
        return (dw4) invokeV.objValue;
    }

    public View.OnLongClickListener L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.T0;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.H0;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public ek5 N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.X;
        }
        return (ek5) invokeV.objValue;
    }

    public void P4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(0);
        }
    }

    public final void Q4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.setTag(Boolean.TRUE);
        }
    }

    public String R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (!di.isEmpty(this.M)) {
                return this.M;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(gm9.g());
            this.M = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void U3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048627, this) != null) || this.D == null) {
            return;
        }
        this.C.setVisibility(8);
        this.D.setVisibility(8);
    }

    public void U4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.C();
            this.l.setAnimationListener(null);
        }
    }

    @Override // com.baidu.tieba.aq9
    public PbModel.h V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.r0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public final void V4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.aq9
    public PbModel W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.a.I1();
        }
        return (PbModel) invokeV.objValue;
    }

    public void W3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (editorTools = this.Y) != null) {
            editorTools.q();
        }
    }

    public final void W4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.V1();
        }
    }

    @Override // com.baidu.tieba.k16
    public ag<RelativeLayout> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            ag<RelativeLayout> agVar = new ag<>(new w0(this), 10, 0);
            this.z = agVar;
            return agVar;
        }
        return (ag) invokeV.objValue;
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public void Y3() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(8);
        }
    }

    public void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            ek5 ek5Var = this.X;
            if (ek5Var != null) {
                D4(ek5Var.z());
            }
            w4();
            this.o.G();
        }
    }

    @Override // com.baidu.tieba.k16
    public ag<ImageView> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (this.w == null) {
                this.w = new ag<>(new s0(this), 8, 0);
            }
            return this.w;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k16
    public ag<View> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (this.x == null) {
                this.x = new ag<>(new u0(this), 8, 0);
            }
            return this.x;
        }
        return (ag) invokeV.objValue;
    }

    public void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            setEditorTools(this.X.a());
        }
    }

    @Override // com.baidu.tieba.aq9
    public AbsPbActivity d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void e4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048653, this) != null) || (editorTools = this.Y) == null) {
            return;
        }
        editorTools.j();
        U3();
    }

    public boolean g4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            EditorTools editorTools = this.Y;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k16
    public ag<TextView> i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.v == null) {
                this.v = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.v;
        }
        return (ag) invokeV.objValue;
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && this.F != null) {
            u3();
            this.F.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    public final boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            PbModel W = W();
            if (W != null && W.s1() != null) {
                return AntiHelper.b(getPageContext(), W.s1().O());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            super.onStart();
            G0().onStart(getPageContext());
        }
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048711, this) == null) && W() != null && !di.isEmpty(W().M1())) {
            super.taskStart();
        }
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            reset();
            W3();
            this.Z.g();
            N4(false);
        }
    }

    public void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.e0 = -1;
            this.f0 = Integer.MIN_VALUE;
        }
    }

    @Override // com.baidu.tieba.k16
    public ag<GifView> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            if (this.u == null) {
                this.u = new ag<>(new t0(this), 20, 0);
            }
            return this.u;
        }
        return (ag) invokeV.objValue;
    }

    public me5 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.r;
        }
        return (me5) invokeV.objValue;
    }

    public final int B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (W() != null && W().s1() != null && W().s1().O() != null) {
                return W().s1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter == null) {
                return null;
            }
            Iterator<BaseFragment> it = videoPbFragmentAdapter.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).o2();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void S4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && W() != null && !di.isEmpty(W().M1())) {
            jt4.w().Q(it4.Z, JavaTypesHelper.toLong(W().M1(), 0L));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            dw4 c2 = dw4.c(this.a);
            this.q = c2;
            if (c2 != null) {
                c2.j(this.s0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.s = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.G0);
            this.r = new me5(getPageContext());
            this.o = new fq9(this);
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048670, this) != null) || W() == null) {
            return;
        }
        yh9 s1 = W().s1();
        W().i3(true);
        dw4 dw4Var = this.q;
        if (dw4Var != null) {
            s1.K0(dw4Var.g());
        }
        if (C3() != null) {
            C3().u2();
        }
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.o != null && W() != null) {
                this.o.G();
                if (this.m) {
                    return;
                }
                V4();
                I4();
                if (W().loadData()) {
                    P4();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            super.onResume();
            this.i0 = false;
            G0().onResume(getPageContext());
            S4();
            registerListener(this.A0);
            registerListener(this.B0);
            registerListener(this.z0);
            registerListener(this.O0);
            ItemCardHelper.w(this.R0);
            MessageManager.getInstance().registerListener(this.Q0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            super.onStop();
            G0().onStop(getPageContext());
            cea.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.Q0);
        }
    }

    public zfa D3(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yh9Var)) == null) {
            zfa zfaVar = null;
            if (yh9Var == null) {
                return null;
            }
            if (yh9Var.Y() != null) {
                return yh9Var.Y();
            }
            if (!ListUtils.isEmpty(yh9Var.F())) {
                Iterator<zfa> it = yh9Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zfa next = it.next();
                    if (next != null && next.I() == 1) {
                        zfaVar = next;
                        break;
                    }
                }
            }
            if (zfaVar == null) {
                zfaVar = yh9Var.i();
            }
            if (zfaVar == null) {
                zfaVar = P3(yh9Var);
            }
            if (zfaVar != null && zfaVar.r() != null && zfaVar.r().getUserTbVipInfoData() != null && zfaVar.r().getUserTbVipInfoData().getvipIntro() != null) {
                zfaVar.r().getGodUserData().setIntro(zfaVar.r().getUserTbVipInfoData().getvipIntro());
            }
            return zfaVar;
        }
        return (zfa) invokeL.objValue;
    }

    public final zfa P3(yh9 yh9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, yh9Var)) == null) {
            if (yh9Var != null && yh9Var.O() != null && yh9Var.O().getAuthor() != null) {
                zfa zfaVar = new zfa();
                MetaData author = yh9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = yh9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                zfaVar.S0(1);
                zfaVar.Y0(yh9Var.O().getFirstPostId());
                zfaVar.p1(yh9Var.O().getTitle());
                zfaVar.o1(yh9Var.O().getCreateTime());
                zfaVar.N0(author);
                return zfaVar;
            }
            return null;
        }
        return (zfa) invokeL.objValue;
    }

    public void V3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) && this.D != null && this.G != null) {
            if (W() != null && W().s1() != null) {
                this.G.setText(TbSingleton.getInstance().getAdVertiComment(W().s1().q0(), W().s1().r0(), R3()));
            } else {
                this.G.setText(R3());
            }
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.D.startAnimation(alphaAnimation);
            }
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    public void a5(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, yh9Var) == null) {
            if (yh9Var != null && AntiHelper.o(yh9Var.O())) {
                nq9 nq9Var = this.K;
                if (nq9Var != null) {
                    nq9Var.k(false);
                    this.K.j();
                }
                ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.J.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            nq9 nq9Var2 = this.K;
            if (nq9Var2 != null && nq9Var2.g()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.J.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.J.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907b5));
            if (W() != null && W().s1() != null) {
                boolean b12 = W().b1();
                yh9 s1 = W().s1();
                if (b12) {
                    zfa D3 = D3(s1);
                    if (s1.u() != null && !s1.u().equals(D3.S()) && (customViewPager = this.d) != null) {
                        customViewPager.setCurrentItem(0);
                    }
                }
            }
            this.a.K1().k(this.j0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            d4(bundle);
            G0().onCreate(getPageContext());
            l95 l95Var = new l95();
            this.p = l95Var;
            l95Var.a = 1000L;
            if (this.o != null) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
                userMuteAddAndDelCustomMessage.from = 1;
                BdUniqueId bdUniqueId = this.o.D;
                userMuteAddAndDelCustomMessage.mId = bdUniqueId;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
                BdUniqueId bdUniqueId2 = this.o.D;
                userMuteCheckCustomMessage.mId = bdUniqueId2;
                userMuteCheckCustomMessage.setTag(bdUniqueId2);
                MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            }
            registerListener(this.P0);
            this.g = new jn6(getPageContext());
            cea.g().i(getUniqueId());
        }
    }

    public void p3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, bVar) == null) {
            List<zfa> list = W().s1().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).i0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).i0().get(i3).S())) {
                        list.get(i2).i0().remove(i3);
                        list.get(i2).h();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).i(bVar.g);
            }
            if (z2 && C3() != null) {
                C3().u2();
            }
        }
    }

    public final void q4(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048699, this, yh9Var) != null) || yh9Var == null) {
            return;
        }
        ThreadData O = yh9Var.O();
        if (O != null && O.isUgcThreadType()) {
            h3();
        } else {
            F4(this.W);
        }
        ek5 ek5Var = this.X;
        if (ek5Var != null) {
            D4(ek5Var.z());
            this.X.I(yh9Var.c());
            this.X.J(yh9Var.k(), yh9Var.V());
            this.X.l0(O);
            if (W() != null) {
                this.X.K(W().U0(), W().M1(), W().Q0());
            }
            if (O != null) {
                this.X.a0(O.isMutiForumThread());
            }
        }
    }

    public void t4(yh9 yh9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048709, this, yh9Var) == null) && yh9Var != null && yh9Var.O() != null) {
            a5(yh9Var);
            ImageView imageView = this.I;
            if (yh9Var.j0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (yh9Var.q()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String y3 = y3(yh9Var.O().getReply_num());
            TextView textView = this.L;
            if (textView != null) {
                textView.setText(y3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, yh9Var.O()));
        }
    }

    public final String y3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048721, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0fd0);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i2 > 9990000) {
                return "· · ·";
            }
            if (i2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (i2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + i2;
            }
        }
        return (String) invokeI.objValue;
    }

    public final String F3() {
        InterceptResult invokeV;
        ArrayList<zfa> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (W() == null || W().s1() == null || W().s1().F() == null || (count = ListUtils.getCount((F = W().s1().F()))) == 0) {
                return "";
            }
            if (W().E1()) {
                Iterator<zfa> it = F.iterator();
                while (it.hasNext()) {
                    zfa next = it.next();
                    if (next != null && next.I() == 1) {
                        return next.S();
                    }
                }
            }
            int i2 = 0;
            if (Q3() != null && C3() != null) {
                i2 = C3().l2();
            }
            zfa zfaVar = (zfa) ListUtils.getItem(F, i2);
            if (zfaVar != null && zfaVar.r() != null) {
                if (W().m2(zfaVar.r().getUserId())) {
                    return zfaVar.S();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    zfa zfaVar2 = (zfa) ListUtils.getItem(F, i3);
                    if (zfaVar2 == null || zfaVar2.r() == null || zfaVar2.r().getUserId() == null) {
                        break;
                    } else if (W().m2(zfaVar2.r().getUserId())) {
                        return zfaVar2.S();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    zfa zfaVar3 = (zfa) ListUtils.getItem(F, i4);
                    if (zfaVar3 == null || zfaVar3.r() == null || zfaVar3.r().getUserId() == null) {
                        break;
                    } else if (W().m2(zfaVar3.r().getUserId())) {
                        return zfaVar3.S();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (W() == null) {
                return true;
            }
            if (W().s1() != null && W().s1().j0()) {
                return true;
            }
            if (W().d1()) {
                MarkData O0 = W().O0();
                if (O0 != null && W().b1() && Q3() != null) {
                    MarkData I0 = W().I0(Q3().getFirstVisiblePosition());
                    if (I0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", O0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                        s45 s45Var = new s45(getBaseFragmentActivity());
                        s45Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0299));
                        s45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c2, new n(this, I0, O0, s45Var));
                        s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new o(this, O0, s45Var));
                        s45Var.setOnCalcelListener(new p(this));
                        s45Var.create(getBaseFragmentActivity().getPageContext());
                        s45Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", O0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (W().s1() != null && W().s1().F() != null && W().s1().F().size() > 0 && W().b1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.B = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09290a);
            this.C = this.c.findViewById(R.id.obfuscated_res_0x7f092968);
            this.D = this.c.findViewById(R.id.obfuscated_res_0x7f091ab6);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09099b);
            this.F = imageView;
            imageView.setOnClickListener(new d0(this));
            i4();
            this.G = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ab9);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091ab0);
            this.E = linearLayout;
            linearLayout.setOnClickListener(new e0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ab7);
            this.H = imageView2;
            imageView2.setOnClickListener(this.L0);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ab5);
            this.I = imageView3;
            imageView3.setOnClickListener(this.L0);
            if (booleanExtra) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
            }
            if (h4()) {
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
                this.I.setPadding(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091aba);
            this.J = imageView4;
            imageView4.setOnClickListener(this.L0);
            this.K = new nq9(this.J);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ab8);
            this.L = textView;
            textView.setVisibility(0);
            N4(false);
        }
    }

    public final void h3() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && W() != null && this.a != null) {
            ek5 ek5Var = this.X;
            if (ek5Var != null && ek5Var.t) {
                return;
            }
            dk5 dk5Var = new dk5();
            F4(dk5Var);
            ek5 ek5Var2 = (ek5) dk5Var.a(getContext());
            this.X = ek5Var2;
            ek5Var2.X(this.a.getPageContext());
            this.X.g0(this.D0);
            this.X.h0(this.K0);
            ek5 ek5Var3 = this.X;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            ek5Var3.B(pageContext, extras);
            this.X.a().F(true);
            setEditorTools(this.X.a());
            if (!W().f1()) {
                this.X.q(W().M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.X.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (W().c2()) {
                this.X.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.X.d0(R3());
            }
        }
    }

    public final void l4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048673, this) == null) && W() != null && W().s1() != null && C3() != null && this.q != null) {
            MarkData markData = null;
            if (W().s1() != null && W().s1().j0()) {
                markData = W().I0(0);
            } else {
                CustomViewPager customViewPager = this.d;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = W().m1(D3(W().s1()));
                } else if (C3() != null) {
                    markData = W().I0(C3().n2());
                }
            }
            if (markData == null) {
                return;
            }
            I4();
            this.q.i(markData);
            if (!this.q.e()) {
                if (W() != null && !lo9.h(W().M1())) {
                    this.K.n(2);
                    lo9.b(W().M1());
                }
                this.q.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.q.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void F4(fk5 fk5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, fk5Var) == null) && fk5Var != null && W() != null) {
            fk5Var.p(W().R0());
            if (W().s1() != null && W().s1().k() != null) {
                fk5Var.o(W().s1().k());
            }
            fk5Var.q("pb");
            fk5Var.r(W());
            fk5Var.s(PbNewEditorTool.InputShowType.REPLY_VIDEO);
        }
    }

    public final void J4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048600, this, i2) != null) || W() == null) {
            return;
        }
        int C1 = W().C1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    W().c3(1);
                } else {
                    W().c3(4);
                }
            } else {
                W().c3(3);
            }
        } else {
            W().c3(2);
        }
        int C12 = W().C1();
        if (C1 == 4 || C12 == 4) {
            n4();
        }
    }

    public void b5(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z2) == null) {
            DetailInfoAndReplyFragment C3 = C3();
            if (C3 != null && C3.U1() != null && C3.U1().g() != null && C3.U1().h() != null) {
                C3.U1().g().q0(z2);
                C3.U1().h().W(z2);
            }
            MaskView maskView = this.k;
            if (maskView != null) {
                if (z2) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                maskView.setVisibility(i2);
            }
        }
    }

    public boolean m3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i2)) == null) {
            if (this.f1158T != null && W() != null && W().s1() != null && !ThreadCardUtils.isSelf(W().s1().O()) && W().s1().c() != null) {
                return this.f1158T.checkPrivacyBeforeSend(W().s1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, editorTools) == null) {
            this.Y = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091ab1);
            this.Y.setOnCancelClickListener(new m0(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.Y.getParent() == null) {
                this.c.addView(this.Y, layoutParams);
            }
            this.Y.z(TbadkCoreApplication.getInst().getSkinType());
            this.Y.setActionListener(24, new n0(this));
            W3();
            this.X.g(new o0(this));
        }
    }

    public SparseArray<Object> J3(yh9 yh9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        zfa D3;
        boolean z3;
        d25 d25Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{yh9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (yh9Var == null || (D3 = D3(yh9Var)) == null) {
                return null;
            }
            String userId = D3.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, D3.S());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(yh9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (D3.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, D3.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, D3.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, D3.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, D3.S());
                }
                sparseArray.put(R.id.tag_del_post_id, D3.S());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(yh9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<y35> o2 = yh9Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (y35 y35Var : o2) {
                        if (y35Var != null && !StringUtils.isNull(y35Var.d()) && (d25Var = y35Var.h) != null && d25Var.a && !d25Var.c && ((i3 = d25Var.b) == 1 || i3 == 2)) {
                            sb.append(di.cutString(y35Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f077c));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0540), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void K0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048602, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (h16[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), h16.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (nm9.c(objArr[i2].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new VCenterTextSpan(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.k16
    public void g0(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048657, this, context, str, z2) == null) {
            if (nm9.c(str) && W() != null && W().M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", W().M1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    dh5 dh5Var = new dh5();
                    dh5Var.a = str;
                    dh5Var.b = 3;
                    dh5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, dh5Var));
                }
            } else {
                nm9.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048682, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.X.D(i2, i3, intent);
            fl9 fl9Var = this.Z;
            if (fl9Var != null) {
                fl9Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                S3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 11009) {
                    if (i2 != 13011) {
                        switch (i2) {
                            case 25055:
                                View view2 = this.h;
                                if (view2 != null) {
                                    view2.performClick();
                                    return;
                                }
                                return;
                            case 25056:
                                View view3 = this.i;
                                if (view3 != null) {
                                    view3.performClick();
                                    return;
                                }
                                return;
                            case 25057:
                                if (A3() != null) {
                                    A3().performClick();
                                    return;
                                }
                                return;
                            case 25058:
                                View view4 = this.j;
                                if (view4 != null) {
                                    view4.performClick();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    RateManager.getInstance().notifyShare(getPageContext());
                    return;
                }
                l4();
            }
        }
    }

    public final void L4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048606, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new l0(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                fq9 fq9Var = this.o;
                if (fq9Var != null) {
                    fq9Var.E0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.k16
    public void l0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048671, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.o.o0(str);
            t45 S = this.o.S();
            if (S == null) {
                this.o.X();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                S.f(1).setVisibility(8);
            } else {
                S.f(1).setVisibility(0);
            }
            S.m();
            this.A = true;
        }
    }

    public final void M4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048609, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    uf5.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (W() != null && !W().f1()) {
                antiData.setBlock_forum_name(W().s1().k().getName());
                antiData.setBlock_forum_id(W().s1().k().getId());
                antiData.setUser_name(W().s1().V().getUserName());
                antiData.setUser_id(W().s1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public void i3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        zfa zfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048664, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof zfa) && (zfaVar = (zfa) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && zfaVar.n() != null) {
                        zfaVar.n().setFloonumber(zfaVar.I());
                        arrayList.add(zfaVar.n());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new x0(this));
                if (((AdverSegmentData) ListUtils.getItem(arrayList, 0)).getFloonumber() == 1) {
                    if (!z2) {
                        p4((AdverSegmentData) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                p4((AdverSegmentData) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public void O4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) && this.D != null && (textView = this.G) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0607);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.D.startAnimation(alphaAnimation);
            }
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    public final boolean k3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048669, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (W() != null) {
                W().O2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                G0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void z4(boolean z2) {
        dw4 dw4Var;
        MarkData f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048725, this, z2) != null) || (dw4Var = this.q) == null || (f2 = dw4Var.f()) == null) {
            return;
        }
        vfa vfaVar = new vfa();
        vfaVar.a = f2.getThreadId();
        vfaVar.b = z2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, vfaVar));
    }

    public final void S3(int i2, Intent intent) {
        mi5 mi5Var;
        fl9 fl9Var;
        mi5 mi5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048622, this, i2, intent) == null) {
            if (i2 == 0) {
                W3();
                fl9 fl9Var2 = this.Z;
                if (fl9Var2 != null) {
                    fl9Var2.g();
                }
                N4(false);
            }
            w4();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType == 1 && (fl9Var = this.Z) != null && fl9Var.f() != null) {
                    hk5 f2 = this.Z.f();
                    f2.f0(W().s1().O());
                    f2.D(writeData);
                    f2.g0(pbEditorData.getVoiceModel());
                    li5 p2 = f2.a().p(6);
                    if (p2 != null && (mi5Var2 = p2.m) != null) {
                        mi5Var2.E(new zh5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.I();
                        return;
                    }
                    return;
                }
                return;
            }
            this.X.M();
            this.X.n0(pbEditorData.getVoiceModel());
            this.X.C(writeData);
            li5 p3 = this.X.a().p(6);
            if (p3 != null && (mi5Var = p3.m) != null) {
                mi5Var.E(new zh5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.X.H(null, null);
            }
        }
    }

    public void q3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048698, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.s.g0()) {
                    return;
                }
                showProgressBar();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (sparseArray.get(R.id.tag_is_block_thread) != null) {
                    z2 = ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue();
                } else {
                    z2 = false;
                }
                if (jSONArray != null) {
                    this.s.i0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.s.j0(W().s1().k().getId(), W().s1().k().getName(), W().s1().O().getId(), str, intValue3, intValue2, booleanValue, W().s1().O().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                if (W().N0() != null) {
                    W().N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void x3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048719, this, i2, gVar) == null) && gVar != null && W() != null && W().s1() != null && W().s1().O() != null) {
            w3(this.s.getLoadDataMode(), gVar.a, gVar.b, false);
            if (gVar.a) {
                this.P = true;
                if (i2 != 2 && i2 != 3) {
                    if (i2 == 4 || i2 == 5) {
                        this.Q = false;
                        this.R = true;
                    }
                } else {
                    this.Q = true;
                    this.R = false;
                }
                if (i2 == 2) {
                    W().s1().O().setIs_good(1);
                    W().V2(1);
                } else if (i2 == 3) {
                    W().s1().O().setIs_good(0);
                    W().V2(0);
                } else if (i2 == 4) {
                    W().s1().O().setIs_top(1);
                    W().W2(1);
                } else if (i2 == 5) {
                    W().s1().O().setIs_top(0);
                    W().W2(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
            }
            if (W().s1().O() != null && C3() != null) {
                C3().z2();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T3(boolean z2) {
        yh9 s1;
        int i2;
        nq9 nq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) && W() != null && this.o != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (s1 = W().s1()) == null) {
                return;
            }
            ThreadData O = s1.O();
            int i3 = 1;
            if (O != null && O.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", W().M1()).param("fid", s1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", W().getForumId());
                statisticItem.param("tid", W().M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", F3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", E3());
                TiebaStatic.log(statisticItem);
            }
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    i2 = 2;
                } else if (O.isBJHVideoThreadType()) {
                    i2 = 3;
                } else if (O.isBJHNormalThreadType()) {
                    i2 = 4;
                } else if (O.isBJHVideoDynamicThreadType()) {
                    i2 = 5;
                }
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", W().M1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", W().getForumId());
                if (!z2) {
                    statisticItem2.param("obj_locate", 6);
                } else {
                    statisticItem2.param("obj_locate", 5);
                }
                statisticItem2.param("obj_name", i2);
                statisticItem2.param("obj_type", 2);
                if (O != null) {
                    if (O.isBJHArticleThreadType()) {
                        statisticItem2.param("obj_type", 10);
                    } else if (O.isBJHVideoThreadType()) {
                        statisticItem2.param("obj_type", 9);
                    } else if (O.isBJHVideoDynamicThreadType()) {
                        statisticItem2.param("obj_type", 8);
                    } else if (O.isBJHNormalThreadType()) {
                        statisticItem2.param("obj_type", 7);
                    } else if (O.isShareThread) {
                        statisticItem2.param("obj_type", 6);
                    } else {
                        int i4 = O.threadType;
                        if (i4 == 0) {
                            statisticItem2.param("obj_type", 1);
                        } else if (i4 == 40) {
                            statisticItem2.param("obj_type", 2);
                        } else if (i4 == 49) {
                            statisticItem2.param("obj_type", 3);
                        } else if (i4 == 54) {
                            statisticItem2.param("obj_type", 4);
                        } else {
                            statisticItem2.param("obj_type", 5);
                        }
                    }
                    statisticItem2.param("nid", O.getNid());
                    statisticItem2.param("card_type", O.getRecomCardType());
                    statisticItem2.param("recom_source", O.mRecomSource);
                    statisticItem2.param("ab_tag", O.mRecomAbTag);
                    statisticItem2.param("weight", O.mRecomWeight);
                    statisticItem2.param("extra", O.mRecomExtra);
                    statisticItem2.param("nid", O.getNid());
                    if (O.getBaijiahaoData() != null && !di.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (d0() != null) {
                    xr5.e(d0(), statisticItem2);
                }
                nq9Var = this.K;
                if (nq9Var != null) {
                    statisticItem2.param("obj_param1", nq9Var.f());
                }
                TiebaStatic.log(statisticItem2);
                if (BdUtilHelper.isNetOk()) {
                    showToast(R.string.obfuscated_res_0x7f0f0e29);
                    return;
                } else if (W().s1() == null) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0fed));
                    return;
                } else {
                    ArrayList<zfa> F = s1.F();
                    if ((F == null || F.size() <= 0) && W().L1()) {
                        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0fed));
                        return;
                    }
                    this.o.G();
                    V4();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), O)) {
                        return;
                    }
                    nq9 nq9Var2 = this.K;
                    if (nq9Var2 != null) {
                        nq9Var2.k(false);
                        a5(s1);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i3 = 2;
                        }
                        if (this.K.h()) {
                            this.K.l(false);
                            Z3(lf5.a(), this.K.f());
                            return;
                        }
                        R4(i3);
                        return;
                    }
                    this.o.w0();
                    W().M0().P(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", W().M1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", W().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            statisticItem22.param("obj_type", 2);
            if (O != null) {
            }
            if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (d0() != null) {
            }
            nq9Var = this.K;
            if (nq9Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (BdUtilHelper.isNetOk()) {
            }
        }
    }

    public final void T4(zfa zfaVar, zfa zfaVar2, boolean z2, boolean z3) {
        String str;
        int i2;
        boolean z4;
        boolean z5;
        zfa D3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{zfaVar, zfaVar2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String M1 = W().M1();
            String S = zfaVar.S();
            if (zfaVar2 != null) {
                str = zfaVar2.S();
            } else {
                str = "";
            }
            if (W().s1() != null) {
                i2 = W().s1().W();
            } else {
                i2 = 0;
            }
            if (C3() != null && C3().q2() != null) {
                AbsPbActivity.e p2 = C3().q2().p(S);
                if (zfaVar != null && W() != null && W().s1() != null && p2 != null) {
                    if (E3() != 1 && E3() != 2 && E3() != 3 && E3() != 4 && E3() != 5) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, S, "pb", true, true, null, false, str, i2, zfaVar.l0(), W().s1().c(), false, zfaVar.r().getIconInfo(), E3(), z4).addBigImageData(p2.a, p2.b, p2.g, p2.j);
                    if (z3) {
                        addBigImageData.setHighLightPostId(str);
                        z5 = true;
                        addBigImageData.setKeyIsUseSpid(true);
                    } else {
                        z5 = true;
                    }
                    addBigImageData.setKeyFromForumId(W().getForumId());
                    addBigImageData.setTiebaPlusData(W().W(), W().S(), W().T(), W().R(), W().X());
                    addBigImageData.setBjhData(W().J0());
                    addBigImageData.setKeyPageStartFrom(W().r1());
                    addBigImageData.setFromFrsForumId(W().getFromForumId());
                    addBigImageData.setWorksInfoData(W().R1());
                    addBigImageData.setIsOpenEditor(z2);
                    if (W().s1().n() != null) {
                        addBigImageData.setHasForumRule(W().s1().n().has_forum_rule.intValue());
                    }
                    if (W().s1().V() != null) {
                        addBigImageData.setIsManager(W().s1().V().getIs_manager());
                    }
                    if (W().s1().k().getDeletedReasonInfo() != null) {
                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(W().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(W().s1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    if (W().s1().k() != null) {
                        addBigImageData.setForumHeadUrl(W().s1().k().getImage_url());
                        addBigImageData.setUserLevel(W().s1().k().getUser_level());
                    }
                    if (W() != null && (D3 = D3(W().s1())) != null) {
                        if (!D3.f1192T && !zfaVar.f1192T) {
                            z5 = false;
                        }
                        addBigImageData.setMainPostMaskVisibly(z5);
                    }
                    if (this.a.getIntent() != null) {
                        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                    }
                    addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
                    sendMessage(new CustomMessage(2002001, addBigImageData));
                }
            }
        }
    }

    public final void Z4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && W() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.S(W().getForumId()) && W().s1() != null && W().s1().k() != null) {
            boolean z2 = true;
            if (W().s1().k().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                W().F0().R(W().getForumId(), W().M1());
            }
        }
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.a0 = new PbFakeFloorModel(getPageContext());
            PbModel W = W();
            this.a0.g0(W.W(), W.S(), W.T(), W.R(), W.X());
            this.a0.setFromForumId(W.getFromForumId());
            fl9 fl9Var = new fl9(getPageContext(), this.a0, this.c);
            this.Z = fl9Var;
            fl9Var.p(new h0(this));
            this.Z.s(this.J0);
            this.a0.i0(new i0(this));
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && W() != null && W().s1() != null && W().s1().O() != null) {
            ThreadData O = W().s1().O();
            O.mRecomAbTag = W().y1();
            O.mRecomWeight = W().B1();
            O.mRecomSource = W().A1();
            O.mRecomExtra = W().z1();
            O.isSubPb = W().f1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(W().getForumId(), 0L));
            }
            StatisticItem i2 = xr5.i(getContext(), O, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            cy6 cy6Var = new cy6(getActivity());
            this.b0 = cy6Var;
            cy6Var.i(this.I0);
            this.d = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091b66);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f091260);
            this.k = (MaskView) this.c.findViewById(R.id.mask_view);
            this.f.setOnClickListener(this.L0);
            a4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.e = videoPbFragmentAdapter;
            this.d.setAdapter(videoPbFragmentAdapter);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f0929a0);
            this.l = (PbFallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090af1);
            B4();
            this.l.setAnimationListener(new c0(this));
            c4();
            b4();
        }
    }

    public boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if ((W() != null && W().s1().j0()) || this.f1158T == null || W() == null || W().s1() == null || ThreadCardUtils.isSelf(W().s1().O()) || W().s1().c() == null) {
                return true;
            }
            return this.f1158T.checkPrivacyBeforeInvokeEditor(W().s1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            if (!checkUpIsLogin()) {
                if (W() != null) {
                    wp9.v("c10517", W().getForumId(), 2);
                }
            } else if (!l3()) {
            } else {
                ek5 ek5Var = this.X;
                if (ek5Var != null && (ek5Var.y() || this.X.A())) {
                    this.X.w(false, null);
                    return;
                }
                if (this.Y != null) {
                    e4();
                    if (this.Y.p(2) != null) {
                        lfa.c(getPageContext(), (View) this.Y.p(2).m, false, null);
                    }
                }
                U3();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            super.onDestroy();
            cea.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.P0);
            ItemCardHelper.w(null);
            G0().onDestory(getPageContext());
            nq9 nq9Var = this.K;
            if (nq9Var != null) {
                nq9Var.j();
            }
            ForumManageModel forumManageModel = this.s;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.f1158T;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            fq9 fq9Var = this.o;
            if (fq9Var != null) {
                fq9Var.m0();
            }
            fl9 fl9Var = this.Z;
            if (fl9Var != null) {
                fl9Var.m();
            }
            if (W() != null) {
                W().cancelLoadData();
                W().destory();
                if (W().o1() != null) {
                    W().o1().d();
                }
            }
            ek5 ek5Var = this.X;
            if (ek5Var != null) {
                ek5Var.E();
            }
            this.p = null;
            lfa.d();
            U4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            super.onPause();
            this.i0 = true;
            G0().onPause();
            if (W() != null && !W().f1()) {
                this.X.O(W().M1());
            }
            jt4.w().E();
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.O0);
        }
    }

    public void r4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048701, this) != null) || !checkUpIsLogin() || W() == null || W().s1() == null || W().s1().k() == null || j3()) {
            return;
        }
        if (W().s1().j0()) {
            n3();
            return;
        }
        ek5 ek5Var = this.X;
        if (ek5Var != null && ek5Var.a() != null) {
            this.X.a().D(new zh5(45, 27, null));
        }
        n3();
    }

    public final void reset() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && this.X != null && this.Y != null) {
            zj5.a().c(0);
            this.X.N();
            this.X.L();
            if (this.X.v() != null) {
                WriteImagesInfo v2 = this.X.v();
                if (this.X.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            this.X.e0(SendView.f);
            this.X.h(SendView.f);
            hi5 o2 = this.Y.o(23);
            hi5 o3 = this.Y.o(2);
            hi5 o4 = this.Y.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.Y.invalidate();
        }
    }

    public final void d4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) {
            fk5 fk5Var = new fk5();
            this.W = fk5Var;
            F4(fk5Var);
            ek5 ek5Var = (ek5) this.W.a(getActivity());
            this.X = ek5Var;
            ek5Var.X(this.a.getPageContext());
            this.X.g0(this.D0);
            this.X.h0(this.K0);
            this.X.Z(1);
            this.X.e0(SendView.f);
            this.X.h(SendView.f);
            this.X.B(this.a.getPageContext(), bundle);
            this.X.a().b(new ki5(getActivity()));
            this.X.a().F(true);
            K4(true);
            if (W() != null) {
                this.X.K(W().U0(), W().M1(), W().Q0());
            }
            registerListener(this.v0);
            registerListener(this.x0);
            registerListener(this.F0);
            registerListener(this.u0);
            registerListener(this.w0);
            registerListener(this.y0);
            registerListener(this.S0);
            if (!W().f1()) {
                this.X.q(W().M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.X.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (W().c2()) {
                this.X.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.X.d0(R3());
            }
            this.U = new km9();
            if (this.X.s() != null) {
                this.U.m(this.X.s().i());
            }
            this.X.W(this.t0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.f1158T = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new z(this));
        }
    }

    @Override // com.baidu.tieba.aq9
    public void finish() {
        CardHListViewData p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            PbModel I1 = this.a.I1();
            if (I1 != null && I1.s1() != null && I1.s1().O() != null && !I1.s1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = I1.s1().O().getId();
                if (I1.isShareThread() && I1.s1().O().originalThreadData != null) {
                    historyMessage.threadName = I1.s1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = I1.s1().O().getTitle();
                }
                if (I1.isShareThread() && !H0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = I1.s1().k().getName();
                }
                ArrayList<zfa> F = I1.s1().F();
                if (F != null && F.size() > 0) {
                    historyMessage.postID = F.get(0).S();
                }
                historyMessage.isHostOnly = I1.V0();
                historyMessage.isSquence = I1.L1();
                historyMessage.isShareThread = I1.isShareThread();
                historyMessage.threadType = I1.s1().O().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            ek5 ek5Var = this.X;
            if (ek5Var != null) {
                ek5Var.E();
            }
            if (I1 != null && (I1.X0() || I1.a1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", I1.M1());
                if (this.P) {
                    if (this.R) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", I1.g1());
                    }
                    if (this.Q) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", I1.c1());
                    }
                }
                if (I1.s1() != null && System.currentTimeMillis() - this.b >= 40000 && (p2 = I1.s1().p()) != null && !ListUtils.isEmpty(p2.getDataList())) {
                    intent.putExtra("guess_like_data", p2);
                }
                this.a.setResult(-1, intent);
            }
            if (X4()) {
                if (I1 != null) {
                    yh9 s1 = I1.s1();
                    if (s1 != null) {
                        if (s1.V() != null) {
                            s1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s1.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.S) {
                            yl9.b().q(this.d.getCurrentItem());
                            BdTypeRecyclerView Q3 = Q3();
                            Parcelable parcelable = null;
                            if (Q3 != null) {
                                parcelable = Q3.onSaveInstanceState();
                            }
                            yl9.b().l(I1.t1(), parcelable, I1.L1(), I1.V0(), false);
                        }
                    }
                } else {
                    yl9.b().k();
                }
                W4();
            }
        }
    }

    public final void g3(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048658, this, z2, str) == null) && W() != null && W().s1() != null && W().s1().O() != null) {
            ThreadData O = W().s1().O();
            O.mRecomAbTag = W().y1();
            O.mRecomWeight = W().B1();
            O.mRecomSource = W().A1();
            O.mRecomExtra = W().z1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(W().getForumId(), 0L));
            }
            StatisticItem i2 = xr5.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = xr5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (O.isVideoThreadType()) {
                    if (ix5.e(str) > 40) {
                        str2 = ix5.m(str, 40);
                    } else {
                        str2 = str;
                    }
                    i2.param(TiebaStatic.Params.POST_CONTENT, str2);
                }
                i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
                if (z2) {
                    i2.addParam("obj_type", 2);
                } else {
                    i2.addParam("obj_type", 1);
                }
                sr5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (E3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (E3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (E3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (E3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (E3() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", W().M1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", W().s1().l());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = xr5.i(getContext(), O, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", W().M1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", W().s1().l());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = xr5.i(getContext(), O, "c14303");
            if (i4 != null) {
                if (E3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (E3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (E3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (E3() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", W().M1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", W().s1().l());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }

    public final void j4(View view2, String str, String str2, zfa zfaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048668, this, view2, str, str2, zfaVar) != null) || view2 == null || str == null || str2 == null || j3() || !l3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.c0);
            this.d0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.Z != null && zfaVar != null) {
            if (zfaVar.e0() != null) {
                str3 = zfaVar.e0().toString();
            } else {
                str3 = "";
            }
            this.Z.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), zfaVar.r().getName_show(), str3));
        }
        if (W() != null && W().s1() != null && W().s1().j0()) {
            SafeHandler.getInst().postDelayed(new p0(this, str, str2), 0L);
            return;
        }
        SafeHandler.getInst().postDelayed(new q0(this, str, str2), 0L);
        if (W() == null || W().s1() == null || W().s1().k() == null) {
        }
    }

    public final boolean m4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, str)) == null) {
            if (StringUtils.isNull(str) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean y4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048722, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof zfa)) {
                return false;
            }
            zfa zfaVar = (zfa) obj;
            if (!TextUtils.isEmpty(zfaVar.u()) && h05.c().g()) {
                return m4(zfaVar.S());
            }
            if (checkUpIsLogin() && W() != null && W().s1() != null) {
                fl9 fl9Var = this.Z;
                if (fl9Var != null) {
                    fl9Var.g();
                }
                pi9 pi9Var = new pi9();
                pi9Var.v(W().s1().k());
                pi9Var.z(W().s1().O());
                pi9Var.x(zfaVar);
                this.a0.j0(pi9Var);
                this.a0.setPostId(zfaVar.S());
                j4(view2, zfaVar.r().getUserId(), "", zfaVar);
                TiebaStatic.log("c11743");
                ek5 ek5Var = this.X;
                if (ek5Var != null) {
                    D4(ek5Var.z());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            if (W().X0() || W().a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", W().M1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, W().M1()));
            if (X4()) {
                this.a.finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            BDLayoutMode layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 4) {
                z2 = false;
            }
            layoutMode.setNightMode(z2);
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c);
            km9 km9Var = this.U;
            if (km9Var != null) {
                km9Var.i();
            }
            EditorTools editorTools = this.Y;
            if (editorTools != null) {
                editorTools.z(i2);
            }
            fl9 fl9Var = this.Z;
            if (fl9Var != null) {
                fl9Var.l(i2);
            }
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (W() != null && W().d1()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.F, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            if (W() != null) {
                a5(W().s1());
            }
            SkinManager.setBackgroundColor(this.D, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.L, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.L, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (C3() != null) {
                C3().onChangeSkinType(i2);
            }
            V4();
        }
    }

    public void v4(pi9 pi9Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048716, this, pi9Var) == null) && W() != null && W().s1() != null && pi9Var.g() != null) {
            String S = pi9Var.g().S();
            ArrayList<zfa> F = W().s1().F();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= F.size()) {
                    break;
                }
                zfa zfaVar = F.get(i2);
                if (zfaVar.S() != null && zfaVar.S().equals(S)) {
                    ArrayList<zfa> i3 = pi9Var.i();
                    zfaVar.m1(pi9Var.k());
                    if (zfaVar.i0() != null && i3 != null) {
                        Iterator<zfa> it = i3.iterator();
                        while (it.hasNext()) {
                            zfa next = it.next();
                            if (zfaVar.r0() != null && next != null && next.r() != null && (metaData = zfaVar.r0().get(next.r().getUserId())) != null) {
                                next.N0(metaData);
                                next.c1(true);
                                next.w1(getPageContext(), W().m2(metaData.getUserId()));
                            }
                        }
                        if (i3.size() != zfaVar.i0().size()) {
                            z3 = true;
                        }
                        if (!zfaVar.y0(true)) {
                            zfaVar.i0().clear();
                            zfaVar.i0().addAll(i3);
                        }
                        z2 = z3;
                    }
                    if (zfaVar.D() != null) {
                        zfaVar.L0();
                    }
                } else {
                    i2++;
                }
            }
            if (!W().b1() && z2 && C3() != null) {
                C3().u2();
            }
        }
    }

    public void r3(s45 s45Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048700, this, s45Var, jSONArray) == null) {
            s45Var.dismiss();
            if (W() != null && W().s1() != null && W().s1().O() != null && W().s1().k() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(s45Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    q3((SparseArray) s45Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void s3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                q3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void s4(boolean z2, int i2, int i3, int i4, yh9 yh9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048704, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), yh9Var, str, Integer.valueOf(i5)}) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null) {
                for (BaseFragment baseFragment : videoPbFragmentAdapter.c()) {
                    if (baseFragment instanceof zp9) {
                        ((zp9) baseFragment).J1(z2, i2, i3, i4, yh9Var, str, i5);
                    }
                }
            }
            J1(z2, i2, i3, i4, yh9Var, str, i5);
        }
    }

    public void u4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048714, this, z2, markData) != null) || W() == null) {
            return;
        }
        H4();
        W().i3(z2);
        dw4 dw4Var = this.q;
        if (dw4Var != null) {
            dw4Var.h(z2);
            if (markData != null) {
                this.q.i(markData);
            }
        }
        if (W().d1()) {
            k4();
        } else if (C3() != null) {
            C3().u2();
        }
    }

    public final void v3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048715, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                s45 s45Var = new s45(getPageContext().getPageActivity());
                s45Var.setMessage(string);
                s45Var.setPositiveButton(R.string.dialog_known, new l(this));
                s45Var.setCancelable(true);
                s45Var.create(getPageContext());
                s45Var.show();
            } else {
                w3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<zfa> F = W().s1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).S())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    W().s1().O().setReply_num(W().s1().O().getReply_num() - 1);
                    if (C3() != null) {
                        C3().u2();
                    }
                } else if (i3 == 0) {
                    o3();
                } else if (i3 == 2) {
                    ArrayList<zfa> F2 = W().s1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).i0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).i0().get(i5).S())) {
                                F2.get(i4).i0().remove(i5);
                                F2.get(i4).h();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).i(bVar.g);
                    }
                    if (z3 && C3() != null) {
                        C3().u2();
                    }
                    p3(bVar);
                }
            }
        }
    }

    public void w3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048717, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f1491));
            } else if (z3) {
                if (di.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e29);
                }
                showToast(str);
            }
        }
    }
}
