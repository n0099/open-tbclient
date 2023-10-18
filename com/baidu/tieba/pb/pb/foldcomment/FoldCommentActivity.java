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
import com.baidu.tieba.ad;
import com.baidu.tieba.cd5;
import com.baidu.tieba.df5;
import com.baidu.tieba.dk9;
import com.baidu.tieba.dn9;
import com.baidu.tieba.ef5;
import com.baidu.tieba.fm9;
import com.baidu.tieba.g4;
import com.baidu.tieba.gk9;
import com.baidu.tieba.hf5;
import com.baidu.tieba.hna;
import com.baidu.tieba.hz4;
import com.baidu.tieba.if5;
import com.baidu.tieba.ik9;
import com.baidu.tieba.ina;
import com.baidu.tieba.jk9;
import com.baidu.tieba.kf5;
import com.baidu.tieba.km9;
import com.baidu.tieba.lh9;
import com.baidu.tieba.m85;
import com.baidu.tieba.nd5;
import com.baidu.tieba.nl9;
import com.baidu.tieba.nz4;
import com.baidu.tieba.od5;
import com.baidu.tieba.oq4;
import com.baidu.tieba.ow5;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pd5;
import com.baidu.tieba.pea;
import com.baidu.tieba.pf9;
import com.baidu.tieba.pl9;
import com.baidu.tieba.pv4;
import com.baidu.tieba.pz4;
import com.baidu.tieba.qz4;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rw5;
import com.baidu.tieba.rz4;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sj9;
import com.baidu.tieba.t35;
import com.baidu.tieba.ta5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tg9;
import com.baidu.tieba.tm5;
import com.baidu.tieba.uj9;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.uu4;
import com.baidu.tieba.va5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.wg9;
import com.baidu.tieba.xh9;
import com.baidu.tieba.xn9;
import com.baidu.tieba.ya;
import com.baidu.tieba.ye9;
import com.baidu.tieba.ym5;
import com.baidu.tieba.za;
import com.baidu.tieba.ze9;
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
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, lh9<NewSubPbActivity>, TbRichTextView.t, hz4.e, rw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId A;
    public PbModel.h B;
    public final TbRichTextView.z C;
    public tg9 D;
    public final View.OnLongClickListener E;
    public ik9 F;
    public BdImage G;
    public String H;
    public pea I;
    public rz4.f J;
    public final g4 K;
    public ef5 L;
    public CustomMessageListener M;
    public NewWriteModel.d N;
    public View.OnClickListener O;
    public df5 P;
    public final oq4.a Q;
    public PbModel a;
    public dn9 b;
    public xh9 c;
    public nl9 d;
    public pl9 e;
    public boolean f;
    public boolean g;
    public pz4 h;
    public rz4 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public t35 l;
    public AgreeMessageData m;
    public ForumManageModel n;
    public ina o;
    public if5 p;
    public hf5 q;
    public boolean r;
    public gk9 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public oq4 y;
    public ya<ImageView> z;

    @Override // com.baidu.tieba.rw5
    public ya<ItemCardView> C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public boolean F2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<GifView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<LinearLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw5
    public void U(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.rw5
    public void W(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<TiebaPlusRecommendCard> b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<RelativeLayout> f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<FestivalTipView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<View> k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public void m0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.rw5
    public void n0(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048633, this, context, str, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<TextView> p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public void s0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048649, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView v1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048655, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.rw5
    public void x1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, context, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class h implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes7.dex */
        public class a implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements hz4.e {
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m85 m85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m85Var, writeData, antiData}) == null) {
                if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.s1() != null) {
                        statisticItem.param("fid", this.a.a.s1().l());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    gk9 gk9Var = this.a.s;
                    if (gk9Var != null) {
                        gk9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        va5.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new a(this));
                    hz4Var.setPositiveButton(R.string.open_now, new b(this));
                    hz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    if (foldCommentActivity.s != null) {
                        if (foldCommentActivity.c != null && this.a.c.x() != null && this.a.c.x().f() != null && this.a.c.x().f().A()) {
                            this.a.c.x().f().x(postWriteCallBackData);
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
                    wg9.a(this.b.a.getPageContext(), this.a).show();
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
    public class a implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends g4 {
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

        @Override // com.baidu.tieba.g4
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
                    this.a.a.X1();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    this.a.r2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.c.u(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) && hz4Var != null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.b.c.c0();
                MessageManager.getInstance().sendMessage(this.a);
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ef5 {
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

        @Override // com.baidu.tieba.ef5
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
                this.a.c.V(this.a.q.A());
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
        public void b(ye9 ye9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye9Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, ye9 ye9Var, String str, int i4, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ye9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) != null) || this.a.c == null) {
                return;
            }
            this.a.c.T();
            if (z) {
                this.a.c.D();
                if (ye9Var != null) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    boolean z3 = true;
                    if (ye9Var.r() != 1) {
                        z3 = false;
                    }
                    foldCommentActivity.f = z3;
                    String str2 = null;
                    if (this.a.a != null && this.a.a.c2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.c != null) {
                        str2 = this.a.c.y();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.q.e0(TbSingleton.getInstance().getAdVertiComment(ye9Var.q0(), ye9Var.r0(), str2));
                    }
                    this.a.c.R(ye9Var, this.a.f);
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
                    if (obj instanceof pea) {
                        pea peaVar = (pea) obj;
                        if (this.a.a == null || this.a.a.s1() == null || peaVar.t() == null || peaVar.L() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.x() != null) {
                            this.a.c.x().g();
                        }
                        pf9 pf9Var = new pf9();
                        pf9Var.v(this.a.a.s1().k());
                        pf9Var.z(this.a.a.s1().O());
                        pf9Var.x(peaVar);
                        this.a.c.w().j0(pf9Var);
                        this.a.c.w().setPostId(peaVar.U());
                        this.a.J2(view2, peaVar.t().getUserId(), "", peaVar);
                        TiebaStatic.log("c11743");
                        xn9.b(this.a.a.s1(), peaVar, peaVar.f0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.V(this.a.q.A());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091afe && view2.getId() != R.id.obfuscated_res_0x7f091b5f) {
                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09230c && view2.getId() != R.id.obfuscated_res_0x7f091afc && view2.getId() != R.id.obfuscated_res_0x7f091975) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f091b65 && view2.getId() != R.id.obfuscated_res_0x7f091d31 && view2.getId() != R.id.obfuscated_res_0x7f091af6) {
                        if ((view2.getId() == R.id.obfuscated_res_0x7f09087e || view2.getId() == R.id.obfuscated_res_0x7f090b85) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof pea)) {
                            pea peaVar2 = (pea) sparseArray.get(R.id.tag_load_sub_data);
                            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                            if (peaVar2 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09087f);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090880);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b85);
                            peaVar2.j1(!peaVar2.D0());
                            SkinManager.setBackgroundColor(findViewById, peaVar2.D0() ? R.color.CAM_X0201 : R.color.transparent);
                            SkinManager.setViewTextColor(eMTextView, peaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            WebPManager.setPureDrawable(imageView, peaVar2.D0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, peaVar2.D0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                            return;
                        }
                        return;
                    } else if (this.a.a == null) {
                        return;
                    } else {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091b65) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.M1());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091d31) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b65 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof pea) {
                                pea peaVar3 = (pea) sparseArray2.get(R.id.tag_load_sub_data);
                                if (view2.getId() == R.id.obfuscated_res_0x7f091b65 && (statisticItem = peaVar3.g0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d31 || view2.getId() == R.id.obfuscated_res_0x7f091af6) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.N1()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", peaVar3.U()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.s1() == null || peaVar3.t() == null || peaVar3.L() == 1) {
                                    return;
                                }
                                if (this.a.c.x() != null) {
                                    this.a.c.x().g();
                                }
                                pf9 pf9Var2 = new pf9();
                                pf9Var2.v(this.a.a.s1().k());
                                pf9Var2.z(this.a.a.s1().O());
                                pf9Var2.x(peaVar3);
                                this.a.c.w().j0(pf9Var2);
                                this.a.c.w().setPostId(peaVar3.U());
                                this.a.J2(view2, peaVar3.t().getUserId(), "", peaVar3);
                                if (this.a.q != null) {
                                    this.a.c.V(this.a.q.A());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091975) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.M1());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f091afc || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    if (!this.a.checkUpIsLogin()) {
                        xn9.u("c10517", this.a.a.s1().l(), 3);
                    } else if (this.a.a == null || this.a.a.s1() == null) {
                    } else {
                        this.a.c.t();
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        pea peaVar4 = (pea) sparseArray3.get(R.id.tag_load_sub_data);
                        pea peaVar5 = (pea) sparseArray3.get(R.id.tag_load_sub_reply_data);
                        View view4 = (View) sparseArray3.get(R.id.tag_load_sub_view);
                        if (peaVar4 == null || view4 == null) {
                            return;
                        }
                        if (peaVar4.P() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem5 = peaVar4.g0;
                        if (statisticItem5 != null) {
                            StatisticItem copy2 = statisticItem5.copy();
                            copy2.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091975) {
                                copy2.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091afc) {
                                copy2.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy2);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091afc && this.a.a != null && this.a.a.s1() != null && peaVar4 != null) {
                            TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.M1()).param("fname", this.a.a.s1().m()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", peaVar4.U()));
                        }
                        String M1 = this.a.a.M1();
                        String U = peaVar4.U();
                        String U2 = peaVar5 != null ? peaVar5.U() : "";
                        int W = this.a.a.s1() != null ? this.a.a.s1().W() : 0;
                        this.a.E();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091f18 && (view2.getId() != R.id.obfuscated_res_0x7f091afc || !this.a.r)) {
                            TiebaStatic.log("c11742");
                            AbsPbActivity.e P2 = this.a.P2(U);
                            if (peaVar4 == null || this.a.a == null || this.a.a.s1() == null || P2 == null) {
                                return;
                            }
                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, this.a.r, null, false, U2, W, peaVar4.m0(), this.a.a.s1().c(), false, peaVar4.t().getIconInfo(), 5).addBigImageData(P2.a, P2.b, P2.g, P2.j);
                            if (!ad.isEmpty(U2)) {
                                addBigImageData.setHighLightPostId(U2);
                                addBigImageData.setKeyIsUseSpid(true);
                            }
                            addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                            addBigImageData.setTiebaPlusData(this.a.a.W(), this.a.a.S(), this.a.a.T(), this.a.a.R(), this.a.a.X());
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
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, this.a.r, null, true, null, W, peaVar4.m0(), this.a.a.s1().c(), false, peaVar4.t().getIconInfo(), 5).addBigImageData(P22.a, P22.b, P22.g, P22.j);
                        addBigImageData2.setKeyPageStartFrom(this.a.a.r1());
                        addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.a.a.R1());
                        addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData2.setBjhData(this.a.a.J0());
                        addBigImageData2.setTiebaPlusData(this.a.a.W(), this.a.a.S(), this.a.a.T(), this.a.a.R(), this.a.a.X());
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
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.M1()).param("fname", this.a.a.s1().m()).param("fid", this.a.a.s1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.I.U()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.n2(view2);
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
            gk9 gk9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (gk9Var = this.a.s) != null && gk9Var.g() != null) {
                if (!this.a.s.g().e()) {
                    this.a.s.b(false);
                }
                this.a.s.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements df5 {
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

        @Override // com.baidu.tieba.df5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gk9 gk9Var = this.a.s;
                if (gk9Var != null && gk9Var.g() != null && this.a.s.g().d()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                    if (this.a.c != null && this.a.c.x() != null && this.a.c.x().f() != null && this.a.c.x().f().A()) {
                        this.a.c.x().f().x(this.a.s.h());
                    }
                    this.a.s.b(true);
                    return true;
                }
                return !this.a.k2(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q implements oq4.a {
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

        @Override // com.baidu.tieba.oq4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                if (z) {
                    if (this.a.y != null) {
                        this.a.y.h(z2);
                    }
                    this.a.a.i3(z2);
                    if (this.a.a.d1()) {
                        this.a.K2();
                    }
                    if (z2) {
                        if (this.a.y != null) {
                            if (this.a.y.f() != null && this.a.a != null && this.a.a.s1() != null && this.a.a.s1().O() != null && this.a.a.s1().O().getAuthor() != null) {
                                MarkData f = this.a.y.f();
                                MetaData author = this.a.a.s1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        if (str2 == null) {
                                            str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f00ff);
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
                        this.a.g2();
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
    public class r implements za<ImageView> {
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
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
                    sj9.e(this.a.a, str, i, eVar);
                    if (this.a.a.s1().j0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i4 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().R() != null) {
                            ArrayList<TbRichTextImageInfo> R = tbRichTextView.getRichText().R();
                            int i5 = 0;
                            int i6 = -1;
                            while (i5 < R.size()) {
                                if (R.get(i5) != null) {
                                    arrayList.add(R.get(i5).T());
                                    if (i6 == i4 && str != null && (str.equals(R.get(i5).T()) || str.equals(R.get(i5).P()) || str.equals(R.get(i5).N()) || str.equals(R.get(i5).O()) || str.equals(R.get(i5).R()))) {
                                        i6 = i5;
                                    }
                                    ImageUrlData imageUrlData3 = new ImageUrlData();
                                    String T2 = R.get(i5).T();
                                    imageUrlData3.imageUrl = T2;
                                    imageUrlData3.imageThumbUrl = T2;
                                    if (this.a.f) {
                                        i3 = 17;
                                    } else {
                                        i3 = 18;
                                    }
                                    imageUrlData3.urlThumbType = i3;
                                    imageUrlData3.originalUrl = R.get(i5).T();
                                    imageUrlData3.isLongPic = R.get(i5).W();
                                    concurrentHashMap.put(R.get(i5).T(), imageUrlData3);
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
                                builder.setThreadData(this.a.a.s1().O());
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
                                builder2.setThreadData(this.a.a.s1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = sj9.f(this.a.a, str, i);
                        if (f != null && (d = sj9.d()) >= 0 && d < f.P().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = ze9.a(f.P().get(d));
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
                                    builder3.setThreadData(this.a.a.s1().O());
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
                    this.a.q.I(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.c != null && this.a.c.x() != null && this.a.c.x().f() != null) {
                    this.a.c.x().f().J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements PbFragment.i3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.i3
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
                String valueOf = String.valueOf(this.a.a.s1().V().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.s1().k().getId(), this.a.a.s1().k().getName(), this.a.a.s1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements tg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.tg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tg9.a
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

        @Override // com.baidu.tieba.tg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091f39) {
                        if (this.a.R2(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091afb) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.Y2((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.pb_post_header_layout) {
                        SparseArray sparseArray = null;
                        if (view2.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view2.getTag();
                        }
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.Y2(sparseArray);
                    }
                }
                if (this.a.q != null) {
                    this.a.c.V(this.a.q.A());
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
            return this.a.n2(view2);
        }
    }

    /* loaded from: classes7.dex */
    public class x implements rz4.d {
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

        @Override // com.baidu.tieba.rz4.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null) {
                this.a.i.s(fm9.h(this.a.I));
                ArrayList arrayList = new ArrayList();
                for (qz4 qz4Var : this.a.i.h()) {
                    if (qz4Var instanceof nz4) {
                        arrayList.add((nz4) qz4Var);
                    }
                }
                fm9.f(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements rz4.f {
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

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
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
                        if (view6 == null) {
                            return;
                        }
                        this.a.Q2(view6);
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
                                foldCommentActivity.F = new ik9(foldCommentActivity.getPageContext());
                            }
                            this.a.F.b(this.a.H, this.a.G.getImageByte());
                            this.a.G = null;
                            this.a.H = null;
                            return;
                        }
                        return;
                    case 3:
                        pea peaVar = this.a.I;
                        if (peaVar != null) {
                            peaVar.S0();
                            this.a.I = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (!this.a.checkUpIsLogin()) {
                            return;
                        }
                        this.a.L2(view2);
                        if (this.a.a.s1().O() != null && this.a.a.s1().O().getAuthor() != null && this.a.a.s1().O().getAuthor().getUserId() != null && this.a.y != null) {
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int x2 = foldCommentActivity2.x2(foldCommentActivity2.a.s1());
                            ThreadData O = this.a.a.s1().O();
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
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.M1()).param("obj_locate", 2).param("obj_id", this.a.a.s1().O().getAuthor().getUserId()).param("obj_type", !this.a.y.e()).param("obj_source", x2).param("obj_param1", i2));
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
                            this.a.A2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.a.i2(sparseArray2);
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
                            boolean S = this.a.S(TbadkCoreApplication.getCurrentAccount());
                            if (S) {
                                if (booleanValue2) {
                                    this.a.c.M(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, S);
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
                                this.a.i2(sparseArray4);
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
                        pea peaVar2 = (pea) sparseArray.get(R.id.tag_clip_board);
                        if (peaVar2.p() == null) {
                            return;
                        }
                        this.a.l2(peaVar2.p());
                        return;
                    case 9:
                        if (this.a.checkUpIsLogin() && this.a.a != null && this.a.a.s1() != null) {
                            this.a.U2(hna.c(view2));
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                if (hz4Var != null) {
                    hz4Var.dismiss();
                }
                this.d.q2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
        this.C = new s(this);
        this.D = new tg9(new v(this));
        this.E = new w(this);
        this.I = null;
        this.J = new y(this);
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
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.s1() == null || this.a.s1().k() == null || h2()) {
            return;
        }
        if (this.a.s1().j0()) {
            this.c.s();
            return;
        }
        hf5 hf5Var = this.q;
        if (hf5Var != null && hf5Var.a() != null) {
            this.q.a().D(new cd5(45, 27, null));
        }
        this.c.s();
    }

    public final boolean C2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    public final void H2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(this, "", str, false, true, true, bundle);
        }
    }

    public final void L2(View view2) {
        SparseArray sparseArray;
        pea peaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            M2(peaVar);
        }
    }

    @Override // com.baidu.tieba.lh9
    public boolean S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.m2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void T2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z2) == null) {
            this.q.Z(z2);
            this.q.c0(z2);
            this.q.k0(z2);
        }
    }

    public void U2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && str != null && this.o != null) {
            this.o.n(JavaTypesHelper.toLong(str, 0L));
        }
    }

    public void a3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.A);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.hz4.e
    public void onClick(hz4 hz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, hz4Var) == null) {
            p2(hz4Var, null);
        }
    }

    public final void A2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null && this.a.s1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.M1(), str);
                ThreadData O = this.a.s1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                H2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final boolean G2(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null) {
                if (this.a.s1().W() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.s1().O() == null || this.a.s1().O().getAuthor() == null || TextUtils.equals(this.a.s1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                return !z2;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void M2(pea peaVar) {
        boolean z2;
        oq4 oq4Var;
        pea t2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, peaVar) != null) || peaVar == null) {
            return;
        }
        if (peaVar.U() != null && peaVar.U().equals(this.a.n1())) {
            z2 = true;
        } else {
            z2 = false;
        }
        MarkData m1 = this.a.m1(peaVar);
        if (this.a.s1() != null && this.a.s1().j0() && (t2 = t2()) != null) {
            m1 = this.a.m1(t2);
        }
        if (m1 != null && (oq4Var = this.y) != null) {
            oq4Var.i(m1);
            if (!z2) {
                this.y.a();
            } else {
                this.y.d();
            }
        }
    }

    public final void B2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.k = getUniqueId();
            oq4 c2 = oq4.c(this);
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
            this.a.d3(true);
            this.a.f3(4);
        }
    }

    public final void S2(if5 if5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, if5Var) == null) && if5Var != null && (pbModel = this.a) != null) {
            if5Var.p(pbModel.R0());
            if (this.a.s1() != null && this.a.s1().k() != null) {
                if5Var.o(this.a.s1().k());
            }
            if5Var.q("pb");
            if5Var.r(this.a);
        }
    }

    public boolean k2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            if (this.u != null && this.a.s1() != null && !ThreadCardUtils.isSelf(this.a.s1().O()) && this.a.s1().c() != null) {
                return this.u.checkPrivacyBeforeSend(this.a.s1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void D2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.d = new nl9(this);
            this.e = new pl9(getPageContext());
            xh9 xh9Var = new xh9(this, this.O, this.C, this.D, this.E);
            this.c = xh9Var;
            xh9Var.X(this.a);
            setContentView(this.c.z(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.r();
            this.c.U(new u(this));
            if5 if5Var = new if5();
            this.p = if5Var;
            S2(if5Var);
            hf5 hf5Var = (hf5) this.p.a(getActivity());
            this.q = hf5Var;
            hf5Var.Y(getPageContext());
            this.q.i0(this.L);
            this.q.a0(1);
            this.q.C(getPageContext(), bundle);
            this.q.a().b(new nd5(getActivity()));
            this.q.a().F(true);
            T2(true);
            this.q.L(this.a.U0(), this.a.M1(), this.a.Q0());
            this.c.S(this.q.a());
            this.s = new gk9();
            if (this.q.t() != null) {
                this.s.m(this.q.t().j());
            }
            registerListener(this.M);
            if (!this.a.f1()) {
                this.q.r(this.a.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.e0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.c2()) {
                this.q.e0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                xh9 xh9Var2 = this.c;
                if (xh9Var2 != null) {
                    this.q.e0(xh9Var2.y());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
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

    public final void I2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (pbModel = this.a) != null) {
            pbModel.t2();
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ye9 s1 = this.a.s1();
            this.a.i3(true);
            oq4 oq4Var = this.y;
            if (oq4Var != null) {
                s1.L0(oq4Var.g());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh9
    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.l2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lh9
    public nl9 X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.d;
        }
        return (nl9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<ImageView> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.z == null) {
                this.z = new ya<>(new r(this), 8, 0);
            }
            return this.z;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh9
    public String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.R0();
            }
            return null;
        }
        return (String) invokeV.objValue;
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

    @Override // com.baidu.tieba.lh9
    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null) {
                return this.a.s1().W();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public AntiData s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null) {
                return this.a.s1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public PbModel u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public hf5 v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.q;
        }
        return (hf5) invokeV.objValue;
    }

    public pl9 w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.e;
        }
        return (pl9) invokeV.objValue;
    }

    public final void J2(View view2, String str, String str2, pea peaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048588, this, view2, str, str2, peaVar) != null) || view2 == null || str == null || str2 == null || !j2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.w);
            this.x = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.x() != null && peaVar != null) {
            if (peaVar.f0() != null) {
                str3 = peaVar.f0().toString();
            } else {
                str3 = "";
            }
            this.c.x().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), peaVar.t().getName_show(), str3));
        }
        if (this.a.s1() != null && this.a.s1().j0()) {
            SafeHandler.getInst().postDelayed(new m(this, str, str2), 0L);
        } else {
            SafeHandler.getInst().postDelayed(new n(this, str, str2), 0L);
        }
    }

    public void q2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(dk9.o2, Integer.valueOf(dk9.p2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                o2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void N2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, str) == null) {
            if (this.a.T1()) {
                showToast(str);
            } else if (BdUtilHelper.isNetOk()) {
                if (i2 == 4) {
                    xh9 xh9Var = this.c;
                    xh9Var.f0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    xh9 xh9Var2 = this.c;
                    xh9Var2.f0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.c.e0(R.string.no_data_text);
                }
            } else {
                this.c.e0(R.string.recommend_pb_no_net_text);
            }
        }
    }

    public final AbsPbActivity.e P2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            String str2 = null;
            if (this.a.s1() != null && this.a.s1().F() != null && this.a.s1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 < this.a.s1().F().size()) {
                        if (str.equals(this.a.s1().F().get(i2).U())) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                pea peaVar = this.a.s1().F().get(i2);
                if (peaVar.f0() != null && peaVar.f0().P() != null) {
                    Iterator<TbRichTextData> it = peaVar.f0().P().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.V() != null) {
                                str2 = next.V().P();
                            }
                        }
                    }
                    sj9.e(this.a, str2, 0, eVar);
                    ze9.b(peaVar, eVar);
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
            C2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            B2(bundle);
            D2(bundle);
            I2();
            if (this.r) {
                this.c.z().setAnimTime(0);
                this.c.z().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.A = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.z().h();
            this.c.w().setFromForumId(this.a.getFromForumId());
            dn9 dn9Var = new dn9(this);
            this.b = dn9Var;
            dn9Var.b(getUniqueId());
            this.o = new ina(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new t(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.e0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.e0(this.c.y());
            }
            ta5.b(false);
        }
    }

    public final void Q2(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, view2) != null) || view2 == null) {
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
        pea peaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof pea) || (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        Z2(peaVar, false);
    }

    public final void b3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.M1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fm9.n(i2))));
        }
    }

    public void i2(SparseArray<Object> sparseArray) {
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

    public final int x2(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, ye9Var)) == null) {
            if (ye9Var != null && ye9Var.O() != null) {
                if (ye9Var.O().getThreadType() == 0) {
                    return 1;
                }
                if (ye9Var.O().getThreadType() == 54) {
                    return 2;
                }
                if (ye9Var.O().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void R0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048600, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
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

    public final boolean R2(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof pea)) {
                return false;
            }
            pea peaVar = (pea) obj;
            if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.s1() != null) {
                if (this.c.x() != null) {
                    this.c.x().g();
                }
                pf9 pf9Var = new pf9();
                pf9Var.v(this.a.s1().k());
                pf9Var.z(this.a.s1().O());
                pf9Var.x(peaVar);
                TiebaStatic.log("c11743");
                this.c.w().j0(pf9Var);
                this.c.w().setPostId(peaVar.U());
                J2(view2, peaVar.t().getUserId(), "", peaVar);
                hf5 hf5Var = this.q;
                if (hf5Var != null) {
                    this.c.V(hf5Var.A());
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
    public final void l2(AgreeData agreeData) {
        tm5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new t35();
        }
        if (this.m == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.m = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        pv4 pv4Var = new pv4();
        pv4Var.b = 5;
        pv4Var.h = 8;
        pv4Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            pv4Var.f = pbModel2.r1();
        }
        pv4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                pv4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel == null && pbModel.s1() != null) {
                    this.l.b(this, pv4Var, agreeData, this.a.s1().O());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            pv4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            pv4Var.i = 1;
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

    public final void V2(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            fm9.e(getActivity(), getPageContext(), new z(this, sparseArray, i2, z2), new a(this));
        }
    }

    public final void W2(String str, String str2) {
        int i2;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
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
                this.c.x().t(str, str2, this.c.y(), (pbModel2 == null || pbModel2.s1() == null || this.a.s1().O() == null || !this.a.s1().O().isBjh()) ? false : false);
                kf5 f2 = this.c.x().f();
                if (f2 != null && (pbModel = this.a) != null && pbModel.s1() != null) {
                    f2.K(this.a.s1().c());
                    f2.g0(this.a.s1().O());
                }
                if (this.s.f() == null && this.c.x().f().v() != null) {
                    this.c.x().f().v().h(new o(this));
                    this.s.n(this.c.x().f().v().j());
                    this.c.x().f().Q(this.P);
                }
            }
            this.c.A();
        }
    }

    public final void Z2(pea peaVar, boolean z2) {
        PbModel pbModel;
        int i2;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048613, this, peaVar, z2) != null) || peaVar == null || (pbModel = this.a) == null || pbModel.s1() == null || peaVar.L() == 1) {
            return;
        }
        String M1 = this.a.M1();
        String U = peaVar.U();
        if (this.a.s1() != null) {
            i2 = this.a.s1().W();
        } else {
            i2 = 0;
        }
        AbsPbActivity.e P2 = P2(U);
        if (P2 == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this);
        boolean z3 = this.r;
        SmallTailInfo m0 = peaVar.m0();
        AntiData c2 = this.a.s1().c();
        if (peaVar.t() != null) {
            arrayList = peaVar.t().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, U, "pb", true, z3, null, false, null, i2, m0, c2, false, arrayList, 5).addBigImageData(P2.a, P2.b, P2.g, P2.j);
        addBigImageData.setKeyPageStartFrom(this.a.r1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.R1());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.J0());
        addBigImageData.setIsOpenEditor(z2);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void o2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(dk9.o2)).intValue();
            if (intValue == dk9.p2) {
                if (this.n.g0()) {
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
                    this.n.i0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.j0(this.a.s1().k().getId(), this.a.s1().k().getName(), this.a.s1().O().getId(), str, intValue3, intValue2, booleanValue, this.a.s1().O().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == dk9.q2 || intValue == dk9.s2) {
                if (this.a.N0() != null) {
                    this.a.N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == dk9.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void r2(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048648, this, bVar, z2) != null) || bVar == null) {
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
            hz4 hz4Var = new hz4(getPageContext().getPageActivity());
            hz4Var.setMessage(string);
            hz4Var.setPositiveButton(R.string.dialog_known, new c(this));
            hz4Var.setCancelable(true);
            hz4Var.create(getPageContext());
            hz4Var.show();
        } else if (bVar.d != 0) {
            this.c.u(0, bVar.a, bVar.b, z2);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<pea> F = this.a.s1().F();
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
                this.a.s1().O().setReply_num(this.a.s1().O().getReply_num() - 1);
            } else if (i3 == 0) {
                m2();
            } else if (i3 == 2) {
                ArrayList<pea> F2 = this.a.s1().F();
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

    public final void y2(int i2, Intent intent) {
        pd5 pd5Var;
        pd5 pd5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048659, this, i2, intent) == null) {
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
                    kf5 f2 = this.c.x().f();
                    f2.g0(this.a.s1().O());
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
            this.q.N();
            this.q.o0(pbEditorData.getVoiceModel());
            this.q.D(writeData);
            od5 p3 = this.q.a().p(6);
            if (p3 != null && (pd5Var = p3.m) != null) {
                pd5Var.O(new cd5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.q.I(null, null);
            }
        }
    }

    public final void X2(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.c.c0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            hz4 hz4Var = new hz4(this);
            if (!ad.isEmpty(str)) {
                hz4Var.setMessage(str);
            } else {
                hz4Var.setMessage(getResources().getString(R.string.block_mute_message_alert, str3));
            }
            hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c8, new d(this, userMuteAddAndDelCustomMessage));
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new e(this));
            hz4Var.create(getPageContext()).show();
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.S(this.a.getForumId()) && this.a.s1() != null && this.a.s1().k() != null) {
            boolean z2 = true;
            if (this.a.s1().k().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                this.a.F0().R(this.a.getForumId(), this.a.M1());
            }
        }
    }

    public final boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.s1() == null) {
                return false;
            }
            ThreadData O = this.a.s1().O();
            AntiData c2 = this.a.s1().c();
            if (!AntiHelper.b(getPageContext(), O) && !AntiHelper.d(getPageContext(), c2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if ((this.a.s1() != null && (this.a.s1().j0() || ThreadCardUtils.isSelf(this.a.s1().O()))) || this.u == null || this.a.s1() == null || this.a.s1().c() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.s1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
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

    public final void g2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (pbModel = this.a) != null && pbModel.s1() != null && this.a.s1().O() != null) {
            ThreadData O = this.a.s1().O();
            O.mRecomAbTag = this.a.y1();
            O.mRecomWeight = this.a.B1();
            O.mRecomSource = this.a.A1();
            O.mRecomExtra = this.a.z1();
            O.isSubPb = this.a.f1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.a.getForumId(), 0L));
            }
            StatisticItem i2 = ym5.i(this, O, "c13562");
            TbPageTag l2 = ym5.l(this);
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

    public pea t2() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.s1() != null && this.a.s1().O() != null && this.a.s1().O().getAuthor() != null) {
                pea peaVar = new pea();
                MetaData author = this.a.s1().O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = this.a.s1().O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                peaVar.W0(1);
                peaVar.c1(this.a.s1().O().getFirstPostId());
                peaVar.t1(this.a.s1().O().getTitle());
                peaVar.s1(this.a.s1().O().getCreateTime());
                peaVar.P0(author);
                return peaVar;
            }
            return null;
        }
        return (pea) invokeV.objValue;
    }

    public final boolean n2(View view2) {
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
        nz4 nz4Var;
        nz4 nz4Var2;
        nz4 nz4Var3;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            pea peaVar = (pea) sparseArray.get(R.id.tag_clip_board);
            this.I = peaVar;
            if (peaVar == null || this.y == null) {
                return true;
            }
            if (this.i == null) {
                rz4 rz4Var = new rz4(this);
                this.i = rz4Var;
                rz4Var.r(this.J);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                boolean F2 = F2(view2);
                if (F2(view2) && (bdImage = this.G) != null && !bdImage.isGif()) {
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
                if (F2) {
                    z10 = z3;
                    arrayList.add(new nz4(1, getString(R.string.save_to_emotion), this.i));
                } else {
                    z10 = z3;
                }
                if (z2) {
                    arrayList.add(new nz4(2, getString(R.string.save_to_local), this.i));
                }
                if (!F2 && !z2) {
                    nz4 nz4Var4 = new nz4(3, getString(R.string.obfuscated_res_0x7f0f04eb), this.i);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, this.I);
                    nz4Var4.d.setTag(sparseArray2);
                    arrayList.add(nz4Var4);
                }
                if (this.mIsLogin) {
                    if (!fm9.j(this.a) && !z6 && z5) {
                        nz4 nz4Var5 = new nz4(5, getString(R.string.obfuscated_res_0x7f0f0d2b), this.i);
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
                        nz4Var5.d.setTag(sparseArray3);
                        arrayList.add(nz4Var5);
                    } else {
                        if (G2(z4) && TbadkCoreApplication.isLogin()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            nz4 nz4Var6 = new nz4(5, getString(R.string.report_text), this.i);
                            nz4Var6.d.setTag(str);
                            arrayList.add(nz4Var6);
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
                        if (!fm9.j(this.a) && z7) {
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
                                nz4Var = new nz4(6, getString(R.string.obfuscated_res_0x7f0f0551), this.i);
                                nz4Var.d.setTag(sparseArray4);
                                nz4Var2 = new nz4(7, getString(R.string.obfuscated_res_0x7f0f0326), this.i);
                                nz4Var2.d.setTag(sparseArray4);
                            }
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        nz4Var = null;
                        nz4Var2 = new nz4(7, getString(R.string.obfuscated_res_0x7f0f0326), this.i);
                        nz4Var2.d.setTag(sparseArray4);
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
                            if (this.a.s1().W() == 1002 && !z4) {
                                nz4Var3 = new nz4(6, getString(R.string.report_text), this.i);
                            } else {
                                nz4Var3 = new nz4(6, getString(R.string.obfuscated_res_0x7f0f0551), this.i);
                            }
                            nz4Var3.d.setTag(sparseArray5);
                            nz4Var = nz4Var3;
                        } else {
                            nz4Var = null;
                        }
                        nz4Var2 = null;
                    }
                    if (nz4Var != null) {
                        arrayList.add(nz4Var);
                    }
                    if (nz4Var2 != null) {
                        arrayList.add(nz4Var2);
                    }
                    fm9.b(arrayList, this.i, this.I, this.a);
                }
                List<nz4> c2 = fm9.c(arrayList, this.I.p(), sparseArray, this.i);
                fm9.m(c2, this.g);
                fm9.f(c2);
                this.i.s(fm9.h(this.I));
                this.i.n(c2, true);
                this.h = new pz4(getPageContext(), this.i);
                this.i.q(new x(this));
                this.h.l();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.a.M1()).param("fid", this.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.P());
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048637, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.E(i2, i3, intent);
            if (this.c.x() != null) {
                this.c.x().k(i2, i3, intent);
            }
            if (i2 == 25035) {
                y2(i3, intent);
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
                                    shareSuccessReplyToServerModel.N(str, intExtra, new j(this));
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
                uj9.b().k();
                this.mHandler.postDelayed(new i(this), 1000L);
            }
        }
    }

    public void z2(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048660, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
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
            X2(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void p2(hz4 hz4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, hz4Var, jSONArray) == null) {
            hz4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(hz4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                o2((SparseArray) hz4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }
}
