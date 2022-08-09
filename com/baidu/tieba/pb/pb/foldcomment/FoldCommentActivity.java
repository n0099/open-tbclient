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
import com.repackage.az4;
import com.repackage.bm4;
import com.repackage.bs4;
import com.repackage.c9;
import com.repackage.cb8;
import com.repackage.cx7;
import com.repackage.ds4;
import com.repackage.ev7;
import com.repackage.fg;
import com.repackage.fs4;
import com.repackage.ft7;
import com.repackage.fz7;
import com.repackage.g05;
import com.repackage.gg;
import com.repackage.gi5;
import com.repackage.gt7;
import com.repackage.h25;
import com.repackage.h45;
import com.repackage.hu7;
import com.repackage.hw7;
import com.repackage.i08;
import com.repackage.i45;
import com.repackage.j55;
import com.repackage.ji5;
import com.repackage.k05;
import com.repackage.k45;
import com.repackage.ku7;
import com.repackage.l05;
import com.repackage.lo4;
import com.repackage.m45;
import com.repackage.nu4;
import com.repackage.nx7;
import com.repackage.ny7;
import com.repackage.o45;
import com.repackage.o95;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.oz7;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.qo6;
import com.repackage.qx7;
import com.repackage.r25;
import com.repackage.rg;
import com.repackage.rn4;
import com.repackage.ry7;
import com.repackage.s25;
import com.repackage.sk8;
import com.repackage.su7;
import com.repackage.sx7;
import com.repackage.t25;
import com.repackage.t95;
import com.repackage.tx7;
import com.repackage.ty7;
import com.repackage.ur4;
import com.repackage.ur8;
import com.repackage.vr8;
import com.repackage.vt7;
import com.repackage.yf5;
import com.repackage.zm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, su7<NewSubPbActivity>, TbRichTextView.s, ur4.e, ji5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qo6 A;
    public qo6 B;
    public bm4 C;
    public fg<ImageView> D;
    public BdUniqueId E;
    public PbModel.h F;
    public View G;
    public int H;
    public final TbRichTextView.y I;
    public boolean J;
    public hu7 K;
    public final View.OnLongClickListener L;
    public sx7 M;
    public zm N;
    public String O;
    public TbRichTextMemeInfo P;
    public PostData Q;
    public fs4.e R;
    public Object S;
    public final c9 T;
    public i45 U;
    public CustomMessageListener V;
    public NewWriteModel.e W;
    public boolean X;
    public View Y;
    public View Z;
    public PbModel a;
    public View.OnClickListener a0;
    public oz7 b;
    public h45 b0;
    public ev7 c;
    public final bm4.a c0;
    public ry7 d;
    public ty7 e;
    public boolean f;
    public boolean g;
    public ds4 h;
    public fs4 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public nu4 l;
    public sk8 m;
    public ForumManageModel n;
    public vr8 o;
    public m45 p;
    public k45 q;
    public boolean r;
    public qx7 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ny7 v;
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
                        this.a.a.r2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.T1(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
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
    public class b implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || ur4Var == null) {
                return;
            }
            ur4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.b.c.d0();
                MessageManager.getInstance().sendMessage(this.a);
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements i45 {
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

        @Override // com.repackage.i45
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
        public class a implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.Q1() != null) {
                        statisticItem.param("fid", this.a.a.Q1().m());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.i2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    qx7 qx7Var = this.a.s;
                    if (qx7Var != null) {
                        qx7Var.d();
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                        return;
                    }
                    l05.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047b), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    ur4 ur4Var = new ur4(this.a.getActivity());
                    if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        ur4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf3));
                    } else {
                        ur4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new a(this));
                    ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf5, new b(this));
                    ur4Var.create(this.a.getPageContext()).show();
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
                    ku7.a(this.b.a.getPageContext(), this.a).show();
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
                rg.a().postDelayed(new a(this, customDialogData), 1000L);
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
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", this.a.a.i2());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091fe8);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.a.a == null || this.a.a.Q1() == null || postData.s() == null || postData.B() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.y() != null) {
                            this.a.c.y().c();
                        }
                        vt7 vt7Var = new vt7();
                        vt7Var.A(this.a.a.Q1().l());
                        vt7Var.E(this.a.a.Q1().O());
                        vt7Var.C(postData);
                        this.a.c.x().V(vt7Var);
                        this.a.c.x().setPostId(postData.K());
                        this.a.r2(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        i08.b(this.a.a.Q1(), postData, postData.b0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.W(this.a.q.C());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f0917d5 && view2.getId() != R.id.obfuscated_res_0x7f09182d) {
                if (view2.getId() != R.id.obfuscated_res_0x7f091f4a && view2.getId() != R.id.obfuscated_res_0x7f091f48 && view2.getId() != R.id.obfuscated_res_0x7f0917d3 && view2.getId() != R.id.obfuscated_res_0x7f091668) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091833 || view2.getId() == R.id.obfuscated_res_0x7f091a01 || view2.getId() == R.id.obfuscated_res_0x7f0917cd) {
                        if (this.a.a == null) {
                            return;
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091833) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.i2());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091a01) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                this.a.Z = view2;
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091833 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            this.a.Z = view2;
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.obfuscated_res_0x7f092005) instanceof PostData) {
                                PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092005);
                                if (view2.getId() == R.id.obfuscated_res_0x7f091833 && (statisticItem = postData2.c0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a01 || view2.getId() == R.id.obfuscated_res_0x7f0917cd) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.j2()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.K()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.Q1() == null || postData2.s() == null || postData2.B() == 1) {
                                    return;
                                }
                                if (this.a.c.y() != null) {
                                    this.a.c.y().c();
                                }
                                if (this.a.X && postData2.Y() != null && postData2.Y().size() != 0) {
                                    this.a.I2(postData2, true);
                                    return;
                                }
                                vt7 vt7Var2 = new vt7();
                                vt7Var2.A(this.a.a.Q1().l());
                                vt7Var2.E(this.a.a.Q1().O());
                                vt7Var2.C(postData2);
                                this.a.c.x().V(vt7Var2);
                                this.a.c.x().setPostId(postData2.K());
                                this.a.r2(view2, postData2.s().getUserId(), "", postData2);
                                if (this.a.q != null) {
                                    this.a.c.W(this.a.q.C());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if ((view2.getId() == R.id.obfuscated_res_0x7f09076e || view2.getId() == R.id.obfuscated_res_0x7f0909f1) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.obfuscated_res_0x7f092005) instanceof PostData)) {
                        PostData postData3 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092005);
                        View view3 = (View) sparseArray.get(R.id.obfuscated_res_0x7f092007);
                        if (postData3 == null || view3 == null) {
                            return;
                        }
                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09076f);
                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090770);
                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f0909f1);
                        if (postData3.p0()) {
                            postData3.P0(false);
                        } else {
                            postData3.P0(true);
                        }
                        SkinManager.setBackgroundColor(findViewById, postData3.p0() ? R.color.CAM_X0201 : R.color.transparent);
                        SkinManager.setViewTextColor(eMTextView, postData3.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                        WebPManager.setPureDrawable(imageView, postData3.p0() ? R.drawable.obfuscated_res_0x7f080964 : R.drawable.obfuscated_res_0x7f080963, postData3.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                        return;
                    } else {
                        return;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091668) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.i2());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0917d3 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    this.a.Y = view2;
                } else if (this.a.checkUpIsLogin()) {
                    if (this.a.a == null || this.a.a.Q1() == null) {
                        return;
                    }
                    this.a.c.u();
                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                    PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092005);
                    PostData postData5 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092006);
                    View view4 = (View) sparseArray3.get(R.id.obfuscated_res_0x7f092007);
                    if (postData4 == null || view4 == null) {
                        return;
                    }
                    if (postData4.F() == 1) {
                        TiebaStatic.log(new StatisticItem("c12630"));
                    }
                    StatisticItem statisticItem5 = postData4.c0;
                    if (statisticItem5 != null) {
                        StatisticItem copy2 = statisticItem5.copy();
                        copy2.delete("obj_locate");
                        if (view2.getId() == R.id.obfuscated_res_0x7f091668) {
                            copy2.param("obj_locate", 6);
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d3) {
                            copy2.param("obj_locate", 8);
                        }
                        TiebaStatic.log(copy2);
                    }
                    if (view2.getId() == R.id.obfuscated_res_0x7f0917d3 && this.a.a != null && this.a.a.Q1() != null && postData4 != null) {
                        TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.i2()).param("fname", this.a.a.Q1().n()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.K()));
                    }
                    String i2 = this.a.a.i2();
                    String K = postData4.K();
                    String K2 = postData5 != null ? postData5.K() : "";
                    int W = this.a.a.Q1() != null ? this.a.a.Q1().W() : 0;
                    this.a.J2();
                    if (view2.getId() == R.id.obfuscated_res_0x7f091bb7) {
                        AbsPbActivity.e y2 = this.a.y2(K);
                        if (this.a.a == null || this.a.a.Q1() == null || y2 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(i2, K, "pb", true, this.a.r, null, true, null, W, postData4.b0(), this.a.a.Q1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(y2.a, y2.b, y2.g, y2.j);
                        addBigImageData.setKeyPageStartFrom(this.a.a.P1());
                        addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData.setWorksInfoData(this.a.a.n2());
                        addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData.setBjhData(this.a.a.i1());
                        addBigImageData.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                        addBigImageData.setFromFoldComment(true);
                        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d3 && this.a.r) {
                        AbsPbActivity.e y22 = this.a.y2(K);
                        if (this.a.a == null || this.a.a.Q1() == null || y22 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(i2, K, "pb", true, this.a.r, null, true, null, W, postData4.b0(), this.a.a.Q1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(y22.a, y22.b, y22.g, y22.j);
                        addBigImageData2.setKeyPageStartFrom(this.a.a.P1());
                        addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData2.setWorksInfoData(this.a.a.n2());
                        addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData2.setBjhData(this.a.a.i1());
                        addBigImageData2.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                        addBigImageData2.setFromFoldComment(true);
                        addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                    } else {
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e y23 = this.a.y2(K);
                        if (postData4 == null || this.a.a == null || this.a.a.Q1() == null || y23 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(i2, K, "pb", true, this.a.r, null, false, K2, W, postData4.b0(), this.a.a.Q1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(y23.a, y23.b, y23.g, y23.j);
                        if (!pi.isEmpty(K2)) {
                            addBigImageData3.setHighLightPostId(K2);
                            addBigImageData3.setKeyIsUseSpid(true);
                        }
                        addBigImageData3.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData3.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                        addBigImageData3.setBjhData(this.a.a.i1());
                        addBigImageData3.setKeyPageStartFrom(this.a.a.P1());
                        addBigImageData3.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.a.a.n2());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.a.Q1().m()));
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.i2());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.Q1() != null && this.a.Q != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.i2()).param("fname", this.a.a.Q1().n()).param("fid", this.a.a.Q1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.Q.K()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.P1(view2);
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
        public void b(ft7 ft7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ft7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ft7 ft7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ft7Var, str, Integer.valueOf(i4)}) == null) || this.a.c == null) {
                return;
            }
            this.a.c.U();
            if (!z) {
                this.a.v2(i, str);
                return;
            }
            this.a.c.E();
            if (ft7Var != null) {
                if (ft7Var.s() == 1) {
                    this.a.f = true;
                } else {
                    this.a.f = false;
                }
                String str2 = null;
                if (this.a.a == null || !this.a.a.w2()) {
                    if (this.a.c != null) {
                        str2 = this.a.c.z();
                    }
                } else {
                    str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dec);
                }
                if (!StringUtils.isNull(str2)) {
                    this.a.q.m0(TbSingleton.getInstance().getAdVertiComment(ft7Var.n0(), ft7Var.o0(), str2));
                }
                this.a.c.S(ft7Var, this.a.f);
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
                qx7 qx7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qx7Var = this.a.c.s) == null || qx7Var.g() == null) {
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
                int i2 = qi.i(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = qi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = qi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.y[1] + foldCommentActivity.z) - i3, 50);
                if (this.c.c.y() != null) {
                    this.c.q.a().setVisibility(8);
                    this.c.c.y().o(this.a, this.b, this.c.c.z(), (this.c.a == null || this.c.a.Q1() == null || this.c.a.Q1().O() == null || !this.c.a.Q1().O().isBjh()) ? false : false);
                    o45 b = this.c.c.y().b();
                    if (b != null && this.c.a != null && this.c.a.Q1() != null) {
                        b.G(this.c.a.Q1().d());
                        b.c0(this.c.a.Q1().O());
                    }
                    if (this.c.s.f() == null && this.c.c.y().b().t() != null) {
                        this.c.c.y().b().t().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().t().i());
                        this.c.c.y().b().M(this.c.b0);
                    }
                }
                this.c.c.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements qo6.d {
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
            public class C0245a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0245a(a aVar) {
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
                    qx7 qx7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qx7Var = this.a.a.c.s) == null || qx7Var.g() == null) {
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
                    int i2 = qi.i(this.a.c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    FoldCommentActivity foldCommentActivity = this.a.c;
                    boolean z = true;
                    foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.y[1] + foldCommentActivity.z) - i3, 50);
                    if (this.a.c.c.y() != null) {
                        this.a.c.q.a().setVisibility(8);
                        z = (this.a.c.a == null || this.a.c.a.Q1() == null || this.a.c.a.Q1().O() == null || !this.a.c.a.Q1().O().isBjh()) ? false : false;
                        hw7 y = this.a.c.c.y();
                        m mVar = this.a;
                        y.o(mVar.a, mVar.b, mVar.c.c.z(), z);
                        o45 b = this.a.c.c.y().b();
                        if (b != null && this.a.c.a != null && this.a.c.a.Q1() != null) {
                            b.G(this.a.c.a.Q1().d());
                            b.c0(this.a.c.a.Q1().O());
                        }
                        if (this.a.c.s.f() == null && this.a.c.c.y().b().t() != null) {
                            this.a.c.c.y().b().t().g(new C0245a(this));
                            FoldCommentActivity foldCommentActivity2 = this.a.c;
                            foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().t().i());
                            this.a.c.c.y().b().M(this.a.c.b0);
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

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                rg.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements h45 {
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

        @Override // com.repackage.h45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qx7 qx7Var = this.a.s;
                if (qx7Var == null || qx7Var.g() == null || !this.a.s.g().d()) {
                    return !this.a.M1(ReplyPrivacyCheckController.TYPE_FLOOR);
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
    public class o implements qo6.d {
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

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.q != null && this.a.q.a() != null) {
                    this.a.q.a().A(new h25(45, 27, null));
                }
                this.a.c.t();
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements bm4.a {
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

        @Override // com.repackage.bm4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.C != null) {
                        this.a.C.h(z2);
                    }
                    this.a.a.D3(z2);
                    if (this.a.a.B1()) {
                        this.a.s2();
                    }
                    if (z2) {
                        if (this.a.C != null) {
                            if (this.a.C.f() == null || this.a.a == null || this.a.a.Q1() == null || this.a.a.Q1().O() == null || this.a.a.Q1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.C.f();
                            MetaData author = this.a.a.Q1().O().getAuthor();
                            if (f != null && author != null) {
                                if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                    if (g05.g(this.a.getActivity(), 0)) {
                                        g05.i(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                        this.a.H1();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd1));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14c0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements gg<ImageView> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
                    if (rn4.c().g()) {
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
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = rn4.c().g();
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
                    if (view2.getTag(R.id.obfuscated_res_0x7f092024) == null || !(view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        if (this.a.a.Q1().i0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view2.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view2.getParent();
                            } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                            }
                            int i2 = -1;
                            if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().D() != null) {
                                ArrayList<TbRichTextImageInfo> D = tbRichTextView.getRichText().D();
                                int i3 = -1;
                                for (int i4 = 0; i4 < D.size(); i4++) {
                                    if (D.get(i4) != null) {
                                        arrayList.add(D.get(i4).F());
                                        if (i3 == -1 && str != null && (str.equals(D.get(i4).F()) || str.equals(D.get(i4).B()) || str.equals(D.get(i4).z()) || str.equals(D.get(i4).A()) || str.equals(D.get(i4).D()))) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = D.get(i4).F();
                                        imageUrlData.originalUrl = D.get(i4).F();
                                        imageUrlData.isLongPic = D.get(i4).I();
                                        concurrentHashMap.put(D.get(i4).F(), imageUrlData);
                                    }
                                }
                                i2 = i3;
                            }
                            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                            builder.y(arrayList);
                            builder.C(i2);
                            builder.D(false);
                            builder.G(this.a.a.b2());
                            builder.x(concurrentHashMap);
                            builder.I(true);
                            builder.L(false);
                            builder.H(this.a.m2());
                            if (this.a.a != null) {
                                builder.B(this.a.a.getFromForumId());
                                if (this.a.a.Q1() != null) {
                                    builder.O(this.a.a.Q1().O());
                                }
                            }
                            ImageViewerConfig w = builder.w(this.a.getPageContext().getPageActivity());
                            w.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, w));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.w2(str, i, eVar);
                        if (eVar.h) {
                            TbRichText N2 = this.a.N2(str, i);
                            if (N2 != null && this.a.H >= 0 && this.a.H < N2.B().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = gt7.a(N2.B().get(this.a.H));
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
                                builder2.G(this.a.a.b2());
                                builder2.x(concurrentHashMap2);
                                builder2.L(false);
                                builder2.H(this.a.m2());
                                builder2.M(eVar.f);
                                if (this.a.a != null) {
                                    builder2.B(this.a.a.getFromForumId());
                                    if (this.a.a.Q1() != null) {
                                        builder2.O(this.a.a.Q1().O());
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
                        builder3.G(this.a.a.b2());
                        builder3.x(concurrentHashMap3);
                        builder3.L(false);
                        builder3.H(this.a.m2());
                        builder3.M(eVar.f);
                        builder3.E(false);
                        if (this.a.a != null) {
                            builder3.B(this.a.a.getFromForumId());
                            if (this.a.a.Q1() != null) {
                                builder3.O(this.a.a.Q1().O());
                            }
                        }
                        ImageViewerConfig w3 = builder3.w(this.a.getPageContext().getPageActivity());
                        w3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, w3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
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
                    foldCommentActivity.B2(foldCommentActivity.w);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!oi.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.Q1().l().getId(), this.a.a.Q1().l().getName(), this.a.a.Q1().O().getId(), String.valueOf(this.a.a.Q1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements hu7.a {
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

        @Override // com.repackage.hu7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091bd2) {
                        if (this.a.A2(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d2) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f091ffb) instanceof SparseArray) {
                            this.a.H2((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091ffb));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f09182c) {
                        SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.H2(sparseArray);
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

        @Override // com.repackage.hu7.a
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.P1(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class w implements fs4.e {
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

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.L2(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b7);
                        this.a.z2(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b6);
                        this.a.z2(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.z2(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                        if (view6 != null) {
                            this.a.z2(view6);
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
                            j55.a aVar = new j55.a();
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
                            foldCommentActivity.M = new sx7(foldCommentActivity.getPageContext());
                        }
                        this.a.M.b(this.a.O, this.a.N.n());
                        this.a.N = null;
                        this.a.O = null;
                        return;
                    case 3:
                        PostData postData = this.a.Q;
                        if (postData != null) {
                            postData.B0();
                            this.a.Q = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.t2(view2);
                            if (this.a.a.Q1().O() == null || this.a.a.Q1().O().getAuthor() == null || this.a.a.Q1().O().getAuthor().getUserId() == null || this.a.C == null) {
                                return;
                            }
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int f2 = foldCommentActivity2.f2(foldCommentActivity2.a.Q1());
                            ThreadData O = this.a.a.Q1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.i2()).param("obj_locate", 2).param("obj_id", this.a.a.Q1().O().getAuthor().getUserId()).param("obj_type", !this.a.C.e()).param("obj_source", f2).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!oi.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.i2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091ffb, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091fe4, 2);
                                this.a.K1(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091fec) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091fea) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f092008) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f091ffc) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091feb)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092008)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091ffc)).booleanValue();
                            boolean E = this.a.E(TbadkCoreApplication.getCurrentAccount());
                            if (E) {
                                if (!booleanValue2) {
                                    this.a.F2(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.c.N(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue, null, E);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.F2(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.c.L(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!oi.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092030)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09202e)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092044)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.c.L(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091ffb, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091fe4, 2);
                            this.a.K1(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091fe4, 2);
                            this.a.c.P(view2);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.a.N1(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.a == null || this.a.a.Q1() == null) {
                            return;
                        }
                        this.a.E2(ur8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (ur4Var != null) {
                    ur4Var.dismiss();
                }
                this.d.S1(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fea), this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
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
        this.K = new hu7(new u(this));
        this.L = new v(this);
        this.Q = null;
        this.R = new w(this);
        this.T = new a(this);
        this.U = new e(this);
        this.V = new f(this, 2004008);
        this.W = new g(this);
        this.X = UbsABTestHelper.showTrisectionAndFeedback();
        this.a0 = new j(this);
        this.b0 = new n(this);
        this.c0 = new p(this);
    }

    public final boolean A2(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091fe8);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.Q1() != null) {
                        if (this.c.y() != null) {
                            this.c.y().c();
                        }
                        vt7 vt7Var = new vt7();
                        vt7Var.A(this.a.Q1().l());
                        vt7Var.E(this.a.Q1().O());
                        vt7Var.C(postData);
                        TiebaStatic.log("c11743");
                        this.c.x().V(vt7Var);
                        this.c.x().setPostId(postData.K());
                        r2(view2, postData.s().getUserId(), "", postData);
                        k45 k45Var = this.q;
                        if (k45Var != null) {
                            this.c.W(k45Var.C());
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

    public final void B2(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.v == null) {
            ny7 ny7Var = new ny7(this);
            this.v = ny7Var;
            ny7Var.n(this.U);
        }
        ny7 ny7Var2 = this.v;
        PbModel pbModel = this.a;
        ny7Var2.k(emotionImageData, pbModel, pbModel.Q1());
    }

    @Override // com.repackage.ji5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void C2(m45 m45Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, m45Var) == null) || m45Var == null || (pbModel = this.a) == null) {
            return;
        }
        m45Var.p(pbModel.p1());
        if (this.a.Q1() != null && this.a.Q1().l() != null) {
            m45Var.o(this.a.Q1().l());
        }
        m45Var.q("pb");
        m45Var.r(this.a);
    }

    public final void D2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.q.g0(z);
            this.q.k0(z);
            this.q.s0(z);
        }
    }

    @Override // com.repackage.su7
    public boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PbModel pbModel = this.a;
            return pbModel != null && pbModel.G2(str);
        }
        return invokeL.booleanValue;
    }

    public void E2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str == null || this.o == null) {
            return;
        }
        this.o.n(og.g(str, 0L));
    }

    @Override // com.repackage.ji5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) {
        }
    }

    public final void F2(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            fz7.e(getActivity(), getPageContext(), new x(this, sparseArray, i2, z), new y(this));
        }
    }

    public final void G2(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            ur4 ur4Var = new ur4(this);
            if (pi.isEmpty(str)) {
                ur4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f031e, str3));
            } else {
                ur4Var.setMessage(str);
            }
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new c(this, userMuteAddAndDelCustomMessage));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new d(this));
            ur4Var.create(getPageContext()).show();
        }
    }

    @Override // com.repackage.ji5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
        }
    }

    public final void H1() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (pbModel = this.a) == null || pbModel.Q1() == null || this.a.Q1().O() == null) {
            return;
        }
        ThreadData O = this.a.Q1().O();
        O.mRecomAbTag = this.a.V1();
        O.mRecomWeight = this.a.Y1();
        O.mRecomSource = this.a.X1();
        O.mRecomExtra = this.a.W1();
        O.isSubPb = this.a.D1();
        if (O.getFid() == 0) {
            O.setFid(og.g(this.a.getForumId(), 0L));
        }
        StatisticItem i2 = t95.i(this, O, "c13562");
        TbPageTag l2 = t95.l(this);
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

    public final void H2(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091fe8) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) != null) {
            I2(postData, false);
        }
    }

    public final void I1(ft7 ft7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, ft7Var, arrayList) == null) || ft7Var == null || ft7Var.T() == null || ft7Var.T().a == null || (list = ft7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.K()) && !TextUtils.isEmpty(postData.K()) && next.K().equals(postData.K())) {
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

    public final void I2(PostData postData, boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, postData, z) == null) || postData == null || (pbModel = this.a) == null || pbModel.Q1() == null || postData.B() == 1) {
            return;
        }
        String i2 = this.a.i2();
        String K = postData.K();
        int W = this.a.Q1() != null ? this.a.Q1().W() : 0;
        AbsPbActivity.e y2 = y2(K);
        if (y2 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this).createSubPbActivityConfig(i2, K, "pb", true, this.r, null, false, null, W, postData.b0(), this.a.Q1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(y2.a, y2.b, y2.g, y2.j);
        addBigImageData.setKeyPageStartFrom(this.a.P1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.n2());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.i1());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.Q1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.a.Q1().O()) || AntiHelper.d(getPageContext(), this.a.Q1().d());
        }
        return invokeV.booleanValue;
    }

    public final void J2() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (voiceManager = this.t) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void K1(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = og.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = og.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092040), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.S = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void K2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.E);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.repackage.ji5
    public fg<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if ((this.a.Q1() != null && (this.a.Q1().i0() || ThreadCardUtils.isSelf(this.a.Q1().O()))) || this.u == null || this.a.Q1() == null || this.a.Q1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.Q1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void L2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.i2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fz7.m(i2))));
        }
    }

    public boolean M1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (this.u == null || this.a.Q1() == null || ThreadCardUtils.isSelf(this.a.Q1().O()) || this.a.Q1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeSend(this.a.Q1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.a.getForumId()) && this.a.Q1() != null && this.a.Q1().l() != null) {
            if (this.a.Q1().l().isLike() == 1) {
                this.a.d1().D(this.a.getForumId(), this.a.i2());
            }
        }
    }

    @Override // com.repackage.ji5
    public fg<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.D == null) {
                this.D = new fg<>(new q(this), 8, 0);
            }
            return this.D;
        }
        return (fg) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N1(AgreeData agreeData) {
        o95 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new nu4();
        }
        if (this.m == null) {
            sk8 sk8Var = new sk8();
            this.m = sk8Var;
            sk8Var.a = getUniqueId();
        }
        lo4 lo4Var = new lo4();
        lo4Var.b = 5;
        lo4Var.h = 8;
        lo4Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            lo4Var.f = pbModel2.P1();
        }
        lo4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                lo4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel != null || pbModel.Q1() == null) {
                }
                this.l.b(this, lo4Var, agreeData, this.a.Q1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            lo4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            lo4Var.i = 1;
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

    public final TbRichText N2(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.Q1() == null || str == null || i2 < 0) {
                return null;
            }
            ft7 Q1 = this.a.Q1();
            if (Q1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(Q1.j());
                tbRichText = W1(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = Q1.F();
                I1(Q1, F);
                return W1(F, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.repackage.ji5
    public fg<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.a.v1() || this.a.y1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.i2());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.i2()));
            finish();
        }
    }

    public final boolean P1(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        bm4 bm4Var;
        boolean z;
        boolean z2;
        List<bs4> c2;
        bs4 bs4Var;
        bs4 bs4Var2;
        bs4 bs4Var3;
        zm zmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
            this.Q = postData;
            if (postData == null || (bm4Var = this.C) == null) {
                return true;
            }
            if (bm4Var.e() && this.Q.K() != null) {
                this.Q.K().equals(this.a.L1());
            }
            if (this.i == null) {
                fs4 fs4Var = new fs4(this);
                this.i = fs4Var;
                fs4Var.n(this.R);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean n2 = n2(view2);
            boolean z3 = (!n2(view2) || (zmVar = this.N) == null || zmVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092001) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092001)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ff8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ff8) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f092009) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092009)).booleanValue() : false;
            if (n2) {
                z = booleanValue;
                z2 = booleanValue8;
                arrayList.add(new bs4(1, getString(R.string.obfuscated_res_0x7f0f108d), this.i));
            } else {
                z = booleanValue;
                z2 = booleanValue8;
            }
            if (z3) {
                arrayList.add(new bs4(2, getString(R.string.obfuscated_res_0x7f0f108e), this.i));
            }
            if (!n2 && !z3) {
                bs4 bs4Var4 = new bs4(3, getString(R.string.obfuscated_res_0x7f0f044d), this.i);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fe8, this.Q);
                bs4Var4.d.setTag(sparseArray2);
                arrayList.add(bs4Var4);
            }
            if (this.mIsLogin) {
                if (!fz7.i(this.a) && !booleanValue4 && booleanValue3) {
                    bs4 bs4Var5 = new bs4(5, getString(R.string.obfuscated_res_0x7f0f0b33), this.i);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    bs4Var5.d.setTag(sparseArray3);
                    arrayList.add(bs4Var5);
                } else {
                    if (o2(booleanValue2) && TbadkCoreApplication.isLogin()) {
                        bs4 bs4Var6 = new bs4(5, getString(R.string.obfuscated_res_0x7f0f0ff6), this.i);
                        bs4Var6.d.setTag(str);
                        arrayList.add(bs4Var6);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff5, sparseArray.get(R.id.obfuscated_res_0x7f091ff5));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff6, sparseArray.get(R.id.obfuscated_res_0x7f091ff6));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, str);
                    if (!fz7.i(this.a) && booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    }
                    if (booleanValue6) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                        if (booleanValue7) {
                            bs4Var = new bs4(6, getString(R.string.obfuscated_res_0x7f0f04ab), this.i);
                            bs4Var.d.setTag(sparseArray4);
                            bs4Var2 = new bs4(7, getString(R.string.obfuscated_res_0x7f0f02e3), this.i);
                            bs4Var2.d.setTag(sparseArray4);
                        }
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                    }
                    bs4Var = null;
                    bs4Var2 = new bs4(7, getString(R.string.obfuscated_res_0x7f0f02e3), this.i);
                    bs4Var2.d.setTag(sparseArray4);
                } else {
                    if (booleanValue6) {
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                        if (this.a.Q1().W() == 1002 && !booleanValue2) {
                            bs4Var3 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f0ff6), this.i);
                        } else {
                            bs4Var3 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f04ab), this.i);
                        }
                        bs4Var3.d.setTag(sparseArray5);
                        if (z2) {
                            new bs4(13, getString(R.string.obfuscated_res_0x7f0f0b23), this.i);
                        }
                        bs4Var = bs4Var3;
                    } else {
                        bs4Var = null;
                    }
                    bs4Var2 = null;
                }
                if (bs4Var != null) {
                    arrayList.add(bs4Var);
                }
                if (bs4Var2 != null) {
                    arrayList.add(bs4Var2);
                }
                fz7.b(arrayList, this.i, this.Q, this.a);
            }
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = fz7.d(arrayList, this.Q.q(), sparseArray, this.i);
            } else {
                c2 = fz7.c(arrayList, this.Q.q(), sparseArray, this.i);
            }
            fz7.l(c2, this.g);
            fz7.f(c2);
            this.i.o(fz7.g(this.Q));
            if (UbsABTestHelper.isPBPlanA()) {
                this.i.k(c2, false);
            } else {
                this.i.k(c2, true);
            }
            ds4 ds4Var = new ds4(getPageContext(), this.i);
            this.h = ds4Var;
            ds4Var.k();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.i2()).param("fid", this.a.getForumId()).param("uid", this.a.Q1().O().getAuthor().getUserId()).param("post_id", this.a.B()).param("obj_source", z ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ji5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
        }
    }

    public void Q1(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(nx7.k2)).intValue();
            if (intValue == nx7.l2) {
                if (this.n.S()) {
                    return;
                }
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ffe) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ffe)).booleanValue() : false;
                if (jSONArray != null) {
                    this.n.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.V(this.a.Q1().l().getId(), this.a.Q1().l().getName(), this.a.Q1().O().getId(), str, intValue3, intValue2, booleanValue, this.a.Q1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == nx7.m2 || intValue == nx7.o2) {
                if (this.a.l1() != null) {
                    this.a.l1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == nx7.m2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    @Override // com.repackage.ji5
    public void R(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048608, this, context, str, z) == null) {
        }
    }

    public void R1(ur4 ur4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, ur4Var, jSONArray) == null) {
            ur4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (ur4Var.getYesButtonTag() instanceof SparseArray) {
                    Q1((SparseArray) ur4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public void S1(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z));
            sparseArray.put(nx7.k2, Integer.valueOf(nx7.l2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                Q1(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // com.repackage.su7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.Q1() == null) {
                return 0;
            }
            return this.a.Q1().W();
        }
        return invokeV.intValue;
    }

    public final void T1(ForumManageModel.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048612, this, bVar, z) == null) || bVar == null) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04b0);
        int i2 = 0;
        if (bVar.c == 1211066) {
            hideProgressBar();
            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
            ur4Var.setMessage(string);
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ec, new b(this));
            ur4Var.setCancelable(true);
            ur4Var.create(getPageContext());
            ur4Var.show();
        } else if (bVar.d != 0) {
            this.c.v(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<PostData> F = this.a.Q1().F();
                int size = F.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.g.equals(F.get(i2).K())) {
                        F.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.a.Q1().O().setReply_num(this.a.Q1().O().getReply_num() - 1);
            } else if (i3 == 0) {
                O1();
            } else if (i3 == 2) {
                ArrayList<PostData> F2 = this.a.Q1().F();
                int size2 = F2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= F2.get(i4).Y().size()) {
                            break;
                        } else if (bVar.g.equals(F2.get(i4).Y().get(i5).K())) {
                            F2.get(i4).Y().remove(i5);
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

    public AntiData U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.Q1() == null) {
                return null;
            }
            return this.a.Q1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.repackage.ji5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, context, str, str2) == null) {
        }
    }

    public PostData V1() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.Q1() == null || this.a.Q1().O() == null || this.a.Q1().O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = this.a.Q1().O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = this.a.Q1().O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.C0(1);
            postData.I0(this.a.Q1().O().getFirstPostId());
            postData.Z0(this.a.Q1().O().getTitle());
            postData.Y0(this.a.Q1().O().getCreateTime());
            postData.A0(author);
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    public final TbRichText W1(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText V = arrayList.get(i3).V();
                    if (V != null && (B = V.B()) != null) {
                        int size = B.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (B.get(i5) != null && B.get(i5).getType() == 8) {
                                i4++;
                                if (B.get(i5).F().B().equals(str) || B.get(i5).F().C().equals(str)) {
                                    int h2 = (int) qi.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i5).F().getWidth() * h2;
                                    int height = B.get(i5).F().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.H = i5;
                                    return V;
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

    @Override // com.repackage.su7
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.p1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final int X1(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.J = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i4 = i2;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int h2 = (int) qi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h2;
                        int height = tbRichTextData.F().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.F().H()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = gt7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                    String B = F.B();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        B = F.C();
                                    } else {
                                        imageUrlData.urlType = this.f ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = B;
                                    imageUrlData.originalUrl = b2(tbRichTextData);
                                    imageUrlData.originalSize = c2(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = Z1(tbRichTextData);
                                    imageUrlData.isLongPic = Y1(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = og.g(this.a.i2(), -1L);
                                    imageUrlData.mIsReserver = this.a.b2();
                                    imageUrlData.mIsSeeHost = this.a.t1();
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

    @Override // com.repackage.ji5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, context, str) == null) {
        }
    }

    @Override // com.repackage.ji5
    public fg<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    public final boolean Y1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final boolean Z1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public PbModel a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    public final String b2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public final long c2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    public k45 d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.q : (k45) invokeV.objValue;
    }

    @Override // com.repackage.ji5
    public fg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public ty7 e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.e : (ty7) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public final int f2(ft7 ft7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, ft7Var)) == null) {
            if (ft7Var == null || ft7Var.O() == null) {
                return 0;
            }
            if (ft7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (ft7Var.O().getThreadType() == 54) {
                return 2;
            }
            return ft7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.ji5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, context, str) == null) {
        }
    }

    public final void g2(int i2, Intent intent) {
        t25 t25Var;
        t25 t25Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048634, this, i2, intent) == null) {
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
                    o45 b2 = this.c.y().b();
                    b2.c0(this.a.Q1().O());
                    b2.B(writeData);
                    b2.d0(pbEditorData.getVoiceModel());
                    s25 n2 = b2.a().n(6);
                    if (n2 != null && (t25Var2 = n2.m) != null) {
                        t25Var2.A(new h25(52, 0, pbEditorData.getVoiceModel()));
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
                s25 n3 = this.q.a().n(6);
                if (n3 != null && (t25Var = n3.m) != null) {
                    t25Var.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.q.M(null, null);
                }
            }
        }
    }

    @Override // com.repackage.ji5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public void h2(boolean z, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092041) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092041) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092043) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092043) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092042) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092042) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.k);
            userMuteAddAndDelCustomMessage.setTag(this.k);
            G2(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void i2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.Q1() != null && this.a.Q1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.i2(), str);
                ThreadData O = this.a.Q1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                p2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final void j2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            this.k = getUniqueId();
            bm4 c2 = bm4.c(this);
            this.C = c2;
            if (c2 != null) {
                c2.j(this.c0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.n = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.T);
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.F);
            } else {
                this.a = new PbModel(this, getIntent(), this.F);
            }
            this.a.y3(true);
            this.a.A3(4);
        }
    }

    public final boolean k2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    public final void l2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            this.d = new ry7(this);
            this.e = new ty7(getPageContext());
            ev7 ev7Var = new ev7(this, this.a0, this.I, this.K, this.L);
            this.c = ev7Var;
            ev7Var.Y(this.a);
            setContentView(this.c.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.s();
            this.c.V(new t(this));
            m45 m45Var = new m45();
            this.p = m45Var;
            C2(m45Var);
            k45 k45Var = (k45) this.p.a(getActivity());
            this.q = k45Var;
            k45Var.f0(getPageContext());
            this.q.q0(this.U);
            this.q.i0(1);
            this.q.F(getPageContext(), bundle);
            this.q.a().b(new r25(getActivity()));
            this.q.a().C(true);
            D2(true);
            this.q.P(this.a.s1(), this.a.i2(), this.a.o1());
            this.c.T(this.q.a());
            this.s = new qx7();
            if (this.q.v() != null) {
                this.s.m(this.q.v().i());
            }
            registerListener(this.V);
            if (!this.a.D1()) {
                this.q.s(this.a.i2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.w2()) {
                this.q.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dec));
            } else {
                ev7 ev7Var2 = this.c;
                if (ev7Var2 != null) {
                    this.q.m0(ev7Var2.z());
                }
            }
            this.x = new ShareSuccessReplyToServerModel();
        }
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.t1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean o2(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.Q1() != null) {
                return ((this.a.Q1().W() != 0) || this.a.Q1().O() == null || this.a.Q1().O().getAuthor() == null || TextUtils.equals(this.a.Q1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048644, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.H(i2, i3, intent);
            ny7 ny7Var = this.v;
            if (ny7Var != null) {
                ny7Var.i(i2, i3, intent);
            }
            if (this.c.y() != null) {
                this.c.y().g(i2, i3, intent);
            }
            if (i2 == 25035) {
                g2(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 13008) {
                    cx7.b().m();
                    this.mHandler.postDelayed(new h(this), 1000L);
                } else if (i2 == 13011) {
                    cb8.g().m(getPageContext());
                } else if (i2 != 24007) {
                } else {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        cb8.g().m(getPageContext());
                        M2();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.x;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.w) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.z(str, intExtra, new i(this));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
        }
    }

    @Override // com.repackage.ur4.e
    public void onClick(ur4 ur4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, ur4Var) == null) {
            R1(ur4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, bundle) == null) {
            k2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            j2(bundle);
            l2(bundle);
            q2();
            if (this.r) {
                this.c.A().setAnimTime(0);
                this.c.A().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.E = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.A().h();
            this.c.x().setFromForumId(this.a.getFromForumId());
            oz7 oz7Var = new oz7(this);
            this.b = oz7Var;
            oz7Var.b(getUniqueId());
            this.o = new vr8(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.m0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.m0(this.c.z());
            }
            k05.b(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            super.onPause();
            if (this.r) {
                K2(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            super.onResume();
            if (this.r) {
                K2(true);
            }
        }
    }

    public final void p2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void q0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048652, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (gi5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), gi5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (tx7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new yf5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void q2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (pbModel = this.a) == null) {
            return;
        }
        pbModel.P2();
    }

    public final void r2(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048654, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || !L1()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.y);
            this.z = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.y() != null && postData != null) {
            this.c.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fec), postData.s().getName_show(), postData.V() != null ? postData.V().toString() : ""));
        }
        if (this.a.Q1() != null && this.a.Q1().i0()) {
            rg.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.B == null) {
            qo6 qo6Var = new qo6(getPageContext());
            this.B = qo6Var;
            qo6Var.j(1);
            this.B.i(new m(this, str, str2));
        }
        PbModel pbModel = this.a;
        if (pbModel == null || pbModel.Q1() == null || this.a.Q1().l() == null) {
            return;
        }
        this.B.g(this.a.Q1().l().getId(), og.g(this.a.i2(), 0L));
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            ft7 Q1 = this.a.Q1();
            this.a.D3(true);
            bm4 bm4Var = this.C;
            if (bm4Var != null) {
                Q1.H0(bm4Var.g());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.t : (VoiceManager) invokeV.objValue;
    }

    public final void t2(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) == null) {
                return;
            }
            u2(postData);
        }
    }

    @Override // com.repackage.su7
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.F2();
        }
        return invokeV.booleanValue;
    }

    public void u2(PostData postData) {
        bm4 bm4Var;
        PostData V1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, postData) == null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.K() != null && postData.K().equals(this.a.L1())) {
            z = true;
        }
        MarkData K1 = this.a.K1(postData);
        if (this.a.Q1() != null && this.a.Q1().i0() && (V1 = V1()) != null) {
            K1 = this.a.K1(V1);
        }
        if (K1 == null || (bm4Var = this.C) == null) {
            return;
        }
        bm4Var.i(K1);
        if (!z) {
            this.C.a();
        } else {
            this.C.d();
        }
    }

    @Override // com.repackage.ji5
    public fg<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    public final void v2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048661, this, i2, str) == null) {
            if (this.a.p2()) {
                showToast(str);
            } else if (!qi.D()) {
                this.c.f0(R.string.obfuscated_res_0x7f0f0fac);
            } else if (i2 == 4) {
                ev7 ev7Var = this.c;
                ev7Var.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                ev7 ev7Var2 = this.c;
                ev7Var2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.c.f0(R.string.obfuscated_res_0x7f0f0c56);
            }
        }
    }

    public final void w2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048662, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        ft7 Q1 = this.a.Q1();
        TbRichText N2 = N2(str, i2);
        if (N2 == null || (tbRichTextData = N2.B().get(this.H)) == null) {
            return;
        }
        eVar.f = String.valueOf(N2.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a2 = gt7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.f ? 17 : 18;
            }
            imageUrlData.originalUrl = b2(tbRichTextData);
            imageUrlData.originalUrl = b2(tbRichTextData);
            imageUrlData.originalSize = c2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = Z1(tbRichTextData);
            imageUrlData.isLongPic = Y1(tbRichTextData);
            imageUrlData.postId = N2.getPostId();
            imageUrlData.mIsReserver = this.a.b2();
            imageUrlData.mIsSeeHost = this.a.t1();
            eVar.b.put(a2, imageUrlData);
            if (Q1 != null) {
                if (Q1.l() != null) {
                    eVar.c = Q1.l().getName();
                    eVar.d = Q1.l().getId();
                }
                if (Q1.O() != null) {
                    eVar.e = Q1.O().getId();
                }
                eVar.g = Q1.s() == 1;
            }
            imageUrlData.threadId = og.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = Q1.F().size();
        this.J = false;
        eVar.j = -1;
        int X1 = Q1.j() != null ? X1(Q1.j().V(), N2, i2, i2, eVar.a, eVar.b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = Q1.F().get(i3);
            if (postData.K() == null || Q1.j() == null || Q1.j().K() == null || !postData.K().equals(Q1.j().K())) {
                X1 = X1(postData.V(), N2, X1, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (Q1 != null) {
            if (Q1.l() != null) {
                eVar.c = Q1.l().getName();
                eVar.d = Q1.l().getId();
            }
            if (Q1.O() != null) {
                eVar.e = Q1.O().getId();
            }
            eVar.g = Q1.s() == 1;
        }
        eVar.j = X1;
    }

    public void x2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.Q1() == null || this.a.Q1().l() == null || J1()) {
            return;
        }
        if (this.a.Q1().i0()) {
            this.c.t();
            return;
        }
        if (this.A == null) {
            qo6 qo6Var = new qo6(getPageContext());
            this.A = qo6Var;
            qo6Var.j(0);
            this.A.i(new o(this));
        }
        this.A.g(this.a.Q1().l().getId(), og.g(this.a.i2(), 0L));
    }

    @Override // com.repackage.ji5
    public fg<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.repackage.ji5
    public fg<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    public final AbsPbActivity.e y2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, str)) == null) {
            String str2 = null;
            if (this.a.Q1() != null && this.a.Q1().F() != null && this.a.Q1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.a.Q1().F().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.a.Q1().F().get(i2).K())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.a.Q1().F().get(i2);
                if (postData.V() != null && postData.V().B() != null) {
                    Iterator<TbRichTextData> it = postData.V().B().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.F() != null) {
                                str2 = next.F().B();
                            }
                        }
                    }
                    w2(str2, 0, eVar);
                    gt7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    @Override // com.repackage.su7
    public ry7 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.d : (ry7) invokeV.objValue;
    }

    public final void z2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048668, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091852, Integer.valueOf(this.g ? 2 : 3));
        view2.setTag(sparseArray);
    }
}
