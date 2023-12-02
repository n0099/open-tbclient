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
import androidx.annotation.Nullable;
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
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tbadk.editortools.DLauncher;
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
import com.baidu.tieba.a75;
import com.baidu.tieba.ah5;
import com.baidu.tieba.aw6;
import com.baidu.tieba.aw9;
import com.baidu.tieba.b6a;
import com.baidu.tieba.bh5;
import com.baidu.tieba.br6;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cp5;
import com.baidu.tieba.dh5;
import com.baidu.tieba.e1a;
import com.baidu.tieba.eh5;
import com.baidu.tieba.ey9;
import com.baidu.tieba.f05;
import com.baidu.tieba.fh5;
import com.baidu.tieba.g05;
import com.baidu.tieba.g5b;
import com.baidu.tieba.g6a;
import com.baidu.tieba.gu9;
import com.baidu.tieba.h6a;
import com.baidu.tieba.he5;
import com.baidu.tieba.hh5;
import com.baidu.tieba.ie5;
import com.baidu.tieba.iwa;
import com.baidu.tieba.jb5;
import com.baidu.tieba.jr4;
import com.baidu.tieba.k0a;
import com.baidu.tieba.l4a;
import com.baidu.tieba.l55;
import com.baidu.tieba.ld5;
import com.baidu.tieba.ll6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m1a;
import com.baidu.tieba.m6a;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mwa;
import com.baidu.tieba.nu5;
import com.baidu.tieba.o95;
import com.baidu.tieba.oo4;
import com.baidu.tieba.p6a;
import com.baidu.tieba.pb;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.po4;
import com.baidu.tieba.pua;
import com.baidu.tieba.pw9;
import com.baidu.tieba.q1a;
import com.baidu.tieba.q4a;
import com.baidu.tieba.qb;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qv4;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rd;
import com.baidu.tieba.ru5;
import com.baidu.tieba.s4a;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.st5;
import com.baidu.tieba.sx9;
import com.baidu.tieba.t1a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.te5;
import com.baidu.tieba.u6a;
import com.baidu.tieba.ue5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uu5;
import com.baidu.tieba.uy5;
import com.baidu.tieba.v85;
import com.baidu.tieba.ve5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.w4;
import com.baidu.tieba.w4a;
import com.baidu.tieba.xo5;
import com.baidu.tieba.xy5;
import com.baidu.tieba.y95;
import com.baidu.tieba.yb5;
import com.baidu.tieba.yva;
import com.baidu.tieba.z95;
import com.baidu.tieba.zg5;
import com.baidu.tieba.zv9;
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
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SpriteMemeInfo;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes7.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements xy5, VoiceManager.j, h6a, TbRichTextView.t, g6a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int U0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public CustomMessageListener A0;
    public View B;
    public ah5 B0;
    public View C;
    public final NewWriteModel.d C0;
    public LinearLayout D;
    public View.OnClickListener D0;
    public ImageView E;
    public CustomMessageListener E0;
    public TextView F;
    public final w4 F0;
    public ImageView G;
    public View.OnTouchListener G0;
    public ImageView H;
    public final aw6.b H0;
    public ImageView I;
    public NewWriteModel.d I0;
    public u6a J;
    public bh5 J0;
    public TextView K;
    public final View.OnClickListener K0;
    public String L;
    public View.OnClickListener L0;
    public boolean M;
    public final AdapterView.OnItemClickListener M0;
    public String N;
    public CustomMessageListener N0;
    public boolean O;
    public CustomMessageListener O0;
    public boolean P;
    public CustomMessageListener P0;
    public boolean Q;
    public final ItemCardHelper.c Q0;
    public boolean R;
    public CustomMessageListener R0;
    public ReplyPrivacyCheckController S;
    public final View.OnLongClickListener S0;

    /* renamed from: T  reason: collision with root package name */
    public q1a f1141T;
    public SortSwitchButton.f T0;
    public PermissionJudgePolicy U;
    public fh5 V;
    public eh5 W;
    public EditorTools X;
    public k0a Y;
    public PbFakeFloorModel Z;
    public AbsPbActivity a;
    public aw6 a0;
    public long b;
    public int[] b0;
    public RelativeLayout c;
    public int c0;
    public CustomViewPager d;
    public int d0;
    public VideoPbFragmentAdapter e;
    public int e0;
    public View f;
    public int f0;
    public ll6 g;
    public int g0;
    public View h;
    public boolean h0;
    public View i;
    @NonNull
    public TiePlusEventController.g i0;
    public View j;
    public final PbModel.h j0;
    public MaskView k;
    public PbFallingView l;
    public boolean m;
    public View n;
    public m6a o;
    public l55 p;
    public jr4 q;
    public ForumManageModel r;
    public final jr4.a r0;
    public VoiceManager s;
    public ah5 s0;
    public pb<GifView> t;
    public final CustomMessageListener t0;
    public pb<TextView> u;
    public CustomMessageListener u0;
    public pb<ImageView> v;
    public final CustomMessageListener v0;
    public pb<View> w;
    public CustomMessageListener w0;
    public pb<LinearLayout> x;
    public HttpMessageListener x0;
    public pb<RelativeLayout> y;
    public CustomMessageListener y0;
    public boolean z;
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

    @Override // com.baidu.tieba.xy5
    public pb<TiebaPlusRecommendCard> F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<ItemCardView> P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    public abstract boolean S4();

    @Override // com.baidu.tieba.xy5
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public void Y1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h6a
    public AbsVideoPbFragment h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public abstract int p4();

    @Override // com.baidu.tieba.xy5
    public pb<FestivalTipView> q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    public abstract int r4();

    @Override // com.baidu.tieba.g6a
    public void s2(boolean z2, int i2, int i3, int i4, zv9 zv9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048702, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), zv9Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h6a
    public PbFragment v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048719, this, context, str) == null) {
        }
    }

    public final int z4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048727, this, i2)) == null) {
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
                    this.b.a.c5(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                    q4a.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.l0() != null && this.a.l0().s1() != null) {
                        statisticItem.param("fid", this.a.l0().s1().o());
                    }
                    statisticItem.param("tid", this.a.l0().M1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.K5();
                this.a.u5(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    a75.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.l0() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.l0().B0(postWriteCallBackData.getPostId());
                        if (this.a.n4() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.f0 = absVideoPbFragment.n4().X2();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.g0 = absVideoPbFragment2.n4().Y2();
                            this.a.l0().P2(this.a.f0, this.a.g0);
                        }
                    }
                    if (this.a.d != null) {
                        this.a.d.setCurrentItem(0);
                    }
                    this.a.o.F();
                    this.a.f1141T.c();
                    if (this.a.W != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.r5(absVideoPbFragment3.W.C());
                    }
                    this.a.G4();
                    this.a.B5(true);
                    this.a.l0().X1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.A5(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && this.a.n4() != null) {
                            this.a.n4().g3();
                        }
                    } else if (this.a.l0().V0()) {
                        zv9 s1 = this.a.l0().s1();
                        if (s1 != null && s1.R() != null && s1.R().getAuthor() != null && (userId = s1.R().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.l0().h3()) {
                            this.a.w5();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.l0().h3()) {
                        this.a.w5();
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
                    absVideoPbFragment4.S3(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.W.B() || this.a.W.D()) {
                        this.a.W.z(false, postWriteCallBackData);
                    }
                    this.a.f1141T.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.S;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    f05 f05Var = new f05(this.a.getActivity());
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        f05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        f05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                    f05Var.setPositiveButton(R.string.open_now, new c(this));
                    f05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (o95Var != null || i == 227001) {
                } else {
                    this.a.z5(i, antiData, str);
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
                    this.b.a.c5(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                    q4a.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.l0() != null && this.a.l0().s1() != null) {
                        statisticItem.param("fid", this.a.l0().s1().o());
                    }
                    if (this.a.l0() != null) {
                        statisticItem.param("tid", this.a.l0().M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    a75.b(writeData.getContent(), "4");
                }
                if (z) {
                    q1a q1aVar = this.a.f1141T;
                    if (q1aVar != null) {
                        q1aVar.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        yb5.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.S;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    f05 f05Var = new f05(this.a.getActivity());
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        f05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        f05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                    f05Var.setPositiveButton(R.string.open_now, new c(this));
                    f05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    if (absVideoPbFragment.f1141T != null) {
                        if (absVideoPbFragment.Y != null && this.a.Y.f() != null && this.a.Y.f().A()) {
                            this.a.Y.f().x(postWriteCallBackData);
                        }
                        this.a.f1141T.l(postWriteCallBackData);
                    }
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g5b) && customResponsedMessage.getOrginalMessage().getTag() == this.a.o.B) {
                g5b g5bVar = (g5b) customResponsedMessage.getData();
                this.a.o.T();
                SparseArray<Object> sparseArray = (SparseArray) this.a.o.N();
                DataRes dataRes = g5bVar.a;
                boolean z = false;
                if (g5bVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (rd.isEmpty(str)) {
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
                    this.a.o.q0(z, sparseArray);
                } else if (intValue == 1) {
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.o.g0(sparseArray, z);
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
                gu9 gu9Var = (gu9) customResponsedMessage.getData();
                int b = gu9Var.b();
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            if (gu9Var.a() == null) {
                                this.a.i5(false, null);
                                return;
                            } else {
                                this.a.i5(true, (MarkData) gu9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.h4((ForumManageModel.b) gu9Var.a(), false);
                    return;
                }
                this.a.j5((pw9) gu9Var.a());
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
                m6a m6aVar = this.a.o;
                if (tag == m6aVar.B) {
                    m6aVar.T();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    zv9 s1 = this.a.l0().s1();
                    if (s1 != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.setUserId(str);
                        s1.y().add(muteUser);
                    }
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.mute_success));
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                        String errorString = userMuteAddResponseMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            errorString = this.a.getResources().getString(R.string.mute_error_beyond_limit);
                        }
                        this.a.o.u0(errorString);
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                        this.a.o.p0();
                    } else {
                        String errorString2 = userMuteAddResponseMessage.getErrorString();
                        if (rd.isEmpty(errorString2)) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.h0) {
                return;
            }
            this.a.H5();
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
                m6a m6aVar = this.a.o;
                if (tag == m6aVar.B) {
                    m6aVar.T();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (rd.isEmpty(muteMessage)) {
                        muteMessage = this.a.getResources().getString(R.string.un_mute_fail);
                    }
                    this.a.p.c(muteMessage);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements PbFallingView.q {
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

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.F5();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
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
            this.a.O5();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ah5 {
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

        @Override // com.baidu.tieba.ah5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                q1a q1aVar = this.a.f1141T;
                if (q1aVar != null && q1aVar.g() != null && this.a.f1141T.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.f1141T.g().c());
                    if (this.a.Y != null && this.a.Y.f() != null && this.a.Y.f().A()) {
                        this.a.Y.f().x(this.a.f1141T.h());
                    }
                    this.a.f1141T.b(true);
                    return true;
                }
                return !this.a.Y3(ReplyPrivacyCheckController.TYPE_FLOOR);
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
                if (absVideoPbFragment.S != null && absVideoPbFragment.l0() != null && this.a.l0().s1() != null && this.a.l0().s1().f() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.S.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.l0().s1().f().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.W.r0();
                this.a.f4();
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
                    this.a.x5(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Y4();
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
                absVideoPbFragment.showToast(absVideoPbFragment.N);
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
                ViewGroup.LayoutParams layoutParams = this.a.A.getLayoutParams();
                layoutParams.height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144);
                this.a.A.setLayoutParams(layoutParams);
                this.a.k5();
                if (this.a.n4() != null) {
                    this.a.n4().g3();
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
            if (this.a.W != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.r5(absVideoPbFragment.W.C());
            }
            this.a.B5(false);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements jr4.a {
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

        @Override // com.baidu.tieba.jr4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            ThreadData R;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                this.a.v5();
                if (z && this.a.l0() != null) {
                    if (this.a.q != null) {
                        this.a.q.h(z2);
                        this.a.n5(z2);
                    }
                    this.a.l0().g3(z2);
                    if (this.a.l0().s1() != null && (R = this.a.l0().s1().R()) != null) {
                        if (z2) {
                            R.collectNum++;
                        } else {
                            int i = R.collectNum;
                            if (i > 0) {
                                R.collectNum = i - 1;
                            }
                        }
                    }
                    if (!this.a.l0().d1()) {
                        if (this.a.n4() != null) {
                            this.a.n4().g3();
                        }
                    } else {
                        this.a.V4();
                    }
                    if (z2) {
                        if (this.a.q != null) {
                            if (this.a.q.f() != null && this.a.l0() != null && this.a.l0().s1() != null && this.a.l0().s1().R() != null && this.a.l0().s1().R().getAuthor() != null) {
                                MarkData f = this.a.q.f();
                                MetaData author = this.a.l0().s1().R().getAuthor();
                                if (f != null && author != null) {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0100);
                                    }
                                    BdUtilHelper.showToast(str2, 2000, true);
                                } else {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.add_mark);
                                    }
                                    BdUtilHelper.showToast(str2, 2000, true);
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.R3();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.a;
                absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends w4 {
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

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.l0() != null) {
                    switch (this.a.r.getLoadDataMode()) {
                        case 0:
                            this.a.l0().X1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.h4(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.i4(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.j4(absVideoPbFragment.r.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.i4(absVideoPbFragment2.r.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.o.b0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.i4(absVideoPbFragment3.r.getLoadDataMode(), false, null, false);
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
                this.a.k5();
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
                this.a.a0.c(motionEvent);
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
        public void a(mwa mwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mwaVar) == null) {
                this.a.Z.f0(mwaVar);
                if (this.a.n4() != null) {
                    this.a.n4().g3();
                }
                this.a.Y.g();
                this.a.X.y();
                this.a.B5(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements aw6.b {
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

        @Override // com.baidu.tieba.aw6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    sx9.d();
                } else {
                    sx9.c();
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
                this.a.o.k0(true);
                return this.a.o.O().onLongClick(view2);
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
                this.a.z = true;
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
                m6a m6aVar = this.a.o;
                if (m6aVar != null) {
                    m6aVar.F();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.l0() != null && !this.a.l0().isLoading) {
                    this.a.K5();
                    this.a.w5();
                    z = true;
                    if (this.a.l0().s1() != null && this.a.l0().s1().f != null && this.a.l0().s1().f.size() > i) {
                        int intValue = this.a.l0().s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.l0().N1()).param("fid", this.a.l0().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.l0().k3(intValue)) {
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
    public class l implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) && f05Var != null) {
                f05Var.dismiss();
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
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
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
                this.a.k5();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ f05 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public n(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, f05Var};
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
            this.c = f05Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
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
                this.d.L5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements ie5 {
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

        @Override // com.baidu.tieba.ie5
        public void U(he5 he5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, he5Var) == null) {
                Object obj = he5Var.c;
                if ((obj instanceof v85) && EmotionGroupType.isSendAsPic(((v85) obj).g())) {
                    if (this.a.U == null) {
                        this.a.U = new PermissionJudgePolicy();
                    }
                    this.a.U.clearRequestPermissionList();
                    this.a.U.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.U.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.W.g((v85) he5Var.c);
                    this.a.W.z(false, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ f05 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public o(AbsVideoPbFragment absVideoPbFragment, MarkData markData, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, f05Var};
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
            this.b = f05Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.L5();
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
            q1a q1aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (q1aVar = this.a.f1141T) != null && q1aVar.e() != null) {
                if (!this.a.f1141T.e().e()) {
                    this.a.f1141T.a(false);
                }
                this.a.f1141T.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.X == null || this.a.X.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
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
    public class p0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

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
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.E5(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class q implements bh5 {
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

        @Override // com.baidu.tieba.bh5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
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
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.E5(this.a, this.b);
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
                if (view2.getId() == R.id.obfuscated_res_0x7f091bf1) {
                    if (this.a.l0() != null) {
                        this.a.l0().s2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.l0().M1());
                    statisticItem2.param("fid", this.a.l0().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", this.a.l0().getForumId());
                    statisticItem3.param("tid", this.a.l0().M1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", this.a.q4());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 3);
                    statisticItem3.param("obj_locate", this.a.p4());
                    TiebaStatic.log(statisticItem3);
                    if (!this.a.z) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof mwa) {
                                mwa mwaVar = (mwa) obj;
                                if (this.a.l0() == null || this.a.l0().s1() == null || this.a.Z == null || mwaVar.u() == null || mwaVar.L() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.Y != null) {
                                    this.a.Y.g();
                                }
                                pw9 pw9Var = new pw9();
                                pw9Var.v(this.a.l0().s1().n());
                                pw9Var.z(this.a.l0().s1().R());
                                pw9Var.x(mwaVar);
                                this.a.Z.k0(pw9Var);
                                this.a.Z.setPostId(mwaVar.U());
                                this.a.U4(view2, mwaVar.u().getUserId(), "", mwaVar);
                                TiebaStatic.log("c11743");
                                b6a.b(this.a.l0().s1(), mwaVar, mwaVar.h0, 8, 1);
                                if (this.a.W != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.r5(absVideoPbFragment.W.C());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.z = false;
                } else {
                    if (view2.getId() == R.id.pb_video_more && this.a.getPageContext().getPageActivity() != null && this.a.l0() != null && this.a.a != null && this.a.a.getIntent() != null) {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.l0().M1(), false, true);
                            this.a.q5(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.l0().M1(), true, false);
                            this.a.q5(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.l0().getForumId());
                        statisticItem4.param("fname", this.a.l0().R0());
                        statisticItem4.param("tid", this.a.l0().M1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.n4() == null || this.a.n4().b3() == null || view2 != this.a.n4().b3()) && view2.getId() != R.id.pb_more) {
                        m6a m6aVar = this.a.o;
                        if (m6aVar != null && m6aVar.P() != null && view2 == this.a.o.P().y()) {
                            this.a.o.I();
                            return;
                        }
                        m6a m6aVar2 = this.a.o;
                        if ((m6aVar2 == null || m6aVar2.P() == null || view2 != this.a.o.P().D()) && view2.getId() != R.id.obfuscated_res_0x7f090bcb && view2.getId() != R.id.obfuscated_res_0x7f091fd4) {
                            if (this.a.o.P() != null && view2 == this.a.o.P().F()) {
                                if (this.a.l0() == null) {
                                    return;
                                }
                                this.a.o.F();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.K5();
                                this.a.w5();
                                this.a.l0().e3(1);
                                return;
                            }
                            m6a m6aVar3 = this.a.o;
                            if (m6aVar3 != null && m6aVar3.P() != null && view2 == this.a.o.P().D()) {
                                this.a.o.I();
                                return;
                            }
                            m6a m6aVar4 = this.a.o;
                            if (m6aVar4 != null && ((m6aVar4.P() != null && view2 == this.a.o.P().L()) || view2.getId() == R.id.obfuscated_res_0x7f091c33)) {
                                this.a.o.F();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                } else if (this.a.m) {
                                    view2.setTag(Integer.valueOf(this.a.l0().J1()));
                                    return;
                                } else {
                                    this.a.K5();
                                    this.a.w5();
                                    this.a.o.t0(view2);
                                    return;
                                }
                            }
                            m6a m6aVar5 = this.a.o;
                            if (m6aVar5 != null && m6aVar5.P() != null && view2 == this.a.o.P().K()) {
                                if (this.a.l0() == null || this.a.l0().s1() == null || this.a.l0().s1().R() == null) {
                                    return;
                                }
                                this.a.o.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment2 = this.a;
                                absVideoPbFragment2.o.S(absVideoPbFragment2.l0().s1().R().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bb8) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                m6a m6aVar6 = this.a.o;
                                if (m6aVar6 != null) {
                                    m6aVar6.n0(sparseArray);
                                }
                            } else {
                                m6a m6aVar7 = this.a.o;
                                if (m6aVar7 != null && m6aVar7.P() != null && view2 == this.a.o.P().I()) {
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
                                    this.a.o.J();
                                    return;
                                }
                                m6a m6aVar8 = this.a.o;
                                if (m6aVar8 != null && m6aVar8.P() != null && view2 == this.a.o.P().J()) {
                                    this.a.o.J();
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.o.s0(absVideoPbFragment3.M0);
                                    return;
                                }
                                m6a m6aVar9 = this.a.o;
                                if (m6aVar9 != null && m6aVar9.P() != null && view2 == this.a.o.P().C()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.l0().M1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.o.I();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                m6a m6aVar10 = this.a.o;
                                if (m6aVar10 != null && (view2 == m6aVar10.L() || (this.a.o.P() != null && (view2 == this.a.o.P().G() || view2 == this.a.o.P().H())))) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.l0() == null || this.a.l0().s1() == null || this.a.r.h0()) {
                                        return;
                                    } else {
                                        this.a.o.F();
                                        if (this.a.o.P() != null && view2 == this.a.o.P().H()) {
                                            i3 = this.a.l0().s1().R().getIs_top() == 1 ? 5 : 4;
                                        } else if (this.a.o.P() != null && view2 == this.a.o.P().G()) {
                                            i3 = this.a.l0().s1().R().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i3 = view2 == this.a.o.L() ? 2 : 0;
                                        }
                                        ForumData n = this.a.l0().s1().n();
                                        String name = n.getName();
                                        String id = n.getId();
                                        String id2 = this.a.l0().s1().R().getId();
                                        this.a.showProgressBar();
                                        this.a.r.l0(id, name, id2, i3, this.a.o.M());
                                        return;
                                    }
                                }
                                m6a m6aVar11 = this.a.o;
                                if (m6aVar11 != null && m6aVar11.P() != null && view2 == this.a.o.P().A()) {
                                    if (this.a.l0() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.a.o.F();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    SparseArray<Object> u4 = absVideoPbFragment4.u4(absVideoPbFragment4.l0().s1(), this.a.l0().L1(), 1);
                                    if (u4 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.l0().s1().n().getId(), this.a.l0().s1().n().getName(), this.a.l0().s1().R().getId(), String.valueOf(this.a.l0().s1().Y().getUserId()), (String) u4.get(R.id.tag_forbid_user_name), (String) u4.get(R.id.tag_forbid_user_name_show), (String) u4.get(R.id.tag_forbid_user_post_id), (String) u4.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                m6a m6aVar12 = this.a.o;
                                if (m6aVar12 != null && m6aVar12.P() != null && view2 == this.a.o.P().g()) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> u42 = absVideoPbFragment5.u4(absVideoPbFragment5.l0().s1(), this.a.l0().L1(), 1);
                                    if (u42 != null) {
                                        this.a.o.f0(((Integer) u42.get(R.id.tag_del_post_type)).intValue(), (String) u42.get(R.id.tag_del_post_id), ((Integer) u42.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) u42.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.a.o.I();
                                    if (this.a.l0() == null || this.a.l0().s1() == null || this.a.l0().s1().R() == null) {
                                        return;
                                    }
                                    ThreadData R = this.a.l0().s1().R();
                                    StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem5.param("tid", R.getId());
                                    statisticItem5.param("fid", R.getFid());
                                    statisticItem5.param("fname", R.getForum_name());
                                    TiebaStatic.log(statisticItem5);
                                    StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem6.param("tid", R.getId());
                                    statisticItem6.param("fid", R.getFid());
                                    statisticItem6.param("fname", R.getForum_name());
                                    statisticItem6.param("obj_source", 3);
                                    TiebaStatic.log(statisticItem6);
                                    return;
                                }
                                m6a m6aVar13 = this.a.o;
                                if (m6aVar13 != null && m6aVar13.P() != null && view2 == this.a.o.P().z()) {
                                    if (this.a.l0() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> u43 = absVideoPbFragment6.u4(absVideoPbFragment6.l0().s1(), this.a.l0().L1(), 1);
                                    if (u43 != null) {
                                        if (StringUtils.isNull((String) u43.get(R.id.tag_del_multi_forum))) {
                                            this.a.o.c0(((Integer) u43.get(R.id.tag_del_post_type)).intValue(), (String) u43.get(R.id.tag_del_post_id), ((Integer) u43.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) u43.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.a.o.d0(((Integer) u43.get(R.id.tag_del_post_type)).intValue(), (String) u43.get(R.id.tag_del_post_id), ((Integer) u43.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) u43.get(R.id.tag_del_post_is_self)).booleanValue(), (String) u43.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.a.o.I();
                                } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0923e6 && view2.getId() != R.id.obfuscated_res_0x7f091bba && view2.getId() != R.id.obfuscated_res_0x7f091a31 && view2.getId() != R.id.obfuscated_res_0x7f091c25) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091c23 && view2.getId() != R.id.obfuscated_res_0x7f091df0 && view2.getId() != R.id.obfuscated_res_0x7f091bb4) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ba2 && view2.getId() != R.id.collect_num_container) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ba7 && view2.getId() != R.id.share_more_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091ba4 && view2.getId() != R.id.thread_info_commont_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f092854) {
                                                        if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                            if (this.a.l0() == null) {
                                                                return;
                                                            }
                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                            statisticItem7.param("tid", this.a.l0().M1());
                                                            statisticItem7.param("fid", this.a.l0().getForumId());
                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem7.param("obj_locate", 2);
                                                            TiebaStatic.log(statisticItem7);
                                                            return;
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091be8 && view2.getId() != R.id.obfuscated_res_0x7f091baf) {
                                                            if (view2.getId() == R.id.obfuscated_res_0x7f0912d7) {
                                                                this.a.k5();
                                                                return;
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f0908bc && view2.getId() != R.id.obfuscated_res_0x7f090bc7) {
                                                                if (this.a.o.P() != null && view2 == this.a.o.P().x()) {
                                                                    this.a.o.F();
                                                                    if (this.a.l0() != null) {
                                                                        this.a.g.f(this.a.l0().M1());
                                                                    }
                                                                    if (this.a.l0() != null && this.a.l0().isPrivacy()) {
                                                                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                        if (this.a.l0().s1() != null) {
                                                                            this.a.g.d(3, 3, this.a.l0().s1().T());
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    this.a.g.b();
                                                                    int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.l0() == null || this.a.l0().s1() == null || this.a.l0().s1().T() == null || !this.a.l0().s1().T().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                    if (this.a.l0() == null || this.a.l0().s1() == null) {
                                                                        return;
                                                                    }
                                                                    this.a.g.d(3, i5, this.a.l0().s1().T());
                                                                    return;
                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091bbc && view2.getId() != R.id.obfuscated_res_0x7f091c1d) {
                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09237e) {
                                                                        Object tag2 = view2.getTag();
                                                                        if (tag2 instanceof SpriteMemeInfo) {
                                                                            this.a.Z4((SpriteMemeInfo) tag2);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                } else {
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.l0().M1());
                                                                    statisticItem8.param("fid", this.a.l0().getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    StatisticItem statisticItem9 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                    statisticItem9.param("fid", this.a.l0().getForumId());
                                                                    statisticItem9.param("tid", this.a.l0().M1());
                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem9.param("post_id", this.a.q4());
                                                                    statisticItem9.param("obj_source", 1);
                                                                    statisticItem9.param("obj_type", 2);
                                                                    statisticItem9.param("obj_locate", this.a.p4());
                                                                    TiebaStatic.log(statisticItem9);
                                                                    this.a.o.k0(false);
                                                                    this.a.o.O().onLongClick(view2);
                                                                    return;
                                                                }
                                                            } else {
                                                                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof mwa)) {
                                                                    return;
                                                                }
                                                                mwa mwaVar2 = (mwa) sparseArray2.get(R.id.tag_load_sub_data);
                                                                View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                if (mwaVar2 == null || view3 == null) {
                                                                    return;
                                                                }
                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0908bd);
                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0908be);
                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090bc7);
                                                                if (mwaVar2.G0()) {
                                                                    mwaVar2.m1(false);
                                                                    w4a.e(mwaVar2);
                                                                } else {
                                                                    if (this.a.l0() != null ? w4a.c(this.a.l0().s1(), mwaVar2) : false) {
                                                                        mwaVar2.m1(true);
                                                                        findViewById.setVisibility(0);
                                                                    }
                                                                }
                                                                SkinManager.setBackgroundColor(findViewById, mwaVar2.G0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                SkinManager.setViewTextColor(eMTextView, mwaVar2.G0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                WebPManager.setPureDrawable(imageView, mwaVar2.G0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, mwaVar2.G0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                return;
                                                            }
                                                        } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                BrowserHelper.startWebActivity(view2.getContext(), string, string2, true, true, true);
                                                            }
                                                            this.a.k5();
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (this.a.f0 >= 0) {
                                                        if (this.a.l0() != null) {
                                                            this.a.l0().L2();
                                                        }
                                                        if (this.a.n4() != null && this.a.n4().G2() != null) {
                                                            this.a.n4().G2().s(this.a.l0().s1());
                                                        }
                                                        this.a.f0 = 0;
                                                        this.a.g0 = Integer.MIN_VALUE;
                                                        if (this.a.l0() == null || this.a.n4() == null) {
                                                            return;
                                                        }
                                                        this.a.n4().n3(this.a.l0().l1(), this.a.l0().k1());
                                                        this.a.l0().P2(0, 0);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.l0() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                                    if (absVideoPbFragment7.o == null || absVideoPbFragment7.d == null || this.a.l0().s1() == null || this.a.l0().s1().R() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    zv9 s1 = this.a.l0().s1();
                                                    if (s1.R().getReply_num() == 0) {
                                                        this.a.e5();
                                                        return;
                                                    } else if (this.a.n4() == null || this.a.A4() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.l0().M1()).param("fid", this.a.l0().s1().o()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView A4 = this.a.A4();
                                                        if (A4 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = A4.canScrollVertically(1);
                                                        boolean canScrollVertically2 = A4.canScrollVertically(-1);
                                                        if (A4.getLayoutManager() == null || !(A4.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) A4.getLayoutManager();
                                                        if (canScrollVertically2 || !canScrollVertically) {
                                                            str = "obj_source";
                                                            int firstVisiblePosition = A4.getFirstVisiblePosition();
                                                            View childAt = A4.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.d0 = firstVisiblePosition;
                                                            this.a.e0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-equipmentHeight) || A4.getCount() < 6)) {
                                                                A4.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                A4.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        } else if (this.a.d0 == -1 && this.a.e0 == Integer.MIN_VALUE) {
                                                            return;
                                                        } else {
                                                            if (this.a.d0 > 3 || (this.a.d0 == 3 && this.a.e0 < (-equipmentHeight))) {
                                                                str = "obj_source";
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.d0, this.a.e0 + equipmentHeight);
                                                                A4.smoothScrollBy(0, equipmentHeight);
                                                            } else if (this.a.d0 >= 2) {
                                                                str = "obj_source";
                                                                int i6 = equipmentHeight / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.d0, this.a.e0 + i6);
                                                                A4.smoothScrollBy(0, i6);
                                                            } else {
                                                                str = "obj_source";
                                                                if (this.a.d0 == 1) {
                                                                    int i7 = equipmentHeight / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.d0, this.a.e0 + i7);
                                                                    A4.smoothScrollBy(0, i7);
                                                                } else {
                                                                    A4.smoothScrollBy(0, -this.a.e0);
                                                                }
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        }
                                                        TiebaStatic.log(param);
                                                        xo5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem10 = new StatisticItem("c12942");
                                                        statisticItem10.param("obj_type", i2);
                                                        statisticItem10.param("obj_locate", 4);
                                                        statisticItem10.param("tid", this.a.l0().M1());
                                                        statisticItem10.param("nid", s1.R().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem10);
                                                        if (this.a.l0() == null || this.a.l0().s1() == null || this.a.l0().s1().R() == null || this.a.l0().s1().R().getAuthor() == null) {
                                                            return;
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.l0().M1()).param("fid", this.a.l0().s1().o()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem11.param("fid", this.a.l0().getForumId());
                                                        statisticItem11.param("tid", this.a.l0().M1());
                                                        statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem11.param("post_id", this.a.q4());
                                                        statisticItem11.param(str, 1);
                                                        statisticItem11.param("obj_type", 12);
                                                        statisticItem11.param("obj_locate", this.a.p4());
                                                        TiebaStatic.log(statisticItem11);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            this.a.D4(true);
                                        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                        } else {
                                            AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                            if (absVideoPbFragment8.o == null || absVideoPbFragment8.l0() == null || this.a.n4() == null) {
                                                return;
                                            }
                                            this.a.o.F();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ba2 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.W3(11009) || this.a.l0() == null) {
                                                    return;
                                                }
                                                this.a.W4();
                                                if (this.a.l0().s1() != null && this.a.l0().s1().R() != null && this.a.l0().s1().R().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.l0().M1()).param("fid", this.a.l0().s1().o()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                    StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem12.param("fid", this.a.l0().getForumId());
                                                    statisticItem12.param("tid", this.a.l0().M1());
                                                    statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem12.param("post_id", this.a.q4());
                                                    statisticItem12.param("obj_source", 1);
                                                    statisticItem12.param("obj_type", 13);
                                                    statisticItem12.param("obj_locate", this.a.p4());
                                                    TiebaStatic.log(statisticItem12);
                                                }
                                                if (this.a.l0().s1().R() == null || this.a.l0().s1().R().getAuthor() == null || this.a.l0().s1().R().getAuthor().getUserId() == null || this.a.q == null) {
                                                    return;
                                                }
                                                int d = l4a.d(this.a.l0().s1());
                                                ThreadData R2 = this.a.l0().s1().R();
                                                if (R2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (R2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (R2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = R2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.l0().M1()).param("obj_locate", 1).param("obj_id", this.a.l0().s1().R().getAuthor().getUserId()).param("obj_type", !this.a.q.e()).param("obj_source", d).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.j = view2;
                                        }
                                    } else if (this.a.l0() == null) {
                                    } else {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091c23) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.l0().M1());
                                            statisticItem13.param("fid", this.a.l0().getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091df0) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.i = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091c23 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.i = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof mwa) {
                                                mwa mwaVar3 = (mwa) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091c23 && (statisticItem = mwaVar3.i0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091df0 || view2.getId() == R.id.obfuscated_res_0x7f091bb4) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.l0().N1()).param("fid", this.a.l0().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", mwaVar3.U()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.a.l0() == null || this.a.l0().s1() == null || this.a.Z == null || mwaVar3.u() == null || mwaVar3.L() == 1) {
                                                    return;
                                                }
                                                if (this.a.Y != null) {
                                                    this.a.Y.g();
                                                }
                                                pw9 pw9Var2 = new pw9();
                                                pw9Var2.v(this.a.l0().s1().n());
                                                pw9Var2.z(this.a.l0().s1().R());
                                                pw9Var2.x(mwaVar3);
                                                this.a.Z.k0(pw9Var2);
                                                this.a.Z.setPostId(mwaVar3.U());
                                                this.a.U4(view2, mwaVar3.u().getUserId(), "", mwaVar3);
                                                if (this.a.W != null) {
                                                    AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                                    absVideoPbFragment9.r5(absVideoPbFragment9.W.C());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a31) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.l0().M1());
                                        statisticItem14.param("fid", this.a.l0().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem14);
                                        StatisticItem statisticItem15 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem15.param("fid", this.a.l0().getForumId());
                                        statisticItem15.param("tid", this.a.l0().M1());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("post_id", this.a.q4());
                                        statisticItem15.param("obj_source", 1);
                                        statisticItem15.param("obj_type", 8);
                                        statisticItem15.param("obj_locate", this.a.p4());
                                        TiebaStatic.log(statisticItem15);
                                    }
                                    if ((view2.getId() != R.id.obfuscated_res_0x7f091bba && view2.getId() != R.id.obfuscated_res_0x7f091c25) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091bba) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.l0().getForumId());
                                            statisticItem16.param("tid", this.a.l0().M1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param("post_id", this.a.q4());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 9);
                                            statisticItem16.param("obj_locate", this.a.p4());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                        if (!this.a.checkUpIsLogin()) {
                                            b6a.u("c10517", this.a.l0().s1().o(), 3);
                                            return;
                                        } else if (this.a.l0() == null || this.a.l0().s1() == null) {
                                            return;
                                        } else {
                                            m6a m6aVar14 = this.a.o;
                                            if (m6aVar14 != null) {
                                                m6aVar14.F();
                                            }
                                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                            mwa mwaVar4 = (mwa) sparseArray4.get(R.id.tag_load_sub_data);
                                            mwa mwaVar5 = (mwa) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                            if (mwaVar4 == null) {
                                                return;
                                            }
                                            if (mwaVar4.P() == 1) {
                                                TiebaStatic.log(new StatisticItem("c12630"));
                                            }
                                            StatisticItem statisticItem17 = mwaVar4.i0;
                                            if (statisticItem17 != null) {
                                                StatisticItem copy2 = statisticItem17.copy();
                                                copy2.delete("obj_locate");
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091a31) {
                                                    copy2.param("obj_locate", 6);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091bba) {
                                                    copy2.param("obj_locate", 8);
                                                }
                                                TiebaStatic.log(copy2);
                                            }
                                            this.a.K5();
                                            TiebaStatic.log("c11742");
                                            if (mwaVar5 != null) {
                                                this.a.I5(mwaVar4, mwaVar5, false, true);
                                                return;
                                            } else {
                                                this.a.I5(mwaVar4, null, false, false);
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
                            this.a.o.F();
                            if (this.a.m) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.K5();
                            this.a.w5();
                            boolean i32 = this.a.l0().i3(this.a.q4());
                            view2.setTag(Boolean.valueOf(i32));
                            if (i32) {
                                this.a.D5();
                                i4 = 1;
                                this.a.m = true;
                            } else {
                                i4 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                        }
                    } else if (!this.a.m && this.a.l0().q2(true)) {
                        this.a.m = true;
                        if (this.a.n4() != null) {
                            this.a.n4().s3();
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
    public class r0 implements ah5 {
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

        @Override // com.baidu.tieba.ah5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                q1a q1aVar = this.a.f1141T;
                if (q1aVar != null && q1aVar.e() != null && this.a.f1141T.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.f1141T.e().c());
                    if (this.a.W != null && (this.a.W.B() || this.a.W.D())) {
                        this.a.W.z(false, this.a.f1141T.h());
                    }
                    this.a.f1141T.a(true);
                    return true;
                }
                return !this.a.Y3(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s extends nu5<ShareItem> {
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
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel l0 = this.b.l0();
                if (l0 != null) {
                    l0.S2(this.a);
                }
                return s4a.b(this.b.m4(), 2, l0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            q1a q1aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (q1aVar = this.a.f1141T) != null && q1aVar.g() != null) {
                if (!this.a.f1141T.g().e()) {
                    this.a.f1141T.b(false);
                }
                this.a.f1141T.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements st5<ShareItem> {
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
        @Override // com.baidu.tieba.st5
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
    public class t0 implements qb<ImageView> {
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
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
                    if (qv4.c().g()) {
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = qv4.c().g();
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
            m6a m6aVar = this.a.o;
            if (m6aVar != null) {
                if (z) {
                    if (z2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.a.o.B(sparseArray);
                        return;
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.o.h0(view2);
                } else if (z2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.a.o.B(sparseArray);
                } else if (z3) {
                    m6aVar.c0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements qb<GifView> {
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
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.h();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.k();
                gifView.h();
                gifView.setImageDrawable(null);
                gifView.l();
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
                if (qv4.c().g()) {
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = qv4.c().g();
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
        public void b(zv9 zv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zv9Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, zv9 zv9Var, String str, int i4, boolean z2) {
            String B4;
            qe5 t;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), zv9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907f7));
                }
                this.a.v5();
                this.a.J4();
                if (this.a.m) {
                    this.a.m = false;
                }
                this.a.B5(false);
                if (z && zv9Var != null) {
                    ThreadData R = zv9Var.R();
                    this.a.d5(zv9Var);
                    this.a.g5(z, i, i2, i3, zv9Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(zv9Var.Y().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(zv9Var.Y().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(zv9Var.Y().getBimg_end_time());
                    if (zv9Var.I() != null && zv9Var.I().size() >= 1 && zv9Var.I().get(0) != null) {
                        this.a.l0().Q2(zv9Var.I().get(0).U());
                    } else if (zv9Var.b0() != null) {
                        this.a.l0().Q2(zv9Var.b0().U());
                    }
                    if (this.a.q != null) {
                        this.a.q.h(zv9Var.t());
                    }
                    AntiData f = zv9Var.f();
                    if (f != null) {
                        this.a.N = f.getVoice_message();
                        if (!StringUtils.isNull(this.a.N) && this.a.W != null && this.a.W.a() != null && (t = this.a.W.a().t(6)) != null && !TextUtils.isEmpty(this.a.N)) {
                            ((View) t).setOnClickListener(this.a.D0);
                        }
                    }
                    if (this.a.S != null && R != null && R.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(R.getAuthor());
                        this.a.S.setLikeUserData(attentionHostData);
                    }
                    if (this.a.l0() != null && this.a.l0().d2()) {
                        B4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        B4 = this.a.B4();
                    }
                    if (!StringUtils.isNull(B4)) {
                        this.a.W.g0(TbSingleton.getInstance().getAdVertiComment(zv9Var.r0(), zv9Var.s0(), B4));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.l0().M1());
                            jSONObject.put("fid", this.a.l0().getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        br6.b().c(new z95(this.a.l0().M1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (this.a.n4() == null) {
                        return;
                    }
                    if (i != -1) {
                        ArrayList<mwa> arrayList = null;
                        if (this.a.l0() != null && this.a.l0().s1() != null) {
                            arrayList = this.a.l0().s1().I();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).L() != 1)) {
                            this.a.n4().p3(this.a.getResources().getString(R.string.list_no_more_new));
                        } else if (this.a.n4().h3()) {
                            this.a.n4().q3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1037));
                        } else {
                            this.a.n4().q3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1038));
                        }
                    } else {
                        this.a.n4().p3("");
                    }
                    this.a.n4().U2();
                }
                pua.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements qb<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.d1());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.l0() != null && this.a.l0().C1() != i + 1) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.o5(absVideoPbFragment.z4(i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements qb<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof uy5.a)) {
                uy5.a aVar = (uy5.a) customResponsedMessage.getData();
                if (!StringUtils.isNull(aVar.e)) {
                    str = aVar.e;
                } else {
                    str = aVar.b;
                }
                uy5.c(this.a.getPageContext(), this.a, aVar.a, str, aVar.c);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && (agreeMessageData = (AgreeMessageData) customResponsedMessage.getData()) != null && (agreeData = agreeMessageData.agreeData) != null && agreeData.agreeType == 2 && this.a.J != null && this.a.l0() != null && !s4a.g(this.a.l0().M1())) {
                this.a.J.n(2);
                s4a.a(this.a.l0().M1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements PbFallingView.o {
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

        @Override // com.baidu.tieba.pb.view.PbFallingView.o
        public void onClick() {
            String B4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.l0() != null && this.a.l0().d2()) {
                    B4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    B4 = this.a.B4();
                }
                if (!StringUtils.isNull(B4) && this.a.l0() != null && this.a.l0().s1() != null) {
                    B4 = TbSingleton.getInstance().getAdVertiComment(this.a.l0().s1().r0(), this.a.l0().s1().s0(), B4);
                }
                if (this.a.W != null) {
                    this.a.W.g0(B4);
                }
                if (this.a.F != null) {
                    this.a.F.setText(B4);
                }
                this.a.B5(false);
                this.a.F5();
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
                    this.a.W.K(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.Y != null && this.a.Y.f() != null) {
                    this.a.Y.f().J();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.l0() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.W != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.r5(absVideoPbFragment.W.C());
                }
                this.a.k5();
                this.a.o.F();
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
        this.z = false;
        this.C = null;
        this.F = null;
        this.M = false;
        this.N = null;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.b0 = new int[2];
        this.d0 = -1;
        this.e0 = Integer.MIN_VALUE;
        this.f0 = 0;
        this.g0 = Integer.MIN_VALUE;
        this.h0 = false;
        this.i0 = new k(this);
        this.j0 = new v(this);
        this.r0 = new g0(this);
        this.s0 = new r0(this);
        this.t0 = new z0(this, 2004016);
        this.u0 = new a1(this, 2004007);
        this.v0 = new b1(this, 2921391);
        this.w0 = new c1(this, 2016450);
        this.x0 = new d1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.y0 = new a(this, 2001426);
        this.z0 = new b(this, 2001427);
        this.A0 = new c(this, 2001428);
        this.B0 = new d(this);
        this.C0 = new e(this);
        this.D0 = new f(this);
        this.E0 = new g(this, 2004008);
        this.F0 = new h(this);
        this.G0 = new i(this);
        this.H0 = new j(this);
        this.I0 = new m(this);
        this.J0 = new q(this);
        this.K0 = new r(this);
        this.L0 = new u(this);
        this.M0 = new w(this);
        this.N0 = new x(this, 2001332);
        this.O0 = new y(this, 2016528);
        this.P0 = new a0(this, 2001440);
        this.Q0 = new b0(this);
        this.R0 = new f0(this, 2921509);
        this.S0 = new j0(this);
        this.T0 = new k0(this);
    }

    @Override // com.baidu.tieba.xy5
    public void J0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.z = true;
    }

    public final void K4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            ru5.b(new s(this, i3), new t(this, i3, i2));
        }
    }

    public void c5(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048644, this, adverSegmentData, i2) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.x(adverSegmentData, getPageContext(), i2, false);
        }
    }

    @Override // com.baidu.tieba.xy5
    public void d0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, context, str) == null) {
            t1a.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.z = true;
        }
    }

    public void u5(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048714, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            m6a m6aVar = this.o;
            if (m6aVar == null) {
                return;
            }
            if (z2) {
                m6aVar.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.o.G();
            } else {
                this.o.F();
            }
        }
    }

    public void B5(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z2) != null) || this.C == null) {
            return;
        }
        r5(this.W.C());
        if (this.M) {
            C5(z2);
        } else {
            F4(z2);
        }
    }

    public final void G5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            p6a.a(u0(), m4(), i2);
        }
    }

    public void P4(@Nullable SpriteMemeInfo spriteMemeInfo) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, spriteMemeInfo) != null) || (editorTools = this.X) == null) {
            return;
        }
        editorTools.n(spriteMemeInfo);
        E4();
    }

    public void P5(zv9 zv9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, zv9Var) == null) && zv9Var != null && (imageView = this.I) != null) {
            l4a.f(zv9Var, this.J, null, imageView);
        }
    }

    public void b5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048642, this, i2) == null) && i2 == 0) {
            pua.g().h(getUniqueId(), false);
            if (A4() != null) {
                U3(A4(), true);
            }
        }
    }

    public mwa o4(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, zv9Var)) == null) {
            if (zv9Var == null) {
                return null;
            }
            return zv9Var.a0();
        }
        return (mwa) invokeL.objValue;
    }

    public final void o5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048678, this, i2) == null) && l0() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(l0().M1());
            sendMessage(privacySettingMessage);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) {
            super.onUserChanged(z2);
            T4();
        }
    }

    public final void q5(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).b2());
            }
        }
    }

    public void r5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z2) == null) {
            this.M = z2;
        }
    }

    public void s5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048704, this, z2) == null) {
            this.m = z2;
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

    public final void y5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z2) == null) {
            this.W.b0(z2);
            this.W.e0(z2);
            this.W.m0(z2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048684, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(r4(), viewGroup, false);
            Q4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    public BdTypeRecyclerView A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter == null) {
                return null;
            }
            Iterator<BaseFragment> it = videoPbFragmentAdapter.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).a3();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && l0() != null && !rd.isEmpty(l0().M1())) {
            po4.w().Q(oo4.Z, JavaTypesHelper.toLong(l0().M1(), 0L));
        }
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048628, this) != null) || l0() == null) {
            return;
        }
        zv9 s1 = l0().s1();
        l0().g3(true);
        jr4 jr4Var = this.q;
        if (jr4Var != null) {
            s1.M0(jr4Var.g());
        }
        if (n4() != null) {
            n4().g3();
        }
    }

    public final void a5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.o != null && l0() != null) {
                this.o.F();
                if (this.m) {
                    return;
                }
                K5();
                w5();
                if (l0().loadData()) {
                    D5();
                }
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            jr4 c2 = jr4.c(this.a);
            this.q = c2;
            if (c2 != null) {
                c2.j(this.r0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.r = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.F0);
            getPageContext();
            this.o = new m6a(this);
        }
    }

    public final int m4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (l0() != null && l0().s1() != null && l0().s1().R() != null) {
                return l0().s1().R().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            super.onResume();
            this.h0 = false;
            d1().onResume(getPageContext());
            H5();
            registerListener(this.z0);
            registerListener(this.A0);
            registerListener(this.y0);
            registerListener(this.N0);
            ItemCardHelper.w(this.Q0);
            MessageManager.getInstance().registerListener(this.P0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            super.onStop();
            d1().onStop(getPageContext());
            pua.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.P0);
        }
    }

    public final void A5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    yb5.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (l0() != null && !l0().f1()) {
                antiData.setBlock_forum_name(l0().s1().n().getName());
                antiData.setBlock_forum_id(l0().s1().n().getId());
                antiData.setUser_name(l0().s1().Y().getUserName());
                antiData.setUser_id(l0().s1().Y().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public void U3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        mwa mwaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048623, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof mwa) && (mwaVar = (mwa) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && mwaVar.o() != null) {
                        mwaVar.o().setFloonumber(mwaVar.L());
                        arrayList.add(mwaVar.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new x0(this));
                if (((AdverSegmentData) ListUtils.getItem(arrayList, 0)).getFloonumber() == 1) {
                    if (!z2) {
                        c5((AdverSegmentData) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                c5((AdverSegmentData) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public String B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!rd.isEmpty(this.L)) {
                return this.L;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(m1a.d());
            this.L = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void D5() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(0);
        }
    }

    public void E4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.C == null) {
            return;
        }
        this.B.setVisibility(8);
        this.C.setVisibility(8);
    }

    public final void F5() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.setTag(Boolean.TRUE);
        }
    }

    public void G4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (editorTools = this.X) != null) {
            editorTools.v();
        }
    }

    public void H4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (editorTools = this.X) != null) {
            editorTools.z();
        }
    }

    public void I4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public void J4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(8);
        }
    }

    public void J5() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.z();
            this.l.setAnimationListener(null);
        }
    }

    public final void K5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (voiceManager = this.s) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void L5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.Q1();
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<GifView> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.t == null) {
                this.t = new pb<>(new u0(this), 20, 0);
            }
            return this.t;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<TextView> N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.u == null) {
                this.u = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.u;
        }
        return (pb) invokeV.objValue;
    }

    public void N4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            setEditorTools(this.W.a());
        }
    }

    public void N5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            eh5 eh5Var = this.W;
            if (eh5Var != null) {
                r5(eh5Var.C());
            }
            k5();
            this.o.F();
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<LinearLayout> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.x == null) {
                this.x = aw9.f(getActivity());
            }
            return this.x;
        }
        return (pb) invokeV.objValue;
    }

    public boolean R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            EditorTools editorTools = this.X;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.E != null) {
            g4();
            this.E.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    public final boolean V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            PbModel l02 = l0();
            if (l02 != null && l02.s1() != null) {
                return AntiHelper.b(getPageContext(), l02.s1().R());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            Z4(null);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (this.s == null) {
                this.s = VoiceManager.instance();
            }
            return this.s;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            PbModel B1 = this.a.B1();
            if (B1 == null) {
                return false;
            }
            return B1.m2();
        }
        return invokeV.booleanValue;
    }

    public void e5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            f5(null);
        }
    }

    public void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", U0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", U0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            reset();
            G4();
            this.Y.g();
            B5(false);
        }
    }

    @Override // com.baidu.tieba.h6a
    public PbModel l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.a.B1();
        }
        return (PbModel) invokeV.objValue;
    }

    public LinearLayout l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.D;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public void l5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.d0 = -1;
            this.e0 = Integer.MIN_VALUE;
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<RelativeLayout> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            pb<RelativeLayout> pbVar = new pb<>(new w0(this), 10, 0);
            this.y = pbVar;
            return pbVar;
        }
        return (pb) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment n4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.e.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            super.onStart();
            d1().onStart(getPageContext());
        }
    }

    public final void p5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.l.setFallingFeedbackListener(new y0(this));
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<ImageView> r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            if (this.v == null) {
                this.v = new pb<>(new t0(this), 8, 0);
            }
            return this.v;
        }
        return (pb) invokeV.objValue;
    }

    public View.OnClickListener s4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.K0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<View> t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            if (this.w == null) {
                this.w = new pb<>(new v0(this), 8, 0);
            }
            return this.w;
        }
        return (pb) invokeV.objValue;
    }

    public View.OnClickListener t4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            return this.L0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048711, this) == null) && l0() != null && !rd.isEmpty(l0().M1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tieba.h6a
    public AbsPbActivity u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h6a
    public PbModel.h v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.j0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public jr4 v4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.q;
        }
        return (jr4) invokeV.objValue;
    }

    public void v5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            hideProgressBar();
            if (n4() != null) {
                n4().U2();
                n4().V2();
            }
        }
    }

    public View.OnLongClickListener w4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            return this.S0;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public void w5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public View.OnTouchListener x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return this.G0;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public eh5 y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.W;
        }
        return (eh5) invokeV.objValue;
    }

    public final void C4(int i2, Intent intent) {
        ve5 ve5Var;
        k0a k0aVar;
        ve5 ve5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, intent) == null) {
            if (i2 == 0) {
                G4();
                k0a k0aVar2 = this.Y;
                if (k0aVar2 != null) {
                    k0aVar2.g();
                }
                B5(false);
            }
            k5();
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
                if (editorType == 1 && (k0aVar = this.Y) != null && k0aVar.f() != null) {
                    hh5 f2 = this.Y.f();
                    f2.g0(l0().s1().R());
                    f2.E(writeData);
                    f2.h0(pbEditorData.getVoiceModel());
                    ue5 u2 = f2.a().u(6);
                    if (u2 != null && (ve5Var2 = u2.m) != null) {
                        ve5Var2.U(new he5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.J();
                        return;
                    }
                    return;
                }
                return;
            }
            this.W.P();
            this.W.q0(pbEditorData.getVoiceModel());
            this.W.F(writeData);
            ue5 u3 = this.W.a().u(6);
            if (u3 != null && (ve5Var = u3.m) != null) {
                ve5Var.U(new he5(52, 0, pbEditorData.getVoiceModel()));
            }
            ue5 u4 = this.W.a().u(41);
            if (u4 != null) {
                u4.h();
                DLauncher dLauncher = (DLauncher) this.W.a().t(41);
                if (dLauncher != null) {
                    dLauncher.setIcon();
                }
            }
            if (i2 == -1) {
                if (StringUtils.isNotNull(pbEditorData.getMemeQuery()) || pbEditorData.getMemeId() != 0) {
                    this.W.G = true;
                    if (StringUtils.isNotNull(pbEditorData.getMemeQuery())) {
                        this.W.H = pbEditorData.getMemeQuery();
                    }
                    if (pbEditorData.getMemeId() != 0) {
                        this.W.I = pbEditorData.getMemeId();
                    }
                }
                this.W.K(null, null);
            }
        }
    }

    public final void E5(String str, String str2) {
        int i2;
        int dimens;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                dimens = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.tbds256);
            } else {
                i2 = equipmentHeight / 2;
                dimens = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.tbds256);
            }
            int i3 = equipmentHeight - (i2 + dimens);
            boolean z2 = true;
            int i4 = (this.b0[1] + this.c0) - i3;
            if (A4() != null) {
                A4().smoothScrollBy(0, i4);
            }
            if (this.Y != null) {
                this.W.a().setVisibility(8);
                this.Y.t(str, str2, B4(), (l0() == null || l0().s1() == null || l0().s1().R() == null || !l0().s1().R().isBjh()) ? false : false);
                this.Y.q(p4());
                hh5 f2 = this.Y.f();
                if (f2 != null && l0() != null && l0().s1() != null) {
                    f2.K(l0().s1().f());
                    f2.g0(l0().s1().R());
                }
                if (this.f1141T.f() == null && this.Y.f().v() != null) {
                    this.Y.f().v().i(new s0(this));
                    this.f1141T.n(this.Y.f().v().k());
                    this.Y.f().Q(this.B0);
                }
            }
            E4();
        }
    }

    public final void h4(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048660, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                f05 f05Var = new f05(getPageContext().getPageActivity());
                f05Var.setMessage(string);
                f05Var.setPositiveButton(R.string.dialog_known, new l(this));
                f05Var.setCancelable(true);
                f05Var.create(getPageContext());
                f05Var.show();
            } else {
                i4(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<mwa> I = l0().s1().I();
                    int size = I.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(I.get(i2).U())) {
                            I.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    l0().s1().R().setReply_num(l0().s1().R().getReply_num() - 1);
                    if (n4() != null) {
                        n4().g3();
                    }
                } else if (i3 == 0) {
                    a4();
                } else if (i3 == 2) {
                    ArrayList<mwa> I2 = l0().s1().I();
                    int size2 = I2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= I2.get(i4).k0().size()) {
                                break;
                            } else if (bVar.g.equals(I2.get(i4).k0().get(i5).U())) {
                                I2.get(i4).k0().remove(i5);
                                I2.get(i4).h();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        I2.get(i4).k(bVar.g);
                    }
                    if (z3 && n4() != null) {
                        n4().g3();
                    }
                    b4(bVar);
                }
            }
        }
    }

    public void C5(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) && this.C != null && (textView = this.F) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f061a);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.C.startAnimation(alphaAnimation);
            }
            this.B.setVisibility(0);
            this.C.setVisibility(0);
        }
    }

    public final boolean W3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void n5(boolean z2) {
        jr4 jr4Var;
        MarkData f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048676, this, z2) != null) || (jr4Var = this.q) == null || (f2 = jr4Var.f()) == null) {
            return;
        }
        iwa iwaVar = new iwa();
        iwaVar.a = f2.getThreadId();
        iwaVar.b = z2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, iwaVar));
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (l0() != null) {
                l0().M2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                d1().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public void D0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.o.l0(str);
            g05 Q = this.o.Q();
            if (Q == null) {
                this.o.V();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                Q.f(1).setVisibility(8);
            } else {
                Q.f(1).setVisibility(0);
            }
            Q.m();
            this.z = true;
        }
    }

    public final void z5(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048728, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new l0(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                m6a m6aVar = this.o;
                if (m6aVar != null) {
                    m6aVar.u0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D4(boolean z2) {
        zv9 s1;
        int i2;
        int i3;
        u6a u6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) && l0() != null && this.o != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (s1 = l0().s1()) == null) {
                return;
            }
            ThreadData R = s1.R();
            int i4 = 1;
            if (R != null && R.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", l0().M1()).param("fid", s1.o()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", l0().getForumId());
                statisticItem.param("tid", l0().M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", q4());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", p4());
                TiebaStatic.log(statisticItem);
            }
            if (R != null) {
                if (R.isBJHArticleThreadType()) {
                    i2 = 2;
                } else if (R.isBJHVideoThreadType()) {
                    i2 = 3;
                } else if (R.isBJHNormalThreadType()) {
                    i2 = 4;
                } else if (R.isBJHVideoDynamicThreadType()) {
                    i2 = 5;
                }
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", l0().M1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", l0().getForumId());
                if (!z2) {
                    statisticItem2.param("obj_locate", 6);
                } else {
                    statisticItem2.param("obj_locate", 5);
                }
                statisticItem2.param("obj_name", i2);
                if (R == null) {
                    if (R.isBJHArticleThreadType()) {
                        i3 = 10;
                    } else if (R.isBJHVideoThreadType()) {
                        i3 = 9;
                    } else if (R.isBJHVideoDynamicThreadType()) {
                        i3 = 8;
                    } else if (R.isBJHNormalThreadType()) {
                        i3 = 7;
                    } else if (R.isShareThread) {
                        i3 = 6;
                    } else {
                        int i5 = R.threadType;
                        if (i5 == 0) {
                            i3 = 1;
                        } else if (i5 == 40) {
                            i3 = 2;
                        } else if (i5 == 49) {
                            i3 = 3;
                        } else if (i5 == 54) {
                            i3 = 4;
                        } else {
                            i3 = 5;
                        }
                    }
                    statisticItem2.param("nid", R.getNid());
                    statisticItem2.param("card_type", R.getRecomCardType());
                    statisticItem2.param("recom_source", R.mRecomSource);
                    statisticItem2.param("ab_tag", R.mRecomAbTag);
                    statisticItem2.param("weight", R.mRecomWeight);
                    statisticItem2.param("extra", R.mRecomExtra);
                    statisticItem2.param("nid", R.getNid());
                    if (R.getBaijiahaoData() != null && !rd.isEmpty(R.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, R.getBaijiahaoData().oriUgcVid);
                    }
                } else {
                    i3 = 2;
                }
                statisticItem2.param("obj_type", i3);
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (u0() != null) {
                    cp5.e(u0(), statisticItem2);
                }
                u6aVar = this.J;
                if (u6aVar != null) {
                    statisticItem2.param("obj_param1", u6aVar.f());
                }
                TiebaStatic.log(statisticItem2);
                if (BdUtilHelper.isNetOk()) {
                    showToast(R.string.obfuscated_res_0x7f0f0e70);
                    return;
                } else if (l0().s1() == null) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1036));
                    return;
                } else {
                    ArrayList<mwa> I = s1.I();
                    if ((I == null || I.size() <= 0) && l0().L1()) {
                        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1036));
                        return;
                    }
                    this.o.F();
                    K5();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), R)) {
                        return;
                    }
                    u6a u6aVar2 = this.J;
                    if (u6aVar2 != null) {
                        u6aVar2.k(false);
                        P5(s1);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i4 = 2;
                        }
                        if (this.J.h()) {
                            this.J.l(false);
                            K4(jb5.a(), this.J.f());
                            return;
                        }
                        G5(i4);
                        return;
                    }
                    this.o.o0();
                    l0().M0().Q(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", l0().M1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", l0().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            if (R == null) {
            }
            statisticItem22.param("obj_type", i3);
            if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (u0() != null) {
            }
            u6aVar = this.J;
            if (u6aVar != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (BdUtilHelper.isNetOk()) {
            }
        }
    }

    public void F4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) && this.C != null && this.F != null) {
            if (l0() != null && l0().s1() != null) {
                this.F.setText(TbSingleton.getInstance().getAdVertiComment(l0().s1().r0(), l0().s1().s0(), B4()));
            } else {
                this.F.setText(B4());
            }
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.C.startAnimation(alphaAnimation);
            }
            this.B.setVisibility(0);
            this.C.setVisibility(0);
        }
    }

    public void Z3(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, spriteMemeInfo) == null) {
            if (!checkUpIsLogin()) {
                if (l0() != null) {
                    b6a.u("c10517", l0().getForumId(), 2);
                }
            } else if (!X3()) {
            } else {
                eh5 eh5Var = this.W;
                if (eh5Var != null) {
                    eh5Var.s0(spriteMemeInfo);
                }
                eh5 eh5Var2 = this.W;
                if (eh5Var2 != null && (eh5Var2.B() || this.W.D())) {
                    this.W.z(false, null);
                    return;
                }
                if (this.X != null) {
                    P4(spriteMemeInfo);
                    if (this.X.u(2) != null) {
                        yva.c(getPageContext(), (View) this.X.u(2).m, false, null);
                    }
                }
                E4();
            }
        }
    }

    public void b4(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, bVar) == null) {
            List<mwa> list = l0().s1().W().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).k0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).k0().get(i3).U())) {
                        list.get(i2).k0().remove(i3);
                        list.get(i2).h();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).k(bVar.g);
            }
            if (z2 && n4() != null) {
                n4().g3();
            }
        }
    }

    public final void d5(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048648, this, zv9Var) != null) || zv9Var == null) {
            return;
        }
        ThreadData R = zv9Var.R();
        if (R != null && R.isUgcThreadType()) {
            T3();
        } else {
            t5(this.V);
        }
        eh5 eh5Var = this.W;
        if (eh5Var != null) {
            r5(eh5Var.C());
            this.W.L(zv9Var.f());
            this.W.M(zv9Var.n(), zv9Var.Y());
            this.W.o0(R);
            if (l0() != null) {
                this.W.N(l0().U0(), l0().M1(), l0().Q0());
            }
            if (R != null) {
                this.W.d0(R.isMutiForumThread());
            }
        }
    }

    public void f5(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048653, this, spriteMemeInfo) != null) || !checkUpIsLogin() || l0() == null || l0().s1() == null || l0().s1().n() == null || V3()) {
            return;
        }
        if (l0().s1().a()) {
            Z3(spriteMemeInfo);
            return;
        }
        eh5 eh5Var = this.W;
        if (eh5Var != null && eh5Var.a() != null) {
            this.W.a().K(new he5(45, 27, null));
        }
        Z3(spriteMemeInfo);
    }

    public void h5(zv9 zv9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048661, this, zv9Var) == null) && zv9Var != null && zv9Var.R() != null) {
            P5(zv9Var);
            ImageView imageView = this.H;
            if (zv9Var.a()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (zv9Var.t()) {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String k4 = k4(zv9Var.R().getReply_num());
            TextView textView = this.K;
            if (textView != null) {
                textView.setText(k4);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, zv9Var.R()));
        }
    }

    public final String k4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048667, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f1019);
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
        if (interceptable == null || interceptable.invokeL(1048679, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907f7));
            if (l0() != null && l0().s1() != null) {
                boolean b12 = l0().b1();
                zv9 s1 = l0().s1();
                if (b12) {
                    mwa o4 = o4(s1);
                    if (s1.x() != null && !s1.x().equals(o4.U()) && (customViewPager = this.d) != null) {
                        customViewPager.setCurrentItem(0);
                    }
                }
            }
            this.a.E1().j(this.i0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            O4(bundle);
            d1().onCreate(getPageContext());
            l55 l55Var = new l55();
            this.p = l55Var;
            l55Var.a = 1000L;
            if (this.o != null) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
                userMuteAddAndDelCustomMessage.from = 1;
                BdUniqueId bdUniqueId = this.o.B;
                userMuteAddAndDelCustomMessage.mId = bdUniqueId;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
                BdUniqueId bdUniqueId2 = this.o.B;
                userMuteCheckCustomMessage.mId = bdUniqueId2;
                userMuteCheckCustomMessage.setTag(bdUniqueId2);
                MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            }
            registerListener(this.O0);
            this.g = new ll6(getPageContext());
            pua.g().i(getUniqueId());
        }
    }

    public final void I5(mwa mwaVar, mwa mwaVar2, boolean z2, boolean z3) {
        String str;
        int i2;
        boolean z4;
        boolean z5;
        mwa o4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{mwaVar, mwaVar2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String M1 = l0().M1();
            String U = mwaVar.U();
            if (mwaVar2 != null) {
                str = mwaVar2.U();
            } else {
                str = "";
            }
            if (l0().s1() != null) {
                i2 = l0().s1().Z();
            } else {
                i2 = 0;
            }
            if (n4() != null && n4().c3() != null) {
                AbsPbActivity.e f2 = n4().c3().f(U);
                if (mwaVar != null && l0() != null && l0().s1() != null && f2 != null) {
                    if (p4() != 1 && p4() != 2 && p4() != 3 && p4() != 4 && p4() != 5) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, true, null, false, str, i2, mwaVar.n0(), l0().s1().f(), false, mwaVar.u().getIconInfo(), p4(), z4).addBigImageData(f2.a, f2.b, f2.g, f2.j);
                    if (z3) {
                        addBigImageData.setHighLightPostId(str);
                        z5 = true;
                        addBigImageData.setKeyIsUseSpid(true);
                    } else {
                        z5 = true;
                    }
                    addBigImageData.setKeyFromForumId(l0().getForumId());
                    addBigImageData.setTiebaPlusData(l0().X(), l0().T(), l0().U(), l0().S(), l0().Y());
                    addBigImageData.setBjhData(l0().J0());
                    addBigImageData.setKeyPageStartFrom(l0().r1());
                    addBigImageData.setFromFrsForumId(l0().getFromForumId());
                    addBigImageData.setWorksInfoData(l0().R1());
                    addBigImageData.setIsOpenEditor(z2);
                    if (l0().s1().q() != null) {
                        addBigImageData.setHasForumRule(l0().s1().q().has_forum_rule.intValue());
                    }
                    if (l0().s1().Y() != null) {
                        addBigImageData.setIsManager(l0().s1().Y().getIs_manager());
                    }
                    if (l0().s1().n().getDeletedReasonInfo() != null) {
                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(l0().s1().n().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(l0().s1().n().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    if (l0().s1().n() != null) {
                        addBigImageData.setForumHeadUrl(l0().s1().n().getImage_url());
                        addBigImageData.setUserLevel(l0().s1().n().getUser_level());
                    }
                    if (l0() != null && (o4 = o4(l0().s1())) != null) {
                        if (!o4.f1127T && !mwaVar.f1127T) {
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

    public final void L4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.A = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0929e6);
            this.B = this.c.findViewById(R.id.obfuscated_res_0x7f092a43);
            this.C = this.c.findViewById(R.id.obfuscated_res_0x7f091ba3);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0909e4);
            this.E = imageView;
            imageView.setOnClickListener(new d0(this));
            T4();
            this.F = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ba6);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091b9d);
            this.D = linearLayout;
            linearLayout.setOnClickListener(new e0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ba4);
            this.G = imageView2;
            imageView2.setOnClickListener(this.K0);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ba2);
            this.H = imageView3;
            imageView3.setOnClickListener(this.K0);
            if (booleanExtra) {
                this.H.setVisibility(8);
            } else {
                this.H.setVisibility(0);
            }
            if (S4()) {
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
                this.H.setPadding(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ba7);
            this.I = imageView4;
            imageView4.setOnClickListener(this.K0);
            this.J = new u6a(this.I);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ba5);
            this.K = textView;
            textView.setVisibility(0);
            B5(false);
        }
    }

    public final boolean M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (l0() == null) {
                return true;
            }
            if (l0().s1() != null && l0().s1().a()) {
                return true;
            }
            if (l0().d1()) {
                MarkData O0 = l0().O0();
                if (O0 != null && l0().b1() && A4() != null) {
                    MarkData I0 = l0().I0(A4().getFirstVisiblePosition());
                    if (I0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", O0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                        f05 f05Var = new f05(getBaseFragmentActivity());
                        f05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f02a4));
                        f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new n(this, I0, O0, f05Var));
                        f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new o(this, O0, f05Var));
                        f05Var.setOnCalcelListener(new p(this));
                        f05Var.create(getBaseFragmentActivity().getPageContext());
                        f05Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", O0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (l0().s1() != null && l0().s1().I() != null && l0().s1().I().size() > 0 && l0().b1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T3() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && l0() != null && this.a != null) {
            eh5 eh5Var = this.W;
            if (eh5Var != null && eh5Var.t) {
                return;
            }
            dh5 dh5Var = new dh5();
            t5(dh5Var);
            eh5 eh5Var2 = (eh5) dh5Var.a(getContext());
            this.W = eh5Var2;
            eh5Var2.a0(this.a.getPageContext());
            this.W.j0(this.C0);
            this.W.k0(this.J0);
            eh5 eh5Var3 = this.W;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            eh5Var3.E(pageContext, extras);
            this.W.a().M(true);
            setEditorTools(this.W.a());
            if (!l0().f1()) {
                this.W.t(l0().M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.W.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (l0().d2()) {
                this.W.g0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.W.g0(B4());
            }
        }
    }

    public final void W4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && l0() != null && l0().s1() != null && n4() != null && this.q != null) {
            MarkData markData = null;
            if (l0().s1() != null && l0().s1().a()) {
                markData = l0().I0(0);
            } else {
                CustomViewPager customViewPager = this.d;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = l0().m1(o4(l0().s1()));
                } else if (n4() != null) {
                    markData = l0().I0(n4().Z2());
                }
            }
            if (markData == null) {
                return;
            }
            w5();
            this.q.i(markData);
            if (!this.q.e()) {
                if (l0() != null && !s4a.g(l0().M1())) {
                    this.J.n(2);
                    s4a.a(l0().M1());
                }
                this.q.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.q.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final String q4() {
        InterceptResult invokeV;
        ArrayList<mwa> I;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            if (l0() == null || l0().s1() == null || l0().s1().I() == null || (count = ListUtils.getCount((I = l0().s1().I()))) == 0) {
                return "";
            }
            if (l0().E1()) {
                Iterator<mwa> it = I.iterator();
                while (it.hasNext()) {
                    mwa next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int i2 = 0;
            if (A4() != null && n4() != null) {
                i2 = n4().X2();
            }
            mwa mwaVar = (mwa) ListUtils.getItem(I, i2);
            if (mwaVar != null && mwaVar.u() != null) {
                if (l0().n2(mwaVar.u().getUserId())) {
                    return mwaVar.U();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    mwa mwaVar2 = (mwa) ListUtils.getItem(I, i3);
                    if (mwaVar2 == null || mwaVar2.u() == null || mwaVar2.u().getUserId() == null) {
                        break;
                    } else if (l0().n2(mwaVar2.u().getUserId())) {
                        return mwaVar2.U();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    mwa mwaVar3 = (mwa) ListUtils.getItem(I, i4);
                    if (mwaVar3 == null || mwaVar3.u() == null || mwaVar3.u().getUserId() == null) {
                        break;
                    } else if (l0().n2(mwaVar3.u().getUserId())) {
                        return mwaVar3.U();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void M4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.Z = new PbFakeFloorModel(getPageContext());
            PbModel l02 = l0();
            this.Z.h0(l02.X(), l02.T(), l02.U(), l02.S(), l02.Y());
            this.Z.setFromForumId(l02.getFromForumId());
            k0a k0aVar = new k0a(getPageContext(), this.Z, this.c);
            this.Y = k0aVar;
            k0aVar.p(new h0(this));
            this.Y.s(this.I0);
            this.Z.j0(new i0(this));
        }
    }

    public final void O5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && l0() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.T(l0().getForumId()) && l0().s1() != null && l0().s1().n() != null) {
            boolean z2 = true;
            if (l0().s1().n().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                l0().F0().S(l0().getForumId(), l0().M1());
            }
        }
    }

    public void Q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            aw6 aw6Var = new aw6(getActivity());
            this.a0 = aw6Var;
            aw6Var.i(this.H0);
            this.d = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091c52);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f0912d7);
            this.k = (MaskView) this.c.findViewById(R.id.mask_view);
            this.f.setOnClickListener(this.K0);
            L4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.e = videoPbFragmentAdapter;
            this.d.setAdapter(videoPbFragmentAdapter);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f092a7d);
            this.l = (PbFallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090b3e);
            p5();
            this.l.setAnimationListener(new c0(this));
            N4();
            M4();
        }
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && l0() != null && l0().s1() != null && l0().s1().R() != null) {
            ThreadData R = l0().s1().R();
            R.mRecomAbTag = l0().y1();
            R.mRecomWeight = l0().B1();
            R.mRecomSource = l0().A1();
            R.mRecomExtra = l0().z1();
            R.isSubPb = l0().f1();
            if (R.getFid() == 0) {
                R.setFid(JavaTypesHelper.toLong(l0().getForumId(), 0L));
            }
            StatisticItem i2 = cp5.i(getContext(), R, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public boolean X3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if ((l0() != null && l0().s1().a()) || this.S == null || l0() == null || l0().s1() == null || ThreadCardUtils.isSelf(l0().s1().R()) || l0().s1().f() == null) {
                return true;
            }
            return this.S.checkPrivacyBeforeInvokeEditor(l0().s1().f().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            super.onDestroy();
            pua.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.O0);
            ItemCardHelper.w(null);
            d1().onDestory(getPageContext());
            u6a u6aVar = this.J;
            if (u6aVar != null) {
                u6aVar.j();
            }
            ForumManageModel forumManageModel = this.r;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.S;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            m6a m6aVar = this.o;
            if (m6aVar != null) {
                m6aVar.j0();
            }
            k0a k0aVar = this.Y;
            if (k0aVar != null) {
                k0aVar.m();
            }
            if (l0() != null) {
                l0().cancelLoadData();
                l0().destory();
                if (l0().o1() != null) {
                    l0().o1().d();
                }
            }
            eh5 eh5Var = this.W;
            if (eh5Var != null) {
                eh5Var.H();
            }
            this.p = null;
            yva.d();
            J5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            super.onPause();
            this.h0 = true;
            d1().onPause();
            if (l0() != null && !l0().f1()) {
                this.W.R(l0().M1());
            }
            po4.w().E();
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.y0);
            MessageManager.getInstance().unRegisterListener(this.N0);
        }
    }

    public final void reset() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && this.W != null && this.X != null) {
            zg5.a().c(0);
            this.W.Q();
            this.W.O();
            if (this.W.y() != null) {
                WriteImagesInfo y2 = this.W.y();
                if (this.W.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                y2.setMaxImagesAllowed(i2);
            }
            this.W.h0(SendView.f);
            this.W.j(SendView.f);
            qe5 t2 = this.X.t(23);
            qe5 t3 = this.X.t(2);
            qe5 t4 = this.X.t(5);
            if (t3 != null) {
                t3.display();
            }
            if (t4 != null) {
                t4.display();
            }
            if (t2 != null) {
                t2.hide();
            }
            this.X.invalidate();
        }
    }

    public final void O4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            fh5 fh5Var = new fh5();
            this.V = fh5Var;
            t5(fh5Var);
            eh5 eh5Var = (eh5) this.V.a(getActivity());
            this.W = eh5Var;
            eh5Var.a0(this.a.getPageContext());
            this.W.j0(this.C0);
            this.W.k0(this.J0);
            this.W.c0(1);
            this.W.h0(SendView.f);
            this.W.j(SendView.f);
            this.W.E(this.a.getPageContext(), bundle);
            this.W.a().c(new te5(getActivity()));
            this.W.a().M(true);
            y5(true);
            if (l0() != null) {
                this.W.N(l0().U0(), l0().M1(), l0().Q0());
            }
            registerListener(this.u0);
            registerListener(this.w0);
            registerListener(this.E0);
            registerListener(this.t0);
            registerListener(this.v0);
            registerListener(this.x0);
            registerListener(this.R0);
            if (!l0().f1()) {
                this.W.t(l0().M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.W.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (l0().d2()) {
                this.W.g0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.W.g0(B4());
            }
            this.f1141T = new q1a();
            if (this.W.v() != null) {
                this.f1141T.m(this.W.v().k());
            }
            this.W.Z(this.s0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.S = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new z(this));
        }
    }

    public void Q5(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            DetailInfoAndReplyFragment n4 = n4();
            if (n4 != null && n4.G2() != null && n4.G2().g() != null && n4.G2().h() != null) {
                n4.G2().g().x0(z2);
                n4.G2().h().W(z2);
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

    public boolean Y3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            if (this.S != null && l0() != null && l0().s1() != null && !ThreadCardUtils.isSelf(l0().s1().R()) && l0().s1().f() != null) {
                return this.S.checkPrivacyBeforeSend(l0().s1().f().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, editorTools) == null) {
            this.X = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091b9e);
            this.X.setOnCancelClickListener(new m0(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.X.getParent() == null) {
                this.c.addView(this.X, layoutParams);
            }
            this.X.F(TbadkCoreApplication.getInst().getSkinType());
            this.X.setActionListener(24, new n0(this));
            H4();
            this.W.i(new o0(this));
        }
    }

    public final void t5(fh5 fh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048709, this, fh5Var) == null) && fh5Var != null && l0() != null) {
            fh5Var.p(l0().R0());
            if (l0().s1() != null && l0().s1().n() != null) {
                fh5Var.o(l0().s1().n());
            }
            fh5Var.q("pb");
            fh5Var.r(l0());
            fh5Var.s(PbNewEditorTool.InputShowType.REPLY_VIDEO);
        }
    }

    public final void x5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048724, this, i2) != null) || l0() == null) {
            return;
        }
        int C1 = l0().C1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    l0().a3(1);
                } else {
                    l0().a3(4);
                }
            } else {
                l0().a3(3);
            }
        } else {
            l0().a3(2);
        }
        int C12 = l0().C1();
        if (C1 == 4 || C12 == 4) {
            a5();
        }
    }

    public final void S3(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048619, this, z2, str) == null) && l0() != null && l0().s1() != null && l0().s1().R() != null) {
            ThreadData R = l0().s1().R();
            R.mRecomAbTag = l0().y1();
            R.mRecomWeight = l0().B1();
            R.mRecomSource = l0().A1();
            R.mRecomExtra = l0().z1();
            if (R.getFid() == 0) {
                R.setFid(JavaTypesHelper.toLong(l0().getForumId(), 0L));
            }
            StatisticItem i2 = cp5.i(getContext(), R, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = cp5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (R.isVideoThreadType()) {
                    if (uu5.e(str) > 40) {
                        str2 = uu5.m(str, 40);
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
                xo5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (p4() == 1) {
                    i2.param("obj_locate", 4);
                } else if (p4() == 2) {
                    i2.param("obj_locate", 5);
                } else if (p4() == 3) {
                    i2.param("obj_locate", 2);
                } else if (p4() == 4) {
                    i2.param("obj_locate", 3);
                } else if (p4() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", l0().M1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", l0().s1().o());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = cp5.i(getContext(), R, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", l0().M1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", l0().s1().o());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = cp5.i(getContext(), R, "c14303");
            if (i4 != null) {
                if (p4() == 1) {
                    i4.param("obj_locate", 1);
                } else if (p4() == 2) {
                    i4.param("obj_locate", 2);
                } else if (p4() == 3) {
                    i4.param("obj_locate", 3);
                } else if (p4() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", l0().M1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", l0().s1().o());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }

    public final void U4(View view2, String str, String str2, mwa mwaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048624, this, view2, str, str2, mwaVar) != null) || view2 == null || str == null || str2 == null || V3() || !X3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.b0);
            this.c0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.Y != null && mwaVar != null) {
            if (mwaVar.f0() != null) {
                str3 = mwaVar.f0().toString();
            } else {
                str3 = "";
            }
            this.Y.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), mwaVar.u().getName_show(), str3));
        }
        if (l0() != null && l0().s1() != null && l0().s1().a()) {
            SafeHandler.getInst().postDelayed(new p0(this, str, str2), 0L);
            return;
        }
        SafeHandler.getInst().postDelayed(new q0(this, str, str2), 0L);
        if (l0() == null || l0().s1() == null || l0().s1().n() == null) {
        }
    }

    public final boolean X4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
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

    public boolean m5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof mwa)) {
                return false;
            }
            mwa mwaVar = (mwa) obj;
            if (!TextUtils.isEmpty(mwaVar.x()) && qv4.c().g()) {
                return X4(mwaVar.U());
            }
            if (checkUpIsLogin() && l0() != null && l0().s1() != null) {
                k0a k0aVar = this.Y;
                if (k0aVar != null) {
                    k0aVar.g();
                }
                pw9 pw9Var = new pw9();
                pw9Var.v(l0().s1().n());
                pw9Var.z(l0().s1().R());
                pw9Var.x(mwaVar);
                this.Z.k0(pw9Var);
                this.Z.setPostId(mwaVar.U());
                U4(view2, mwaVar.u().getUserId(), "", mwaVar);
                TiebaStatic.log("c11743");
                eh5 eh5Var = this.W;
                if (eh5Var != null) {
                    r5(eh5Var.C());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void Z4(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048637, this, spriteMemeInfo) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
            return;
        }
        f5(spriteMemeInfo);
        if (l0() != null && l0().s1() != null && l0().s1().R() != null && l0().s1().R().getAuthor() != null) {
            TiebaStatic.log(new StatisticItem("c13701").param("tid", l0().N1()).param("fid", l0().s1().o()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            TiebaStatic.log(new StatisticItem("c13402").param("tid", l0().M1()).param("fid", l0().s1().o()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", l0().getForumId());
            statisticItem.param("tid", l0().M1());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", q4());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 11);
            statisticItem.param("obj_locate", p4());
            TiebaStatic.log(statisticItem);
        }
    }

    public void j5(pw9 pw9Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, pw9Var) == null) && l0() != null && l0().s1() != null && pw9Var.i() != null) {
            String U = pw9Var.i().U();
            ArrayList<mwa> I = l0().s1().I();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= I.size()) {
                    break;
                }
                mwa mwaVar = I.get(i2);
                if (mwaVar.U() != null && mwaVar.U().equals(U)) {
                    ArrayList<mwa> k2 = pw9Var.k();
                    mwaVar.u1(pw9Var.m());
                    if (mwaVar.k0() != null && k2 != null) {
                        Iterator<mwa> it = k2.iterator();
                        while (it.hasNext()) {
                            mwa next = it.next();
                            if (mwaVar.t0() != null && next != null && next.u() != null && (metaData = mwaVar.t0().get(next.u().getUserId())) != null) {
                                next.T0(metaData);
                                next.j1(true);
                                next.E1(getPageContext(), l0().n2(metaData.getUserId()));
                            }
                        }
                        if (k2.size() != mwaVar.k0().size()) {
                            z3 = true;
                        }
                        if (!mwaVar.A0(true)) {
                            mwaVar.k0().clear();
                            mwaVar.k0().addAll(k2);
                        }
                        z2 = z3;
                    }
                    if (mwaVar.E() != null) {
                        mwaVar.R0();
                    }
                } else {
                    i2++;
                }
            }
            if (!l0().b1() && z2 && n4() != null) {
                n4().g3();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            BDLayoutMode layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 4) {
                z2 = false;
            }
            layoutMode.setNightMode(z2);
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c);
            q1a q1aVar = this.f1141T;
            if (q1aVar != null) {
                q1aVar.i();
            }
            EditorTools editorTools = this.X;
            if (editorTools != null) {
                editorTools.F(i2);
            }
            k0a k0aVar = this.Y;
            if (k0aVar != null) {
                k0aVar.l(i2);
            }
            LinearLayout linearLayout = this.D;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (l0() != null && l0().d1()) {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.G, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.E, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            if (l0() != null) {
                P5(l0().s1());
            }
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.K, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.K, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (n4() != null) {
                n4().onChangeSkinType(i2);
            }
            K5();
        }
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (l0().X0() || l0().a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", l0().M1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, l0().M1()));
            if (M5()) {
                this.a.finish();
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public void b0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, context, str) == null) {
            if (!StringUtils.isNull(str) && !TextUtils.isDigitsOnly(str) && ey9.a(str)) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + str);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            }
            this.z = true;
        }
    }

    public void i5(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048663, this, z2, markData) != null) || l0() == null) {
            return;
        }
        v5();
        l0().g3(z2);
        jr4 jr4Var = this.q;
        if (jr4Var != null) {
            jr4Var.h(z2);
            if (markData != null) {
                this.q.i(markData);
            }
        }
        if (l0().d1()) {
            V4();
        } else if (n4() != null) {
            n4().g3();
        }
    }

    public void c4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.r.h0()) {
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
                    this.r.j0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.r.k0(l0().s1().n().getId(), l0().s1().n().getName(), l0().s1().R().getId(), str, intValue3, intValue2, booleanValue, l0().s1().R().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                br6.b().c(new y95(l0().M1()));
            } else if (intValue == 4 || intValue == 6) {
                if (l0().N0() != null) {
                    l0().N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void j4(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048665, this, i2, gVar) == null) && gVar != null && l0() != null && l0().s1() != null && l0().s1().R() != null) {
            i4(this.r.getLoadDataMode(), gVar.a, gVar.b, false);
            if (gVar.a) {
                this.O = true;
                if (i2 != 2 && i2 != 3) {
                    if (i2 == 4 || i2 == 5) {
                        this.P = false;
                        this.Q = true;
                    }
                } else {
                    this.P = true;
                    this.Q = false;
                }
                if (i2 == 2) {
                    l0().s1().R().setIs_good(1);
                    l0().T2(1);
                } else if (i2 == 3) {
                    l0().s1().R().setIs_good(0);
                    l0().T2(0);
                } else if (i2 == 4) {
                    l0().s1().R().setIs_top(1);
                    l0().U2(1);
                } else if (i2 == 5) {
                    l0().s1().R().setIs_top(0);
                    l0().U2(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
            }
            if (l0().s1().R() != null && n4() != null) {
                n4().l3();
            }
        }
    }

    public void d4(f05 f05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, f05Var, jSONArray) == null) {
            f05Var.dismiss();
            if (l0() != null && l0().s1() != null && l0().s1().R() != null && l0().s1().n() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(f05Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    c4((SparseArray) f05Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void e4(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                c4(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // com.baidu.tieba.h6a
    public void finish() {
        CardHListViewData s2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            PbModel B1 = this.a.B1();
            if (B1 != null && B1.s1() != null && B1.s1().R() != null && !B1.s1().a()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = B1.s1().R().getId();
                if (B1.isShareThread() && B1.s1().R().originalThreadData != null) {
                    historyMessage.threadName = B1.s1().R().originalThreadData.b;
                } else {
                    historyMessage.threadName = B1.s1().R().getTitle();
                }
                if (B1.isShareThread() && !e1()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = B1.s1().n().getName();
                }
                ArrayList<mwa> I = B1.s1().I();
                if (I != null && I.size() > 0) {
                    historyMessage.postID = I.get(0).U();
                }
                historyMessage.isHostOnly = B1.V0();
                historyMessage.isSquence = B1.L1();
                historyMessage.isShareThread = B1.isShareThread();
                historyMessage.threadType = B1.s1().R().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            eh5 eh5Var = this.W;
            if (eh5Var != null) {
                eh5Var.H();
            }
            if (B1 != null && (B1.X0() || B1.a1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", B1.M1());
                if (this.O) {
                    if (this.Q) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", B1.g1());
                    }
                    if (this.P) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", B1.c1());
                    }
                }
                if (B1.s1() != null && System.currentTimeMillis() - this.b >= 40000 && (s2 = B1.s1().s()) != null && !ListUtils.isEmpty(s2.getDataList())) {
                    intent.putExtra("guess_like_data", s2);
                }
                this.a.setResult(-1, intent);
            }
            if (M5()) {
                if (B1 != null) {
                    zv9 s1 = B1.s1();
                    if (s1 != null) {
                        if (s1.Y() != null) {
                            s1.Y().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s1.Y().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.R) {
                            e1a.b().q(this.d.getCurrentItem());
                            BdTypeRecyclerView A4 = A4();
                            Parcelable parcelable = null;
                            if (A4 != null) {
                                parcelable = A4.onSaveInstanceState();
                            }
                            e1a.b().l(B1.t1(), parcelable, B1.L1(), B1.V0(), false);
                        }
                    }
                } else {
                    e1a.b().k();
                }
                L5();
            }
        }
    }

    public void g5(boolean z2, int i2, int i3, int i4, zv9 zv9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), zv9Var, str, Integer.valueOf(i5)}) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null) {
                for (BaseFragment baseFragment : videoPbFragmentAdapter.c()) {
                    if (baseFragment instanceof g6a) {
                        ((g6a) baseFragment).s2(z2, i2, i3, i4, zv9Var, str, i5);
                    }
                }
            }
            s2(z2, i2, i3, i4, zv9Var, str, i5);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void h1(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048659, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (uy5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), uy5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (t1a.c(objArr[i2].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048680, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.W.G(i2, i3, intent);
            k0a k0aVar = this.Y;
            if (k0aVar != null) {
                k0aVar.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                C4(i3, intent);
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
                                if (l4() != null) {
                                    l4().performClick();
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
                W4();
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public void x0(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048722, this, context, str, z2) == null) {
            if (t1a.c(str) && l0() != null && l0().M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", l0().M1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    ld5 ld5Var = new ld5();
                    ld5Var.a = str;
                    ld5Var.b = 3;
                    ld5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, ld5Var));
                }
            } else {
                t1a.a().e(getPageContext(), str);
            }
            this.z = true;
        }
    }

    public void i4(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f14e6));
            } else if (z3) {
                if (rd.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                }
                showToast(str);
            }
        }
    }

    public SparseArray<Object> u4(zv9 zv9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048713, this, new Object[]{zv9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            if (zv9Var == null) {
                return null;
            }
            return l4a.b(zv9Var, i2);
        }
        return (SparseArray) invokeCommon.objValue;
    }
}
