package com.baidu.tieba.pb.pb.foldcomment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.VCenterTextSpan;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.ah5;
import com.baidu.tieba.aw9;
import com.baidu.tieba.b3a;
import com.baidu.tieba.b6a;
import com.baidu.tieba.bh5;
import com.baidu.tieba.br6;
import com.baidu.tieba.c1a;
import com.baidu.tieba.cp5;
import com.baidu.tieba.d5b;
import com.baidu.tieba.e1a;
import com.baidu.tieba.e5b;
import com.baidu.tieba.eh5;
import com.baidu.tieba.f05;
import com.baidu.tieba.f4a;
import com.baidu.tieba.fh5;
import com.baidu.tieba.h5a;
import com.baidu.tieba.he5;
import com.baidu.tieba.hh5;
import com.baidu.tieba.i4a;
import com.baidu.tieba.jr4;
import com.baidu.tieba.l05;
import com.baidu.tieba.l4a;
import com.baidu.tieba.lw4;
import com.baidu.tieba.ly9;
import com.baidu.tieba.mwa;
import com.baidu.tieba.n05;
import com.baidu.tieba.n1a;
import com.baidu.tieba.o05;
import com.baidu.tieba.o4a;
import com.baidu.tieba.o95;
import com.baidu.tieba.p05;
import com.baidu.tieba.pb;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pw9;
import com.baidu.tieba.q1a;
import com.baidu.tieba.q4a;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rd;
import com.baidu.tieba.s1a;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.t1a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.te5;
import com.baidu.tieba.tx9;
import com.baidu.tieba.u45;
import com.baidu.tieba.ue5;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.uy5;
import com.baidu.tieba.ve5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.w4;
import com.baidu.tieba.wb5;
import com.baidu.tieba.wx9;
import com.baidu.tieba.xo5;
import com.baidu.tieba.xy5;
import com.baidu.tieba.xy9;
import com.baidu.tieba.y95;
import com.baidu.tieba.yb5;
import com.baidu.tieba.z2a;
import com.baidu.tieba.zv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, ly9<NewSubPbActivity>, TbRichTextView.t, f05.e, xy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId A;
    public PbModel.h B;
    public final TbRichTextView.z C;
    public tx9 D;
    public final View.OnLongClickListener E;
    public s1a F;
    public BdImage G;
    public String H;
    public mwa I;
    public p05.f J;
    public final w4 K;
    public bh5 L;
    public CustomMessageListener M;
    public NewWriteModel.d N;
    public View.OnClickListener O;
    public ah5 P;
    public final jr4.a Q;
    public PbModel a;
    public h5a b;
    public xy9 c;
    public z2a d;
    public b3a e;
    public boolean f;
    public boolean g;
    public n05 h;
    public p05 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public u45 l;
    public AgreeMessageData m;
    public ForumManageModel n;
    public e5b o;
    public fh5 p;
    public eh5 q;
    public boolean r;
    public q1a s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public jr4 y;
    public pb<ImageView> z;

    @Override // com.baidu.tieba.xy5
    public void D0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<TiebaPlusRecommendCard> F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    public boolean G2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xy5
    public void J0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<GifView> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<TextView> N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<ItemCardView> P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<LinearLayout> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public void Y1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public void b0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public void d0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<RelativeLayout> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<FestivalTipView> q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<View> t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048654, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.xy5
    public void x0(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048656, this, context, str, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class h implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes7.dex */
        public class a implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
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
        public class b implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
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

        public h(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.s1() != null) {
                        statisticItem.param("fid", this.a.a.s1().o());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    q1a q1aVar = this.a.s;
                    if (q1aVar != null) {
                        q1aVar.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        yb5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                        return;
                    }
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.u;
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
                    f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new a(this));
                    f05Var.setPositiveButton(R.string.open_now, new b(this));
                    f05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    if (foldCommentActivity.s != null) {
                        if (foldCommentActivity.c != null && this.a.c.w() != null && this.a.c.w().f() != null && this.a.c.w().f().A()) {
                            this.a.c.w().f().x(postWriteCallBackData);
                        }
                        this.a.s.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ j b;

            public a(j jVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    wx9.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

        public j(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public a(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
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
    public class b extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public b(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.n.getLoadDataMode();
                    if (loadDataMode != 0) {
                        if (loadDataMode == 1) {
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.c.t(1, dVar.a, dVar.b, true);
                            return;
                        }
                        return;
                    }
                    this.a.a.X1();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    this.a.q2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.c.t(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public c(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
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
    public class d implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ FoldCommentActivity b;

        public d(FoldCommentActivity foldCommentActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = foldCommentActivity;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.b.c.a0();
                MessageManager.getInstance().sendMessage(this.a);
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public e(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
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
    public class f implements bh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public f(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
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
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FoldCommentActivity foldCommentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, Integer.valueOf(i)};
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
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.q != null) {
                this.a.c.V(this.a.q.C());
            }
            this.a.c.Y(false);
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public i(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

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

        public k(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, zv9 zv9Var, String str, int i4, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), zv9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) != null) || this.a.c == null) {
                return;
            }
            this.a.c.T();
            if (z) {
                this.a.c.C();
                if (zv9Var != null) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    boolean z3 = true;
                    if (zv9Var.u() != 1) {
                        z3 = false;
                    }
                    foldCommentActivity.f = z3;
                    String str2 = null;
                    if (this.a.a != null && this.a.a.d2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.c != null) {
                        str2 = this.a.c.x();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.q.g0(TbSingleton.getInstance().getAdVertiComment(zv9Var.r0(), zv9Var.s0(), str2));
                    }
                    this.a.c.R(zv9Var, this.a.f);
                    return;
                }
                return;
            }
            this.a.N2(i, str);
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", this.a.a.M1());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof mwa) {
                        mwa mwaVar = (mwa) obj;
                        if (this.a.a == null || this.a.a.s1() == null || mwaVar.u() == null || mwaVar.L() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.w() != null) {
                            this.a.c.w().g();
                        }
                        pw9 pw9Var = new pw9();
                        pw9Var.v(this.a.a.s1().n());
                        pw9Var.z(this.a.a.s1().R());
                        pw9Var.x(mwaVar);
                        this.a.c.v().k0(pw9Var);
                        this.a.c.v().setPostId(mwaVar.U());
                        this.a.K2(view2, mwaVar.u().getUserId(), "", mwaVar);
                        TiebaStatic.log("c11743");
                        b6a.b(this.a.a.s1(), mwaVar, mwaVar.h0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.V(this.a.q.C());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091bbc && view2.getId() != R.id.obfuscated_res_0x7f091c1d) {
                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0923e6 && view2.getId() != R.id.obfuscated_res_0x7f091bba && view2.getId() != R.id.obfuscated_res_0x7f091a31) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f091c23 && view2.getId() != R.id.obfuscated_res_0x7f091df0 && view2.getId() != R.id.obfuscated_res_0x7f091bb4) {
                        if ((view2.getId() == R.id.obfuscated_res_0x7f0908bc || view2.getId() == R.id.obfuscated_res_0x7f090bc7) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof mwa)) {
                            mwa mwaVar2 = (mwa) sparseArray.get(R.id.tag_load_sub_data);
                            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                            if (mwaVar2 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0908bd);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0908be);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090bc7);
                            mwaVar2.m1(!mwaVar2.G0());
                            SkinManager.setBackgroundColor(findViewById, mwaVar2.G0() ? R.color.CAM_X0201 : R.color.transparent);
                            SkinManager.setViewTextColor(eMTextView, mwaVar2.G0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            WebPManager.setPureDrawable(imageView, mwaVar2.G0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, mwaVar2.G0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                            return;
                        }
                        return;
                    } else if (this.a.a == null) {
                        return;
                    } else {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091c23) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.M1());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091df0) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091c23 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof mwa) {
                                mwa mwaVar3 = (mwa) sparseArray2.get(R.id.tag_load_sub_data);
                                if (view2.getId() == R.id.obfuscated_res_0x7f091c23 && (statisticItem = mwaVar3.i0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091df0 || view2.getId() == R.id.obfuscated_res_0x7f091bb4) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.N1()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", mwaVar3.U()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.s1() == null || mwaVar3.u() == null || mwaVar3.L() == 1) {
                                    return;
                                }
                                if (this.a.c.w() != null) {
                                    this.a.c.w().g();
                                }
                                pw9 pw9Var2 = new pw9();
                                pw9Var2.v(this.a.a.s1().n());
                                pw9Var2.z(this.a.a.s1().R());
                                pw9Var2.x(mwaVar3);
                                this.a.c.v().k0(pw9Var2);
                                this.a.c.v().setPostId(mwaVar3.U());
                                this.a.K2(view2, mwaVar3.u().getUserId(), "", mwaVar3);
                                if (this.a.q != null) {
                                    this.a.c.V(this.a.q.C());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091a31) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.M1());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f091bba || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    if (!this.a.checkUpIsLogin()) {
                        b6a.u("c10517", this.a.a.s1().o(), 3);
                    } else if (this.a.a == null || this.a.a.s1() == null) {
                    } else {
                        this.a.c.s();
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        mwa mwaVar4 = (mwa) sparseArray3.get(R.id.tag_load_sub_data);
                        mwa mwaVar5 = (mwa) sparseArray3.get(R.id.tag_load_sub_reply_data);
                        View view4 = (View) sparseArray3.get(R.id.tag_load_sub_view);
                        if (mwaVar4 == null || view4 == null) {
                            return;
                        }
                        if (mwaVar4.P() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem5 = mwaVar4.i0;
                        if (statisticItem5 != null) {
                            StatisticItem copy2 = statisticItem5.copy();
                            copy2.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091a31) {
                                copy2.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bba) {
                                copy2.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy2);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091bba && this.a.a != null && this.a.a.s1() != null && mwaVar4 != null) {
                            TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.M1()).param("fname", this.a.a.s1().p()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", mwaVar4.U()));
                        }
                        String M1 = this.a.a.M1();
                        String U = mwaVar4.U();
                        String U2 = mwaVar5 != null ? mwaVar5.U() : "";
                        int Z = this.a.a.s1() != null ? this.a.a.s1().Z() : 0;
                        this.a.E();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091fd9 && (view2.getId() != R.id.obfuscated_res_0x7f091bba || !this.a.r)) {
                            TiebaStatic.log("c11742");
                            AbsPbActivity.e P2 = this.a.P2(U);
                            if (mwaVar4 == null || this.a.a == null || this.a.a.s1() == null || P2 == null) {
                                return;
                            }
                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, this.a.r, null, false, U2, Z, mwaVar4.n0(), this.a.a.s1().f(), false, mwaVar4.u().getIconInfo(), 5).addBigImageData(P2.a, P2.b, P2.g, P2.j);
                            if (!rd.isEmpty(U2)) {
                                addBigImageData.setHighLightPostId(U2);
                                addBigImageData.setKeyIsUseSpid(true);
                            }
                            addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                            addBigImageData.setTiebaPlusData(this.a.a.X(), this.a.a.T(), this.a.a.U(), this.a.a.S(), this.a.a.Y());
                            addBigImageData.setBjhData(this.a.a.J0());
                            addBigImageData.setKeyPageStartFrom(this.a.a.r1());
                            addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                            addBigImageData.setWorksInfoData(this.a.a.R1());
                            addBigImageData.setFromFoldComment(true);
                            addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                            return;
                        }
                        AbsPbActivity.e P22 = this.a.P2(U);
                        if (this.a.a == null || this.a.a.s1() == null || P22 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, this.a.r, null, true, null, Z, mwaVar4.n0(), this.a.a.s1().f(), false, mwaVar4.u().getIconInfo(), 5).addBigImageData(P22.a, P22.b, P22.g, P22.j);
                        addBigImageData2.setKeyPageStartFrom(this.a.a.r1());
                        addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.a.a.R1());
                        addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData2.setBjhData(this.a.a.J0());
                        addBigImageData2.setTiebaPlusData(this.a.a.X(), this.a.a.T(), this.a.a.U(), this.a.a.S(), this.a.a.Y());
                        addBigImageData2.setFromFoldComment(true);
                        addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                    }
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.M1());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.s1() != null && this.a.I != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.M1()).param("fname", this.a.a.s1().p()).param("fid", this.a.a.s1().o()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.I.U()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.m2(view2);
            }
        }

        public l(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        public m(FoldCommentActivity foldCommentActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = foldCommentActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.W2(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        public n(FoldCommentActivity foldCommentActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = foldCommentActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.W2(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class o implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

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

        public o(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            q1a q1aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (q1aVar = this.a.s) != null && q1aVar.g() != null) {
                if (!this.a.s.g().e()) {
                    this.a.s.b(false);
                }
                this.a.s.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements ah5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public p(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.ah5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                q1a q1aVar = this.a.s;
                if (q1aVar != null && q1aVar.g() != null && this.a.s.g().d()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                    if (this.a.c != null && this.a.c.w() != null && this.a.c.w().f() != null && this.a.c.w().f().A()) {
                        this.a.c.w().f().x(this.a.s.h());
                    }
                    this.a.s.b(true);
                    return true;
                }
                return !this.a.h2(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q implements jr4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public q(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.jr4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                if (z) {
                    if (this.a.y != null) {
                        this.a.y.h(z2);
                    }
                    this.a.a.g3(z2);
                    if (this.a.a.d1()) {
                        this.a.L2();
                    }
                    if (z2) {
                        if (this.a.y != null) {
                            if (this.a.y.f() != null && this.a.a != null && this.a.a.s1() != null && this.a.a.s1().R() != null && this.a.a.s1().R().getAuthor() != null) {
                                MarkData f = this.a.y.f();
                                MetaData author = this.a.a.s1().R().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        if (str2 == null) {
                                            str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0100);
                                        }
                                        BdUtilHelper.showToast(str2, 2000, true);
                                        if (DialogUtil.shouldShowPushPremissionDialog(this.a.getActivity(), 0)) {
                                            DialogUtil.showPushPermissionDialog(this.a.getPageContext(), 6, 2000L);
                                        }
                                    }
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
                        this.a.c2();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                FoldCommentActivity foldCommentActivity2 = this.a;
                foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public r(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int d;
            String str2;
            ImageUrlData imageUrlData;
            String str3;
            ImageUrlData imageUrlData2;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        boolean isGif = ((TbImageView) view2).isGif();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                            return;
                        }
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    c1a.e(this.a.a, str, i, eVar);
                    if (this.a.a.s1().a()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().S() != null) {
                            ArrayList<TbRichTextImageInfo> S = tbRichTextView.getRichText().S();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < S.size()) {
                                if (S.get(i5) != null) {
                                    arrayList.add(S.get(i5).U());
                                    if (i6 == i4 && str != null && (str.equals(S.get(i5).U()) || str.equals(S.get(i5).Q()) || str.equals(S.get(i5).O()) || str.equals(S.get(i5).P()) || str.equals(S.get(i5).S()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData3 = new ImageUrlData();
                                    String U = S.get(i5).U();
                                    imageUrlData3.imageUrl = U;
                                    imageUrlData3.imageThumbUrl = U;
                                    if (this.a.f) {
                                        i3 = 17;
                                    } else {
                                        i3 = 18;
                                    }
                                    imageUrlData3.urlThumbType = i3;
                                    imageUrlData3.originalUrl = S.get(i5).U();
                                    imageUrlData3.isLongPic = S.get(i5).X();
                                    concurrentHashMap.put(S.get(i5).U(), imageUrlData3);
                                }
                                i5++;
                                i4 = -1;
                            }
                            i2 = i6;
                        } else {
                            i2 = -1;
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i2).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.E2());
                        if (this.a.a != null) {
                            builder.setFromForumId(this.a.a.getFromForumId());
                            if (this.a.a.s1() != null) {
                                builder.setThreadData(this.a.a.s1().R());
                            }
                        }
                        ImageViewerConfig bulid = builder.bulid(this.a.getPageContext().getPageActivity());
                        bulid.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (!eVar.h) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        arrayList2.add((String) ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!ListUtils.isEmpty(arrayList2) && (imageUrlData2 = eVar.b.get((str3 = arrayList2.get(0)))) != null) {
                            concurrentHashMap2.put(str3, imageUrlData2);
                        }
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.a.E1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.E2()).setBjhPostId(eVar.f).setPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.a != null) {
                            builder2.setFromForumId(this.a.a.getFromForumId());
                            if (this.a.a.s1() != null) {
                                builder2.setThreadData(this.a.a.s1().R());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = c1a.f(this.a.a, str, i);
                        if (f != null && (d = c1a.d()) >= 0 && d < f.Q().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = aw9.a(f.Q().get(d));
                            int i7 = 0;
                            while (true) {
                                if (i7 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i7).equals(a)) {
                                    eVar.j = i7;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList3) && (imageUrlData = eVar.b.get((str2 = arrayList3.get(0)))) != null) {
                                concurrentHashMap3.put(str2, imageUrlData);
                            }
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.a.E1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.E2()).setPostId(eVar.f).setBjhPostId(eVar.f);
                            if (this.a.a != null) {
                                builder3.setFromForumId(this.a.a.getFromForumId());
                                if (this.a.a.s1() != null) {
                                    builder3.setThreadData(this.a.a.s1().R());
                                }
                            }
                            ImageViewerConfig bulid3 = builder3.bulid(this.a.getPageContext().getPageActivity());
                            bulid3.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, bulid3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public s(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.q.K(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.c != null && this.a.c.w() != null && this.a.c.w().f() != null) {
                    this.a.c.w().f().J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements PbFragment.k3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public t(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.k3
        public void callback(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.a.s1().Y().getUserId());
                if (objArr.length <= 1) {
                    str = "";
                } else {
                    str = String.valueOf(objArr[1]);
                }
                if (objArr.length <= 2) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(objArr[2]);
                }
                if (objArr.length <= 3) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(objArr[3]);
                }
                if (objArr.length <= 4) {
                    str4 = "";
                } else {
                    str4 = String.valueOf(objArr[4]);
                }
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.s1().n().getId(), this.a.a.s1().n().getName(), this.a.a.s1().R().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements tx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.tx9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tx9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public u(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.tx9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ffa) {
                        if (this.a.R2(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091bb9) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.Y2((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.pb_post_header_layout) {
                        SparseArray sparseArray = null;
                        if (view2.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view2.getTag();
                        }
                        if (sparseArray != null) {
                            this.a.Y2(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (this.a.q != null) {
                    this.a.c.V(this.a.q.C());
                }
                this.a.c.Q();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class v implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public v(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.m2(view2);
        }
    }

    /* loaded from: classes7.dex */
    public class w implements p05.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public w(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.p05.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null) {
                this.a.i.s(i4a.f(this.a.I));
                ArrayList arrayList = new ArrayList();
                for (o05 o05Var : this.a.i.h()) {
                    if (o05Var instanceof l05) {
                        arrayList.add((l05) o05Var);
                    }
                }
                i4a.d(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public x(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.b3(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                        this.a.Q2(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_reply);
                        this.a.Q2(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.Q2(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view6 != null) {
                            this.a.Q2(view6);
                            AgreeView agreeView2 = (AgreeView) view6;
                            if (agreeView2.getImgAgree() != null) {
                                agreeView2.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.a.G != null && !TextUtils.isEmpty(this.a.H)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.H));
                            this.a.G = null;
                            this.a.H = null;
                            return;
                        }
                        return;
                    case 2:
                        if (this.a.G != null && !TextUtils.isEmpty(this.a.H)) {
                            if (this.a.j == null) {
                                this.a.j = new PermissionJudgePolicy();
                            }
                            this.a.j.clearRequestPermissionList();
                            this.a.j.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.j.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.F == null) {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.F = new s1a(foldCommentActivity.getPageContext());
                            }
                            this.a.F.b(this.a.H, this.a.G.getImageByte());
                            this.a.G = null;
                            this.a.H = null;
                            return;
                        }
                        return;
                    case 3:
                        mwa mwaVar = this.a.I;
                        if (mwaVar != null) {
                            mwaVar.V0();
                            this.a.I = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            if (view2 != null) {
                                this.a.M2(l4a.c(view2));
                            }
                            if (this.a.a.s1().R() != null && this.a.a.s1().R().getAuthor() != null && this.a.a.s1().R().getAuthor().getUserId() != null && this.a.y != null) {
                                int d = l4a.d(this.a.a.s1());
                                ThreadData R = this.a.a.s1().R();
                                if (R.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (R.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!R.isBJHNormalThreadType()) {
                                    if (R.isBJHVideoDynamicThreadType()) {
                                        i2 = 5;
                                    } else {
                                        i2 = 1;
                                    }
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.M1()).param("obj_locate", 2).param("obj_id", this.a.a.s1().R().getAuthor().getUserId()).param("obj_type", !this.a.y.e()).param("obj_source", d).param("obj_param1", i2));
                                return;
                            }
                            return;
                        }
                        return;
                    case 5:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.x2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.a.f2(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(R.id.tag_has_sub_post) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                            boolean Z = this.a.Z(TbadkCoreApplication.getCurrentAccount());
                            if (Z) {
                                if (booleanValue2) {
                                    this.a.c.M(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, Z);
                                    return;
                                } else {
                                    this.a.V2(sparseArray3, intValue, booleanValue);
                                    return;
                                }
                            } else if (!booleanValue || booleanValue2) {
                                this.a.c.K(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            } else {
                                this.a.V2(sparseArray3, intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue3) {
                            if (booleanValue5) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                this.a.f2(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.a.c.O(view2);
                            return;
                        } else if (booleanValue4) {
                            this.a.c.K(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    case 8:
                        if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                            return;
                        }
                        mwa mwaVar2 = (mwa) sparseArray.get(R.id.tag_clip_board);
                        if (mwaVar2.p() != null) {
                            this.a.i2(mwaVar2.p());
                            return;
                        }
                        return;
                    case 9:
                        if (this.a.checkUpIsLogin() && this.a.a != null && this.a.a.s1() != null) {
                            this.a.U2(d5b.c(view2));
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ FoldCommentActivity d;

        public y(FoldCommentActivity foldCommentActivity, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = foldCommentActivity;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                if (f05Var != null) {
                    f05Var.dismiss();
                }
                this.d.p2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    public FoldCommentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = true;
        this.r = false;
        this.w = new int[2];
        this.y = null;
        this.B = new k(this);
        this.C = new r(this);
        this.D = new tx9(new u(this));
        this.E = new v(this);
        this.I = null;
        this.J = new x(this);
        this.K = new b(this);
        this.L = new f(this);
        this.M = new g(this, 2004008);
        this.N = new h(this);
        this.O = new l(this);
        this.P = new p(this);
        this.Q = new q(this);
    }

    public void O2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.s1() == null || this.a.s1().n() == null || e2()) {
            return;
        }
        if (this.a.s1().a()) {
            this.c.r();
            return;
        }
        eh5 eh5Var = this.q;
        if (eh5Var != null && eh5Var.a() != null) {
            this.q.a().K(new he5(45, 27, null));
        }
        this.c.r();
    }

    public final boolean B2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    public final void I2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(this, "", str, false, true, true, bundle);
        }
    }

    public final void T2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.q.b0(z);
            this.q.e0(z);
            this.q.m0(z);
        }
    }

    public void U2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, str) == null) && str != null && this.o != null) {
            this.o.n(JavaTypesHelper.toLong(str, 0L));
        }
    }

    @Override // com.baidu.tieba.ly9
    public boolean Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.n2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.A);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.f05.e
    public void onClick(f05 f05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, f05Var) == null) {
            o2(f05Var, null);
        }
    }

    public final void A2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.k = getUniqueId();
            jr4 c2 = jr4.c(this);
            this.y = c2;
            if (c2 != null) {
                c2.j(this.Q);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.n = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.K);
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.B);
            } else {
                this.a = new PbModel(this, getIntent(), this.B);
            }
            this.a.b3(true);
            this.a.d3(4);
        }
    }

    public final void S2(fh5 fh5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, fh5Var) == null) && fh5Var != null && (pbModel = this.a) != null) {
            fh5Var.p(pbModel.R0());
            if (this.a.s1() != null && this.a.s1().n() != null) {
                fh5Var.o(this.a.s1().n());
            }
            fh5Var.q("pb");
            fh5Var.r(this.a);
        }
    }

    public boolean h2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            if (this.u != null && this.a.s1() != null && !ThreadCardUtils.isSelf(this.a.s1().R()) && this.a.s1().f() != null) {
                return this.u.checkPrivacyBeforeSend(this.a.s1().f().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void C2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.d = new z2a(this);
            this.e = new b3a(getPageContext());
            xy9 xy9Var = new xy9(this, this.O, this.C, this.D, this.E);
            this.c = xy9Var;
            xy9Var.X(this.a);
            setContentView(this.c.y(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.q();
            this.c.U(new t(this));
            fh5 fh5Var = new fh5();
            this.p = fh5Var;
            S2(fh5Var);
            eh5 eh5Var = (eh5) this.p.a(getActivity());
            this.q = eh5Var;
            eh5Var.a0(getPageContext());
            this.q.k0(this.L);
            this.q.c0(1);
            this.q.E(getPageContext(), bundle);
            this.q.a().c(new te5(getActivity()));
            this.q.a().M(true);
            T2(true);
            this.q.N(this.a.U0(), this.a.M1(), this.a.Q0());
            this.c.S(this.q.a());
            this.s = new q1a();
            if (this.q.v() != null) {
                this.s.m(this.q.v().k());
            }
            registerListener(this.M);
            if (!this.a.f1()) {
                this.q.t(this.a.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.d2()) {
                this.q.g0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                xy9 xy9Var2 = this.c;
                if (xy9Var2 != null) {
                    this.q.g0(xy9Var2.x());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return o4a.d(pbModel.s1());
        }
        return invokeV.booleanValue;
    }

    public final void E() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (pbModel = this.a) != null) {
            pbModel.u2();
        }
    }

    @Override // com.baidu.tieba.ly9
    public String L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.R0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            zv9 s1 = this.a.s1();
            this.a.g3(true);
            jr4 jr4Var = this.y;
            if (jr4Var != null) {
                s1.M0(jr4Var.g());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ly9
    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.m2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tieba.ly9
    public z2a o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.d;
        }
        return (z2a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            super.onDestroy();
            ReplyPrivacyCheckController replyPrivacyCheckController = this.u;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            super.onPause();
            if (this.r) {
                a3(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            super.onResume();
            if (this.r) {
                a3(true);
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<ImageView> r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (this.z == null) {
                this.z = aw9.e(getActivity());
            }
            return this.z;
        }
        return (pb) invokeV.objValue;
    }

    public PbModel s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public eh5 t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.q;
        }
        return (eh5) invokeV.objValue;
    }

    public b3a u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.e;
        }
        return (b3a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ly9
    public int z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null) {
                return this.a.s1().Z();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean H2(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null) {
                if (this.a.s1().Z() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || this.a.s1().R() == null || this.a.s1().R().getAuthor() == null || TextUtils.equals(this.a.s1().R().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                return !z;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void M2(mwa mwaVar) {
        boolean z;
        jr4 jr4Var;
        mwa r2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, mwaVar) != null) || mwaVar == null) {
            return;
        }
        if (mwaVar.U() != null && mwaVar.U().equals(this.a.n1())) {
            z = true;
        } else {
            z = false;
        }
        MarkData m1 = this.a.m1(mwaVar);
        if (this.a.s1() != null && this.a.s1().a() && (r2 = r2()) != null) {
            m1 = this.a.m1(r2);
        }
        if (m1 != null && (jr4Var = this.y) != null) {
            jr4Var.i(m1);
            if (!z) {
                this.y.a();
            } else {
                this.y.d();
            }
        }
    }

    public final void i2(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new u45();
        }
        if (this.m == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.m = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        lw4 lw4Var = new lw4();
        lw4Var.b = 5;
        lw4Var.h = 8;
        lw4Var.g = 2;
        PbModel pbModel = this.a;
        if (pbModel != null) {
            lw4Var.f = pbModel.r1();
        }
        lw4Var.a = 2;
        xo5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
        if (currentVisiblePageExtra != null) {
            agreeData.objSource = currentVisiblePageExtra.a();
        }
        this.l.c(agreeData, l4a.e(agreeData, lw4Var), getUniqueId(), false);
        this.l.d(agreeData, this.m);
        PbModel pbModel2 = this.a;
        if (pbModel2 != null && pbModel2.s1() != null) {
            this.l.b(this, lw4Var, agreeData, this.a.s1().R());
        }
    }

    public final void x2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null && this.a.s1().a()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.M1(), str);
                ThreadData R = this.a.s1().R();
                if (R.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (R.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (R.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                I2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final void K2(View view2, String str, String str2, mwa mwaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048589, this, view2, str, str2, mwaVar) != null) || view2 == null || str == null || str2 == null || !g2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.w);
            this.x = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.w() != null && mwaVar != null) {
            if (mwaVar.f0() != null) {
                str3 = mwaVar.f0().toString();
            } else {
                str3 = "";
            }
            this.c.w().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), mwaVar.u().getName_show(), str3));
        }
        if (this.a.s1() != null && this.a.s1().a()) {
            SafeHandler.getInst().postDelayed(new m(this, str, str2), 0L);
        } else {
            SafeHandler.getInst().postDelayed(new n(this, str, str2), 0L);
        }
    }

    public void p2(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(n1a.i2, Integer.valueOf(n1a.j2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                n2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void N2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i2, str) == null) {
            if (this.a.T1()) {
                showToast(str);
            } else if (BdUtilHelper.isNetOk()) {
                if (i2 == 4) {
                    xy9 xy9Var = this.c;
                    xy9Var.c0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    xy9 xy9Var2 = this.c;
                    xy9Var2.c0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.c.b0(R.string.no_data_text);
                }
            } else {
                this.c.b0(R.string.recommend_pb_no_net_text);
            }
        }
    }

    public final AbsPbActivity.e P2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            String str2 = null;
            if (this.a.s1() != null && this.a.s1().I() != null && this.a.s1().I().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 < this.a.s1().I().size()) {
                        if (str.equals(this.a.s1().I().get(i2).U())) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                mwa mwaVar = this.a.s1().I().get(i2);
                if (mwaVar.f0() != null && mwaVar.f0().Q() != null) {
                    Iterator<TbRichTextData> it = mwaVar.f0().Q().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.V() != null) {
                                str2 = next.V().Q();
                            }
                        }
                    }
                    c1a.e(this.a, str2, 0, eVar);
                    aw9.c(mwaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            B2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            A2(bundle);
            C2(bundle);
            J2();
            if (this.r) {
                this.c.y().setAnimTime(0);
                this.c.y().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.A = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.y().h();
            this.c.v().setFromForumId(this.a.getFromForumId());
            h5a h5aVar = new h5a(this);
            this.b = h5aVar;
            h5aVar.b(getUniqueId());
            this.o = new e5b(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.g0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.g0(this.c.x());
            }
            wb5.b(false);
        }
    }

    public final void Q2(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.g) {
            i2 = 2;
        } else {
            i2 = 3;
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void Y2(SparseArray<Object> sparseArray) {
        mwa mwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof mwa) || (mwaVar = (mwa) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        Z2(mwaVar, false);
    }

    public final void b3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.M1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(i4a.j(i2))));
        }
    }

    public void f2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final boolean R2(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof mwa)) {
                return false;
            }
            mwa mwaVar = (mwa) obj;
            if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.s1() != null) {
                if (this.c.w() != null) {
                    this.c.w().g();
                }
                pw9 pw9Var = new pw9();
                pw9Var.v(this.a.s1().n());
                pw9Var.z(this.a.s1().R());
                pw9Var.x(mwaVar);
                TiebaStatic.log("c11743");
                this.c.v().k0(pw9Var);
                this.c.v().setPostId(mwaVar.U());
                K2(view2, mwaVar.u().getUserId(), "", mwaVar);
                eh5 eh5Var = this.q;
                if (eh5Var != null) {
                    this.c.V(eh5Var.C());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void V2(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            i4a.c(getActivity(), getPageContext(), new y(this, sparseArray, i2, z), new a(this));
        }
    }

    public final void W2(String str, String str2) {
        int i2;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) {
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getApplicationContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
            } else {
                i2 = equipmentHeight / 2;
                dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
            }
            int i3 = equipmentHeight - (i2 + dimens);
            boolean z = true;
            this.c.u().smoothScrollBy((this.w[1] + this.x) - i3, 50);
            if (this.c.w() != null) {
                this.q.a().setVisibility(8);
                PbModel pbModel2 = this.a;
                this.c.w().t(str, str2, this.c.x(), (pbModel2 == null || pbModel2.s1() == null || this.a.s1().R() == null || !this.a.s1().R().isBjh()) ? false : false);
                hh5 f2 = this.c.w().f();
                if (f2 != null && (pbModel = this.a) != null && pbModel.s1() != null) {
                    f2.K(this.a.s1().f());
                    f2.g0(this.a.s1().R());
                }
                if (this.s.f() == null && this.c.w().f().v() != null) {
                    this.c.w().f().v().i(new o(this));
                    this.s.n(this.c.w().f().v().k());
                    this.c.w().f().Q(this.P);
                }
            }
            this.c.z();
        }
    }

    public final void Z2(mwa mwaVar, boolean z) {
        PbModel pbModel;
        int i2;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048613, this, mwaVar, z) != null) || mwaVar == null || (pbModel = this.a) == null || pbModel.s1() == null || mwaVar.L() == 1) {
            return;
        }
        String M1 = this.a.M1();
        String U = mwaVar.U();
        if (this.a.s1() != null) {
            i2 = this.a.s1().Z();
        } else {
            i2 = 0;
        }
        AbsPbActivity.e P2 = P2(U);
        if (P2 == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this);
        boolean z2 = this.r;
        SmallTailInfo n0 = mwaVar.n0();
        AntiData f2 = this.a.s1().f();
        if (mwaVar.u() != null) {
            arrayList = mwaVar.u().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, U, "pb", true, z2, null, false, null, i2, n0, f2, false, arrayList, 5).addBigImageData(P2.a, P2.b, P2.g, P2.j);
        addBigImageData.setKeyPageStartFrom(this.a.r1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.R1());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.J0());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void n2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(n1a.i2)).intValue();
            if (intValue == n1a.j2) {
                if (this.n.h0()) {
                    return;
                }
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (sparseArray.get(R.id.tag_is_block_thread) != null) {
                    z = ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue();
                } else {
                    z = false;
                }
                if (jSONArray != null) {
                    this.n.j0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.k0(this.a.s1().n().getId(), this.a.s1().n().getName(), this.a.s1().R().getId(), str, intValue3, intValue2, booleanValue, this.a.s1().R().getBaijiahaoData(), z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                br6.b().c(new y95(this.a.M1()));
            } else if (intValue == n1a.k2 || intValue == n1a.m2) {
                if (this.a.N0() != null) {
                    this.a.N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == n1a.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void q2(ForumManageModel.b bVar, boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048646, this, bVar, z) != null) || bVar == null) {
            return;
        }
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
            f05Var.setPositiveButton(R.string.dialog_known, new c(this));
            f05Var.setCancelable(true);
            f05Var.create(getPageContext());
            f05Var.show();
        } else if (bVar.d != 0) {
            this.c.t(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<mwa> I = this.a.s1().I();
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
                this.a.s1().R().setReply_num(this.a.s1().R().getReply_num() - 1);
            } else if (i3 == 0) {
                k2();
            } else if (i3 == 2) {
                ArrayList<mwa> I2 = this.a.s1().I();
                int size2 = I2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= I2.get(i4).k0().size()) {
                            break;
                        } else if (bVar.g.equals(I2.get(i4).k0().get(i5).U())) {
                            I2.get(i4).k0().remove(i5);
                            I2.get(i4).h();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    I2.get(i4).k(bVar.g);
                }
            }
        }
    }

    public final void v2(int i2, Intent intent) {
        ve5 ve5Var;
        ve5 ve5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048653, this, i2, intent) == null) {
            if (i2 == 0) {
                this.c.B();
                this.c.w().g();
                this.c.Y(false);
            }
            this.c.Q();
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
                if (editorType == 1 && this.c.w() != null && this.c.w().f() != null) {
                    hh5 f2 = this.c.w().f();
                    f2.g0(this.a.s1().R());
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
            this.q.P();
            this.q.q0(pbEditorData.getVoiceModel());
            this.q.F(writeData);
            ue5 u3 = this.q.a().u(6);
            if (u3 != null && (ve5Var = u3.m) != null) {
                ve5Var.U(new he5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.q.K(null, null);
            }
        }
    }

    public final void X2(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.a0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            f05 f05Var = new f05(this);
            if (!rd.isEmpty(str)) {
                f05Var.setMessage(str);
            } else {
                f05Var.setMessage(getResources().getString(R.string.block_mute_message_alert, str3));
            }
            f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new d(this, userMuteAddAndDelCustomMessage));
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new e(this));
            f05Var.create(getPageContext()).show();
        }
    }

    public final void c2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (pbModel = this.a) != null && pbModel.s1() != null && this.a.s1().R() != null) {
            ThreadData R = this.a.s1().R();
            R.mRecomAbTag = this.a.y1();
            R.mRecomWeight = this.a.B1();
            R.mRecomSource = this.a.A1();
            R.mRecomExtra = this.a.z1();
            R.isSubPb = this.a.f1();
            if (R.getFid() == 0) {
                R.setFid(JavaTypesHelper.toLong(this.a.getForumId(), 0L));
            }
            StatisticItem i2 = cp5.i(this, R, "c13562");
            TbPageTag l2 = cp5.l(this);
            if (l2 != null && "a008".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
            }
            if (l2 != null && "a002".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public mwa r2() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null && this.a.s1().R() != null && this.a.s1().R().getAuthor() != null) {
                mwa mwaVar = new mwa();
                MetaData author = this.a.s1().R().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = this.a.s1().R().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                mwaVar.Z0(1);
                mwaVar.f1(this.a.s1().R().getFirstPostId());
                mwaVar.x1(this.a.s1().R().getTitle());
                mwaVar.w1(this.a.s1().R().getCreateTime());
                mwaVar.T0(author);
                return mwaVar;
            }
            return null;
        }
        return (mwa) invokeV.objValue;
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.T(this.a.getForumId()) && this.a.s1() != null && this.a.s1().n() != null) {
            boolean z = true;
            if (this.a.s1().n().isLike() != 1) {
                z = false;
            }
            if (z) {
                this.a.F0().S(this.a.getForumId(), this.a.M1());
            }
        }
    }

    public final boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.s1() == null) {
                return false;
            }
            ThreadData R = this.a.s1().R();
            AntiData f2 = this.a.s1().f();
            if (!AntiHelper.b(getPageContext(), R) && !AntiHelper.d(getPageContext(), f2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if ((this.a.s1() != null && (this.a.s1().a() || ThreadCardUtils.isSelf(this.a.s1().R()))) || this.u == null || this.a.s1() == null || this.a.s1().f() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.s1().f().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.a.X0() || this.a.a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.M1());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.M1()));
            finish();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void h1(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048628, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
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

    public final boolean m2(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z;
        boolean z2;
        int i2;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            mwa mwaVar = (mwa) sparseArray.get(R.id.tag_clip_board);
            this.I = mwaVar;
            if (mwaVar == null || this.y == null) {
                return true;
            }
            if (this.i == null) {
                p05 p05Var = new p05(this);
                this.i = p05Var;
                p05Var.r(this.J);
            }
            ArrayList arrayList = new ArrayList();
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null && this.a.s1().R() != null && this.a.s1().a()) {
                z = true;
            } else {
                z = false;
            }
            if (view2 != null && sparseArray != null) {
                boolean G2 = G2(view2);
                if (G2(view2) && (bdImage = this.G) != null && !bdImage.isGif()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean b2 = o4a.b(sparseArray, R.id.tag_is_subpb, false);
                boolean b3 = o4a.b(sparseArray, R.id.tag_del_post_is_self, false);
                boolean b4 = o4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                boolean b5 = o4a.b(sparseArray, R.id.tag_should_manage_visible, false);
                boolean b6 = o4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                boolean b7 = o4a.b(sparseArray, R.id.tag_should_delete_visible, false);
                boolean b8 = o4a.b(sparseArray, R.id.tag_is_self_post, false);
                String c2 = o4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
                if (G2) {
                    arrayList.add(new l05(1, getString(R.string.save_to_emotion), this.i));
                }
                if (z2) {
                    arrayList.add(new l05(2, getString(R.string.save_to_local), this.i));
                }
                if (!G2 && !z2) {
                    l05 l05Var = new l05(3, getString(R.string.obfuscated_res_0x7f0f04f5), this.i);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, this.I);
                    l05Var.d.setTag(sparseArray2);
                    arrayList.add(l05Var);
                }
                f4a.d(this.i, b5, b4, sparseArray, arrayList, TbadkCoreApplication.isLogin(), D2());
                f4a.e(this.i, b5, b4, arrayList, z, c2, TbadkCoreApplication.isLogin(), D2(), H2(b3));
                f4a.b(this.i, sparseArray, arrayList, b3, b5, b6, b7, b8, c2, TbadkCoreApplication.isLogin(), D2());
                f4a.a(this.i, sparseArray, arrayList, b3, b5, b6, b7, b8, c2, TbadkCoreApplication.isLogin(), D2(), this.a.s1().Z());
                o4a.a(arrayList, this.i, this.I, this.a.s1(), TbadkCoreApplication.isLogin());
                List<l05> a2 = i4a.a(arrayList, this.I.p(), sparseArray, this.i);
                i4a.i(a2, this.g);
                i4a.d(a2);
                this.i.s(i4a.f(this.I));
                this.i.n(a2, true);
                this.h = new n05(getPageContext(), this.i);
                this.i.q(new w(this));
                this.h.l();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.a.M1()).param("fid", this.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.Q());
                if (b2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                TiebaStatic.log(param.param("obj_source", i2));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o2(f05 f05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, f05Var, jSONArray) == null) {
            f05Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(f05Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                n2((SparseArray) f05Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048637, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.G(i2, i3, intent);
            if (this.c.w() != null) {
                this.c.w().k(i2, i3, intent);
            }
            if (i2 == 25035) {
                v2(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 13008) {
                    if (i2 != 13011) {
                        if (i2 == 24007) {
                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                RateManager.getInstance().notifyShare(getPageContext());
                                c3();
                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                    shareSuccessReplyToServerModel.O(str, intExtra, new j(this));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    RateManager.getInstance().notifyShare(getPageContext());
                    return;
                }
                e1a.b().k();
                this.mHandler.postDelayed(new i(this), 1000L);
            }
        }
    }

    public void w2(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_msg) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
            }
            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.k);
            userMuteAddAndDelCustomMessage.setTag(this.k);
            X2(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }
}
