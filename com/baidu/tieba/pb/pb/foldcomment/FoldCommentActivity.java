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
import com.baidu.tbadk.baseEditMark.MarkData;
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
import com.baidu.tieba.a15;
import com.baidu.tieba.a65;
import com.baidu.tieba.af9;
import com.baidu.tieba.al5;
import com.baidu.tieba.at5;
import com.baidu.tieba.ax4;
import com.baidu.tieba.bh5;
import com.baidu.tieba.bl5;
import com.baidu.tieba.dh5;
import com.baidu.tieba.dh9;
import com.baidu.tieba.dm9;
import com.baidu.tieba.el5;
import com.baidu.tieba.f36;
import com.baidu.tieba.fl5;
import com.baidu.tieba.fl9;
import com.baidu.tieba.ft5;
import com.baidu.tieba.g06;
import com.baidu.tieba.gg9;
import com.baidu.tieba.hl5;
import com.baidu.tieba.i36;
import com.baidu.tieba.ij9;
import com.baidu.tieba.jg9;
import com.baidu.tieba.jn;
import com.baidu.tieba.k9;
import com.baidu.tieba.kj5;
import com.baidu.tieba.kl9;
import com.baidu.tieba.lj5;
import com.baidu.tieba.lj9;
import com.baidu.tieba.mj5;
import com.baidu.tieba.ng;
import com.baidu.tieba.nj9;
import com.baidu.tieba.nx4;
import com.baidu.tieba.oca;
import com.baidu.tieba.og;
import com.baidu.tieba.oj9;
import com.baidu.tieba.ok9;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.qf9;
import com.baidu.tieba.qk9;
import com.baidu.tieba.rg9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.ve5;
import com.baidu.tieba.vg5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vka;
import com.baidu.tieba.w55;
import com.baidu.tieba.wg;
import com.baidu.tieba.wka;
import com.baidu.tieba.wx9;
import com.baidu.tieba.xi;
import com.baidu.tieba.xm9;
import com.baidu.tieba.y55;
import com.baidu.tieba.yca;
import com.baidu.tieba.yi;
import com.baidu.tieba.yi9;
import com.baidu.tieba.z15;
import com.baidu.tieba.z55;
import com.baidu.tieba.z95;
import com.baidu.tieba.ze9;
import com.baidu.tieba.zg;
import com.baidu.tieba.zi5;
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
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, rg9<NewSubPbActivity>, TbRichTextView.t, p55.e, i36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId A;
    public PbModel.h B;
    public int C;
    public final TbRichTextView.z D;
    public boolean E;
    public gg9 F;
    public final View.OnLongClickListener G;
    public nj9 H;
    public jn I;
    public String J;
    public yca K;
    public a65.f L;
    public final k9 M;
    public bl5 N;
    public CustomMessageListener O;
    public NewWriteModel.d P;
    public View.OnClickListener Q;
    public al5 R;
    public final ax4.a S;
    public PbModel a;
    public dm9 b;
    public dh9 c;
    public ok9 d;
    public qk9 e;
    public boolean f;
    public boolean g;
    public y55 h;
    public a65 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public z95 l;
    public oca m;
    public ForumManageModel n;
    public wka o;
    public fl5 p;
    public el5 q;
    public boolean r;
    public lj9 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public ax4 y;
    public ng<ImageView> z;

    @Override // com.baidu.tieba.i36
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<TiebaPlusRecommendCard> G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.i36
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
        }
    }

    public boolean O2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<RelativeLayout> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<FestivalTipView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<View> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.i36
    public void Z(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048615, this, context, str, z) == null) {
        }
    }

    @Override // com.baidu.tieba.i36
    public ng<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public void e0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048624, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.i36
    public void i1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.i36
    public ng<ItemCardView> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.i36
    public ng<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i36
    public ng<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class h implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes7.dex */
        public class a implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                    kl9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ve5Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.z1() != null) {
                        statisticItem.param("fid", this.a.a.z1().l());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.S1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    lj9 lj9Var = this.a.s;
                    if (lj9Var != null) {
                        lj9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        dh5.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    p55 p55Var = new p55(this.a.getActivity());
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        p55Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        p55Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new a(this));
                    p55Var.setPositiveButton(R.string.open_now, new b(this));
                    p55Var.create(this.a.getPageContext()).show();
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
                    jg9.a(this.b.a.getPageContext(), this.a).show();
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
                zg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes7.dex */
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
                lj9 lj9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (lj9Var = this.a.c.s) != null && lj9Var.g() != null) {
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
                int j = yi.j(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.v().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i2, 50);
                if (this.c.c.x() != null) {
                    this.c.q.b().setVisibility(8);
                    this.c.c.x().t(this.a, this.b, this.c.c.y(), (this.c.a == null || this.c.a.z1() == null || this.c.a.z1().N() == null || !this.c.a.z1().N().isBjh()) ? false : false);
                    hl5 f = this.c.c.x().f();
                    if (f != null && this.c.a != null && this.c.a.z1() != null) {
                        f.J(this.c.a.z1().c());
                        f.f0(this.c.a.z1().N());
                    }
                    if (this.c.s.f() == null && this.c.c.x().f().u() != null) {
                        this.c.c.x().f().u().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.x().f().u().i());
                        this.c.c.x().f().P(this.c.R);
                    }
                }
                this.c.c.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes7.dex */
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
                lj9 lj9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (lj9Var = this.a.c.s) != null && lj9Var.g() != null) {
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
                int j = yi.j(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = j / 2;
                    g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i2 = j - (i + g);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.v().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i2, 50);
                if (this.c.c.x() != null) {
                    this.c.q.b().setVisibility(8);
                    this.c.c.x().t(this.a, this.b, this.c.c.y(), (this.c.a == null || this.c.a.z1() == null || this.c.a.z1().N() == null || !this.c.a.z1().N().isBjh()) ? false : false);
                    hl5 f = this.c.c.x().f();
                    if (f != null && this.c.a != null && this.c.a.z1() != null) {
                        f.J(this.c.a.z1().c());
                        f.f0(this.c.a.z1().N());
                    }
                    if (this.c.s.f() == null && this.c.c.x().f().u() != null) {
                        this.c.c.x().f().u().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.x().f().u().i());
                        this.c.c.x().f().P(this.c.R);
                    }
                }
                this.c.c.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends k9 {
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

        @Override // com.baidu.tieba.k9
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
                    this.a.a.d2();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    this.a.u2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.c.u(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) && p55Var != null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.b.c.c0();
                MessageManager.getInstance().sendMessage(this.a);
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements bl5 {
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

        @Override // com.baidu.tieba.bl5
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
        public void b(ze9 ze9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ze9Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, ze9 ze9Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ze9Var, str, Integer.valueOf(i4)}) != null) || this.a.c == null) {
                return;
            }
            this.a.c.T();
            if (z) {
                this.a.c.D();
                if (ze9Var != null) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    boolean z2 = true;
                    if (ze9Var.r() != 1) {
                        z2 = false;
                    }
                    foldCommentActivity.f = z2;
                    String str2 = null;
                    if (this.a.a != null && this.a.a.i2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.c != null) {
                        str2 = this.a.c.y();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.q.d0(TbSingleton.getInstance().getAdVertiComment(ze9Var.p0(), ze9Var.q0(), str2));
                    }
                    this.a.c.R(ze9Var, this.a.f);
                    return;
                }
                return;
            }
            this.a.W2(i, str);
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
                statisticItem2.param("tid", this.a.a.S1());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof yca) {
                        yca ycaVar = (yca) obj;
                        if (this.a.a == null || this.a.a.z1() == null || ycaVar.q() == null || ycaVar.I() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.x() != null) {
                            this.a.c.x().g();
                        }
                        qf9 qf9Var = new qf9();
                        qf9Var.v(this.a.a.z1().k());
                        qf9Var.z(this.a.a.z1().N());
                        qf9Var.x(ycaVar);
                        this.a.c.w().r0(qf9Var);
                        this.a.c.w().setPostId(ycaVar.S());
                        this.a.S2(view2, ycaVar.q().getUserId(), "", ycaVar);
                        TiebaStatic.log("c11743");
                        xm9.b(this.a.a.z1(), ycaVar, ycaVar.e0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.V(this.a.q.z());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091a92 && view2.getId() != R.id.obfuscated_res_0x7f091af2) {
                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0922b2 && view2.getId() != R.id.obfuscated_res_0x7f091a90 && view2.getId() != R.id.obfuscated_res_0x7f09190f) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f091af8 && view2.getId() != R.id.obfuscated_res_0x7f091cdc && view2.getId() != R.id.obfuscated_res_0x7f091a8a) {
                        if ((view2.getId() == R.id.obfuscated_res_0x7f090861 || view2.getId() == R.id.obfuscated_res_0x7f090b60) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof yca)) {
                            yca ycaVar2 = (yca) sparseArray.get(R.id.tag_load_sub_data);
                            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                            if (ycaVar2 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090862);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090863);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b60);
                            ycaVar2.f1(!ycaVar2.C0());
                            SkinManager.setBackgroundColor(findViewById, ycaVar2.C0() ? R.color.CAM_X0201 : R.color.transparent);
                            SkinManager.setViewTextColor(eMTextView, ycaVar2.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            WebPManager.setPureDrawable(imageView, ycaVar2.C0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, ycaVar2.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                            return;
                        }
                        return;
                    } else if (this.a.a == null) {
                        return;
                    } else {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091af8) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.S1());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091cdc) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091af8 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof yca) {
                                yca ycaVar3 = (yca) sparseArray2.get(R.id.tag_load_sub_data);
                                if (view2.getId() == R.id.obfuscated_res_0x7f091af8 && (statisticItem = ycaVar3.f0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cdc || view2.getId() == R.id.obfuscated_res_0x7f091a8a) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.T1()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", ycaVar3.S()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.z1() == null || ycaVar3.q() == null || ycaVar3.I() == 1) {
                                    return;
                                }
                                if (this.a.c.x() != null) {
                                    this.a.c.x().g();
                                }
                                qf9 qf9Var2 = new qf9();
                                qf9Var2.v(this.a.a.z1().k());
                                qf9Var2.z(this.a.a.z1().N());
                                qf9Var2.x(ycaVar3);
                                this.a.c.w().r0(qf9Var2);
                                this.a.c.w().setPostId(ycaVar3.S());
                                this.a.S2(view2, ycaVar3.q().getUserId(), "", ycaVar3);
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
                if (view2.getId() == R.id.obfuscated_res_0x7f09190f) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.S1());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f091a90 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    if (!this.a.checkUpIsLogin()) {
                        xm9.t("c10517", this.a.a.z1().l(), 3);
                    } else if (this.a.a == null || this.a.a.z1() == null) {
                    } else {
                        this.a.c.t();
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        yca ycaVar4 = (yca) sparseArray3.get(R.id.tag_load_sub_data);
                        yca ycaVar5 = (yca) sparseArray3.get(R.id.tag_load_sub_reply_data);
                        View view4 = (View) sparseArray3.get(R.id.tag_load_sub_view);
                        if (ycaVar4 == null || view4 == null) {
                            return;
                        }
                        if (ycaVar4.M() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem5 = ycaVar4.f0;
                        if (statisticItem5 != null) {
                            StatisticItem copy2 = statisticItem5.copy();
                            copy2.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f09190f) {
                                copy2.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091a90) {
                                copy2.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy2);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091a90 && this.a.a != null && this.a.a.z1() != null && ycaVar4 != null) {
                            TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.S1()).param("fname", this.a.a.z1().m()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", ycaVar4.S()));
                        }
                        String S1 = this.a.a.S1();
                        String S = ycaVar4.S();
                        String S2 = ycaVar5 != null ? ycaVar5.S() : "";
                        int V = this.a.a.z1() != null ? this.a.a.z1().V() : 0;
                        this.a.M();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091ec6) {
                            if (view2.getId() != R.id.obfuscated_res_0x7f091a90 || !this.a.r) {
                                TiebaStatic.log("c11742");
                                AbsPbActivity.e Z2 = this.a.Z2(S);
                                if (ycaVar4 == null || this.a.a == null || this.a.a.z1() == null || Z2 == null) {
                                    return;
                                }
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S1, S, "pb", true, this.a.r, null, false, S2, V, ycaVar4.l0(), this.a.a.z1().c(), false, ycaVar4.q().getIconInfo(), 5).addBigImageData(Z2.a, Z2.b, Z2.g, Z2.j);
                                if (!xi.isEmpty(S2)) {
                                    addBigImageData.setHighLightPostId(S2);
                                    addBigImageData.setKeyIsUseSpid(true);
                                }
                                addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                                addBigImageData.setTiebaPlusData(this.a.a.e0(), this.a.a.a0(), this.a.a.b0(), this.a.a.Z(), this.a.a.f0());
                                addBigImageData.setBjhData(this.a.a.R0());
                                addBigImageData.setKeyPageStartFrom(this.a.a.y1());
                                addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                                addBigImageData.setWorksInfoData(this.a.a.X1());
                                addBigImageData.setFromFoldComment(true);
                                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            AbsPbActivity.e Z22 = this.a.Z2(S);
                            if (this.a.a == null || this.a.a.z1() == null || Z22 == null) {
                                return;
                            }
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S1, S, "pb", true, this.a.r, null, true, null, V, ycaVar4.l0(), this.a.a.z1().c(), false, ycaVar4.q().getIconInfo(), 5).addBigImageData(Z22.a, Z22.b, Z22.g, Z22.j);
                            addBigImageData2.setKeyPageStartFrom(this.a.a.y1());
                            addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.a.a.X1());
                            addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                            addBigImageData2.setBjhData(this.a.a.R0());
                            addBigImageData2.setTiebaPlusData(this.a.a.e0(), this.a.a.a0(), this.a.a.b0(), this.a.a.Z(), this.a.a.f0());
                            addBigImageData2.setFromFoldComment(true);
                            addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                            return;
                        }
                        AbsPbActivity.e Z23 = this.a.Z2(S);
                        if (this.a.a == null || this.a.a.z1() == null || Z23 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S1, S, "pb", true, this.a.r, null, true, null, V, ycaVar4.l0(), this.a.a.z1().c(), false, ycaVar4.q().getIconInfo(), 5).addBigImageData(Z23.a, Z23.b, Z23.g, Z23.j);
                        addBigImageData3.setKeyPageStartFrom(this.a.a.y1());
                        addBigImageData3.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.a.a.X1());
                        addBigImageData3.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData3.setBjhData(this.a.a.R0());
                        addBigImageData3.setTiebaPlusData(this.a.a.e0(), this.a.a.a0(), this.a.a.b0(), this.a.a.Z(), this.a.a.f0());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.S1());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.z1() != null && this.a.K != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.S1()).param("fname", this.a.a.z1().m()).param("fid", this.a.a.z1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.K.S()));
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

    /* loaded from: classes7.dex */
    public class o implements al5 {
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

        @Override // com.baidu.tieba.al5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                lj9 lj9Var = this.a.s;
                if (lj9Var != null && lj9Var.g() != null && this.a.s.g().d()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                    if (this.a.c != null && this.a.c.x() != null && this.a.c.x().f() != null && this.a.c.x().f().z()) {
                        this.a.c.x().f().w(this.a.s.h());
                    }
                    this.a.s.b(true);
                    return true;
                }
                return !this.a.n2(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p implements ax4.a {
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

        @Override // com.baidu.tieba.ax4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.y != null) {
                        this.a.y.h(z2);
                    }
                    this.a.a.n3(z2);
                    if (this.a.a.k1()) {
                        this.a.T2();
                    }
                    if (z2) {
                        if (this.a.y != null) {
                            if (this.a.y.f() != null && this.a.a != null && this.a.a.z1() != null && this.a.a.z1().N() != null && this.a.a.z1().N().getAuthor() != null) {
                                MarkData f = this.a.y.f();
                                MetaData author = this.a.a.z1().N().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
                                        if (vg5.g(this.a.getActivity(), 0)) {
                                            vg5.h(this.a.getPageContext(), 6, 2000L);
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

    /* loaded from: classes7.dex */
    public class q implements og<ImageView> {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
                    if (a15.c().g()) {
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = a15.c().g();
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
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
                        boolean y = ((TbImageView) view2).y();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, y)));
                            return;
                        }
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.X2(str, i, eVar);
                    if (this.a.a.z1().i0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().Z() != null) {
                            ArrayList<TbRichTextImageInfo> Z = tbRichTextView.getRichText().Z();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < Z.size()) {
                                if (Z.get(i5) != null) {
                                    arrayList.add(Z.get(i5).getSrc());
                                    if (i6 == i4 && str != null && (str.equals(Z.get(i5).getSrc()) || str.equals(Z.get(i5).W()) || str.equals(Z.get(i5).V()) || str.equals(Z.get(i5).getBigSrc()) || str.equals(Z.get(i5).Y()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData3 = new ImageUrlData();
                                    String src = Z.get(i5).getSrc();
                                    imageUrlData3.imageUrl = src;
                                    imageUrlData3.imageThumbUrl = src;
                                    if (this.a.f) {
                                        i3 = 17;
                                    } else {
                                        i3 = 18;
                                    }
                                    imageUrlData3.urlThumbType = i3;
                                    imageUrlData3.originalUrl = Z.get(i5).getSrc();
                                    imageUrlData3.isLongPic = Z.get(i5).c0();
                                    concurrentHashMap.put(Z.get(i5).getSrc(), imageUrlData3);
                                }
                                i5++;
                                i4 = -1;
                            }
                            i2 = i6;
                        } else {
                            i2 = -1;
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i2);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.a.K1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.N2());
                        if (this.a.a != null) {
                            builder.D(this.a.a.getFromForumId());
                            if (this.a.a.z1() != null) {
                                builder.Q(this.a.a.z1().N());
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
                        if (!ListUtils.isEmpty(arrayList2) && (imageUrlData2 = eVar.b.get((str3 = (String) arrayList2.get(0)))) != null) {
                            concurrentHashMap2.put(str3, imageUrlData2);
                        }
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList2);
                        builder2.C(eVar.c);
                        builder2.B(eVar.d);
                        builder2.R(eVar.e);
                        builder2.F(eVar.g);
                        builder2.K(true);
                        builder2.M(eVar.a.get(0));
                        builder2.I(this.a.a.K1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.N2());
                        builder2.z(eVar.f);
                        builder2.O(eVar.f);
                        builder2.G(false);
                        if (this.a.a != null) {
                            builder2.D(this.a.a.getFromForumId());
                            if (this.a.a.z1() != null) {
                                builder2.Q(this.a.a.z1().N());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText m3 = this.a.m3(str, i);
                        if (m3 != null && this.a.C >= 0 && this.a.C < m3.X().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = af9.a(m3.X().get(this.a.C));
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
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.a.K1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.N2());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a != null) {
                                builder3.D(this.a.a.getFromForumId());
                                if (this.a.a.z1() != null) {
                                    builder3.Q(this.a.a.z1().N());
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
                    this.a.q.H(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.c != null && this.a.c.x() != null && this.a.c.x().f() != null) {
                    this.a.c.x().f().I();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements PbFragment.e3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.e3
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
                String valueOf = String.valueOf(this.a.a.z1().U().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.z1().k().getId(), this.a.a.z1().k().getName(), this.a.a.z1().N().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements gg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.gg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.gg9.a
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

        @Override // com.baidu.tieba.gg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ee7) {
                        if (this.a.b3(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a8f) {
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
                    this.a.c.V(this.a.q.z());
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
            return this.a.q2(view2);
        }
    }

    /* loaded from: classes7.dex */
    public class w implements a65.d {
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

        @Override // com.baidu.tieba.a65.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null) {
                this.a.i.r(fl9.g(this.a.K));
                ArrayList arrayList = new ArrayList();
                for (z55 z55Var : this.a.i.g()) {
                    if (z55Var instanceof w55) {
                        arrayList.add((w55) z55Var);
                    }
                }
                fl9.e(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements a65.f {
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

        @Override // com.baidu.tieba.a65.f
        public void L0(a65 a65Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a65Var, i, view2) == null) {
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
                                foldCommentActivity.H = new nj9(foldCommentActivity.getPageContext());
                            }
                            this.a.H.b(this.a.J, this.a.I.n());
                            this.a.I = null;
                            this.a.J = null;
                            return;
                        }
                        return;
                    case 3:
                        yca ycaVar = this.a.K;
                        if (ycaVar != null) {
                            ycaVar.P0();
                            this.a.K = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.U2(view2);
                            if (this.a.a.z1().N() != null && this.a.a.z1().N().getAuthor() != null && this.a.a.z1().N().getAuthor().getUserId() != null && this.a.y != null) {
                                FoldCommentActivity foldCommentActivity2 = this.a;
                                int G2 = foldCommentActivity2.G2(foldCommentActivity2.a.z1());
                                ThreadData N = this.a.a.z1().N();
                                if (N.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (N.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!N.isBJHNormalThreadType()) {
                                    if (N.isBJHVideoDynamicThreadType()) {
                                        i2 = 5;
                                    } else {
                                        i2 = 1;
                                    }
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.S1()).param("obj_locate", 2).param("obj_id", this.a.a.z1().N().getAuthor().getUserId()).param("obj_type", !this.a.y.e()).param("obj_source", G2).param("obj_param1", i2));
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
                            boolean F = this.a.F(TbadkCoreApplication.getCurrentAccount());
                            if (F) {
                                if (booleanValue2) {
                                    this.a.c.M(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, F);
                                    return;
                                } else {
                                    this.a.f3(sparseArray3, intValue, booleanValue);
                                    return;
                                }
                            } else if (!booleanValue || booleanValue2) {
                                this.a.c.K(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
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
                        yca ycaVar2 = (yca) sparseArray.get(R.id.tag_clip_board);
                        if (ycaVar2.o() != null) {
                            this.a.o2(ycaVar2.o());
                            return;
                        }
                        return;
                    case 9:
                        if (this.a.checkUpIsLogin() && this.a.a != null && this.a.a.z1() != null) {
                            this.a.e3(vka.c(view2));
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                if (p55Var != null) {
                    p55Var.dismiss();
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
        this.C = 0;
        this.D = new r(this);
        this.E = false;
        this.F = new gg9(new u(this));
        this.G = new v(this);
        this.K = null;
        this.L = new x(this);
        this.M = new b(this);
        this.N = new f(this);
        this.O = new g(this, 2004008);
        this.P = new h(this);
        this.Q = new l(this);
        this.R = new o(this);
        this.S = new p(this);
    }

    public void Y2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.z1() == null || this.a.z1().k() == null || k2()) {
            return;
        }
        if (this.a.z1().i0()) {
            this.c.s();
            return;
        }
        el5 el5Var = this.q;
        if (el5Var != null && el5Var.b() != null) {
            this.q.b().D(new zi5(45, 27, null));
        }
        this.c.s();
    }

    public final boolean A2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return false;
            }
            return tbRichTextData.d0().d0();
        }
        return invokeL.booleanValue;
    }

    public final String C2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return null;
            }
            return tbRichTextData.d0().Y();
        }
        return (String) invokeL.objValue;
    }

    public final long D2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return 0L;
            }
            return tbRichTextData.d0().getOriginalSize();
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.rg9
    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bundle)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            nx4.y(this, "", str, false, true, true, bundle);
        }
    }

    public final void U2(View view2) {
        SparseArray sparseArray;
        yca ycaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (ycaVar = (yca) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            V2(ycaVar);
        }
    }

    public final void d3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.q.Y(z);
            this.q.b0(z);
            this.q.j0(z);
        }
    }

    public void e3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, str) == null) && str != null && this.o != null) {
            this.o.n(wg.g(str, 0L));
        }
    }

    public void j3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.A);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.p55.e
    public void onClick(p55 p55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, p55Var) == null) {
            s2(p55Var, null);
        }
    }

    public final boolean z2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return false;
            }
            return tbRichTextData.d0().c0();
        }
        return invokeL.booleanValue;
    }

    public PbModel B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public el5 E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q;
        }
        return (el5) invokeV.objValue;
    }

    public qk9 F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (qk9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg9
    public ok9 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (ok9) invokeV.objValue;
    }

    public final void M() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.c1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (pbModel = this.a) != null) {
            pbModel.z2();
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            ze9 z1 = this.a.z1();
            this.a.n3(true);
            ax4 ax4Var = this.y;
            if (ax4Var != null) {
                z1.J0(ax4Var.g());
            }
        }
    }

    @Override // com.baidu.tieba.i36
    public ng<ImageView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.z == null) {
                this.z = new ng<>(new q(this), 8, 0);
            }
            return this.z;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg9
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.Y0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg9
    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.z1() != null) {
                return this.a.z1().V();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            super.onPause();
            if (this.r) {
                j3(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            super.onResume();
            if (this.r) {
                j3(true);
            }
        }
    }

    public AntiData v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.z1() != null) {
                return this.a.z1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg9
    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.r2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void C0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (f36[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), f36.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (oj9.c(objArr[i2].f()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new g06(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final int G2(ze9 ze9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, ze9Var)) == null) {
            if (ze9Var != null && ze9Var.N() != null) {
                if (ze9Var.N().getThreadType() == 0) {
                    return 1;
                }
                if (ze9Var.N().getThreadType() == 54) {
                    return 2;
                }
                if (ze9Var.N().getThreadType() == 40) {
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
        if ((interceptable != null && interceptable.invokeL(1048618, this, view2) != null) || view2 == null) {
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
        yca ycaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048631, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof yca) || (ycaVar = (yca) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        i3(ycaVar, false);
    }

    public final void k3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.S1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fl9.m(i2))));
        }
    }

    public void l2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = wg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = wg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void H2(int i2, Intent intent) {
        mj5 mj5Var;
        mj5 mj5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, intent) == null) {
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
                    hl5 f2 = this.c.x().f();
                    f2.f0(this.a.z1().N());
                    f2.D(writeData);
                    f2.g0(pbEditorData.getVoiceModel());
                    lj5 p2 = f2.b().p(6);
                    if (p2 != null && (mj5Var2 = p2.m) != null) {
                        mj5Var2.B(new zi5(52, 0, pbEditorData.getVoiceModel()));
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
            lj5 p3 = this.q.b().p(6);
            if (p3 != null && (mj5Var = p3.m) != null) {
                mj5Var.B(new zi5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.q.H(null, null);
            }
        }
    }

    public final void i3(yca ycaVar, boolean z) {
        PbModel pbModel;
        int i2;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048635, this, ycaVar, z) != null) || ycaVar == null || (pbModel = this.a) == null || pbModel.z1() == null || ycaVar.I() == 1) {
            return;
        }
        String S1 = this.a.S1();
        String S = ycaVar.S();
        if (this.a.z1() != null) {
            i2 = this.a.z1().V();
        } else {
            i2 = 0;
        }
        AbsPbActivity.e Z2 = Z2(S);
        if (Z2 == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this);
        boolean z2 = this.r;
        SmallTailInfo l0 = ycaVar.l0();
        AntiData c2 = this.a.z1().c();
        if (ycaVar.q() != null) {
            arrayList = ycaVar.q().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(S1, S, "pb", true, z2, null, false, null, i2, l0, c2, false, arrayList, 5).addBigImageData(Z2.a, Z2.b, Z2.g, Z2.j);
        addBigImageData.setKeyPageStartFrom(this.a.y1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.X1());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.R0());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void r2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048656, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(ij9.i2)).intValue();
            if (intValue == ij9.j2) {
                if (this.n.o0()) {
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
                    this.n.q0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.r0(this.a.z1().k().getId(), this.a.z1().k().getName(), this.a.z1().N().getId(), str, intValue3, intValue2, booleanValue, this.a.z1().N().getBaijiahaoData(), z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == ij9.k2 || intValue == ij9.m2) {
                if (this.a.U0() != null) {
                    this.a.U0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ij9.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void u2(ForumManageModel.b bVar, boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048659, this, bVar, z) != null) || bVar == null) {
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
            p55 p55Var = new p55(getPageContext().getPageActivity());
            p55Var.setMessage(string);
            p55Var.setPositiveButton(R.string.dialog_known, new c(this));
            p55Var.setCancelable(true);
            p55Var.create(getPageContext());
            p55Var.show();
        } else if (bVar.d != 0) {
            this.c.u(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<yca> F = this.a.z1().F();
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
                this.a.z1().N().setReply_num(this.a.z1().N().getReply_num() - 1);
            } else if (i3 == 0) {
                p2();
            } else if (i3 == 2) {
                ArrayList<yca> F2 = this.a.z1().F();
                int size2 = F2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= F2.get(i4).i0().size()) {
                            break;
                        } else if (bVar.g.equals(F2.get(i4).i0().get(i5).S())) {
                            F2.get(i4).i0().remove(i5);
                            F2.get(i4).h();
                            z2 = true;
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

    public void I2(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
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
        if (interceptable == null || interceptable.invokeIIL(1048647, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.D(i2, i3, intent);
            if (this.c.x() != null) {
                this.c.x().k(i2, i3, intent);
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
                                wx9.g().m(getPageContext());
                                l3();
                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                    shareSuccessReplyToServerModel.V(str, intExtra, new j(this));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    wx9.g().m(getPageContext());
                    return;
                }
                yi9.b().k();
                this.mHandler.postDelayed(new i(this), 1000L);
            }
        }
    }

    public final void J2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.z1() != null && this.a.z1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.S1(), str);
                ThreadData N = this.a.z1().N();
                if (N.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (N.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (N.isBJHVideoThreadType()) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.z1() != null) {
                if (this.a.z1().V() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || this.a.z1().N() == null || this.a.z1().N().getAuthor() == null || TextUtils.equals(this.a.z1().N().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                return !z;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void V2(yca ycaVar) {
        boolean z;
        ax4 ax4Var;
        yca w2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, ycaVar) != null) || ycaVar == null) {
            return;
        }
        if (ycaVar.S() != null && ycaVar.S().equals(this.a.u1())) {
            z = true;
        } else {
            z = false;
        }
        MarkData t1 = this.a.t1(ycaVar);
        if (this.a.z1() != null && this.a.z1().i0() && (w2 = w2()) != null) {
            t1 = this.a.t1(w2);
        }
        if (t1 != null && (ax4Var = this.y) != null) {
            ax4Var.i(t1);
            if (!z) {
                this.y.a();
            } else {
                this.y.d();
            }
        }
    }

    public final void K2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            this.k = getUniqueId();
            ax4 c2 = ax4.c(this);
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
            this.a.i3(true);
            this.a.k3(4);
        }
    }

    public final void c3(fl5 fl5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, fl5Var) == null) && fl5Var != null && (pbModel = this.a) != null) {
            fl5Var.p(pbModel.Y0());
            if (this.a.z1() != null && this.a.z1().k() != null) {
                fl5Var.o(this.a.z1().k());
            }
            fl5Var.q("pb");
            fl5Var.r(this.a);
        }
    }

    public boolean n2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i2)) == null) {
            if (this.u != null && this.a.z1() != null && !ThreadCardUtils.isSelf(this.a.z1().N()) && this.a.z1().c() != null) {
                return this.u.checkPrivacyBeforeSend(this.a.z1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void M2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            this.d = new ok9(this);
            this.e = new qk9(getPageContext());
            dh9 dh9Var = new dh9(this, this.Q, this.D, this.F, this.G);
            this.c = dh9Var;
            dh9Var.X(this.a);
            setContentView(this.c.z(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.r();
            this.c.U(new t(this));
            fl5 fl5Var = new fl5();
            this.p = fl5Var;
            c3(fl5Var);
            el5 el5Var = (el5) this.p.a(getActivity());
            this.q = el5Var;
            el5Var.X(getPageContext());
            this.q.h0(this.N);
            this.q.Z(1);
            this.q.B(getPageContext(), bundle);
            this.q.b().b(new kj5(getActivity()));
            this.q.b().F(true);
            d3(true);
            this.q.K(this.a.b1(), this.a.S1(), this.a.X0());
            this.c.S(this.q.b());
            this.s = new lj9();
            if (this.q.s() != null) {
                this.s.m(this.q.s().i());
            }
            registerListener(this.O);
            if (!this.a.m1()) {
                this.q.q(this.a.S1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.i2()) {
                this.q.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                dh9 dh9Var2 = this.c;
                if (dh9Var2 != null) {
                    this.q.d0(dh9Var2.y());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    public final void S2(View view2, String str, String str2, yca ycaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048603, this, view2, str, str2, ycaVar) != null) || view2 == null || str == null || str2 == null || !m2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.w);
            this.x = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.x() != null && ycaVar != null) {
            if (ycaVar.e0() != null) {
                str3 = ycaVar.e0().toString();
            } else {
                str3 = "";
            }
            this.c.x().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), ycaVar.q().getName_show(), str3));
        }
        if (this.a.z1() != null && this.a.z1().i0()) {
            zg.a().postDelayed(new m(this, str, str2), 0L);
        } else {
            zg.a().postDelayed(new n(this, str, str2), 0L);
        }
    }

    public void t2(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(ij9.i2, Integer.valueOf(ij9.j2));
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
        if (interceptable == null || interceptable.invokeIL(1048610, this, i2, str) == null) {
            if (this.a.Z1()) {
                showToast(str);
            } else if (yi.G()) {
                if (i2 == 4) {
                    dh9 dh9Var = this.c;
                    dh9Var.f0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    dh9 dh9Var2 = this.c;
                    dh9Var2.f0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.c.e0(R.string.no_data_text);
                }
            } else {
                this.c.e0(R.string.recommend_pb_no_net_text);
            }
        }
    }

    public final void X2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048612, this, str, i2, eVar) != null) || eVar == null) {
            return;
        }
        ze9 z1 = this.a.z1();
        TbRichText m3 = m3(str, i2);
        if (m3 == null || (tbRichTextData = m3.X().get(this.C)) == null) {
            return;
        }
        eVar.f = String.valueOf(m3.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.d0().b0()) {
            eVar.h = false;
            String a2 = af9.a(tbRichTextData);
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
            imageUrlData.originalUrl = C2(tbRichTextData);
            imageUrlData.originalUrl = C2(tbRichTextData);
            imageUrlData.originalSize = D2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = A2(tbRichTextData);
            imageUrlData.isLongPic = z2(tbRichTextData);
            imageUrlData.postId = m3.getPostId();
            imageUrlData.mIsReserver = this.a.K1();
            imageUrlData.mIsSeeHost = this.a.c1();
            eVar.b.put(a2, imageUrlData);
            if (z1 != null) {
                if (z1.k() != null) {
                    eVar.c = z1.k().getName();
                    eVar.d = z1.k().getId();
                }
                if (z1.N() != null) {
                    eVar.e = z1.N().getId();
                }
                if (z1.r() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = wg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = z1.F().size();
        this.E = false;
        eVar.j = -1;
        if (z1.i() != null) {
            i3 = y2(z1.i().e0(), m3, i2, i2, eVar.a, eVar.b);
        } else {
            i3 = i2;
        }
        int i5 = i3;
        for (int i6 = 0; i6 < size; i6++) {
            yca ycaVar = z1.F().get(i6);
            if (ycaVar.S() == null || z1.i() == null || z1.i().S() == null || !ycaVar.S().equals(z1.i().S())) {
                i5 = y2(ycaVar.e0(), m3, i5, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (z1 != null) {
            if (z1.k() != null) {
                eVar.c = z1.k().getName();
                eVar.d = z1.k().getId();
            }
            if (z1.N() != null) {
                eVar.e = z1.N().getId();
            }
            if (z1.r() == 1) {
                z = true;
            }
            eVar.g = z;
        }
        eVar.j = i5;
    }

    public final AbsPbActivity.e Z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            String str2 = null;
            if (this.a.z1() != null && this.a.z1().F() != null && this.a.z1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 < this.a.z1().F().size()) {
                        if (str.equals(this.a.z1().F().get(i2).S())) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                yca ycaVar = this.a.z1().F().get(i2);
                if (ycaVar.e0() != null && ycaVar.e0().X() != null) {
                    Iterator<TbRichTextData> it = ycaVar.e0().X().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.d0() != null) {
                                str2 = next.d0().W();
                            }
                        }
                    }
                    X2(str2, 0, eVar);
                    af9.b(ycaVar, eVar);
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
        if (interceptable == null || interceptable.invokeL(1048650, this, bundle) == null) {
            L2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            K2(bundle);
            M2(bundle);
            R2();
            if (this.r) {
                this.c.z().setAnimTime(0);
                this.c.z().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.A = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.z().h();
            this.c.w().setFromForumId(this.a.getFromForumId());
            dm9 dm9Var = new dm9(this);
            this.b = dm9Var;
            dm9Var.b(getUniqueId());
            this.o = new wka(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.d0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.d0(this.c.y());
            }
            bh5.b(false);
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
            if (!(obj instanceof yca)) {
                return false;
            }
            yca ycaVar = (yca) obj;
            if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.z1() != null) {
                if (this.c.x() != null) {
                    this.c.x().g();
                }
                qf9 qf9Var = new qf9();
                qf9Var.v(this.a.z1().k());
                qf9Var.z(this.a.z1().N());
                qf9Var.x(ycaVar);
                TiebaStatic.log("c11743");
                this.c.w().r0(qf9Var);
                this.c.w().setPostId(ycaVar.S());
                S2(view2, ycaVar.q().getUserId(), "", ycaVar);
                el5 el5Var = this.q;
                if (el5Var != null) {
                    this.c.V(el5Var.z());
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
        at5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048646, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new z95();
        }
        if (this.m == null) {
            oca ocaVar = new oca();
            this.m = ocaVar;
            ocaVar.a = getUniqueId();
        }
        z15 z15Var = new z15();
        z15Var.b = 5;
        z15Var.h = 8;
        z15Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            z15Var.f = pbModel2.y1();
        }
        z15Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                z15Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel == null && pbModel.z1() != null) {
                    this.l.b(this, z15Var, agreeData, this.a.z1().N());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            z15Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            z15Var.i = 1;
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
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            fl9.d(getActivity(), getPageContext(), new y(this, sparseArray, i2, z), new a(this));
        }
    }

    public final void g3(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.c0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            p55 p55Var = new p55(this);
            if (!xi.isEmpty(str)) {
                p55Var.setMessage(str);
            } else {
                p55Var.setMessage(getResources().getString(R.string.block_mute_message_alert, str3));
            }
            p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new d(this, userMuteAddAndDelCustomMessage));
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new e(this));
            p55Var.create(getPageContext()).show();
        }
    }

    public final void i2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (pbModel = this.a) != null && pbModel.z1() != null && this.a.z1().N() != null) {
            ThreadData N = this.a.z1().N();
            N.mRecomAbTag = this.a.E1();
            N.mRecomWeight = this.a.H1();
            N.mRecomSource = this.a.G1();
            N.mRecomExtra = this.a.F1();
            N.isSubPb = this.a.m1();
            if (N.getFid() == 0) {
                N.setFid(wg.g(this.a.getForumId(), 0L));
            }
            StatisticItem i2 = ft5.i(this, N, "c13562");
            TbPageTag l2 = ft5.l(this);
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

    public yca w2() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.z1() != null && this.a.z1().N() != null && this.a.z1().N().getAuthor() != null) {
                yca ycaVar = new yca();
                MetaData author = this.a.z1().N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = this.a.z1().N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                ycaVar.S0(1);
                ycaVar.Y0(this.a.z1().N().getFirstPostId());
                ycaVar.p1(this.a.z1().N().getTitle());
                ycaVar.o1(this.a.z1().N().getCreateTime());
                ycaVar.N0(author);
                return ycaVar;
            }
            return null;
        }
        return (yca) invokeV.objValue;
    }

    public final void j2(ze9 ze9Var, ArrayList<yca> arrayList) {
        List<yca> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048636, this, ze9Var, arrayList) == null) && ze9Var != null && ze9Var.S() != null && ze9Var.S().a != null && (list = ze9Var.S().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<yca> it = arrayList.iterator();
                while (it.hasNext()) {
                    yca next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            yca ycaVar = (yca) it2.next();
                            if (ycaVar != null && !TextUtils.isEmpty(next.S()) && !TextUtils.isEmpty(ycaVar.S()) && next.S().equals(ycaVar.S())) {
                                arrayList2.add(ycaVar);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.z1() == null) {
                return false;
            }
            ThreadData N = this.a.z1().N();
            AntiData c2 = this.a.z1().c();
            if (!AntiHelper.b(getPageContext(), N) && !AntiHelper.d(getPageContext(), c2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.a0(this.a.getForumId()) && this.a.z1() != null && this.a.z1().k() != null) {
            boolean z = true;
            if (this.a.z1().k().isLike() != 1) {
                z = false;
            }
            if (z) {
                this.a.N0().Z(this.a.getForumId(), this.a.S1());
            }
        }
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if ((this.a.z1() != null && (this.a.z1().i0() || ThreadCardUtils.isSelf(this.a.z1().N()))) || this.u == null || this.a.z1() == null || this.a.z1().c() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.z1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            if (this.a.e1() || this.a.h1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.S1());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.S1()));
            finish();
        }
    }

    public final TbRichText m3(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048643, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.z1() == null || str == null || i2 < 0) {
                return null;
            }
            ze9 z1 = this.a.z1();
            if (z1.i() != null) {
                ArrayList<yca> arrayList = new ArrayList<>();
                arrayList.add(z1.i());
                tbRichText = x2(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<yca> F = z1.F();
                j2(z1, F);
                return x2(F, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void s2(p55 p55Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, p55Var, jSONArray) == null) {
            p55Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(p55Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                r2((SparseArray) p55Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean q2(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
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
        int i2;
        boolean z10;
        w55 w55Var;
        w55 w55Var2;
        w55 w55Var3;
        jn jnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            yca ycaVar = (yca) sparseArray.get(R.id.tag_clip_board);
            this.K = ycaVar;
            if (ycaVar == null || this.y == null) {
                return true;
            }
            if (this.i == null) {
                a65 a65Var = new a65(this);
                this.i = a65Var;
                a65Var.q(this.L);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                boolean O2 = O2(view2);
                if (O2(view2) && (jnVar = this.I) != null && !jnVar.t()) {
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
                if (O2) {
                    z9 = z2;
                    arrayList.add(new w55(1, getString(R.string.save_to_emotion), this.i));
                } else {
                    z9 = z2;
                }
                if (z) {
                    arrayList.add(new w55(2, getString(R.string.save_to_local), this.i));
                }
                if (!O2 && !z) {
                    w55 w55Var4 = new w55(3, getString(R.string.obfuscated_res_0x7f0f04e1), this.i);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, this.K);
                    w55Var4.d.setTag(sparseArray2);
                    arrayList.add(w55Var4);
                }
                if (this.mIsLogin) {
                    if (!fl9.i(this.a) && !z5 && z4) {
                        w55 w55Var5 = new w55(5, getString(R.string.obfuscated_res_0x7f0f0cfb), this.i);
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
                        w55Var5.d.setTag(sparseArray3);
                        arrayList.add(w55Var5);
                    } else {
                        if (P2(z3) && TbadkCoreApplication.isLogin()) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            w55 w55Var6 = new w55(5, getString(R.string.report_text), this.i);
                            w55Var6.d.setTag(str);
                            arrayList.add(w55Var6);
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
                        if (!fl9.i(this.a) && z6) {
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
                                w55Var = new w55(6, getString(R.string.obfuscated_res_0x7f0f0546), this.i);
                                w55Var.d.setTag(sparseArray4);
                                w55Var2 = new w55(7, getString(R.string.obfuscated_res_0x7f0f0322), this.i);
                                w55Var2.d.setTag(sparseArray4);
                            }
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        w55Var = null;
                        w55Var2 = new w55(7, getString(R.string.obfuscated_res_0x7f0f0322), this.i);
                        w55Var2.d.setTag(sparseArray4);
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
                            if (this.a.z1().V() == 1002 && !z3) {
                                w55Var3 = new w55(6, getString(R.string.report_text), this.i);
                            } else {
                                w55Var3 = new w55(6, getString(R.string.obfuscated_res_0x7f0f0546), this.i);
                            }
                            w55Var3.d.setTag(sparseArray5);
                            w55Var = w55Var3;
                        } else {
                            w55Var = null;
                        }
                        w55Var2 = null;
                    }
                    if (w55Var != null) {
                        arrayList.add(w55Var);
                    }
                    if (w55Var2 != null) {
                        arrayList.add(w55Var2);
                    }
                    fl9.b(arrayList, this.i, this.K, this.a);
                }
                List<w55> c2 = fl9.c(arrayList, this.K.o(), sparseArray, this.i);
                fl9.l(c2, this.g);
                fl9.e(c2);
                this.i.r(fl9.g(this.K));
                this.i.m(c2, true);
                this.h = new y55(getPageContext(), this.i);
                this.i.p(new w(this));
                this.h.l();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.a.S1()).param("fid", this.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.X());
                if (z9) {
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

    public final TbRichText x2(ArrayList<yca> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048663, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText e0 = arrayList.get(i3).e0();
                    if (e0 != null && (X = e0.X()) != null) {
                        int size = X.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (X.get(i5) != null && X.get(i5).getType() == 8) {
                                i4++;
                                if (!X.get(i5).d0().W().equals(str) && !X.get(i5).d0().X().equals(str)) {
                                    if (i4 > i2) {
                                        break;
                                    }
                                } else {
                                    int i6 = (int) yi.i(TbadkCoreApplication.getInst());
                                    int width = X.get(i5).d0().getWidth() * i6;
                                    int height = X.get(i5).d0().getHeight() * i6;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.C = i5;
                                    return e0;
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
        TbRichTextImageInfo d0;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048665, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.E = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.X().size();
                int i5 = i2;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.X().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int i8 = (int) yi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.d0().getWidth() * i8;
                        int height = tbRichTextData.d0().getHeight() * i8;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.d0().b0()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = af9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (d0 = tbRichTextData.d0()) != null) {
                                        String W = d0.W();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            W = d0.X();
                                        } else {
                                            if (this.f) {
                                                i4 = 17;
                                            } else {
                                                i4 = 18;
                                            }
                                            imageUrlData.urlType = i4;
                                        }
                                        imageUrlData.imageUrl = W;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.imageThumbUrl = W;
                                        imageUrlData.originalUrl = C2(tbRichTextData);
                                        imageUrlData.originalSize = D2(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = A2(tbRichTextData);
                                        imageUrlData.isLongPic = z2(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = wg.g(this.a.S1(), -1L);
                                        imageUrlData.mIsReserver = this.a.K1();
                                        imageUrlData.mIsSeeHost = this.a.c1();
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
