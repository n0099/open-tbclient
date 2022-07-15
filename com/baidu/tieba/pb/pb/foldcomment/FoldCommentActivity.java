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
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
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
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c9;
import com.repackage.cr4;
import com.repackage.dp8;
import com.repackage.eg;
import com.repackage.ei8;
import com.repackage.ep8;
import com.repackage.fg;
import com.repackage.fv7;
import com.repackage.fx7;
import com.repackage.fy4;
import com.repackage.fy7;
import com.repackage.it7;
import com.repackage.j15;
import com.repackage.jl4;
import com.repackage.jr4;
import com.repackage.jr7;
import com.repackage.ju7;
import com.repackage.k35;
import com.repackage.kr7;
import com.repackage.kz4;
import com.repackage.l35;
import com.repackage.lr4;
import com.repackage.ls7;
import com.repackage.lx7;
import com.repackage.m45;
import com.repackage.n35;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nr4;
import com.repackage.nv7;
import com.repackage.nw7;
import com.repackage.oi;
import com.repackage.os7;
import com.repackage.oz4;
import com.repackage.p35;
import com.repackage.p85;
import com.repackage.pi;
import com.repackage.pz4;
import com.repackage.qg;
import com.repackage.qv7;
import com.repackage.r35;
import com.repackage.rw7;
import com.repackage.sg5;
import com.repackage.sv7;
import com.repackage.t15;
import com.repackage.tn4;
import com.repackage.tt4;
import com.repackage.tv7;
import com.repackage.tw7;
import com.repackage.u15;
import com.repackage.u85;
import com.repackage.v15;
import com.repackage.v88;
import com.repackage.vg5;
import com.repackage.ws7;
import com.repackage.xm6;
import com.repackage.ym;
import com.repackage.ze5;
import com.repackage.zm4;
import com.repackage.zr7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, ws7<NewSubPbActivity>, TbRichTextView.s, cr4.e, vg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xm6 A;
    public xm6 B;
    public jl4 C;
    public eg<ImageView> D;
    public BdUniqueId E;
    public PbModel.h F;
    public View G;
    public int H;
    public final TbRichTextView.y I;
    public boolean J;
    public ls7 K;
    public final View.OnLongClickListener L;
    public sv7 M;
    public ym N;
    public String O;
    public TbRichTextMemeInfo P;
    public PostData Q;
    public nr4.e R;
    public Object S;
    public final c9 T;
    public l35 U;
    public CustomMessageListener V;
    public NewWriteModel.e W;
    public boolean X;
    public View Y;
    public View Z;
    public PbModel a;
    public lx7 b;
    public it7 c;
    public rw7 d;
    public tw7 e;
    public boolean f;
    public boolean g;
    public View.OnClickListener g0;
    public lr4 h;
    public k35 h0;
    public nr4 i;
    public final jl4.a i0;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public tt4 l;
    public ei8 m;
    public ForumManageModel n;
    public ep8 o;
    public p35 p;
    public n35 q;
    public boolean r;
    public qv7 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public nw7 v;
    public EmotionImageData w;
    public ShareSuccessReplyToServerModel x;
    public int[] y;
    public int z;

    /* loaded from: classes3.dex */
    public class a extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.n.getLoadDataMode();
                    if (loadDataMode == 0) {
                        this.a.a.s2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.I1(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.c.v(1, dVar.a, dVar.b, true);
                        return;
                    }
                }
                this.a.c.v(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) || cr4Var == null) {
                return;
            }
            cr4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ FoldCommentActivity b;

        public c(FoldCommentActivity foldCommentActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.b.c.d0();
                MessageManager.getInstance().sendMessage(this.a);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public d(FoldCommentActivity foldCommentActivity) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements l35 {
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

        @Override // com.repackage.l35
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FoldCommentActivity foldCommentActivity, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.q != null) {
                this.a.c.W(this.a.q.C());
            }
            this.a.c.a0(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes3.dex */
        public class a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public g(FoldCommentActivity foldCommentActivity) {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, fy4 fy4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, fy4Var, writeData, antiData}) == null) {
                if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.R1() != null) {
                        statisticItem.param("fid", this.a.a.R1().m());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.j2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    qv7 qv7Var = this.a.s;
                    if (qv7Var != null) {
                        qv7Var.d();
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                        return;
                    }
                    pz4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.u;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046e), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    cr4 cr4Var = new cr4(this.a.getActivity());
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce1));
                    } else {
                        cr4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new a(this));
                    cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce3, new b(this));
                    cr4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                FoldCommentActivity foldCommentActivity = this.a;
                if (foldCommentActivity.s == null) {
                    return;
                }
                if (foldCommentActivity.c != null && this.a.c.y() != null && this.a.c.y().b() != null && this.a.c.y().b().x()) {
                    this.a.c.y().b().v(postWriteCallBackData);
                }
                this.a.s.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ i b;

            public a(i iVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    os7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                qg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", this.a.a.j2());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091eed);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.a.a == null || this.a.a.R1() == null || postData.s() == null || postData.B() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.y() != null) {
                            this.a.c.y().c();
                        }
                        zr7 zr7Var = new zr7();
                        zr7Var.A(this.a.a.R1().l());
                        zr7Var.E(this.a.a.R1().O());
                        zr7Var.C(postData);
                        this.a.c.x().W(zr7Var);
                        this.a.c.x().setPostId(postData.J());
                        this.a.g2(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        fy7.b(this.a.a.R1(), postData, postData.h0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.W(this.a.q.C());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09172e && view2.getId() != R.id.obfuscated_res_0x7f091785) {
                if (view2.getId() != R.id.obfuscated_res_0x7f091e50 && view2.getId() != R.id.obfuscated_res_0x7f091e4e && view2.getId() != R.id.obfuscated_res_0x7f09172c && view2.getId() != R.id.obfuscated_res_0x7f0915cf) {
                    if ((view2.getId() == R.id.obfuscated_res_0x7f09178b || view2.getId() == R.id.obfuscated_res_0x7f091953 || view2.getId() == R.id.obfuscated_res_0x7f091726) && this.a.a != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f09178b) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.j2());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091953) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                this.a.Z = view2;
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09178b && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            this.a.Z = view2;
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view2.getTag();
                            if (sparseArray.get(R.id.obfuscated_res_0x7f091f09) instanceof PostData) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091f09);
                                if (view2.getId() == R.id.obfuscated_res_0x7f09178b && (statisticItem = postData2.i0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091953 || view2.getId() == R.id.obfuscated_res_0x7f091726) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.k2()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.J()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.R1() == null || postData2.s() == null || postData2.B() == 1) {
                                    return;
                                }
                                if (this.a.c.y() != null) {
                                    this.a.c.y().c();
                                }
                                if (this.a.X && postData2.S() != null && postData2.S().size() != 0) {
                                    this.a.x2(postData2, true);
                                    return;
                                }
                                zr7 zr7Var2 = new zr7();
                                zr7Var2.A(this.a.a.R1().l());
                                zr7Var2.E(this.a.a.R1().O());
                                zr7Var2.C(postData2);
                                this.a.c.x().W(zr7Var2);
                                this.a.c.x().setPostId(postData2.J());
                                this.a.g2(view2, postData2.s().getUserId(), "", postData2);
                                if (this.a.q != null) {
                                    this.a.c.W(this.a.q.C());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0915cf) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.j2());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09172c && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    this.a.Y = view2;
                } else if (this.a.checkUpIsLogin()) {
                    if (this.a.a == null || this.a.a.R1() == null) {
                        return;
                    }
                    this.a.c.u();
                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                    PostData postData3 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091f09);
                    PostData postData4 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091f0a);
                    View view3 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f091f0b);
                    if (postData3 == null || view3 == null) {
                        return;
                    }
                    if (postData3.F() == 1) {
                        TiebaStatic.log(new StatisticItem("c12630"));
                    }
                    StatisticItem statisticItem5 = postData3.i0;
                    if (statisticItem5 != null) {
                        StatisticItem copy2 = statisticItem5.copy();
                        copy2.delete("obj_locate");
                        if (view2.getId() == R.id.obfuscated_res_0x7f0915cf) {
                            copy2.param("obj_locate", 6);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09172c) {
                            copy2.param("obj_locate", 8);
                        }
                        TiebaStatic.log(copy2);
                    }
                    if (view2.getId() == R.id.obfuscated_res_0x7f09172c && this.a.a != null && this.a.a.R1() != null && postData3 != null) {
                        TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.j2()).param("fname", this.a.a.R1().n()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.J()));
                    }
                    String j2 = this.a.a.j2();
                    String J = postData3.J();
                    String J2 = postData4 != null ? postData4.J() : "";
                    int V = this.a.a.R1() != null ? this.a.a.R1().V() : 0;
                    this.a.y2();
                    if (view2.getId() == R.id.obfuscated_res_0x7f091afd) {
                        AbsPbActivity.e n2 = this.a.n2(J);
                        if (this.a.a == null || this.a.a.R1() == null || n2 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(j2, J, "pb", true, this.a.r, null, true, null, V, postData3.V(), this.a.a.R1().d(), false, postData3.s().getIconInfo(), 5).addBigImageData(n2.a, n2.b, n2.g, n2.j);
                        addBigImageData.setKeyPageStartFrom(this.a.a.Q1());
                        addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData.setWorksInfoData(this.a.a.o2());
                        addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData.setBjhData(this.a.a.j1());
                        addBigImageData.setTiebaPlusData(this.a.a.J(), this.a.a.F(), this.a.a.G(), this.a.a.E(), this.a.a.K());
                        addBigImageData.setFromFoldComment(true);
                        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09172c && this.a.r) {
                        AbsPbActivity.e n22 = this.a.n2(J);
                        if (this.a.a == null || this.a.a.R1() == null || n22 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(j2, J, "pb", true, this.a.r, null, true, null, V, postData3.V(), this.a.a.R1().d(), false, postData3.s().getIconInfo(), 5).addBigImageData(n22.a, n22.b, n22.g, n22.j);
                        addBigImageData2.setKeyPageStartFrom(this.a.a.Q1());
                        addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.a.a.o2());
                        addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData2.setBjhData(this.a.a.j1());
                        addBigImageData2.setTiebaPlusData(this.a.a.J(), this.a.a.F(), this.a.a.G(), this.a.a.E(), this.a.a.K());
                        addBigImageData2.setFromFoldComment(true);
                        addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                    } else {
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e n23 = this.a.n2(J);
                        if (postData3 == null || this.a.a == null || this.a.a.R1() == null || n23 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(j2, J, "pb", true, this.a.r, null, false, J2, V, postData3.V(), this.a.a.R1().d(), false, postData3.s().getIconInfo(), 5).addBigImageData(n23.a, n23.b, n23.g, n23.j);
                        if (!oi.isEmpty(J2)) {
                            addBigImageData3.setHighLightPostId(J2);
                            addBigImageData3.setKeyIsUseSpid(true);
                        }
                        addBigImageData3.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData3.setTiebaPlusData(this.a.a.J(), this.a.a.F(), this.a.a.G(), this.a.a.E(), this.a.a.K());
                        addBigImageData3.setBjhData(this.a.a.j1());
                        addBigImageData3.setKeyPageStartFrom(this.a.a.Q1());
                        addBigImageData3.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.a.a.o2());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.a.R1().m()));
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.j2());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.R1() != null && this.a.Q != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.j2()).param("fname", this.a.a.R1().n()).param("fid", this.a.a.R1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.Q.J()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.E1(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

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
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(jr7 jr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jr7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, jr7 jr7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jr7Var, str, Integer.valueOf(i4)}) == null) || this.a.c == null) {
                return;
            }
            this.a.c.U();
            if (!z) {
                this.a.k2(i, str);
                return;
            }
            this.a.c.E();
            if (jr7Var != null) {
                if (jr7Var.s() == 1) {
                    this.a.f = true;
                } else {
                    this.a.f = false;
                }
                String str2 = null;
                if (this.a.a == null || !this.a.a.x2()) {
                    if (this.a.c != null) {
                        str2 = this.a.c.z();
                    }
                } else {
                    str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd7);
                }
                if (!StringUtils.isNull(str2)) {
                    this.a.q.m0(TbSingleton.getInstance().getAdVertiComment(jr7Var.k0(), jr7Var.l0(), str2));
                }
                this.a.c.S(jr7Var, this.a.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes3.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                qv7 qv7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qv7Var = this.a.c.s) == null || qv7Var.g() == null) {
                    return;
                }
                if (!this.a.c.s.g().e()) {
                    this.a.c.s.b(false);
                }
                this.a.c.s.g().l(false);
            }

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
        }

        public l(FoldCommentActivity foldCommentActivity, String str, String str2) {
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
            int f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = pi.i(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = pi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = pi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.y[1] + foldCommentActivity.z) - i3, 50);
                if (this.c.c.y() != null) {
                    this.c.q.a().setVisibility(8);
                    this.c.c.y().o(this.a, this.b, this.c.c.z(), (this.c.a == null || this.c.a.R1() == null || this.c.a.R1().O() == null || !this.c.a.R1().O().isBjh()) ? false : false);
                    r35 b = this.c.c.y().b();
                    if (b != null && this.c.a != null && this.c.a.R1() != null) {
                        b.G(this.c.a.R1().d());
                        b.c0(this.c.a.R1().O());
                    }
                    if (this.c.s.f() == null && this.c.c.y().b().t() != null) {
                        this.c.c.y().b().t().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().t().i());
                        this.c.c.y().b().M(this.c.h0);
                    }
                }
                this.c.c.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements xm6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            /* renamed from: com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0230a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0230a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    qv7 qv7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qv7Var = this.a.a.c.s) == null || qv7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.s.g().e()) {
                        this.a.a.c.s.b(false);
                    }
                    this.a.a.c.s.g().l(false);
                }

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

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = pi.i(this.a.c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    FoldCommentActivity foldCommentActivity = this.a.c;
                    boolean z = true;
                    foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.y[1] + foldCommentActivity.z) - i3, 50);
                    if (this.a.c.c.y() != null) {
                        this.a.c.q.a().setVisibility(8);
                        z = (this.a.c.a == null || this.a.c.a.R1() == null || this.a.c.a.R1().O() == null || !this.a.c.a.R1().O().isBjh()) ? false : false;
                        ju7 y = this.a.c.c.y();
                        m mVar = this.a;
                        y.o(mVar.a, mVar.b, mVar.c.c.z(), z);
                        r35 b = this.a.c.c.y().b();
                        if (b != null && this.a.c.a != null && this.a.c.a.R1() != null) {
                            b.G(this.a.c.a.R1().d());
                            b.c0(this.a.c.a.R1().O());
                        }
                        if (this.a.c.s.f() == null && this.a.c.c.y().b().t() != null) {
                            this.a.c.c.y().b().t().g(new C0230a(this));
                            FoldCommentActivity foldCommentActivity2 = this.a.c;
                            foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().t().i());
                            this.a.c.c.y().b().M(this.a.c.h0);
                        }
                    }
                    this.a.c.c.B();
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

        @Override // com.repackage.xm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                qg.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.xm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements k35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public n(FoldCommentActivity foldCommentActivity) {
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

        @Override // com.repackage.k35
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qv7 qv7Var = this.a.s;
                if (qv7Var == null || qv7Var.g() == null || !this.a.s.g().d()) {
                    return !this.a.B1(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                if (this.a.c != null && this.a.c.y() != null && this.a.c.y().b() != null && this.a.c.y().b().x()) {
                    this.a.c.y().b().v(this.a.s.h());
                }
                this.a.s.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o implements xm6.d {
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

        @Override // com.repackage.xm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.q != null && this.a.q.a() != null) {
                    this.a.q.a().A(new j15(45, 27, null));
                }
                this.a.c.t();
            }
        }

        @Override // com.repackage.xm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements jl4.a {
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

        @Override // com.repackage.jl4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.C != null) {
                        this.a.C.h(z2);
                    }
                    this.a.a.E3(z2);
                    if (this.a.a.C1()) {
                        this.a.h2();
                    }
                    if (z2) {
                        if (this.a.C != null) {
                            if (this.a.C.f() == null || this.a.a == null || this.a.a.R1() == null || this.a.a.R1().O() == null || this.a.a.R1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.C.f();
                            MetaData author = this.a.a.R1().O().getAuthor();
                            if (f != null && author != null) {
                                if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                    if (kz4.g(this.a.getActivity(), 0)) {
                                        kz4.i(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                        this.a.v1();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb3));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14d3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements fg<ImageView> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (zm4.c().g()) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = zm4.c().g();
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class r implements TbRichTextView.y {
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

        /* JADX DEBUG: Multi-variable search result rejected for r14v21, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.obfuscated_res_0x7f091f24) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091f24) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        if (this.a.a.R1().g0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view2.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view2.getParent();
                            } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                            }
                            int i2 = -1;
                            if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().E() != null) {
                                ArrayList<TbRichTextImageInfo> E = tbRichTextView.getRichText().E();
                                int i3 = -1;
                                for (int i4 = 0; i4 < E.size(); i4++) {
                                    if (E.get(i4) != null) {
                                        arrayList.add(E.get(i4).G());
                                        if (i3 == -1 && str != null && (str.equals(E.get(i4).G()) || str.equals(E.get(i4).C()) || str.equals(E.get(i4).A()) || str.equals(E.get(i4).B()) || str.equals(E.get(i4).E()))) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = E.get(i4).G();
                                        imageUrlData.originalUrl = E.get(i4).G();
                                        imageUrlData.isLongPic = E.get(i4).J();
                                        concurrentHashMap.put(E.get(i4).G(), imageUrlData);
                                    }
                                }
                                i2 = i3;
                            }
                            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                            builder.y(arrayList);
                            builder.C(i2);
                            builder.D(false);
                            builder.G(this.a.a.c2());
                            builder.x(concurrentHashMap);
                            builder.I(true);
                            builder.L(false);
                            builder.H(this.a.b2());
                            if (this.a.a != null) {
                                builder.B(this.a.a.getFromForumId());
                                if (this.a.a.R1() != null) {
                                    builder.O(this.a.a.R1().O());
                                }
                            }
                            ImageViewerConfig w = builder.w(this.a.getPageContext().getPageActivity());
                            w.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, w));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.l2(str, i, eVar);
                        if (eVar.h) {
                            TbRichText C2 = this.a.C2(str, i);
                            if (C2 != null && this.a.H >= 0 && this.a.H < C2.C().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = kr7.a(C2.C().get(this.a.H));
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= eVar.a.size()) {
                                        break;
                                    } else if (eVar.a.get(i5).equals(a)) {
                                        eVar.j = i5;
                                        arrayList2.add(a);
                                        break;
                                    } else {
                                        i5++;
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.b.get(str2));
                                }
                                ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                                builder2.y(arrayList2);
                                builder2.A(eVar.c);
                                builder2.z(eVar.d);
                                builder2.P(eVar.e);
                                builder2.D(eVar.g);
                                builder2.I(true);
                                builder2.K(eVar.i);
                                builder2.G(this.a.a.c2());
                                builder2.x(concurrentHashMap2);
                                builder2.L(false);
                                builder2.H(this.a.b2());
                                builder2.M(eVar.f);
                                if (this.a.a != null) {
                                    builder2.B(this.a.a.getFromForumId());
                                    if (this.a.a.R1() != null) {
                                        builder2.O(this.a.a.R1().O());
                                    }
                                }
                                ImageViewerConfig w2 = builder2.w(this.a.getPageContext().getPageActivity());
                                w2.getIntent().putExtra("from", "pb");
                                this.a.sendMessage(new CustomMessage(2010000, w2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                        builder3.y(arrayList3);
                        builder3.A(eVar.c);
                        builder3.z(eVar.d);
                        builder3.P(eVar.e);
                        builder3.D(eVar.g);
                        builder3.I(true);
                        builder3.K(eVar.a.get(0));
                        builder3.G(this.a.a.c2());
                        builder3.x(concurrentHashMap3);
                        builder3.L(false);
                        builder3.H(this.a.b2());
                        builder3.M(eVar.f);
                        builder3.E(false);
                        if (this.a.a != null) {
                            builder3.B(this.a.a.getFromForumId());
                            if (this.a.a.R1() != null) {
                                builder3.O(this.a.a.R1().O());
                            }
                        }
                        ImageViewerConfig w3 = builder3.w(this.a.getPageContext().getPageActivity());
                        w3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, w3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f24);
                    boolean w4 = ((TbImageView) view2).w();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w4)));
                    }
                    this.a.G = view2;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.q.M(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.c != null && this.a.c.y() != null && this.a.c.y().b() != null) {
                    this.a.c.y().b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.q2(foldCommentActivity.w);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements PbFragment.f3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.f3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ni.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.R1().l().getId(), this.a.a.R1().l().getName(), this.a.a.R1().O().getId(), String.valueOf(this.a.a.R1().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements ls7.a {
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

        @Override // com.repackage.ls7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091b17) {
                        if (this.a.p2(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09172b) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f091f00) instanceof SparseArray) {
                            this.a.w2((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091f00));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f091784) {
                        SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.w2(sparseArray);
                    }
                }
                if (this.a.q != null) {
                    this.a.c.W(this.a.q.C());
                }
                this.a.c.R();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.E1(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class w implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.A2(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091711);
                        this.a.o2(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091710);
                        this.a.o2(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091713);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.o2(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091713);
                        if (view6 != null) {
                            this.a.o2(view6);
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
                        if (this.a.N == null || TextUtils.isEmpty(this.a.O)) {
                            return;
                        }
                        if (this.a.P == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.O));
                        } else {
                            m45.a aVar = new m45.a();
                            aVar.a = this.a.O;
                            String str = "";
                            if (this.a.P.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.P.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.N = null;
                        this.a.O = null;
                        return;
                    case 2:
                        if (this.a.N == null || TextUtils.isEmpty(this.a.O)) {
                            return;
                        }
                        if (this.a.j == null) {
                            this.a.j = new PermissionJudgePolicy();
                        }
                        this.a.j.clearRequestPermissionList();
                        this.a.j.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.j.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.M == null) {
                            FoldCommentActivity foldCommentActivity = this.a;
                            foldCommentActivity.M = new sv7(foldCommentActivity.getPageContext());
                        }
                        this.a.M.b(this.a.O, this.a.N.n());
                        this.a.N = null;
                        this.a.O = null;
                        return;
                    case 3:
                        PostData postData = this.a.Q;
                        if (postData != null) {
                            postData.r0();
                            this.a.Q = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.i2(view2);
                            if (this.a.a.R1().O() == null || this.a.a.R1().O().getAuthor() == null || this.a.a.R1().O().getAuthor().getUserId() == null || this.a.C == null) {
                                return;
                            }
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int U1 = foldCommentActivity2.U1(foldCommentActivity2.a.R1());
                            ThreadData O = this.a.a.R1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.j2()).param("obj_locate", 2).param("obj_id", this.a.a.R1().O().getAuthor().getUserId()).param("obj_type", !this.a.C.e()).param("obj_source", U1).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!ni.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.X1((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091f44)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091f00, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091ee9, 2);
                                this.a.y1(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091ef1) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091eef) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091f0c) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f091f01) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091f0c)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091f01)).booleanValue();
                            boolean G = this.a.G(TbadkCoreApplication.getCurrentAccount());
                            if (G) {
                                if (!booleanValue2) {
                                    this.a.u2(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.c.N(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eef), intValue, booleanValue, null, G);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.u2(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.c.L(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eef), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!ni.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2c);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f30)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f2e)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f44)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.c.L(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091eef), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091f00, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091ee9, 2);
                            this.a.y1(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091ee9, 2);
                            this.a.c.P(view2);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed);
                            if (postData2.p() == null) {
                                return;
                            }
                            this.a.C1(postData2.p());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.a == null || this.a.a.R1() == null) {
                            return;
                        }
                        this.a.t2(dp8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ FoldCommentActivity d;

        public x(FoldCommentActivity foldCommentActivity, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (cr4Var != null) {
                    cr4Var.dismiss();
                }
                this.d.H1(((Integer) this.a.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091eef), this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
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
        this.y = new int[2];
        this.C = null;
        this.F = new k(this);
        this.H = 0;
        this.I = new r(this);
        this.J = false;
        this.K = new ls7(new u(this));
        this.L = new v(this);
        this.Q = null;
        this.R = new w(this);
        this.T = new a(this);
        this.U = new e(this);
        this.V = new f(this, 2004008);
        this.W = new g(this);
        this.X = UbsABTestHelper.showTrisectionAndFeedback();
        this.g0 = new j(this);
        this.h0 = new n(this);
        this.i0 = new p(this);
    }

    @Override // com.repackage.vg5
    public eg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    @Override // com.repackage.ws7
    public rw7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (rw7) invokeV.objValue;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if ((this.a.R1() != null && (this.a.R1().g0() || ThreadCardUtils.isSelf(this.a.R1().O()))) || this.u == null || this.a.R1() == null || this.a.R1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.R1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void A2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.j2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fx7.m(i2))));
        }
    }

    public boolean B1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.u == null || this.a.R1() == null || ThreadCardUtils.isSelf(this.a.R1().O()) || this.a.R1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeSend(this.a.R1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.F(this.a.getForumId()) && this.a.R1() != null && this.a.R1().l() != null) {
            if (this.a.R1().l().isLike() == 1) {
                this.a.e1().E(this.a.getForumId(), this.a.j2());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C1(AgreeData agreeData) {
        p85 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new tt4();
        }
        if (this.m == null) {
            ei8 ei8Var = new ei8();
            this.m = ei8Var;
            ei8Var.a = getUniqueId();
        }
        tn4 tn4Var = new tn4();
        tn4Var.b = 5;
        tn4Var.h = 8;
        tn4Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            tn4Var.f = pbModel2.Q1();
        }
        tn4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                tn4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel != null || pbModel.R1() == null) {
                }
                this.l.b(this, tn4Var, agreeData, this.a.R1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            tn4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            tn4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
        if (currentVisiblePageExtra != null) {
        }
        this.l.c(agreeData, i2, getUniqueId(), false);
        this.l.d(agreeData, this.m);
        pbModel = this.a;
        if (pbModel != null) {
        }
    }

    public final TbRichText C2(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.R1() == null || str == null || i2 < 0) {
                return null;
            }
            jr7 R1 = this.a.R1();
            if (R1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(R1.j());
                tbRichText = L1(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = R1.F();
                w1(R1, F);
                return L1(F, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.a.w1() || this.a.z1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.j2());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.j2()));
            finish();
        }
    }

    @Override // com.repackage.vg5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean E1(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        jl4 jl4Var;
        boolean z;
        List<jr4> b2;
        jr4 jr4Var;
        jr4 jr4Var2;
        jr4 jr4Var3;
        ym ymVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed);
            this.Q = postData;
            if (postData == null || (jl4Var = this.C) == null) {
                return true;
            }
            if (jl4Var.e() && this.Q.J() != null) {
                this.Q.J().equals(this.a.M1());
            }
            if (this.i == null) {
                nr4 nr4Var = new nr4(this);
                this.i = nr4Var;
                nr4Var.n(this.R);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean c2 = c2(view2);
            boolean z2 = (!c2(view2) || (ymVar = this.N) == null || ymVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091f06) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f06)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091f30) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f30)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091f2e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f2e)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091efd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091efd) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091f05) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f05)).booleanValue() : false;
            if (c2) {
                z = booleanValue;
                arrayList.add(new jr4(1, getString(R.string.obfuscated_res_0x7f0f1098), this.i));
            } else {
                z = booleanValue;
            }
            if (z2) {
                arrayList.add(new jr4(2, getString(R.string.obfuscated_res_0x7f0f1099), this.i));
            }
            if (!c2 && !z2) {
                jr4 jr4Var4 = new jr4(3, getString(R.string.obfuscated_res_0x7f0f0443), this.i);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091eed, this.Q);
                jr4Var4.d.setTag(sparseArray2);
                arrayList.add(jr4Var4);
            }
            if (this.mIsLogin) {
                if (!fx7.h(this.a) && !booleanValue4 && booleanValue3) {
                    jr4 jr4Var5 = new jr4(5, getString(R.string.obfuscated_res_0x7f0f0b23), this.i);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f04, sparseArray.get(R.id.obfuscated_res_0x7f091f04));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f40, sparseArray.get(R.id.obfuscated_res_0x7f091f40));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f41, sparseArray.get(R.id.obfuscated_res_0x7f091f41));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f3f, sparseArray.get(R.id.obfuscated_res_0x7f091f3f));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f42, sparseArray.get(R.id.obfuscated_res_0x7f091f42));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ef0, sparseArray.get(R.id.obfuscated_res_0x7f091ef0));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                    jr4Var5.d.setTag(sparseArray3);
                    arrayList.add(jr4Var5);
                } else {
                    if (d2(booleanValue2) && TbadkCoreApplication.isLogin()) {
                        jr4 jr4Var6 = new jr4(5, getString(R.string.obfuscated_res_0x7f0f0fd6), this.i);
                        jr4Var6.d.setTag(str);
                        arrayList.add(jr4Var6);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091f30, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091efa, sparseArray.get(R.id.obfuscated_res_0x7f091efa));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091efb, sparseArray.get(R.id.obfuscated_res_0x7f091efb));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091efc, sparseArray.get(R.id.obfuscated_res_0x7f091efc));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091efd, str);
                    if (!fx7.h(this.a) && booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f04, sparseArray.get(R.id.obfuscated_res_0x7f091f04));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f40, sparseArray.get(R.id.obfuscated_res_0x7f091f40));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f41, sparseArray.get(R.id.obfuscated_res_0x7f091f41));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f3f, sparseArray.get(R.id.obfuscated_res_0x7f091f3f));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f42, sparseArray.get(R.id.obfuscated_res_0x7f091f42));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                    }
                    if (booleanValue6) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue2));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                        if (booleanValue7) {
                            jr4Var = new jr4(6, getString(R.string.obfuscated_res_0x7f0f049f), this.i);
                            jr4Var.d.setTag(sparseArray4);
                            jr4Var2 = new jr4(7, getString(R.string.obfuscated_res_0x7f0f02df), this.i);
                            jr4Var2.d.setTag(sparseArray4);
                        }
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f2e, Boolean.FALSE);
                    }
                    jr4Var = null;
                    jr4Var2 = new jr4(7, getString(R.string.obfuscated_res_0x7f0f02df), this.i);
                    jr4Var2.d.setTag(sparseArray4);
                } else {
                    if (booleanValue6) {
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f30, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(booleanValue2));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                        if (this.a.R1().V() == 1002 && !booleanValue2) {
                            jr4Var3 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f0fd6), this.i);
                        } else {
                            jr4Var3 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f049f), this.i);
                        }
                        jr4Var3.d.setTag(sparseArray5);
                        jr4Var = jr4Var3;
                    } else {
                        jr4Var = null;
                    }
                    jr4Var2 = null;
                }
                if (jr4Var != null) {
                    arrayList.add(jr4Var);
                }
                if (jr4Var2 != null) {
                    arrayList.add(jr4Var2);
                }
                fx7.a(arrayList, this.i, this.Q, this.a);
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = fx7.c(arrayList, this.Q.p(), sparseArray, this.i);
            } else {
                b2 = fx7.b(arrayList, this.Q.p(), sparseArray, this.i);
            }
            fx7.k(b2, this.g);
            fx7.e(b2);
            this.i.o(fx7.f(this.Q));
            if (UbsABTestHelper.isPBPlanA()) {
                this.i.k(b2, false);
            } else {
                this.i.k(b2, true);
            }
            lr4 lr4Var = new lr4(getPageContext(), this.i);
            this.h = lr4Var;
            lr4Var.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.j2()).param("fid", this.a.getForumId()).param("uid", this.a.R1().O().getAuthor().getUserId()).param("post_id", this.a.C()).param("obj_source", z ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void F1(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(nv7.i2)).intValue();
            if (intValue == nv7.j2) {
                if (this.n.T()) {
                    return;
                }
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eef);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f0c)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
                if (jSONArray != null) {
                    this.n.V(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.W(this.a.R1().l().getId(), this.a.R1().l().getName(), this.a.R1().O().getId(), str, intValue3, intValue2, booleanValue, this.a.R1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == nv7.k2 || intValue == nv7.m2) {
                if (this.a.m1() != null) {
                    this.a.m1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == nv7.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    @Override // com.repackage.ws7
    public boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            PbModel pbModel = this.a;
            return pbModel != null && pbModel.H2(str);
        }
        return invokeL.booleanValue;
    }

    public void G1(cr4 cr4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, cr4Var, jSONArray) == null) {
            cr4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (cr4Var.getYesButtonTag() instanceof SparseArray) {
                    F1((SparseArray) cr4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    @Override // com.repackage.vg5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
        }
    }

    public void H1(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eef, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091ef1, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(z));
            sparseArray.put(nv7.i2, Integer.valueOf(nv7.j2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                F1(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void I1(ForumManageModel.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, bVar, z) == null) || bVar == null) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04a4);
        int i2 = 0;
        if (bVar.c == 1211066) {
            hideProgressBar();
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setMessage(string);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, new b(this));
            cr4Var.setCancelable(true);
            cr4Var.create(getPageContext());
            cr4Var.show();
        } else if (bVar.d != 0) {
            this.c.v(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<PostData> F = this.a.R1().F();
                int size = F.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.g.equals(F.get(i2).J())) {
                        F.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.a.R1().O().setReply_num(this.a.R1().O().getReply_num() - 1);
            } else if (i3 == 0) {
                D1();
            } else if (i3 == 2) {
                ArrayList<PostData> F2 = this.a.R1().F();
                int size2 = F2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= F2.get(i4).S().size()) {
                            break;
                        } else if (bVar.g.equals(F2.get(i4).S().get(i5).J())) {
                            F2.get(i4).S().remove(i5);
                            F2.get(i4).k();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    F2.get(i4).l(bVar.g);
                }
            }
        }
    }

    @Override // com.repackage.vg5
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
        }
    }

    public AntiData J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.R1() == null) {
                return null;
            }
            return this.a.R1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public PostData K1() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.R1() == null || this.a.R1().O() == null || this.a.R1().O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = this.a.R1().O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = this.a.R1().O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.s0(1);
            postData.x0(this.a.R1().O().getFirstPostId());
            postData.J0(this.a.R1().O().getTitle());
            postData.I0(this.a.R1().O().getCreateTime());
            postData.q0(author);
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    public final TbRichText L1(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText Q = arrayList.get(i3).Q();
                    if (Q != null && (C = Q.C()) != null) {
                        int size = C.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (C.get(i5) != null && C.get(i5).getType() == 8) {
                                i4++;
                                if (C.get(i5).G().C().equals(str) || C.get(i5).G().D().equals(str)) {
                                    int h2 = (int) pi.h(TbadkCoreApplication.getInst());
                                    int width = C.get(i5).G().getWidth() * h2;
                                    int height = C.get(i5).G().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.H = i5;
                                    return Q;
                                } else if (i4 > i2) {
                                    break;
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

    @Override // com.repackage.vg5
    public eg<RelativeLayout> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public final int M1(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.J = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.C().size();
                int i4 = i2;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.C().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int h2 = (int) pi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.G().getWidth() * h2;
                        int height = tbRichTextData.G().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.G().I()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = kr7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (G = tbRichTextData.G()) != null) {
                                    String C = G.C();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        C = G.D();
                                    } else {
                                        imageUrlData.urlType = this.f ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = C;
                                    imageUrlData.originalUrl = Q1(tbRichTextData);
                                    imageUrlData.originalSize = R1(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = O1(tbRichTextData);
                                    imageUrlData.isLongPic = N1(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = ng.g(this.a.j2(), -1L);
                                    imageUrlData.mIsReserver = this.a.c2();
                                    imageUrlData.mIsSeeHost = this.a.u1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.J) {
                                i4++;
                            }
                        }
                    }
                }
                return i4;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final boolean N1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return false;
            }
            return tbRichTextData.G().J();
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.vg5
    public eg<ImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.D == null) {
                this.D = new eg<>(new q(this), 8, 0);
            }
            return this.D;
        }
        return (eg) invokeV.objValue;
    }

    public final boolean O1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return false;
            }
            return tbRichTextData.G().K();
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.vg5
    public eg<View> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public PbModel P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    @Override // com.repackage.vg5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    public final String Q1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return null;
            }
            return tbRichTextData.G().E();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.vg5
    public void R(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048606, this, context, str, z) == null) {
        }
    }

    public final long R1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return 0L;
            }
            return tbRichTextData.G().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public n35 S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.q : (n35) invokeV.objValue;
    }

    @Override // com.repackage.ws7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.R1() == null) {
                return 0;
            }
            return this.a.R1().V();
        }
        return invokeV.intValue;
    }

    public tw7 T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.e : (tw7) invokeV.objValue;
    }

    public final int U1(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.O() == null) {
                return 0;
            }
            if (jr7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (jr7Var.O().getThreadType() == 54) {
                return 2;
            }
            return jr7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.vg5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, str, str2) == null) {
        }
    }

    public final void V1(int i2, Intent intent) {
        v15 v15Var;
        v15 v15Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048613, this, i2, intent) == null) {
            if (i2 == 0) {
                this.c.D();
                this.c.y().c();
                this.c.a0(false);
            }
            this.c.R();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                int editorType = pbEditorData.getEditorType();
                if (editorType != 0) {
                    if (editorType != 1 || this.c.y() == null || this.c.y().b() == null) {
                        return;
                    }
                    r35 b2 = this.c.y().b();
                    b2.c0(this.a.R1().O());
                    b2.B(writeData);
                    b2.d0(pbEditorData.getVoiceModel());
                    u15 n2 = b2.a().n(6);
                    if (n2 != null && (v15Var2 = n2.m) != null) {
                        v15Var2.C(new j15(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b2.F();
                        return;
                    }
                    return;
                }
                this.q.T();
                this.q.w0(pbEditorData.getVoiceModel());
                this.q.G(writeData);
                u15 n3 = this.q.a().n(6);
                if (n3 != null && (v15Var = n3.m) != null) {
                    v15Var.C(new j15(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.q.M(null, null);
                }
            }
        }
    }

    public void W1(boolean z, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091f41) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f41) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091f43) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f43) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091f42) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f42) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091f3e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f3e) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091f3f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f3f) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.k);
            userMuteAddAndDelCustomMessage.setTag(this.k);
            v2(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void X1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.R1() != null && this.a.R1().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.j2(), str);
                ThreadData O = this.a.R1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                e2(format);
                return;
            }
            this.b.a(str);
        }
    }

    @Override // com.repackage.vg5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, context, str) == null) {
        }
    }

    @Override // com.repackage.ws7
    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.q1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void Y1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            this.k = getUniqueId();
            jl4 c2 = jl4.c(this);
            this.C = c2;
            if (c2 != null) {
                c2.j(this.i0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.n = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.T);
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.F);
            } else {
                this.a = new PbModel(this, getIntent(), this.F);
            }
            this.a.z3(true);
            this.a.B3(4);
        }
    }

    @Override // com.repackage.vg5
    public eg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public final boolean Z1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    public final void a2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            this.d = new rw7(this);
            this.e = new tw7(getPageContext());
            it7 it7Var = new it7(this, this.g0, this.I, this.K, this.L);
            this.c = it7Var;
            it7Var.Y(this.a);
            setContentView(this.c.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.s();
            this.c.V(new t(this));
            p35 p35Var = new p35();
            this.p = p35Var;
            r2(p35Var);
            n35 n35Var = (n35) this.p.a(getActivity());
            this.q = n35Var;
            n35Var.f0(getPageContext());
            this.q.q0(this.U);
            this.q.h0(1);
            this.q.F(getPageContext(), bundle);
            this.q.a().b(new t15(getActivity()));
            this.q.a().C(true);
            s2(true);
            this.q.P(this.a.t1(), this.a.j2(), this.a.p1());
            this.c.T(this.q.a());
            this.s = new qv7();
            if (this.q.v() != null) {
                this.s.m(this.q.v().i());
            }
            registerListener(this.V);
            if (!this.a.E1()) {
                this.q.s(this.a.j2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.x2()) {
                this.q.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd7));
            } else {
                it7 it7Var2 = this.c;
                if (it7Var2 != null) {
                    this.q.m0(it7Var2.z());
                }
            }
            this.x = new ShareSuccessReplyToServerModel();
        }
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.u1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    public final boolean d2(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.R1() != null) {
                return ((this.a.R1().V() != 0) || this.a.R1().O() == null || this.a.R1().O().getAuthor() == null || TextUtils.equals(this.a.R1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.repackage.vg5
    public eg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public final void e2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void f2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (pbModel = this.a) == null) {
            return;
        }
        pbModel.Q2();
    }

    public final void g2(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048631, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || !A1()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.y);
            this.z = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.y() != null && postData != null) {
            this.c.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fcc), postData.s().getName_show(), postData.Q() != null ? postData.Q().toString() : ""));
        }
        if (this.a.R1() != null && this.a.R1().g0()) {
            qg.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.B == null) {
            xm6 xm6Var = new xm6(getPageContext());
            this.B = xm6Var;
            xm6Var.j(1);
            this.B.i(new m(this, str, str2));
        }
        PbModel pbModel = this.a;
        if (pbModel == null || pbModel.R1() == null || this.a.R1().l() == null) {
            return;
        }
        this.B.g(this.a.R1().l().getId(), ng.g(this.a.j2(), 0L));
    }

    @Override // com.repackage.vg5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.repackage.vg5
    public void h1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, context, str) == null) {
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            jr7 R1 = this.a.R1();
            this.a.E3(true);
            jl4 jl4Var = this.C;
            if (jl4Var != null) {
                R1.E0(jl4Var.g());
            }
        }
    }

    public final void i2(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed)) == null) {
                return;
            }
            j2(postData);
        }
    }

    public void j2(PostData postData) {
        jl4 jl4Var;
        PostData K1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, postData) == null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.J() != null && postData.J().equals(this.a.M1())) {
            z = true;
        }
        MarkData L1 = this.a.L1(postData);
        if (this.a.R1() != null && this.a.R1().g0() && (K1 = K1()) != null) {
            L1 = this.a.L1(K1);
        }
        if (L1 == null || (jl4Var = this.C) == null) {
            return;
        }
        jl4Var.i(L1);
        if (!z) {
            this.C.a();
        } else {
            this.C.d();
        }
    }

    public final void k2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048637, this, i2, str) == null) {
            if (this.a.q2()) {
                showToast(str);
            } else if (!pi.D()) {
                this.c.f0(R.string.obfuscated_res_0x7f0f0f8e);
            } else if (i2 == 4) {
                it7 it7Var = this.c;
                it7Var.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                it7 it7Var2 = this.c;
                it7Var2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.c.f0(R.string.obfuscated_res_0x7f0f0c45);
            }
        }
    }

    public final void l2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048638, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        jr7 R1 = this.a.R1();
        TbRichText C2 = C2(str, i2);
        if (C2 == null || (tbRichTextData = C2.C().get(this.H)) == null) {
            return;
        }
        eVar.f = String.valueOf(C2.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.G().I()) {
            eVar.h = false;
            String a2 = kr7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.f ? 17 : 18;
            }
            imageUrlData.originalUrl = Q1(tbRichTextData);
            imageUrlData.originalUrl = Q1(tbRichTextData);
            imageUrlData.originalSize = R1(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = O1(tbRichTextData);
            imageUrlData.isLongPic = N1(tbRichTextData);
            imageUrlData.postId = C2.getPostId();
            imageUrlData.mIsReserver = this.a.c2();
            imageUrlData.mIsSeeHost = this.a.u1();
            eVar.b.put(a2, imageUrlData);
            if (R1 != null) {
                if (R1.l() != null) {
                    eVar.c = R1.l().getName();
                    eVar.d = R1.l().getId();
                }
                if (R1.O() != null) {
                    eVar.e = R1.O().getId();
                }
                eVar.g = R1.s() == 1;
            }
            imageUrlData.threadId = ng.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = R1.F().size();
        this.J = false;
        eVar.j = -1;
        int M1 = R1.j() != null ? M1(R1.j().Q(), C2, i2, i2, eVar.a, eVar.b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = R1.F().get(i3);
            if (postData.J() == null || R1.j() == null || R1.j().J() == null || !postData.J().equals(R1.j().J())) {
                M1 = M1(postData.Q(), C2, M1, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (R1 != null) {
            if (R1.l() != null) {
                eVar.c = R1.l().getName();
                eVar.d = R1.l().getId();
            }
            if (R1.O() != null) {
                eVar.e = R1.O().getId();
            }
            eVar.g = R1.s() == 1;
        }
        eVar.j = M1;
    }

    public void m2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.R1() == null || this.a.R1().l() == null || x1()) {
            return;
        }
        if (this.a.R1().g0()) {
            this.c.t();
            return;
        }
        if (this.A == null) {
            xm6 xm6Var = new xm6(getPageContext());
            this.A = xm6Var;
            xm6Var.j(0);
            this.A.i(new o(this));
        }
        this.A.g(this.a.R1().l().getId(), ng.g(this.a.j2(), 0L));
    }

    public final AbsPbActivity.e n2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, str)) == null) {
            String str2 = null;
            if (this.a.R1() != null && this.a.R1().F() != null && this.a.R1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.a.R1().F().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.a.R1().F().get(i2).J())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.a.R1().F().get(i2);
                if (postData.Q() != null && postData.Q().C() != null) {
                    Iterator<TbRichTextData> it = postData.Q().C().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.G() != null) {
                                str2 = next.G().C();
                            }
                        }
                    }
                    l2(str2, 0, eVar);
                    kr7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void o2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f0917a9, Integer.valueOf(this.g ? 2 : 3));
        view2.setTag(sparseArray);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048642, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.H(i2, i3, intent);
            nw7 nw7Var = this.v;
            if (nw7Var != null) {
                nw7Var.i(i2, i3, intent);
            }
            if (this.c.y() != null) {
                this.c.y().g(i2, i3, intent);
            }
            if (i2 == 25035) {
                V1(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 13008) {
                    fv7.b().m();
                    this.mHandler.postDelayed(new h(this), 1000L);
                } else if (i2 == 13011) {
                    v88.g().m(getPageContext());
                } else if (i2 != 24007) {
                } else {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        v88.g().m(getPageContext());
                        B2();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.x;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.w) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.A(str, intExtra, new i(this));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
        }
    }

    @Override // com.repackage.cr4.e
    public void onClick(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, cr4Var) == null) {
            G1(cr4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bundle) == null) {
            Z1(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            Y1(bundle);
            a2(bundle);
            f2();
            if (this.r) {
                this.c.A().setAnimTime(0);
                this.c.A().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.E = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.A().h();
            this.c.x().setFromForumId(this.a.getFromForumId());
            lx7 lx7Var = new lx7(this);
            this.b = lx7Var;
            lx7Var.b(getUniqueId());
            this.o = new ep8(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.m0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.m0(this.c.z());
            }
            oz4.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            super.onPause();
            if (this.r) {
                z2(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            super.onResume();
            if (this.r) {
                z2(true);
            }
        }
    }

    public final boolean p2(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091eed);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.R1() != null) {
                        if (this.c.y() != null) {
                            this.c.y().c();
                        }
                        zr7 zr7Var = new zr7();
                        zr7Var.A(this.a.R1().l());
                        zr7Var.E(this.a.R1().O());
                        zr7Var.C(postData);
                        TiebaStatic.log("c11743");
                        this.c.x().W(zr7Var);
                        this.c.x().setPostId(postData.J());
                        g2(view2, postData.s().getUserId(), "", postData);
                        n35 n35Var = this.q;
                        if (n35Var != null) {
                            this.c.W(n35Var.C());
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void q2(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048650, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.v == null) {
            nw7 nw7Var = new nw7(this);
            this.v = nw7Var;
            nw7Var.n(this.U);
        }
        nw7 nw7Var2 = this.v;
        PbModel pbModel = this.a;
        nw7Var2.k(emotionImageData, pbModel, pbModel.R1());
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void r0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048651, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (sg5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), sg5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (tv7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new ze5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void r2(p35 p35Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, p35Var) == null) || p35Var == null || (pbModel = this.a) == null) {
            return;
        }
        p35Var.p(pbModel.q1());
        if (this.a.R1() != null && this.a.R1().l() != null) {
            p35Var.o(this.a.R1().l());
        }
        p35Var.q("pb");
        p35Var.r(this.a);
    }

    public final void s2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.q.g0(z);
            this.q.k0(z);
            this.q.s0(z);
        }
    }

    public void t2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048654, this, str) == null) || str == null || this.o == null) {
            return;
        }
        this.o.n(ng.g(str, 0L));
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.t : (VoiceManager) invokeV.objValue;
    }

    public final void u2(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            fx7.d(getActivity(), getPageContext(), new x(this, sparseArray, i2, z), new y(this));
        }
    }

    @Override // com.repackage.ws7
    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.G2();
        }
        return invokeV.booleanValue;
    }

    public final void v1() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || (pbModel = this.a) == null || pbModel.R1() == null || this.a.R1().O() == null) {
            return;
        }
        ThreadData O = this.a.R1().O();
        O.mRecomAbTag = this.a.W1();
        O.mRecomWeight = this.a.Z1();
        O.mRecomSource = this.a.Y1();
        O.mRecomExtra = this.a.X1();
        O.isSubPb = this.a.E1();
        if (O.getFid() == 0) {
            O.setFid(ng.g(this.a.getForumId(), 0L));
        }
        StatisticItem i2 = u85.i(this, O, "c13562");
        TbPageTag l2 = u85.l(this);
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

    public final void v2(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            cr4 cr4Var = new cr4(this);
            if (oi.isEmpty(str)) {
                cr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0319, str3));
            } else {
                cr4Var.setMessage(str);
            }
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0427, new c(this, userMuteAddAndDelCustomMessage));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new d(this));
            cr4Var.create(getPageContext()).show();
        }
    }

    public final void w1(jr7 jr7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048660, this, jr7Var, arrayList) == null) || jr7Var == null || jr7Var.T() == null || jr7Var.T().a == null || (list = jr7Var.T().a) == null || arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list.size() <= 0 || arrayList.size() <= 0) {
            return;
        }
        arrayList3.addAll(list);
        Iterator<PostData> it = arrayList.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    PostData postData = (PostData) it2.next();
                    if (postData != null && !TextUtils.isEmpty(next.J()) && !TextUtils.isEmpty(postData.J()) && next.J().equals(postData.J())) {
                        arrayList2.add(postData);
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

    public final void w2(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048661, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091eed) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed)) != null) {
            x2(postData, false);
        }
    }

    @Override // com.repackage.vg5
    public eg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public final boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.R1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.a.R1().O()) || AntiHelper.d(getPageContext(), this.a.R1().d());
        }
        return invokeV.booleanValue;
    }

    public final void x2(PostData postData, boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048664, this, postData, z) == null) || postData == null || (pbModel = this.a) == null || pbModel.R1() == null || postData.B() == 1) {
            return;
        }
        String j2 = this.a.j2();
        String J = postData.J();
        int V = this.a.R1() != null ? this.a.R1().V() : 0;
        AbsPbActivity.e n2 = n2(J);
        if (n2 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this).createSubPbActivityConfig(j2, J, "pb", true, this.r, null, false, null, V, postData.V(), this.a.R1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(n2.a, n2.b, n2.g, n2.j);
        addBigImageData.setKeyPageStartFrom(this.a.Q1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.o2());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.j1());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void y1(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = ng.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = ng.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091f40), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.S = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void y2() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || (voiceManager = this.t) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    @Override // com.repackage.vg5
    public eg<TiebaPlusRecommendCard> z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public void z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.E);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
