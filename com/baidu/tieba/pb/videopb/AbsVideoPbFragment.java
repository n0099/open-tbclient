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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
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
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.ak5;
import com.baidu.tieba.b89;
import com.baidu.tieba.bb9;
import com.baidu.tieba.c55;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cd5;
import com.baidu.tieba.ci5;
import com.baidu.tieba.ck5;
import com.baidu.tieba.d05;
import com.baidu.tieba.du4;
import com.baidu.tieba.dx4;
import com.baidu.tieba.e49;
import com.baidu.tieba.e55;
import com.baidu.tieba.e6a;
import com.baidu.tieba.eb9;
import com.baidu.tieba.eu4;
import com.baidu.tieba.fb9;
import com.baidu.tieba.fh5;
import com.baidu.tieba.fi5;
import com.baidu.tieba.gi5;
import com.baidu.tieba.gn6;
import com.baidu.tieba.hi5;
import com.baidu.tieba.ib5;
import com.baidu.tieba.ix5;
import com.baidu.tieba.j45;
import com.baidu.tieba.j9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.kb9;
import com.baidu.tieba.kg;
import com.baidu.tieba.l79;
import com.baidu.tieba.lg;
import com.baidu.tieba.lg5;
import com.baidu.tieba.ll9;
import com.baidu.tieba.lw9;
import com.baidu.tieba.m39;
import com.baidu.tieba.mf5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mr5;
import com.baidu.tieba.mw5;
import com.baidu.tieba.mw6;
import com.baidu.tieba.mx5;
import com.baidu.tieba.n05;
import com.baidu.tieba.n25;
import com.baidu.tieba.n95;
import com.baidu.tieba.nb9;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.px5;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qx4;
import com.baidu.tieba.r16;
import com.baidu.tieba.r49;
import com.baidu.tieba.r69;
import com.baidu.tieba.rr5;
import com.baidu.tieba.s95;
import com.baidu.tieba.sb9;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sy5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tg;
import com.baidu.tieba.tj5;
import com.baidu.tieba.u16;
import com.baidu.tieba.u29;
import com.baidu.tieba.u79;
import com.baidu.tieba.uh5;
import com.baidu.tieba.ui;
import com.baidu.tieba.uj5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ux9;
import com.baidu.tieba.v99;
import com.baidu.tieba.vh5;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vj5;
import com.baidu.tieba.wg;
import com.baidu.tieba.xf5;
import com.baidu.tieba.xj5;
import com.baidu.tieba.y79;
import com.baidu.tieba.yj5;
import com.baidu.tieba.z99;
import com.baidu.tieba.zd5;
import com.baidu.tieba.zx9;
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
public abstract class AbsVideoPbFragment extends BaseFragment implements u16, VoiceManager.j, fb9, TbRichTextView.u, eb9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int V0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener A0;
    public LinearLayout B;
    public CustomMessageListener B0;
    public View C;
    public uj5 C0;
    public View D;
    public final NewWriteModel.d D0;
    public LinearLayout E;
    public View.OnClickListener E0;
    public ImageView F;
    public CustomMessageListener F0;
    public TextView G;
    public final j9 G0;
    public ImageView H;
    public View.OnTouchListener H0;
    public ImageView I;
    public final mw6.b I0;
    public ImageView J;
    public NewWriteModel.d J0;
    public sb9 K;
    public vj5 K0;
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
    public ReplyPrivacyCheckController f1154T;
    public final View.OnLongClickListener T0;
    public y79 U;
    public SortSwitchButton.f U0;
    public PermissionJudgePolicy V;
    public ak5 W;
    public yj5 X;
    public EditorTools Y;
    public r69 Z;
    public AbsPbActivity a;
    public PbFakeFloorModel a0;
    public long b;
    public mw6 b0;
    public RelativeLayout c;
    public int[] c0;
    public CustomViewPager d;
    public int d0;
    public VideoPbFragmentAdapter e;
    public int e0;
    public View f;
    public int f0;
    public gn6 g;
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
    public kb9 o;
    public s95 p;
    public dx4 q;
    public qe5 r;
    public final PbModel.h r0;
    public ForumManageModel s;
    public final dx4.a s0;
    public VoiceManager t;
    public uj5 t0;
    public kg<GifView> u;
    public final CustomMessageListener u0;
    public kg<TextView> v;
    public CustomMessageListener v0;
    public kg<ImageView> w;
    public final CustomMessageListener w0;
    public kg<View> x;
    public CustomMessageListener x0;
    public kg<LinearLayout> y;
    public HttpMessageListener y0;
    public kg<RelativeLayout> z;
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

    public final int A3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
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

    @Override // com.baidu.tieba.u16
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.u16
    public kg<TiebaPlusRecommendCard> G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fb9
    public AbsVideoPbFragment N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public abstract boolean T3();

    @Override // com.baidu.tieba.u16
    public kg<FestivalTipView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return null;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u16
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u16
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u16
    public void i1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048663, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.u16
    public kg<ItemCardView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return null;
        }
        return (kg) invokeV.objValue;
    }

    public abstract int q3();

    public abstract int s3();

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eb9
    public void w1(boolean z2, int i2, int i3, int i4, m39 m39Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), m39Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // com.baidu.tieba.fb9
    public PbFragment z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
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
                    this.b.a.b4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c55.e {
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

            @Override // com.baidu.tieba.c55.e
            public void onClick(c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                    c55Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements c55.e {
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

            @Override // com.baidu.tieba.c55.e
            public void onClick(c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                    c55Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, zd5 zd5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, zd5Var, writeData, antiData}) == null) {
                if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.Q() != null && this.a.Q().y1() != null) {
                        statisticItem.param("fid", this.a.Q().y1().l());
                    }
                    statisticItem.param("tid", this.a.Q().R1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.I4();
                this.a.t4(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    ib5.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.Q() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.Q().H0(postWriteCallBackData.getPostId());
                        if (this.a.o3() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.g0 = absVideoPbFragment.o3().W1();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.h0 = absVideoPbFragment2.o3().X1();
                            this.a.Q().V2(this.a.g0, this.a.h0);
                        }
                    }
                    if (this.a.d != null) {
                        this.a.d.setCurrentItem(0);
                    }
                    this.a.o.G();
                    this.a.U.c();
                    if (this.a.X != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.q4(absVideoPbFragment3.X.z());
                    }
                    this.a.I3();
                    this.a.A4(true);
                    this.a.Q().c2();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.z4(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && this.a.o3() != null) {
                            this.a.o3().f2();
                        }
                    } else if (this.a.Q().b1()) {
                        m39 y1 = this.a.Q().y1();
                        if (y1 != null && y1.N() != null && y1.N().getAuthor() != null && (userId = y1.N().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.Q().n3()) {
                            this.a.v4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.Q().n3()) {
                        this.a.v4();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        wg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    if (writeData != null) {
                        str2 = writeData.getContent();
                    }
                    absVideoPbFragment4.S2(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.X.y() || this.a.X.A()) {
                        this.a.X.w(false, postWriteCallBackData);
                    }
                    this.a.U.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.f1154T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c55 c55Var = new c55(this.a.getActivity());
                    if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                        c55Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        c55Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new b(this));
                    c55Var.setPositiveButton(R.string.open_now, new c(this));
                    c55Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (zd5Var != null || i == 227001) {
                } else {
                    this.a.y4(i, antiData, str);
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
                    this.b.a.b4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c55.e {
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

            @Override // com.baidu.tieba.c55.e
            public void onClick(c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                    c55Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements c55.e {
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

            @Override // com.baidu.tieba.c55.e
            public void onClick(c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                    c55Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, zd5 zd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, zd5Var, writeData, antiData}) == null) {
                if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.Q() != null && this.a.Q().y1() != null) {
                        statisticItem.param("fid", this.a.Q().y1().l());
                    }
                    if (this.a.Q() != null) {
                        statisticItem.param("tid", this.a.Q().R1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    ib5.b(writeData.getContent(), "4");
                }
                if (z) {
                    y79 y79Var = this.a.U;
                    if (y79Var != null) {
                        y79Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        xf5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        wg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.f1154T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c55 c55Var = new c55(this.a.getActivity());
                    if (ui.isEmpty(postWriteCallBackData.getErrorString())) {
                        c55Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        c55Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new b(this));
                    c55Var.setPositiveButton(R.string.open_now, new c(this));
                    c55Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    if (absVideoPbFragment.U != null) {
                        if (absVideoPbFragment.Z != null && this.a.Z.f() != null && this.a.Z.f().y()) {
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
                y79 y79Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (y79Var = this.a.c.U) != null && y79Var.g() != null) {
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
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = vi.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = vi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = vi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.c0[1] + absVideoPbFragment.d0) - i2;
                if (absVideoPbFragment.C3() != null) {
                    this.c.C3().smoothScrollBy(0, i3);
                }
                if (this.c.Z != null) {
                    this.c.X.b().setVisibility(8);
                    this.c.Z.t(this.a, this.b, this.c.D3(), (this.c.Q() == null || this.c.Q().y1() == null || this.c.Q().y1().N() == null || !this.c.Q().y1().N().isBjh()) ? false : false);
                    this.c.Z.q(this.c.q3());
                    ck5 f = this.c.Z.f();
                    if (f != null && this.c.Q() != null && this.c.Q().y1() != null) {
                        f.H(this.c.Q().y1().c());
                        f.d0(this.c.Q().y1().N());
                    }
                    if (this.c.U.f() == null && this.c.Z.f().u() != null) {
                        this.c.Z.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.U.n(absVideoPbFragment2.Z.f().u().i());
                        this.c.Z.f().N(this.c.C0);
                    }
                }
                this.c.G3();
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
                y79 y79Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (y79Var = this.a.c.U) != null && y79Var.g() != null) {
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
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = vi.j(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = vi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = vi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.c0[1] + absVideoPbFragment.d0) - i2;
                if (absVideoPbFragment.C3() != null) {
                    this.c.C3().smoothScrollBy(0, i3);
                }
                if (this.c.Z != null) {
                    this.c.X.b().setVisibility(8);
                    this.c.Z.t(this.a, this.b, this.c.D3(), (this.c.Q() == null || this.c.Q().y1() == null || this.c.Q().y1().N() == null || !this.c.Q().y1().N().isBjh()) ? false : false);
                    this.c.Z.q(this.c.q3());
                    ck5 f = this.c.Z.f();
                    if (f != null && this.c.Q() != null && this.c.Q().y1() != null) {
                        f.H(this.c.Q().y1().c());
                        f.d0(this.c.Q().y1().N());
                    }
                    if (this.c.U.f() == null && this.c.Z.f().u() != null) {
                        this.c.Z.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.U.n(absVideoPbFragment2.Z.f().u().i());
                        this.c.Z.f().N(this.c.C0);
                    }
                }
                this.c.G3();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e6a) && customResponsedMessage.getOrginalMessage().getTag() == this.a.o.D) {
                e6a e6aVar = (e6a) customResponsedMessage.getData();
                this.a.o.W();
                SparseArray<Object> sparseArray = (SparseArray) this.a.o.P();
                DataRes dataRes = e6aVar.a;
                boolean z = false;
                if (e6aVar.c == 0 && dataRes != null) {
                    int e = tg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (ui.isEmpty(str)) {
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
                u29 u29Var = (u29) customResponsedMessage.getData();
                int type = u29Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (u29Var.a() == null) {
                                this.a.g4(false, null);
                                return;
                            } else {
                                this.a.g4(true, (MarkData) u29Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.h3((ForumManageModel.b) u29Var.a(), false);
                    return;
                }
                this.a.h4((e49) u29Var.a());
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
                kb9 kb9Var = this.a.o;
                if (tag == kb9Var.D) {
                    kb9Var.W();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    m39 y1 = this.a.Q().y1();
                    if (y1 != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.setUserId(str);
                        y1.v().add(muteUser);
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
                        if (ui.isEmpty(errorString2)) {
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
            this.a.F4();
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
                kb9 kb9Var = this.a.o;
                if (tag == kb9Var.D) {
                    kb9Var.W();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (ui.isEmpty(muteMessage)) {
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
            this.a.D4();
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
            this.a.M4();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements uj5 {
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

        @Override // com.baidu.tieba.uj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                y79 y79Var = this.a.U;
                if (y79Var != null && y79Var.g() != null && this.a.U.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.U.g().c());
                    if (this.a.Z != null && this.a.Z.f() != null && this.a.Z.f().y()) {
                        this.a.Z.f().w(this.a.U.h());
                    }
                    this.a.U.b(true);
                    return true;
                }
                return !this.a.Y2(ReplyPrivacyCheckController.TYPE_FLOOR);
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
                if (absVideoPbFragment.f1154T != null && absVideoPbFragment.Q() != null && this.a.Q().y1() != null && this.a.Q().y1().c() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.f1154T.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.Q().y1().c().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.X.o0();
                this.a.f3();
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
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.h(true);
                    bdTopToast.g(this.a.getString(R.string.block_user_success));
                    bdTopToast.i((ViewGroup) this.a.getView());
                    this.a.w4(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.h(false);
                bdTopToast2.g(errorString);
                bdTopToast2.i((ViewGroup) this.a.getView());
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
            this.a.d4();
            if (this.a.Q() != null && this.a.Q().y1() != null && this.a.Q().y1().N() != null && this.a.Q().y1().N().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.Q().S1()).param("fid", this.a.Q().y1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.Q().R1()).param("fid", this.a.Q().y1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.a.Q().getForumId());
                statisticItem.param("tid", this.a.Q().R1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.r3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 11);
                statisticItem.param("obj_locate", this.a.q3());
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
                layoutParams.height = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
                this.a.B.setLayoutParams(layoutParams);
                this.a.j4();
                if (this.a.o3() != null) {
                    this.a.o3().f2();
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
                absVideoPbFragment.q4(absVideoPbFragment.X.z());
            }
            this.a.A4(false);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements dx4.a {
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

        @Override // com.baidu.tieba.dx4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.u4();
                if (z && this.a.Q() != null) {
                    if (this.a.q != null) {
                        this.a.q.h(z2);
                    }
                    this.a.Q().m3(z2);
                    if (this.a.Q().y1() != null && (N = this.a.Q().y1().N()) != null) {
                        if (z2) {
                            N.collectNum++;
                        } else {
                            int i = N.collectNum;
                            if (i > 0) {
                                N.collectNum = i - 1;
                            }
                        }
                    }
                    if (!this.a.Q().j1()) {
                        if (this.a.o3() != null) {
                            this.a.o3().f2();
                        }
                    } else {
                        this.a.W3();
                    }
                    if (z2) {
                        if (this.a.q != null) {
                            if (this.a.q.f() != null && this.a.Q() != null && this.a.Q().y1() != null && this.a.Q().y1().N() != null && this.a.Q().y1().N().getAuthor() != null) {
                                MarkData f = this.a.q.f();
                                MetaData author = this.a.Q().y1().N().getAuthor();
                                if (f != null && author != null) {
                                    if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                        this.a.o.v0(author);
                                    } else {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00fd);
                                    }
                                } else {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.R2();
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
    public class h extends j9 {
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

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.Q() != null) {
                    switch (this.a.s.getLoadDataMode()) {
                        case 0:
                            this.a.Q().c2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.h3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.i3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.j3(absVideoPbFragment.s.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.i3(absVideoPbFragment2.s.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.o.e0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.i3(absVideoPbFragment3.s.getLoadDataMode(), false, null, false);
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
                this.a.j4();
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
        public void a(jy9 jy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jy9Var) == null) {
                this.a.a0.l0(jy9Var);
                if (this.a.o3() != null) {
                    this.a.o3().f2();
                }
                this.a.Z.g();
                this.a.Y.s();
                this.a.A4(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements mw6.b {
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

        @Override // com.baidu.tieba.mw6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    r49.d();
                } else {
                    r49.c();
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
                kb9 kb9Var = this.a.o;
                if (kb9Var != null) {
                    kb9Var.G();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.Q() != null && !this.a.Q().isLoading) {
                    this.a.I4();
                    this.a.v4();
                    z = true;
                    if (this.a.Q().y1() != null && this.a.Q().y1().f != null && this.a.Q().y1().f.size() > i) {
                        int intValue = this.a.Q().y1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.Q().S1()).param("fid", this.a.Q().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.Q().q3(intValue)) {
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
    public class l implements c55.e {
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

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) && c55Var != null) {
                c55Var.dismiss();
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
        public void onNavigationButtonClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c55Var) == null) {
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
                this.a.j4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ c55 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public n(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, c55Var};
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
            this.c = c55Var;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
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
                this.d.J4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements vh5 {
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

        @Override // com.baidu.tieba.vh5
        public void C(uh5 uh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uh5Var) == null) {
                Object obj = uh5Var.c;
                if ((obj instanceof cd5) && EmotionGroupType.isSendAsPic(((cd5) obj).getType())) {
                    if (this.a.V == null) {
                        this.a.V = new PermissionJudgePolicy();
                    }
                    this.a.V.clearRequestPermissionList();
                    this.a.V.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.V.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.X.f((cd5) uh5Var.c);
                    this.a.X.w(false, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ c55 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public o(AbsVideoPbFragment absVideoPbFragment, MarkData markData, c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, c55Var};
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
            this.b = c55Var;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.J4();
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
            y79 y79Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (y79Var = this.a.U) != null && y79Var.e() != null) {
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
    public class q implements vj5 {
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

        @Override // com.baidu.tieba.vj5
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
                if (view2.getId() == R.id.obfuscated_res_0x7f091a4f) {
                    if (this.a.Q() != null) {
                        this.a.Q().w2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.Q().R1());
                    statisticItem2.param("fid", this.a.Q().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", this.a.Q().getForumId());
                    statisticItem3.param("tid", this.a.Q().R1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", this.a.r3());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 3);
                    statisticItem3.param("obj_locate", this.a.q3());
                    TiebaStatic.log(statisticItem3);
                    if (!this.a.A) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof jy9) {
                                jy9 jy9Var = (jy9) obj;
                                if (this.a.Q() == null || this.a.Q().y1() == null || this.a.a0 == null || jy9Var.p() == null || jy9Var.D() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.Z != null) {
                                    this.a.Z.g();
                                }
                                e49 e49Var = new e49();
                                e49Var.v(this.a.Q().y1().k());
                                e49Var.z(this.a.Q().y1().N());
                                e49Var.x(jy9Var);
                                this.a.a0.q0(e49Var);
                                this.a.a0.setPostId(jy9Var.O());
                                this.a.V3(view2, jy9Var.p().getUserId(), "", jy9Var);
                                TiebaStatic.log("c11743");
                                bb9.b(this.a.Q().y1(), jy9Var, jy9Var.d0, 8, 1);
                                if (this.a.X != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.q4(absVideoPbFragment.X.z());
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
                    if (view2.getId() == R.id.pb_video_more && this.a.getPageContext().getPageActivity() != null && this.a.Q() != null && this.a.a != null && this.a.a.getIntent() != null) {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.Q().R1(), false, true);
                            this.a.p4(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.Q().R1(), true, false);
                            this.a.p4(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.Q().getForumId());
                        statisticItem4.param("fname", this.a.Q().X0());
                        statisticItem4.param("tid", this.a.Q().R1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.o3() == null || this.a.o3().a2() == null || view2 != this.a.o3().a2()) && view2.getId() != R.id.pb_more) {
                        kb9 kb9Var = this.a.o;
                        if (kb9Var != null && kb9Var.R() != null && view2 == this.a.o.R().y()) {
                            this.a.o.J();
                            return;
                        }
                        kb9 kb9Var2 = this.a.o;
                        if ((kb9Var2 == null || kb9Var2.R() == null || view2 != this.a.o.R().C()) && view2.getId() != R.id.obfuscated_res_0x7f090b4f && view2.getId() != R.id.obfuscated_res_0x7f091e2d) {
                            if (this.a.o.R() != null && view2 == this.a.o.R().E()) {
                                if (this.a.Q() == null) {
                                    return;
                                }
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.I4();
                                this.a.v4();
                                this.a.Q().k3(1);
                                return;
                            }
                            kb9 kb9Var3 = this.a.o;
                            if (kb9Var3 != null && kb9Var3.R() != null && view2 == this.a.o.R().C()) {
                                this.a.o.J();
                                return;
                            }
                            kb9 kb9Var4 = this.a.o;
                            if (kb9Var4 != null && ((kb9Var4.R() != null && view2 == this.a.o.R().K()) || view2.getId() == R.id.obfuscated_res_0x7f091a90)) {
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                } else if (this.a.m) {
                                    view2.setTag(Integer.valueOf(this.a.Q().O1()));
                                    return;
                                } else {
                                    this.a.I4();
                                    this.a.v4();
                                    this.a.o.D0(view2);
                                    return;
                                }
                            }
                            kb9 kb9Var5 = this.a.o;
                            if (kb9Var5 != null && kb9Var5.R() != null && view2 == this.a.o.R().J()) {
                                if (this.a.Q() == null || this.a.Q().y1() == null || this.a.Q().y1().N() == null) {
                                    return;
                                }
                                this.a.o.J();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment2 = this.a;
                                absVideoPbFragment2.o.V(absVideoPbFragment2.Q().y1().N().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091a1a) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                kb9 kb9Var6 = this.a.o;
                                if (kb9Var6 != null) {
                                    kb9Var6.u0(sparseArray);
                                }
                            } else {
                                kb9 kb9Var7 = this.a.o;
                                if (kb9Var7 != null && kb9Var7.R() != null && view2 == this.a.o.R().H()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                    this.a.onChangeSkinType(skinType);
                                    UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                    if (skinType == 0) {
                                        TbadkCoreApplication.getInst().setSkinType(4);
                                    } else {
                                        n95.m().w("key_is_follow_system_mode", false);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                    }
                                    this.a.o.K();
                                    return;
                                }
                                kb9 kb9Var8 = this.a.o;
                                if (kb9Var8 != null && kb9Var8.R() != null && view2 == this.a.o.R().I()) {
                                    this.a.o.K();
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.o.B0(absVideoPbFragment3.N0);
                                    return;
                                }
                                kb9 kb9Var9 = this.a.o;
                                if (kb9Var9 != null && kb9Var9.R() != null && view2 == this.a.o.R().B()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.Q().R1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.o.J();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                kb9 kb9Var10 = this.a.o;
                                if (kb9Var10 != null && (view2 == kb9Var10.N() || (this.a.o.R() != null && (view2 == this.a.o.R().F() || view2 == this.a.o.R().G())))) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.Q() == null || this.a.Q().y1() == null || this.a.s.n0()) {
                                        return;
                                    } else {
                                        this.a.o.G();
                                        if (this.a.o.R() != null && view2 == this.a.o.R().G()) {
                                            i3 = this.a.Q().y1().N().getIs_top() == 1 ? 5 : 4;
                                        } else if (this.a.o.R() != null && view2 == this.a.o.R().F()) {
                                            i3 = this.a.Q().y1().N().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i3 = view2 == this.a.o.N() ? 2 : 0;
                                        }
                                        ForumData k = this.a.Q().y1().k();
                                        String name = k.getName();
                                        String id = k.getId();
                                        String id2 = this.a.Q().y1().N().getId();
                                        this.a.showProgressBar();
                                        this.a.s.r0(id, name, id2, i3, this.a.o.O());
                                        return;
                                    }
                                }
                                kb9 kb9Var11 = this.a.o;
                                if (kb9Var11 != null && kb9Var11.R() != null && view2 == this.a.o.R().A()) {
                                    if (this.a.Q() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.a.o.G();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    SparseArray<Object> v3 = absVideoPbFragment4.v3(absVideoPbFragment4.Q().y1(), this.a.Q().Q1(), 1);
                                    if (v3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.Q().y1().k().getId(), this.a.Q().y1().k().getName(), this.a.Q().y1().N().getId(), String.valueOf(this.a.Q().y1().U().getUserId()), (String) v3.get(R.id.tag_forbid_user_name), (String) v3.get(R.id.tag_forbid_user_name_show), (String) v3.get(R.id.tag_forbid_user_post_id), (String) v3.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                kb9 kb9Var12 = this.a.o;
                                if (kb9Var12 != null && kb9Var12.R() != null && view2 == this.a.o.R().u()) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> v32 = absVideoPbFragment5.v3(absVideoPbFragment5.Q().y1(), this.a.Q().Q1(), 1);
                                    if (v32 != null) {
                                        this.a.o.i0(((Integer) v32.get(R.id.tag_del_post_type)).intValue(), (String) v32.get(R.id.tag_del_post_id), ((Integer) v32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) v32.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.a.o.J();
                                    if (this.a.Q() == null || this.a.Q().y1() == null || this.a.Q().y1().N() == null) {
                                        return;
                                    }
                                    ThreadData N = this.a.Q().y1().N();
                                    StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem5.param("tid", N.getId());
                                    statisticItem5.param("fid", N.getFid());
                                    statisticItem5.param("fname", N.getForum_name());
                                    TiebaStatic.log(statisticItem5);
                                    StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem6.param("tid", N.getId());
                                    statisticItem6.param("fid", N.getFid());
                                    statisticItem6.param("fname", N.getForum_name());
                                    statisticItem6.param("obj_source", 3);
                                    TiebaStatic.log(statisticItem6);
                                    return;
                                }
                                kb9 kb9Var13 = this.a.o;
                                if (kb9Var13 != null && kb9Var13.R() != null && view2 == this.a.o.R().z()) {
                                    if (this.a.Q() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> v33 = absVideoPbFragment6.v3(absVideoPbFragment6.Q().y1(), this.a.Q().Q1(), 1);
                                    if (v33 != null) {
                                        if (StringUtils.isNull((String) v33.get(R.id.tag_del_multi_forum))) {
                                            this.a.o.f0(((Integer) v33.get(R.id.tag_del_post_type)).intValue(), (String) v33.get(R.id.tag_del_post_id), ((Integer) v33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) v33.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.a.o.g0(((Integer) v33.get(R.id.tag_del_post_type)).intValue(), (String) v33.get(R.id.tag_del_post_id), ((Integer) v33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) v33.get(R.id.tag_del_post_is_self)).booleanValue(), (String) v33.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.a.o.J();
                                } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092214 && view2.getId() != R.id.obfuscated_res_0x7f091a1c && view2.getId() != R.id.obfuscated_res_0x7f0918a7 && view2.getId() != R.id.obfuscated_res_0x7f091a82) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091a80 && view2.getId() != R.id.obfuscated_res_0x7f091c5d && view2.getId() != R.id.obfuscated_res_0x7f091a16) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091a03 && view2.getId() != R.id.collect_num_container) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091a08 && view2.getId() != R.id.share_more_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091a05 && view2.getId() != R.id.thread_info_commont_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f092687) {
                                                        if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                            if (this.a.Q() == null) {
                                                                return;
                                                            }
                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                            statisticItem7.param("tid", this.a.Q().R1());
                                                            statisticItem7.param("fid", this.a.Q().getForumId());
                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem7.param("obj_locate", 2);
                                                            TiebaStatic.log(statisticItem7);
                                                            return;
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091a46 && view2.getId() != R.id.obfuscated_res_0x7f091a10) {
                                                            if (view2.getId() == R.id.obfuscated_res_0x7f09120e) {
                                                                this.a.j4();
                                                                return;
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09085c && view2.getId() != R.id.obfuscated_res_0x7f090b4c) {
                                                                if (this.a.o.R() != null && view2 == this.a.o.R().x()) {
                                                                    this.a.o.G();
                                                                    if (this.a.Q() != null) {
                                                                        this.a.g.f(this.a.Q().R1());
                                                                    }
                                                                    if (this.a.Q() != null && this.a.Q().isPrivacy()) {
                                                                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                        if (this.a.Q().y1() != null) {
                                                                            this.a.g.d(3, 3, this.a.Q().y1().P());
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    this.a.g.b();
                                                                    int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.Q() == null || this.a.Q().y1() == null || this.a.Q().y1().P() == null || !this.a.Q().y1().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                    if (this.a.Q() == null || this.a.Q().y1() == null) {
                                                                        return;
                                                                    }
                                                                    this.a.g.d(3, i5, this.a.Q().y1().P());
                                                                    return;
                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a1e || view2.getId() == R.id.obfuscated_res_0x7f091a7a) {
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.Q().R1());
                                                                    statisticItem8.param("fid", this.a.Q().getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    StatisticItem statisticItem9 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                    statisticItem9.param("fid", this.a.Q().getForumId());
                                                                    statisticItem9.param("tid", this.a.Q().R1());
                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem9.param("post_id", this.a.r3());
                                                                    statisticItem9.param("obj_source", 1);
                                                                    statisticItem9.param("obj_type", 2);
                                                                    statisticItem9.param("obj_locate", this.a.q3());
                                                                    TiebaStatic.log(statisticItem9);
                                                                    this.a.o.n0(false);
                                                                    this.a.o.Q().onLongClick(view2);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof jy9)) {
                                                                    return;
                                                                }
                                                                jy9 jy9Var2 = (jy9) sparseArray2.get(R.id.tag_load_sub_data);
                                                                View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                if (jy9Var2 == null || view3 == null) {
                                                                    return;
                                                                }
                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09085d);
                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f09085e);
                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b4c);
                                                                if (jy9Var2.x0()) {
                                                                    jy9Var2.Y0(false);
                                                                    z99.e(jy9Var2);
                                                                } else {
                                                                    if (this.a.Q() != null ? z99.c(this.a.Q().y1(), jy9Var2) : false) {
                                                                        jy9Var2.Y0(true);
                                                                        findViewById.setVisibility(0);
                                                                    }
                                                                }
                                                                SkinManager.setBackgroundColor(findViewById, jy9Var2.x0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                SkinManager.setViewTextColor(eMTextView, jy9Var2.x0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                WebPManager.setPureDrawable(imageView, jy9Var2.x0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, jy9Var2.x0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                return;
                                                            }
                                                        } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                            String s = n95.m().s("tail_link", "");
                                                            if (!StringUtils.isNull(s)) {
                                                                TiebaStatic.log("c10056");
                                                                qx4.x(view2.getContext(), string, s, true, true, true);
                                                            }
                                                            this.a.j4();
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (this.a.g0 >= 0) {
                                                        if (this.a.Q() != null) {
                                                            this.a.Q().R2();
                                                        }
                                                        if (this.a.o3() != null && this.a.o3().H1() != null) {
                                                            this.a.o3().H1().r(this.a.Q().y1());
                                                        }
                                                        this.a.g0 = 0;
                                                        this.a.h0 = Integer.MIN_VALUE;
                                                        if (this.a.Q() == null || this.a.o3() == null) {
                                                            return;
                                                        }
                                                        this.a.o3().m2(this.a.Q().r1(), this.a.Q().q1());
                                                        this.a.Q().V2(0, 0);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.Q() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                                    if (absVideoPbFragment7.o == null || absVideoPbFragment7.d == null || this.a.Q().y1() == null || this.a.Q().y1().N() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    m39 y1 = this.a.Q().y1();
                                                    if (y1.N().getReply_num() == 0) {
                                                        this.a.d4();
                                                        return;
                                                    } else if (this.a.o3() == null || this.a.C3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.Q().R1()).param("fid", this.a.Q().y1().l()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int j = (int) (vi.j(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView C3 = this.a.C3();
                                                        if (C3 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = C3.canScrollVertically(1);
                                                        boolean canScrollVertically2 = C3.canScrollVertically(-1);
                                                        if (C3.getLayoutManager() == null || !(C3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) C3.getLayoutManager();
                                                        if (canScrollVertically2 || !canScrollVertically) {
                                                            str = "obj_source";
                                                            int firstVisiblePosition = C3.getFirstVisiblePosition();
                                                            View childAt = C3.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.e0 = firstVisiblePosition;
                                                            this.a.f0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-j) || C3.getCount() < 6)) {
                                                                C3.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                C3.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        } else if (this.a.e0 == -1 && this.a.f0 == Integer.MIN_VALUE) {
                                                            return;
                                                        } else {
                                                            if (this.a.e0 > 3 || (this.a.e0 == 3 && this.a.f0 < (-j))) {
                                                                str = "obj_source";
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + j);
                                                                C3.smoothScrollBy(0, j);
                                                            } else if (this.a.e0 >= 2) {
                                                                str = "obj_source";
                                                                int i6 = j / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + i6);
                                                                C3.smoothScrollBy(0, i6);
                                                            } else {
                                                                str = "obj_source";
                                                                if (this.a.e0 == 1) {
                                                                    int i7 = j / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + i7);
                                                                    C3.smoothScrollBy(0, i7);
                                                                } else {
                                                                    C3.smoothScrollBy(0, -this.a.f0);
                                                                }
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        }
                                                        TiebaStatic.log(param);
                                                        mr5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem10 = new StatisticItem("c12942");
                                                        statisticItem10.param("obj_type", i2);
                                                        statisticItem10.param("obj_locate", 4);
                                                        statisticItem10.param("tid", this.a.Q().R1());
                                                        statisticItem10.param("nid", y1.N().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem10);
                                                        if (this.a.Q() == null || this.a.Q().y1() == null || this.a.Q().y1().N() == null || this.a.Q().y1().N().getAuthor() == null) {
                                                            return;
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.Q().R1()).param("fid", this.a.Q().y1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem11.param("fid", this.a.Q().getForumId());
                                                        statisticItem11.param("tid", this.a.Q().R1());
                                                        statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem11.param("post_id", this.a.r3());
                                                        statisticItem11.param(str, 1);
                                                        statisticItem11.param("obj_type", 12);
                                                        statisticItem11.param("obj_locate", this.a.q3());
                                                        TiebaStatic.log(statisticItem11);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            this.a.F3(true);
                                        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                        } else {
                                            AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                            if (absVideoPbFragment8.o == null || absVideoPbFragment8.Q() == null || this.a.o3() == null) {
                                                return;
                                            }
                                            this.a.o.G();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091a03 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.W2(11009) || this.a.Q() == null) {
                                                    return;
                                                }
                                                this.a.X3();
                                                if (this.a.Q().y1() != null && this.a.Q().y1().N() != null && this.a.Q().y1().N().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.Q().R1()).param("fid", this.a.Q().y1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                    StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem12.param("fid", this.a.Q().getForumId());
                                                    statisticItem12.param("tid", this.a.Q().R1());
                                                    statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem12.param("post_id", this.a.r3());
                                                    statisticItem12.param("obj_source", 1);
                                                    statisticItem12.param("obj_type", 13);
                                                    statisticItem12.param("obj_locate", this.a.q3());
                                                    TiebaStatic.log(statisticItem12);
                                                }
                                                if (this.a.Q().y1().N() == null || this.a.Q().y1().N().getAuthor() == null || this.a.Q().y1().N().getAuthor().getUserId() == null || this.a.q == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                                int T2 = absVideoPbFragment9.o.T(absVideoPbFragment9.Q().y1());
                                                ThreadData N2 = this.a.Q().y1().N();
                                                if (N2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (N2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (N2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = N2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.Q().R1()).param("obj_locate", 1).param("obj_id", this.a.Q().y1().N().getAuthor().getUserId()).param("obj_type", !this.a.q.e()).param("obj_source", T2).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.j = view2;
                                        }
                                    } else if (this.a.Q() == null) {
                                    } else {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a80) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.Q().R1());
                                            statisticItem13.param("fid", this.a.Q().getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091c5d) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.i = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091a80 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.i = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof jy9) {
                                                jy9 jy9Var3 = (jy9) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091a80 && (statisticItem = jy9Var3.e0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091c5d || view2.getId() == R.id.obfuscated_res_0x7f091a16) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.Q().S1()).param("fid", this.a.Q().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", jy9Var3.O()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.a.Q() == null || this.a.Q().y1() == null || this.a.a0 == null || jy9Var3.p() == null || jy9Var3.D() == 1) {
                                                    return;
                                                }
                                                if (this.a.Z != null) {
                                                    this.a.Z.g();
                                                }
                                                e49 e49Var2 = new e49();
                                                e49Var2.v(this.a.Q().y1().k());
                                                e49Var2.z(this.a.Q().y1().N());
                                                e49Var2.x(jy9Var3);
                                                this.a.a0.q0(e49Var2);
                                                this.a.a0.setPostId(jy9Var3.O());
                                                this.a.V3(view2, jy9Var3.p().getUserId(), "", jy9Var3);
                                                if (this.a.X != null) {
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                    absVideoPbFragment10.q4(absVideoPbFragment10.X.z());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918a7) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.Q().R1());
                                        statisticItem14.param("fid", this.a.Q().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem14);
                                        StatisticItem statisticItem15 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem15.param("fid", this.a.Q().getForumId());
                                        statisticItem15.param("tid", this.a.Q().R1());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("post_id", this.a.r3());
                                        statisticItem15.param("obj_source", 1);
                                        statisticItem15.param("obj_type", 8);
                                        statisticItem15.param("obj_locate", this.a.q3());
                                        TiebaStatic.log(statisticItem15);
                                    }
                                    if ((view2.getId() != R.id.obfuscated_res_0x7f091a1c && view2.getId() != R.id.obfuscated_res_0x7f091a82) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a1c) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.Q().getForumId());
                                            statisticItem16.param("tid", this.a.Q().R1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param("post_id", this.a.r3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 9);
                                            statisticItem16.param("obj_locate", this.a.q3());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                        if (!this.a.checkUpIsLogin()) {
                                            bb9.r("c10517", this.a.Q().y1().l(), 3);
                                            return;
                                        } else if (this.a.Q() == null || this.a.Q().y1() == null) {
                                            return;
                                        } else {
                                            kb9 kb9Var14 = this.a.o;
                                            if (kb9Var14 != null) {
                                                kb9Var14.G();
                                            }
                                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                            jy9 jy9Var4 = (jy9) sparseArray4.get(R.id.tag_load_sub_data);
                                            jy9 jy9Var5 = (jy9) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                            if (jy9Var4 == null) {
                                                return;
                                            }
                                            if (jy9Var4.I() == 1) {
                                                TiebaStatic.log(new StatisticItem("c12630"));
                                            }
                                            StatisticItem statisticItem17 = jy9Var4.e0;
                                            if (statisticItem17 != null) {
                                                StatisticItem copy2 = statisticItem17.copy();
                                                copy2.delete("obj_locate");
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0918a7) {
                                                    copy2.param("obj_locate", 6);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a1c) {
                                                    copy2.param("obj_locate", 8);
                                                }
                                                TiebaStatic.log(copy2);
                                            }
                                            this.a.I4();
                                            TiebaStatic.log("c11742");
                                            if (jy9Var5 != null) {
                                                this.a.G4(jy9Var4, jy9Var5, false, true);
                                                return;
                                            } else {
                                                this.a.G4(jy9Var4, null, false, false);
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
                            this.a.I4();
                            this.a.v4();
                            boolean o3 = this.a.Q().o3(this.a.r3());
                            view2.setTag(Boolean.valueOf(o3));
                            if (o3) {
                                this.a.C4();
                                i4 = 1;
                                this.a.m = true;
                            } else {
                                i4 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                        }
                    } else if (!this.a.m && this.a.Q().u2(true)) {
                        this.a.m = true;
                        if (this.a.o3() != null) {
                            this.a.o3().r2();
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
    public class r0 implements uj5 {
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

        @Override // com.baidu.tieba.uj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                y79 y79Var = this.a.U;
                if (y79Var != null && y79Var.e() != null && this.a.U.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.U.e().c());
                    if (this.a.X != null && (this.a.X.y() || this.a.X.A())) {
                        this.a.X.w(false, this.a.U.h());
                    }
                    this.a.U.a(true);
                    return true;
                }
                return !this.a.Y2(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s extends ix5<ShareItem> {
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
        @Override // com.baidu.tieba.ix5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel Q = this.b.Q();
                if (Q != null) {
                    Q.Y2(this.a);
                }
                return v99.c(this.b.n3(), 2, Q);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements lg<ImageView> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
                    foreDrawableImageView.R();
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
                    if (n05.c().g()) {
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
                    foreDrawableImageView.R();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.H();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = n05.c().g();
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
    public class t implements mw5<ShareItem> {
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
        @Override // com.baidu.tieba.mw5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.r(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements lg<GifView> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.e0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.h0();
                gifView.e0();
                gifView.setImageDrawable(null);
                gifView.i0();
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
                if (n05.c().g()) {
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
        @Override // com.baidu.tieba.lg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = n05.c().g();
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
            kb9 kb9Var = this.a.o;
            if (kb9Var != null) {
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
                    kb9Var.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements lg<View> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).o();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).n();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.y0());
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
        public void b(m39 m39Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m39Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, m39 m39Var, String str, int i4) {
            String D3;
            ci5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), m39Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09079d));
                }
                this.a.u4();
                this.a.K3();
                if (this.a.m) {
                    this.a.m = false;
                }
                this.a.A4(false);
                if (z && m39Var != null) {
                    ThreadData N = m39Var.N();
                    this.a.c4(m39Var);
                    this.a.e4(z, i, i2, i3, m39Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(m39Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(m39Var.U().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(m39Var.U().getBimg_end_time());
                    if (m39Var.F() != null && m39Var.F().size() >= 1 && m39Var.F().get(0) != null) {
                        this.a.Q().W2(m39Var.F().get(0).O());
                    } else if (m39Var.X() != null) {
                        this.a.Q().W2(m39Var.X().O());
                    }
                    if (this.a.q != null) {
                        this.a.q.h(m39Var.q());
                    }
                    AntiData c = m39Var.c();
                    if (c != null) {
                        this.a.O = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.O) && this.a.X != null && this.a.X.b() != null && (o = this.a.X.b().o(6)) != null && !TextUtils.isEmpty(this.a.O)) {
                            ((View) o).setOnClickListener(this.a.E0);
                        }
                    }
                    if (this.a.f1154T != null && N != null && N.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.getAuthor());
                        this.a.f1154T.setLikeUserData(attentionHostData);
                    }
                    if (this.a.Q() != null && this.a.Q().h2()) {
                        D3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        D3 = this.a.D3();
                    }
                    if (!StringUtils.isNull(D3)) {
                        this.a.X.d0(TbSingleton.getInstance().getAdVertiComment(m39Var.p0(), m39Var.q0(), D3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.Q().R1());
                            jSONObject.put("fid", this.a.Q().getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (this.a.o3() == null) {
                        return;
                    }
                    if (i != -1) {
                        ArrayList<jy9> arrayList = null;
                        if (this.a.Q() != null && this.a.Q().y1() != null) {
                            arrayList = this.a.Q().y1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).D() != 1)) {
                            this.a.o3().o2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else if (this.a.o3().g2()) {
                            this.a.o3().p2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0faf));
                        } else {
                            this.a.o3().p2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb0));
                        }
                    } else {
                        this.a.o3().o2("");
                    }
                    this.a.o3().T1();
                }
                lw9.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements lg<LinearLayout> {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.Q() != null && this.a.Q().H1() != i + 1) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.m4(absVideoPbFragment.A3(i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements lg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof r16.a)) {
                r16.a aVar = (r16.a) customResponsedMessage.getData();
                r16.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements Comparator<lg5> {
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
        public int compare(lg5 lg5Var, lg5 lg5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lg5Var, lg5Var2)) == null) {
                return lg5Var.compareTo(lg5Var2);
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
            zx9 zx9Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zx9) && (zx9Var = (zx9) customResponsedMessage.getData()) != null && (agreeData = zx9Var.b) != null && agreeData.agreeType == 2 && this.a.K != null && this.a.Q() != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !v99.h(this.a.Q().R1())) {
                this.a.K.o(2);
                v99.b(this.a.Q().R1());
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
            String D3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.Q() != null && this.a.Q().h2()) {
                    D3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    D3 = this.a.D3();
                }
                if (!StringUtils.isNull(D3) && this.a.Q() != null && this.a.Q().y1() != null) {
                    D3 = TbSingleton.getInstance().getAdVertiComment(this.a.Q().y1().p0(), this.a.Q().y1().q0(), D3);
                }
                if (this.a.X != null) {
                    this.a.X.d0(D3);
                }
                if (this.a.G != null) {
                    this.a.G.setText(D3);
                }
                this.a.A4(false);
                this.a.D4();
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
                    this.a.Z.f().G();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.Q() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.X != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.q4(absVideoPbFragment.X.z());
                }
                this.a.j4();
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

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.B = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092814);
            this.C = this.c.findViewById(R.id.obfuscated_res_0x7f092872);
            this.D = this.c.findViewById(R.id.obfuscated_res_0x7f091a04);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09097b);
            this.F = imageView;
            imageView.setOnClickListener(new d0(this));
            U3();
            this.G = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a07);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0919ff);
            this.E = linearLayout;
            linearLayout.setOnClickListener(new e0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a05);
            this.H = imageView2;
            imageView2.setOnClickListener(this.L0);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a03);
            this.I = imageView3;
            imageView3.setOnClickListener(this.L0);
            if (booleanExtra) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
            }
            if (T3()) {
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
                this.I.setPadding(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a08);
            this.J = imageView4;
            imageView4.setOnClickListener(this.L0);
            this.K = new sb9(this.J);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.K.f();
            }
            if (Q() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !v99.h(Q().R1())) {
                this.K.f();
                v99.b(Q().R1());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a06);
            this.L = textView;
            textView.setVisibility(0);
            A4(false);
        }
    }

    @Override // com.baidu.tieba.u16
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.u16
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            b89.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    public final void L3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) {
            mx5.b(new s(this, i3), new t(this, i3, i2));
        }
    }

    public void b4(lg5 lg5Var, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048646, this, lg5Var, i2) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.A(lg5Var, getPageContext(), i2, false);
        }
    }

    @Override // com.baidu.tieba.u16
    public void j0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048667, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.A = true;
    }

    public void t4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048705, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            kb9 kb9Var = this.o;
            if (kb9Var == null) {
                return;
            }
            if (z2) {
                kb9Var.G();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.o.H();
            } else {
                this.o.G();
            }
        }
    }

    public void A4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) != null) || this.D == null) {
            return;
        }
        q4(this.X.z());
        if (this.N) {
            B4(z2);
        } else {
            H3(z2);
        }
    }

    public final void E4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            nb9.c(V(), n3(), i2);
        }
    }

    public void a4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048644, this, i2) == null) && i2 == 0) {
            lw9.g().h(getUniqueId(), false);
            if (C3() != null) {
                U2(C3(), true);
            }
        }
    }

    public final void m4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048675, this, i2) == null) && Q() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(Q().R1());
            sendMessage(privacySettingMessage);
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
            U3();
        }
    }

    public final void p4(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).c2());
            }
        }
    }

    public void q4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z2) == null) {
            this.N = z2;
        }
    }

    public void r4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z2) == null) {
            this.m = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) {
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

    public final void x4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048717, this, z2) == null) {
            this.X.Y(z2);
            this.X.b0(z2);
            this.X.j0(z2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048686, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(s3(), viewGroup, false);
            R3();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.u16
    public kg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.y == null) {
                this.y = new kg<>(new v0(this), 15, 0);
            }
            return this.y;
        }
        return (kg) invokeV.objValue;
    }

    public void C4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(0);
        }
    }

    public String D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!ui.isEmpty(this.M)) {
                return this.M;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(u79.g());
            this.M = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void D4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.setTag(Boolean.TRUE);
        }
    }

    public void G3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.D == null) {
            return;
        }
        this.C.setVisibility(8);
        this.D.setVisibility(8);
    }

    public void H4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.C();
            this.l.setAnimationListener(null);
        }
    }

    public void I3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (editorTools = this.Y) != null) {
            editorTools.q();
        }
    }

    public final void I4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    public void J3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.a.getCurrentFocus() != null) {
            vi.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final void J4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.V1();
        }
    }

    public void K3() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(8);
        }
    }

    public void L4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            yj5 yj5Var = this.X;
            if (yj5Var != null) {
                q4(yj5Var.z());
            }
            j4();
            this.o.G();
        }
    }

    @Override // com.baidu.tieba.fb9
    public PbModel.h M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.r0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            n4(this.X.b());
        }
    }

    @Override // com.baidu.tieba.fb9
    public PbModel Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.a.K1();
        }
        return (PbModel) invokeV.objValue;
    }

    public void Q3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || (editorTools = this.Y) == null) {
            return;
        }
        editorTools.j();
        G3();
    }

    @Override // com.baidu.tieba.u16
    public kg<RelativeLayout> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            kg<RelativeLayout> kgVar = new kg<>(new w0(this), 10, 0);
            this.z = kgVar;
            return kgVar;
        }
        return (kg) invokeV.objValue;
    }

    public boolean S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            EditorTools editorTools = this.Y;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && this.F != null) {
            g3();
            this.F.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    @Override // com.baidu.tieba.fb9
    public AbsPbActivity V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public final boolean V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbModel Q = Q();
            if (Q != null && Q.y1() != null) {
                return AntiHelper.b(getPageContext(), Q.y1().N());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u16
    public kg<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.w == null) {
                this.w = new kg<>(new s0(this), 8, 0);
            }
            return this.w;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u16
    public kg<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.x == null) {
                this.x = new kg<>(new u0(this), 8, 0);
            }
            return this.x;
        }
        return (kg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u16
    public kg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.v == null) {
                this.v = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.v;
        }
        return (kg) invokeV.objValue;
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            i4();
            I3();
            this.Z.g();
            A4(false);
        }
    }

    public void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.e0 = -1;
            this.f0 = Integer.MIN_VALUE;
        }
    }

    public qe5 l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.r;
        }
        return (qe5) invokeV.objValue;
    }

    public LinearLayout m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.E;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.e.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            this.l.setFallingFeedbackListener(new y0(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            super.onStart();
            y0().onStart(getPageContext());
        }
    }

    public View.OnClickListener t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.L0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048707, this) == null) && Q() != null && !ui.isEmpty(Q().R1())) {
            super.taskStart();
        }
    }

    public View.OnClickListener u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            return this.M0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            hideProgressBar();
            if (o3() != null) {
                o3().T1();
                o3().U1();
            }
        }
    }

    public void v4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            vi.z(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public dx4 w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            return this.q;
        }
        return (dx4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u16
    public kg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            if (this.u == null) {
                this.u = new kg<>(new t0(this), 20, 0);
            }
            return this.u;
        }
        return (kg) invokeV.objValue;
    }

    public View.OnLongClickListener x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            return this.T0;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            if (this.t == null) {
                this.t = VoiceManager.instance();
            }
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public View.OnTouchListener y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return this.H0;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            PbModel K1 = this.a.K1();
            if (K1 == null) {
                return false;
            }
            return K1.q2();
        }
        return invokeV.booleanValue;
    }

    public yj5 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return this.X;
        }
        return (yj5) invokeV.objValue;
    }

    public final jy9 B3(m39 m39Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, m39Var)) == null) {
            if (m39Var != null && m39Var.N() != null && m39Var.N().getAuthor() != null) {
                jy9 jy9Var = new jy9();
                MetaData author = m39Var.N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = m39Var.N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                jy9Var.L0(1);
                jy9Var.R0(m39Var.N().getFirstPostId());
                jy9Var.i1(m39Var.N().getTitle());
                jy9Var.h1(m39Var.N().getCreateTime());
                jy9Var.I0(author);
                return jy9Var;
            }
            return null;
        }
        return (jy9) invokeL.objValue;
    }

    public void H3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) && this.D != null && this.G != null) {
            if (Q() != null && Q().y1() != null) {
                this.G.setText(TbSingleton.getInstance().getAdVertiComment(Q().y1().p0(), Q().y1().q0(), D3()));
            } else {
                this.G.setText(D3());
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

    public void N4(m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, m39Var) == null) {
            if (m39Var != null && AntiHelper.o(m39Var.N())) {
                sb9 sb9Var = this.K;
                if (sb9Var != null) {
                    sb9Var.l(false);
                    this.K.k();
                }
                ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.J.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            sb9 sb9Var2 = this.K;
            if (sb9Var2 != null && sb9Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.J.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.J.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void b3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bVar) == null) {
            List<jy9> list = Q().y1().S().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).e0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).e0().get(i3).O())) {
                        list.get(i2).e0().remove(i3);
                        list.get(i2).i();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).k(bVar.g);
            }
            if (z2 && o3() != null) {
                o3().f2();
            }
        }
    }

    public final void c4(m39 m39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048648, this, m39Var) != null) || m39Var == null) {
            return;
        }
        ThreadData N = m39Var.N();
        if (N != null && N.isUgcThreadType()) {
            T2();
        } else {
            s4(this.W);
        }
        yj5 yj5Var = this.X;
        if (yj5Var != null) {
            q4(yj5Var.z());
            this.X.I(m39Var.c());
            this.X.J(m39Var.k(), m39Var.U());
            this.X.l0(N);
            if (Q() != null) {
                this.X.K(Q().a1(), Q().R1(), Q().W0());
            }
            if (N != null) {
                this.X.a0(N.isMutiForumThread());
            }
        }
    }

    public void f4(m39 m39Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048656, this, m39Var) == null) && m39Var != null && m39Var.N() != null) {
            N4(m39Var);
            ImageView imageView = this.I;
            if (m39Var.i0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (m39Var.q()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String k3 = k3(m39Var.N().getReply_num());
            TextView textView = this.L;
            if (textView != null) {
                textView.setText(k3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, m39Var.N()));
        }
    }

    public final String k3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048670, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0f91);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09079d));
            if (Q() != null && Q().y1() != null) {
                boolean h1 = Q().h1();
                m39 y1 = Q().y1();
                if (h1) {
                    jy9 p3 = p3(y1);
                    if (y1.u() != null && !y1.u().equals(p3.O()) && (customViewPager = this.d) != null) {
                        customViewPager.setCurrentItem(0);
                    }
                }
            }
            this.a.M1().j(this.j0);
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
            P3(bundle);
            y0().onCreate(getPageContext());
            s95 s95Var = new s95();
            this.p = s95Var;
            s95Var.a = 1000L;
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
            this.g = new gn6(getPageContext());
            lw9.g().i(getUniqueId());
        }
    }

    public jy9 p3(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048695, this, m39Var)) == null) {
            jy9 jy9Var = null;
            if (m39Var == null) {
                return null;
            }
            if (m39Var.X() != null) {
                return m39Var.X();
            }
            if (!ListUtils.isEmpty(m39Var.F())) {
                Iterator<jy9> it = m39Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    jy9 next = it.next();
                    if (next != null && next.D() == 1) {
                        jy9Var = next;
                        break;
                    }
                }
            }
            if (jy9Var == null) {
                jy9Var = m39Var.i();
            }
            if (jy9Var == null) {
                jy9Var = B3(m39Var);
            }
            if (jy9Var != null && jy9Var.p() != null && jy9Var.p().getUserTbVipInfoData() != null && jy9Var.p().getUserTbVipInfoData().getvipIntro() != null) {
                jy9Var.p().getGodUserData().setIntro(jy9Var.p().getUserTbVipInfoData().getvipIntro());
            }
            return jy9Var;
        }
        return (jy9) invokeL.objValue;
    }

    public void B4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) && this.D != null && (textView = this.G) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f05f9);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.D.startAnimation(alphaAnimation);
            }
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    public final boolean W2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
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
            if (Q() != null) {
                Q().S2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                y0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public BdTypeRecyclerView C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<BaseFragment> it = this.e.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).Z1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void F4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && Q() != null && !ui.isEmpty(Q().R1())) {
            eu4.w().Q(du4.Z, tg.g(Q().R1(), 0L));
        }
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048632, this) != null) || Q() == null) {
            return;
        }
        m39 y1 = Q().y1();
        Q().m3(true);
        dx4 dx4Var = this.q;
        if (dx4Var != null) {
            y1.J0(dx4Var.g());
        }
        if (o3() != null) {
            o3().f2();
        }
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.o != null && Q() != null) {
                this.o.G();
                if (this.m) {
                    return;
                }
                I4();
                v4();
                if (Q().loadData()) {
                    C4();
                }
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            dx4 c2 = dx4.c(this.a);
            this.q = c2;
            if (c2 != null) {
                c2.j(this.s0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.s = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.G0);
            this.r = new qe5(getPageContext());
            this.o = new kb9(this);
        }
    }

    public final int n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (Q() != null && Q().y1() != null && Q().y1().N() != null) {
                return Q().y1().N().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            super.onResume();
            this.i0 = false;
            y0().onResume(getPageContext());
            F4();
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
            y0().onStop(getPageContext());
            lw9.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.Q0);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void D0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (r16[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), r16.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (b89.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new sy5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.u16
    public void Z(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048639, this, context, str, z2) == null) {
            if (b89.c(str) && Q() != null && Q().R1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", Q().R1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    fh5 fh5Var = new fh5();
                    fh5Var.a = str;
                    fh5Var.b = 3;
                    fh5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, fh5Var));
                }
            } else {
                b89.a().e(getPageContext(), str);
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
            r69 r69Var = this.Z;
            if (r69Var != null) {
                r69Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                E3(i3, intent);
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
                                if (m3() != null) {
                                    m3().performClick();
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
                    ll9.g().m(getPageContext());
                    return;
                }
                X3();
            }
        }
    }

    public final void E3(int i2, Intent intent) {
        hi5 hi5Var;
        r69 r69Var;
        hi5 hi5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, intent) == null) {
            if (i2 == 0) {
                I3();
                r69 r69Var2 = this.Z;
                if (r69Var2 != null) {
                    r69Var2.g();
                }
                A4(false);
            }
            j4();
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
                if (editorType == 1 && (r69Var = this.Z) != null && r69Var.f() != null) {
                    ck5 f2 = this.Z.f();
                    f2.d0(Q().y1().N());
                    f2.C(writeData);
                    f2.e0(pbEditorData.getVoiceModel());
                    gi5 p2 = f2.b().p(6);
                    if (p2 != null && (hi5Var2 = p2.m) != null) {
                        hi5Var2.C(new uh5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.X.M();
            this.X.n0(pbEditorData.getVoiceModel());
            this.X.C(writeData);
            gi5 p3 = this.X.b().p(6);
            if (p3 != null && (hi5Var = p3.m) != null) {
                hi5Var.C(new uh5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.X.H(null, null);
            }
        }
    }

    public void c3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.s.n0()) {
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
                    this.s.p0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.s.q0(Q().y1().k().getId(), Q().y1().k().getName(), Q().y1().N().getId(), str, intValue3, intValue2, booleanValue, Q().y1().N().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                if (Q().T0() != null) {
                    Q().T0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void j3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048668, this, i2, gVar) == null) && gVar != null && Q() != null && Q().y1() != null && Q().y1().N() != null) {
            i3(this.s.getLoadDataMode(), gVar.a, gVar.b, false);
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
                    Q().y1().N().setIs_good(1);
                    Q().Z2(1);
                } else if (i2 == 3) {
                    Q().y1().N().setIs_good(0);
                    Q().Z2(0);
                } else if (i2 == 4) {
                    Q().y1().N().setIs_top(1);
                    Q().a3(1);
                } else if (i2 == 5) {
                    Q().y1().N().setIs_top(0);
                    Q().a3(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                vi.Q(getPageContext().getPageActivity(), string);
            }
            if (Q().y1().N() != null && o3() != null) {
                o3().k2();
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
    public void F3(boolean z2) {
        m39 y1;
        int i2;
        sb9 sb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) && Q() != null && this.o != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (y1 = Q().y1()) == null) {
                return;
            }
            ThreadData N = y1.N();
            int i3 = 1;
            if (N != null && N.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", Q().R1()).param("fid", y1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", Q().getForumId());
                statisticItem.param("tid", Q().R1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", r3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", q3());
                TiebaStatic.log(statisticItem);
            }
            if (N != null) {
                if (N.isBJHArticleThreadType()) {
                    i2 = 2;
                } else if (N.isBJHVideoThreadType()) {
                    i2 = 3;
                } else if (N.isBJHNormalThreadType()) {
                    i2 = 4;
                } else if (N.isBJHVideoDynamicThreadType()) {
                    i2 = 5;
                }
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", Q().R1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", Q().getForumId());
                if (!z2) {
                    statisticItem2.param("obj_locate", 6);
                } else {
                    statisticItem2.param("obj_locate", 5);
                }
                statisticItem2.param("obj_name", i2);
                statisticItem2.param("obj_type", 2);
                if (N != null) {
                    if (N.isBJHArticleThreadType()) {
                        statisticItem2.param("obj_type", 10);
                    } else if (N.isBJHVideoThreadType()) {
                        statisticItem2.param("obj_type", 9);
                    } else if (N.isBJHVideoDynamicThreadType()) {
                        statisticItem2.param("obj_type", 8);
                    } else if (N.isBJHNormalThreadType()) {
                        statisticItem2.param("obj_type", 7);
                    } else if (N.isShareThread) {
                        statisticItem2.param("obj_type", 6);
                    } else {
                        int i4 = N.threadType;
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
                    statisticItem2.param("nid", N.getNid());
                    statisticItem2.param("card_type", N.getRecomCardType());
                    statisticItem2.param("recom_source", N.mRecomSource);
                    statisticItem2.param("ab_tag", N.mRecomAbTag);
                    statisticItem2.param("weight", N.mRecomWeight);
                    statisticItem2.param("extra", N.mRecomExtra);
                    statisticItem2.param("nid", N.getNid());
                    if (N.getBaijiahaoData() != null && !ui.isEmpty(N.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, N.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (V() != null) {
                    rr5.e(V(), statisticItem2);
                }
                sb9Var = this.K;
                if (sb9Var != null) {
                    statisticItem2.param("obj_param1", sb9Var.g());
                }
                TiebaStatic.log(statisticItem2);
                if (vi.F()) {
                    showToast(R.string.obfuscated_res_0x7f0f0def);
                    return;
                } else if (Q().y1() == null) {
                    vi.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0fae));
                    return;
                } else {
                    ArrayList<jy9> F = y1.F();
                    if ((F == null || F.size() <= 0) && Q().Q1()) {
                        vi.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0fae));
                        return;
                    }
                    this.o.G();
                    I4();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), N)) {
                        return;
                    }
                    sb9 sb9Var2 = this.K;
                    if (sb9Var2 != null) {
                        sb9Var2.l(false);
                        N4(y1);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i3 = 2;
                        }
                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.K.i()) {
                            this.K.m(false);
                            L3(mf5.a(), this.K.g());
                            return;
                        }
                        E4(i3);
                        return;
                    }
                    this.o.w0();
                    Q().S0().W(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", Q().R1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", Q().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            statisticItem22.param("obj_type", 2);
            if (N != null) {
            }
            if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (V() != null) {
            }
            sb9Var = this.K;
            if (sb9Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (vi.F()) {
            }
        }
    }

    public final void G4(jy9 jy9Var, jy9 jy9Var2, boolean z2, boolean z3) {
        String str;
        int i2;
        boolean z4;
        boolean z5;
        jy9 p3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{jy9Var, jy9Var2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String R1 = Q().R1();
            String O = jy9Var.O();
            if (jy9Var2 != null) {
                str = jy9Var2.O();
            } else {
                str = "";
            }
            if (Q().y1() != null) {
                i2 = Q().y1().V();
            } else {
                i2 = 0;
            }
            if (o3() != null && o3().b2() != null) {
                AbsPbActivity.e p2 = o3().b2().p(O);
                if (jy9Var != null && Q() != null && Q().y1() != null && p2 != null) {
                    if (q3() != 1 && q3() != 2 && q3() != 3 && q3() != 4 && q3() != 5) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(R1, O, "pb", true, true, null, false, str, i2, jy9Var.h0(), Q().y1().c(), false, jy9Var.p().getIconInfo(), q3(), z4).addBigImageData(p2.a, p2.b, p2.g, p2.j);
                    if (z3) {
                        addBigImageData.setHighLightPostId(str);
                        z5 = true;
                        addBigImageData.setKeyIsUseSpid(true);
                    } else {
                        z5 = true;
                    }
                    addBigImageData.setKeyFromForumId(Q().getForumId());
                    addBigImageData.setTiebaPlusData(Q().d0(), Q().Z(), Q().a0(), Q().Y(), Q().e0());
                    addBigImageData.setBjhData(Q().Q0());
                    addBigImageData.setKeyPageStartFrom(Q().x1());
                    addBigImageData.setFromFrsForumId(Q().getFromForumId());
                    addBigImageData.setWorksInfoData(Q().W1());
                    addBigImageData.setIsOpenEditor(z2);
                    if (Q().y1().n() != null) {
                        addBigImageData.setHasForumRule(Q().y1().n().has_forum_rule.intValue());
                    }
                    if (Q().y1().U() != null) {
                        addBigImageData.setIsManager(Q().y1().U().getIs_manager());
                    }
                    if (Q().y1().k().getDeletedReasonInfo() != null) {
                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(Q().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(Q().y1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    if (Q().y1().k() != null) {
                        addBigImageData.setForumHeadUrl(Q().y1().k().getImage_url());
                        addBigImageData.setUserLevel(Q().y1().k().getUser_level());
                    }
                    if (Q() != null && (p3 = p3(Q().y1())) != null) {
                        if (!p3.S && !jy9Var.S) {
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

    public final boolean K4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (Q() == null) {
                return true;
            }
            if (Q().y1() != null && Q().y1().i0()) {
                return true;
            }
            if (Q().j1()) {
                MarkData U0 = Q().U0();
                if (U0 != null && Q().h1() && C3() != null) {
                    MarkData P0 = Q().P0(C3().getFirstVisiblePosition());
                    if (P0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", U0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (P0.getPostId() != null && !P0.getPostId().equals(U0.getPostId())) {
                        c55 c55Var = new c55(getBaseFragmentActivity());
                        c55Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0296));
                        c55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04bb, new n(this, P0, U0, c55Var));
                        c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new o(this, U0, c55Var));
                        c55Var.setOnCalcelListener(new p(this));
                        c55Var.create(getBaseFragmentActivity().getPageContext());
                        c55Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", U0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (Q().y1() != null && Q().y1().F() != null && Q().y1().F().size() > 0 && Q().h1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T2() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && Q() != null && this.a != null) {
            yj5 yj5Var = this.X;
            if (yj5Var != null && yj5Var.t) {
                return;
            }
            xj5 xj5Var = new xj5();
            s4(xj5Var);
            yj5 yj5Var2 = (yj5) xj5Var.a(getContext());
            this.X = yj5Var2;
            yj5Var2.X(this.a.getPageContext());
            this.X.g0(this.D0);
            this.X.h0(this.K0);
            yj5 yj5Var3 = this.X;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            yj5Var3.B(pageContext, extras);
            this.X.b().E(true);
            n4(this.X.b());
            if (!Q().l1()) {
                this.X.q(Q().R1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.X.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (Q().h2()) {
                this.X.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.X.d0(D3());
            }
        }
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && Q() != null && Q().y1() != null && o3() != null && this.q != null) {
            MarkData markData = null;
            if (Q().y1() != null && Q().y1().i0()) {
                markData = Q().P0(0);
            } else {
                CustomViewPager customViewPager = this.d;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = Q().s1(p3(Q().y1()));
                } else if (o3() != null) {
                    markData = Q().P0(o3().Y1());
                }
            }
            if (markData == null) {
                return;
            }
            v4();
            this.q.i(markData);
            if (!this.q.e()) {
                if (Q() != null && !v99.h(Q().R1())) {
                    this.K.o(2);
                    v99.b(Q().R1());
                }
                this.q.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.q.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final String r3() {
        InterceptResult invokeV;
        ArrayList<jy9> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            if (Q() == null || Q().y1() == null || Q().y1().F() == null || (count = ListUtils.getCount((F = Q().y1().F()))) == 0) {
                return "";
            }
            if (Q().J1()) {
                Iterator<jy9> it = F.iterator();
                while (it.hasNext()) {
                    jy9 next = it.next();
                    if (next != null && next.D() == 1) {
                        return next.O();
                    }
                }
            }
            int i2 = 0;
            if (C3() != null && o3() != null) {
                i2 = o3().W1();
            }
            jy9 jy9Var = (jy9) ListUtils.getItem(F, i2);
            if (jy9Var != null && jy9Var.p() != null) {
                if (Q().r2(jy9Var.p().getUserId())) {
                    return jy9Var.O();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    jy9 jy9Var2 = (jy9) ListUtils.getItem(F, i3);
                    if (jy9Var2 == null || jy9Var2.p() == null || jy9Var2.p().getUserId() == null) {
                        break;
                    } else if (Q().r2(jy9Var2.p().getUserId())) {
                        return jy9Var2.O();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    jy9 jy9Var3 = (jy9) ListUtils.getItem(F, i4);
                    if (jy9Var3 == null || jy9Var3.p() == null || jy9Var3.p().getUserId() == null) {
                        break;
                    } else if (Q().r2(jy9Var3.p().getUserId())) {
                        return jy9Var3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void M4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && Q() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Z(Q().getForumId()) && Q().y1() != null && Q().y1().k() != null) {
            boolean z2 = true;
            if (Q().y1().k().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                Q().M0().Y(Q().getForumId(), Q().R1());
            }
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.a0 = new PbFakeFloorModel(getPageContext());
            PbModel Q = Q();
            this.a0.n0(Q.d0(), Q.Z(), Q.a0(), Q.Y(), Q.e0());
            this.a0.setFromForumId(Q.getFromForumId());
            r69 r69Var = new r69(getPageContext(), this.a0, this.c);
            this.Z = r69Var;
            r69Var.p(new h0(this));
            this.Z.s(this.J0);
            this.a0.p0(new i0(this));
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && Q() != null && Q().y1() != null && Q().y1().N() != null) {
            ThreadData N = Q().y1().N();
            N.mRecomAbTag = Q().D1();
            N.mRecomWeight = Q().G1();
            N.mRecomSource = Q().F1();
            N.mRecomExtra = Q().E1();
            N.isSubPb = Q().l1();
            if (N.getFid() == 0) {
                N.setFid(tg.g(Q().getForumId(), 0L));
            }
            StatisticItem i2 = rr5.i(getContext(), N, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            mw6 mw6Var = new mw6(getActivity());
            this.b0 = mw6Var;
            mw6Var.i(this.I0);
            this.d = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091aaf);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f09120e);
            this.k = (MaskView) this.c.findViewById(R.id.mask_view);
            this.f.setOnClickListener(this.L0);
            M3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.e = videoPbFragmentAdapter;
            this.d.setAdapter(videoPbFragmentAdapter);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f0928aa);
            this.l = (PbFallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090ac5);
            o4();
            this.l.setAnimationListener(new c0(this));
            O3();
            N3();
        }
    }

    public boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if ((Q() != null && Q().y1().i0()) || this.f1154T == null || Q() == null || Q().y1() == null || ThreadCardUtils.isSelf(Q().y1().N()) || Q().y1().c() == null) {
                return true;
            }
            return this.f1154T.checkPrivacyBeforeInvokeEditor(Q().y1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (!checkUpIsLogin()) {
                if (Q() != null) {
                    bb9.r("c10517", Q().getForumId(), 2);
                }
            } else if (!X2()) {
            } else {
                yj5 yj5Var = this.X;
                if (yj5Var != null && (yj5Var.y() || this.X.A())) {
                    this.X.w(false, null);
                    return;
                }
                if (this.Y != null) {
                    Q3();
                    if (this.Y.p(2) != null) {
                        ux9.c(getPageContext(), (View) this.Y.p(2).m, false, null);
                    }
                }
                G3();
            }
        }
    }

    public void d4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048650, this) != null) || !checkUpIsLogin() || Q() == null || Q().y1() == null || Q().y1().k() == null || V2()) {
            return;
        }
        if (Q().y1().i0()) {
            Z2();
            return;
        }
        yj5 yj5Var = this.X;
        if (yj5Var != null && yj5Var.b() != null) {
            this.X.b().C(new uh5(45, 27, null));
        }
        Z2();
    }

    public final void i4() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && this.X != null && this.Y != null) {
            tj5.a().c(0);
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
            ci5 o2 = this.Y.o(23);
            ci5 o3 = this.Y.o(2);
            ci5 o4 = this.Y.o(5);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            super.onDestroy();
            lw9.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.P0);
            ItemCardHelper.w(null);
            y0().onDestory(getPageContext());
            sb9 sb9Var = this.K;
            if (sb9Var != null) {
                sb9Var.k();
            }
            ForumManageModel forumManageModel = this.s;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.f1154T;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            kb9 kb9Var = this.o;
            if (kb9Var != null) {
                kb9Var.m0();
            }
            r69 r69Var = this.Z;
            if (r69Var != null) {
                r69Var.m();
            }
            if (Q() != null) {
                Q().cancelLoadData();
                Q().destory();
                if (Q().u1() != null) {
                    Q().u1().d();
                }
            }
            yj5 yj5Var = this.X;
            if (yj5Var != null) {
                yj5Var.E();
            }
            this.p = null;
            ux9.d();
            H4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            super.onPause();
            this.i0 = true;
            y0().onPause();
            if (Q() != null && !Q().l1()) {
                this.X.O(Q().R1());
            }
            eu4.w().E();
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.O0);
        }
    }

    public void O4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) {
            DetailInfoAndReplyFragment o3 = o3();
            if (o3 != null && o3.H1() != null && o3.H1().f() != null && o3.H1().g() != null) {
                o3.H1().f().p0(z2);
                o3.H1().g().I(z2);
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

    public boolean Y2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i2)) == null) {
            if (this.f1154T != null && Q() != null && Q().y1() != null && !ThreadCardUtils.isSelf(Q().y1().N()) && Q().y1().c() != null) {
                return this.f1154T.checkPrivacyBeforeSend(Q().y1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void n4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, editorTools) == null) {
            this.Y = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091a00);
            this.Y.setOnCancelClickListener(new m0(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.Y.getParent() == null) {
                this.c.addView(this.Y, layoutParams);
            }
            this.Y.y(TbadkCoreApplication.getInst().getSkinType());
            this.Y.setActionListener(24, new n0(this));
            I3();
            this.X.g(new o0(this));
        }
    }

    public final void s4(ak5 ak5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, ak5Var) == null) && ak5Var != null && Q() != null) {
            ak5Var.p(Q().X0());
            if (Q().y1() != null && Q().y1().k() != null) {
                ak5Var.o(Q().y1().k());
            }
            ak5Var.q("pb");
            ak5Var.r(Q());
        }
    }

    public final void w4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048714, this, i2) != null) || Q() == null) {
            return;
        }
        int H1 = Q().H1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    Q().g3(1);
                } else {
                    Q().g3(4);
                }
            } else {
                Q().g3(3);
            }
        } else {
            Q().g3(2);
        }
        int H12 = Q().H1();
        if (H1 == 4 || H12 == 4) {
            Z3();
        }
    }

    public final void P3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            ak5 ak5Var = new ak5();
            this.W = ak5Var;
            s4(ak5Var);
            yj5 yj5Var = (yj5) this.W.a(getActivity());
            this.X = yj5Var;
            yj5Var.X(this.a.getPageContext());
            this.X.g0(this.D0);
            this.X.h0(this.K0);
            this.X.Z(1);
            this.X.e0(SendView.f);
            this.X.h(SendView.f);
            this.X.B(this.a.getPageContext(), bundle);
            this.X.b().b(new fi5(getActivity()));
            this.X.b().E(true);
            x4(true);
            if (Q() != null) {
                this.X.K(Q().a1(), Q().R1(), Q().W0());
            }
            registerListener(this.v0);
            registerListener(this.x0);
            registerListener(this.F0);
            registerListener(this.u0);
            registerListener(this.w0);
            registerListener(this.y0);
            registerListener(this.S0);
            if (!Q().l1()) {
                this.X.q(Q().R1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.X.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (Q().h2()) {
                this.X.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.X.d0(D3());
            }
            this.U = new y79();
            if (this.X.s() != null) {
                this.U.m(this.X.s().i());
            }
            this.X.W(this.t0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.f1154T = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new z(this));
        }
    }

    public final void S2(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048620, this, z2, str) == null) && Q() != null && Q().y1() != null && Q().y1().N() != null) {
            ThreadData N = Q().y1().N();
            N.mRecomAbTag = Q().D1();
            N.mRecomWeight = Q().G1();
            N.mRecomSource = Q().F1();
            N.mRecomExtra = Q().E1();
            if (N.getFid() == 0) {
                N.setFid(tg.g(Q().getForumId(), 0L));
            }
            StatisticItem i2 = rr5.i(getContext(), N, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = rr5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (N.isVideoThreadType()) {
                    if (px5.e(str) > 40) {
                        str2 = px5.m(str, 40);
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
                mr5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (q3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (q3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (q3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (q3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (q3() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", Q().R1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", Q().y1().l());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = rr5.i(getContext(), N, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", Q().R1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", Q().y1().l());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = rr5.i(getContext(), N, "c14303");
            if (i4 != null) {
                if (q3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (q3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (q3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (q3() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", Q().R1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", Q().y1().l());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }

    public void U2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof jy9) && (jy9Var = (jy9) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && jy9Var.m() != null) {
                        jy9Var.m().r(jy9Var.D());
                        arrayList.add(jy9Var.m());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new x0(this));
                if (((lg5) ListUtils.getItem(arrayList, 0)).e() == 1) {
                    if (!z2) {
                        b4((lg5) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                b4((lg5) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public final void z4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048724, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    xf5.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (Q() != null && !Q().l1()) {
                antiData.setBlock_forum_name(Q().y1().k().getName());
                antiData.setBlock_forum_id(Q().y1().k().getId());
                antiData.setUser_name(Q().y1().U().getUserName());
                antiData.setUser_id(Q().y1().U().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void V3(View view2, String str, String str2, jy9 jy9Var) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048629, this, view2, str, str2, jy9Var) != null) || view2 == null || str == null || str2 == null || V2() || !X2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.c0);
            this.d0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.Z != null && jy9Var != null) {
            if (jy9Var.a0() != null) {
                str3 = jy9Var.a0().toString();
            } else {
                str3 = "";
            }
            this.Z.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), jy9Var.p().getName_show(), str3));
        }
        if (Q() != null && Q().y1() != null && Q().y1().i0()) {
            wg.a().postDelayed(new p0(this, str, str2), 0L);
            return;
        }
        wg.a().postDelayed(new q0(this, str, str2), 0L);
        if (Q() == null || Q().y1() == null || Q().y1().k() == null) {
        }
    }

    public final boolean Y3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) {
            if (StringUtils.isNull(str) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s2 = n95.m().s("bubble_link", "");
            if (StringUtils.isNull(s2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                qx4.x(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean l4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof jy9)) {
                return false;
            }
            jy9 jy9Var = (jy9) obj;
            if (!TextUtils.isEmpty(jy9Var.s()) && n05.c().g()) {
                return Y3(jy9Var.O());
            }
            if (checkUpIsLogin() && Q() != null && Q().y1() != null) {
                r69 r69Var = this.Z;
                if (r69Var != null) {
                    r69Var.g();
                }
                e49 e49Var = new e49();
                e49Var.v(Q().y1().k());
                e49Var.z(Q().y1().N());
                e49Var.x(jy9Var);
                this.a0.q0(e49Var);
                this.a0.setPostId(jy9Var.O());
                V3(view2, jy9Var.p().getUserId(), "", jy9Var);
                TiebaStatic.log("c11743");
                yj5 yj5Var = this.X;
                if (yj5Var != null) {
                    q4(yj5Var.z());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (Q().d1() || Q().g1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", Q().R1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, Q().R1()));
            if (K4()) {
                this.a.finish();
            }
        }
    }

    public void d3(c55 c55Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, c55Var, jSONArray) == null) {
            c55Var.dismiss();
            if (Q() != null && Q().y1() != null && Q().y1().N() != null && Q().y1().k() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(c55Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    c3((SparseArray) c55Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // com.baidu.tieba.u16
    public void e0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048651, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.o.o0(str);
            e55 S = this.o.S();
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

    public final void y4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048720, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new l0(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                kb9 kb9Var = this.o;
                if (kb9Var != null) {
                    kb9Var.E0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public void e3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                c3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void e4(boolean z2, int i2, int i3, int i4, m39 m39Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), m39Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.e.c()) {
                if (baseFragment instanceof eb9) {
                    ((eb9) baseFragment).w1(z2, i2, i3, i4, m39Var, str, i5);
                }
            }
            w1(z2, i2, i3, i4, m39Var, str, i5);
        }
    }

    @Override // com.baidu.tieba.fb9
    public void finish() {
        CardHListViewData p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            PbModel K1 = this.a.K1();
            if (K1 != null && K1.y1() != null && K1.y1().N() != null && !K1.y1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = K1.y1().N().getId();
                if (K1.isShareThread() && K1.y1().N().originalThreadData != null) {
                    historyMessage.threadName = K1.y1().N().originalThreadData.b;
                } else {
                    historyMessage.threadName = K1.y1().N().getTitle();
                }
                if (K1.isShareThread() && !z0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = K1.y1().k().getName();
                }
                ArrayList<jy9> F = K1.y1().F();
                if (F != null && F.size() > 0) {
                    historyMessage.postID = F.get(0).O();
                }
                historyMessage.isHostOnly = K1.b1();
                historyMessage.isSquence = K1.Q1();
                historyMessage.isShareThread = K1.isShareThread();
                historyMessage.threadType = K1.y1().N().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            yj5 yj5Var = this.X;
            if (yj5Var != null) {
                yj5Var.E();
            }
            if (K1 != null && (K1.d1() || K1.g1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", K1.R1());
                if (this.P) {
                    if (this.R) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", K1.m1());
                    }
                    if (this.Q) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", K1.i1());
                    }
                }
                if (K1.y1() != null && System.currentTimeMillis() - this.b >= 40000 && (p2 = K1.y1().p()) != null && !ListUtils.isEmpty(p2.getDataList())) {
                    intent.putExtra("guess_like_data", p2);
                }
                this.a.setResult(-1, intent);
            }
            if (K4()) {
                if (K1 != null) {
                    m39 y1 = K1.y1();
                    if (y1 != null) {
                        if (y1.U() != null) {
                            y1.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            y1.U().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.S) {
                            l79.b().q(this.d.getCurrentItem());
                            BdTypeRecyclerView C3 = C3();
                            Parcelable parcelable = null;
                            if (C3 != null) {
                                parcelable = C3.onSaveInstanceState();
                            }
                            l79.b().l(K1.z1(), parcelable, K1.Q1(), K1.b1(), false);
                        }
                    }
                } else {
                    l79.b().k();
                }
                J4();
            }
        }
    }

    public void g4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048659, this, z2, markData) != null) || Q() == null) {
            return;
        }
        u4();
        Q().m3(z2);
        dx4 dx4Var = this.q;
        if (dx4Var != null) {
            dx4Var.h(z2);
            if (markData != null) {
                this.q.i(markData);
            }
        }
        if (Q().j1()) {
            W3();
        } else if (o3() != null) {
            o3().f2();
        }
    }

    public final void h3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048661, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                c55 c55Var = new c55(getPageContext().getPageActivity());
                c55Var.setMessage(string);
                c55Var.setPositiveButton(R.string.dialog_known, new l(this));
                c55Var.setCancelable(true);
                c55Var.create(getPageContext());
                c55Var.show();
            } else {
                i3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<jy9> F = Q().y1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).O())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    Q().y1().N().setReply_num(Q().y1().N().getReply_num() - 1);
                    if (o3() != null) {
                        o3().f2();
                    }
                } else if (i3 == 0) {
                    a3();
                } else if (i3 == 2) {
                    ArrayList<jy9> F2 = Q().y1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).e0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).e0().get(i5).O())) {
                                F2.get(i4).e0().remove(i5);
                                F2.get(i4).i();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).k(bVar.g);
                    }
                    if (z3 && o3() != null) {
                        o3().f2();
                    }
                    b3(bVar);
                }
            }
        }
    }

    public void h4(e49 e49Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, e49Var) == null) && Q() != null && Q().y1() != null && e49Var.g() != null) {
            String O = e49Var.g().O();
            ArrayList<jy9> F = Q().y1().F();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= F.size()) {
                    break;
                }
                jy9 jy9Var = F.get(i2);
                if (jy9Var.O() != null && jy9Var.O().equals(O)) {
                    ArrayList<jy9> i3 = e49Var.i();
                    jy9Var.f1(e49Var.k());
                    if (jy9Var.e0() != null && i3 != null) {
                        Iterator<jy9> it = i3.iterator();
                        while (it.hasNext()) {
                            jy9 next = it.next();
                            if (jy9Var.n0() != null && next != null && next.p() != null && (metaData = jy9Var.n0().get(next.p().getUserId())) != null) {
                                next.I0(metaData);
                                next.V0(true);
                                next.p1(getPageContext(), Q().r2(metaData.getUserId()));
                            }
                        }
                        if (i3.size() != jy9Var.e0().size()) {
                            z3 = true;
                        }
                        if (!jy9Var.u0(true)) {
                            jy9Var.e0().clear();
                            jy9Var.e0().addAll(i3);
                        }
                        z2 = z3;
                    }
                    if (jy9Var.y() != null) {
                        jy9Var.G0();
                    }
                } else {
                    i2++;
                }
            }
            if (!Q().h1() && z2 && o3() != null) {
                o3().f2();
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
            d05 layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 4) {
                z2 = false;
            }
            layoutMode.l(z2);
            getBaseFragmentActivity().getLayoutMode().k(this.c);
            y79 y79Var = this.U;
            if (y79Var != null) {
                y79Var.i();
            }
            EditorTools editorTools = this.Y;
            if (editorTools != null) {
                editorTools.y(i2);
            }
            r69 r69Var = this.Z;
            if (r69Var != null) {
                r69Var.l(i2);
            }
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(vi.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (Q() != null && Q().j1()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.F, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            if (Q() != null) {
                N4(Q().y1());
            }
            SkinManager.setBackgroundColor(this.D, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.L, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.L, vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (o3() != null) {
                o3().onChangeSkinType(i2);
            }
            I4();
        }
    }

    public void i3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048664, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f1448));
            } else if (z3) {
                if (ui.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                }
                showToast(str);
            }
        }
    }

    public SparseArray<Object> v3(m39 m39Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        jy9 p3;
        boolean z3;
        n25 n25Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048710, this, new Object[]{m39Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (m39Var == null || (p3 = p3(m39Var)) == null) {
                return null;
            }
            String userId = p3.p().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, p3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(m39Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (p3.p() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, p3.p().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, p3.p().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, p3.p().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, p3.O());
                }
                sparseArray.put(R.id.tag_del_post_id, p3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(m39Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<j45> o2 = m39Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (j45 j45Var : o2) {
                        if (j45Var != null && !StringUtils.isNull(j45Var.d()) && (n25Var = j45Var.h) != null && n25Var.a && !n25Var.c && ((i3 = n25Var.b) == 1 || i3 == 2)) {
                            sb.append(ui.cutString(j45Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0766));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0537), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }
}
