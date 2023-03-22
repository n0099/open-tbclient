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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.aj8;
import com.baidu.tieba.bc9;
import com.baidu.tieba.br5;
import com.baidu.tieba.dm8;
import com.baidu.tieba.ek5;
import com.baidu.tieba.g05;
import com.baidu.tieba.g95;
import com.baidu.tieba.gg;
import com.baidu.tieba.gi;
import com.baidu.tieba.hi;
import com.baidu.tieba.i05;
import com.baidu.tieba.i09;
import com.baidu.tieba.i35;
import com.baidu.tieba.j05;
import com.baidu.tieba.jg;
import com.baidu.tieba.jk8;
import com.baidu.tieba.jo8;
import com.baidu.tieba.k05;
import com.baidu.tieba.kd5;
import com.baidu.tieba.ki8;
import com.baidu.tieba.lb5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.li8;
import com.baidu.tieba.m95;
import com.baidu.tieba.mj8;
import com.baidu.tieba.mp8;
import com.baidu.tieba.ne5;
import com.baidu.tieba.nj9;
import com.baidu.tieba.nw4;
import com.baidu.tieba.o95;
import com.baidu.tieba.od5;
import com.baidu.tieba.oj9;
import com.baidu.tieba.om8;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pj8;
import com.baidu.tieba.pv4;
import com.baidu.tieba.qd5;
import com.baidu.tieba.rb9;
import com.baidu.tieba.rm;
import com.baidu.tieba.rm8;
import com.baidu.tieba.sd5;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.so8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tm8;
import com.baidu.tieba.tn8;
import com.baidu.tieba.um8;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.vb5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vn8;
import com.baidu.tieba.vt5;
import com.baidu.tieba.wb5;
import com.baidu.tieba.x75;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xf;
import com.baidu.tieba.xj8;
import com.baidu.tieba.xs4;
import com.baidu.tieba.yf;
import com.baidu.tieba.yt5;
import com.baidu.tieba.z8;
import com.baidu.tieba.zj5;
import com.baidu.tieba.zz4;
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
/* loaded from: classes5.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, xj8<NewSubPbActivity>, TbRichTextView.u, zz4.e, yt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId A;
    public PbModel.h B;
    public View C;
    public int D;
    public final TbRichTextView.a0 E;
    public boolean F;
    public mj8 G;
    public final View.OnLongClickListener H;
    public tm8 I;
    public rm J;
    public String K;
    public TbRichTextMemeInfo L;
    public bc9 M;
    public k05.f N;
    public Object O;
    public final z8 P;
    public ld5 Q;
    public CustomMessageListener R;
    public NewWriteModel.d S;
    public View.OnClickListener T;
    public kd5 U;
    public final xs4.a V;
    public PbModel a;
    public so8 b;
    public jk8 c;
    public tn8 d;
    public vn8 e;
    public boolean f;
    public boolean g;
    public i05 h;
    public k05 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public i35 l;
    public rb9 m;
    public ForumManageModel n;
    public oj9 o;
    public qd5 p;
    public od5 q;
    public boolean r;
    public rm8 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public xs4 y;
    public xf<ImageView> z;

    @Override // com.baidu.tieba.yt5
    public xf<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<TiebaPlusRecommendCard> D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yt5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yt5
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, str) == null) {
        }
    }

    public boolean O2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<RelativeLayout> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<FestivalTipView> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<View> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public void X(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yt5
    public void Y(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048615, this, context, str, z) == null) {
        }
    }

    @Override // com.baidu.tieba.yt5
    public xf<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public void e0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048625, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yt5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yt5
    public xf<ItemCardView> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.yt5
    public xf<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class h implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes5.dex */
        public class a implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x75 x75Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, x75Var, writeData, antiData}) == null) {
                if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.w1() != null) {
                        statisticItem.param("fid", this.a.a.w1().m());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.Q1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    rm8 rm8Var = this.a.s;
                    if (rm8Var != null) {
                        rm8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        o95.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    if (gi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    zz4 zz4Var = new zz4(this.a.getActivity());
                    if (gi.isEmpty(postWriteCallBackData.getErrorString())) {
                        zz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        zz4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new a(this));
                    zz4Var.setPositiveButton(R.string.open_now, new b(this));
                    zz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    if (foldCommentActivity.s != null) {
                        if (foldCommentActivity.c != null && this.a.c.y() != null && this.a.c.y().f() != null && this.a.c.y().f().y()) {
                            this.a.c.y().f().w(postWriteCallBackData);
                        }
                        this.a.s.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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
                    pj8.a(this.b.a.getPageContext(), this.a).show();
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
                jg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

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

            public a(m mVar) {
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

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                rm8 rm8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (rm8Var = this.a.c.s) != null && rm8Var.g() != null) {
                    if (!this.a.c.s.g().e()) {
                        this.a.c.s.b(false);
                    }
                    this.a.c.s.g().l(false);
                }
            }
        }

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
            int i;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = hi.j(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = hi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = hi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i2, 50);
                if (this.c.c.y() != null) {
                    this.c.q.b().setVisibility(8);
                    this.c.c.y().t(this.a, this.b, this.c.c.z(), (this.c.a == null || this.c.a.w1() == null || this.c.a.w1().Q() == null || !this.c.a.w1().Q().isBjh()) ? false : false);
                    sd5 f = this.c.c.y().f();
                    if (f != null && this.c.a != null && this.c.a.w1() != null) {
                        f.H(this.c.a.w1().d());
                        f.d0(this.c.a.w1().Q());
                    }
                    if (this.c.s.f() == null && this.c.c.y().f().u() != null) {
                        this.c.c.y().f().u().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.y().f().u().i());
                        this.c.c.y().f().N(this.c.U);
                    }
                }
                this.c.c.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

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

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                rm8 rm8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (rm8Var = this.a.c.s) != null && rm8Var.g() != null) {
                    if (!this.a.c.s.g().e()) {
                        this.a.c.s.b(false);
                    }
                    this.a.c.s.g().l(false);
                }
            }
        }

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
            int i;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = hi.j(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = j / 2;
                    g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i2 = j - (i + g);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i2, 50);
                if (this.c.c.y() != null) {
                    this.c.q.b().setVisibility(8);
                    this.c.c.y().t(this.a, this.b, this.c.c.z(), (this.c.a == null || this.c.a.w1() == null || this.c.a.w1().Q() == null || !this.c.a.w1().Q().isBjh()) ? false : false);
                    sd5 f = this.c.c.y().f();
                    if (f != null && this.c.a != null && this.c.a.w1() != null) {
                        f.H(this.c.a.w1().d());
                        f.d0(this.c.a.w1().Q());
                    }
                    if (this.c.s.f() == null && this.c.c.y().f().u() != null) {
                        this.c.c.y().f().u().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.y().f().u().i());
                        this.c.c.y().f().N(this.c.U);
                    }
                }
                this.c.c.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends z8 {
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

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.n.getLoadDataMode();
                    if (loadDataMode != 0) {
                        if (loadDataMode == 1) {
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.c.v(1, dVar.a, dVar.b, true);
                            return;
                        }
                        return;
                    }
                    this.a.a.b2();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    this.a.u2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.c.v(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) && zz4Var != null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.b.c.d0();
                MessageManager.getInstance().sendMessage(this.a);
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ld5 {
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

        @Override // com.baidu.tieba.ld5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.c.W(this.a.q.y());
            }
            this.a.c.a0(false);
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        public void b(ki8 ki8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki8Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, ki8 ki8Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ki8Var, str, Integer.valueOf(i4)}) != null) || this.a.c == null) {
                return;
            }
            this.a.c.U();
            if (z) {
                this.a.c.E();
                if (ki8Var != null) {
                    if (ki8Var.s() == 1) {
                        this.a.f = true;
                    } else {
                        this.a.f = false;
                    }
                    String str2 = null;
                    if (this.a.a != null && this.a.a.h2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.c != null) {
                        str2 = this.a.c.z();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.q.c0(TbSingleton.getInstance().getAdVertiComment(ki8Var.r0(), ki8Var.s0(), str2));
                    }
                    this.a.c.S(ki8Var, this.a.f);
                    return;
                }
                return;
            }
            this.a.W2(i, str);
        }
    }

    /* loaded from: classes5.dex */
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
                statisticItem2.param("tid", this.a.a.Q1());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof bc9) {
                        bc9 bc9Var = (bc9) obj;
                        if (this.a.a == null || this.a.a.w1() == null || bc9Var.r() == null || bc9Var.E() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.y() != null) {
                            this.a.c.y().g();
                        }
                        aj8 aj8Var = new aj8();
                        aj8Var.A(this.a.a.w1().l());
                        aj8Var.E(this.a.a.w1().Q());
                        aj8Var.C(bc9Var);
                        this.a.c.x().n0(aj8Var);
                        this.a.c.x().setPostId(bc9Var.O());
                        this.a.S2(view2, bc9Var.r().getUserId(), "", bc9Var);
                        TiebaStatic.log("c11743");
                        mp8.b(this.a.a.w1(), bc9Var, bc9Var.d0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.W(this.a.q.y());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09199f && view2.getId() != R.id.obfuscated_res_0x7f0919f7) {
                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09217d && view2.getId() != R.id.obfuscated_res_0x7f09199d && view2.getId() != R.id.obfuscated_res_0x7f091824) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f0919fd && view2.getId() != R.id.obfuscated_res_0x7f091bde && view2.getId() != R.id.obfuscated_res_0x7f091997) {
                        if ((view2.getId() == R.id.obfuscated_res_0x7f09082e || view2.getId() == R.id.obfuscated_res_0x7f090b04) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof bc9)) {
                            bc9 bc9Var2 = (bc9) sparseArray.get(R.id.tag_load_sub_data);
                            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                            if (bc9Var2 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09082f);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090830);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b04);
                            if (bc9Var2.v0()) {
                                bc9Var2.W0(false);
                            } else {
                                bc9Var2.W0(true);
                            }
                            SkinManager.setBackgroundColor(findViewById, bc9Var2.v0() ? R.color.CAM_X0201 : R.color.transparent);
                            SkinManager.setViewTextColor(eMTextView, bc9Var2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            WebPManager.setPureDrawable(imageView, bc9Var2.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, bc9Var2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                            return;
                        }
                        return;
                    } else if (this.a.a == null) {
                        return;
                    } else {
                        if (view2.getId() == R.id.obfuscated_res_0x7f0919fd) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.Q1());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091bde) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0919fd && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof bc9) {
                                bc9 bc9Var3 = (bc9) sparseArray2.get(R.id.tag_load_sub_data);
                                if (view2.getId() == R.id.obfuscated_res_0x7f0919fd && (statisticItem = bc9Var3.e0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091bde || view2.getId() == R.id.obfuscated_res_0x7f091997) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.R1()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var3.O()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.w1() == null || bc9Var3.r() == null || bc9Var3.E() == 1) {
                                    return;
                                }
                                if (this.a.c.y() != null) {
                                    this.a.c.y().g();
                                }
                                aj8 aj8Var2 = new aj8();
                                aj8Var2.A(this.a.a.w1().l());
                                aj8Var2.E(this.a.a.w1().Q());
                                aj8Var2.C(bc9Var3);
                                this.a.c.x().n0(aj8Var2);
                                this.a.c.x().setPostId(bc9Var3.O());
                                this.a.S2(view2, bc9Var3.r().getUserId(), "", bc9Var3);
                                if (this.a.q != null) {
                                    this.a.c.W(this.a.q.y());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091824) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.Q1());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f09199d || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    if (!this.a.checkUpIsLogin()) {
                        mp8.r("c10517", this.a.a.w1().m(), 3);
                    } else if (this.a.a == null || this.a.a.w1() == null) {
                    } else {
                        this.a.c.u();
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        bc9 bc9Var4 = (bc9) sparseArray3.get(R.id.tag_load_sub_data);
                        bc9 bc9Var5 = (bc9) sparseArray3.get(R.id.tag_load_sub_reply_data);
                        View view4 = (View) sparseArray3.get(R.id.tag_load_sub_view);
                        if (bc9Var4 == null || view4 == null) {
                            return;
                        }
                        if (bc9Var4.J() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem5 = bc9Var4.e0;
                        if (statisticItem5 != null) {
                            StatisticItem copy2 = statisticItem5.copy();
                            copy2.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091824) {
                                copy2.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f09199d) {
                                copy2.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy2);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f09199d && this.a.a != null && this.a.a.w1() != null && bc9Var4 != null) {
                            TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.Q1()).param("fname", this.a.a.w1().n()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var4.O()));
                        }
                        String Q1 = this.a.a.Q1();
                        String O = bc9Var4.O();
                        String O2 = bc9Var5 != null ? bc9Var5.O() : "";
                        int Y = this.a.a.w1() != null ? this.a.a.w1().Y() : 0;
                        this.a.M();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091da9) {
                            if (view2.getId() != R.id.obfuscated_res_0x7f09199d || !this.a.r) {
                                TiebaStatic.log("c11742");
                                AbsPbActivity.e Z2 = this.a.Z2(O);
                                if (bc9Var4 == null || this.a.a == null || this.a.a.w1() == null || Z2 == null) {
                                    return;
                                }
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(Q1, O, "pb", true, this.a.r, null, false, O2, Y, bc9Var4.g0(), this.a.a.w1().d(), false, bc9Var4.r().getIconInfo(), 5).addBigImageData(Z2.a, Z2.b, Z2.g, Z2.j);
                                if (!gi.isEmpty(O2)) {
                                    addBigImageData.setHighLightPostId(O2);
                                    addBigImageData.setKeyIsUseSpid(true);
                                }
                                addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                                addBigImageData.setTiebaPlusData(this.a.a.a0(), this.a.a.W(), this.a.a.X(), this.a.a.V(), this.a.a.b0());
                                addBigImageData.setBjhData(this.a.a.O0());
                                addBigImageData.setKeyPageStartFrom(this.a.a.v1());
                                addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                                addBigImageData.setWorksInfoData(this.a.a.V1());
                                addBigImageData.setFromFoldComment(true);
                                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            AbsPbActivity.e Z22 = this.a.Z2(O);
                            if (this.a.a == null || this.a.a.w1() == null || Z22 == null) {
                                return;
                            }
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(Q1, O, "pb", true, this.a.r, null, true, null, Y, bc9Var4.g0(), this.a.a.w1().d(), false, bc9Var4.r().getIconInfo(), 5).addBigImageData(Z22.a, Z22.b, Z22.g, Z22.j);
                            addBigImageData2.setKeyPageStartFrom(this.a.a.v1());
                            addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.a.a.V1());
                            addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                            addBigImageData2.setBjhData(this.a.a.O0());
                            addBigImageData2.setTiebaPlusData(this.a.a.a0(), this.a.a.W(), this.a.a.X(), this.a.a.V(), this.a.a.b0());
                            addBigImageData2.setFromFoldComment(true);
                            addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                            return;
                        }
                        AbsPbActivity.e Z23 = this.a.Z2(O);
                        if (this.a.a == null || this.a.a.w1() == null || Z23 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(Q1, O, "pb", true, this.a.r, null, true, null, Y, bc9Var4.g0(), this.a.a.w1().d(), false, bc9Var4.r().getIconInfo(), 5).addBigImageData(Z23.a, Z23.b, Z23.g, Z23.j);
                        addBigImageData3.setKeyPageStartFrom(this.a.a.v1());
                        addBigImageData3.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.a.a.V1());
                        addBigImageData3.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData3.setBjhData(this.a.a.O0());
                        addBigImageData3.setTiebaPlusData(this.a.a.a0(), this.a.a.W(), this.a.a.X(), this.a.a.V(), this.a.a.b0());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.Q1());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.w1() != null && this.a.M != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.Q1()).param("fname", this.a.a.w1().n()).param("fid", this.a.a.w1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.M.O()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.q2(view2);
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

    /* loaded from: classes5.dex */
    public class o implements kd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

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

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                rm8 rm8Var = this.a.s;
                if (rm8Var != null && rm8Var.g() != null && this.a.s.g().d()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                    if (this.a.c != null && this.a.c.y() != null && this.a.c.y().f() != null && this.a.c.y().f().y()) {
                        this.a.c.y().f().w(this.a.s.h());
                    }
                    this.a.s.b(true);
                    return true;
                } else if (!this.a.n2(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p implements xs4.a {
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

        @Override // com.baidu.tieba.xs4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.y != null) {
                        this.a.y.h(z2);
                    }
                    this.a.a.q3(z2);
                    if (this.a.a.h1()) {
                        this.a.T2();
                    }
                    if (z2) {
                        if (this.a.y != null) {
                            if (this.a.y.f() != null && this.a.a != null && this.a.a.w1() != null && this.a.a.w1().Q() != null && this.a.a.w1().Q().getAuthor() != null) {
                                MarkData f = this.a.y.f();
                                MetaData author = this.a.a.w1().Q().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d5);
                                        if (g95.g(this.a.getActivity(), 0)) {
                                            g95.h(this.a.getPageContext(), 6, 2000L);
                                        }
                                    }
                                } else {
                                    FoldCommentActivity foldCommentActivity = this.a;
                                    foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.i2();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements yf<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
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
                    if (pv4.c().g()) {
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = pv4.c().g();
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

    /* loaded from: classes5.dex */
    public class r implements TbRichTextView.a0 {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.a0
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        boolean y = ((TbImageView) view2).y();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, y)));
                        }
                        this.a.C = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.X2(str, i, eVar);
                    if (this.a.a.w1().l0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i3 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().V() != null) {
                            ArrayList<TbRichTextImageInfo> V = tbRichTextView.getRichText().V();
                            int i4 = 0;
                            int i5 = -1;
                            while (i4 < V.size()) {
                                if (V.get(i4) != null) {
                                    arrayList.add(V.get(i4).getSrc());
                                    if (i5 == i3 && str != null && (str.equals(V.get(i4).getSrc()) || str.equals(V.get(i4).S()) || str.equals(V.get(i4).R()) || str.equals(V.get(i4).getBigSrc()) || str.equals(V.get(i4).U()))) {
                                        i5 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = V.get(i4).getSrc();
                                    imageUrlData.originalUrl = V.get(i4).getSrc();
                                    imageUrlData.isLongPic = V.get(i4).Y();
                                    concurrentHashMap.put(V.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = -1;
                            }
                            i2 = i5;
                        } else {
                            i2 = -1;
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i2);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.a.H1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.N2());
                        if (this.a.a != null) {
                            builder.D(this.a.a.getFromForumId());
                            if (this.a.a.w1() != null) {
                                builder.Q(this.a.a.w1().Q());
                            }
                        }
                        ImageViewerConfig x = builder.x(this.a.getPageContext().getPageActivity());
                        x.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (!eVar.h) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList2)) {
                            String str2 = (String) arrayList2.get(0);
                            concurrentHashMap2.put(str2, eVar.b.get(str2));
                        }
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList2);
                        builder2.C(eVar.c);
                        builder2.B(eVar.d);
                        builder2.R(eVar.e);
                        builder2.F(eVar.g);
                        builder2.K(true);
                        builder2.M(eVar.a.get(0));
                        builder2.I(this.a.a.H1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.N2());
                        builder2.z(eVar.f);
                        builder2.O(eVar.f);
                        builder2.G(false);
                        if (this.a.a != null) {
                            builder2.D(this.a.a.getFromForumId());
                            if (this.a.a.w1() != null) {
                                builder2.Q(this.a.a.w1().Q());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText m3 = this.a.m3(str, i);
                        if (m3 != null && this.a.D >= 0 && this.a.D < m3.T().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = li8.a(m3.T().get(this.a.D));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i6).equals(a)) {
                                    eVar.j = i6;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList3)) {
                                String str3 = arrayList3.get(0);
                                concurrentHashMap3.put(str3, eVar.b.get(str3));
                            }
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.a.H1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.N2());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a != null) {
                                builder3.D(this.a.a.getFromForumId());
                                if (this.a.a.w1() != null) {
                                    builder3.Q(this.a.a.w1().Q());
                                }
                            }
                            ImageViewerConfig x3 = builder3.x(this.a.getPageContext().getPageActivity());
                            x3.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, x3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    this.a.q.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.c != null && this.a.c.y() != null && this.a.c.y().f() != null) {
                    this.a.c.y().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements PbFragment.h3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
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
                String valueOf = String.valueOf(this.a.a.w1().X().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.w1().l().getId(), this.a.a.w1().l().getName(), this.a.a.w1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements mj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.mj8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.mj8.a
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

        @Override // com.baidu.tieba.mj8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091dc7) {
                        if (this.a.b3(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09199c) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.h3((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.pb_post_header_layout) {
                        SparseArray sparseArray = null;
                        if (view2.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view2.getTag();
                        }
                        if (sparseArray != null) {
                            this.a.h3(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (this.a.q != null) {
                    this.a.c.W(this.a.q.y());
                }
                this.a.c.R();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            return this.a.q2(view2);
        }
    }

    /* loaded from: classes5.dex */
    public class w implements k05.d {
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

        @Override // com.baidu.tieba.k05.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null) {
                this.a.i.q(jo8.h(this.a.M));
                ArrayList arrayList = new ArrayList();
                for (j05 j05Var : this.a.i.g()) {
                    if (j05Var instanceof g05) {
                        arrayList.add((g05) j05Var);
                    }
                }
                jo8.f(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements k05.f {
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

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.k3(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                        this.a.a3(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_reply);
                        this.a.a3(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.a3(view5);
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
                            this.a.a3(view6);
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
                        if (this.a.J != null && !TextUtils.isEmpty(this.a.K)) {
                            if (this.a.L == null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.K));
                            } else {
                                ne5.a aVar = new ne5.a();
                                aVar.a = this.a.K;
                                String str = "";
                                if (this.a.L.memeInfo.pck_id.intValue() >= 0) {
                                    str = "" + this.a.L.memeInfo.pck_id;
                                }
                                aVar.b = str;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                            }
                            this.a.J = null;
                            this.a.K = null;
                            return;
                        }
                        return;
                    case 2:
                        if (this.a.J != null && !TextUtils.isEmpty(this.a.K)) {
                            if (this.a.j == null) {
                                this.a.j = new PermissionJudgePolicy();
                            }
                            this.a.j.clearRequestPermissionList();
                            this.a.j.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.j.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.I == null) {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.I = new tm8(foldCommentActivity.getPageContext());
                            }
                            this.a.I.b(this.a.K, this.a.J.n());
                            this.a.J = null;
                            this.a.K = null;
                            return;
                        }
                        return;
                    case 3:
                        bc9 bc9Var = this.a.M;
                        if (bc9Var != null) {
                            bc9Var.H0();
                            this.a.M = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.U2(view2);
                            if (this.a.a.w1().Q() != null && this.a.a.w1().Q().getAuthor() != null && this.a.a.w1().Q().getAuthor().getUserId() != null && this.a.y != null) {
                                FoldCommentActivity foldCommentActivity2 = this.a;
                                int G2 = foldCommentActivity2.G2(foldCommentActivity2.a.w1());
                                ThreadData Q = this.a.a.w1().Q();
                                if (Q.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (Q.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!Q.isBJHNormalThreadType()) {
                                    if (Q.isBJHVideoDynamicThreadType()) {
                                        i2 = 5;
                                    } else {
                                        i2 = 1;
                                    }
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.Q1()).param("obj_locate", 2).param("obj_id", this.a.a.w1().Q().getAuthor().getUserId()).param("obj_type", !this.a.y.e()).param("obj_source", G2).param("obj_param1", i2));
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
                            this.a.J2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.a.l2(sparseArray2);
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
                            boolean G = this.a.G(TbadkCoreApplication.getCurrentAccount());
                            if (G) {
                                if (booleanValue2) {
                                    this.a.c.N(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
                                    return;
                                } else {
                                    this.a.f3(sparseArray3, intValue, booleanValue);
                                    return;
                                }
                            } else if (!booleanValue || booleanValue2) {
                                this.a.c.L(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            } else {
                                this.a.f3(sparseArray3, intValue, booleanValue);
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
                                this.a.l2(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.a.c.P(view2);
                            return;
                        } else if (booleanValue4) {
                            this.a.c.L(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    case 8:
                        if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                            return;
                        }
                        bc9 bc9Var2 = (bc9) sparseArray.get(R.id.tag_clip_board);
                        if (bc9Var2.o() != null) {
                            this.a.o2(bc9Var2.o());
                            return;
                        }
                        return;
                    case 9:
                        if (this.a.checkUpIsLogin() && this.a.a != null && this.a.a.w1() != null) {
                            this.a.e3(nj9.c(view2));
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                if (zz4Var != null) {
                    zz4Var.dismiss();
                }
                this.d.t2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
        this.D = 0;
        this.E = new r(this);
        this.F = false;
        this.G = new mj8(new u(this));
        this.H = new v(this);
        this.M = null;
        this.N = new x(this);
        this.P = new b(this);
        this.Q = new f(this);
        this.R = new g(this, 2004008);
        this.S = new h(this);
        this.T = new l(this);
        this.U = new o(this);
        this.V = new p(this);
    }

    public void Y2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.w1() == null || this.a.w1().l() == null || k2()) {
            return;
        }
        if (this.a.w1().l0()) {
            this.c.t();
            return;
        }
        od5 od5Var = this.q;
        if (od5Var != null && od5Var.b() != null) {
            this.q.b().C(new lb5(45, 27, null));
        }
        this.c.t();
    }

    public final boolean A2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return false;
            }
            return tbRichTextData.Z().Z();
        }
        return invokeL.booleanValue;
    }

    public final String C2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return null;
            }
            return tbRichTextData.Z().U();
        }
        return (String) invokeL.objValue;
    }

    public final long D2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return 0L;
            }
            return tbRichTextData.Z().getOriginalSize();
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.xj8
    public boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean L2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    public final void Q2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void U2(View view2) {
        SparseArray sparseArray;
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            V2(bc9Var);
        }
    }

    public final void d3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.q.X(z);
            this.q.a0(z);
            this.q.i0(z);
        }
    }

    public void e3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, str) == null) && str != null && this.o != null) {
            this.o.n(gg.g(str, 0L));
        }
    }

    public void j3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.A);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.zz4.e
    public void onClick(zz4 zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, zz4Var) == null) {
            s2(zz4Var, null);
        }
    }

    public final boolean z2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return false;
            }
            return tbRichTextData.Z().Y();
        }
        return invokeL.booleanValue;
    }

    public PbModel B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public od5 E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.q;
        }
        return (od5) invokeV.objValue;
    }

    public vn8 F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (vn8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public tn8 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (tn8) invokeV.objValue;
    }

    public final void M() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.Z0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (pbModel = this.a) != null) {
            pbModel.B2();
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ki8 w1 = this.a.w1();
            this.a.q3(true);
            xs4 xs4Var = this.y;
            if (xs4Var != null) {
                w1.L0(xs4Var.g());
            }
        }
    }

    @Override // com.baidu.tieba.yt5
    public xf<ImageView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.z == null) {
                this.z = new xf<>(new q(this), 8, 0);
            }
            return this.z;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.V0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.w1() != null) {
                return this.a.w1().Y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            super.onPause();
            if (this.r) {
                j3(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            super.onResume();
            if (this.r) {
                j3(true);
            }
        }
    }

    public AntiData v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.w1() != null) {
                return this.a.w1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.r2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void C0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048579, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (vt5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), vt5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (um8.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new br5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final int G2(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ki8Var)) == null) {
            if (ki8Var != null && ki8Var.Q() != null) {
                if (ki8Var.Q().getThreadType() == 0) {
                    return 1;
                }
                if (ki8Var.Q().getThreadType() == 54) {
                    return 2;
                }
                if (ki8Var.Q().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void a3(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, view2) != null) || view2 == null) {
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

    public final void h3(SparseArray<Object> sparseArray) {
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048633, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof bc9) || (bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        i3(bc9Var, false);
    }

    public final void k3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.Q1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(jo8.n(i2))));
        }
    }

    public void l2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = gg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = gg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.O = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void H2(int i2, Intent intent) {
        xb5 xb5Var;
        xb5 xb5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, intent) == null) {
            if (i2 == 0) {
                this.c.D();
                this.c.y().g();
                this.c.a0(false);
            }
            this.c.R();
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
                if (editorType == 1 && this.c.y() != null && this.c.y().f() != null) {
                    sd5 f2 = this.c.y().f();
                    f2.d0(this.a.w1().Q());
                    f2.C(writeData);
                    f2.e0(pbEditorData.getVoiceModel());
                    wb5 p2 = f2.b().p(6);
                    if (p2 != null && (xb5Var2 = p2.m) != null) {
                        xb5Var2.C(new lb5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.q.L();
            this.q.m0(pbEditorData.getVoiceModel());
            this.q.B(writeData);
            wb5 p3 = this.q.b().p(6);
            if (p3 != null && (xb5Var = p3.m) != null) {
                xb5Var.C(new lb5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.q.G(null, null);
            }
        }
    }

    public final void i3(bc9 bc9Var, boolean z) {
        PbModel pbModel;
        int i2;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048636, this, bc9Var, z) != null) || bc9Var == null || (pbModel = this.a) == null || pbModel.w1() == null || bc9Var.E() == 1) {
            return;
        }
        String Q1 = this.a.Q1();
        String O = bc9Var.O();
        if (this.a.w1() != null) {
            i2 = this.a.w1().Y();
        } else {
            i2 = 0;
        }
        AbsPbActivity.e Z2 = Z2(O);
        if (Z2 == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this);
        boolean z2 = this.r;
        SmallTailInfo g0 = bc9Var.g0();
        AntiData d2 = this.a.w1().d();
        if (bc9Var.r() != null) {
            arrayList = bc9Var.r().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(Q1, O, "pb", true, z2, null, false, null, i2, g0, d2, false, arrayList, 5).addBigImageData(Z2.a, Z2.b, Z2.g, Z2.j);
        addBigImageData.setKeyPageStartFrom(this.a.v1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.V1());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.O0());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void r2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(om8.p2)).intValue();
            if (intValue == om8.q2) {
                if (this.n.k0()) {
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
                    this.n.m0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.n0(this.a.w1().l().getId(), this.a.w1().l().getName(), this.a.w1().Q().getId(), str, intValue3, intValue2, booleanValue, this.a.w1().Q().getBaijiahaoData(), z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == om8.r2 || intValue == om8.t2) {
                if (this.a.R0() != null) {
                    this.a.R0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == om8.r2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void u2(ForumManageModel.b bVar, boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048660, this, bVar, z) != null) || bVar == null) {
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
            zz4 zz4Var = new zz4(getPageContext().getPageActivity());
            zz4Var.setMessage(string);
            zz4Var.setPositiveButton(R.string.dialog_known, new c(this));
            zz4Var.setCancelable(true);
            zz4Var.create(getPageContext());
            zz4Var.show();
        } else if (bVar.d != 0) {
            this.c.v(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<bc9> H = this.a.w1().H();
                int size = H.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.g.equals(H.get(i2).O())) {
                        H.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.a.w1().Q().setReply_num(this.a.w1().Q().getReply_num() - 1);
            } else if (i3 == 0) {
                p2();
            } else if (i3 == 2) {
                ArrayList<bc9> H2 = this.a.w1().H();
                int size2 = H2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= H2.get(i4).d0().size()) {
                            break;
                        } else if (bVar.g.equals(H2.get(i4).d0().get(i5).O())) {
                            H2.get(i4).d0().remove(i5);
                            H2.get(i4).j();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    H2.get(i4).k(bVar.g);
                }
            }
        }
    }

    public void I2(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
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
            g3(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048648, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.C(i2, i3, intent);
            if (this.c.y() != null) {
                this.c.y().k(i2, i3, intent);
            }
            if (i2 == 25035) {
                H2(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 13008) {
                    if (i2 != 13011) {
                        if (i2 == 24007) {
                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                i09.g().m(getPageContext());
                                l3();
                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                    shareSuccessReplyToServerModel.R(str, intExtra, new j(this));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    i09.g().m(getPageContext());
                    return;
                }
                dm8.b().m();
                this.mHandler.postDelayed(new i(this), 1000L);
            }
        }
    }

    public final void J2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.w1() != null && this.a.w1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.Q1(), str);
                ThreadData Q = this.a.w1().Q();
                if (Q.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                Q2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final boolean P2(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.w1() != null) {
                if (this.a.w1().Y() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || this.a.w1().Q() == null || this.a.w1().Q().getAuthor() == null || TextUtils.equals(this.a.w1().Q().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void V2(bc9 bc9Var) {
        xs4 xs4Var;
        bc9 w2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, bc9Var) != null) || bc9Var == null) {
            return;
        }
        boolean z = false;
        if (bc9Var.O() != null && bc9Var.O().equals(this.a.r1())) {
            z = true;
        }
        MarkData q1 = this.a.q1(bc9Var);
        if (this.a.w1() != null && this.a.w1().l0() && (w2 = w2()) != null) {
            q1 = this.a.q1(w2);
        }
        if (q1 != null && (xs4Var = this.y) != null) {
            xs4Var.i(q1);
            if (!z) {
                this.y.a();
            } else {
                this.y.d();
            }
        }
    }

    public final void K2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            this.k = getUniqueId();
            xs4 c2 = xs4.c(this);
            this.y = c2;
            if (c2 != null) {
                c2.j(this.V);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.n = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.P);
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.B);
            } else {
                this.a = new PbModel(this, getIntent(), this.B);
            }
            this.a.l3(true);
            this.a.n3(4);
        }
    }

    public final void c3(qd5 qd5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, qd5Var) == null) && qd5Var != null && (pbModel = this.a) != null) {
            qd5Var.p(pbModel.V0());
            if (this.a.w1() != null && this.a.w1().l() != null) {
                qd5Var.o(this.a.w1().l());
            }
            qd5Var.q("pb");
            qd5Var.r(this.a);
        }
    }

    public boolean n2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048646, this, i2)) == null) {
            if (this.u != null && this.a.w1() != null && !ThreadCardUtils.isSelf(this.a.w1().Q()) && this.a.w1().d() != null) {
                return this.u.checkPrivacyBeforeSend(this.a.w1().d().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void M2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            this.d = new tn8(this);
            this.e = new vn8(getPageContext());
            jk8 jk8Var = new jk8(this, this.T, this.E, this.G, this.H);
            this.c = jk8Var;
            jk8Var.Y(this.a);
            setContentView(this.c.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.s();
            this.c.V(new t(this));
            qd5 qd5Var = new qd5();
            this.p = qd5Var;
            c3(qd5Var);
            od5 od5Var = (od5) this.p.a(getActivity());
            this.q = od5Var;
            od5Var.W(getPageContext());
            this.q.g0(this.Q);
            this.q.Y(1);
            this.q.A(getPageContext(), bundle);
            this.q.b().b(new vb5(getActivity()));
            this.q.b().E(true);
            d3(true);
            this.q.J(this.a.Y0(), this.a.Q1(), this.a.U0());
            this.c.T(this.q.b());
            this.s = new rm8();
            if (this.q.s() != null) {
                this.s.m(this.q.s().i());
            }
            registerListener(this.R);
            if (!this.a.j1()) {
                this.q.q(this.a.Q1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.h2()) {
                this.q.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                jk8 jk8Var2 = this.c;
                if (jk8Var2 != null) {
                    this.q.c0(jk8Var2.z());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    public final void S2(View view2, String str, String str2, bc9 bc9Var) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048604, this, view2, str, str2, bc9Var) != null) || view2 == null || str == null || str2 == null || !m2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.w);
            this.x = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.y() != null && bc9Var != null) {
            if (bc9Var.Z() != null) {
                str3 = bc9Var.Z().toString();
            } else {
                str3 = "";
            }
            this.c.y().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), bc9Var.r().getName_show(), str3));
        }
        if (this.a.w1() != null && this.a.w1().l0()) {
            jg.a().postDelayed(new m(this, str, str2), 0L);
        } else {
            jg.a().postDelayed(new n(this, str, str2), 0L);
        }
    }

    public void t2(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(om8.p2, Integer.valueOf(om8.q2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                r2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void W2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048611, this, i2, str) == null) {
            if (this.a.X1()) {
                showToast(str);
            } else if (hi.F()) {
                if (i2 == 4) {
                    jk8 jk8Var = this.c;
                    jk8Var.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    jk8 jk8Var2 = this.c;
                    jk8Var2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.c.f0(R.string.no_data_text);
                }
            } else {
                this.c.f0(R.string.recommend_pb_no_net_text);
            }
        }
    }

    public final void X2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048614, this, str, i2, eVar) != null) || eVar == null) {
            return;
        }
        ki8 w1 = this.a.w1();
        TbRichText m3 = m3(str, i2);
        if (m3 == null || (tbRichTextData = m3.T().get(this.D)) == null) {
            return;
        }
        eVar.f = String.valueOf(m3.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.Z().X()) {
            eVar.h = false;
            String a2 = li8.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (this.f) {
                    i4 = 17;
                } else {
                    i4 = 18;
                }
                imageUrlData.urlType = i4;
            }
            imageUrlData.originalUrl = C2(tbRichTextData);
            imageUrlData.originalUrl = C2(tbRichTextData);
            imageUrlData.originalSize = D2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = A2(tbRichTextData);
            imageUrlData.isLongPic = z2(tbRichTextData);
            imageUrlData.postId = m3.getPostId();
            imageUrlData.mIsReserver = this.a.H1();
            imageUrlData.mIsSeeHost = this.a.Z0();
            eVar.b.put(a2, imageUrlData);
            if (w1 != null) {
                if (w1.l() != null) {
                    eVar.c = w1.l().getName();
                    eVar.d = w1.l().getId();
                }
                if (w1.Q() != null) {
                    eVar.e = w1.Q().getId();
                }
                if (w1.s() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = gg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = w1.H().size();
        this.F = false;
        eVar.j = -1;
        if (w1.j() != null) {
            i3 = y2(w1.j().Z(), m3, i2, i2, eVar.a, eVar.b);
        } else {
            i3 = i2;
        }
        int i5 = i3;
        for (int i6 = 0; i6 < size; i6++) {
            bc9 bc9Var = w1.H().get(i6);
            if (bc9Var.O() == null || w1.j() == null || w1.j().O() == null || !bc9Var.O().equals(w1.j().O())) {
                i5 = y2(bc9Var.Z(), m3, i5, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (w1 != null) {
            if (w1.l() != null) {
                eVar.c = w1.l().getName();
                eVar.d = w1.l().getId();
            }
            if (w1.Q() != null) {
                eVar.e = w1.Q().getId();
            }
            if (w1.s() == 1) {
                z = true;
            }
            eVar.g = z;
        }
        eVar.j = i5;
    }

    public final AbsPbActivity.e Z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            String str2 = null;
            if (this.a.w1() != null && this.a.w1().H() != null && this.a.w1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 < this.a.w1().H().size()) {
                        if (str.equals(this.a.w1().H().get(i2).O())) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                bc9 bc9Var = this.a.w1().H().get(i2);
                if (bc9Var.Z() != null && bc9Var.Z().T() != null) {
                    Iterator<TbRichTextData> it = bc9Var.Z().T().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.Z() != null) {
                                str2 = next.Z().S();
                            }
                        }
                    }
                    X2(str2, 0, eVar);
                    li8.b(bc9Var, eVar);
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
        if (interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) {
            L2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            K2(bundle);
            M2(bundle);
            R2();
            if (this.r) {
                this.c.A().setAnimTime(0);
                this.c.A().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.A = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.A().h();
            this.c.x().setFromForumId(this.a.getFromForumId());
            so8 so8Var = new so8(this);
            this.b = so8Var;
            so8Var.b(getUniqueId());
            this.o = new oj9(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.c0(this.c.z());
            }
            m95.b(false);
        }
    }

    public final boolean b3(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof bc9)) {
                return false;
            }
            bc9 bc9Var = (bc9) obj;
            if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.w1() != null) {
                if (this.c.y() != null) {
                    this.c.y().g();
                }
                aj8 aj8Var = new aj8();
                aj8Var.A(this.a.w1().l());
                aj8Var.E(this.a.w1().Q());
                aj8Var.C(bc9Var);
                TiebaStatic.log("c11743");
                this.c.x().n0(aj8Var);
                this.c.x().setPostId(bc9Var.O());
                S2(view2, bc9Var.r().getUserId(), "", bc9Var);
                od5 od5Var = this.q;
                if (od5Var != null) {
                    this.c.W(od5Var.y());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o2(AgreeData agreeData) {
        zj5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048647, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new i35();
        }
        if (this.m == null) {
            rb9 rb9Var = new rb9();
            this.m = rb9Var;
            rb9Var.a = getUniqueId();
        }
        nw4 nw4Var = new nw4();
        nw4Var.b = 5;
        nw4Var.h = 8;
        nw4Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            nw4Var.f = pbModel2.v1();
        }
        nw4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                nw4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel == null && pbModel.w1() != null) {
                    this.l.b(this, nw4Var, agreeData, this.a.w1().Q());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            nw4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            nw4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
        if (currentVisiblePageExtra != null) {
        }
        this.l.c(agreeData, i2, getUniqueId(), false);
        this.l.d(agreeData, this.m);
        pbModel = this.a;
        if (pbModel == null) {
        }
    }

    public final void f3(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            jo8.e(getActivity(), getPageContext(), new y(this, sparseArray, i2, z), new a(this));
        }
    }

    public final void g3(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            zz4 zz4Var = new zz4(this);
            if (!gi.isEmpty(str)) {
                zz4Var.setMessage(str);
            } else {
                zz4Var.setMessage(getResources().getString(R.string.block_mute_message_alert, str3));
            }
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045e, new d(this, userMuteAddAndDelCustomMessage));
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new e(this));
            zz4Var.create(getPageContext()).show();
        }
    }

    public final void i2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (pbModel = this.a) != null && pbModel.w1() != null && this.a.w1().Q() != null) {
            ThreadData Q = this.a.w1().Q();
            Q.mRecomAbTag = this.a.B1();
            Q.mRecomWeight = this.a.E1();
            Q.mRecomSource = this.a.D1();
            Q.mRecomExtra = this.a.C1();
            Q.isSubPb = this.a.j1();
            if (Q.getFid() == 0) {
                Q.setFid(gg.g(this.a.getForumId(), 0L));
            }
            StatisticItem i2 = ek5.i(this, Q, "c13562");
            TbPageTag l2 = ek5.l(this);
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

    public bc9 w2() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.w1() != null && this.a.w1().Q() != null && this.a.w1().Q().getAuthor() != null) {
                bc9 bc9Var = new bc9();
                MetaData author = this.a.w1().Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = this.a.w1().Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                bc9Var.J0(1);
                bc9Var.P0(this.a.w1().Q().getFirstPostId());
                bc9Var.g1(this.a.w1().Q().getTitle());
                bc9Var.f1(this.a.w1().Q().getCreateTime());
                bc9Var.G0(author);
                return bc9Var;
            }
            return null;
        }
        return (bc9) invokeV.objValue;
    }

    public final void j2(ki8 ki8Var, ArrayList<bc9> arrayList) {
        List<bc9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048637, this, ki8Var, arrayList) == null) && ki8Var != null && ki8Var.V() != null && ki8Var.V().a != null && (list = ki8Var.V().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<bc9> it = arrayList.iterator();
                while (it.hasNext()) {
                    bc9 next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            bc9 bc9Var = (bc9) it2.next();
                            if (bc9Var != null && !TextUtils.isEmpty(next.O()) && !TextUtils.isEmpty(bc9Var.O()) && next.O().equals(bc9Var.O())) {
                                arrayList2.add(bc9Var);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.w1() == null) {
                return false;
            }
            ThreadData Q = this.a.w1().Q();
            AntiData d2 = this.a.w1().d();
            if (!AntiHelper.b(getPageContext(), Q) && !AntiHelper.d(getPageContext(), d2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.W(this.a.getForumId()) && this.a.w1() != null && this.a.w1().l() != null) {
            boolean z = true;
            if (this.a.w1().l().isLike() != 1) {
                z = false;
            }
            if (z) {
                this.a.J0().V(this.a.getForumId(), this.a.Q1());
            }
        }
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if ((this.a.w1() != null && (this.a.w1().l0() || ThreadCardUtils.isSelf(this.a.w1().Q()))) || this.u == null || this.a.w1() == null || this.a.w1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.w1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            if (this.a.b1() || this.a.e1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.Q1());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.Q1()));
            finish();
        }
    }

    public final TbRichText m3(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048644, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.w1() == null || str == null || i2 < 0) {
                return null;
            }
            ki8 w1 = this.a.w1();
            if (w1.j() != null) {
                ArrayList<bc9> arrayList = new ArrayList<>();
                arrayList.add(w1.j());
                tbRichText = x2(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<bc9> H = w1.H();
                j2(w1, H);
                return x2(H, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void s2(zz4 zz4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, zz4Var, jSONArray) == null) {
            zz4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(zz4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                r2((SparseArray) zz4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean q2(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        xs4 xs4Var;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        List<g05> c2;
        int i2;
        boolean z12;
        g05 g05Var;
        g05 g05Var2;
        g05 g05Var3;
        rm rmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            bc9 bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board);
            this.M = bc9Var;
            if (bc9Var == null || (xs4Var = this.y) == null) {
                return true;
            }
            if (xs4Var.e() && this.M.O() != null) {
                this.M.O().equals(this.a.r1());
            }
            if (this.i == null) {
                k05 k05Var = new k05(this);
                this.i = k05Var;
                k05Var.p(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                boolean O2 = O2(view2);
                if (O2(view2) && (rmVar = this.J) != null && !rmVar.t()) {
                    z = true;
                } else {
                    z = false;
                }
                if (sparseArray.get(R.id.tag_is_subpb) instanceof Boolean) {
                    z2 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                } else {
                    z2 = false;
                }
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                } else {
                    z3 = false;
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                } else {
                    z4 = false;
                }
                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                } else {
                    z5 = false;
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                } else {
                    z6 = false;
                }
                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                } else {
                    z7 = false;
                }
                if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                } else {
                    str = null;
                }
                if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
                } else {
                    z8 = false;
                }
                if (sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue();
                } else {
                    z9 = false;
                }
                if (O2) {
                    z10 = z2;
                    z11 = z9;
                    arrayList.add(new g05(1, getString(R.string.save_to_emotion), this.i));
                } else {
                    z10 = z2;
                    z11 = z9;
                }
                if (z) {
                    arrayList.add(new g05(2, getString(R.string.save_to_local), this.i));
                }
                if (!O2 && !z) {
                    g05 g05Var4 = new g05(3, getString(R.string.obfuscated_res_0x7f0f047b), this.i);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, this.M);
                    g05Var4.d.setTag(sparseArray2);
                    arrayList.add(g05Var4);
                }
                if (this.mIsLogin) {
                    if (!jo8.j(this.a) && !z5 && z4) {
                        g05 g05Var5 = new g05(5, getString(R.string.obfuscated_res_0x7f0f0c00), this.i);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                        sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                        sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                        sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                        sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                        sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        g05Var5.d.setTag(sparseArray3);
                        arrayList.add(g05Var5);
                    } else {
                        if (P2(z3) && TbadkCoreApplication.isLogin()) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            g05 g05Var6 = new g05(5, getString(R.string.report_text), this.i);
                            g05Var6.d.setTag(str);
                            arrayList.add(g05Var6);
                        }
                    }
                    if (z5) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                        sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                        sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                        sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                        if (!jo8.j(this.a) && z6) {
                            sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z7) {
                            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray4.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                            if (z8) {
                                g05Var = new g05(6, getString(R.string.obfuscated_res_0x7f0f04db), this.i);
                                g05Var.d.setTag(sparseArray4);
                                g05Var2 = new g05(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.i);
                                g05Var2.d.setTag(sparseArray4);
                            }
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        g05Var = null;
                        g05Var2 = new g05(7, getString(R.string.obfuscated_res_0x7f0f02f2), this.i);
                        g05Var2.d.setTag(sparseArray4);
                    } else {
                        if (z7) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray5.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                            if (this.a.w1().Y() == 1002 && !z3) {
                                g05Var3 = new g05(6, getString(R.string.report_text), this.i);
                            } else {
                                g05Var3 = new g05(6, getString(R.string.obfuscated_res_0x7f0f04db), this.i);
                            }
                            g05Var3.d.setTag(sparseArray5);
                            if (z11) {
                                new g05(13, getString(R.string.multi_delete), this.i);
                            }
                            g05Var = g05Var3;
                        } else {
                            g05Var = null;
                        }
                        g05Var2 = null;
                    }
                    if (g05Var != null) {
                        arrayList.add(g05Var);
                    }
                    if (g05Var2 != null) {
                        arrayList.add(g05Var2);
                    }
                    jo8.b(arrayList, this.i, this.M, this.a);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c2 = jo8.d(arrayList, this.M.o(), sparseArray, this.i);
                } else {
                    c2 = jo8.c(arrayList, this.M.o(), sparseArray, this.i);
                }
                jo8.m(c2, this.g);
                jo8.f(c2);
                this.i.q(jo8.h(this.M));
                this.i.l(c2, !UbsABTestHelper.isPBPlanA());
                this.h = new i05(getPageContext(), this.i);
                this.i.o(new w(this));
                this.h.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.a.Q1()).param("fid", this.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.T());
                if (z10) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                TiebaStatic.log(param.param("obj_source", i2));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final TbRichText x2(ArrayList<bc9> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048666, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText Z = arrayList.get(i3).Z();
                    if (Z != null && (T = Z.T()) != null) {
                        int size = T.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (T.get(i5) != null && T.get(i5).getType() == 8) {
                                i4++;
                                if (!T.get(i5).Z().S().equals(str) && !T.get(i5).Z().T().equals(str)) {
                                    if (i4 > i2) {
                                        break;
                                    }
                                } else {
                                    int i6 = (int) hi.i(TbadkCoreApplication.getInst());
                                    int width = T.get(i5).Z().getWidth() * i6;
                                    int height = T.get(i5).Z().getHeight() * i6;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.D = i5;
                                    return Z;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final int y2(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z;
        TbRichTextImageInfo Z;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048667, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.F = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.T().size();
                int i5 = i2;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.T().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int i8 = (int) hi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.Z().getWidth() * i8;
                        int height = tbRichTextData.Z().getHeight() * i8;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.Z().X()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = li8.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (Z = tbRichTextData.Z()) != null) {
                                        String S = Z.S();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            S = Z.T();
                                        } else {
                                            if (this.f) {
                                                i4 = 17;
                                            } else {
                                                i4 = 18;
                                            }
                                            imageUrlData.urlType = i4;
                                        }
                                        imageUrlData.imageUrl = S;
                                        imageUrlData.originalUrl = C2(tbRichTextData);
                                        imageUrlData.originalSize = D2(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = A2(tbRichTextData);
                                        imageUrlData.isLongPic = z2(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = gg.g(this.a.Q1(), -1L);
                                        imageUrlData.mIsReserver = this.a.H1();
                                        imageUrlData.mIsSeeHost = this.a.Z0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a2, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.F) {
                                    i5++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i6 <= i3) {
                                i5--;
                            }
                        }
                    }
                }
                return i5;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }
}
