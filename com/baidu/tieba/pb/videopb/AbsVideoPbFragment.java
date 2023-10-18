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
import com.baidu.tieba.ad;
import com.baidu.tieba.aea;
import com.baidu.tieba.aj6;
import com.baidu.tieba.aj9;
import com.baidu.tieba.ao9;
import com.baidu.tieba.bo9;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cd5;
import com.baidu.tieba.cf5;
import com.baidu.tieba.ck9;
import com.baidu.tieba.dd5;
import com.baidu.tieba.df5;
import com.baidu.tieba.ef5;
import com.baidu.tieba.eh9;
import com.baidu.tieba.g4;
import com.baidu.tieba.ga5;
import com.baidu.tieba.gc5;
import com.baidu.tieba.gd9;
import com.baidu.tieba.gf5;
import com.baidu.tieba.gk9;
import com.baidu.tieba.go9;
import com.baidu.tieba.gs5;
import com.baidu.tieba.h45;
import com.baidu.tieba.hf5;
import com.baidu.tieba.hz4;
import com.baidu.tieba.if5;
import com.baidu.tieba.iz4;
import com.baidu.tieba.jk9;
import com.baidu.tieba.jo9;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kf5;
import com.baidu.tieba.km9;
import com.baidu.tieba.kna;
import com.baidu.tieba.ks5;
import com.baidu.tieba.lea;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lr5;
import com.baidu.tieba.ly4;
import com.baidu.tieba.m85;
import com.baidu.tieba.mm9;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.nd5;
import com.baidu.tieba.ns5;
import com.baidu.tieba.od5;
import com.baidu.tieba.oo9;
import com.baidu.tieba.oq4;
import com.baidu.tieba.ow5;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.pd5;
import com.baidu.tieba.pea;
import com.baidu.tieba.pf9;
import com.baidu.tieba.q75;
import com.baidu.tieba.qm9;
import com.baidu.tieba.qw4;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rca;
import com.baidu.tieba.rw5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sg9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tm5;
import com.baidu.tieba.tn4;
import com.baidu.tieba.uj9;
import com.baidu.tieba.un4;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uu4;
import com.baidu.tieba.va5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vt6;
import com.baidu.tieba.w55;
import com.baidu.tieba.w85;
import com.baidu.tieba.wo6;
import com.baidu.tieba.xn9;
import com.baidu.tieba.ya;
import com.baidu.tieba.ye9;
import com.baidu.tieba.ym5;
import com.baidu.tieba.za;
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
public abstract class AbsVideoPbFragment extends BaseFragment implements rw5, VoiceManager.j, bo9, TbRichTextView.t, ao9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int U0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public CustomMessageListener A0;
    public View B;
    public df5 B0;
    public View C;
    public final NewWriteModel.d C0;
    public LinearLayout D;
    public View.OnClickListener D0;
    public ImageView E;
    public CustomMessageListener E0;
    public TextView F;
    public final g4 F0;
    public ImageView G;
    public View.OnTouchListener G0;
    public ImageView H;
    public final vt6.b H0;
    public ImageView I;
    public NewWriteModel.d I0;
    public oo9 J;
    public ef5 J0;
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
    public gk9 f1147T;
    public SortSwitchButton.f T0;
    public PermissionJudgePolicy U;
    public if5 V;
    public hf5 W;
    public EditorTools X;
    public aj9 Y;
    public PbFakeFloorModel Z;
    public AbsPbActivity a;
    public vt6 a0;
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
    public aj6 g;
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
    public go9 o;
    public h45 p;
    public oq4 q;
    public ForumManageModel r;
    public final oq4.a r0;
    public VoiceManager s;
    public df5 s0;
    public ya<GifView> t;
    public final CustomMessageListener t0;
    public ya<TextView> u;
    public CustomMessageListener u0;
    public ya<ImageView> v;
    public final CustomMessageListener v0;
    public ya<View> w;
    public CustomMessageListener w0;
    public ya<LinearLayout> x;
    public HttpMessageListener x0;
    public ya<RelativeLayout> y;
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

    @Override // com.baidu.tieba.rw5
    public ya<ItemCardView> C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public abstract int L3();

    public abstract int N3();

    @Override // com.baidu.tieba.rw5
    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ao9
    public void P1(boolean z2, int i2, int i3, int i4, ye9 ye9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ye9Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // com.baidu.tieba.bo9
    public PbFragment S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final int V3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
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

    @Override // com.baidu.tieba.bo9
    public AbsVideoPbFragment a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<TiebaPlusRecommendCard> b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<FestivalTipView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public void m0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048673, this, context, str) == null) {
        }
    }

    public abstract boolean o4();

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView v1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public void x1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048719, this, context, str) == null) {
        }
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
                    this.b.a.w4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                    km9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m85 m85Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m85Var, writeData, antiData}) == null) {
                if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.e0() != null && this.a.e0().s1() != null) {
                        statisticItem.param("fid", this.a.e0().s1().l());
                    }
                    statisticItem.param("tid", this.a.e0().M1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.d5();
                this.a.N4(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    w55.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.e0() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.e0().A0(postWriteCallBackData.getPostId());
                        if (this.a.J3() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.f0 = absVideoPbFragment.J3().t2();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.g0 = absVideoPbFragment2.J3().u2();
                            this.a.e0().R2(this.a.f0, this.a.g0);
                        }
                    }
                    if (this.a.d != null) {
                        this.a.d.setCurrentItem(0);
                    }
                    this.a.o.G();
                    this.a.f1147T.c();
                    if (this.a.W != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.K4(absVideoPbFragment3.W.A());
                    }
                    this.a.d4();
                    this.a.U4(true);
                    this.a.e0().X1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.T4(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && this.a.J3() != null) {
                            this.a.J3().C2();
                        }
                    } else if (this.a.e0().V0()) {
                        ye9 s1 = this.a.e0().s1();
                        if (s1 != null && s1.O() != null && s1.O().getAuthor() != null && (userId = s1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.e0().j3()) {
                            this.a.P4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.e0().j3()) {
                        this.a.P4();
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
                    absVideoPbFragment4.o3(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.W.z() || this.a.W.B()) {
                        this.a.W.x(false, postWriteCallBackData);
                    }
                    this.a.f1147T.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.S;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    hz4 hz4Var = new hz4(this.a.getActivity());
                    if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                        hz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        hz4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new b(this));
                    hz4Var.setPositiveButton(R.string.open_now, new c(this));
                    hz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (m85Var != null || i == 227001) {
                } else {
                    this.a.S4(i, antiData, str);
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
                    this.b.a.w4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                    km9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m85 m85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m85Var, writeData, antiData}) == null) {
                if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.e0() != null && this.a.e0().s1() != null) {
                        statisticItem.param("fid", this.a.e0().s1().l());
                    }
                    if (this.a.e0() != null) {
                        statisticItem.param("tid", this.a.e0().M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    w55.b(writeData.getContent(), "4");
                }
                if (z) {
                    gk9 gk9Var = this.a.f1147T;
                    if (gk9Var != null) {
                        gk9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        va5.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    hz4 hz4Var = new hz4(this.a.getActivity());
                    if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                        hz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        hz4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new b(this));
                    hz4Var.setPositiveButton(R.string.open_now, new c(this));
                    hz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    if (absVideoPbFragment.f1147T != null) {
                        if (absVideoPbFragment.Y != null && this.a.Y.f() != null && this.a.Y.f().A()) {
                            this.a.Y.f().x(postWriteCallBackData);
                        }
                        this.a.f1147T.l(postWriteCallBackData);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof kna) && customResponsedMessage.getOrginalMessage().getTag() == this.a.o.D) {
                kna knaVar = (kna) customResponsedMessage.getData();
                this.a.o.W();
                SparseArray<Object> sparseArray = (SparseArray) this.a.o.P();
                DataRes dataRes = knaVar.a;
                boolean z = false;
                if (knaVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (ad.isEmpty(str)) {
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
                    this.a.o.y0(z, sparseArray);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.c);
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e0() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.W != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.K4(absVideoPbFragment.W.A());
                }
                this.a.D4();
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
                go9 go9Var = this.a.o;
                if (tag == go9Var.D) {
                    go9Var.W();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    ye9 s1 = this.a.e0().s1();
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
                        this.a.o.D0(errorString);
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                        this.a.o.x0();
                    } else {
                        String errorString2 = userMuteAddResponseMessage.getErrorString();
                        if (ad.isEmpty(errorString2)) {
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
                gd9 gd9Var = (gd9) customResponsedMessage.getData();
                int b = gd9Var.b();
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            if (gd9Var.a() == null) {
                                this.a.B4(false, null);
                                return;
                            } else {
                                this.a.B4(true, (MarkData) gd9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.D3((ForumManageModel.b) gd9Var.a(), false);
                    return;
                }
                this.a.C4((pf9) gd9Var.a());
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
                go9 go9Var = this.a.o;
                if (tag == go9Var.D) {
                    go9Var.W();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (ad.isEmpty(muteMessage)) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Y4();
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.h0) {
                this.a.a5();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements df5 {
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

        @Override // com.baidu.tieba.df5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gk9 gk9Var = this.a.f1147T;
                if (gk9Var != null && gk9Var.g() != null && this.a.f1147T.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.f1147T.g().c());
                    if (this.a.Y != null && this.a.Y.f() != null && this.a.Y.f().A()) {
                        this.a.Y.f().x(this.a.f1147T.h());
                    }
                    this.a.f1147T.b(true);
                    return true;
                }
                return !this.a.u3(ReplyPrivacyCheckController.TYPE_FLOOR);
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
                if (absVideoPbFragment.S != null && absVideoPbFragment.e0() != null && this.a.e0().s1() != null && this.a.e0().s1().c() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.S.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.e0().s1().c().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.W.p0();
                this.a.B3();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.h5();
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
            this.a.y4();
            if (this.a.e0() != null && this.a.e0().s1() != null && this.a.e0().s1().O() != null && this.a.e0().s1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.e0().N1()).param("fid", this.a.e0().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.e0().M1()).param("fid", this.a.e0().s1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.a.e0().getForumId());
                statisticItem.param("tid", this.a.e0().M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.M3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 11);
                statisticItem.param("obj_locate", this.a.L3());
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
                    this.a.Q4(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e4f);
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
                this.a.D4();
                if (this.a.J3() != null) {
                    this.a.J3().C2();
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
                absVideoPbFragment.K4(absVideoPbFragment.W.A());
            }
            this.a.U4(false);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements oq4.a {
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

        @Override // com.baidu.tieba.oq4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                this.a.O4();
                if (z && this.a.e0() != null) {
                    if (this.a.q != null) {
                        this.a.q.h(z2);
                        this.a.G4(z2);
                    }
                    this.a.e0().i3(z2);
                    if (this.a.e0().s1() != null && (O = this.a.e0().s1().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (this.a.e0().d1()) {
                        this.a.r4();
                    } else if (this.a.J3() != null) {
                        this.a.J3().C2();
                    }
                    if (z2) {
                        if (this.a.q != null) {
                            if (this.a.q.f() != null && this.a.e0() != null && this.a.e0().s1() != null && this.a.e0().s1().O() != null && this.a.e0().s1().O().getAuthor() != null) {
                                MarkData f = this.a.q.f();
                                MetaData author = this.a.e0().s1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f00ff);
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
                        this.a.n3();
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
    public class h extends g4 {
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

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.e0() != null) {
                    switch (this.a.r.getLoadDataMode()) {
                        case 0:
                            this.a.e0().X1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.D3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.E3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.F3(absVideoPbFragment.r.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.E3(absVideoPbFragment2.r.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.o.e0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.E3(absVideoPbFragment3.r.getLoadDataMode(), false, null, false);
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
                this.a.D4();
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
        public void a(pea peaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, peaVar) == null) {
                this.a.Z.e0(peaVar);
                if (this.a.J3() != null) {
                    this.a.J3().C2();
                }
                this.a.Y.g();
                this.a.X.t();
                this.a.U4(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements vt6.b {
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

        @Override // com.baidu.tieba.vt6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    sg9.d();
                } else {
                    sg9.c();
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z = true;
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
                go9 go9Var = this.a.o;
                if (go9Var != null) {
                    go9Var.G();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.e0() != null && !this.a.e0().isLoading) {
                    this.a.d5();
                    this.a.P4();
                    z = true;
                    if (this.a.e0().s1() != null && this.a.e0().s1().f != null && this.a.e0().s1().f.size() > i) {
                        int intValue = this.a.e0().s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.e0().N1()).param("fid", this.a.e0().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.e0().m3(intValue)) {
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
    public class l implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) && hz4Var != null) {
                hz4Var.dismiss();
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
        public void onNavigationButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var) == null) {
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
                this.a.D4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ hz4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public n(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, hz4Var};
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
            this.c = hz4Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
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
                this.d.e5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements dd5 {
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

        @Override // com.baidu.tieba.dd5
        public void O(cd5 cd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cd5Var) == null) {
                Object obj = cd5Var.c;
                if ((obj instanceof q75) && EmotionGroupType.isSendAsPic(((q75) obj).g())) {
                    if (this.a.U == null) {
                        this.a.U = new PermissionJudgePolicy();
                    }
                    this.a.U.clearRequestPermissionList();
                    this.a.U.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.U.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.W.f((q75) cd5Var.c);
                    this.a.W.x(false, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ hz4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public o(AbsVideoPbFragment absVideoPbFragment, MarkData markData, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, hz4Var};
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
            this.b = hz4Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.e5();
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
            gk9 gk9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (gk9Var = this.a.f1147T) != null && gk9Var.e() != null) {
                if (!this.a.f1147T.e().e()) {
                    this.a.f1147T.a(false);
                }
                this.a.f1147T.e().l(false);
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
            this.c.X4(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class q implements ef5 {
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

        @Override // com.baidu.tieba.ef5
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
            this.c.X4(this.a, this.b);
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
                if (view2.getId() == R.id.obfuscated_res_0x7f091b33) {
                    if (this.a.e0() != null) {
                        this.a.e0().r2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.e0().M1());
                    statisticItem2.param("fid", this.a.e0().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", this.a.e0().getForumId());
                    statisticItem3.param("tid", this.a.e0().M1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", this.a.M3());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 3);
                    statisticItem3.param("obj_locate", this.a.L3());
                    TiebaStatic.log(statisticItem3);
                    if (!this.a.z) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof pea) {
                                pea peaVar = (pea) obj;
                                if (this.a.e0() == null || this.a.e0().s1() == null || this.a.Z == null || peaVar.t() == null || peaVar.L() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.Y != null) {
                                    this.a.Y.g();
                                }
                                pf9 pf9Var = new pf9();
                                pf9Var.v(this.a.e0().s1().k());
                                pf9Var.z(this.a.e0().s1().O());
                                pf9Var.x(peaVar);
                                this.a.Z.j0(pf9Var);
                                this.a.Z.setPostId(peaVar.U());
                                this.a.q4(view2, peaVar.t().getUserId(), "", peaVar);
                                TiebaStatic.log("c11743");
                                xn9.b(this.a.e0().s1(), peaVar, peaVar.f0, 8, 1);
                                if (this.a.W != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.K4(absVideoPbFragment.W.A());
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
                    if (view2.getId() == R.id.pb_video_more && this.a.getPageContext().getPageActivity() != null && this.a.e0() != null && this.a.a != null && this.a.a.getIntent() != null) {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.e0().M1(), false, true);
                            this.a.J4(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.e0().M1(), true, false);
                            this.a.J4(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.e0().getForumId());
                        statisticItem4.param("fname", this.a.e0().R0());
                        statisticItem4.param("tid", this.a.e0().M1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.J3() == null || this.a.J3().x2() == null || view2 != this.a.J3().x2()) && view2.getId() != R.id.pb_more) {
                        go9 go9Var = this.a.o;
                        if (go9Var != null && go9Var.R() != null && view2 == this.a.o.R().t()) {
                            this.a.o.J();
                            return;
                        }
                        go9 go9Var2 = this.a.o;
                        if ((go9Var2 == null || go9Var2.R() == null || view2 != this.a.o.R().z()) && view2.getId() != R.id.obfuscated_res_0x7f090b89 && view2.getId() != R.id.obfuscated_res_0x7f091f13) {
                            if (this.a.o.R() != null && view2 == this.a.o.R().B()) {
                                if (this.a.e0() == null) {
                                    return;
                                }
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.d5();
                                this.a.P4();
                                this.a.e0().g3(1);
                                return;
                            }
                            go9 go9Var3 = this.a.o;
                            if (go9Var3 != null && go9Var3.R() != null && view2 == this.a.o.R().z()) {
                                this.a.o.J();
                                return;
                            }
                            go9 go9Var4 = this.a.o;
                            if (go9Var4 != null && ((go9Var4.R() != null && view2 == this.a.o.R().H()) || view2.getId() == R.id.obfuscated_res_0x7f091b75)) {
                                this.a.o.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                } else if (this.a.m) {
                                    view2.setTag(Integer.valueOf(this.a.e0().J1()));
                                    return;
                                } else {
                                    this.a.d5();
                                    this.a.P4();
                                    this.a.o.C0(view2);
                                    return;
                                }
                            }
                            go9 go9Var5 = this.a.o;
                            if (go9Var5 != null && go9Var5.R() != null && view2 == this.a.o.R().G()) {
                                if (this.a.e0() == null || this.a.e0().s1() == null || this.a.e0().s1().O() == null) {
                                    return;
                                }
                                this.a.o.J();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment2 = this.a;
                                absVideoPbFragment2.o.V(absVideoPbFragment2.e0().s1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091afa) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                go9 go9Var6 = this.a.o;
                                if (go9Var6 != null) {
                                    go9Var6.u0(sparseArray);
                                }
                            } else {
                                go9 go9Var7 = this.a.o;
                                if (go9Var7 != null && go9Var7.R() != null && view2 == this.a.o.R().E()) {
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
                                go9 go9Var8 = this.a.o;
                                if (go9Var8 != null && go9Var8.R() != null && view2 == this.a.o.R().F()) {
                                    this.a.o.K();
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.o.A0(absVideoPbFragment3.M0);
                                    return;
                                }
                                go9 go9Var9 = this.a.o;
                                if (go9Var9 != null && go9Var9.R() != null && view2 == this.a.o.R().y()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.e0().M1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.o.J();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                go9 go9Var10 = this.a.o;
                                if (go9Var10 != null && (view2 == go9Var10.N() || (this.a.o.R() != null && (view2 == this.a.o.R().C() || view2 == this.a.o.R().D())))) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.e0() == null || this.a.e0().s1() == null || this.a.r.g0()) {
                                        return;
                                    } else {
                                        this.a.o.G();
                                        if (this.a.o.R() != null && view2 == this.a.o.R().D()) {
                                            i3 = this.a.e0().s1().O().getIs_top() == 1 ? 5 : 4;
                                        } else if (this.a.o.R() != null && view2 == this.a.o.R().C()) {
                                            i3 = this.a.e0().s1().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i3 = view2 == this.a.o.N() ? 2 : 0;
                                        }
                                        ForumData k = this.a.e0().s1().k();
                                        String name = k.getName();
                                        String id = k.getId();
                                        String id2 = this.a.e0().s1().O().getId();
                                        this.a.showProgressBar();
                                        this.a.r.k0(id, name, id2, i3, this.a.o.O());
                                        return;
                                    }
                                }
                                go9 go9Var11 = this.a.o;
                                if (go9Var11 != null && go9Var11.R() != null && view2 == this.a.o.R().x()) {
                                    if (this.a.e0() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.a.o.G();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    SparseArray<Object> Q3 = absVideoPbFragment4.Q3(absVideoPbFragment4.e0().s1(), this.a.e0().L1(), 1);
                                    if (Q3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.e0().s1().k().getId(), this.a.e0().s1().k().getName(), this.a.e0().s1().O().getId(), String.valueOf(this.a.e0().s1().V().getUserId()), (String) Q3.get(R.id.tag_forbid_user_name), (String) Q3.get(R.id.tag_forbid_user_name_show), (String) Q3.get(R.id.tag_forbid_user_post_id), (String) Q3.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                go9 go9Var12 = this.a.o;
                                if (go9Var12 != null && go9Var12.R() != null && view2 == this.a.o.R().f()) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> Q32 = absVideoPbFragment5.Q3(absVideoPbFragment5.e0().s1(), this.a.e0().L1(), 1);
                                    if (Q32 != null) {
                                        this.a.o.i0(((Integer) Q32.get(R.id.tag_del_post_type)).intValue(), (String) Q32.get(R.id.tag_del_post_id), ((Integer) Q32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) Q32.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.a.o.J();
                                    if (this.a.e0() == null || this.a.e0().s1() == null || this.a.e0().s1().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.e0().s1().O();
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
                                go9 go9Var13 = this.a.o;
                                if (go9Var13 != null && go9Var13.R() != null && view2 == this.a.o.R().u()) {
                                    if (this.a.e0() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> Q33 = absVideoPbFragment6.Q3(absVideoPbFragment6.e0().s1(), this.a.e0().L1(), 1);
                                    if (Q33 != null) {
                                        if (StringUtils.isNull((String) Q33.get(R.id.tag_del_multi_forum))) {
                                            this.a.o.f0(((Integer) Q33.get(R.id.tag_del_post_type)).intValue(), (String) Q33.get(R.id.tag_del_post_id), ((Integer) Q33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) Q33.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.a.o.g0(((Integer) Q33.get(R.id.tag_del_post_type)).intValue(), (String) Q33.get(R.id.tag_del_post_id), ((Integer) Q33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) Q33.get(R.id.tag_del_post_is_self)).booleanValue(), (String) Q33.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.a.o.J();
                                } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09230c && view2.getId() != R.id.obfuscated_res_0x7f091afc && view2.getId() != R.id.obfuscated_res_0x7f091975 && view2.getId() != R.id.obfuscated_res_0x7f091b67) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b65 && view2.getId() != R.id.obfuscated_res_0x7f091d31 && view2.getId() != R.id.obfuscated_res_0x7f091af6) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ae4 && view2.getId() != R.id.collect_num_container) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ae9 && view2.getId() != R.id.share_more_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091ae6 && view2.getId() != R.id.thread_info_commont_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f09276f) {
                                                        if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                            if (this.a.e0() == null) {
                                                                return;
                                                            }
                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                            statisticItem7.param("tid", this.a.e0().M1());
                                                            statisticItem7.param("fid", this.a.e0().getForumId());
                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem7.param("obj_locate", 2);
                                                            TiebaStatic.log(statisticItem7);
                                                            return;
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091b2a && view2.getId() != R.id.obfuscated_res_0x7f091af1) {
                                                            if (view2.getId() == R.id.obfuscated_res_0x7f09126f) {
                                                                this.a.D4();
                                                                return;
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09087e && view2.getId() != R.id.obfuscated_res_0x7f090b85) {
                                                                if (this.a.o.R() != null && view2 == this.a.o.R().g()) {
                                                                    this.a.o.G();
                                                                    if (this.a.e0() != null) {
                                                                        this.a.g.f(this.a.e0().M1());
                                                                    }
                                                                    if (this.a.e0() != null && this.a.e0().isPrivacy()) {
                                                                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                        if (this.a.e0().s1() != null) {
                                                                            this.a.g.d(3, 3, this.a.e0().s1().Q());
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    this.a.g.b();
                                                                    int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.e0() == null || this.a.e0().s1() == null || this.a.e0().s1().Q() == null || !this.a.e0().s1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                    if (this.a.e0() == null || this.a.e0().s1() == null) {
                                                                        return;
                                                                    }
                                                                    this.a.g.d(3, i5, this.a.e0().s1().Q());
                                                                    return;
                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091afe || view2.getId() == R.id.obfuscated_res_0x7f091b5f) {
                                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                    statisticItem8.param("tid", this.a.e0().M1());
                                                                    statisticItem8.param("fid", this.a.e0().getForumId());
                                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem8.param("obj_locate", 7);
                                                                    TiebaStatic.log(statisticItem8);
                                                                    StatisticItem statisticItem9 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                    statisticItem9.param("fid", this.a.e0().getForumId());
                                                                    statisticItem9.param("tid", this.a.e0().M1());
                                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    statisticItem9.param("post_id", this.a.M3());
                                                                    statisticItem9.param("obj_source", 1);
                                                                    statisticItem9.param("obj_type", 2);
                                                                    statisticItem9.param("obj_locate", this.a.L3());
                                                                    TiebaStatic.log(statisticItem9);
                                                                    this.a.o.n0(false);
                                                                    this.a.o.Q().onLongClick(view2);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof pea)) {
                                                                    return;
                                                                }
                                                                pea peaVar2 = (pea) sparseArray2.get(R.id.tag_load_sub_data);
                                                                View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                if (peaVar2 == null || view3 == null) {
                                                                    return;
                                                                }
                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09087f);
                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090880);
                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b85);
                                                                if (peaVar2.D0()) {
                                                                    peaVar2.j1(false);
                                                                    qm9.e(peaVar2);
                                                                } else {
                                                                    if (this.a.e0() != null ? qm9.c(this.a.e0().s1(), peaVar2) : false) {
                                                                        peaVar2.j1(true);
                                                                        findViewById.setVisibility(0);
                                                                    }
                                                                }
                                                                SkinManager.setBackgroundColor(findViewById, peaVar2.D0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                SkinManager.setViewTextColor(eMTextView, peaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                WebPManager.setPureDrawable(imageView, peaVar2.D0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, peaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                return;
                                                            }
                                                        } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                BrowserHelper.startWebActivity(view2.getContext(), string, string2, true, true, true);
                                                            }
                                                            this.a.D4();
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (this.a.f0 >= 0) {
                                                        if (this.a.e0() != null) {
                                                            this.a.e0().N2();
                                                        }
                                                        if (this.a.J3() != null && this.a.J3().c2() != null) {
                                                            this.a.J3().c2().s(this.a.e0().s1());
                                                        }
                                                        this.a.f0 = 0;
                                                        this.a.g0 = Integer.MIN_VALUE;
                                                        if (this.a.e0() == null || this.a.J3() == null) {
                                                            return;
                                                        }
                                                        this.a.J3().J2(this.a.e0().l1(), this.a.e0().k1());
                                                        this.a.e0().R2(0, 0);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.e0() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                                    if (absVideoPbFragment7.o == null || absVideoPbFragment7.d == null || this.a.e0().s1() == null || this.a.e0().s1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    ye9 s1 = this.a.e0().s1();
                                                    if (s1.O().getReply_num() == 0) {
                                                        this.a.y4();
                                                        return;
                                                    } else if (this.a.J3() == null || this.a.X3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.e0().M1()).param("fid", this.a.e0().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView X3 = this.a.X3();
                                                        if (X3 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = X3.canScrollVertically(1);
                                                        boolean canScrollVertically2 = X3.canScrollVertically(-1);
                                                        if (X3.getLayoutManager() == null || !(X3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) X3.getLayoutManager();
                                                        if (canScrollVertically2 || !canScrollVertically) {
                                                            str = "obj_source";
                                                            int firstVisiblePosition = X3.getFirstVisiblePosition();
                                                            View childAt = X3.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.d0 = firstVisiblePosition;
                                                            this.a.e0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-equipmentHeight) || X3.getCount() < 6)) {
                                                                X3.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                X3.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        } else if (this.a.d0 == -1 && this.a.e0 == Integer.MIN_VALUE) {
                                                            return;
                                                        } else {
                                                            if (this.a.d0 > 3 || (this.a.d0 == 3 && this.a.e0 < (-equipmentHeight))) {
                                                                str = "obj_source";
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.d0, this.a.e0 + equipmentHeight);
                                                                X3.smoothScrollBy(0, equipmentHeight);
                                                            } else if (this.a.d0 >= 2) {
                                                                str = "obj_source";
                                                                int i6 = equipmentHeight / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.d0, this.a.e0 + i6);
                                                                X3.smoothScrollBy(0, i6);
                                                            } else {
                                                                str = "obj_source";
                                                                if (this.a.d0 == 1) {
                                                                    int i7 = equipmentHeight / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.d0, this.a.e0 + i7);
                                                                    X3.smoothScrollBy(0, i7);
                                                                } else {
                                                                    X3.smoothScrollBy(0, -this.a.e0);
                                                                }
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        }
                                                        TiebaStatic.log(param);
                                                        tm5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem10 = new StatisticItem("c12942");
                                                        statisticItem10.param("obj_type", i2);
                                                        statisticItem10.param("obj_locate", 4);
                                                        statisticItem10.param("tid", this.a.e0().M1());
                                                        statisticItem10.param("nid", s1.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem10.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem10);
                                                        if (this.a.e0() == null || this.a.e0().s1() == null || this.a.e0().s1().O() == null || this.a.e0().s1().O().getAuthor() == null) {
                                                            return;
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.e0().M1()).param("fid", this.a.e0().s1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem11.param("fid", this.a.e0().getForumId());
                                                        statisticItem11.param("tid", this.a.e0().M1());
                                                        statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem11.param("post_id", this.a.M3());
                                                        statisticItem11.param(str, 1);
                                                        statisticItem11.param("obj_type", 12);
                                                        statisticItem11.param("obj_locate", this.a.L3());
                                                        TiebaStatic.log(statisticItem11);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            this.a.a4(true);
                                        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                        } else {
                                            AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                            if (absVideoPbFragment8.o == null || absVideoPbFragment8.e0() == null || this.a.J3() == null) {
                                                return;
                                            }
                                            this.a.o.G();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ae4 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.s3(11009) || this.a.e0() == null) {
                                                    return;
                                                }
                                                this.a.s4();
                                                if (this.a.e0().s1() != null && this.a.e0().s1().O() != null && this.a.e0().s1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.e0().M1()).param("fid", this.a.e0().s1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                    StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem12.param("fid", this.a.e0().getForumId());
                                                    statisticItem12.param("tid", this.a.e0().M1());
                                                    statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem12.param("post_id", this.a.M3());
                                                    statisticItem12.param("obj_source", 1);
                                                    statisticItem12.param("obj_type", 13);
                                                    statisticItem12.param("obj_locate", this.a.L3());
                                                    TiebaStatic.log(statisticItem12);
                                                }
                                                if (this.a.e0().s1().O() == null || this.a.e0().s1().O().getAuthor() == null || this.a.e0().s1().O().getAuthor().getUserId() == null || this.a.q == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                                int T2 = absVideoPbFragment9.o.T(absVideoPbFragment9.e0().s1());
                                                ThreadData O2 = this.a.e0().s1().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.e0().M1()).param("obj_locate", 1).param("obj_id", this.a.e0().s1().O().getAuthor().getUserId()).param("obj_type", !this.a.q.e()).param("obj_source", T2).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.j = view2;
                                        }
                                    } else if (this.a.e0() == null) {
                                    } else {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091b65) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.e0().M1());
                                            statisticItem13.param("fid", this.a.e0().getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091d31) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.i = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b65 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.i = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof pea) {
                                                pea peaVar3 = (pea) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091b65 && (statisticItem = peaVar3.g0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d31 || view2.getId() == R.id.obfuscated_res_0x7f091af6) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.e0().N1()).param("fid", this.a.e0().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", peaVar3.U()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.a.e0() == null || this.a.e0().s1() == null || this.a.Z == null || peaVar3.t() == null || peaVar3.L() == 1) {
                                                    return;
                                                }
                                                if (this.a.Y != null) {
                                                    this.a.Y.g();
                                                }
                                                pf9 pf9Var2 = new pf9();
                                                pf9Var2.v(this.a.e0().s1().k());
                                                pf9Var2.z(this.a.e0().s1().O());
                                                pf9Var2.x(peaVar3);
                                                this.a.Z.j0(pf9Var2);
                                                this.a.Z.setPostId(peaVar3.U());
                                                this.a.q4(view2, peaVar3.t().getUserId(), "", peaVar3);
                                                if (this.a.W != null) {
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                    absVideoPbFragment10.K4(absVideoPbFragment10.W.A());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091975) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.e0().M1());
                                        statisticItem14.param("fid", this.a.e0().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem14);
                                        StatisticItem statisticItem15 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem15.param("fid", this.a.e0().getForumId());
                                        statisticItem15.param("tid", this.a.e0().M1());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("post_id", this.a.M3());
                                        statisticItem15.param("obj_source", 1);
                                        statisticItem15.param("obj_type", 8);
                                        statisticItem15.param("obj_locate", this.a.L3());
                                        TiebaStatic.log(statisticItem15);
                                    }
                                    if ((view2.getId() != R.id.obfuscated_res_0x7f091afc && view2.getId() != R.id.obfuscated_res_0x7f091b67) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091afc) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.e0().getForumId());
                                            statisticItem16.param("tid", this.a.e0().M1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param("post_id", this.a.M3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 9);
                                            statisticItem16.param("obj_locate", this.a.L3());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                        if (!this.a.checkUpIsLogin()) {
                                            xn9.u("c10517", this.a.e0().s1().l(), 3);
                                            return;
                                        } else if (this.a.e0() == null || this.a.e0().s1() == null) {
                                            return;
                                        } else {
                                            go9 go9Var14 = this.a.o;
                                            if (go9Var14 != null) {
                                                go9Var14.G();
                                            }
                                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                            pea peaVar4 = (pea) sparseArray4.get(R.id.tag_load_sub_data);
                                            pea peaVar5 = (pea) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                            if (peaVar4 == null) {
                                                return;
                                            }
                                            if (peaVar4.P() == 1) {
                                                TiebaStatic.log(new StatisticItem("c12630"));
                                            }
                                            StatisticItem statisticItem17 = peaVar4.g0;
                                            if (statisticItem17 != null) {
                                                StatisticItem copy2 = statisticItem17.copy();
                                                copy2.delete("obj_locate");
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091975) {
                                                    copy2.param("obj_locate", 6);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091afc) {
                                                    copy2.param("obj_locate", 8);
                                                }
                                                TiebaStatic.log(copy2);
                                            }
                                            this.a.d5();
                                            TiebaStatic.log("c11742");
                                            if (peaVar5 != null) {
                                                this.a.b5(peaVar4, peaVar5, false, true);
                                                return;
                                            } else {
                                                this.a.b5(peaVar4, null, false, false);
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
                            this.a.d5();
                            this.a.P4();
                            boolean k3 = this.a.e0().k3(this.a.M3());
                            view2.setTag(Boolean.valueOf(k3));
                            if (k3) {
                                this.a.W4();
                                i4 = 1;
                                this.a.m = true;
                            } else {
                                i4 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                        }
                    } else if (!this.a.m && this.a.e0().p2(true)) {
                        this.a.m = true;
                        if (this.a.J3() != null) {
                            this.a.J3().O2();
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
    public class r0 implements df5 {
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

        @Override // com.baidu.tieba.df5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gk9 gk9Var = this.a.f1147T;
                if (gk9Var != null && gk9Var.e() != null && this.a.f1147T.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.f1147T.e().c());
                    if (this.a.W != null && (this.a.W.z() || this.a.W.B())) {
                        this.a.W.x(false, this.a.f1147T.h());
                    }
                    this.a.f1147T.a(true);
                    return true;
                }
                return !this.a.u3(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s extends gs5<ShareItem> {
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
        @Override // com.baidu.tieba.gs5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel e0 = this.b.e0();
                if (e0 != null) {
                    e0.U2(this.a);
                }
                return mm9.b(this.b.I3(), 2, e0);
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
            gk9 gk9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (gk9Var = this.a.f1147T) != null && gk9Var.g() != null) {
                if (!this.a.f1147T.g().e()) {
                    this.a.f1147T.b(false);
                }
                this.a.f1147T.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements lr5<ShareItem> {
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
        @Override // com.baidu.tieba.lr5
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
    public class t0 implements za<ImageView> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
                    if (uu4.c().g()) {
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = uu4.c().g();
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
            go9 go9Var = this.a.o;
            if (go9Var != null) {
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
                    go9Var.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements za<GifView> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
                if (uu4.c().g()) {
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = uu4.c().g();
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
        public void b(ye9 ye9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye9Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, ye9 ye9Var, String str, int i4, boolean z2) {
            String Y3;
            kd5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ye9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907bc));
                }
                this.a.O4();
                this.a.f4();
                if (this.a.m) {
                    this.a.m = false;
                }
                this.a.U4(false);
                if (z && ye9Var != null) {
                    ThreadData O = ye9Var.O();
                    this.a.x4(ye9Var);
                    this.a.z4(z, i, i2, i3, ye9Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(ye9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(ye9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(ye9Var.V().getBimg_end_time());
                    if (ye9Var.F() != null && ye9Var.F().size() >= 1 && ye9Var.F().get(0) != null) {
                        this.a.e0().S2(ye9Var.F().get(0).U());
                    } else if (ye9Var.Y() != null) {
                        this.a.e0().S2(ye9Var.Y().U());
                    }
                    if (this.a.q != null) {
                        this.a.q.h(ye9Var.q());
                    }
                    AntiData c = ye9Var.c();
                    if (c != null) {
                        this.a.N = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.N) && this.a.W != null && this.a.W.a() != null && (o = this.a.W.a().o(6)) != null && !TextUtils.isEmpty(this.a.N)) {
                            ((View) o).setOnClickListener(this.a.D0);
                        }
                    }
                    if (this.a.S != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.S.setLikeUserData(attentionHostData);
                    }
                    if (this.a.e0() != null && this.a.e0().c2()) {
                        Y3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        Y3 = this.a.Y3();
                    }
                    if (!StringUtils.isNull(Y3)) {
                        this.a.W.e0(TbSingleton.getInstance().getAdVertiComment(ye9Var.q0(), ye9Var.r0(), Y3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.e0().M1());
                            jSONObject.put("fid", this.a.e0().getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        wo6.b().c(new w85(this.a.e0().M1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (this.a.J3() == null) {
                        return;
                    }
                    if (i != -1) {
                        ArrayList<pea> arrayList = null;
                        if (this.a.e0() != null && this.a.e0().s1() != null) {
                            arrayList = this.a.e0().s1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).L() != 1)) {
                            this.a.J3().L2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else if (this.a.J3().D2()) {
                            this.a.J3().M2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1014));
                        } else {
                            this.a.J3().M2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1015));
                        }
                    } else {
                        this.a.J3().L2("");
                    }
                    this.a.J3().q2();
                }
                rca.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements za<View> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.O0());
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.e0() != null && this.a.e0().C1() != i + 1) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.H4(absVideoPbFragment.V3(i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements za<LinearLayout> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
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
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ow5.a)) {
                ow5.a aVar = (ow5.a) customResponsedMessage.getData();
                if (!StringUtils.isNull(aVar.e)) {
                    str = aVar.e;
                } else {
                    str = aVar.b;
                }
                ow5.c(this.a.getPageContext(), this.a, aVar.a, str, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements za<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && (agreeMessageData = (AgreeMessageData) customResponsedMessage.getData()) != null && (agreeData = agreeMessageData.agreeData) != null && agreeData.agreeType == 2 && this.a.J != null && this.a.e0() != null && !mm9.g(this.a.e0().M1())) {
                this.a.J.n(2);
                mm9.a(this.a.e0().M1());
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
                    this.a.W.I(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.Y != null && this.a.Y.f() != null) {
                    this.a.Y.f().J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 implements PbFallingView.p {
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

        @Override // com.baidu.tieba.pb.view.PbFallingView.p
        public void onClick() {
            String Y3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e0() != null && this.a.e0().c2()) {
                    Y3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    Y3 = this.a.Y3();
                }
                if (!StringUtils.isNull(Y3) && this.a.e0() != null && this.a.e0().s1() != null) {
                    Y3 = TbSingleton.getInstance().getAdVertiComment(this.a.e0().s1().q0(), this.a.e0().s1().r0(), Y3);
                }
                if (this.a.W != null) {
                    this.a.W.e0(Y3);
                }
                if (this.a.F != null) {
                    this.a.F.setText(Y3);
                }
                this.a.U4(false);
                this.a.Y4();
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
        this.t0 = new a1(this, 2004016);
        this.u0 = new b1(this, 2004007);
        this.v0 = new c1(this, 2921391);
        this.w0 = new d1(this, 2016450);
        this.x0 = new e1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
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

    public final void H4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i2) == null) && e0() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(e0().M1());
            sendMessage(privacySettingMessage);
        }
    }

    public final void J4(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).d2());
            }
        }
    }

    public void K4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.M = z2;
        }
    }

    public void L4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.m = z2;
        }
    }

    public final void R4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            this.W.Z(z2);
            this.W.c0(z2);
            this.W.k0(z2);
        }
    }

    public void U4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048627, this, z2) != null) || this.C == null) {
            return;
        }
        K4(this.W.A());
        if (this.M) {
            V4(z2);
        } else {
            c4(z2);
        }
    }

    public final void Z4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            jo9.a(l0(), I3(), i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048693, this, z2) == null) {
            super.onUserChanged(z2);
            p4();
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

    public void v4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048715, this, i2) == null) && i2 == 0) {
            rca.g().h(getUniqueId(), false);
            if (X3() != null) {
                q3(X3(), true);
            }
        }
    }

    public void N4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048606, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            go9 go9Var = this.o;
            if (go9Var == null) {
                return;
            }
            if (z2) {
                go9Var.G();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.o.H();
            } else {
                this.o.G();
            }
        }
    }

    @Override // com.baidu.tieba.rw5
    public void W(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, context, str) == null) {
            jk9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.z = true;
        }
    }

    public final void g4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048657, this, i2, i3) == null) {
            ks5.b(new s(this, i3), new t(this, i3, i2));
        }
    }

    @Override // com.baidu.tieba.rw5
    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048716, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.z = true;
    }

    public void w4(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048718, this, adverSegmentData, i2) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.A(adverSegmentData, getPageContext(), i2, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048685, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(N3(), viewGroup, false);
            m4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    public void A3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                y3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void A4(ye9 ye9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye9Var) == null) && ye9Var != null && ye9Var.O() != null) {
            i5(ye9Var);
            ImageView imageView = this.H;
            if (ye9Var.j0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (ye9Var.q()) {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String G3 = G3(ye9Var.O().getReply_num());
            TextView textView = this.K;
            if (textView != null) {
                textView.setText(G3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, ye9Var.O()));
        }
    }

    public final String G3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0ff6);
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

    public pea K3(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, ye9Var)) == null) {
            pea peaVar = null;
            if (ye9Var == null) {
                return null;
            }
            if (ye9Var.Y() != null) {
                return ye9Var.Y();
            }
            if (!ListUtils.isEmpty(ye9Var.F())) {
                Iterator<pea> it = ye9Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    pea next = it.next();
                    if (next != null && next.L() == 1) {
                        peaVar = next;
                        break;
                    }
                }
            }
            if (peaVar == null) {
                peaVar = ye9Var.i();
            }
            if (peaVar == null) {
                peaVar = W3(ye9Var);
            }
            if (peaVar != null && peaVar.t() != null && peaVar.t().getUserTbVipInfoData() != null && peaVar.t().getUserTbVipInfoData().getvipIntro() != null) {
                peaVar.t().getGodUserData().setIntro(peaVar.t().getUserTbVipInfoData().getvipIntro());
            }
            return peaVar;
        }
        return (pea) invokeL.objValue;
    }

    public final pea W3(ye9 ye9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, ye9Var)) == null) {
            if (ye9Var != null && ye9Var.O() != null && ye9Var.O().getAuthor() != null) {
                pea peaVar = new pea();
                MetaData author = ye9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ye9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                peaVar.W0(1);
                peaVar.c1(ye9Var.O().getFirstPostId());
                peaVar.t1(ye9Var.O().getTitle());
                peaVar.s1(ye9Var.O().getCreateTime());
                peaVar.P0(author);
                return peaVar;
            }
            return null;
        }
        return (pea) invokeL.objValue;
    }

    public void c4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) && this.C != null && this.F != null) {
            if (e0() != null && e0().s1() != null) {
                this.F.setText(TbSingleton.getInstance().getAdVertiComment(e0().s1().q0(), e0().s1().r0(), Y3()));
            } else {
                this.F.setText(Y3());
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

    public void i5(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, ye9Var) == null) {
            if (ye9Var != null && AntiHelper.o(ye9Var.O())) {
                oo9 oo9Var = this.J;
                if (oo9Var != null) {
                    oo9Var.k(false);
                    this.J.j();
                }
                ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.I.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            oo9 oo9Var2 = this.J;
            if (oo9Var2 != null && oo9Var2.g()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.I.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.I.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907bc));
            if (e0() != null && e0().s1() != null) {
                boolean b12 = e0().b1();
                ye9 s1 = e0().s1();
                if (b12) {
                    pea K3 = K3(s1);
                    if (s1.u() != null && !s1.u().equals(K3.U()) && (customViewPager = this.d) != null) {
                        customViewPager.setCurrentItem(0);
                    }
                }
            }
            this.a.L1().k(this.i0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            k4(bundle);
            O0().onCreate(getPageContext());
            h45 h45Var = new h45();
            this.p = h45Var;
            h45Var.a = 1000L;
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
            registerListener(this.O0);
            this.g = new aj6(getPageContext());
            rca.g().i(getUniqueId());
        }
    }

    public void x3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, bVar) == null) {
            List<pea> list = e0().s1().T().a;
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
            if (z2 && J3() != null) {
                J3().C2();
            }
        }
    }

    public final void x4(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048721, this, ye9Var) != null) || ye9Var == null) {
            return;
        }
        ThreadData O = ye9Var.O();
        if (O != null && O.isUgcThreadType()) {
            p3();
        } else {
            M4(this.V);
        }
        hf5 hf5Var = this.W;
        if (hf5Var != null) {
            K4(hf5Var.A());
            this.W.J(ye9Var.c());
            this.W.K(ye9Var.k(), ye9Var.V());
            this.W.m0(O);
            if (e0() != null) {
                this.W.L(e0().U0(), e0().M1(), e0().Q0());
            }
            if (O != null) {
                this.W.b0(O.isMutiForumThread());
            }
        }
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", U0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", U0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void D4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            reset();
            d4();
            this.Y.g();
            U4(false);
        }
    }

    public void E4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d0 = -1;
            this.e0 = Integer.MIN_VALUE;
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<GifView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.t == null) {
                this.t = new ya<>(new u0(this), 20, 0);
            }
            return this.t;
        }
        return (ya) invokeV.objValue;
    }

    public LinearLayout H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.D;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void I4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.l.setFallingFeedbackListener(new z0(this));
        }
    }

    public DetailInfoAndReplyFragment J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.e.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<LinearLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.x == null) {
                this.x = new ya<>(new w0(this), 15, 0);
            }
            return this.x;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.s == null) {
                this.s = VoiceManager.instance();
            }
            return this.s;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public View.OnClickListener O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.K0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void O4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            hideProgressBar();
            if (J3() != null) {
                J3().q2();
                J3().r2();
            }
        }
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PbModel J1 = this.a.J1();
            if (J1 == null) {
                return false;
            }
            return J1.l2();
        }
        return invokeV.booleanValue;
    }

    public View.OnClickListener P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.L0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void P4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public oq4 R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.q;
        }
        return (oq4) invokeV.objValue;
    }

    public View.OnLongClickListener S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.S0;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.G0;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public hf5 U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.W;
        }
        return (hf5) invokeV.objValue;
    }

    public void W4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(0);
        }
    }

    public String Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (!ad.isEmpty(this.L)) {
                return this.L;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(ck9.h());
            this.L = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void Y4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.setTag(Boolean.TRUE);
        }
    }

    @Override // com.baidu.tieba.bo9
    public PbModel.h b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.j0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048644, this) != null) || this.C == null) {
            return;
        }
        this.B.setVisibility(8);
        this.C.setVisibility(8);
    }

    public void c5() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (pbFallingView = this.l) != null) {
            pbFallingView.C();
            this.l.setAnimationListener(null);
        }
    }

    public void d4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && (editorTools = this.X) != null) {
            editorTools.q();
        }
    }

    public final void d5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048649, this) == null) && (voiceManager = this.s) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.bo9
    public PbModel e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.a.J1();
        }
        return (PbModel) invokeV.objValue;
    }

    public void e4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final void e5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.V1();
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<RelativeLayout> f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ya<RelativeLayout> yaVar = new ya<>(new x0(this), 10, 0);
            this.y = yaVar;
            return yaVar;
        }
        return (ya) invokeV.objValue;
    }

    public void f4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(8);
        }
    }

    public void g5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            hf5 hf5Var = this.W;
            if (hf5Var != null) {
                K4(hf5Var.A());
            }
            D4();
            this.o.G();
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<ImageView> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            if (this.v == null) {
                this.v = new ya<>(new t0(this), 8, 0);
            }
            return this.v;
        }
        return (ya) invokeV.objValue;
    }

    public void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            setEditorTools(this.W.a());
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<View> k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.w == null) {
                this.w = new ya<>(new v0(this), 8, 0);
            }
            return this.w;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bo9
    public AbsPbActivity l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void l4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048672, this) != null) || (editorTools = this.X) == null) {
            return;
        }
        editorTools.j();
        b4();
    }

    public boolean n4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            EditorTools editorTools = this.X;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            super.onStart();
            O0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<TextView> p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            if (this.u == null) {
                this.u = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.u;
        }
        return (ya) invokeV.objValue;
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && this.E != null) {
            C3();
            this.E.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    public final boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            PbModel e02 = e0();
            if (e02 != null && e02.s1() != null) {
                return AntiHelper.b(getPageContext(), e02.s1().O());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048710, this) == null) && e0() != null && !ad.isEmpty(e0().M1())) {
            super.taskStart();
        }
    }

    public void B4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048579, this, z2, markData) != null) || e0() == null) {
            return;
        }
        O4();
        e0().i3(z2);
        oq4 oq4Var = this.q;
        if (oq4Var != null) {
            oq4Var.h(z2);
            if (markData != null) {
                this.q.i(markData);
            }
        }
        if (e0().d1()) {
            r4();
        } else if (J3() != null) {
            J3().C2();
        }
    }

    @Override // com.baidu.tieba.rw5
    public void U(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, context, str) == null) {
            if (!StringUtils.isNull(str) && !TextUtils.isDigitsOnly(str) && eh9.a(str)) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + str);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            }
            this.z = true;
        }
    }

    public void C4(pf9 pf9Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, pf9Var) == null) && e0() != null && e0().s1() != null && pf9Var.g() != null) {
            String U = pf9Var.g().U();
            ArrayList<pea> F = e0().s1().F();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= F.size()) {
                    break;
                }
                pea peaVar = F.get(i2);
                if (peaVar.U() != null && peaVar.U().equals(U)) {
                    ArrayList<pea> i3 = pf9Var.i();
                    peaVar.q1(pf9Var.k());
                    if (peaVar.j0() != null && i3 != null) {
                        Iterator<pea> it = i3.iterator();
                        while (it.hasNext()) {
                            pea next = it.next();
                            if (peaVar.s0() != null && next != null && next.t() != null && (metaData = peaVar.s0().get(next.t().getUserId())) != null) {
                                next.P0(metaData);
                                next.g1(true);
                                next.A1(getPageContext(), e0().m2(metaData.getUserId()));
                            }
                        }
                        if (i3.size() != peaVar.j0().size()) {
                            z3 = true;
                        }
                        if (!peaVar.z0(true)) {
                            peaVar.j0().clear();
                            peaVar.j0().addAll(i3);
                        }
                        z2 = z3;
                    }
                    if (peaVar.E() != null) {
                        peaVar.N0();
                    }
                } else {
                    i2++;
                }
            }
            if (!e0().b1() && z2 && J3() != null) {
                J3().C2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            BDLayoutMode layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 4) {
                z2 = false;
            }
            layoutMode.setNightMode(z2);
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c);
            gk9 gk9Var = this.f1147T;
            if (gk9Var != null) {
                gk9Var.i();
            }
            EditorTools editorTools = this.X;
            if (editorTools != null) {
                editorTools.z(i2);
            }
            aj9 aj9Var = this.Y;
            if (aj9Var != null) {
                aj9Var.l(i2);
            }
            LinearLayout linearLayout = this.D;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (e0() != null && e0().d1()) {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.G, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.E, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            if (e0() != null) {
                i5(e0().s1());
            }
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.K, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.K, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (J3() != null) {
                J3().onChangeSkinType(i2);
            }
            d5();
        }
    }

    public final void D3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                hz4 hz4Var = new hz4(getPageContext().getPageActivity());
                hz4Var.setMessage(string);
                hz4Var.setPositiveButton(R.string.dialog_known, new l(this));
                hz4Var.setCancelable(true);
                hz4Var.create(getPageContext());
                hz4Var.show();
            } else {
                E3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<pea> F = e0().s1().F();
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
                    e0().s1().O().setReply_num(e0().s1().O().getReply_num() - 1);
                    if (J3() != null) {
                        J3().C2();
                    }
                } else if (i3 == 0) {
                    w3();
                } else if (i3 == 2) {
                    ArrayList<pea> F2 = e0().s1().F();
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
                    if (z3 && J3() != null) {
                        J3().C2();
                    }
                    x3(bVar);
                }
            }
        }
    }

    public final void X4(String str, String str2) {
        int i2;
        int dimens;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, str, str2) == null) {
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
            if (X3() != null) {
                X3().smoothScrollBy(0, i4);
            }
            if (this.Y != null) {
                this.W.a().setVisibility(8);
                this.Y.t(str, str2, Y3(), (e0() == null || e0().s1() == null || e0().s1().O() == null || !e0().s1().O().isBjh()) ? false : false);
                this.Y.q(L3());
                kf5 f2 = this.Y.f();
                if (f2 != null && e0() != null && e0().s1() != null) {
                    f2.K(e0().s1().c());
                    f2.g0(e0().s1().O());
                }
                if (this.f1147T.f() == null && this.Y.f().v() != null) {
                    this.Y.f().v().h(new s0(this));
                    this.f1147T.n(this.Y.f().v().j());
                    this.Y.f().Q(this.B0);
                }
            }
            b4();
        }
    }

    public void E3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f14be));
            } else if (z3) {
                if (ad.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e4f);
                }
                showToast(str);
            }
        }
    }

    public final void F3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048587, this, i2, gVar) == null) && gVar != null && e0() != null && e0().s1() != null && e0().s1().O() != null) {
            E3(this.r.getLoadDataMode(), gVar.a, gVar.b, false);
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
                    e0().s1().O().setIs_good(1);
                    e0().V2(1);
                } else if (i2 == 3) {
                    e0().s1().O().setIs_good(0);
                    e0().V2(0);
                } else if (i2 == 4) {
                    e0().s1().O().setIs_top(1);
                    e0().W2(1);
                } else if (i2 == 5) {
                    e0().s1().O().setIs_top(0);
                    e0().W2(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
            }
            if (e0().s1().O() != null && J3() != null) {
                J3().H2();
            }
        }
    }

    public final void Z3(int i2, Intent intent) {
        pd5 pd5Var;
        aj9 aj9Var;
        pd5 pd5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048637, this, i2, intent) == null) {
            if (i2 == 0) {
                d4();
                aj9 aj9Var2 = this.Y;
                if (aj9Var2 != null) {
                    aj9Var2.g();
                }
                U4(false);
            }
            D4();
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
                if (editorType == 1 && (aj9Var = this.Y) != null && aj9Var.f() != null) {
                    kf5 f2 = this.Y.f();
                    f2.g0(e0().s1().O());
                    f2.E(writeData);
                    f2.h0(pbEditorData.getVoiceModel());
                    od5 p2 = f2.a().p(6);
                    if (p2 != null && (pd5Var2 = p2.m) != null) {
                        pd5Var2.O(new cd5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.J();
                        return;
                    }
                    return;
                }
                return;
            }
            this.W.N();
            this.W.o0(pbEditorData.getVoiceModel());
            this.W.D(writeData);
            od5 p3 = this.W.a().p(6);
            if (p3 != null && (pd5Var = p3.m) != null) {
                pd5Var.O(new cd5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.W.I(null, null);
            }
        }
    }

    public void y3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048722, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.r.g0()) {
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
                    this.r.i0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.r.j0(e0().s1().k().getId(), e0().s1().k().getName(), e0().s1().O().getId(), str, intValue3, intValue2, booleanValue, e0().s1().O().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                if (e0().N0() != null) {
                    e0().N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public boolean F4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof pea)) {
                return false;
            }
            pea peaVar = (pea) obj;
            if (!TextUtils.isEmpty(peaVar.v()) && uu4.c().g()) {
                return t4(peaVar.U());
            }
            if (checkUpIsLogin() && e0() != null && e0().s1() != null) {
                aj9 aj9Var = this.Y;
                if (aj9Var != null) {
                    aj9Var.g();
                }
                pf9 pf9Var = new pf9();
                pf9Var.v(e0().s1().k());
                pf9Var.z(e0().s1().O());
                pf9Var.x(peaVar);
                this.Z.j0(pf9Var);
                this.Z.setPostId(peaVar.U());
                q4(view2, peaVar.t().getUserId(), "", peaVar);
                TiebaStatic.log("c11743");
                hf5 hf5Var = this.W;
                if (hf5Var != null) {
                    K4(hf5Var.A());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean t4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, str)) == null) {
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

    public final void G4(boolean z2) {
        oq4 oq4Var;
        MarkData f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048590, this, z2) != null) || (oq4Var = this.q) == null || (f2 = oq4Var.f()) == null) {
            return;
        }
        lea leaVar = new lea();
        leaVar.a = f2.getThreadId();
        leaVar.b = z2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, leaVar));
    }

    public void V4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) && this.C != null && (textView = this.F) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0610);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.C.startAnimation(alphaAnimation);
            }
            this.B.setVisibility(0);
            this.C.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (e0() != null) {
                e0().O2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                O0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final boolean s3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048703, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final int I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (e0() != null && e0().s1() != null && e0().s1().O() != null) {
                return e0().s1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView X3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter == null) {
                return null;
            }
            Iterator<BaseFragment> it = videoPbFragmentAdapter.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).w2();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void a5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && e0() != null && !ad.isEmpty(e0().M1())) {
            un4.w().Q(tn4.Z, JavaTypesHelper.toLong(e0().M1(), 0L));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            oq4 c2 = oq4.c(this.a);
            this.q = c2;
            if (c2 != null) {
                c2.j(this.r0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.r = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.F0);
            getPageContext();
            this.o = new go9(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            super.onResume();
            this.h0 = false;
            O0().onResume(getPageContext());
            a5();
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
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            super.onStop();
            O0().onStop(getPageContext());
            rca.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.P0);
        }
    }

    public final void r4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048700, this) != null) || e0() == null) {
            return;
        }
        ye9 s1 = e0().s1();
        e0().i3(true);
        oq4 oq4Var = this.q;
        if (oq4Var != null) {
            s1.L0(oq4Var.g());
        }
        if (J3() != null) {
            J3().C2();
        }
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.o != null && e0() != null) {
                this.o.G();
                if (this.m) {
                    return;
                }
                d5();
                P4();
                if (e0().loadData()) {
                    W4();
                }
            }
        }
    }

    public final String M3() {
        InterceptResult invokeV;
        ArrayList<pea> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (e0() == null || e0().s1() == null || e0().s1().F() == null || (count = ListUtils.getCount((F = e0().s1().F()))) == 0) {
                return "";
            }
            if (e0().E1()) {
                Iterator<pea> it = F.iterator();
                while (it.hasNext()) {
                    pea next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int i2 = 0;
            if (X3() != null && J3() != null) {
                i2 = J3().t2();
            }
            pea peaVar = (pea) ListUtils.getItem(F, i2);
            if (peaVar != null && peaVar.t() != null) {
                if (e0().m2(peaVar.t().getUserId())) {
                    return peaVar.U();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    pea peaVar2 = (pea) ListUtils.getItem(F, i3);
                    if (peaVar2 == null || peaVar2.t() == null || peaVar2.t().getUserId() == null) {
                        break;
                    } else if (e0().m2(peaVar2.t().getUserId())) {
                        return peaVar2.U();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    pea peaVar3 = (pea) ListUtils.getItem(F, i4);
                    if (peaVar3 == null || peaVar3.t() == null || peaVar3.t().getUserId() == null) {
                        break;
                    } else if (e0().m2(peaVar3.t().getUserId())) {
                        return peaVar3.U();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean f5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (e0() == null) {
                return true;
            }
            if (e0().s1() != null && e0().s1().j0()) {
                return true;
            }
            if (e0().d1()) {
                MarkData O0 = e0().O0();
                if (O0 != null && e0().b1() && X3() != null) {
                    MarkData I0 = e0().I0(X3().getFirstVisiblePosition());
                    if (I0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", O0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                        hz4 hz4Var = new hz4(getBaseFragmentActivity());
                        hz4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f029b));
                        hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c8, new n(this, I0, O0, hz4Var));
                        hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new o(this, O0, hz4Var));
                        hz4Var.setOnCalcelListener(new p(this));
                        hz4Var.create(getBaseFragmentActivity().getPageContext());
                        hz4Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", O0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (e0().s1() != null && e0().s1().F() != null && e0().s1().F().size() > 0 && e0().b1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            this.A = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0928ff);
            this.B = this.c.findViewById(R.id.obfuscated_res_0x7f09295b);
            this.C = this.c.findViewById(R.id.obfuscated_res_0x7f091ae5);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0909a6);
            this.E = imageView;
            imageView.setOnClickListener(new d0(this));
            p4();
            this.F = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ae8);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091adf);
            this.D = linearLayout;
            linearLayout.setOnClickListener(new e0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ae6);
            this.G = imageView2;
            imageView2.setOnClickListener(this.K0);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ae4);
            this.H = imageView3;
            imageView3.setOnClickListener(this.K0);
            if (booleanExtra) {
                this.H.setVisibility(8);
            } else {
                this.H.setVisibility(0);
            }
            if (o4()) {
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
                this.H.setPadding(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ae9);
            this.I = imageView4;
            imageView4.setOnClickListener(this.K0);
            this.J = new oo9(this.I);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ae7);
            this.K = textView;
            textView.setVisibility(0);
            U4(false);
        }
    }

    public final void p3() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && e0() != null && this.a != null) {
            hf5 hf5Var = this.W;
            if (hf5Var != null && hf5Var.t) {
                return;
            }
            gf5 gf5Var = new gf5();
            M4(gf5Var);
            hf5 hf5Var2 = (hf5) gf5Var.a(getContext());
            this.W = hf5Var2;
            hf5Var2.Y(this.a.getPageContext());
            this.W.h0(this.C0);
            this.W.i0(this.J0);
            hf5 hf5Var3 = this.W;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            hf5Var3.C(pageContext, extras);
            this.W.a().F(true);
            setEditorTools(this.W.a());
            if (!e0().f1()) {
                this.W.r(e0().M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.W.e0(TbSingleton.getInstance().getAdVertiComment());
            } else if (e0().c2()) {
                this.W.e0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.W.e0(Y3());
            }
        }
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && e0() != null && e0().s1() != null && J3() != null && this.q != null) {
            MarkData markData = null;
            if (e0().s1() != null && e0().s1().j0()) {
                markData = e0().I0(0);
            } else {
                CustomViewPager customViewPager = this.d;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = e0().m1(K3(e0().s1()));
                } else if (J3() != null) {
                    markData = e0().I0(J3().v2());
                }
            }
            if (markData == null) {
                return;
            }
            P4();
            this.q.i(markData);
            if (!this.q.e()) {
                if (e0() != null && !mm9.g(e0().M1())) {
                    this.J.n(2);
                    mm9.a(e0().M1());
                }
                this.q.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.q.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void M4(if5 if5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, if5Var) == null) && if5Var != null && e0() != null) {
            if5Var.p(e0().R0());
            if (e0().s1() != null && e0().s1().k() != null) {
                if5Var.o(e0().s1().k());
            }
            if5Var.q("pb");
            if5Var.r(e0());
            if5Var.s(PbNewEditorTool.InputShowType.REPLY_VIDEO);
        }
    }

    public final void Q4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048616, this, i2) != null) || e0() == null) {
            return;
        }
        int C1 = e0().C1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    e0().c3(1);
                } else {
                    e0().c3(4);
                }
            } else {
                e0().c3(3);
            }
        } else {
            e0().c3(2);
        }
        int C12 = e0().C1();
        if (C1 == 4 || C12 == 4) {
            u4();
        }
    }

    public void j5(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            DetailInfoAndReplyFragment J3 = J3();
            if (J3 != null && J3.c2() != null && J3.c2().g() != null && J3.c2().h() != null) {
                J3.c2().g().x0(z2);
                J3.c2().h().V(z2);
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

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, editorTools) == null) {
            this.X = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091ae0);
            this.X.setOnCancelClickListener(new m0(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.X.getParent() == null) {
                this.c.addView(this.X, layoutParams);
            }
            this.X.z(TbadkCoreApplication.getInst().getSkinType());
            this.X.setActionListener(24, new n0(this));
            d4();
            this.W.g(new o0(this));
        }
    }

    public boolean u3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048711, this, i2)) == null) {
            if (this.S != null && e0() != null && e0().s1() != null && !ThreadCardUtils.isSelf(e0().s1().O()) && e0().s1().c() != null) {
                return this.S.checkPrivacyBeforeSend(e0().s1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public SparseArray<Object> Q3(ye9 ye9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        pea K3;
        boolean z3;
        qw4 qw4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{ye9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (ye9Var == null || (K3 = K3(ye9Var)) == null) {
                return null;
            }
            String userId = K3.t().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, K3.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ye9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (K3.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, K3.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, K3.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, K3.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, K3.U());
                }
                sparseArray.put(R.id.tag_del_post_id, K3.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ye9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<ly4> o2 = ye9Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (ly4 ly4Var : o2) {
                        if (ly4Var != null && !StringUtils.isNull(ly4Var.d()) && (qw4Var = ly4Var.h) != null && qw4Var.a && !qw4Var.c && ((i3 = qw4Var.b) == 1 || i3 == 2)) {
                            sb.append(ad.cutString(ly4Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0785));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0549), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void R0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048617, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (ow5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ow5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (jk9.c(objArr[i2].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.rw5
    public void n0(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048675, this, context, str, z2) == null) {
            if (jk9.c(str) && e0() != null && e0().M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", e0().M1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    gc5 gc5Var = new gc5();
                    gc5Var.a = str;
                    gc5Var.b = 3;
                    gc5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, gc5Var));
                }
            } else {
                jk9.a().e(getPageContext(), str);
            }
            this.z = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048681, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.W.E(i2, i3, intent);
            aj9 aj9Var = this.Y;
            if (aj9Var != null) {
                aj9Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                Z3(i3, intent);
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
                                if (H3() != null) {
                                    H3().performClick();
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
                s4();
            }
        }
    }

    public final void S4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048622, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new l0(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                go9 go9Var = this.o;
                if (go9Var != null) {
                    go9Var.D0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.rw5
    public void s0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048702, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.o.o0(str);
            iz4 S = this.o.S();
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
            this.z = true;
        }
    }

    public final void T4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048624, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    va5.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (e0() != null && !e0().f1()) {
                antiData.setBlock_forum_name(e0().s1().k().getName());
                antiData.setBlock_forum_id(e0().s1().k().getId());
                antiData.setUser_name(e0().s1().V().getUserName());
                antiData.setUser_id(e0().s1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public void q3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        pea peaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048697, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof pea) && (peaVar = (pea) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && peaVar.o() != null) {
                        peaVar.o().setFloonumber(peaVar.L());
                        arrayList.add(peaVar.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new y0(this));
                if (((AdverSegmentData) ListUtils.getItem(arrayList, 0)).getFloonumber() == 1) {
                    if (!z2) {
                        w4((AdverSegmentData) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                w4((AdverSegmentData) ListUtils.getItem(arrayList, 0), 1);
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
    public void a4(boolean z2) {
        ye9 s1;
        int i2;
        int i3;
        oo9 oo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048640, this, z2) == null) && e0() != null && this.o != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (s1 = e0().s1()) == null) {
                return;
            }
            ThreadData O = s1.O();
            int i4 = 1;
            if (O != null && O.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", e0().M1()).param("fid", s1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", e0().getForumId());
                statisticItem.param("tid", e0().M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", M3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", L3());
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
                statisticItem2.param("tid", e0().M1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", e0().getForumId());
                if (!z2) {
                    statisticItem2.param("obj_locate", 6);
                } else {
                    statisticItem2.param("obj_locate", 5);
                }
                statisticItem2.param("obj_name", i2);
                if (O == null) {
                    if (O.isBJHArticleThreadType()) {
                        i3 = 10;
                    } else if (O.isBJHVideoThreadType()) {
                        i3 = 9;
                    } else if (O.isBJHVideoDynamicThreadType()) {
                        i3 = 8;
                    } else if (O.isBJHNormalThreadType()) {
                        i3 = 7;
                    } else if (O.isShareThread) {
                        i3 = 6;
                    } else {
                        int i5 = O.threadType;
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
                    statisticItem2.param("nid", O.getNid());
                    statisticItem2.param("card_type", O.getRecomCardType());
                    statisticItem2.param("recom_source", O.mRecomSource);
                    statisticItem2.param("ab_tag", O.mRecomAbTag);
                    statisticItem2.param("weight", O.mRecomWeight);
                    statisticItem2.param("extra", O.mRecomExtra);
                    statisticItem2.param("nid", O.getNid());
                    if (O.getBaijiahaoData() != null && !ad.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                    }
                } else {
                    i3 = 2;
                }
                statisticItem2.param("obj_type", i3);
                if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (l0() != null) {
                    ym5.e(l0(), statisticItem2);
                }
                oo9Var = this.J;
                if (oo9Var != null) {
                    statisticItem2.param("obj_param1", oo9Var.f());
                }
                TiebaStatic.log(statisticItem2);
                if (BdUtilHelper.isNetOk()) {
                    showToast(R.string.obfuscated_res_0x7f0f0e4f);
                    return;
                } else if (e0().s1() == null) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1013));
                    return;
                } else {
                    ArrayList<pea> F = s1.F();
                    if ((F == null || F.size() <= 0) && e0().L1()) {
                        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1013));
                        return;
                    }
                    this.o.G();
                    d5();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), O)) {
                        return;
                    }
                    oo9 oo9Var2 = this.J;
                    if (oo9Var2 != null) {
                        oo9Var2.k(false);
                        i5(s1);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i4 = 2;
                        }
                        if (this.J.h()) {
                            this.J.l(false);
                            g4(ga5.a(), this.J.f());
                            return;
                        }
                        Z4(i4);
                        return;
                    }
                    this.o.v0();
                    e0().M0().P(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", e0().M1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", e0().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            if (O == null) {
            }
            statisticItem22.param("obj_type", i3);
            if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (l0() != null) {
            }
            oo9Var = this.J;
            if (oo9Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (BdUtilHelper.isNetOk()) {
            }
        }
    }

    public final void b5(pea peaVar, pea peaVar2, boolean z2, boolean z3) {
        String str;
        int i2;
        boolean z4;
        boolean z5;
        pea K3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{peaVar, peaVar2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String M1 = e0().M1();
            String U = peaVar.U();
            if (peaVar2 != null) {
                str = peaVar2.U();
            } else {
                str = "";
            }
            if (e0().s1() != null) {
                i2 = e0().s1().W();
            } else {
                i2 = 0;
            }
            if (J3() != null && J3().y2() != null) {
                AbsPbActivity.e f2 = J3().y2().f(U);
                if (peaVar != null && e0() != null && e0().s1() != null && f2 != null) {
                    if (L3() != 1 && L3() != 2 && L3() != 3 && L3() != 4 && L3() != 5) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, true, null, false, str, i2, peaVar.m0(), e0().s1().c(), false, peaVar.t().getIconInfo(), L3(), z4).addBigImageData(f2.a, f2.b, f2.g, f2.j);
                    if (z3) {
                        addBigImageData.setHighLightPostId(str);
                        z5 = true;
                        addBigImageData.setKeyIsUseSpid(true);
                    } else {
                        z5 = true;
                    }
                    addBigImageData.setKeyFromForumId(e0().getForumId());
                    addBigImageData.setTiebaPlusData(e0().W(), e0().S(), e0().T(), e0().R(), e0().X());
                    addBigImageData.setBjhData(e0().J0());
                    addBigImageData.setKeyPageStartFrom(e0().r1());
                    addBigImageData.setFromFrsForumId(e0().getFromForumId());
                    addBigImageData.setWorksInfoData(e0().R1());
                    addBigImageData.setIsOpenEditor(z2);
                    if (e0().s1().n() != null) {
                        addBigImageData.setHasForumRule(e0().s1().n().has_forum_rule.intValue());
                    }
                    if (e0().s1().V() != null) {
                        addBigImageData.setIsManager(e0().s1().V().getIs_manager());
                    }
                    if (e0().s1().k().getDeletedReasonInfo() != null) {
                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(e0().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(e0().s1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    if (e0().s1().k() != null) {
                        addBigImageData.setForumHeadUrl(e0().s1().k().getImage_url());
                        addBigImageData.setUserLevel(e0().s1().k().getUser_level());
                    }
                    if (e0() != null && (K3 = K3(e0().s1())) != null) {
                        if (!K3.f1148T && !peaVar.f1148T) {
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

    @Override // com.baidu.tieba.bo9
    public void finish() {
        CardHListViewData p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            PbModel J1 = this.a.J1();
            if (J1 != null && J1.s1() != null && J1.s1().O() != null && !J1.s1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = J1.s1().O().getId();
                if (J1.isShareThread() && J1.s1().O().originalThreadData != null) {
                    historyMessage.threadName = J1.s1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = J1.s1().O().getTitle();
                }
                if (J1.isShareThread() && !P0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = J1.s1().k().getName();
                }
                ArrayList<pea> F = J1.s1().F();
                if (F != null && F.size() > 0) {
                    historyMessage.postID = F.get(0).U();
                }
                historyMessage.isHostOnly = J1.V0();
                historyMessage.isSquence = J1.L1();
                historyMessage.isShareThread = J1.isShareThread();
                historyMessage.threadType = J1.s1().O().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            hf5 hf5Var = this.W;
            if (hf5Var != null) {
                hf5Var.F();
            }
            if (J1 != null && (J1.X0() || J1.a1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", J1.M1());
                if (this.O) {
                    if (this.Q) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", J1.g1());
                    }
                    if (this.P) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", J1.c1());
                    }
                }
                if (J1.s1() != null && System.currentTimeMillis() - this.b >= 40000 && (p2 = J1.s1().p()) != null && !ListUtils.isEmpty(p2.getDataList())) {
                    intent.putExtra("guess_like_data", p2);
                }
                this.a.setResult(-1, intent);
            }
            if (f5()) {
                if (J1 != null) {
                    ye9 s1 = J1.s1();
                    if (s1 != null) {
                        if (s1.V() != null) {
                            s1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s1.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.R) {
                            uj9.b().q(this.d.getCurrentItem());
                            BdTypeRecyclerView X3 = X3();
                            Parcelable parcelable = null;
                            if (X3 != null) {
                                parcelable = X3.onSaveInstanceState();
                            }
                            uj9.b().l(J1.t1(), parcelable, J1.L1(), J1.V0(), false);
                        }
                    }
                } else {
                    uj9.b().k();
                }
                e5();
            }
        }
    }

    public final void h5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && e0() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.S(e0().getForumId()) && e0().s1() != null && e0().s1().k() != null) {
            boolean z2 = true;
            if (e0().s1().k().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                e0().F0().R(e0().getForumId(), e0().M1());
            }
        }
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            this.Z = new PbFakeFloorModel(getPageContext());
            PbModel e02 = e0();
            this.Z.g0(e02.W(), e02.S(), e02.T(), e02.R(), e02.X());
            this.Z.setFromForumId(e02.getFromForumId());
            aj9 aj9Var = new aj9(getPageContext(), this.Z, this.c);
            this.Y = aj9Var;
            aj9Var.p(new h0(this));
            this.Y.s(this.I0);
            this.Z.i0(new i0(this));
        }
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            vt6 vt6Var = new vt6(getActivity());
            this.a0 = vt6Var;
            vt6Var.i(this.H0);
            this.d = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091b94);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f09126f);
            this.k = (MaskView) this.c.findViewById(R.id.mask_view);
            this.f.setOnClickListener(this.K0);
            h4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.e = videoPbFragmentAdapter;
            this.d.setAdapter(videoPbFragmentAdapter);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f092993);
            this.l = (PbFallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090afc);
            I4();
            this.l.setAnimationListener(new c0(this));
            j4();
            i4();
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && e0() != null && e0().s1() != null && e0().s1().O() != null) {
            ThreadData O = e0().s1().O();
            O.mRecomAbTag = e0().y1();
            O.mRecomWeight = e0().B1();
            O.mRecomSource = e0().A1();
            O.mRecomExtra = e0().z1();
            O.isSubPb = e0().f1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(e0().getForumId(), 0L));
            }
            StatisticItem i2 = ym5.i(getContext(), O, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            super.onDestroy();
            rca.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.O0);
            ItemCardHelper.w(null);
            O0().onDestory(getPageContext());
            oo9 oo9Var = this.J;
            if (oo9Var != null) {
                oo9Var.j();
            }
            ForumManageModel forumManageModel = this.r;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.S;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            go9 go9Var = this.o;
            if (go9Var != null) {
                go9Var.m0();
            }
            aj9 aj9Var = this.Y;
            if (aj9Var != null) {
                aj9Var.m();
            }
            if (e0() != null) {
                e0().cancelLoadData();
                e0().destory();
                if (e0().o1() != null) {
                    e0().o1().d();
                }
            }
            hf5 hf5Var = this.W;
            if (hf5Var != null) {
                hf5Var.F();
            }
            this.p = null;
            aea.d();
            c5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            super.onPause();
            this.h0 = true;
            O0().onPause();
            if (e0() != null && !e0().f1()) {
                this.W.P(e0().M1());
            }
            un4.w().E();
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
            cf5.a().c(0);
            this.W.O();
            this.W.M();
            if (this.W.w() != null) {
                WriteImagesInfo w2 = this.W.w();
                if (this.W.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                w2.setMaxImagesAllowed(i2);
            }
            this.W.f0(SendView.f);
            this.W.h(SendView.f);
            kd5 o2 = this.X.o(23);
            kd5 o3 = this.X.o(2);
            kd5 o4 = this.X.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.X.invalidate();
        }
    }

    public boolean t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            if ((e0() != null && e0().s1().j0()) || this.S == null || e0() == null || e0().s1() == null || ThreadCardUtils.isSelf(e0().s1().O()) || e0().s1().c() == null) {
                return true;
            }
            return this.S.checkPrivacyBeforeInvokeEditor(e0().s1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            if (!checkUpIsLogin()) {
                if (e0() != null) {
                    xn9.u("c10517", e0().getForumId(), 2);
                }
            } else if (!t3()) {
            } else {
                hf5 hf5Var = this.W;
                if (hf5Var != null && (hf5Var.z() || this.W.B())) {
                    this.W.x(false, null);
                    return;
                }
                if (this.X != null) {
                    l4();
                    if (this.X.p(2) != null) {
                        aea.c(getPageContext(), (View) this.X.p(2).m, false, null);
                    }
                }
                b4();
            }
        }
    }

    public void y4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048723, this) != null) || !checkUpIsLogin() || e0() == null || e0().s1() == null || e0().s1().k() == null || r3()) {
            return;
        }
        if (e0().s1().j0()) {
            v3();
            return;
        }
        hf5 hf5Var = this.W;
        if (hf5Var != null && hf5Var.a() != null) {
            this.W.a().D(new cd5(45, 27, null));
        }
        v3();
    }

    public final void k4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, bundle) == null) {
            if5 if5Var = new if5();
            this.V = if5Var;
            M4(if5Var);
            hf5 hf5Var = (hf5) this.V.a(getActivity());
            this.W = hf5Var;
            hf5Var.Y(this.a.getPageContext());
            this.W.h0(this.C0);
            this.W.i0(this.J0);
            this.W.a0(1);
            this.W.f0(SendView.f);
            this.W.h(SendView.f);
            this.W.C(this.a.getPageContext(), bundle);
            this.W.a().b(new nd5(getActivity()));
            this.W.a().F(true);
            R4(true);
            if (e0() != null) {
                this.W.L(e0().U0(), e0().M1(), e0().Q0());
            }
            registerListener(this.u0);
            registerListener(this.w0);
            registerListener(this.E0);
            registerListener(this.t0);
            registerListener(this.v0);
            registerListener(this.x0);
            registerListener(this.R0);
            if (!e0().f1()) {
                this.W.r(e0().M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.W.e0(TbSingleton.getInstance().getAdVertiComment());
            } else if (e0().c2()) {
                this.W.e0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.W.e0(Y3());
            }
            this.f1147T = new gk9();
            if (this.W.t() != null) {
                this.f1147T.m(this.W.t().j());
            }
            this.W.X(this.s0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.S = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new z(this));
        }
    }

    public final void o3(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048678, this, z2, str) == null) && e0() != null && e0().s1() != null && e0().s1().O() != null) {
            ThreadData O = e0().s1().O();
            O.mRecomAbTag = e0().y1();
            O.mRecomWeight = e0().B1();
            O.mRecomSource = e0().A1();
            O.mRecomExtra = e0().z1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(e0().getForumId(), 0L));
            }
            StatisticItem i2 = ym5.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = ym5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (O.isVideoThreadType()) {
                    if (ns5.e(str) > 40) {
                        str2 = ns5.m(str, 40);
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
                tm5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (L3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (L3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (L3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (L3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (L3() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", e0().M1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", e0().s1().l());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = ym5.i(getContext(), O, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", e0().M1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", e0().s1().l());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = ym5.i(getContext(), O, "c14303");
            if (i4 != null) {
                if (L3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (L3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (L3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (L3() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", e0().M1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", e0().s1().l());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }

    public final void q4(View view2, String str, String str2, pea peaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048698, this, view2, str, str2, peaVar) != null) || view2 == null || str == null || str2 == null || r3() || !t3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.b0);
            this.c0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.Y != null && peaVar != null) {
            if (peaVar.f0() != null) {
                str3 = peaVar.f0().toString();
            } else {
                str3 = "";
            }
            this.Y.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), peaVar.t().getName_show(), str3));
        }
        if (e0() != null && e0().s1() != null && e0().s1().j0()) {
            SafeHandler.getInst().postDelayed(new p0(this, str, str2), 0L);
            return;
        }
        SafeHandler.getInst().postDelayed(new q0(this, str, str2), 0L);
        if (e0() == null || e0().s1() == null || e0().s1().k() == null) {
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            if (e0().X0() || e0().a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", e0().M1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, e0().M1()));
            if (f5()) {
                this.a.finish();
            }
        }
    }

    public void z3(hz4 hz4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048724, this, hz4Var, jSONArray) == null) {
            hz4Var.dismiss();
            if (e0() != null && e0().s1() != null && e0().s1().O() != null && e0().s1().k() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(hz4Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    y3((SparseArray) hz4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void z4(boolean z2, int i2, int i3, int i4, ye9 ye9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048725, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ye9Var, str, Integer.valueOf(i5)}) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null) {
                for (BaseFragment baseFragment : videoPbFragmentAdapter.c()) {
                    if (baseFragment instanceof ao9) {
                        ((ao9) baseFragment).P1(z2, i2, i3, i4, ye9Var, str, i5);
                    }
                }
            }
            P1(z2, i2, i3, i4, ye9Var, str, i5);
        }
    }
}
