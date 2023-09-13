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
import com.baidu.tieba.ae5;
import com.baidu.tieba.aj5;
import com.baidu.tieba.aj9;
import com.baidu.tieba.al5;
import com.baidu.tieba.ao9;
import com.baidu.tieba.aq9;
import com.baidu.tieba.bg;
import com.baidu.tieba.by5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cg;
import com.baidu.tieba.cq9;
import com.baidu.tieba.cx5;
import com.baidu.tieba.d45;
import com.baidu.tieba.dj5;
import com.baidu.tieba.do9;
import com.baidu.tieba.e26;
import com.baidu.tieba.ed5;
import com.baidu.tieba.eha;
import com.baidu.tieba.ei;
import com.baidu.tieba.ej5;
import com.baidu.tieba.es9;
import com.baidu.tieba.ey5;
import com.baidu.tieba.fj5;
import com.baidu.tieba.gq9;
import com.baidu.tieba.gz6;
import com.baidu.tieba.h26;
import com.baidu.tieba.hu6;
import com.baidu.tieba.hw4;
import com.baidu.tieba.i25;
import com.baidu.tieba.i9;
import com.baidu.tieba.ih9;
import com.baidu.tieba.kb5;
import com.baidu.tieba.ke5;
import com.baidu.tieba.kg5;
import com.baidu.tieba.lo6;
import com.baidu.tieba.lqa;
import com.baidu.tieba.m05;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.ms5;
import com.baidu.tieba.mt4;
import com.baidu.tieba.nr9;
import com.baidu.tieba.nt4;
import com.baidu.tieba.on9;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.pha;
import com.baidu.tieba.qr9;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rj9;
import com.baidu.tieba.rr9;
import com.baidu.tieba.rs5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.si5;
import com.baidu.tieba.sk5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tha;
import com.baidu.tieba.ti5;
import com.baidu.tieba.tk5;
import com.baidu.tieba.uk5;
import com.baidu.tieba.uk9;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v95;
import com.baidu.tieba.ve5;
import com.baidu.tieba.vf5;
import com.baidu.tieba.vfa;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vm9;
import com.baidu.tieba.wh5;
import com.baidu.tieba.wk5;
import com.baidu.tieba.wn9;
import com.baidu.tieba.wr9;
import com.baidu.tieba.xk5;
import com.baidu.tieba.xx5;
import com.baidu.tieba.y45;
import com.baidu.tieba.yk5;
import com.baidu.tieba.z45;
import com.baidu.tieba.zr9;
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
public abstract class AbsVideoPbFragment extends BaseFragment implements h26, VoiceManager.j, rr9, TbRichTextView.t, qr9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int V0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener A0;
    public LinearLayout B;
    public CustomMessageListener B0;
    public View C;
    public tk5 C0;
    public View D;
    public final NewWriteModel.d D0;
    public LinearLayout E;
    public View.OnClickListener E0;
    public ImageView F;
    public CustomMessageListener F0;
    public TextView G;
    public final i9 G0;
    public ImageView H;
    public View.OnTouchListener H0;
    public ImageView I;
    public final gz6.b I0;
    public ImageView J;
    public NewWriteModel.d J0;
    public es9 K;
    public uk5 K0;
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
    public ReplyPrivacyCheckController f1147T;
    public final View.OnLongClickListener T0;
    public ao9 U;
    public SortSwitchButton.f U0;
    public PermissionJudgePolicy V;
    public yk5 W;
    public xk5 X;
    public EditorTools Y;
    public vm9 Z;
    public AbsPbActivity a;
    public PbFakeFloorModel a0;
    public long b;
    public gz6 b0;
    public RelativeLayout c;
    public int[] c0;
    public CustomViewPager d;
    public int d0;
    public VideoPbFragmentAdapter e;
    public int e0;
    public View f;
    public int f0;
    public lo6 g;
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
    public wr9 o;
    public v95 p;
    public hw4 q;
    public ve5 r;
    public final PbModel.h r0;
    public ForumManageModel s;
    public final hw4.a s0;
    public VoiceManager t;
    public tk5 t0;
    public bg<GifView> u;
    public final CustomMessageListener u0;
    public bg<TextView> v;
    public CustomMessageListener v0;
    public bg<ImageView> w;
    public final CustomMessageListener w0;
    public bg<View> x;
    public CustomMessageListener x0;
    public bg<LinearLayout> y;
    public HttpMessageListener y0;
    public bg<RelativeLayout> z;
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

    public abstract int G3();

    @Override // com.baidu.tieba.h26
    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract int I3();

    @Override // com.baidu.tieba.qr9
    public void L1(boolean z2, int i2, int i3, int i4, aj9 aj9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aj9Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // com.baidu.tieba.rr9
    public PbFragment O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final int Q3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
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

    @Override // com.baidu.tieba.rr9
    public AbsVideoPbFragment S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<TiebaPlusRecommendCard> V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<FestivalTipView> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void f0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.h26
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public abstract boolean j4();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048701, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void u1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048713, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<ItemCardView> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
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
                    this.b.a.r4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                    aq9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) == null) {
                if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.X() != null && this.a.X().r1() != null) {
                        statisticItem.param("fid", this.a.X().r1().l());
                    }
                    statisticItem.param("tid", this.a.X().L1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.Y4();
                this.a.I4(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    kb5.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.X() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.X().z0(postWriteCallBackData.getPostId());
                        if (this.a.E3() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.g0 = absVideoPbFragment.E3().n2();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.h0 = absVideoPbFragment2.E3().o2();
                            this.a.X().Q2(this.a.g0, this.a.h0);
                        }
                    }
                    if (this.a.d != null) {
                        this.a.d.setCurrentItem(0);
                    }
                    this.a.o.G();
                    this.a.U.c();
                    if (this.a.X != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.F4(absVideoPbFragment3.X.z());
                    }
                    this.a.Y3();
                    this.a.P4(true);
                    this.a.X().W1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.O4(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && this.a.E3() != null) {
                            this.a.E3().w2();
                        }
                    } else if (this.a.X().U0()) {
                        aj9 r1 = this.a.X().r1();
                        if (r1 != null && r1.O() != null && r1.O().getAuthor() != null && (userId = r1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.X().i3()) {
                            this.a.K4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.X().i3()) {
                        this.a.K4();
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
                    absVideoPbFragment4.i3(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.X.y() || this.a.X.A()) {
                        this.a.X.w(false, postWriteCallBackData);
                    }
                    this.a.U.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.f1147T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    y45 y45Var = new y45(this.a.getActivity());
                    if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                        y45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        y45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this));
                    y45Var.setPositiveButton(R.string.open_now, new c(this));
                    y45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (ae5Var != null || i == 227001) {
                } else {
                    this.a.N4(i, antiData, str);
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
                    this.b.a.r4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                    aq9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) == null) {
                if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.X() != null && this.a.X().r1() != null) {
                        statisticItem.param("fid", this.a.X().r1().l());
                    }
                    if (this.a.X() != null) {
                        statisticItem.param("tid", this.a.X().L1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    kb5.b(writeData.getContent(), "4");
                }
                if (z) {
                    ao9 ao9Var = this.a.U;
                    if (ao9Var != null) {
                        ao9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        kg5.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.f1147T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    y45 y45Var = new y45(this.a.getActivity());
                    if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                        y45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        y45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this));
                    y45Var.setPositiveButton(R.string.open_now, new c(this));
                    y45Var.create(this.a.getPageContext()).show();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lqa) && customResponsedMessage.getOrginalMessage().getTag() == this.a.o.D) {
                lqa lqaVar = (lqa) customResponsedMessage.getData();
                this.a.o.W();
                SparseArray<Object> sparseArray = (SparseArray) this.a.o.P();
                DataRes dataRes = lqaVar.a;
                boolean z = false;
                if (lqaVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (ei.isEmpty(str)) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.X() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.X != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.F4(absVideoPbFragment.X.z());
                }
                this.a.y4();
                this.a.o.G();
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
                wr9 wr9Var = this.a.o;
                if (tag == wr9Var.D) {
                    wr9Var.W();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    aj9 r1 = this.a.X().r1();
                    if (r1 != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.setUserId(str);
                        r1.v().add(muteUser);
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
                        if (ei.isEmpty(errorString2)) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                ih9 ih9Var = (ih9) customResponsedMessage.getData();
                int type = ih9Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (ih9Var.a() == null) {
                                this.a.w4(false, null);
                                return;
                            } else {
                                this.a.w4(true, (MarkData) ih9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.x3((ForumManageModel.b) ih9Var.a(), false);
                    return;
                }
                this.a.x4((rj9) ih9Var.a());
            }
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
                wr9 wr9Var = this.a.o;
                if (tag == wr9Var.D) {
                    wr9Var.W();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (ei.isEmpty(muteMessage)) {
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
            this.a.T4();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.i0) {
                return;
            }
            this.a.V4();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements tk5 {
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

        @Override // com.baidu.tieba.tk5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ao9 ao9Var = this.a.U;
                if (ao9Var != null && ao9Var.g() != null && this.a.U.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.U.g().c());
                    if (this.a.Z != null && this.a.Z.f() != null && this.a.Z.f().z()) {
                        this.a.Z.f().w(this.a.U.h());
                    }
                    this.a.U.b(true);
                    return true;
                }
                return !this.a.o3(ReplyPrivacyCheckController.TYPE_FLOOR);
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
                if (absVideoPbFragment.f1147T != null && absVideoPbFragment.X() != null && this.a.X().r1() != null && this.a.X().r1().c() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.f1147T.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.X().r1().c().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.X.o0();
                this.a.v3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(AbsVideoPbFragment absVideoPbFragment, int i) {
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
            this.a.c5();
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
            this.a.t4();
            if (this.a.X() != null && this.a.X().r1() != null && this.a.X().r1().O() != null && this.a.X().r1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.X().M1()).param("fid", this.a.X().r1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.X().L1()).param("fid", this.a.X().r1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.a.X().getForumId());
                statisticItem.param("tid", this.a.X().L1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.H3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 11);
                statisticItem.param("obj_locate", this.a.G3());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(AbsVideoPbFragment absVideoPbFragment, int i, boolean z) {
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
                    this.a.L4(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e40);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
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
                this.a.y4();
                if (this.a.E3() != null) {
                    this.a.E3().w2();
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
                absVideoPbFragment.F4(absVideoPbFragment.X.z());
            }
            this.a.P4(false);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements hw4.a {
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

        @Override // com.baidu.tieba.hw4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.J4();
                if (z && this.a.X() != null) {
                    if (this.a.q != null) {
                        this.a.q.h(z2);
                        this.a.B4(z2);
                    }
                    this.a.X().h3(z2);
                    if (this.a.X().r1() != null && (O = this.a.X().r1().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (!this.a.X().c1()) {
                        if (this.a.E3() != null) {
                            this.a.E3().w2();
                        }
                    } else {
                        this.a.m4();
                    }
                    if (z2) {
                        if (this.a.q != null) {
                            if (this.a.q.f() != null && this.a.X() != null && this.a.X().r1() != null && this.a.X().r1().O() != null && this.a.X().r1().O().getAuthor() != null) {
                                MarkData f = this.a.q.f();
                                MetaData author = this.a.X().r1().O().getAuthor();
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
                        this.a.h3();
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
    public class h extends i9 {
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

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.X() != null) {
                    switch (this.a.s.getLoadDataMode()) {
                        case 0:
                            this.a.X().W1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.x3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.y3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.z3(absVideoPbFragment.s.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.y3(absVideoPbFragment2.s.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.o.e0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.y3(absVideoPbFragment3.s.getLoadDataMode(), false, null, false);
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
                this.a.y4();
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
        public void a(tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, thaVar) == null) {
                this.a.a0.d0(thaVar);
                if (this.a.E3() != null) {
                    this.a.E3().w2();
                }
                this.a.Z.g();
                this.a.Y.t();
                this.a.P4(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements gz6.b {
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

        @Override // com.baidu.tieba.gz6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    uk9.d();
                } else {
                    uk9.c();
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
                wr9 wr9Var = this.a.o;
                if (wr9Var != null) {
                    wr9Var.G();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.X() != null && !this.a.X().isLoading) {
                    this.a.Y4();
                    this.a.K4();
                    z = true;
                    if (this.a.X().r1() != null && this.a.X().r1().f != null && this.a.X().r1().f.size() > i) {
                        int intValue = this.a.X().r1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.X().M1()).param("fid", this.a.X().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.X().l3(intValue)) {
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
    public class l implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) && y45Var != null) {
                y45Var.dismiss();
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
        public void onNavigationButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y45Var) == null) {
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
                this.a.y4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ y45 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public n(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, y45Var};
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
            this.c = y45Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
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
                this.d.Z4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements ti5 {
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

        @Override // com.baidu.tieba.ti5
        public void G(si5 si5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, si5Var) == null) {
                Object obj = si5Var.c;
                if ((obj instanceof ed5) && EmotionGroupType.isSendAsPic(((ed5) obj).getType())) {
                    if (this.a.V == null) {
                        this.a.V = new PermissionJudgePolicy();
                    }
                    this.a.V.clearRequestPermissionList();
                    this.a.V.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.V.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.X.f((ed5) si5Var.c);
                    this.a.X.w(false, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ y45 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public o(AbsVideoPbFragment absVideoPbFragment, MarkData markData, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, y45Var};
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
            this.b = y45Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.Z4();
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
            ao9 ao9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ao9Var = this.a.U) != null && ao9Var.e() != null) {
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
            this.c.S4(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class q implements uk5 {
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

        @Override // com.baidu.tieba.uk5
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
            this.c.S4(this.a, this.b);
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
                if (view2.getId() == R.id.obfuscated_res_0x7f091b1e) {
                    if (this.a.X() != null) {
                        this.a.X().q2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.X().L1());
                    statisticItem2.param("fid", this.a.X().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", this.a.X().getForumId());
                    statisticItem3.param("tid", this.a.X().L1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", this.a.H3());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 3);
                    statisticItem3.param("obj_locate", this.a.G3());
                    TiebaStatic.log(statisticItem3);
                    if (!this.a.A) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof tha) {
                                tha thaVar = (tha) obj;
                                if (this.a.X() == null || this.a.X().r1() == null || this.a.a0 == null || thaVar.t() == null || thaVar.L() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.Z != null) {
                                    this.a.Z.g();
                                }
                                rj9 rj9Var = new rj9();
                                rj9Var.v(this.a.X().r1().k());
                                rj9Var.z(this.a.X().r1().O());
                                rj9Var.x(thaVar);
                                this.a.a0.i0(rj9Var);
                                this.a.a0.setPostId(thaVar.U());
                                this.a.l4(view2, thaVar.t().getUserId(), "", thaVar);
                                TiebaStatic.log("c11743");
                                nr9.b(this.a.X().r1(), thaVar, thaVar.f0, 8, 1);
                                if (this.a.X != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.F4(absVideoPbFragment.X.z());
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
                    if (view2.getId() == R.id.pb_video_more && this.a.getPageContext().getPageActivity() != null && this.a.X() != null && this.a.a != null && this.a.a.getIntent() != null) {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.X().L1(), false, true);
                            this.a.E4(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.X().L1(), true, false);
                            this.a.E4(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.X().getForumId());
                        statisticItem4.param("fname", this.a.X().Q0());
                        statisticItem4.param("tid", this.a.X().L1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.E3() == null || this.a.E3().r2() == null || view2 != this.a.E3().r2()) && view2.getId() != R.id.pb_more) {
                        wr9 wr9Var = this.a.o;
                        if (wr9Var != null && wr9Var.R() != null && view2 == this.a.o.R().x()) {
                            this.a.o.J();
                            return;
                        }
                        wr9 wr9Var2 = this.a.o;
                        if ((wr9Var2 == null || wr9Var2.R() == null || view2 != this.a.o.R().D()) && view2.getId() != R.id.obfuscated_res_0x7f090b7b && view2.getId() != R.id.obfuscated_res_0x7f091f2a) {
                            if (this.a.o.R() != null && view2 == this.a.o.R().F()) {
                                if (this.a.X() == null) {
                                    return;
                                }
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.Y4();
                                this.a.K4();
                                this.a.X().f3(1);
                                return;
                            }
                            wr9 wr9Var3 = this.a.o;
                            if (wr9Var3 != null && wr9Var3.R() != null && view2 == this.a.o.R().D()) {
                                this.a.o.J();
                                return;
                            }
                            wr9 wr9Var4 = this.a.o;
                            if (wr9Var4 != null && ((wr9Var4.R() != null && view2 == this.a.o.R().L()) || view2.getId() == R.id.obfuscated_res_0x7f091b60)) {
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                } else if (this.a.m) {
                                    view2.setTag(Integer.valueOf(this.a.X().I1()));
                                    return;
                                } else {
                                    this.a.Y4();
                                    this.a.K4();
                                    this.a.o.D0(view2);
                                    return;
                                }
                            }
                            wr9 wr9Var5 = this.a.o;
                            if (wr9Var5 != null && wr9Var5.R() != null && view2 == this.a.o.R().K()) {
                                if (this.a.X() == null || this.a.X().r1() == null || this.a.X().r1().O() == null) {
                                    return;
                                }
                                this.a.o.J();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment2 = this.a;
                                absVideoPbFragment2.o.V(absVideoPbFragment2.X().r1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae5) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                wr9 wr9Var6 = this.a.o;
                                if (wr9Var6 != null) {
                                    wr9Var6.u0(sparseArray);
                                }
                            } else {
                                wr9 wr9Var7 = this.a.o;
                                if (wr9Var7 != null && wr9Var7.R() != null && view2 == this.a.o.R().I()) {
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
                                wr9 wr9Var8 = this.a.o;
                                if (wr9Var8 != null && wr9Var8.R() != null && view2 == this.a.o.R().J()) {
                                    this.a.o.K();
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.o.B0(absVideoPbFragment3.N0);
                                    return;
                                }
                                wr9 wr9Var9 = this.a.o;
                                if (wr9Var9 != null && wr9Var9.R() != null && view2 == this.a.o.R().C()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.X().L1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.o.J();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                wr9 wr9Var10 = this.a.o;
                                if (wr9Var10 != null && (view2 == wr9Var10.N() || (this.a.o.R() != null && (view2 == this.a.o.R().G() || view2 == this.a.o.R().H())))) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.X() == null || this.a.X().r1() == null || this.a.s.f0()) {
                                        return;
                                    } else {
                                        this.a.o.G();
                                        if (this.a.o.R() != null && view2 == this.a.o.R().H()) {
                                            i3 = this.a.X().r1().O().getIs_top() == 1 ? 5 : 4;
                                        } else if (this.a.o.R() != null && view2 == this.a.o.R().G()) {
                                            i3 = this.a.X().r1().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i3 = view2 == this.a.o.N() ? 2 : 0;
                                        }
                                        ForumData k = this.a.X().r1().k();
                                        String name = k.getName();
                                        String id = k.getId();
                                        String id2 = this.a.X().r1().O().getId();
                                        this.a.showProgressBar();
                                        this.a.s.j0(id, name, id2, i3, this.a.o.O());
                                        return;
                                    }
                                }
                                wr9 wr9Var11 = this.a.o;
                                if (wr9Var11 != null && wr9Var11.R() != null && view2 == this.a.o.R().z()) {
                                    if (this.a.X() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.a.o.G();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    SparseArray<Object> L3 = absVideoPbFragment4.L3(absVideoPbFragment4.X().r1(), this.a.X().K1(), 1);
                                    if (L3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.X().r1().k().getId(), this.a.X().r1().k().getName(), this.a.X().r1().O().getId(), String.valueOf(this.a.X().r1().V().getUserId()), (String) L3.get(R.id.tag_forbid_user_name), (String) L3.get(R.id.tag_forbid_user_name_show), (String) L3.get(R.id.tag_forbid_user_post_id), (String) L3.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                wr9 wr9Var12 = this.a.o;
                                if (wr9Var12 != null && wr9Var12.R() != null && view2 == this.a.o.R().t()) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> L32 = absVideoPbFragment5.L3(absVideoPbFragment5.X().r1(), this.a.X().K1(), 1);
                                    if (L32 != null) {
                                        this.a.o.i0(((Integer) L32.get(R.id.tag_del_post_type)).intValue(), (String) L32.get(R.id.tag_del_post_id), ((Integer) L32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) L32.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.a.o.J();
                                    if (this.a.X() == null || this.a.X().r1() == null || this.a.X().r1().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.X().r1().O();
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
                                wr9 wr9Var13 = this.a.o;
                                if (wr9Var13 != null && wr9Var13.R() != null && view2 == this.a.o.R().y()) {
                                    if (this.a.X() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> L33 = absVideoPbFragment6.L3(absVideoPbFragment6.X().r1(), this.a.X().K1(), 1);
                                    if (L33 != null) {
                                        if (StringUtils.isNull((String) L33.get(R.id.tag_del_multi_forum))) {
                                            this.a.o.f0(((Integer) L33.get(R.id.tag_del_post_type)).intValue(), (String) L33.get(R.id.tag_del_post_id), ((Integer) L33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) L33.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.a.o.g0(((Integer) L33.get(R.id.tag_del_post_type)).intValue(), (String) L33.get(R.id.tag_del_post_id), ((Integer) L33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) L33.get(R.id.tag_del_post_is_self)).booleanValue(), (String) L33.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.a.o.J();
                                } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092337 && view2.getId() != R.id.obfuscated_res_0x7f091ae7 && view2.getId() != R.id.obfuscated_res_0x7f091960 && view2.getId() != R.id.obfuscated_res_0x7f091b52) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b50 && view2.getId() != R.id.obfuscated_res_0x7f091d3b && view2.getId() != R.id.obfuscated_res_0x7f091ae1) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091acf && view2.getId() != R.id.collect_num_container) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ad4 && view2.getId() != R.id.share_more_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091ad1 && view2.getId() != R.id.thread_info_commont_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f0927ad) {
                                                        if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                            if (this.a.X() == null) {
                                                                return;
                                                            }
                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                            statisticItem7.param("tid", this.a.X().L1());
                                                            statisticItem7.param("fid", this.a.X().getForumId());
                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem7.param("obj_locate", 2);
                                                            TiebaStatic.log(statisticItem7);
                                                            return;
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091b15 && view2.getId() != R.id.obfuscated_res_0x7f091adc) {
                                                            if (view2.getId() == R.id.obfuscated_res_0x7f091266) {
                                                                this.a.y4();
                                                                return;
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09086b && view2.getId() != R.id.obfuscated_res_0x7f090b78) {
                                                                if (this.a.o.R() != null && view2 == this.a.o.R().u()) {
                                                                    this.a.o.G();
                                                                    if (this.a.X() != null) {
                                                                        this.a.g.f(this.a.X().L1());
                                                                    }
                                                                    if (this.a.X() != null && this.a.X().isPrivacy()) {
                                                                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                        if (this.a.X().r1() != null) {
                                                                            this.a.g.d(3, 3, this.a.X().r1().Q());
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    this.a.g.b();
                                                                    int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.X() == null || this.a.X().r1() == null || this.a.X().r1().Q() == null || !this.a.X().r1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                    if (this.a.X() == null || this.a.X().r1() == null) {
                                                                        return;
                                                                    }
                                                                    this.a.g.d(3, i5, this.a.X().r1().Q());
                                                                    return;
                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae9 || view2.getId() == R.id.obfuscated_res_0x7f091b4a) {
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.X().L1());
                                                                    statisticItem8.param("fid", this.a.X().getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    StatisticItem statisticItem9 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                    statisticItem9.param("fid", this.a.X().getForumId());
                                                                    statisticItem9.param("tid", this.a.X().L1());
                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem9.param("post_id", this.a.H3());
                                                                    statisticItem9.param("obj_source", 1);
                                                                    statisticItem9.param("obj_type", 2);
                                                                    statisticItem9.param("obj_locate", this.a.G3());
                                                                    TiebaStatic.log(statisticItem9);
                                                                    this.a.o.n0(false);
                                                                    this.a.o.Q().onLongClick(view2);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof tha)) {
                                                                    return;
                                                                }
                                                                tha thaVar2 = (tha) sparseArray2.get(R.id.tag_load_sub_data);
                                                                View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                if (thaVar2 == null || view3 == null) {
                                                                    return;
                                                                }
                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09086c);
                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f09086d);
                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b78);
                                                                if (thaVar2.D0()) {
                                                                    thaVar2.j1(false);
                                                                    gq9.e(thaVar2);
                                                                } else {
                                                                    if (this.a.X() != null ? gq9.c(this.a.X().r1(), thaVar2) : false) {
                                                                        thaVar2.j1(true);
                                                                        findViewById.setVisibility(0);
                                                                    }
                                                                }
                                                                SkinManager.setBackgroundColor(findViewById, thaVar2.D0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                SkinManager.setViewTextColor(eMTextView, thaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                WebPManager.setPureDrawable(imageView, thaVar2.D0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, thaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                return;
                                                            }
                                                        } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                BrowserHelper.startWebActivity(view2.getContext(), string, string2, true, true, true);
                                                            }
                                                            this.a.y4();
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (this.a.g0 >= 0) {
                                                        if (this.a.X() != null) {
                                                            this.a.X().M2();
                                                        }
                                                        if (this.a.E3() != null && this.a.E3().W1() != null) {
                                                            this.a.E3().W1().s(this.a.X().r1());
                                                        }
                                                        this.a.g0 = 0;
                                                        this.a.h0 = Integer.MIN_VALUE;
                                                        if (this.a.X() == null || this.a.E3() == null) {
                                                            return;
                                                        }
                                                        this.a.E3().D2(this.a.X().k1(), this.a.X().j1());
                                                        this.a.X().Q2(0, 0);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.X() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                                    if (absVideoPbFragment7.o == null || absVideoPbFragment7.d == null || this.a.X().r1() == null || this.a.X().r1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    aj9 r1 = this.a.X().r1();
                                                    if (r1.O().getReply_num() == 0) {
                                                        this.a.t4();
                                                        return;
                                                    } else if (this.a.E3() == null || this.a.S3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.X().L1()).param("fid", this.a.X().r1().l()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView S3 = this.a.S3();
                                                        if (S3 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = S3.canScrollVertically(1);
                                                        boolean canScrollVertically2 = S3.canScrollVertically(-1);
                                                        if (S3.getLayoutManager() == null || !(S3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) S3.getLayoutManager();
                                                        if (canScrollVertically2 || !canScrollVertically) {
                                                            str = "obj_source";
                                                            int firstVisiblePosition = S3.getFirstVisiblePosition();
                                                            View childAt = S3.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.e0 = firstVisiblePosition;
                                                            this.a.f0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-equipmentHeight) || S3.getCount() < 6)) {
                                                                S3.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                S3.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        } else if (this.a.e0 == -1 && this.a.f0 == Integer.MIN_VALUE) {
                                                            return;
                                                        } else {
                                                            if (this.a.e0 > 3 || (this.a.e0 == 3 && this.a.f0 < (-equipmentHeight))) {
                                                                str = "obj_source";
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + equipmentHeight);
                                                                S3.smoothScrollBy(0, equipmentHeight);
                                                            } else if (this.a.e0 >= 2) {
                                                                str = "obj_source";
                                                                int i6 = equipmentHeight / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + i6);
                                                                S3.smoothScrollBy(0, i6);
                                                            } else {
                                                                str = "obj_source";
                                                                if (this.a.e0 == 1) {
                                                                    int i7 = equipmentHeight / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.e0, this.a.f0 + i7);
                                                                    S3.smoothScrollBy(0, i7);
                                                                } else {
                                                                    S3.smoothScrollBy(0, -this.a.f0);
                                                                }
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        }
                                                        TiebaStatic.log(param);
                                                        ms5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem10 = new StatisticItem("c12942");
                                                        statisticItem10.param("obj_type", i2);
                                                        statisticItem10.param("obj_locate", 4);
                                                        statisticItem10.param("tid", this.a.X().L1());
                                                        statisticItem10.param("nid", r1.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem10);
                                                        if (this.a.X() == null || this.a.X().r1() == null || this.a.X().r1().O() == null || this.a.X().r1().O().getAuthor() == null) {
                                                            return;
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.X().L1()).param("fid", this.a.X().r1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem11.param("fid", this.a.X().getForumId());
                                                        statisticItem11.param("tid", this.a.X().L1());
                                                        statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem11.param("post_id", this.a.H3());
                                                        statisticItem11.param(str, 1);
                                                        statisticItem11.param("obj_type", 12);
                                                        statisticItem11.param("obj_locate", this.a.G3());
                                                        TiebaStatic.log(statisticItem11);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            this.a.V3(true);
                                        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                        } else {
                                            AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                            if (absVideoPbFragment8.o == null || absVideoPbFragment8.X() == null || this.a.E3() == null) {
                                                return;
                                            }
                                            this.a.o.G();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091acf || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.m3(11009) || this.a.X() == null) {
                                                    return;
                                                }
                                                this.a.n4();
                                                if (this.a.X().r1() != null && this.a.X().r1().O() != null && this.a.X().r1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.X().L1()).param("fid", this.a.X().r1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                    StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem12.param("fid", this.a.X().getForumId());
                                                    statisticItem12.param("tid", this.a.X().L1());
                                                    statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem12.param("post_id", this.a.H3());
                                                    statisticItem12.param("obj_source", 1);
                                                    statisticItem12.param("obj_type", 13);
                                                    statisticItem12.param("obj_locate", this.a.G3());
                                                    TiebaStatic.log(statisticItem12);
                                                }
                                                if (this.a.X().r1().O() == null || this.a.X().r1().O().getAuthor() == null || this.a.X().r1().O().getAuthor().getUserId() == null || this.a.q == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                                int T2 = absVideoPbFragment9.o.T(absVideoPbFragment9.X().r1());
                                                ThreadData O2 = this.a.X().r1().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.X().L1()).param("obj_locate", 1).param("obj_id", this.a.X().r1().O().getAuthor().getUserId()).param("obj_type", !this.a.q.e()).param("obj_source", T2).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.j = view2;
                                        }
                                    } else if (this.a.X() == null) {
                                    } else {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091b50) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.X().L1());
                                            statisticItem13.param("fid", this.a.X().getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091d3b) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.i = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b50 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.i = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof tha) {
                                                tha thaVar3 = (tha) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091b50 && (statisticItem = thaVar3.g0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d3b || view2.getId() == R.id.obfuscated_res_0x7f091ae1) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.X().M1()).param("fid", this.a.X().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", thaVar3.U()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.a.X() == null || this.a.X().r1() == null || this.a.a0 == null || thaVar3.t() == null || thaVar3.L() == 1) {
                                                    return;
                                                }
                                                if (this.a.Z != null) {
                                                    this.a.Z.g();
                                                }
                                                rj9 rj9Var2 = new rj9();
                                                rj9Var2.v(this.a.X().r1().k());
                                                rj9Var2.z(this.a.X().r1().O());
                                                rj9Var2.x(thaVar3);
                                                this.a.a0.i0(rj9Var2);
                                                this.a.a0.setPostId(thaVar3.U());
                                                this.a.l4(view2, thaVar3.t().getUserId(), "", thaVar3);
                                                if (this.a.X != null) {
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                    absVideoPbFragment10.F4(absVideoPbFragment10.X.z());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091960) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.X().L1());
                                        statisticItem14.param("fid", this.a.X().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem14);
                                        StatisticItem statisticItem15 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem15.param("fid", this.a.X().getForumId());
                                        statisticItem15.param("tid", this.a.X().L1());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("post_id", this.a.H3());
                                        statisticItem15.param("obj_source", 1);
                                        statisticItem15.param("obj_type", 8);
                                        statisticItem15.param("obj_locate", this.a.G3());
                                        TiebaStatic.log(statisticItem15);
                                    }
                                    if ((view2.getId() != R.id.obfuscated_res_0x7f091ae7 && view2.getId() != R.id.obfuscated_res_0x7f091b52) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091ae7) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.X().getForumId());
                                            statisticItem16.param("tid", this.a.X().L1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param("post_id", this.a.H3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 9);
                                            statisticItem16.param("obj_locate", this.a.G3());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                        if (!this.a.checkUpIsLogin()) {
                                            nr9.v("c10517", this.a.X().r1().l(), 3);
                                            return;
                                        } else if (this.a.X() == null || this.a.X().r1() == null) {
                                            return;
                                        } else {
                                            wr9 wr9Var14 = this.a.o;
                                            if (wr9Var14 != null) {
                                                wr9Var14.G();
                                            }
                                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                            tha thaVar4 = (tha) sparseArray4.get(R.id.tag_load_sub_data);
                                            tha thaVar5 = (tha) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                            if (thaVar4 == null) {
                                                return;
                                            }
                                            if (thaVar4.P() == 1) {
                                                TiebaStatic.log(new StatisticItem("c12630"));
                                            }
                                            StatisticItem statisticItem17 = thaVar4.g0;
                                            if (statisticItem17 != null) {
                                                StatisticItem copy2 = statisticItem17.copy();
                                                copy2.delete("obj_locate");
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091960) {
                                                    copy2.param("obj_locate", 6);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae7) {
                                                    copy2.param("obj_locate", 8);
                                                }
                                                TiebaStatic.log(copy2);
                                            }
                                            this.a.Y4();
                                            TiebaStatic.log("c11742");
                                            if (thaVar5 != null) {
                                                this.a.W4(thaVar4, thaVar5, false, true);
                                                return;
                                            } else {
                                                this.a.W4(thaVar4, null, false, false);
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
                            this.a.Y4();
                            this.a.K4();
                            boolean j3 = this.a.X().j3(this.a.H3());
                            view2.setTag(Boolean.valueOf(j3));
                            if (j3) {
                                this.a.R4();
                                i4 = 1;
                                this.a.m = true;
                            } else {
                                i4 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                        }
                    } else if (!this.a.m && this.a.X().o2(true)) {
                        this.a.m = true;
                        if (this.a.E3() != null) {
                            this.a.E3().I2();
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
    public class r0 implements tk5 {
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

        @Override // com.baidu.tieba.tk5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ao9 ao9Var = this.a.U;
                if (ao9Var != null && ao9Var.e() != null && this.a.U.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.U.e().c());
                    if (this.a.X != null && (this.a.X.y() || this.a.X.A())) {
                        this.a.X.w(false, this.a.U.h());
                    }
                    this.a.U.a(true);
                    return true;
                }
                return !this.a.o3(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s extends xx5<ShareItem> {
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
        @Override // com.baidu.tieba.xx5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel X = this.b.X();
                if (X != null) {
                    X.T2(this.a);
                }
                return cq9.b(this.b.D3(), 2, X);
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
            ao9 ao9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ao9Var = this.a.U) != null && ao9Var.g() != null) {
                if (!this.a.U.g().e()) {
                    this.a.U.b(false);
                }
                this.a.U.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements cx5<ShareItem> {
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
        @Override // com.baidu.tieba.cx5
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
    public class t0 implements cg<ImageView> {
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
                    if (m05.c().g()) {
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = m05.c().g();
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
            wr9 wr9Var = this.a.o;
            if (wr9Var != null) {
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
                    wr9Var.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements cg<GifView> {
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
                if (m05.c().g()) {
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = m05.c().g();
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
        public void b(aj9 aj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aj9Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, aj9 aj9Var, String str, int i4) {
            String T3;
            aj5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), aj9Var, str, Integer.valueOf(i4)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907aa));
                }
                this.a.J4();
                this.a.a4();
                if (this.a.m) {
                    this.a.m = false;
                }
                this.a.P4(false);
                if (z && aj9Var != null) {
                    ThreadData O = aj9Var.O();
                    this.a.s4(aj9Var);
                    this.a.u4(z, i, i2, i3, aj9Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(aj9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(aj9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(aj9Var.V().getBimg_end_time());
                    if (aj9Var.F() != null && aj9Var.F().size() >= 1 && aj9Var.F().get(0) != null) {
                        this.a.X().R2(aj9Var.F().get(0).U());
                    } else if (aj9Var.Y() != null) {
                        this.a.X().R2(aj9Var.Y().U());
                    }
                    if (this.a.q != null) {
                        this.a.q.h(aj9Var.q());
                    }
                    AntiData c = aj9Var.c();
                    if (c != null) {
                        this.a.O = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.O) && this.a.X != null && this.a.X.a() != null && (o = this.a.X.a().o(6)) != null && !TextUtils.isEmpty(this.a.O)) {
                            ((View) o).setOnClickListener(this.a.E0);
                        }
                    }
                    if (this.a.f1147T != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.f1147T.setLikeUserData(attentionHostData);
                    }
                    if (this.a.X() != null && this.a.X().b2()) {
                        T3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        T3 = this.a.T3();
                    }
                    if (!StringUtils.isNull(T3)) {
                        this.a.X.d0(TbSingleton.getInstance().getAdVertiComment(aj9Var.q0(), aj9Var.r0(), T3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.X().L1());
                            jSONObject.put("fid", this.a.X().getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        hu6.b().b(new ke5(this.a.X().L1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (this.a.E3() == null) {
                        return;
                    }
                    if (i != -1) {
                        ArrayList<tha> arrayList = null;
                        if (this.a.X() != null && this.a.X().r1() != null) {
                            arrayList = this.a.X().r1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).L() != 1)) {
                            this.a.E3().F2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else if (this.a.E3().x2()) {
                            this.a.E3().G2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1005));
                        } else {
                            this.a.E3().G2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1006));
                        }
                    } else {
                        this.a.E3().F2("");
                    }
                    this.a.E3().k2();
                }
                vfa.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements cg<View> {
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.H0());
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.X() != null && this.a.X().B1() != i + 1) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.C4(absVideoPbFragment.Q3(i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements cg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e26.a)) {
                e26.a aVar = (e26.a) customResponsedMessage.getData();
                e26.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements cg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && (agreeMessageData = (AgreeMessageData) customResponsedMessage.getData()) != null && (agreeData = agreeMessageData.agreeData) != null && agreeData.agreeType == 2 && this.a.K != null && this.a.X() != null && !cq9.g(this.a.X().L1())) {
                this.a.K.n(2);
                cq9.a(this.a.X().L1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements Comparator<AdverSegmentData> {
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
    public class z0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public z0(AbsVideoPbFragment absVideoPbFragment) {
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
            String T3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.X() != null && this.a.X().b2()) {
                    T3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    T3 = this.a.T3();
                }
                if (!StringUtils.isNull(T3) && this.a.X() != null && this.a.X().r1() != null) {
                    T3 = TbSingleton.getInstance().getAdVertiComment(this.a.X().r1().q0(), this.a.X().r1().r0(), T3);
                }
                if (this.a.X != null) {
                    this.a.X.d0(T3);
                }
                if (this.a.G != null) {
                    this.a.G.setText(T3);
                }
                this.a.P4(false);
                this.a.T4();
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
        this.u0 = new a1(this, 2004016);
        this.v0 = new b1(this, 2004007);
        this.w0 = new c1(this, 2921391);
        this.x0 = new d1(this, 2016450);
        this.y0 = new e1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
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

    public void I4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048598, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            wr9 wr9Var = this.o;
            if (wr9Var == null) {
                return;
            }
            if (z2) {
                wr9Var.G();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.o.H();
            } else {
                this.o.G();
            }
        }
    }

    @Override // com.baidu.tieba.h26
    public void M(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.h26
    public void P(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, str) == null) {
            do9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    public final void b4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048646, this, i2, i3) == null) {
            by5.b(new s(this, i3), new t(this, i3, i2));
        }
    }

    @Override // com.baidu.tieba.h26
    public void p0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048696, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.A = true;
    }

    public void r4(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048703, this, adverSegmentData, i2) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.A(adverSegmentData, getPageContext(), i2, false);
        }
    }

    public final void C4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i2) == null) && X() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(X().L1());
            sendMessage(privacySettingMessage);
        }
    }

    public final void E4(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).d2());
            }
        }
    }

    public void F4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            this.N = z2;
        }
    }

    public void G4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) {
            this.m = z2;
        }
    }

    public final void M4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.X.Y(z2);
            this.X.b0(z2);
            this.X.j0(z2);
        }
    }

    public void P4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048617, this, z2) != null) || this.D == null) {
            return;
        }
        F4(this.X.z());
        if (this.N) {
            Q4(z2);
        } else {
            X3(z2);
        }
    }

    public final void U4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            zr9.a(e0(), D3(), i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) {
            super.onUserChanged(z2);
            k4();
        }
    }

    public void q4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048700, this, i2) == null) && i2 == 0) {
            vfa.g().h(getUniqueId(), false);
            if (S3() != null) {
                k3(S3(), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048708, this, z2) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048687, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(I3(), viewGroup, false);
            h4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<GifView> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.u == null) {
                this.u = new bg<>(new u0(this), 20, 0);
            }
            return this.u;
        }
        return (bg) invokeV.objValue;
    }

    public ve5 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.r;
        }
        return (ve5) invokeV.objValue;
    }

    public LinearLayout C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.E;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<LinearLayout> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.y == null) {
                this.y = new bg<>(new w0(this), 15, 0);
            }
            return this.y;
        }
        return (bg) invokeV.objValue;
    }

    public final void D4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l.setFallingFeedbackListener(new z0(this));
        }
    }

    public DetailInfoAndReplyFragment E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.e.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.t == null) {
                this.t = VoiceManager.instance();
            }
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PbModel J1 = this.a.J1();
            if (J1 == null) {
                return false;
            }
            return J1.k2();
        }
        return invokeV.booleanValue;
    }

    public View.OnClickListener J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.L0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void J4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            hideProgressBar();
            if (E3() != null) {
                E3().k2();
                E3().l2();
            }
        }
    }

    public View.OnClickListener K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.M0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void K4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public hw4 M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.q;
        }
        return (hw4) invokeV.objValue;
    }

    public View.OnLongClickListener N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.T0;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.H0;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public xk5 P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.X;
        }
        return (xk5) invokeV.objValue;
    }

    public void R4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(0);
        }
    }

    public String T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!ei.isEmpty(this.M)) {
                return this.M;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(wn9.g());
            this.M = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void T4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.setTag(Boolean.TRUE);
        }
    }

    @Override // com.baidu.tieba.rr9
    public PbModel.h W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.r0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public void W3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048633, this) != null) || this.D == null) {
            return;
        }
        this.C.setVisibility(8);
        this.D.setVisibility(8);
    }

    @Override // com.baidu.tieba.rr9
    public PbModel X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.a.J1();
        }
        return (PbModel) invokeV.objValue;
    }

    public void X4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.C();
            this.l.setAnimationListener(null);
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<RelativeLayout> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            bg<RelativeLayout> bgVar = new bg<>(new x0(this), 10, 0);
            this.z = bgVar;
            return bgVar;
        }
        return (bg) invokeV.objValue;
    }

    public void Y3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (editorTools = this.Y) != null) {
            editorTools.q();
        }
    }

    public final void Y4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final void Z4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.W1();
        }
    }

    public void a4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(8);
        }
    }

    public void b5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            xk5 xk5Var = this.X;
            if (xk5Var != null) {
                F4(xk5Var.z());
            }
            y4();
            this.o.G();
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<ImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (this.w == null) {
                this.w = new bg<>(new t0(this), 8, 0);
            }
            return this.w;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<View> d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (this.x == null) {
                this.x = new bg<>(new v0(this), 8, 0);
            }
            return this.x;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr9
    public AbsPbActivity e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            setEditorTools(this.X.a());
        }
    }

    public void g4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048660, this) != null) || (editorTools = this.Y) == null) {
            return;
        }
        editorTools.j();
        W3();
    }

    public boolean i4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            EditorTools editorTools = this.Y;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<TextView> j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (this.v == null) {
                this.v = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.v;
        }
        return (bg) invokeV.objValue;
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && this.F != null) {
            w3();
            this.F.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    public final boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            PbModel X = X();
            if (X != null && X.r1() != null) {
                return AntiHelper.b(getPageContext(), X.r1().O());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            super.onStart();
            H0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048712, this) == null) && X() != null && !ei.isEmpty(X().L1())) {
            super.taskStart();
        }
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            reset();
            Y3();
            this.Z.g();
            P4(false);
        }
    }

    public void z4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            this.e0 = -1;
            this.f0 = Integer.MIN_VALUE;
        }
    }

    public final String A3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0fe7);
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

    public tha F3(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, aj9Var)) == null) {
            tha thaVar = null;
            if (aj9Var == null) {
                return null;
            }
            if (aj9Var.Y() != null) {
                return aj9Var.Y();
            }
            if (!ListUtils.isEmpty(aj9Var.F())) {
                Iterator<tha> it = aj9Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    tha next = it.next();
                    if (next != null && next.L() == 1) {
                        thaVar = next;
                        break;
                    }
                }
            }
            if (thaVar == null) {
                thaVar = aj9Var.i();
            }
            if (thaVar == null) {
                thaVar = R3(aj9Var);
            }
            if (thaVar != null && thaVar.t() != null && thaVar.t().getUserTbVipInfoData() != null && thaVar.t().getUserTbVipInfoData().getvipIntro() != null) {
                thaVar.t().getGodUserData().setIntro(thaVar.t().getUserTbVipInfoData().getvipIntro());
            }
            return thaVar;
        }
        return (tha) invokeL.objValue;
    }

    public final tha R3(aj9 aj9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, aj9Var)) == null) {
            if (aj9Var != null && aj9Var.O() != null && aj9Var.O().getAuthor() != null) {
                tha thaVar = new tha();
                MetaData author = aj9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = aj9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                thaVar.W0(1);
                thaVar.c1(aj9Var.O().getFirstPostId());
                thaVar.t1(aj9Var.O().getTitle());
                thaVar.s1(aj9Var.O().getCreateTime());
                thaVar.P0(author);
                return thaVar;
            }
            return null;
        }
        return (tha) invokeL.objValue;
    }

    public void X3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z2) == null) && this.D != null && this.G != null) {
            if (X() != null && X().r1() != null) {
                this.G.setText(TbSingleton.getInstance().getAdVertiComment(X().r1().q0(), X().r1().r0(), T3()));
            } else {
                this.G.setText(T3());
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

    public void d5(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, aj9Var) == null) {
            if (aj9Var != null && AntiHelper.o(aj9Var.O())) {
                es9 es9Var = this.K;
                if (es9Var != null) {
                    es9Var.k(false);
                    this.K.j();
                }
                ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.J.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            es9 es9Var2 = this.K;
            if (es9Var2 != null && es9Var2.g()) {
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
        if (interceptable == null || interceptable.invokeL(1048682, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907aa));
            if (X() != null && X().r1() != null) {
                boolean a12 = X().a1();
                aj9 r1 = X().r1();
                if (a12) {
                    tha F3 = F3(r1);
                    if (r1.u() != null && !r1.u().equals(F3.U()) && (customViewPager = this.d) != null) {
                        customViewPager.setCurrentItem(0);
                    }
                }
            }
            this.a.L1().k(this.j0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            f4(bundle);
            H0().onCreate(getPageContext());
            v95 v95Var = new v95();
            this.p = v95Var;
            v95Var.a = 1000L;
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
            this.g = new lo6(getPageContext());
            vfa.g().i(getUniqueId());
        }
    }

    public void r3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, bVar) == null) {
            List<tha> list = X().r1().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).j0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).j0().get(i3).U())) {
                        list.get(i2).j0().remove(i3);
                        list.get(i2).h();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).i(bVar.g);
            }
            if (z2 && E3() != null) {
                E3().w2();
            }
        }
    }

    public final void s4(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048706, this, aj9Var) != null) || aj9Var == null) {
            return;
        }
        ThreadData O = aj9Var.O();
        if (O != null && O.isUgcThreadType()) {
            j3();
        } else {
            H4(this.W);
        }
        xk5 xk5Var = this.X;
        if (xk5Var != null) {
            F4(xk5Var.z());
            this.X.I(aj9Var.c());
            this.X.J(aj9Var.k(), aj9Var.V());
            this.X.l0(O);
            if (X() != null) {
                this.X.K(X().T0(), X().L1(), X().P0());
            }
            if (O != null) {
                this.X.a0(O.isMutiForumThread());
            }
        }
    }

    public void v4(aj9 aj9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048718, this, aj9Var) == null) && aj9Var != null && aj9Var.O() != null) {
            d5(aj9Var);
            ImageView imageView = this.I;
            if (aj9Var.j0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (aj9Var.q()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String A3 = A3(aj9Var.O().getReply_num());
            TextView textView = this.L;
            if (textView != null) {
                textView.setText(A3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, aj9Var.O()));
        }
    }

    public boolean A4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof tha)) {
                return false;
            }
            tha thaVar = (tha) obj;
            if (!TextUtils.isEmpty(thaVar.v()) && m05.c().g()) {
                return o4(thaVar.U());
            }
            if (checkUpIsLogin() && X() != null && X().r1() != null) {
                vm9 vm9Var = this.Z;
                if (vm9Var != null) {
                    vm9Var.g();
                }
                rj9 rj9Var = new rj9();
                rj9Var.v(X().r1().k());
                rj9Var.z(X().r1().O());
                rj9Var.x(thaVar);
                this.a0.i0(rj9Var);
                this.a0.setPostId(thaVar.U());
                l4(view2, thaVar.t().getUserId(), "", thaVar);
                TiebaStatic.log("c11743");
                xk5 xk5Var = this.X;
                if (xk5Var != null) {
                    F4(xk5Var.z());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean o4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, str)) == null) {
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

    public final void B4(boolean z2) {
        hw4 hw4Var;
        MarkData f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z2) != null) || (hw4Var = this.q) == null || (f2 = hw4Var.f()) == null) {
            return;
        }
        pha phaVar = new pha();
        phaVar.a = f2.getThreadId();
        phaVar.b = z2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, phaVar));
    }

    public void Q4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) && this.D != null && (textView = this.G) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f060a);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.D.startAnimation(alphaAnimation);
            }
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    public final boolean m3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048676, this, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048692, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (X() != null) {
                X().N2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                H0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final int D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (X() != null && X().r1() != null && X().r1().O() != null) {
                return X().r1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter == null) {
                return null;
            }
            Iterator<BaseFragment> it = videoPbFragmentAdapter.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).q2();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && X() != null && !ei.isEmpty(X().L1())) {
            nt4.w().Q(mt4.Z, JavaTypesHelper.toLong(X().L1(), 0L));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            hw4 c2 = hw4.c(this.a);
            this.q = c2;
            if (c2 != null) {
                c2.j(this.s0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.s = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.G0);
            this.r = new ve5(getPageContext());
            this.o = new wr9(this);
        }
    }

    public final void m4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048677, this) != null) || X() == null) {
            return;
        }
        aj9 r1 = X().r1();
        X().h3(true);
        hw4 hw4Var = this.q;
        if (hw4Var != null) {
            r1.L0(hw4Var.g());
        }
        if (E3() != null) {
            E3().w2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            super.onResume();
            this.i0 = false;
            H0().onResume(getPageContext());
            V4();
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
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            super.onStop();
            H0().onStop(getPageContext());
            vfa.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.Q0);
        }
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.o != null && X() != null) {
                this.o.G();
                if (this.m) {
                    return;
                }
                Y4();
                K4();
                if (X().loadData()) {
                    R4();
                }
            }
        }
    }

    public final String H3() {
        InterceptResult invokeV;
        ArrayList<tha> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (X() == null || X().r1() == null || X().r1().F() == null || (count = ListUtils.getCount((F = X().r1().F()))) == 0) {
                return "";
            }
            if (X().D1()) {
                Iterator<tha> it = F.iterator();
                while (it.hasNext()) {
                    tha next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int i2 = 0;
            if (S3() != null && E3() != null) {
                i2 = E3().n2();
            }
            tha thaVar = (tha) ListUtils.getItem(F, i2);
            if (thaVar != null && thaVar.t() != null) {
                if (X().l2(thaVar.t().getUserId())) {
                    return thaVar.U();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    tha thaVar2 = (tha) ListUtils.getItem(F, i3);
                    if (thaVar2 == null || thaVar2.t() == null || thaVar2.t().getUserId() == null) {
                        break;
                    } else if (X().l2(thaVar2.t().getUserId())) {
                        return thaVar2.U();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    tha thaVar3 = (tha) ListUtils.getItem(F, i4);
                    if (thaVar3 == null || thaVar3.t() == null || thaVar3.t().getUserId() == null) {
                        break;
                    } else if (X().l2(thaVar3.t().getUserId())) {
                        return thaVar3.U();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (X() == null) {
                return true;
            }
            if (X().r1() != null && X().r1().j0()) {
                return true;
            }
            if (X().c1()) {
                MarkData N0 = X().N0();
                if (N0 != null && X().a1() && S3() != null) {
                    MarkData H0 = X().H0(S3().getFirstVisiblePosition());
                    if (H0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", N0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (H0.getPostId() != null && !H0.getPostId().equals(N0.getPostId())) {
                        y45 y45Var = new y45(getBaseFragmentActivity());
                        y45Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0299));
                        y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c4, new n(this, H0, N0, y45Var));
                        y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new o(this, N0, y45Var));
                        y45Var.setOnCalcelListener(new p(this));
                        y45Var.create(getBaseFragmentActivity().getPageContext());
                        y45Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", N0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (X().r1() != null && X().r1().F() != null && X().r1().F().size() > 0 && X().a1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.B = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09293d);
            this.C = this.c.findViewById(R.id.obfuscated_res_0x7f09299b);
            this.D = this.c.findViewById(R.id.obfuscated_res_0x7f091ad0);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090993);
            this.F = imageView;
            imageView.setOnClickListener(new d0(this));
            k4();
            this.G = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ad3);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091aca);
            this.E = linearLayout;
            linearLayout.setOnClickListener(new e0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ad1);
            this.H = imageView2;
            imageView2.setOnClickListener(this.L0);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091acf);
            this.I = imageView3;
            imageView3.setOnClickListener(this.L0);
            if (booleanExtra) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
            }
            if (j4()) {
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
                this.I.setPadding(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ad4);
            this.J = imageView4;
            imageView4.setOnClickListener(this.L0);
            this.K = new es9(this.J);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ad2);
            this.L = textView;
            textView.setVisibility(0);
            P4(false);
        }
    }

    public final void j3() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && X() != null && this.a != null) {
            xk5 xk5Var = this.X;
            if (xk5Var != null && xk5Var.t) {
                return;
            }
            wk5 wk5Var = new wk5();
            H4(wk5Var);
            xk5 xk5Var2 = (xk5) wk5Var.a(getContext());
            this.X = xk5Var2;
            xk5Var2.X(this.a.getPageContext());
            this.X.g0(this.D0);
            this.X.h0(this.K0);
            xk5 xk5Var3 = this.X;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            xk5Var3.B(pageContext, extras);
            this.X.a().F(true);
            setEditorTools(this.X.a());
            if (!X().e1()) {
                this.X.q(X().L1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.X.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (X().b2()) {
                this.X.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.X.d0(T3());
            }
        }
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && X() != null && X().r1() != null && E3() != null && this.q != null) {
            MarkData markData = null;
            if (X().r1() != null && X().r1().j0()) {
                markData = X().H0(0);
            } else {
                CustomViewPager customViewPager = this.d;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = X().l1(F3(X().r1()));
                } else if (E3() != null) {
                    markData = X().H0(E3().p2());
                }
            }
            if (markData == null) {
                return;
            }
            K4();
            this.q.i(markData);
            if (!this.q.e()) {
                if (X() != null && !cq9.g(X().L1())) {
                    this.K.n(2);
                    cq9.a(X().L1());
                }
                this.q.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.q.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void H4(yk5 yk5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, yk5Var) == null) && yk5Var != null && X() != null) {
            yk5Var.p(X().Q0());
            if (X().r1() != null && X().r1().k() != null) {
                yk5Var.o(X().r1().k());
            }
            yk5Var.q("pb");
            yk5Var.r(X());
            yk5Var.s(PbNewEditorTool.InputShowType.REPLY_VIDEO);
        }
    }

    public final void L4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048606, this, i2) != null) || X() == null) {
            return;
        }
        int B1 = X().B1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    X().b3(1);
                } else {
                    X().b3(4);
                }
            } else {
                X().b3(3);
            }
        } else {
            X().b3(2);
        }
        int B12 = X().B1();
        if (B1 == 4 || B12 == 4) {
            p4();
        }
    }

    public void e5(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z2) == null) {
            DetailInfoAndReplyFragment E3 = E3();
            if (E3 != null && E3.W1() != null && E3.W1().g() != null && E3.W1().h() != null) {
                E3.W1().g().B0(z2);
                E3.W1().h().W(z2);
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

    public boolean o3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048680, this, i2)) == null) {
            if (this.f1147T != null && X() != null && X().r1() != null && !ThreadCardUtils.isSelf(X().r1().O()) && X().r1().c() != null) {
                return this.f1147T.checkPrivacyBeforeSend(X().r1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, editorTools) == null) {
            this.Y = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091acb);
            this.Y.setOnCancelClickListener(new m0(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.Y.getParent() == null) {
                this.c.addView(this.Y, layoutParams);
            }
            this.Y.z(TbadkCoreApplication.getInst().getSkinType());
            this.Y.setActionListener(24, new n0(this));
            Y3();
            this.X.g(new o0(this));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void L0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048603, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (e26[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), e26.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (do9.c(objArr[i2].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.h26
    public void h0(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048662, this, context, str, z2) == null) {
            if (do9.c(str) && X() != null && X().L1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", X().L1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    wh5 wh5Var = new wh5();
                    wh5Var.a = str;
                    wh5Var.b = 3;
                    wh5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wh5Var));
                }
            } else {
                do9.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048683, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.X.D(i2, i3, intent);
            vm9 vm9Var = this.Z;
            if (vm9Var != null) {
                vm9Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                U3(i3, intent);
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
                                if (C3() != null) {
                                    C3().performClick();
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
                n4();
            }
        }
    }

    public SparseArray<Object> L3(aj9 aj9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        tha F3;
        boolean z3;
        i25 i25Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{aj9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (aj9Var == null || (F3 = F3(aj9Var)) == null) {
                return null;
            }
            String userId = F3.t().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, F3.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aj9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (F3.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, F3.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, F3.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, F3.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, F3.U());
                }
                sparseArray.put(R.id.tag_del_post_id, F3.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aj9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<d45> o2 = aj9Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (d45 d45Var : o2) {
                        if (d45Var != null && !StringUtils.isNull(d45Var.d()) && (i25Var = d45Var.h) != null && i25Var.a && !i25Var.c && ((i3 = i25Var.b) == 1 || i3 == 2)) {
                            sb.append(ei.cutString(d45Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f077f));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void N4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048611, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new l0(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                wr9 wr9Var = this.o;
                if (wr9Var != null) {
                    wr9Var.E0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.h26
    public void m0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048675, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.o.o0(str);
            z45 S = this.o.S();
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

    public final void O4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048614, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    kg5.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (X() != null && !X().e1()) {
                antiData.setBlock_forum_name(X().r1().k().getName());
                antiData.setBlock_forum_id(X().r1().k().getId());
                antiData.setUser_name(X().r1().V().getUserName());
                antiData.setUser_id(X().r1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public void k3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        tha thaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048671, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof tha) && (thaVar = (tha) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && thaVar.o() != null) {
                        thaVar.o().setFloonumber(thaVar.L());
                        arrayList.add(thaVar.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new y0(this));
                if (((AdverSegmentData) ListUtils.getItem(arrayList, 0)).getFloonumber() == 1) {
                    if (!z2) {
                        r4((AdverSegmentData) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                r4((AdverSegmentData) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public final void S4(String str, String str2) {
        int i2;
        int dimens;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, str, str2) == null) {
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
            int i4 = (this.c0[1] + this.d0) - i3;
            if (S3() != null) {
                S3().smoothScrollBy(0, i4);
            }
            if (this.Z != null) {
                this.X.a().setVisibility(8);
                this.Z.t(str, str2, T3(), (X() == null || X().r1() == null || X().r1().O() == null || !X().r1().O().isBjh()) ? false : false);
                this.Z.q(G3());
                al5 f2 = this.Z.f();
                if (f2 != null && X() != null && X().r1() != null) {
                    f2.J(X().r1().c());
                    f2.f0(X().r1().O());
                }
                if (this.U.f() == null && this.Z.f().u() != null) {
                    this.Z.f().u().g(new s0(this));
                    this.U.n(this.Z.f().u().i());
                    this.Z.f().P(this.C0);
                }
            }
            W3();
        }
    }

    public final void x3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048721, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                y45 y45Var = new y45(getPageContext().getPageActivity());
                y45Var.setMessage(string);
                y45Var.setPositiveButton(R.string.dialog_known, new l(this));
                y45Var.setCancelable(true);
                y45Var.create(getPageContext());
                y45Var.show();
            } else {
                y3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<tha> F = X().r1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).U())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    X().r1().O().setReply_num(X().r1().O().getReply_num() - 1);
                    if (E3() != null) {
                        E3().w2();
                    }
                } else if (i3 == 0) {
                    q3();
                } else if (i3 == 2) {
                    ArrayList<tha> F2 = X().r1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).j0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).j0().get(i5).U())) {
                                F2.get(i4).j0().remove(i5);
                                F2.get(i4).h();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).i(bVar.g);
                    }
                    if (z3 && E3() != null) {
                        E3().w2();
                    }
                    r3(bVar);
                }
            }
        }
    }

    public final void U3(int i2, Intent intent) {
        fj5 fj5Var;
        vm9 vm9Var;
        fj5 fj5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048627, this, i2, intent) == null) {
            if (i2 == 0) {
                Y3();
                vm9 vm9Var2 = this.Z;
                if (vm9Var2 != null) {
                    vm9Var2.g();
                }
                P4(false);
            }
            y4();
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
                if (editorType == 1 && (vm9Var = this.Z) != null && vm9Var.f() != null) {
                    al5 f2 = this.Z.f();
                    f2.f0(X().r1().O());
                    f2.D(writeData);
                    f2.g0(pbEditorData.getVoiceModel());
                    ej5 p2 = f2.a().p(6);
                    if (p2 != null && (fj5Var2 = p2.m) != null) {
                        fj5Var2.G(new si5(52, 0, pbEditorData.getVoiceModel()));
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
            ej5 p3 = this.X.a().p(6);
            if (p3 != null && (fj5Var = p3.m) != null) {
                fj5Var.G(new si5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.X.H(null, null);
            }
        }
    }

    public void s3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048705, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.s.f0()) {
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
                    this.s.h0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.s.i0(X().r1().k().getId(), X().r1().k().getName(), X().r1().O().getId(), str, intValue3, intValue2, booleanValue, X().r1().O().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                if (X().M0() != null) {
                    X().M0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void z3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048725, this, i2, gVar) == null) && gVar != null && X() != null && X().r1() != null && X().r1().O() != null) {
            y3(this.s.getLoadDataMode(), gVar.a, gVar.b, false);
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
                    X().r1().O().setIs_good(1);
                    X().U2(1);
                } else if (i2 == 3) {
                    X().r1().O().setIs_good(0);
                    X().U2(0);
                } else if (i2 == 4) {
                    X().r1().O().setIs_top(1);
                    X().V2(1);
                } else if (i2 == 5) {
                    X().r1().O().setIs_top(0);
                    X().V2(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
            }
            if (X().r1().O() != null && E3() != null) {
                E3().B2();
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
    public void V3(boolean z2) {
        aj9 r1;
        int i2;
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) && X() != null && this.o != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (r1 = X().r1()) == null) {
                return;
            }
            ThreadData O = r1.O();
            int i3 = 1;
            if (O != null && O.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", X().L1()).param("fid", r1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", X().getForumId());
                statisticItem.param("tid", X().L1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", H3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", G3());
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
                statisticItem2.param("tid", X().L1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", X().getForumId());
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
                    if (O.getBaijiahaoData() != null && !ei.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (e0() != null) {
                    rs5.e(e0(), statisticItem2);
                }
                es9Var = this.K;
                if (es9Var != null) {
                    statisticItem2.param("obj_param1", es9Var.f());
                }
                TiebaStatic.log(statisticItem2);
                if (BdUtilHelper.isNetOk()) {
                    showToast(R.string.obfuscated_res_0x7f0f0e40);
                    return;
                } else if (X().r1() == null) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
                    return;
                } else {
                    ArrayList<tha> F = r1.F();
                    if ((F == null || F.size() <= 0) && X().K1()) {
                        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
                        return;
                    }
                    this.o.G();
                    Y4();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), O)) {
                        return;
                    }
                    es9 es9Var2 = this.K;
                    if (es9Var2 != null) {
                        es9Var2.k(false);
                        d5(r1);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i3 = 2;
                        }
                        if (this.K.h()) {
                            this.K.l(false);
                            b4(vf5.a(), this.K.f());
                            return;
                        }
                        U4(i3);
                        return;
                    }
                    this.o.w0();
                    X().L0().O(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", X().L1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", X().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            statisticItem22.param("obj_type", 2);
            if (O != null) {
            }
            if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (e0() != null) {
            }
            es9Var = this.K;
            if (es9Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (BdUtilHelper.isNetOk()) {
            }
        }
    }

    public final void W4(tha thaVar, tha thaVar2, boolean z2, boolean z3) {
        String str;
        int i2;
        boolean z4;
        boolean z5;
        tha F3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{thaVar, thaVar2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String L1 = X().L1();
            String U = thaVar.U();
            if (thaVar2 != null) {
                str = thaVar2.U();
            } else {
                str = "";
            }
            if (X().r1() != null) {
                i2 = X().r1().W();
            } else {
                i2 = 0;
            }
            if (E3() != null && E3().s2() != null) {
                AbsPbActivity.e p2 = E3().s2().p(U);
                if (thaVar != null && X() != null && X().r1() != null && p2 != null) {
                    if (G3() != 1 && G3() != 2 && G3() != 3 && G3() != 4 && G3() != 5) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, true, null, false, str, i2, thaVar.m0(), X().r1().c(), false, thaVar.t().getIconInfo(), G3(), z4).addBigImageData(p2.a, p2.b, p2.g, p2.j);
                    if (z3) {
                        addBigImageData.setHighLightPostId(str);
                        z5 = true;
                        addBigImageData.setKeyIsUseSpid(true);
                    } else {
                        z5 = true;
                    }
                    addBigImageData.setKeyFromForumId(X().getForumId());
                    addBigImageData.setTiebaPlusData(X().V(), X().R(), X().S(), X().Q(), X().W());
                    addBigImageData.setBjhData(X().I0());
                    addBigImageData.setKeyPageStartFrom(X().q1());
                    addBigImageData.setFromFrsForumId(X().getFromForumId());
                    addBigImageData.setWorksInfoData(X().Q1());
                    addBigImageData.setIsOpenEditor(z2);
                    if (X().r1().n() != null) {
                        addBigImageData.setHasForumRule(X().r1().n().has_forum_rule.intValue());
                    }
                    if (X().r1().V() != null) {
                        addBigImageData.setIsManager(X().r1().V().getIs_manager());
                    }
                    if (X().r1().k().getDeletedReasonInfo() != null) {
                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(X().r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(X().r1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    if (X().r1().k() != null) {
                        addBigImageData.setForumHeadUrl(X().r1().k().getImage_url());
                        addBigImageData.setUserLevel(X().r1().k().getUser_level());
                    }
                    if (X() != null && (F3 = F3(X().r1())) != null) {
                        if (!F3.f1164T && !thaVar.f1164T) {
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

    public final void c5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && X() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.R(X().getForumId()) && X().r1() != null && X().r1().k() != null) {
            boolean z2 = true;
            if (X().r1().k().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                X().E0().Q(X().getForumId(), X().L1());
            }
        }
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.a0 = new PbFakeFloorModel(getPageContext());
            PbModel X = X();
            this.a0.f0(X.V(), X.R(), X.S(), X.Q(), X.W());
            this.a0.setFromForumId(X.getFromForumId());
            vm9 vm9Var = new vm9(getPageContext(), this.a0, this.c);
            this.Z = vm9Var;
            vm9Var.p(new h0(this));
            this.Z.s(this.J0);
            this.a0.h0(new i0(this));
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && X() != null && X().r1() != null && X().r1().O() != null) {
            ThreadData O = X().r1().O();
            O.mRecomAbTag = X().x1();
            O.mRecomWeight = X().A1();
            O.mRecomSource = X().z1();
            O.mRecomExtra = X().y1();
            O.isSubPb = X().e1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(X().getForumId(), 0L));
            }
            StatisticItem i2 = rs5.i(getContext(), O, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            gz6 gz6Var = new gz6(getActivity());
            this.b0 = gz6Var;
            gz6Var.i(this.I0);
            this.d = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091b7f);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f091266);
            this.k = (MaskView) this.c.findViewById(R.id.mask_view);
            this.f.setOnClickListener(this.L0);
            c4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.e = videoPbFragmentAdapter;
            this.d.setAdapter(videoPbFragmentAdapter);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f0929d6);
            this.l = (PbFallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090ae9);
            D4();
            this.l.setAnimationListener(new c0(this));
            e4();
            d4();
        }
    }

    public boolean n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if ((X() != null && X().r1().j0()) || this.f1147T == null || X() == null || X().r1() == null || ThreadCardUtils.isSelf(X().r1().O()) || X().r1().c() == null) {
                return true;
            }
            return this.f1147T.checkPrivacyBeforeInvokeEditor(X().r1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            super.onDestroy();
            vfa.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.P0);
            ItemCardHelper.w(null);
            H0().onDestory(getPageContext());
            es9 es9Var = this.K;
            if (es9Var != null) {
                es9Var.j();
            }
            ForumManageModel forumManageModel = this.s;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.f1147T;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            wr9 wr9Var = this.o;
            if (wr9Var != null) {
                wr9Var.m0();
            }
            vm9 vm9Var = this.Z;
            if (vm9Var != null) {
                vm9Var.m();
            }
            if (X() != null) {
                X().cancelLoadData();
                X().destory();
                if (X().n1() != null) {
                    X().n1().d();
                }
            }
            xk5 xk5Var = this.X;
            if (xk5Var != null) {
                xk5Var.E();
            }
            this.p = null;
            eha.d();
            X4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            super.onPause();
            this.i0 = true;
            H0().onPause();
            if (X() != null && !X().e1()) {
                this.X.O(X().L1());
            }
            nt4.w().E();
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.O0);
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            if (!checkUpIsLogin()) {
                if (X() != null) {
                    nr9.v("c10517", X().getForumId(), 2);
                }
            } else if (!n3()) {
            } else {
                xk5 xk5Var = this.X;
                if (xk5Var != null && (xk5Var.y() || this.X.A())) {
                    this.X.w(false, null);
                    return;
                }
                if (this.Y != null) {
                    g4();
                    if (this.Y.p(2) != null) {
                        eha.c(getPageContext(), (View) this.Y.p(2).m, false, null);
                    }
                }
                W3();
            }
        }
    }

    public final void reset() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && this.X != null && this.Y != null) {
            sk5.a().c(0);
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
            aj5 o2 = this.Y.o(23);
            aj5 o3 = this.Y.o(2);
            aj5 o4 = this.Y.o(5);
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

    public void t4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048710, this) != null) || !checkUpIsLogin() || X() == null || X().r1() == null || X().r1().k() == null || l3()) {
            return;
        }
        if (X().r1().j0()) {
            p3();
            return;
        }
        xk5 xk5Var = this.X;
        if (xk5Var != null && xk5Var.a() != null) {
            this.X.a().D(new si5(45, 27, null));
        }
        p3();
    }

    public final void f4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, bundle) == null) {
            yk5 yk5Var = new yk5();
            this.W = yk5Var;
            H4(yk5Var);
            xk5 xk5Var = (xk5) this.W.a(getActivity());
            this.X = xk5Var;
            xk5Var.X(this.a.getPageContext());
            this.X.g0(this.D0);
            this.X.h0(this.K0);
            this.X.Z(1);
            this.X.e0(SendView.f);
            this.X.h(SendView.f);
            this.X.B(this.a.getPageContext(), bundle);
            this.X.a().b(new dj5(getActivity()));
            this.X.a().F(true);
            M4(true);
            if (X() != null) {
                this.X.K(X().T0(), X().L1(), X().P0());
            }
            registerListener(this.v0);
            registerListener(this.x0);
            registerListener(this.F0);
            registerListener(this.u0);
            registerListener(this.w0);
            registerListener(this.y0);
            registerListener(this.S0);
            if (!X().e1()) {
                this.X.q(X().L1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.X.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (X().b2()) {
                this.X.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.X.d0(T3());
            }
            this.U = new ao9();
            if (this.X.s() != null) {
                this.U.m(this.X.s().i());
            }
            this.X.W(this.t0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.f1147T = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new z(this));
        }
    }

    @Override // com.baidu.tieba.rr9
    public void finish() {
        CardHListViewData p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            PbModel J1 = this.a.J1();
            if (J1 != null && J1.r1() != null && J1.r1().O() != null && !J1.r1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = J1.r1().O().getId();
                if (J1.isShareThread() && J1.r1().O().originalThreadData != null) {
                    historyMessage.threadName = J1.r1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = J1.r1().O().getTitle();
                }
                if (J1.isShareThread() && !I0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = J1.r1().k().getName();
                }
                ArrayList<tha> F = J1.r1().F();
                if (F != null && F.size() > 0) {
                    historyMessage.postID = F.get(0).U();
                }
                historyMessage.isHostOnly = J1.U0();
                historyMessage.isSquence = J1.K1();
                historyMessage.isShareThread = J1.isShareThread();
                historyMessage.threadType = J1.r1().O().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            xk5 xk5Var = this.X;
            if (xk5Var != null) {
                xk5Var.E();
            }
            if (J1 != null && (J1.W0() || J1.Z0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", J1.L1());
                if (this.P) {
                    if (this.R) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", J1.f1());
                    }
                    if (this.Q) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", J1.b1());
                    }
                }
                if (J1.r1() != null && System.currentTimeMillis() - this.b >= 40000 && (p2 = J1.r1().p()) != null && !ListUtils.isEmpty(p2.getDataList())) {
                    intent.putExtra("guess_like_data", p2);
                }
                this.a.setResult(-1, intent);
            }
            if (a5()) {
                if (J1 != null) {
                    aj9 r1 = J1.r1();
                    if (r1 != null) {
                        if (r1.V() != null) {
                            r1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            r1.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.S) {
                            on9.b().q(this.d.getCurrentItem());
                            BdTypeRecyclerView S3 = S3();
                            Parcelable parcelable = null;
                            if (S3 != null) {
                                parcelable = S3.onSaveInstanceState();
                            }
                            on9.b().l(J1.s1(), parcelable, J1.K1(), J1.U0(), false);
                        }
                    }
                } else {
                    on9.b().k();
                }
                Z4();
            }
        }
    }

    public final void i3(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048665, this, z2, str) == null) && X() != null && X().r1() != null && X().r1().O() != null) {
            ThreadData O = X().r1().O();
            O.mRecomAbTag = X().x1();
            O.mRecomWeight = X().A1();
            O.mRecomSource = X().z1();
            O.mRecomExtra = X().y1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(X().getForumId(), 0L));
            }
            StatisticItem i2 = rs5.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = rs5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (O.isVideoThreadType()) {
                    if (ey5.e(str) > 40) {
                        str2 = ey5.m(str, 40);
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
                ms5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (G3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (G3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (G3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (G3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (G3() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", X().L1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", X().r1().l());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = rs5.i(getContext(), O, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", X().L1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", X().r1().l());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = rs5.i(getContext(), O, "c14303");
            if (i4 != null) {
                if (G3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (G3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (G3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (G3() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", X().L1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", X().r1().l());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }

    public final void l4(View view2, String str, String str2, tha thaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048674, this, view2, str, str2, thaVar) != null) || view2 == null || str == null || str2 == null || l3() || !n3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.c0);
            this.d0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.Z != null && thaVar != null) {
            if (thaVar.f0() != null) {
                str3 = thaVar.f0().toString();
            } else {
                str3 = "";
            }
            this.Z.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), thaVar.t().getName_show(), str3));
        }
        if (X() != null && X().r1() != null && X().r1().j0()) {
            SafeHandler.getInst().postDelayed(new p0(this, str, str2), 0L);
            return;
        }
        SafeHandler.getInst().postDelayed(new q0(this, str, str2), 0L);
        if (X() == null || X().r1() == null || X().r1().k() == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            BDLayoutMode layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 4) {
                z2 = false;
            }
            layoutMode.setNightMode(z2);
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c);
            ao9 ao9Var = this.U;
            if (ao9Var != null) {
                ao9Var.i();
            }
            EditorTools editorTools = this.Y;
            if (editorTools != null) {
                editorTools.z(i2);
            }
            vm9 vm9Var = this.Z;
            if (vm9Var != null) {
                vm9Var.l(i2);
            }
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (X() != null && X().c1()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.F, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            if (X() != null) {
                d5(X().r1());
            }
            SkinManager.setBackgroundColor(this.D, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.L, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.L, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (E3() != null) {
                E3().onChangeSkinType(i2);
            }
            Y4();
        }
    }

    public void x4(rj9 rj9Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048722, this, rj9Var) == null) && X() != null && X().r1() != null && rj9Var.g() != null) {
            String U = rj9Var.g().U();
            ArrayList<tha> F = X().r1().F();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= F.size()) {
                    break;
                }
                tha thaVar = F.get(i2);
                if (thaVar.U() != null && thaVar.U().equals(U)) {
                    ArrayList<tha> i3 = rj9Var.i();
                    thaVar.q1(rj9Var.k());
                    if (thaVar.j0() != null && i3 != null) {
                        Iterator<tha> it = i3.iterator();
                        while (it.hasNext()) {
                            tha next = it.next();
                            if (thaVar.s0() != null && next != null && next.t() != null && (metaData = thaVar.s0().get(next.t().getUserId())) != null) {
                                next.P0(metaData);
                                next.g1(true);
                                next.A1(getPageContext(), X().l2(metaData.getUserId()));
                            }
                        }
                        if (i3.size() != thaVar.j0().size()) {
                            z3 = true;
                        }
                        if (!thaVar.z0(true)) {
                            thaVar.j0().clear();
                            thaVar.j0().addAll(i3);
                        }
                        z2 = z3;
                    }
                    if (thaVar.E() != null) {
                        thaVar.N0();
                    }
                } else {
                    i2++;
                }
            }
            if (!X().a1() && z2 && E3() != null) {
                E3().w2();
            }
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            if (X().W0() || X().Z0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", X().L1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, X().L1()));
            if (a5()) {
                this.a.finish();
            }
        }
    }

    public void t3(y45 y45Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, y45Var, jSONArray) == null) {
            y45Var.dismiss();
            if (X() != null && X().r1() != null && X().r1().O() != null && X().r1().k() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(y45Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    s3((SparseArray) y45Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void u3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                s3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void u4(boolean z2, int i2, int i3, int i4, aj9 aj9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048715, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aj9Var, str, Integer.valueOf(i5)}) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null) {
                for (BaseFragment baseFragment : videoPbFragmentAdapter.c()) {
                    if (baseFragment instanceof qr9) {
                        ((qr9) baseFragment).L1(z2, i2, i3, i4, aj9Var, str, i5);
                    }
                }
            }
            L1(z2, i2, i3, i4, aj9Var, str, i5);
        }
    }

    public void w4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048720, this, z2, markData) != null) || X() == null) {
            return;
        }
        J4();
        X().h3(z2);
        hw4 hw4Var = this.q;
        if (hw4Var != null) {
            hw4Var.h(z2);
            if (markData != null) {
                this.q.i(markData);
            }
        }
        if (X().c1()) {
            m4();
        } else if (E3() != null) {
            E3().w2();
        }
    }

    public void y3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048723, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f14aa));
            } else if (z3) {
                if (ei.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e40);
                }
                showToast(str);
            }
        }
    }
}
