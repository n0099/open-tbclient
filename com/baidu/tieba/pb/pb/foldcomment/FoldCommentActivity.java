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
import com.baidu.tbadk.widget.ForeDrawableImageView;
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
import com.baidu.tieba.ae5;
import com.baidu.tieba.aj9;
import com.baidu.tieba.al5;
import com.baidu.tieba.ao9;
import com.baidu.tieba.aq9;
import com.baidu.tieba.bg;
import com.baidu.tieba.bj9;
import com.baidu.tieba.cg;
import com.baidu.tieba.co9;
import com.baidu.tieba.dj5;
import com.baidu.tieba.do9;
import com.baidu.tieba.e26;
import com.baidu.tieba.e55;
import com.baidu.tieba.ei;
import com.baidu.tieba.ej5;
import com.baidu.tieba.ep9;
import com.baidu.tieba.fj5;
import com.baidu.tieba.g55;
import com.baidu.tieba.gl9;
import com.baidu.tieba.gp9;
import com.baidu.tieba.h15;
import com.baidu.tieba.h26;
import com.baidu.tieba.h55;
import com.baidu.tieba.h95;
import com.baidu.tieba.hw4;
import com.baidu.tieba.i55;
import com.baidu.tieba.i9;
import com.baidu.tieba.ig5;
import com.baidu.tieba.iqa;
import com.baidu.tieba.jqa;
import com.baidu.tieba.kg5;
import com.baidu.tieba.m05;
import com.baidu.tieba.ms5;
import com.baidu.tieba.nr9;
import com.baidu.tieba.on9;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rj9;
import com.baidu.tieba.rs5;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.si5;
import com.baidu.tieba.sl9;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tha;
import com.baidu.tieba.tk5;
import com.baidu.tieba.tq9;
import com.baidu.tieba.uk5;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vk9;
import com.baidu.tieba.vp9;
import com.baidu.tieba.xk5;
import com.baidu.tieba.xn9;
import com.baidu.tieba.y45;
import com.baidu.tieba.yk5;
import com.baidu.tieba.yk9;
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
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, gl9<NewSubPbActivity>, TbRichTextView.t, y45.e, h26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId A;
    public PbModel.h B;
    public int C;
    public final TbRichTextView.z D;
    public boolean E;
    public vk9 F;
    public final View.OnLongClickListener G;
    public co9 H;
    public BdImage I;
    public String J;
    public tha K;
    public i55.f L;
    public final i9 M;
    public uk5 N;
    public CustomMessageListener O;
    public NewWriteModel.d P;
    public View.OnClickListener Q;
    public tk5 R;
    public final hw4.a S;
    public PbModel a;
    public tq9 b;
    public sl9 c;
    public ep9 d;
    public gp9 e;
    public boolean f;
    public boolean g;
    public g55 h;
    public i55 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public h95 l;
    public AgreeMessageData m;
    public ForumManageModel n;
    public jqa o;
    public yk5 p;
    public xk5 q;
    public boolean r;
    public ao9 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public hw4 y;
    public bg<ImageView> z;

    @Override // com.baidu.tieba.h26
    public bg<GifView> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<LinearLayout> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h26
    public void M(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.h26
    public void P(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, context, str) == null) {
        }
    }

    public boolean P2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<TiebaPlusRecommendCard> V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<RelativeLayout> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<FestivalTipView> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<View> d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void f0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.h26
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void h0(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048629, this, context, str, z2) == null) {
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<TextView> j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void m0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048641, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.h26
    public void p0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048655, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void u1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048662, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<ItemCardView> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class h implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes7.dex */
        public class a implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements y45.e {
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) == null) {
                if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.r1() != null) {
                        statisticItem.param("fid", this.a.a.r1().l());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.L1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    ao9 ao9Var = this.a.s;
                    if (ao9Var != null) {
                        ao9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        kg5.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new a(this));
                    y45Var.setPositiveButton(R.string.open_now, new b(this));
                    y45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    if (foldCommentActivity.s != null) {
                        if (foldCommentActivity.c != null && this.a.c.x() != null && this.a.c.x().f() != null && this.a.c.x().f().z()) {
                            this.a.c.x().f().w(postWriteCallBackData);
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
                    yk9.a(this.b.a.getPageContext(), this.a).show();
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
    public class a implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends i9 {
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

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.n.getLoadDataMode();
                    if (loadDataMode != 0) {
                        if (loadDataMode == 1) {
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.c.u(1, dVar.a, dVar.b, true);
                            return;
                        }
                        return;
                    }
                    this.a.a.W1();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    this.a.v2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.c.u(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) && y45Var != null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.b.c.c0();
                MessageManager.getInstance().sendMessage(this.a);
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements uk5 {
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

        @Override // com.baidu.tieba.uk5
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
                this.a.c.V(this.a.q.z());
            }
            this.a.c.Z(false);
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
        public void b(aj9 aj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aj9Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, aj9 aj9Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), aj9Var, str, Integer.valueOf(i4)}) != null) || this.a.c == null) {
                return;
            }
            this.a.c.T();
            if (z) {
                this.a.c.D();
                if (aj9Var != null) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    boolean z2 = true;
                    if (aj9Var.r() != 1) {
                        z2 = false;
                    }
                    foldCommentActivity.f = z2;
                    String str2 = null;
                    if (this.a.a != null && this.a.a.b2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.c != null) {
                        str2 = this.a.c.y();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.q.d0(TbSingleton.getInstance().getAdVertiComment(aj9Var.q0(), aj9Var.r0(), str2));
                    }
                    this.a.c.R(aj9Var, this.a.f);
                    return;
                }
                return;
            }
            this.a.X2(i, str);
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
                statisticItem2.param("tid", this.a.a.L1());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof tha) {
                        tha thaVar = (tha) obj;
                        if (this.a.a == null || this.a.a.r1() == null || thaVar.t() == null || thaVar.L() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.x() != null) {
                            this.a.c.x().g();
                        }
                        rj9 rj9Var = new rj9();
                        rj9Var.v(this.a.a.r1().k());
                        rj9Var.z(this.a.a.r1().O());
                        rj9Var.x(thaVar);
                        this.a.c.w().i0(rj9Var);
                        this.a.c.w().setPostId(thaVar.U());
                        this.a.T2(view2, thaVar.t().getUserId(), "", thaVar);
                        TiebaStatic.log("c11743");
                        nr9.b(this.a.a.r1(), thaVar, thaVar.f0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.V(this.a.q.z());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091ae9 && view2.getId() != R.id.obfuscated_res_0x7f091b4a) {
                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092337 && view2.getId() != R.id.obfuscated_res_0x7f091ae7 && view2.getId() != R.id.obfuscated_res_0x7f091960) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f091b50 && view2.getId() != R.id.obfuscated_res_0x7f091d3b && view2.getId() != R.id.obfuscated_res_0x7f091ae1) {
                        if ((view2.getId() == R.id.obfuscated_res_0x7f09086b || view2.getId() == R.id.obfuscated_res_0x7f090b78) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof tha)) {
                            tha thaVar2 = (tha) sparseArray.get(R.id.tag_load_sub_data);
                            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                            if (thaVar2 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09086c);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f09086d);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b78);
                            thaVar2.j1(!thaVar2.D0());
                            SkinManager.setBackgroundColor(findViewById, thaVar2.D0() ? R.color.CAM_X0201 : R.color.transparent);
                            SkinManager.setViewTextColor(eMTextView, thaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            WebPManager.setPureDrawable(imageView, thaVar2.D0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, thaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                            return;
                        }
                        return;
                    } else if (this.a.a == null) {
                        return;
                    } else {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091b50) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.L1());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091d3b) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b50 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof tha) {
                                tha thaVar3 = (tha) sparseArray2.get(R.id.tag_load_sub_data);
                                if (view2.getId() == R.id.obfuscated_res_0x7f091b50 && (statisticItem = thaVar3.g0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d3b || view2.getId() == R.id.obfuscated_res_0x7f091ae1) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.M1()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", thaVar3.U()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.r1() == null || thaVar3.t() == null || thaVar3.L() == 1) {
                                    return;
                                }
                                if (this.a.c.x() != null) {
                                    this.a.c.x().g();
                                }
                                rj9 rj9Var2 = new rj9();
                                rj9Var2.v(this.a.a.r1().k());
                                rj9Var2.z(this.a.a.r1().O());
                                rj9Var2.x(thaVar3);
                                this.a.c.w().i0(rj9Var2);
                                this.a.c.w().setPostId(thaVar3.U());
                                this.a.T2(view2, thaVar3.t().getUserId(), "", thaVar3);
                                if (this.a.q != null) {
                                    this.a.c.V(this.a.q.z());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091960) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.L1());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f091ae7 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    if (!this.a.checkUpIsLogin()) {
                        nr9.v("c10517", this.a.a.r1().l(), 3);
                    } else if (this.a.a == null || this.a.a.r1() == null) {
                    } else {
                        this.a.c.t();
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        tha thaVar4 = (tha) sparseArray3.get(R.id.tag_load_sub_data);
                        tha thaVar5 = (tha) sparseArray3.get(R.id.tag_load_sub_reply_data);
                        View view4 = (View) sparseArray3.get(R.id.tag_load_sub_view);
                        if (thaVar4 == null || view4 == null) {
                            return;
                        }
                        if (thaVar4.P() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem5 = thaVar4.g0;
                        if (statisticItem5 != null) {
                            StatisticItem copy2 = statisticItem5.copy();
                            copy2.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091960) {
                                copy2.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae7) {
                                copy2.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy2);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091ae7 && this.a.a != null && this.a.a.r1() != null && thaVar4 != null) {
                            TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.L1()).param("fname", this.a.a.r1().m()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", thaVar4.U()));
                        }
                        String L1 = this.a.a.L1();
                        String U = thaVar4.U();
                        String U2 = thaVar5 != null ? thaVar5.U() : "";
                        int W = this.a.a.r1() != null ? this.a.a.r1().W() : 0;
                        this.a.I();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091f2f && (view2.getId() != R.id.obfuscated_res_0x7f091ae7 || !this.a.r)) {
                            TiebaStatic.log("c11742");
                            AbsPbActivity.e a3 = this.a.a3(U);
                            if (thaVar4 == null || this.a.a == null || this.a.a.r1() == null || a3 == null) {
                                return;
                            }
                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, this.a.r, null, false, U2, W, thaVar4.m0(), this.a.a.r1().c(), false, thaVar4.t().getIconInfo(), 5).addBigImageData(a3.a, a3.b, a3.g, a3.j);
                            if (!ei.isEmpty(U2)) {
                                addBigImageData.setHighLightPostId(U2);
                                addBigImageData.setKeyIsUseSpid(true);
                            }
                            addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                            addBigImageData.setTiebaPlusData(this.a.a.V(), this.a.a.R(), this.a.a.S(), this.a.a.Q(), this.a.a.W());
                            addBigImageData.setBjhData(this.a.a.I0());
                            addBigImageData.setKeyPageStartFrom(this.a.a.q1());
                            addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                            addBigImageData.setWorksInfoData(this.a.a.Q1());
                            addBigImageData.setFromFoldComment(true);
                            addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                            return;
                        }
                        AbsPbActivity.e a32 = this.a.a3(U);
                        if (this.a.a == null || this.a.a.r1() == null || a32 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, this.a.r, null, true, null, W, thaVar4.m0(), this.a.a.r1().c(), false, thaVar4.t().getIconInfo(), 5).addBigImageData(a32.a, a32.b, a32.g, a32.j);
                        addBigImageData2.setKeyPageStartFrom(this.a.a.q1());
                        addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.a.a.Q1());
                        addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData2.setBjhData(this.a.a.I0());
                        addBigImageData2.setTiebaPlusData(this.a.a.V(), this.a.a.R(), this.a.a.S(), this.a.a.Q(), this.a.a.W());
                        addBigImageData2.setFromFoldComment(true);
                        addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                    }
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.L1());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.r1() != null && this.a.K != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.L1()).param("fname", this.a.a.r1().m()).param("fid", this.a.a.r1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.K.U()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.r2(view2);
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
            this.c.h3(this.a, this.b);
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
            this.c.h3(this.a, this.b);
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
            ao9 ao9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ao9Var = this.a.s) != null && ao9Var.g() != null) {
                if (!this.a.s.g().e()) {
                    this.a.s.b(false);
                }
                this.a.s.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements tk5 {
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

        @Override // com.baidu.tieba.tk5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ao9 ao9Var = this.a.s;
                if (ao9Var != null && ao9Var.g() != null && this.a.s.g().d()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                    if (this.a.c != null && this.a.c.x() != null && this.a.c.x().f() != null && this.a.c.x().f().z()) {
                        this.a.c.x().f().w(this.a.s.h());
                    }
                    this.a.s.b(true);
                    return true;
                }
                return !this.a.o2(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q implements hw4.a {
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

        @Override // com.baidu.tieba.hw4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.y != null) {
                        this.a.y.h(z2);
                    }
                    this.a.a.h3(z2);
                    if (this.a.a.c1()) {
                        this.a.U2();
                    }
                    if (z2) {
                        if (this.a.y != null) {
                            if (this.a.y.f() != null && this.a.a != null && this.a.a.r1() != null && this.a.a.r1().O() != null && this.a.a.r1().O().getAuthor() != null) {
                                MarkData f = this.a.y.f();
                                MetaData author = this.a.a.r1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
                                        if (DialogUtil.shouldShowPushPremissionDialog(this.a.getActivity(), 0)) {
                                            DialogUtil.showPushPermissionDialog(this.a.getPageContext(), 6, 2000L);
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
                        this.a.j2();
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

    /* loaded from: classes7.dex */
    public class r implements cg<ImageView> {
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
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
    public class s implements TbRichTextView.z {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
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
                    this.a.Y2(str, i, eVar);
                    if (this.a.a.r1().j0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().Q() != null) {
                            ArrayList<TbRichTextImageInfo> Q = tbRichTextView.getRichText().Q();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < Q.size()) {
                                if (Q.get(i5) != null) {
                                    arrayList.add(Q.get(i5).getSrc());
                                    if (i6 == i4 && str != null && (str.equals(Q.get(i5).getSrc()) || str.equals(Q.get(i5).N()) || str.equals(Q.get(i5).M()) || str.equals(Q.get(i5).getBigSrc()) || str.equals(Q.get(i5).P()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData3 = new ImageUrlData();
                                    String src = Q.get(i5).getSrc();
                                    imageUrlData3.imageUrl = src;
                                    imageUrlData3.imageThumbUrl = src;
                                    if (this.a.f) {
                                        i3 = 17;
                                    } else {
                                        i3 = 18;
                                    }
                                    imageUrlData3.urlThumbType = i3;
                                    imageUrlData3.originalUrl = Q.get(i5).getSrc();
                                    imageUrlData3.isLongPic = Q.get(i5).T();
                                    concurrentHashMap.put(Q.get(i5).getSrc(), imageUrlData3);
                                }
                                i5++;
                                i4 = -1;
                            }
                            i2 = i6;
                        } else {
                            i2 = -1;
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i2).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.D1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.O2());
                        if (this.a.a != null) {
                            builder.setFromForumId(this.a.a.getFromForumId());
                            if (this.a.a.r1() != null) {
                                builder.setThreadData(this.a.a.r1().O());
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
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.a.D1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.O2()).setBjhPostId(eVar.f).setPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.a != null) {
                            builder2.setFromForumId(this.a.a.getFromForumId());
                            if (this.a.a.r1() != null) {
                                builder2.setThreadData(this.a.a.r1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText o3 = this.a.o3(str, i);
                        if (o3 != null && this.a.C >= 0 && this.a.C < o3.O().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = bj9.a(o3.O().get(this.a.C));
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
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.a.D1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.O2()).setPostId(eVar.f).setBjhPostId(eVar.f);
                            if (this.a.a != null) {
                                builder3.setFromForumId(this.a.a.getFromForumId());
                                if (this.a.a.r1() != null) {
                                    builder3.setThreadData(this.a.a.r1().O());
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
    public class t implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.q.H(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.c != null && this.a.c.x() != null && this.a.c.x().f() != null) {
                    this.a.c.x().f().I();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements PbFragment.k3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

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
                String valueOf = String.valueOf(this.a.a.r1().V().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.r1().k().getId(), this.a.a.r1().k().getName(), this.a.a.r1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.vk9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.vk9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091f50) {
                        if (this.a.c3(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae6) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.j3((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.pb_post_header_layout) {
                        SparseArray sparseArray = null;
                        if (view2.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view2.getTag();
                        }
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.j3(sparseArray);
                    }
                }
                if (this.a.q != null) {
                    this.a.c.V(this.a.q.z());
                }
                this.a.c.Q();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class w implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.r2(view2);
        }
    }

    /* loaded from: classes7.dex */
    public class x implements i55.d {
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

        @Override // com.baidu.tieba.i55.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null) {
                this.a.i.r(vp9.h(this.a.K));
                ArrayList arrayList = new ArrayList();
                for (h55 h55Var : this.a.i.g()) {
                    if (h55Var instanceof e55) {
                        arrayList.add((e55) h55Var);
                    }
                }
                vp9.f(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public y(FoldCommentActivity foldCommentActivity) {
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

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.m3(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                        this.a.b3(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_reply);
                        this.a.b3(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.b3(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view6 == null) {
                            return;
                        }
                        this.a.b3(view6);
                        AgreeView agreeView2 = (AgreeView) view6;
                        if (agreeView2.getImgAgree() != null) {
                            agreeView2.getImgAgree().performClick();
                            return;
                        }
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.a.I != null && !TextUtils.isEmpty(this.a.J)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.J));
                            this.a.I = null;
                            this.a.J = null;
                            return;
                        }
                        return;
                    case 2:
                        if (this.a.I != null && !TextUtils.isEmpty(this.a.J)) {
                            if (this.a.j == null) {
                                this.a.j = new PermissionJudgePolicy();
                            }
                            this.a.j.clearRequestPermissionList();
                            this.a.j.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.j.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.H == null) {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.H = new co9(foldCommentActivity.getPageContext());
                            }
                            this.a.H.b(this.a.J, this.a.I.getImageByte());
                            this.a.I = null;
                            this.a.J = null;
                            return;
                        }
                        return;
                    case 3:
                        tha thaVar = this.a.K;
                        if (thaVar != null) {
                            thaVar.S0();
                            this.a.K = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (!this.a.checkUpIsLogin()) {
                            return;
                        }
                        this.a.V2(view2);
                        if (this.a.a.r1().O() != null && this.a.a.r1().O().getAuthor() != null && this.a.a.r1().O().getAuthor().getUserId() != null && this.a.y != null) {
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int H2 = foldCommentActivity2.H2(foldCommentActivity2.a.r1());
                            ThreadData O = this.a.a.r1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                if (O.isBJHVideoDynamicThreadType()) {
                                    i2 = 5;
                                } else {
                                    i2 = 1;
                                }
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.L1()).param("obj_locate", 2).param("obj_id", this.a.a.r1().O().getAuthor().getUserId()).param("obj_type", !this.a.y.e()).param("obj_source", H2).param("obj_param1", i2));
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
                            this.a.K2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.a.m2(sparseArray2);
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
                            boolean K = this.a.K(TbadkCoreApplication.getCurrentAccount());
                            if (K) {
                                if (booleanValue2) {
                                    this.a.c.M(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, K);
                                    return;
                                } else {
                                    this.a.g3(sparseArray3, intValue, booleanValue);
                                    return;
                                }
                            } else if (!booleanValue || booleanValue2) {
                                this.a.c.K(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            } else {
                                this.a.g3(sparseArray3, intValue, booleanValue);
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
                                this.a.m2(sparseArray4);
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
                        tha thaVar2 = (tha) sparseArray.get(R.id.tag_clip_board);
                        if (thaVar2.p() == null) {
                            return;
                        }
                        this.a.p2(thaVar2.p());
                        return;
                    case 9:
                        if (this.a.checkUpIsLogin() && this.a.a != null && this.a.a.r1() != null) {
                            this.a.f3(iqa.c(view2));
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ FoldCommentActivity d;

        public z(FoldCommentActivity foldCommentActivity, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                if (y45Var != null) {
                    y45Var.dismiss();
                }
                this.d.u2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
        this.C = 0;
        this.D = new s(this);
        this.E = false;
        this.F = new vk9(new v(this));
        this.G = new w(this);
        this.K = null;
        this.L = new y(this);
        this.M = new b(this);
        this.N = new f(this);
        this.O = new g(this, 2004008);
        this.P = new h(this);
        this.Q = new l(this);
        this.R = new p(this);
        this.S = new q(this);
    }

    public void Z2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.r1() == null || this.a.r1().k() == null || l2()) {
            return;
        }
        if (this.a.r1().j0()) {
            this.c.s();
            return;
        }
        xk5 xk5Var = this.q;
        if (xk5Var != null && xk5Var.a() != null) {
            this.q.a().D(new si5(45, 27, null));
        }
        this.c.s();
    }

    public final boolean A2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return false;
            }
            return tbRichTextData.U().T();
        }
        return invokeL.booleanValue;
    }

    public final boolean B2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return false;
            }
            return tbRichTextData.U().U();
        }
        return invokeL.booleanValue;
    }

    public final String D2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return null;
            }
            return tbRichTextData.U().P();
        }
        return (String) invokeL.objValue;
    }

    public final long E2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return 0L;
            }
            return tbRichTextData.U().getOriginalSize();
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.gl9
    public boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.l2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean M2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    public final void R2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(this, "", str, false, true, true, bundle);
        }
    }

    public final void V2(View view2) {
        SparseArray sparseArray;
        tha thaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (thaVar = (tha) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            W2(thaVar);
        }
    }

    public final void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            this.q.Y(z2);
            this.q.b0(z2);
            this.q.j0(z2);
        }
    }

    public void f3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, str) == null) && str != null && this.o != null) {
            this.o.n(JavaTypesHelper.toLong(str, 0L));
        }
    }

    public void l3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.A);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.y45.e
    public void onClick(y45 y45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, y45Var) == null) {
            t2(y45Var, null);
        }
    }

    public PbModel C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public xk5 F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q;
        }
        return (xk5) invokeV.objValue;
    }

    public gp9 G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (gp9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void I() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.gl9
    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.k2();
        }
        return invokeV.booleanValue;
    }

    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.U0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gl9
    public ep9 S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.d;
        }
        return (ep9) invokeV.objValue;
    }

    public final void S2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (pbModel = this.a) != null) {
            pbModel.s2();
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            aj9 r1 = this.a.r1();
            this.a.h3(true);
            hw4 hw4Var = this.y;
            if (hw4Var != null) {
                r1.L0(hw4Var.g());
            }
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<ImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.z == null) {
                this.z = new bg<>(new r(this), 8, 0);
            }
            return this.z;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tieba.gl9
    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.Q0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gl9
    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.r1() != null) {
                return this.a.r1().W();
            }
            return 0;
        }
        return invokeV.intValue;
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
                l3(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            super.onResume();
            if (this.r) {
                l3(true);
            }
        }
    }

    public AntiData w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.r1() != null) {
                return this.a.r1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final int H2(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aj9Var)) == null) {
            if (aj9Var != null && aj9Var.O() != null) {
                if (aj9Var.O().getThreadType() == 0) {
                    return 1;
                }
                if (aj9Var.O().getThreadType() == 54) {
                    return 2;
                }
                if (aj9Var.O().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void b3(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, view2) != null) || view2 == null) {
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

    public final void j3(SparseArray<Object> sparseArray) {
        tha thaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048636, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof tha) || (thaVar = (tha) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        k3(thaVar, false);
    }

    public void m2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, sparseArray) == null) {
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

    public final void m3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.L1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(vp9.n(i2))));
        }
    }

    public final void I2(int i2, Intent intent) {
        fj5 fj5Var;
        fj5 fj5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, intent) == null) {
            if (i2 == 0) {
                this.c.C();
                this.c.x().g();
                this.c.Z(false);
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
                if (editorType == 1 && this.c.x() != null && this.c.x().f() != null) {
                    al5 f2 = this.c.x().f();
                    f2.f0(this.a.r1().O());
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
            this.q.M();
            this.q.n0(pbEditorData.getVoiceModel());
            this.q.C(writeData);
            ej5 p3 = this.q.a().p(6);
            if (p3 != null && (fj5Var = p3.m) != null) {
                fj5Var.G(new si5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.q.H(null, null);
            }
        }
    }

    public final void h3(String str, String str2) {
        int i2;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, str, str2) == null) {
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getApplicationContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
            } else {
                i2 = equipmentHeight / 2;
                dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
            }
            int i3 = equipmentHeight - (i2 + dimens);
            boolean z2 = true;
            this.c.v().smoothScrollBy((this.w[1] + this.x) - i3, 50);
            if (this.c.x() != null) {
                this.q.a().setVisibility(8);
                PbModel pbModel2 = this.a;
                this.c.x().t(str, str2, this.c.y(), (pbModel2 == null || pbModel2.r1() == null || this.a.r1().O() == null || !this.a.r1().O().isBjh()) ? false : false);
                al5 f2 = this.c.x().f();
                if (f2 != null && (pbModel = this.a) != null && pbModel.r1() != null) {
                    f2.J(this.a.r1().c());
                    f2.f0(this.a.r1().O());
                }
                if (this.s.f() == null && this.c.x().f().u() != null) {
                    this.c.x().f().u().g(new o(this));
                    this.s.n(this.c.x().f().u().i());
                    this.c.x().f().P(this.R);
                }
            }
            this.c.A();
        }
    }

    public final void k3(tha thaVar, boolean z2) {
        PbModel pbModel;
        int i2;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048638, this, thaVar, z2) != null) || thaVar == null || (pbModel = this.a) == null || pbModel.r1() == null || thaVar.L() == 1) {
            return;
        }
        String L1 = this.a.L1();
        String U = thaVar.U();
        if (this.a.r1() != null) {
            i2 = this.a.r1().W();
        } else {
            i2 = 0;
        }
        AbsPbActivity.e a3 = a3(U);
        if (a3 == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this);
        boolean z3 = this.r;
        SmallTailInfo m0 = thaVar.m0();
        AntiData c2 = this.a.r1().c();
        if (thaVar.t() != null) {
            arrayList = thaVar.t().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(L1, U, "pb", true, z3, null, false, null, i2, m0, c2, false, arrayList, 5).addBigImageData(a3.a, a3.b, a3.g, a3.j);
        addBigImageData.setKeyPageStartFrom(this.a.q1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.Q1());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.I0());
        addBigImageData.setIsOpenEditor(z2);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void s2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048660, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(xn9.o2)).intValue();
            if (intValue == xn9.p2) {
                if (this.n.f0()) {
                    return;
                }
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
                    this.n.h0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.i0(this.a.r1().k().getId(), this.a.r1().k().getName(), this.a.r1().O().getId(), str, intValue3, intValue2, booleanValue, this.a.r1().O().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == xn9.q2 || intValue == xn9.s2) {
                if (this.a.M0() != null) {
                    this.a.M0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == xn9.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void v2(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048665, this, bVar, z2) != null) || bVar == null) {
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
            y45 y45Var = new y45(getPageContext().getPageActivity());
            y45Var.setMessage(string);
            y45Var.setPositiveButton(R.string.dialog_known, new c(this));
            y45Var.setCancelable(true);
            y45Var.create(getPageContext());
            y45Var.show();
        } else if (bVar.d != 0) {
            this.c.u(0, bVar.a, bVar.b, z2);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<tha> F = this.a.r1().F();
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
                this.a.r1().O().setReply_num(this.a.r1().O().getReply_num() - 1);
            } else if (i3 == 0) {
                q2();
            } else if (i3 == 2) {
                ArrayList<tha> F2 = this.a.r1().F();
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
            }
        }
    }

    public void J2(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
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
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.k);
            userMuteAddAndDelCustomMessage.setTag(this.k);
            i3(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048648, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.D(i2, i3, intent);
            if (this.c.x() != null) {
                this.c.x().k(i2, i3, intent);
            }
            if (i2 == 25035) {
                I2(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 13008) {
                    if (i2 != 13011) {
                        if (i2 == 24007) {
                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                RateManager.getInstance().notifyShare(getPageContext());
                                n3();
                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                    shareSuccessReplyToServerModel.M(str, intExtra, new j(this));
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
                on9.b().k();
                this.mHandler.postDelayed(new i(this), 1000L);
            }
        }
    }

    public final void K2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.r1() != null && this.a.r1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.L1(), str);
                ThreadData O = this.a.r1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                R2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final boolean Q2(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z2)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.r1() != null) {
                if (this.a.r1().W() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.r1().O() == null || this.a.r1().O().getAuthor() == null || TextUtils.equals(this.a.r1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                return !z2;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void W2(tha thaVar) {
        boolean z2;
        hw4 hw4Var;
        tha x2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, thaVar) != null) || thaVar == null) {
            return;
        }
        if (thaVar.U() != null && thaVar.U().equals(this.a.m1())) {
            z2 = true;
        } else {
            z2 = false;
        }
        MarkData l1 = this.a.l1(thaVar);
        if (this.a.r1() != null && this.a.r1().j0() && (x2 = x2()) != null) {
            l1 = this.a.l1(x2);
        }
        if (l1 != null && (hw4Var = this.y) != null) {
            hw4Var.i(l1);
            if (!z2) {
                this.y.a();
            } else {
                this.y.d();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void L0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048594, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
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

    public final void L2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            this.k = getUniqueId();
            hw4 c2 = hw4.c(this);
            this.y = c2;
            if (c2 != null) {
                c2.j(this.S);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.n = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.M);
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.B);
            } else {
                this.a = new PbModel(this, getIntent(), this.B);
            }
            this.a.c3(true);
            this.a.e3(4);
        }
    }

    public final void d3(yk5 yk5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, yk5Var) == null) && yk5Var != null && (pbModel = this.a) != null) {
            yk5Var.p(pbModel.Q0());
            if (this.a.r1() != null && this.a.r1().k() != null) {
                yk5Var.o(this.a.r1().k());
            }
            yk5Var.q("pb");
            yk5Var.r(this.a);
        }
    }

    public boolean o2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048646, this, i2)) == null) {
            if (this.u != null && this.a.r1() != null && !ThreadCardUtils.isSelf(this.a.r1().O()) && this.a.r1().c() != null) {
                return this.u.checkPrivacyBeforeSend(this.a.r1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void N2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            this.d = new ep9(this);
            this.e = new gp9(getPageContext());
            sl9 sl9Var = new sl9(this, this.Q, this.D, this.F, this.G);
            this.c = sl9Var;
            sl9Var.X(this.a);
            setContentView(this.c.z(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.r();
            this.c.U(new u(this));
            yk5 yk5Var = new yk5();
            this.p = yk5Var;
            d3(yk5Var);
            xk5 xk5Var = (xk5) this.p.a(getActivity());
            this.q = xk5Var;
            xk5Var.X(getPageContext());
            this.q.h0(this.N);
            this.q.Z(1);
            this.q.B(getPageContext(), bundle);
            this.q.a().b(new dj5(getActivity()));
            this.q.a().F(true);
            e3(true);
            this.q.K(this.a.T0(), this.a.L1(), this.a.P0());
            this.c.S(this.q.a());
            this.s = new ao9();
            if (this.q.s() != null) {
                this.s.m(this.q.s().i());
            }
            registerListener(this.O);
            if (!this.a.e1()) {
                this.q.q(this.a.L1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.b2()) {
                this.q.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                sl9 sl9Var2 = this.c;
                if (sl9Var2 != null) {
                    this.q.d0(sl9Var2.y());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    public final void T2(View view2, String str, String str2, tha thaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048606, this, view2, str, str2, thaVar) != null) || view2 == null || str == null || str2 == null || !n2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.w);
            this.x = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.x() != null && thaVar != null) {
            if (thaVar.f0() != null) {
                str3 = thaVar.f0().toString();
            } else {
                str3 = "";
            }
            this.c.x().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), thaVar.t().getName_show(), str3));
        }
        if (this.a.r1() != null && this.a.r1().j0()) {
            SafeHandler.getInst().postDelayed(new m(this, str, str2), 0L);
        } else {
            SafeHandler.getInst().postDelayed(new n(this, str, str2), 0L);
        }
    }

    public void u2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(xn9.o2, Integer.valueOf(xn9.p2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                s2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void X2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048611, this, i2, str) == null) {
            if (this.a.S1()) {
                showToast(str);
            } else if (BdUtilHelper.isNetOk()) {
                if (i2 == 4) {
                    sl9 sl9Var = this.c;
                    sl9Var.f0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    sl9 sl9Var2 = this.c;
                    sl9Var2.f0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.c.e0(R.string.no_data_text);
                }
            } else {
                this.c.e0(R.string.recommend_pb_no_net_text);
            }
        }
    }

    public final void Y2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048613, this, str, i2, eVar) != null) || eVar == null) {
            return;
        }
        aj9 r1 = this.a.r1();
        TbRichText o3 = o3(str, i2);
        if (o3 == null || (tbRichTextData = o3.O().get(this.C)) == null) {
            return;
        }
        eVar.f = String.valueOf(o3.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z2 = false;
        if (!tbRichTextData.U().S()) {
            eVar.h = false;
            String a2 = bj9.a(tbRichTextData);
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
            imageUrlData.urlThumbType = imageUrlData.urlType;
            imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
            imageUrlData.originalUrl = D2(tbRichTextData);
            imageUrlData.originalUrl = D2(tbRichTextData);
            imageUrlData.originalSize = E2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = B2(tbRichTextData);
            imageUrlData.isLongPic = A2(tbRichTextData);
            imageUrlData.postId = o3.getPostId();
            imageUrlData.mIsReserver = this.a.D1();
            imageUrlData.mIsSeeHost = this.a.U0();
            eVar.b.put(a2, imageUrlData);
            if (r1 != null) {
                if (r1.k() != null) {
                    eVar.c = r1.k().getName();
                    eVar.d = r1.k().getId();
                }
                if (r1.O() != null) {
                    eVar.e = r1.O().getId();
                }
                if (r1.r() == 1) {
                    z2 = true;
                }
                eVar.g = z2;
            }
            imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = r1.F().size();
        this.E = false;
        eVar.j = -1;
        if (r1.i() != null) {
            i3 = z2(r1.i().f0(), o3, i2, i2, eVar.a, eVar.b);
        } else {
            i3 = i2;
        }
        int i5 = i3;
        for (int i6 = 0; i6 < size; i6++) {
            tha thaVar = r1.F().get(i6);
            if (thaVar.U() == null || r1.i() == null || r1.i().U() == null || !thaVar.U().equals(r1.i().U())) {
                i5 = z2(thaVar.f0(), o3, i5, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (r1 != null) {
            if (r1.k() != null) {
                eVar.c = r1.k().getName();
                eVar.d = r1.k().getId();
            }
            if (r1.O() != null) {
                eVar.e = r1.O().getId();
            }
            if (r1.r() == 1) {
                z2 = true;
            }
            eVar.g = z2;
        }
        eVar.j = i5;
    }

    public final AbsPbActivity.e a3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            String str2 = null;
            if (this.a.r1() != null && this.a.r1().F() != null && this.a.r1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 < this.a.r1().F().size()) {
                        if (str.equals(this.a.r1().F().get(i2).U())) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                tha thaVar = this.a.r1().F().get(i2);
                if (thaVar.f0() != null && thaVar.f0().O() != null) {
                    Iterator<TbRichTextData> it = thaVar.f0().O().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.U() != null) {
                                str2 = next.U().N();
                            }
                        }
                    }
                    Y2(str2, 0, eVar);
                    bj9.b(thaVar, eVar);
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
            M2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            L2(bundle);
            N2(bundle);
            S2();
            if (this.r) {
                this.c.z().setAnimTime(0);
                this.c.z().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.A = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.z().h();
            this.c.w().setFromForumId(this.a.getFromForumId());
            tq9 tq9Var = new tq9(this);
            this.b = tq9Var;
            tq9Var.b(getUniqueId());
            this.o = new jqa(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new t(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.d0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.d0(this.c.y());
            }
            ig5.b(false);
        }
    }

    public final boolean c3(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof tha)) {
                return false;
            }
            tha thaVar = (tha) obj;
            if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.r1() != null) {
                if (this.c.x() != null) {
                    this.c.x().g();
                }
                rj9 rj9Var = new rj9();
                rj9Var.v(this.a.r1().k());
                rj9Var.z(this.a.r1().O());
                rj9Var.x(thaVar);
                TiebaStatic.log("c11743");
                this.c.w().i0(rj9Var);
                this.c.w().setPostId(thaVar.U());
                T2(view2, thaVar.t().getUserId(), "", thaVar);
                xk5 xk5Var = this.q;
                if (xk5Var != null) {
                    this.c.V(xk5Var.z());
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
    public final void p2(AgreeData agreeData) {
        ms5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048656, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new h95();
        }
        if (this.m == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.m = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        h15 h15Var = new h15();
        h15Var.b = 5;
        h15Var.h = 8;
        h15Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            h15Var.f = pbModel2.q1();
        }
        h15Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                h15Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel == null && pbModel.r1() != null) {
                    this.l.b(this, h15Var, agreeData, this.a.r1().O());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            h15Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            h15Var.i = 1;
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

    public final void g3(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            vp9.e(getActivity(), getPageContext(), new z(this, sparseArray, i2, z2), new a(this));
        }
    }

    public final void i3(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.c.c0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            y45 y45Var = new y45(this);
            if (!ei.isEmpty(str)) {
                y45Var.setMessage(str);
            } else {
                y45Var.setMessage(getResources().getString(R.string.block_mute_message_alert, str3));
            }
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c4, new d(this, userMuteAddAndDelCustomMessage));
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new e(this));
            y45Var.create(getPageContext()).show();
        }
    }

    public final void j2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (pbModel = this.a) != null && pbModel.r1() != null && this.a.r1().O() != null) {
            ThreadData O = this.a.r1().O();
            O.mRecomAbTag = this.a.x1();
            O.mRecomWeight = this.a.A1();
            O.mRecomSource = this.a.z1();
            O.mRecomExtra = this.a.y1();
            O.isSubPb = this.a.e1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.a.getForumId(), 0L));
            }
            StatisticItem i2 = rs5.i(this, O, "c13562");
            TbPageTag l2 = rs5.l(this);
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

    public tha x2() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.r1() != null && this.a.r1().O() != null && this.a.r1().O().getAuthor() != null) {
                tha thaVar = new tha();
                MetaData author = this.a.r1().O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = this.a.r1().O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                thaVar.W0(1);
                thaVar.c1(this.a.r1().O().getFirstPostId());
                thaVar.t1(this.a.r1().O().getTitle());
                thaVar.s1(this.a.r1().O().getCreateTime());
                thaVar.P0(author);
                return thaVar;
            }
            return null;
        }
        return (tha) invokeV.objValue;
    }

    public final void k2(aj9 aj9Var, ArrayList<tha> arrayList) {
        List<tha> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048637, this, aj9Var, arrayList) == null) && aj9Var != null && aj9Var.T() != null && aj9Var.T().a != null && (list = aj9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<tha> it = arrayList.iterator();
                while (it.hasNext()) {
                    tha next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            tha thaVar = (tha) it2.next();
                            if (thaVar != null && !TextUtils.isEmpty(next.U()) && !TextUtils.isEmpty(thaVar.U()) && next.U().equals(thaVar.U())) {
                                arrayList2.add(thaVar);
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

    public final boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.r1() == null) {
                return false;
            }
            ThreadData O = this.a.r1().O();
            AntiData c2 = this.a.r1().c();
            if (!AntiHelper.b(getPageContext(), O) && !AntiHelper.d(getPageContext(), c2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if ((this.a.r1() != null && (this.a.r1().j0() || ThreadCardUtils.isSelf(this.a.r1().O()))) || this.u == null || this.a.r1() == null || this.a.r1().c() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.r1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.R(this.a.getForumId()) && this.a.r1() != null && this.a.r1().k() != null) {
            boolean z2 = true;
            if (this.a.r1().k().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                this.a.E0().Q(this.a.getForumId(), this.a.L1());
            }
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (this.a.W0() || this.a.Z0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.L1());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.L1()));
            finish();
        }
    }

    public final TbRichText o3(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048647, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.r1() == null || str == null || i2 < 0) {
                return null;
            }
            aj9 r1 = this.a.r1();
            if (r1.i() != null) {
                ArrayList<tha> arrayList = new ArrayList<>();
                arrayList.add(r1.i());
                tbRichText = y2(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<tha> F = r1.F();
                k2(r1, F);
                return y2(F, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void t2(y45 y45Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048661, this, y45Var, jSONArray) == null) {
            y45Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(y45Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                s2((SparseArray) y45Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean r2(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String str;
        boolean z9;
        boolean z10;
        int i2;
        boolean z11;
        e55 e55Var;
        e55 e55Var2;
        e55 e55Var3;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            tha thaVar = (tha) sparseArray.get(R.id.tag_clip_board);
            this.K = thaVar;
            if (thaVar == null || this.y == null) {
                return true;
            }
            if (this.i == null) {
                i55 i55Var = new i55(this);
                this.i = i55Var;
                i55Var.q(this.L);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                boolean P2 = P2(view2);
                if (P2(view2) && (bdImage = this.I) != null && !bdImage.isGif()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (sparseArray.get(R.id.tag_is_subpb) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                } else {
                    z3 = false;
                }
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                } else {
                    z4 = false;
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                } else {
                    z5 = false;
                }
                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                } else {
                    z6 = false;
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                } else {
                    z7 = false;
                }
                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                } else {
                    z8 = false;
                }
                if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                } else {
                    str = null;
                }
                if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
                } else {
                    z9 = false;
                }
                if (P2) {
                    z10 = z3;
                    arrayList.add(new e55(1, getString(R.string.save_to_emotion), this.i));
                } else {
                    z10 = z3;
                }
                if (z2) {
                    arrayList.add(new e55(2, getString(R.string.save_to_local), this.i));
                }
                if (!P2 && !z2) {
                    e55 e55Var4 = new e55(3, getString(R.string.obfuscated_res_0x7f0f04e5), this.i);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, this.K);
                    e55Var4.d.setTag(sparseArray2);
                    arrayList.add(e55Var4);
                }
                if (this.mIsLogin) {
                    if (!vp9.j(this.a) && !z6 && z5) {
                        e55 e55Var5 = new e55(5, getString(R.string.obfuscated_res_0x7f0f0d1c), this.i);
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
                        e55Var5.d.setTag(sparseArray3);
                        arrayList.add(e55Var5);
                    } else {
                        if (Q2(z4) && TbadkCoreApplication.isLogin()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            e55 e55Var6 = new e55(5, getString(R.string.report_text), this.i);
                            e55Var6.d.setTag(str);
                            arrayList.add(e55Var6);
                        }
                    }
                    if (z6) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                        sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                        sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                        sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                        if (!vp9.j(this.a) && z7) {
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
                        if (z8) {
                            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray4.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                            if (z9) {
                                e55Var = new e55(6, getString(R.string.obfuscated_res_0x7f0f054b), this.i);
                                e55Var.d.setTag(sparseArray4);
                                e55Var2 = new e55(7, getString(R.string.obfuscated_res_0x7f0f0324), this.i);
                                e55Var2.d.setTag(sparseArray4);
                            }
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        e55Var = null;
                        e55Var2 = new e55(7, getString(R.string.obfuscated_res_0x7f0f0324), this.i);
                        e55Var2.d.setTag(sparseArray4);
                    } else {
                        if (z8) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray5.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                            if (this.a.r1().W() == 1002 && !z4) {
                                e55Var3 = new e55(6, getString(R.string.report_text), this.i);
                            } else {
                                e55Var3 = new e55(6, getString(R.string.obfuscated_res_0x7f0f054b), this.i);
                            }
                            e55Var3.d.setTag(sparseArray5);
                            e55Var = e55Var3;
                        } else {
                            e55Var = null;
                        }
                        e55Var2 = null;
                    }
                    if (e55Var != null) {
                        arrayList.add(e55Var);
                    }
                    if (e55Var2 != null) {
                        arrayList.add(e55Var2);
                    }
                    vp9.b(arrayList, this.i, this.K, this.a);
                }
                List<e55> c2 = vp9.c(arrayList, this.K.p(), sparseArray, this.i);
                vp9.m(c2, this.g);
                vp9.f(c2);
                this.i.r(vp9.h(this.K));
                this.i.m(c2, true);
                this.h = new g55(getPageContext(), this.i);
                this.i.p(new x(this));
                this.h.l();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.a.L1()).param("fid", this.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.O());
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

    public final TbRichText y2(ArrayList<tha> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048668, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText f0 = arrayList.get(i3).f0();
                    if (f0 != null && (O = f0.O()) != null) {
                        int size = O.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (O.get(i5) != null && O.get(i5).getType() == 8) {
                                i4++;
                                if (!O.get(i5).U().N().equals(str) && !O.get(i5).U().O().equals(str)) {
                                    if (i4 > i2) {
                                        break;
                                    }
                                } else {
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    int width = O.get(i5).U().getWidth() * equipmentDensity;
                                    int height = O.get(i5).U().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.C = i5;
                                    return f0;
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

    public final int z2(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z2;
        TbRichTextImageInfo U;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048669, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.E = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.O().size();
                int i5 = i2;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.O().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.U().getWidth() * equipmentDensity;
                        int height = tbRichTextData.U().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2 && tbRichTextData.U().S()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = bj9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (U = tbRichTextData.U()) != null) {
                                        String N = U.N();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            N = U.O();
                                        } else {
                                            if (this.f) {
                                                i4 = 17;
                                            } else {
                                                i4 = 18;
                                            }
                                            imageUrlData.urlType = i4;
                                        }
                                        imageUrlData.imageUrl = N;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.imageThumbUrl = N;
                                        imageUrlData.originalUrl = D2(tbRichTextData);
                                        imageUrlData.originalSize = E2(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = B2(tbRichTextData);
                                        imageUrlData.isLongPic = A2(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = JavaTypesHelper.toLong(this.a.L1(), -1L);
                                        imageUrlData.mIsReserver = this.a.D1();
                                        imageUrlData.mIsSeeHost = this.a.U0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a2, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.E) {
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
